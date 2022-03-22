package c.a.n0.a.x.g;

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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.f.d.u0;
import c.a.n0.a.p2.d0;
import c.a.n0.a.p2.f0;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s1.b.c.a;
import c.a.n0.a.x.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class f extends c.a.n0.a.x.g.d implements a.InterfaceC0451a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean V0;
    public static final int W0;
    public static String X0;
    public static c.a.n0.a.c1.b Y0;
    public static String Z0;
    public static String a1;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.d2.a F0;
    public c.a.n0.a.c1.b G0;
    public c.a.n0.a.c1.b H0;
    public Map<String, c.a.n0.a.f.e.b> I0;
    public FrameLayout J0;
    public c.a.n0.a.f.e.b K0;
    public c.a.n0.a.i2.b.a L0;
    public c.a.n0.a.s1.b.c.a M0;
    public View N0;
    public c.a.n0.a.t1.n.g O0;
    public int P0;
    public c.a.n0.a.x.j.c Q0;
    public u0 R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.R0 = c.a.n0.a.s0.a.Q();
                u0 u0Var = this.a.R0;
                f fVar = this.a;
                u0Var.a(fVar.h0, fVar.j0, fVar.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String c2 = this.a.K0.c();
                c.a.n0.a.e0.d.h hVar = new c.a.n0.a.e0.d.h();
                hVar.f4243c = c.a.n0.a.q2.g.c.a.a(c2, "scrollViewBackToTop");
                c.a.n0.a.w0.f.U().m(c2, hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7040b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7041c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7042d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7043e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f7044f;

        public d(f fVar, a.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7044f = fVar;
            this.a = eVar;
            this.f7040b = str;
            this.f7041c = str2;
            this.f7042d = str3;
            this.f7043e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [c.a.n0.a.f.e.c] */
        @Override // c.a.n0.a.x.t.a.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.x.u.d dVar = new c.a.n0.a.x.u.d();
                dVar.i = this.a.a.M();
                if (!TextUtils.isEmpty(this.f7040b)) {
                    c.a.n0.a.k1.i.e(this.a, this.f7040b);
                }
                String b2 = c.a.n0.a.v1.f.o0.j.b(this.f7041c);
                dVar.a = this.f7042d;
                if (TextUtils.isEmpty(this.f7043e)) {
                    str = this.f7041c;
                } else {
                    str = this.f7041c + "?" + this.f7043e;
                }
                dVar.f7474b = str;
                if (c.a.n0.a.t1.e.a0() != null) {
                    dVar.f7475c = c.a.n0.a.t1.e.a0().c0(b2);
                    dVar.f7478f = c.a.n0.a.t1.e.a0().W(b2);
                }
                dVar.k = c.a.n0.a.x.u.a.c(c.a.n0.a.t1.e.L(), dVar.f7474b);
                dVar.f7476d = c.a.n0.a.w0.f.U().f(b2).f6384g;
                dVar.f7477e = String.valueOf(c.a.n0.a.u.a.a());
                dVar.f7479g = f.V0 || c.a.n0.a.w0.f.U().N();
                if (c.a.n0.a.n1.a.a.H()) {
                    dVar.j = c.a.n0.a.u.f.b.d();
                }
                if (!TextUtils.isEmpty(this.f7040b)) {
                    String str2 = this.f7040b;
                    dVar.f7480h = str2;
                    c.a.n0.a.k1.h.q("route", str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                d0.d();
                this.a.a.u().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f7041c);
                this.a.a.U(dVar.f7474b);
                c.a.n0.a.w0.f.U().m(this.a.a.c(), c.a.n0.a.x.u.d.a(dVar));
                if (c.a.n0.a.x.u.e.b()) {
                    c.a.n0.a.x.u.e eVar = new c.a.n0.a.x.u.e();
                    eVar.a = this.a.a.c();
                    c.a.n0.a.w0.f.U().u(c.a.n0.a.x.u.e.a(eVar));
                }
                c.a.n0.a.d2.e.F(this.a.a.c(), dVar.f7474b);
                if (f.V0) {
                    Log.d("SwanAppFragment", "createSlaveAndLoad onReady. pageEvent: " + dVar.toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.T0 = false;
                    this.a.a.z2(true, false);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null || fVar.f7640d || fVar.j != 1) {
                return;
            }
            q0.e0(new a(this));
        }
    }

    /* renamed from: c.a.n0.a.x.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0531f implements c.a.n0.a.x.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public C0531f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.n0.a.x.j.c
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
                this.a.W3(i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.n0.a.x.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public g(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.n0.a.x.j.e
        public void a(c.a.n0.a.f.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.v(this.a.Q0);
            eVar.c0(this.a.w3());
            c.a.n0.a.d1.h.e().a(eVar);
        }

        @Override // c.a.n0.a.x.j.e
        public void b(c.a.n0.a.f.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.X(this.a.Q0);
            c.a.n0.a.d1.h.e().b(eVar);
        }
    }

    /* loaded from: classes.dex */
    public class h extends c.a.n0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f7045c;

        public h(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7045c = fVar;
        }

        @Override // c.a.n0.a.x.j.a, c.a.n0.a.x.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f7045c.t2(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1594216700, "Lc/a/n0/a/x/g/f$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1594216700, "Lc/a/n0/a/x/g/f$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    c.a.n0.a.s0.a.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (f.V0) {
                    Log.d("SwanAppFragment", "getFragmentDestroySwitch:" + a);
                }
                return a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-622887255, "Lc/a/n0/a/x/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-622887255, "Lc/a/n0/a/x/g/f;");
                return;
            }
        }
        V0 = c.a.n0.a.a.a;
        W0 = n0.g(149.0f);
        X0 = "-1";
        Z0 = "-1";
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
        this.G0 = new c.a.n0.a.c1.b();
        this.I0 = new TreeMap();
        this.P0 = 0;
        this.S0 = false;
        this.T0 = false;
        this.U0 = false;
    }

    public static f K3(c.a.n0.a.c1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            f fVar = new f();
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", cVar.m());
                fVar.h1(bundle);
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static void Q3(c.a.n0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            try {
                if (V0) {
                    Log.d("SwanAppFragment", "setLastPageParams =" + bVar);
                }
                if (bVar == null) {
                    Y0 = null;
                } else {
                    Y0 = (c.a.n0.a.c1.b) bVar.clone();
                }
            } catch (Exception e2) {
                if (V0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void S3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a1 = str;
        }
    }

    private void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (O()) {
                pause();
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performPause() wvID: " + this.K0.c())));
            }
        }
    }

    private void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (O()) {
                resume();
            }
            c.a.n0.n.f fVar = this.m0;
            if (fVar != null && fVar.j()) {
                this.m0.C(c.a.n0.a.s0.a.M().a());
            }
            if (V0) {
                Log.d("SwanAppFragment", Log.getStackTraceString(new Exception("performResume() wvID: " + this.K0.c())));
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            Map<String, c.a.n0.a.f.e.b> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (c.a.n0.a.f.e.b bVar : this.I0.values()) {
                    if (bVar != null) {
                        bVar.h0();
                    }
                }
            } else {
                c.a.n0.a.f.e.b bVar2 = this.K0;
                if (bVar2 != null) {
                    bVar2.h0();
                }
            }
            y3();
        }
    }

    @DebugTrace
    public void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.n0 == null) {
                this.n0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.m0 != null) {
                return;
            }
            this.m0 = new c.a.n0.n.f(activity, this.l0, n3(), c.a.n0.a.s0.a.K(), new c.a.n0.a.q2.h.b());
            new c.a.n0.a.a1.a(this.m0, this, this.n0).z();
            if (c.a.n0.a.a1.f.b.e()) {
                this.m0.m(50);
            }
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.B0();
        }
    }

    public boolean B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.n0.a.i2.b.a aVar = this.L0;
            if (aVar == null) {
                return false;
            }
            return aVar.p();
        }
        return invokeV.booleanValue;
    }

    public final boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SwanAppConfigData s = c.a.n0.a.w0.f.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.G0.a) || s.r(this.G0.a)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public final boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.n0.a.t1.n.g gVar = this.O0;
            return gVar != null && gVar.f6385h;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.g.d
    public c.a.n0.a.t1.n.g E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.O0 : (c.a.n0.a.t1.n.g) invokeV.objValue;
    }

    public boolean E3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.a.n0.a.t1.n.g gVar = this.O0;
            if (gVar != null) {
                return TextUtils.equals(gVar.j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean F3(c.a.n0.a.x.g.g gVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar, swanAppConfigData)) == null) {
            c.a.n0.a.x.g.d j = gVar.j(0);
            if (j == null || !(j instanceof f)) {
                return false;
            }
            String e2 = ((f) j).k3().e();
            return swanAppConfigData.r(e2) || TextUtils.equals(swanAppConfigData.f(), e2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean G3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c.a.n0.a.x.g.g K1 = K1();
            if (K1 == null) {
                return false;
            }
            c.a.n0.a.t1.n.g gVar = this.O0;
            if ((gVar != null && gVar.k) || (s = c.a.n0.a.w0.f.U().s()) == null) {
                return false;
            }
            return !F3(K1, s);
        }
        return invokeV.booleanValue;
    }

    public final boolean H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SwanAppConfigData s = c.a.n0.a.w0.f.U().s();
            return (s == null || TextUtils.equals(s.f(), this.G0.e())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean I3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? (this.I0.isEmpty() || this.I0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void J3(c.a.n0.a.d2.s.g gVar) {
        c.a.n0.a.d2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) || (aVar = this.F0) == null) {
            return;
        }
        n.i(aVar, gVar);
        this.F0 = null;
    }

    @Override // c.a.n0.a.x.g.d
    public void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.c());
            c.a.n0.a.f.e.e m = this.K0.m();
            if (m != null) {
                hashMap.put("webViewUrl", m.getCurrentPageUrl());
            }
            c.a.n0.a.w0.f.U().u(new c.a.n0.a.e0.d.c("sharebtn", hashMap));
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().e() && getFloatLayer().f()) {
                return true;
            }
            if ((getFloatLayer() == null || !getFloatLayer().c()) && !PaymentManager.k()) {
                c.a.n0.a.f.e.b bVar = this.K0;
                if (bVar != null) {
                    if (c.a.n0.a.z0.b.g(bVar.c())) {
                        return true;
                    }
                    return this.K0.L();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L3() {
        int i2;
        c.a.n0.a.t1.n.g gVar;
        c.a.n0.a.f.e.c cVar;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.l0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (E3()) {
            z2(true, this.T0);
            i2 = 0;
        } else if (D3()) {
            z2(false, false);
            c.a.n0.a.f.e.b bVar = this.K0;
            if (bVar != null) {
                if (bVar.m() != null) {
                    cVar = this.K0.m().u();
                } else {
                    cVar = this.K0.u();
                }
                if (cVar != null) {
                    i2 = cVar.getWebViewScrollY();
                    gVar = this.O0;
                    if (gVar != null && gVar.i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            gVar = this.O0;
            if (gVar != null) {
                i3 = 0;
            }
        } else {
            z2(false, false);
            i2 = W0 + this.P0;
            centerTitleView = this.l0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            W3(i2);
            Y3(z);
        }
        z = true;
        centerTitleView = this.l0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        W3(i2);
        Y3(z);
    }

    public final void M3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (p = p()) == null) {
            return;
        }
        this.H0 = Y0;
        if (V0) {
            Log.d("SwanAppFragment", "restoreArguments sPrePageParams=" + this.H0);
        }
        c.a.n0.a.c1.c g2 = c.a.n0.a.c1.c.g(p.getString("ai_apps_param"));
        this.j0 = g2;
        if (g2 == null) {
            c.a.n0.a.c1.b bVar = this.G0;
            bVar.a = "";
            bVar.f3947b = "";
            bVar.f3950e = "";
            bVar.f3951f = "";
        } else {
            this.G0.a = g2.i();
            this.G0.f3947b = this.j0.j();
            this.G0.f3950e = this.j0.l();
            this.G0.f3951f = this.j0.k();
        }
        c.a.n0.a.c1.b bVar2 = this.G0;
        bVar2.f3949d = c.a.n0.a.v1.f.o0.j.b(bVar2.e());
        c.a.n0.a.t1.n.g f2 = c.a.n0.a.w0.f.U().f(this.G0.g());
        this.O0 = f2;
        if (f2.p) {
            this.O0 = c.a.n0.a.w0.f.U().j(this.G0.e());
        }
        if (this.D0) {
            c.a.n0.a.t1.n.g gVar = this.O0;
            gVar.f6383f = false;
            gVar.f6385h = true;
            gVar.p = true;
        }
        this.P0 = H1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07015b);
    }

    public final void N3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.K0.c());
            c.a.n0.a.e0.d.d dVar = new c.a.n0.a.e0.d.d(hashMap);
            if (V0) {
                Log.d("SwanAppFragment", "sendLifecycleMessage type: " + str + " wvID: " + this.K0.c());
            }
            c.a.n0.a.w0.f.U().u(dVar);
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!TextUtils.equals(Z0, this.K0.c()) || TextUtils.equals(a1, "switchTab")) {
                int o = this.L0.o(k3().g());
                c.a.n0.a.e0.d.f fVar = new c.a.n0.a.e0.d.f();
                fVar.f4236c = Z0;
                fVar.f4237d = this.K0.c();
                fVar.f4238e = a1;
                fVar.f4239f = this.G0.a;
                fVar.f4240g = String.valueOf(o);
                a1 = "";
                if (V0) {
                    Log.d("SwanAppFragment", "sendRouteMessage fromId: " + fVar.f4236c + " ,toId: " + fVar.f4237d + " ,RouteType: " + fVar.f4238e + " page:" + fVar.f4239f + ",TabIndex: " + fVar.f4240g);
                }
                c.a.n0.a.w0.f.U().u(fVar);
                Z0 = this.K0.c();
            }
        }
    }

    public void P3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.U0 = z;
        }
    }

    public final void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "setting immersive portrait fullscreen video");
            }
            c.a.n0.a.p2.d.h();
            if (this.i0.getWindow() != null) {
                this.i0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = c.a.n0.a.s1.b.a.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.obfuscated_res_0x7f092056).setVisibility(8);
            }
            SwanAppActionBar I1 = I1();
            if (I1 != null) {
                I1.setRightMenuStyle();
                I1.setRightZoneImmersiveStyle();
                I1.setBackgroundColor(0);
            }
            View Q = Q();
            if (Q != null) {
                Q.findViewById(R.id.obfuscated_res_0x7f090ee7).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) Q.findViewById(R.id.obfuscated_res_0x7f09017a);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // c.a.n0.a.x.g.d
    public void S1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view) == null) {
            super.S1(view);
            boolean z = false;
            v2(X1() || C3());
            if (G3()) {
                d2();
            }
            L3();
            this.l0.setOnDoubleClickListener(new b(this));
            if (!c.a.n0.a.d2.e.i()) {
                c.a.n0.a.d2.e.d(c.a.n0.a.t1.d.J().r().V());
            }
            if (E3() && C3()) {
                z = true;
            }
            this.T0 = z;
            if (z) {
                d3();
            }
        }
    }

    public void T3(c.a.n0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "switchTab pageParam: " + bVar);
            }
            if (this.L0.o(k3().g()) == this.L0.o(bVar.g())) {
                c.a.n0.a.c1.b bVar2 = this.G0;
                bVar2.f3950e = bVar.f3950e;
                bVar2.f3951f = bVar.f3951f;
                return;
            }
            this.L0.E(bVar.g());
            onPause();
            j3(bVar, "");
        }
    }

    public final void U3(String str, c.a.n0.a.c1.b bVar) {
        c.a.n0.a.f.e.b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, str, bVar) == null) || this.K0 == (bVar2 = this.I0.get(str)) || bVar2 == null) {
            return;
        }
        c.a.n0.a.t1.n.g f2 = c.a.n0.a.w0.f.U().f(str);
        bVar2.B(this.J0, f2);
        if (!bVar2.e()) {
            bVar2.R(this.J0, f2);
        }
        bVar2.E(0);
        c.a.n0.a.f.e.b bVar3 = this.K0;
        if (bVar3 != null) {
            bVar3.E(8);
        }
        this.K0 = bVar2;
        c.a.n0.a.c1.b bVar4 = this.G0;
        bVar4.f3950e = bVar.f3950e;
        bVar4.f3951f = bVar.f3951f;
        bVar2.j(bVar4);
    }

    public final void V3(c.a.n0.a.f.e.b bVar) {
        c.a.n0.a.x.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) || (cVar = this.Q0) == null || bVar == null) {
            return;
        }
        bVar.X(cVar);
        if (bVar.m() != null) {
            bVar.X(this.Q0);
        }
    }

    public final void W3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - W0) * 1.0f;
            int i3 = this.P0;
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
            if (V0 && i4 != 0 && i4 != 255) {
                Log.d("SwanAppFragment", "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4);
            }
            c.a.n0.a.q2.d.b bVar = this.t0;
            if (bVar != null && bVar.i() && (e2 = this.t0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.l0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            c.a.n0.a.t1.n.g gVar = this.O0;
            if (gVar != null && gVar.i && (centerTitleView = this.l0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.o0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void X3() {
        c.a.n0.a.c1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.j0) == null) {
            return;
        }
        cVar.n();
    }

    public final void Y3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            int i3 = 0;
            if (z) {
                c.a.n0.a.q2.d.b bVar = this.t0;
                if (bVar != null && bVar.i()) {
                    i2 = n0.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.J0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.k0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.k0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = H1().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07015b);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.J0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.J0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.k0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.k0.setLayoutParams(layoutParams22);
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b3(c.a.n0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) || bVar == null) {
            return;
        }
        c.a.n0.a.x.j.c cVar = this.Q0;
        if (cVar != null) {
            bVar.v(cVar);
        }
        bVar.d0(x3());
    }

    @Override // c.a.n0.a.x.g.d
    public boolean c2() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        c.a.n0.a.c1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
            if (U == null || (s = U.s()) == null || !s.n() || (cVar = this.j0) == null) {
                return false;
            }
            return s.r(cVar.i());
        }
        return invokeV.booleanValue;
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.F0 = n.c("805");
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.n0.a.t1.d.J().r().d0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final c.a.n0.a.f.e.b e3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048609, this, str, str2, str3, str4)) == null) {
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad start.");
            }
            a.e f2 = c.a.n0.a.x.t.a.f(getActivity(), c.a.n0.a.x.t.f.a.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = c.a.n0.a.k1.h.q("route", str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f7448b ? "1" : "0");
            }
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad preloadManager: " + f2);
            }
            c.a.n0.a.x.t.a.q(f2, new d(this, f2, str4, str2, str, str3));
            if (V0) {
                Log.d("SwanAppFragment", "createSlaveAndLoad end.");
            }
            return f2.a;
        }
        return (c.a.n0.a.f.e.b) invokeLLLL.objValue;
    }

    public final void f3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view) == null) {
            c.a.n0.a.k1.g.a("route", "createSlaveWebView start.");
            String h2 = this.j0.h();
            String j = this.j0.j();
            String i2 = this.j0.i();
            String a2 = q0.a(h2, i2, j);
            this.K0 = c.a.n0.a.x.t.a.h(a2);
            if (V0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                sb.append(this.K0 != null);
                Log.d("SwanAppFragment", sb.toString());
            }
            if (this.K0 == null) {
                if (V0) {
                    Log.e("SwanAppFragment", Log.getStackTraceString(new Exception("createSlaveWebView failed.")));
                }
                this.K0 = e3(h2, i2, j, "");
            }
            this.K0.j(this.G0);
            c.a.n0.a.t1.n.g f2 = c.a.n0.a.w0.f.U().f(i2);
            this.K0.B(this.J0, f2);
            this.K0.R(this.J0, f2);
            z3(i2);
            b3(this.K0);
            if (c2()) {
                this.I0.put(i2, this.K0);
                this.L0.f(view, getContext(), i2);
            }
            c.a.n0.a.k1.g.a("route", "createSlaveWebView end.");
            c3();
        }
    }

    @Override // c.a.n0.a.x.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            N1();
            c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
            fVar.f4191e = "gohome";
            fVar.f4189c = "bar";
            f H = c.a.n0.a.w0.f.U().H();
            c.a.n0.a.c1.c L1 = H == null ? null : H.L1();
            if (L1 != null && !TextUtils.isEmpty(L1.i())) {
                fVar.a("page", L1.i());
            }
            y1(fVar);
        }
    }

    public final void g3(c.a.n0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, bVar, str) == null) && this.I0.get(bVar.f3949d) == null) {
            String a2 = q0.a(bVar.f3948c, bVar.a, bVar.f3947b);
            c.a.n0.a.f.e.b h2 = c.a.n0.a.x.t.a.h(a2);
            if (h2 != null) {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView loaded manager pageUrl: " + a2);
                }
                this.I0.put(bVar.a, h2);
            } else {
                if (V0) {
                    Log.d("SwanAppFragment", "createTabSlaveWebView createNew.");
                }
                h2 = e3(bVar.f3948c, bVar.a, bVar.f3947b, str);
                this.I0.put(bVar.a, h2);
            }
            z3(bVar.a);
            b3(h2);
        }
    }

    @Override // c.a.n0.a.s1.b.c.a.InterfaceC0451a
    public c.a.n0.a.s1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.M0 == null) {
                if (this.N0 == null) {
                    return null;
                }
                this.M0 = new c.a.n0.a.s1.b.c.a(this, (LinearLayout) this.N0.findViewById(R.id.obfuscated_res_0x7f090179), H1().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07015b));
            }
            return this.M0;
        }
        return (c.a.n0.a.s1.b.c.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            c.a.n0.a.f.e.b bVar = this.K0;
            if (bVar != null) {
                bVar.W();
            }
            A3();
            o3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.n0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(c.a.n0.a.z.b.a.n(c.a.n0.a.t1.d.J().getAppId()));
            }
            this.m0.u(c.a.n0.a.s0.a.M().a(), F1(), this.n0, false);
        }
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            Map<String, c.a.n0.a.f.e.b> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (c.a.n0.a.f.e.b bVar : this.I0.values()) {
                    if (bVar != null) {
                        V3(bVar);
                        bVar.destroy();
                    }
                }
                this.I0.clear();
            } else {
                c.a.n0.a.f.e.b bVar2 = this.K0;
                if (bVar2 != null) {
                    V3(bVar2);
                    this.K0.destroy();
                }
            }
            this.K0 = null;
            if (V0) {
                Log.d("SwanAppFragment", "onDestroy() obj: " + this);
            }
            if (this.S0) {
                return;
            }
            c.a.n0.a.x.t.a.n(c.a.n0.a.w0.f.U().getActivity());
        }
    }

    public void i3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.O0.j = "default";
            t1();
            L3();
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) ? X1() && this.K0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    public void j3(c.a.n0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, bVar, str) == null) {
            Q3(this.G0);
            this.H0 = Y0;
            if (V0) {
                Log.d("SwanAppFragment", "doSwitchTab mPrePageParams=" + this.H0);
            }
            String str2 = bVar.a;
            String str3 = bVar.f3949d;
            c.a.n0.a.t1.n.g f2 = c.a.n0.a.w0.f.U().f(TextUtils.isEmpty(str3) ? "" : str3);
            c.a.n0.a.c1.b bVar2 = this.G0;
            bVar2.a = str2;
            bVar2.f3947b = bVar != null ? bVar.f() : "";
            this.G0.f3949d = str3;
            this.O0 = f2;
            boolean z = !I3(str3);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    c.a.n0.a.k1.i.c(7, str);
                } else {
                    c.a.n0.a.k1.i.c(6, str);
                }
            }
            if (!z) {
                U3(str3, bVar);
            } else {
                g3(bVar, str);
                U3(str2, bVar);
            }
            if (!TextUtils.isEmpty(str)) {
                c.a.n0.a.k1.h.q("route", str).F(new UbcFlowEvent("na_push_page_end"));
                c.a.n0.a.k1.i.a(str, bVar);
            }
            t2(f2.f6379b);
            A2(SwanAppConfigData.t(f2.f6380c));
            r2(f2.a);
            L3();
            X3();
            c.a.n0.a.u.d.i("SwanAppFragment", "switch tab title: " + f2.f6379b + " page:" + str2);
        }
    }

    public PullToRefreshBaseWebView k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            c.a.n0.a.f.e.b bVar = this.K0;
            if (bVar != null) {
                return bVar.k0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && e0()) {
            super.k1(z);
            if (V0) {
                Log.d("SwanAppFragment", "setUserVisibleHint isVisibleToUser: " + z);
            }
            if (z) {
                resume();
                q3(false);
                return;
            }
            pause();
        }
    }

    @NonNull
    public c.a.n0.a.c1.b k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.G0 : (c.a.n0.a.c1.b) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [c.a.n0.a.f.e.c] */
    @NonNull
    public Pair<Integer, Integer> l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            c.a.n0.a.f.e.b bVar = this.K0;
            if (bVar == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = bVar.u().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public c.a.n0.a.f.e.b m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.K0 : (c.a.n0.a.f.e.b) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.g.d
    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.n2();
            L3();
            if (this.U0) {
                R3();
            }
        }
    }

    public final int n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? b2() ? H3() ? 18 : 17 : H3() ? 12 : 15 : invokeV.intValue;
    }

    public final void o3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048626, this, z) == null) && c.a.n0.a.s0.a.K().k(z, 2)) {
            c.a.n0.a.b1.a.l(getContext(), this.m0, this.l0, c.a.n0.a.t1.e.a0().V().f0().paNumber);
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onPause();
            Z0();
        }
    }

    @Override // c.a.n0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onResume();
            c1();
            q3(false);
        }
    }

    @Nullable
    public c.a.n0.a.c1.b p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.H0 : (c.a.n0.a.c1.b) invokeV.objValue;
    }

    public void pause() {
        PullToRefreshBaseWebView k0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            boolean z = this.K0 == null;
            String c2 = z ? "" : this.K0.c();
            if (V0) {
                Log.d("SwanAppFragment", "pause() wvID: " + c2);
            }
            if (!z) {
                this.K0.onPause();
                N3("onHide");
                c.a.n0.a.d1.h.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c() && (!getFloatLayer().f() || getFloatLayer().j())) {
                getFloatLayer().g();
            }
            c.a.n0.a.u.d.i("SwanApp", "onHide");
            c.a.n0.a.z0.b.i(c2, false);
            if (!z && (k0 = this.K0.k0()) != null) {
                k0.w(false);
            }
            c.a.n0.a.s0.a.H().f(c.a.n0.a.t1.e.a0() != null ? c.a.n0.a.t1.e.a0().N() : "");
        }
    }

    public final void q3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            if (c.a.n0.a.s0.a.K().k(z, 1)) {
                c.a.n0.a.b1.a.k(getContext(), this.l0, c.a.n0.a.t1.e.a0().V().f0().paNumber);
            } else if (c.a.n0.a.t1.e.a0() == null) {
            } else {
                c.a.n0.a.b1.a.o(this.l0, c.a.n0.a.t1.e.a0().T().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, activity) == null) {
            super.r0(activity);
            if (V0) {
                Log.d("SwanAppFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // c.a.n0.a.x.g.d
    public boolean r2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            boolean r2 = super.r2(i2);
            L3();
            return r2;
        }
        return invokeI.booleanValue;
    }

    public String r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            c.a.n0.a.f.e.b bVar = this.K0;
            return bVar != null ? bVar.c() : "";
        }
        return (String) invokeV.objValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            boolean z = false;
            boolean z2 = this.K0 == null;
            String c2 = z2 ? "" : this.K0.c();
            if (V0) {
                Log.d("SwanAppFragment", "resume() wvID: " + c2);
            }
            if (!z2) {
                v2((X1() || C3()) ? true : true);
                this.K0.onResume();
                O3();
                N3("onShow");
                c.a.n0.a.d1.h.e().i(true);
            }
            c.a.n0.a.u.d.i("SwanApp", "onShow");
            c.a.n0.a.z0.b.i(c2, true);
            if (c.a.n0.a.u.d.f()) {
                c.a.n0.a.x.e.b.b();
            }
            c.a.n0.a.s0.a.H().e(c.a.n0.a.t1.e.a0() != null ? c.a.n0.a.t1.e.a0().N() : "");
        }
    }

    public List<String> s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, c.a.n0.a.f.e.b> map = this.I0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, c.a.n0.a.f.e.b> entry : this.I0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().c());
                    }
                }
            }
            c.a.n0.a.f.e.b bVar = this.K0;
            if (bVar != null) {
                String c2 = bVar.c();
                if (!arrayList.contains(c2)) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public c.a.n0.a.i2.b.a t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.L0 : (c.a.n0.a.i2.b.a) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, bundle) == null) {
            super.u0(bundle);
            M3();
            if (V0) {
                Log.d("SwanAppFragment", "onCreate() obj: " + this);
            }
            q.j(new a(this), "SwanAppPageHistory");
            c.a.n0.a.k1.g.a("route", "fragment create.");
        }
    }

    @Override // c.a.n0.a.x.g.d
    public void u1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            if (!c.a.n0.a.t1.n.g.f(this.O0)) {
                super.u1(i2);
                return;
            }
            v1(i2, E3() ? true : true ^ f0.h(this.i0));
            L3();
        }
    }

    public String u3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, str)) == null) {
            if (this.I0.containsKey(str)) {
                return this.I0.get(str).c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public FrameLayout v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.J0 : (FrameLayout) invokeV.objValue;
    }

    public final c.a.n0.a.x.j.a w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? new h(this) : (c.a.n0.a.x.j.a) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048643, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.n0.a.k1.g.a("route", "fragment onCreateView.");
            View b2 = c.a.n0.a.k1.n.a.a().b(R.layout.obfuscated_res_0x7f0d00aa, viewGroup, false);
            this.J0 = (FrameLayout) b2.findViewById(R.id.obfuscated_res_0x7f09017a);
            S1(b2);
            R2(b2);
            this.L0 = new c.a.n0.a.i2.b.a(this);
            f3(b2);
            if (!c.a.n0.a.a1.f.b.e() && !c.a.n0.a.a1.f.b.f()) {
                c.a.n0.a.a1.f.a.b(this.K0.c(), String.valueOf(c.a.n0.a.a1.f.b.d()), String.valueOf(c.a.n0.a.a1.f.b.a(c.a.n0.a.a1.f.b.b())));
            }
            if (R1()) {
                b2 = U1(b2);
            }
            this.N0 = B1(b2, this);
            E2(this.K0.C());
            c.a.n0.a.d1.h.e().m();
            return this.N0;
        }
        return (View) invokeLLL.objValue;
    }

    public final c.a.n0.a.x.j.e x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? new g(this) : (c.a.n0.a.x.j.e) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            super.y0();
            this.B0.a();
            if (i.b()) {
                q0.q().postAtFrontOfQueue(new c(this));
            } else {
                h3();
            }
        }
    }

    public final void y3() {
        c.a.n0.a.o0.j.b I0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            c.a.n0.a.f.e.b m3 = m3();
            if (!(m3 instanceof SwanAppWebViewManager) || (I0 = ((SwanAppWebViewManager) m3).I0()) == null) {
                return;
            }
            I0.d();
        }
    }

    public final void z3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048647, this, str) == null) || E3()) {
            return;
        }
        c.a.n0.a.w0.f U = c.a.n0.a.w0.f.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).f6385h && this.Q0 == null) {
            this.Q0 = new C0531f(this);
        }
    }
}
