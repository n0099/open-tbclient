package com.baidu.swan.apps;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
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
import androidx.fragment.app.FragmentActivity;
import androidx.media2.session.SessionCommand;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.process.ipc.util.TranslucentUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ag3;
import com.baidu.tieba.av2;
import com.baidu.tieba.bl3;
import com.baidu.tieba.bm4;
import com.baidu.tieba.cw1;
import com.baidu.tieba.dn3;
import com.baidu.tieba.eg3;
import com.baidu.tieba.f33;
import com.baidu.tieba.fg3;
import com.baidu.tieba.fl3;
import com.baidu.tieba.fm3;
import com.baidu.tieba.fo3;
import com.baidu.tieba.fp3;
import com.baidu.tieba.gg2;
import com.baidu.tieba.gm3;
import com.baidu.tieba.gn3;
import com.baidu.tieba.gu2;
import com.baidu.tieba.h63;
import com.baidu.tieba.hg2;
import com.baidu.tieba.ho3;
import com.baidu.tieba.j93;
import com.baidu.tieba.jl3;
import com.baidu.tieba.ju2;
import com.baidu.tieba.k63;
import com.baidu.tieba.ke3;
import com.baidu.tieba.kf3;
import com.baidu.tieba.km2;
import com.baidu.tieba.l93;
import com.baidu.tieba.lm2;
import com.baidu.tieba.lm3;
import com.baidu.tieba.lu2;
import com.baidu.tieba.m62;
import com.baidu.tieba.m93;
import com.baidu.tieba.mf3;
import com.baidu.tieba.mz2;
import com.baidu.tieba.n33;
import com.baidu.tieba.ng3;
import com.baidu.tieba.nm2;
import com.baidu.tieba.on3;
import com.baidu.tieba.oo3;
import com.baidu.tieba.pg3;
import com.baidu.tieba.pu2;
import com.baidu.tieba.q93;
import com.baidu.tieba.r23;
import com.baidu.tieba.rj3;
import com.baidu.tieba.ru2;
import com.baidu.tieba.sj3;
import com.baidu.tieba.sl3;
import com.baidu.tieba.t83;
import com.baidu.tieba.te2;
import com.baidu.tieba.ts2;
import com.baidu.tieba.u82;
import com.baidu.tieba.uf3;
import com.baidu.tieba.ul3;
import com.baidu.tieba.ul4;
import com.baidu.tieba.us2;
import com.baidu.tieba.v82;
import com.baidu.tieba.vl3;
import com.baidu.tieba.vm3;
import com.baidu.tieba.w62;
import com.baidu.tieba.wp1;
import com.baidu.tieba.xc3;
import com.baidu.tieba.ye3;
import com.baidu.tieba.z82;
import com.baidu.tieba.zu2;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, t83.a, sj3, ServiceConnection {
    public static final boolean B = wp1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public lm2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public sl3 q;
    public boolean t;
    public OrientationEventListener u;
    public ul3 v;
    public oo3 w;
    public t83 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final j93 y = new j93();
    public boolean z = false;

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* loaded from: classes3.dex */
        public class a extends OrientationEventListener {
            public a(j jVar, Context context, int i) {
                super(context, i);
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                l93.K().c = i;
            }
        }

        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity swanAppActivity = SwanAppActivity.this;
            if (swanAppActivity.u == null) {
                swanAppActivity.u = new a(this, SwanAppActivity.this, 2);
            }
            if (SwanAppActivity.this.d) {
                SwanAppActivity.this.u.enable();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements fo3<q93.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements fo3<q93.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.m0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements fo3<q93.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.A0(true, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ho3<q93.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ho3
        /* renamed from: b */
        public Boolean a(q93.a aVar) {
            return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity.this.E0();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            zu2 U = zu2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                v82 V = U.V();
                if (V == null) {
                    m62.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    m62.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (V == null) {
                    m62.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    u82.S3(null);
                    v82.b i = V.i("init");
                    int i2 = v82.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", mz2.d(str, str), true).a();
                    oo3 T = activity.T();
                    if (T != null) {
                        T.F(1);
                    }
                    fl3 fl3Var = new fl3();
                    fl3Var.k(1L);
                    fl3Var.i(2110L);
                    fl3Var.f("host url" + this.a);
                    jl3.a().f(fl3Var);
                    ng3 ng3Var = new ng3();
                    ng3Var.p(fl3Var);
                    ng3Var.r(l93.K().q().W());
                    ng3Var.q(fg3.n(l93.K().k()));
                    ng3Var.m(l93.K().getAppId());
                    fg3.R(ng3Var);
                    return;
                }
            }
            m62.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ts2.o().d();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (kf3.d()) {
                kf3.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ts2.o().k();
            if (!n33.h()) {
                fm3.m(SwanAppActivity.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                mf3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements fo3<q93.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.o0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements fo3<q93.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.C0();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements fo3<q93.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.k0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements fo3<q93.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.l0();
        }
    }

    /* loaded from: classes3.dex */
    public class p implements fo3<q93.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fo3
        /* renamed from: b */
        public void a(q93.a aVar) {
            SwanAppActivity.this.I0(aVar);
        }
    }

    public final synchronized void C0() {
        D0(this.o);
    }

    public final void E0() {
        vl3.j(this);
    }

    public void L() {
        if (this.A == null) {
            this.A = w62.a(this);
        }
    }

    public void O() {
        int i2;
        if (S() != null && S().d0() == 1) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        if (T() != null) {
            T().F(i2);
        }
    }

    public String P() {
        lm2 lm2Var = this.m;
        if (lm2Var == null) {
            return "";
        }
        return lm2Var.i;
    }

    public lm2 Q() {
        return this.m;
    }

    public int R() {
        lm2 lm2Var = this.m;
        if (lm2Var == null) {
            return -1;
        }
        return lm2Var.k();
    }

    public ju2.a S() {
        lm2 lm2Var = this.m;
        if (lm2Var == null) {
            return null;
        }
        return lm2Var.Z();
    }

    public oo3 T() {
        return this.w;
    }

    public SwanAppProcessInfo U() {
        return SwanAppProcessInfo.P0;
    }

    public String V() {
        return this.r;
    }

    public ul3 W() {
        return this.v;
    }

    @Nullable
    public v82 X() {
        lm2 lm2Var = this.m;
        if (lm2Var == null) {
            return null;
        }
        return lm2Var.c0();
    }

    public synchronized boolean Z() {
        boolean z;
        if (!isDestroyed() && this.m != null) {
            if (this.m.a0().activated()) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public final boolean a0() {
        return !TextUtils.isEmpty(bm4.e().b());
    }

    @Override // com.baidu.tieba.sj3
    public rj3 b() {
        lm2 lm2Var = this.m;
        if (lm2Var == null) {
            return null;
        }
        return lm2Var.d0();
    }

    public final boolean b0() {
        if (this.w != null && !isDestroyed()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.t83.a
    @NonNull
    public t83 d() {
        if (this.x == null) {
            this.x = new t83(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.x;
    }

    public boolean e0() {
        return this.t;
    }

    public final boolean f0() {
        PMSAppInfo f0 = l93.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (B) {
            m62.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.p == null) {
            this.p = new ActivityResultDispatcher(this, 1);
        }
        return this.p;
    }

    public boolean i0() {
        lm2 lm2Var = this.m;
        if (lm2Var != null && lm2Var.g0()) {
            return true;
        }
        return false;
    }

    public void j0() {
        if (this.s) {
            this.r = "schema";
        } else {
            this.r = "user";
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        p0(1);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        m62.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        H0(FrameLifeState.JUST_STARTED);
        this.s = false;
        ag3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        m62.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        ul3 ul3Var = this.v;
        if (ul3Var != null) {
            ul3Var.e();
        }
        H0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        m62.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        H0(FrameLifeState.JUST_CREATED);
        if (!Z()) {
            r23.m();
        }
        gm3.k(new k(), "tracer");
        ts2.p0().flush(false);
    }

    public void u0() {
        View view2 = this.A;
        if (view2 != null) {
            w62.d(this, view2);
            this.A = null;
        }
    }

    public void v0() {
        lm2 lm2Var = this.m;
        if (lm2Var != null) {
            lm2Var.K0();
        }
    }

    public void z0() {
        lm2 lm2Var = this.m;
        if (lm2Var != null) {
            lm2Var.M0();
        }
    }

    public final synchronized void D0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void F0(km2 km2Var) {
        lm2 lm2Var = this.m;
        if (lm2Var != null) {
            lm2Var.T0(km2Var);
        }
    }

    public final synchronized void H0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        C0();
    }

    public final void N(pg3 pg3Var) {
        lm2 lm2Var = this.m;
        if (lm2Var != null) {
            lm2Var.Q(pg3Var);
        }
    }

    @UiThread
    public void Y(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        ts2.H().d(this, i2, S());
    }

    public boolean d0(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, P())) {
            return true;
        }
        return false;
    }

    public final boolean g0(Intent intent) {
        if (intent == null) {
            return true;
        }
        ComponentName component = intent.getComponent();
        if (component != null && !component.getClassName().startsWith(C)) {
            return true;
        }
        return false;
    }

    public final void k0(pu2 pu2Var) {
        if (b0() && pu2Var.b(" event_params_installer_progress")) {
            this.w.u(pu2Var.g(" event_params_installer_progress"));
        }
    }

    public final void n0(pu2 pu2Var) {
        lm2 lm2Var = this.m;
        if (lm2Var != null && lm2Var.f0()) {
            G0("update_tag_by_activity_on_new_intent".equals(pu2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ul3 ul3Var = this.v;
        if (ul3Var != null) {
            ul3Var.n();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle.get(FragmentActivity.FRAGMENTS_TAG) != null) {
            bundle.remove(FragmentActivity.FRAGMENTS_TAG);
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putBundle("swan_key_save_bundle", intent.getExtras());
            bundle.putInt("swan_key_save_task_id", getTaskId());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (B) {
            Log.i("SwanAppActivity", "onServiceDisconnected: " + componentName);
        }
        this.n = null;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (Z()) {
            this.m.F0(i2);
        }
    }

    public void q0(String str) {
        G0(true);
        gg2.U().b1(str);
    }

    public final void r0(String str) {
        gn3.e0(new f(str));
    }

    public void s0(Bundle bundle) {
        k63.k(this, bundle);
    }

    public void t0(km2 km2Var) {
        lm2 lm2Var = this.m;
        if (lm2Var != null) {
            lm2Var.I0(km2Var);
        }
    }

    public void x0(String... strArr) {
        HashSet newHashSet;
        M();
        if (strArr == null) {
            newHashSet = Sets.newHashSet();
        } else {
            newHashSet = Sets.newHashSet(strArr);
        }
        if (newHashSet.contains("flag_finish_activity")) {
            if (newHashSet.contains("flag_remove_task")) {
                E0();
            } else {
                finish();
            }
        }
    }

    public void A0(boolean z, @Nullable q93.a aVar) {
        if (this.w == null) {
            this.w = new oo3(this);
        }
        oo3 oo3Var = this.w;
        boolean z2 = true;
        if (1 != l93.K().q().W().G()) {
            z2 = false;
        }
        oo3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        lm2 lm2Var = this.m;
        if ((lm2Var != null && lm2Var.r0(i2, keyEvent)) || this.A != null) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (B) {
            Log.i("SwanAppActivity", "onServiceConnected: " + componentName);
        }
        if (iBinder != null) {
            this.n = new Messenger(iBinder);
        }
    }

    public final void y0(int i2, int i3) {
        int i4;
        if (-1 < i2) {
            if (i2 == 1) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            setRequestedOrientation(i4);
        }
        if (i3 == 1) {
            if (vm3.p(this)) {
                vm3.s(this);
            }
            vl3.e(this);
        }
    }

    public final synchronized boolean B0(m93 m93Var) {
        if (this.m != null) {
            M();
        }
        lm2 a2 = nm2.a(this, m93Var);
        if (a2 == null) {
            fl3 fl3Var = new fl3();
            fl3Var.k(5L);
            fl3Var.i(11L);
            fl3Var.d("can not buildFramework");
            gu2.e(this, fl3Var, m93Var.k(), m93Var.b);
            E0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (n33.h()) {
            f33.e().d(gVar, "updateMobStat", false);
        } else {
            gm3.k(gVar, "updateMobStat");
        }
        y0(m93Var.W().d0(), m93Var.k());
        return true;
    }

    public final void m0(q93.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        ju2.a W = l93.K().q().W();
        y0(W.d0(), W.G());
        A0(false, aVar);
        m62.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        ju2.a S = S();
        boolean z3 = false;
        if (S != null && "1230000000000000".equals(S.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        sl3 sl3Var = this.q;
        if (sl3Var != null && !z2) {
            sl3Var.v(false);
        }
        if (Z() && !l93.K().q().s0()) {
            try {
                boolean moveTaskToBack = super.moveTaskToBack(z);
                try {
                    overridePendingTransition(0, R.anim.obfuscated_res_0x7f010026);
                    return moveTaskToBack;
                } catch (Exception e2) {
                    e = e2;
                    z3 = moveTaskToBack;
                    if (B) {
                        e.printStackTrace();
                    }
                    return z3;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            fg3.Y();
            E0();
            return false;
        }
    }

    public void p0(int i2) {
        m62.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (Z()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = r23.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        av2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void G0(boolean z) {
        m93 q = l93.K().q();
        if (!q.I()) {
            m62.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!d0(q.getAppId()) && !B0(q)) {
            m62.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            m62.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                w0();
            }
            if (this.q == null && sl3.j()) {
                sl3 m2 = sl3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(S(), getTaskId());
                }
            }
        }
    }

    public final boolean h0(String str) {
        boolean z;
        m62.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + l93.K().getAppId());
        boolean z2 = true;
        if (l93.K().q().E() && l93.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, l93.K().getAppId())) ? false : false;
        m62.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            uf3.b bVar = new uf3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(l93.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void I0(pu2 pu2Var) {
        if (b0()) {
            this.w.I(pu2Var.n("app_icon_url"));
            this.w.K(pu2Var.n("app_name"));
            if (l93.K().q().W().G() == 0) {
                this.w.L(pu2Var.i("app_pay_protected"));
            }
        }
    }

    public synchronized void M() {
        if (this.w != null) {
            this.w.H();
            if (B) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        oo3.A();
        oo3.z(ts2.c());
        v82 X = X();
        if (X != null) {
            v82.b h2 = X.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        bl3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        ke3.r();
        m93 q = l93.K().q();
        q.e0().j();
        q.N().a();
        ye3.x();
        us2.o().a();
    }

    public final void c0() {
        j93 j93Var = this.y;
        j93Var.c(new d());
        j93Var.f(new c(), "event_on_still_maintaining");
        j93Var.f(new b(), "event_on_app_occupied");
        j93Var.f(new a(), "event_on_app_updated");
        j93Var.f(new p(), "event_on_app_icon_update");
        j93Var.f(new o(), "event_on_pkg_maintain_finish");
        j93Var.f(new n(), "installer_on_progress");
        j93Var.f(new m(), "event_first_action_launched");
        j93Var.f(new l(), "event_on_web_mode_launched");
        av2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        l93.K().o(this.y);
        m62.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        M();
        if (this.n != null) {
            unbindService(this);
        }
        ts2.H().b();
        ul3 ul3Var = this.v;
        if (ul3Var != null) {
            ul3Var.p();
        }
        l93.K().r(this);
        H0(FrameLifeState.INACTIVATED);
        zu2.b0();
        String appId = l93.K().getAppId();
        if (B) {
            ru2 d2 = ru2.d(appId);
            d2.e().c();
            d2.h();
        }
        kf3.l(true);
        l93.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        av2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        m62.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !l93.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            l93.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (l93.K().E() && lu2.a(intent)) {
                l93.K().q().W().I0("1250000000000000");
            }
        }
        j0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        ul3 ul3Var = this.v;
        if (ul3Var != null) {
            ul3Var.t();
        }
        H0(FrameLifeState.JUST_RESUMED);
        on3.b().d();
    }

    public final void l0() {
        if (z82.b.a()) {
            q0(fp3.b(xc3.e()));
        } else if (!isDestroyed()) {
            if (l93.K().q().I()) {
                G0(true);
            } else {
                l93.M().postDelayed(new e(), D);
            }
        }
    }

    public final void w0() {
        m93 q = l93.K().q();
        if (q != null) {
            String V = q.Y().V();
            ru2 d2 = ru2.d(q.Y().V());
            d2.f("appId: " + q.b + "  launchId: " + V).e();
            d2.h();
        }
    }

    public final void o0(String str) {
        if (!TextUtils.isEmpty(str)) {
            q0(str);
        } else if (isDestroyed()) {
            m62.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (z82.b.a() && l93.K().q().z0() && ul4.d()) {
            G0(true);
            gg2.U().a1();
        } else if (a0() && !f0()) {
            G0(true);
            r0(bm4.e().b());
        } else if (l93.K().q().z0() && ul4.d()) {
            G0(true);
            gg2.U().a1();
        } else {
            String D2 = ts2.o().D();
            if (ts2.a().c() && !gn3.G() && !TextUtils.isEmpty(D2)) {
                G0(true);
                r0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", l93.K().getAppId()).build().toString());
                return;
            }
            fl3 fl3Var = new fl3();
            fl3Var.k(1L);
            fl3Var.i(2109L);
            fl3Var.f("web mode start failed.");
            if (f0()) {
                jl3.a().f(fl3Var);
                ng3 ng3Var = new ng3();
                ng3Var.p(fl3Var);
                ng3Var.r(l93.K().q().W());
                ng3Var.q(fg3.n(l93.K().k()));
                ng3Var.m(l93.K().getAppId());
                fg3.R(ng3Var);
            }
            gu2.e(ts2.c(), fl3Var, 0, "");
            E0();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        cw1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.cn4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        hg2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        SwanAppProcessInfo.init(U());
        ts2.G().b();
        h63.Q().c0();
        boolean z2 = true;
        this.s = true;
        ag3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        eg3.d(i2);
        super.onCreate(bundle);
        H0(FrameLifeState.JUST_CREATED);
        if (lm3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = lu2.a(intent);
        if (a2) {
            intent.putExtra("launch_id", SwanLauncher.h());
        }
        if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
            ClassLoader classLoader = getClass().getClassLoader();
            bundle2.setClassLoader(classLoader);
            intent.setExtrasClassLoader(classLoader);
            intent.putExtras(bundle2);
        }
        if (g0(intent)) {
            E0();
            return;
        }
        gg2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!te2.a.c()) {
            try {
                bindService(new Intent(this, U().service), this, 1);
            } catch (Exception e2) {
                if (B) {
                    e2.printStackTrace();
                }
            }
        }
        if (Build.VERSION.SDK_INT == 26) {
            TranslucentUtils.convertFromTranslucent(this);
        }
        m62.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        m62.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0094);
        if (R() == 0) {
            dn3.c(this);
        }
        c0();
        l93 K = l93.K();
        K.t(this);
        K.u(this.y);
        if (intent != null && (a2 || bundle == null)) {
            intent.putExtra("receive_launch_intent_time", currentTimeMillis);
            Bundle extras = intent.getExtras();
            String string = extras.getString("mAppId");
            if (bundle != null && h0(string)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                m62.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        dn3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new ul3(this);
        }
        ul3 ul3Var = this.v;
        if (ul3Var != null) {
            ul3Var.u(false);
        }
        ul3 ul3Var2 = this.v;
        if (ul3Var2 != null) {
            ul3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        gm3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        hg2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        m62.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        if (B) {
            int flags = intent.getFlags();
            StringBuilder sb = new StringBuilder();
            sb.append("onNewIntent:REORDER_TO_FRONT = ");
            if ((flags & 131072) == 131072) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            Log.i("SwanAppActivity", sb.toString());
        }
        ul3 ul3Var = this.v;
        if (ul3Var != null) {
            ul3Var.r();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            m62.i("SwanAppActivity", "onNewIntent: start swan web");
            l93.K().q().A0();
        }
        this.s = true;
        ag3.l(true);
        l93 K = l93.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && lu2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        sl3 sl3Var = this.q;
        if (sl3Var != null) {
            sl3Var.z(intent, getTaskId());
        }
    }
}
