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
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.m;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.i.c;
import com.baidu.swan.apps.o.e;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class SwanAppActivity extends FragmentActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.aj.e.c, a.InterfaceC0135a {
    private static final boolean DEBUG = c.DEBUG;
    private com.baidu.swan.apps.o.d ajm;
    private SwanAppLocalService ajn;
    private String ajo = NotificationCompat.CATEGORY_SYSTEM;
    private boolean ajp = false;
    private boolean mIsDestroyed;

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        overridePendingTransition(b.a.aiapps_slide_in_from_right, b.a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        this.ajp = true;
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
            setContentView(b.g.aiapps_activity);
            A(intent);
            this.ajm.onCreate(bundle);
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
        this.ajm.onPostCreate(bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder instanceof SwanAppLocalService.a) {
            this.ajn = ((SwanAppLocalService.a) iBinder).Gp();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.ajn = null;
    }

    public int ut() {
        return this.ajm.ut();
    }

    public com.baidu.swan.apps.o.d uu() {
        return this.ajm;
    }

    private void A(Intent intent) {
        this.ajm = e.b(this, e.F(intent));
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(b.a.aiapps_slide_in_from_right, b.a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        this.ajp = true;
        if (ut() != e.F(intent)) {
            uz().yS().A(0, 0).yY().za();
            this.ajm.onDestroy();
            A(intent);
            this.ajm.onCreate(null);
        } else {
            this.ajm.onNewIntent(intent);
        }
        z.Ml();
    }

    public void B(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ajm.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.ajm.getResultDispatcher();
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0135a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a uv() {
        return this.ajm.uv();
    }

    public com.baidu.swan.apps.view.b uw() {
        return this.ajm.uw();
    }

    public void ux() {
        if (this.ajp) {
            this.ajo = "schema";
        } else {
            this.ajo = "user";
        }
    }

    public String uy() {
        return this.ajo;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        if (com.baidu.swan.apps.u.a.CB().vh()) {
            ux();
            com.baidu.swan.apps.w.e.Ec().vQ();
        }
        super.onStart();
        this.ajm.onStart();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        if (!com.baidu.swan.apps.u.a.CB().vh()) {
            ux();
            com.baidu.swan.apps.w.e.Ec().vQ();
        }
        super.onResume();
        this.ajm.onResume();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        this.ajm.onPause();
        super.onPause();
        if (!com.baidu.swan.apps.u.a.CB().vh()) {
            com.baidu.swan.apps.w.e.Ec().vR();
            this.ajp = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        this.ajm.onStop();
        super.onStop();
        if (com.baidu.swan.apps.u.a.CB().vh()) {
            com.baidu.swan.apps.w.e.Ec().vR();
            this.ajp = false;
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
        return this.ajm.uz();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity finish");
        if (this.ajm == null || !this.ajm.tu()) {
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
        if (this.ajn != null) {
            unbindService(this);
        }
        super.onDestroy();
    }

    private void destroy() {
        if (!this.mIsDestroyed && this.ajm != null) {
            this.ajm.onDestroy();
            this.mIsDestroyed = true;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        this.ajm.onBackPressed();
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
            overridePendingTransition(0, b.a.aiapps_slide_out_to_right_zadjustment_top);
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
        return this.ajm.uB();
    }

    public final void a(f fVar) {
        this.ajm.a(fVar);
    }

    public void k(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.c.c(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0078a interfaceC0078a) {
        this.ajm.a(i, strArr, interfaceC0078a);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0179a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.ajm.b(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.ajm.showLoadingView();
    }

    public void uC() {
        this.ajm.uC();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.ajm.onTrimMemory(i);
    }

    @Override // com.baidu.swan.apps.aj.e.c
    @NonNull
    public com.baidu.swan.apps.aj.e.b uD() {
        return this.ajm.uD();
    }

    public void aK(boolean z) {
        this.ajm.aK(z);
    }

    public boolean isLandScape() {
        return this.ajm.isLandScape();
    }

    public void a(com.baidu.swan.apps.o.b bVar) {
        this.ajm.a(bVar);
    }

    public void b(com.baidu.swan.apps.o.b bVar) {
        this.ajm.b(bVar);
    }

    public boolean uE() {
        return this.ajm.uE();
    }

    @UiThread
    public void bL(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.Da().a(this, i, uB());
    }
}
