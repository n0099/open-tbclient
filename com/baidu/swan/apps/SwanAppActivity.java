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
import com.baidu.tieba.a13;
import com.baidu.tieba.ai3;
import com.baidu.tieba.at2;
import com.baidu.tieba.bi3;
import com.baidu.tieba.bk3;
import com.baidu.tieba.c73;
import com.baidu.tieba.cd2;
import com.baidu.tieba.cr2;
import com.baidu.tieba.d72;
import com.baidu.tieba.de3;
import com.baidu.tieba.dk3;
import com.baidu.tieba.dk4;
import com.baidu.tieba.dr2;
import com.baidu.tieba.e72;
import com.baidu.tieba.ek3;
import com.baidu.tieba.el3;
import com.baidu.tieba.f52;
import com.baidu.tieba.fo1;
import com.baidu.tieba.gb3;
import com.baidu.tieba.hd3;
import com.baidu.tieba.i72;
import com.baidu.tieba.it2;
import com.baidu.tieba.je3;
import com.baidu.tieba.jt2;
import com.baidu.tieba.kj3;
import com.baidu.tieba.kk4;
import com.baidu.tieba.lu1;
import com.baidu.tieba.ml3;
import com.baidu.tieba.ne3;
import com.baidu.tieba.o13;
import com.baidu.tieba.oe3;
import com.baidu.tieba.oj3;
import com.baidu.tieba.ok3;
import com.baidu.tieba.om3;
import com.baidu.tieba.on3;
import com.baidu.tieba.pe2;
import com.baidu.tieba.pk3;
import com.baidu.tieba.pl3;
import com.baidu.tieba.ps2;
import com.baidu.tieba.q43;
import com.baidu.tieba.qe2;
import com.baidu.tieba.qm3;
import com.baidu.tieba.s73;
import com.baidu.tieba.sj3;
import com.baidu.tieba.ss2;
import com.baidu.tieba.t43;
import com.baidu.tieba.tc3;
import com.baidu.tieba.td3;
import com.baidu.tieba.tk2;
import com.baidu.tieba.u73;
import com.baidu.tieba.uk2;
import com.baidu.tieba.uk3;
import com.baidu.tieba.us2;
import com.baidu.tieba.v42;
import com.baidu.tieba.v73;
import com.baidu.tieba.vd3;
import com.baidu.tieba.vx2;
import com.baidu.tieba.w13;
import com.baidu.tieba.we3;
import com.baidu.tieba.wk2;
import com.baidu.tieba.xl3;
import com.baidu.tieba.xm3;
import com.baidu.tieba.ye3;
import com.baidu.tieba.ys2;
import com.baidu.tieba.z73;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, c73.a, bi3, ServiceConnection {
    public static final boolean B = fo1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public uk2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public bk3 q;
    public boolean t;
    public OrientationEventListener u;
    public dk3 v;
    public xm3 w;
    public c73 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final s73 y = new s73();
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
                u73.K().c = i;
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
    public class a implements om3<z73.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.p0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements om3<z73.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements om3<z73.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.C0(true, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements qm3<z73.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public Boolean a(z73.a aVar) {
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
            it2 U = it2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                e72 V = U.V();
                if (V == null) {
                    v42.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    v42.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (V == null) {
                    v42.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    d72.V3(null);
                    e72.b i = V.i("init");
                    int i2 = e72.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", vx2.d(str, str), true).a();
                    xm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    oj3 oj3Var = new oj3();
                    oj3Var.k(1L);
                    oj3Var.i(2110L);
                    oj3Var.f("host url" + this.a);
                    sj3.a().f(oj3Var);
                    we3 we3Var = new we3();
                    we3Var.p(oj3Var);
                    we3Var.r(u73.K().q().W());
                    we3Var.q(oe3.n(u73.K().k()));
                    we3Var.m(u73.K().getAppId());
                    oe3.R(we3Var);
                    return;
                }
            }
            v42.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cr2.o().d();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (td3.d()) {
                td3.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cr2.o().k();
            if (!w13.h()) {
                ok3.m(SwanAppActivity.this);
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
                vd3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements om3<z73.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.q0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements om3<z73.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.E0();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements om3<z73.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.m0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements om3<z73.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.n0();
        }
    }

    /* loaded from: classes3.dex */
    public class p implements om3<z73.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(z73.a aVar) {
            SwanAppActivity.this.K0(aVar);
        }
    }

    public void B0() {
        uk2 uk2Var = this.m;
        if (uk2Var != null) {
            uk2Var.M0();
        }
    }

    public final synchronized void E0() {
        F0(this.o);
    }

    public final void G0() {
        ek3.j(this);
    }

    public void N() {
        if (this.A == null) {
            this.A = f52.a(this);
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
        uk2 uk2Var = this.m;
        if (uk2Var == null) {
            return "";
        }
        return uk2Var.i;
    }

    public uk2 S() {
        return this.m;
    }

    public int T() {
        uk2 uk2Var = this.m;
        if (uk2Var == null) {
            return -1;
        }
        return uk2Var.k();
    }

    public ss2.a U() {
        uk2 uk2Var = this.m;
        if (uk2Var == null) {
            return null;
        }
        return uk2Var.Z();
    }

    public xm3 V() {
        return this.w;
    }

    public SwanAppProcessInfo W() {
        return SwanAppProcessInfo.P0;
    }

    public String X() {
        return this.r;
    }

    public dk3 Y() {
        return this.v;
    }

    @Nullable
    public e72 Z() {
        uk2 uk2Var = this.m;
        if (uk2Var == null) {
            return null;
        }
        return uk2Var.c0();
    }

    @Override // com.baidu.tieba.bi3
    public ai3 b() {
        uk2 uk2Var = this.m;
        if (uk2Var == null) {
            return null;
        }
        return uk2Var.d0();
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
        return !TextUtils.isEmpty(kk4.e().b());
    }

    @Override // com.baidu.tieba.c73.a
    @NonNull
    public c73 d() {
        if (this.x == null) {
            this.x = new c73(this, (FrameLayout) findViewById(16908290), 0);
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
            v42.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
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
        PMSAppInfo f0 = u73.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        uk2 uk2Var = this.m;
        if (uk2Var != null && uk2Var.g0()) {
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
        v42.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        J0(FrameLifeState.JUST_STARTED);
        this.s = false;
        je3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        v42.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        dk3 dk3Var = this.v;
        if (dk3Var != null) {
            dk3Var.e();
        }
        J0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        v42.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        J0(FrameLifeState.JUST_CREATED);
        if (!b0()) {
            a13.m();
        }
        pk3.k(new k(), "tracer");
        cr2.p0().flush(false);
    }

    public void w0() {
        View view2 = this.A;
        if (view2 != null) {
            f52.d(this, view2);
            this.A = null;
        }
    }

    public void x0() {
        uk2 uk2Var = this.m;
        if (uk2Var != null) {
            uk2Var.K0();
        }
    }

    public final synchronized void F0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void H0(tk2 tk2Var) {
        uk2 uk2Var = this.m;
        if (uk2Var != null) {
            uk2Var.T0(tk2Var);
        }
    }

    public final synchronized void J0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        E0();
    }

    public final void P(ye3 ye3Var) {
        uk2 uk2Var = this.m;
        if (uk2Var != null) {
            uk2Var.Q(ye3Var);
        }
    }

    @UiThread
    public void a0(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        cr2.H().d(this, i2, U());
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

    public final void m0(ys2 ys2Var) {
        if (d0() && ys2Var.b(" event_params_installer_progress")) {
            this.w.u(ys2Var.g(" event_params_installer_progress"));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        dk3 dk3Var = this.v;
        if (dk3Var != null) {
            dk3Var.n();
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

    public final void p0(ys2 ys2Var) {
        uk2 uk2Var = this.m;
        if (uk2Var != null && uk2Var.f0()) {
            I0("update_tag_by_activity_on_new_intent".equals(ys2Var.n("app_update_tag")));
        }
    }

    public void s0(String str) {
        I0(true);
        pe2.U().b1(str);
    }

    public final void t0(String str) {
        pl3.e0(new f(str));
    }

    public void u0(Bundle bundle) {
        t43.k(this, bundle);
    }

    public void v0(tk2 tk2Var) {
        uk2 uk2Var = this.m;
        if (uk2Var != null) {
            uk2Var.I0(tk2Var);
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
            if (el3.p(this)) {
                el3.s(this);
            }
            ek3.e(this);
        }
    }

    public void C0(boolean z, @Nullable z73.a aVar) {
        if (this.w == null) {
            this.w = new xm3(this);
        }
        xm3 xm3Var = this.w;
        boolean z2 = true;
        if (1 != u73.K().q().W().G()) {
            z2 = false;
        }
        xm3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        uk2 uk2Var = this.m;
        if ((uk2Var != null && uk2Var.r0(i2, keyEvent)) || this.A != null) {
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

    public final synchronized boolean D0(v73 v73Var) {
        if (this.m != null) {
            O();
        }
        uk2 a2 = wk2.a(this, v73Var);
        if (a2 == null) {
            oj3 oj3Var = new oj3();
            oj3Var.k(5L);
            oj3Var.i(11L);
            oj3Var.d("can not buildFramework");
            ps2.e(this, oj3Var, v73Var.k(), v73Var.b);
            G0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (w13.h()) {
            o13.e().d(gVar, "updateMobStat", false);
        } else {
            pk3.k(gVar, "updateMobStat");
        }
        A0(v73Var.W().d0(), v73Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        ss2.a U = U();
        boolean z3 = false;
        if (U != null && "1230000000000000".equals(U.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        bk3 bk3Var = this.q;
        if (bk3Var != null && !z2) {
            bk3Var.v(false);
        }
        if (b0() && !u73.K().q().s0()) {
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
            oe3.Y();
            G0();
            return false;
        }
    }

    public final void o0(z73.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        ss2.a W = u73.K().q().W();
        A0(W.d0(), W.G());
        C0(false, aVar);
        v42.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void r0(int i2) {
        v42.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (b0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = a13.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        jt2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void I0(boolean z) {
        v73 q = u73.K().q();
        if (!q.I()) {
            v42.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!f0(q.getAppId()) && !D0(q)) {
            v42.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            v42.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                y0();
            }
            if (this.q == null && bk3.j()) {
                bk3 m2 = bk3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(U(), getTaskId());
                }
            }
        }
    }

    public final boolean j0(String str) {
        boolean z;
        v42.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + u73.K().getAppId());
        boolean z2 = true;
        if (u73.K().q().E() && u73.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, u73.K().getAppId())) ? false : false;
        v42.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            de3.b bVar = new de3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(u73.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void K0(ys2 ys2Var) {
        if (d0()) {
            this.w.I(ys2Var.n("app_icon_url"));
            this.w.K(ys2Var.n("app_name"));
            if (u73.K().q().W().G() == 0) {
                this.w.L(ys2Var.i("app_pay_protected"));
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
        xm3.A();
        xm3.z(cr2.c());
        e72 Z = Z();
        if (Z != null) {
            e72.b h2 = Z.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        kj3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        tc3.r();
        v73 q = u73.K().q();
        q.e0().j();
        q.N().a();
        hd3.x();
        dr2.o().a();
    }

    public final void e0() {
        s73 s73Var = this.y;
        s73Var.c(new d());
        s73Var.f(new c(), "event_on_still_maintaining");
        s73Var.f(new b(), "event_on_app_occupied");
        s73Var.f(new a(), "event_on_app_updated");
        s73Var.f(new p(), "event_on_app_icon_update");
        s73Var.f(new o(), "event_on_pkg_maintain_finish");
        s73Var.f(new n(), "installer_on_progress");
        s73Var.f(new m(), "event_first_action_launched");
        s73Var.f(new l(), "event_on_web_mode_launched");
        jt2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        u73.K().o(this.y);
        v42.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        O();
        if (this.n != null) {
            unbindService(this);
        }
        cr2.H().b();
        dk3 dk3Var = this.v;
        if (dk3Var != null) {
            dk3Var.p();
        }
        u73.K().r(this);
        J0(FrameLifeState.INACTIVATED);
        it2.b0();
        String appId = u73.K().getAppId();
        if (B) {
            at2 d2 = at2.d(appId);
            d2.e().c();
            d2.h();
        }
        td3.l(true);
        u73.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        jt2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        v42.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !u73.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            u73.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (u73.K().E() && us2.a(intent)) {
                u73.K().q().W().I0("1250000000000000");
            }
        }
        l0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        dk3 dk3Var = this.v;
        if (dk3Var != null) {
            dk3Var.t();
        }
        J0(FrameLifeState.JUST_RESUMED);
        xl3.b().d();
    }

    public final void n0() {
        if (i72.b.a()) {
            s0(on3.b(gb3.e()));
        } else if (!isDestroyed()) {
            if (u73.K().q().I()) {
                I0(true);
            } else {
                u73.M().postDelayed(new e(), D);
            }
        }
    }

    public final void y0() {
        v73 q = u73.K().q();
        if (q != null) {
            String V = q.Y().V();
            at2 d2 = at2.d(q.Y().V());
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
        lu1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.ll4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        qe2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        SwanAppProcessInfo.init(W());
        cr2.G().b();
        q43.Q().c0();
        boolean z2 = true;
        this.s = true;
        je3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ne3.d(i2);
        super.onCreate(bundle);
        J0(FrameLifeState.JUST_CREATED);
        if (uk3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = us2.a(intent);
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
        pe2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!cd2.a.c()) {
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
        v42.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        v42.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0095);
        if (T() == 0) {
            ml3.c(this);
        }
        e0();
        u73 K = u73.K();
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
                v42.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        ml3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new dk3(this);
        }
        dk3 dk3Var = this.v;
        if (dk3Var != null) {
            dk3Var.u(false);
        }
        dk3 dk3Var2 = this.v;
        if (dk3Var2 != null) {
            dk3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        pk3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        qe2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        v42.i("SwanApp", "SwanAppActivity onNewIntent");
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
        dk3 dk3Var = this.v;
        if (dk3Var != null) {
            dk3Var.r();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            v42.i("SwanAppActivity", "onNewIntent: start swan web");
            u73.K().q().A0();
        }
        this.s = true;
        je3.l(true);
        u73 K = u73.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && us2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        bk3 bk3Var = this.q;
        if (bk3Var != null) {
            bk3Var.z(intent, getTaskId());
        }
    }

    public final void q0(String str) {
        if (!TextUtils.isEmpty(str)) {
            s0(str);
        } else if (isDestroyed()) {
            v42.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (i72.b.a() && u73.K().q().z0() && dk4.d()) {
            I0(true);
            pe2.U().a1();
        } else if (c0() && !h0()) {
            I0(true);
            t0(kk4.e().b());
        } else if (u73.K().q().z0() && dk4.d()) {
            I0(true);
            pe2.U().a1();
        } else {
            String D2 = cr2.o().D();
            if (cr2.a().c() && !pl3.G() && !TextUtils.isEmpty(D2)) {
                I0(true);
                t0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", u73.K().getAppId()).build().toString());
                return;
            }
            oj3 oj3Var = new oj3();
            oj3Var.k(1L);
            oj3Var.i(2109L);
            oj3Var.f("web mode start failed.");
            if (h0()) {
                sj3.a().f(oj3Var);
                we3 we3Var = new we3();
                we3Var.p(oj3Var);
                we3Var.r(u73.K().q().W());
                we3Var.q(oe3.n(u73.K().k()));
                we3Var.m(u73.K().getAppId());
                oe3.R(we3Var);
            }
            ps2.e(cr2.c(), oj3Var, 0, "");
            G0();
        }
    }
}
