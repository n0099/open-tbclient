package com.baidu.adp.lib.debug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
/* loaded from: classes.dex */
public class MainActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.adp.e.adp_debug_activity_main);
        a();
    }

    private void a() {
        startService(new Intent(this, SwitchDebugService.class));
        d.f = new c(this);
    }
}
