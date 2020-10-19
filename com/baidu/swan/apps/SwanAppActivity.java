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
public class SwanAppActivity extends SwanAppBaseActivity implements ServiceConnection, ActivityResultDispatcherHolder, com.baidu.swan.apps.al.f.c, a.InterfaceC0444a {
    private static final boolean DEBUG = b.DEBUG;
    private static final String cfM = SwanAppActivity.class.getName();
    private static final long cfN = TimeUnit.SECONDS.toMillis(1);
    private com.baidu.swan.apps.framework.c cfO;
    private Messenger cfP;
    private ActivityResultDispatcher cfR;
    @Nullable
    private com.baidu.swan.apps.ap.b cfS;
    OrientationEventListener cfU;
    private d cfV;
    protected com.baidu.swan.apps.view.c cfW;
    private com.baidu.swan.apps.res.widget.floatlayer.a cfX;
    private boolean mIsBackground;
    private FrameLifeState cfQ = FrameLifeState.INACTIVATED;
    private String cfT = "sys";
    private boolean mIsFromSchema = false;
    private final com.baidu.swan.apps.runtime.b cfY = new com.baidu.swan.apps.runtime.b();
    private boolean cfZ = false;

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    @DebugTrace
    protected void onCreate(Bundle bundle) {
        Bundle bundle2;
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(a.C0343a.aiapps_slide_in_from_right, a.C0343a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        com.baidu.swan.apps.t.a.asZ().adS();
        com.baidu.swan.apps.process.messaging.client.a.aAU().aAW();
        this.mIsFromSchema = true;
        g.kc(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        a(FrameLifeState.JUST_CREATED);
        if (!u.checkActivityRefuseServiceAndFinish(this)) {
            Intent intent = getIntent();
            boolean v = com.baidu.swan.apps.u.c.d.v(intent);
            if (v) {
                intent.putExtra("launch_id", SwanLauncher.aoQ());
            }
            if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                intent.putExtras(bundle2);
            }
            if (q(intent)) {
                abC();
                return;
            }
            d.C0408d.s(intent);
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
            aby();
            com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
            aCW.j(this);
            aCW.v(this.cfY);
            if (intent != null && (v || bundle == null)) {
                intent.putExtra("receive_launch_intent_time", currentTimeMillis);
                aCW.e(intent.getExtras(), "update_tag_by_activity_on_create");
            }
            if (aCW.aBj() && v) {
                aCW.aCS().aDe().oM("1250000000000000");
            }
            ah.T(this);
            if (Build.VERSION.SDK_INT != 26) {
                this.cfV = new com.baidu.swan.apps.ap.d(this);
            }
            if (this.cfV != null) {
                this.cfV.setCanSlide(false);
            }
            if (this.cfV != null) {
                this.cfV.onCreate();
            }
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.ass().adE();
                    o.Q(SwanAppActivity.this);
                }
            }, "initOnCreate");
            if (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) {
                z = false;
            }
            this.cfZ = z;
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.cfV != null) {
            this.cfV.aHN();
        }
    }

    public com.baidu.swan.apps.ap.d abj() {
        return this.cfV;
    }

    private boolean q(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(cfM)) ? false : true;
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

    private void ac(int i, int i2) {
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
            this.cfP = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.cfP = null;
    }

    public int abk() {
        if (this.cfO == null) {
            return -1;
        }
        return this.cfO.abk();
    }

    public com.baidu.swan.apps.framework.c abl() {
        return this.cfO;
    }

    public synchronized boolean abm() {
        boolean z;
        if (!isDestroyed() && this.cfO != null) {
            z = this.cfO.aqw().activated();
        }
        return z;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(a.C0343a.aiapps_slide_in_from_right, a.C0343a.aiapps_hold);
        if (DEBUG) {
            Log.i("SwanAppActivity", "onNewIntent:REORDER_TO_FRONT = " + ((intent.getFlags() & 131072) == 131072));
        }
        if (this.cfV != null) {
            this.cfV.aHO();
        }
        this.mIsFromSchema = true;
        com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
        aCW.e(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (aCW.aBj() && com.baidu.swan.apps.u.c.d.v(intent)) {
            aCW.aCS().abu().oM("1250000000000000");
        }
        if (this.cfS != null) {
            this.cfS.b(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.cfO == null || !this.cfO.onKeyDown(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.cfR == null) {
            this.cfR = new ActivityResultDispatcher(this, 1);
        }
        return this.cfR;
    }

    @Override // com.baidu.swan.apps.res.widget.floatlayer.a.InterfaceC0444a
    @NonNull
    public com.baidu.swan.apps.res.widget.floatlayer.a abn() {
        if (this.cfX == null) {
            this.cfX = new com.baidu.swan.apps.res.widget.floatlayer.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.cfX;
    }

    public com.baidu.swan.apps.view.c abo() {
        return this.cfW;
    }

    public void abp() {
        if (this.mIsFromSchema) {
            this.cfT = "schema";
        } else {
            this.cfT = "user";
        }
    }

    public String abq() {
        return this.cfT;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        if (this.cfV != null) {
            this.cfV.closePane();
        }
        a(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !com.baidu.swan.apps.runtime.d.aCW().aBj()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            com.baidu.swan.apps.runtime.d.aCW().e(intent.getExtras(), "update_tag_by_activity_on_create");
            if (com.baidu.swan.apps.runtime.d.aCW().aBj() && com.baidu.swan.apps.u.c.d.v(intent)) {
                com.baidu.swan.apps.runtime.d.aCW().aCS().aDe().oM("1250000000000000");
            }
        }
        abp();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppActivity.this.cfU == null) {
                    SwanAppActivity.this.cfU = new OrientationEventListener(SwanAppActivity.this, 2) { // from class: com.baidu.swan.apps.SwanAppActivity.6.1
                        @Override // android.view.OrientationEventListener
                        public void onOrientationChanged(int i) {
                            com.baidu.swan.apps.runtime.d.aCW().deg = i;
                        }
                    };
                }
                if (SwanAppActivity.this.mResumed) {
                    SwanAppActivity.this.cfU.enable();
                }
            }
        }, "OrientationEventListener", 2);
        if (this.cfV != null) {
            this.cfV.onResume();
        }
        a(FrameLifeState.JUST_RESUMED);
        ap.aIQ().reset();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        a(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        if (this.cfU != null) {
            this.cfU.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        a(FrameLifeState.JUST_CREATED);
        if (!abm()) {
            i.azn();
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.baidu.swan.apps.ak.a.aFy().aFD();
                } catch (Exception e) {
                    if (SwanAppActivity.DEBUG) {
                        Log.e("SwanAppActivity", "SaveTraceException:", e);
                    }
                }
            }
        }, "tracer");
        com.baidu.swan.apps.t.a.ath().flush(false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!getResultDispatcher().notifyActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
            com.baidu.swan.apps.adaptation.b.a.c.aey().aez().aex().onActivityResult(this, i, i2, intent);
        }
    }

    private synchronized void a(@NonNull FrameLifeState frameLifeState) {
        this.cfQ = frameLifeState;
        abr();
    }

    private synchronized void b(@NonNull FrameLifeState frameLifeState) {
        if (this.cfO != null && !this.cfO.aqg()) {
            this.cfO.d(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void abr() {
        b(this.cfQ);
    }

    @Nullable
    public f abs() {
        if (this.cfO == null) {
            return null;
        }
        return this.cfO.abs();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.baidu.swan.apps.runtime.d.aCW().w(this.cfY);
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onDestroy");
        this.cfU = null;
        abt();
        if (this.cfP != null) {
            unbindService(this);
        }
        com.baidu.swan.apps.t.a.asK().adV();
        if (this.cfV != null) {
            this.cfV.onDestroy();
        }
        com.baidu.swan.apps.runtime.d.aCW().k(this);
        a(FrameLifeState.INACTIVATED);
        com.baidu.swan.apps.v.f.release();
        String appId = com.baidu.swan.apps.runtime.d.aCW().getAppId();
        if (DEBUG) {
            com.baidu.swan.apps.u.e.a oY = com.baidu.swan.apps.u.e.a.oY(appId);
            oY.auK().auQ();
            oY.auL();
        }
        com.baidu.swan.apps.runtime.d.aCW().x(new String[0]);
        this.cfS = null;
        super.onDestroy();
    }

    public synchronized void abt() {
        if (this.cfW != null) {
            this.cfW.afb();
            if (DEBUG) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        com.baidu.swan.apps.view.c.aJl();
        com.baidu.swan.apps.view.c.cV(com.baidu.swan.apps.t.a.asf());
        f abs = abs();
        if (abs != null) {
            abs.akL().ak(0, 0).akQ().akS();
        }
        com.baidu.swan.apps.textarea.c.release();
        if (this.cfO != null) {
            this.cfO.d(FrameLifeState.INACTIVATED);
            this.cfO.release();
            this.cfO = null;
        }
        com.baidu.swan.apps.setting.oauth.c.release();
        com.baidu.swan.apps.runtime.e aCS = com.baidu.swan.apps.runtime.d.aCW().aCS();
        aCS.aDm().aEJ();
        aCS.aDn().clear();
        com.baidu.swan.apps.setting.b.a.aFx();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (abm()) {
            this.cfO.onBackPressed();
            return;
        }
        HybridUbcFlow azn = i.azn();
        if (azn != null) {
            azn.r("value", "cancel");
            azn.cb("exitType", String.valueOf(4));
            azn.ayS();
        }
        com.baidu.swan.apps.v.g.avD().setForeground(false);
        moveTaskToBack(true);
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        Exception e;
        b.a abu = abu();
        boolean z3 = abu != null && "1230000000000000".equals(abu.auj());
        if (this.cfS != null && !z3) {
            this.cfS.gu(false);
        }
        if (!abm() || com.baidu.swan.apps.runtime.d.aCW().aCS().aDf()) {
            h.aFX();
            abC();
            return false;
        }
        try {
            z2 = super.moveTaskToBack(z);
            try {
                overridePendingTransition(0, a.C0343a.aiapps_slide_out_to_right_zadjustment_top);
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

    public b.a abu() {
        if (this.cfO == null) {
            return null;
        }
        return this.cfO.abu();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (this.cfO != null) {
            this.cfO.a(fVar);
        }
    }

    public void m(Bundle bundle) {
        com.baidu.swan.apps.process.messaging.service.b.b(this, bundle);
    }

    public void showLoadingView() {
        if (this.cfO != null) {
            this.cfO.showLoadingView();
        }
    }

    public void abv() {
        if (this.cfO != null) {
            this.cfO.abv();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (abm()) {
            this.cfO.onTrimMemory(i);
        }
    }

    @Override // com.baidu.swan.apps.al.f.c
    public com.baidu.swan.apps.al.f.b abw() {
        if (this.cfO == null) {
            return null;
        }
        return this.cfO.abw();
    }

    public boolean isLandScape() {
        return this.cfO != null && this.cfO.isLandScape();
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public void a(com.baidu.swan.apps.framework.b bVar) {
        if (this.cfO != null) {
            this.cfO.a(bVar);
        }
    }

    public void b(com.baidu.swan.apps.framework.b bVar) {
        if (this.cfO != null) {
            this.cfO.b(bVar);
        }
    }

    @UiThread
    public void gU(int i) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i + ", pid:" + Process.myPid());
        }
        com.baidu.swan.apps.t.a.asK().a(this, i, abu());
    }

    public void a(boolean z, @Nullable i.a aVar) {
        if (this.cfW == null) {
            this.cfW = new com.baidu.swan.apps.view.c(this);
        }
        this.cfW.a(1 == com.baidu.swan.apps.runtime.d.aCW().aCS().aDe().getAppFrameType(), z, aVar);
    }

    public void abx() {
        int i = 2;
        if (abu() != null && abu().getOrientation() == 1) {
            i = 3;
        }
        if (abo() != null) {
            abo().lc(i);
        }
    }

    private void aby() {
        this.cfY.a(new com.baidu.swan.apps.ap.e.c<i.a, Boolean>() { // from class: com.baidu.swan.apps.SwanAppActivity.3
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
                SwanAppActivity.this.abz();
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
                SwanAppActivity.this.abr();
            }
        }, "event_first_action_launched");
        com.baidu.swan.apps.v.g.avD().avE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.u.c.a.c cVar) {
        if (abA() && cVar.containsKey(" event_params_installer_progress")) {
            this.cfW.N(cVar.getFloat(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abz() {
        if (!isDestroyed()) {
            if (com.baidu.swan.apps.runtime.d.aCW().aCS().available()) {
                dK(true);
            } else {
                com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SwanAppActivity.this.abC();
                    }
                }, cfN);
            }
        }
    }

    private boolean abA() {
        return (this.cfW == null || isDestroyed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.a.c cVar) {
        if (abA()) {
            this.cfW.ua(cVar.getString("app_icon_url"));
            this.cfW.jM(cVar.getString("app_name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i.a aVar) {
        if (DEBUG) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        b.a aDe = com.baidu.swan.apps.runtime.d.aCW().aCS().aDe();
        ac(aDe.getOrientation(), aDe.getAppFrameType());
        a(false, aVar);
        com.baidu.swan.apps.console.c.i("SwanAppActivity", "appName: " + aDe.aoj() + " appId: " + aDe.getAppId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.swan.apps.u.c.a.c cVar) {
        if (this.cfO != null && this.cfO.aqI()) {
            dK("update_tag_by_activity_on_new_intent".equals(cVar.getString("app_update_tag")));
        }
    }

    public void p(String... strArr) {
        abt();
        HashSet dWp = strArr == null ? com.facebook.common.internal.i.dWp() : com.facebook.common.internal.i.N(strArr);
        if (dWp.contains("flag_finish_activity")) {
            if (dWp.contains("flag_remove_task")) {
                abC();
            } else {
                finish();
            }
        }
    }

    public String abB() {
        return this.cfO == null ? "" : this.cfO.cGG;
    }

    public boolean jD(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, abB());
    }

    private synchronized void dK(boolean z) {
        com.baidu.swan.apps.runtime.e aCS = com.baidu.swan.apps.runtime.d.aCW().aCS();
        if (aCS.available() && (jD(aCS.getAppId()) || a(aCS))) {
            this.cfO.a(this.cfQ, z);
            if (DEBUG) {
                abD();
            }
            if (this.cfS == null && com.baidu.swan.apps.ap.b.aHG()) {
                this.cfS = com.baidu.swan.apps.ap.b.aHF();
                if (!this.cfZ) {
                    this.cfS.a(abu(), getTaskId());
                }
            }
        }
    }

    private synchronized boolean a(com.baidu.swan.apps.runtime.e eVar) {
        boolean z;
        if (this.cfO != null) {
            abt();
        }
        com.baidu.swan.apps.framework.c a2 = com.baidu.swan.apps.framework.e.a(this, eVar);
        if (a2 == null) {
            com.baidu.swan.apps.u.b.a.a(this, new com.baidu.swan.apps.am.a().bX(5L).bY(11L).tr("can not buildFramework"), eVar.abk(), eVar.id);
            abC();
            z = false;
        } else {
            this.cfO = a2;
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.SwanAppActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.t.a.ass().adF();
                }
            }, "updateMobStat");
            ac(eVar.aDe().getOrientation(), eVar.abk());
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        e.N(this);
    }

    private void abD() {
        com.baidu.swan.apps.runtime.e aCS = com.baidu.swan.apps.runtime.d.aCW().aCS();
        if (aCS != null) {
            String auC = aCS.abu().auC();
            com.baidu.swan.apps.u.e.a oY = com.baidu.swan.apps.u.e.a.oY(aCS.abu().auC());
            oY.oZ("appId: " + aCS.id + "  launchId: " + auC).auR();
            oY.auL();
        }
    }
}
