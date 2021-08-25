package c.a.o0.a.h0.g;

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
import c.a.o0.a.h0.t.a;
import c.a.o0.a.p.d.q0;
import c.a.o0.a.v2.d0;
import c.a.o0.a.v2.f0;
import c.a.o0.a.v2.n0;
import c.a.o0.a.v2.q;
import c.a.o0.a.z1.b.c.a;
import c.a.o0.k.n;
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
public class f extends c.a.o0.a.h0.g.d implements a.InterfaceC0481a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean R0;
    public static final int S0;
    public static String T0;
    public static c.a.o0.a.l1.b U0;
    public static String V0;
    public static String W0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.a.j2.a C0;
    public c.a.o0.a.l1.b D0;
    public c.a.o0.a.l1.b E0;
    public Map<String, c.a.o0.a.p.e.b> F0;
    public FrameLayout G0;
    public c.a.o0.a.p.e.b H0;
    public c.a.o0.a.o2.b.a I0;
    public c.a.o0.a.z1.b.c.a J0;
    public View K0;
    public c.a.o0.a.a2.n.g L0;
    public int M0;
    public c.a.o0.a.h0.j.c N0;
    public q0 O0;
    public boolean P0;
    public boolean Q0;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5883e;

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
            this.f5883e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5883e.O0 = c.a.o0.a.c1.a.L();
                q0 q0Var = this.f5883e.O0;
                f fVar = this.f5883e;
                q0Var.a(fVar.l0, fVar.q());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements SwanAppActionBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5884a;

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
            this.f5884a = fVar;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
        @Override // com.baidu.swan.apps.view.SwanAppActionBar.c
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String c2 = this.f5884a.H0.c();
                c.a.o0.a.o0.d.g gVar = new c.a.o0.a.o0.d.g();
                gVar.f7786c = c.a.o0.a.w2.g.c.a.a(c2, "scrollViewBackToTop");
                c.a.o0.a.g1.f.V().m(c2, gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5885e;

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
            this.f5885e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5885e.U2();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.d f5886a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5887b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5888c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5889d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f5891f;

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
            this.f5891f = fVar;
            this.f5886a = dVar;
            this.f5887b = str;
            this.f5888c = str2;
            this.f5889d = str3;
            this.f5890e = str4;
        }

        /* JADX WARN: Type inference failed for: r1v19, types: [c.a.o0.a.p.e.c] */
        @Override // c.a.o0.a.h0.t.a.e
        public void onReady() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.a.h0.u.d dVar = new c.a.o0.a.h0.u.d();
                dVar.f6450i = this.f5886a.f6409a.K();
                if (!TextUtils.isEmpty(this.f5887b)) {
                    c.a.o0.a.r1.i.e(this.f5886a, this.f5887b);
                }
                String b2 = c.a.o0.a.c2.f.p0.j.b(this.f5888c);
                dVar.f6442a = this.f5889d;
                if (TextUtils.isEmpty(this.f5890e)) {
                    str = this.f5888c;
                } else {
                    str = this.f5888c + "?" + this.f5890e;
                }
                dVar.f6443b = str;
                if (c.a.o0.a.a2.e.Q() != null) {
                    dVar.f6444c = c.a.o0.a.a2.e.Q().S(b2);
                    dVar.f6447f = c.a.o0.a.a2.e.Q().M(b2);
                }
                dVar.k = c.a.o0.a.h0.u.a.c(c.a.o0.a.a2.e.i(), dVar.f6443b);
                dVar.f6445d = c.a.o0.a.g1.f.V().e(b2).f4581g;
                dVar.f6446e = String.valueOf(c.a.o0.a.e0.a.a());
                dVar.f6448g = f.R0 || c.a.o0.a.g1.f.V().O();
                if (c.a.o0.a.u1.a.a.G()) {
                    dVar.f6451j = c.a.o0.a.e0.f.b.d();
                }
                if (!TextUtils.isEmpty(this.f5887b)) {
                    String str2 = this.f5887b;
                    dVar.f6449h = str2;
                    c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str2).C(new UbcFlowEvent("slave_dispatch_start"));
                }
                d0.d();
                this.f5886a.f6409a.t().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, this.f5888c);
                this.f5886a.f6409a.R(dVar.f6443b);
                c.a.o0.a.g1.f.V().m(this.f5886a.f6409a.c(), c.a.o0.a.h0.u.d.a(dVar));
                if (c.a.o0.a.h0.u.e.b()) {
                    c.a.o0.a.h0.u.e eVar = new c.a.o0.a.h0.u.e();
                    eVar.f6454a = this.f5886a.f6409a.c();
                    c.a.o0.a.g1.f.V().v(c.a.o0.a.h0.u.e.a(eVar));
                }
                c.a.o0.a.j2.e.F(this.f5886a.f6409a.c(), dVar.f6443b);
                if (f.R0) {
                    String str3 = "createSlaveAndLoad onReady. pageEvent: " + dVar.toString();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f5892e;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f5893e;

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
                this.f5893e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5893e.f5892e.Q0 = false;
                    this.f5893e.f5892e.q2(true, false);
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
            this.f5892e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null || fVar.f5513d || fVar.f5519j != 1) {
                return;
            }
            c.a.o0.a.v2.q0.b0(new a(this));
        }
    }

    /* renamed from: c.a.o0.a.h0.g.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0212f implements c.a.o0.a.h0.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5894a;

        public C0212f(f fVar) {
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
            this.f5894a = fVar;
        }

        @Override // c.a.o0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) {
                this.f5894a.H3(i3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements c.a.o0.a.h0.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f5895a;

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
            this.f5895a = fVar;
        }

        @Override // c.a.o0.a.h0.j.e
        public void a(c.a.o0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.u(this.f5895a.N0);
            eVar.Y(this.f5895a.j3());
            c.a.o0.a.m1.g.f().a(eVar);
        }

        @Override // c.a.o0.a.h0.j.e
        public void b(c.a.o0.a.p.e.e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || eVar == null) {
                return;
            }
            eVar.U(this.f5895a.N0);
            c.a.o0.a.m1.g.f().b(eVar);
        }
    }

    /* loaded from: classes.dex */
    public class h extends c.a.o0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f5896c;

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
            this.f5896c = fVar;
        }

        @Override // c.a.o0.a.h0.j.a, c.a.o0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f5896c.l2(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f5897a = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1309416201, "Lc/a/o0/a/h0/g/f$i;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1309416201, "Lc/a/o0/a/h0/g/f$i;");
            }
        }

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f5897a < 0) {
                    c.a.o0.a.c1.a.Z().getSwitch("swan_app_fragment_destroy_switch", 1);
                    f5897a = 1;
                }
                if (f.R0) {
                    String str = "getFragmentDestroySwitch:" + f5897a;
                }
                return f5897a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(957786094, "Lc/a/o0/a/h0/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(957786094, "Lc/a/o0/a/h0/g/f;");
                return;
            }
        }
        R0 = c.a.o0.a.k.f7049a;
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
        this.D0 = new c.a.o0.a.l1.b();
        this.F0 = new TreeMap();
        this.M0 = 0;
        this.P0 = false;
        this.Q0 = false;
    }

    public static void C3(c.a.o0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            try {
                if (R0) {
                    String str = "setLastPageParams =" + bVar;
                }
                if (bVar == null) {
                    U0 = null;
                } else {
                    U0 = (c.a.o0.a.l1.b) bVar.clone();
                }
            } catch (Exception e2) {
                if (R0) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void D3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            W0 = str;
        }
    }

    private void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (e0()) {
                pause();
            }
            if (R0) {
                Log.getStackTraceString(new Exception("performPause() wvID: " + this.H0.c()));
            }
        }
    }

    private void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (e0()) {
                resume();
            }
            n nVar = this.o0;
            if (nVar != null && nVar.g()) {
                this.o0.x(c.a.o0.a.c1.a.H().a());
            }
            if (R0) {
                Log.getStackTraceString(new Exception("performResume() wvID: " + this.H0.c()));
            }
        }
    }

    public static f x3(c.a.o0.a.l1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, cVar)) == null) {
            f fVar = new f();
            if (cVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("ai_apps_param", cVar.i());
                fVar.h1(bundle);
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.H0 == null) {
                if (R0) {
                    Log.getStackTraceString(new Exception("mCurWebViewManager is null."));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0.c());
            c.a.o0.a.p.e.e l = this.H0.l();
            if (l != null) {
                hashMap.put("webViewUrl", l.getCurrentPageUrl());
            }
            c.a.o0.a.g1.f.V().v(new c.a.o0.a.o0.d.b("sharebtn", hashMap));
        }
    }

    public final void A3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", str);
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, this.H0.c());
            c.a.o0.a.o0.d.c cVar = new c.a.o0.a.o0.d.c(hashMap);
            if (R0) {
                String str2 = "sendLifecycleMessage type: " + str + " wvID: " + this.H0.c();
            }
            c.a.o0.a.g1.f.V().v(cVar);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.B0();
            Map<String, c.a.o0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (c.a.o0.a.p.e.b bVar : this.F0.values()) {
                    if (bVar != null) {
                        bVar.e0();
                    }
                }
            } else {
                c.a.o0.a.p.e.b bVar2 = this.H0;
                if (bVar2 != null) {
                    bVar2.e0();
                }
            }
            l3();
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public c.a.o0.a.a2.n.g B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.L0 : (c.a.o0.a.a2.n.g) invokeV.objValue;
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!TextUtils.equals(V0, this.H0.c()) || TextUtils.equals(W0, "switchTab")) {
                int o = this.I0.o(X2().j());
                c.a.o0.a.o0.d.e eVar = new c.a.o0.a.o0.d.e();
                eVar.f7779c = V0;
                eVar.f7780d = this.H0.c();
                eVar.f7781e = W0;
                eVar.f7782f = this.D0.f7208e;
                eVar.f7783g = String.valueOf(o);
                W0 = "";
                if (R0) {
                    String str = "sendRouteMessage fromId: " + eVar.f7779c + " ,toId: " + eVar.f7780d + " ,RouteType: " + eVar.f7781e + " page:" + eVar.f7782f + ",TabIndex: " + eVar.f7783g;
                }
                c.a.o0.a.g1.f.V().v(eVar);
                V0 = this.H0.c();
            }
        }
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.C0();
        }
    }

    public void E3(c.a.o0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            if (R0) {
                String str = "switchTab pageParam: " + bVar;
            }
            if (this.I0.o(X2().j()) == this.I0.o(bVar.j())) {
                return;
            }
            this.I0.E(bVar.j());
            onPause();
            W2(bVar, "");
        }
    }

    public final void F3(String str) {
        c.a.o0.a.p.e.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.H0 == (bVar = this.F0.get(str)) || bVar == null) {
            return;
        }
        c.a.o0.a.a2.n.g e2 = c.a.o0.a.g1.f.V().e(str);
        bVar.A(this.G0, e2);
        if (!bVar.e()) {
            bVar.P(this.G0, e2);
        }
        bVar.D(0);
        c.a.o0.a.p.e.b bVar2 = this.H0;
        if (bVar2 != null) {
            bVar2.D(8);
        }
        this.H0 = bVar;
        bVar.i(this.D0);
    }

    public final void G3(c.a.o0.a.p.e.b bVar) {
        c.a.o0.a.h0.j.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || (cVar = this.N0) == null || bVar == null) {
            return;
        }
        bVar.U(cVar);
        if (bVar.l() != null) {
            bVar.U(this.N0);
        }
    }

    public final void H3(int i2) {
        TextView centerTitleView;
        View e2;
        Drawable background;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
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
            c.a.o0.a.w2.d.b bVar = this.s0;
            if (bVar != null && bVar.i() && (e2 = this.s0.e()) != null && (background = e2.getBackground()) != null) {
                background.setAlpha(i4);
            }
            Drawable background2 = this.n0.getBackground();
            if (background2 != null) {
                background2.setAlpha(i4);
            }
            c.a.o0.a.a2.n.g gVar = this.L0;
            if (gVar != null && gVar.f4583i && (centerTitleView = this.n0.getCenterTitleView()) != null) {
                centerTitleView.setAlpha(f2);
            }
            Drawable background3 = this.q0.getBackground();
            if (background3 != null) {
                background3.setAlpha(i4);
            }
        }
    }

    public void I3() {
        c.a.o0.a.l1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.l0) == null) {
            return;
        }
        cVar.j();
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if ((getFloatLayer() == null || !getFloatLayer().d()) && !c.a.d0.a.j()) {
                c.a.o0.a.p.e.b bVar = this.H0;
                if (bVar != null) {
                    if (c.a.o0.a.i1.b.g(bVar.c())) {
                        return true;
                    }
                    return this.H0.J();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void J3(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            int i3 = 0;
            if (z) {
                c.a.o0.a.w2.d.b bVar = this.s0;
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
                i3 = E1().getDimensionPixelSize(c.a.o0.a.d.aiapps_normal_base_action_bar_height);
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

    @Override // c.a.o0.a.h0.g.d
    public void O1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            super.O1(view);
            boolean z = false;
            n2(T1() || p3());
            if (t3()) {
                Y1();
            }
            y3();
            this.n0.setOnDoubleClickListener(new b(this));
            if (!c.a.o0.a.j2.e.i()) {
                c.a.o0.a.j2.e.d(c.a.o0.a.a2.d.g().r().L());
            }
            if (r3() && p3()) {
                z = true;
            }
            this.Q0 = z;
            if (z) {
                Q2();
            }
        }
    }

    public final void O2(c.a.o0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) || bVar == null) {
            return;
        }
        c.a.o0.a.h0.j.c cVar = this.N0;
        if (cVar != null) {
            bVar.u(cVar);
        }
        bVar.Z(k3());
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.C0 = c.a.o0.a.j2.k.c("805");
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.o0.a.a2.d.g().r().T().e("mapp_i_custom_navigation_bar", new e(this));
        }
    }

    public final c.a.o0.a.p.e.b R2(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048593, this, str, str2, str3, str4)) == null) {
            boolean z = R0;
            a.d f2 = c.a.o0.a.h0.t.a.f(h());
            if (!TextUtils.isEmpty(str4)) {
                HybridUbcFlow q = c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str4);
                q.C(new UbcFlowEvent("na_pre_load_slave_check"));
                q.A("preload", f2.f6410b ? "1" : "0");
            }
            if (R0) {
                String str5 = "createSlaveAndLoad preloadManager: " + f2;
            }
            c.a.o0.a.h0.t.a.n(f2, new d(this, f2, str4, str2, str, str3));
            boolean z2 = R0;
            return f2.f6409a;
        }
        return (c.a.o0.a.p.e.b) invokeLLLL.objValue;
    }

    public final void S2(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            c.a.o0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView start.");
            String f2 = this.l0.f();
            String h2 = this.l0.h();
            String g2 = this.l0.g();
            String a2 = c.a.o0.a.v2.q0.a(f2, g2, h2);
            this.H0 = c.a.o0.a.h0.t.a.h(a2);
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
                this.H0 = R2(f2, g2, h2, "");
            }
            this.H0.i(this.D0);
            c.a.o0.a.a2.n.g e2 = c.a.o0.a.g1.f.V().e(g2);
            c.a.o0.a.e0.d.g("SwanAppFragment", "create slave webview: " + g2);
            this.H0.A(this.G0, e2);
            this.H0.P(this.G0, e2);
            m3(g2);
            O2(this.H0);
            if (X1()) {
                this.F0.put(g2, this.H0);
                this.I0.f(view, q(), g2);
            }
            c.a.o0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "createSlaveWebView end.");
            P2();
        }
    }

    public final void T2(c.a.o0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, bVar, str) == null) && this.F0.get(bVar.f7211h) == null) {
            String a2 = c.a.o0.a.v2.q0.a(bVar.f7210g, bVar.f7208e, bVar.f7209f);
            c.a.o0.a.p.e.b h2 = c.a.o0.a.h0.t.a.h(a2);
            if (h2 != null) {
                if (R0) {
                    String str2 = "createTabSlaveWebView loaded manager pageUrl: " + a2;
                }
                this.F0.put(bVar.f7208e, h2);
            } else {
                boolean z = R0;
                h2 = R2(bVar.f7210g, bVar.f7208e, bVar.f7209f, str);
                this.F0.put(bVar.f7208e, h2);
            }
            m3(bVar.f7208e);
            O2(h2);
        }
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Map<String, c.a.o0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (c.a.o0.a.p.e.b bVar : this.F0.values()) {
                    if (bVar != null) {
                        G3(bVar);
                        bVar.destroy();
                    }
                }
                this.F0.clear();
            } else {
                c.a.o0.a.p.e.b bVar2 = this.H0;
                if (bVar2 != null) {
                    G3(bVar2);
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
            c.a.o0.a.h0.t.a.l(c.a.o0.a.g1.f.V().getActivity());
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.L0.f4584j = "default";
            r1();
            y3();
        }
    }

    public void W2(c.a.o0.a.l1.b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, bVar, str) == null) {
            C3(this.D0);
            this.E0 = U0;
            if (R0) {
                String str2 = "doSwitchTab mPrePageParams=" + this.E0;
            }
            String str3 = bVar.f7208e;
            String str4 = bVar.f7211h;
            c.a.o0.a.a2.n.g e2 = c.a.o0.a.g1.f.V().e(TextUtils.isEmpty(str4) ? "" : str4);
            c.a.o0.a.l1.b bVar2 = this.D0;
            bVar2.f7208e = str3;
            bVar2.f7209f = bVar != null ? bVar.i() : "";
            this.D0.f7211h = str4;
            this.L0 = e2;
            boolean z = !v3(str4);
            if (!TextUtils.isEmpty(str)) {
                if (z) {
                    c.a.o0.a.r1.i.c(7, str);
                } else {
                    c.a.o0.a.r1.i.c(6, str);
                }
            }
            if (!z) {
                F3(str4);
            } else {
                T2(bVar, str);
                F3(str3);
            }
            if (!TextUtils.isEmpty(str)) {
                c.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str).C(new UbcFlowEvent("na_push_page_end"));
                c.a.o0.a.r1.i.a(str, bVar);
            }
            l2(e2.f4576b);
            r2(SwanAppConfigData.s(e2.f4577c));
            j2(e2.f4575a);
            y3();
            I3();
            c.a.o0.a.e0.d.g("SwanAppFragment", "switch tab title: " + e2.f4576b + " page:" + str3);
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean X1() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        c.a.o0.a.l1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            c.a.o0.a.g1.f V = c.a.o0.a.g1.f.V();
            if (V == null || (s = V.s()) == null || !s.m() || (cVar = this.l0) == null) {
                return false;
            }
            return s.q(cVar.g());
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public c.a.o0.a.l1.b X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.D0 : (c.a.o0.a.l1.b) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [c.a.o0.a.p.e.c] */
    @NonNull
    public Pair<Integer, Integer> Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            c.a.o0.a.p.e.b bVar = this.H0;
            if (bVar == null) {
                return new Pair<>(0, 0);
            }
            AbsoluteLayout currentWebView = bVar.t().getCurrentWebView();
            return currentWebView == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(currentWebView.getWidth()), Integer.valueOf(currentWebView.getHeight()));
        }
        return (Pair) invokeV.objValue;
    }

    public c.a.o0.a.p.e.b Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.H0 : (c.a.o0.a.p.e.b) invokeV.objValue;
    }

    public final int a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? W1() ? u3() ? 18 : 17 : u3() ? 12 : 15 : invokeV.intValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            J1();
            c.a.o0.a.j2.p.f fVar = new c.a.o0.a.j2.p.f();
            fVar.f7039e = "gohome";
            fVar.f7037c = "bar";
            f J = c.a.o0.a.g1.f.V().J();
            c.a.o0.a.l1.c I1 = J == null ? null : J.I1();
            if (I1 != null && !TextUtils.isEmpty(I1.g())) {
                fVar.a("page", I1.g());
            }
            w1(fVar);
        }
    }

    public final void b3(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z) == null) && c.a.o0.a.c1.a.G().i(z, 2)) {
            c.a.o0.a.k1.a.l(q(), this.o0, c.a.o0.a.a2.e.Q().L().f0().paNumber);
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.H0.T();
            n3();
            b3(true);
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.p0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(c.a.o0.a.j0.b.a.n(c.a.o0.a.a2.d.g().getAppId()));
            }
            this.o0.r(c.a.o0.a.c1.a.H().a(), C1(), this.p0, false);
        }
    }

    @Nullable
    public c.a.o0.a.l1.b c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.E0 : (c.a.o0.a.l1.b) invokeV.objValue;
    }

    public final void d3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (c.a.o0.a.c1.a.G().i(z, 1)) {
                c.a.o0.a.k1.a.k(q(), this.n0, c.a.o0.a.a2.e.Q().L().f0().paNumber);
            } else if (c.a.o0.a.a2.e.Q() == null) {
            } else {
                c.a.o0.a.k1.a.o(this.n0, c.a.o0.a.a2.e.Q().J().d("key_unread_counts_message", 0).intValue());
            }
        }
    }

    public String e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            c.a.o0.a.p.e.b bVar = this.H0;
            return bVar != null ? bVar.c() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<String> f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Map<String, c.a.o0.a.p.e.b> map = this.F0;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, c.a.o0.a.p.e.b> entry : this.F0.entrySet()) {
                    if (entry != null) {
                        arrayList.add(entry.getValue().c());
                    }
                }
            }
            c.a.o0.a.p.e.b bVar = this.H0;
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

    public PullToRefreshBaseWebView g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            c.a.o0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                return bVar.g0();
            }
            return null;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.g2();
            y3();
        }
    }

    @Nullable
    public c.a.o0.a.o2.b.a g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.I0 : (c.a.o0.a.o2.b.a) invokeV.objValue;
    }

    @Override // c.a.o0.a.z1.b.c.a.InterfaceC0481a
    public c.a.o0.a.z1.b.c.a getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.J0 == null) {
                if (this.K0 == null) {
                    return null;
                }
                this.J0 = new c.a.o0.a.z1.b.c.a(this, (LinearLayout) this.K0.findViewById(c.a.o0.a.f.ai_apps_fragment_base_view), E1().getDimensionPixelOffset(c.a.o0.a.d.aiapps_normal_base_action_bar_height));
            }
            return this.J0;
        }
        return (c.a.o0.a.z1.b.c.a) invokeV.objValue;
    }

    public String h3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            if (this.F0.containsKey(str)) {
                return this.F0.get(str).c();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public FrameLayout i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.G0 : (FrameLayout) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, motionEvent)) == null) ? T1() && this.H0.isSlidable(motionEvent) : invokeL.booleanValue;
    }

    @Override // c.a.o0.a.h0.g.d
    public boolean j2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            boolean j2 = super.j2(i2);
            y3();
            return j2;
        }
        return invokeI.booleanValue;
    }

    public final c.a.o0.a.h0.j.a j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? new h(this) : (c.a.o0.a.h0.j.a) invokeV.objValue;
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048621, this, z) == null) && n0()) {
            super.k1(z);
            if (R0) {
                String str = "setUserVisibleHint isVisibleToUser: " + z;
            }
            if (z) {
                resume();
                d3(false);
                return;
            }
            pause();
        }
    }

    public final c.a.o0.a.h0.j.e k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? new g(this) : (c.a.o0.a.h0.j.e) invokeV.objValue;
    }

    public final void l3() {
        c.a.o0.a.y0.j.b E0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            c.a.o0.a.p.e.b Z2 = Z2();
            if (!(Z2 instanceof SwanAppWebViewManager) || (E0 = ((SwanAppWebViewManager) Z2).E0()) == null) {
                return;
            }
            E0.d();
        }
    }

    public final void m3(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || r3()) {
            return;
        }
        c.a.o0.a.g1.f V = c.a.o0.a.g1.f.V();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (V.e(str).f4582h && this.N0 == null) {
            this.N0 = new C0212f(this);
        }
    }

    @DebugTrace
    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            FragmentActivity h2 = h();
            if (this.p0 == null) {
                this.p0 = new SwanAppMenuHeaderView(q());
            }
            if (h2 == null || this.o0 != null) {
                return;
            }
            this.o0 = new n(h2, this.n0, a3(), c.a.o0.a.c1.a.G(), new c.a.o0.a.w2.h.b());
            new c.a.o0.a.j1.a(this.o0, this, this.p0).z();
            if (c.a.o0.a.j1.e.b.d()) {
                this.o0.j(50);
            }
        }
    }

    public boolean o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            c.a.o0.a.o2.b.a aVar = this.I0;
            if (aVar == null) {
                return false;
            }
            return aVar.p();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onCreate(bundle);
            z3();
            if (R0) {
                String str = "onCreate() obj: " + this;
            }
            q.i(new a(this), "SwanAppPageHistory");
            c.a.o0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment create.");
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onDestroy();
            if (i.b()) {
                c.a.o0.a.v2.q0.q().postAtFrontOfQueue(new c(this));
            } else {
                U2();
            }
        }
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onPause();
            Y0();
        }
    }

    @Override // c.a.o0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
            b1();
            d3(false);
        }
    }

    public final boolean p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            SwanAppConfigData s = c.a.o0.a.g1.f.V().s();
            boolean z = false;
            if (s == null) {
                return false;
            }
            return !((TextUtils.equals(s.e(), this.D0.f7208e) || s.q(this.D0.f7208e)) ? true : true);
        }
        return invokeV.booleanValue;
    }

    public void pause() {
        PullToRefreshBaseWebView g0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            boolean z = this.H0 == null;
            String c2 = z ? "" : this.H0.c();
            if (R0) {
                String str = "pause() wvID: " + c2;
            }
            if (!z) {
                this.H0.onPause();
                A3("onHide");
                c.a.o0.a.m1.g.f().k(false);
            }
            if (getFloatLayer() != null && !getFloatLayer().d()) {
                getFloatLayer().g();
            }
            c.a.o0.a.e0.d.g("SwanApp", "onHide");
            c.a.o0.a.i1.b.i(false);
            if (!z && (g0 = this.H0.g0()) != null) {
                g0.onPullDownRefreshComplete(false);
            }
            c.a.o0.a.c1.a.D().f(c.a.o0.a.a2.e.Q() != null ? c.a.o0.a.a2.e.Q().D() : "");
        }
    }

    public final boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            c.a.o0.a.a2.n.g gVar = this.L0;
            return gVar != null && gVar.f4582h;
        }
        return invokeV.booleanValue;
    }

    public boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            c.a.o0.a.a2.n.g gVar = this.L0;
            if (gVar != null) {
                return TextUtils.equals(gVar.f4584j, SchedulerSupport.CUSTOM);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            boolean z = false;
            boolean z2 = this.H0 == null;
            String c2 = z2 ? "" : this.H0.c();
            if (R0) {
                String str = "resume() wvID: " + c2;
            }
            if (!z2) {
                n2((T1() || p3()) ? true : true);
                this.H0.onResume();
                B3();
                A3("onShow");
                c.a.o0.a.m1.g.f().k(true);
            }
            c.a.o0.a.e0.d.g("SwanApp", "onShow");
            c.a.o0.a.i1.b.i(true);
            if (c.a.o0.a.e0.d.d()) {
                c.a.o0.a.h0.e.b.b();
            }
            c.a.o0.a.c1.a.D().e(c.a.o0.a.a2.e.Q() != null ? c.a.o0.a.a2.e.Q().D() : "");
        }
    }

    @Override // c.a.o0.a.h0.g.d
    public void s1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            if (!c.a.o0.a.a2.n.g.f(this.L0)) {
                super.s1(i2);
                return;
            }
            t1(i2, r3() ? true : true ^ f0.h(this.k0));
            y3();
        }
    }

    public final boolean s3(c.a.o0.a.h0.g.g gVar, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, gVar, swanAppConfigData)) == null) {
            c.a.o0.a.h0.g.d j2 = gVar.j(0);
            if (j2 == null || !(j2 instanceof f)) {
                return false;
            }
            String h2 = ((f) j2).X2().h();
            return swanAppConfigData.q(h2) || TextUtils.equals(swanAppConfigData.e(), h2);
        }
        return invokeLL.booleanValue;
    }

    public final boolean t3() {
        InterceptResult invokeV;
        SwanAppConfigData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            c.a.o0.a.h0.g.g H1 = H1();
            if (H1 == null) {
                return false;
            }
            c.a.o0.a.a2.n.g gVar = this.L0;
            if ((gVar != null && gVar.k) || (s = c.a.o0.a.g1.f.V().s()) == null) {
                return false;
            }
            return !s3(H1, s);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, activity) == null) {
            super.u0(activity);
            if (R0) {
                String str = "onAttach() obj: " + this;
            }
        }
    }

    public final boolean u3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            SwanAppConfigData s = c.a.o0.a.g1.f.V().s();
            return (s == null || TextUtils.equals(s.e(), this.D0.h())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean v3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) ? (this.F0.isEmpty() || this.F0.get(str) == null) ? false : true : invokeL.booleanValue;
    }

    public void w3(c.a.o0.a.j2.p.g gVar) {
        c.a.o0.a.j2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, gVar) == null) || (aVar = this.C0) == null) {
            return;
        }
        c.a.o0.a.j2.k.i(aVar, gVar);
        this.C0 = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y3() {
        int i2;
        c.a.o0.a.a2.n.g gVar;
        c.a.o0.a.p.e.c cVar;
        TextView centerTitleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || this.n0 == null) {
            return;
        }
        int i3 = 1;
        boolean z = false;
        if (r3()) {
            q2(true, this.Q0);
            i2 = 0;
        } else if (q3()) {
            q2(false, false);
            c.a.o0.a.p.e.b bVar = this.H0;
            if (bVar != null) {
                if (bVar.l() != null) {
                    cVar = this.H0.l().t();
                } else {
                    cVar = this.H0.t();
                }
                if (cVar != null) {
                    i2 = cVar.getWebViewScrollY();
                    gVar = this.L0;
                    if (gVar != null && gVar.f4583i) {
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
            q2(false, false);
            i2 = S0 + this.M0;
            centerTitleView = this.n0.getCenterTitleView();
            if (centerTitleView != null) {
                centerTitleView.setAlpha(i3);
            }
            H3(i2);
            J3(z);
        }
        z = true;
        centerTitleView = this.n0.getCenterTitleView();
        if (centerTitleView != null) {
        }
        H3(i2);
        J3(z);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @DebugTrace
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048644, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.o0.a.r1.g.a(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, "fragment onCreateView.");
            View b2 = c.a.o0.a.r1.n.a.a().b(c.a.o0.a.g.aiapps_fragment, viewGroup, false);
            this.G0 = (FrameLayout) b2.findViewById(c.a.o0.a.f.ai_apps_fragment_content);
            O1(b2);
            this.I0 = new c.a.o0.a.o2.b.a(this);
            S2(b2);
            if (!c.a.o0.a.j1.e.b.d() && !c.a.o0.a.j1.e.b.e()) {
                c.a.o0.a.j1.e.a.b(this.H0.c(), String.valueOf(c.a.o0.a.j1.e.b.c()), String.valueOf(c.a.o0.a.j1.e.b.a(c.a.o0.a.j1.e.b.b())));
            }
            if (N1()) {
                b2 = Q1(b2);
            }
            this.K0 = y1(b2, this);
            this.u0.setRegionFactor(this.H0.B());
            c.a.o0.a.m1.g.f().o();
            return this.K0;
        }
        return (View) invokeLLL.objValue;
    }

    public final void z3() {
        Bundle o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (o = o()) == null) {
            return;
        }
        this.E0 = U0;
        if (R0) {
            String str = "restoreArguments sPrePageParams=" + this.E0;
        }
        c.a.o0.a.l1.c e2 = c.a.o0.a.l1.c.e(o.getString("ai_apps_param"));
        this.l0 = e2;
        this.D0.f7208e = e2 != null ? e2.g() : "";
        c.a.o0.a.l1.b bVar = this.D0;
        c.a.o0.a.l1.c cVar = this.l0;
        bVar.f7209f = cVar != null ? cVar.h() : "";
        c.a.o0.a.l1.b bVar2 = this.D0;
        bVar2.f7211h = c.a.o0.a.c2.f.p0.j.b(bVar2.h());
        c.a.o0.a.a2.n.g e3 = c.a.o0.a.g1.f.V().e(this.D0.j());
        this.L0 = e3;
        if (e3.p) {
            this.L0 = c.a.o0.a.g1.f.V().i(this.D0.h());
        }
        this.M0 = E1().getDimensionPixelSize(c.a.o0.a.d.aiapps_normal_base_action_bar_height);
    }
}
