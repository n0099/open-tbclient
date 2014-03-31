package com.baidu.batsdk.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.baidu.batsdk.BatSDK;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class CrashActivity extends Activity {
    static /* synthetic */ List a(CrashActivity crashActivity) {
        return null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.about_activity);
        ((Button) findViewById(R.id.disabled)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.batsdk.test.CrashActivity.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CrashActivity.a(CrashActivity.this).equals("");
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
