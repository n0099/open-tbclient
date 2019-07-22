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
public class SwanAppActivity extends FragmentActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.aj.f.c, a.InterfaceC0167a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String akh = SwanAppActivity.class.getName();
    private d aki;
    private SwanAppLocalService akj;
    private String akk = "sys";
    private boolean akl = false;
    private boolean mIsDestroyed;

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        overridePendingTransition(a.C0105a.aiapps_slide_in_from_right, a.C0105a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        this.akl = true;
        super.onCreate(bundle);
        if (!n.R(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.putExtras(bundle2);
            }
            if (x(intent)) {
                com.baidu.swan.apps.an.b.O(this);
                return;
            }
            c.b.D(intent);
            if (DEBUG) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            bindService(new Intent(this, getProcessInfo().service), this, 1);
            y(intent);
            z.S(this);
            if (DEBUG) {
                Log.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=" + bundle);
            }
            com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            z(intent);
            this.aki.onCreate(bundle);
            j.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.Ew().wR();
                }
            }, "initMobStat");
        }
    }

    private boolean x(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(akh)) ? false : true;
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

    private void y(Intent intent) {
        if (intent != null) {
            if (n.a(intent, "ai_launch_app_orientation", 0) == 1) {
                setRequestedOrientation(0);
            }
            if (e.E(intent) == 1) {
                com.baidu.swan.apps.an.b.P(this);
            }
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.aki.onPostCreate(bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder instanceof SwanAppLocalService.a) {
            this.akj = ((SwanAppLocalService.a) iBinder).Jq();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.akj = null;
    }

    public int vD() {
        return this.aki.vD();
    }

    public d vE() {
        return this.aki;
    }

    private void z(Intent intent) {
        this.aki = e.b(this, e.E(intent));
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0105a.aiapps_slide_in_from_right, a.C0105a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        this.akl = true;
        if (vD() != e.E(intent)) {
            vJ().Av().B(0, 0).AB().AD();
            this.aki.onDestroy();
            z(intent);
            this.aki.onCreate(null);
        } else {
            this.aki.onNewIntent(intent);
        }
        ab.PH();
    }

    public void A(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aki.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.aki.getResultDispatcher();
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0167a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a vF() {
        return this.aki.vF();
    }

    public com.baidu.swan.apps.view.b vG() {
        return this.aki.vG();
    }

    public void vH() {
        if (this.akl) {
            this.akk = "schema";
        } else {
            this.akk = "user";
        }
    }

    public String vI() {
        return this.akk;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        if (com.baidu.swan.apps.u.a.En().wj()) {
            vH();
            com.baidu.swan.apps.w.e.GF().xh();
        }
        super.onStart();
        this.aki.onStart();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        if (!com.baidu.swan.apps.u.a.En().wj()) {
            vH();
            com.baidu.swan.apps.w.e.GF().xh();
        }
        super.onResume();
        this.aki.onResume();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        this.aki.onPause();
        super.onPause();
        if (!com.baidu.swan.apps.u.a.En().wj()) {
            com.baidu.swan.apps.w.e.GF().xi();
            this.akl = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        this.aki.onStop();
        super.onStop();
        if (com.baidu.swan.apps.u.a.En().wj()) {
            com.baidu.swan.apps.w.e.GF().xi();
            this.akl = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.b.c.a.a.xz().xA().xy().a(this, i, i2, intent);
        }
    }

    public com.baidu.swan.apps.core.d.e vJ() {
        return this.aki.vJ();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity finish");
        if (this.aki == null || !this.aki.uE()) {
            super.finish();
        }
    }

    public void vK() {
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
        if (this.akj != null) {
            unbindService(this);
        }
        super.onDestroy();
    }

    private void destroy() {
        if (!this.mIsDestroyed && this.aki != null) {
            this.aki.onDestroy();
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
        this.aki.onBackPressed();
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
            overridePendingTransition(0, a.C0105a.aiapps_slide_out_to_right_zadjustment_top);
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

    public com.baidu.swan.apps.v.b.b vL() {
        return this.aki.vL();
    }

    public final void a(f fVar) {
        this.aki.a(fVar);
    }

    public void k(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.c.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0106a interfaceC0106a) {
        this.aki.a(i, strArr, interfaceC0106a);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0224a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.aki.b(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.aki.showLoadingView();
    }

    public void vM() {
        this.aki.vM();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.aki.onTrimMemory(i);
    }

    @Override // com.baidu.swan.apps.aj.f.c
    @NonNull
    public com.baidu.swan.apps.aj.f.b vN() {
        return this.aki.vN();
    }

    public void aQ(boolean z) {
        this.aki.aQ(z);
    }

    public boolean isLandScape() {
        return this.aki.isLandScape();
    }

    public void a(com.baidu.swan.apps.o.b bVar) {
        this.aki.a(bVar);
    }

    public void b(com.baidu.swan.apps.o.b bVar) {
        this.aki.b(bVar);
    }

    public boolean vO() {
        return this.aki.vO();
    }

    @UiThread
    public void bK(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.EM().a(this, i, vL());
    }
}
