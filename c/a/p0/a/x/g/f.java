package c.a.p0.a.x.g;

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
import c.a.p0.a.d2.n;
import c.a.p0.a.f.d.u0;
import c.a.p0.a.p2.d0;
import c.a.p0.a.p2.f0;
import c.a.p0.a.p2.n0;
import c.a.p0.a.p2.q;
import c.a.p0.a.p2.q0;
import c.a.p0.a.s1.b.c.a;
import c.a.p0.a.x.t.a;
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
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class f extends c.a.p0.a.x.g.d implements a.InterfaceC0459a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Z0;
    public static final int a1;
    public static String b1;
    public static c.a.p0.a.c1.b c1;
    public static String d1;
    public static String e1;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.a.d2.a J0;
    public c.a.p0.a.c1.b K0;
    public c.a.p0.a.c1.b L0;
    public Map<String, c.a.p0.a.f.e.b> M0;
    public FrameLayout N0;
    public c.a.p0.a.f.e.b O0;
    public c.a.p0.a.i2.b.a P0;
    public c.a.p0.a.s1.b.c.a Q0;
    public View R0;
    public c.a.p0.a.t1.n.g S0;
    public int T0;
    public c.a.p0.a.x.j.c U0;
    public u0 V0;
    public boolean W0;
    public boolean X0;
    public boolean Y0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8362e;

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
            this.f8362e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8362e.V0 = c.a.p0.a.s0.a.Q();
                u0 u0Var = this.f8362e.V0;
                f fVar = this.f8362e;
                u0Var.a(fVar.f0, fVar.h0, fVar.getContext());
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                String c2 = this.a.O0.c();
                c.a.p0.a.e0.d.h hVar = new c.a.p0.a.e0.d.h();
                hVar.f5013c = c.a.p0.a.q2.g.c.a.a(c2, "scrollViewBackToTop");
                c.a.p0.a.w0.f.U().m(c2, hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8363e;

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
            this.f8363e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8363e.d3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8365c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f8366d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f8368f;

        public d(f fVar, a.e eVar, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, eVar, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8368f = fVar;
            this.a = eVar;
            this.f8364b = str;
            this.f8365c = str2;
            this.f8366d = str3;
            this.f8367e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [c.a.p0.a.f.e.c] */
        @Override // c.a.p0.a.x.t.a.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.x.u.d dVar = new c.a.p0.a.x.u.d();
                dVar.f8896i = this.a.a.L();
                if (!TextUtils.isEmpty(this.f8364b)) {
                    c.a.p0.a.k1.i.e(this.a, this.f8364b);
                }
                String b2 = c.a.p0.a.v1.f.o0.j.b(this.f8365c);
                dVar.a = this.f8366d;
                if (TextUtils.isEmpty(this.f8367e)) {
                    str = this.f8365c;
                } else {
                    str = this.f8365c + "?" + this.f8367e;
                }
                dVar.f8889b = str;
                if (c.a.p0.a.t1.e.a0() != null) {
                    dVar.f8890c = c.a.p0.a.t1.e.a0().c0(b2);
                    dVar.f8893f = c.a.p0.a.t1.e.a0().W(b2);
                }
                dVar.k = c.a.p0.a.x.u.a.c(c.a.p0.a.t1.e.L(), dVar.f8889b);
                dVar.f8891d = c.a.p0.a.w0.f.U().f(b2).f7554g;
                dVar.f8892e = String.valueOf(c.a.p0.a.u.a.a());
                dVar.f8894g = f.Z0 || c.a.p0.a.w0.f.U().N();
                if (c.a.p0.a.n1.a.a.H()) {
                    dVar.f8897j = c.a.p0.a.u.f.b.d();
                }
                if (!TextUtils.isEmpty(this.f8364b)) {
                    String str2 = this.f8364b;
                    dVar.f8895h = str2;
                    c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                d0.d();
                this.a.a.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f8365c);
                this.a.a.T(dVar.f8889b);
                c.a.p0.a.w0.f.U().m(this.a.a.c(), c.a.p0.a.x.u.d.a(dVar));
                if (c.a.p0.a.x.u.e.b()) {
                    c.a.p0.a.x.u.e eVar = new c.a.p0.a.x.u.e();
                    eVar.a = this.a.a.c();
                    c.a.p0.a.w0.f.U().u(c.a.p0.a.x.u.e.a(eVar));
                }
                c.a.p0.a.d2.e.F(this.a.a.c(), dVar.f8889b);
                if (f.Z0) {
                    String str3 = "createSlaveAndLoad onReady. pageEvent: " + dVar.toString();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f8369e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f8370e;

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
                this.f8370e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8370e.f8369e.X0 = false;
                    this.f8370e.f8369e.v2(true, false);
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
            this.f8369e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.c.f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null || fVar.f9100d || fVar.f9106j != 1) {
                return;
            }
            q0.e0(new a(this));
        }
    }

    /* renamed from: c.a.p0.a.x.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0539f implements c.a.p0.a.x.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public C0539f(f fVar) {
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
            this.a = fVar;
        }

        @Override // c.a.p0.a.x.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.a.S3(i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.p0.a.x.j.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // c.a.p0.a.x.j.e
        public void a(c.a.p0.a.f.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.u(this.a.U0);
            eVar.a0(this.a.s3());
            c.a.p0.a.d1.h.e().a(eVar);
        }

        @Override // c.a.p0.a.x.j.e
        public void b(c.a.p0.a.f.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.W(this.a.U0);
            c.a.p0.a.d1.h.e().b(eVar);
        }
    }

    /* loaded from: classes.dex */
    public class h extends c.a.p0.a.x.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f8371c;

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
            this.f8371c = fVar;
        }

        @Override // c.a.p0.a.x.j.a, c.a.p0.a.x.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f8371c.p2(str);
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
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2113944582, "Lc/a/p0/a/x/g/f$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2113944582, "Lc/a/p0/a/x/g/f$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (a < 0) {
                    c.a.p0.a.s0.a.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    a = 1;
                }
                if (f.Z0) {
                    String str = "getFragmentDestroySwitch:" + a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78177323, "Lc/a/p0/a/x/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78177323, "Lc/a/p0/a/x/g/f;");
                return;
            }
        }
        Z0 = c.a.p0.a.a.a;
        a1 = n0.g(149.0f);
        b1 = "-1";
        d1 = "-1";
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
        this.K0 = new c.a.p0.a.c1.b();
        this.M0 = new TreeMap();
        this.T0 = 0;
        this.W0 = false;
        this.X0 = false;
        this.Y0 = false;
    }

    public static f G3(c.a.p0.a.c1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            f fVar = new f();
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", cVar.m());
                fVar.d1(bundle);
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static void M3(c.a.p0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            try {
                if (Z0) {
                    String str = "setLastPageParams =" + bVar;
                }
                if (bVar == null) {
                    c1 = null;
                } else {
                    c1 = (c.a.p0.a.c1.b) bVar.clone();
                }
            } catch (Exception e2) {
                if (Z0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void O3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            e1 = str;
        }
    }

    private void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (U()) {
                pause();
            }
            if (Z0) {
                Log.getStackTraceString(new Exception("performPause() wvID: " + this.O0.c()));
            }
        }
    }

    private void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (U()) {
                resume();
            }
            c.a.p0.n.f fVar = this.q0;
            if (fVar != null && fVar.l()) {
                this.q0.E(c.a.p0.a.s0.a.M().a());
            }
            if (Z0) {
                Log.getStackTraceString(new Exception("performResume() wvID: " + this.O0.c()));
            }
        }
    }

    @Override // c.a.p0.a.x.g.d
    public c.a.p0.a.t1.n.g A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.S0 : (c.a.p0.a.t1.n.g) invokeV.objValue;
    }

    public boolean A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.p0.a.t1.n.g gVar = this.S0;
            if (gVar != null) {
                return TextUtils.equals(gVar.f7557j, "custom");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean B3(c.a.p0.a.x.g.g gVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, swanAppConfigData)) == null) {
            c.a.p0.a.x.g.d j2 = gVar.j(0);
            if (j2 == null || !(j2 instanceof f)) {
                return false;
            }
            String f2 = ((f) j2).g3().f();
            return swanAppConfigData.r(f2) || TextUtils.equals(swanAppConfigData.f(), f2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean C3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.a.x.g.g G1 = G1();
            if (G1 == null) {
                return false;
            }
            c.a.p0.a.t1.n.g gVar = this.S0;
            if ((gVar != null && gVar.k) || (s = c.a.p0.a.w0.f.U().s()) == null) {
                return false;
            }
            return !B3(G1, s);
        }
        return invokeV.booleanValue;
    }

    public final boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SwanAppConfigData s = c.a.p0.a.w0.f.U().s();
            return (s == null || TextUtils.equals(s.f(), this.K0.f())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean E3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? (this.M0.isEmpty() || this.M0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void F3(c.a.p0.a.d2.s.g gVar) {
        c.a.p0.a.d2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || (aVar = this.J0) == null) {
            return;
        }
        n.i(aVar, gVar);
        this.J0 = null;
    }

    @Override // c.a.p0.a.x.g.d
    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.O0 == null) {
                if (Z0) {
                    Log.getStackTraceString(new Exception("mCurWebViewManager is null."));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.O0.c());
            c.a.p0.a.f.e.e l = this.O0.l();
            if (l != null) {
                hashMap.put("webViewUrl", l.getCurrentPageUrl());
            }
            c.a.p0.a.w0.f.U().u(new c.a.p0.a.e0.d.c("sharebtn", hashMap));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H3() {
        int i2;
        c.a.p0.a.t1.n.g gVar;
        c.a.p0.a.f.e.c cVar;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.k0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (A3()) {
            v2(true, this.X0);
            i2 = 0;
        } else if (z3()) {
            v2(false, false);
            c.a.p0.a.f.e.b bVar = this.O0;
            if (bVar != null) {
                if (bVar.l() != null) {
                    cVar = this.O0.l().t();
                } else {
                    cVar = this.O0.t();
                }
                if (cVar != null) {
                    i2 = cVar.getWebViewScrollY();
                    gVar = this.S0;
                    if (gVar != null && gVar.f7556i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            gVar = this.S0;
            if (gVar != null) {
                i3 = 0;
            }
        } else {
            v2(false, false);
            i2 = a1 + this.T0;
            centerTitleView = this.k0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            S3(i2);
            U3(z);
        }
        z = true;
        centerTitleView = this.k0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        S3(i2);
        U3(z);
    }

    public final void I3() {
        Bundle t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t = t()) == null) {
            return;
        }
        this.L0 = c1;
        if (Z0) {
            String str = "restoreArguments sPrePageParams=" + this.L0;
        }
        c.a.p0.a.c1.c g2 = c.a.p0.a.c1.c.g(t.getString("ai_apps_param"));
        this.h0 = g2;
        if (g2 == null) {
            c.a.p0.a.c1.b bVar = this.K0;
            bVar.f4642e = "";
            bVar.f4643f = "";
            bVar.f4646i = "";
            bVar.f4647j = "";
        } else {
            this.K0.f4642e = g2.i();
            this.K0.f4643f = this.h0.j();
            this.K0.f4646i = this.h0.l();
            this.K0.f4647j = this.h0.k();
        }
        c.a.p0.a.c1.b bVar2 = this.K0;
        bVar2.f4645h = c.a.p0.a.v1.f.o0.j.b(bVar2.f());
        c.a.p0.a.t1.n.g f2 = c.a.p0.a.w0.f.U().f(this.K0.h());
        this.S0 = f2;
        if (f2.p) {
            this.S0 = c.a.p0.a.w0.f.U().j(this.K0.f());
        }
        if (this.H0) {
            c.a.p0.a.t1.n.g gVar = this.S0;
            gVar.f7553f = false;
            gVar.f7555h = true;
            gVar.p = true;
        }
        this.T0 = D1().getDimensionPixelSize(R.dimen.aiapps_normal_base_action_bar_height);
    }

    public final void J3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.O0.c());
            c.a.p0.a.e0.d.d dVar = new c.a.p0.a.e0.d.d(hashMap);
            if (Z0) {
                String str2 = "sendLifecycleMessage type: " + str + " wvID: " + this.O0.c();
            }
            c.a.p0.a.w0.f.U().u(dVar);
        }
    }

    @Override // c.a.p0.a.x.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().e() && getFloatLayer().f()) {
                return true;
            }
            if ((getFloatLayer() == null || !getFloatLayer().c()) && !PaymentManager.k()) {
                c.a.p0.a.f.e.b bVar = this.O0;
                if (bVar != null) {
                    if (c.a.p0.a.z0.b.g(bVar.c())) {
                        return true;
                    }
                    return this.O0.K();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!TextUtils.equals(d1, this.O0.c()) || TextUtils.equals(e1, "switchTab")) {
                int o = this.P0.o(g3().h());
                c.a.p0.a.e0.d.f fVar = new c.a.p0.a.e0.d.f();
                fVar.f5006c = d1;
                fVar.f5007d = this.O0.c();
                fVar.f5008e = e1;
                fVar.f5009f = this.K0.f4642e;
                fVar.f5010g = String.valueOf(o);
                e1 = "";
                if (Z0) {
                    String str = "sendRouteMessage fromId: " + fVar.f5006c + " ,toId: " + fVar.f5007d + " ,RouteType: " + fVar.f5008e + " page:" + fVar.f5009f + ",TabIndex: " + fVar.f5010g;
                }
                c.a.p0.a.w0.f.U().u(fVar);
                d1 = this.O0.c();
            }
        }
    }

    public void L3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.Y0 = z;
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            boolean z = Z0;
            c.a.p0.a.p2.d.h();
            if (this.g0.getWindow() != null) {
                this.g0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = c.a.p0.a.s1.b.a.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(R.id.title_shadow).setVisibility(8);
            }
            SwanAppActionBar E1 = E1();
            if (E1 != null) {
                E1.setRightMenuStyle();
                E1.setRightZoneImmersiveStyle();
                E1.setBackgroundColor(0);
            }
            View W = W();
            if (W != null) {
                W.findViewById(R.id.immersion_custom_statusbar_view).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) W.findViewById(R.id.ai_apps_fragment_content);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // c.a.p0.a.x.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            super.O1(view);
            boolean z = false;
            r2(T1() || y3());
            if (C3()) {
                Z1();
            }
            H3();
            this.k0.setOnDoubleClickListener(new b(this));
            if (!c.a.p0.a.d2.e.i()) {
                c.a.p0.a.d2.e.d(c.a.p0.a.t1.d.J().r().V());
            }
            if (A3() && y3()) {
                z = true;
            }
            this.X0 = z;
            if (z) {
                Z2();
            }
        }
    }

    public void P3(c.a.p0.a.c1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            if (Z0) {
                String str = "switchTab pageParam: " + bVar;
            }
            if (this.P0.o(g3().h()) == this.P0.o(bVar.h())) {
                c.a.p0.a.c1.b bVar2 = this.K0;
                bVar2.f4646i = bVar.f4646i;
                bVar2.f4647j = bVar.f4647j;
                return;
            }
            this.P0.E(bVar.h());
            onPause();
            f3(bVar, "");
        }
    }

    public final void Q3(String str, c.a.p0.a.c1.b bVar) {
        c.a.p0.a.f.e.b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, str, bVar) == null) || this.O0 == (bVar2 = this.M0.get(str)) || bVar2 == null) {
            return;
        }
        c.a.p0.a.t1.n.g f2 = c.a.p0.a.w0.f.U().f(str);
        bVar2.A(this.N0, f2);
        if (!bVar2.e()) {
            bVar2.Q(this.N0, f2);
        }
        bVar2.D(0);
        c.a.p0.a.f.e.b bVar3 = this.O0;
        if (bVar3 != null) {
            bVar3.D(8);
        }
        this.O0 = bVar2;
        c.a.p0.a.c1.b bVar4 = this.K0;
        bVar4.f4646i = bVar.f4646i;
        bVar4.f4647j = bVar.f4647j;
        bVar2.i(bVar4);
    }

    public final void R3(c.a.p0.a.f.e.b bVar) {
        c.a.p0.a.x.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) || (cVar = this.U0) == null || bVar == null) {
            return;
        }
        bVar.W(cVar);
        if (bVar.l() != null) {
            bVar.W(this.U0);
        }
    }

    public final void S3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - a1) * 1.0f;
            int i3 = this.T0;
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
            if (Z0 && i4 != 0 && i4 != 255) {
                String str = "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4;
            }
            c.a.p0.a.q2.d.b bVar = this.x0;
            if (bVar != null && bVar.i() && (e2 = this.x0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.k0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            c.a.p0.a.t1.n.g gVar = this.S0;
            if (gVar != null && gVar.f7556i && (centerTitleView = this.k0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.s0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void T3() {
        c.a.p0.a.c1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (cVar = this.h0) == null) {
            return;
        }
        cVar.n();
    }

    public final void U3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            int i3 = 0;
            if (z) {
                c.a.p0.a.q2.d.b bVar = this.x0;
                if (bVar != null && bVar.i()) {
                    i2 = n0.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.N0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.N0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.i0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.i0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = D1().getDimensionPixelSize(R.dimen.aiapps_normal_base_action_bar_height);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.N0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.N0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.i0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.i0.setLayoutParams(layoutParams22);
        }
    }

    @Override // c.a.p0.a.x.g.d
    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void X2(c.a.p0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) || bVar == null) {
            return;
        }
        c.a.p0.a.x.j.c cVar = this.U0;
        if (cVar != null) {
            bVar.u(cVar);
        }
        bVar.b0(t3());
    }

    @Override // c.a.p0.a.x.g.d
    public boolean Y1() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        c.a.p0.a.c1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
            if (U == null || (s = U.s()) == null || !s.n() || (cVar = this.h0) == null) {
                return false;
            }
            return s.r(cVar.i());
        }
        return invokeV.booleanValue;
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.J0 = n.c("805");
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.p0.a.t1.d.J().r().d0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final c.a.p0.a.f.e.b a3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048603, this, str, str2, str3, str4)) == null) {
            boolean z = Z0;
            a.e f2 = c.a.p0.a.x.t.a.f(getActivity(), c.a.p0.a.x.t.f.a.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f8859b ? "1" : "0");
            }
            if (Z0) {
                String str5 = "createSlaveAndLoad preloadManager: " + f2;
            }
            c.a.p0.a.x.t.a.q(f2, new d(this, f2, str4, str2, str, str3));
            boolean z2 = Z0;
            return f2.a;
        }
        return (c.a.p0.a.f.e.b) invokeLLLL.objValue;
    }

    public final void b3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view) == null) {
            c.a.p0.a.k1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
            String h2 = this.h0.h();
            String j2 = this.h0.j();
            String i2 = this.h0.i();
            String a2 = q0.a(h2, i2, j2);
            this.O0 = c.a.p0.a.x.t.a.h(a2);
            if (Z0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                sb.append(this.O0 != null);
                sb.toString();
            }
            if (this.O0 == null) {
                if (Z0) {
                    Log.getStackTraceString(new Exception("createSlaveWebView failed."));
                }
                this.O0 = a3(h2, i2, j2, "");
            }
            this.O0.i(this.K0);
            c.a.p0.a.t1.n.g f2 = c.a.p0.a.w0.f.U().f(i2);
            this.O0.A(this.N0, f2);
            this.O0.Q(this.N0, f2);
            v3(i2);
            X2(this.O0);
            if (Y1()) {
                this.M0.put(i2, this.O0);
                this.P0.f(view, getContext(), i2);
            }
            c.a.p0.a.k1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
            Y2();
        }
    }

    @Override // c.a.p0.a.x.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            J1();
            c.a.p0.a.d2.s.f fVar = new c.a.p0.a.d2.s.f();
            fVar.f4950e = "gohome";
            fVar.f4948c = "bar";
            f H = c.a.p0.a.w0.f.U().H();
            c.a.p0.a.c1.c H1 = H == null ? null : H.H1();
            if (H1 != null && !TextUtils.isEmpty(H1.i())) {
                fVar.a("page", H1.i());
            }
            u1(fVar);
        }
    }

    public final void c3(c.a.p0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048606, this, bVar, str) == null) && this.M0.get(bVar.f4645h) == null) {
            String a2 = q0.a(bVar.f4644g, bVar.f4642e, bVar.f4643f);
            c.a.p0.a.f.e.b h2 = c.a.p0.a.x.t.a.h(a2);
            if (h2 != null) {
                if (Z0) {
                    String str2 = "createTabSlaveWebView loaded manager pageUrl: " + a2;
                }
                this.M0.put(bVar.f4642e, h2);
            } else {
                boolean z = Z0;
                h2 = a3(bVar.f4644g, bVar.f4642e, bVar.f4643f, str);
                this.M0.put(bVar.f4642e, h2);
            }
            v3(bVar.f4642e);
            X2(h2);
        }
    }

    @Override // c.a.p0.a.x.g.d
    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            c.a.p0.a.f.e.b bVar = this.O0;
            if (bVar != null) {
                bVar.V();
            }
            w3();
            k3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.r0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(c.a.p0.a.z.b.a.n(c.a.p0.a.t1.d.J().getAppId()));
            }
            this.q0.x(c.a.p0.a.s0.a.M().a(), B1(), this.r0, false);
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Map<String, c.a.p0.a.f.e.b> map = this.M0;
            if (map != null && !map.isEmpty()) {
                for (c.a.p0.a.f.e.b bVar : this.M0.values()) {
                    if (bVar != null) {
                        R3(bVar);
                        bVar.destroy();
                    }
                }
                this.M0.clear();
            } else {
                c.a.p0.a.f.e.b bVar2 = this.O0;
                if (bVar2 != null) {
                    R3(bVar2);
                    this.O0.destroy();
                }
            }
            this.O0 = null;
            if (Z0) {
                String str = "onDestroy() obj: " + this;
            }
            if (this.W0) {
                return;
            }
            c.a.p0.a.x.t.a.n(c.a.p0.a.w0.f.U().getActivity());
        }
    }

    public void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.S0.f7557j = "default";
            p1();
            H3();
        }
    }

    public void f3(c.a.p0.a.c1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, bVar, str) == null) {
            M3(this.K0);
            this.L0 = c1;
            if (Z0) {
                String str2 = "doSwitchTab mPrePageParams=" + this.L0;
            }
            String str3 = bVar.f4642e;
            String str4 = bVar.f4645h;
            c.a.p0.a.t1.n.g f2 = c.a.p0.a.w0.f.U().f(TextUtils.isEmpty(str4) ? "" : str4);
            c.a.p0.a.c1.b bVar2 = this.K0;
            bVar2.f4642e = str3;
            bVar2.f4643f = bVar != null ? bVar.g() : "";
            this.K0.f4645h = str4;
            this.S0 = f2;
            boolean z = !E3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    c.a.p0.a.k1.i.c(7, str);
                } else {
                    c.a.p0.a.k1.i.c(6, str);
                }
            }
            if (!z) {
                Q3(str4, bVar);
            } else {
                c3(bVar, str);
                Q3(str3, bVar);
            }
            if (!TextUtils.isEmpty(str)) {
                c.a.p0.a.k1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
                c.a.p0.a.k1.i.a(str, bVar);
            }
            p2(f2.f7549b);
            w2(SwanAppConfigData.t(f2.f7550c));
            n2(f2.a);
            H3();
            T3();
            c.a.p0.a.u.d.i("SwanAppFragment", "switch tab title: " + f2.f7549b + " page:" + str3);
        }
    }

    @Override // c.a.p0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && g0()) {
            super.g1(z);
            if (Z0) {
                String str = "setUserVisibleHint isVisibleToUser: " + z;
            }
            if (z) {
                resume();
                m3(false);
                return;
            }
            pause();
        }
    }

    @NonNull
    public c.a.p0.a.c1.b g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.K0 : (c.a.p0.a.c1.b) invokeV.objValue;
    }

    @Override // c.a.p0.a.s1.b.c.a.InterfaceC0459a
    public c.a.p0.a.s1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.Q0 == null) {
                if (this.R0 == null) {
                    return null;
                }
                this.Q0 = new c.a.p0.a.s1.b.c.a(this, (LinearLayout) this.R0.findViewById(R.id.ai_apps_fragment_base_view), D1().getDimensionPixelOffset(R.dimen.aiapps_normal_base_action_bar_height));
            }
            return this.Q0;
        }
        return (c.a.p0.a.s1.b.c.a) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [c.a.p0.a.f.e.c] */
    @NonNull
    public Pair<Integer, Integer> h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            c.a.p0.a.f.e.b bVar = this.O0;
            if (bVar == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = bVar.t().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public c.a.p0.a.f.e.b i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.O0 : (c.a.p0.a.f.e.b) invokeV.objValue;
    }

    @Override // c.a.p0.a.x.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, motionEvent)) == null) ? T1() && this.O0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    public PullToRefreshBaseWebView j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            c.a.p0.a.f.e.b bVar = this.O0;
            if (bVar != null) {
                return bVar.j0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // c.a.p0.a.x.g.d
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.j2();
            H3();
            if (this.Y0) {
                N3();
            }
        }
    }

    public final int j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? X1() ? D3() ? 18 : 17 : D3() ? 12 : 15 : invokeV.intValue;
    }

    public final void k3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && c.a.p0.a.s0.a.K().k(z, 2)) {
            c.a.p0.a.b1.a.l(getContext(), this.q0, this.k0, c.a.p0.a.t1.e.a0().V().f0().paNumber);
        }
    }

    @Nullable
    public c.a.p0.a.c1.b l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.L0 : (c.a.p0.a.c1.b) invokeV.objValue;
    }

    public final void m3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            if (c.a.p0.a.s0.a.K().k(z, 1)) {
                c.a.p0.a.b1.a.k(getContext(), this.k0, c.a.p0.a.t1.e.a0().V().f0().paNumber);
            } else if (c.a.p0.a.t1.e.a0() == null) {
            } else {
                c.a.p0.a.b1.a.o(this.k0, c.a.p0.a.t1.e.a0().T().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    @Override // c.a.p0.a.x.g.d
    public boolean n2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            boolean n2 = super.n2(i2);
            H3();
            return n2;
        }
        return invokeI.booleanValue;
    }

    public String n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            c.a.p0.a.f.e.b bVar = this.O0;
            return bVar != null ? bVar.c() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<String> o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, c.a.p0.a.f.e.b> map = this.M0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, c.a.p0.a.f.e.b> entry : this.M0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().c());
                    }
                }
            }
            c.a.p0.a.f.e.b bVar = this.O0;
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

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bundle) == null) {
            super.onCreate(bundle);
            I3();
            if (Z0) {
                String str = "onCreate() obj: " + this;
            }
            q.j(new a(this), "SwanAppPageHistory");
            c.a.p0.a.k1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.onDestroy();
            this.F0.a();
            if (i.b()) {
                q0.q().postAtFrontOfQueue(new c(this));
            } else {
                d3();
            }
        }
    }

    @Override // c.a.p0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPause();
            V0();
        }
    }

    @Override // c.a.p0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onResume();
            Y0();
            m3(false);
        }
    }

    @Nullable
    public c.a.p0.a.i2.b.a p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.P0 : (c.a.p0.a.i2.b.a) invokeV.objValue;
    }

    public void pause() {
        PullToRefreshBaseWebView j0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            boolean z = this.O0 == null;
            String c2 = z ? "" : this.O0.c();
            if (Z0) {
                String str = "pause() wvID: " + c2;
            }
            if (!z) {
                this.O0.onPause();
                J3("onHide");
                c.a.p0.a.d1.h.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c() && (!getFloatLayer().f() || getFloatLayer().j())) {
                getFloatLayer().g();
            }
            c.a.p0.a.u.d.i("SwanApp", "onHide");
            c.a.p0.a.z0.b.i(c2, false);
            if (!z && (j0 = this.O0.j0()) != null) {
                j0.onPullDownRefreshComplete(false);
            }
            c.a.p0.a.s0.a.H().f(c.a.p0.a.t1.e.a0() != null ? c.a.p0.a.t1.e.a0().N() : "");
        }
    }

    @Override // c.a.p0.a.x.g.d
    public void q1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            if (!c.a.p0.a.t1.n.g.f(this.S0)) {
                super.q1(i2);
                return;
            }
            r1(i2, A3() ? true : true ^ f0.h(this.g0));
            H3();
        }
    }

    public String q3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (this.M0.containsKey(str)) {
                return this.M0.get(str).c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, activity) == null) {
            super.r0(activity);
            if (Z0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }

    public FrameLayout r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.N0 : (FrameLayout) invokeV.objValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            boolean z = false;
            boolean z2 = this.O0 == null;
            String c2 = z2 ? "" : this.O0.c();
            if (Z0) {
                String str = "resume() wvID: " + c2;
            }
            if (!z2) {
                r2((T1() || y3()) ? true : true);
                this.O0.onResume();
                K3();
                J3("onShow");
                c.a.p0.a.d1.h.e().i(true);
            }
            c.a.p0.a.u.d.i("SwanApp", "onShow");
            c.a.p0.a.z0.b.i(c2, true);
            if (c.a.p0.a.u.d.f()) {
                c.a.p0.a.x.e.b.b();
            }
            c.a.p0.a.s0.a.H().e(c.a.p0.a.t1.e.a0() != null ? c.a.p0.a.t1.e.a0().N() : "");
        }
    }

    public final c.a.p0.a.x.j.a s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? new h(this) : (c.a.p0.a.x.j.a) invokeV.objValue;
    }

    public final c.a.p0.a.x.j.e t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? new g(this) : (c.a.p0.a.x.j.e) invokeV.objValue;
    }

    public final void u3() {
        c.a.p0.a.o0.j.b H0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            c.a.p0.a.f.e.b i3 = i3();
            if (!(i3 instanceof SwanAppWebViewManager) || (H0 = ((SwanAppWebViewManager) i3).H0()) == null) {
                return;
            }
            H0.d();
        }
    }

    public final void v3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, str) == null) || A3()) {
            return;
        }
        c.a.p0.a.w0.f U = c.a.p0.a.w0.f.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.f(str).f7555h && this.U0 == null) {
            this.U0 = new C0539f(this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048641, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.p0.a.k1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
            View b2 = c.a.p0.a.k1.n.a.a().b(R.layout.aiapps_fragment, viewGroup, false);
            this.N0 = (FrameLayout) b2.findViewById(R.id.ai_apps_fragment_content);
            O1(b2);
            N2(b2);
            this.P0 = new c.a.p0.a.i2.b.a(this);
            b3(b2);
            if (!c.a.p0.a.a1.f.b.e() && !c.a.p0.a.a1.f.b.f()) {
                c.a.p0.a.a1.f.a.b(this.O0.c(), String.valueOf(c.a.p0.a.a1.f.b.d()), String.valueOf(c.a.p0.a.a1.f.b.a(c.a.p0.a.a1.f.b.b())));
            }
            if (N1()) {
                b2 = Q1(b2);
            }
            this.R0 = x1(b2, this);
            A2(this.O0.B());
            c.a.p0.a.d1.h.e().m();
            return this.R0;
        }
        return (View) invokeLLL.objValue;
    }

    @DebugTrace
    public void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.r0 == null) {
                this.r0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.q0 != null) {
                return;
            }
            this.q0 = new c.a.p0.n.f(activity, this.k0, j3(), c.a.p0.a.s0.a.K(), new c.a.p0.a.q2.h.b());
            new c.a.p0.a.a1.a(this.q0, this, this.r0).z();
            if (c.a.p0.a.a1.f.b.e()) {
                this.q0.p(50);
            }
        }
    }

    public boolean x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            c.a.p0.a.i2.b.a aVar = this.P0;
            if (aVar == null) {
                return false;
            }
            return aVar.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            super.y0();
            Map<String, c.a.p0.a.f.e.b> map = this.M0;
            if (map != null && !map.isEmpty()) {
                for (c.a.p0.a.f.e.b bVar : this.M0.values()) {
                    if (bVar != null) {
                        bVar.g0();
                    }
                }
            } else {
                c.a.p0.a.f.e.b bVar2 = this.O0;
                if (bVar2 != null) {
                    bVar2.g0();
                }
            }
            u3();
        }
    }

    public final boolean y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            SwanAppConfigData s = c.a.p0.a.w0.f.U().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.f(), this.K0.f4642e) || s.r(this.K0.f4642e)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.x.g.d, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.z0();
        }
    }

    public final boolean z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            c.a.p0.a.t1.n.g gVar = this.S0;
            return gVar != null && gVar.f7555h;
        }
        return invokeV.booleanValue;
    }
}
