package b.a.p0.a.t0;

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
import b.a.p0.a.a2.h;
import b.a.p0.a.a2.i;
import b.a.p0.a.a2.m;
import b.a.p0.a.f;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import b.a.p0.a.v1.c.e.a;
import b.a.p0.a.v2.p;
import b.a.p0.a.v2.q0;
import b.a.p0.a.v2.x0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class c extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppActivity f7905f;

    /* renamed from: g  reason: collision with root package name */
    public g f7906g;

    /* renamed from: h  reason: collision with root package name */
    public a.c f7907h;

    /* renamed from: i  reason: collision with root package name */
    public final b.a.p0.a.n2.h.d f7908i;
    public FrameLayout j;
    public b.a.p0.a.j2.a k;
    public b.a.p0.a.t0.d l;
    public boolean m;
    public final String n;
    public FrameLifeState o;
    public FrameLifeState p;
    public boolean q;
    public boolean r;
    public final b.a.p0.a.a2.b s;
    public boolean t;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f7909e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f7910f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f7911g;

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
            this.f7911g = cVar;
            this.f7909e = z;
            this.f7910f = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && b.a.p0.a.a2.d.g().C()) {
                this.f7911g.s.f("event_first_action_launched");
                this.f7911g.w0(this.f7909e, this.f7910f);
                this.f7911g.D0();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7912e;

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
            this.f7912e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f7912e.D0();
            }
        }
    }

    /* renamed from: b.a.p0.a.t0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0369c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7913e;

        public RunnableC0369c(c cVar) {
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
            this.f7913e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n1.q.a.g().y();
                boolean unused = c.u;
                if (this.f7913e.f7905f != null && b.a.p0.a.a2.e.i() != null) {
                    b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                    b.a.p0.a.n0.l.c l = b.a.p0.a.n0.l.c.l();
                    l.n(10);
                    b.a.p0.a.w0.c.c(i2, l.k());
                }
                if (b.a.p0.a.r1.l.e.l()) {
                    p.i(this.f7913e.f7905f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7914e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f7915e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f7916f;

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
                this.f7916f = dVar;
                this.f7915e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7916f.f7914e.f7905f == null || b.a.p0.a.a2.e.P() == null) {
                    return;
                }
                this.f7916f.f7914e.G(this.f7915e);
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
            this.f7914e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q0.b0(new a(this, q0.i(this.f7914e.O(), "SwanActivityFrame", true)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7917a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-637584492, "Lb/a/p0/a/t0/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-637584492, "Lb/a/p0/a/t0/c$e;");
                    return;
                }
            }
            int[] iArr = new int[FrameLifeState.values().length];
            f7917a = iArr;
            try {
                iArr[FrameLifeState.JUST_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7917a[FrameLifeState.JUST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7917a[FrameLifeState.JUST_RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7917a[FrameLifeState.INACTIVATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1335647925, "Lb/a/p0/a/t0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1335647925, "Lb/a/p0/a/t0/c;");
                return;
            }
        }
        u = k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SwanAppActivity swanAppActivity, String str) {
        super(b.a.p0.a.a2.d.g());
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
        this.f7907h = null;
        this.f7908i = new b.a.p0.a.n2.h.d();
        this.o = FrameLifeState.INACTIVATED;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = new b.a.p0.a.a2.b();
        this.t = true;
        this.f7905f = swanAppActivity;
        this.n = str;
        this.l = new b.a.p0.a.t0.d();
        v(this.s);
    }

    public static void B0(Activity activity, String str, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65538, null, activity, str, bitmap, i2) == null) {
            if (i2 != 0 && Color.alpha(i2) != 255) {
                i2 = Color.argb(255, Color.red(i2), Color.green(i2), Color.blue(i2));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i2));
            }
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.p0.a.z1.b.d.a.c(this.j);
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FrameLayout frameLayout = (FrameLayout) this.f7905f.findViewById(f.ai_apps_activity_root);
            this.j = frameLayout;
            b.a.p0.a.z1.b.d.a.e(this.f7905f, frameLayout);
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m || !b.a.p0.a.v0.c.c().a(new WeakReference<>(this.f7905f))) {
                return false;
            }
            this.m = true;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final synchronized void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                boolean z = true;
                this.q = true;
                while (this.p != null && U()) {
                    FrameLifeState j = j(this.p);
                    Y("syncLifeState: pendingTarget=" + this.p + " fixedTarget=" + j);
                    this.p = null;
                    int i2 = e.f7917a[j.ordinal()];
                    if (i2 == 1) {
                        M();
                        H();
                    } else if (i2 == 2) {
                        J();
                        L();
                    } else if (i2 != 3) {
                        I();
                    } else {
                        K();
                    }
                }
                Y("syncLifeState: done=" + this.o);
                if (FrameLifeState.INACTIVATED != this.p) {
                    z = false;
                }
                this.r = z;
                this.q = false;
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f7906g = new g(this.f7905f);
            f0();
        }
    }

    public final void E0() {
        b.a.p0.a.p.d.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (a2 = y().a().a()) == null) {
            return;
        }
        a2.a(this.f7905f);
    }

    public final void F(b.a.p0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) && fVar != null && C()) {
            b.a O = O();
            fVar.f6383a = b.a.p0.a.j2.k.m(l());
            fVar.f6388f = O.G();
            fVar.f6385c = O.S();
            fVar.b(b.a.p0.a.j2.k.k(O.V()));
            if (TextUtils.isEmpty(fVar.f6384b)) {
                fVar.f6384b = PrefetchEvent.STATE_CLICK;
            }
            fVar.d(O.q0().getString(UBCCloudControlProcessor.UBC_KEY));
            if (TextUtils.equals(fVar.f6384b, PrefetchEvent.STATE_CLICK)) {
                b.a.p0.a.j2.d.b(fVar);
            } else {
                b.a.p0.a.j2.k.onEvent(fVar);
            }
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            b.a.p0.a.m.b j = i2 != null ? i2.j() : null;
            if (j != null) {
                j.h(j.c(AppRuntime.getAppContext()));
            }
        }
    }

    public final void G(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) && r().e()) {
            B0(this.f7905f, O().J(), bitmap, (int) O().a0());
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            E0();
            F0();
        }
    }

    public final synchronized void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                if (!this.o.hasCreated()) {
                    c0();
                    b.a.p0.a.e0.d.g("SwanApp", "onPostCreate: " + this);
                    l0();
                    this.o = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final synchronized void H0(@NonNull FrameLifeState frameLifeState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, frameLifeState) == null) {
            synchronized (this) {
                Y(" transLifeState: target=" + frameLifeState + " holdon=" + this.q + " locked=" + this.r + " thread=" + Thread.currentThread());
                if (!this.r) {
                    this.p = frameLifeState;
                    this.r = FrameLifeState.INACTIVATED == frameLifeState;
                }
                if (this.q) {
                    return;
                }
                this.q = true;
                q0.b0(new b(this));
            }
        }
    }

    public final synchronized void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                M();
                if (this.o.hasCreated()) {
                    e0();
                    this.o = FrameLifeState.INACTIVATED;
                }
            }
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z().S();
            this.f7907h = null;
        }
    }

    public final synchronized void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                if (this.o.hasResumed()) {
                    k0();
                    this.o = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public void J0(b.a.p0.a.t0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.l.i(bVar);
        }
    }

    public final synchronized void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                L();
                if (!this.o.hasResumed()) {
                    p0();
                    this.o = FrameLifeState.JUST_RESUMED;
                }
            }
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && r().e()) {
            b.a.p0.a.r1.k.i.b.e().f(new d(this), "updateTaskDescription");
        }
    }

    public final synchronized void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                H();
                if (!this.o.hasStarted()) {
                    r0();
                    this.o = FrameLifeState.JUST_STARTED;
                }
            }
        }
    }

    public final synchronized void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this) {
                J();
                if (this.o.hasStarted()) {
                    t0();
                    this.o = FrameLifeState.JUST_CREATED;
                }
            }
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            b.a.p0.a.c1.a.Z().getSwitch("swan_fixed_relaunch_switch", true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public b.a O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? r().K() : (b.a) invokeV.objValue;
    }

    public synchronized FrameLifeState P() {
        InterceptResult invokeV;
        FrameLifeState frameLifeState;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                frameLifeState = this.o;
            }
            return frameLifeState;
        }
        return (FrameLifeState) invokeV.objValue;
    }

    @NonNull
    public abstract a.c Q();

    public g R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f7906g == null) {
                E();
            }
            return this.f7906g;
        }
        return (g) invokeV.objValue;
    }

    @NonNull
    public b.a.p0.a.n2.h.d S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f7908i : (b.a.p0.a.n2.h.d) invokeV.objValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f7906g.k() != 1) {
                return false;
            }
            this.f7905f.moveTaskToBack(true);
            this.f7905f.handleSwanAppExit(2);
            x0.b().e(1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? b.a.p0.a.g1.f.T().X() : invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u") : invokeL.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public final void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            boolean z = u;
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
        }
    }

    public void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            Z();
        }
    }

    public abstract void b0();

    @DebugTrace
    public final synchronized void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            synchronized (this) {
                Y("onCreateInternal");
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                p.C(new UbcFlowEvent("frame_start_create"));
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onCreateInternalStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                this.l.g();
                b.a.p0.a.e0.d.g("SwanApp", "onCreate: " + this);
                if (b.a.p0.a.e0.f.e.e.d()) {
                    b.a.p0.a.h0.u.g.z0(false);
                }
                E();
                b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
                if (g2.C() && g2.r().e()) {
                    k();
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onCreateStart");
                    ubcFlowEvent2.a(true);
                    p.C(ubcFlowEvent2);
                    b0();
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onCreateEnd");
                    ubcFlowEvent3.a(true);
                    p.C(ubcFlowEvent3);
                    b.a.p0.a.v2.e slideHelper = this.f7905f.getSlideHelper();
                    if (slideHelper != null) {
                        slideHelper.q();
                    }
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onCreateInternalEnd");
                    ubcFlowEvent4.a(true);
                    p.C(ubcFlowEvent4);
                    return;
                }
                b.a.p0.a.q2.a aVar = new b.a.p0.a.q2.a();
                aVar.j(5L);
                aVar.h(11L);
                aVar.e("aiapp data is invalid");
                b.a.p0.a.q2.e.a().f(aVar);
                b.a.p0.a.j2.p.d dVar = new b.a.p0.a.j2.p.d();
                dVar.q(b.a.p0.a.j2.k.m(l()));
                dVar.p(aVar);
                dVar.r(O());
                b.a.p0.a.j2.k.L(dVar);
                b.a.p0.a.r1.h.k(aVar);
                b.a.p0.a.v2.f.j(this.f7905f);
            }
        }
    }

    public abstract void d0();

    public final synchronized void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            synchronized (this) {
                Y("onDestroyInternal");
                d0();
                this.l.c();
                b.a.p0.a.e0.d.g("SwanApp", "onDestroy: " + this);
                b.a.p0.a.n1.q.a.g().u();
                b.a.p0.a.h0.q.b.g().n();
                b.a.p0.a.u.g.c.c().d();
                b.a.p0.a.r1.p.d.f();
                z0();
                I0();
                b.a.p0.a.g1.f.a0();
                b.a.p0.a.o0.b.b().a();
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    public boolean g0(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048615, this, i2, keyEvent)) == null) ? this.l.onKeyDown(i2, keyEvent) : invokeIL.booleanValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.l.a();
        }
    }

    public final synchronized FrameLifeState j(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, frameLifeState)) == null) {
            synchronized (this) {
                if (!frameLifeState.inactivated() && !r().g() && frameLifeState.hasStarted() && !frameLifeState.moreInactiveThan(this.o)) {
                    return this.o.hasCreated() ? this.o : FrameLifeState.JUST_CREATED;
                }
                return frameLifeState;
            }
        }
        return (FrameLifeState) invokeL.objValue;
    }

    public abstract void j0();

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.f7907h == null) {
                this.f7907h = Q();
            }
            z().i(null, this.f7907h);
        }
    }

    public final synchronized void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            synchronized (this) {
                Y("onPauseInternal");
                j0();
                b.a.p0.a.g1.f.T().w();
                this.l.b();
                b.a.p0.a.e0.d.g("SwanApp", "onPause: " + this);
                if (this.k != null && C()) {
                    b.a.p0.a.j2.p.a aVar = new b.a.p0.a.j2.p.a();
                    b.a O = O();
                    aVar.f6383a = b.a.p0.a.j2.k.m(l());
                    aVar.f6388f = O.G();
                    aVar.f6385c = O.S();
                    aVar.i(O);
                    aVar.d(O.q0().getString(UBCCloudControlProcessor.UBC_KEY));
                    aVar.b(b.a.p0.a.j2.k.k(O.V()));
                    b.a.p0.a.j2.k.i(this.k, aVar);
                    this.k = null;
                }
            }
        }
    }

    public abstract void l0();

    public abstract void m0();

    public final synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            synchronized (this) {
                Y("onReleaseInternal");
                m0();
                b.a.p0.a.g1.f.a0();
            }
        }
    }

    public abstract void o0();

    public final synchronized void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onResumeInternalStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                Y("onResumeInternal");
                this.l.e();
                b.a.p0.a.e0.d.g("SwanApp", "onResume: " + this);
                this.k = b.a.p0.a.j2.k.c("607");
                K0();
                if (C()) {
                    r().n0(this.f7905f);
                }
                b.a.p0.a.r1.k.i.b.e().f(new RunnableC0369c(this), "tryUpdateAndInsertHistory");
                HybridUbcFlow p2 = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_page_show");
                ubcFlowEvent2.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                p2.C(ubcFlowEvent2);
                b.a.p0.a.i2.a.d().i("na_page_show");
                b.a.p0.a.g1.f.T().v();
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onResumeStart");
                ubcFlowEvent3.a(true);
                p.C(ubcFlowEvent3);
                o0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("onResumeEnd");
                ubcFlowEvent4.a(true);
                p.C(ubcFlowEvent4);
            }
        }
    }

    public abstract void q0();

    public final synchronized void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onStartStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                Y("onStartInternal");
                this.l.d();
                q0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onStartEnd");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
            }
        }
    }

    public abstract void s0();

    public final synchronized void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            synchronized (this) {
                b.a.p0.a.r1.h.m();
                Y("onStopInternal");
                s0();
                this.l.f();
            }
        }
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            b.a.p0.a.e0.d.l("SwanActivityFrame", "onTrimMemory level:" + i2);
            S().a(i2);
        }
    }

    public final synchronized void update(FrameLifeState frameLifeState, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048632, this, frameLifeState, z) == null) {
            synchronized (this) {
                if (!this.f7905f.isDestroyed()) {
                    boolean z2 = false;
                    boolean z3 = z | (!this.o.hasCreated());
                    if (this.o.hasCreated() && z3) {
                        z2 = true;
                    }
                    boolean N = N();
                    this.t = N;
                    if (N && z2 && !r().g()) {
                        this.s.e(new a(this, z3, z2), "event_first_action_launched");
                    } else {
                        w0(z3, z2);
                    }
                    H0(frameLifeState);
                    if (z3 && (z2 || 1 == l())) {
                        b.a.p0.a.r1.h.j(O(), z2);
                    }
                }
            }
        }
    }

    public abstract void v0(boolean z, boolean z2);

    public final synchronized void w0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("onUpdateInternalStart");
                ubcFlowEvent.a(true);
                p.C(ubcFlowEvent);
                Y("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
                if (z) {
                    b.a O = O();
                    if (!z2) {
                        h0();
                    }
                    if (!TextUtils.isEmpty(O.f0())) {
                        b.a.p0.a.e0.f.e.e.g(O.f0());
                    }
                }
                b.a.p0.a.g1.f.T().k(this.f7905f);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("onUpdateStart");
                ubcFlowEvent2.a(true);
                p.C(ubcFlowEvent2);
                v0(z, z2);
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("onUpdateEnd");
                ubcFlowEvent3.a(true);
                p.C(ubcFlowEvent3);
            }
        }
    }

    public void x0(b.a.p0.a.t0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bVar) == null) {
            this.l.h(bVar);
        }
    }

    public final synchronized void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            synchronized (this) {
                H0(FrameLifeState.INACTIVATED);
                n0();
            }
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            b.a.p0.a.c2.f.p0.c.f4361b = null;
            b.a.p0.a.r1.h.f7632e = null;
        }
    }
}
