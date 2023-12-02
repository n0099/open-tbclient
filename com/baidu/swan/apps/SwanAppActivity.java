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
import com.baidu.tieba.bk3;
import com.baidu.tieba.bt1;
import com.baidu.tieba.cd3;
import com.baidu.tieba.d03;
import com.baidu.tieba.dd3;
import com.baidu.tieba.di3;
import com.baidu.tieba.dj3;
import com.baidu.tieba.dl3;
import com.baidu.tieba.dm3;
import com.baidu.tieba.ed2;
import com.baidu.tieba.ej3;
import com.baidu.tieba.ek3;
import com.baidu.tieba.er2;
import com.baidu.tieba.f33;
import com.baidu.tieba.fd2;
import com.baidu.tieba.fl3;
import com.baidu.tieba.h63;
import com.baidu.tieba.hi3;
import com.baidu.tieba.hr2;
import com.baidu.tieba.i33;
import com.baidu.tieba.ib3;
import com.baidu.tieba.ic3;
import com.baidu.tieba.ij2;
import com.baidu.tieba.j63;
import com.baidu.tieba.jj2;
import com.baidu.tieba.jj3;
import com.baidu.tieba.jr2;
import com.baidu.tieba.k32;
import com.baidu.tieba.k63;
import com.baidu.tieba.kc3;
import com.baidu.tieba.kw2;
import com.baidu.tieba.l03;
import com.baidu.tieba.ld3;
import com.baidu.tieba.lj2;
import com.baidu.tieba.mk3;
import com.baidu.tieba.ml3;
import com.baidu.tieba.nd3;
import com.baidu.tieba.nr2;
import com.baidu.tieba.o63;
import com.baidu.tieba.pg3;
import com.baidu.tieba.pr2;
import com.baidu.tieba.pz2;
import com.baidu.tieba.qg3;
import com.baidu.tieba.qi3;
import com.baidu.tieba.r53;
import com.baidu.tieba.rb2;
import com.baidu.tieba.rp2;
import com.baidu.tieba.s52;
import com.baidu.tieba.sc3;
import com.baidu.tieba.si3;
import com.baidu.tieba.si4;
import com.baidu.tieba.sp2;
import com.baidu.tieba.t52;
import com.baidu.tieba.ti3;
import com.baidu.tieba.tj3;
import com.baidu.tieba.u32;
import com.baidu.tieba.v93;
import com.baidu.tieba.vm1;
import com.baidu.tieba.wb3;
import com.baidu.tieba.x52;
import com.baidu.tieba.xr2;
import com.baidu.tieba.yc3;
import com.baidu.tieba.yr2;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zi4;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, r53.a, qg3, ServiceConnection {
    public static final boolean B = vm1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public jj2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public qi3 q;
    public boolean t;
    public OrientationEventListener u;
    public si3 v;
    public ml3 w;
    public r53 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final h63 y = new h63();
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
                j63.K().c = i;
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
    public class a implements dl3<o63.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements dl3<o63.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements dl3<o63.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements fl3<o63.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fl3
        /* renamed from: b */
        public Boolean a(o63.a aVar) {
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
            xr2 V = xr2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                t52 W = V.W();
                if (W == null) {
                    k32.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    k32.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (W == null) {
                    k32.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    s52.Z3(null);
                    t52.b i = W.i("init");
                    int i2 = t52.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", kw2.d(str, str), true).a();
                    ml3 U = activity.U();
                    if (U != null) {
                        U.F(1);
                    }
                    di3 di3Var = new di3();
                    di3Var.k(1L);
                    di3Var.i(2110L);
                    di3Var.f("host url" + this.a);
                    hi3.a().f(di3Var);
                    ld3 ld3Var = new ld3();
                    ld3Var.p(di3Var);
                    ld3Var.r(j63.K().q().X());
                    ld3Var.q(dd3.n(j63.K().k()));
                    ld3Var.m(j63.K().getAppId());
                    dd3.R(ld3Var);
                    return;
                }
            }
            k32.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rp2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ic3.d()) {
                ic3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rp2.o().k();
            if (!l03.h()) {
                dj3.m(SwanAppActivity.this);
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
                kc3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements dl3<o63.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.p0(aVar.m("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements dl3<o63.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements dl3<o63.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements dl3<o63.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements dl3<o63.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(o63.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        jj2 jj2Var = this.m;
        if (jj2Var != null) {
            jj2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        ti3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = u32.a(this);
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
        jj2 jj2Var = this.m;
        if (jj2Var == null) {
            return "";
        }
        return jj2Var.i;
    }

    public jj2 R() {
        return this.m;
    }

    public int S() {
        jj2 jj2Var = this.m;
        if (jj2Var == null) {
            return -1;
        }
        return jj2Var.k();
    }

    public hr2.a T() {
        jj2 jj2Var = this.m;
        if (jj2Var == null) {
            return null;
        }
        return jj2Var.Z();
    }

    public ml3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public si3 X() {
        return this.v;
    }

    @Nullable
    public t52 Y() {
        jj2 jj2Var = this.m;
        if (jj2Var == null) {
            return null;
        }
        return jj2Var.c0();
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

    @Override // com.baidu.tieba.qg3
    public pg3 b() {
        jj2 jj2Var = this.m;
        if (jj2Var == null) {
            return null;
        }
        return jj2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(zi4.e().b());
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
            k32.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo g0 = j63.K().q().X().g0();
        if (g0 == null || g0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.r53.a
    @NonNull
    public r53 getFloatLayer() {
        if (this.x == null) {
            this.x = new r53(this, (FrameLayout) findViewById(16908290), 0);
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
        jj2 jj2Var = this.m;
        if (jj2Var != null && jj2Var.g0()) {
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
        k32.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        yc3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        k32.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        si3 si3Var = this.v;
        if (si3Var != null) {
            si3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        k32.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            pz2.m();
        }
        ej3.k(new k(), "tracer");
        rp2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            u32.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        jj2 jj2Var = this.m;
        if (jj2Var != null) {
            jj2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(ij2 ij2Var) {
        jj2 jj2Var = this.m;
        if (jj2Var != null) {
            jj2Var.T0(ij2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(nd3 nd3Var) {
        jj2 jj2Var = this.m;
        if (jj2Var != null) {
            jj2Var.Q(nd3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        rp2.H().d(this, i2, T());
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

    public final void l0(nr2 nr2Var) {
        if (c0() && nr2Var.b(" event_params_installer_progress")) {
            this.w.u(nr2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(nr2 nr2Var) {
        jj2 jj2Var = this.m;
        if (jj2Var != null && jj2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(nr2Var.m("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        si3 si3Var = this.v;
        if (si3Var != null) {
            si3Var.n();
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
        ed2.V().c1(str);
    }

    public final void s0(String str) {
        ek3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        i33.k(this, bundle);
    }

    public void u0(ij2 ij2Var) {
        jj2 jj2Var = this.m;
        if (jj2Var != null) {
            jj2Var.I0(ij2Var);
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

    public void B0(boolean z, @Nullable o63.a aVar) {
        if (this.w == null) {
            this.w = new ml3(this);
        }
        ml3 ml3Var = this.w;
        boolean z2 = true;
        if (1 != j63.K().q().X().H()) {
            z2 = false;
        }
        ml3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        jj2 jj2Var = this.m;
        if ((jj2Var != null && jj2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (tj3.p(this)) {
                tj3.s(this);
            }
            ti3.e(this);
        }
    }

    public final synchronized boolean C0(k63 k63Var) {
        if (this.m != null) {
            N();
        }
        jj2 a2 = lj2.a(this, k63Var);
        if (a2 == null) {
            di3 di3Var = new di3();
            di3Var.k(5L);
            di3Var.i(11L);
            di3Var.d("can not buildFramework");
            er2.e(this, di3Var, k63Var.k(), k63Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (l03.h()) {
            d03.e().d(gVar, "updateMobStat", false);
        } else {
            ej3.k(gVar, "updateMobStat");
        }
        z0(k63Var.X().e0(), k63Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        hr2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.U())) {
            z2 = true;
        } else {
            z2 = false;
        }
        qi3 qi3Var = this.q;
        if (qi3Var != null && !z2) {
            qi3Var.v(false);
        }
        if (a0() && !j63.K().q().t0()) {
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
            dd3.Y();
            F0();
            return false;
        }
    }

    public final void n0(o63.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        hr2.a X = j63.K().q().X();
        z0(X.e0(), X.H());
        B0(false, aVar);
        k32.i("SwanAppActivity", "appName: " + X.L() + " appId: " + X.I());
    }

    public void q0(int i2) {
        k32.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = pz2.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        yr2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        k63 q = j63.K().q();
        if (!q.I()) {
            k32.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            k32.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.U0(this.o, z);
            k32.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && qi3.j()) {
                qi3 m2 = qi3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        k32.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + j63.K().getAppId());
        boolean z2 = true;
        if (j63.K().q().E() && j63.K().q().y0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, j63.K().getAppId())) ? false : false;
        k32.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            sc3.b bVar = new sc3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(j63.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(nr2 nr2Var) {
        if (c0()) {
            this.w.I(nr2Var.m("app_icon_url"));
            this.w.K(nr2Var.m("app_name"));
            if (j63.K().q().X().H() == 0) {
                this.w.L(nr2Var.h("app_pay_protected"));
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
        ml3.A();
        ml3.z(rp2.c());
        t52 Y = Y();
        if (Y != null) {
            t52.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        zh3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        ib3.r();
        k63 q = j63.K().q();
        q.f0().j();
        q.N().a();
        wb3.x();
        sp2.o().a();
    }

    public final void d0() {
        h63 h63Var = this.y;
        h63Var.c(new d());
        h63Var.f(new c(), "event_on_still_maintaining");
        h63Var.f(new b(), "event_on_app_occupied");
        h63Var.f(new a(), "event_on_app_updated");
        h63Var.f(new p(), "event_on_app_icon_update");
        h63Var.f(new o(), "event_on_pkg_maintain_finish");
        h63Var.f(new n(), "installer_on_progress");
        h63Var.f(new m(), "event_first_action_launched");
        h63Var.f(new l(), "event_on_web_mode_launched");
        yr2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        j63.K().o(this.y);
        k32.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        rp2.H().b();
        si3 si3Var = this.v;
        if (si3Var != null) {
            si3Var.p();
        }
        j63.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        xr2.c0();
        String appId = j63.K().getAppId();
        if (B) {
            pr2 d2 = pr2.d(appId);
            d2.e().c();
            d2.h();
        }
        ic3.l(true);
        j63.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        yr2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        k32.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !j63.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            j63.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (j63.K().E() && jr2.a(intent)) {
                j63.K().q().X().J0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        si3 si3Var = this.v;
        if (si3Var != null) {
            si3Var.v();
        }
        I0(FrameLifeState.JUST_RESUMED);
        mk3.b().d();
    }

    public final void m0() {
        if (x52.b.a()) {
            r0(dm3.b(v93.e()));
        } else if (!isDestroyed()) {
            if (j63.K().q().I()) {
                H0(true);
            } else {
                j63.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        k63 q = j63.K().q();
        if (q != null) {
            String W = q.Z().W();
            pr2 d2 = pr2.d(q.Z().W());
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
        bt1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.zj4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        fd2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        rp2.G().b();
        f33.Q().c0();
        boolean z2 = true;
        this.s = true;
        yc3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        cd3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (jj3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = jr2.a(intent);
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
        ed2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!rb2.a.c()) {
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
        k32.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        k32.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d009c);
        if (S() == 0) {
            bk3.c(this);
        }
        d0();
        j63 K = j63.K();
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
                k32.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().X().J0("1250000000000000");
        }
        bk3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new si3(this);
        }
        si3 si3Var = this.v;
        if (si3Var != null) {
            si3Var.w(false);
        }
        si3 si3Var2 = this.v;
        if (si3Var2 != null) {
            si3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        ej3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        fd2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        k32.i("SwanApp", "SwanAppActivity onNewIntent");
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
        si3 si3Var = this.v;
        if (si3Var != null) {
            si3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            k32.i("SwanAppActivity", "onNewIntent: start swan web");
            j63.K().q().B0();
        }
        this.s = true;
        yc3.l(true);
        j63 K = j63.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && jr2.a(intent)) {
            K.q().Z().J0("1250000000000000");
        }
        qi3 qi3Var = this.q;
        if (qi3Var != null) {
            qi3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            k32.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (x52.b.a() && j63.K().q().A0() && si4.d()) {
            H0(true);
            ed2.V().b1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(zi4.e().b());
        } else if (j63.K().q().A0() && si4.d()) {
            H0(true);
            ed2.V().b1();
        } else {
            String D2 = rp2.o().D();
            if (rp2.a().c() && !ek3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", j63.K().getAppId()).build().toString());
                return;
            }
            di3 di3Var = new di3();
            di3Var.k(1L);
            di3Var.i(2109L);
            di3Var.f("web mode start failed.");
            if (g0()) {
                hi3.a().f(di3Var);
                ld3 ld3Var = new ld3();
                ld3Var.p(di3Var);
                ld3Var.r(j63.K().q().X());
                ld3Var.q(dd3.n(j63.K().k()));
                ld3Var.m(j63.K().getAppId());
                dd3.R(ld3Var);
            }
            er2.e(rp2.c(), di3Var, 0, "");
            F0();
        }
    }
}
