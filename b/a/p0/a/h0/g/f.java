package b.a.p0.a.h0.g;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.p.d.q0;
import b.a.p0.a.v2.d0;
import b.a.p0.a.v2.f0;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q;
import b.a.p0.a.z1.b.c.a;
import b.a.p0.k.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class f extends b.a.p0.a.h0.g.d implements a.InterfaceC0478a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public static final int S0;
    public static String T0;
    public static b.a.p0.a.l1.b U0;
    public static String V0;
    public static String W0;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.p0.a.j2.a C0;
    public b.a.p0.a.l1.b D0;
    public b.a.p0.a.l1.b E0;
    public Map<String, b.a.p0.a.p.e.b> F0;
    public FrameLayout G0;
    public b.a.p0.a.p.e.b H0;
    public b.a.p0.a.o2.b.a I0;
    public b.a.p0.a.z1.b.c.a J0;
    public View K0;
    public b.a.p0.a.a2.n.g L0;
    public int M0;
    public b.a.p0.a.h0.j.c N0;
    public q0 O0;
    public boolean P0;
    public boolean Q0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5264e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5264e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5264e.O0 = b.a.p0.a.c1.a.L();
                q0 q0Var = this.f5264e.O0;
                f fVar = this.f5264e;
                q0Var.a(fVar.l0, fVar.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5265a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5265a = fVar;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void onDoubleClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String b2 = this.f5265a.H0.b();
                b.a.p0.a.o0.d.g gVar = new b.a.p0.a.o0.d.g();
                gVar.f7118c = b.a.p0.a.w2.g.c.a.a(b2, "scrollViewBackToTop");
                b.a.p0.a.g1.f.T().l(b2, gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5266e;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5266e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5266e.Q2();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f5267a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5268b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5269c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5270d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5271e;

        public d(f fVar, a.d dVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, dVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5267a = dVar;
            this.f5268b = str;
            this.f5269c = str2;
            this.f5270d = str3;
            this.f5271e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [b.a.p0.a.p.e.c] */
        @Override // b.a.p0.a.h0.t.a.e
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.u.d dVar = new b.a.p0.a.h0.u.d();
                dVar.f5818i = this.f5267a.f5778a.J();
                if (!TextUtils.isEmpty(this.f5268b)) {
                    b.a.p0.a.r1.i.e(this.f5267a, this.f5268b);
                }
                String b2 = b.a.p0.a.c2.f.p0.j.b(this.f5269c);
                dVar.f5810a = this.f5270d;
                if (TextUtils.isEmpty(this.f5271e)) {
                    str = this.f5269c;
                } else {
                    str = this.f5269c + "?" + this.f5271e;
                }
                dVar.f5811b = str;
                if (b.a.p0.a.a2.e.P() != null) {
                    dVar.f5812c = b.a.p0.a.a2.e.P().R(b2);
                    dVar.f5815f = b.a.p0.a.a2.e.P().L(b2);
                }
                dVar.k = b.a.p0.a.h0.u.a.c(b.a.p0.a.a2.e.i(), dVar.f5811b);
                dVar.f5813d = b.a.p0.a.g1.f.T().e(b2).f4010g;
                dVar.f5814e = String.valueOf(b.a.p0.a.e0.a.a());
                dVar.f5816g = f.R0 || b.a.p0.a.g1.f.T().M();
                if (b.a.p0.a.u1.a.a.G()) {
                    dVar.j = b.a.p0.a.e0.f.b.d();
                }
                if (!TextUtils.isEmpty(this.f5268b)) {
                    String str2 = this.f5268b;
                    dVar.f5817h = str2;
                    b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).C(new UbcFlowEvent("slave_dispatch_start"));
                }
                d0.d();
                this.f5267a.f5778a.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f5269c);
                this.f5267a.f5778a.Q(dVar.f5811b);
                b.a.p0.a.g1.f.T().l(this.f5267a.f5778a.b(), b.a.p0.a.h0.u.d.a(dVar));
                if (b.a.p0.a.h0.u.e.b()) {
                    b.a.p0.a.h0.u.e eVar = new b.a.p0.a.h0.u.e();
                    eVar.f5821a = this.f5267a.f5778a.b();
                    b.a.p0.a.g1.f.T().u(b.a.p0.a.h0.u.e.a(eVar));
                }
                b.a.p0.a.j2.e.F(this.f5267a.f5778a.b(), dVar.f5811b);
                if (f.R0) {
                    String str3 = "createSlaveAndLoad onReady. pageEvent: " + dVar.toString();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5272e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f5273e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5273e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5273e.f5272e.Q0 = false;
                    this.f5273e.f5272e.m2(true, false);
                }
            }
        }

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5272e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null || fVar.f4907d || fVar.j != 1) {
                return;
            }
            b.a.p0.a.v2.q0.b0(new a(this));
        }
    }

    /* renamed from: b.a.p0.a.h0.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0209f implements b.a.p0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5274a;

        public C0209f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5274a = fVar;
        }

        @Override // b.a.p0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.f5274a.D3(i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.h0.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5275a;

        public g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5275a = fVar;
        }

        @Override // b.a.p0.a.h0.j.e
        public void a(b.a.p0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.t(this.f5275a.N0);
            eVar.X(this.f5275a.f3());
            b.a.p0.a.m1.g.f().a(eVar);
        }

        @Override // b.a.p0.a.h0.j.e
        public void b(b.a.p0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.T(this.f5275a.N0);
            b.a.p0.a.m1.g.f().b(eVar);
        }
    }

    /* loaded from: classes.dex */
    public class h extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f5276c;

        public h(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5276c = fVar;
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5276c.h2(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f5277a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1800929929, "Lb/a/p0/a/h0/g/f$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1800929929, "Lb/a/p0/a/h0/g/f$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f5277a < 0) {
                    b.a.p0.a.c1.a.Z().getSwitch("swan_app_fragment_destroy_switch", 1);
                    f5277a = 1;
                }
                if (f.R0) {
                    String str = "getFragmentDestroySwitch:" + f5277a;
                }
                return f5277a;
            }
            return invokeV.intValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a() > 0 : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597402990, "Lb/a/p0/a/h0/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597402990, "Lb/a/p0/a/h0/g/f;");
                return;
            }
        }
        R0 = b.a.p0.a.k.f6397a;
        S0 = n0.g(149.0f);
        T0 = "-1";
        V0 = "-1";
    }

    public f() {
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
        this.D0 = new b.a.p0.a.l1.b();
        this.F0 = new TreeMap();
        this.M0 = 0;
        this.P0 = false;
        this.Q0 = false;
    }

    private void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (a0()) {
                pause();
            }
            if (R0) {
                Log.getStackTraceString(new Exception("performPause() wvID: " + this.H0.b()));
            }
        }
    }

    private void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (a0()) {
                resume();
            }
            n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.x(b.a.p0.a.c1.a.H().a());
            }
            if (R0) {
                Log.getStackTraceString(new Exception("performResume() wvID: " + this.H0.b()));
            }
        }
    }

    public static f t3(b.a.p0.a.l1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cVar)) == null) {
            f fVar = new f();
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", cVar.i());
                fVar.d1(bundle);
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static void y3(b.a.p0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, bVar) == null) {
            try {
                if (R0) {
                    String str = "setLastPageParams =" + bVar;
                }
                if (bVar == null) {
                    U0 = null;
                } else {
                    U0 = (b.a.p0.a.l1.b) bVar.clone();
                }
            } catch (Exception e2) {
                if (R0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void z3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            W0 = str;
        }
    }

    public void A3(b.a.p0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (R0) {
                String str = "switchTab pageParam: " + bVar;
            }
            if (this.I0.o(T2().h()) == this.I0.o(bVar.h())) {
                return;
            }
            this.I0.E(bVar.h());
            onPause();
            S2(bVar, "");
        }
    }

    public final void B3(String str) {
        b.a.p0.a.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.H0 == (bVar = this.F0.get(str)) || bVar == null) {
            return;
        }
        b.a.p0.a.a2.n.g e2 = b.a.p0.a.g1.f.T().e(str);
        bVar.z(this.G0, e2);
        if (!bVar.d()) {
            bVar.O(this.G0, e2);
        }
        bVar.D(0);
        b.a.p0.a.p.e.b bVar2 = this.H0;
        if (bVar2 != null) {
            bVar2.D(8);
        }
        this.H0 = bVar;
        bVar.h(this.D0);
    }

    public final void C3(b.a.p0.a.p.e.b bVar) {
        b.a.p0.a.h0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (cVar = this.N0) == null || bVar == null) {
            return;
        }
        bVar.T(cVar);
        if (bVar.k() != null) {
            bVar.T(this.N0);
        }
    }

    public final void D3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - S0) * 1.0f;
            int i3 = this.M0;
            if (i3 == 0) {
                i3 = 1;
            }
            float f4 = f3 / i3;
            if (f4 <= 0.0f) {
                f2 = 0.0f;
            } else if (f4 < 1.0f) {
                f2 = f4;
            }
            int i4 = (int) (255.0f * f2);
            if (R0 && i4 != 0 && i4 != 255) {
                String str = "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4;
            }
            b.a.p0.a.w2.d.b bVar = this.s0;
            if (bVar != null && bVar.i() && (e2 = this.s0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.n0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            b.a.p0.a.a2.n.g gVar = this.L0;
            if (gVar != null && gVar.f4012i && (centerTitleView = this.n0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.q0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void E3() {
        b.a.p0.a.l1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.l0) == null) {
            return;
        }
        cVar.j();
    }

    public final void F3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            int i3 = 0;
            if (z) {
                b.a.p0.a.w2.d.b bVar = this.s0;
                if (bVar != null && bVar.i()) {
                    i2 = n0.u();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.G0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.G0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.m0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.m0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = A1().getDimensionPixelSize(b.a.p0.a.d.aiapps_normal_base_action_bar_height);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.G0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.G0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.m0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.m0.setLayoutParams(layoutParams22);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if ((getFloatLayer() == null || !getFloatLayer().c()) && !b.a.d0.a.j()) {
                b.a.p0.a.p.e.b bVar = this.H0;
                if (bVar != null) {
                    if (b.a.p0.a.i1.b.g(bVar.b())) {
                        return true;
                    }
                    return this.H0.I();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void K1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            super.K1(view);
            boolean z = false;
            j2(P1() || l3());
            if (p3()) {
                U1();
            }
            u3();
            this.n0.setOnDoubleClickListener(new b(this));
            if (!b.a.p0.a.j2.e.i()) {
                b.a.p0.a.j2.e.d(b.a.p0.a.a2.d.g().r().K());
            }
            if (n3() && l3()) {
                z = true;
            }
            this.Q0 = z;
            if (z) {
                M2();
            }
        }
    }

    public final void K2(b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        b.a.p0.a.h0.j.c cVar = this.N0;
        if (cVar != null) {
            bVar.t(cVar);
        }
        bVar.Y(g3());
    }

    public final void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.C0 = b.a.p0.a.j2.k.c("805");
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.p0.a.a2.d.g().r().S().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final b.a.p0.a.p.e.b N2(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, str2, str3, str4)) == null) {
            boolean z = R0;
            a.d f2 = b.a.p0.a.h0.t.a.f(getActivity());
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
                q.C(new UbcFlowEvent("na_pre_load_slave_check"));
                q.A("preload", f2.f5779b ? "1" : "0");
            }
            if (R0) {
                String str5 = "createSlaveAndLoad preloadManager: " + f2;
            }
            b.a.p0.a.h0.t.a.n(f2, new d(this, f2, str4, str2, str, str3));
            boolean z2 = R0;
            return f2.f5778a;
        }
        return (b.a.p0.a.p.e.b) invokeLLLL.objValue;
    }

    public final void O2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            b.a.p0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
            String f2 = this.l0.f();
            String h2 = this.l0.h();
            String g2 = this.l0.g();
            String a2 = b.a.p0.a.v2.q0.a(f2, g2, h2);
            this.H0 = b.a.p0.a.h0.t.a.h(a2);
            if (R0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                sb.append(this.H0 != null);
                sb.toString();
            }
            if (this.H0 == null) {
                if (R0) {
                    Log.getStackTraceString(new Exception("createSlaveWebView failed."));
                }
                this.H0 = N2(f2, g2, h2, "");
            }
            this.H0.h(this.D0);
            b.a.p0.a.a2.n.g e2 = b.a.p0.a.g1.f.T().e(g2);
            b.a.p0.a.e0.d.g("SwanAppFragment", "create slave webview: " + g2);
            this.H0.z(this.G0, e2);
            this.H0.O(this.G0, e2);
            i3(g2);
            K2(this.H0);
            if (T1()) {
                this.F0.put(g2, this.H0);
                this.I0.f(view, getContext(), g2);
            }
            b.a.p0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
            L2();
        }
    }

    public final void P2(b.a.p0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, bVar, str) == null) && this.F0.get(bVar.f6558h) == null) {
            String a2 = b.a.p0.a.v2.q0.a(bVar.f6557g, bVar.f6555e, bVar.f6556f);
            b.a.p0.a.p.e.b h2 = b.a.p0.a.h0.t.a.h(a2);
            if (h2 != null) {
                if (R0) {
                    String str2 = "createTabSlaveWebView loaded manager pageUrl: " + a2;
                }
                this.F0.put(bVar.f6555e, h2);
            } else {
                boolean z = R0;
                h2 = N2(bVar.f6557g, bVar.f6555e, bVar.f6556f, str);
                this.F0.put(bVar.f6555e, h2);
            }
            i3(bVar.f6555e);
            K2(h2);
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Map<String, b.a.p0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (b.a.p0.a.p.e.b bVar : this.F0.values()) {
                    if (bVar != null) {
                        C3(bVar);
                        bVar.destroy();
                    }
                }
                this.F0.clear();
            } else {
                b.a.p0.a.p.e.b bVar2 = this.H0;
                if (bVar2 != null) {
                    C3(bVar2);
                    this.H0.destroy();
                }
            }
            this.H0 = null;
            if (R0) {
                String str = "onDestroy() obj: " + this;
            }
            if (this.P0) {
                return;
            }
            b.a.p0.a.h0.t.a.l(b.a.p0.a.g1.f.T().getActivity());
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.L0.j = "default";
            n1();
            u3();
        }
    }

    public void S2(b.a.p0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, bVar, str) == null) {
            y3(this.D0);
            this.E0 = U0;
            if (R0) {
                String str2 = "doSwitchTab mPrePageParams=" + this.E0;
            }
            String str3 = bVar.f6555e;
            String str4 = bVar.f6558h;
            b.a.p0.a.a2.n.g e2 = b.a.p0.a.g1.f.T().e(TextUtils.isEmpty(str4) ? "" : str4);
            b.a.p0.a.l1.b bVar2 = this.D0;
            bVar2.f6555e = str3;
            bVar2.f6556f = bVar != null ? bVar.g() : "";
            this.D0.f6558h = str4;
            this.L0 = e2;
            boolean z = !r3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    b.a.p0.a.r1.i.c(7, str);
                } else {
                    b.a.p0.a.r1.i.c(6, str);
                }
            }
            if (!z) {
                B3(str4);
            } else {
                P2(bVar, str);
                B3(str3);
            }
            if (!TextUtils.isEmpty(str)) {
                b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
                b.a.p0.a.r1.i.a(str, bVar);
            }
            h2(e2.f4005b);
            n2(SwanAppConfigData.s(e2.f4006c));
            f2(e2.f4004a);
            u3();
            E3();
            b.a.p0.a.e0.d.g("SwanAppFragment", "switch tab title: " + e2.f4005b + " page:" + str3);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean T1() {
        InterceptResult invokeV;
        SwanAppConfigData r;
        b.a.p0.a.l1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
            if (T == null || (r = T.r()) == null || !r.m() || (cVar = this.l0) == null) {
                return false;
            }
            return r.q(cVar.g());
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public b.a.p0.a.l1.b T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.D0 : (b.a.p0.a.l1.b) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [b.a.p0.a.p.e.c] */
    @NonNull
    public Pair<Integer, Integer> U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            b.a.p0.a.p.e.b bVar = this.H0;
            if (bVar == null) {
                return new Pair<>(0, 0);
            }
            AbsoluteLayout currentWebView = bVar.s().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public b.a.p0.a.p.e.b V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.H0 : (b.a.p0.a.p.e.b) invokeV.objValue;
    }

    public final int W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? S1() ? q3() ? 18 : 17 : q3() ? 12 : 15 : invokeV.intValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            F1();
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6387e = "gohome";
            fVar.f6385c = "bar";
            f H = b.a.p0.a.g1.f.T().H();
            b.a.p0.a.l1.c E1 = H == null ? null : H.E1();
            if (E1 != null && !TextUtils.isEmpty(E1.g())) {
                fVar.a("page", E1.g());
            }
            s1(fVar);
        }
    }

    public final void X2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && b.a.p0.a.c1.a.G().i(z, 2)) {
            b.a.p0.a.k1.a.l(getContext(), this.o0, b.a.p0.a.a2.e.P().K().e0().paNumber);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.H0.S();
            j3();
            X2(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.p0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(b.a.p0.a.j0.b.a.n(b.a.p0.a.a2.d.g().getAppId()));
            }
            this.o0.r(b.a.p0.a.c1.a.H().a(), y1(), this.p0, false);
        }
    }

    @Nullable
    public b.a.p0.a.l1.b Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.E0 : (b.a.p0.a.l1.b) invokeV.objValue;
    }

    public final void Z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (b.a.p0.a.c1.a.G().i(z, 1)) {
                b.a.p0.a.k1.a.k(getContext(), this.n0, b.a.p0.a.a2.e.P().K().e0().paNumber);
            } else if (b.a.p0.a.a2.e.P() == null) {
            } else {
                b.a.p0.a.k1.a.o(this.n0, b.a.p0.a.a2.e.P().I().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    public String a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            b.a.p0.a.p.e.b bVar = this.H0;
            return bVar != null ? bVar.b() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<String> b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, b.a.p0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, b.a.p0.a.p.e.b> entry : this.F0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().b());
                    }
                }
            }
            b.a.p0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                String b2 = bVar.b();
                if (!arrayList.contains(b2)) {
                    arrayList.add(b2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.c2();
            u3();
        }
    }

    @Nullable
    public b.a.p0.a.o2.b.a c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.I0 : (b.a.p0.a.o2.b.a) invokeV.objValue;
    }

    public String d3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (this.F0.containsKey(str)) {
                return this.F0.get(str).b();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public FrameLayout e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.G0 : (FrameLayout) invokeV.objValue;
    }

    public PullToRefreshBaseWebView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            b.a.p0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                return bVar.f0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean f2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            boolean f2 = super.f2(i2);
            u3();
            return f2;
        }
        return invokeI.booleanValue;
    }

    public final b.a.p0.a.h0.j.a f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? new h(this) : (b.a.p0.a.h0.j.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && k0()) {
            super.g1(z);
            if (R0) {
                String str = "setUserVisibleHint isVisibleToUser: " + z;
            }
            if (z) {
                resume();
                Z2(false);
                return;
            }
            pause();
        }
    }

    public final b.a.p0.a.h0.j.e g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? new g(this) : (b.a.p0.a.h0.j.e) invokeV.objValue;
    }

    @Override // b.a.p0.a.z1.b.c.a.InterfaceC0478a
    public b.a.p0.a.z1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.J0 == null) {
                if (this.K0 == null) {
                    return null;
                }
                this.J0 = new b.a.p0.a.z1.b.c.a(this, (LinearLayout) this.K0.findViewById(b.a.p0.a.f.ai_apps_fragment_base_view), A1().getDimensionPixelOffset(b.a.p0.a.d.aiapps_normal_base_action_bar_height));
            }
            return this.J0;
        }
        return (b.a.p0.a.z1.b.c.a) invokeV.objValue;
    }

    public final void h3() {
        b.a.p0.a.y0.j.b D0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            b.a.p0.a.p.e.b V2 = V2();
            if (!(V2 instanceof SwanAppWebViewManager) || (D0 = ((SwanAppWebViewManager) V2).D0()) == null) {
                return;
            }
            D0.d();
        }
    }

    public final void i3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || n3()) {
            return;
        }
        b.a.p0.a.g1.f T = b.a.p0.a.g1.f.T();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (T.e(str).f4011h && this.N0 == null) {
            this.N0 = new C0209f(this);
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, motionEvent)) == null) ? P1() && this.H0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    @DebugTrace
    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.p0 == null) {
                this.p0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.o0 != null) {
                return;
            }
            this.o0 = new n(activity, this.n0, W2(), b.a.p0.a.c1.a.G(), new b.a.p0.a.w2.h.b());
            new b.a.p0.a.j1.a(this.o0, this, this.p0).z();
            if (b.a.p0.a.j1.e.b.d()) {
                this.o0.j(50);
            }
        }
    }

    public boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            b.a.p0.a.o2.b.a aVar = this.I0;
            if (aVar == null) {
                return false;
            }
            return aVar.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            SwanAppConfigData r = b.a.p0.a.g1.f.T().r();
            boolean z = false;
            if (r == null) {
                return false;
            }
            return !((TextUtils.equals(r.e(), this.D0.f6555e) || r.q(this.D0.f6555e)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            b.a.p0.a.a2.n.g gVar = this.L0;
            return gVar != null && gVar.f4011h;
        }
        return invokeV.booleanValue;
    }

    public boolean n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            b.a.p0.a.a2.n.g gVar = this.L0;
            if (gVar != null) {
                return TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void o1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            if (!b.a.p0.a.a2.n.g.f(this.L0)) {
                super.o1(i2);
                return;
            }
            p1(i2, n3() ? true : true ^ f0.h(this.k0));
            u3();
        }
    }

    public final boolean o3(b.a.p0.a.h0.g.g gVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048625, this, gVar, swanAppConfigData)) == null) {
            b.a.p0.a.h0.g.d j = gVar.j(0);
            if (j == null || !(j instanceof f)) {
                return false;
            }
            String f2 = ((f) j).T2().f();
            return swanAppConfigData.q(f2) || TextUtils.equals(swanAppConfigData.e(), f2);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bundle) == null) {
            super.onCreate(bundle);
            v3();
            if (R0) {
                String str = "onCreate() obj: " + this;
            }
            q.i(new a(this), "SwanAppPageHistory");
            b.a.p0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onDestroy();
            if (i.b()) {
                b.a.p0.a.v2.q0.q().postAtFrontOfQueue(new c(this));
            } else {
                Q2();
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPause();
            V0();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onResume();
            Y0();
            Z2(false);
        }
    }

    public final boolean p3() {
        InterceptResult invokeV;
        SwanAppConfigData r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            b.a.p0.a.h0.g.g D1 = D1();
            if (D1 == null) {
                return false;
            }
            b.a.p0.a.a2.n.g gVar = this.L0;
            if ((gVar != null && gVar.k) || (r = b.a.p0.a.g1.f.T().r()) == null) {
                return false;
            }
            return !o3(D1, r);
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        PullToRefreshBaseWebView f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            boolean z = this.H0 == null;
            String b2 = z ? "" : this.H0.b();
            if (R0) {
                String str = "pause() wvID: " + b2;
            }
            if (!z) {
                this.H0.onPause();
                w3("onHide");
                b.a.p0.a.m1.g.f().k(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c()) {
                getFloatLayer().f();
            }
            b.a.p0.a.e0.d.g("SwanApp", "onHide");
            b.a.p0.a.i1.b.i(false);
            if (!z && (f0 = this.H0.f0()) != null) {
                f0.onPullDownRefreshComplete(false);
            }
            b.a.p0.a.c1.a.D().f(b.a.p0.a.a2.e.P() != null ? b.a.p0.a.a2.e.P().k() : "");
        }
    }

    public final boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            SwanAppConfigData r = b.a.p0.a.g1.f.T().r();
            return (r == null || TextUtils.equals(r.e(), this.D0.f())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, activity) == null) {
            super.r0(activity);
            if (R0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }

    public final boolean r3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) ? (this.F0.isEmpty() || this.F0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            boolean z = false;
            boolean z2 = this.H0 == null;
            String b2 = z2 ? "" : this.H0.b();
            if (R0) {
                String str = "resume() wvID: " + b2;
            }
            if (!z2) {
                j2((P1() || l3()) ? true : true);
                this.H0.onResume();
                x3();
                w3("onShow");
                b.a.p0.a.m1.g.f().k(true);
            }
            b.a.p0.a.e0.d.g("SwanApp", "onShow");
            b.a.p0.a.i1.b.i(true);
            if (b.a.p0.a.e0.d.d()) {
                b.a.p0.a.h0.e.b.b();
            }
            b.a.p0.a.c1.a.D().e(b.a.p0.a.a2.e.P() != null ? b.a.p0.a.a2.e.P().k() : "");
        }
    }

    public void s3(b.a.p0.a.j2.p.g gVar) {
        b.a.p0.a.j2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048636, this, gVar) == null) || (aVar = this.C0) == null) {
            return;
        }
        b.a.p0.a.j2.k.i(aVar, gVar);
        this.C0 = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u3() {
        int i2;
        b.a.p0.a.a2.n.g gVar;
        b.a.p0.a.p.e.c cVar;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || this.n0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (n3()) {
            m2(true, this.Q0);
            i2 = 0;
        } else if (m3()) {
            m2(false, false);
            b.a.p0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                if (bVar.k() != null) {
                    cVar = this.H0.k().s();
                } else {
                    cVar = this.H0.s();
                }
                if (cVar != null) {
                    i2 = cVar.getWebViewScrollY();
                    gVar = this.L0;
                    if (gVar != null && gVar.f4012i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            gVar = this.L0;
            if (gVar != null) {
                i3 = 0;
            }
        } else {
            m2(false, false);
            i2 = S0 + this.M0;
            centerTitleView = this.n0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            D3(i2);
            F3(z);
        }
        z = true;
        centerTitleView = this.n0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        D3(i2);
        F3(z);
    }

    public final void v3() {
        Bundle n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (n = n()) == null) {
            return;
        }
        this.E0 = U0;
        if (R0) {
            String str = "restoreArguments sPrePageParams=" + this.E0;
        }
        b.a.p0.a.l1.c e2 = b.a.p0.a.l1.c.e(n.getString("ai_apps_param"));
        this.l0 = e2;
        this.D0.f6555e = e2 != null ? e2.g() : "";
        b.a.p0.a.l1.b bVar = this.D0;
        b.a.p0.a.l1.c cVar = this.l0;
        bVar.f6556f = cVar != null ? cVar.h() : "";
        b.a.p0.a.l1.b bVar2 = this.D0;
        bVar2.f6558h = b.a.p0.a.c2.f.p0.j.b(bVar2.f());
        b.a.p0.a.a2.n.g e3 = b.a.p0.a.g1.f.T().e(this.D0.h());
        this.L0 = e3;
        if (e3.p) {
            this.L0 = b.a.p0.a.g1.f.T().i(this.D0.f());
        }
        this.M0 = A1().getDimensionPixelSize(b.a.p0.a.d.aiapps_normal_base_action_bar_height);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048639, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.p0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
            View b2 = b.a.p0.a.r1.n.a.a().b(b.a.p0.a.g.aiapps_fragment, viewGroup, false);
            this.G0 = (FrameLayout) b2.findViewById(b.a.p0.a.f.ai_apps_fragment_content);
            K1(b2);
            this.I0 = new b.a.p0.a.o2.b.a(this);
            O2(b2);
            if (!b.a.p0.a.j1.e.b.d() && !b.a.p0.a.j1.e.b.e()) {
                b.a.p0.a.j1.e.a.b(this.H0.b(), String.valueOf(b.a.p0.a.j1.e.b.c()), String.valueOf(b.a.p0.a.j1.e.b.a(b.a.p0.a.j1.e.b.b())));
            }
            if (J1()) {
                b2 = M1(b2);
            }
            this.K0 = u1(b2, this);
            this.u0.setRegionFactor(this.H0.A());
            b.a.p0.a.m1.g.f().o();
            return this.K0;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.H0 == null) {
                if (R0) {
                    Log.getStackTraceString(new Exception("mCurWebViewManager is null."));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0.b());
            b.a.p0.a.p.e.e k = this.H0.k();
            if (k != null) {
                hashMap.put("webViewUrl", k.getCurrentPageUrl());
            }
            b.a.p0.a.g1.f.T().u(new b.a.p0.a.o0.d.b("sharebtn", hashMap));
        }
    }

    public final void w3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0.b());
            b.a.p0.a.o0.d.c cVar = new b.a.p0.a.o0.d.c(hashMap);
            if (R0) {
                String str2 = "sendLifecycleMessage type: " + str + " wvID: " + this.H0.b();
            }
            b.a.p0.a.g1.f.T().u(cVar);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public b.a.p0.a.a2.n.g x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.L0 : (b.a.p0.a.a2.n.g) invokeV.objValue;
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            if (!TextUtils.equals(V0, this.H0.b()) || TextUtils.equals(W0, "switchTab")) {
                int o = this.I0.o(T2().h());
                b.a.p0.a.o0.d.e eVar = new b.a.p0.a.o0.d.e();
                eVar.f7111c = V0;
                eVar.f7112d = this.H0.b();
                eVar.f7113e = W0;
                eVar.f7114f = this.D0.f6555e;
                eVar.f7115g = String.valueOf(o);
                W0 = "";
                if (R0) {
                    String str = "sendRouteMessage fromId: " + eVar.f7111c + " ,toId: " + eVar.f7112d + " ,RouteType: " + eVar.f7113e + " page:" + eVar.f7114f + ",TabIndex: " + eVar.f7115g;
                }
                b.a.p0.a.g1.f.T().u(eVar);
                V0 = this.H0.b();
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            super.y0();
            Map<String, b.a.p0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (b.a.p0.a.p.e.b bVar : this.F0.values()) {
                    if (bVar != null) {
                        bVar.d0();
                    }
                }
            } else {
                b.a.p0.a.p.e.b bVar2 = this.H0;
                if (bVar2 != null) {
                    bVar2.d0();
                }
            }
            h3();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            super.z0();
        }
    }
}
