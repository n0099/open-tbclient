package com.baidu.swan.apps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import d.a.m0.a.k;
import d.a.m0.a.s1.d;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.v;
@Autowired
/* loaded from: classes2.dex */
public class SwanAppLauncherActivity extends Activity {
    public static final boolean DEBUG = k.f46983a;
    public static final String SWAN_APP_LAUNCH_ACTION = "com.baidu.searchbox.action.aiapps.LAUNCH";
    public static final String TAG = "SwanAppLauncherActivity";
    public Object mPermissionDialog;

    /* loaded from: classes2.dex */
    public class a implements d.b {
        public a() {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppLauncherActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIntent() {
        SwanLauncher.j().m(getIntent().getExtras());
        d.a.m0.a.a2.d.i().post(new b());
    }

    @Deprecated
    public static void startSwanApp(Context context, d.a.m0.a.f1.e.b bVar, String str) {
        SwanLauncher.j().n(bVar, null);
    }

    @Inject(force = false)
    public d getPermissionDialogIOC() {
        return d.f48466a;
    }

    @Override // android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        n0.b(this);
        if (DEBUG) {
            Log.d(TAG, MissionEvent.MESSAGE_CREATE);
        }
        if (v.a(this)) {
            return;
        }
        String stringExtra = getIntent() != null ? getIntent().getStringExtra("mAppId") : "";
        getPermissionDialogIOC().a(stringExtra);
        if (getPermissionDialogIOC().b()) {
            this.mPermissionDialog = getPermissionDialogIOC().c(this, stringExtra, new a(), true);
        } else {
            handleIntent();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        getPermissionDialogIOC().f(this, this.mPermissionDialog);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (getPermissionDialogIOC().e(this, i2, strArr, iArr, this.mPermissionDialog)) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        getPermissionDialogIOC().d(this, this.mPermissionDialog);
    }
}
