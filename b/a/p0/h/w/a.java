package b.a.p0.h.w;

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
import b.a.p0.a.v2.q0;
import b.a.p0.h.f.h;
import b.a.p0.h.f.i;
import b.a.p0.h.s.a;
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
    public b.a.p0.h.r.b l;
    public Runnable m;
    public b.a.p0.h.x.a n;

    /* renamed from: b.a.p0.h.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0595a implements b.a.p0.a.a1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a1.b f10778a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.f1.e.b f10779b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f10780c;

        /* renamed from: b.a.p0.h.w.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0596a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.a1.a f10781e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f10782f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ C0595a f10783g;

            public RunnableC0596a(C0595a c0595a, b.a.p0.a.a1.a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0595a, aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10783g = c0595a;
                this.f10781e = aVar;
                this.f10782f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10783g.f10780c.f5107i) {
                    return;
                }
                a.c cVar = (a.c) this.f10781e;
                if (this.f10782f != 0 || cVar == null) {
                    return;
                }
                C0595a c0595a = this.f10783g;
                if (c0595a.f10778a == null) {
                    return;
                }
                if (c0595a.f10779b.k0()) {
                    if (!b.a.p0.h.f.d.m().n()) {
                        b.a.p0.a.e0.b.c(false);
                        this.f10783g.f10779b.x0(false);
                    } else {
                        a aVar = this.f10783g.f10780c;
                        aVar.m(aVar.f5102d).setVisibility(0);
                        this.f10783g.f10780c.p().G(this.f10783g.f10780c.f5104f);
                        b.a.p0.a.e0.a.b(true);
                        b.a.p0.a.e0.d.g("GamesControllerImpl", "init sConsole for devHook");
                    }
                }
                this.f10783g.f10780c.l.c(cVar, this.f10783g.f10780c.f5102d);
                this.f10783g.f10780c.k = cVar.f10740a;
                this.f10783g.f10778a.a(0, cVar);
                this.f10783g.f10780c.d0(cVar.f10742c);
                b.a.p0.h.i0.a.b().e(cVar.f10742c);
            }
        }

        public C0595a(a aVar, b.a.p0.a.a1.b bVar, b.a.p0.a.f1.e.b bVar2) {
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
            this.f10780c = aVar;
            this.f10778a = bVar;
            this.f10779b = bVar2;
        }

        @Override // b.a.p0.a.a1.b
        public void a(int i2, b.a.p0.a.a1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) {
                q0.a0(this.f10780c.m);
                this.f10780c.m = new RunnableC0596a(this, aVar, i2);
                q0.d0(this.f10780c.m);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-864799263, "Lb/a/p0/h/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-864799263, "Lb/a/p0/h/w/a;");
                return;
            }
        }
        o = k.f6397a;
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
        this.l = new b.a.p0.h.r.b();
        this.n = new b.a.p0.h.x.a();
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void E(b.a.p0.a.f1.e.b bVar, b.a.p0.a.a1.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, bVar2) == null) {
            super.E(bVar, bVar2);
            if (o) {
                String str = "asyncLoadSwanApp swanCoreVersion: " + bVar.h0();
            }
            b.a.p0.h.s.a.c(bVar, new C0595a(this, bVar2, bVar));
            b.a.p0.h.o.c.m().I(bVar);
            b.a.p0.h.o.c.m().G(bVar);
            boolean z = o;
            b.a.p0.h.o.c.m().z(null);
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
            if (this.f5105g == null && (viewGroup = (ViewGroup) activity.findViewById(f.ai_apps_activity_root)) != null) {
                SwanAppPropertyWindow swanAppPropertyWindow = new SwanAppPropertyWindow(activity);
                this.f5105g = swanAppPropertyWindow;
                swanAppPropertyWindow.setVisibility(8);
                viewGroup.addView(this.f5105g);
            }
            return this.f5105g;
        }
        return (SwanAppPropertyWindow) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public n K() {
        InterceptResult invokeV;
        b.a.p0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            g S = S();
            if (S == null || (aVar = (b.a.p0.h.n.a) S.n(b.a.p0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.e3();
        }
        return (n) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public SwanCoreVersion L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.a.p0.h.o.c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.N();
            b.a.p0.h.o.c.C();
            b.a.p0.h.a0.b.f10190a.a().d(new JsObject());
            b.a.p0.t.d.j(b.a.p0.a.r0.n.n() + File.separator + "tmp");
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public n O() {
        InterceptResult invokeV;
        b.a.p0.h.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g S = S();
            if (S == null || (aVar = (b.a.p0.h.n.a) S.n(b.a.p0.h.n.a.class)) == null) {
                return null;
            }
            return aVar.c3();
        }
        return (n) invokeV.objValue;
    }

    @Override // b.a.p0.a.g1.b
    @NonNull
    public Pair<Integer, Integer> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? q() : (Pair) invokeV.objValue;
    }

    public final void d0(b.a.p0.h.c0.a.a aVar) {
        b.a.p0.a.a2.e D;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (D = D()) == null) {
            return;
        }
        D.t0(aVar);
    }

    @Override // b.a.p0.a.g1.d
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f5106h : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public FullScreenFloatView m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, activity)) == null) {
            super.m(activity);
            this.f5104f.setAutoAttachEnable(false);
            return this.f5104f;
        }
        return (FullScreenFloatView) invokeL.objValue;
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public b.a.p0.a.p.e.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f5099a == null) {
                this.f5099a = new h(AppRuntime.getAppContext());
                i.h(true);
            }
            this.f5099a.F((ViewGroup) this.f5102d.findViewById(16908290));
            return this.f5099a;
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
            SwanAppActivity swanAppActivity = this.f5102d;
            if (swanAppActivity != null && swanAppActivity.getLaunchInfo() != null) {
                b.a launchInfo = this.f5102d.getLaunchInfo();
                b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
                fVar.f6383a = b.a.p0.a.j2.k.m(1);
                fVar.f6388f = launchInfo.G();
                fVar.f6385c = launchInfo.S();
                fVar.f6384b = "show";
                fVar.d(launchInfo.q0().getString(UBCCloudControlProcessor.UBC_KEY));
                fVar.b(b.a.p0.a.j2.k.k(launchInfo.V()));
                b.a.p0.a.j2.k.onEvent(fVar);
            }
            b.a.p0.a.i1.b.h(true);
            b.a.p0.h.a0.b.f10190a.a().j();
        }
    }

    @Override // b.a.p0.a.g1.b, b.a.p0.a.g1.d
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.w();
            b.a.p0.a.i1.b.h(false);
            b.a.p0.h.a0.b.f10190a.a().f();
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
            SwanAppActivity swanAppActivity = this.f5102d;
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
            Display defaultDisplay = this.f5102d.getWindowManager().getDefaultDisplay();
            if (i3 == 0 || i2 == 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i3 = displayMetrics.widthPixels;
                i2 = displayMetrics.heightPixels;
            }
            if (this.f5102d.isLandScape() == ((defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) ? true : true)) {
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
