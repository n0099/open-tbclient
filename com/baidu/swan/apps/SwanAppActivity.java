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
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
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
import d.a.i0.a.a2.i;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.h0.p.a;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.j2.c;
import d.a.i0.a.v2.f0;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.p;
import d.a.i0.a.v2.q;
import d.a.i0.a.v2.v;
import d.a.i0.a.v2.x0;
import d.a.i0.a.z1.b.c.a;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, a.InterfaceC0924a, d.a.i0.a.n2.h.e, ServiceConnection {
    public static final int BACK_TYPE_SLIDE = 3;
    public static final int BACK_TYPE_SYSTEM = 1;
    public static final int BACK_TYPE_TITLE_BAR = 2;
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
    public d.a.i0.a.z1.b.c.a mFloatLayer;
    public d.a.i0.a.t0.c mFrame;
    public boolean mIsBackground;
    public d.a.i0.a.w2.e mLoadingView;
    public View mLocalDebugLayer;
    public Messenger mLocalService;
    public OrientationEventListener mOrientationListener;
    public ActivityResultDispatcher mResultDispatcher;
    public d.a.i0.a.v2.e mSlideHelper;
    @Nullable
    public d.a.i0.a.v2.c mTaskManager;
    public static final boolean DEBUG = d.a.i0.a.k.f43025a;
    public static final String COMPONENT_NAME = SwanAppActivity.class.getName();
    public static final long DELAY_TIME_FOR_LAUNCH_FAIL = TimeUnit.SECONDS.toMillis(1);
    public FrameLifeState mLifeStatus = FrameLifeState.INACTIVATED;
    public String mShowBy = "sys";
    public boolean mIsFromSchema = false;
    public final d.a.i0.a.a2.b mEventSubscriber = new d.a.i0.a.a2.b();
    public boolean restoreFromSaveInstance = false;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<i.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.showSwanAppStartView(true, aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.v2.e1.c<i.a, Boolean> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.c
        /* renamed from: b */
        public Boolean a(i.a aVar) {
            return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity.this.tryFinishAndRemoveTask();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.c1.a.n().d();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.c1.a.n().k();
            if (d.a.i0.a.r1.l.e.l()) {
                return;
            }
            p.i(SwanAppActivity.this);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* loaded from: classes2.dex */
        public class a extends OrientationEventListener {
            public a(f fVar, Context context, int i2) {
                super(context, i2);
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                d.a.i0.a.a2.d.g().f40564g = i2;
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

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.i0.a.i2.a.d().l();
            } catch (Exception e2) {
                if (SwanAppActivity.DEBUG) {
                    Log.e(SwanAppActivity.TAG, "SaveTraceException:", e2);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.a.i0.a.v2.e1.b<i.a> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.syncFrameLifeStatus();
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.a.i0.a.v2.e1.b<i.a> {
        public i() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.notifyInstallProgress(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements d.a.i0.a.v2.e1.b<i.a> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.onAppMaintainFinish();
        }
    }

    /* loaded from: classes2.dex */
    public class k implements d.a.i0.a.v2.e1.b<i.a> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.updateLoadingView(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class l implements d.a.i0.a.v2.e1.b<i.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.onAppUpdated(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class m implements d.a.i0.a.v2.e1.b<i.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            SwanAppActivity.this.onAppOccupied(aVar);
        }
    }

    private boolean hasLoadingView() {
        return (this.mLoadingView == null || isDestroyed()) ? false : true;
    }

    private void initEventHandler() {
        d.a.i0.a.a2.b bVar = this.mEventSubscriber;
        bVar.b(new b());
        bVar.e(new a(), "event_on_still_maintaining");
        bVar.e(new m(), "event_on_app_occupied");
        bVar.e(new l(), "event_on_app_updated");
        bVar.e(new k(), "event_on_app_icon_update");
        bVar.e(new j(), "event_on_pkg_maintain_finish");
        bVar.e(new i(), "installer_on_progress");
        bVar.e(new h(), "event_first_action_launched");
        d.a.i0.a.g1.g.a().c();
    }

    private boolean isInvalidComponentName(Intent intent) {
        if (intent != null) {
            ComponentName component = intent.getComponent();
            return (component == null || component.getClassName().startsWith(COMPONENT_NAME)) ? false : true;
        }
        return true;
    }

    private boolean isInvalidIntentAppId(String str) {
        d.a.i0.a.e0.d.h(TAG, "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + d.a.i0.a.a2.d.g().getAppId());
        boolean z = true;
        z = (!(d.a.i0.a.a2.d.g().r().C() && d.a.i0.a.a2.d.g().r().n0()) || TextUtils.equals(str, d.a.i0.a.a2.d.g().getAppId())) ? false : false;
        d.a.i0.a.e0.d.h(TAG, "isInvalidIntentAppId: isInValidIntent=" + z);
        if (z) {
            c.b bVar = new c.b(10017);
            bVar.l(str);
            bVar.h(d.a.i0.a.a2.d.g().getAppId());
            bVar.m();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyInstallProgress(d.a.i0.a.f1.e.f.c cVar) {
        if (hasLoadingView() && cVar.c(" event_params_installer_progress")) {
            this.mLoadingView.v(cVar.g(" event_params_installer_progress"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppMaintainFinish() {
        if (isDestroyed()) {
            return;
        }
        if (d.a.i0.a.a2.d.g().r().e()) {
            updateFrame(true);
        } else {
            d.a.i0.a.a2.d.i().postDelayed(new c(), DELAY_TIME_FOR_LAUNCH_FAIL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppOccupied(i.a aVar) {
        if (DEBUG) {
            Log.i(TAG, "onAppOccupied: ");
        }
        b.a L = d.a.i0.a.a2.d.g().r().L();
        setWindowFeature(L.d0(), L.G());
        showSwanAppStartView(false, aVar);
        d.a.i0.a.e0.d.g(TAG, "appName: " + L.K() + " appId: " + L.H());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAppUpdated(d.a.i0.a.f1.e.f.c cVar) {
        d.a.i0.a.t0.c cVar2 = this.mFrame;
        if (cVar2 == null || !cVar2.U()) {
            return;
        }
        updateFrame("update_tag_by_activity_on_new_intent".equals(cVar.n("app_update_tag")));
    }

    private void reportLaunchTrace() {
        d.a.i0.a.a2.e r = d.a.i0.a.a2.d.g().r();
        if (r != null) {
            String V = r.N().V();
            d.a.i0.a.f1.g.a d2 = d.a.i0.a.f1.g.a.d(r.N().V());
            d2.f("appId: " + r.f40575f + "  launchId: " + V).e();
            d2.h();
        }
    }

    private void setWindowFeature(int i2, int i3) {
        if (-1 < i2) {
            setRequestedOrientation(i2 == 1 ? 0 : 1);
        }
        if (i3 == 1) {
            if (f0.p(this)) {
                f0.s(this);
            }
            d.a.i0.a.v2.f.e(this);
        }
    }

    private synchronized boolean swapFrame(d.a.i0.a.a2.e eVar) {
        if (this.mFrame != null) {
            destroyFrame();
        }
        d.a.i0.a.t0.c a2 = d.a.i0.a.t0.e.a(this, eVar);
        if (a2 == null) {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.j(5L);
            aVar.h(11L);
            aVar.c("can not buildFramework");
            d.a.i0.a.f1.d.a.d(this, aVar, eVar.l(), eVar.f40575f);
            tryFinishAndRemoveTask();
            return false;
        }
        this.mFrame = a2;
        d dVar = new d();
        if (d.a.i0.a.r1.l.e.l()) {
            d.a.i0.a.r1.k.i.b.e().f(dVar, "updateMobStat");
        } else {
            q.j(dVar, "updateMobStat");
        }
        setWindowFeature(eVar.L().d0(), eVar.l());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void syncFrameLifeStatus() {
        transFrameLifeStatus(this.mLifeStatus);
    }

    private synchronized void transFrameLifeStatus(@NonNull FrameLifeState frameLifeState) {
        if (this.mFrame != null && !this.mFrame.X()) {
            this.mFrame.H0(frameLifeState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryFinishAndRemoveTask() {
        d.a.i0.a.v2.f.j(this);
    }

    private synchronized void updateFrame(boolean z) {
        d.a.i0.a.a2.e r = d.a.i0.a.a2.d.g().r();
        if (r.e()) {
            if (isActivedApp(r.getAppId()) || swapFrame(r)) {
                this.mFrame.K0(this.mLifeStatus, z);
                if (DEBUG) {
                    reportLaunchTrace();
                }
                if (this.mTaskManager == null && d.a.i0.a.v2.c.j()) {
                    d.a.i0.a.v2.c m2 = d.a.i0.a.v2.c.m();
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
    public void updateLoadingView(d.a.i0.a.f1.e.f.c cVar) {
        if (hasLoadingView()) {
            this.mLoadingView.K(cVar.n("app_icon_url"));
            this.mLoadingView.M(cVar.n("app_name"));
            if (d.a.i0.a.a2.d.g().r().L().G() == 0) {
                this.mLoadingView.N(cVar.i("app_pay_protected"));
            }
        }
    }

    public void addDebugRunningView() {
        if (this.mLocalDebugLayer == null) {
            this.mLocalDebugLayer = d.a.i0.a.e0.f.d.e.a(this);
        }
    }

    public boolean checkShowEntryGuideWhenBack() {
        d.a.i0.a.t0.c cVar = this.mFrame;
        return cVar != null && cVar.D();
    }

    public synchronized void destroyFrame() {
        if (this.mLoadingView != null) {
            this.mLoadingView.J();
            if (DEBUG) {
                Log.i(TAG, "destroyFrame resetLoadingView");
            }
        }
        d.a.i0.a.w2.e.B();
        d.a.i0.a.w2.e.A(d.a.i0.a.c1.a.b());
        d.a.i0.a.h0.g.g swanAppFragmentManager = getSwanAppFragmentManager();
        if (swanAppFragmentManager != null) {
            g.b h2 = swanAppFragmentManager.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        d.a.i0.a.p2.c.j();
        if (this.mFrame != null) {
            this.mFrame.H0(FrameLifeState.INACTIVATED);
            this.mFrame.y0();
            this.mFrame = null;
        }
        d.a.i0.a.e2.c.d.q();
        d.a.i0.a.a2.e r = d.a.i0.a.a2.d.g().r();
        r.T().j();
        r.j().a();
        d.a.i0.a.e2.d.a.x();
        d.a.i0.a.c1.b.o().a();
    }

    public final void doUBCEventStatistic(d.a.i0.a.j2.p.f fVar) {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.F(fVar);
        }
    }

    public void finishLoadingAnimator() {
        int i2 = (getLaunchInfo() == null || getLaunchInfo().d0() != 1) ? 2 : 3;
        if (getLoadingView() != null) {
            getLoadingView().H(i2);
        }
    }

    public String getActivedAppId() {
        d.a.i0.a.t0.c cVar = this.mFrame;
        return cVar == null ? "" : cVar.n;
    }

    @Override // d.a.i0.a.z1.b.c.a.InterfaceC0924a
    @NonNull
    public d.a.i0.a.z1.b.c.a getFloatLayer() {
        if (this.mFloatLayer == null) {
            this.mFloatLayer = new d.a.i0.a.z1.b.c.a(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.mFloatLayer;
    }

    public d.a.i0.a.t0.c getFrame() {
        return this.mFrame;
    }

    public int getFrameType() {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar == null) {
            return -1;
        }
        return cVar.l();
    }

    public b.a getLaunchInfo() {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar == null) {
            return null;
        }
        return cVar.O();
    }

    public d.a.i0.a.w2.e getLoadingView() {
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

    public d.a.i0.a.v2.e getSlideHelper() {
        return this.mSlideHelper;
    }

    @Nullable
    public d.a.i0.a.h0.g.g getSwanAppFragmentManager() {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar == null) {
            return null;
        }
        return cVar.R();
    }

    @Override // d.a.i0.a.n2.h.e
    public d.a.i0.a.n2.h.d getTrimMemoryDispatcher() {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar == null) {
            return null;
        }
        return cVar.S();
    }

    @UiThread
    public void handleSwanAppExit(int i2) {
        if (DEBUG) {
            Log.i(TAG, "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        d.a.i0.a.c1.a.D().d(this, i2, getLaunchInfo());
    }

    public synchronized boolean hasActivedFrame() {
        boolean z;
        if (!isDestroyed() && this.mFrame != null) {
            z = this.mFrame.P().activated();
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
        d.a.i0.a.t0.c cVar = this.mFrame;
        return cVar != null && cVar.V();
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
        boolean z3 = launchInfo != null && "1230000000000000".equals(launchInfo.T());
        d.a.i0.a.v2.c cVar = this.mTaskManager;
        if (cVar != null && !z3) {
            cVar.v(false);
        }
        if (hasActivedFrame() && !d.a.i0.a.a2.d.g().r().i0()) {
            try {
                boolean moveTaskToBack = super.moveTaskToBack(z);
                try {
                    overridePendingTransition(0, d.a.i0.a.a.aiapps_slide_out_to_right_zadjustment_top);
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
            d.a.i0.a.j2.k.Q();
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
        d.a.i0.a.p.e.j.c.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        onBackPressed(1);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.i0.o.a.a.f, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(d.a.i0.a.a.aiapps_slide_in_from_right, d.a.i0.a.a.aiapps_hold);
        SwanAppProcessInfo.init(getProcessInfo());
        d.a.i0.a.c1.a.C().b();
        d.a.i0.a.v1.c.e.a.E().Q();
        boolean z = true;
        this.mIsFromSchema = true;
        d.a.i0.a.j2.h.i(true);
        d.a.i0.a.j2.j.c(bundle == null ? 0 : 1);
        super.onCreate(bundle);
        updateLifeStatus(FrameLifeState.JUST_CREATED);
        if (v.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = d.a.i0.a.f1.e.d.a(intent);
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
        g.t.g(intent);
        if (DEBUG) {
            Log.i(TAG, "onCreate: bindService");
        }
        if (!a.C0683a.c()) {
            try {
                bindService(new Intent(this, getProcessInfo().service), this, 1);
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        if (Build.VERSION.SDK_INT == 26) {
            TranslucentUtils.convertFromTranslucent(this);
        }
        d.a.i0.a.e0.d.a(TAG, "SwanAppActivity onCreate() savedInstanceState=", bundle);
        d.a.i0.a.e0.d.g("SwanApp", "SwanAppActivity onCreate");
        setContentView(d.a.i0.a.g.aiapps_activity);
        n0.c(this);
        initEventHandler();
        d.a.i0.a.a2.d g2 = d.a.i0.a.a2.d.g();
        g2.u(this);
        g2.v(this.mEventSubscriber);
        if (intent != null && (a2 || bundle == null)) {
            intent.putExtra("receive_launch_intent_time", currentTimeMillis);
            Bundle extras = intent.getExtras();
            if (bundle == null || !isInvalidIntentAppId(extras.getString("mAppId"))) {
                d.a.i0.a.e0.d.h(TAG, "updateSwanApp by onCreate");
                g2.m(extras, "update_tag_by_activity_on_create");
            }
        }
        if (g2.C() && a2) {
            g2.r().L().H0("1250000000000000");
        }
        n0.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.mSlideHelper = new d.a.i0.a.v2.e(this);
        }
        d.a.i0.a.v2.e eVar = this.mSlideHelper;
        if (eVar != null) {
            eVar.u(false);
        }
        d.a.i0.a.v2.e eVar2 = this.mSlideHelper;
        if (eVar2 != null) {
            eVar2.n();
        }
        q.j(new e(), "initOnCreate");
        this.restoreFromSaveInstance = (bundle == null || bundle.getInt(KEY_SAVE_TASK_ID) != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d.a.i0.a.a2.d.g().p(this.mEventSubscriber);
        d.a.i0.a.e0.d.g("SwanApp", "SwanAppActivity onDestroy");
        this.mOrientationListener = null;
        destroyFrame();
        if (this.mLocalService != null) {
            unbindService(this);
        }
        d.a.i0.a.c1.a.D().b();
        d.a.i0.a.v2.e eVar = this.mSlideHelper;
        if (eVar != null) {
            eVar.p();
        }
        d.a.i0.a.a2.d.g().s(this);
        updateLifeStatus(FrameLifeState.INACTIVATED);
        d.a.i0.a.g1.f.c0();
        String appId = d.a.i0.a.a2.d.g().getAppId();
        if (DEBUG) {
            d.a.i0.a.f1.g.a d2 = d.a.i0.a.f1.g.a.d(appId);
            d2.e().c();
            d2.h();
        }
        d.a.i0.a.a2.d.g().o(new String[0]);
        this.mTaskManager = null;
        super.onDestroy();
        d.a.i0.a.g1.g.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if ((cVar == null || !cVar.g0(i2, keyEvent)) && this.mLocalDebugLayer == null) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        d.a.i0.a.e0.d.g("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(d.a.i0.a.a.aiapps_slide_in_from_right, d.a.i0.a.a.aiapps_hold);
        if (DEBUG) {
            int flags = intent.getFlags();
            StringBuilder sb = new StringBuilder();
            sb.append("onNewIntent:REORDER_TO_FRONT = ");
            sb.append((flags & 131072) == 131072);
            Log.i(TAG, sb.toString());
        }
        d.a.i0.a.v2.e eVar = this.mSlideHelper;
        if (eVar != null) {
            eVar.r();
        }
        this.mIsFromSchema = true;
        d.a.i0.a.j2.h.i(true);
        d.a.i0.a.a2.d g2 = d.a.i0.a.a2.d.g();
        g2.m(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (g2.C() && d.a.i0.a.f1.e.d.a(intent)) {
            g2.r().N().H0("1250000000000000");
        }
        d.a.i0.a.v2.c cVar = this.mTaskManager;
        if (cVar != null) {
            cVar.z(intent, getTaskId());
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        d.a.i0.a.e0.d.g("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        updateLifeStatus(FrameLifeState.JUST_STARTED);
        this.mIsFromSchema = false;
        d.a.i0.a.j2.h.i(false);
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        d.a.i0.a.v2.e eVar = this.mSlideHelper;
        if (eVar != null) {
            eVar.k();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        d.a.i0.a.e0.d.g("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !d.a.i0.a.a2.d.g().C()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            d.a.i0.a.a2.d.g().m(intent.getExtras(), "update_tag_by_activity_on_create");
            if (d.a.i0.a.a2.d.g().C() && d.a.i0.a.f1.e.d.a(intent)) {
                d.a.i0.a.a2.d.g().r().L().H0("1250000000000000");
            }
        }
        markShowByStatus();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new f(), "OrientationEventListener", 2);
        d.a.i0.a.v2.e eVar = this.mSlideHelper;
        if (eVar != null) {
            eVar.s();
        }
        updateLifeStatus(FrameLifeState.JUST_RESUMED);
        x0.b().d();
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
        d.a.i0.a.e0.d.g("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.mIsBackground = false;
        d.a.i0.a.v2.e eVar = this.mSlideHelper;
        if (eVar != null) {
            eVar.e();
        }
        updateLifeStatus(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        d.a.i0.a.e0.d.g("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.mIsBackground = true;
        updateLifeStatus(FrameLifeState.JUST_CREATED);
        if (!hasActivedFrame()) {
            d.a.i0.a.r1.h.m();
        }
        q.j(new g(), "tracer");
        d.a.i0.a.c1.a.g0().c(false);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (hasActivedFrame()) {
            this.mFrame.u0(i2);
        }
    }

    public void preloadNextSwanAppProcess(Bundle bundle) {
        d.a.i0.a.v1.c.f.b.k(this, bundle);
    }

    public void registerCallback(d.a.i0.a.t0.b bVar) {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.x0(bVar);
        }
    }

    public void removeDebugRunningView() {
        View view = this.mLocalDebugLayer;
        if (view != null) {
            d.a.i0.a.e0.f.d.e.d(this, view);
            this.mLocalDebugLayer = null;
        }
    }

    public void removeLoadingView() {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.A0();
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
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.C0();
        }
    }

    public void showSwanAppStartView(boolean z, @Nullable i.a aVar) {
        if (this.mLoadingView == null) {
            this.mLoadingView = new d.a.i0.a.w2.e(this);
        }
        this.mLoadingView.F(1 == d.a.i0.a.a2.d.g().r().L().G(), z, aVar);
    }

    public void unregisterCallback(d.a.i0.a.t0.b bVar) {
        d.a.i0.a.t0.c cVar = this.mFrame;
        if (cVar != null) {
            cVar.J0(bVar);
        }
    }

    public void onBackPressed(int i2) {
        d.a.i0.a.e0.d.g("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (hasActivedFrame()) {
            this.mFrame.a0(i2);
            return;
        }
        HybridUbcFlow m2 = d.a.i0.a.r1.h.m();
        if (m2 != null) {
            m2.B("value", QueryResponse.Options.CANCEL);
            m2.A("exitType", String.valueOf(4));
            m2.l();
        }
        d.a.i0.a.g1.g.a().d(false);
        moveTaskToBack(true);
    }
}
