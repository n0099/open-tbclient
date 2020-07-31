package com.baidu.swan.apps;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.runtime.d;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
/* loaded from: classes7.dex */
public class SwanAppLauncherActivity extends Activity {
    private static final boolean DEBUG = b.DEBUG;

    @Override // android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        al.fixedOrientation(this, releaseFixedOrientation);
        ai.S(this);
        if (DEBUG) {
            Log.d("SwanAppLauncherActivity", MissionEvent.MESSAGE_CREATE);
        }
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            SwanLauncher.aeL().v(getIntent().getExtras());
            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.SwanAppLauncherActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    SwanAppLauncherActivity.this.finish();
                }
            });
        }
    }
}
