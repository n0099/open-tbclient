package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.ab;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.core.j.c;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.o.e;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes2.dex */
public class SwanAppActivity extends FragmentActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.aj.f.c, a.InterfaceC0213a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String aEb = SwanAppActivity.class.getName();
    private d aEc;
    private SwanAppLocalService aEd;
    private String aEe = "sys";
    private boolean aEf = false;
    private boolean mIsDestroyed;

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        overridePendingTransition(a.C0151a.aiapps_slide_in_from_right, a.C0151a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        this.aEf = true;
        super.onCreate(bundle);
        if (!n.Q(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.putExtras(bundle2);
            }
            if (D(intent)) {
                com.baidu.swan.apps.an.b.N(this);
                return;
            }
            c.b.J(intent);
            if (DEBUG) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            bindService(new Intent(this, getProcessInfo().service), this, 1);
            E(intent);
            z.R(this);
            if (DEBUG) {
                Log.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=" + bundle);
            }
            com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            F(intent);
            this.aEc.onCreate(bundle);
            j.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.Ju().BP();
                }
            }, "initMobStat");
        }
    }

    private boolean D(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(aEb)) ? false : true;
        }
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle.get("android:support:fragments") != null) {
            bundle.remove("android:support:fragments");
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putBundle("swan_key_save_bundle", intent.getExtras());
        }
    }

    private void E(Intent intent) {
        if (intent != null) {
            if (n.a(intent, "ai_launch_app_orientation", 0) == 1) {
                setRequestedOrientation(0);
            }
            if (e.K(intent) == 1) {
                com.baidu.swan.apps.an.b.O(this);
            }
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.aEc.onPostCreate(bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder instanceof SwanAppLocalService.a) {
            this.aEd = ((SwanAppLocalService.a) iBinder).Oo();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.aEd = null;
    }

    public int AB() {
        return this.aEc.AB();
    }

    public d AC() {
        return this.aEc;
    }

    private void F(Intent intent) {
        this.aEc = e.b(this, e.K(intent));
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0151a.aiapps_slide_in_from_right, a.C0151a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        this.aEf = true;
        if (AB() != e.K(intent)) {
            AH().Fu().H(0, 0).FA().FC();
            this.aEc.onDestroy();
            F(intent);
            this.aEc.onCreate(null);
        } else {
            this.aEc.onNewIntent(intent);
        }
        ab.UB();
    }

    public void G(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aEc.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.aEc.getResultDispatcher();
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0213a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a AD() {
        return this.aEc.AD();
    }

    public com.baidu.swan.apps.view.b AE() {
        return this.aEc.AE();
    }

    public void AF() {
        if (this.aEf) {
            this.aEe = "schema";
        } else {
            this.aEe = "user";
        }
    }

    public String AG() {
        return this.aEe;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        if (com.baidu.swan.apps.u.a.Jl().Bh()) {
            AF();
            com.baidu.swan.apps.w.e.LD().Cf();
        }
        super.onStart();
        this.aEc.onStart();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        if (!com.baidu.swan.apps.u.a.Jl().Bh()) {
            AF();
            com.baidu.swan.apps.w.e.LD().Cf();
        }
        super.onResume();
        this.aEc.onResume();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        this.aEc.onPause();
        super.onPause();
        if (!com.baidu.swan.apps.u.a.Jl().Bh()) {
            com.baidu.swan.apps.w.e.LD().Cg();
            this.aEf = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        this.aEc.onStop();
        super.onStop();
        if (com.baidu.swan.apps.u.a.Jl().Bh()) {
            com.baidu.swan.apps.w.e.LD().Cg();
            this.aEf = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.b.c.a.a.Cx().Cy().Cw().a(this, i, i2, intent);
        }
    }

    public com.baidu.swan.apps.core.d.e AH() {
        return this.aEc.AH();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity finish");
        if (this.aEc == null || !this.aEc.zC()) {
            super.finish();
        }
    }

    public void AI() {
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
        if (this.aEd != null) {
            unbindService(this);
        }
        super.onDestroy();
    }

    private void destroy() {
        if (!this.mIsDestroyed && this.aEc != null) {
            this.aEc.onDestroy();
            this.mIsDestroyed = true;
            com.baidu.swan.apps.textarea.a.release();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        this.aEc.onBackPressed();
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
            overridePendingTransition(0, a.C0151a.aiapps_slide_out_to_right_zadjustment_top);
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

    public com.baidu.swan.apps.v.b.b AJ() {
        return this.aEc.AJ();
    }

    public final void a(f fVar) {
        this.aEc.a(fVar);
    }

    public void k(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.c.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0152a interfaceC0152a) {
        this.aEc.a(i, strArr, interfaceC0152a);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0270a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.aEc.b(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.aEc.showLoadingView();
    }

    public void AK() {
        this.aEc.AK();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.aEc.onTrimMemory(i);
    }

    @Override // com.baidu.swan.apps.aj.f.c
    @NonNull
    public com.baidu.swan.apps.aj.f.b AL() {
        return this.aEc.AL();
    }

    public void bi(boolean z) {
        this.aEc.bi(z);
    }

    public boolean isLandScape() {
        return this.aEc.isLandScape();
    }

    public void a(com.baidu.swan.apps.o.b bVar) {
        this.aEc.a(bVar);
    }

    public void b(com.baidu.swan.apps.o.b bVar) {
        this.aEc.b(bVar);
    }

    public boolean AM() {
        return this.aEc.AM();
    }

    @UiThread
    public void cH(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.JK().a(this, i, AJ());
    }
}
