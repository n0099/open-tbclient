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
/* loaded from: classes7.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.al.f.c, a.InterfaceC0468a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String csx = SwanAppActivity.class.getName();
    private static final long csy = TimeUnit.SECONDS.toMillis(1);
    private Messenger csA;
    private ActivityResultDispatcher csC;
    @Nullable
    private com.baidu.swan.apps.ap.b csD;
    OrientationEventListener csF;
    private d csG;
    protected com.baidu.swan.apps.view.c csH;
    private com.baidu.swan.apps.res.widget.floatlayer.a csI;
    private com.baidu.swan.apps.framework.c csz;
    private boolean mIsBackground;
    private FrameLifeState csB = FrameLifeState.INACTIVATED;
    private String csE = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b csJ = new com.baidu.swan.apps.runtime.b();
    private boolean csK = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0367a.aiapps_slide_in_from_right, a.C0367a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.awL().ahE();
        com.baidu.swan.apps.process.messaging.client.a.aEG().aEI();
        this.mIsFromSchema = true;
        g.kt(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.asE());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                afo();
                return;
            }
            d.C0432d.s(intent);
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
            afk();
            com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
            aGI.j(this);
            aGI.v(this.csJ);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aGI.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aGI.aEV() && v) {
                aGI.aGE().aGQ().pn("1250000000000000");
            }
            ah.S(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.csG = new com.baidu.swan.apps.ap.d(this);
            }
            if (this.csG != null) {
                this.csG.setCanSlide(false);
            }
            if (this.csG != null) {
                this.csG.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.awe().ahq();
                    o.P(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.csK = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.csG != null) {
            this.csG.aLz();
        }
    }

    public com.baidu.swan.apps.ap.d aeV() {
        return this.csG;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(csx)) ? false : true;
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
            e.N(this);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.csA = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.csA = null;
    }

    public int aeW() {
        if (this.csz == null) {
            return -1;
        }
        return this.csz.aeW();
    }

    public com.baidu.swan.apps.framework.c aeX() {
        return this.csz;
    }

    public synchronized boolean aeY() {
        boolean z;
        if (!isDestroyed() && this.csz != null) {
            z = this.csz.auj().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0367a.aiapps_slide_in_from_right, a.C0367a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.csG != null) {
            this.csG.aLA();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
        aGI.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aGI.aEV() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aGI.aGE().afg().pn("1250000000000000");
        }
        if (this.csD != null) {
            this.csD.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.csz == null || !this.csz.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.csC == null) {
            this.csC = new ActivityResultDispatcher(this, 1);
        }
        return this.csC;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0468a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a aeZ() {
        if (this.csI == null) {
            this.csI = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.csI;
    }

    public com.baidu.swan.apps.view.c afa() {
        return this.csH;
    }

    public void afb() {
        if (this.mIsFromSchema) {
            this.csE = "schema";
        } else {
            this.csE = "user";
        }
    }

    public String afc() {
        return this.csE;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.csG != null) {
            this.csG.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aGI().aEV()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aGI().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aGI().aEV() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ().pn("1250000000000000");
            }
        }
        afb();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.csF == null) {
                    SwanAppActivity.this.csF = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aGI().dqU = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.csF.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.csG != null) {
            this.csG.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aMC().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.csF != null) {
            this.csF.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!aeY()) {
            i.aCZ();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.ak.a.aJk().aJp();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.awT().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.aik().ail().aij().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.csB = frameLifeState;
        afd();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.csz != null && !this.csz.atT()) {
            this.csz.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afd() {
        b(this.csB);
    }

    @Nullable
    public f afe() {
        if (this.csz == null) {
            return null;
        }
        return this.csz.afe();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aGI().w(this.csJ);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.csF = null;
        aff();
        if (this.csA != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.aww().ahH();
        if (this.csG != null) {
            this.csG.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aGI().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aGI().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a pz = com.baidu.swan.apps.u.e.a.pz(appId);
            pz.ayw().ayC();
            pz.ayx();
        }
        com.baidu.swan.apps.runtime.d.aGI().y(new String[0]);
        this.csD = null;
        super.onDestroy();
    }

    public synchronized void aff() {
        if (this.csH != null) {
            this.csH.aiN();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aMX();
        com.baidu.swan.apps.view.c.cV(com.baidu.swan.apps.t.a.avS());
        f afe = afe();
        if (afe != null) {
            afe.aox().al(0, 0).aoC().aoE();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.csz != null) {
            this.csz.d(FrameLifeState.INACTIVATED);
            this.csz.release();
            this.csz = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aGE = com.baidu.swan.apps.runtime.d.aGI().aGE();
        aGE.aGY().aIv();
        aGE.aGZ().clear();
        com.baidu.swan.apps.setting.b.a.aJj();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (aeY()) {
            this.csz.onBackPressed();
            return;
        }
        HybridUbcFlow aCZ = i.aCZ();
        if (aCZ != null) {
            aCZ.r("value", "cancel");
            aCZ.ch("exitType", String.valueOf(4));
            aCZ.aCE();
        }
        com.baidu.swan.apps.v.g.azp().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a afg = afg();
        boolean z3 = afg != null && "1230000000000000".equals(afg.axV());
        if (this.csD != null && !z3) {
            this.csD.gT(false);
        }
        if (!aeY() || com.baidu.swan.apps.runtime.d.aGI().aGE().aGR()) {
            h.aJJ();
            afo();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0367a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a afg() {
        if (this.csz == null) {
            return null;
        }
        return this.csz.afg();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.csz != null) {
            this.csz.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.csz != null) {
            this.csz.showLoadingView();
        }
    }

    public void afh() {
        if (this.csz != null) {
            this.csz.afh();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (aeY()) {
            this.csz.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.al.f.c
    public com.baidu.swan.apps.al.f.b afi() {
        if (this.csz == null) {
            return null;
        }
        return this.csz.afi();
    }

    public boolean isLandScape() {
        return this.csz != null && this.csz.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.csz != null) {
            this.csz.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.csz != null) {
            this.csz.b(bVar);
        }
    }

    @UiThread
    public void hl(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.aww().a(this, i, afg());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.csH == null) {
            this.csH = new com.baidu.swan.apps.view.c(this);
        }
        this.csH.a(1 == com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ().getAppFrameType(), z, aVar);
    }

    public void afj() {
        int i = 2;
        if (afg() != null && afg().getOrientation() == 1) {
            i = 3;
        }
        if (afa() != null) {
            afa().lt(i);
        }
    }

    private void afk() {
        this.csJ.a(new com.baidu.swan.apps.ap.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
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
                SwanAppActivity.this.afl();
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
                SwanAppActivity.this.afd();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.azp().azq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (afm() && cVar.containsKey(" event_params_installer_progress")) {
            this.csH.Q(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afl() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aGI().aGE().available()) {
                ej(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.afo();
                    }
                }, csy);
            }
        }
    }

    private boolean afm() {
        return (this.csH == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (afm()) {
            this.csH.uC(cVar.getString("app_icon_url"));
            this.csH.ko(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aGQ = com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ();
        ad(aGQ.getOrientation(), aGQ.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aGQ.arW() + " appId: " + aGQ.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.csz != null && this.csz.auv()) {
            ej("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void q(String... strArr) {
        aff();
        HashSet eka = strArr == null ? com.facebook.common.internal.i.eka() : com.facebook.common.internal.i.N(strArr);
        if (eka.contains("flag_finish_activity")) {
            if (eka.contains("flag_remove_task")) {
                afo();
            } else {
                finish();
            }
        }
    }

    public String afn() {
        return this.csz == null ? "" : this.csz.cTl;
    }

    public boolean kf(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, afn());
    }

    private synchronized void ej(boolean z) {
        com.baidu.swan.apps.runtime.e aGE = com.baidu.swan.apps.runtime.d.aGI().aGE();
        if (aGE.available() && (kf(aGE.getAppId()) || a(aGE))) {
            this.csz.a(this.csB, z);
            if (DEBUG) {
                afp();
            }
            if (this.csD == null && com.baidu.swan.apps.ap.b.aLs()) {
                this.csD = com.baidu.swan.apps.ap.b.aLr();
                if (!this.csK) {
                    this.csD.a(afg(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.csz != null) {
            aff();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.am.a().cv(5L).cw(11L).tT("can not buildFramework"), eVar.aeW(), eVar.id);
            afo();
            z = false;
        } else {
            this.csz = a2;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.awe().ahr();
                }
            }, "updateMobStat");
            ad(eVar.aGQ().getOrientation(), eVar.aeW());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afo() {
        e.M(this);
    }

    private void afp() {
        com.baidu.swan.apps.runtime.e aGE = com.baidu.swan.apps.runtime.d.aGI().aGE();
        if (aGE != null) {
            String ayo = aGE.afg().ayo();
            com.baidu.swan.apps.u.e.a pz = com.baidu.swan.apps.u.e.a.pz(aGE.afg().ayo());
            pz.pA("appId: " + aGE.id + "  launchId: " + ayo).ayD();
            pz.ayx();
        }
    }
}
