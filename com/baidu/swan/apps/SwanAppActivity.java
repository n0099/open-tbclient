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
public class SwanAppActivity extends FragmentActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.aj.f.c, a.InterfaceC0170a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String ajF = SwanAppActivity.class.getName();
    private d ajG;
    private SwanAppLocalService ajH;
    private String ajI = NotificationCompat.CATEGORY_SYSTEM;
    private boolean ajJ = false;
    private boolean mIsDestroyed;

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        overridePendingTransition(a.C0108a.aiapps_slide_in_from_right, a.C0108a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        this.ajJ = true;
        super.onCreate(bundle);
        if (!n.O(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.putExtras(bundle2);
            }
            if (x(intent)) {
                com.baidu.swan.apps.an.b.L(this);
                return;
            }
            c.b.D(intent);
            if (DEBUG) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            bindService(new Intent(this, getProcessInfo().service), this, 1);
            y(intent);
            z.P(this);
            if (DEBUG) {
                Log.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=" + bundle);
            }
            com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            z(intent);
            this.ajG.onCreate(bundle);
            j.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.u.a.DN().wq();
                }
            }, "initMobStat");
        }
    }

    private boolean x(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(ajF)) ? false : true;
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
                com.baidu.swan.apps.an.b.M(this);
            }
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.ajG.onPostCreate(bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder instanceof SwanAppLocalService.a) {
            this.ajH = ((SwanAppLocalService.a) iBinder).ID();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.ajH = null;
    }

    public int vc() {
        return this.ajG.vc();
    }

    public d vd() {
        return this.ajG;
    }

    private void z(Intent intent) {
        this.ajG = e.b(this, e.E(intent));
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0108a.aiapps_slide_in_from_right, a.C0108a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        this.ajJ = true;
        if (vc() != e.E(intent)) {
            vi().zO().y(0, 0).zU().zW();
            this.ajG.onDestroy();
            z(intent);
            this.ajG.onCreate(null);
        } else {
            this.ajG.onNewIntent(intent);
        }
        ab.OR();
    }

    public void A(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.ajG.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        return this.ajG.getResultDispatcher();
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0170a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a ve() {
        return this.ajG.ve();
    }

    public com.baidu.swan.apps.view.b vf() {
        return this.ajG.vf();
    }

    public void vg() {
        if (this.ajJ) {
            this.ajI = "schema";
        } else {
            this.ajI = "user";
        }
    }

    public String vh() {
        return this.ajI;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        if (com.baidu.swan.apps.u.a.DE().vI()) {
            vg();
            com.baidu.swan.apps.w.e.FV().wG();
        }
        super.onStart();
        this.ajG.onStart();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        if (!com.baidu.swan.apps.u.a.DE().vI()) {
            vg();
            com.baidu.swan.apps.w.e.FV().wG();
        }
        super.onResume();
        this.ajG.onResume();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        this.ajG.onPause();
        super.onPause();
        if (!com.baidu.swan.apps.u.a.DE().vI()) {
            com.baidu.swan.apps.w.e.FV().wH();
            this.ajJ = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        this.ajG.onStop();
        super.onStop();
        if (com.baidu.swan.apps.u.a.DE().vI()) {
            com.baidu.swan.apps.w.e.FV().wH();
            this.ajJ = false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.b.c.a.a.wY().wZ().wX().a(this, i, i2, intent);
        }
    }

    public com.baidu.swan.apps.core.d.e vi() {
        return this.ajG.vi();
    }

    @Override // android.app.Activity
    public void finish() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity finish");
        if (this.ajG == null || !this.ajG.ue()) {
            super.finish();
        }
    }

    public void vj() {
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
        if (this.ajH != null) {
            unbindService(this);
        }
        super.onDestroy();
    }

    private void destroy() {
        if (!this.mIsDestroyed && this.ajG != null) {
            this.ajG.onDestroy();
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
        this.ajG.onBackPressed();
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
            overridePendingTransition(0, a.C0108a.aiapps_slide_out_to_right_zadjustment_top);
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

    public com.baidu.swan.apps.v.b.b vk() {
        return this.ajG.vk();
    }

    public final void a(f fVar) {
        this.ajG.a(fVar);
    }

    public void k(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.c.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0109a interfaceC0109a) {
        this.ajG.a(i, strArr, interfaceC0109a);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0227a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (!this.ajG.b(i, strArr, iArr)) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void showLoadingView() {
        this.ajG.showLoadingView();
    }

    public void vl() {
        this.ajG.vl();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.ajG.onTrimMemory(i);
    }

    @Override // com.baidu.swan.apps.aj.f.c
    @NonNull
    public com.baidu.swan.apps.aj.f.b vm() {
        return this.ajG.vm();
    }

    public void aN(boolean z) {
        this.ajG.aN(z);
    }

    public boolean isLandScape() {
        return this.ajG.isLandScape();
    }

    public void a(com.baidu.swan.apps.o.b bVar) {
        this.ajG.a(bVar);
    }

    public void b(com.baidu.swan.apps.o.b bVar) {
        this.ajG.b(bVar);
    }

    public boolean vn() {
        return this.ajG.vn();
    }

    @UiThread
    public void bK(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.u.a.Ed().a(this, i, vk());
    }
}
