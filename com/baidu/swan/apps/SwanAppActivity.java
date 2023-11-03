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
import com.baidu.tieba.ad2;
import com.baidu.tieba.aj3;
import com.baidu.tieba.ak3;
import com.baidu.tieba.ar2;
import com.baidu.tieba.b33;
import com.baidu.tieba.bd2;
import com.baidu.tieba.bl3;
import com.baidu.tieba.d63;
import com.baidu.tieba.di3;
import com.baidu.tieba.dr2;
import com.baidu.tieba.e33;
import com.baidu.tieba.eb3;
import com.baidu.tieba.ec3;
import com.baidu.tieba.ej2;
import com.baidu.tieba.f63;
import com.baidu.tieba.fj2;
import com.baidu.tieba.fj3;
import com.baidu.tieba.fr2;
import com.baidu.tieba.g32;
import com.baidu.tieba.g63;
import com.baidu.tieba.gc3;
import com.baidu.tieba.gw2;
import com.baidu.tieba.h03;
import com.baidu.tieba.hd3;
import com.baidu.tieba.hj2;
import com.baidu.tieba.ik3;
import com.baidu.tieba.il3;
import com.baidu.tieba.jd3;
import com.baidu.tieba.jr2;
import com.baidu.tieba.k63;
import com.baidu.tieba.lg3;
import com.baidu.tieba.lr2;
import com.baidu.tieba.lz2;
import com.baidu.tieba.mg3;
import com.baidu.tieba.mi3;
import com.baidu.tieba.n53;
import com.baidu.tieba.nb2;
import com.baidu.tieba.np2;
import com.baidu.tieba.o52;
import com.baidu.tieba.oc3;
import com.baidu.tieba.oi3;
import com.baidu.tieba.oi4;
import com.baidu.tieba.op2;
import com.baidu.tieba.p52;
import com.baidu.tieba.pi3;
import com.baidu.tieba.pj3;
import com.baidu.tieba.q32;
import com.baidu.tieba.r93;
import com.baidu.tieba.rm1;
import com.baidu.tieba.sb3;
import com.baidu.tieba.t52;
import com.baidu.tieba.tr2;
import com.baidu.tieba.uc3;
import com.baidu.tieba.ur2;
import com.baidu.tieba.vh3;
import com.baidu.tieba.vi4;
import com.baidu.tieba.xj3;
import com.baidu.tieba.xs1;
import com.baidu.tieba.yc3;
import com.baidu.tieba.zc3;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zi3;
import com.baidu.tieba.zk3;
import com.baidu.tieba.zl3;
import com.baidu.tieba.zz2;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, n53.a, mg3, ServiceConnection {
    public static final boolean B = rm1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public fj2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public mi3 q;
    public boolean t;
    public OrientationEventListener u;
    public oi3 v;
    public il3 w;
    public n53 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final d63 y = new d63();
    public boolean z = false;

    /* loaded from: classes4.dex */
    public class j implements Runnable {

        /* loaded from: classes4.dex */
        public class a extends OrientationEventListener {
            public a(j jVar, Context context, int i) {
                super(context, i);
            }

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                f63.K().c = i;
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

    /* loaded from: classes4.dex */
    public class a implements zk3<k63.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zk3<k63.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements zk3<k63.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements bl3<k63.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bl3
        /* renamed from: b */
        public Boolean a(k63.a aVar) {
            return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity.this.F0();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            tr2 V = tr2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                p52 W = V.W();
                if (W == null) {
                    g32.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    g32.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (W == null) {
                    g32.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    o52.Z3(null);
                    p52.b i = W.i("init");
                    int i2 = p52.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", gw2.d(str, str), true).a();
                    il3 U = activity.U();
                    if (U != null) {
                        U.F(1);
                    }
                    zh3 zh3Var = new zh3();
                    zh3Var.k(1L);
                    zh3Var.i(2110L);
                    zh3Var.f("host url" + this.a);
                    di3.a().f(zh3Var);
                    hd3 hd3Var = new hd3();
                    hd3Var.p(zh3Var);
                    hd3Var.r(f63.K().q().X());
                    hd3Var.q(zc3.n(f63.K().k()));
                    hd3Var.m(f63.K().getAppId());
                    zc3.R(hd3Var);
                    return;
                }
            }
            g32.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            np2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ec3.d()) {
                ec3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            np2.o().k();
            if (!h03.h()) {
                zi3.m(SwanAppActivity.this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                gc3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements zk3<k63.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements zk3<k63.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements zk3<k63.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements zk3<k63.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements zk3<k63.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(k63.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        fj2 fj2Var = this.m;
        if (fj2Var != null) {
            fj2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        pi3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = q32.a(this);
        }
    }

    public void P() {
        int i2;
        if (T() != null && T().e0() == 1) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        if (U() != null) {
            U().F(i2);
        }
    }

    public String Q() {
        fj2 fj2Var = this.m;
        if (fj2Var == null) {
            return "";
        }
        return fj2Var.i;
    }

    public fj2 R() {
        return this.m;
    }

    public int S() {
        fj2 fj2Var = this.m;
        if (fj2Var == null) {
            return -1;
        }
        return fj2Var.k();
    }

    public dr2.a T() {
        fj2 fj2Var = this.m;
        if (fj2Var == null) {
            return null;
        }
        return fj2Var.Z();
    }

    public il3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public oi3 X() {
        return this.v;
    }

    @Nullable
    public p52 Y() {
        fj2 fj2Var = this.m;
        if (fj2Var == null) {
            return null;
        }
        return fj2Var.c0();
    }

    public synchronized boolean a0() {
        boolean z;
        if (!isDestroyed() && this.m != null) {
            if (this.m.a0().activated()) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    @Override // com.baidu.tieba.mg3
    public lg3 b() {
        fj2 fj2Var = this.m;
        if (fj2Var == null) {
            return null;
        }
        return fj2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(vi4.e().b());
    }

    public final boolean c0() {
        if (this.w != null && !isDestroyed()) {
            return true;
        }
        return false;
    }

    public boolean f0() {
        return this.t;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (B) {
            g32.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo g0 = f63.K().q().X().g0();
        if (g0 == null || g0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.n53.a
    @NonNull
    public n53 getFloatLayer() {
        if (this.x == null) {
            this.x = new n53(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.x;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.p == null) {
            this.p = new ActivityResultDispatcher(this, 1);
        }
        return this.p;
    }

    public boolean j0() {
        fj2 fj2Var = this.m;
        if (fj2Var != null && fj2Var.g0()) {
            return true;
        }
        return false;
    }

    public void k0() {
        if (this.s) {
            this.r = "schema";
        } else {
            this.r = "user";
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        q0(1);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        g32.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        uc3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        g32.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        oi3 oi3Var = this.v;
        if (oi3Var != null) {
            oi3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        g32.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            lz2.m();
        }
        aj3.k(new k(), "tracer");
        np2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            q32.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        fj2 fj2Var = this.m;
        if (fj2Var != null) {
            fj2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(ej2 ej2Var) {
        fj2 fj2Var = this.m;
        if (fj2Var != null) {
            fj2Var.T0(ej2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(jd3 jd3Var) {
        fj2 fj2Var = this.m;
        if (fj2Var != null) {
            fj2Var.Q(jd3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        np2.H().d(this, i2, T());
    }

    public boolean e0(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, Q())) {
            return true;
        }
        return false;
    }

    public final boolean h0(Intent intent) {
        if (intent == null) {
            return true;
        }
        ComponentName component = intent.getComponent();
        if (component != null && !component.getClassName().startsWith(C)) {
            return true;
        }
        return false;
    }

    public final void l0(jr2 jr2Var) {
        if (c0() && jr2Var.b(" event_params_installer_progress")) {
            this.w.u(jr2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(jr2 jr2Var) {
        fj2 fj2Var = this.m;
        if (fj2Var != null && fj2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(jr2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        oi3 oi3Var = this.v;
        if (oi3Var != null) {
            oi3Var.n();
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
        if (a0()) {
            this.m.F0(i2);
        }
    }

    public void r0(String str) {
        H0(true);
        ad2.V().c1(str);
    }

    public final void s0(String str) {
        ak3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        e33.k(this, bundle);
    }

    public void u0(ej2 ej2Var) {
        fj2 fj2Var = this.m;
        if (fj2Var != null) {
            fj2Var.I0(ej2Var);
        }
    }

    public void y0(String... strArr) {
        HashSet newHashSet;
        N();
        if (strArr == null) {
            newHashSet = Sets.newHashSet();
        } else {
            newHashSet = Sets.newHashSet(strArr);
        }
        if (newHashSet.contains("flag_finish_activity")) {
            if (newHashSet.contains("flag_remove_task")) {
                F0();
            } else {
                finish();
            }
        }
    }

    public void B0(boolean z, @Nullable k63.a aVar) {
        if (this.w == null) {
            this.w = new il3(this);
        }
        il3 il3Var = this.w;
        boolean z2 = true;
        if (1 != f63.K().q().X().H()) {
            z2 = false;
        }
        il3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        fj2 fj2Var = this.m;
        if ((fj2Var != null && fj2Var.r0(i2, keyEvent)) || this.A != null) {
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

    public final void z0(int i2, int i3) {
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
            if (pj3.p(this)) {
                pj3.s(this);
            }
            pi3.e(this);
        }
    }

    public final synchronized boolean C0(g63 g63Var) {
        if (this.m != null) {
            N();
        }
        fj2 a2 = hj2.a(this, g63Var);
        if (a2 == null) {
            zh3 zh3Var = new zh3();
            zh3Var.k(5L);
            zh3Var.i(11L);
            zh3Var.d("can not buildFramework");
            ar2.e(this, zh3Var, g63Var.k(), g63Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (h03.h()) {
            zz2.e().d(gVar, "updateMobStat", false);
        } else {
            aj3.k(gVar, "updateMobStat");
        }
        z0(g63Var.X().e0(), g63Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        dr2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.U())) {
            z2 = true;
        } else {
            z2 = false;
        }
        mi3 mi3Var = this.q;
        if (mi3Var != null && !z2) {
            mi3Var.v(false);
        }
        if (a0() && !f63.K().q().t0()) {
            try {
                boolean moveTaskToBack = super.moveTaskToBack(z);
                try {
                    overridePendingTransition(0, R.anim.obfuscated_res_0x7f010027);
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
            zc3.Y();
            F0();
            return false;
        }
    }

    public final void n0(k63.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        dr2.a X = f63.K().q().X();
        z0(X.e0(), X.H());
        B0(false, aVar);
        g32.i("SwanAppActivity", "appName: " + X.L() + " appId: " + X.I());
    }

    public void q0(int i2) {
        g32.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = lz2.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        ur2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        g63 q = f63.K().q();
        if (!q.I()) {
            g32.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            g32.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.U0(this.o, z);
            g32.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && mi3.j()) {
                mi3 m2 = mi3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        g32.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + f63.K().getAppId());
        boolean z2 = true;
        if (f63.K().q().E() && f63.K().q().y0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, f63.K().getAppId())) ? false : false;
        g32.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            oc3.b bVar = new oc3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(f63.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(jr2 jr2Var) {
        if (c0()) {
            this.w.I(jr2Var.n("app_icon_url"));
            this.w.K(jr2Var.n("app_name"));
            if (f63.K().q().X().H() == 0) {
                this.w.L(jr2Var.h("app_pay_protected"));
            }
        }
    }

    public synchronized void N() {
        if (this.w != null) {
            this.w.H();
            if (B) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        il3.A();
        il3.z(np2.c());
        p52 Y = Y();
        if (Y != null) {
            p52.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        vh3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        eb3.r();
        g63 q = f63.K().q();
        q.f0().j();
        q.N().a();
        sb3.x();
        op2.o().a();
    }

    public final void d0() {
        d63 d63Var = this.y;
        d63Var.c(new d());
        d63Var.f(new c(), "event_on_still_maintaining");
        d63Var.f(new b(), "event_on_app_occupied");
        d63Var.f(new a(), "event_on_app_updated");
        d63Var.f(new p(), "event_on_app_icon_update");
        d63Var.f(new o(), "event_on_pkg_maintain_finish");
        d63Var.f(new n(), "installer_on_progress");
        d63Var.f(new m(), "event_first_action_launched");
        d63Var.f(new l(), "event_on_web_mode_launched");
        ur2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f63.K().o(this.y);
        g32.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        np2.H().b();
        oi3 oi3Var = this.v;
        if (oi3Var != null) {
            oi3Var.p();
        }
        f63.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        tr2.c0();
        String appId = f63.K().getAppId();
        if (B) {
            lr2 d2 = lr2.d(appId);
            d2.e().c();
            d2.h();
        }
        ec3.l(true);
        f63.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        ur2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        g32.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !f63.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            f63.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (f63.K().E() && fr2.a(intent)) {
                f63.K().q().X().J0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        oi3 oi3Var = this.v;
        if (oi3Var != null) {
            oi3Var.v();
        }
        I0(FrameLifeState.JUST_RESUMED);
        ik3.b().d();
    }

    public final void m0() {
        if (t52.b.a()) {
            r0(zl3.b(r93.e()));
        } else if (!isDestroyed()) {
            if (f63.K().q().I()) {
                H0(true);
            } else {
                f63.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        g63 q = f63.K().q();
        if (q != null) {
            String W = q.Z().W();
            lr2 d2 = lr2.d(q.Z().W());
            d2.f("appId: " + q.b + "  launchId: " + W).e();
            d2.h();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        xs1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.vj4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        bd2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        np2.G().b();
        b33.Q().c0();
        boolean z2 = true;
        this.s = true;
        uc3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        yc3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (fj3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = fr2.a(intent);
        if (a2) {
            intent.putExtra("launch_id", SwanLauncher.h());
        }
        if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
            ClassLoader classLoader = getClass().getClassLoader();
            bundle2.setClassLoader(classLoader);
            intent.setExtrasClassLoader(classLoader);
            intent.putExtras(bundle2);
        }
        if (h0(intent)) {
            F0();
            return;
        }
        ad2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!nb2.a.c()) {
            try {
                bindService(new Intent(this, V().service), this, 1);
            } catch (Exception e2) {
                if (B) {
                    e2.printStackTrace();
                }
            }
        }
        if (Build.VERSION.SDK_INT == 26) {
            TranslucentUtils.convertFromTranslucent(this);
        }
        g32.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        g32.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d009b);
        if (S() == 0) {
            xj3.c(this);
        }
        d0();
        f63 K = f63.K();
        K.t(this);
        K.u(this.y);
        if (intent != null && (a2 || bundle == null)) {
            intent.putExtra("receive_launch_intent_time", currentTimeMillis);
            Bundle extras = intent.getExtras();
            String string = extras.getString("mAppId");
            if (bundle != null && i0(string)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                g32.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().X().J0("1250000000000000");
        }
        xj3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new oi3(this);
        }
        oi3 oi3Var = this.v;
        if (oi3Var != null) {
            oi3Var.w(false);
        }
        oi3 oi3Var2 = this.v;
        if (oi3Var2 != null) {
            oi3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        aj3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        bd2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        g32.i("SwanApp", "SwanAppActivity onNewIntent");
        setIntent(intent);
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
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
        oi3 oi3Var = this.v;
        if (oi3Var != null) {
            oi3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            g32.i("SwanAppActivity", "onNewIntent: start swan web");
            f63.K().q().B0();
        }
        this.s = true;
        uc3.l(true);
        f63 K = f63.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && fr2.a(intent)) {
            K.q().Z().J0("1250000000000000");
        }
        mi3 mi3Var = this.q;
        if (mi3Var != null) {
            mi3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            g32.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (t52.b.a() && f63.K().q().A0() && oi4.d()) {
            H0(true);
            ad2.V().b1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(vi4.e().b());
        } else if (f63.K().q().A0() && oi4.d()) {
            H0(true);
            ad2.V().b1();
        } else {
            String D2 = np2.o().D();
            if (np2.a().c() && !ak3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", f63.K().getAppId()).build().toString());
                return;
            }
            zh3 zh3Var = new zh3();
            zh3Var.k(1L);
            zh3Var.i(2109L);
            zh3Var.f("web mode start failed.");
            if (g0()) {
                di3.a().f(zh3Var);
                hd3 hd3Var = new hd3();
                hd3Var.p(zh3Var);
                hd3Var.r(f63.K().q().X());
                hd3Var.q(zc3.n(f63.K().k()));
                hd3Var.m(f63.K().getAppId());
                zc3.R(hd3Var);
            }
            ar2.e(np2.c(), zh3Var, 0, "");
            F0();
        }
    }
}
