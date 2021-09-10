package c.a.p0.a.h0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.i.a;
import c.a.p0.a.h0.i.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6023a;

    /* renamed from: b  reason: collision with root package name */
    public static c f6024b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f6025c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f6026a;

        public a(g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6026a = aVar;
        }

        @Override // c.a.p0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                this.f6026a.a(gVar);
                i.r(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.v2.e1.b f6027a;

        public b(c.a.p0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6027a = bVar;
        }

        @Override // c.a.p0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (TextUtils.isEmpty(i.f6024b.f6033f)) {
                    i.f6024b.f6033f = c.a.p0.a.h0.i.c.b("", gVar);
                }
                c.a.p0.a.v2.e1.b bVar = this.f6027a;
                if (bVar != null) {
                    bVar.onCallback(i.f6024b.r(i.f6024b.f6033f));
                }
                if (i.f6023a) {
                    String.format("getLaunchInfo by click, consume time: %d ms，detail:%s", Long.valueOf(System.currentTimeMillis() - i.f6024b.s()), i.f6024b.f6033f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6047a;

        /* renamed from: b  reason: collision with root package name */
        public long f6048b;

        /* renamed from: c  reason: collision with root package name */
        public int f6049c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public d(String str, long j2, long j3) {
            this(str, j2, j3, 200);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r9;
                Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public d(String str, long j2, long j3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f6047a = str;
            this.f6048b = j3;
            this.f6049c = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1086928488, "Lc/a/p0/a/h0/i/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1086928488, "Lc/a/p0/a/h0/i/i;");
                return;
            }
        }
        f6023a = k.f7077a;
    }

    public static void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.o();
    }

    public static void d(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.q(aVar);
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (i.class) {
                if (f6024b != null) {
                    e.e();
                    f6024b.n();
                }
                f6024b = new c(null);
                if (f6025c != null) {
                    for (Map.Entry<String, String> entry : f6025c.entrySet()) {
                        f6024b.w(entry.getKey(), entry.getValue());
                    }
                    f6024b.K(true);
                    f6025c = null;
                }
            }
        }
    }

    public static void f(c.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            c cVar = f6024b;
            if (cVar == null) {
                if (bVar != null) {
                    bVar.onCallback("");
                }
            } else if (cVar.v() && !TextUtils.isEmpty(f6024b.f6033f)) {
                if (bVar != null) {
                    c cVar2 = f6024b;
                    bVar.onCallback(cVar2.r(cVar2.f6033f));
                }
            } else if (!f6024b.u() || TextUtils.isEmpty(f6024b.f6033f)) {
                f6024b.q(new b(bVar));
            } else if (bVar != null) {
                c cVar3 = f6024b;
                bVar.onCallback(cVar3.r(cVar3.f6033f));
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c cVar = f6024b;
            if (cVar == null) {
                return false;
            }
            return cVar.t();
        }
        return invokeV.booleanValue;
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, null, z) == null) || c.a.p0.a.a2.d.g().l() == 1) {
            return;
        }
        e();
        v();
        u();
        if (z) {
            t();
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            j(str, c.a.p0.a.v2.k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            c cVar = f6024b;
            if (cVar != null) {
                cVar.w(str, str2);
                return;
            }
            if (f6025c == null) {
                f6025c = new LinkedHashMap<>();
            }
            f6025c.put(str, str2);
        }
    }

    public static void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.x();
    }

    public static void l(long j2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65548, null, j2) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.y(j2);
    }

    public static void m(a.C0218a c0218a) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, c0218a) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.z(c0218a);
    }

    public static void n(String str, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65550, null, str, i2) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.A(str, i2);
    }

    public static void o(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.B(str);
    }

    public static void p(String str, long j2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65552, null, str, j2) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.C(str, j2);
    }

    public static void q(int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, null, i2) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.J(i2);
    }

    public static void r(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, gVar) == null) || gVar == null) {
            return;
        }
        int i2 = c.a.p0.a.h.swanapp_tip_request_default;
        int d2 = gVar.d();
        c.a.p0.a.h0.i.a c2 = gVar.c();
        if (c2 != null && c2.c()) {
            i2 = c.a.p0.a.h.swanapp_tip_show_js_error;
        } else if (d2 != 1 && d2 != 2) {
            int f2 = gVar.f();
            if (f2 == 4) {
                i2 = c.a.p0.a.h.swanapp_tip_request_fail;
            } else if (f2 == 8) {
                i2 = c.a.p0.a.h.swanapp_tip_request_slow;
            }
        } else {
            i2 = c.a.p0.a.h.swanapp_tip_request_bad_network;
        }
        e.f(i2);
    }

    public static void s(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, aVar) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.q(new a(aVar));
    }

    public static void t() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, null) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.L();
    }

    public static void u() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, null) == null) || (cVar = f6024b) == null) {
            return;
        }
        cVar.M();
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            synchronized (i.class) {
                if (f6024b != null) {
                    f6024b.N();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final long p;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f6028a;

        /* renamed from: b  reason: collision with root package name */
        public List<d> f6029b;

        /* renamed from: c  reason: collision with root package name */
        public List<d> f6030c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f6031d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f6032e;

        /* renamed from: f  reason: collision with root package name */
        public String f6033f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6034g;

        /* renamed from: h  reason: collision with root package name */
        public Timer f6035h;

        /* renamed from: i  reason: collision with root package name */
        public Timer f6036i;

        /* renamed from: j  reason: collision with root package name */
        public Timer f6037j;
        public long k;
        public int l;
        public c.a.p0.a.h0.i.a m;
        public boolean n;
        public long o;

        /* loaded from: classes.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f6038e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6038e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f6038e.f6032e = false;
                    this.f6038e.H();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends c.a.p0.a.t0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppActivity f6039a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f6040b;

            public b(c cVar, SwanAppActivity swanAppActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, swanAppActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6040b = cVar;
                this.f6039a = swanAppActivity;
            }

            @Override // c.a.p0.a.t0.a, c.a.p0.a.t0.b
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f6040b.I()) {
                    this.f6039a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: c.a.p0.a.h0.i.i$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0220c implements SwanAppNetworkUtils.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f6041a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.a f6042b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f6043c;

            public C0220c(c cVar, g gVar, g.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, gVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6043c = cVar;
                this.f6041a = gVar;
                this.f6042b = aVar;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 1) {
                        this.f6041a.j(0);
                    } else if (i2 == 2) {
                        this.f6041a.j(1);
                    } else if (i2 != 3) {
                        this.f6041a.j(3);
                    } else {
                        this.f6041a.j(2);
                    }
                    if (this.f6043c.f6030c.size() + this.f6043c.f6029b.size() + this.f6043c.f6031d.size() > 2 && System.currentTimeMillis() - this.f6043c.k >= 3000) {
                        if (!this.f6043c.E(this.f6041a)) {
                            if (this.f6043c.F(this.f6041a)) {
                                this.f6041a.k(8);
                                this.f6042b.a(this.f6041a);
                                return;
                            }
                            this.f6042b.a(this.f6041a);
                            return;
                        }
                        this.f6041a.k(4);
                        this.f6042b.a(this.f6041a);
                        return;
                    }
                    this.f6041a.k(12);
                    this.f6042b.a(this.f6041a);
                }
            }
        }

        /* loaded from: classes.dex */
        public class d extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f6044e;

            /* loaded from: classes.dex */
            public class a implements g.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public a(d dVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // c.a.p0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && q0.H()) {
                        f.c("fcp_timeout", gVar);
                        int d2 = gVar.d();
                        if (d2 == 1) {
                            i.i(c.a.p0.a.h0.i.c.b(c.a.p0.a.h0.i.c.f6008a, gVar));
                            c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_net_unavailable);
                        } else if (d2 != 2) {
                            i.i(c.a.p0.a.h0.i.c.b(c.a.p0.a.h0.i.c.f6008a, gVar));
                        } else {
                            i.i(c.a.p0.a.h0.i.c.b(c.a.p0.a.h0.i.c.f6008a, gVar));
                            c.a.p0.a.h0.i.e.f(c.a.p0.a.h.swanapp_tip_net_unavailable);
                        }
                    }
                }
            }

            public d(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6044e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f6044e.f6028a == 0 && c.a.p0.a.m1.g.f().e() == 0) {
                    this.f6044e.q(new a(this));
                }
            }
        }

        /* loaded from: classes.dex */
        public class e extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f6045e;

            /* loaded from: classes.dex */
            public class a implements g.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f6046a;

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
                    this.f6046a = eVar;
                }

                @Override // c.a.p0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && TextUtils.isEmpty(this.f6046a.f6045e.f6033f)) {
                        this.f6046a.f6045e.f6033f = c.a.p0.a.h0.i.c.b("", gVar);
                        if (i.f6023a) {
                            String.format("%d ms countdown end，collect launchInfo：%s", 6000L, this.f6046a.f6045e.f6033f);
                        }
                    }
                }
            }

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6045e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f6045e.u() && TextUtils.isEmpty(this.f6045e.f6033f)) {
                    this.f6045e.q(new a(this));
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(861205065, "Lc/a/p0/a/h0/i/i$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(861205065, "Lc/a/p0/a/h0/i/i$c;");
                    return;
                }
            }
            p = c.a.p0.a.c1.a.Z().o();
        }

        public c() {
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
            this.f6028a = 0L;
            this.f6029b = new ArrayList();
            this.f6030c = new ArrayList();
            this.f6031d = new ArrayList();
            this.f6032e = true;
            this.f6033f = "";
            this.f6034g = false;
            this.k = 0L;
            this.l = 0;
            this.m = new c.a.p0.a.h0.i.a();
            this.n = false;
            this.o = s();
        }

        public synchronized void A(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                synchronized (this) {
                    if (this.f6032e) {
                        this.f6031d.add(new d(str, 0L, 0L, i2));
                        D(str);
                    }
                }
            }
        }

        public synchronized void B(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (this.f6032e) {
                        this.f6029b.add(new d(str, System.currentTimeMillis(), 0L));
                    }
                }
            }
        }

        public synchronized void C(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j2) == null) {
                synchronized (this) {
                    if (this.f6032e) {
                        this.f6030c.add(new d(str, 0L, j2));
                        D(str);
                    }
                }
            }
        }

        public final void D(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                for (int i2 = 0; i2 < this.f6029b.size(); i2++) {
                    if (TextUtils.equals(this.f6029b.get(i2).f6047a, str)) {
                        List<d> list = this.f6029b;
                        list.remove(list.get(i2));
                        return;
                    }
                }
            }
        }

        public final boolean E(g gVar) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) {
                ArrayList arrayList = new ArrayList();
                int size = this.f6031d.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    d dVar = this.f6031d.get(i4);
                    if (dVar != null && (i2 = dVar.f6049c) >= 400 && i2 < 600) {
                        i3++;
                        arrayList.add(dVar.f6047a);
                    }
                }
                int size2 = this.f6030c.size() + i3 + this.f6029b.size();
                gVar.f6019c = arrayList;
                gVar.f6018b = size2;
                return ((double) i3) / ((double) size2) >= 0.5d;
            }
            return invokeL.booleanValue;
        }

        public final boolean F(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
                TreeMap treeMap = new TreeMap();
                int size = this.f6030c.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    d dVar = this.f6030c.get(i3);
                    long j2 = dVar.f6048b;
                    if (j2 > 3000) {
                        i2++;
                        treeMap.put(dVar.f6047a, Integer.valueOf((int) j2));
                    }
                }
                gVar.f6020d = treeMap;
                return i2 >= 2;
            }
            return invokeL.booleanValue;
        }

        public void G() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                Timer timer = this.f6035h;
                if (timer != null) {
                    timer.cancel();
                    this.f6035h = null;
                }
                this.f6028a = 0L;
            }
        }

        public final void H() {
            Timer timer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (timer = this.f6036i) == null) {
                return;
            }
            timer.cancel();
            this.f6036i = null;
        }

        public final boolean I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (!this.f6034g || TextUtils.isEmpty(this.f6033f)) {
                    return false;
                }
                c.a.p0.a.h0.i.b.h(s(), this.f6033f);
                this.f6034g = false;
                return true;
            }
            return invokeV.booleanValue;
        }

        public void J(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                this.l = i2;
            }
        }

        public void K(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.f6034g = z;
            }
        }

        public void L() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                G();
                Timer timer = new Timer();
                this.f6035h = timer;
                timer.schedule(new d(this), 3000L);
            }
        }

        public void M() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                Timer timer = this.f6037j;
                if (timer != null) {
                    timer.cancel();
                    this.f6037j = null;
                }
                Timer timer2 = new Timer();
                this.f6037j = timer2;
                timer2.schedule(new e(this), 6000L);
            }
        }

        public void N() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f6032e) {
                this.k = System.currentTimeMillis();
                Timer timer = new Timer();
                this.f6036i = timer;
                timer.schedule(new a(this), 6000L);
                SwanAppActivity activity = c.a.p0.a.g1.f.V().getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.registerCallback(new b(this, activity));
            }
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                H();
            }
        }

        public void o() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.l == 1) {
                if (!TextUtils.equals(c.a.p0.a.g1.f.V().U(), c.a.p0.a.h0.i.d.a())) {
                    if (i.f6023a) {
                        String str = "current page: " + c.a.p0.a.g1.f.V().U();
                        String a2 = c.a.p0.a.h0.i.d.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append("skeleton error first page: ");
                        if (a2 == null) {
                            a2 = "";
                        }
                        sb.append(a2);
                        sb.toString();
                        return;
                    }
                    return;
                }
                String D = c.a.p0.a.g1.f.V().D();
                if (TextUtils.isEmpty(D)) {
                    return;
                }
                c.a.p0.a.g1.f.V().m(D, new c.a.p0.a.o0.d.b("check-skeleton-status"));
            }
        }

        public void p(SwanAppNetworkUtils.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
                this.f6034g = true;
                SwanAppNetworkUtils.b(bVar);
            }
        }

        public void q(g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
                g gVar = new g();
                gVar.h(System.currentTimeMillis() - this.k);
                gVar.i(this.m);
                p(new C0220c(this, gVar, aVar));
            }
        }

        public String r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                StringBuilder sb = new StringBuilder(c.a.p0.a.c1.a.b().getText(c.a.p0.a.h.swanapp_tip_cur_title));
                sb.append(str);
                String e2 = c.a.p0.a.h0.i.b.e();
                if (!TextUtils.isEmpty(e2)) {
                    sb.append(e2);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public final long s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
                if (Q != null) {
                    return Q.L().l("launch_time", 0L);
                }
                return 0L;
            }
            return invokeV.longValue;
        }

        public boolean t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.m.c() : invokeV.booleanValue;
        }

        public boolean u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.n : invokeV.booleanValue;
        }

        public boolean v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return System.currentTimeMillis() - this.o > ((long) ((p > 6000L ? 1 : (p == 6000L ? 0 : -1)) >= 0 ? 10000 : 7000));
            }
            return invokeV.booleanValue;
        }

        public void w(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048599, this, str, str2) == null) {
                if (v()) {
                    c.a.p0.a.e0.d.h("SwanAppLaunchTips", "the log has expired, content=" + str2 + str);
                    return;
                }
                String str3 = StringUtils.LF + str2 + str;
                if (!TextUtils.isEmpty(this.f6033f)) {
                    str3 = this.f6033f + str3;
                }
                this.f6033f = str3;
                boolean unused = i.f6023a;
                c.a.p0.a.e0.d.h("SwanAppLaunchTips", str2 + str);
            }
        }

        public void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                this.n = true;
            }
        }

        public void y(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) && this.f6028a == 0) {
                this.f6028a = j2;
            }
        }

        public void z(@NonNull a.C0218a c0218a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, c0218a) == null) {
                boolean z = u() || v();
                if (i.f6023a) {
                    String.format("onJsError needFilter ?: %s, content:%s", Boolean.valueOf(z), c0218a.toString());
                }
                if (z) {
                    return;
                }
                this.m.a(c0218a);
            }
        }

        public /* synthetic */ c(h hVar) {
            this();
        }
    }
}
