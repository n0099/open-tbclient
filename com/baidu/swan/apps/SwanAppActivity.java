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
import com.baidu.tieba.ai3;
import com.baidu.tieba.ak3;
import com.baidu.tieba.b73;
import com.baidu.tieba.bd2;
import com.baidu.tieba.br2;
import com.baidu.tieba.c72;
import com.baidu.tieba.ce3;
import com.baidu.tieba.ck3;
import com.baidu.tieba.ck4;
import com.baidu.tieba.cr2;
import com.baidu.tieba.d72;
import com.baidu.tieba.dk3;
import com.baidu.tieba.dl3;
import com.baidu.tieba.e52;
import com.baidu.tieba.eo1;
import com.baidu.tieba.fb3;
import com.baidu.tieba.gd3;
import com.baidu.tieba.h72;
import com.baidu.tieba.ht2;
import com.baidu.tieba.ie3;
import com.baidu.tieba.it2;
import com.baidu.tieba.jj3;
import com.baidu.tieba.jk4;
import com.baidu.tieba.ku1;
import com.baidu.tieba.ll3;
import com.baidu.tieba.me3;
import com.baidu.tieba.n13;
import com.baidu.tieba.ne3;
import com.baidu.tieba.nj3;
import com.baidu.tieba.nk3;
import com.baidu.tieba.nm3;
import com.baidu.tieba.nn3;
import com.baidu.tieba.oe2;
import com.baidu.tieba.ok3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.os2;
import com.baidu.tieba.p43;
import com.baidu.tieba.pe2;
import com.baidu.tieba.pm3;
import com.baidu.tieba.r73;
import com.baidu.tieba.rj3;
import com.baidu.tieba.rs2;
import com.baidu.tieba.s43;
import com.baidu.tieba.sc3;
import com.baidu.tieba.sd3;
import com.baidu.tieba.sk2;
import com.baidu.tieba.t73;
import com.baidu.tieba.tk2;
import com.baidu.tieba.tk3;
import com.baidu.tieba.ts2;
import com.baidu.tieba.u42;
import com.baidu.tieba.u73;
import com.baidu.tieba.ud3;
import com.baidu.tieba.ux2;
import com.baidu.tieba.v13;
import com.baidu.tieba.ve3;
import com.baidu.tieba.vk2;
import com.baidu.tieba.wl3;
import com.baidu.tieba.wm3;
import com.baidu.tieba.xe3;
import com.baidu.tieba.xs2;
import com.baidu.tieba.y73;
import com.baidu.tieba.z03;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zs2;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, b73.a, ai3, ServiceConnection {
    public static final boolean B = eo1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public tk2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public ak3 q;
    public boolean t;
    public OrientationEventListener u;
    public ck3 v;
    public wm3 w;
    public b73 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final r73 y = new r73();
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
                t73.K().c = i;
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
    public class a implements nm3<y73.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.p0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nm3<y73.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements nm3<y73.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.C0(true, aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements pm3<y73.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pm3
        /* renamed from: b */
        public Boolean a(y73.a aVar) {
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
            ht2 U = ht2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity != null && !activity.isFinishing()) {
                d72 V = U.V();
                if (V == null) {
                    u42.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    u42.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (V == null) {
                    u42.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    c72.V3(null);
                    d72.b i = V.i("init");
                    int i2 = d72.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", ux2.d(str, str), true).a();
                    wm3 V2 = activity.V();
                    if (V2 != null) {
                        V2.F(1);
                    }
                    nj3 nj3Var = new nj3();
                    nj3Var.k(1L);
                    nj3Var.i(2110L);
                    nj3Var.f("host url" + this.a);
                    rj3.a().f(nj3Var);
                    ve3 ve3Var = new ve3();
                    ve3Var.p(nj3Var);
                    ve3Var.r(t73.K().q().W());
                    ve3Var.q(ne3.n(t73.K().k()));
                    ve3Var.m(t73.K().getAppId());
                    ne3.R(ve3Var);
                    return;
                }
            }
            u42.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            br2.o().d();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (sd3.d()) {
                sd3.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            br2.o().k();
            if (!v13.h()) {
                nk3.m(SwanAppActivity.this);
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
                ud3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements nm3<y73.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.q0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes3.dex */
    public class m implements nm3<y73.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.E0();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements nm3<y73.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.m0(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class o implements nm3<y73.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.n0();
        }
    }

    /* loaded from: classes3.dex */
    public class p implements nm3<y73.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(y73.a aVar) {
            SwanAppActivity.this.K0(aVar);
        }
    }

    public void B0() {
        tk2 tk2Var = this.m;
        if (tk2Var != null) {
            tk2Var.M0();
        }
    }

    public final synchronized void E0() {
        F0(this.o);
    }

    public final void G0() {
        dk3.j(this);
    }

    public void N() {
        if (this.A == null) {
            this.A = e52.a(this);
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
        tk2 tk2Var = this.m;
        if (tk2Var == null) {
            return "";
        }
        return tk2Var.i;
    }

    public tk2 S() {
        return this.m;
    }

    public int T() {
        tk2 tk2Var = this.m;
        if (tk2Var == null) {
            return -1;
        }
        return tk2Var.k();
    }

    public rs2.a U() {
        tk2 tk2Var = this.m;
        if (tk2Var == null) {
            return null;
        }
        return tk2Var.Z();
    }

    public wm3 V() {
        return this.w;
    }

    public SwanAppProcessInfo W() {
        return SwanAppProcessInfo.P0;
    }

    public String X() {
        return this.r;
    }

    public ck3 Y() {
        return this.v;
    }

    @Nullable
    public d72 Z() {
        tk2 tk2Var = this.m;
        if (tk2Var == null) {
            return null;
        }
        return tk2Var.c0();
    }

    @Override // com.baidu.tieba.ai3
    public zh3 b() {
        tk2 tk2Var = this.m;
        if (tk2Var == null) {
            return null;
        }
        return tk2Var.d0();
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
        return !TextUtils.isEmpty(jk4.e().b());
    }

    @Override // com.baidu.tieba.b73.a
    @NonNull
    public b73 d() {
        if (this.x == null) {
            this.x = new b73(this, (FrameLayout) findViewById(16908290), 0);
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
            u42.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
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
        PMSAppInfo f0 = t73.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    public boolean k0() {
        tk2 tk2Var = this.m;
        if (tk2Var != null && tk2Var.g0()) {
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
        u42.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        J0(FrameLifeState.JUST_STARTED);
        this.s = false;
        ie3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        u42.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        ck3 ck3Var = this.v;
        if (ck3Var != null) {
            ck3Var.e();
        }
        J0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        u42.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        J0(FrameLifeState.JUST_CREATED);
        if (!b0()) {
            z03.m();
        }
        ok3.k(new k(), "tracer");
        br2.p0().flush(false);
    }

    public void w0() {
        View view2 = this.A;
        if (view2 != null) {
            e52.d(this, view2);
            this.A = null;
        }
    }

    public void x0() {
        tk2 tk2Var = this.m;
        if (tk2Var != null) {
            tk2Var.K0();
        }
    }

    public final synchronized void F0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void H0(sk2 sk2Var) {
        tk2 tk2Var = this.m;
        if (tk2Var != null) {
            tk2Var.T0(sk2Var);
        }
    }

    public final synchronized void J0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        E0();
    }

    public final void P(xe3 xe3Var) {
        tk2 tk2Var = this.m;
        if (tk2Var != null) {
            tk2Var.Q(xe3Var);
        }
    }

    @UiThread
    public void a0(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        br2.H().d(this, i2, U());
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

    public final void m0(xs2 xs2Var) {
        if (d0() && xs2Var.b(" event_params_installer_progress")) {
            this.w.u(xs2Var.g(" event_params_installer_progress"));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ck3 ck3Var = this.v;
        if (ck3Var != null) {
            ck3Var.n();
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

    public final void p0(xs2 xs2Var) {
        tk2 tk2Var = this.m;
        if (tk2Var != null && tk2Var.f0()) {
            I0("update_tag_by_activity_on_new_intent".equals(xs2Var.n("app_update_tag")));
        }
    }

    public void s0(String str) {
        I0(true);
        oe2.U().b1(str);
    }

    public final void t0(String str) {
        ol3.e0(new f(str));
    }

    public void u0(Bundle bundle) {
        s43.k(this, bundle);
    }

    public void v0(sk2 sk2Var) {
        tk2 tk2Var = this.m;
        if (tk2Var != null) {
            tk2Var.I0(sk2Var);
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
            if (dl3.p(this)) {
                dl3.s(this);
            }
            dk3.e(this);
        }
    }

    public void C0(boolean z, @Nullable y73.a aVar) {
        if (this.w == null) {
            this.w = new wm3(this);
        }
        wm3 wm3Var = this.w;
        boolean z2 = true;
        if (1 != t73.K().q().W().G()) {
            z2 = false;
        }
        wm3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        tk2 tk2Var = this.m;
        if ((tk2Var != null && tk2Var.r0(i2, keyEvent)) || this.A != null) {
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

    public final synchronized boolean D0(u73 u73Var) {
        if (this.m != null) {
            O();
        }
        tk2 a2 = vk2.a(this, u73Var);
        if (a2 == null) {
            nj3 nj3Var = new nj3();
            nj3Var.k(5L);
            nj3Var.i(11L);
            nj3Var.d("can not buildFramework");
            os2.e(this, nj3Var, u73Var.k(), u73Var.b);
            G0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (v13.h()) {
            n13.e().d(gVar, "updateMobStat", false);
        } else {
            ok3.k(gVar, "updateMobStat");
        }
        A0(u73Var.W().d0(), u73Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        rs2.a U = U();
        boolean z3 = false;
        if (U != null && "1230000000000000".equals(U.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        ak3 ak3Var = this.q;
        if (ak3Var != null && !z2) {
            ak3Var.v(false);
        }
        if (b0() && !t73.K().q().s0()) {
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
            ne3.Y();
            G0();
            return false;
        }
    }

    public final void o0(y73.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        rs2.a W = t73.K().q().W();
        A0(W.d0(), W.G());
        C0(false, aVar);
        u42.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void r0(int i2) {
        u42.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (b0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = z03.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        it2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void I0(boolean z) {
        u73 q = t73.K().q();
        if (!q.I()) {
            u42.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!f0(q.getAppId()) && !D0(q)) {
            u42.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            u42.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                y0();
            }
            if (this.q == null && ak3.j()) {
                ak3 m2 = ak3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(U(), getTaskId());
                }
            }
        }
    }

    public final boolean j0(String str) {
        boolean z;
        u42.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + t73.K().getAppId());
        boolean z2 = true;
        if (t73.K().q().E() && t73.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, t73.K().getAppId())) ? false : false;
        u42.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            ce3.b bVar = new ce3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(t73.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void K0(xs2 xs2Var) {
        if (d0()) {
            this.w.I(xs2Var.n("app_icon_url"));
            this.w.K(xs2Var.n("app_name"));
            if (t73.K().q().W().G() == 0) {
                this.w.L(xs2Var.i("app_pay_protected"));
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
        wm3.A();
        wm3.z(br2.c());
        d72 Z = Z();
        if (Z != null) {
            d72.b h2 = Z.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        jj3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        sc3.r();
        u73 q = t73.K().q();
        q.e0().j();
        q.N().a();
        gd3.x();
        cr2.o().a();
    }

    public final void e0() {
        r73 r73Var = this.y;
        r73Var.c(new d());
        r73Var.f(new c(), "event_on_still_maintaining");
        r73Var.f(new b(), "event_on_app_occupied");
        r73Var.f(new a(), "event_on_app_updated");
        r73Var.f(new p(), "event_on_app_icon_update");
        r73Var.f(new o(), "event_on_pkg_maintain_finish");
        r73Var.f(new n(), "installer_on_progress");
        r73Var.f(new m(), "event_first_action_launched");
        r73Var.f(new l(), "event_on_web_mode_launched");
        it2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        t73.K().o(this.y);
        u42.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        O();
        if (this.n != null) {
            unbindService(this);
        }
        br2.H().b();
        ck3 ck3Var = this.v;
        if (ck3Var != null) {
            ck3Var.p();
        }
        t73.K().r(this);
        J0(FrameLifeState.INACTIVATED);
        ht2.b0();
        String appId = t73.K().getAppId();
        if (B) {
            zs2 d2 = zs2.d(appId);
            d2.e().c();
            d2.h();
        }
        sd3.l(true);
        t73.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        it2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        u42.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !t73.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            t73.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (t73.K().E() && ts2.a(intent)) {
                t73.K().q().W().I0("1250000000000000");
            }
        }
        l0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        ck3 ck3Var = this.v;
        if (ck3Var != null) {
            ck3Var.t();
        }
        J0(FrameLifeState.JUST_RESUMED);
        wl3.b().d();
    }

    public final void n0() {
        if (h72.b.a()) {
            s0(nn3.b(fb3.e()));
        } else if (!isDestroyed()) {
            if (t73.K().q().I()) {
                I0(true);
            } else {
                t73.M().postDelayed(new e(), D);
            }
        }
    }

    public final void y0() {
        u73 q = t73.K().q();
        if (q != null) {
            String V = q.Y().V();
            zs2 d2 = zs2.d(q.Y().V());
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
        ku1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.kl4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        pe2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010022, R.anim.obfuscated_res_0x7f01001c);
        SwanAppProcessInfo.init(W());
        br2.G().b();
        p43.Q().c0();
        boolean z2 = true;
        this.s = true;
        ie3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        me3.d(i2);
        super.onCreate(bundle);
        J0(FrameLifeState.JUST_CREATED);
        if (tk3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = ts2.a(intent);
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
        oe2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!bd2.a.c()) {
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
        u42.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        u42.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0095);
        if (T() == 0) {
            ll3.c(this);
        }
        e0();
        t73 K = t73.K();
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
                u42.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        ll3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new ck3(this);
        }
        ck3 ck3Var = this.v;
        if (ck3Var != null) {
            ck3Var.u(false);
        }
        ck3 ck3Var2 = this.v;
        if (ck3Var2 != null) {
            ck3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        ok3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        pe2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        u42.i("SwanApp", "SwanAppActivity onNewIntent");
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
        ck3 ck3Var = this.v;
        if (ck3Var != null) {
            ck3Var.r();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            u42.i("SwanAppActivity", "onNewIntent: start swan web");
            t73.K().q().A0();
        }
        this.s = true;
        ie3.l(true);
        t73 K = t73.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && ts2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        ak3 ak3Var = this.q;
        if (ak3Var != null) {
            ak3Var.z(intent, getTaskId());
        }
    }

    public final void q0(String str) {
        if (!TextUtils.isEmpty(str)) {
            s0(str);
        } else if (isDestroyed()) {
            u42.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (h72.b.a() && t73.K().q().z0() && ck4.d()) {
            I0(true);
            oe2.U().a1();
        } else if (c0() && !h0()) {
            I0(true);
            t0(jk4.e().b());
        } else if (t73.K().q().z0() && ck4.d()) {
            I0(true);
            oe2.U().a1();
        } else {
            String D2 = br2.o().D();
            if (br2.a().c() && !ol3.G() && !TextUtils.isEmpty(D2)) {
                I0(true);
                t0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", t73.K().getAppId()).build().toString());
                return;
            }
            nj3 nj3Var = new nj3();
            nj3Var.k(1L);
            nj3Var.i(2109L);
            nj3Var.f("web mode start failed.");
            if (h0()) {
                rj3.a().f(nj3Var);
                ve3 ve3Var = new ve3();
                ve3Var.p(nj3Var);
                ve3Var.r(t73.K().q().W());
                ve3Var.q(ne3.n(t73.K().k()));
                ve3Var.m(t73.K().getAppId());
                ne3.R(ve3Var);
            }
            os2.e(br2.c(), nj3Var, 0, "");
            G0();
        }
    }
}
