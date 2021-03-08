package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.d;
import com.baidu.swan.apps.ao.e;
import com.baidu.swan.apps.ao.o;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.u;
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
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.ak.f.c, a.InterfaceC0459a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String cDr = SwanAppActivity.class.getName();
    private static final long cDs = TimeUnit.SECONDS.toMillis(1);
    private d cDA;
    protected com.baidu.swan.apps.view.c cDB;
    private com.baidu.swan.apps.res.widget.floatlayer.a cDC;
    private com.baidu.swan.apps.framework.c cDt;
    private Messenger cDu;
    private ActivityResultDispatcher cDw;
    @Nullable
    private com.baidu.swan.apps.ao.b cDx;
    OrientationEventListener cDz;
    private boolean mIsBackground;
    private FrameLifeState cDv = FrameLifeState.INACTIVATED;
    private String cDy = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b cDD = new com.baidu.swan.apps.runtime.b();
    private boolean cDE = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0358a.aiapps_slide_in_from_right, a.C0358a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.axS().aiE();
        com.baidu.swan.apps.process.messaging.client.a.aFM().aFO();
        this.mIsFromSchema = true;
        g.setStartType(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.M(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.atM());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                agk();
                return;
            }
            d.C0422d.s(intent);
            com.baidu.swan.games.utils.so.d.A(intent);
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
            agg();
            com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
            aIJ.j(this);
            aIJ.v(this.cDD);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aIJ.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aIJ.aGb() && v) {
                aIJ.aIF().aIR().pb("1250000000000000");
            }
            ah.O(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.cDA = new com.baidu.swan.apps.ao.d(this);
            }
            if (this.cDA != null) {
                this.cDA.setCanSlide(false);
            }
            if (this.cDA != null) {
                this.cDA.onCreate();
            }
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.axl().aiq();
                    o.K(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.cDE = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.cDA != null) {
            this.cDA.aNA();
        }
    }

    public com.baidu.swan.apps.ao.d afS() {
        return this.cDA;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(cDr)) ? false : true;
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

    private void X(int i, int i2) {
        if (-1 < i) {
            setRequestedOrientation(i == 1 ? 0 : 1);
        }
        if (i2 == 1) {
            e.I(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.cDu = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.cDu = null;
    }

    public int getFrameType() {
        if (this.cDt == null) {
            return -1;
        }
        return this.cDt.getFrameType();
    }

    public com.baidu.swan.apps.framework.c afT() {
        return this.cDt;
    }

    public synchronized boolean afU() {
        boolean z;
        if (!isDestroyed() && this.cDt != null) {
            z = this.cDt.avq().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0358a.aiapps_slide_in_from_right, a.C0358a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.cDA != null) {
            this.cDA.aNB();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
        aIJ.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aIJ.aGb() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aIJ.aIF().agc().pb("1250000000000000");
        }
        if (this.cDx != null) {
            this.cDx.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cDt == null || !this.cDt.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.cDw == null) {
            this.cDw = new ActivityResultDispatcher(this, 1);
        }
        return this.cDw;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0459a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a afV() {
        if (this.cDC == null) {
            this.cDC = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.cDC;
    }

    public com.baidu.swan.apps.view.c afW() {
        return this.cDB;
    }

    public void afX() {
        if (this.mIsFromSchema) {
            this.cDy = "schema";
        } else {
            this.cDy = "user";
        }
    }

    public String afY() {
        return this.cDy;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.cDA != null) {
            this.cDA.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aIJ().aGb()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aIJ().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aIJ().aGb() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().pb("1250000000000000");
            }
        }
        afX();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.cDz == null) {
                    SwanAppActivity.this.cDz = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aIJ().dFt = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.cDz.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.cDA != null) {
            this.cDA.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aOD().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.cDz != null) {
            this.cDz.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!afU()) {
            i.aEf();
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.aj.a.aLl().aLq();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.aya().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.ajk().ajl().ajj().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.cDv = frameLifeState;
        afZ();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.cDt != null && !this.cDt.ava()) {
            this.cDt.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afZ() {
        b(this.cDv);
    }

    @Nullable
    public f aga() {
        if (this.cDt == null) {
            return null;
        }
        return this.cDt.aga();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aIJ().w(this.cDD);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.cDz = null;
        agb();
        if (this.cDu != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.axD().aiH();
        if (this.cDA != null) {
            this.cDA.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aIJ().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aIJ().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a pn = com.baidu.swan.apps.u.e.a.pn(appId);
            pn.azE().azK();
            pn.azF();
        }
        com.baidu.swan.apps.runtime.d.aIJ().F(new String[0]);
        this.cDx = null;
        super.onDestroy();
    }

    public synchronized void agb() {
        if (this.cDB != null) {
            this.cDB.ajN();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aPb();
        com.baidu.swan.apps.view.c.dR(com.baidu.swan.apps.t.a.awZ());
        f aga = aga();
        if (aga != null) {
            aga.apE().af(0, 0).apJ().apL();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.cDt != null) {
            this.cDt.d(FrameLifeState.INACTIVATED);
            this.cDt.release();
            this.cDt = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aIF = com.baidu.swan.apps.runtime.d.aIJ().aIF();
        aIF.aIZ().aKw();
        aIF.aJa().clear();
        com.baidu.swan.apps.setting.b.a.aLk();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (afU()) {
            this.cDt.onBackPressed();
            return;
        }
        HybridUbcFlow aEf = i.aEf();
        if (aEf != null) {
            aEf.p("value", "cancel");
            aEf.cg("exitType", String.valueOf(4));
            aEf.aDM();
        }
        com.baidu.swan.apps.v.g.aAx().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        b.a agc = agc();
        boolean z3 = agc != null && "1230000000000000".equals(agc.azd());
        if (this.cDx != null && !z3) {
            this.cDx.hy(false);
        }
        if (!afU() || com.baidu.swan.apps.runtime.d.aIJ().aIF().aIS()) {
            h.aLJ();
            agk();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0358a.aiapps_slide_out_to_right_zadjustment_top);
                return z2;
            } catch (Exception e) {
                e = e;
                if (DEBUG) {
                    e.printStackTrace();
                    return z2;
                }
                return z2;
            }
        } catch (Exception e2) {
            e = e2;
            z2 = false;
        }
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    public b.a agc() {
        if (this.cDt == null) {
            return null;
        }
        return this.cDt.agc();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.cDt != null) {
            this.cDt.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.cDt != null) {
            this.cDt.showLoadingView();
        }
    }

    public void agd() {
        if (this.cDt != null) {
            this.cDt.agd();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (afU()) {
            this.cDt.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.ak.f.c
    public com.baidu.swan.apps.ak.f.b age() {
        if (this.cDt == null) {
            return null;
        }
        return this.cDt.age();
    }

    public boolean isLandScape() {
        return this.cDt != null && this.cDt.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.cDt != null) {
            this.cDt.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.cDt != null) {
            this.cDt.b(bVar);
        }
    }

    @UiThread
    public void ga(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.axD().a(this, i, agc());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.cDB == null) {
            this.cDB = new com.baidu.swan.apps.view.c(this);
        }
        this.cDB.a(1 == com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().getAppFrameType(), z, aVar);
    }

    public void agf() {
        int i = 2;
        if (agc() != null && agc().getOrientation() == 1) {
            i = 3;
        }
        if (afW() != null) {
            afW().kw(i);
        }
    }

    private void agg() {
        this.cDD.a(new com.baidu.swan.apps.ao.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.c
            /* renamed from: c */
            public Boolean O(i.a aVar) {
                return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
            }
        }).a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                SwanAppActivity.this.a(true, aVar);
            }
        }, "event_on_still_maintaining").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                SwanAppActivity.this.a(aVar);
            }
        }, "event_on_app_occupied").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                SwanAppActivity.this.c(aVar);
            }
        }, "event_on_app_updated").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                SwanAppActivity.this.b(aVar);
            }
        }, "event_on_app_icon_update").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                SwanAppActivity.this.agh();
            }
        }, "event_on_pkg_maintain_finish").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                SwanAppActivity.this.a((com.baidu.swan.apps.u.c.a.c) aVar);
            }
        }, "installer_on_progress").a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.SwanAppActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: b */
            public void N(i.a aVar) {
                SwanAppActivity.this.afZ();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.aAx().aAy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (agi() && cVar.containsKey(" event_params_installer_progress")) {
            this.cDB.X(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agh() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aIJ().aIF().available()) {
                eE(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.agk();
                    }
                }, cDs);
            }
        }
    }

    private boolean agi() {
        return (this.cDB == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (agi()) {
            this.cDB.ux(cVar.getString("app_icon_url"));
            this.cDB.kc(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aIR = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR();
        X(aIR.getOrientation(), aIR.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aIR.atf() + " appId: " + aIR.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.cDt != null && this.cDt.avC()) {
            eE("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void x(String... strArr) {
        agb();
        HashSet esP = strArr == null ? com.facebook.common.internal.i.esP() : com.facebook.common.internal.i.Q(strArr);
        if (esP.contains("flag_finish_activity")) {
            if (esP.contains("flag_remove_task")) {
                agk();
            } else {
                finish();
            }
        }
    }

    public String agj() {
        return this.cDt == null ? "" : this.cDt.dea;
    }

    public boolean jT(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, agj());
    }

    private synchronized void eE(boolean z) {
        com.baidu.swan.apps.runtime.e aIF = com.baidu.swan.apps.runtime.d.aIJ().aIF();
        if (aIF.available() && (jT(aIF.getAppId()) || a(aIF))) {
            this.cDt.a(this.cDv, z);
            if (DEBUG) {
                agl();
            }
            if (this.cDx == null && com.baidu.swan.apps.ao.b.aNt()) {
                this.cDx = com.baidu.swan.apps.ao.b.aNs();
                if (!this.cDE) {
                    this.cDx.a(agc(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.cDt != null) {
            agb();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.al.a().db(5L).dc(11L).tM("can not buildFramework"), eVar.getFrameType(), eVar.id);
            agk();
            z = false;
        } else {
            this.cDt = a2;
            p.a(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.axl().air();
                }
            }, "updateMobStat");
            X(eVar.aIR().getOrientation(), eVar.getFrameType());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agk() {
        e.H(this);
    }

    private void agl() {
        com.baidu.swan.apps.runtime.e aIF = com.baidu.swan.apps.runtime.d.aIJ().aIF();
        if (aIF != null) {
            String azw = aIF.agc().azw();
            com.baidu.swan.apps.u.e.a pn = com.baidu.swan.apps.u.e.a.pn(aIF.agc().azw());
            pn.po("appId: " + aIF.id + "  launchId: " + azw).azL();
            pn.azF();
        }
    }
}
