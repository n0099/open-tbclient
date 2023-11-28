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
import com.baidu.tieba.a03;
import com.baidu.tieba.ad3;
import com.baidu.tieba.ai3;
import com.baidu.tieba.aj3;
import com.baidu.tieba.al3;
import com.baidu.tieba.am3;
import com.baidu.tieba.bd2;
import com.baidu.tieba.bj3;
import com.baidu.tieba.bk3;
import com.baidu.tieba.br2;
import com.baidu.tieba.c33;
import com.baidu.tieba.cd2;
import com.baidu.tieba.cl3;
import com.baidu.tieba.e63;
import com.baidu.tieba.ei3;
import com.baidu.tieba.er2;
import com.baidu.tieba.f33;
import com.baidu.tieba.fb3;
import com.baidu.tieba.fc3;
import com.baidu.tieba.fj2;
import com.baidu.tieba.g63;
import com.baidu.tieba.gj2;
import com.baidu.tieba.gj3;
import com.baidu.tieba.gr2;
import com.baidu.tieba.h32;
import com.baidu.tieba.h63;
import com.baidu.tieba.hc3;
import com.baidu.tieba.hw2;
import com.baidu.tieba.i03;
import com.baidu.tieba.id3;
import com.baidu.tieba.ij2;
import com.baidu.tieba.jk3;
import com.baidu.tieba.jl3;
import com.baidu.tieba.kd3;
import com.baidu.tieba.kr2;
import com.baidu.tieba.l63;
import com.baidu.tieba.mg3;
import com.baidu.tieba.mr2;
import com.baidu.tieba.mz2;
import com.baidu.tieba.ng3;
import com.baidu.tieba.ni3;
import com.baidu.tieba.o53;
import com.baidu.tieba.ob2;
import com.baidu.tieba.op2;
import com.baidu.tieba.p52;
import com.baidu.tieba.pc3;
import com.baidu.tieba.pi3;
import com.baidu.tieba.pi4;
import com.baidu.tieba.pp2;
import com.baidu.tieba.q52;
import com.baidu.tieba.qi3;
import com.baidu.tieba.qj3;
import com.baidu.tieba.r32;
import com.baidu.tieba.s93;
import com.baidu.tieba.sm1;
import com.baidu.tieba.tb3;
import com.baidu.tieba.u52;
import com.baidu.tieba.ur2;
import com.baidu.tieba.vc3;
import com.baidu.tieba.vr2;
import com.baidu.tieba.wh3;
import com.baidu.tieba.wi4;
import com.baidu.tieba.yj3;
import com.baidu.tieba.ys1;
import com.baidu.tieba.zc3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, o53.a, ng3, ServiceConnection {
    public static final boolean B = sm1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public gj2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public ni3 q;
    public boolean t;
    public OrientationEventListener u;
    public pi3 v;
    public jl3 w;
    public o53 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final e63 y = new e63();
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
                g63.K().c = i;
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
    public class a implements al3<l63.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements al3<l63.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements al3<l63.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements cl3<l63.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cl3
        /* renamed from: b */
        public Boolean a(l63.a aVar) {
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
            ur2 V = ur2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                q52 W = V.W();
                if (W == null) {
                    h32.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    h32.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (W == null) {
                    h32.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    p52.Z3(null);
                    q52.b i = W.i("init");
                    int i2 = q52.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", hw2.d(str, str), true).a();
                    jl3 U = activity.U();
                    if (U != null) {
                        U.F(1);
                    }
                    ai3 ai3Var = new ai3();
                    ai3Var.k(1L);
                    ai3Var.i(2110L);
                    ai3Var.f("host url" + this.a);
                    ei3.a().f(ai3Var);
                    id3 id3Var = new id3();
                    id3Var.p(ai3Var);
                    id3Var.r(g63.K().q().X());
                    id3Var.q(ad3.n(g63.K().k()));
                    id3Var.m(g63.K().getAppId());
                    ad3.R(id3Var);
                    return;
                }
            }
            h32.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            op2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (fc3.d()) {
                fc3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            op2.o().k();
            if (!i03.h()) {
                aj3.m(SwanAppActivity.this);
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
                hc3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements al3<l63.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.p0(aVar.m("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements al3<l63.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements al3<l63.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements al3<l63.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements al3<l63.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(l63.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        gj2 gj2Var = this.m;
        if (gj2Var != null) {
            gj2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        qi3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = r32.a(this);
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
        gj2 gj2Var = this.m;
        if (gj2Var == null) {
            return "";
        }
        return gj2Var.i;
    }

    public gj2 R() {
        return this.m;
    }

    public int S() {
        gj2 gj2Var = this.m;
        if (gj2Var == null) {
            return -1;
        }
        return gj2Var.k();
    }

    public er2.a T() {
        gj2 gj2Var = this.m;
        if (gj2Var == null) {
            return null;
        }
        return gj2Var.Z();
    }

    public jl3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public pi3 X() {
        return this.v;
    }

    @Nullable
    public q52 Y() {
        gj2 gj2Var = this.m;
        if (gj2Var == null) {
            return null;
        }
        return gj2Var.c0();
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

    @Override // com.baidu.tieba.ng3
    public mg3 b() {
        gj2 gj2Var = this.m;
        if (gj2Var == null) {
            return null;
        }
        return gj2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(wi4.e().b());
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
            h32.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo g0 = g63.K().q().X().g0();
        if (g0 == null || g0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.o53.a
    @NonNull
    public o53 getFloatLayer() {
        if (this.x == null) {
            this.x = new o53(this, (FrameLayout) findViewById(16908290), 0);
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
        gj2 gj2Var = this.m;
        if (gj2Var != null && gj2Var.g0()) {
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
        h32.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        vc3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        h32.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        pi3 pi3Var = this.v;
        if (pi3Var != null) {
            pi3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        h32.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            mz2.m();
        }
        bj3.k(new k(), "tracer");
        op2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            r32.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        gj2 gj2Var = this.m;
        if (gj2Var != null) {
            gj2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(fj2 fj2Var) {
        gj2 gj2Var = this.m;
        if (gj2Var != null) {
            gj2Var.T0(fj2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(kd3 kd3Var) {
        gj2 gj2Var = this.m;
        if (gj2Var != null) {
            gj2Var.Q(kd3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        op2.H().d(this, i2, T());
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

    public final void l0(kr2 kr2Var) {
        if (c0() && kr2Var.b(" event_params_installer_progress")) {
            this.w.u(kr2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(kr2 kr2Var) {
        gj2 gj2Var = this.m;
        if (gj2Var != null && gj2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(kr2Var.m("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        pi3 pi3Var = this.v;
        if (pi3Var != null) {
            pi3Var.n();
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
        bd2.V().c1(str);
    }

    public final void s0(String str) {
        bk3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        f33.k(this, bundle);
    }

    public void u0(fj2 fj2Var) {
        gj2 gj2Var = this.m;
        if (gj2Var != null) {
            gj2Var.I0(fj2Var);
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

    public void B0(boolean z, @Nullable l63.a aVar) {
        if (this.w == null) {
            this.w = new jl3(this);
        }
        jl3 jl3Var = this.w;
        boolean z2 = true;
        if (1 != g63.K().q().X().H()) {
            z2 = false;
        }
        jl3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        gj2 gj2Var = this.m;
        if ((gj2Var != null && gj2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (qj3.p(this)) {
                qj3.s(this);
            }
            qi3.e(this);
        }
    }

    public final synchronized boolean C0(h63 h63Var) {
        if (this.m != null) {
            N();
        }
        gj2 a2 = ij2.a(this, h63Var);
        if (a2 == null) {
            ai3 ai3Var = new ai3();
            ai3Var.k(5L);
            ai3Var.i(11L);
            ai3Var.d("can not buildFramework");
            br2.e(this, ai3Var, h63Var.k(), h63Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (i03.h()) {
            a03.e().d(gVar, "updateMobStat", false);
        } else {
            bj3.k(gVar, "updateMobStat");
        }
        z0(h63Var.X().e0(), h63Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        er2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.U())) {
            z2 = true;
        } else {
            z2 = false;
        }
        ni3 ni3Var = this.q;
        if (ni3Var != null && !z2) {
            ni3Var.v(false);
        }
        if (a0() && !g63.K().q().t0()) {
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
            ad3.Y();
            F0();
            return false;
        }
    }

    public final void n0(l63.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        er2.a X = g63.K().q().X();
        z0(X.e0(), X.H());
        B0(false, aVar);
        h32.i("SwanAppActivity", "appName: " + X.L() + " appId: " + X.I());
    }

    public void q0(int i2) {
        h32.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = mz2.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        vr2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        h63 q = g63.K().q();
        if (!q.I()) {
            h32.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            h32.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.U0(this.o, z);
            h32.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && ni3.j()) {
                ni3 m2 = ni3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        h32.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + g63.K().getAppId());
        boolean z2 = true;
        if (g63.K().q().E() && g63.K().q().y0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, g63.K().getAppId())) ? false : false;
        h32.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            pc3.b bVar = new pc3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(g63.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(kr2 kr2Var) {
        if (c0()) {
            this.w.I(kr2Var.m("app_icon_url"));
            this.w.K(kr2Var.m("app_name"));
            if (g63.K().q().X().H() == 0) {
                this.w.L(kr2Var.h("app_pay_protected"));
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
        jl3.A();
        jl3.z(op2.c());
        q52 Y = Y();
        if (Y != null) {
            q52.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        wh3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        fb3.r();
        h63 q = g63.K().q();
        q.f0().j();
        q.N().a();
        tb3.x();
        pp2.o().a();
    }

    public final void d0() {
        e63 e63Var = this.y;
        e63Var.c(new d());
        e63Var.f(new c(), "event_on_still_maintaining");
        e63Var.f(new b(), "event_on_app_occupied");
        e63Var.f(new a(), "event_on_app_updated");
        e63Var.f(new p(), "event_on_app_icon_update");
        e63Var.f(new o(), "event_on_pkg_maintain_finish");
        e63Var.f(new n(), "installer_on_progress");
        e63Var.f(new m(), "event_first_action_launched");
        e63Var.f(new l(), "event_on_web_mode_launched");
        vr2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g63.K().o(this.y);
        h32.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        op2.H().b();
        pi3 pi3Var = this.v;
        if (pi3Var != null) {
            pi3Var.p();
        }
        g63.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        ur2.c0();
        String appId = g63.K().getAppId();
        if (B) {
            mr2 d2 = mr2.d(appId);
            d2.e().c();
            d2.h();
        }
        fc3.l(true);
        g63.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        vr2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        h32.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !g63.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            g63.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (g63.K().E() && gr2.a(intent)) {
                g63.K().q().X().J0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        pi3 pi3Var = this.v;
        if (pi3Var != null) {
            pi3Var.v();
        }
        I0(FrameLifeState.JUST_RESUMED);
        jk3.b().d();
    }

    public final void m0() {
        if (u52.b.a()) {
            r0(am3.b(s93.e()));
        } else if (!isDestroyed()) {
            if (g63.K().q().I()) {
                H0(true);
            } else {
                g63.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        h63 q = g63.K().q();
        if (q != null) {
            String W = q.Z().W();
            mr2 d2 = mr2.d(q.Z().W());
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
        ys1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.wj4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        cd2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        op2.G().b();
        c33.Q().c0();
        boolean z2 = true;
        this.s = true;
        vc3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        zc3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (gj3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = gr2.a(intent);
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
        bd2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!ob2.a.c()) {
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
        h32.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        h32.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d009c);
        if (S() == 0) {
            yj3.c(this);
        }
        d0();
        g63 K = g63.K();
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
                h32.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().X().J0("1250000000000000");
        }
        yj3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new pi3(this);
        }
        pi3 pi3Var = this.v;
        if (pi3Var != null) {
            pi3Var.w(false);
        }
        pi3 pi3Var2 = this.v;
        if (pi3Var2 != null) {
            pi3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        bj3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        cd2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        h32.i("SwanApp", "SwanAppActivity onNewIntent");
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
        pi3 pi3Var = this.v;
        if (pi3Var != null) {
            pi3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            h32.i("SwanAppActivity", "onNewIntent: start swan web");
            g63.K().q().B0();
        }
        this.s = true;
        vc3.l(true);
        g63 K = g63.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && gr2.a(intent)) {
            K.q().Z().J0("1250000000000000");
        }
        ni3 ni3Var = this.q;
        if (ni3Var != null) {
            ni3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            h32.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (u52.b.a() && g63.K().q().A0() && pi4.d()) {
            H0(true);
            bd2.V().b1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(wi4.e().b());
        } else if (g63.K().q().A0() && pi4.d()) {
            H0(true);
            bd2.V().b1();
        } else {
            String D2 = op2.o().D();
            if (op2.a().c() && !bk3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", g63.K().getAppId()).build().toString());
                return;
            }
            ai3 ai3Var = new ai3();
            ai3Var.k(1L);
            ai3Var.i(2109L);
            ai3Var.f("web mode start failed.");
            if (g0()) {
                ei3.a().f(ai3Var);
                id3 id3Var = new id3();
                id3Var.p(ai3Var);
                id3Var.r(g63.K().q().X());
                id3Var.q(ad3.n(g63.K().k()));
                id3Var.m(g63.K().getAppId());
                ad3.R(id3Var);
            }
            br2.e(op2.c(), ai3Var, 0, "");
            F0();
        }
    }
}
