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
import com.baidu.tieba.a53;
import com.baidu.tieba.ai3;
import com.baidu.tieba.an3;
import com.baidu.tieba.ao3;
import com.baidu.tieba.aq3;
import com.baidu.tieba.ar3;
import com.baidu.tieba.bi2;
import com.baidu.tieba.bo3;
import com.baidu.tieba.bp3;
import com.baidu.tieba.bw2;
import com.baidu.tieba.c83;
import com.baidu.tieba.ci2;
import com.baidu.tieba.cq3;
import com.baidu.tieba.eb3;
import com.baidu.tieba.en3;
import com.baidu.tieba.ew2;
import com.baidu.tieba.f83;
import com.baidu.tieba.fg3;
import com.baidu.tieba.fh3;
import com.baidu.tieba.fo2;
import com.baidu.tieba.gb3;
import com.baidu.tieba.go2;
import com.baidu.tieba.go3;
import com.baidu.tieba.gw2;
import com.baidu.tieba.h13;
import com.baidu.tieba.h82;
import com.baidu.tieba.hb3;
import com.baidu.tieba.hh3;
import com.baidu.tieba.i53;
import com.baidu.tieba.ii3;
import com.baidu.tieba.io2;
import com.baidu.tieba.jp3;
import com.baidu.tieba.jq3;
import com.baidu.tieba.ki3;
import com.baidu.tieba.kw2;
import com.baidu.tieba.lb3;
import com.baidu.tieba.m43;
import com.baidu.tieba.ml3;
import com.baidu.tieba.mw2;
import com.baidu.tieba.nl3;
import com.baidu.tieba.nn3;
import com.baidu.tieba.oa3;
import com.baidu.tieba.og2;
import com.baidu.tieba.ou2;
import com.baidu.tieba.pa2;
import com.baidu.tieba.ph3;
import com.baidu.tieba.pn3;
import com.baidu.tieba.pn4;
import com.baidu.tieba.pu2;
import com.baidu.tieba.qa2;
import com.baidu.tieba.qn3;
import com.baidu.tieba.qo3;
import com.baidu.tieba.r82;
import com.baidu.tieba.rr1;
import com.baidu.tieba.se3;
import com.baidu.tieba.tg3;
import com.baidu.tieba.ua2;
import com.baidu.tieba.uw2;
import com.baidu.tieba.vh3;
import com.baidu.tieba.vw2;
import com.baidu.tieba.wm3;
import com.baidu.tieba.wn4;
import com.baidu.tieba.xx1;
import com.baidu.tieba.yo3;
import com.baidu.tieba.zh3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, oa3.a, nl3, ServiceConnection {
    public static final boolean B = rr1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public go2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public nn3 q;
    public boolean t;
    public OrientationEventListener u;
    public pn3 v;
    public jq3 w;
    public oa3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final eb3 y = new eb3();
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
                gb3.K().c = i;
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
    public class a implements aq3<lb3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements aq3<lb3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements aq3<lb3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements cq3<lb3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cq3
        /* renamed from: b */
        public Boolean a(lb3.a aVar) {
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
            uw2 T2 = uw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                qa2 U = T2.U();
                if (U == null) {
                    h82.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    h82.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    h82.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    pa2.U3(null);
                    qa2.b i = U.i("init");
                    int i2 = qa2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", h13.d(str, str), true).a();
                    jq3 T3 = activity.T();
                    if (T3 != null) {
                        T3.F(1);
                    }
                    an3 an3Var = new an3();
                    an3Var.k(1L);
                    an3Var.i(2110L);
                    an3Var.f("host url" + this.a);
                    en3.a().f(an3Var);
                    ii3 ii3Var = new ii3();
                    ii3Var.p(an3Var);
                    ii3Var.r(gb3.K().q().W());
                    ii3Var.q(ai3.n(gb3.K().k()));
                    ii3Var.m(gb3.K().getAppId());
                    ai3.R(ii3Var);
                    return;
                }
            }
            h82.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ou2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (fh3.d()) {
                fh3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ou2.o().k();
            if (!i53.h()) {
                ao3.m(SwanAppActivity.this);
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
                hh3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements aq3<lb3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements aq3<lb3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements aq3<lb3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements aq3<lb3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements aq3<lb3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(lb3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        go2 go2Var = this.m;
        if (go2Var != null) {
            go2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        qn3.j(this);
    }

    public void L() {
        if (this.A == null) {
            this.A = r82.a(this);
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
        go2 go2Var = this.m;
        if (go2Var == null) {
            return "";
        }
        return go2Var.i;
    }

    public go2 Q() {
        return this.m;
    }

    public int R() {
        go2 go2Var = this.m;
        if (go2Var == null) {
            return -1;
        }
        return go2Var.k();
    }

    public ew2.a S() {
        go2 go2Var = this.m;
        if (go2Var == null) {
            return null;
        }
        return go2Var.Z();
    }

    public jq3 T() {
        return this.w;
    }

    public SwanAppProcessInfo U() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public pn3 X() {
        return this.v;
    }

    @Nullable
    public qa2 Y() {
        go2 go2Var = this.m;
        if (go2Var == null) {
            return null;
        }
        return go2Var.c0();
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

    @Override // com.baidu.tieba.nl3
    public ml3 b() {
        go2 go2Var = this.m;
        if (go2Var == null) {
            return null;
        }
        return go2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(wn4.e().b());
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
            h82.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = gb3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.oa3.a
    @NonNull
    public oa3 getFloatLayer() {
        if (this.x == null) {
            this.x = new oa3(this, (FrameLayout) findViewById(16908290), 0);
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
        go2 go2Var = this.m;
        if (go2Var != null && go2Var.g0()) {
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
        h82.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        vh3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        h82.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        pn3 pn3Var = this.v;
        if (pn3Var != null) {
            pn3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        h82.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            m43.m();
        }
        bo3.k(new k(), "tracer");
        ou2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            r82.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        go2 go2Var = this.m;
        if (go2Var != null) {
            go2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(fo2 fo2Var) {
        go2 go2Var = this.m;
        if (go2Var != null) {
            go2Var.T0(fo2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void N(ki3 ki3Var) {
        go2 go2Var = this.m;
        if (go2Var != null) {
            go2Var.Q(ki3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        ou2.H().d(this, i2, S());
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

    public final void l0(kw2 kw2Var) {
        if (c0() && kw2Var.b(" event_params_installer_progress")) {
            this.w.u(kw2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(kw2 kw2Var) {
        go2 go2Var = this.m;
        if (go2Var != null && go2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(kw2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        pn3 pn3Var = this.v;
        if (pn3Var != null) {
            pn3Var.n();
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
        bi2.U().b1(str);
    }

    public final void s0(String str) {
        bp3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        f83.k(this, bundle);
    }

    public void u0(fo2 fo2Var) {
        go2 go2Var = this.m;
        if (go2Var != null) {
            go2Var.I0(fo2Var);
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

    public void B0(boolean z, @Nullable lb3.a aVar) {
        if (this.w == null) {
            this.w = new jq3(this);
        }
        jq3 jq3Var = this.w;
        boolean z2 = true;
        if (1 != gb3.K().q().W().G()) {
            z2 = false;
        }
        jq3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        go2 go2Var = this.m;
        if ((go2Var != null && go2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (qo3.p(this)) {
                qo3.s(this);
            }
            qn3.e(this);
        }
    }

    public final synchronized boolean C0(hb3 hb3Var) {
        if (this.m != null) {
            M();
        }
        go2 a2 = io2.a(this, hb3Var);
        if (a2 == null) {
            an3 an3Var = new an3();
            an3Var.k(5L);
            an3Var.i(11L);
            an3Var.d("can not buildFramework");
            bw2.e(this, an3Var, hb3Var.k(), hb3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (i53.h()) {
            a53.e().d(gVar, "updateMobStat", false);
        } else {
            bo3.k(gVar, "updateMobStat");
        }
        z0(hb3Var.W().d0(), hb3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        ew2.a S = S();
        boolean z3 = false;
        if (S != null && "1230000000000000".equals(S.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        nn3 nn3Var = this.q;
        if (nn3Var != null && !z2) {
            nn3Var.v(false);
        }
        if (a0() && !gb3.K().q().s0()) {
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
            ai3.Y();
            F0();
            return false;
        }
    }

    public final void n0(lb3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        ew2.a W = gb3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        h82.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        h82.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = m43.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        vw2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        hb3 q = gb3.K().q();
        if (!q.I()) {
            h82.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            h82.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            h82.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && nn3.j()) {
                nn3 m2 = nn3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(S(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        h82.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + gb3.K().getAppId());
        boolean z2 = true;
        if (gb3.K().q().E() && gb3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, gb3.K().getAppId())) ? false : false;
        h82.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            ph3.b bVar = new ph3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(gb3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(kw2 kw2Var) {
        if (c0()) {
            this.w.I(kw2Var.n("app_icon_url"));
            this.w.K(kw2Var.n("app_name"));
            if (gb3.K().q().W().G() == 0) {
                this.w.L(kw2Var.h("app_pay_protected"));
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
        jq3.A();
        jq3.z(ou2.c());
        qa2 Y = Y();
        if (Y != null) {
            qa2.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        wm3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        fg3.r();
        hb3 q = gb3.K().q();
        q.e0().j();
        q.N().a();
        tg3.x();
        pu2.o().a();
    }

    public final void d0() {
        eb3 eb3Var = this.y;
        eb3Var.c(new d());
        eb3Var.f(new c(), "event_on_still_maintaining");
        eb3Var.f(new b(), "event_on_app_occupied");
        eb3Var.f(new a(), "event_on_app_updated");
        eb3Var.f(new p(), "event_on_app_icon_update");
        eb3Var.f(new o(), "event_on_pkg_maintain_finish");
        eb3Var.f(new n(), "installer_on_progress");
        eb3Var.f(new m(), "event_first_action_launched");
        eb3Var.f(new l(), "event_on_web_mode_launched");
        vw2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        gb3.K().o(this.y);
        h82.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        M();
        if (this.n != null) {
            unbindService(this);
        }
        ou2.H().b();
        pn3 pn3Var = this.v;
        if (pn3Var != null) {
            pn3Var.p();
        }
        gb3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        uw2.a0();
        String appId = gb3.K().getAppId();
        if (B) {
            mw2 d2 = mw2.d(appId);
            d2.e().c();
            d2.h();
        }
        fh3.l(true);
        gb3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        vw2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        h82.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !gb3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            gb3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (gb3.K().E() && gw2.a(intent)) {
                gb3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        pn3 pn3Var = this.v;
        if (pn3Var != null) {
            pn3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        jp3.b().d();
    }

    public final void m0() {
        if (ua2.b.a()) {
            r0(ar3.b(se3.e()));
        } else if (!isDestroyed()) {
            if (gb3.K().q().I()) {
                H0(true);
            } else {
                gb3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        hb3 q = gb3.K().q();
        if (q != null) {
            String V = q.Y().V();
            mw2 d2 = mw2.d(q.Y().V());
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
        xx1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.xo4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        ci2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(U());
        ou2.G().b();
        c83.Q().c0();
        boolean z2 = true;
        this.s = true;
        vh3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        zh3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (go3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = gw2.a(intent);
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
        bi2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!og2.a.c()) {
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
        h82.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        h82.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d009c);
        if (R() == 0) {
            yo3.c(this);
        }
        d0();
        gb3 K = gb3.K();
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
                h82.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        yo3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new pn3(this);
        }
        pn3 pn3Var = this.v;
        if (pn3Var != null) {
            pn3Var.v(false);
        }
        pn3 pn3Var2 = this.v;
        if (pn3Var2 != null) {
            pn3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        bo3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        ci2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        h82.i("SwanApp", "SwanAppActivity onNewIntent");
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
        pn3 pn3Var = this.v;
        if (pn3Var != null) {
            pn3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            h82.i("SwanAppActivity", "onNewIntent: start swan web");
            gb3.K().q().A0();
        }
        this.s = true;
        vh3.l(true);
        gb3 K = gb3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && gw2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        nn3 nn3Var = this.q;
        if (nn3Var != null) {
            nn3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            h82.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (ua2.b.a() && gb3.K().q().z0() && pn4.d()) {
            H0(true);
            bi2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(wn4.e().b());
        } else if (gb3.K().q().z0() && pn4.d()) {
            H0(true);
            bi2.U().a1();
        } else {
            String D2 = ou2.o().D();
            if (ou2.a().c() && !bp3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", gb3.K().getAppId()).build().toString());
                return;
            }
            an3 an3Var = new an3();
            an3Var.k(1L);
            an3Var.i(2109L);
            an3Var.f("web mode start failed.");
            if (g0()) {
                en3.a().f(an3Var);
                ii3 ii3Var = new ii3();
                ii3Var.p(an3Var);
                ii3Var.r(gb3.K().q().W());
                ii3Var.q(ai3.n(gb3.K().k()));
                ii3Var.m(gb3.K().getAppId());
                ai3.R(ii3Var);
            }
            bw2.e(ou2.c(), an3Var, 0, "");
            F0();
        }
    }
}
