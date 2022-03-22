package c.a.n0.j.x;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.s.f;
import c.a.n0.a.f.b.a.k;
import c.a.n0.a.f.b.a.n;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v0.e.b;
import c.a.n0.a.x.g.g;
import c.a.n0.j.f.h;
import c.a.n0.j.f.i;
import c.a.n0.j.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@Service
/* loaded from: classes2.dex */
public class a extends c.a.n0.a.w0.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public c.a.n0.j.s.b l;
    public Runnable m;
    public c.a.n0.j.y.a n;

    /* renamed from: c.a.n0.j.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0738a implements c.a.n0.a.q0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.q0.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.v0.e.b f8957b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f8958c;

        /* renamed from: c.a.n0.j.x.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0739a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.q0.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f8959b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C0738a f8960c;

            public RunnableC0739a(C0738a c0738a, c.a.n0.a.q0.a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0738a, aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8960c = c0738a;
                this.a = aVar;
                this.f8959b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8960c.f8958c.i) {
                    return;
                }
                a.c cVar = (a.c) this.a;
                if (this.f8959b != 0 || cVar == null) {
                    return;
                }
                C0738a c0738a = this.f8960c;
                if (c0738a.a == null) {
                    return;
                }
                if (c0738a.f8957b.m0()) {
                    if (!c.a.n0.j.f.d.m().n()) {
                        c.a.n0.a.u.b.c(false);
                        this.f8960c.f8957b.z0(false);
                    } else {
                        a aVar = this.f8960c.f8958c;
                        aVar.n(aVar.f6934d).setVisibility(0);
                        this.f8960c.f8958c.q().I(this.f8960c.f8958c.f6936f);
                        c.a.n0.a.u.a.b(true);
                        c.a.n0.a.u.d.i("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.f8960c.f8958c.l.c(cVar, this.f8960c.f8958c.f6934d);
                this.f8960c.f8958c.k = cVar.a;
                this.f8960c.a.a(0, cVar);
                this.f8960c.f8958c.e0(cVar.f8938c);
                c.a.n0.j.j0.a.b().e(cVar.f8938c);
            }
        }

        public C0738a(a aVar, c.a.n0.a.q0.b bVar, c.a.n0.a.v0.e.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8958c = aVar;
            this.a = bVar;
            this.f8957b = bVar2;
        }

        @Override // c.a.n0.a.q0.b
        public void a(int i, c.a.n0.a.q0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, aVar) == null) {
                q0.d0(this.f8958c.m);
                this.f8958c.m = new RunnableC0739a(this, aVar, i);
                q0.g0(this.f8958c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1780972547, "Lc/a/n0/j/x/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1780972547, "Lc/a/n0/j/x/a;");
                return;
            }
        }
        o = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new c.a.n0.j.s.b();
        this.n = new c.a.n0.j.y.a();
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public void E(c.a.n0.a.v0.e.b bVar, c.a.n0.a.q0.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (o) {
                Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.j0());
            }
            c.a.n0.j.t.a.c(bVar, new C0738a(this, bVar2, bVar));
            c.a.n0.j.o.c.m().I(bVar);
            c.a.n0.j.o.c.m().G(bVar);
            if (o) {
                Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
            }
            c.a.n0.j.o.c.m().z(null);
        }
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public k F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : (k) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public SwanAppPropertyWindow J(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.f6937g == null && (viewGroup = (ViewGroup) activity.findViewById(R.id.obfuscated_res_0x7f09016f)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f6937g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f6937g);
            }
            return this.f6937g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public n L() {
        InterceptResult invokeV;
        c.a.n0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g T = T();
            if (T == null || (aVar = (c.a.n0.j.n.a) T.n(c.a.n0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.w3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.n0.j.o.c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O();
            c.a.n0.j.o.c.C();
            c.a.n0.j.b0.b.a.a().d(new JsObject());
            c.a.n0.w.d.k(c.a.n0.a.h0.n.p() + File.separator + "tmp");
        }
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public n P() {
        InterceptResult invokeV;
        c.a.n0.j.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g T = T();
            if (T == null || (aVar = (c.a.n0.j.n.a) T.n(c.a.n0.j.n.a.class)) == null) {
                return null;
            }
            return aVar.u3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.b
    @NonNull
    public Pair<Integer, Integer> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void e0(c.a.n0.j.d0.a.a aVar) {
        c.a.n0.a.t1.e D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (D = D()) == null) {
            return;
        }
        D.G0(aVar);
    }

    @Override // c.a.n0.a.w0.d
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f6938h : invokeV.booleanValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.n(activity);
            this.f6936f.setAutoAttachEnable(false);
            return this.f6936f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public c.a.n0.a.f.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new h(AppRuntime.getAppContext());
                i.h(true);
            }
            this.a.H((ViewGroup) this.f6934d.findViewById(16908290));
            return this.a;
        }
        return (c.a.n0.a.f.e.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? x() : (Pair) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.v();
            SwanAppActivity swanAppActivity = this.f6934d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                b.a launchInfo = this.f6934d.getLaunchInfo();
                f fVar = new f();
                fVar.a = c.a.n0.a.d2.n.n(1);
                fVar.f4192f = launchInfo.H();
                fVar.f4189c = launchInfo.T();
                fVar.f4188b = "show";
                fVar.d(launchInfo.s0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(c.a.n0.a.d2.n.k(launchInfo.W()));
                c.a.n0.a.d2.n.onEvent(fVar);
            }
            c.a.n0.a.z0.b.h(true);
            c.a.n0.j.b0.b.a.a().j();
        }
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            c.a.n0.a.z0.b.h(false);
            c.a.n0.j.b0.b.a.a().f();
        }
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    @NonNull
    public Pair<Integer, Integer> x() {
        InterceptResult invokeV;
        int i;
        int i2;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SwanAppActivity swanAppActivity = this.f6934d;
            if (swanAppActivity == null) {
                return super.x();
            }
            Window window = swanAppActivity.getWindow();
            boolean z = false;
            if (window == null || (decorView = window.getDecorView()) == null) {
                i = 0;
                i2 = 0;
            } else {
                i2 = decorView.getWidth();
                i = decorView.getHeight();
            }
            Display defaultDisplay = this.f6934d.getWindowManager().getDefaultDisplay();
            if (i2 == 0 || i == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i2 = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            }
            if (this.f6934d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
                int i3 = i2;
                i2 = i;
                i = i3;
            }
            if (o) {
                Log.d("GamesControllerImpl", "getCurScreenSize width:" + i + ",height:" + i2);
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        }
        return (Pair) invokeV.objValue;
    }

    @Override // c.a.n0.a.w0.b, c.a.n0.a.w0.d
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }
}
