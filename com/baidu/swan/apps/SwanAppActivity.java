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
public class SwanAppActivity extends FragmentActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.aj.f.c, a.InterfaceC0208a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String aDJ = SwanAppActivity.class.getName();
    private d aDK;
    private SwanAppLocalService aDL;
    private String aDM = "sys";
    private boolean aDN = false;
    private boolean mIsDestroyed;

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        overridePendingTransition(a.C0146a.aiapps_slide_in_from_right, a.C0146a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        this.aDN = true;
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
            this.aDK.onCreate(bundle);
            j.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.Jv().BQ();
                }
            }, "initMobStat");
        }
    }

    private boolean D(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(aDJ)) ? false : true;
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
        this.aDK.onPostCreate(bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder instanceof SwanAppLocalService.a) {
            this.aDL = ((SwanAppLocalService.a) iBinder).Op();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.aDL = null;
    }

    public int AC() {
        return this.aDK.AC();
    }

    public d AD() {
        return this.aDK;
    }

    private void F(Intent intent) {
        this.aDK = e.b(this, e.K(intent));
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0146a.aiapps_slide_in_from_right, a.C0146a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        this.aDN = true;
        if (AC() != e.K(intent)) {
            AI().Fv().F(0, 0).FB().FD();
            this.aDK.onDestroy();
            F(intent);
            this.aDK.onCreate(null);
        } else {
            this.aDK.onNewIntent(intent);
        }
        ab.Uz();
    }

    public void G(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aDK.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.aDK.getResultDispatcher();
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0208a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a AE() {
        return this.aDK.AE();
    }

    public com.baidu.swan.apps.view.b AF() {
        return this.aDK.AF();
    }

    public void AG() {
        if (this.aDN) {
            this.aDM = "schema";
        } else {
            this.aDM = "user";
        }
    }

    public String AH() {
        return this.aDM;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        if (com.baidu.swan.apps.u.a.Jm().Bi()) {
            AG();
            com.baidu.swan.apps.w.e.LE().Cg();
        }
        super.onStart();
        this.aDK.onStart();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        if (!com.baidu.swan.apps.u.a.Jm().Bi()) {
            AG();
            com.baidu.swan.apps.w.e.LE().Cg();
        }
        super.onResume();
        this.aDK.onResume();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        this.aDK.onPause();
        super.onPause();
        if (!com.baidu.swan.apps.u.a.Jm().Bi()) {
            com.baidu.swan.apps.w.e.LE().Ch();
            this.aDN = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        this.aDK.onStop();
        super.onStop();
        if (com.baidu.swan.apps.u.a.Jm().Bi()) {
            com.baidu.swan.apps.w.e.LE().Ch();
            this.aDN = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.b.c.a.a.Cy().Cz().Cx().a(this, i, i2, intent);
        }
    }

    public com.baidu.swan.apps.core.d.e AI() {
        return this.aDK.AI();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity finish");
        if (this.aDK == null || !this.aDK.zD()) {
            super.finish();
        }
    }

    public void AJ() {
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
        if (this.aDL != null) {
            unbindService(this);
        }
        super.onDestroy();
    }

    private void destroy() {
        if (!this.mIsDestroyed && this.aDK != null) {
            this.aDK.onDestroy();
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
        this.aDK.onBackPressed();
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
            overridePendingTransition(0, a.C0146a.aiapps_slide_out_to_right_zadjustment_top);
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

    public com.baidu.swan.apps.v.b.b AK() {
        return this.aDK.AK();
    }

    public final void a(f fVar) {
        this.aDK.a(fVar);
    }

    public void k(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.c.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0147a interfaceC0147a) {
        this.aDK.a(i, strArr, interfaceC0147a);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0265a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.aDK.b(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.aDK.showLoadingView();
    }

    public void AL() {
        this.aDK.AL();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.aDK.onTrimMemory(i);
    }

    @Override // com.baidu.swan.apps.aj.f.c
    @NonNull
    public com.baidu.swan.apps.aj.f.b AM() {
        return this.aDK.AM();
    }

    public void bi(boolean z) {
        this.aDK.bi(z);
    }

    public boolean isLandScape() {
        return this.aDK.isLandScape();
    }

    public void a(com.baidu.swan.apps.o.b bVar) {
        this.aDK.a(bVar);
    }

    public void b(com.baidu.swan.apps.o.b bVar) {
        this.aDK.b(bVar);
    }

    public boolean AN() {
        return this.aDK.AN();
    }

    @UiThread
    public void cH(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.JL().a(this, i, AK());
    }
}
