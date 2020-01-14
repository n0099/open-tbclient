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
/* loaded from: classes10.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ao.f.c, a.InterfaceC0273a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String aWr = SwanAppActivity.class.getName();
    private static final long aWs = TimeUnit.SECONDS.toMillis(1);
    private static final long aWt = TimeUnit.SECONDS.toMillis(5);
    OrientationEventListener aWA;
    private com.baidu.swan.apps.as.b aWB;
    protected com.baidu.swan.apps.view.c aWC;
    private com.baidu.swan.apps.res.widget.floatlayer.a aWD;
    private com.baidu.swan.apps.framework.c aWu;
    private Messenger aWv;
    private ActivityResultDispatcher aWx;
    private FrameLifeState aWw = FrameLifeState.INACTIVATED;
    private String aWy = "sys";
    private boolean aWz = false;
    private final com.baidu.swan.apps.runtime.b aWE = new com.baidu.swan.apps.runtime.b();

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0187a.aiapps_slide_in_from_right, a.C0187a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.w.a.Sy().Gg();
        com.baidu.swan.apps.process.messaging.client.a.YF().YH();
        this.aWz = true;
        e.ga(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!r.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                bundle2.setClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (D(intent)) {
                Ex();
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
            Es();
            com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
            aam.j(this);
            aam.e(this.aWE);
            boolean I = com.baidu.swan.apps.x.b.d.I(intent);
            if (intent != null && (I || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aam.c(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aam.YT() && I) {
                aam.aaj().aas().im("1250000000000000");
            }
            af.W(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.aWB = new com.baidu.swan.apps.as.b(this);
            }
            if (this.aWB != null) {
                this.aWB.setCanSlide(false);
            }
            if (this.aWB != null) {
                this.aWB.onCreate();
            }
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.RS().FJ();
                }
            }, "initMobStat");
            ah.aeL();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.aWB != null) {
            this.aWB.aef();
        }
    }

    public com.baidu.swan.apps.as.b Ec() {
        return this.aWB;
    }

    private boolean D(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(aWr)) ? false : true;
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
            com.baidu.swan.apps.as.c.T(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.aWv = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.aWv = null;
    }

    public int Ed() {
        if (this.aWu == null) {
            return -1;
        }
        return this.aWu.Ed();
    }

    public com.baidu.swan.apps.framework.c Ee() {
        return this.aWu;
    }

    public synchronized boolean Ef() {
        boolean z;
        if (!isDestroyed() && this.aWu != null) {
            z = this.aWu.Qt().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0187a.aiapps_slide_in_from_right, a.C0187a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.aWB != null) {
            this.aWB.aeg();
        }
        this.aWz = true;
        com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
        aam.c(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aam.YT() && com.baidu.swan.apps.x.b.d.I(intent)) {
            aam.aaj().En().im("1250000000000000");
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.aWu == null || !this.aWu.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.aWx == null) {
            this.aWx = new ActivityResultDispatcher(this, 1);
        }
        return this.aWx;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0273a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a Eg() {
        if (this.aWD == null) {
            this.aWD = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.aWD;
    }

    public com.baidu.swan.apps.view.c Eh() {
        return this.aWC;
    }

    public void Ei() {
        if (this.aWz) {
            this.aWy = "schema";
        } else {
            this.aWy = "user";
        }
    }

    public String Ej() {
        return this.aWy;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        if (this.aWB != null) {
            this.aWB.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aam().YT()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aam().c(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aam().YT() && com.baidu.swan.apps.x.b.d.I(intent)) {
                com.baidu.swan.apps.runtime.d.aam().aaj().aas().im("1250000000000000");
            }
        }
        Ei();
        super.onResume();
        if (this.aWA == null) {
            this.aWA = new OrientationEventListener(this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.4
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i) {
                    com.baidu.swan.apps.runtime.d.aam().bKM = i;
                }
            };
        }
        this.aWA.enable();
        if (this.aWB != null) {
            this.aWB.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.aWz = false;
        this.aWA.disable();
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
            com.baidu.swan.apps.adaptation.b.a.c.GH().GI().GG().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.aWw = frameLifeState;
        Ek();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.aWu != null && !this.aWu.Qe()) {
            this.aWu.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Ek() {
        b(this.aWw);
    }

    public com.baidu.swan.apps.core.d.e El() {
        if (this.aWu == null) {
            return null;
        }
        return this.aWu.El();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aam().f(this.aWE);
        if (DEBUG) {
            Log.d("SwanAppActivity", "——> onDestroy: ");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onDestroy");
        this.aWA = null;
        Em();
        if (this.aWv != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.w.a.Sj().Gj();
        if (this.aWB != null) {
            this.aWB.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aam().k(this);
        a(FrameLifeState.INACTIVATED);
        f.release();
        com.baidu.swan.apps.x.c.a ix = com.baidu.swan.apps.x.c.a.ix(com.baidu.swan.apps.runtime.d.aam().getAppId());
        ix.TT().Ua();
        ix.TU();
        com.baidu.swan.apps.runtime.d.aam().r(new String[0]);
        super.onDestroy();
    }

    public synchronized void Em() {
        if (this.aWC != null) {
            this.aWC.Hk();
            this.aWC = null;
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.core.d.e El = El();
        if (El != null) {
            El.Mb().Y(0, 0).Mh().Mj();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.aWu != null) {
            this.aWu.d(FrameLifeState.INACTIVATED);
            this.aWu.release();
            this.aWu = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (DEBUG) {
            Log.d("SwanAppActivity", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onBackPressed");
        if (Ef()) {
            this.aWu.onBackPressed();
        } else {
            moveTaskToBack(true);
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2 = false;
        if (!Ef() || com.baidu.swan.apps.runtime.d.aam().aaj().aat()) {
            com.baidu.swan.apps.statistic.f.acK();
            Ex();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            overridePendingTransition(0, a.C0187a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a En() {
        if (this.aWu == null) {
            return null;
        }
        return this.aWu.En();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.aWu != null) {
            this.aWu.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (this.aWu != null) {
            this.aWu.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0355a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.aWu != null && !this.aWu.b(i, strArr, iArr)) {
            a(i, strArr, iArr);
        }
    }

    public void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void showLoadingView() {
        if (this.aWu != null) {
            this.aWu.showLoadingView();
        }
    }

    public void Eo() {
        if (this.aWu != null) {
            this.aWu.Eo();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (Ef()) {
            this.aWu.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ao.f.c
    public com.baidu.swan.apps.ao.f.b Ep() {
        if (this.aWu == null) {
            return null;
        }
        return this.aWu.Ep();
    }

    public boolean isLandScape() {
        return this.aWu != null && this.aWu.isLandScape();
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.aWu != null) {
            this.aWu.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.aWu != null) {
            this.aWu.b(bVar);
        }
    }

    @UiThread
    public void dB(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.w.a.Sj().a(this, i, En());
    }

    public void Eq() {
        if (this.aWC == null) {
            this.aWC = new com.baidu.swan.apps.view.c(this);
        }
        b.a aas = com.baidu.swan.apps.runtime.d.aam().aaj().aas();
        U(aas.getOrientation(), aas.getAppFrameType());
        this.aWC.ec(1 == aas.getAppFrameType());
    }

    public void Er() {
        int i = 2;
        if (En() != null && En().getOrientation() == 1) {
            i = 3;
        }
        if (Eh() != null) {
            Eh().gT(i);
        }
    }

    private void Es() {
        this.aWE.a(new com.baidu.swan.apps.as.d.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
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
                SwanAppActivity.this.Ev();
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
                SwanAppActivity.this.Et();
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
                SwanAppActivity.this.Ek();
            }
        }, "event_first_action_launched");
        g.UH().UI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.x.b.a.c cVar) {
        if (Eu() && cVar.containsKey(" event_params_installer_progress")) {
            this.aWC.W(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aam().aaj().available()) {
                bJ(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.Ex();
                    }
                }, aWs);
            }
        }
    }

    private boolean Eu() {
        return (this.aWC == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.a.c cVar) {
        if (Eu()) {
            this.aWC.mL(cVar.getString("app_icon_url"));
            this.aWC.mM(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ev() {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        Eq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.x.b.a.c cVar) {
        if (this.aWu != null && this.aWu.QG()) {
            bJ("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void m(String... strArr) {
        Em();
        HashSet djs = strArr == null ? com.facebook.common.internal.i.djs() : com.facebook.common.internal.i.K(strArr);
        if (djs.contains("flag_finish_activity")) {
            if (djs.contains("flag_remove_task")) {
                Ex();
            } else {
                finish();
            }
        }
    }

    public String Ew() {
        return this.aWu == null ? "" : this.aWu.brt;
    }

    public boolean eL(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, Ew());
    }

    private synchronized void bJ(boolean z) {
        com.baidu.swan.apps.runtime.e aaj = com.baidu.swan.apps.runtime.d.aam().aaj();
        if (aaj.available() && (eL(aaj.getAppId()) || a(aaj))) {
            this.aWu.a(this.aWw, z);
            Ey();
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.aWu != null) {
            Em();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.x.a.a.a(this, new com.baidu.swan.apps.ap.a().aE(5L).aF(11L).mj("can not buildFramework"), eVar.Ed(), eVar.id);
            Ex();
            z = false;
        } else {
            this.aWu = a;
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.w.a.RS().FK();
                }
            }, "updateMobStat");
            U(eVar.aas().getOrientation(), eVar.Ed());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ex() {
        com.baidu.swan.apps.as.c.S(this);
    }

    private void Ey() {
        com.baidu.swan.apps.runtime.e aaj = com.baidu.swan.apps.runtime.d.aam().aaj();
        if (aaj != null) {
            String TM = aaj.En().TM();
            com.baidu.swan.apps.x.c.a ix = com.baidu.swan.apps.x.c.a.ix(aaj.En().TM());
            ix.iy("appId: " + aaj.id + "  launchId: " + TM).Ub();
            ix.TU();
        }
    }
}
