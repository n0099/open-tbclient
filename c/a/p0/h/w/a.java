package c.a.p0.h.w;

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
import c.a.p0.a.f;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.k;
import c.a.p0.a.p.b.a.n;
import c.a.p0.a.v2.q0;
import c.a.p0.h.f.h;
import c.a.p0.h.f.i;
import c.a.p0.h.s.a;
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
/* loaded from: classes3.dex */
public class a extends c.a.p0.a.g1.b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;
    public c.a.p0.h.r.b l;
    public Runnable m;
    public c.a.p0.h.x.a n;

    /* renamed from: c.a.p0.h.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0600a implements c.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a1.b f11579a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.f1.e.b f11580b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f11581c;

        /* renamed from: c.a.p0.h.w.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0601a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.a1.a f11582e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f11583f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0600a f11584g;

            public RunnableC0601a(C0600a c0600a, c.a.p0.a.a1.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0600a, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11584g = c0600a;
                this.f11582e = aVar;
                this.f11583f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11584g.f11581c.f5749i) {
                    return;
                }
                a.c cVar = (a.c) this.f11582e;
                if (this.f11583f != 0 || cVar == null) {
                    return;
                }
                C0600a c0600a = this.f11584g;
                if (c0600a.f11579a == null) {
                    return;
                }
                if (c0600a.f11580b.l0()) {
                    if (!c.a.p0.h.f.d.m().n()) {
                        c.a.p0.a.e0.b.c(false);
                        this.f11584g.f11580b.y0(false);
                    } else {
                        a aVar = this.f11584g.f11581c;
                        aVar.n(aVar.f5744d).setVisibility(0);
                        this.f11584g.f11581c.q().H(this.f11584g.f11581c.f5746f);
                        c.a.p0.a.e0.a.b(true);
                        c.a.p0.a.e0.d.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.f11584g.f11581c.l.c(cVar, this.f11584g.f11581c.f5744d);
                this.f11584g.f11581c.k = cVar.f11540a;
                this.f11584g.f11579a.a(0, cVar);
                this.f11584g.f11581c.f0(cVar.f11542c);
                c.a.p0.h.i0.a.b().e(cVar.f11542c);
            }
        }

        public C0600a(a aVar, c.a.p0.a.a1.b bVar, c.a.p0.a.f1.e.b bVar2) {
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
            this.f11581c = aVar;
            this.f11579a = bVar;
            this.f11580b = bVar2;
        }

        @Override // c.a.p0.a.a1.b
        public void a(int i2, c.a.p0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                q0.a0(this.f11581c.m);
                this.f11581c.m = new RunnableC0601a(this, aVar, i2);
                q0.d0(this.f11581c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1158202270, "Lc/a/p0/h/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1158202270, "Lc/a/p0/h/w/a;");
                return;
            }
        }
        o = k.f7077a;
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
        this.l = new c.a.p0.h.r.b();
        this.n = new c.a.p0.h.x.a();
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.isEmpty(this.k) ? "" : this.k : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void G(c.a.p0.a.f1.e.b bVar, c.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            super.G(bVar, bVar2);
            if (o) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.i0();
            }
            c.a.p0.h.s.a.c(bVar, new C0600a(this, bVar2, bVar));
            c.a.p0.h.o.c.m().I(bVar);
            c.a.p0.h.o.c.m().G(bVar);
            boolean z = o;
            c.a.p0.h.o.c.m().z(null);
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public c.a.p0.a.p.b.a.k H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : (c.a.p0.a.p.b.a.k) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public SwanAppPropertyWindow L(Activity activity) {
        InterceptResult invokeL;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            if (this.f5747g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f5747g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f5747g);
            }
            return this.f5747g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public n M() {
        InterceptResult invokeV;
        c.a.p0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            g U = U();
            if (U == null || (aVar = (c.a.p0.h.n.a) U.n(c.a.p0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.i3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public SwanCoreVersion N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? c.a.p0.h.o.c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.P();
            c.a.p0.h.o.c.C();
            c.a.p0.h.a0.b.f10978a.a().d(new JsObject());
            c.a.p0.t.d.j(c.a.p0.a.r0.n.n() + File.separator + "tmp");
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public n Q() {
        InterceptResult invokeV;
        c.a.p0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            g U = U();
            if (U == null || (aVar = (c.a.p0.h.n.a) U.n(c.a.p0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.g3();
        }
        return (n) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? r() : (Pair) invokeV.objValue;
    }

    public final void f0(c.a.p0.h.c0.a.a aVar) {
        c.a.p0.a.a2.e F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || (F = F()) == null) {
            return;
        }
        F.u0(aVar);
    }

    @Override // c.a.p0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f5748h : invokeV.booleanValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public FullScreenFloatView n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, activity)) == null) {
            super.n(activity);
            this.f5746f.setAutoAttachEnable(false);
            return this.f5746f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public c.a.p0.a.p.e.a q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f5741a == null) {
                this.f5741a = new h(AppRuntime.getAppContext());
                i.h(true);
            }
            this.f5741a.G((ViewGroup) this.f5744d.findViewById(16908290));
            return this.f5741a;
        }
        return (c.a.p0.a.p.e.a) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? y() : (Pair) invokeV.objValue;
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            SwanAppActivity swanAppActivity = this.f5744d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                b.a launchInfo = this.f5744d.getLaunchInfo();
                c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
                fVar.f7063a = c.a.p0.a.j2.k.m(1);
                fVar.f7068f = launchInfo.H();
                fVar.f7065c = launchInfo.T();
                fVar.f7064b = "show";
                fVar.d(launchInfo.r0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(c.a.p0.a.j2.k.k(launchInfo.W()));
                c.a.p0.a.j2.k.onEvent(fVar);
            }
            c.a.p0.a.i1.b.h(true);
            c.a.p0.h.a0.b.f10978a.a().j();
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.x();
            c.a.p0.a.i1.b.h(false);
            c.a.p0.h.a0.b.f10978a.a().f();
        }
    }

    @Override // c.a.p0.a.g1.b, c.a.p0.a.g1.d
    @NonNull
    public Pair<Integer, Integer> y() {
        InterceptResult invokeV;
        int i2;
        int i3;
        View decorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SwanAppActivity swanAppActivity = this.f5744d;
            if (swanAppActivity == null) {
                return super.y();
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
            Display defaultDisplay = this.f5744d.getWindowManager().getDefaultDisplay();
            if (i3 == 0 || i2 == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i3 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            if (this.f5744d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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
}
