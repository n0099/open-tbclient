package com.baidu.batsdk.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.batsdk.BatSDK;
import com.baidu.batsdk.b.e;
import com.baidu.batsdk.b.f;
import com.slidingmenu.lib.R;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class MainActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_activity);
        ((Button) findViewById(R.id.pullFromStart)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.test.MainActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), CrashActivity.class));
            }
        });
        ((Button) findViewById(R.id.pullFromEnd)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.test.MainActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), PngActivity.class));
            }
        });
        final TextView textView = (TextView) findViewById(R.id.normal);
        ((Button) findViewById(R.id.both)).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.batsdk.test.MainActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                textView.setText("taken:" + (System.currentTimeMillis() - currentTimeMillis) + IOUtils.LINE_SEPARATOR_UNIX + f.a());
            }
        });
        ((Button) findViewById(R.id.manualOnly)).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.batsdk.test.MainActivity.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                textView.setText("taken:" + (System.currentTimeMillis() - currentTimeMillis) + IOUtils.LINE_SEPARATOR_UNIX + e.e());
            }
        });
        ((Button) findViewById(R.id.tab_content)).setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.batsdk.test.MainActivity.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatSDK.showFeedbackActivity();
            }
        });
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        BatSDK.doActivityStart(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        BatSDK.doActivityStop(this);
    }
}
