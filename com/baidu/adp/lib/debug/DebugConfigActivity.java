package com.baidu.adp.lib.debug;

import android.app.Activity;
import android.os.Bundle;
/* loaded from: classes.dex */
public class DebugConfigActivity extends Activity {
    private com.baidu.adp.lib.debug.b.c fW;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.gh = true;
        a(new com.baidu.adp.lib.debug.b.c(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        d.gh = false;
        super.onDestroy();
    }

    public void a(com.baidu.adp.lib.debug.b.c cVar) {
        this.fW = cVar;
    }
}
