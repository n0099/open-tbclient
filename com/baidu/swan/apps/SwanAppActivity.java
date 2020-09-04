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
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.d;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.ap.o;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.al.f.c, a.InterfaceC0432a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String bRy = SwanAppActivity.class.getName();
    private static final long bRz = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c bRA;
    private Messenger bRB;
    private ActivityResultDispatcher bRD;
    @Nullable
    private com.baidu.swan.apps.ap.b bRE;
    OrientationEventListener bRG;
    private d bRH;
    protected com.baidu.swan.apps.view.c bRI;
    private com.baidu.swan.apps.res.widget.floatlayer.a bRJ;
    private boolean mIsBackground;
    private FrameLifeState bRC = FrameLifeState.INACTIVATED;
    private String bRF = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b bRK = new com.baidu.swan.apps.runtime.b();
    private boolean bRL = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0331a.aiapps_slide_in_from_right, a.C0331a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.apD().aax();
        com.baidu.swan.apps.process.messaging.client.a.axC().axE();
        this.mIsFromSchema = true;
        g.ju(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.alv());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                Yh();
                return;
            }
            d.C0396d.s(intent);
            com.baidu.swan.games.utils.so.d.z(intent);
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
            com.baidu.swan.apps.console.c.d("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
            com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onCreate");
            setContentView(a.g.aiapps_activity);
            Yd();
            com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
            azE.j(this);
            azE.v(this.bRK);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                azE.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (azE.axR() && v) {
                azE.azA().azM().nF("1250000000000000");
            }
            ah.Q(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.bRH = new com.baidu.swan.apps.ap.d(this);
            }
            if (this.bRH != null) {
                this.bRH.setCanSlide(false);
            }
            if (this.bRH != null) {
                this.bRH.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.aoV().aaj();
                    o.N(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.bRL = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.bRH != null) {
            this.bRH.aEu();
        }
    }

    public com.baidu.swan.apps.ap.d XO() {
        return this.bRH;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(bRy)) ? false : true;
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
            bundle.putInt("swan_key_save_task_id", getTaskId());
        }
    }

    private void ad(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            e.L(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.bRB = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.bRB = null;
    }

    public int XP() {
        if (this.bRA == null) {
            return -1;
        }
        return this.bRA.XP();
    }

    public com.baidu.swan.apps.framework.c XQ() {
        return this.bRA;
    }

    public synchronized boolean XR() {
        boolean z;
        if (!isDestroyed() && this.bRA != null) {
            z = this.bRA.ana().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0331a.aiapps_slide_in_from_right, a.C0331a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.bRH != null) {
            this.bRH.aEv();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
        azE.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (azE.axR() && com.baidu.swan.apps.u.c.d.v(intent)) {
            azE.azA().XZ().nF("1250000000000000");
        }
        if (this.bRE != null) {
            this.bRE.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.bRA == null || !this.bRA.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.bRD == null) {
            this.bRD = new ActivityResultDispatcher(this, 1);
        }
        return this.bRD;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0432a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a XS() {
        if (this.bRJ == null) {
            this.bRJ = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.bRJ;
    }

    public com.baidu.swan.apps.view.c XT() {
        return this.bRI;
    }

    public void XU() {
        if (this.mIsFromSchema) {
            this.bRF = "schema";
        } else {
            this.bRF = "user";
        }
    }

    public String XV() {
        return this.bRF;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.bRH != null) {
            this.bRH.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.azE().axR()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.azE().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.azE().axR() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.azE().azA().azM().nF("1250000000000000");
            }
        }
        XU();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.bRG == null) {
                    SwanAppActivity.this.bRG = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.azE().cPZ = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.bRG.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.bRH != null) {
            this.bRH.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aFx().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.bRG != null) {
            this.bRG.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!XR()) {
            i.avT();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.ak.a.aCf().aCk();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.apL().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.abd().abe().abc().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.bRC = frameLifeState;
        XW();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.bRA != null && !this.bRA.amK()) {
            this.bRA.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void XW() {
        b(this.bRC);
    }

    @Nullable
    public f XX() {
        if (this.bRA == null) {
            return null;
        }
        return this.bRA.XX();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.azE().w(this.bRK);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.bRG = null;
        XY();
        if (this.bRB != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.apo().aaA();
        if (this.bRH != null) {
            this.bRH.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.azE().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.azE().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a nR = com.baidu.swan.apps.u.e.a.nR(appId);
            nR.aro().aru();
            nR.arp();
        }
        com.baidu.swan.apps.runtime.d.azE().w(new String[0]);
        this.bRE = null;
        super.onDestroy();
    }

    public synchronized void XY() {
        if (this.bRI != null) {
            this.bRI.abG();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aFS();
        com.baidu.swan.apps.view.c.cQ(com.baidu.swan.apps.t.a.aoJ());
        f XX = XX();
        if (XX != null) {
            XX.ahq().al(0, 0).ahv().ahx();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.bRA != null) {
            this.bRA.d(FrameLifeState.INACTIVATED);
            this.bRA.release();
            this.bRA = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e azA = com.baidu.swan.apps.runtime.d.azE().azA();
        azA.azU().aBq();
        azA.azV().clear();
        com.baidu.swan.apps.setting.b.a.aCe();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (XR()) {
            this.bRA.onBackPressed();
            return;
        }
        HybridUbcFlow avT = i.avT();
        if (avT != null) {
            avT.r("value", "cancel");
            avT.bW("exitType", String.valueOf(4));
            avT.avy();
        }
        com.baidu.swan.apps.v.g.ash().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a XZ = XZ();
        boolean z3 = XZ != null && "1230000000000000".equals(XZ.aqN());
        if (this.bRE != null && !z3) {
            this.bRE.ga(false);
        }
        if (!XR() || com.baidu.swan.apps.runtime.d.azE().azA().azN()) {
            h.aCE();
            Yh();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0331a.aiapps_slide_out_to_right_zadjustment_top);
                return z2;
            } catch (Exception e2) {
                e = e2;
                if (DEBUG) {
                    e.printStackTrace();
                    return z2;
                }
                return z2;
            }
        } catch (Exception e3) {
            z2 = false;
            e = e3;
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    public b.a XZ() {
        if (this.bRA == null) {
            return null;
        }
        return this.bRA.XZ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.bRA != null) {
            this.bRA.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.bRA != null) {
            this.bRA.showLoadingView();
        }
    }

    public void Ya() {
        if (this.bRA != null) {
            this.bRA.Ya();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (XR()) {
            this.bRA.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.al.f.c
    public com.baidu.swan.apps.al.f.b Yb() {
        if (this.bRA == null) {
            return null;
        }
        return this.bRA.Yb();
    }

    public boolean isLandScape() {
        return this.bRA != null && this.bRA.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.bRA != null) {
            this.bRA.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.bRA != null) {
            this.bRA.b(bVar);
        }
    }

    @UiThread
    public void gn(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.apo().a(this, i, XZ());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.bRI == null) {
            this.bRI = new com.baidu.swan.apps.view.c(this);
        }
        this.bRI.a(1 == com.baidu.swan.apps.runtime.d.azE().azA().azM().getAppFrameType(), z, aVar);
    }

    public void Yc() {
        int i = 2;
        if (XZ() != null && XZ().getOrientation() == 1) {
            i = 3;
        }
        if (XT() != null) {
            XT().ku(i);
        }
    }

    private void Yd() {
        this.bRK.a(new com.baidu.swan.apps.ap.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.c
            /* renamed from: c */
            public Boolean J(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(i.a aVar) {
                SwanAppActivity.this.a(true, aVar);
            }
        }, "event_on_still_maintaining").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(i.a aVar) {
                SwanAppActivity.this.Ye();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(i.a aVar) {
                SwanAppActivity.this.a((com.baidu.swan.apps.u.c.a.c) aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(i.a aVar) {
                SwanAppActivity.this.XW();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.ash().asi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (Yf() && cVar.containsKey(" event_params_installer_progress")) {
            this.bRI.L(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ye() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.azE().azA().available()) {
                dq(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.Yh();
                    }
                }, bRz);
            }
        }
    }

    private boolean Yf() {
        return (this.bRI == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (Yf()) {
            this.bRI.sV(cVar.getString("app_icon_url"));
            this.bRI.iH(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a azM = com.baidu.swan.apps.runtime.d.azE().azA().azM();
        ad(azM.getOrientation(), azM.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + azM.akO() + " appId: " + azM.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.bRA != null && this.bRA.anm()) {
            dq("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void o(String... strArr) {
        XY();
        HashSet dOG = strArr == null ? com.facebook.common.internal.i.dOG() : com.facebook.common.internal.i.N(strArr);
        if (dOG.contains("flag_finish_activity")) {
            if (dOG.contains("flag_remove_task")) {
                Yh();
            } else {
                finish();
            }
        }
    }

    public String Yg() {
        return this.bRA == null ? "" : this.bRA.cst;
    }

    public boolean iy(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, Yg());
    }

    private synchronized void dq(boolean z) {
        com.baidu.swan.apps.runtime.e azA = com.baidu.swan.apps.runtime.d.azE().azA();
        if (azA.available() && (iy(azA.getAppId()) || a(azA))) {
            this.bRA.a(this.bRC, z);
            if (DEBUG) {
                Yi();
            }
            if (this.bRE == null && com.baidu.swan.apps.ap.b.aEn()) {
                this.bRE = com.baidu.swan.apps.ap.b.aEm();
                if (!this.bRL) {
                    this.bRE.a(XZ(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.bRA != null) {
            XY();
        }
        com.baidu.swan.apps.framework.c a = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.am.a().bO(5L).bP(11L).sl("can not buildFramework"), eVar.XP(), eVar.id);
            Yh();
            z = false;
        } else {
            this.bRA = a;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.aoV().aak();
                }
            }, "updateMobStat");
            ad(eVar.azM().getOrientation(), eVar.XP());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh() {
        e.K(this);
    }

    private void Yi() {
        com.baidu.swan.apps.runtime.e azA = com.baidu.swan.apps.runtime.d.azE().azA();
        if (azA != null) {
            String arg = azA.XZ().arg();
            com.baidu.swan.apps.u.e.a nR = com.baidu.swan.apps.u.e.a.nR(azA.XZ().arg());
            nR.nS("appId: " + azA.id + "  launchId: " + arg).arv();
            nR.arp();
        }
    }
}
