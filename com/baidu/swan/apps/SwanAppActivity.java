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
import com.baidu.tieba.ab3;
import com.baidu.tieba.an3;
import com.baidu.tieba.aw2;
import com.baidu.tieba.b83;
import com.baidu.tieba.bg3;
import com.baidu.tieba.bh3;
import com.baidu.tieba.bo2;
import com.baidu.tieba.cb3;
import com.baidu.tieba.co2;
import com.baidu.tieba.co3;
import com.baidu.tieba.cw2;
import com.baidu.tieba.d13;
import com.baidu.tieba.d82;
import com.baidu.tieba.db3;
import com.baidu.tieba.dh3;
import com.baidu.tieba.e53;
import com.baidu.tieba.ei3;
import com.baidu.tieba.eo2;
import com.baidu.tieba.fp3;
import com.baidu.tieba.fq3;
import com.baidu.tieba.gi3;
import com.baidu.tieba.gw2;
import com.baidu.tieba.hb3;
import com.baidu.tieba.i43;
import com.baidu.tieba.il3;
import com.baidu.tieba.iw2;
import com.baidu.tieba.jl3;
import com.baidu.tieba.jn3;
import com.baidu.tieba.ka3;
import com.baidu.tieba.kg2;
import com.baidu.tieba.ku2;
import com.baidu.tieba.la2;
import com.baidu.tieba.lh3;
import com.baidu.tieba.ln3;
import com.baidu.tieba.ln4;
import com.baidu.tieba.lu2;
import com.baidu.tieba.ma2;
import com.baidu.tieba.mn3;
import com.baidu.tieba.mo3;
import com.baidu.tieba.n82;
import com.baidu.tieba.nr1;
import com.baidu.tieba.oe3;
import com.baidu.tieba.pg3;
import com.baidu.tieba.qa2;
import com.baidu.tieba.qw2;
import com.baidu.tieba.rh3;
import com.baidu.tieba.rw2;
import com.baidu.tieba.sm3;
import com.baidu.tieba.sn4;
import com.baidu.tieba.tx1;
import com.baidu.tieba.uo3;
import com.baidu.tieba.vh3;
import com.baidu.tieba.w43;
import com.baidu.tieba.wh3;
import com.baidu.tieba.wm3;
import com.baidu.tieba.wn3;
import com.baidu.tieba.wp3;
import com.baidu.tieba.wq3;
import com.baidu.tieba.xh2;
import com.baidu.tieba.xn3;
import com.baidu.tieba.xo3;
import com.baidu.tieba.xv2;
import com.baidu.tieba.y73;
import com.baidu.tieba.yh2;
import com.baidu.tieba.yp3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, ka3.a, jl3, ServiceConnection {
    public static final boolean B = nr1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public co2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public jn3 q;
    public boolean t;
    public OrientationEventListener u;
    public ln3 v;
    public fq3 w;
    public ka3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final ab3 y = new ab3();
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
                cb3.K().c = i;
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
    public class a implements wp3<hb3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements wp3<hb3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements wp3<hb3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements yp3<hb3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yp3
        /* renamed from: b */
        public Boolean a(hb3.a aVar) {
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
            qw2 T2 = qw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ma2 U = T2.U();
                if (U == null) {
                    d82.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    d82.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    d82.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    la2.U3(null);
                    ma2.b i = U.i("init");
                    int i2 = ma2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", d13.d(str, str), true).a();
                    fq3 T3 = activity.T();
                    if (T3 != null) {
                        T3.F(1);
                    }
                    wm3 wm3Var = new wm3();
                    wm3Var.k(1L);
                    wm3Var.i(2110L);
                    wm3Var.f("host url" + this.a);
                    an3.a().f(wm3Var);
                    ei3 ei3Var = new ei3();
                    ei3Var.p(wm3Var);
                    ei3Var.r(cb3.K().q().W());
                    ei3Var.q(wh3.n(cb3.K().k()));
                    ei3Var.m(cb3.K().getAppId());
                    wh3.R(ei3Var);
                    return;
                }
            }
            d82.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ku2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bh3.d()) {
                bh3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ku2.o().k();
            if (!e53.h()) {
                wn3.m(SwanAppActivity.this);
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
                dh3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements wp3<hb3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements wp3<hb3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements wp3<hb3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements wp3<hb3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements wp3<hb3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(hb3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        co2 co2Var = this.m;
        if (co2Var != null) {
            co2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        mn3.j(this);
    }

    public void L() {
        if (this.A == null) {
            this.A = n82.a(this);
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
        co2 co2Var = this.m;
        if (co2Var == null) {
            return "";
        }
        return co2Var.i;
    }

    public co2 Q() {
        return this.m;
    }

    public int R() {
        co2 co2Var = this.m;
        if (co2Var == null) {
            return -1;
        }
        return co2Var.k();
    }

    public aw2.a S() {
        co2 co2Var = this.m;
        if (co2Var == null) {
            return null;
        }
        return co2Var.Z();
    }

    public fq3 T() {
        return this.w;
    }

    public SwanAppProcessInfo U() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public ln3 X() {
        return this.v;
    }

    @Nullable
    public ma2 Y() {
        co2 co2Var = this.m;
        if (co2Var == null) {
            return null;
        }
        return co2Var.c0();
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

    @Override // com.baidu.tieba.jl3
    public il3 b() {
        co2 co2Var = this.m;
        if (co2Var == null) {
            return null;
        }
        return co2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(sn4.e().b());
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
            d82.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = cb3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.ka3.a
    @NonNull
    public ka3 getFloatLayer() {
        if (this.x == null) {
            this.x = new ka3(this, (FrameLayout) findViewById(16908290), 0);
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
        co2 co2Var = this.m;
        if (co2Var != null && co2Var.g0()) {
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
        d82.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        rh3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        d82.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        ln3 ln3Var = this.v;
        if (ln3Var != null) {
            ln3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        d82.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            i43.m();
        }
        xn3.k(new k(), "tracer");
        ku2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            n82.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        co2 co2Var = this.m;
        if (co2Var != null) {
            co2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(bo2 bo2Var) {
        co2 co2Var = this.m;
        if (co2Var != null) {
            co2Var.T0(bo2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void N(gi3 gi3Var) {
        co2 co2Var = this.m;
        if (co2Var != null) {
            co2Var.Q(gi3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        ku2.H().d(this, i2, S());
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

    public final void l0(gw2 gw2Var) {
        if (c0() && gw2Var.b(" event_params_installer_progress")) {
            this.w.u(gw2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(gw2 gw2Var) {
        co2 co2Var = this.m;
        if (co2Var != null && co2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(gw2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ln3 ln3Var = this.v;
        if (ln3Var != null) {
            ln3Var.n();
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
        xh2.U().b1(str);
    }

    public final void s0(String str) {
        xo3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        b83.k(this, bundle);
    }

    public void u0(bo2 bo2Var) {
        co2 co2Var = this.m;
        if (co2Var != null) {
            co2Var.I0(bo2Var);
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

    public void B0(boolean z, @Nullable hb3.a aVar) {
        if (this.w == null) {
            this.w = new fq3(this);
        }
        fq3 fq3Var = this.w;
        boolean z2 = true;
        if (1 != cb3.K().q().W().G()) {
            z2 = false;
        }
        fq3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        co2 co2Var = this.m;
        if ((co2Var != null && co2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (mo3.p(this)) {
                mo3.s(this);
            }
            mn3.e(this);
        }
    }

    public final synchronized boolean C0(db3 db3Var) {
        if (this.m != null) {
            M();
        }
        co2 a2 = eo2.a(this, db3Var);
        if (a2 == null) {
            wm3 wm3Var = new wm3();
            wm3Var.k(5L);
            wm3Var.i(11L);
            wm3Var.d("can not buildFramework");
            xv2.e(this, wm3Var, db3Var.k(), db3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (e53.h()) {
            w43.e().d(gVar, "updateMobStat", false);
        } else {
            xn3.k(gVar, "updateMobStat");
        }
        z0(db3Var.W().d0(), db3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        aw2.a S = S();
        boolean z3 = false;
        if (S != null && "1230000000000000".equals(S.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        jn3 jn3Var = this.q;
        if (jn3Var != null && !z2) {
            jn3Var.v(false);
        }
        if (a0() && !cb3.K().q().s0()) {
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
            wh3.Y();
            F0();
            return false;
        }
    }

    public final void n0(hb3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        aw2.a W = cb3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        d82.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        d82.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = i43.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        rw2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        db3 q = cb3.K().q();
        if (!q.I()) {
            d82.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            d82.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            d82.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && jn3.j()) {
                jn3 m2 = jn3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(S(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        d82.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + cb3.K().getAppId());
        boolean z2 = true;
        if (cb3.K().q().E() && cb3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, cb3.K().getAppId())) ? false : false;
        d82.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            lh3.b bVar = new lh3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(cb3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(gw2 gw2Var) {
        if (c0()) {
            this.w.I(gw2Var.n("app_icon_url"));
            this.w.K(gw2Var.n("app_name"));
            if (cb3.K().q().W().G() == 0) {
                this.w.L(gw2Var.h("app_pay_protected"));
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
        fq3.A();
        fq3.z(ku2.c());
        ma2 Y = Y();
        if (Y != null) {
            ma2.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        sm3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        bg3.r();
        db3 q = cb3.K().q();
        q.e0().j();
        q.N().a();
        pg3.x();
        lu2.o().a();
    }

    public final void d0() {
        ab3 ab3Var = this.y;
        ab3Var.c(new d());
        ab3Var.f(new c(), "event_on_still_maintaining");
        ab3Var.f(new b(), "event_on_app_occupied");
        ab3Var.f(new a(), "event_on_app_updated");
        ab3Var.f(new p(), "event_on_app_icon_update");
        ab3Var.f(new o(), "event_on_pkg_maintain_finish");
        ab3Var.f(new n(), "installer_on_progress");
        ab3Var.f(new m(), "event_first_action_launched");
        ab3Var.f(new l(), "event_on_web_mode_launched");
        rw2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        cb3.K().o(this.y);
        d82.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        M();
        if (this.n != null) {
            unbindService(this);
        }
        ku2.H().b();
        ln3 ln3Var = this.v;
        if (ln3Var != null) {
            ln3Var.p();
        }
        cb3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        qw2.a0();
        String appId = cb3.K().getAppId();
        if (B) {
            iw2 d2 = iw2.d(appId);
            d2.e().c();
            d2.h();
        }
        bh3.l(true);
        cb3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        rw2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        d82.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !cb3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            cb3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (cb3.K().E() && cw2.a(intent)) {
                cb3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        ln3 ln3Var = this.v;
        if (ln3Var != null) {
            ln3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        fp3.b().d();
    }

    public final void m0() {
        if (qa2.b.a()) {
            r0(wq3.b(oe3.e()));
        } else if (!isDestroyed()) {
            if (cb3.K().q().I()) {
                H0(true);
            } else {
                cb3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        db3 q = cb3.K().q();
        if (q != null) {
            String V = q.Y().V();
            iw2 d2 = iw2.d(q.Y().V());
            d2.f("appId: " + q.b + "  launchId: " + V).e();
            d2.h();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (getResultDispatcher().notifyActivityResult(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
        tx1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.to4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        yh2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(U());
        ku2.G().b();
        y73.Q().c0();
        boolean z2 = true;
        this.s = true;
        rh3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        vh3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (co3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = cw2.a(intent);
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
        xh2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!kg2.a.c()) {
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
        d82.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        d82.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0099);
        if (R() == 0) {
            uo3.c(this);
        }
        d0();
        cb3 K = cb3.K();
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
                d82.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        uo3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new ln3(this);
        }
        ln3 ln3Var = this.v;
        if (ln3Var != null) {
            ln3Var.v(false);
        }
        ln3 ln3Var2 = this.v;
        if (ln3Var2 != null) {
            ln3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        xn3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        yh2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        d82.i("SwanApp", "SwanAppActivity onNewIntent");
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
        ln3 ln3Var = this.v;
        if (ln3Var != null) {
            ln3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            d82.i("SwanAppActivity", "onNewIntent: start swan web");
            cb3.K().q().A0();
        }
        this.s = true;
        rh3.l(true);
        cb3 K = cb3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && cw2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        jn3 jn3Var = this.q;
        if (jn3Var != null) {
            jn3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            d82.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (qa2.b.a() && cb3.K().q().z0() && ln4.d()) {
            H0(true);
            xh2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(sn4.e().b());
        } else if (cb3.K().q().z0() && ln4.d()) {
            H0(true);
            xh2.U().a1();
        } else {
            String D2 = ku2.o().D();
            if (ku2.a().c() && !xo3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", cb3.K().getAppId()).build().toString());
                return;
            }
            wm3 wm3Var = new wm3();
            wm3Var.k(1L);
            wm3Var.i(2109L);
            wm3Var.f("web mode start failed.");
            if (g0()) {
                an3.a().f(wm3Var);
                ei3 ei3Var = new ei3();
                ei3Var.p(wm3Var);
                ei3Var.r(cb3.K().q().W());
                ei3Var.q(wh3.n(cb3.K().k()));
                ei3Var.m(cb3.K().getAppId());
                wh3.R(ei3Var);
            }
            xv2.e(ku2.c(), wm3Var, 0, "");
            F0();
        }
    }
}
