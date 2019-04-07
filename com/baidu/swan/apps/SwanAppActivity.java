package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.core.i.c;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.o.e;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class SwanAppActivity extends FragmentActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.aj.e.c, a.InterfaceC0164a {
    private static final boolean DEBUG = b.DEBUG;
    private d ajr;
    private SwanAppLocalService ajs;
    private String ajt = NotificationCompat.CATEGORY_SYSTEM;
    private boolean aju = false;
    private boolean mIsDestroyed;

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        overridePendingTransition(a.C0107a.aiapps_slide_in_from_right, a.C0107a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        this.aju = true;
        super.onCreate(bundle);
        if (!m.N(this)) {
            c.b.E(getIntent());
            if (DEBUG) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            bindService(new Intent(this, getProcessInfo().service), this, 1);
            Intent intent = getIntent();
            z(intent);
            x.O(this);
            if (DEBUG) {
                Log.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=" + bundle);
            }
            com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            A(intent);
            this.ajr.onCreate(bundle);
            j.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.CI().vB();
                }
            }, "initMobStat");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle.get("android:support:fragments") != null) {
            bundle.remove("android:support:fragments");
        }
    }

    private void z(Intent intent) {
        if (intent != null) {
            if (m.a(intent, "ai_launch_app_orientation", 0) == 1) {
                setRequestedOrientation(0);
            }
            if (e.F(intent) == 1) {
                com.baidu.swan.apps.an.b.L(this);
            }
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.ajr.onPostCreate(bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder instanceof SwanAppLocalService.a) {
            this.ajs = ((SwanAppLocalService.a) iBinder).Gn();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.ajs = null;
    }

    public int us() {
        return this.ajr.us();
    }

    public d ut() {
        return this.ajr;
    }

    private void A(Intent intent) {
        this.ajr = e.b(this, e.F(intent));
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0107a.aiapps_slide_in_from_right, a.C0107a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        this.aju = true;
        if (us() != e.F(intent)) {
            uy().yR().A(0, 0).yX().yZ();
            this.ajr.onDestroy();
            A(intent);
            this.ajr.onCreate(null);
        } else {
            this.ajr.onNewIntent(intent);
        }
        z.Mj();
    }

    public void B(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ajr.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.ajr.getResultDispatcher();
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0164a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a uu() {
        return this.ajr.uu();
    }

    public com.baidu.swan.apps.view.b uv() {
        return this.ajr.uv();
    }

    public void uw() {
        if (this.aju) {
            this.ajt = "schema";
        } else {
            this.ajt = "user";
        }
    }

    public String ux() {
        return this.ajt;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        if (com.baidu.swan.apps.u.a.Cz().vg()) {
            uw();
            com.baidu.swan.apps.w.e.Ea().vP();
        }
        super.onStart();
        this.ajr.onStart();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        if (!com.baidu.swan.apps.u.a.Cz().vg()) {
            uw();
            com.baidu.swan.apps.w.e.Ea().vP();
        }
        super.onResume();
        this.ajr.onResume();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        this.ajr.onPause();
        super.onPause();
        if (!com.baidu.swan.apps.u.a.Cz().vg()) {
            com.baidu.swan.apps.w.e.Ea().vQ();
            this.aju = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        this.ajr.onStop();
        super.onStop();
        if (com.baidu.swan.apps.u.a.Cz().vg()) {
            com.baidu.swan.apps.w.e.Ea().vQ();
            this.aju = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.b.c.a.a.wh().wi().wg().a(this, i, i2, intent);
        }
    }

    public com.baidu.swan.apps.core.c.e uy() {
        return this.ajr.uy();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity finish");
        if (this.ajr == null || !this.ajr.tt()) {
            super.finish();
        }
    }

    public void uz() {
        finish();
        destroy();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        destroy();
        if (this.ajs != null) {
            unbindService(this);
        }
        super.onDestroy();
    }

    private void destroy() {
        if (!this.mIsDestroyed && this.ajr != null) {
            this.ajr.onDestroy();
            this.mIsDestroyed = true;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        this.ajr.onBackPressed();
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        try {
            z2 = super.moveTaskToBack(z);
        } catch (Exception e2) {
            z2 = false;
            e = e2;
        }
        try {
            overridePendingTransition(0, a.C0107a.aiapps_slide_out_to_right_zadjustment_top);
        } catch (Exception e3) {
            e = e3;
            if (DEBUG) {
                e.printStackTrace();
            }
            return z2;
        }
        return z2;
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    public com.baidu.swan.apps.v.b.b uA() {
        return this.ajr.uA();
    }

    public final void a(f fVar) {
        this.ajr.a(fVar);
    }

    public void k(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.c.c(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        this.ajr.a(i, strArr, interfaceC0108a);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0213a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.ajr.b(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.ajr.showLoadingView();
    }

    public void uB() {
        this.ajr.uB();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.ajr.onTrimMemory(i);
    }

    @Override // com.baidu.swan.apps.aj.e.c
    @NonNull
    public com.baidu.swan.apps.aj.e.b uC() {
        return this.ajr.uC();
    }

    public void aK(boolean z) {
        this.ajr.aK(z);
    }

    public boolean isLandScape() {
        return this.ajr.isLandScape();
    }

    public void a(com.baidu.swan.apps.o.b bVar) {
        this.ajr.a(bVar);
    }

    public void b(com.baidu.swan.apps.o.b bVar) {
        this.ajr.b(bVar);
    }

    public boolean uD() {
        return this.ajr.uD();
    }

    @UiThread
    public void bK(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.CY().a(this, i, uA());
    }
}
