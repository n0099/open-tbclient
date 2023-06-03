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
import com.baidu.tieba.aq3;
import com.baidu.tieba.ar3;
import com.baidu.tieba.bj3;
import com.baidu.tieba.bx2;
import com.baidu.tieba.cc3;
import com.baidu.tieba.d53;
import com.baidu.tieba.dm3;
import com.baidu.tieba.dx2;
import com.baidu.tieba.em3;
import com.baidu.tieba.eo3;
import com.baidu.tieba.fb3;
import com.baidu.tieba.fh2;
import com.baidu.tieba.fv2;
import com.baidu.tieba.gb2;
import com.baidu.tieba.gi3;
import com.baidu.tieba.go3;
import com.baidu.tieba.go4;
import com.baidu.tieba.gv2;
import com.baidu.tieba.hb2;
import com.baidu.tieba.ho3;
import com.baidu.tieba.hp3;
import com.baidu.tieba.i92;
import com.baidu.tieba.is1;
import com.baidu.tieba.jf3;
import com.baidu.tieba.kh3;
import com.baidu.tieba.lb2;
import com.baidu.tieba.lx2;
import com.baidu.tieba.mi3;
import com.baidu.tieba.mx2;
import com.baidu.tieba.nn3;
import com.baidu.tieba.no4;
import com.baidu.tieba.oy1;
import com.baidu.tieba.pp3;
import com.baidu.tieba.qi3;
import com.baidu.tieba.r53;
import com.baidu.tieba.ri3;
import com.baidu.tieba.rn3;
import com.baidu.tieba.ro3;
import com.baidu.tieba.rq3;
import com.baidu.tieba.rr3;
import com.baidu.tieba.si2;
import com.baidu.tieba.so3;
import com.baidu.tieba.sp3;
import com.baidu.tieba.sw2;
import com.baidu.tieba.t83;
import com.baidu.tieba.ti2;
import com.baidu.tieba.tq3;
import com.baidu.tieba.vb3;
import com.baidu.tieba.vn3;
import com.baidu.tieba.vw2;
import com.baidu.tieba.w83;
import com.baidu.tieba.wg3;
import com.baidu.tieba.wh3;
import com.baidu.tieba.wo2;
import com.baidu.tieba.xb3;
import com.baidu.tieba.xo2;
import com.baidu.tieba.xo3;
import com.baidu.tieba.xw2;
import com.baidu.tieba.y13;
import com.baidu.tieba.y82;
import com.baidu.tieba.yb3;
import com.baidu.tieba.yh3;
import com.baidu.tieba.z53;
import com.baidu.tieba.zi3;
import com.baidu.tieba.zo2;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, fb3.a, em3, ServiceConnection {
    public static final boolean B = is1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public xo2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public eo3 q;
    public boolean t;
    public OrientationEventListener u;
    public go3 v;
    public ar3 w;
    public fb3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final vb3 y = new vb3();
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
                xb3.K().c = i;
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
    public class a implements rq3<cc3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements rq3<cc3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements rq3<cc3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements tq3<cc3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tq3
        /* renamed from: b */
        public Boolean a(cc3.a aVar) {
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
            lx2 T2 = lx2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                hb2 U = T2.U();
                if (U == null) {
                    y82.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    y82.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    y82.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    gb2.U3(null);
                    hb2.b i = U.i("init");
                    int i2 = hb2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", y13.d(str, str), true).a();
                    ar3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    rn3 rn3Var = new rn3();
                    rn3Var.k(1L);
                    rn3Var.i(2110L);
                    rn3Var.f("host url" + this.a);
                    vn3.a().f(rn3Var);
                    zi3 zi3Var = new zi3();
                    zi3Var.p(rn3Var);
                    zi3Var.r(xb3.K().q().W());
                    zi3Var.q(ri3.n(xb3.K().k()));
                    zi3Var.m(xb3.K().getAppId());
                    ri3.R(zi3Var);
                    return;
                }
            }
            y82.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fv2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (wh3.d()) {
                wh3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fv2.o().k();
            if (!z53.h()) {
                ro3.m(SwanAppActivity.this);
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
                yh3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements rq3<cc3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements rq3<cc3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements rq3<cc3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements rq3<cc3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements rq3<cc3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(cc3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        xo2 xo2Var = this.m;
        if (xo2Var != null) {
            xo2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        ho3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = i92.a(this);
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
        xo2 xo2Var = this.m;
        if (xo2Var == null) {
            return "";
        }
        return xo2Var.i;
    }

    public xo2 R() {
        return this.m;
    }

    public int S() {
        xo2 xo2Var = this.m;
        if (xo2Var == null) {
            return -1;
        }
        return xo2Var.k();
    }

    public vw2.a T() {
        xo2 xo2Var = this.m;
        if (xo2Var == null) {
            return null;
        }
        return xo2Var.Z();
    }

    public ar3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public go3 X() {
        return this.v;
    }

    @Nullable
    public hb2 Y() {
        xo2 xo2Var = this.m;
        if (xo2Var == null) {
            return null;
        }
        return xo2Var.c0();
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

    @Override // com.baidu.tieba.em3
    public dm3 b() {
        xo2 xo2Var = this.m;
        if (xo2Var == null) {
            return null;
        }
        return xo2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(no4.e().b());
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
            y82.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = xb3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.fb3.a
    @NonNull
    public fb3 getFloatLayer() {
        if (this.x == null) {
            this.x = new fb3(this, (FrameLayout) findViewById(16908290), 0);
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
        xo2 xo2Var = this.m;
        if (xo2Var != null && xo2Var.g0()) {
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
        y82.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        mi3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        y82.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        go3 go3Var = this.v;
        if (go3Var != null) {
            go3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        y82.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            d53.m();
        }
        so3.k(new k(), "tracer");
        fv2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            i92.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        xo2 xo2Var = this.m;
        if (xo2Var != null) {
            xo2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(wo2 wo2Var) {
        xo2 xo2Var = this.m;
        if (xo2Var != null) {
            xo2Var.T0(wo2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(bj3 bj3Var) {
        xo2 xo2Var = this.m;
        if (xo2Var != null) {
            xo2Var.Q(bj3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        fv2.H().d(this, i2, T());
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

    public final void l0(bx2 bx2Var) {
        if (c0() && bx2Var.b(" event_params_installer_progress")) {
            this.w.u(bx2Var.g(" event_params_installer_progress"));
        }
    }

    public final void o0(bx2 bx2Var) {
        xo2 xo2Var = this.m;
        if (xo2Var != null && xo2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(bx2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        go3 go3Var = this.v;
        if (go3Var != null) {
            go3Var.n();
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
        si2.U().b1(str);
    }

    public final void s0(String str) {
        sp3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        w83.k(this, bundle);
    }

    public void u0(wo2 wo2Var) {
        xo2 xo2Var = this.m;
        if (xo2Var != null) {
            xo2Var.I0(wo2Var);
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

    public void B0(boolean z, @Nullable cc3.a aVar) {
        if (this.w == null) {
            this.w = new ar3(this);
        }
        ar3 ar3Var = this.w;
        boolean z2 = true;
        if (1 != xb3.K().q().W().G()) {
            z2 = false;
        }
        ar3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        xo2 xo2Var = this.m;
        if ((xo2Var != null && xo2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (hp3.p(this)) {
                hp3.s(this);
            }
            ho3.e(this);
        }
    }

    public final synchronized boolean C0(yb3 yb3Var) {
        if (this.m != null) {
            N();
        }
        xo2 a2 = zo2.a(this, yb3Var);
        if (a2 == null) {
            rn3 rn3Var = new rn3();
            rn3Var.k(5L);
            rn3Var.i(11L);
            rn3Var.d("can not buildFramework");
            sw2.e(this, rn3Var, yb3Var.k(), yb3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (z53.h()) {
            r53.e().d(gVar, "updateMobStat", false);
        } else {
            so3.k(gVar, "updateMobStat");
        }
        z0(yb3Var.W().d0(), yb3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        vw2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        eo3 eo3Var = this.q;
        if (eo3Var != null && !z2) {
            eo3Var.v(false);
        }
        if (a0() && !xb3.K().q().s0()) {
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
            ri3.Y();
            F0();
            return false;
        }
    }

    public final void n0(cc3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        vw2.a W = xb3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        y82.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        y82.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = d53.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        mx2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        yb3 q = xb3.K().q();
        if (!q.I()) {
            y82.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            y82.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            y82.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && eo3.j()) {
                eo3 m2 = eo3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        y82.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + xb3.K().getAppId());
        boolean z2 = true;
        if (xb3.K().q().E() && xb3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, xb3.K().getAppId())) ? false : false;
        y82.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            gi3.b bVar = new gi3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(xb3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(bx2 bx2Var) {
        if (c0()) {
            this.w.I(bx2Var.n("app_icon_url"));
            this.w.K(bx2Var.n("app_name"));
            if (xb3.K().q().W().G() == 0) {
                this.w.L(bx2Var.i("app_pay_protected"));
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
        ar3.A();
        ar3.z(fv2.c());
        hb2 Y = Y();
        if (Y != null) {
            hb2.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        nn3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        wg3.r();
        yb3 q = xb3.K().q();
        q.e0().j();
        q.N().a();
        kh3.x();
        gv2.o().a();
    }

    public final void d0() {
        vb3 vb3Var = this.y;
        vb3Var.c(new d());
        vb3Var.f(new c(), "event_on_still_maintaining");
        vb3Var.f(new b(), "event_on_app_occupied");
        vb3Var.f(new a(), "event_on_app_updated");
        vb3Var.f(new p(), "event_on_app_icon_update");
        vb3Var.f(new o(), "event_on_pkg_maintain_finish");
        vb3Var.f(new n(), "installer_on_progress");
        vb3Var.f(new m(), "event_first_action_launched");
        vb3Var.f(new l(), "event_on_web_mode_launched");
        mx2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        xb3.K().o(this.y);
        y82.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        fv2.H().b();
        go3 go3Var = this.v;
        if (go3Var != null) {
            go3Var.p();
        }
        xb3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        lx2.a0();
        String appId = xb3.K().getAppId();
        if (B) {
            dx2 d2 = dx2.d(appId);
            d2.e().c();
            d2.h();
        }
        wh3.l(true);
        xb3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        mx2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        y82.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !xb3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            xb3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (xb3.K().E() && xw2.a(intent)) {
                xb3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        go3 go3Var = this.v;
        if (go3Var != null) {
            go3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        aq3.b().d();
    }

    public final void m0() {
        if (lb2.b.a()) {
            r0(rr3.b(jf3.e()));
        } else if (!isDestroyed()) {
            if (xb3.K().q().I()) {
                H0(true);
            } else {
                xb3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        yb3 q = xb3.K().q();
        if (q != null) {
            String V = q.Y().V();
            dx2 d2 = dx2.d(q.Y().V());
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
        oy1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.op4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        ti2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        fv2.G().b();
        t83.Q().c0();
        boolean z2 = true;
        this.s = true;
        mi3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        qi3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (xo3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = xw2.a(intent);
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
        si2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!fh2.a.c()) {
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
        y82.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        y82.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0098);
        if (S() == 0) {
            pp3.c(this);
        }
        d0();
        xb3 K = xb3.K();
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
                y82.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        pp3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new go3(this);
        }
        go3 go3Var = this.v;
        if (go3Var != null) {
            go3Var.v(false);
        }
        go3 go3Var2 = this.v;
        if (go3Var2 != null) {
            go3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        so3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        ti2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        y82.i("SwanApp", "SwanAppActivity onNewIntent");
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
        go3 go3Var = this.v;
        if (go3Var != null) {
            go3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            y82.i("SwanAppActivity", "onNewIntent: start swan web");
            xb3.K().q().A0();
        }
        this.s = true;
        mi3.l(true);
        xb3 K = xb3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && xw2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        eo3 eo3Var = this.q;
        if (eo3Var != null) {
            eo3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            y82.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (lb2.b.a() && xb3.K().q().z0() && go4.d()) {
            H0(true);
            si2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(no4.e().b());
        } else if (xb3.K().q().z0() && go4.d()) {
            H0(true);
            si2.U().a1();
        } else {
            String D2 = fv2.o().D();
            if (fv2.a().c() && !sp3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", xb3.K().getAppId()).build().toString());
                return;
            }
            rn3 rn3Var = new rn3();
            rn3Var.k(1L);
            rn3Var.i(2109L);
            rn3Var.f("web mode start failed.");
            if (g0()) {
                vn3.a().f(rn3Var);
                zi3 zi3Var = new zi3();
                zi3Var.p(rn3Var);
                zi3Var.r(xb3.K().q().W());
                zi3Var.q(ri3.n(xb3.K().k()));
                zi3Var.m(xb3.K().getAppId());
                ri3.R(zi3Var);
            }
            sw2.e(fv2.c(), rn3Var, 0, "");
            F0();
        }
    }
}
