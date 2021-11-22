package b.a.p0.j.x;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.k;
import b.a.p0.a.p.b.a.n;
import b.a.p0.a.z2.q0;
import b.a.p0.j.f.h;
import b.a.p0.j.f.i;
import b.a.p0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes4.dex */
public class a extends b.a.p0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public b.a.p0.j.s.b l;
    public Runnable m;
    public b.a.p0.j.y.a n;

    /* renamed from: b.a.p0.j.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0629a implements b.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a1.b f11500a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f11501b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f11502c;

        /* renamed from: b.a.p0.j.x.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0630a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.a1.a f11503e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f11504f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0629a f11505g;

            public RunnableC0630a(C0629a c0629a, b.a.p0.a.a1.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0629a, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11505g = c0629a;
                this.f11503e = aVar;
                this.f11504f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11505g.f11502c.f5250i) {
                    return;
                }
                a.c cVar = (a.c) this.f11503e;
                if (this.f11504f != 0 || cVar == null) {
                    return;
                }
                C0629a c0629a = this.f11505g;
                if (c0629a.f11500a == null) {
                    return;
                }
                if (c0629a.f11501b.m0()) {
                    if (!b.a.p0.j.f.d.m().n()) {
                        b.a.p0.a.e0.b.c(false);
                        this.f11505g.f11501b.z0(false);
                    } else {
                        a aVar = this.f11505g.f11502c;
                        aVar.m(aVar.f5245d).setVisibility(0);
                        this.f11505g.f11502c.p().H(this.f11505g.f11502c.f5247f);
                        b.a.p0.a.e0.a.b(true);
                        b.a.p0.a.e0.d.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.f11505g.f11502c.l.c(cVar, this.f11505g.f11502c.f5245d);
                this.f11505g.f11502c.k = cVar.f11462a;
                this.f11505g.f11500a.a(0, cVar);
                this.f11505g.f11502c.e0(cVar.f11464c);
                b.a.p0.j.j0.a.b().e(cVar.f11464c);
            }
        }

        public C0629a(a aVar, b.a.p0.a.a1.b bVar, b.a.p0.a.f1.e.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11502c = aVar;
            this.f11500a = bVar;
            this.f11501b = bVar2;
        }

        @Override // b.a.p0.a.a1.b
        public void a(int i2, b.a.p0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                q0.d0(this.f11502c.m);
                this.f11502c.m = new RunnableC0630a(this, aVar, i2);
                q0.g0(this.f11502c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807511170, "Lb/a/p0/j/x/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807511170, "Lb/a/p0/j/x/a;");
                return;
            }
        }
        o = k.f6863a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new b.a.p0.j.s.b();
        this.n = new b.a.p0.j.y.a();
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (o) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            b.a.p0.j.t.a.c(bVar, new C0629a(this, bVar2, bVar));
            b.a.p0.j.o.c.m().I(bVar);
            b.a.p0.j.o.c.m().G(bVar);
            boolean z = o;
            b.a.p0.j.o.c.m().z(null);
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public b.a.p0.a.p.b.a.k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (b.a.p0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.f5248g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f5248g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f5248g);
            }
            return this.f5248g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public n L() {
        InterceptResult invokeV;
        b.a.p0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g T = T();
            if (T == null || (aVar = (b.a.p0.j.n.a) T.n(b.a.p0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.v3();
        }
        return (n) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.a.p0.j.o.c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            b.a.p0.j.o.c.C();
            b.a.p0.j.b0.b.f10941a.a().d(new JsObject());
            b.a.p0.w.d.k(b.a.p0.a.r0.n.p() + File.separator + "tmp");
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public n P() {
        InterceptResult invokeV;
        b.a.p0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g T = T();
            if (T == null || (aVar = (b.a.p0.j.n.a) T.n(b.a.p0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.t3();
        }
        return (n) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? q() : (Pair) invokeV.objValue;
    }

    public final void e0(b.a.p0.j.d0.a.a aVar) {
        b.a.p0.a.d2.e D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (D = D()) == null) {
            return;
        }
        D.G0(aVar);
    }

    @Override // b.a.p0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5249h : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public FullScreenFloatView m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.m(activity);
            this.f5247f.setAutoAttachEnable(false);
            return this.f5247f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public b.a.p0.a.p.e.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f5242a == null) {
                this.f5242a = new h(AppRuntime.getAppContext());
                i.h(true);
            }
            this.f5242a.G((ViewGroup) this.f5245d.findViewById(16908290));
            return this.f5242a;
        }
        return (b.a.p0.a.p.e.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.f5245d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                b.a launchInfo = this.f5245d.getLaunchInfo();
                b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
                fVar.f7379a = b.a.p0.a.n2.n.n(1);
                fVar.f7384f = launchInfo.H();
                fVar.f7381c = launchInfo.T();
                fVar.f7380b = "show";
                fVar.d(launchInfo.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(b.a.p0.a.n2.n.k(launchInfo.W()));
                b.a.p0.a.n2.n.onEvent(fVar);
            }
            b.a.p0.a.j1.b.h(true);
            b.a.p0.j.b0.b.f10941a.a().j();
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            b.a.p0.a.j1.b.h(false);
            b.a.p0.j.b0.b.f10941a.a().f();
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i2;
        int i3;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity swanAppActivity = this.f5245d;
            if (swanAppActivity == null) {
                return super.x();
            }
            Window window = swanAppActivity.getWindow();
            boolean z = false;
            if (window == null || (decorView = window.getDecorView()) == null) {
                i2 = 0;
                i3 = 0;
            } else {
                i3 = decorView.getWidth();
                i2 = decorView.getHeight();
            }
            Display defaultDisplay = this.f5245d.getWindowManager().getDefaultDisplay();
            if (i3 == 0 || i2 == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i3 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            if (this.f5245d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
                int i4 = i3;
                i3 = i2;
                i2 = i4;
            }
            if (o) {
                String str = "getCurScreenSize width:" + i2 + ",height:" + i3;
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
