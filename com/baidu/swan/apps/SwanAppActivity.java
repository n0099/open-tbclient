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
import com.baidu.tieba.a63;
import com.baidu.tieba.aj3;
import com.baidu.tieba.ap2;
import com.baidu.tieba.bq3;
import com.baidu.tieba.br3;
import com.baidu.tieba.cj3;
import com.baidu.tieba.cx2;
import com.baidu.tieba.dc3;
import com.baidu.tieba.e53;
import com.baidu.tieba.em3;
import com.baidu.tieba.ex2;
import com.baidu.tieba.fm3;
import com.baidu.tieba.fo3;
import com.baidu.tieba.gb3;
import com.baidu.tieba.gh2;
import com.baidu.tieba.gv2;
import com.baidu.tieba.hb2;
import com.baidu.tieba.hi3;
import com.baidu.tieba.ho3;
import com.baidu.tieba.ho4;
import com.baidu.tieba.hv2;
import com.baidu.tieba.ib2;
import com.baidu.tieba.io3;
import com.baidu.tieba.ip3;
import com.baidu.tieba.j92;
import com.baidu.tieba.js1;
import com.baidu.tieba.kf3;
import com.baidu.tieba.lh3;
import com.baidu.tieba.mb2;
import com.baidu.tieba.mx2;
import com.baidu.tieba.ni3;
import com.baidu.tieba.nx2;
import com.baidu.tieba.on3;
import com.baidu.tieba.oo4;
import com.baidu.tieba.py1;
import com.baidu.tieba.qp3;
import com.baidu.tieba.ri3;
import com.baidu.tieba.s53;
import com.baidu.tieba.si3;
import com.baidu.tieba.sn3;
import com.baidu.tieba.so3;
import com.baidu.tieba.sq3;
import com.baidu.tieba.sr3;
import com.baidu.tieba.ti2;
import com.baidu.tieba.to3;
import com.baidu.tieba.tp3;
import com.baidu.tieba.tw2;
import com.baidu.tieba.u83;
import com.baidu.tieba.ui2;
import com.baidu.tieba.uq3;
import com.baidu.tieba.wb3;
import com.baidu.tieba.wn3;
import com.baidu.tieba.ww2;
import com.baidu.tieba.x83;
import com.baidu.tieba.xg3;
import com.baidu.tieba.xh3;
import com.baidu.tieba.xo2;
import com.baidu.tieba.yb3;
import com.baidu.tieba.yo2;
import com.baidu.tieba.yo3;
import com.baidu.tieba.yw2;
import com.baidu.tieba.z13;
import com.baidu.tieba.z82;
import com.baidu.tieba.zb3;
import com.baidu.tieba.zh3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, gb3.a, fm3, ServiceConnection {
    public static final boolean B = js1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public yo2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public fo3 q;
    public boolean t;
    public OrientationEventListener u;
    public ho3 v;
    public br3 w;
    public gb3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final wb3 y = new wb3();
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
                yb3.K().c = i;
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
    public class a implements sq3<dc3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements sq3<dc3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements sq3<dc3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements uq3<dc3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uq3
        /* renamed from: b */
        public Boolean a(dc3.a aVar) {
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
            mx2 T2 = mx2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ib2 U = T2.U();
                if (U == null) {
                    z82.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    z82.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    z82.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    hb2.U3(null);
                    ib2.b i = U.i("init");
                    int i2 = ib2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", z13.d(str, str), true).a();
                    br3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    sn3 sn3Var = new sn3();
                    sn3Var.k(1L);
                    sn3Var.i(2110L);
                    sn3Var.f("host url" + this.a);
                    wn3.a().f(sn3Var);
                    aj3 aj3Var = new aj3();
                    aj3Var.p(sn3Var);
                    aj3Var.r(yb3.K().q().W());
                    aj3Var.q(si3.n(yb3.K().k()));
                    aj3Var.m(yb3.K().getAppId());
                    si3.R(aj3Var);
                    return;
                }
            }
            z82.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gv2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (xh3.d()) {
                xh3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gv2.o().k();
            if (!a63.h()) {
                so3.m(SwanAppActivity.this);
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
                zh3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements sq3<dc3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements sq3<dc3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements sq3<dc3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements sq3<dc3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements sq3<dc3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(dc3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        yo2 yo2Var = this.m;
        if (yo2Var != null) {
            yo2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        io3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = j92.a(this);
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
        yo2 yo2Var = this.m;
        if (yo2Var == null) {
            return "";
        }
        return yo2Var.i;
    }

    public yo2 R() {
        return this.m;
    }

    public int S() {
        yo2 yo2Var = this.m;
        if (yo2Var == null) {
            return -1;
        }
        return yo2Var.k();
    }

    public ww2.a T() {
        yo2 yo2Var = this.m;
        if (yo2Var == null) {
            return null;
        }
        return yo2Var.Z();
    }

    public br3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public ho3 X() {
        return this.v;
    }

    @Nullable
    public ib2 Y() {
        yo2 yo2Var = this.m;
        if (yo2Var == null) {
            return null;
        }
        return yo2Var.c0();
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

    @Override // com.baidu.tieba.fm3
    public em3 b() {
        yo2 yo2Var = this.m;
        if (yo2Var == null) {
            return null;
        }
        return yo2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(oo4.e().b());
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
            z82.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = yb3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.gb3.a
    @NonNull
    public gb3 getFloatLayer() {
        if (this.x == null) {
            this.x = new gb3(this, (FrameLayout) findViewById(16908290), 0);
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
        yo2 yo2Var = this.m;
        if (yo2Var != null && yo2Var.g0()) {
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
        z82.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        ni3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        z82.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        ho3 ho3Var = this.v;
        if (ho3Var != null) {
            ho3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        z82.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            e53.m();
        }
        to3.k(new k(), "tracer");
        gv2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            j92.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        yo2 yo2Var = this.m;
        if (yo2Var != null) {
            yo2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(xo2 xo2Var) {
        yo2 yo2Var = this.m;
        if (yo2Var != null) {
            yo2Var.T0(xo2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(cj3 cj3Var) {
        yo2 yo2Var = this.m;
        if (yo2Var != null) {
            yo2Var.Q(cj3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        gv2.H().d(this, i2, T());
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

    public final void l0(cx2 cx2Var) {
        if (c0() && cx2Var.b(" event_params_installer_progress")) {
            this.w.u(cx2Var.g(" event_params_installer_progress"));
        }
    }

    public final void o0(cx2 cx2Var) {
        yo2 yo2Var = this.m;
        if (yo2Var != null && yo2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(cx2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ho3 ho3Var = this.v;
        if (ho3Var != null) {
            ho3Var.n();
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
        ti2.U().b1(str);
    }

    public final void s0(String str) {
        tp3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        x83.k(this, bundle);
    }

    public void u0(xo2 xo2Var) {
        yo2 yo2Var = this.m;
        if (yo2Var != null) {
            yo2Var.I0(xo2Var);
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

    public void B0(boolean z, @Nullable dc3.a aVar) {
        if (this.w == null) {
            this.w = new br3(this);
        }
        br3 br3Var = this.w;
        boolean z2 = true;
        if (1 != yb3.K().q().W().G()) {
            z2 = false;
        }
        br3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        yo2 yo2Var = this.m;
        if ((yo2Var != null && yo2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (ip3.p(this)) {
                ip3.s(this);
            }
            io3.e(this);
        }
    }

    public final synchronized boolean C0(zb3 zb3Var) {
        if (this.m != null) {
            N();
        }
        yo2 a2 = ap2.a(this, zb3Var);
        if (a2 == null) {
            sn3 sn3Var = new sn3();
            sn3Var.k(5L);
            sn3Var.i(11L);
            sn3Var.d("can not buildFramework");
            tw2.e(this, sn3Var, zb3Var.k(), zb3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (a63.h()) {
            s53.e().d(gVar, "updateMobStat", false);
        } else {
            to3.k(gVar, "updateMobStat");
        }
        z0(zb3Var.W().d0(), zb3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        ww2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        fo3 fo3Var = this.q;
        if (fo3Var != null && !z2) {
            fo3Var.v(false);
        }
        if (a0() && !yb3.K().q().s0()) {
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
            si3.Y();
            F0();
            return false;
        }
    }

    public final void n0(dc3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        ww2.a W = yb3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        z82.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        z82.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = e53.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        nx2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        zb3 q = yb3.K().q();
        if (!q.I()) {
            z82.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            z82.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            z82.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && fo3.j()) {
                fo3 m2 = fo3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        z82.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + yb3.K().getAppId());
        boolean z2 = true;
        if (yb3.K().q().E() && yb3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, yb3.K().getAppId())) ? false : false;
        z82.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            hi3.b bVar = new hi3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(yb3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(cx2 cx2Var) {
        if (c0()) {
            this.w.I(cx2Var.n("app_icon_url"));
            this.w.K(cx2Var.n("app_name"));
            if (yb3.K().q().W().G() == 0) {
                this.w.L(cx2Var.i("app_pay_protected"));
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
        br3.A();
        br3.z(gv2.c());
        ib2 Y = Y();
        if (Y != null) {
            ib2.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        on3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        xg3.r();
        zb3 q = yb3.K().q();
        q.e0().j();
        q.N().a();
        lh3.x();
        hv2.o().a();
    }

    public final void d0() {
        wb3 wb3Var = this.y;
        wb3Var.c(new d());
        wb3Var.f(new c(), "event_on_still_maintaining");
        wb3Var.f(new b(), "event_on_app_occupied");
        wb3Var.f(new a(), "event_on_app_updated");
        wb3Var.f(new p(), "event_on_app_icon_update");
        wb3Var.f(new o(), "event_on_pkg_maintain_finish");
        wb3Var.f(new n(), "installer_on_progress");
        wb3Var.f(new m(), "event_first_action_launched");
        wb3Var.f(new l(), "event_on_web_mode_launched");
        nx2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        yb3.K().o(this.y);
        z82.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        gv2.H().b();
        ho3 ho3Var = this.v;
        if (ho3Var != null) {
            ho3Var.p();
        }
        yb3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        mx2.a0();
        String appId = yb3.K().getAppId();
        if (B) {
            ex2 d2 = ex2.d(appId);
            d2.e().c();
            d2.h();
        }
        xh3.l(true);
        yb3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        nx2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        z82.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !yb3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            yb3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (yb3.K().E() && yw2.a(intent)) {
                yb3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        ho3 ho3Var = this.v;
        if (ho3Var != null) {
            ho3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        bq3.b().d();
    }

    public final void m0() {
        if (mb2.b.a()) {
            r0(sr3.b(kf3.e()));
        } else if (!isDestroyed()) {
            if (yb3.K().q().I()) {
                H0(true);
            } else {
                yb3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        zb3 q = yb3.K().q();
        if (q != null) {
            String V = q.Y().V();
            ex2 d2 = ex2.d(q.Y().V());
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
        py1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.pp4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        ui2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        gv2.G().b();
        u83.Q().c0();
        boolean z2 = true;
        this.s = true;
        ni3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ri3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (yo3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = yw2.a(intent);
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
        ti2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!gh2.a.c()) {
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
        z82.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        z82.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0098);
        if (S() == 0) {
            qp3.c(this);
        }
        d0();
        yb3 K = yb3.K();
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
                z82.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        qp3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new ho3(this);
        }
        ho3 ho3Var = this.v;
        if (ho3Var != null) {
            ho3Var.v(false);
        }
        ho3 ho3Var2 = this.v;
        if (ho3Var2 != null) {
            ho3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        to3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        ui2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        z82.i("SwanApp", "SwanAppActivity onNewIntent");
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
        ho3 ho3Var = this.v;
        if (ho3Var != null) {
            ho3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            z82.i("SwanAppActivity", "onNewIntent: start swan web");
            yb3.K().q().A0();
        }
        this.s = true;
        ni3.l(true);
        yb3 K = yb3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && yw2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        fo3 fo3Var = this.q;
        if (fo3Var != null) {
            fo3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            z82.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (mb2.b.a() && yb3.K().q().z0() && ho4.d()) {
            H0(true);
            ti2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(oo4.e().b());
        } else if (yb3.K().q().z0() && ho4.d()) {
            H0(true);
            ti2.U().a1();
        } else {
            String D2 = gv2.o().D();
            if (gv2.a().c() && !tp3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", yb3.K().getAppId()).build().toString());
                return;
            }
            sn3 sn3Var = new sn3();
            sn3Var.k(1L);
            sn3Var.i(2109L);
            sn3Var.f("web mode start failed.");
            if (g0()) {
                wn3.a().f(sn3Var);
                aj3 aj3Var = new aj3();
                aj3Var.p(sn3Var);
                aj3Var.r(yb3.K().q().W());
                aj3Var.q(si3.n(yb3.K().k()));
                aj3Var.m(yb3.K().getAppId());
                si3.R(aj3Var);
            }
            tw2.e(gv2.c(), sn3Var, 0, "");
            F0();
        }
    }
}
