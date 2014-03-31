package com.baidu.adp.lib.debug;

import android.app.Activity;
import android.os.Bundle;
/* loaded from: classes.dex */
public class DebugConfigActivity extends Activity {
    private com.baidu.adp.lib.debug.b.c a;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c.c = true;
        this.a = new com.baidu.adp.lib.debug.b.c(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        c.c = false;
        super.onDestroy();
    }
}
