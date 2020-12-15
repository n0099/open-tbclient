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
/* loaded from: classes25.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.al.f.c, a.InterfaceC0480a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String czt = SwanAppActivity.class.getName();
    private static final long czu = TimeUnit.SECONDS.toMillis(1);
    OrientationEventListener czB;
    private d czC;
    protected com.baidu.swan.apps.view.c czD;
    private com.baidu.swan.apps.res.widget.floatlayer.a czE;
    private com.baidu.swan.apps.framework.c czv;
    private Messenger czw;
    private ActivityResultDispatcher czy;
    @Nullable
    private com.baidu.swan.apps.ap.b czz;
    private boolean mIsBackground;
    private FrameLifeState czx = FrameLifeState.INACTIVATED;
    private String czA = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b czF = new com.baidu.swan.apps.runtime.b();
    private boolean czG = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0379a.aiapps_slide_in_from_right, a.C0379a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.azT().akM();
        com.baidu.swan.apps.process.messaging.client.a.aHO().aHQ();
        this.mIsFromSchema = true;
        g.kR(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.avM());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                aiw();
                return;
            }
            d.C0444d.s(intent);
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
            ais();
            com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
            aJQ.j(this);
            aJQ.v(this.czF);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aJQ.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aJQ.aId() && v) {
                aJQ.aJM().aJY().pU("1250000000000000");
            }
            ah.S(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.czC = new com.baidu.swan.apps.ap.d(this);
            }
            if (this.czC != null) {
                this.czC.setCanSlide(false);
            }
            if (this.czC != null) {
                this.czC.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.azm().aky();
                    o.P(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.czG = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.czC != null) {
            this.czC.aOG();
        }
    }

    public com.baidu.swan.apps.ap.d aid() {
        return this.czC;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(czt)) ? false : true;
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

    private void af(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            e.N(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.czw = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.czw = null;
    }

    public int aie() {
        if (this.czv == null) {
            return -1;
        }
        return this.czv.aie();
    }

    public com.baidu.swan.apps.framework.c aif() {
        return this.czv;
    }

    public synchronized boolean aig() {
        boolean z;
        if (!isDestroyed() && this.czv != null) {
            z = this.czv.axr().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0379a.aiapps_slide_in_from_right, a.C0379a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.czC != null) {
            this.czC.aOH();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        aJQ.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aJQ.aId() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aJQ.aJM().aio().pU("1250000000000000");
        }
        if (this.czz != null) {
            this.czz.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.czv == null || !this.czv.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.czy == null) {
            this.czy = new ActivityResultDispatcher(this, 1);
        }
        return this.czy;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0480a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a aih() {
        if (this.czE == null) {
            this.czE = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.czE;
    }

    public com.baidu.swan.apps.view.c aii() {
        return this.czD;
    }

    public void aij() {
        if (this.mIsFromSchema) {
            this.czA = "schema";
        } else {
            this.czA = "user";
        }
    }

    public String aik() {
        return this.czA;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.czC != null) {
            this.czC.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aJQ().aId()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aJQ().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aJQ().aId() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().pU("1250000000000000");
            }
        }
        aij();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.czB == null) {
                    SwanAppActivity.this.czB = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aJQ().dxV = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.czB.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.czC != null) {
            this.czC.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aPI().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.czB != null) {
            this.czB.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!aig()) {
            i.aGh();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.ak.a.aMs().aMx();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.aAb().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.als().alt().alr().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.czx = frameLifeState;
        ail();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.czv != null && !this.czv.axb()) {
            this.czv.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ail() {
        b(this.czx);
    }

    @Nullable
    public f aim() {
        if (this.czv == null) {
            return null;
        }
        return this.czv.aim();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aJQ().w(this.czF);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.czB = null;
        ain();
        if (this.czw != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.azE().akP();
        if (this.czC != null) {
            this.czC.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aJQ().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aJQ().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a qg = com.baidu.swan.apps.u.e.a.qg(appId);
            qg.aBF().aBL();
            qg.aBG();
        }
        com.baidu.swan.apps.runtime.d.aJQ().y(new String[0]);
        this.czz = null;
        super.onDestroy();
    }

    public synchronized void ain() {
        if (this.czD != null) {
            this.czD.alV();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aQd();
        com.baidu.swan.apps.view.c.dB(com.baidu.swan.apps.t.a.aza());
        f aim = aim();
        if (aim != null) {
            aim.arF().an(0, 0).arK().arM();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.czv != null) {
            this.czv.d(FrameLifeState.INACTIVATED);
            this.czv.release();
            this.czv = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aJM = com.baidu.swan.apps.runtime.d.aJQ().aJM();
        aJM.aKg().aLD();
        aJM.aKh().clear();
        com.baidu.swan.apps.setting.b.a.aMr();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (aig()) {
            this.czv.onBackPressed();
            return;
        }
        HybridUbcFlow aGh = i.aGh();
        if (aGh != null) {
            aGh.q("value", "cancel");
            aGh.co("exitType", String.valueOf(4));
            aGh.aFM();
        }
        com.baidu.swan.apps.v.g.aCy().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a aio = aio();
        boolean z3 = aio != null && "1230000000000000".equals(aio.aBe());
        if (this.czz != null && !z3) {
            this.czz.hi(false);
        }
        if (!aig() || com.baidu.swan.apps.runtime.d.aJQ().aJM().aJZ()) {
            h.aMQ();
            aiw();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0379a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a aio() {
        if (this.czv == null) {
            return null;
        }
        return this.czv.aio();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.czv != null) {
            this.czv.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.czv != null) {
            this.czv.showLoadingView();
        }
    }

    public void aip() {
        if (this.czv != null) {
            this.czv.aip();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (aig()) {
            this.czv.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.al.f.c
    public com.baidu.swan.apps.al.f.b aiq() {
        if (this.czv == null) {
            return null;
        }
        return this.czv.aiq();
    }

    public boolean isLandScape() {
        return this.czv != null && this.czv.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.czv != null) {
            this.czv.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.czv != null) {
            this.czv.b(bVar);
        }
    }

    @UiThread
    public void hJ(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.azE().a(this, i, aio());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.czD == null) {
            this.czD = new com.baidu.swan.apps.view.c(this);
        }
        this.czD.a(1 == com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().getAppFrameType(), z, aVar);
    }

    public void air() {
        int i = 2;
        if (aio() != null && aio().getOrientation() == 1) {
            i = 3;
        }
        if (aii() != null) {
            aii().lR(i);
        }
    }

    private void ais() {
        this.czF.a(new com.baidu.swan.apps.ap.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.c
            /* renamed from: c */
            public Boolean N(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                SwanAppActivity.this.a(true, aVar);
            }
        }, "event_on_still_maintaining").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                SwanAppActivity.this.ait();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                SwanAppActivity.this.a((com.baidu.swan.apps.u.c.a.c) aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void M(i.a aVar) {
                SwanAppActivity.this.ail();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.aCy().aCz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (aiu() && cVar.containsKey(" event_params_installer_progress")) {
            this.czD.Q(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aJQ().aJM().available()) {
                ey(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.aiw();
                    }
                }, czu);
            }
        }
    }

    private boolean aiu() {
        return (this.czD == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (aiu()) {
            this.czD.vj(cVar.getString("app_icon_url"));
            this.czD.kV(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aJY = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY();
        af(aJY.getOrientation(), aJY.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aJY.avf() + " appId: " + aJY.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.czv != null && this.czv.axD()) {
            ey("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        ain();
        HashSet epQ = strArr == null ? com.facebook.common.internal.i.epQ() : com.facebook.common.internal.i.N(strArr);
        if (epQ.contains("flag_finish_activity")) {
            if (epQ.contains("flag_remove_task")) {
                aiw();
            } else {
                finish();
            }
        }
    }

    public String aiv() {
        return this.czv == null ? "" : this.czv.daf;
    }

    public boolean kM(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, aiv());
    }

    private synchronized void ey(boolean z) {
        com.baidu.swan.apps.runtime.e aJM = com.baidu.swan.apps.runtime.d.aJQ().aJM();
        if (aJM.available() && (kM(aJM.getAppId()) || a(aJM))) {
            this.czv.a(this.czx, z);
            if (DEBUG) {
                aix();
            }
            if (this.czz == null && com.baidu.swan.apps.ap.b.aOz()) {
                this.czz = com.baidu.swan.apps.ap.b.aOy();
                if (!this.czG) {
                    this.czz.a(aio(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.czv != null) {
            ain();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.am.a().cU(5L).cV(11L).uA("can not buildFramework"), eVar.aie(), eVar.id);
            aiw();
            z = false;
        } else {
            this.czv = a2;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.azm().akz();
                }
            }, "updateMobStat");
            af(eVar.aJY().getOrientation(), eVar.aie());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiw() {
        e.M(this);
    }

    private void aix() {
        com.baidu.swan.apps.runtime.e aJM = com.baidu.swan.apps.runtime.d.aJQ().aJM();
        if (aJM != null) {
            String aBx = aJM.aio().aBx();
            com.baidu.swan.apps.u.e.a qg = com.baidu.swan.apps.u.e.a.qg(aJM.aio().aBx());
            qg.qh("appId: " + aJM.id + "  launchId: " + aBx).aBM();
            qg.aBG();
        }
    }
}
