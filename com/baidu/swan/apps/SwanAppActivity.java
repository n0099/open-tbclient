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
import com.baidu.tieba.a73;
import com.baidu.tieba.ad2;
import com.baidu.tieba.ar2;
import com.baidu.tieba.b72;
import com.baidu.tieba.be3;
import com.baidu.tieba.bk3;
import com.baidu.tieba.bk4;
import com.baidu.tieba.br2;
import com.baidu.tieba.c72;
import com.baidu.tieba.ck3;
import com.baidu.tieba.cl3;
import com.baidu.tieba.d52;
import com.baidu.tieba.do1;
import com.baidu.tieba.eb3;
import com.baidu.tieba.fd3;
import com.baidu.tieba.g72;
import com.baidu.tieba.gt2;
import com.baidu.tieba.he3;
import com.baidu.tieba.ht2;
import com.baidu.tieba.ij3;
import com.baidu.tieba.ik4;
import com.baidu.tieba.ju1;
import com.baidu.tieba.kl3;
import com.baidu.tieba.le3;
import com.baidu.tieba.m13;
import com.baidu.tieba.me3;
import com.baidu.tieba.mj3;
import com.baidu.tieba.mk3;
import com.baidu.tieba.mm3;
import com.baidu.tieba.mn3;
import com.baidu.tieba.ne2;
import com.baidu.tieba.nk3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.ns2;
import com.baidu.tieba.o43;
import com.baidu.tieba.oe2;
import com.baidu.tieba.om3;
import com.baidu.tieba.q73;
import com.baidu.tieba.qj3;
import com.baidu.tieba.qs2;
import com.baidu.tieba.r43;
import com.baidu.tieba.rc3;
import com.baidu.tieba.rd3;
import com.baidu.tieba.rk2;
import com.baidu.tieba.s73;
import com.baidu.tieba.sk2;
import com.baidu.tieba.sk3;
import com.baidu.tieba.ss2;
import com.baidu.tieba.t42;
import com.baidu.tieba.t73;
import com.baidu.tieba.td3;
import com.baidu.tieba.tx2;
import com.baidu.tieba.u13;
import com.baidu.tieba.ue3;
import com.baidu.tieba.uk2;
import com.baidu.tieba.vl3;
import com.baidu.tieba.vm3;
import com.baidu.tieba.we3;
import com.baidu.tieba.ws2;
import com.baidu.tieba.x73;
import com.baidu.tieba.y03;
import com.baidu.tieba.yh3;
import com.baidu.tieba.ys2;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zj3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, a73.a, zh3, ServiceConnection {
    public static final boolean B = do1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public sk2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public zj3 q;
    public boolean t;
    public OrientationEventListener u;
    public bk3 v;
    public vm3 w;
    public a73 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final q73 y = new q73();
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
                s73.K().c = i;
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
    public class a implements mm3<x73.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.p0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements mm3<x73.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements mm3<x73.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.C0(true, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements om3<x73.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public Boolean a(x73.a aVar) {
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
            gt2 U = gt2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                c72 V = U.V();
                if (V == null) {
                    t42.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    t42.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (V == null) {
                    t42.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    b72.V3(null);
                    c72.b i = V.i("init");
                    int i2 = c72.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", tx2.d(str, str), true).a();
                    vm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    mj3 mj3Var = new mj3();
                    mj3Var.k(1L);
                    mj3Var.i(2110L);
                    mj3Var.f("host url" + this.a);
                    qj3.a().f(mj3Var);
                    ue3 ue3Var = new ue3();
                    ue3Var.p(mj3Var);
                    ue3Var.r(s73.K().q().W());
                    ue3Var.q(me3.n(s73.K().k()));
                    ue3Var.m(s73.K().getAppId());
                    me3.R(ue3Var);
                    return;
                }
            }
            t42.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ar2.o().d();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (rd3.d()) {
                rd3.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ar2.o().k();
            if (!u13.h()) {
                mk3.m(SwanAppActivity.this);
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
                td3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements mm3<x73.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.q0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements mm3<x73.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.E0();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements mm3<x73.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.m0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements mm3<x73.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.n0();
        }
    }

    /* loaded from: classes3.dex */
    public class p implements mm3<x73.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(x73.a aVar) {
            SwanAppActivity.this.K0(aVar);
        }
    }

    public void B0() {
        sk2 sk2Var = this.m;
        if (sk2Var != null) {
            sk2Var.M0();
        }
    }

    public final synchronized void E0() {
        F0(this.o);
    }

    public final void G0() {
        ck3.j(this);
    }

    public void N() {
        if (this.A == null) {
            this.A = d52.a(this);
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
        sk2 sk2Var = this.m;
        if (sk2Var == null) {
            return "";
        }
        return sk2Var.i;
    }

    public sk2 S() {
        return this.m;
    }

    public int T() {
        sk2 sk2Var = this.m;
        if (sk2Var == null) {
            return -1;
        }
        return sk2Var.k();
    }

    public qs2.a U() {
        sk2 sk2Var = this.m;
        if (sk2Var == null) {
            return null;
        }
        return sk2Var.Z();
    }

    public vm3 V() {
        return this.w;
    }

    public SwanAppProcessInfo W() {
        return SwanAppProcessInfo.P0;
    }

    public String X() {
        return this.r;
    }

    public bk3 Y() {
        return this.v;
    }

    @Nullable
    public c72 Z() {
        sk2 sk2Var = this.m;
        if (sk2Var == null) {
            return null;
        }
        return sk2Var.c0();
    }

    @Override // com.baidu.tieba.zh3
    public yh3 b() {
        sk2 sk2Var = this.m;
        if (sk2Var == null) {
            return null;
        }
        return sk2Var.d0();
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
        return !TextUtils.isEmpty(ik4.e().b());
    }

    @Override // com.baidu.tieba.a73.a
    @NonNull
    public a73 d() {
        if (this.x == null) {
            this.x = new a73(this, (FrameLayout) findViewById(16908290), 0);
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
            t42.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
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
        PMSAppInfo f0 = s73.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        sk2 sk2Var = this.m;
        if (sk2Var != null && sk2Var.g0()) {
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
        t42.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        J0(FrameLifeState.JUST_STARTED);
        this.s = false;
        he3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        t42.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        bk3 bk3Var = this.v;
        if (bk3Var != null) {
            bk3Var.e();
        }
        J0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        t42.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        J0(FrameLifeState.JUST_CREATED);
        if (!b0()) {
            y03.m();
        }
        nk3.k(new k(), "tracer");
        ar2.p0().flush(false);
    }

    public void w0() {
        View view2 = this.A;
        if (view2 != null) {
            d52.d(this, view2);
            this.A = null;
        }
    }

    public void x0() {
        sk2 sk2Var = this.m;
        if (sk2Var != null) {
            sk2Var.K0();
        }
    }

    public final synchronized void F0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void H0(rk2 rk2Var) {
        sk2 sk2Var = this.m;
        if (sk2Var != null) {
            sk2Var.T0(rk2Var);
        }
    }

    public final synchronized void J0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        E0();
    }

    public final void P(we3 we3Var) {
        sk2 sk2Var = this.m;
        if (sk2Var != null) {
            sk2Var.Q(we3Var);
        }
    }

    @UiThread
    public void a0(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        ar2.H().d(this, i2, U());
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

    public final void m0(ws2 ws2Var) {
        if (d0() && ws2Var.b(" event_params_installer_progress")) {
            this.w.u(ws2Var.g(" event_params_installer_progress"));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        bk3 bk3Var = this.v;
        if (bk3Var != null) {
            bk3Var.n();
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

    public final void p0(ws2 ws2Var) {
        sk2 sk2Var = this.m;
        if (sk2Var != null && sk2Var.f0()) {
            I0("update_tag_by_activity_on_new_intent".equals(ws2Var.n("app_update_tag")));
        }
    }

    public void s0(String str) {
        I0(true);
        ne2.U().b1(str);
    }

    public final void t0(String str) {
        nl3.e0(new f(str));
    }

    public void u0(Bundle bundle) {
        r43.k(this, bundle);
    }

    public void v0(rk2 rk2Var) {
        sk2 sk2Var = this.m;
        if (sk2Var != null) {
            sk2Var.I0(rk2Var);
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
            if (cl3.p(this)) {
                cl3.s(this);
            }
            ck3.e(this);
        }
    }

    public void C0(boolean z, @Nullable x73.a aVar) {
        if (this.w == null) {
            this.w = new vm3(this);
        }
        vm3 vm3Var = this.w;
        boolean z2 = true;
        if (1 != s73.K().q().W().G()) {
            z2 = false;
        }
        vm3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        sk2 sk2Var = this.m;
        if ((sk2Var != null && sk2Var.r0(i2, keyEvent)) || this.A != null) {
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

    public final synchronized boolean D0(t73 t73Var) {
        if (this.m != null) {
            O();
        }
        sk2 a2 = uk2.a(this, t73Var);
        if (a2 == null) {
            mj3 mj3Var = new mj3();
            mj3Var.k(5L);
            mj3Var.i(11L);
            mj3Var.d("can not buildFramework");
            ns2.e(this, mj3Var, t73Var.k(), t73Var.b);
            G0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (u13.h()) {
            m13.e().d(gVar, "updateMobStat", false);
        } else {
            nk3.k(gVar, "updateMobStat");
        }
        A0(t73Var.W().d0(), t73Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        qs2.a U = U();
        boolean z3 = false;
        if (U != null && "1230000000000000".equals(U.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        zj3 zj3Var = this.q;
        if (zj3Var != null && !z2) {
            zj3Var.v(false);
        }
        if (b0() && !s73.K().q().s0()) {
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
            me3.Y();
            G0();
            return false;
        }
    }

    public final void o0(x73.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        qs2.a W = s73.K().q().W();
        A0(W.d0(), W.G());
        C0(false, aVar);
        t42.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void r0(int i2) {
        t42.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (b0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = y03.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        ht2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void I0(boolean z) {
        t73 q = s73.K().q();
        if (!q.I()) {
            t42.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!f0(q.getAppId()) && !D0(q)) {
            t42.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            t42.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                y0();
            }
            if (this.q == null && zj3.j()) {
                zj3 m2 = zj3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(U(), getTaskId());
                }
            }
        }
    }

    public final boolean j0(String str) {
        boolean z;
        t42.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + s73.K().getAppId());
        boolean z2 = true;
        if (s73.K().q().E() && s73.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, s73.K().getAppId())) ? false : false;
        t42.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            be3.b bVar = new be3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(s73.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void K0(ws2 ws2Var) {
        if (d0()) {
            this.w.I(ws2Var.n("app_icon_url"));
            this.w.K(ws2Var.n("app_name"));
            if (s73.K().q().W().G() == 0) {
                this.w.L(ws2Var.i("app_pay_protected"));
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
        vm3.A();
        vm3.z(ar2.c());
        c72 Z = Z();
        if (Z != null) {
            c72.b h2 = Z.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        ij3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        rc3.r();
        t73 q = s73.K().q();
        q.e0().j();
        q.N().a();
        fd3.x();
        br2.o().a();
    }

    public final void e0() {
        q73 q73Var = this.y;
        q73Var.c(new d());
        q73Var.f(new c(), "event_on_still_maintaining");
        q73Var.f(new b(), "event_on_app_occupied");
        q73Var.f(new a(), "event_on_app_updated");
        q73Var.f(new p(), "event_on_app_icon_update");
        q73Var.f(new o(), "event_on_pkg_maintain_finish");
        q73Var.f(new n(), "installer_on_progress");
        q73Var.f(new m(), "event_first_action_launched");
        q73Var.f(new l(), "event_on_web_mode_launched");
        ht2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        s73.K().o(this.y);
        t42.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        O();
        if (this.n != null) {
            unbindService(this);
        }
        ar2.H().b();
        bk3 bk3Var = this.v;
        if (bk3Var != null) {
            bk3Var.p();
        }
        s73.K().r(this);
        J0(FrameLifeState.INACTIVATED);
        gt2.b0();
        String appId = s73.K().getAppId();
        if (B) {
            ys2 d2 = ys2.d(appId);
            d2.e().c();
            d2.h();
        }
        rd3.l(true);
        s73.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        ht2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        t42.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !s73.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            s73.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (s73.K().E() && ss2.a(intent)) {
                s73.K().q().W().I0("1250000000000000");
            }
        }
        l0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        bk3 bk3Var = this.v;
        if (bk3Var != null) {
            bk3Var.t();
        }
        J0(FrameLifeState.JUST_RESUMED);
        vl3.b().d();
    }

    public final void n0() {
        if (g72.b.a()) {
            s0(mn3.b(eb3.e()));
        } else if (!isDestroyed()) {
            if (s73.K().q().I()) {
                I0(true);
            } else {
                s73.M().postDelayed(new e(), D);
            }
        }
    }

    public final void y0() {
        t73 q = s73.K().q();
        if (q != null) {
            String V = q.Y().V();
            ys2 d2 = ys2.d(q.Y().V());
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
        ju1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.jl4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        oe2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        SwanAppProcessInfo.init(W());
        ar2.G().b();
        o43.Q().c0();
        boolean z2 = true;
        this.s = true;
        he3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        le3.d(i2);
        super.onCreate(bundle);
        J0(FrameLifeState.JUST_CREATED);
        if (sk3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = ss2.a(intent);
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
        ne2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!ad2.a.c()) {
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
        t42.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        t42.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0096);
        if (T() == 0) {
            kl3.c(this);
        }
        e0();
        s73 K = s73.K();
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
                t42.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        kl3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new bk3(this);
        }
        bk3 bk3Var = this.v;
        if (bk3Var != null) {
            bk3Var.u(false);
        }
        bk3 bk3Var2 = this.v;
        if (bk3Var2 != null) {
            bk3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        nk3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        oe2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        t42.i("SwanApp", "SwanAppActivity onNewIntent");
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
        bk3 bk3Var = this.v;
        if (bk3Var != null) {
            bk3Var.r();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            t42.i("SwanAppActivity", "onNewIntent: start swan web");
            s73.K().q().A0();
        }
        this.s = true;
        he3.l(true);
        s73 K = s73.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && ss2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        zj3 zj3Var = this.q;
        if (zj3Var != null) {
            zj3Var.z(intent, getTaskId());
        }
    }

    public final void q0(String str) {
        if (!TextUtils.isEmpty(str)) {
            s0(str);
        } else if (isDestroyed()) {
            t42.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (g72.b.a() && s73.K().q().z0() && bk4.d()) {
            I0(true);
            ne2.U().a1();
        } else if (c0() && !h0()) {
            I0(true);
            t0(ik4.e().b());
        } else if (s73.K().q().z0() && bk4.d()) {
            I0(true);
            ne2.U().a1();
        } else {
            String D2 = ar2.o().D();
            if (ar2.a().c() && !nl3.G() && !TextUtils.isEmpty(D2)) {
                I0(true);
                t0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", s73.K().getAppId()).build().toString());
                return;
            }
            mj3 mj3Var = new mj3();
            mj3Var.k(1L);
            mj3Var.i(2109L);
            mj3Var.f("web mode start failed.");
            if (h0()) {
                qj3.a().f(mj3Var);
                ue3 ue3Var = new ue3();
                ue3Var.p(mj3Var);
                ue3Var.r(s73.K().q().W());
                ue3Var.q(me3.n(s73.K().k()));
                ue3Var.m(s73.K().getAppId());
                me3.R(ue3Var);
            }
            ns2.e(ar2.c(), mj3Var, 0, "");
            G0();
        }
    }
}
