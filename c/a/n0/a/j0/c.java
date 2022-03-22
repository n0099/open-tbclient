package c.a.n0.a.j0;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.o1.c.e.a;
import c.a.n0.a.p2.p;
import c.a.n0.a.p2.q0;
import c.a.n0.a.p2.y0;
import c.a.n0.a.t1.h;
import c.a.n0.a.t1.i;
import c.a.n0.a.t1.m;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class c extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final SwanAppActivity f4864b;

    /* renamed from: c  reason: collision with root package name */
    public g f4865c;

    /* renamed from: d  reason: collision with root package name */
    public a.c f4866d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.n0.a.h2.g.b f4867e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f4868f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.d2.a f4869g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.a.j0.d f4870h;
    public boolean i;
    public final String j;
    public FrameLifeState k;
    public FrameLifeState l;
    public boolean m;
    public boolean n;
    public final c.a.n0.a.t1.b o;
    public boolean p;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f4871b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f4872c;

        public a(c cVar, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4872c = cVar;
            this.a = z;
            this.f4871b = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && c.a.n0.a.t1.d.J().D()) {
                this.f4872c.o.f("event_first_action_launched");
                this.f4872c.H0(this.a, this.f4871b);
                this.f4872c.N0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.N0();
            }
        }
    }

    /* renamed from: c.a.n0.a.j0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0321c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public RunnableC0321c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.f1.r.a.g().y();
                if (c.q) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (this.a.f4864b != null && c.a.n0.a.t1.e.L() != null) {
                    c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                    c.a.n0.a.d0.l.c l = c.a.n0.a.d0.l.c.l();
                    l.n(10);
                    c.a.n0.a.m0.d.c(L, l.k());
                }
                if (c.a.n0.a.k1.l.e.h()) {
                    p.m(this.a.f4864b);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f4873b;

            public a(d dVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4873b = dVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f4873b.a.f4864b == null || c.a.n0.a.t1.e.a0() == null) {
                    return;
                }
                this.f4873b.a.R(this.a);
            }
        }

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q0.e0(new a(this, q0.i(this.a.Z(), "SwanActivityFrame", true)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1691386325, "Lc/a/n0/a/j0/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1691386325, "Lc/a/n0/a/j0/c$e;");
                    return;
                }
            }
            int[] iArr = new int[FrameLifeState.values().length];
            a = iArr;
            try {
                iArr[FrameLifeState.JUST_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FrameLifeState.JUST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FrameLifeState.JUST_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FrameLifeState.INACTIVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1213881100, "Lc/a/n0/a/j0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1213881100, "Lc/a/n0/a/j0/c;");
                return;
            }
        }
        q = c.a.n0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SwanAppActivity swanAppActivity, String str) {
        super(c.a.n0.a.t1.d.J());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4866d = null;
        this.f4867e = new c.a.n0.a.h2.g.b();
        this.k = FrameLifeState.INACTIVATED;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = new c.a.n0.a.t1.b();
        this.p = true;
        this.f4864b = swanAppActivity;
        this.j = str;
        this.f4870h = new c.a.n0.a.j0.d();
        v(this.o);
    }

    public static void L0(Activity activity, String str, Bitmap bitmap, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65543, null, activity, str, bitmap, i) == null) {
            if (i != 0 && Color.alpha(i) != 255) {
                i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
            }
        }
    }

    public final synchronized void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onResumeInternal");
                this.f4870h.e();
                c.a.n0.a.u.d.i("SwanApp", "onResume: " + this);
                this.f4869g = n.c("607");
                U0();
                if (D()) {
                    r().A0(this.f4864b);
                }
                c.a.n0.a.k1.k.i.c.e().d(new RunnableC0321c(this), "tryUpdateAndInsertHistory", false);
                HybridUbcFlow p2 = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
                ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                p2.F(ubcFlowEvent2);
                c.a.n0.a.c2.a.d().i("na_page_show");
                f.U().v();
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onResumeStart");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                z0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onResumeEnd");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
            }
        }
    }

    public abstract void B0();

    public final synchronized void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onStartInternal");
                this.f4870h.d();
                B0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onStartEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }
    }

    public abstract void D0();

    public final synchronized void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                c.a.n0.a.k1.h.m();
                j0("onStopInternal");
                D0();
                this.f4870h.f();
            }
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            c.a.n0.a.u.d.o("SwanActivityFrame", "onTrimMemory level:" + i);
            d0().a(i);
        }
    }

    public abstract void G0(boolean z, boolean z2);

    public final synchronized void H0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
                if (z) {
                    b.a Z = Z();
                    if (!z2) {
                        s0();
                    }
                    if (!TextUtils.isEmpty(Z.g0())) {
                        c.a.n0.a.u.f.e.e.g(Z.g0());
                    }
                }
                f.U().l(this.f4864b);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onUpdateStart");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                G0(z, z2);
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onUpdateEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
            }
        }
    }

    public void I0(c.a.n0.a.j0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f4870h.h(bVar);
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.n0.a.v1.f.o0.c.f6808b = null;
            c.a.n0.a.k1.h.f5300c = null;
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.n0.a.s1.b.d.a.d(this.f4868f);
        }
    }

    public final synchronized FrameLifeState M(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, frameLifeState)) == null) {
            synchronized (this) {
                if (!frameLifeState.inactivated() && !r().J() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.k)) {
                    return this.k.hasCreated() ? this.k : FrameLifeState.JUST_CREATED;
                }
                return frameLifeState;
            }
        }
        return (FrameLifeState) invokeL.objValue;
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.f4864b.findViewById(R.id.obfuscated_res_0x7f09016f);
            this.f4868f = frameLayout;
            c.a.n0.a.s1.b.d.a.g(this.f4864b, frameLayout);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f4866d == null) {
                this.f4866d = b0();
            }
            z().L(null, this.f4866d);
        }
    }

    public final synchronized void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                boolean z = true;
                this.m = true;
                while (this.l != null && f0()) {
                    FrameLifeState M = M(this.l);
                    j0("syncLifeState: pendingTarget=" + this.l + " fixedTarget=" + M);
                    this.l = null;
                    int i = e.a[M.ordinal()];
                    if (i == 1) {
                        X();
                        S();
                    } else if (i == 2) {
                        U();
                        W();
                    } else if (i != 3) {
                        T();
                    } else {
                        V();
                    }
                }
                j0("syncLifeState: done=" + this.k);
                if (FrameLifeState.INACTIVATED != this.l) {
                    z = false;
                }
                this.n = z;
                this.m = false;
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.i || !c.a.n0.a.l0.c.c().a(new WeakReference<>(this.f4864b))) {
                return false;
            }
            this.i = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O0() {
        c.a.n0.a.f.d.c a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (a2 = y().a().a()) == null) {
            return;
        }
        a2.a(this.f4864b);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f4865c = new g(this.f4864b);
            q0();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
            c.a.n0.a.c.b M = L != null ? L.M() : null;
            if (M != null) {
                M.h(M.c(AppRuntime.getAppContext()));
            }
        }
    }

    public final void Q(c.a.n0.a.d2.s.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) && fVar != null && D()) {
            b.a Z = Z();
            fVar.a = n.n(l());
            fVar.f4192f = Z.H();
            fVar.f4189c = Z.T();
            fVar.b(n.k(Z.W()));
            if (TextUtils.isEmpty(fVar.f4188b)) {
                fVar.f4188b = "click";
            }
            fVar.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            if (TextUtils.equals(fVar.f4188b, "click")) {
                c.a.n0.a.d2.d.b(fVar);
            } else {
                n.onEvent(fVar);
            }
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            O0();
            P0();
        }
    }

    public final void R(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, bitmap) == null) && r().H()) {
            L0(this.f4864b, Z().K(), bitmap, (int) Z().b0());
        }
    }

    public final synchronized void R0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, frameLifeState) == null) {
            synchronized (this) {
                j0(" transLifeState: target=" + frameLifeState + " holdon=" + this.m + " locked=" + this.n + " thread=" + Thread.currentThread());
                if (!this.n) {
                    this.l = frameLifeState;
                    this.n = FrameLifeState.INACTIVATED == frameLifeState;
                }
                if (this.m) {
                    return;
                }
                this.m = true;
                q0.e0(new b(this));
            }
        }
    }

    public final synchronized void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                if (!this.k.hasCreated()) {
                    n0();
                    c.a.n0.a.u.d.i("SwanApp", "onPostCreate: " + this);
                    w0();
                    this.k = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            z().d0();
            this.f4866d = null;
        }
    }

    public final synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                X();
                if (this.k.hasCreated()) {
                    p0();
                    this.k = FrameLifeState.INACTIVATED;
                }
            }
        }
    }

    public void T0(c.a.n0.a.j0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.f4870h.i(bVar);
        }
    }

    public final synchronized void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.k.hasResumed()) {
                    v0();
                    this.k = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && r().H()) {
            c.a.n0.a.k1.k.i.c.e().d(new d(this), "updateTaskDescription", false);
        }
    }

    public final synchronized void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                W();
                if (!this.k.hasResumed()) {
                    A0();
                    this.k = FrameLifeState.JUST_RESUMED;
                }
            }
        }
    }

    public final synchronized void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                S();
                if (!this.k.hasStarted()) {
                    C0();
                    this.k = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final synchronized void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                U();
                if (this.k.hasStarted()) {
                    E0();
                    this.k = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            c.a.n0.a.s0.a.g0().getSwitch("swan_fixed_relaunch_switch", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public b.a Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? r().V() : (b.a) invokeV.objValue;
    }

    public synchronized FrameLifeState a0() {
        InterceptResult invokeV;
        FrameLifeState frameLifeState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            synchronized (this) {
                frameLifeState = this.k;
            }
            return frameLifeState;
        }
        return (FrameLifeState) invokeV.objValue;
    }

    @NonNull
    public abstract a.c b0();

    public g c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.f4865c == null) {
                P();
            }
            return this.f4865c;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    public c.a.n0.a.h2.g.b d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f4867e : (c.a.n0.a.h2.g.b) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.f4865c.k() != 1) {
                return false;
            }
            this.f4864b.moveTaskToBack(true);
            this.f4864b.handleSwanAppExit(2);
            y0.b().e(1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? f.U().Y() : invokeV.booleanValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) ? TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u") : invokeL.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, str) == null) && q) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            k0();
        }
    }

    public abstract void m0();

    @DebugTrace
    public final synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            synchronized (this) {
                j0("onCreateInternal");
                HybridUbcFlow p = c.a.n0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                p.F(new UbcFlowEvent("frame_start_create"));
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.f4870h.g();
                c.a.n0.a.u.d.i("SwanApp", "onCreate: " + this);
                if (c.a.n0.a.u.f.e.e.d()) {
                    c.a.n0.a.x.u.g.N0(false);
                }
                P();
                c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
                if (J.D() && J.r().H()) {
                    N();
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
                    ubcFlowEvent2.a(true);
                    p.F(ubcFlowEvent2);
                    m0();
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
                    ubcFlowEvent3.a(true);
                    p.F(ubcFlowEvent3);
                    c.a.n0.a.p2.e slideHelper = this.f4864b.getSlideHelper();
                    if (slideHelper != null) {
                        slideHelper.q();
                    }
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
                    ubcFlowEvent4.a(true);
                    p.F(ubcFlowEvent4);
                    return;
                }
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(5L);
                aVar.i(11L);
                aVar.f("aiapp data is invalid");
                c.a.n0.a.k2.e.a().f(aVar);
                c.a.n0.a.d2.s.d dVar = new c.a.n0.a.d2.s.d();
                dVar.q(n.n(l()));
                dVar.p(aVar);
                dVar.r(Z());
                n.R(dVar);
                c.a.n0.a.k1.h.k(aVar);
                c.a.n0.a.p2.f.j(this.f4864b);
            }
        }
    }

    public abstract void o0();

    public final synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            synchronized (this) {
                j0("onDestroyInternal");
                o0();
                this.f4870h.c();
                c.a.n0.a.u.d.i("SwanApp", "onDestroy: " + this);
                c.a.n0.a.f1.r.a.g().u();
                c.a.n0.a.x.q.b.k().v();
                c.a.n0.a.k.g.c.c().d();
                c.a.n0.a.k1.p.d.f();
                J0();
                S0();
                f.b0();
                c.a.n0.a.e0.b.b().a();
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048627, this, i, keyEvent)) == null) ? this.f4870h.onKeyDown(i, keyEvent) : invokeIL.booleanValue;
    }

    public final synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            synchronized (this) {
                R0(FrameLifeState.INACTIVATED);
                y0();
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f4870h.a();
        }
    }

    public abstract void u0();

    public final synchronized void update(FrameLifeState frameLifeState, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048632, this, frameLifeState, z) == null) {
            synchronized (this) {
                if (!this.f4864b.isDestroyed()) {
                    boolean z2 = false;
                    boolean z3 = z | (!this.k.hasCreated());
                    if (this.k.hasCreated() && z3) {
                        z2 = true;
                    }
                    boolean Y = Y();
                    this.p = Y;
                    if (Y && z2 && !r().J()) {
                        this.o.e(new a(this, z3, z2), "event_first_action_launched");
                    } else {
                        H0(z3, z2);
                    }
                    R0(frameLifeState);
                    if (z3 && (z2 || 1 == l())) {
                        c.a.n0.a.k1.h.j(Z(), z2);
                    }
                }
            }
        }
    }

    public final synchronized void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            synchronized (this) {
                j0("onPauseInternal");
                u0();
                f.U().w();
                this.f4870h.b();
                c.a.n0.a.u.d.i("SwanApp", "onPause: " + this);
                if (this.f4869g != null && D()) {
                    c.a.n0.a.d2.s.a aVar = new c.a.n0.a.d2.s.a();
                    b.a Z = Z();
                    aVar.a = n.n(l());
                    aVar.f4192f = Z.H();
                    aVar.f4189c = Z.T();
                    aVar.i(Z);
                    aVar.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                    aVar.b(n.k(Z.W()));
                    n.i(this.f4869g, aVar);
                    this.f4869g = null;
                }
            }
        }
    }

    public abstract void w0();

    public abstract void x0();

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            synchronized (this) {
                j0("onReleaseInternal");
                x0();
                f.b0();
            }
        }
    }

    public abstract void z0();
}
