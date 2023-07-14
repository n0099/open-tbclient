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
import com.baidu.tieba.am3;
import com.baidu.tieba.ax2;
import com.baidu.tieba.bm3;
import com.baidu.tieba.bo3;
import com.baidu.tieba.cb3;
import com.baidu.tieba.ch2;
import com.baidu.tieba.cv2;
import com.baidu.tieba.db2;
import com.baidu.tieba.di3;
import com.baidu.tieba.do3;
import com.baidu.tieba.do4;
import com.baidu.tieba.dv2;
import com.baidu.tieba.eb2;
import com.baidu.tieba.eo3;
import com.baidu.tieba.ep3;
import com.baidu.tieba.f92;
import com.baidu.tieba.fs1;
import com.baidu.tieba.gf3;
import com.baidu.tieba.hh3;
import com.baidu.tieba.ib2;
import com.baidu.tieba.ix2;
import com.baidu.tieba.ji3;
import com.baidu.tieba.jx2;
import com.baidu.tieba.kn3;
import com.baidu.tieba.ko4;
import com.baidu.tieba.ly1;
import com.baidu.tieba.mp3;
import com.baidu.tieba.ni3;
import com.baidu.tieba.o53;
import com.baidu.tieba.oi3;
import com.baidu.tieba.on3;
import com.baidu.tieba.oo3;
import com.baidu.tieba.oq3;
import com.baidu.tieba.or3;
import com.baidu.tieba.pi2;
import com.baidu.tieba.po3;
import com.baidu.tieba.pp3;
import com.baidu.tieba.pw2;
import com.baidu.tieba.q83;
import com.baidu.tieba.qi2;
import com.baidu.tieba.qq3;
import com.baidu.tieba.sb3;
import com.baidu.tieba.sn3;
import com.baidu.tieba.sw2;
import com.baidu.tieba.t83;
import com.baidu.tieba.tg3;
import com.baidu.tieba.th3;
import com.baidu.tieba.to2;
import com.baidu.tieba.ub3;
import com.baidu.tieba.uo2;
import com.baidu.tieba.uo3;
import com.baidu.tieba.uw2;
import com.baidu.tieba.v13;
import com.baidu.tieba.v82;
import com.baidu.tieba.vb3;
import com.baidu.tieba.vh3;
import com.baidu.tieba.w53;
import com.baidu.tieba.wi3;
import com.baidu.tieba.wo2;
import com.baidu.tieba.xp3;
import com.baidu.tieba.xq3;
import com.baidu.tieba.yi3;
import com.baidu.tieba.yw2;
import com.baidu.tieba.zb3;
import com.facebook.common.internal.Sets;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppActivity extends SwanAppBaseActivity implements ActivityResultDispatcherHolder, cb3.a, bm3, ServiceConnection {
    public static final boolean B = fs1.a;
    public static final String C = SwanAppActivity.class.getName();
    public static final long D = TimeUnit.SECONDS.toMillis(1);
    public View A;
    public uo2 m;
    public Messenger n;
    public ActivityResultDispatcher p;
    @Nullable
    public bo3 q;
    public boolean t;
    public OrientationEventListener u;
    public do3 v;
    public xq3 w;
    public cb3 x;
    public FrameLifeState o = FrameLifeState.INACTIVATED;
    public String r = "sys";
    public boolean s = false;
    public final sb3 y = new sb3();
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
                ub3.K().c = i;
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
    public class a implements oq3<zb3.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.o0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements oq3<zb3.a> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.n0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements oq3<zb3.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.B0(true, aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements qq3<zb3.a, Boolean> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qq3
        /* renamed from: b */
        public Boolean a(zb3.a aVar) {
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
            ix2 T2 = ix2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity != null && !activity.isFinishing()) {
                eb2 U = T2.U();
                if (U == null) {
                    v82.i("SwanAppActivity", "doWebViewStart: fragment manager is null.");
                    return;
                } else if (TextUtils.isEmpty(this.a)) {
                    v82.i("SwanAppActivity", "doWebViewStart:  url is null.");
                    return;
                } else if (U == null) {
                    v82.i("SwanAppActivity", "pushWebViewFragment: fragment manager is null.");
                    return;
                } else {
                    db2.U3(null);
                    eb2.b i = U.i("init");
                    int i2 = eb2.i;
                    i.n(i2, i2);
                    i.f();
                    String str = this.a;
                    i.l("default_webview", v13.d(str, str), true).a();
                    xq3 U2 = activity.U();
                    if (U2 != null) {
                        U2.F(1);
                    }
                    on3 on3Var = new on3();
                    on3Var.k(1L);
                    on3Var.i(2110L);
                    on3Var.f("host url" + this.a);
                    sn3.a().f(on3Var);
                    wi3 wi3Var = new wi3();
                    wi3Var.p(on3Var);
                    wi3Var.r(ub3.K().q().W());
                    wi3Var.q(oi3.n(ub3.K().k()));
                    wi3Var.m(ub3.K().getAppId());
                    oi3.R(wi3Var);
                    return;
                }
            }
            v82.i("SwanAppActivity", "activity is invalid.");
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cv2.o().d();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (th3.d()) {
                th3.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cv2.o().k();
            if (!w53.h()) {
                oo3.m(SwanAppActivity.this);
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
                vh3.d().l();
            } catch (Exception e) {
                if (SwanAppActivity.B) {
                    Log.e("SwanAppActivity", "SaveTraceException:", e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements oq3<zb3.a> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.p0(aVar.n("property_launch_url"));
        }
    }

    /* loaded from: classes4.dex */
    public class m implements oq3<zb3.a> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.D0();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements oq3<zb3.a> {
        public n() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.l0(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements oq3<zb3.a> {
        public o() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.m0();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements oq3<zb3.a> {
        public p() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(zb3.a aVar) {
            SwanAppActivity.this.J0(aVar);
        }
    }

    public void A0() {
        uo2 uo2Var = this.m;
        if (uo2Var != null) {
            uo2Var.M0();
        }
    }

    public final synchronized void D0() {
        E0(this.o);
    }

    public final void F0() {
        eo3.j(this);
    }

    public void M() {
        if (this.A == null) {
            this.A = f92.a(this);
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
        uo2 uo2Var = this.m;
        if (uo2Var == null) {
            return "";
        }
        return uo2Var.i;
    }

    public uo2 R() {
        return this.m;
    }

    public int S() {
        uo2 uo2Var = this.m;
        if (uo2Var == null) {
            return -1;
        }
        return uo2Var.k();
    }

    public sw2.a T() {
        uo2 uo2Var = this.m;
        if (uo2Var == null) {
            return null;
        }
        return uo2Var.Z();
    }

    public xq3 U() {
        return this.w;
    }

    public SwanAppProcessInfo V() {
        return SwanAppProcessInfo.P0;
    }

    public String W() {
        return this.r;
    }

    public do3 X() {
        return this.v;
    }

    @Nullable
    public eb2 Y() {
        uo2 uo2Var = this.m;
        if (uo2Var == null) {
            return null;
        }
        return uo2Var.c0();
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

    @Override // com.baidu.tieba.bm3
    public am3 b() {
        uo2 uo2Var = this.m;
        if (uo2Var == null) {
            return null;
        }
        return uo2Var.d0();
    }

    public final boolean b0() {
        return !TextUtils.isEmpty(ko4.e().b());
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
            v82.i("SwanAppActivity", Log.getStackTraceString(new Throwable("call finish!")));
        }
    }

    public final boolean g0() {
        PMSAppInfo f0 = ub3.K().q().W().f0();
        if (f0 == null || f0.appStatus != 6) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.cb3.a
    @NonNull
    public cb3 getFloatLayer() {
        if (this.x == null) {
            this.x = new cb3(this, (FrameLayout) findViewById(16908290), 0);
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
        uo2 uo2Var = this.m;
        if (uo2Var != null && uo2Var.g0()) {
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
        v82.i("SwanApp", "SwanAppActivity onPause");
        super.onPause();
        I0(FrameLifeState.JUST_STARTED);
        this.s = false;
        ji3.l(false);
        OrientationEventListener orientationEventListener = this.u;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        v82.i("SwanApp", "SwanAppActivity onStart");
        super.onStart();
        this.t = false;
        do3 do3Var = this.v;
        if (do3Var != null) {
            do3Var.e();
        }
        I0(FrameLifeState.JUST_STARTED);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        v82.i("SwanApp", "SwanAppActivity onStop");
        super.onStop();
        this.t = true;
        I0(FrameLifeState.JUST_CREATED);
        if (!a0()) {
            a53.m();
        }
        po3.k(new k(), "tracer");
        cv2.p0().flush(false);
    }

    public void v0() {
        View view2 = this.A;
        if (view2 != null) {
            f92.d(this, view2);
            this.A = null;
        }
    }

    public void w0() {
        uo2 uo2Var = this.m;
        if (uo2Var != null) {
            uo2Var.K0();
        }
    }

    public final synchronized void E0(@NonNull FrameLifeState frameLifeState) {
        if (this.m != null && !this.m.i0()) {
            this.m.R0(frameLifeState);
        }
    }

    public void G0(to2 to2Var) {
        uo2 uo2Var = this.m;
        if (uo2Var != null) {
            uo2Var.T0(to2Var);
        }
    }

    public final synchronized void I0(@NonNull FrameLifeState frameLifeState) {
        this.o = frameLifeState;
        D0();
    }

    public final void O(yi3 yi3Var) {
        uo2 uo2Var = this.m;
        if (uo2Var != null) {
            uo2Var.Q(yi3Var);
        }
    }

    @UiThread
    public void Z(int i2) {
        if (B) {
            Log.i("SwanAppActivity", "handleSwanAppExit:" + i2 + ", pid:" + Process.myPid());
        }
        cv2.H().d(this, i2, T());
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

    public final void l0(yw2 yw2Var) {
        if (c0() && yw2Var.b(" event_params_installer_progress")) {
            this.w.u(yw2Var.f(" event_params_installer_progress"));
        }
    }

    public final void o0(yw2 yw2Var) {
        uo2 uo2Var = this.m;
        if (uo2Var != null && uo2Var.f0()) {
            H0("update_tag_by_activity_on_new_intent".equals(yw2Var.n("app_update_tag")));
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        do3 do3Var = this.v;
        if (do3Var != null) {
            do3Var.n();
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
        pi2.U().b1(str);
    }

    public final void s0(String str) {
        pp3.e0(new f(str));
    }

    public void t0(Bundle bundle) {
        t83.k(this, bundle);
    }

    public void u0(to2 to2Var) {
        uo2 uo2Var = this.m;
        if (uo2Var != null) {
            uo2Var.I0(to2Var);
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

    public void B0(boolean z, @Nullable zb3.a aVar) {
        if (this.w == null) {
            this.w = new xq3(this);
        }
        xq3 xq3Var = this.w;
        boolean z2 = true;
        if (1 != ub3.K().q().W().G()) {
            z2 = false;
        }
        xq3Var.E(z2, z, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        uo2 uo2Var = this.m;
        if ((uo2Var != null && uo2Var.r0(i2, keyEvent)) || this.A != null) {
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
            if (ep3.p(this)) {
                ep3.s(this);
            }
            eo3.e(this);
        }
    }

    public final synchronized boolean C0(vb3 vb3Var) {
        if (this.m != null) {
            N();
        }
        uo2 a2 = wo2.a(this, vb3Var);
        if (a2 == null) {
            on3 on3Var = new on3();
            on3Var.k(5L);
            on3Var.i(11L);
            on3Var.d("can not buildFramework");
            pw2.e(this, on3Var, vb3Var.k(), vb3Var.b);
            F0();
            return false;
        }
        this.m = a2;
        g gVar = new g();
        if (w53.h()) {
            o53.e().d(gVar, "updateMobStat", false);
        } else {
            po3.k(gVar, "updateMobStat");
        }
        z0(vb3Var.W().d0(), vb3Var.k());
        return true;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        boolean z2;
        sw2.a T2 = T();
        boolean z3 = false;
        if (T2 != null && "1230000000000000".equals(T2.T())) {
            z2 = true;
        } else {
            z2 = false;
        }
        bo3 bo3Var = this.q;
        if (bo3Var != null && !z2) {
            bo3Var.v(false);
        }
        if (a0() && !ub3.K().q().s0()) {
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
            oi3.Y();
            F0();
            return false;
        }
    }

    public final void n0(zb3.a aVar) {
        if (B) {
            Log.i("SwanAppActivity", "onAppOccupied: ");
        }
        sw2.a W = ub3.K().q().W();
        z0(W.d0(), W.G());
        B0(false, aVar);
        v82.i("SwanAppActivity", "appName: " + W.K() + " appId: " + W.H());
    }

    public void q0(int i2) {
        v82.i("SwanApp", "onBackPressed back stack count: " + getFragmentManager().getBackStackEntryCount());
        if (a0()) {
            this.m.l0(i2);
            return;
        }
        HybridUbcFlow m2 = a53.m();
        if (m2 != null) {
            m2.E("value", "cancel");
            m2.D("exitType", String.valueOf(4));
            m2.n();
        }
        jx2.a().d(false);
        moveTaskToBack(true);
    }

    public final synchronized void H0(boolean z) {
        vb3 q = ub3.K().q();
        if (!q.I()) {
            v82.i("SwanAppActivity", "updateFrame: unavailable");
        } else if (!e0(q.getAppId()) && !C0(q)) {
            v82.i("SwanAppActivity", "updateFrame: swan app id is null.");
        } else {
            this.m.update(this.o, z);
            v82.i("SwanAppActivity", "updateFrame: ");
            if (B) {
                x0();
            }
            if (this.q == null && bo3.j()) {
                bo3 m2 = bo3.m();
                this.q = m2;
                if (!this.z) {
                    m2.y(T(), getTaskId());
                }
            }
        }
    }

    public final boolean i0(String str) {
        boolean z;
        v82.k("SwanAppActivity", "isInvalidIntentAppId: intentAppId=" + str + ",currentAppId=" + ub3.K().getAppId());
        boolean z2 = true;
        if (ub3.K().q().E() && ub3.K().q().x0()) {
            z = true;
        } else {
            z = false;
        }
        z2 = (!z || TextUtils.equals(str, ub3.K().getAppId())) ? false : false;
        v82.k("SwanAppActivity", "isInvalidIntentAppId: isInValidIntent=" + z2);
        if (z2) {
            di3.b bVar = new di3.b(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA);
            bVar.l(str);
            bVar.h(ub3.K().getAppId());
            bVar.m();
        }
        return z2;
    }

    public final void J0(yw2 yw2Var) {
        if (c0()) {
            this.w.I(yw2Var.n("app_icon_url"));
            this.w.K(yw2Var.n("app_name"));
            if (ub3.K().q().W().G() == 0) {
                this.w.L(yw2Var.i("app_pay_protected"));
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
        xq3.A();
        xq3.z(cv2.c());
        eb2 Y = Y();
        if (Y != null) {
            eb2.b h2 = Y.h();
            h2.n(0, 0);
            h2.f();
            h2.b();
        }
        kn3.j();
        if (this.m != null) {
            this.m.R0(FrameLifeState.INACTIVATED);
            this.m.release();
            this.m = null;
        }
        tg3.r();
        vb3 q = ub3.K().q();
        q.e0().j();
        q.N().a();
        hh3.x();
        dv2.o().a();
    }

    public final void d0() {
        sb3 sb3Var = this.y;
        sb3Var.c(new d());
        sb3Var.f(new c(), "event_on_still_maintaining");
        sb3Var.f(new b(), "event_on_app_occupied");
        sb3Var.f(new a(), "event_on_app_updated");
        sb3Var.f(new p(), "event_on_app_icon_update");
        sb3Var.f(new o(), "event_on_pkg_maintain_finish");
        sb3Var.f(new n(), "installer_on_progress");
        sb3Var.f(new m(), "event_first_action_launched");
        sb3Var.f(new l(), "event_on_web_mode_launched");
        jx2.a().c();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ub3.K().o(this.y);
        v82.i("SwanApp", "SwanAppActivity onDestroy");
        this.u = null;
        N();
        if (this.n != null) {
            unbindService(this);
        }
        cv2.H().b();
        do3 do3Var = this.v;
        if (do3Var != null) {
            do3Var.p();
        }
        ub3.K().r(this);
        I0(FrameLifeState.INACTIVATED);
        ix2.a0();
        String appId = ub3.K().getAppId();
        if (B) {
            ax2 d2 = ax2.d(appId);
            d2.e().c();
            d2.h();
        }
        th3.l(true);
        ub3.K().n(new String[0]);
        this.q = null;
        super.onDestroy();
        jx2.a().e();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        v82.i("SwanApp", "SwanAppActivity onResume");
        Intent intent = getIntent();
        if (intent != null && !ub3.K().E()) {
            intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
            ub3.K().l(intent.getExtras(), "update_tag_by_activity_on_create");
            if (ub3.K().E() && uw2.a(intent)) {
                ub3.K().q().W().I0("1250000000000000");
            }
        }
        k0();
        super.onResume();
        ExecutorUtilsExt.postOnElastic(new j(), "OrientationEventListener", 2);
        do3 do3Var = this.v;
        if (do3Var != null) {
            do3Var.t();
        }
        I0(FrameLifeState.JUST_RESUMED);
        xp3.b().d();
    }

    public final void m0() {
        if (ib2.b.a()) {
            r0(or3.b(gf3.e()));
        } else if (!isDestroyed()) {
            if (ub3.K().q().I()) {
                H0(true);
            } else {
                ub3.M().postDelayed(new e(), D);
            }
        }
    }

    public final void x0() {
        vb3 q = ub3.K().q();
        if (q != null) {
            String V = q.Y().V();
            ax2 d2 = ax2.d(q.Y().V());
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
        ly1.a().b().b().onActivityResult(this, i2, i3, intent);
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.lp4, android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        int i2;
        boolean z;
        Bundle bundle2;
        qi2.e();
        long currentTimeMillis = System.currentTimeMillis();
        overridePendingTransition(R.anim.obfuscated_res_0x7f010023, R.anim.obfuscated_res_0x7f01001d);
        SwanAppProcessInfo.init(V());
        cv2.G().b();
        q83.Q().c0();
        boolean z2 = true;
        this.s = true;
        ji3.l(true);
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ni3.d(i2);
        super.onCreate(bundle);
        I0(FrameLifeState.JUST_CREATED);
        if (uo3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        boolean a2 = uw2.a(intent);
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
        pi2.v.g(intent);
        if (B) {
            Log.i("SwanAppActivity", "onCreate: bindService");
        }
        if (!ch2.a.c()) {
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
        v82.b("SwanAppActivity", "SwanAppActivity onCreate() savedInstanceState=", bundle);
        v82.i("SwanApp", "SwanAppActivity onCreate");
        setContentView(R.layout.obfuscated_res_0x7f0d0097);
        if (S() == 0) {
            mp3.c(this);
        }
        d0();
        ub3 K = ub3.K();
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
                v82.k("SwanAppActivity", "updateSwanApp by onCreate");
                K.l(extras, "update_tag_by_activity_on_create");
            }
        }
        if (K.E() && a2) {
            K.q().W().I0("1250000000000000");
        }
        mp3.b(this);
        if (Build.VERSION.SDK_INT != 26) {
            this.v = new do3(this);
        }
        do3 do3Var = this.v;
        if (do3Var != null) {
            do3Var.v(false);
        }
        do3 do3Var2 = this.v;
        if (do3Var2 != null) {
            do3Var2.o();
        }
        ExecutorUtilsExt.postOnSerial(new h(), "小程序稳定性数据采集");
        po3.k(new i(), "initOnCreate");
        this.z = (bundle == null || bundle.getInt("swan_key_save_task_id") != getTaskId()) ? false : false;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        boolean z;
        super.onNewIntent(intent);
        qi2.e();
        intent.putExtra("receive_launch_intent_time", System.currentTimeMillis());
        v82.i("SwanApp", "SwanAppActivity onNewIntent");
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
        do3 do3Var = this.v;
        if (do3Var != null) {
            do3Var.s();
        }
        if (intent.getExtras() != null && intent.getExtras().getBoolean("property_web_mode_degrade")) {
            v82.i("SwanAppActivity", "onNewIntent: start swan web");
            ub3.K().q().A0();
        }
        this.s = true;
        ji3.l(true);
        ub3 K = ub3.K();
        K.l(intent.getExtras(), "update_tag_by_activity_on_new_intent");
        if (K.E() && uw2.a(intent)) {
            K.q().Y().I0("1250000000000000");
        }
        bo3 bo3Var = this.q;
        if (bo3Var != null) {
            bo3Var.z(intent, getTaskId());
        }
    }

    public final void p0(String str) {
        if (!TextUtils.isEmpty(str)) {
            r0(str);
        } else if (isDestroyed()) {
            v82.i("SwanAppActivity", "onAppWebModeStart: swan activity isDestroyed.");
        } else if (ib2.b.a() && ub3.K().q().z0() && do4.d()) {
            H0(true);
            pi2.U().a1();
        } else if (b0() && !g0()) {
            H0(true);
            s0(ko4.e().b());
        } else if (ub3.K().q().z0() && do4.d()) {
            H0(true);
            pi2.U().a1();
        } else {
            String D2 = cv2.o().D();
            if (cv2.a().c() && !pp3.G() && !TextUtils.isEmpty(D2)) {
                H0(true);
                s0(Uri.parse(D2).buildUpon().appendQueryParameter("appkey", ub3.K().getAppId()).build().toString());
                return;
            }
            on3 on3Var = new on3();
            on3Var.k(1L);
            on3Var.i(2109L);
            on3Var.f("web mode start failed.");
            if (g0()) {
                sn3.a().f(on3Var);
                wi3 wi3Var = new wi3();
                wi3Var.p(on3Var);
                wi3Var.r(ub3.K().q().W());
                wi3Var.q(oi3.n(ub3.K().k()));
                wi3Var.m(ub3.K().getAppId());
                oi3.R(wi3Var);
            }
            pw2.e(cv2.c(), on3Var, 0, "");
            F0();
        }
    }
}
