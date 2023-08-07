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
import com.baidu.tieba.ap3;
import com.baidu.tieba.aq3;
import com.baidu.tieba.bi3;
import com.baidu.tieba.bw2;
import com.baidu.tieba.cb3;
import com.baidu.tieba.d43;
import com.baidu.tieba.dl3;
import com.baidu.tieba.dw2;
import com.baidu.tieba.el3;
import com.baidu.tieba.en3;
import com.baidu.tieba.fa3;
import com.baidu.tieba.fg2;
import com.baidu.tieba.fu2;
import com.baidu.tieba.ga2;
import com.baidu.tieba.gh3;
import com.baidu.tieba.gn3;
import com.baidu.tieba.gn4;
import com.baidu.tieba.gu2;
import com.baidu.tieba.ha2;
import com.baidu.tieba.hn3;
import com.baidu.tieba.ho3;
import com.baidu.tieba.i82;
import com.baidu.tieba.ir1;
import com.baidu.tieba.je3;
import com.baidu.tieba.kg3;
import com.baidu.tieba.la2;
import com.baidu.tieba.lw2;
import com.baidu.tieba.mh3;
import com.baidu.tieba.mw2;
import com.baidu.tieba.nm3;
import com.baidu.tieba.nn4;
import com.baidu.tieba.ox1;
import com.baidu.tieba.po3;
import com.baidu.tieba.qh3;
import com.baidu.tieba.r43;
import com.baidu.tieba.rh3;
import com.baidu.tieba.rm3;
import com.baidu.tieba.rn3;
import com.baidu.tieba.rp3;
import com.baidu.tieba.rq3;
import com.baidu.tieba.sh2;
import com.baidu.tieba.sn3;
import com.baidu.tieba.so3;
import com.baidu.tieba.sv2;
import com.baidu.tieba.t73;
import com.baidu.tieba.th2;
import com.baidu.tieba.tp3;
import com.baidu.tieba.va3;
import com.baidu.tieba.vm3;
import com.baidu.tieba.vv2;
import com.baidu.tieba.w73;
import com.baidu.tieba.wf3;
import com.baidu.tieba.wg3;
import com.baidu.tieba.wn2;
import com.baidu.tieba.xa3;
import com.baidu.tieba.xn2;
import com.baidu.tieba.xn3;
import com.baidu.tieba.xv2;
import com.baidu.tieba.y03;
import com.baidu.tieba.y72;
import com.baidu.tieba.ya3;
import com.baidu.tieba.yg3;
import com.baidu.tieba.z43;
import com.baidu.tieba.zh3;
import com.baidu.tieba.zn2;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, fa3.a, el3, ServiceConnection {
    public static final boolean B = ir1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public xn2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public en3 q;
    public boolean t;
    public OrientationEventListener u;
    public gn3 v;
    public aq3 w;
    public fa3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final va3 y = new va3();
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
                xa3.K().c = i;
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
    public class a implements rp3<cb3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements rp3<cb3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements rp3<cb3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements tp3<cb3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tp3
        /* renamed from: b */
        public Boolean a(cb3.a aVar) {
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
            lw2 T2 = lw2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                ha2 U = T2.U();
                if (U == null) {
                    y72.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    y72.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    y72.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    ga2.U3(null);
                    ha2.b i = U.i("init");
                    int i2 = ha2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", y03.d(str, str), true).a();
                    aq3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    rm3 rm3Var = new rm3();
                    rm3Var.k(1L);
                    rm3Var.i(2110L);
                    rm3Var.f("host url" + this.a);
                    vm3.a().f(rm3Var);
                    zh3 zh3Var = new zh3();
                    zh3Var.p(rm3Var);
                    zh3Var.r(xa3.K().q().W());
                    zh3Var.q(rh3.n(xa3.K().k()));
                    zh3Var.m(xa3.K().getAppId());
                    rh3.R(zh3Var);
                    return;
                }
            }
            y72.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fu2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (wg3.d()) {
                wg3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fu2.o().k();
            if (!z43.h()) {
                rn3.m(SwanAppActivity.this);
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
                yg3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements rp3<cb3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements rp3<cb3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements rp3<cb3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements rp3<cb3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements rp3<cb3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(cb3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        xn2 xn2Var = this.m;
        if (xn2Var != null) {
            xn2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        hn3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = i82.a(this);
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
        xn2 xn2Var = this.m;
        if (xn2Var == null) {
            return "";
        }
        return xn2Var.i;
    }

    public xn2 R() {
        return this.m;
    }

    public int S() {
        xn2 xn2Var = this.m;
        if (xn2Var == null) {
            return -1;
        }
        return xn2Var.k();
    }

    public vv2.a T() {
        xn2 xn2Var = this.m;
        if (xn2Var == null) {
            return null;
        }
        return xn2Var.Z();
    }

    public aq3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public gn3 X() {
        return this.v;
    }

    @Nullable
    public ha2 Y() {
        xn2 xn2Var = this.m;
        if (xn2Var == null) {
            return null;
        }
        return xn2Var.c0();
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

    @Override // com.baidu.tieba.el3
    public dl3 b() {
        xn2 xn2Var = this.m;
        if (xn2Var == null) {
            return null;
        }
        return xn2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(nn4.e().b());
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
            y72.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = xa3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.fa3.a
    @NonNull
    public fa3 getFloatLayer() {
        if (this.x == null) {
            this.x = new fa3(this, (FrameLayout) findViewById(16908290), 0);
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
        xn2 xn2Var = this.m;
        if (xn2Var != null && xn2Var.g0()) {
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
        y72.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        mh3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        y72.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        gn3 gn3Var = this.v;
        if (gn3Var != null) {
            gn3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        y72.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            d43.m();
        }
        sn3.k(new k(), "tracer");
        fu2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            i82.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        xn2 xn2Var = this.m;
        if (xn2Var != null) {
            xn2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(wn2 wn2Var) {
        xn2 xn2Var = this.m;
        if (xn2Var != null) {
            xn2Var.T0(wn2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(bi3 bi3Var) {
        xn2 xn2Var = this.m;
        if (xn2Var != null) {
            xn2Var.Q(bi3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        fu2.H().d(this, i2, T());
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

    public final void l0(bw2 bw2Var) {
        if (c0() && bw2Var.b(" event_params_installer_progress")) {
            this.w.u(bw2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(bw2 bw2Var) {
        xn2 xn2Var = this.m;
        if (xn2Var != null && xn2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(bw2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        gn3 gn3Var = this.v;
        if (gn3Var != null) {
            gn3Var.n();
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
        sh2.U().b1(str);
    }

    public final void s0(String str) {
        so3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        w73.k(this, bundle);
    }

    public void u0(wn2 wn2Var) {
        xn2 xn2Var = this.m;
        if (xn2Var != null) {
            xn2Var.I0(wn2Var);
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

    public void B0(boolean z, @Nullable cb3.a aVar) {
        if (this.w == null) {
            this.w = new aq3(this);
        }
        aq3 aq3Var = this.w;
        boolean z2 = true;
        if (1 != xa3.K().q().W().G()) {
            z2 = false;
        }
        aq3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        xn2 xn2Var = this.m;
        if ((xn2Var != null && xn2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (ho3.p(this)) {
                ho3.s(this);
            }
            hn3.e(this);
        }
    }

    public final synchronized boolean C0(ya3 ya3Var) {
        if (this.m != null) {
            N();
        }
        xn2 a2 = zn2.a(this, ya3Var);
        if (a2 == null) {
            rm3 rm3Var = new rm3();
            rm3Var.k(5L);
            rm3Var.i(11L);
            rm3Var.d("can not buildFramework");
            sv2.e(this, rm3Var, ya3Var.k(), ya3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (z43.h()) {
            r43.e().d(gVar, "updateMobStat", false);
        } else {
            sn3.k(gVar, "updateMobStat");
        }
        z0(ya3Var.W().d0(), ya3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        vv2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        en3 en3Var = this.q;
        if (en3Var != null && !z2) {
            en3Var.v(false);
        }
        if (a0() && !xa3.K().q().s0()) {
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
            rh3.Y();
            F0();
            return false;
        }
    }

    public final void n0(cb3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        vv2.a W = xa3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        y72.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        y72.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = d43.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        mw2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        ya3 q = xa3.K().q();
        if (!q.I()) {
            y72.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            y72.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            y72.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && en3.j()) {
                en3 m2 = en3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        y72.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + xa3.K().getAppId());
        boolean z2 = true;
        if (xa3.K().q().E() && xa3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, xa3.K().getAppId())) ? false : false;
        y72.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            gh3.b bVar = new gh3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(xa3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(bw2 bw2Var) {
        if (c0()) {
            this.w.I(bw2Var.n("app_icon_url"));
            this.w.K(bw2Var.n("app_name"));
            if (xa3.K().q().W().G() == 0) {
                this.w.L(bw2Var.h("app_pay_protected"));
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
        aq3.A();
        aq3.z(fu2.c());
        ha2 Y = Y();
        if (Y != null) {
            ha2.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        nm3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        wf3.r();
        ya3 q = xa3.K().q();
        q.e0().j();
        q.N().a();
        kg3.x();
        gu2.o().a();
    }

    public final void d0() {
        va3 va3Var = this.y;
        va3Var.c(new d());
        va3Var.f(new c(), "event_on_still_maintaining");
        va3Var.f(new b(), "event_on_app_occupied");
        va3Var.f(new a(), "event_on_app_updated");
        va3Var.f(new p(), "event_on_app_icon_update");
        va3Var.f(new o(), "event_on_pkg_maintain_finish");
        va3Var.f(new n(), "installer_on_progress");
        va3Var.f(new m(), "event_first_action_launched");
        va3Var.f(new l(), "event_on_web_mode_launched");
        mw2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        xa3.K().o(this.y);
        y72.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        fu2.H().b();
        gn3 gn3Var = this.v;
        if (gn3Var != null) {
            gn3Var.p();
        }
        xa3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        lw2.a0();
        String appId = xa3.K().getAppId();
        if (B) {
            dw2 d2 = dw2.d(appId);
            d2.e().c();
            d2.h();
        }
        wg3.l(true);
        xa3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        mw2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        y72.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !xa3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            xa3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (xa3.K().E() && xv2.a(intent)) {
                xa3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        gn3 gn3Var = this.v;
        if (gn3Var != null) {
            gn3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        ap3.b().d();
    }

    public final void m0() {
        if (la2.b.a()) {
            r0(rq3.b(je3.e()));
        } else if (!isDestroyed()) {
            if (xa3.K().q().I()) {
                H0(true);
            } else {
                xa3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        ya3 q = xa3.K().q();
        if (q != null) {
            String V = q.Y().V();
            dw2 d2 = dw2.d(q.Y().V());
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
        ox1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.oo4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        th2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        fu2.G().b();
        t73.Q().c0();
        boolean z2 = true;
        this.s = true;
        mh3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        qh3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (xn3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = xv2.a(intent);
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
        sh2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!fg2.a.c()) {
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
        y72.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        y72.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0097);
        if (S() == 0) {
            po3.c(this);
        }
        d0();
        xa3 K = xa3.K();
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
                y72.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        po3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new gn3(this);
        }
        gn3 gn3Var = this.v;
        if (gn3Var != null) {
            gn3Var.v(false);
        }
        gn3 gn3Var2 = this.v;
        if (gn3Var2 != null) {
            gn3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        sn3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        th2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        y72.i("SwanApp", "SwanAppActivity onNewIntent");
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
        gn3 gn3Var = this.v;
        if (gn3Var != null) {
            gn3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            y72.i("SwanAppActivity", "onNewIntent: start swan web");
            xa3.K().q().A0();
        }
        this.s = true;
        mh3.l(true);
        xa3 K = xa3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && xv2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        en3 en3Var = this.q;
        if (en3Var != null) {
            en3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            y72.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (la2.b.a() && xa3.K().q().z0() && gn4.d()) {
            H0(true);
            sh2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(nn4.e().b());
        } else if (xa3.K().q().z0() && gn4.d()) {
            H0(true);
            sh2.U().a1();
        } else {
            String D2 = fu2.o().D();
            if (fu2.a().c() && !so3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", xa3.K().getAppId()).build().toString());
                return;
            }
            rm3 rm3Var = new rm3();
            rm3Var.k(1L);
            rm3Var.i(2109L);
            rm3Var.f("web mode start failed.");
            if (g0()) {
                vm3.a().f(rm3Var);
                zh3 zh3Var = new zh3();
                zh3Var.p(rm3Var);
                zh3Var.r(xa3.K().q().W());
                zh3Var.q(rh3.n(xa3.K().k()));
                zh3Var.m(xa3.K().getAppId());
                rh3.R(zh3Var);
            }
            sv2.e(fu2.c(), rm3Var, 0, "");
            F0();
        }
    }
}
