package com.baidu.mobstat;

import android.app.Activity;
/* loaded from: classes.dex */
public class StatActivity extends Activity {
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.mobstat.a.b.a("stat", "StatActivity.OnResume()");
        StatService.onPause(this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.mobstat.a.b.a("stat", "StatActivity.OnResume()");
        StatService.onResume(this);
    }
}
