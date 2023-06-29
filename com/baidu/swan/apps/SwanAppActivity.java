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
import com.baidu.tieba.ah3;
import com.baidu.tieba.ai3;
import com.baidu.tieba.ap2;
import com.baidu.tieba.bc3;
import com.baidu.tieba.bp2;
import com.baidu.tieba.bp3;
import com.baidu.tieba.bx2;
import com.baidu.tieba.c23;
import com.baidu.tieba.c92;
import com.baidu.tieba.cc3;
import com.baidu.tieba.ci3;
import com.baidu.tieba.d63;
import com.baidu.tieba.dj3;
import com.baidu.tieba.dp2;
import com.baidu.tieba.eq3;
import com.baidu.tieba.er3;
import com.baidu.tieba.fj3;
import com.baidu.tieba.fx2;
import com.baidu.tieba.gc3;
import com.baidu.tieba.h53;
import com.baidu.tieba.hm3;
import com.baidu.tieba.hx2;
import com.baidu.tieba.im3;
import com.baidu.tieba.io3;
import com.baidu.tieba.jb3;
import com.baidu.tieba.jh2;
import com.baidu.tieba.jv2;
import com.baidu.tieba.kb2;
import com.baidu.tieba.ki3;
import com.baidu.tieba.ko3;
import com.baidu.tieba.ko4;
import com.baidu.tieba.kv2;
import com.baidu.tieba.lb2;
import com.baidu.tieba.lo3;
import com.baidu.tieba.lp3;
import com.baidu.tieba.m92;
import com.baidu.tieba.ms1;
import com.baidu.tieba.nf3;
import com.baidu.tieba.oh3;
import com.baidu.tieba.pb2;
import com.baidu.tieba.px2;
import com.baidu.tieba.qi3;
import com.baidu.tieba.qx2;
import com.baidu.tieba.rn3;
import com.baidu.tieba.ro4;
import com.baidu.tieba.sy1;
import com.baidu.tieba.tp3;
import com.baidu.tieba.ui3;
import com.baidu.tieba.v53;
import com.baidu.tieba.vi3;
import com.baidu.tieba.vn3;
import com.baidu.tieba.vo3;
import com.baidu.tieba.vq3;
import com.baidu.tieba.vr3;
import com.baidu.tieba.wi2;
import com.baidu.tieba.wo3;
import com.baidu.tieba.wp3;
import com.baidu.tieba.ww2;
import com.baidu.tieba.x83;
import com.baidu.tieba.xi2;
import com.baidu.tieba.xq3;
import com.baidu.tieba.zb3;
import com.baidu.tieba.zn3;
import com.baidu.tieba.zw2;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, jb3.a, im3, ServiceConnection {
    public static final boolean B = ms1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public bp2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public io3 q;
    public boolean t;
    public OrientationEventListener u;
    public ko3 v;
    public er3 w;
    public jb3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final zb3 y = new zb3();
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
                bc3.K().c = i;
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
    public class a implements vq3<gc3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements vq3<gc3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements vq3<gc3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements xq3<gc3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xq3
        /* renamed from: b */
        public Boolean a(gc3.a aVar) {
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
            px2 T2 = px2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                lb2 U = T2.U();
                if (U == null) {
                    c92.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    c92.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    c92.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    kb2.U3(null);
                    lb2.b i = U.i("init");
                    int i2 = lb2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", c23.d(str, str), true).a();
                    er3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    vn3 vn3Var = new vn3();
                    vn3Var.k(1L);
                    vn3Var.i(2110L);
                    vn3Var.f("host url" + this.a);
                    zn3.a().f(vn3Var);
                    dj3 dj3Var = new dj3();
                    dj3Var.p(vn3Var);
                    dj3Var.r(bc3.K().q().W());
                    dj3Var.q(vi3.n(bc3.K().k()));
                    dj3Var.m(bc3.K().getAppId());
                    vi3.R(dj3Var);
                    return;
                }
            }
            c92.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jv2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ai3.d()) {
                ai3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            jv2.o().k();
            if (!d63.h()) {
                vo3.m(SwanAppActivity.this);
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
                ci3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements vq3<gc3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements vq3<gc3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements vq3<gc3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements vq3<gc3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements vq3<gc3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(gc3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        bp2 bp2Var = this.m;
        if (bp2Var != null) {
            bp2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        lo3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = m92.a(this);
        }
    }

    public void P() {
        int i2;
        if (T() != null && T().d0() == 1) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        if (U() != null) {
            U().F(i2);
        }
    }

    public String Q() {
        bp2 bp2Var = this.m;
        if (bp2Var == null) {
            return "";
        }
        return bp2Var.i;
    }

    public bp2 R() {
        return this.m;
    }

    public int S() {
        bp2 bp2Var = this.m;
        if (bp2Var == null) {
            return -1;
        }
        return bp2Var.k();
    }

    public zw2.a T() {
        bp2 bp2Var = this.m;
        if (bp2Var == null) {
            return null;
        }
        return bp2Var.Z();
    }

    public er3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public ko3 X() {
        return this.v;
    }

    @Nullable
    public lb2 Y() {
        bp2 bp2Var = this.m;
        if (bp2Var == null) {
            return null;
        }
        return bp2Var.c0();
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

    @Override // com.baidu.tieba.im3
    public hm3 b() {
        bp2 bp2Var = this.m;
        if (bp2Var == null) {
            return null;
        }
        return bp2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(ro4.e().b());
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
            c92.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = bc3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.jb3.a
    @NonNull
    public jb3 getFloatLayer() {
        if (this.x == null) {
            this.x = new jb3(this, (FrameLayout) findViewById(16908290), 0);
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
        bp2 bp2Var = this.m;
        if (bp2Var != null && bp2Var.g0()) {
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
        c92.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        qi3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        c92.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        ko3 ko3Var = this.v;
        if (ko3Var != null) {
            ko3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        c92.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            h53.m();
        }
        wo3.k(new k(), "tracer");
        jv2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            m92.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        bp2 bp2Var = this.m;
        if (bp2Var != null) {
            bp2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(ap2 ap2Var) {
        bp2 bp2Var = this.m;
        if (bp2Var != null) {
            bp2Var.T0(ap2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(fj3 fj3Var) {
        bp2 bp2Var = this.m;
        if (bp2Var != null) {
            bp2Var.Q(fj3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        jv2.H().d(this, i2, T());
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

    public final void l0(fx2 fx2Var) {
        if (c0() && fx2Var.b(" event_params_installer_progress")) {
            this.w.u(fx2Var.g(" event_params_installer_progress"));
        }
    }

    public final void o0(fx2 fx2Var) {
        bp2 bp2Var = this.m;
        if (bp2Var != null && bp2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(fx2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ko3 ko3Var = this.v;
        if (ko3Var != null) {
            ko3Var.n();
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
        wi2.U().b1(str);
    }

    public final void s0(String str) {
        wp3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        a93.k(this, bundle);
    }

    public void u0(ap2 ap2Var) {
        bp2 bp2Var = this.m;
        if (bp2Var != null) {
            bp2Var.I0(ap2Var);
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

    public void B0(boolean z, @Nullable gc3.a aVar) {
        if (this.w == null) {
            this.w = new er3(this);
        }
        er3 er3Var = this.w;
        boolean z2 = true;
        if (1 != bc3.K().q().W().G()) {
            z2 = false;
        }
        er3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        bp2 bp2Var = this.m;
        if ((bp2Var != null && bp2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (lp3.p(this)) {
                lp3.s(this);
            }
            lo3.e(this);
        }
    }

    public final synchronized boolean C0(cc3 cc3Var) {
        if (this.m != null) {
            N();
        }
        bp2 a2 = dp2.a(this, cc3Var);
        if (a2 == null) {
            vn3 vn3Var = new vn3();
            vn3Var.k(5L);
            vn3Var.i(11L);
            vn3Var.d("can not buildFramework");
            ww2.e(this, vn3Var, cc3Var.k(), cc3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (d63.h()) {
            v53.e().d(gVar, "updateMobStat", false);
        } else {
            wo3.k(gVar, "updateMobStat");
        }
        z0(cc3Var.W().d0(), cc3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        zw2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        io3 io3Var = this.q;
        if (io3Var != null && !z2) {
            io3Var.v(false);
        }
        if (a0() && !bc3.K().q().s0()) {
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
            vi3.Y();
            F0();
            return false;
        }
    }

    public final void n0(gc3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        zw2.a W = bc3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        c92.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        c92.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = h53.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        qx2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        cc3 q = bc3.K().q();
        if (!q.I()) {
            c92.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            c92.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            c92.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && io3.j()) {
                io3 m2 = io3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        c92.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + bc3.K().getAppId());
        boolean z2 = true;
        if (bc3.K().q().E() && bc3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, bc3.K().getAppId())) ? false : false;
        c92.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            ki3.b bVar = new ki3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(bc3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(fx2 fx2Var) {
        if (c0()) {
            this.w.I(fx2Var.n("app_icon_url"));
            this.w.K(fx2Var.n("app_name"));
            if (bc3.K().q().W().G() == 0) {
                this.w.L(fx2Var.i("app_pay_protected"));
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
        er3.A();
        er3.z(jv2.c());
        lb2 Y = Y();
        if (Y != null) {
            lb2.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        rn3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        ah3.r();
        cc3 q = bc3.K().q();
        q.e0().j();
        q.N().a();
        oh3.x();
        kv2.o().a();
    }

    public final void d0() {
        zb3 zb3Var = this.y;
        zb3Var.c(new d());
        zb3Var.f(new c(), "event_on_still_maintaining");
        zb3Var.f(new b(), "event_on_app_occupied");
        zb3Var.f(new a(), "event_on_app_updated");
        zb3Var.f(new p(), "event_on_app_icon_update");
        zb3Var.f(new o(), "event_on_pkg_maintain_finish");
        zb3Var.f(new n(), "installer_on_progress");
        zb3Var.f(new m(), "event_first_action_launched");
        zb3Var.f(new l(), "event_on_web_mode_launched");
        qx2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        bc3.K().o(this.y);
        c92.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        jv2.H().b();
        ko3 ko3Var = this.v;
        if (ko3Var != null) {
            ko3Var.p();
        }
        bc3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        px2.a0();
        String appId = bc3.K().getAppId();
        if (B) {
            hx2 d2 = hx2.d(appId);
            d2.e().c();
            d2.h();
        }
        ai3.l(true);
        bc3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        qx2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        c92.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !bc3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            bc3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (bc3.K().E() && bx2.a(intent)) {
                bc3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        ko3 ko3Var = this.v;
        if (ko3Var != null) {
            ko3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        eq3.b().d();
    }

    public final void m0() {
        if (pb2.b.a()) {
            r0(vr3.b(nf3.e()));
        } else if (!isDestroyed()) {
            if (bc3.K().q().I()) {
                H0(true);
            } else {
                bc3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        cc3 q = bc3.K().q();
        if (q != null) {
            String V = q.Y().V();
            hx2 d2 = hx2.d(q.Y().V());
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
        sy1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.sp4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        xi2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        jv2.G().b();
        x83.Q().c0();
        boolean z2 = true;
        this.s = true;
        qi3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ui3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (bp3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = bx2.a(intent);
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
        wi2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!jh2.a.c()) {
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
        c92.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        c92.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0098);
        if (S() == 0) {
            tp3.c(this);
        }
        d0();
        bc3 K = bc3.K();
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
                c92.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        tp3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new ko3(this);
        }
        ko3 ko3Var = this.v;
        if (ko3Var != null) {
            ko3Var.v(false);
        }
        ko3 ko3Var2 = this.v;
        if (ko3Var2 != null) {
            ko3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        wo3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        xi2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        c92.i("SwanApp", "SwanAppActivity onNewIntent");
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
        ko3 ko3Var = this.v;
        if (ko3Var != null) {
            ko3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            c92.i("SwanAppActivity", "onNewIntent: start swan web");
            bc3.K().q().A0();
        }
        this.s = true;
        qi3.l(true);
        bc3 K = bc3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && bx2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        io3 io3Var = this.q;
        if (io3Var != null) {
            io3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            c92.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (pb2.b.a() && bc3.K().q().z0() && ko4.d()) {
            H0(true);
            wi2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(ro4.e().b());
        } else if (bc3.K().q().z0() && ko4.d()) {
            H0(true);
            wi2.U().a1();
        } else {
            String D2 = jv2.o().D();
            if (jv2.a().c() && !wp3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", bc3.K().getAppId()).build().toString());
                return;
            }
            vn3 vn3Var = new vn3();
            vn3Var.k(1L);
            vn3Var.i(2109L);
            vn3Var.f("web mode start failed.");
            if (g0()) {
                zn3.a().f(vn3Var);
                dj3 dj3Var = new dj3();
                dj3Var.p(vn3Var);
                dj3Var.r(bc3.K().q().W());
                dj3Var.q(vi3.n(bc3.K().k()));
                dj3Var.m(bc3.K().getAppId());
                vi3.R(dj3Var);
            }
            ww2.e(jv2.c(), vn3Var, 0, "");
            F0();
        }
    }
}
