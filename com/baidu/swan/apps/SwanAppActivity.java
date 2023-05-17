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
import com.baidu.tieba.ag2;
import com.baidu.tieba.am3;
import com.baidu.tieba.an3;
import com.baidu.tieba.au2;
import com.baidu.tieba.b63;
import com.baidu.tieba.bg2;
import com.baidu.tieba.bo3;
import com.baidu.tieba.d93;
import com.baidu.tieba.dl3;
import com.baidu.tieba.du2;
import com.baidu.tieba.e63;
import com.baidu.tieba.ee3;
import com.baidu.tieba.ef3;
import com.baidu.tieba.em2;
import com.baidu.tieba.f93;
import com.baidu.tieba.fm2;
import com.baidu.tieba.fm3;
import com.baidu.tieba.fu2;
import com.baidu.tieba.g62;
import com.baidu.tieba.g93;
import com.baidu.tieba.gf3;
import com.baidu.tieba.gz2;
import com.baidu.tieba.h33;
import com.baidu.tieba.hg3;
import com.baidu.tieba.hm2;
import com.baidu.tieba.in3;
import com.baidu.tieba.io3;
import com.baidu.tieba.jg3;
import com.baidu.tieba.ju2;
import com.baidu.tieba.k93;
import com.baidu.tieba.l23;
import com.baidu.tieba.lj3;
import com.baidu.tieba.lu2;
import com.baidu.tieba.mj3;
import com.baidu.tieba.ml3;
import com.baidu.tieba.n83;
import com.baidu.tieba.ne2;
import com.baidu.tieba.ns2;
import com.baidu.tieba.o82;
import com.baidu.tieba.of3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.ol4;
import com.baidu.tieba.os2;
import com.baidu.tieba.p82;
import com.baidu.tieba.pl3;
import com.baidu.tieba.pm3;
import com.baidu.tieba.q62;
import com.baidu.tieba.qp1;
import com.baidu.tieba.rc3;
import com.baidu.tieba.se3;
import com.baidu.tieba.t82;
import com.baidu.tieba.tu2;
import com.baidu.tieba.uf3;
import com.baidu.tieba.uu2;
import com.baidu.tieba.vk3;
import com.baidu.tieba.vl4;
import com.baidu.tieba.wv1;
import com.baidu.tieba.xm3;
import com.baidu.tieba.yf3;
import com.baidu.tieba.z23;
import com.baidu.tieba.zf3;
import com.baidu.tieba.zk3;
import com.baidu.tieba.zl3;
import com.baidu.tieba.zn3;
import com.baidu.tieba.zo3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, n83.a, mj3, ServiceConnection {
    public static final boolean B = qp1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public fm2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public ml3 q;
    public boolean t;
    public OrientationEventListener u;
    public ol3 v;
    public io3 w;
    public n83 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final d93 y = new d93();
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
                f93.K().c = i;
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
    public class a implements zn3<k93.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.p0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zn3<k93.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements zn3<k93.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.C0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements bo3<k93.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bo3
        /* renamed from: b */
        public Boolean a(k93.a aVar) {
            return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity.this.G0();
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
            tu2 U = tu2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                p82 V = U.V();
                if (V == null) {
                    g62.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    g62.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (V == null) {
                    g62.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    o82.V3(null);
                    p82.b i = V.i("init");
                    int i2 = p82.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", gz2.d(str, str), true).a();
                    io3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    zk3 zk3Var = new zk3();
                    zk3Var.k(1L);
                    zk3Var.i(2110L);
                    zk3Var.f("host url" + this.a);
                    dl3.a().f(zk3Var);
                    hg3 hg3Var = new hg3();
                    hg3Var.p(zk3Var);
                    hg3Var.r(f93.K().q().W());
                    hg3Var.q(zf3.n(f93.K().k()));
                    hg3Var.m(f93.K().getAppId());
                    zf3.R(hg3Var);
                    return;
                }
            }
            g62.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ns2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ef3.d()) {
                ef3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ns2.o().k();
            if (!h33.h()) {
                zl3.m(SwanAppActivity.this);
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
                gf3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements zn3<k93.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.q0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements zn3<k93.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.E0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements zn3<k93.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.m0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements zn3<k93.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.n0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements zn3<k93.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(k93.a aVar) {
            SwanAppActivity.this.K0(aVar);
        }
    }

    public void B0() {
        fm2 fm2Var = this.m;
        if (fm2Var != null) {
            fm2Var.M0();
        }
    }

    public final synchronized void E0() {
        F0(this.o);
    }

    public final void G0() {
        pl3.j(this);
    }

    public void N() {
        if (this.A == null) {
            this.A = q62.a(this);
        }
    }

    public void Q() {
        int i2;
        if (U() != null && U().d0() == 1) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        if (V() != null) {
            V().F(i2);
        }
    }

    public String R() {
        fm2 fm2Var = this.m;
        if (fm2Var == null) {
            return "";
        }
        return fm2Var.i;
    }

    public fm2 S() {
        return this.m;
    }

    public int T() {
        fm2 fm2Var = this.m;
        if (fm2Var == null) {
            return -1;
        }
        return fm2Var.k();
    }

    public du2.a U() {
        fm2 fm2Var = this.m;
        if (fm2Var == null) {
            return null;
        }
        return fm2Var.Z();
    }

    public io3 V() {
        return this.w;
    }

    public SwanAppProcessInfo W() {
        return SwanAppProcessInfo.P0;
    }

    public String X() {
        return this.r;
    }

    public ol3 Y() {
        return this.v;
    }

    @Nullable
    public p82 Z() {
        fm2 fm2Var = this.m;
        if (fm2Var == null) {
            return null;
        }
        return fm2Var.c0();
    }

    @Override // com.baidu.tieba.mj3
    public lj3 b() {
        fm2 fm2Var = this.m;
        if (fm2Var == null) {
            return null;
        }
        return fm2Var.d0();
    }

    public synchronized boolean b0() {
        boolean z;
        if (!isDestroyed() && this.m != null) {
            if (this.m.a0().activated()) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    public final boolean c0() {
        return !TextUtils.isEmpty(vl4.e().b());
    }

    @Override // com.baidu.tieba.n83.a
    @NonNull
    public n83 d() {
        if (this.x == null) {
            this.x = new n83(this, (FrameLayout) findViewById(16908290), 0);
        }
        return this.x;
    }

    public final boolean d0() {
        if (this.w != null && !isDestroyed()) {
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (B) {
            g62.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public boolean g0() {
        return this.t;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder
    @NonNull
    public ActivityResultDispatcher getResultDispatcher() {
        if (this.p == null) {
            this.p = new ActivityResultDispatcher(this, 1);
        }
        return this.p;
    }

    public final boolean h0() {
        PMSAppInfo f0 = f93.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        fm2 fm2Var = this.m;
        if (fm2Var != null && fm2Var.g0()) {
            return true;
        }
        return false;
    }

    public void l0() {
        if (this.s) {
            this.r = "schema";
        } else {
            this.r = "user";
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        r0(1);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        g62.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        J0(FrameLifeState.JUST_STARTED);
        this.s = false;
        uf3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        g62.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        ol3 ol3Var = this.v;
        if (ol3Var != null) {
            ol3Var.e();
        }
        J0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        g62.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        J0(FrameLifeState.JUST_CREATED);
        if (!b0()) {
            l23.m();
        }
        am3.k(new k(), "tracer");
        ns2.p0().flush(false);
    }

    public void w0() {
        View view2 = this.A;
        if (view2 != null) {
            q62.d(this, view2);
            this.A = null;
        }
    }

    public void x0() {
        fm2 fm2Var = this.m;
        if (fm2Var != null) {
            fm2Var.K0();
        }
    }

    public final synchronized void F0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void H0(em2 em2Var) {
        fm2 fm2Var = this.m;
        if (fm2Var != null) {
            fm2Var.T0(em2Var);
        }
    }

    public final synchronized void J0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        E0();
    }

    public final void P(jg3 jg3Var) {
        fm2 fm2Var = this.m;
        if (fm2Var != null) {
            fm2Var.Q(jg3Var);
        }
    }

    @UiThread
    public void a0(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        ns2.H().d(this, i2, U());
    }

    public boolean f0(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, R())) {
            return true;
        }
        return false;
    }

    public final boolean i0(Intent intent) {
        if (intent == null) {
            return true;
        }
        ComponentName component = intent.getComponent();
        if (component != null && !component.getClassName().startsWith(C)) {
            return true;
        }
        return false;
    }

    public final void m0(ju2 ju2Var) {
        if (d0() && ju2Var.b(" event_params_installer_progress")) {
            this.w.u(ju2Var.g(" event_params_installer_progress"));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ol3 ol3Var = this.v;
        if (ol3Var != null) {
            ol3Var.n();
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
        if (b0()) {
            this.m.F0(i2);
        }
    }

    public final void p0(ju2 ju2Var) {
        fm2 fm2Var = this.m;
        if (fm2Var != null && fm2Var.f0()) {
            I0("update_tag_by_activity_on_new_intent".equals(ju2Var.n("app_update_tag")));
        }
    }

    public void s0(String str) {
        I0(true);
        ag2.U().b1(str);
    }

    public final void t0(String str) {
        an3.e0(new f(str));
    }

    public void u0(Bundle bundle) {
        e63.k(this, bundle);
    }

    public void v0(em2 em2Var) {
        fm2 fm2Var = this.m;
        if (fm2Var != null) {
            fm2Var.I0(em2Var);
        }
    }

    public void z0(String... strArr) {
        HashSet newHashSet;
        O();
        if (strArr == null) {
            newHashSet = Sets.newHashSet();
        } else {
            newHashSet = Sets.newHashSet(strArr);
        }
        if (newHashSet.contains("flag_finish_activity")) {
            if (newHashSet.contains("flag_remove_task")) {
                G0();
            } else {
                finish();
            }
        }
    }

    public final void A0(int i2, int i3) {
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
            if (pm3.p(this)) {
                pm3.s(this);
            }
            pl3.e(this);
        }
    }

    public void C0(boolean z, @Nullable k93.a aVar) {
        if (this.w == null) {
            this.w = new io3(this);
        }
        io3 io3Var = this.w;
        boolean z2 = true;
        if (1 != f93.K().q().W().G()) {
            z2 = false;
        }
        io3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        fm2 fm2Var = this.m;
        if ((fm2Var != null && fm2Var.r0(i2, keyEvent)) || this.A != null) {
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

    public final synchronized boolean D0(g93 g93Var) {
        if (this.m != null) {
            O();
        }
        fm2 a2 = hm2.a(this, g93Var);
        if (a2 == null) {
            zk3 zk3Var = new zk3();
            zk3Var.k(5L);
            zk3Var.i(11L);
            zk3Var.d("can not buildFramework");
            au2.e(this, zk3Var, g93Var.k(), g93Var.b);
            G0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (h33.h()) {
            z23.e().d(gVar, "updateMobStat", false);
        } else {
            am3.k(gVar, "updateMobStat");
        }
        A0(g93Var.W().d0(), g93Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        du2.a U = U();
        boolean z3 = false;
        if (U != null && "1230000000000000".equals(U.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        ml3 ml3Var = this.q;
        if (ml3Var != null && !z2) {
            ml3Var.v(false);
        }
        if (b0() && !f93.K().q().s0()) {
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
            zf3.Y();
            G0();
            return false;
        }
    }

    public final void o0(k93.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        du2.a W = f93.K().q().W();
        A0(W.d0(), W.G());
        C0(false, aVar);
        g62.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void r0(int i2) {
        g62.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (b0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = l23.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        uu2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void I0(boolean z) {
        g93 q = f93.K().q();
        if (!q.I()) {
            g62.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!f0(q.getAppId()) && !D0(q)) {
            g62.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            g62.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                y0();
            }
            if (this.q == null && ml3.j()) {
                ml3 m2 = ml3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(U(), getTaskId());
                }
            }
        }
    }

    public final boolean j0(String str) {
        boolean z;
        g62.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + f93.K().getAppId());
        boolean z2 = true;
        if (f93.K().q().E() && f93.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, f93.K().getAppId())) ? false : false;
        g62.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            of3.b bVar = new of3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(f93.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void K0(ju2 ju2Var) {
        if (d0()) {
            this.w.I(ju2Var.n("app_icon_url"));
            this.w.K(ju2Var.n("app_name"));
            if (f93.K().q().W().G() == 0) {
                this.w.L(ju2Var.i("app_pay_protected"));
            }
        }
    }

    public synchronized void O() {
        if (this.w != null) {
            this.w.H();
            if (B) {
                Log.i("SwanAppActivity", "destroyFrame resetLoadingView");
            }
        }
        io3.A();
        io3.z(ns2.c());
        p82 Z = Z();
        if (Z != null) {
            p82.b h2 = Z.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        vk3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        ee3.r();
        g93 q = f93.K().q();
        q.e0().j();
        q.N().a();
        se3.x();
        os2.o().a();
    }

    public final void e0() {
        d93 d93Var = this.y;
        d93Var.c(new d());
        d93Var.f(new c(), "event_on_still_maintaining");
        d93Var.f(new b(), "event_on_app_occupied");
        d93Var.f(new a(), "event_on_app_updated");
        d93Var.f(new p(), "event_on_app_icon_update");
        d93Var.f(new o(), "event_on_pkg_maintain_finish");
        d93Var.f(new n(), "installer_on_progress");
        d93Var.f(new m(), "event_first_action_launched");
        d93Var.f(new l(), "event_on_web_mode_launched");
        uu2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        f93.K().o(this.y);
        g62.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        O();
        if (this.n != null) {
            unbindService(this);
        }
        ns2.H().b();
        ol3 ol3Var = this.v;
        if (ol3Var != null) {
            ol3Var.p();
        }
        f93.K().r(this);
        J0(FrameLifeState.INACTIVATED);
        tu2.b0();
        String appId = f93.K().getAppId();
        if (B) {
            lu2 d2 = lu2.d(appId);
            d2.e().c();
            d2.h();
        }
        ef3.l(true);
        f93.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        uu2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        g62.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !f93.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            f93.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (f93.K().E() && fu2.a(intent)) {
                f93.K().q().W().I0("1250000000000000");
            }
        }
        l0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        ol3 ol3Var = this.v;
        if (ol3Var != null) {
            ol3Var.t();
        }
        J0(FrameLifeState.JUST_RESUMED);
        in3.b().d();
    }

    public final void n0() {
        if (t82.b.a()) {
            s0(zo3.b(rc3.e()));
        } else if (!isDestroyed()) {
            if (f93.K().q().I()) {
                I0(true);
            } else {
                f93.M().postDelayed(new e(), D);
            }
        }
    }

    public final void y0() {
        g93 q = f93.K().q();
        if (q != null) {
            String V = q.Y().V();
            lu2 d2 = lu2.d(q.Y().V());
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
        wv1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.wm4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        bg2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(W());
        ns2.G().b();
        b63.Q().c0();
        boolean z2 = true;
        this.s = true;
        uf3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        yf3.d(i2);
        super.onCreate(bundle);
        J0(FrameLifeState.JUST_CREATED);
        if (fm3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = fu2.a(intent);
        if (a2) {
            intent.putExtra("launch_id", SwanLauncher.h());
        }
        if (bundle != null && intent != null && (bundle2 = bundle.getBundle("swan_key_save_bundle")) != null) {
            ClassLoader classLoader = getClass().getClassLoader();
            bundle2.setClassLoader(classLoader);
            intent.setExtrasClassLoader(classLoader);
            intent.putExtras(bundle2);
        }
        if (i0(intent)) {
            G0();
            return;
        }
        ag2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!ne2.a.c()) {
            try {
                bindService(new Intent(this, W().service), this, 1);
            } catch (Exception e2) {
                if (B) {
                    e2.printStackTrace();
                }
            }
        }
        if (Build.VERSION.SDK_INT == 26) {
            TranslucentUtils.convertFromTranslucent(this);
        }
        g62.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        g62.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0098);
        if (T() == 0) {
            xm3.c(this);
        }
        e0();
        f93 K = f93.K();
        K.t(this);
        K.u(this.y);
        if (intent != null && (a2 || bundle == null)) {
            intent.putExtra("receive_launch_intent_time", currentTimeMillis);
            Bundle extras = intent.getExtras();
            String string = extras.getString("mAppId");
            if (bundle != null && j0(string)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                g62.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        xm3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new ol3(this);
        }
        ol3 ol3Var = this.v;
        if (ol3Var != null) {
            ol3Var.u(false);
        }
        ol3 ol3Var2 = this.v;
        if (ol3Var2 != null) {
            ol3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        am3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        bg2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        g62.i("SwanApp", "SwanAppActivity onNewIntent");
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
        ol3 ol3Var = this.v;
        if (ol3Var != null) {
            ol3Var.r();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            g62.i("SwanAppActivity", "onNewIntent: start swan web");
            f93.K().q().A0();
        }
        this.s = true;
        uf3.l(true);
        f93 K = f93.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && fu2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        ml3 ml3Var = this.q;
        if (ml3Var != null) {
            ml3Var.z(intent, getTaskId());
        }
    }

    public final void q0(String str) {
        if (!TextUtils.isEmpty(str)) {
            s0(str);
        } else if (isDestroyed()) {
            g62.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (t82.b.a() && f93.K().q().z0() && ol4.d()) {
            I0(true);
            ag2.U().a1();
        } else if (c0() && !h0()) {
            I0(true);
            t0(vl4.e().b());
        } else if (f93.K().q().z0() && ol4.d()) {
            I0(true);
            ag2.U().a1();
        } else {
            String D2 = ns2.o().D();
            if (ns2.a().c() && !an3.G() && !TextUtils.isEmpty(D2)) {
                I0(true);
                t0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", f93.K().getAppId()).build().toString());
                return;
            }
            zk3 zk3Var = new zk3();
            zk3Var.k(1L);
            zk3Var.i(2109L);
            zk3Var.f("web mode start failed.");
            if (h0()) {
                dl3.a().f(zk3Var);
                hg3 hg3Var = new hg3();
                hg3Var.p(zk3Var);
                hg3Var.r(f93.K().q().W());
                hg3Var.q(zf3.n(f93.K().k()));
                hg3Var.m(f93.K().getAppId());
                zf3.R(hg3Var);
            }
            au2.e(ns2.c(), zk3Var, 0, "");
            G0();
        }
    }
}
