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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c2.b.c.a;
import b.a.p0.a.h0.t.a;
import b.a.p0.a.p.d.u0;
import b.a.p0.a.z2.d0;
import b.a.p0.a.z2.f0;
import b.a.p0.a.z2.n0;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import b.a.p0.n.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class f extends b.a.p0.a.h0.g.d implements a.InterfaceC0136a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Y0;
    public static final int Z0;
    public static String a1;
    public static b.a.p0.a.m1.b b1;
    public static String c1;
    public static String d1;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.p0.a.n2.a I0;
    public b.a.p0.a.m1.b J0;
    public b.a.p0.a.m1.b K0;
    public Map<String, b.a.p0.a.p.e.b> L0;
    public FrameLayout M0;
    public b.a.p0.a.p.e.b N0;
    public b.a.p0.a.s2.b.a O0;
    public b.a.p0.a.c2.b.c.a P0;
    public View Q0;
    public b.a.p0.a.d2.n.g R0;
    public int S0;
    public b.a.p0.a.h0.j.c T0;
    public u0 U0;
    public boolean V0;
    public boolean W0;
    public boolean X0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5462e;

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
            this.f5462e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5462e.U0 = b.a.p0.a.c1.a.Q();
                u0 u0Var = this.f5462e.U0;
                f fVar = this.f5462e;
                u0Var.a(fVar.k0, fVar.m0, fVar.getContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5463a;

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
            this.f5463a = fVar;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String c2 = this.f5463a.N0.c();
                b.a.p0.a.o0.d.h hVar = new b.a.p0.a.o0.d.h();
                hVar.f7457c = b.a.p0.a.a3.g.c.a.a(c2, "scrollViewBackToTop");
                b.a.p0.a.g1.f.U().l(c2, hVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5464e;

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
            this.f5464e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5464e.g3();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.e f5465a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5466b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5467c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5468d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5469e;

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
            this.f5465a = eVar;
            this.f5466b = str;
            this.f5467c = str2;
            this.f5468d = str3;
            this.f5469e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [b.a.p0.a.p.e.c] */
        @Override // b.a.p0.a.h0.t.a.f
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.u.d dVar = new b.a.p0.a.h0.u.d();
                dVar.f6154i = this.f5465a.f6108a.L();
                if (!TextUtils.isEmpty(this.f5466b)) {
                    b.a.p0.a.u1.i.e(this.f5465a, this.f5466b);
                }
                String b2 = b.a.p0.a.f2.f.o0.j.b(this.f5467c);
                dVar.f6146a = this.f5468d;
                if (TextUtils.isEmpty(this.f5469e)) {
                    str = this.f5467c;
                } else {
                    str = this.f5467c + "?" + this.f5469e;
                }
                dVar.f6147b = str;
                if (b.a.p0.a.d2.e.a0() != null) {
                    dVar.f6148c = b.a.p0.a.d2.e.a0().c0(b2);
                    dVar.f6151f = b.a.p0.a.d2.e.a0().W(b2);
                }
                dVar.k = b.a.p0.a.h0.u.a.c(b.a.p0.a.d2.e.L(), dVar.f6147b);
                dVar.f6149d = b.a.p0.a.g1.f.U().e(b2).f4523g;
                dVar.f6150e = String.valueOf(b.a.p0.a.e0.a.a());
                dVar.f6152g = f.Y0 || b.a.p0.a.g1.f.U().N();
                if (b.a.p0.a.x1.a.a.H()) {
                    dVar.j = b.a.p0.a.e0.f.b.d();
                }
                if (!TextUtils.isEmpty(this.f5466b)) {
                    String str2 = this.f5466b;
                    dVar.f6153h = str2;
                    b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).F(new UbcFlowEvent("slave_dispatch_start"));
                }
                d0.d();
                this.f5465a.f6108a.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f5467c);
                this.f5465a.f6108a.T(dVar.f6147b);
                b.a.p0.a.g1.f.U().l(this.f5465a.f6108a.c(), b.a.p0.a.h0.u.d.a(dVar));
                if (b.a.p0.a.h0.u.e.b()) {
                    b.a.p0.a.h0.u.e eVar = new b.a.p0.a.h0.u.e();
                    eVar.f6157a = this.f5465a.f6108a.c();
                    b.a.p0.a.g1.f.U().u(b.a.p0.a.h0.u.e.a(eVar));
                }
                b.a.p0.a.n2.e.F(this.f5465a.f6108a.c(), dVar.f6147b);
                if (f.Y0) {
                    String str3 = "createSlaveAndLoad onReady. pageEvent: " + dVar.toString();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5470e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f5471e;

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
                this.f5471e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5471e.f5470e.W0 = false;
                    this.f5471e.f5470e.y2(true, false);
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
            this.f5470e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null || fVar.f6385d || fVar.j != 1) {
                return;
            }
            q0.e0(new a(this));
        }
    }

    /* renamed from: b.a.p0.a.h0.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0216f implements b.a.p0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5472a;

        public C0216f(f fVar) {
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
            this.f5472a = fVar;
        }

        @Override // b.a.p0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.f5472a.V3(i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements b.a.p0.a.h0.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5473a;

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
            this.f5473a = fVar;
        }

        @Override // b.a.p0.a.h0.j.e
        public void a(b.a.p0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.u(this.f5473a.T0);
            eVar.a0(this.f5473a.v3());
            b.a.p0.a.n1.h.e().a(eVar);
        }

        @Override // b.a.p0.a.h0.j.e
        public void b(b.a.p0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.W(this.f5473a.T0);
            b.a.p0.a.n1.h.e().b(eVar);
        }
    }

    /* loaded from: classes.dex */
    public class h extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f5474c;

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
            this.f5474c = fVar;
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5474c.s2(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f5475a = -1;
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
                if (f5475a < 0) {
                    b.a.p0.a.c1.a.g0().getSwitch("swan_app_fragment_destroy_switch", 1);
                    f5475a = 1;
                }
                if (f.Y0) {
                    String str = "getFragmentDestroySwitch:" + f5475a;
                }
                return f5475a;
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
        Y0 = b.a.p0.a.k.f6863a;
        Z0 = n0.g(149.0f);
        a1 = "-1";
        c1 = "-1";
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
        this.J0 = new b.a.p0.a.m1.b();
        this.L0 = new TreeMap();
        this.S0 = 0;
        this.V0 = false;
        this.W0 = false;
        this.X0 = false;
    }

    public static f J3(b.a.p0.a.m1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            f fVar = new f();
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", cVar.m());
                fVar.g1(bundle);
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static void P3(b.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            try {
                if (Y0) {
                    String str = "setLastPageParams =" + bVar;
                }
                if (bVar == null) {
                    b1 = null;
                } else {
                    b1 = (b.a.p0.a.m1.b) bVar.clone();
                }
            } catch (Exception e2) {
                if (Y0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void R3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            d1 = str;
        }
    }

    private void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (c0()) {
                pause();
            }
            if (Y0) {
                Log.getStackTraceString(new Exception("performPause() wvID: " + this.N0.c()));
            }
        }
    }

    private void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (c0()) {
                resume();
            }
            n nVar = this.p0;
            if (nVar != null && nVar.i()) {
                this.p0.A(b.a.p0.a.c1.a.M().a());
            }
            if (Y0) {
                Log.getStackTraceString(new Exception("performResume() wvID: " + this.N0.c()));
            }
        }
    }

    public boolean A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.p0.a.s2.b.a aVar = this.O0;
            if (aVar == null) {
                return false;
            }
            return aVar.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.B0();
            Map<String, b.a.p0.a.p.e.b> map = this.L0;
            if (map != null && !map.isEmpty()) {
                for (b.a.p0.a.p.e.b bVar : this.L0.values()) {
                    if (bVar != null) {
                        bVar.g0();
                    }
                }
            } else {
                b.a.p0.a.p.e.b bVar2 = this.N0;
                if (bVar2 != null) {
                    bVar2.g0();
                }
            }
            x3();
        }
    }

    public final boolean B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SwanAppConfigData r = b.a.p0.a.g1.f.U().r();
            boolean z = false;
            if (r == null) {
                return false;
            }
            return !((TextUtils.equals(r.f(), this.J0.f7014e) || r.r(this.J0.f7014e)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.C0();
        }
    }

    public final boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.p0.a.d2.n.g gVar = this.R0;
            return gVar != null && gVar.f4524h;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public b.a.p0.a.d2.n.g D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.R0 : (b.a.p0.a.d2.n.g) invokeV.objValue;
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b.a.p0.a.d2.n.g gVar = this.R0;
            if (gVar != null) {
                return TextUtils.equals(gVar.j, SchedulerSupport.CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E3(b.a.p0.a.h0.g.g gVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, gVar, swanAppConfigData)) == null) {
            b.a.p0.a.h0.g.d j = gVar.j(0);
            if (j == null || !(j instanceof f)) {
                return false;
            }
            String f2 = ((f) j).j3().f();
            return swanAppConfigData.r(f2) || TextUtils.equals(swanAppConfigData.f(), f2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean F3() {
        InterceptResult invokeV;
        SwanAppConfigData r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b.a.p0.a.h0.g.g J1 = J1();
            if (J1 == null) {
                return false;
            }
            b.a.p0.a.d2.n.g gVar = this.R0;
            if ((gVar != null && gVar.k) || (r = b.a.p0.a.g1.f.U().r()) == null) {
                return false;
            }
            return !E3(J1, r);
        }
        return invokeV.booleanValue;
    }

    public final boolean G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SwanAppConfigData r = b.a.p0.a.g1.f.U().r();
            return (r == null || TextUtils.equals(r.f(), this.J0.f())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean H3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? (this.L0.isEmpty() || this.L0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void I3(b.a.p0.a.n2.s.g gVar) {
        b.a.p0.a.n2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) || (aVar = this.I0) == null) {
            return;
        }
        b.a.p0.a.n2.n.i(aVar, gVar);
        this.I0 = null;
    }

    @Override // b.a.p0.a.h0.g.d
    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.N0 == null) {
                if (Y0) {
                    Log.getStackTraceString(new Exception("mCurWebViewManager is null."));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.N0.c());
            b.a.p0.a.p.e.e l = this.N0.l();
            if (l != null) {
                hashMap.put("webViewUrl", l.getCurrentPageUrl());
            }
            b.a.p0.a.g1.f.U().u(new b.a.p0.a.o0.d.c("sharebtn", hashMap));
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (getFloatLayer() != null && getFloatLayer().e() && getFloatLayer().f()) {
                return true;
            }
            if ((getFloatLayer() == null || !getFloatLayer().c()) && !PaymentManager.k()) {
                b.a.p0.a.p.e.b bVar = this.N0;
                if (bVar != null) {
                    if (b.a.p0.a.j1.b.g(bVar.c())) {
                        return true;
                    }
                    return this.N0.K();
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
    public final void K3() {
        int i2;
        b.a.p0.a.d2.n.g gVar;
        b.a.p0.a.p.e.c cVar;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.o0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (D3()) {
            y2(true, this.W0);
            i2 = 0;
        } else if (C3()) {
            y2(false, false);
            b.a.p0.a.p.e.b bVar = this.N0;
            if (bVar != null) {
                if (bVar.l() != null) {
                    cVar = this.N0.l().t();
                } else {
                    cVar = this.N0.t();
                }
                if (cVar != null) {
                    i2 = cVar.getWebViewScrollY();
                    gVar = this.R0;
                    if (gVar != null && gVar.f4525i) {
                        i3 = 0;
                    }
                }
            }
            i2 = 0;
            gVar = this.R0;
            if (gVar != null) {
                i3 = 0;
            }
        } else {
            y2(false, false);
            i2 = Z0 + this.S0;
            centerTitleView = this.o0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            V3(i2);
            X3(z);
        }
        z = true;
        centerTitleView = this.o0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        V3(i2);
        X3(z);
    }

    public final void L3() {
        Bundle o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (o = o()) == null) {
            return;
        }
        this.K0 = b1;
        if (Y0) {
            String str = "restoreArguments sPrePageParams=" + this.K0;
        }
        b.a.p0.a.m1.c g2 = b.a.p0.a.m1.c.g(o.getString("ai_apps_param"));
        this.m0 = g2;
        if (g2 == null) {
            b.a.p0.a.m1.b bVar = this.J0;
            bVar.f7014e = "";
            bVar.f7015f = "";
            bVar.f7018i = "";
            bVar.j = "";
        } else {
            this.J0.f7014e = g2.i();
            this.J0.f7015f = this.m0.j();
            this.J0.f7018i = this.m0.l();
            this.J0.j = this.m0.k();
        }
        b.a.p0.a.m1.b bVar2 = this.J0;
        bVar2.f7017h = b.a.p0.a.f2.f.o0.j.b(bVar2.f());
        b.a.p0.a.d2.n.g e2 = b.a.p0.a.g1.f.U().e(this.J0.h());
        this.R0 = e2;
        if (e2.p) {
            this.R0 = b.a.p0.a.g1.f.U().i(this.J0.f());
        }
        if (this.G0) {
            b.a.p0.a.d2.n.g gVar = this.R0;
            gVar.f4522f = false;
            gVar.f4524h = true;
            gVar.p = true;
        }
        this.S0 = G1().getDimensionPixelSize(b.a.p0.a.d.aiapps_normal_base_action_bar_height);
    }

    public final void M3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.N0.c());
            b.a.p0.a.o0.d.d dVar = new b.a.p0.a.o0.d.d(hashMap);
            if (Y0) {
                String str2 = "sendLifecycleMessage type: " + str + " wvID: " + this.N0.c();
            }
            b.a.p0.a.g1.f.U().u(dVar);
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!TextUtils.equals(c1, this.N0.c()) || TextUtils.equals(d1, "switchTab")) {
                int o = this.O0.o(j3().h());
                b.a.p0.a.o0.d.f fVar = new b.a.p0.a.o0.d.f();
                fVar.f7450c = c1;
                fVar.f7451d = this.N0.c();
                fVar.f7452e = d1;
                fVar.f7453f = this.J0.f7014e;
                fVar.f7454g = String.valueOf(o);
                d1 = "";
                if (Y0) {
                    String str = "sendRouteMessage fromId: " + fVar.f7450c + " ,toId: " + fVar.f7451d + " ,RouteType: " + fVar.f7452e + " page:" + fVar.f7453f + ",TabIndex: " + fVar.f7454g;
                }
                b.a.p0.a.g1.f.U().u(fVar);
                c1 = this.N0.c();
            }
        }
    }

    public void O3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.X0 = z;
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            boolean z = Y0;
            b.a.p0.a.z2.d.h();
            if (this.l0.getWindow() != null) {
                this.l0.getWindow().getDecorView().setSystemUiVisibility(5376);
            }
            View b2 = b.a.p0.a.c2.b.a.b();
            if (b2 != null) {
                b2.setVisibility(0);
                b2.findViewById(b.a.p0.a.f.title_shadow).setVisibility(8);
            }
            SwanAppActionBar H1 = H1();
            if (H1 != null) {
                H1.setRightMenuStyle();
                H1.setRightZoneImmersiveStyle();
                H1.setBackgroundColor(0);
            }
            View d0 = d0();
            if (d0 != null) {
                d0.findViewById(b.a.p0.a.f.immersion_custom_statusbar_view).setBackgroundColor(0);
                FrameLayout frameLayout = (FrameLayout) d0.findViewById(b.a.p0.a.f.ai_apps_fragment_content);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void R1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            super.R1(view);
            boolean z = false;
            u2(W1() || B3());
            if (F3()) {
                c2();
            }
            K3();
            this.o0.setOnDoubleClickListener(new b(this));
            if (!b.a.p0.a.n2.e.i()) {
                b.a.p0.a.n2.e.d(b.a.p0.a.d2.d.J().r().V());
            }
            if (D3() && B3()) {
                z = true;
            }
            this.W0 = z;
            if (z) {
                c3();
            }
        }
    }

    public void S3(b.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            if (Y0) {
                String str = "switchTab pageParam: " + bVar;
            }
            if (this.O0.o(j3().h()) == this.O0.o(bVar.h())) {
                b.a.p0.a.m1.b bVar2 = this.J0;
                bVar2.f7018i = bVar.f7018i;
                bVar2.j = bVar.j;
                return;
            }
            this.O0.E(bVar.h());
            onPause();
            i3(bVar, "");
        }
    }

    public final void T3(String str, b.a.p0.a.m1.b bVar) {
        b.a.p0.a.p.e.b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, bVar) == null) || this.N0 == (bVar2 = this.L0.get(str)) || bVar2 == null) {
            return;
        }
        b.a.p0.a.d2.n.g e2 = b.a.p0.a.g1.f.U().e(str);
        bVar2.A(this.M0, e2);
        if (!bVar2.e()) {
            bVar2.Q(this.M0, e2);
        }
        bVar2.D(0);
        b.a.p0.a.p.e.b bVar3 = this.N0;
        if (bVar3 != null) {
            bVar3.D(8);
        }
        this.N0 = bVar2;
        b.a.p0.a.m1.b bVar4 = this.J0;
        bVar4.f7018i = bVar.f7018i;
        bVar4.j = bVar.j;
        bVar2.i(bVar4);
    }

    public final void U3(b.a.p0.a.p.e.b bVar) {
        b.a.p0.a.h0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, bVar) == null) || (cVar = this.T0) == null || bVar == null) {
            return;
        }
        bVar.W(cVar);
        if (bVar.l() != null) {
            bVar.W(this.T0);
        }
    }

    public final void V3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            float f2 = 1.0f;
            float f3 = (i2 - Z0) * 1.0f;
            int i3 = this.S0;
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
            if (Y0 && i4 != 0 && i4 != 255) {
                String str = "update bar transparent degree: " + f2 + ZeusCrashHandler.NAME_SEPERATOR + i4;
            }
            b.a.p0.a.a3.d.b bVar = this.w0;
            if (bVar != null && bVar.i() && (e2 = this.w0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.o0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            b.a.p0.a.d2.n.g gVar = this.R0;
            if (gVar != null && gVar.f4525i && (centerTitleView = this.o0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.r0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void W3() {
        b.a.p0.a.m1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (cVar = this.m0) == null) {
            return;
        }
        cVar.n();
    }

    public final void X3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            int i3 = 0;
            if (z) {
                b.a.p0.a.a3.d.b bVar = this.w0;
                if (bVar != null && bVar.i()) {
                    i2 = n0.t();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.M0.getLayoutParams();
                    layoutParams.topMargin = i3;
                    this.M0.setLayoutParams(layoutParams);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.n0.getLayoutParams();
                    layoutParams2.topMargin = i2;
                    this.n0.setLayoutParams(layoutParams2);
                }
            } else {
                i3 = G1().getDimensionPixelSize(b.a.p0.a.d.aiapps_normal_base_action_bar_height);
            }
            i2 = 0;
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.M0.getLayoutParams();
            layoutParams3.topMargin = i3;
            this.M0.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.n0.getLayoutParams();
            layoutParams22.topMargin = i2;
            this.n0.setLayoutParams(layoutParams22);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void a3(b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) || bVar == null) {
            return;
        }
        b.a.p0.a.h0.j.c cVar = this.T0;
        if (cVar != null) {
            bVar.u(cVar);
        }
        bVar.b0(w3());
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean b2() {
        InterceptResult invokeV;
        SwanAppConfigData r;
        b.a.p0.a.m1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
            if (U == null || (r = U.r()) == null || !r.n() || (cVar = this.m0) == null) {
                return false;
            }
            return r.r(cVar.i());
        }
        return invokeV.booleanValue;
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.I0 = b.a.p0.a.n2.n.c("805");
        }
    }

    public final void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            b.a.p0.a.d2.d.J().r().d0().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final b.a.p0.a.p.e.b d3(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048608, this, str, str2, str3, str4)) == null) {
            boolean z = Y0;
            a.e f2 = b.a.p0.a.h0.t.a.f(getActivity(), b.a.p0.a.h0.t.f.a.c(str2));
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
                q.F(new UbcFlowEvent("na_pre_load_slave_check"));
                q.D("preload", f2.f6109b ? "1" : "0");
            }
            if (Y0) {
                String str5 = "createSlaveAndLoad preloadManager: " + f2;
            }
            b.a.p0.a.h0.t.a.q(f2, new d(this, f2, str4, str2, str, str3));
            boolean z2 = Y0;
            return f2.f6108a;
        }
        return (b.a.p0.a.p.e.b) invokeLLLL.objValue;
    }

    public final void e3(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            b.a.p0.a.u1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
            String h2 = this.m0.h();
            String j = this.m0.j();
            String i2 = this.m0.i();
            String a2 = q0.a(h2, i2, j);
            this.N0 = b.a.p0.a.h0.t.a.h(a2);
            if (Y0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pageUrl: ");
                sb.append(a2);
                sb.append(" is load: ");
                sb.append(this.N0 != null);
                sb.toString();
            }
            if (this.N0 == null) {
                if (Y0) {
                    Log.getStackTraceString(new Exception("createSlaveWebView failed."));
                }
                this.N0 = d3(h2, i2, j, "");
            }
            this.N0.i(this.J0);
            b.a.p0.a.d2.n.g e2 = b.a.p0.a.g1.f.U().e(i2);
            this.N0.A(this.M0, e2);
            this.N0.Q(this.M0, e2);
            y3(i2);
            a3(this.N0);
            if (b2()) {
                this.L0.put(i2, this.N0);
                this.O0.f(view, getContext(), i2);
            }
            b.a.p0.a.u1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
            b3();
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            M1();
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7383e = "gohome";
            fVar.f7381c = "bar";
            f H = b.a.p0.a.g1.f.U().H();
            b.a.p0.a.m1.c K1 = H == null ? null : H.K1();
            if (K1 != null && !TextUtils.isEmpty(K1.i())) {
                fVar.a("page", K1.i());
            }
            x1(fVar);
        }
    }

    public final void f3(b.a.p0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048611, this, bVar, str) == null) && this.L0.get(bVar.f7017h) == null) {
            String a2 = q0.a(bVar.f7016g, bVar.f7014e, bVar.f7015f);
            b.a.p0.a.p.e.b h2 = b.a.p0.a.h0.t.a.h(a2);
            if (h2 != null) {
                if (Y0) {
                    String str2 = "createTabSlaveWebView loaded manager pageUrl: " + a2;
                }
                this.L0.put(bVar.f7014e, h2);
            } else {
                boolean z = Y0;
                h2 = d3(bVar.f7016g, bVar.f7014e, bVar.f7015f, str);
                this.L0.put(bVar.f7014e, h2);
            }
            y3(bVar.f7014e);
            a3(h2);
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            b.a.p0.a.p.e.b bVar = this.N0;
            if (bVar != null) {
                bVar.V();
            }
            z3();
            n3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.q0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(b.a.p0.a.j0.b.a.n(b.a.p0.a.d2.d.J().getAppId()));
            }
            this.p0.t(b.a.p0.a.c1.a.M().a(), E1(), this.q0, false);
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Map<String, b.a.p0.a.p.e.b> map = this.L0;
            if (map != null && !map.isEmpty()) {
                for (b.a.p0.a.p.e.b bVar : this.L0.values()) {
                    if (bVar != null) {
                        U3(bVar);
                        bVar.destroy();
                    }
                }
                this.L0.clear();
            } else {
                b.a.p0.a.p.e.b bVar2 = this.N0;
                if (bVar2 != null) {
                    U3(bVar2);
                    this.N0.destroy();
                }
            }
            this.N0 = null;
            if (Y0) {
                String str = "onDestroy() obj: " + this;
            }
            if (this.V0) {
                return;
            }
            b.a.p0.a.h0.t.a.n(b.a.p0.a.g1.f.U().getActivity());
        }
    }

    @Override // b.a.p0.a.c2.b.c.a.InterfaceC0136a
    public b.a.p0.a.c2.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.P0 == null) {
                if (this.Q0 == null) {
                    return null;
                }
                this.P0 = new b.a.p0.a.c2.b.c.a(this, (LinearLayout) this.Q0.findViewById(b.a.p0.a.f.ai_apps_fragment_base_view), G1().getDimensionPixelOffset(b.a.p0.a.d.aiapps_normal_base_action_bar_height));
            }
            return this.P0;
        }
        return (b.a.p0.a.c2.b.c.a) invokeV.objValue;
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.R0.j = "default";
            s1();
            K3();
        }
    }

    public void i3(b.a.p0.a.m1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, bVar, str) == null) {
            P3(this.J0);
            this.K0 = b1;
            if (Y0) {
                String str2 = "doSwitchTab mPrePageParams=" + this.K0;
            }
            String str3 = bVar.f7014e;
            String str4 = bVar.f7017h;
            b.a.p0.a.d2.n.g e2 = b.a.p0.a.g1.f.U().e(TextUtils.isEmpty(str4) ? "" : str4);
            b.a.p0.a.m1.b bVar2 = this.J0;
            bVar2.f7014e = str3;
            bVar2.f7015f = bVar != null ? bVar.g() : "";
            this.J0.f7017h = str4;
            this.R0 = e2;
            boolean z = !H3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    b.a.p0.a.u1.i.c(7, str);
                } else {
                    b.a.p0.a.u1.i.c(6, str);
                }
            }
            if (!z) {
                T3(str4, bVar);
            } else {
                f3(bVar, str);
                T3(str3, bVar);
            }
            if (!TextUtils.isEmpty(str)) {
                b.a.p0.a.u1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).F(new UbcFlowEvent("na_push_page_end"));
                b.a.p0.a.u1.i.a(str, bVar);
            }
            s2(e2.f4518b);
            z2(SwanAppConfigData.t(e2.f4519c));
            q2(e2.f4517a);
            K3();
            W3();
            b.a.p0.a.e0.d.i("SwanAppFragment", "switch tab title: " + e2.f4518b + " page:" + str3);
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) ? W1() && this.N0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    public PullToRefreshBaseWebView j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            b.a.p0.a.p.e.b bVar = this.N0;
            if (bVar != null) {
                return bVar.j0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048619, this, z) == null) && n0()) {
            super.j1(z);
            if (Y0) {
                String str = "setUserVisibleHint isVisibleToUser: " + z;
            }
            if (z) {
                resume();
                p3(false);
                return;
            }
            pause();
        }
    }

    @NonNull
    public b.a.p0.a.m1.b j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.J0 : (b.a.p0.a.m1.b) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [b.a.p0.a.p.e.c] */
    @NonNull
    public Pair<Integer, Integer> k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            b.a.p0.a.p.e.b bVar = this.N0;
            if (bVar == null) {
                return new Pair<>(0, 0);
            }
            View currentWebView = bVar.t().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public b.a.p0.a.p.e.b l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.N0 : (b.a.p0.a.p.e.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.m2();
            K3();
            if (this.X0) {
                Q3();
            }
        }
    }

    public final int m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? a2() ? G3() ? 18 : 17 : G3() ? 12 : 15 : invokeV.intValue;
    }

    public final void n3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z) == null) && b.a.p0.a.c1.a.K().k(z, 2)) {
            b.a.p0.a.l1.a.l(getContext(), this.p0, this.o0, b.a.p0.a.d2.e.a0().V().f0().paNumber);
        }
    }

    @Nullable
    public b.a.p0.a.m1.b o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.K0 : (b.a.p0.a.m1.b) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onCreate(bundle);
            L3();
            if (Y0) {
                String str = "onCreate() obj: " + this;
            }
            q.j(new a(this), "SwanAppPageHistory");
            b.a.p0.a.u1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onDestroy();
            this.E0.a();
            if (i.b()) {
                q0.q().postAtFrontOfQueue(new c(this));
            } else {
                g3();
            }
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onPause();
            Y0();
        }
    }

    @Override // b.a.p0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            b1();
            p3(false);
        }
    }

    public final void p3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            if (b.a.p0.a.c1.a.K().k(z, 1)) {
                b.a.p0.a.l1.a.k(getContext(), this.o0, b.a.p0.a.d2.e.a0().V().f0().paNumber);
            } else if (b.a.p0.a.d2.e.a0() == null) {
            } else {
                b.a.p0.a.l1.a.o(this.o0, b.a.p0.a.d2.e.a0().T().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    public void pause() {
        PullToRefreshBaseWebView j0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            boolean z = this.N0 == null;
            String c2 = z ? "" : this.N0.c();
            if (Y0) {
                String str = "pause() wvID: " + c2;
            }
            if (!z) {
                this.N0.onPause();
                M3("onHide");
                b.a.p0.a.n1.h.e().i(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().c() && (!getFloatLayer().f() || getFloatLayer().j())) {
                getFloatLayer().g();
            }
            b.a.p0.a.e0.d.i("SwanApp", "onHide");
            b.a.p0.a.j1.b.i(c2, false);
            if (!z && (j0 = this.N0.j0()) != null) {
                j0.onPullDownRefreshComplete(false);
            }
            b.a.p0.a.c1.a.H().f(b.a.p0.a.d2.e.a0() != null ? b.a.p0.a.d2.e.a0().N() : "");
        }
    }

    @Override // b.a.p0.a.h0.g.d
    public boolean q2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            boolean q2 = super.q2(i2);
            K3();
            return q2;
        }
        return invokeI.booleanValue;
    }

    public String q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            b.a.p0.a.p.e.b bVar = this.N0;
            return bVar != null ? bVar.c() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<String> r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, b.a.p0.a.p.e.b> map = this.L0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, b.a.p0.a.p.e.b> entry : this.L0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().c());
                    }
                }
            }
            b.a.p0.a.p.e.b bVar = this.N0;
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

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            boolean z = false;
            boolean z2 = this.N0 == null;
            String c2 = z2 ? "" : this.N0.c();
            if (Y0) {
                String str = "resume() wvID: " + c2;
            }
            if (!z2) {
                u2((W1() || B3()) ? true : true);
                this.N0.onResume();
                N3();
                M3("onShow");
                b.a.p0.a.n1.h.e().i(true);
            }
            b.a.p0.a.e0.d.i("SwanApp", "onShow");
            b.a.p0.a.j1.b.i(c2, true);
            if (b.a.p0.a.e0.d.f()) {
                b.a.p0.a.h0.e.b.b();
            }
            b.a.p0.a.c1.a.H().e(b.a.p0.a.d2.e.a0() != null ? b.a.p0.a.d2.e.a0().N() : "");
        }
    }

    @Nullable
    public b.a.p0.a.s2.b.a s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.O0 : (b.a.p0.a.s2.b.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.d
    public void t1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            if (!b.a.p0.a.d2.n.g.f(this.R0)) {
                super.t1(i2);
                return;
            }
            u1(i2, D3() ? true : true ^ f0.h(this.l0));
            K3();
        }
    }

    public String t3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, str)) == null) {
            if (this.L0.containsKey(str)) {
                return this.L0.get(str).c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, activity) == null) {
            super.u0(activity);
            if (Y0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }

    public FrameLayout u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.M0 : (FrameLayout) invokeV.objValue;
    }

    public final b.a.p0.a.h0.j.a v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? new h(this) : (b.a.p0.a.h0.j.a) invokeV.objValue;
    }

    public final b.a.p0.a.h0.j.e w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? new g(this) : (b.a.p0.a.h0.j.e) invokeV.objValue;
    }

    public final void x3() {
        b.a.p0.a.y0.j.b H0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            b.a.p0.a.p.e.b l3 = l3();
            if (!(l3 instanceof SwanAppWebViewManager) || (H0 = ((SwanAppWebViewManager) l3).H0()) == null) {
                return;
            }
            H0.d();
        }
    }

    public final void y3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, str) == null) || D3()) {
            return;
        }
        b.a.p0.a.g1.f U = b.a.p0.a.g1.f.U();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (U.e(str).f4524h && this.T0 == null) {
            this.T0 = new C0216f(this);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048646, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.p0.a.u1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
            View b2 = b.a.p0.a.u1.n.a.a().b(b.a.p0.a.g.aiapps_fragment, viewGroup, false);
            this.M0 = (FrameLayout) b2.findViewById(b.a.p0.a.f.ai_apps_fragment_content);
            R1(b2);
            Q2(b2);
            this.O0 = new b.a.p0.a.s2.b.a(this);
            e3(b2);
            if (!b.a.p0.a.k1.f.b.e() && !b.a.p0.a.k1.f.b.f()) {
                b.a.p0.a.k1.f.a.b(this.N0.c(), String.valueOf(b.a.p0.a.k1.f.b.d()), String.valueOf(b.a.p0.a.k1.f.b.a(b.a.p0.a.k1.f.b.b())));
            }
            if (Q1()) {
                b2 = T1(b2);
            }
            this.Q0 = A1(b2, this);
            D2(this.N0.B());
            b.a.p0.a.n1.h.e().m();
            return this.Q0;
        }
        return (View) invokeLLL.objValue;
    }

    @DebugTrace
    public void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.q0 == null) {
                this.q0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity == null || this.p0 != null) {
                return;
            }
            this.p0 = new n(activity, this.o0, m3(), b.a.p0.a.c1.a.K(), new b.a.p0.a.a3.h.b());
            new b.a.p0.a.k1.a(this.p0, this, this.q0).z();
            if (b.a.p0.a.k1.f.b.e()) {
                this.p0.l(50);
            }
        }
    }
}
