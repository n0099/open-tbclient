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
/* loaded from: classes10.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.al.f.c, a.InterfaceC0458a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String col = SwanAppActivity.class.getName();

    /* renamed from: com  reason: collision with root package name */
    private static final long f3668com = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c coo;
    private Messenger cop;
    private ActivityResultDispatcher cor;
    @Nullable
    private com.baidu.swan.apps.ap.b cos;
    OrientationEventListener cou;
    private d cov;
    protected com.baidu.swan.apps.view.c cow;
    private com.baidu.swan.apps.res.widget.floatlayer.a cox;
    private boolean mIsBackground;
    private FrameLifeState coq = FrameLifeState.INACTIVATED;
    private String cot = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b coy = new com.baidu.swan.apps.runtime.b();
    private boolean coz = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0357a.aiapps_slide_in_from_right, a.C0357a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.auT().afM();
        com.baidu.swan.apps.process.messaging.client.a.aCO().aCQ();
        this.mIsFromSchema = true;
        g.kn(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.aqL());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                adw();
                return;
            }
            d.C0422d.s(intent);
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
            ads();
            com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
            aEQ.j(this);
            aEQ.v(this.coy);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aEQ.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aEQ.aDd() && v) {
                aEQ.aEM().aEY().pf("1250000000000000");
            }
            ah.T(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.cov = new com.baidu.swan.apps.ap.d(this);
            }
            if (this.cov != null) {
                this.cov.setCanSlide(false);
            }
            if (this.cov != null) {
                this.cov.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.aum().afy();
                    o.Q(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.coz = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.cov != null) {
            this.cov.aJH();
        }
    }

    public com.baidu.swan.apps.ap.d add() {
        return this.cov;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(col)) ? false : true;
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
            e.O(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.cop = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.cop = null;
    }

    public int ade() {
        if (this.coo == null) {
            return -1;
        }
        return this.coo.ade();
    }

    public com.baidu.swan.apps.framework.c adf() {
        return this.coo;
    }

    public synchronized boolean adg() {
        boolean z;
        if (!isDestroyed() && this.coo != null) {
            z = this.coo.asr().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0357a.aiapps_slide_in_from_right, a.C0357a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.cov != null) {
            this.cov.aJI();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
        aEQ.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aEQ.aDd() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aEQ.aEM().ado().pf("1250000000000000");
        }
        if (this.cos != null) {
            this.cos.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.coo == null || !this.coo.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.cor == null) {
            this.cor = new ActivityResultDispatcher(this, 1);
        }
        return this.cor;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0458a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a adh() {
        if (this.cox == null) {
            this.cox = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.cox;
    }

    public com.baidu.swan.apps.view.c adi() {
        return this.cow;
    }

    public void adj() {
        if (this.mIsFromSchema) {
            this.cot = "schema";
        } else {
            this.cot = "user";
        }
    }

    public String adk() {
        return this.cot;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.cov != null) {
            this.cov.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aEQ().aDd()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aEQ().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aEQ().aDd() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY().pf("1250000000000000");
            }
        }
        adj();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.cou == null) {
                    SwanAppActivity.this.cou = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aEQ().dmG = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.cou.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.cov != null) {
            this.cov.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aKK().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.cou != null) {
            this.cou.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!adg()) {
            i.aBh();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.ak.a.aHs().aHx();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.avb().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.ags().agt().agr().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.coq = frameLifeState;
        adl();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.coo != null && !this.coo.asa()) {
            this.coo.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void adl() {
        b(this.coq);
    }

    @Nullable
    public f adm() {
        if (this.coo == null) {
            return null;
        }
        return this.coo.adm();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aEQ().w(this.coy);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.cou = null;
        adn();
        if (this.cop != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.auE().afP();
        if (this.cov != null) {
            this.cov.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aEQ().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aEQ().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a pr = com.baidu.swan.apps.u.e.a.pr(appId);
            pr.awE().awK();
            pr.awF();
        }
        com.baidu.swan.apps.runtime.d.aEQ().y(new String[0]);
        this.cos = null;
        super.onDestroy();
    }

    public synchronized void adn() {
        if (this.cow != null) {
            this.cow.agV();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aLf();
        com.baidu.swan.apps.view.c.cV(com.baidu.swan.apps.t.a.aua());
        f adm = adm();
        if (adm != null) {
            adm.amF().al(0, 0).amK().amM();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.coo != null) {
            this.coo.d(FrameLifeState.INACTIVATED);
            this.coo.release();
            this.coo = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aEM = com.baidu.swan.apps.runtime.d.aEQ().aEM();
        aEM.aFg().aGD();
        aEM.aFh().clear();
        com.baidu.swan.apps.setting.b.a.aHr();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (adg()) {
            this.coo.onBackPressed();
            return;
        }
        HybridUbcFlow aBh = i.aBh();
        if (aBh != null) {
            aBh.r("value", "cancel");
            aBh.ci("exitType", String.valueOf(4));
            aBh.aAM();
        }
        com.baidu.swan.apps.v.g.axx().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a ado = ado();
        boolean z3 = ado != null && "1230000000000000".equals(ado.awd());
        if (this.cos != null && !z3) {
            this.cos.gH(false);
        }
        if (!adg() || com.baidu.swan.apps.runtime.d.aEQ().aEM().aEZ()) {
            h.aHR();
            adw();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0357a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a ado() {
        if (this.coo == null) {
            return null;
        }
        return this.coo.ado();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.coo != null) {
            this.coo.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.coo != null) {
            this.coo.showLoadingView();
        }
    }

    public void adp() {
        if (this.coo != null) {
            this.coo.adp();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (adg()) {
            this.coo.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.al.f.c
    public com.baidu.swan.apps.al.f.b adq() {
        if (this.coo == null) {
            return null;
        }
        return this.coo.adq();
    }

    public boolean isLandScape() {
        return this.coo != null && this.coo.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.coo != null) {
            this.coo.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.coo != null) {
            this.coo.b(bVar);
        }
    }

    @UiThread
    public void hf(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.auE().a(this, i, ado());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.cow == null) {
            this.cow = new com.baidu.swan.apps.view.c(this);
        }
        this.cow.a(1 == com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY().getAppFrameType(), z, aVar);
    }

    public void adr() {
        int i = 2;
        if (ado() != null && ado().getOrientation() == 1) {
            i = 3;
        }
        if (adi() != null) {
            adi().ln(i);
        }
    }

    private void ads() {
        this.coy.a(new com.baidu.swan.apps.ap.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
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
                SwanAppActivity.this.adt();
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
                SwanAppActivity.this.adl();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.axx().axy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (adu() && cVar.containsKey(" event_params_installer_progress")) {
            this.cow.P(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adt() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aEQ().aEM().available()) {
                dX(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.adw();
                    }
                }, f3668com);
            }
        }
    }

    private boolean adu() {
        return (this.cow == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (adu()) {
            this.cow.ut(cVar.getString("app_icon_url"));
            this.cow.kf(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aEY = com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY();
        ad(aEY.getOrientation(), aEY.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aEY.aqe() + " appId: " + aEY.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.coo != null && this.coo.asD()) {
            dX("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        adn();
        HashSet egn = strArr == null ? com.facebook.common.internal.i.egn() : com.facebook.common.internal.i.N(strArr);
        if (egn.contains("flag_finish_activity")) {
            if (egn.contains("flag_remove_task")) {
                adw();
            } else {
                finish();
            }
        }
    }

    public String adv() {
        return this.coo == null ? "" : this.coo.cPc;
    }

    public boolean jW(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, adv());
    }

    private synchronized void dX(boolean z) {
        com.baidu.swan.apps.runtime.e aEM = com.baidu.swan.apps.runtime.d.aEQ().aEM();
        if (aEM.available() && (jW(aEM.getAppId()) || a(aEM))) {
            this.coo.a(this.coq, z);
            if (DEBUG) {
                adx();
            }
            if (this.cos == null && com.baidu.swan.apps.ap.b.aJA()) {
                this.cos = com.baidu.swan.apps.ap.b.aJz();
                if (!this.coz) {
                    this.cos.a(ado(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.coo != null) {
            adn();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.am.a().bZ(5L).ca(11L).tK("can not buildFramework"), eVar.ade(), eVar.id);
            adw();
            z = false;
        } else {
            this.coo = a2;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.aum().afz();
                }
            }, "updateMobStat");
            ad(eVar.aEY().getOrientation(), eVar.ade());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adw() {
        e.N(this);
    }

    private void adx() {
        com.baidu.swan.apps.runtime.e aEM = com.baidu.swan.apps.runtime.d.aEQ().aEM();
        if (aEM != null) {
            String aww = aEM.ado().aww();
            com.baidu.swan.apps.u.e.a pr = com.baidu.swan.apps.u.e.a.pr(aEM.ado().aww());
            pr.ps("appId: " + aEM.id + "  launchId: " + aww).awL();
            pr.awF();
        }
    }
}
