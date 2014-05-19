package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
/* loaded from: classes.dex */
public class StatActivity extends Activity {
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.baidu.mobstat.a.e.a("statsdk", "StatActivity.OnResume()");
        StatService.onPause((Context) this);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.mobstat.a.e.a("statsdk", "StatActivity.OnResume()");
        StatService.onResume((Context) this);
    }
}
