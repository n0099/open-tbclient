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
import com.baidu.tieba.af3;
import com.baidu.tieba.at2;
import com.baidu.tieba.b83;
import com.baidu.tieba.c13;
import com.baidu.tieba.ci3;
import com.baidu.tieba.ct2;
import com.baidu.tieba.di3;
import com.baidu.tieba.dk3;
import com.baidu.tieba.e73;
import com.baidu.tieba.ed2;
import com.baidu.tieba.er2;
import com.baidu.tieba.f72;
import com.baidu.tieba.fe3;
import com.baidu.tieba.fk3;
import com.baidu.tieba.fk4;
import com.baidu.tieba.fr2;
import com.baidu.tieba.g72;
import com.baidu.tieba.gk3;
import com.baidu.tieba.gl3;
import com.baidu.tieba.h52;
import com.baidu.tieba.ho1;
import com.baidu.tieba.ib3;
import com.baidu.tieba.jd3;
import com.baidu.tieba.k72;
import com.baidu.tieba.kt2;
import com.baidu.tieba.le3;
import com.baidu.tieba.lt2;
import com.baidu.tieba.mj3;
import com.baidu.tieba.mk4;
import com.baidu.tieba.nu1;
import com.baidu.tieba.ol3;
import com.baidu.tieba.pe3;
import com.baidu.tieba.q13;
import com.baidu.tieba.qe3;
import com.baidu.tieba.qj3;
import com.baidu.tieba.qk3;
import com.baidu.tieba.qm3;
import com.baidu.tieba.qn3;
import com.baidu.tieba.re2;
import com.baidu.tieba.rk3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.rs2;
import com.baidu.tieba.s43;
import com.baidu.tieba.se2;
import com.baidu.tieba.sm3;
import com.baidu.tieba.u73;
import com.baidu.tieba.uj3;
import com.baidu.tieba.us2;
import com.baidu.tieba.v43;
import com.baidu.tieba.vc3;
import com.baidu.tieba.vd3;
import com.baidu.tieba.vk2;
import com.baidu.tieba.w73;
import com.baidu.tieba.wk2;
import com.baidu.tieba.wk3;
import com.baidu.tieba.ws2;
import com.baidu.tieba.x42;
import com.baidu.tieba.x73;
import com.baidu.tieba.xd3;
import com.baidu.tieba.xx2;
import com.baidu.tieba.y13;
import com.baidu.tieba.ye3;
import com.baidu.tieba.yk2;
import com.baidu.tieba.zl3;
import com.baidu.tieba.zm3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, e73.a, di3, ServiceConnection {
    public static final boolean B = ho1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public wk2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public dk3 q;
    public boolean t;
    public OrientationEventListener u;
    public fk3 v;
    public zm3 w;
    public e73 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final u73 y = new u73();
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
                w73.K().c = i;
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
    public class a implements qm3<b83.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.p0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements qm3<b83.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements qm3<b83.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.C0(true, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements sm3<b83.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sm3
        /* renamed from: b */
        public Boolean a(b83.a aVar) {
            return Boolean.valueOf(!SwanAppActivity.this.isDestroyed());
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity.this.G0();
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
            kt2 U = kt2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                g72 V = U.V();
                if (V == null) {
                    x42.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    x42.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (V == null) {
                    x42.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    f72.V3(null);
                    g72.b i = V.i("init");
                    int i2 = g72.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", xx2.d(str, str), true).a();
                    zm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    qj3 qj3Var = new qj3();
                    qj3Var.k(1L);
                    qj3Var.i(2110L);
                    qj3Var.f("host url" + this.a);
                    uj3.a().f(qj3Var);
                    ye3 ye3Var = new ye3();
                    ye3Var.p(qj3Var);
                    ye3Var.r(w73.K().q().W());
                    ye3Var.q(qe3.n(w73.K().k()));
                    ye3Var.m(w73.K().getAppId());
                    qe3.R(ye3Var);
                    return;
                }
            }
            x42.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            er2.o().d();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (vd3.d()) {
                vd3.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            er2.o().k();
            if (!y13.h()) {
                qk3.m(SwanAppActivity.this);
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
                xd3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements qm3<b83.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.q0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements qm3<b83.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.E0();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements qm3<b83.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.m0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements qm3<b83.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.n0();
        }
    }

    /* loaded from: classes3.dex */
    public class p implements qm3<b83.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(b83.a aVar) {
            SwanAppActivity.this.K0(aVar);
        }
    }

    public void B0() {
        wk2 wk2Var = this.m;
        if (wk2Var != null) {
            wk2Var.M0();
        }
    }

    public final synchronized void E0() {
        F0(this.o);
    }

    public final void G0() {
        gk3.j(this);
    }

    public void N() {
        if (this.A == null) {
            this.A = h52.a(this);
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
        wk2 wk2Var = this.m;
        if (wk2Var == null) {
            return "";
        }
        return wk2Var.i;
    }

    public wk2 S() {
        return this.m;
    }

    public int T() {
        wk2 wk2Var = this.m;
        if (wk2Var == null) {
            return -1;
        }
        return wk2Var.k();
    }

    public us2.a U() {
        wk2 wk2Var = this.m;
        if (wk2Var == null) {
            return null;
        }
        return wk2Var.Z();
    }

    public zm3 V() {
        return this.w;
    }

    public SwanAppProcessInfo W() {
        return SwanAppProcessInfo.P0;
    }

    public String X() {
        return this.r;
    }

    public fk3 Y() {
        return this.v;
    }

    @Nullable
    public g72 Z() {
        wk2 wk2Var = this.m;
        if (wk2Var == null) {
            return null;
        }
        return wk2Var.c0();
    }

    @Override // com.baidu.tieba.di3
    public ci3 b() {
        wk2 wk2Var = this.m;
        if (wk2Var == null) {
            return null;
        }
        return wk2Var.d0();
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
        return !TextUtils.isEmpty(mk4.e().b());
    }

    @Override // com.baidu.tieba.e73.a
    @NonNull
    public e73 d() {
        if (this.x == null) {
            this.x = new e73(this, (FrameLayout) findViewById(16908290), 0);
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
            x42.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
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
        PMSAppInfo f0 = w73.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        wk2 wk2Var = this.m;
        if (wk2Var != null && wk2Var.g0()) {
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
        x42.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        J0(FrameLifeState.JUST_STARTED);
        this.s = false;
        le3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        x42.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        fk3 fk3Var = this.v;
        if (fk3Var != null) {
            fk3Var.e();
        }
        J0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        x42.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        J0(FrameLifeState.JUST_CREATED);
        if (!b0()) {
            c13.m();
        }
        rk3.k(new k(), "tracer");
        er2.p0().flush(false);
    }

    public void w0() {
        View view2 = this.A;
        if (view2 != null) {
            h52.d(this, view2);
            this.A = null;
        }
    }

    public void x0() {
        wk2 wk2Var = this.m;
        if (wk2Var != null) {
            wk2Var.K0();
        }
    }

    public final synchronized void F0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void H0(vk2 vk2Var) {
        wk2 wk2Var = this.m;
        if (wk2Var != null) {
            wk2Var.T0(vk2Var);
        }
    }

    public final synchronized void J0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        E0();
    }

    public final void P(af3 af3Var) {
        wk2 wk2Var = this.m;
        if (wk2Var != null) {
            wk2Var.Q(af3Var);
        }
    }

    @UiThread
    public void a0(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        er2.H().d(this, i2, U());
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

    public final void m0(at2 at2Var) {
        if (d0() && at2Var.b(" event_params_installer_progress")) {
            this.w.u(at2Var.g(" event_params_installer_progress"));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        fk3 fk3Var = this.v;
        if (fk3Var != null) {
            fk3Var.n();
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

    public final void p0(at2 at2Var) {
        wk2 wk2Var = this.m;
        if (wk2Var != null && wk2Var.f0()) {
            I0("update_tag_by_activity_on_new_intent".equals(at2Var.n("app_update_tag")));
        }
    }

    public void s0(String str) {
        I0(true);
        re2.U().b1(str);
    }

    public final void t0(String str) {
        rl3.e0(new f(str));
    }

    public void u0(Bundle bundle) {
        v43.k(this, bundle);
    }

    public void v0(vk2 vk2Var) {
        wk2 wk2Var = this.m;
        if (wk2Var != null) {
            wk2Var.I0(vk2Var);
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
            if (gl3.p(this)) {
                gl3.s(this);
            }
            gk3.e(this);
        }
    }

    public void C0(boolean z, @Nullable b83.a aVar) {
        if (this.w == null) {
            this.w = new zm3(this);
        }
        zm3 zm3Var = this.w;
        boolean z2 = true;
        if (1 != w73.K().q().W().G()) {
            z2 = false;
        }
        zm3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        wk2 wk2Var = this.m;
        if ((wk2Var != null && wk2Var.r0(i2, keyEvent)) || this.A != null) {
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

    public final synchronized boolean D0(x73 x73Var) {
        if (this.m != null) {
            O();
        }
        wk2 a2 = yk2.a(this, x73Var);
        if (a2 == null) {
            qj3 qj3Var = new qj3();
            qj3Var.k(5L);
            qj3Var.i(11L);
            qj3Var.d("can not buildFramework");
            rs2.e(this, qj3Var, x73Var.k(), x73Var.b);
            G0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (y13.h()) {
            q13.e().d(gVar, "updateMobStat", false);
        } else {
            rk3.k(gVar, "updateMobStat");
        }
        A0(x73Var.W().d0(), x73Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        us2.a U = U();
        boolean z3 = false;
        if (U != null && "1230000000000000".equals(U.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        dk3 dk3Var = this.q;
        if (dk3Var != null && !z2) {
            dk3Var.v(false);
        }
        if (b0() && !w73.K().q().s0()) {
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
            qe3.Y();
            G0();
            return false;
        }
    }

    public final void o0(b83.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        us2.a W = w73.K().q().W();
        A0(W.d0(), W.G());
        C0(false, aVar);
        x42.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void r0(int i2) {
        x42.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (b0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = c13.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        lt2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void I0(boolean z) {
        x73 q = w73.K().q();
        if (!q.I()) {
            x42.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!f0(q.getAppId()) && !D0(q)) {
            x42.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            x42.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                y0();
            }
            if (this.q == null && dk3.j()) {
                dk3 m2 = dk3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(U(), getTaskId());
                }
            }
        }
    }

    public final boolean j0(String str) {
        boolean z;
        x42.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + w73.K().getAppId());
        boolean z2 = true;
        if (w73.K().q().E() && w73.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, w73.K().getAppId())) ? false : false;
        x42.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            fe3.b bVar = new fe3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(w73.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void K0(at2 at2Var) {
        if (d0()) {
            this.w.I(at2Var.n("app_icon_url"));
            this.w.K(at2Var.n("app_name"));
            if (w73.K().q().W().G() == 0) {
                this.w.L(at2Var.i("app_pay_protected"));
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
        zm3.A();
        zm3.z(er2.c());
        g72 Z = Z();
        if (Z != null) {
            g72.b h2 = Z.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        mj3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        vc3.r();
        x73 q = w73.K().q();
        q.e0().j();
        q.N().a();
        jd3.x();
        fr2.o().a();
    }

    public final void e0() {
        u73 u73Var = this.y;
        u73Var.c(new d());
        u73Var.f(new c(), "event_on_still_maintaining");
        u73Var.f(new b(), "event_on_app_occupied");
        u73Var.f(new a(), "event_on_app_updated");
        u73Var.f(new p(), "event_on_app_icon_update");
        u73Var.f(new o(), "event_on_pkg_maintain_finish");
        u73Var.f(new n(), "installer_on_progress");
        u73Var.f(new m(), "event_first_action_launched");
        u73Var.f(new l(), "event_on_web_mode_launched");
        lt2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        w73.K().o(this.y);
        x42.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        O();
        if (this.n != null) {
            unbindService(this);
        }
        er2.H().b();
        fk3 fk3Var = this.v;
        if (fk3Var != null) {
            fk3Var.p();
        }
        w73.K().r(this);
        J0(FrameLifeState.INACTIVATED);
        kt2.b0();
        String appId = w73.K().getAppId();
        if (B) {
            ct2 d2 = ct2.d(appId);
            d2.e().c();
            d2.h();
        }
        vd3.l(true);
        w73.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        lt2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        x42.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !w73.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            w73.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (w73.K().E() && ws2.a(intent)) {
                w73.K().q().W().I0("1250000000000000");
            }
        }
        l0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        fk3 fk3Var = this.v;
        if (fk3Var != null) {
            fk3Var.t();
        }
        J0(FrameLifeState.JUST_RESUMED);
        zl3.b().d();
    }

    public final void n0() {
        if (k72.b.a()) {
            s0(qn3.b(ib3.e()));
        } else if (!isDestroyed()) {
            if (w73.K().q().I()) {
                I0(true);
            } else {
                w73.M().postDelayed(new e(), D);
            }
        }
    }

    public final void y0() {
        x73 q = w73.K().q();
        if (q != null) {
            String V = q.Y().V();
            ct2 d2 = ct2.d(q.Y().V());
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
        nu1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.nl4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        se2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        SwanAppProcessInfo.init(W());
        er2.G().b();
        s43.Q().c0();
        boolean z2 = true;
        this.s = true;
        le3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        pe3.d(i2);
        super.onCreate(bundle);
        J0(FrameLifeState.JUST_CREATED);
        if (wk3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = ws2.a(intent);
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
        re2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!ed2.a.c()) {
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
        x42.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        x42.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0096);
        if (T() == 0) {
            ol3.c(this);
        }
        e0();
        w73 K = w73.K();
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
                x42.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        ol3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new fk3(this);
        }
        fk3 fk3Var = this.v;
        if (fk3Var != null) {
            fk3Var.u(false);
        }
        fk3 fk3Var2 = this.v;
        if (fk3Var2 != null) {
            fk3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        rk3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        se2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        x42.i("SwanApp", "SwanAppActivity onNewIntent");
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
        fk3 fk3Var = this.v;
        if (fk3Var != null) {
            fk3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            x42.i("SwanAppActivity", "onNewIntent: start swan web");
            w73.K().q().A0();
        }
        this.s = true;
        le3.l(true);
        w73 K = w73.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && ws2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        dk3 dk3Var = this.q;
        if (dk3Var != null) {
            dk3Var.z(intent, getTaskId());
        }
    }

    public final void q0(String str) {
        if (!TextUtils.isEmpty(str)) {
            s0(str);
        } else if (isDestroyed()) {
            x42.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (k72.b.a() && w73.K().q().z0() && fk4.d()) {
            I0(true);
            re2.U().a1();
        } else if (c0() && !h0()) {
            I0(true);
            t0(mk4.e().b());
        } else if (w73.K().q().z0() && fk4.d()) {
            I0(true);
            re2.U().a1();
        } else {
            String D2 = er2.o().D();
            if (er2.a().c() && !rl3.G() && !TextUtils.isEmpty(D2)) {
                I0(true);
                t0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", w73.K().getAppId()).build().toString());
                return;
            }
            qj3 qj3Var = new qj3();
            qj3Var.k(1L);
            qj3Var.i(2109L);
            qj3Var.f("web mode start failed.");
            if (h0()) {
                uj3.a().f(qj3Var);
                ye3 ye3Var = new ye3();
                ye3Var.p(qj3Var);
                ye3Var.r(w73.K().q().W());
                ye3Var.q(qe3.n(w73.K().k()));
                ye3Var.m(w73.K().getAppId());
                qe3.R(ye3Var);
            }
            rs2.e(er2.c(), qj3Var, 0, "");
            G0();
        }
    }
}
