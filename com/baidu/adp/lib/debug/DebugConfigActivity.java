package com.baidu.adp.lib.debug;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.adp.lib.debug.b.c;
/* loaded from: classes.dex */
public class DebugConfigActivity extends Activity {
    private c a;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b.c = true;
        a(new c(this));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        b.c = false;
        super.onDestroy();
    }

    public void a(c cVar) {
        this.a = cVar;
    }
}
