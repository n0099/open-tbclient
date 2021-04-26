package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Context;
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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.facebook.common.internal.Sets;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.e0.w.d;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.o;
import d.a.h0.a.i2.p;
import d.a.h0.a.i2.p0;
import d.a.h0.a.i2.u;
import d.a.h0.a.q1.b.c.a;
import d.a.h0.a.r1.i;
import d.a.h0.a.y0.e.b;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, a.InterfaceC0736a, d.a.h0.a.c2.f.c, ServiceConnection {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public static final int FROM_BACK_PRESS = 2;
    public static final int FROM_LOADING_BACK_PRESS = 4;
    public static final int FROM_LOADING_TITLE_BAR = 3;
    public static final int FROM_TITLE_BAR = 1;
    public static final String KEY_SAVE_BUNDLE = "swan_key_save_bundle";
    public static final String KEY_SAVE_TASK_ID = "swan_key_save_task_id";
    public static final int REQUEST_CODE_RESULT_DISPATCHER = 1;
    public static final String SHOW_BY_SCHEMA = "schema";
    public static final String SHOW_BY_SYS = "sys";
    public static final String SHOW_BY_USER = "user";
    public static final String TAG = "SwanAppActivity";
    public d.a.h0.a.q1.b.c.a mFloatLayer;
    public d.a.h0.a.o0.c mFrame;
    public boolean mIsBackground;
    public d.a.h0.a.j2.d mLoadingView;
    public Messenger mLocalService;
    public OrientationEventListener mOrientationListener;
    public ActivityResultDispatcher mResultDispatcher;
    public d.a.h0.a.i2.d mSlideHelper;
    @Nullable
    public d.a.h0.a.i2.b mTaskManager;
    public static final boolean DEBUG = d.a.h0.a.k.f43101a;
    public static final String COMPONENT_NAME = SwanAppActivity.class.getName();
    public static final long DELAY_TIME_FOR_LAUNCH_FAIL = TimeUnit.SECONDS.toMillis(1);
    public FrameLifeState mLifeStatus = FrameLifeState.INACTIVATED;
    public String mShowBy = "sys";
    public boolean mIsFromSchema = false;
    public final d.a.h0.a.r1.b mEventSubscriber = new d.a.h0.a.r1.b();
    public boolean restoreFromSaveInstance = false;

    /* loaded from: classes.dex */
    public class a implements d.a.h0.a.i2.u0.b<i.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.showSwanAppStartView(true, aVar);
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.h0.a.i2.u0.c<i.a, Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.c
        /* renamed from: b */
        public Boolean a(i.a aVar) {
            return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity.this.tryFinishAndRemoveTask();
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.w0.a.l().d();
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.w0.a.l().i();
            o.e(SwanAppActivity.this);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* loaded from: classes.dex */
        public class a extends OrientationEventListener {
            public a(f fVar, Context context, int i2) {
                super(context, i2);
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                d.a.h0.a.r1.d.e().f43812g = i2;
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity = SwanAppActivity.this;
            if (swanAppActivity.mOrientationListener == null) {
                swanAppActivity.mOrientationListener = new a(this, SwanAppActivity.this, 2);
            }
            if (SwanAppActivity.this.mResumed) {
                SwanAppActivity.this.mOrientationListener.enable();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.h0.a.y1.a.d().l();
            } catch (Exception e2) {
                if (SwanAppActivity.DEBUG) {
                    Log.e(SwanAppActivity.TAG, "SaveTraceException:", e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements d.a.h0.a.i2.u0.b<i.a> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.syncFrameLifeStatus();
        }
    }

    /* loaded from: classes.dex */
    public class i implements d.a.h0.a.i2.u0.b<i.a> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.notifyInstallProgress(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class j implements d.a.h0.a.i2.u0.b<i.a> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.onAppMaintainFinish();
        }
    }

    /* loaded from: classes.dex */
    public class k implements d.a.h0.a.i2.u0.b<i.a> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.updateLoadingView(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class l implements d.a.h0.a.i2.u0.b<i.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.onAppUpdated(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class m implements d.a.h0.a.i2.u0.b<i.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.onAppOccupied(aVar);
        }
    }

    private boolean hasLoadingView() {
        return (this.mLoadingView == null || isDestroyed()) ? false : true;
    }

    private void initEventHandler() {
        d.a.h0.a.r1.b bVar = this.mEventSubscriber;
        bVar.b(new b());
        bVar.e(new a(), "event_on_still_maintaining");
        bVar.e(new m(), "event_on_app_occupied");
        bVar.e(new l(), "event_on_app_updated");
        bVar.e(new k(), "event_on_app_icon_update");
        bVar.e(new j(), "event_on_pkg_maintain_finish");
        bVar.e(new i(), "installer_on_progress");
        bVar.e(new h(), "event_first_action_launched");
        d.a.h0.a.z0.g.a().c();
    }

    private boolean isInvalidComponentName(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(COMPONENT_NAME)) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInstallProgress(d.a.h0.a.y0.e.f.c cVar) {
        if (hasLoadingView() && cVar.c(" event_params_installer_progress")) {
            this.mLoadingView.r(cVar.f(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppMaintainFinish() {
        if (isDestroyed()) {
            return;
        }
        if (d.a.h0.a.r1.d.e().p().d()) {
            updateFrame(true);
        } else {
            d.a.h0.a.r1.d.g().postDelayed(new c(), DELAY_TIME_FOR_LAUNCH_FAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppOccupied(i.a aVar) {
        if (DEBUG) {
            Log.i(TAG, "onAppOccupied: ");
        }
        b.a J = d.a.h0.a.r1.d.e().p().J();
        setWindowFeature(J.a0(), J.F());
        showSwanAppStartView(false, aVar);
        d.a.h0.a.c0.c.g(TAG, "appName: " + J.J() + " appId: " + J.G());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppUpdated(d.a.h0.a.y0.e.f.c cVar) {
        d.a.h0.a.o0.c cVar2 = this.mFrame;
        if (cVar2 == null || !cVar2.S()) {
            return;
        }
        updateFrame("update_tag_by_activity_on_new_intent".equals(cVar.m("app_update_tag")));
    }

    private void reportLaunchTrace() {
        d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
        if (p != null) {
            String U = p.L().U();
            d.a.h0.a.y0.g.a d2 = d.a.h0.a.y0.g.a.d(p.L().U());
            d2.f("appId: " + p.f43823f + "  launchId: " + U).e();
            d2.h();
        }
    }

    private void setWindowFeature(int i2, int i3) {
        if (-1 < i2) {
            setRequestedOrientation(i2 == 1 ? 0 : 1);
        }
        if (i3 == 1) {
            d.a.h0.a.i2.e.d(this);
        }
    }

    private synchronized boolean swapFrame(d.a.h0.a.r1.e eVar) {
        if (this.mFrame != null) {
            destroyFrame();
        }
        d.a.h0.a.o0.c a2 = d.a.h0.a.o0.e.a(this, eVar);
        if (a2 == null) {
            d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
            aVar.j(5L);
            aVar.h(11L);
            aVar.c("can not buildFramework");
            d.a.h0.a.y0.d.a.d(this, aVar, eVar.j(), eVar.f43823f);
            tryFinishAndRemoveTask();
            return false;
        }
        this.mFrame = a2;
        p.k(new d(), "updateMobStat");
        setWindowFeature(eVar.J().a0(), eVar.j());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void syncFrameLifeStatus() {
        transFrameLifeStatus(this.mLifeStatus);
    }

    private synchronized void transFrameLifeStatus(@NonNull FrameLifeState frameLifeState) {
        if (this.mFrame != null && !this.mFrame.V()) {
            this.mFrame.E0(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryFinishAndRemoveTask() {
        d.a.h0.a.i2.e.i(this);
    }

    private synchronized void updateFrame(boolean z) {
        d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
        if (p.d()) {
            if (isActivedApp(p.getAppId()) || swapFrame(p)) {
                this.mFrame.H0(this.mLifeStatus, z);
                if (DEBUG) {
                    reportLaunchTrace();
                }
                if (this.mTaskManager == null && d.a.h0.a.i2.b.j()) {
                    d.a.h0.a.i2.b m2 = d.a.h0.a.i2.b.m();
                    this.mTaskManager = m2;
                    if (!this.restoreFromSaveInstance) {
                        m2.y(getLaunchInfo(), getTaskId());
                    }
                }
            }
        }
    }

    private synchronized void updateLifeStatus(@NonNull FrameLifeState frameLifeState) {
        this.mLifeStatus = frameLifeState;
        syncFrameLifeStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadingView(d.a.h0.a.y0.e.f.c cVar) {
        if (hasLoadingView()) {
            this.mLoadingView.E(cVar.m("app_icon_url"));
            this.mLoadingView.G(cVar.m(DpStatConstants.KEY_APP_NAME));
        }
    }

    public boolean checkShowEntryGuideWhenBack() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        return cVar != null && cVar.B();
    }

    public synchronized void destroyFrame() {
        if (this.mLoadingView != null) {
            this.mLoadingView.D();
            if (DEBUG) {
                Log.i(TAG, "destroyFrame resetLoadingView");
            }
        }
        d.a.h0.a.j2.d.w();
        d.a.h0.a.j2.d.v(d.a.h0.a.w0.a.c());
        d.a.h0.a.e0.l.f swanAppFragmentManager = getSwanAppFragmentManager();
        if (swanAppFragmentManager != null) {
            f.b h2 = swanAppFragmentManager.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        d.a.h0.a.e2.c.j();
        if (this.mFrame != null) {
            this.mFrame.E0(FrameLifeState.INACTIVATED);
            this.mFrame.v0();
            this.mFrame = null;
        }
        d.a.h0.a.v1.c.c.p();
        d.a.h0.a.r1.e p = d.a.h0.a.r1.d.e().p();
        p.R().j();
        p.i().a();
        d.a.h0.a.v1.d.a.r();
    }

    public final void doUBCEventStatistic(d.a.h0.a.z1.k.f fVar) {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.D(fVar);
        }
    }

    public void finishLoadingAnimator() {
        int i2 = (getLaunchInfo() == null || getLaunchInfo().a0() != 1) ? 2 : 3;
        if (getLoadingView() != null) {
            getLoadingView().B(i2);
        }
    }

    public String getActivedAppId() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        return cVar == null ? "" : cVar.n;
    }

    @Override // d.a.h0.a.q1.b.c.a.InterfaceC0736a
    @NonNull
    public d.a.h0.a.q1.b.c.a getFloatLayer() {
        if (this.mFloatLayer == null) {
            this.mFloatLayer = new d.a.h0.a.q1.b.c.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.mFloatLayer;
    }

    public d.a.h0.a.o0.c getFrame() {
        return this.mFrame;
    }

    public int getFrameType() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar == null) {
            return -1;
        }
        return cVar.j();
    }

    public b.a getLaunchInfo() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar == null) {
            return null;
        }
        return cVar.M();
    }

    public d.a.h0.a.j2.d getLoadingView() {
        return this.mLoadingView;
    }

    public SwanAppProcessInfo getProcessInfo() {
        return SwanAppProcessInfo.P0;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.mResultDispatcher == null) {
            this.mResultDispatcher = new ActivityResultDispatcher(this, 1);
        }
        return this.mResultDispatcher;
    }

    public String getShowBy() {
        return this.mShowBy;
    }

    public d.a.h0.a.i2.d getSlideHelper() {
        return this.mSlideHelper;
    }

    @Nullable
    public d.a.h0.a.e0.l.f getSwanAppFragmentManager() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar == null) {
            return null;
        }
        return cVar.P();
    }

    @Override // d.a.h0.a.c2.f.c
    public d.a.h0.a.c2.f.b getTrimMemoryDispatcher() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar == null) {
            return null;
        }
        return cVar.Q();
    }

    @UiThread
    public void handleSwanAppExit(int i2) {
        if (DEBUG) {
            Log.i(TAG, "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        d.a.h0.a.w0.a.v().d(this, i2, getLaunchInfo());
    }

    public synchronized boolean hasActivedFrame() {
        boolean z;
        if (!isDestroyed() && this.mFrame != null) {
            z = this.mFrame.N().activated();
        }
        return z;
    }

    public boolean isActivedApp(String str) {
        return !TextUtils.isEmpty(str) && TextUtils.equals(str, getActivedAppId());
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public boolean isLandScape() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        return cVar != null && cVar.T();
    }

    public void markShowByStatus() {
        if (this.mIsFromSchema) {
            this.mShowBy = "schema";
        } else {
            this.mShowBy = "user";
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        b.a launchInfo = getLaunchInfo();
        boolean z2 = false;
        boolean z3 = launchInfo != null && "1230000000000000".equals(launchInfo.S());
        d.a.h0.a.i2.b bVar = this.mTaskManager;
        if (bVar != null && !z3) {
            bVar.v(false);
        }
        if (hasActivedFrame() && !d.a.h0.a.r1.d.e().p().e0()) {
            try {
                boolean moveTaskToBack = super.moveTaskToBack(z);
                try {
                    overridePendingTransition(0, d.a.h0.a.a.aiapps_slide_out_to_right_zadjustment_top);
                    return moveTaskToBack;
                } catch (Exception e2) {
                    e = e2;
                    z2 = moveTaskToBack;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    return z2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            d.a.h0.a.z1.h.J();
            tryFinishAndRemoveTask();
            return false;
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        d.a.h0.a.p.d.j.c.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        d.a.h0.a.c0.c.g("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (hasActivedFrame()) {
            this.mFrame.X();
            return;
        }
        HybridUbcFlow l2 = d.a.h0.a.j1.i.l();
        if (l2 != null) {
            l2.z("value", QueryResponse.Options.CANCEL);
            l2.y("exitType", String.valueOf(4));
            l2.k();
        }
        d.a.h0.a.z0.g.a().d(false);
        moveTaskToBack(true);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.h0.m.a.a.f, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(d.a.h0.a.a.aiapps_slide_in_from_right, d.a.h0.a.a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        d.a.h0.a.w0.a.u().b();
        d.a.h0.a.n1.c.e.a.C().O();
        boolean z = true;
        this.mIsFromSchema = true;
        d.a.h0.a.z1.g.c(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        updateLifeStatus(FrameLifeState.JUST_CREATED);
        if (u.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = d.a.h0.a.y0.e.d.a(intent);
        if (a2) {
            intent.putExtra("launch_id", SwanLauncher.h());
        }
        if (bundle != null && intent != null && (bundle2 = bundle.getBundle(KEY_SAVE_BUNDLE)) != null) {
            intent.setExtrasClassLoader(getClass().getClassLoader());
            intent.putExtras(bundle2);
        }
        if (isInvalidComponentName(intent)) {
            tryFinishAndRemoveTask();
            return;
        }
        d.p.g(intent);
        d.a.h0.g.i0.f.d.k(intent);
        if (DEBUG) {
            Log.i(TAG, "onCreate: bindService");
        }
        try {
            bindService(new Intent(this, getProcessInfo().service), this, 1);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
        if (Build.VERSION.SDK_INT == 26) {
            TranslucentUtils.convertFromTranslucent(this);
        }
        d.a.h0.a.c0.c.a(TAG, "SwanAppActivity onCreate() savedInstanceState=", bundle);
        d.a.h0.a.c0.c.g("SwanApp", "SwanAppActivity onCreate");
        setContentView(d.a.h0.a.g.aiapps_activity);
        initEventHandler();
        d.a.h0.a.r1.d e3 = d.a.h0.a.r1.d.e();
        e3.s(this);
        e3.t(this.mEventSubscriber);
        if (intent != null && (a2 || bundle == null)) {
            intent.putExtra("receive_launch_intent_time", currentTimeMillis);
            e3.k(intent.getExtras(), "update_tag_by_activity_on_create");
        }
        if (e3.z() && a2) {
            e3.p().J().D0("1250000000000000");
        }
        h0.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.mSlideHelper = new d.a.h0.a.i2.d(this);
        }
        d.a.h0.a.i2.d dVar = this.mSlideHelper;
        if (dVar != null) {
            dVar.t(false);
        }
        d.a.h0.a.i2.d dVar2 = this.mSlideHelper;
        if (dVar2 != null) {
            dVar2.m();
        }
        p.k(new e(), "initOnCreate");
        this.restoreFromSaveInstance = (bundle == null || bundle.getInt(KEY_SAVE_TASK_ID) != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d.a.h0.a.r1.d.e().n(this.mEventSubscriber);
        d.a.h0.a.c0.c.g("SwanApp", "SwanAppActivity onDestroy");
        this.mOrientationListener = null;
        destroyFrame();
        if (this.mLocalService != null) {
            unbindService(this);
        }
        d.a.h0.a.w0.a.v().c();
        d.a.h0.a.i2.d dVar = this.mSlideHelper;
        if (dVar != null) {
            dVar.o();
        }
        d.a.h0.a.r1.d.e().q(this);
        updateLifeStatus(FrameLifeState.INACTIVATED);
        d.a.h0.a.z0.f.d0();
        String appId = d.a.h0.a.r1.d.e().getAppId();
        if (DEBUG) {
            d.a.h0.a.y0.g.a d2 = d.a.h0.a.y0.g.a.d(appId);
            d2.e().c();
            d2.h();
        }
        d.a.h0.a.r1.d.e().m(new String[0]);
        this.mTaskManager = null;
        super.onDestroy();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar == null || !cVar.d0(i2, keyEvent)) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        d.a.h0.a.c0.c.g("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(d.a.h0.a.a.aiapps_slide_in_from_right, d.a.h0.a.a.aiapps_hold);
        if (DEBUG) {
            int flags = intent.getFlags();
            StringBuilder sb = new StringBuilder();
            sb.append("onNewIntent:REORDER_TO_FRONT = ");
            sb.append((flags & 131072) == 131072);
            Log.i(TAG, sb.toString());
        }
        d.a.h0.a.i2.d dVar = this.mSlideHelper;
        if (dVar != null) {
            dVar.q();
        }
        this.mIsFromSchema = true;
        d.a.h0.a.r1.d e2 = d.a.h0.a.r1.d.e();
        e2.k(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (e2.z() && d.a.h0.a.y0.e.d.a(intent)) {
            e2.p().L().D0("1250000000000000");
        }
        d.a.h0.a.i2.b bVar = this.mTaskManager;
        if (bVar != null) {
            bVar.z(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        d.a.h0.a.c0.c.g("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        updateLifeStatus(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        d.a.h0.a.i2.d dVar = this.mSlideHelper;
        if (dVar != null) {
            dVar.j();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        d.a.h0.a.c0.c.g("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !d.a.h0.a.r1.d.e().z()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            d.a.h0.a.r1.d.e().k(intent.getExtras(), "update_tag_by_activity_on_create");
            if (d.a.h0.a.r1.d.e().z() && d.a.h0.a.y0.e.d.a(intent)) {
                d.a.h0.a.r1.d.e().p().J().D0("1250000000000000");
            }
        }
        markShowByStatus();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new f(), "OrientationEventListener", 2);
        d.a.h0.a.i2.d dVar = this.mSlideHelper;
        if (dVar != null) {
            dVar.s();
        }
        updateLifeStatus(FrameLifeState.JUST_RESUMED);
        p0.b().d();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle.get("android:support:fragments") != null) {
            bundle.remove("android:support:fragments");
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putBundle(KEY_SAVE_BUNDLE, intent.getExtras());
            bundle.putInt(KEY_SAVE_TASK_ID, getTaskId());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (DEBUG) {
            Log.i(TAG, "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.mLocalService = new Messenger(iBinder);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (DEBUG) {
            Log.i(TAG, "onServiceDisconnected: " + componentName);
        }
        this.mLocalService = null;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        d.a.h0.a.c0.c.g("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        d.a.h0.a.i2.d dVar = this.mSlideHelper;
        if (dVar != null) {
            dVar.e();
        }
        updateLifeStatus(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        d.a.h0.a.c0.c.g("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        updateLifeStatus(FrameLifeState.JUST_CREATED);
        if (!hasActivedFrame()) {
            d.a.h0.a.j1.i.l();
        }
        p.k(new g(), "tracer");
        d.a.h0.a.w0.a.U().a(false);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (hasActivedFrame()) {
            this.mFrame.r0(i2);
        }
    }

    public void preloadNextSwanAppProcess(Bundle bundle) {
        d.a.h0.a.n1.c.f.b.i(this, bundle);
    }

    public void registerCallback(d.a.h0.a.o0.b bVar) {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.u0(bVar);
        }
    }

    public void removeLoadingView() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.x0();
        }
    }

    public void reset(String... strArr) {
        destroyFrame();
        HashSet newHashSet = strArr == null ? Sets.newHashSet() : Sets.newHashSet(strArr);
        if (newHashSet.contains("flag_finish_activity")) {
            if (newHashSet.contains("flag_remove_task")) {
                tryFinishAndRemoveTask();
            } else {
                finish();
            }
        }
    }

    public void showLoadingView() {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.z0();
        }
    }

    public void showSwanAppStartView(boolean z, @Nullable i.a aVar) {
        if (this.mLoadingView == null) {
            this.mLoadingView = new d.a.h0.a.j2.d(this);
        }
        this.mLoadingView.A(1 == d.a.h0.a.r1.d.e().p().J().F(), z, aVar);
    }

    public void unregisterCallback(d.a.h0.a.o0.b bVar) {
        d.a.h0.a.o0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.G0(bVar);
        }
    }
}
