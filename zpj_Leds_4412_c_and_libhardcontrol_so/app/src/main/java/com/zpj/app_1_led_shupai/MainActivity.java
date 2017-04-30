package com.zpj.app_1_led_shupai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.zpj.hardlibrary.*;

public class MainActivity extends AppCompatActivity {

    private Button button = null;

    private boolean ledon = false;

    private CheckBox LED1 = null;
    private CheckBox LED2 = null;
    private CheckBox LED3 = null;
    private CheckBox LED4 = null;

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            HardControl hardControl = new HardControl();

            ledon = !ledon;
            if (ledon)
            {
                button.setText("ALL OFF");

                LED1.setChecked(true);
                LED2.setChecked(true);
                LED3.setChecked(true);
                LED4.setChecked(true);

                for (int i = 0; i <= 3; i++)
                    HardControl.ledCtrl(i, 1); /* 第0盏灯 点亮 */
            }
            else
            {
                button.setText("ALL ON");

                LED1.setChecked(false);
                LED2.setChecked(false);
                LED3.setChecked(false);
                LED4.setChecked(false);

                for (int i = 0; i <= 3; i++)
                    HardControl.ledCtrl(i, 0); /* 第0盏灯 熄灭 */
            }
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.LED1:
                if (checked) {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED1 选中", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 1);
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED1 取消",
                            Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 0);
                }
                break;
            case R.id.LED2:
                if (checked)
                {
                    // Cheese mecase R.id.LED1:
                    Toast.makeText(getApplicationContext(), "LED2 选中",
                            Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }
                else {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED2 取消",
                            Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;

            case R.id.LED3:
                if (checked)
                {
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED3 选中",
                            Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 1);
                }
                else
                {
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED3 取消",
                            Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 0);
                }
                break;

            case R.id.LED4:
                if (checked) {
                    // Cheese me
                    Toast.makeText(getApplicationContext(), "LED4 选中",
                            Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 1);
                }
                else {
                    // I'm lactose intolerant
                    Toast.makeText(getApplicationContext(), "LED4 取消",
                            Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 0);
                }
                break;

//             TODO: Veggie sandwich
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        HardControl.ledOpen();



        LED1 = (CheckBox) findViewById(R.id.LED1);
        LED2 = (CheckBox) findViewById(R.id.LED2);
        LED3 = (CheckBox) findViewById(R.id.LED3);
        LED4 = (CheckBox) findViewById(R.id.LED4);

        button.setOnClickListener(new MyButtonListener());

        /* 匿名内部类
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                ledon = !ledon;
                if (ledon)
                {
                    button.setText("ALL OFF");
                }
                else
                {
                    button.setText("ALL OFF");
                }

            }
        });
        */



    }
}
