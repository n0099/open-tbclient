package c.a.s0.a.t0;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.d2.h;
import c.a.s0.a.d2.i;
import c.a.s0.a.d2.m;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.g1.f;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.k;
import c.a.s0.a.n2.n;
import c.a.s0.a.y1.c.e.a;
import c.a.s0.a.z2.p;
import c.a.s0.a.z2.q0;
import c.a.s0.a.z2.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.framework.FrameLifeState;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
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
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppActivity f9039f;

    /* renamed from: g  reason: collision with root package name */
    public g f9040g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f9041h;

    /* renamed from: i  reason: collision with root package name */
    public final c.a.s0.a.r2.g.b f9042i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f9043j;
    public c.a.s0.a.n2.a k;
    public c.a.s0.a.t0.d l;
    public boolean m;
    public final String n;
    public FrameLifeState o;
    public FrameLifeState p;
    public boolean q;
    public boolean r;
    public final c.a.s0.a.d2.b s;
    public boolean t;

    /* loaded from: classes.dex */
    public class a implements c.a.s0.a.z2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f9044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f9045f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f9046g;

        public a(c cVar, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9046g = cVar;
            this.f9044e = z;
            this.f9045f = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && c.a.s0.a.d2.d.J().D()) {
                this.f9046g.s.f("event_first_action_launched");
                this.f9046g.H0(this.f9044e, this.f9045f);
                this.f9046g.N0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9047e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9047e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9047e.N0();
            }
        }
    }

    /* renamed from: c.a.s0.a.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0576c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9048e;

        public RunnableC0576c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9048e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.p1.r.a.g().y();
                boolean unused = c.u;
                if (this.f9048e.f9039f != null && c.a.s0.a.d2.e.L() != null) {
                    c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
                    c.a.s0.a.n0.l.c l = c.a.s0.a.n0.l.c.l();
                    l.n(10);
                    c.a.s0.a.w0.d.c(L, l.k());
                }
                if (c.a.s0.a.u1.l.e.h()) {
                    p.m(this.f9048e.f9039f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9049e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f9050e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f9051f;

            public a(d dVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9051f = dVar;
                this.f9050e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9051f.f9049e.f9039f == null || c.a.s0.a.d2.e.a0() == null) {
                    return;
                }
                this.f9051f.f9049e.R(this.f9050e);
            }
        }

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9049e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q0.e0(new a(this, q0.i(this.f9049e.Z(), "SwanActivityFrame", true)));
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-760870512, "Lc/a/s0/a/t0/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-760870512, "Lc/a/s0/a/t0/c$e;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(240548785, "Lc/a/s0/a/t0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(240548785, "Lc/a/s0/a/t0/c;");
                return;
            }
        }
        u = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SwanAppActivity swanAppActivity, String str) {
        super(c.a.s0.a.d2.d.J());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9041h = null;
        this.f9042i = new c.a.s0.a.r2.g.b();
        this.o = FrameLifeState.INACTIVATED;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = new c.a.s0.a.d2.b();
        this.t = true;
        this.f9039f = swanAppActivity;
        this.n = str;
        this.l = new c.a.s0.a.t0.d();
        v(this.s);
    }

    public static void L0(Activity activity, String str, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65543, null, activity, str, bitmap, i2) == null) {
            if (i2 != 0 && Color.alpha(i2) != 255) {
                i2 = Color.argb(255, Color.red(i2), Color.green(i2), Color.blue(i2));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i2));
            }
        }
    }

    public final synchronized void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onResumeInternal");
                this.l.e();
                c.a.s0.a.e0.d.i("SwanApp", "onResume: " + this);
                this.k = n.c("607");
                U0();
                if (D()) {
                    r().A0(this.f9039f);
                }
                c.a.s0.a.u1.k.i.c.e().d(new RunnableC0576c(this), "tryUpdateAndInsertHistory", false);
                HybridUbcFlow p2 = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
                ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                p2.F(ubcFlowEvent2);
                c.a.s0.a.m2.a.d().i("na_page_show");
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
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                j0("onStartInternal");
                this.l.d();
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
                c.a.s0.a.u1.h.m();
                j0("onStopInternal");
                D0();
                this.l.f();
            }
        }
    }

    public void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            c.a.s0.a.e0.d.o("SwanActivityFrame", "onTrimMemory level:" + i2);
            d0().a(i2);
        }
    }

    public abstract void G0(boolean z, boolean z2);

    public final synchronized void H0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
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
                        c.a.s0.a.e0.f.e.e.g(Z.g0());
                    }
                }
                f.U().l(this.f9039f);
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

    public void I0(c.a.s0.a.t0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.l.h(bVar);
        }
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.s0.a.f2.f.o0.c.f6304b = null;
            c.a.s0.a.u1.h.f9584c = null;
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.s0.a.c2.b.d.a.d(this.f9043j);
        }
    }

    public final synchronized FrameLifeState M(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, frameLifeState)) == null) {
            synchronized (this) {
                if (!frameLifeState.inactivated() && !r().J() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.o)) {
                    return this.o.hasCreated() ? this.o : FrameLifeState.JUST_CREATED;
                }
                return frameLifeState;
            }
        }
        return (FrameLifeState) invokeL.objValue;
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.f9039f.findViewById(c.a.s0.a.f.ai_apps_activity_root);
            this.f9043j = frameLayout;
            c.a.s0.a.c2.b.d.a.g(this.f9039f, frameLayout);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.f9041h == null) {
                this.f9041h = b0();
            }
            z().L(null, this.f9041h);
        }
    }

    public final synchronized void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                boolean z = true;
                this.q = true;
                while (this.p != null && f0()) {
                    FrameLifeState M = M(this.p);
                    j0("syncLifeState: pendingTarget=" + this.p + " fixedTarget=" + M);
                    this.p = null;
                    int i2 = e.a[M.ordinal()];
                    if (i2 == 1) {
                        X();
                        S();
                    } else if (i2 == 2) {
                        U();
                        W();
                    } else if (i2 != 3) {
                        T();
                    } else {
                        V();
                    }
                }
                j0("syncLifeState: done=" + this.o);
                if (FrameLifeState.INACTIVATED != this.p) {
                    z = false;
                }
                this.r = z;
                this.q = false;
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.m || !c.a.s0.a.v0.c.c().a(new WeakReference<>(this.f9039f))) {
                return false;
            }
            this.m = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O0() {
        c.a.s0.a.p.d.c a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (a2 = y().a().a()) == null) {
            return;
        }
        a2.a(this.f9039f);
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f9040g = new g(this.f9039f);
            q0();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
            c.a.s0.a.m.b M = L != null ? L.M() : null;
            if (M != null) {
                M.h(M.c(AppRuntime.getAppContext()));
            }
        }
    }

    public final void Q(c.a.s0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) && fVar != null && D()) {
            b.a Z = Z();
            fVar.a = n.n(l());
            fVar.f8223f = Z.H();
            fVar.f8220c = Z.T();
            fVar.b(n.k(Z.W()));
            if (TextUtils.isEmpty(fVar.f8219b)) {
                fVar.f8219b = "click";
            }
            fVar.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            if (TextUtils.equals(fVar.f8219b, "click")) {
                c.a.s0.a.n2.d.b(fVar);
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
            L0(this.f9039f, Z().K(), bitmap, (int) Z().b0());
        }
    }

    public final synchronized void R0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, frameLifeState) == null) {
            synchronized (this) {
                j0(" transLifeState: target=" + frameLifeState + " holdon=" + this.q + " locked=" + this.r + " thread=" + Thread.currentThread());
                if (!this.r) {
                    this.p = frameLifeState;
                    this.r = FrameLifeState.INACTIVATED == frameLifeState;
                }
                if (this.q) {
                    return;
                }
                this.q = true;
                q0.e0(new b(this));
            }
        }
    }

    public final synchronized void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                if (!this.o.hasCreated()) {
                    n0();
                    c.a.s0.a.e0.d.i("SwanApp", "onPostCreate: " + this);
                    w0();
                    this.o = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            z().d0();
            this.f9041h = null;
        }
    }

    public final synchronized void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                X();
                if (this.o.hasCreated()) {
                    p0();
                    this.o = FrameLifeState.INACTIVATED;
                }
            }
        }
    }

    public void T0(c.a.s0.a.t0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.l.i(bVar);
        }
    }

    public final synchronized void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (this.o.hasResumed()) {
                    v0();
                    this.o = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && r().H()) {
            c.a.s0.a.u1.k.i.c.e().d(new d(this), "updateTaskDescription", false);
        }
    }

    public final synchronized void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                W();
                if (!this.o.hasResumed()) {
                    A0();
                    this.o = FrameLifeState.JUST_RESUMED;
                }
            }
        }
    }

    public final synchronized void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            synchronized (this) {
                S();
                if (!this.o.hasStarted()) {
                    C0();
                    this.o = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final synchronized void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                U();
                if (this.o.hasStarted()) {
                    E0();
                    this.o = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            c.a.s0.a.c1.a.g0().getSwitch("swan_fixed_relaunch_switch", true);
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
                frameLifeState = this.o;
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
            if (this.f9040g == null) {
                P();
            }
            return this.f9040g;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    public c.a.s0.a.r2.g.b d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.f9042i : (c.a.s0.a.r2.g.b) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.f9040g.k() != 1) {
                return false;
            }
            this.f9039f.moveTaskToBack(true);
            this.f9039f.handleSwanAppExit(2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            boolean z = u;
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
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
                HybridUbcFlow p = c.a.s0.a.u1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
                p.F(new UbcFlowEvent("frame_start_create"));
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.l.g();
                c.a.s0.a.e0.d.i("SwanApp", "onCreate: " + this);
                if (c.a.s0.a.e0.f.e.e.d()) {
                    c.a.s0.a.h0.u.g.N0(false);
                }
                P();
                c.a.s0.a.d2.d J = c.a.s0.a.d2.d.J();
                if (J.D() && J.r().H()) {
                    N();
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
                    ubcFlowEvent2.a(true);
                    p.F(ubcFlowEvent2);
                    m0();
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
                    ubcFlowEvent3.a(true);
                    p.F(ubcFlowEvent3);
                    c.a.s0.a.z2.e slideHelper = this.f9039f.getSlideHelper();
                    if (slideHelper != null) {
                        slideHelper.q();
                    }
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
                    ubcFlowEvent4.a(true);
                    p.F(ubcFlowEvent4);
                    return;
                }
                c.a.s0.a.u2.a aVar = new c.a.s0.a.u2.a();
                aVar.k(5L);
                aVar.i(11L);
                aVar.f("aiapp data is invalid");
                c.a.s0.a.u2.e.a().f(aVar);
                c.a.s0.a.n2.s.d dVar = new c.a.s0.a.n2.s.d();
                dVar.q(n.n(l()));
                dVar.p(aVar);
                dVar.r(Z());
                n.R(dVar);
                c.a.s0.a.u1.h.k(aVar);
                c.a.s0.a.z2.f.j(this.f9039f);
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
                this.l.c();
                c.a.s0.a.e0.d.i("SwanApp", "onDestroy: " + this);
                c.a.s0.a.p1.r.a.g().u();
                c.a.s0.a.h0.q.b.k().v();
                c.a.s0.a.u.g.c.c().d();
                c.a.s0.a.u1.p.d.f();
                J0();
                S0();
                f.b0();
                c.a.s0.a.o0.b.b().a();
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
        }
    }

    public boolean r0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048627, this, i2, keyEvent)) == null) ? this.l.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
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
            this.l.a();
        }
    }

    public abstract void u0();

    public final synchronized void update(FrameLifeState frameLifeState, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048632, this, frameLifeState, z) == null) {
            synchronized (this) {
                if (!this.f9039f.isDestroyed()) {
                    boolean z2 = false;
                    boolean z3 = z | (!this.o.hasCreated());
                    if (this.o.hasCreated() && z3) {
                        z2 = true;
                    }
                    boolean Y = Y();
                    this.t = Y;
                    if (Y && z2 && !r().J()) {
                        this.s.e(new a(this, z3, z2), "event_first_action_launched");
                    } else {
                        H0(z3, z2);
                    }
                    R0(frameLifeState);
                    if (z3 && (z2 || 1 == l())) {
                        c.a.s0.a.u1.h.j(Z(), z2);
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
                this.l.b();
                c.a.s0.a.e0.d.i("SwanApp", "onPause: " + this);
                if (this.k != null && D()) {
                    c.a.s0.a.n2.s.a aVar = new c.a.s0.a.n2.s.a();
                    b.a Z = Z();
                    aVar.a = n.n(l());
                    aVar.f8223f = Z.H();
                    aVar.f8220c = Z.T();
                    aVar.i(Z);
                    aVar.d(Z.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                    aVar.b(n.k(Z.W()));
                    n.i(this.k, aVar);
                    this.k = null;
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
