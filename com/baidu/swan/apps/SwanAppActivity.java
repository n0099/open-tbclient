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
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.al.f.c, a.InterfaceC0470a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String cuj = SwanAppActivity.class.getName();
    private static final long cuk = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c cul;
    private Messenger cum;
    private ActivityResultDispatcher cuo;
    @Nullable
    private com.baidu.swan.apps.ap.b cup;
    OrientationEventListener cus;
    private d cuu;
    protected com.baidu.swan.apps.view.c cuv;
    private com.baidu.swan.apps.res.widget.floatlayer.a cuw;
    private boolean mIsBackground;
    private FrameLifeState cun = FrameLifeState.INACTIVATED;
    private String cuq = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b cux = new com.baidu.swan.apps.runtime.b();
    private boolean cuy = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0369a.aiapps_slide_in_from_right, a.C0369a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.axt().aim();
        com.baidu.swan.apps.process.messaging.client.a.aFo().aFq();
        this.mIsFromSchema = true;
        g.kx(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.atm());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                afW();
                return;
            }
            d.C0434d.s(intent);
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
            afS();
            com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
            aHq.j(this);
            aHq.v(this.cux);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aHq.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aHq.aFD() && v) {
                aHq.aHm().aHy().pt("1250000000000000");
            }
            ah.T(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.cuu = new com.baidu.swan.apps.ap.d(this);
            }
            if (this.cuu != null) {
                this.cuu.setCanSlide(false);
            }
            if (this.cuu != null) {
                this.cuu.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.awM().ahY();
                    o.Q(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.cuy = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.cuu != null) {
            this.cuu.aMh();
        }
    }

    public com.baidu.swan.apps.ap.d afD() {
        return this.cuu;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(cuj)) ? false : true;
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
            this.cum = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.cum = null;
    }

    public int afE() {
        if (this.cul == null) {
            return -1;
        }
        return this.cul.afE();
    }

    public com.baidu.swan.apps.framework.c afF() {
        return this.cul;
    }

    public synchronized boolean afG() {
        boolean z;
        if (!isDestroyed() && this.cul != null) {
            z = this.cul.auR().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0369a.aiapps_slide_in_from_right, a.C0369a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.cuu != null) {
            this.cuu.aMi();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
        aHq.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aHq.aFD() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aHq.aHm().afO().pt("1250000000000000");
        }
        if (this.cup != null) {
            this.cup.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cul == null || !this.cul.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.cuo == null) {
            this.cuo = new ActivityResultDispatcher(this, 1);
        }
        return this.cuo;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0470a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a afH() {
        if (this.cuw == null) {
            this.cuw = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.cuw;
    }

    public com.baidu.swan.apps.view.c afI() {
        return this.cuv;
    }

    public void afJ() {
        if (this.mIsFromSchema) {
            this.cuq = "schema";
        } else {
            this.cuq = "user";
        }
    }

    public String afK() {
        return this.cuq;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.cuu != null) {
            this.cuu.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aHq().aFD()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aHq().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aHq().aFD() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aHq().aHm().aHy().pt("1250000000000000");
            }
        }
        afJ();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.cus == null) {
                    SwanAppActivity.this.cus = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aHq().dsD = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.cus.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.cuu != null) {
            this.cuu.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aNk().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.cus != null) {
            this.cus.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!afG()) {
            i.aDH();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.ak.a.aJS().aJX();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.axB().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.aiS().aiT().aiR().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.cun = frameLifeState;
        afL();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.cul != null && !this.cul.auB()) {
            this.cul.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afL() {
        b(this.cun);
    }

    @Nullable
    public f afM() {
        if (this.cul == null) {
            return null;
        }
        return this.cul.afM();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aHq().w(this.cux);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.cus = null;
        afN();
        if (this.cum != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.axe().aip();
        if (this.cuu != null) {
            this.cuu.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aHq().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aHq().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a pF = com.baidu.swan.apps.u.e.a.pF(appId);
            pF.aze().azk();
            pF.azf();
        }
        com.baidu.swan.apps.runtime.d.aHq().y(new String[0]);
        this.cup = null;
        super.onDestroy();
    }

    public synchronized void afN() {
        if (this.cuv != null) {
            this.cuv.ajv();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aNF();
        com.baidu.swan.apps.view.c.cV(com.baidu.swan.apps.t.a.awA());
        f afM = afM();
        if (afM != null) {
            afM.apf().al(0, 0).apl().apn();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.cul != null) {
            this.cul.d(FrameLifeState.INACTIVATED);
            this.cul.release();
            this.cul = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aHm = com.baidu.swan.apps.runtime.d.aHq().aHm();
        aHm.aHG().aJd();
        aHm.aHH().clear();
        com.baidu.swan.apps.setting.b.a.aJR();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (afG()) {
            this.cul.onBackPressed();
            return;
        }
        HybridUbcFlow aDH = i.aDH();
        if (aDH != null) {
            aDH.r("value", "cancel");
            aDH.ci("exitType", String.valueOf(4));
            aDH.aDm();
        }
        com.baidu.swan.apps.v.g.azX().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a afO = afO();
        boolean z3 = afO != null && "1230000000000000".equals(afO.ayD());
        if (this.cup != null && !z3) {
            this.cup.gQ(false);
        }
        if (!afG() || com.baidu.swan.apps.runtime.d.aHq().aHm().aHz()) {
            h.aKr();
            afW();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0369a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a afO() {
        if (this.cul == null) {
            return null;
        }
        return this.cul.afO();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.cul != null) {
            this.cul.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.cul != null) {
            this.cul.showLoadingView();
        }
    }

    public void afP() {
        if (this.cul != null) {
            this.cul.afP();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (afG()) {
            this.cul.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.al.f.c
    public com.baidu.swan.apps.al.f.b afQ() {
        if (this.cul == null) {
            return null;
        }
        return this.cul.afQ();
    }

    public boolean isLandScape() {
        return this.cul != null && this.cul.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.cul != null) {
            this.cul.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.cul != null) {
            this.cul.b(bVar);
        }
    }

    @UiThread
    public void hp(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.axe().a(this, i, afO());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.cuv == null) {
            this.cuv = new com.baidu.swan.apps.view.c(this);
        }
        this.cuv.a(1 == com.baidu.swan.apps.runtime.d.aHq().aHm().aHy().getAppFrameType(), z, aVar);
    }

    public void afR() {
        int i = 2;
        if (afO() != null && afO().getOrientation() == 1) {
            i = 3;
        }
        if (afI() != null) {
            afI().lx(i);
        }
    }

    private void afS() {
        this.cux.a(new com.baidu.swan.apps.ap.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
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
                SwanAppActivity.this.afT();
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
                SwanAppActivity.this.afL();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.azX().azY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (afU() && cVar.containsKey(" event_params_installer_progress")) {
            this.cuv.R(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afT() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aHq().aHm().available()) {
                eg(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.afW();
                    }
                }, cuk);
            }
        }
    }

    private boolean afU() {
        return (this.cuv == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (afU()) {
            this.cuv.uH(cVar.getString("app_icon_url"));
            this.cuv.ku(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aHy = com.baidu.swan.apps.runtime.d.aHq().aHm().aHy();
        ad(aHy.getOrientation(), aHy.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aHy.asF() + " appId: " + aHy.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.cul != null && this.cul.avd()) {
            eg("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        afN();
        HashSet ekc = strArr == null ? com.facebook.common.internal.i.ekc() : com.facebook.common.internal.i.N(strArr);
        if (ekc.contains("flag_finish_activity")) {
            if (ekc.contains("flag_remove_task")) {
                afW();
            } else {
                finish();
            }
        }
    }

    public String afV() {
        return this.cul == null ? "" : this.cul.cUV;
    }

    public boolean kl(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, afV());
    }

    private synchronized void eg(boolean z) {
        com.baidu.swan.apps.runtime.e aHm = com.baidu.swan.apps.runtime.d.aHq().aHm();
        if (aHm.available() && (kl(aHm.getAppId()) || a(aHm))) {
            this.cul.a(this.cun, z);
            if (DEBUG) {
                afX();
            }
            if (this.cup == null && com.baidu.swan.apps.ap.b.aMa()) {
                this.cup = com.baidu.swan.apps.ap.b.aLZ();
                if (!this.cuy) {
                    this.cup.a(afO(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.cul != null) {
            afN();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.am.a().cv(5L).cw(11L).tY("can not buildFramework"), eVar.afE(), eVar.id);
            afW();
            z = false;
        } else {
            this.cul = a2;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.awM().ahZ();
                }
            }, "updateMobStat");
            ad(eVar.aHy().getOrientation(), eVar.afE());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afW() {
        e.N(this);
    }

    private void afX() {
        com.baidu.swan.apps.runtime.e aHm = com.baidu.swan.apps.runtime.d.aHq().aHm();
        if (aHm != null) {
            String ayW = aHm.afO().ayW();
            com.baidu.swan.apps.u.e.a pF = com.baidu.swan.apps.u.e.a.pF(aHm.afO().ayW());
            pF.pG("appId: " + aHm.id + "  launchId: " + ayW).azl();
            pF.azf();
        }
    }
}
