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
/* loaded from: classes11.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ao.f.c, a.InterfaceC0283a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String baF = SwanAppActivity.class.getName();
    private static final long baG = TimeUnit.SECONDS.toMillis(1);
    private static final long baH = TimeUnit.SECONDS.toMillis(5);
    private com.baidu.swan.apps.framework.c baI;
    private Messenger baJ;
    private ActivityResultDispatcher baL;
    OrientationEventListener baN;
    private com.baidu.swan.apps.as.b baO;
    protected com.baidu.swan.apps.view.c baP;
    private com.baidu.swan.apps.res.widget.floatlayer.a baQ;
    private FrameLifeState baK = FrameLifeState.INACTIVATED;
    private String baM = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b baR = new com.baidu.swan.apps.runtime.b();

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0197a.aiapps_slide_in_from_right, a.C0197a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.UO().Ix();
        com.baidu.swan.apps.process.messaging.client.a.aaV().aaX();
        this.mIsFromSchema = true;
        e.gr(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!r.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                bundle2.setClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (D(intent)) {
                GO();
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
            GJ();
            com.baidu.swan.apps.runtime.d acC = com.baidu.swan.apps.runtime.d.acC();
            acC.j(this);
            acC.e(this.baR);
            boolean I = com.baidu.swan.apps.x.b.d.I(intent);
            if (intent != null && (I || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                acC.c(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (acC.abj() && I) {
                acC.acz().acI().iB("1250000000000000");
            }
            af.X(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.baO = new com.baidu.swan.apps.as.b(this);
            }
            if (this.baO != null) {
                this.baO.setCanSlide(false);
            }
            if (this.baO != null) {
                this.baO.onCreate();
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Ui().Ia();
                }
            }, "initMobStat");
            ah.ahb();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.baO != null) {
            this.baO.agv();
        }
    }

    public com.baidu.swan.apps.as.b Gt() {
        return this.baO;
    }

    private boolean D(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(baF)) ? false : true;
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

    private void U(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            com.baidu.swan.apps.as.c.U(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.baJ = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.baJ = null;
    }

    public int Gu() {
        if (this.baI == null) {
            return -1;
        }
        return this.baI.Gu();
    }

    public com.baidu.swan.apps.framework.c Gv() {
        return this.baI;
    }

    public synchronized boolean Gw() {
        boolean z;
        if (!isDestroyed() && this.baI != null) {
            z = this.baI.SJ().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0197a.aiapps_slide_in_from_right, a.C0197a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.baO != null) {
            this.baO.agw();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d acC = com.baidu.swan.apps.runtime.d.acC();
        acC.c(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (acC.abj() && com.baidu.swan.apps.x.b.d.I(intent)) {
            acC.acz().GE().iB("1250000000000000");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.baI == null || !this.baI.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.baL == null) {
            this.baL = new ActivityResultDispatcher(this, 1);
        }
        return this.baL;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0283a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a Gx() {
        if (this.baQ == null) {
            this.baQ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.baQ;
    }

    public com.baidu.swan.apps.view.c Gy() {
        return this.baP;
    }

    public void Gz() {
        if (this.mIsFromSchema) {
            this.baM = "schema";
        } else {
            this.baM = "user";
        }
    }

    public String GA() {
        return this.baM;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.baO != null) {
            this.baO.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.acC().abj()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.acC().c(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.acC().abj() && com.baidu.swan.apps.x.b.d.I(intent)) {
                com.baidu.swan.apps.runtime.d.acC().acz().acI().iB("1250000000000000");
            }
        }
        Gz();
        super.onResume();
        if (this.baN == null) {
            this.baN = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.acC().bOT = i;
                }
            };
        }
        this.baN.enable();
        if (this.baO != null) {
            this.baO.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        this.baN.disable();
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
            com.baidu.swan.apps.adaptation.b.a.c.IY().IZ().IX().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.baK = frameLifeState;
        GB();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.baI != null && !this.baI.Su()) {
            this.baI.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void GB() {
        b(this.baK);
    }

    public com.baidu.swan.apps.core.d.e GC() {
        if (this.baI == null) {
            return null;
        }
        return this.baI.GC();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.acC().f(this.baR);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.baN = null;
        GD();
        if (this.baJ != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.w.a.Uz().IA();
        if (this.baO != null) {
            this.baO.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.acC().k(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(com.baidu.swan.apps.runtime.d.acC().getAppId());
        iM.Wj().Wq();
        iM.Wk();
        com.baidu.swan.apps.runtime.d.acC().v(new String[0]);
        super.onDestroy();
    }

    public synchronized void GD() {
        if (this.baP != null) {
            this.baP.JB();
            this.baP = null;
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.core.d.e GC = GC();
        if (GC != null) {
            GC.Or().Y(0, 0).Ox().Oz();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.baI != null) {
            this.baI.d(FrameLifeState.INACTIVATED);
            this.baI.release();
            this.baI = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (Gw()) {
            this.baI.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        if (!Gw() || com.baidu.swan.apps.runtime.d.acC().acz().acJ()) {
            com.baidu.swan.apps.statistic.f.afa();
            GO();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            overridePendingTransition(0, a.C0197a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a GE() {
        if (this.baI == null) {
            return null;
        }
        return this.baI.GE();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.baI != null) {
            this.baI.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.baI != null) {
            this.baI.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0365a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.baI != null && !this.baI.onRequestPermissionsResult(i, strArr, iArr)) {
            a(i, strArr, iArr);
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.baI != null) {
            this.baI.showLoadingView();
        }
    }

    public void GF() {
        if (this.baI != null) {
            this.baI.GF();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (Gw()) {
            this.baI.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ao.f.c
    public com.baidu.swan.apps.ao.f.b GG() {
        if (this.baI == null) {
            return null;
        }
        return this.baI.GG();
    }

    public boolean isLandScape() {
        return this.baI != null && this.baI.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.baI != null) {
            this.baI.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.baI != null) {
            this.baI.b(bVar);
        }
    }

    @UiThread
    public void dR(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.w.a.Uz().a(this, i, GE());
    }

    public void GH() {
        if (this.baP == null) {
            this.baP = new com.baidu.swan.apps.view.c(this);
        }
        b.a acI = com.baidu.swan.apps.runtime.d.acC().acz().acI();
        U(acI.getOrientation(), acI.getAppFrameType());
        this.baP.ej(1 == acI.getAppFrameType());
    }

    public void GI() {
        int i = 2;
        if (GE() != null && GE().getOrientation() == 1) {
            i = 3;
        }
        if (Gy() != null) {
            Gy().hk(i);
        }
    }

    private void GJ() {
        this.baR.a(new com.baidu.swan.apps.as.d.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.c
            /* renamed from: b */
            public Boolean E(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.GM();
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.GK();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.as.d.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(i.a aVar) {
                SwanAppActivity.this.GB();
            }
        }, "event_first_action_launched");
        g.WX().WY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.x.b.a.c cVar) {
        if (GL() && cVar.containsKey(" event_params_installer_progress")) {
            this.baP.W(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.acC().acz().available()) {
                bR(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.GO();
                    }
                }, baG);
            }
        }
    }

    private boolean GL() {
        return (this.baP == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.a.c cVar) {
        if (GL()) {
            this.baP.na(cVar.getString("app_icon_url"));
            this.baP.nb(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        GH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.x.b.a.c cVar) {
        if (this.baI != null && this.baI.SW()) {
            bR("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        GD();
        HashSet dkI = strArr == null ? com.facebook.common.internal.i.dkI() : com.facebook.common.internal.i.K(strArr);
        if (dkI.contains("flag_finish_activity")) {
            if (dkI.contains("flag_remove_task")) {
                GO();
            } else {
                finish();
            }
        }
    }

    public String GN() {
        return this.baI == null ? "" : this.baI.bvF;
    }

    public boolean fa(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, GN());
    }

    private synchronized void bR(boolean z) {
        com.baidu.swan.apps.runtime.e acz = com.baidu.swan.apps.runtime.d.acC().acz();
        if (acz.available() && (fa(acz.getAppId()) || a(acz))) {
            this.baI.a(this.baK, z);
            GP();
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.baI != null) {
            GD();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.x.a.a.a(this, new com.baidu.swan.apps.ap.a().aI(5L).aJ(11L).my("can not buildFramework"), eVar.Gu(), eVar.id);
            GO();
            z = false;
        } else {
            this.baI = a;
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.Ui().Ib();
                }
            }, "updateMobStat");
            U(eVar.acI().getOrientation(), eVar.Gu());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO() {
        com.baidu.swan.apps.as.c.T(this);
    }

    private void GP() {
        com.baidu.swan.apps.runtime.e acz = com.baidu.swan.apps.runtime.d.acC().acz();
        if (acz != null) {
            String Wc = acz.GE().Wc();
            com.baidu.swan.apps.x.c.a iM = com.baidu.swan.apps.x.c.a.iM(acz.GE().Wc());
            iM.iN("appId: " + acz.id + "  launchId: " + Wc).Wr();
            iM.Wk();
        }
    }
}
