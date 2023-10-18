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
import com.baidu.tieba.a93;
import com.baidu.tieba.am1;
import com.baidu.tieba.bb3;
import com.baidu.tieba.c52;
import com.baidu.tieba.cr2;
import com.baidu.tieba.dc3;
import com.baidu.tieba.dr2;
import com.baidu.tieba.eh3;
import com.baidu.tieba.ei4;
import com.baidu.tieba.gj3;
import com.baidu.tieba.gs1;
import com.baidu.tieba.hc3;
import com.baidu.tieba.ic3;
import com.baidu.tieba.ih3;
import com.baidu.tieba.ii3;
import com.baidu.tieba.ik3;
import com.baidu.tieba.il3;
import com.baidu.tieba.iz2;
import com.baidu.tieba.jc2;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jj3;
import com.baidu.tieba.jq2;
import com.baidu.tieba.k23;
import com.baidu.tieba.kc2;
import com.baidu.tieba.kk3;
import com.baidu.tieba.m53;
import com.baidu.tieba.mh3;
import com.baidu.tieba.mq2;
import com.baidu.tieba.n23;
import com.baidu.tieba.na3;
import com.baidu.tieba.nb3;
import com.baidu.tieba.ni2;
import com.baidu.tieba.o53;
import com.baidu.tieba.oi2;
import com.baidu.tieba.oi3;
import com.baidu.tieba.oq2;
import com.baidu.tieba.p22;
import com.baidu.tieba.p53;
import com.baidu.tieba.pb3;
import com.baidu.tieba.pv2;
import com.baidu.tieba.qc3;
import com.baidu.tieba.qi2;
import com.baidu.tieba.qz2;
import com.baidu.tieba.rj3;
import com.baidu.tieba.rk3;
import com.baidu.tieba.sc3;
import com.baidu.tieba.sq2;
import com.baidu.tieba.t53;
import com.baidu.tieba.uf3;
import com.baidu.tieba.uq2;
import com.baidu.tieba.uy2;
import com.baidu.tieba.vf3;
import com.baidu.tieba.vh3;
import com.baidu.tieba.w43;
import com.baidu.tieba.wa2;
import com.baidu.tieba.wo2;
import com.baidu.tieba.x42;
import com.baidu.tieba.xb3;
import com.baidu.tieba.xh3;
import com.baidu.tieba.xh4;
import com.baidu.tieba.xo2;
import com.baidu.tieba.y42;
import com.baidu.tieba.yh3;
import com.baidu.tieba.yi3;
import com.baidu.tieba.z22;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, w43.a, vf3, ServiceConnection {
    public static final boolean B = am1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public oi2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public vh3 q;
    public boolean t;
    public OrientationEventListener u;
    public xh3 v;
    public rk3 w;
    public w43 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final m53 y = new m53();
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
                o53.K().c = i;
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
    public class a implements ik3<t53.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ik3<t53.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ik3<t53.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements kk3<t53.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kk3
        /* renamed from: b */
        public Boolean a(t53.a aVar) {
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
            cr2 V = cr2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity != null && !activity.isFinishing()) {
                y42 W = V.W();
                if (W == null) {
                    p22.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    p22.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (W == null) {
                    p22.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    x42.Z3(null);
                    y42.b i = W.i("init");
                    int i2 = y42.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", pv2.d(str, str), true).a();
                    rk3 T2 = activity.T();
                    if (T2 != null) {
                        T2.F(1);
                    }
                    ih3 ih3Var = new ih3();
                    ih3Var.k(1L);
                    ih3Var.i(2110L);
                    ih3Var.f("host url" + this.a);
                    mh3.a().f(ih3Var);
                    qc3 qc3Var = new qc3();
                    qc3Var.p(ih3Var);
                    qc3Var.r(o53.K().q().X());
                    qc3Var.q(ic3.n(o53.K().k()));
                    qc3Var.m(o53.K().getAppId());
                    ic3.R(qc3Var);
                    return;
                }
            }
            p22.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wo2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (nb3.d()) {
                nb3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            wo2.o().k();
            if (!qz2.h()) {
                ii3.m(SwanAppActivity.this);
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
                pb3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements ik3<t53.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements ik3<t53.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements ik3<t53.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements ik3<t53.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements ik3<t53.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(t53.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        oi2 oi2Var = this.m;
        if (oi2Var != null) {
            oi2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        yh3.j(this);
    }

    public void L() {
        if (this.A == null) {
            this.A = z22.a(this);
        }
    }

    public void O() {
        int i2;
        if (S() != null && S().e0() == 1) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        if (T() != null) {
            T().F(i2);
        }
    }

    public String P() {
        oi2 oi2Var = this.m;
        if (oi2Var == null) {
            return "";
        }
        return oi2Var.i;
    }

    public oi2 Q() {
        return this.m;
    }

    public int R() {
        oi2 oi2Var = this.m;
        if (oi2Var == null) {
            return -1;
        }
        return oi2Var.k();
    }

    public mq2.a S() {
        oi2 oi2Var = this.m;
        if (oi2Var == null) {
            return null;
        }
        return oi2Var.Z();
    }

    public rk3 T() {
        return this.w;
    }

    public SwanAppProcessInfo U() {
        return SwanAppProcessInfo.P0;
    }

    public String V() {
        return this.r;
    }

    public xh3 W() {
        return this.v;
    }

    @Nullable
    public y42 Y() {
        oi2 oi2Var = this.m;
        if (oi2Var == null) {
            return null;
        }
        return oi2Var.c0();
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

    @Override // com.baidu.tieba.vf3
    public uf3 b() {
        oi2 oi2Var = this.m;
        if (oi2Var == null) {
            return null;
        }
        return oi2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(ei4.e().b());
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
            p22.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo g0 = o53.K().q().X().g0();
        if (g0 == null || g0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.w43.a
    @NonNull
    public w43 getFloatLayer() {
        if (this.x == null) {
            this.x = new w43(this, (FrameLayout) findViewById(16908290), 0);
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
        oi2 oi2Var = this.m;
        if (oi2Var != null && oi2Var.g0()) {
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
        p22.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        dc3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        p22.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        xh3 xh3Var = this.v;
        if (xh3Var != null) {
            xh3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        p22.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            uy2.m();
        }
        ji3.k(new k(), "tracer");
        wo2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            z22.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        oi2 oi2Var = this.m;
        if (oi2Var != null) {
            oi2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(ni2 ni2Var) {
        oi2 oi2Var = this.m;
        if (oi2Var != null) {
            oi2Var.T0(ni2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void N(sc3 sc3Var) {
        oi2 oi2Var = this.m;
        if (oi2Var != null) {
            oi2Var.Q(sc3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        wo2.H().d(this, i2, S());
    }

    public boolean e0(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, P())) {
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

    public final void l0(sq2 sq2Var) {
        if (c0() && sq2Var.b(" event_params_installer_progress")) {
            this.w.u(sq2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(sq2 sq2Var) {
        oi2 oi2Var = this.m;
        if (oi2Var != null && oi2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(sq2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        xh3 xh3Var = this.v;
        if (xh3Var != null) {
            xh3Var.n();
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
        jc2.V().c1(str);
    }

    public final void s0(String str) {
        jj3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        n23.k(this, bundle);
    }

    public void u0(ni2 ni2Var) {
        oi2 oi2Var = this.m;
        if (oi2Var != null) {
            oi2Var.I0(ni2Var);
        }
    }

    public void y0(String... strArr) {
        HashSet newHashSet;
        M();
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

    public void B0(boolean z, @Nullable t53.a aVar) {
        if (this.w == null) {
            this.w = new rk3(this);
        }
        rk3 rk3Var = this.w;
        boolean z2 = true;
        if (1 != o53.K().q().X().H()) {
            z2 = false;
        }
        rk3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        oi2 oi2Var = this.m;
        if ((oi2Var != null && oi2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (yi3.p(this)) {
                yi3.s(this);
            }
            yh3.e(this);
        }
    }

    public final synchronized boolean C0(p53 p53Var) {
        if (this.m != null) {
            M();
        }
        oi2 a2 = qi2.a(this, p53Var);
        if (a2 == null) {
            ih3 ih3Var = new ih3();
            ih3Var.k(5L);
            ih3Var.i(11L);
            ih3Var.d("can not buildFramework");
            jq2.e(this, ih3Var, p53Var.k(), p53Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (qz2.h()) {
            iz2.e().d(gVar, "updateMobStat", false);
        } else {
            ji3.k(gVar, "updateMobStat");
        }
        z0(p53Var.X().e0(), p53Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        mq2.a S = S();
        boolean z3 = false;
        if (S != null && "1230000000000000".equals(S.U())) {
            z2 = true;
        } else {
            z2 = false;
        }
        vh3 vh3Var = this.q;
        if (vh3Var != null && !z2) {
            vh3Var.v(false);
        }
        if (a0() && !o53.K().q().t0()) {
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
            ic3.Y();
            F0();
            return false;
        }
    }

    public final void n0(t53.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        mq2.a X = o53.K().q().X();
        z0(X.e0(), X.H());
        B0(false, aVar);
        p22.i("SwanAppActivity", "appName: " + X.L() + " appId: " + X.I());
    }

    public void q0(int i2) {
        p22.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = uy2.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        dr2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        p53 q = o53.K().q();
        if (!q.I()) {
            p22.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            p22.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.U0(this.o, z);
            p22.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && vh3.j()) {
                vh3 m2 = vh3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(S(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        p22.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + o53.K().getAppId());
        boolean z2 = true;
        if (o53.K().q().E() && o53.K().q().y0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, o53.K().getAppId())) ? false : false;
        p22.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            xb3.b bVar = new xb3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(o53.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(sq2 sq2Var) {
        if (c0()) {
            this.w.I(sq2Var.n("app_icon_url"));
            this.w.K(sq2Var.n("app_name"));
            if (o53.K().q().X().H() == 0) {
                this.w.L(sq2Var.h("app_pay_protected"));
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
        rk3.A();
        rk3.z(wo2.c());
        y42 Y = Y();
        if (Y != null) {
            y42.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        eh3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        na3.r();
        p53 q = o53.K().q();
        q.f0().j();
        q.N().a();
        bb3.x();
        xo2.o().a();
    }

    public final void d0() {
        m53 m53Var = this.y;
        m53Var.c(new d());
        m53Var.f(new c(), "event_on_still_maintaining");
        m53Var.f(new b(), "event_on_app_occupied");
        m53Var.f(new a(), "event_on_app_updated");
        m53Var.f(new p(), "event_on_app_icon_update");
        m53Var.f(new o(), "event_on_pkg_maintain_finish");
        m53Var.f(new n(), "installer_on_progress");
        m53Var.f(new m(), "event_first_action_launched");
        m53Var.f(new l(), "event_on_web_mode_launched");
        dr2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        o53.K().o(this.y);
        p22.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        M();
        if (this.n != null) {
            unbindService(this);
        }
        wo2.H().b();
        xh3 xh3Var = this.v;
        if (xh3Var != null) {
            xh3Var.p();
        }
        o53.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        cr2.c0();
        String appId = o53.K().getAppId();
        if (B) {
            uq2 d2 = uq2.d(appId);
            d2.e().c();
            d2.h();
        }
        nb3.l(true);
        o53.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        dr2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        p22.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !o53.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            o53.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (o53.K().E() && oq2.a(intent)) {
                o53.K().q().X().J0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        xh3 xh3Var = this.v;
        if (xh3Var != null) {
            xh3Var.v();
        }
        I0(FrameLifeState.JUST_RESUMED);
        rj3.b().d();
    }

    public final void m0() {
        if (c52.b.a()) {
            r0(il3.b(a93.e()));
        } else if (!isDestroyed()) {
            if (o53.K().q().I()) {
                H0(true);
            } else {
                o53.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        p53 q = o53.K().q();
        if (q != null) {
            String W = q.Z().W();
            uq2 d2 = uq2.d(q.Z().W());
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
        gs1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.ej4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        kc2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(U());
        wo2.G().b();
        k23.Q().c0();
        boolean z2 = true;
        this.s = true;
        dc3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        hc3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (oi3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = oq2.a(intent);
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
        jc2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!wa2.a.c()) {
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
        p22.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        p22.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0099);
        if (R() == 0) {
            gj3.c(this);
        }
        d0();
        o53 K = o53.K();
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
                p22.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().X().J0("1250000000000000");
        }
        gj3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new xh3(this);
        }
        xh3 xh3Var = this.v;
        if (xh3Var != null) {
            xh3Var.w(false);
        }
        xh3 xh3Var2 = this.v;
        if (xh3Var2 != null) {
            xh3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        ji3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        kc2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        p22.i("SwanApp", "SwanAppActivity onNewIntent");
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
        xh3 xh3Var = this.v;
        if (xh3Var != null) {
            xh3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            p22.i("SwanAppActivity", "onNewIntent: start swan web");
            o53.K().q().B0();
        }
        this.s = true;
        dc3.l(true);
        o53 K = o53.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && oq2.a(intent)) {
            K.q().Z().J0("1250000000000000");
        }
        vh3 vh3Var = this.q;
        if (vh3Var != null) {
            vh3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            p22.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (c52.b.a() && o53.K().q().A0() && xh4.d()) {
            H0(true);
            jc2.V().b1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(ei4.e().b());
        } else if (o53.K().q().A0() && xh4.d()) {
            H0(true);
            jc2.V().b1();
        } else {
            String D2 = wo2.o().D();
            if (wo2.a().c() && !jj3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", o53.K().getAppId()).build().toString());
                return;
            }
            ih3 ih3Var = new ih3();
            ih3Var.k(1L);
            ih3Var.i(2109L);
            ih3Var.f("web mode start failed.");
            if (g0()) {
                mh3.a().f(ih3Var);
                qc3 qc3Var = new qc3();
                qc3Var.p(ih3Var);
                qc3Var.r(o53.K().q().X());
                qc3Var.q(ic3.n(o53.K().k()));
                qc3Var.m(o53.K().getAppId());
                ic3.R(qc3Var);
            }
            jq2.e(wo2.c(), ih3Var, 0, "");
            F0();
        }
    }
}
