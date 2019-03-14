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
    private d ajn;
    private SwanAppLocalService ajo;
    private String ajp = NotificationCompat.CATEGORY_SYSTEM;
    private boolean ajq = false;
    private boolean mIsDestroyed;

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        overridePendingTransition(a.C0107a.aiapps_slide_in_from_right, a.C0107a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        this.ajq = true;
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
            this.ajn.onCreate(bundle);
            j.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.CK().vC();
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
        this.ajn.onPostCreate(bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder instanceof SwanAppLocalService.a) {
            this.ajo = ((SwanAppLocalService.a) iBinder).Gp();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.ajo = null;
    }

    public int ut() {
        return this.ajn.ut();
    }

    public d uu() {
        return this.ajn;
    }

    private void A(Intent intent) {
        this.ajn = e.b(this, e.F(intent));
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0107a.aiapps_slide_in_from_right, a.C0107a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        this.ajq = true;
        if (ut() != e.F(intent)) {
            uz().yS().A(0, 0).yY().za();
            this.ajn.onDestroy();
            A(intent);
            this.ajn.onCreate(null);
        } else {
            this.ajn.onNewIntent(intent);
        }
        z.Ml();
    }

    public void B(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ajn.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.ajn.getResultDispatcher();
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0164a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a uv() {
        return this.ajn.uv();
    }

    public com.baidu.swan.apps.view.b uw() {
        return this.ajn.uw();
    }

    public void ux() {
        if (this.ajq) {
            this.ajp = "schema";
        } else {
            this.ajp = "user";
        }
    }

    public String uy() {
        return this.ajp;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        if (com.baidu.swan.apps.u.a.CB().vh()) {
            ux();
            com.baidu.swan.apps.w.e.Ec().vQ();
        }
        super.onStart();
        this.ajn.onStart();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        if (!com.baidu.swan.apps.u.a.CB().vh()) {
            ux();
            com.baidu.swan.apps.w.e.Ec().vQ();
        }
        super.onResume();
        this.ajn.onResume();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        this.ajn.onPause();
        super.onPause();
        if (!com.baidu.swan.apps.u.a.CB().vh()) {
            com.baidu.swan.apps.w.e.Ec().vR();
            this.ajq = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        this.ajn.onStop();
        super.onStop();
        if (com.baidu.swan.apps.u.a.CB().vh()) {
            com.baidu.swan.apps.w.e.Ec().vR();
            this.ajq = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.b.c.a.a.wi().wj().wh().a(this, i, i2, intent);
        }
    }

    public com.baidu.swan.apps.core.c.e uz() {
        return this.ajn.uz();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity finish");
        if (this.ajn == null || !this.ajn.tu()) {
            super.finish();
        }
    }

    public void uA() {
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
        if (this.ajo != null) {
            unbindService(this);
        }
        super.onDestroy();
    }

    private void destroy() {
        if (!this.mIsDestroyed && this.ajn != null) {
            this.ajn.onDestroy();
            this.mIsDestroyed = true;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        this.ajn.onBackPressed();
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

    public com.baidu.swan.apps.v.b.b uB() {
        return this.ajn.uB();
    }

    public final void a(f fVar) {
        this.ajn.a(fVar);
    }

    public void k(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.c.c(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        this.ajn.a(i, strArr, interfaceC0108a);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0213a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.ajn.b(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.ajn.showLoadingView();
    }

    public void uC() {
        this.ajn.uC();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.ajn.onTrimMemory(i);
    }

    @Override // com.baidu.swan.apps.aj.e.c
    @NonNull
    public com.baidu.swan.apps.aj.e.b uD() {
        return this.ajn.uD();
    }

    public void aK(boolean z) {
        this.ajn.aK(z);
    }

    public boolean isLandScape() {
        return this.ajn.isLandScape();
    }

    public void a(com.baidu.swan.apps.o.b bVar) {
        this.ajn.a(bVar);
    }

    public void b(com.baidu.swan.apps.o.b bVar) {
        this.ajn.b(bVar);
    }

    public boolean uE() {
        return this.ajn.uE();
    }

    @UiThread
    public void bL(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.Da().a(this, i, uB());
    }
}
