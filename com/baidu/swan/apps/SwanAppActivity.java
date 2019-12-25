package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ah;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.apps.y.g;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ao.g.c, a.InterfaceC0271a {
    private com.baidu.swan.apps.framework.c aVC;
    private Messenger aVD;
    private ActivityResultDispatcher aVF;
    OrientationEventListener aVI;
    private com.baidu.swan.apps.as.b aVJ;
    protected com.baidu.swan.apps.view.c aVK;
    private com.baidu.swan.apps.res.widget.floatlayer.a aVL;
    private static final boolean DEBUG = b.DEBUG;
    private static final String aVz = SwanAppActivity.class.getName();
    private static final long aVA = TimeUnit.SECONDS.toMillis(1);
    private static final long aVB = TimeUnit.SECONDS.toMillis(5);
    private FrameLifeState aVE = FrameLifeState.INACTIVATED;
    private String aVG = "sys";
    private boolean aVH = false;
    private final com.baidu.swan.apps.runtime.b aVM = new com.baidu.swan.apps.runtime.b();

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0185a.aiapps_slide_in_from_right, a.C0185a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.Sc().FK();
        com.baidu.swan.apps.process.messaging.client.a.Yi().Yk();
        this.aVH = true;
        e.fZ(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!r.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                bundle2.setClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (D(intent)) {
                Eb();
                return;
            }
            d.b.F(intent);
            com.baidu.swan.games.utils.so.d.P(intent);
            if (DEBUG) {
                Log.i("SwanAppActivity", "onCreate: bindService");
            }
            try {
                bindService(new Intent(this, getProcessInfo().service), this, 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (Build.VERSION.SDK_INT == 26) {
                TranslucentUtils.convertFromTranslucent(this);
            }
            if (DEBUG) {
                Log.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=" + bundle);
            }
            com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            DW();
            com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
            ZP.j(this);
            ZP.e(this.aVM);
            boolean I = com.baidu.swan.apps.x.b.d.I(intent);
            if (intent != null && (I || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                ZP.c(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (ZP.Yw() && I) {
                ZP.ZM().ZV().ij("1250000000000000");
            }
            af.V(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.aVJ = new com.baidu.swan.apps.as.b(this);
            }
            if (this.aVJ != null) {
                this.aVJ.setCanSlide(false);
            }
            if (this.aVJ != null) {
                this.aVJ.onCreate();
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Rw().Fn();
                }
            }, "initMobStat");
            ah.aes();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.aVJ != null) {
            this.aVJ.adM();
        }
    }

    public com.baidu.swan.apps.as.b DG() {
        return this.aVJ;
    }

    private boolean D(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(aVz)) ? false : true;
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

    private void Q(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            com.baidu.swan.apps.as.c.S(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.aVD = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.aVD = null;
    }

    public int DH() {
        if (this.aVC == null) {
            return -1;
        }
        return this.aVC.DH();
    }

    public com.baidu.swan.apps.framework.c DI() {
        return this.aVC;
    }

    public synchronized boolean DJ() {
        boolean z;
        if (!isDestroyed() && this.aVC != null) {
            z = this.aVC.PX().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0185a.aiapps_slide_in_from_right, a.C0185a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.aVJ != null) {
            this.aVJ.adN();
        }
        this.aVH = true;
        com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
        ZP.c(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (ZP.Yw() && com.baidu.swan.apps.x.b.d.I(intent)) {
            ZP.ZM().DR().ij("1250000000000000");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aVC == null || !this.aVC.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.aVF == null) {
            this.aVF = new ActivityResultDispatcher(this, 1);
        }
        return this.aVF;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0271a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a DK() {
        if (this.aVL == null) {
            this.aVL = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.aVL;
    }

    public com.baidu.swan.apps.view.c DL() {
        return this.aVK;
    }

    public void DM() {
        if (this.aVH) {
            this.aVG = "schema";
        } else {
            this.aVG = "user";
        }
    }

    public String DN() {
        return this.aVG;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.aVJ != null) {
            this.aVJ.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.ZP().Yw()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.ZP().c(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.ZP().Yw() && com.baidu.swan.apps.x.b.d.I(intent)) {
                com.baidu.swan.apps.runtime.d.ZP().ZM().ZV().ij("1250000000000000");
            }
        }
        DM();
        super.onResume();
        if (this.aVI == null) {
            this.aVI = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.ZP().bKc = i;
                }
            };
        }
        this.aVI.enable();
        if (this.aVJ != null) {
            this.aVJ.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.aVH = false;
        this.aVI.disable();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        a(FrameLifeState.JUST_CREATED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.Gl().Gm().Gk().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.aVE = frameLifeState;
        DO();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.aVC != null && !this.aVC.PI()) {
            this.aVC.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void DO() {
        b(this.aVE);
    }

    public com.baidu.swan.apps.core.d.e DP() {
        if (this.aVC == null) {
            return null;
        }
        return this.aVC.DP();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.ZP().f(this.aVM);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.aVI = null;
        DQ();
        if (this.aVD != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.w.a.RN().FN();
        if (this.aVJ != null) {
            this.aVJ.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.ZP().k(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.x.c.a iu = com.baidu.swan.apps.x.c.a.iu(com.baidu.swan.apps.runtime.d.ZP().getAppId());
        iu.Tw().TD();
        iu.Tx();
        com.baidu.swan.apps.runtime.d.ZP().r(new String[0]);
        super.onDestroy();
    }

    public synchronized void DQ() {
        if (this.aVK != null) {
            this.aVK.GO();
            this.aVK = null;
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.core.d.e DP = DP();
        if (DP != null) {
            DP.LF().U(0, 0).LL().LN();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.aVC != null) {
            this.aVC.d(FrameLifeState.INACTIVATED);
            this.aVC.release();
            this.aVC = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (DJ()) {
            this.aVC.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        if (!DJ() || com.baidu.swan.apps.runtime.d.ZP().ZM().ZW()) {
            com.baidu.swan.apps.statistic.f.acn();
            Eb();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            overridePendingTransition(0, a.C0185a.aiapps_slide_out_to_right_zadjustment_top);
            return z2;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
                return z2;
            }
            return z2;
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    public b.a DR() {
        if (this.aVC == null) {
            return null;
        }
        return this.aVC.DR();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.aVC != null) {
            this.aVC.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.aVC != null) {
            this.aVC.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0353a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.aVC != null && !this.aVC.b(i, strArr, iArr)) {
            a(i, strArr, iArr);
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.aVC != null) {
            this.aVC.showLoadingView();
        }
    }

    public void DS() {
        if (this.aVC != null) {
            this.aVC.DS();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (DJ()) {
            this.aVC.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ao.g.c
    public com.baidu.swan.apps.ao.g.b DT() {
        if (this.aVC == null) {
            return null;
        }
        return this.aVC.DT();
    }

    public boolean isLandScape() {
        return this.aVC != null && this.aVC.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.aVC != null) {
            this.aVC.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.aVC != null) {
            this.aVC.b(bVar);
        }
    }

    @UiThread
    public void dA(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.w.a.RN().a(this, i, DR());
    }

    public void DU() {
        if (this.aVK == null) {
            this.aVK = new com.baidu.swan.apps.view.c(this);
        }
        b.a ZV = com.baidu.swan.apps.runtime.d.ZP().ZM().ZV();
        Q(ZV.getOrientation(), ZV.getAppFrameType());
        this.aVK.dX(1 == ZV.getAppFrameType());
    }

    public void DV() {
        int i = 2;
        if (DR() != null && DR().getOrientation() == 1) {
            i = 3;
        }
        if (DL() != null) {
            DL().gT(i);
        }
    }

    private void DW() {
        this.aVM.a(new com.baidu.swan.apps.as.d.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.c
            /* renamed from: b */
            public Boolean C(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(i.a aVar) {
                SwanAppActivity.this.DZ();
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(i.a aVar) {
                SwanAppActivity.this.DX();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(i.a aVar) {
                SwanAppActivity.this.DO();
            }
        }, "event_first_action_launched");
        g.Uk().Ul();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.x.b.a.c cVar) {
        if (DY() && cVar.containsKey(" event_params_installer_progress")) {
            this.aVK.X(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.ZP().ZM().available()) {
                bE(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.Eb();
                    }
                }, aVA);
            }
        }
    }

    private boolean DY() {
        return (this.aVK == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.a.c cVar) {
        if (DY()) {
            this.aVK.mI(cVar.getString("app_icon_url"));
            this.aVK.mJ(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DZ() {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        DU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.x.b.a.c cVar) {
        if (this.aVC != null && this.aVC.Qk()) {
            bE("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void m(String... strArr) {
        DQ();
        HashSet dip = strArr == null ? com.facebook.common.internal.i.dip() : com.facebook.common.internal.i.K(strArr);
        if (dip.contains("flag_finish_activity")) {
            if (dip.contains("flag_remove_task")) {
                Eb();
            } else {
                finish();
            }
        }
    }

    public String Ea() {
        return this.aVC == null ? "" : this.aVC.bqF;
    }

    public boolean eI(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, Ea());
    }

    private synchronized void bE(boolean z) {
        com.baidu.swan.apps.runtime.e ZM = com.baidu.swan.apps.runtime.d.ZP().ZM();
        if (ZM.available() && (eI(ZM.getAppId()) || a(ZM))) {
            this.aVC.a(this.aVE, z);
            Ec();
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.aVC != null) {
            DQ();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.x.a.a.a(this, new com.baidu.swan.apps.ap.a().aB(5L).aC(11L).mg("can not buildFramework"), eVar.DH(), eVar.id);
            Eb();
            z = false;
        } else {
            this.aVC = a;
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Rw().Fo();
                }
            }, "updateMobStat");
            Q(eVar.ZV().getOrientation(), eVar.DH());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eb() {
        com.baidu.swan.apps.as.c.R(this);
    }

    private void Ec() {
        com.baidu.swan.apps.runtime.e ZM = com.baidu.swan.apps.runtime.d.ZP().ZM();
        if (ZM != null) {
            String Tp = ZM.DR().Tp();
            com.baidu.swan.apps.x.c.a iu = com.baidu.swan.apps.x.c.a.iu(ZM.DR().Tp());
            iu.iv("appId: " + ZM.id + "  launchId: " + Tp).TE();
            iu.Tx();
        }
    }
}
