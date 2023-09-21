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
import com.baidu.tieba.ai2;
import com.baidu.tieba.ao3;
import com.baidu.tieba.ap3;
import com.baidu.tieba.aw2;
import com.baidu.tieba.b83;
import com.baidu.tieba.bi2;
import com.baidu.tieba.bq3;
import com.baidu.tieba.db3;
import com.baidu.tieba.dn3;
import com.baidu.tieba.dw2;
import com.baidu.tieba.e83;
import com.baidu.tieba.eg3;
import com.baidu.tieba.eh3;
import com.baidu.tieba.eo2;
import com.baidu.tieba.fb3;
import com.baidu.tieba.fo2;
import com.baidu.tieba.fo3;
import com.baidu.tieba.fw2;
import com.baidu.tieba.g13;
import com.baidu.tieba.g82;
import com.baidu.tieba.gb3;
import com.baidu.tieba.gh3;
import com.baidu.tieba.h53;
import com.baidu.tieba.hi3;
import com.baidu.tieba.ho2;
import com.baidu.tieba.ip3;
import com.baidu.tieba.iq3;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jw2;
import com.baidu.tieba.kb3;
import com.baidu.tieba.l43;
import com.baidu.tieba.ll3;
import com.baidu.tieba.lw2;
import com.baidu.tieba.ml3;
import com.baidu.tieba.mn3;
import com.baidu.tieba.na3;
import com.baidu.tieba.ng2;
import com.baidu.tieba.nu2;
import com.baidu.tieba.oa2;
import com.baidu.tieba.oh3;
import com.baidu.tieba.on3;
import com.baidu.tieba.on4;
import com.baidu.tieba.ou2;
import com.baidu.tieba.pa2;
import com.baidu.tieba.pn3;
import com.baidu.tieba.po3;
import com.baidu.tieba.q82;
import com.baidu.tieba.qr1;
import com.baidu.tieba.re3;
import com.baidu.tieba.sg3;
import com.baidu.tieba.ta2;
import com.baidu.tieba.tw2;
import com.baidu.tieba.uh3;
import com.baidu.tieba.uw2;
import com.baidu.tieba.vm3;
import com.baidu.tieba.vn4;
import com.baidu.tieba.wx1;
import com.baidu.tieba.xo3;
import com.baidu.tieba.yh3;
import com.baidu.tieba.z43;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zm3;
import com.baidu.tieba.zn3;
import com.baidu.tieba.zp3;
import com.baidu.tieba.zq3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, na3.a, ml3, ServiceConnection {
    public static final boolean B = qr1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public fo2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public mn3 q;
    public boolean t;
    public OrientationEventListener u;
    public on3 v;
    public iq3 w;
    public na3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final db3 y = new db3();
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
                fb3.K().c = i;
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
    public class a implements zp3<kb3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements zp3<kb3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements zp3<kb3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements bq3<kb3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bq3
        /* renamed from: b */
        public Boolean a(kb3.a aVar) {
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
            tw2 T2 = tw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                pa2 U = T2.U();
                if (U == null) {
                    g82.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    g82.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    g82.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    oa2.U3(null);
                    pa2.b i = U.i("init");
                    int i2 = pa2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", g13.d(str, str), true).a();
                    iq3 T3 = activity.T();
                    if (T3 != null) {
                        T3.F(1);
                    }
                    zm3 zm3Var = new zm3();
                    zm3Var.k(1L);
                    zm3Var.i(2110L);
                    zm3Var.f("host url" + this.a);
                    dn3.a().f(zm3Var);
                    hi3 hi3Var = new hi3();
                    hi3Var.p(zm3Var);
                    hi3Var.r(fb3.K().q().W());
                    hi3Var.q(zh3.n(fb3.K().k()));
                    hi3Var.m(fb3.K().getAppId());
                    zh3.R(hi3Var);
                    return;
                }
            }
            g82.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            nu2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (eh3.d()) {
                eh3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            nu2.o().k();
            if (!h53.h()) {
                zn3.m(SwanAppActivity.this);
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
                gh3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements zp3<kb3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements zp3<kb3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements zp3<kb3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements zp3<kb3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements zp3<kb3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(kb3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        fo2 fo2Var = this.m;
        if (fo2Var != null) {
            fo2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        pn3.j(this);
    }

    public void L() {
        if (this.A == null) {
            this.A = q82.a(this);
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
        fo2 fo2Var = this.m;
        if (fo2Var == null) {
            return "";
        }
        return fo2Var.i;
    }

    public fo2 Q() {
        return this.m;
    }

    public int R() {
        fo2 fo2Var = this.m;
        if (fo2Var == null) {
            return -1;
        }
        return fo2Var.k();
    }

    public dw2.a S() {
        fo2 fo2Var = this.m;
        if (fo2Var == null) {
            return null;
        }
        return fo2Var.Z();
    }

    public iq3 T() {
        return this.w;
    }

    public SwanAppProcessInfo U() {
        return SwanAppProcessInfo.P0;
    }

    public String V() {
        return this.r;
    }

    public on3 W() {
        return this.v;
    }

    @Nullable
    public pa2 X() {
        fo2 fo2Var = this.m;
        if (fo2Var == null) {
            return null;
        }
        return fo2Var.c0();
    }

    public synchronized boolean Z() {
        boolean z;
        if (!isDestroyed() && this.m != null) {
            if (this.m.a0().activated()) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    @Override // com.baidu.tieba.ml3
    public ll3 b() {
        fo2 fo2Var = this.m;
        if (fo2Var == null) {
            return null;
        }
        return fo2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(vn4.e().b());
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
            g82.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = fb3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.na3.a
    @NonNull
    public na3 getFloatLayer() {
        if (this.x == null) {
            this.x = new na3(this, (FrameLayout) findViewById(16908290), 0);
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
        fo2 fo2Var = this.m;
        if (fo2Var != null && fo2Var.g0()) {
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
        g82.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        uh3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        g82.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        on3 on3Var = this.v;
        if (on3Var != null) {
            on3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        g82.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!Z()) {
            l43.m();
        }
        ao3.k(new k(), "tracer");
        nu2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            q82.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        fo2 fo2Var = this.m;
        if (fo2Var != null) {
            fo2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(eo2 eo2Var) {
        fo2 fo2Var = this.m;
        if (fo2Var != null) {
            fo2Var.T0(eo2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void N(ji3 ji3Var) {
        fo2 fo2Var = this.m;
        if (fo2Var != null) {
            fo2Var.Q(ji3Var);
        }
    }

    @UiThread
    public void Y(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        nu2.H().d(this, i2, S());
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

    public final void l0(jw2 jw2Var) {
        if (c0() && jw2Var.b(" event_params_installer_progress")) {
            this.w.u(jw2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(jw2 jw2Var) {
        fo2 fo2Var = this.m;
        if (fo2Var != null && fo2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(jw2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        on3 on3Var = this.v;
        if (on3Var != null) {
            on3Var.n();
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
        if (Z()) {
            this.m.F0(i2);
        }
    }

    public void r0(String str) {
        H0(true);
        ai2.U().b1(str);
    }

    public final void s0(String str) {
        ap3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        e83.k(this, bundle);
    }

    public void u0(eo2 eo2Var) {
        fo2 fo2Var = this.m;
        if (fo2Var != null) {
            fo2Var.I0(eo2Var);
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

    public void B0(boolean z, @Nullable kb3.a aVar) {
        if (this.w == null) {
            this.w = new iq3(this);
        }
        iq3 iq3Var = this.w;
        boolean z2 = true;
        if (1 != fb3.K().q().W().G()) {
            z2 = false;
        }
        iq3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        fo2 fo2Var = this.m;
        if ((fo2Var != null && fo2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (po3.p(this)) {
                po3.s(this);
            }
            pn3.e(this);
        }
    }

    public final synchronized boolean C0(gb3 gb3Var) {
        if (this.m != null) {
            M();
        }
        fo2 a2 = ho2.a(this, gb3Var);
        if (a2 == null) {
            zm3 zm3Var = new zm3();
            zm3Var.k(5L);
            zm3Var.i(11L);
            zm3Var.d("can not buildFramework");
            aw2.e(this, zm3Var, gb3Var.k(), gb3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (h53.h()) {
            z43.e().d(gVar, "updateMobStat", false);
        } else {
            ao3.k(gVar, "updateMobStat");
        }
        z0(gb3Var.W().d0(), gb3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        dw2.a S = S();
        boolean z3 = false;
        if (S != null && "1230000000000000".equals(S.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        mn3 mn3Var = this.q;
        if (mn3Var != null && !z2) {
            mn3Var.v(false);
        }
        if (Z() && !fb3.K().q().s0()) {
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
            zh3.Y();
            F0();
            return false;
        }
    }

    public final void n0(kb3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        dw2.a W = fb3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        g82.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        g82.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (Z()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = l43.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        uw2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        gb3 q = fb3.K().q();
        if (!q.I()) {
            g82.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            g82.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            g82.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && mn3.j()) {
                mn3 m2 = mn3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(S(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        g82.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + fb3.K().getAppId());
        boolean z2 = true;
        if (fb3.K().q().E() && fb3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, fb3.K().getAppId())) ? false : false;
        g82.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            oh3.b bVar = new oh3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(fb3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(jw2 jw2Var) {
        if (c0()) {
            this.w.I(jw2Var.n("app_icon_url"));
            this.w.K(jw2Var.n("app_name"));
            if (fb3.K().q().W().G() == 0) {
                this.w.L(jw2Var.h("app_pay_protected"));
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
        iq3.A();
        iq3.z(nu2.c());
        pa2 X = X();
        if (X != null) {
            pa2.b h2 = X.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        vm3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        eg3.r();
        gb3 q = fb3.K().q();
        q.e0().j();
        q.N().a();
        sg3.x();
        ou2.o().a();
    }

    public final void d0() {
        db3 db3Var = this.y;
        db3Var.c(new d());
        db3Var.f(new c(), "event_on_still_maintaining");
        db3Var.f(new b(), "event_on_app_occupied");
        db3Var.f(new a(), "event_on_app_updated");
        db3Var.f(new p(), "event_on_app_icon_update");
        db3Var.f(new o(), "event_on_pkg_maintain_finish");
        db3Var.f(new n(), "installer_on_progress");
        db3Var.f(new m(), "event_first_action_launched");
        db3Var.f(new l(), "event_on_web_mode_launched");
        uw2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        fb3.K().o(this.y);
        g82.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        M();
        if (this.n != null) {
            unbindService(this);
        }
        nu2.H().b();
        on3 on3Var = this.v;
        if (on3Var != null) {
            on3Var.p();
        }
        fb3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        tw2.a0();
        String appId = fb3.K().getAppId();
        if (B) {
            lw2 d2 = lw2.d(appId);
            d2.e().c();
            d2.h();
        }
        eh3.l(true);
        fb3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        uw2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        g82.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !fb3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            fb3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (fb3.K().E() && fw2.a(intent)) {
                fb3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        on3 on3Var = this.v;
        if (on3Var != null) {
            on3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        ip3.b().d();
    }

    public final void m0() {
        if (ta2.b.a()) {
            r0(zq3.b(re3.e()));
        } else if (!isDestroyed()) {
            if (fb3.K().q().I()) {
                H0(true);
            } else {
                fb3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        gb3 q = fb3.K().q();
        if (q != null) {
            String V = q.Y().V();
            lw2 d2 = lw2.d(q.Y().V());
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
        wx1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.wo4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        bi2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(U());
        nu2.G().b();
        b83.Q().c0();
        boolean z2 = true;
        this.s = true;
        uh3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        yh3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (fo3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = fw2.a(intent);
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
        ai2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!ng2.a.c()) {
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
        g82.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        g82.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d009c);
        if (R() == 0) {
            xo3.c(this);
        }
        d0();
        fb3 K = fb3.K();
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
                g82.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        xo3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new on3(this);
        }
        on3 on3Var = this.v;
        if (on3Var != null) {
            on3Var.v(false);
        }
        on3 on3Var2 = this.v;
        if (on3Var2 != null) {
            on3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        ao3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        bi2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        g82.i("SwanApp", "SwanAppActivity onNewIntent");
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
        on3 on3Var = this.v;
        if (on3Var != null) {
            on3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            g82.i("SwanAppActivity", "onNewIntent: start swan web");
            fb3.K().q().A0();
        }
        this.s = true;
        uh3.l(true);
        fb3 K = fb3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && fw2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        mn3 mn3Var = this.q;
        if (mn3Var != null) {
            mn3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            g82.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (ta2.b.a() && fb3.K().q().z0() && on4.d()) {
            H0(true);
            ai2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(vn4.e().b());
        } else if (fb3.K().q().z0() && on4.d()) {
            H0(true);
            ai2.U().a1();
        } else {
            String D2 = nu2.o().D();
            if (nu2.a().c() && !ap3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", fb3.K().getAppId()).build().toString());
                return;
            }
            zm3 zm3Var = new zm3();
            zm3Var.k(1L);
            zm3Var.i(2109L);
            zm3Var.f("web mode start failed.");
            if (g0()) {
                dn3.a().f(zm3Var);
                hi3 hi3Var = new hi3();
                hi3Var.p(zm3Var);
                hi3Var.r(fb3.K().q().W());
                hi3Var.q(zh3.n(fb3.K().k()));
                hi3Var.m(fb3.K().getAppId());
                zh3.R(hi3Var);
            }
            aw2.e(nu2.c(), zm3Var, 0, "");
            F0();
        }
    }
}
