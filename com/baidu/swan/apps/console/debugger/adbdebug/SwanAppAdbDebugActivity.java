package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes25.dex */
public class SwanAppAdbDebugActivity extends Activity {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DEBUG) {
            Log.d("SwanAppAdbDebugActivity", "ADB Debug onCreate");
        }
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            final Intent intent = getIntent();
            if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
                d.t(this, a.h.aiapps_adb_debug_lack_path).showToast();
                if (DEBUG) {
                    Log.d("SwanAppAdbDebugActivity", "ADB Debug lack of app path");
                }
                finish();
            }
            new g.a(this).f(getString(a.h.aiapps_adb_debug)).st(getString(a.h.aiapps_adb_debug_alert)).a(new com.baidu.swan.apps.view.c.a()).gJ(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.debugger.adbdebug.SwanAppAdbDebugActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    intent.setClass(SwanAppAdbDebugActivity.this, SwanAppLauncherActivity.class);
                    SwanAppAdbDebugActivity.this.startActivity(intent);
                    SwanAppAdbDebugActivity.this.finish();
                }
            }).d(a.h.aiapps_adb_debug_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.debugger.adbdebug.SwanAppAdbDebugActivity.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppAdbDebugActivity.this.finish();
                }
            }).aJB();
        }
    }
}
