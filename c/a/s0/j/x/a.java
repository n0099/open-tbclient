package c.a.s0.j.x;

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
import c.a.s0.a.f;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.h0.g.g;
import c.a.s0.a.k;
import c.a.s0.a.p.b.a.n;
import c.a.s0.a.z2.q0;
import c.a.s0.j.f.h;
import c.a.s0.j.f.i;
import c.a.s0.j.t.a;
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
/* loaded from: classes6.dex */
public class a extends c.a.s0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public c.a.s0.j.s.b l;
    public Runnable m;
    public c.a.s0.j.y.a n;

    /* renamed from: c.a.s0.j.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0798a implements c.a.s0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.s0.a.a1.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.f1.e.b f11523b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f11524c;

        /* renamed from: c.a.s0.j.x.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0799a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.a1.a f11525e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f11526f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0798a f11527g;

            public RunnableC0799a(C0798a c0798a, c.a.s0.a.a1.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0798a, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11527g = c0798a;
                this.f11525e = aVar;
                this.f11526f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11527g.f11524c.f6459i) {
                    return;
                }
                a.c cVar = (a.c) this.f11525e;
                if (this.f11526f != 0 || cVar == null) {
                    return;
                }
                C0798a c0798a = this.f11527g;
                if (c0798a.a == null) {
                    return;
                }
                if (c0798a.f11523b.m0()) {
                    if (!c.a.s0.j.f.d.m().n()) {
                        c.a.s0.a.e0.b.c(false);
                        this.f11527g.f11523b.z0(false);
                    } else {
                        a aVar = this.f11527g.f11524c;
                        aVar.n(aVar.f6454d).setVisibility(0);
                        this.f11527g.f11524c.q().H(this.f11527g.f11524c.f6456f);
                        c.a.s0.a.e0.a.b(true);
                        c.a.s0.a.e0.d.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.f11527g.f11524c.l.c(cVar, this.f11527g.f11524c.f6454d);
                this.f11527g.f11524c.k = cVar.a;
                this.f11527g.a.a(0, cVar);
                this.f11527g.f11524c.e0(cVar.f11497c);
                c.a.s0.j.j0.a.b().e(cVar.f11497c);
            }
        }

        public C0798a(a aVar, c.a.s0.a.a1.b bVar, c.a.s0.a.f1.e.b bVar2) {
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
            this.f11524c = aVar;
            this.a = bVar;
            this.f11523b = bVar2;
        }

        @Override // c.a.s0.a.a1.b
        public void a(int i2, c.a.s0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                q0.d0(this.f11524c.m);
                this.f11524c.m = new RunnableC0799a(this, aVar, i2);
                q0.g0(this.f11524c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2066657026, "Lc/a/s0/j/x/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2066657026, "Lc/a/s0/j/x/a;");
                return;
            }
        }
        o = k.a;
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
        this.l = new c.a.s0.j.s.b();
        this.n = new c.a.s0.j.y.a();
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void E(c.a.s0.a.f1.e.b bVar, c.a.s0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (o) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.j0();
            }
            c.a.s0.j.t.a.c(bVar, new C0798a(this, bVar2, bVar));
            c.a.s0.j.o.c.m().I(bVar);
            c.a.s0.j.o.c.m().G(bVar);
            boolean z = o;
            c.a.s0.j.o.c.m().z(null);
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public c.a.s0.a.p.b.a.k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (c.a.s0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.f6457g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f6457g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f6457g);
            }
            return this.f6457g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public n L() {
        InterceptResult invokeV;
        c.a.s0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g T = T();
            if (T == null || (aVar = (c.a.s0.j.n.a) T.n(c.a.s0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.s3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.s0.j.o.c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            c.a.s0.j.o.c.C();
            c.a.s0.j.b0.b.a.a().d(new JsObject());
            c.a.s0.w.d.k(c.a.s0.a.r0.n.p() + File.separator + "tmp");
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public n P() {
        InterceptResult invokeV;
        c.a.s0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g T = T();
            if (T == null || (aVar = (c.a.s0.j.n.a) T.n(c.a.s0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.q3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void e0(c.a.s0.j.d0.a.a aVar) {
        c.a.s0.a.d2.e D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (D = D()) == null) {
            return;
        }
        D.G0(aVar);
    }

    @Override // c.a.s0.a.g1.d
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6458h : invokeV.booleanValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.n(activity);
            this.f6456f.setAutoAttachEnable(false);
            return this.f6456f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public c.a.s0.a.p.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new h(AppRuntime.getAppContext());
                i.h(true);
            }
            this.a.G((ViewGroup) this.f6454d.findViewById(16908290));
            return this.a;
        }
        return (c.a.s0.a.p.e.a) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.f6454d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                b.a launchInfo = this.f6454d.getLaunchInfo();
                c.a.s0.a.n2.s.f fVar = new c.a.s0.a.n2.s.f();
                fVar.a = c.a.s0.a.n2.n.n(1);
                fVar.f8223f = launchInfo.H();
                fVar.f8220c = launchInfo.T();
                fVar.f8219b = "show";
                fVar.d(launchInfo.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(c.a.s0.a.n2.n.k(launchInfo.W()));
                c.a.s0.a.n2.n.onEvent(fVar);
            }
            c.a.s0.a.j1.b.h(true);
            c.a.s0.j.b0.b.a.a().j();
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            c.a.s0.a.j1.b.h(false);
            c.a.s0.j.b0.b.a.a().f();
        }
    }

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i2;
        int i3;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity swanAppActivity = this.f6454d;
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
            Display defaultDisplay = this.f6454d.getWindowManager().getDefaultDisplay();
            if (i3 == 0 || i2 == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i3 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            if (this.f6454d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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

    @Override // c.a.s0.a.g1.b, c.a.s0.a.g1.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
