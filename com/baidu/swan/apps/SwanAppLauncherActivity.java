package com.baidu.swan.apps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.u;
import d.a.h0.a.k;
import d.a.h0.a.r1.d;
import d.a.h0.a.y0.e.b;
/* loaded from: classes.dex */
public class SwanAppLauncherActivity extends Activity {
    public static final boolean DEBUG = k.f43101a;
    public static final String SWAN_APP_LAUNCH_ACTION = "com.baidu.searchbox.action.aiapps.LAUNCH";
    public static final String TAG = "SwanAppLauncherActivity";

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppLauncherActivity.this.finish();
        }
    }

    @Deprecated
    public static void startSwanApp(Context context, b bVar, String str) {
        SwanLauncher.j().n(bVar, null);
    }

    @Override // android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
        h0.b(this);
        if (DEBUG) {
            Log.d(TAG, MissionEvent.MESSAGE_CREATE);
        }
        if (u.a(this)) {
            return;
        }
        SwanLauncher.j().m(getIntent().getExtras());
        d.g().post(new a());
    }
}
