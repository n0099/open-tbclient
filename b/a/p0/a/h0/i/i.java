package b.a.p0.a.h0.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.i.a;
import b.a.p0.a.h0.i.g;
import b.a.p0.a.k;
import b.a.p0.a.v2.q0;
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
    public static final boolean f5375a;

    /* renamed from: b  reason: collision with root package name */
    public static c f5376b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedHashMap<String, String> f5377c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f5378a;

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
            this.f5378a = aVar;
        }

        @Override // b.a.p0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                this.f5378a.a(gVar);
                i.r(gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.v2.e1.b f5379a;

        public b(b.a.p0.a.v2.e1.b bVar) {
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
            this.f5379a = bVar;
        }

        @Override // b.a.p0.a.h0.i.g.a
        public void a(@NonNull g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
                if (TextUtils.isEmpty(i.f5376b.f5385f)) {
                    i.f5376b.f5385f = b.a.p0.a.h0.i.c.b("", gVar);
                }
                b.a.p0.a.v2.e1.b bVar = this.f5379a;
                if (bVar != null) {
                    bVar.onCallback(i.f5376b.r(i.f5376b.f5385f));
                }
                if (i.f5375a) {
                    String.format("getLaunchInfo by click, consume time: %d ms，detail:%s", Long.valueOf(System.currentTimeMillis() - i.f5376b.s()), i.f5376b.f5385f);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f5398a;

        /* renamed from: b  reason: collision with root package name */
        public long f5399b;

        /* renamed from: c  reason: collision with root package name */
        public int f5400c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public d(String str, long j, long j2) {
            this(str, j, j2, 200);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r9;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2)};
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

        public d(String str, long j, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f5398a = str;
            this.f5399b = j2;
            this.f5400c = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597462665, "Lb/a/p0/a/h0/i/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597462665, "Lb/a/p0/a/h0/i/i;");
                return;
            }
        }
        f5375a = k.f6397a;
    }

    public static void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.o();
    }

    public static void d(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.q(aVar);
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (i.class) {
                if (f5376b != null) {
                    e.e();
                    f5376b.n();
                }
                f5376b = new c(null);
                if (f5377c != null) {
                    for (Map.Entry<String, String> entry : f5377c.entrySet()) {
                        f5376b.w(entry.getKey(), entry.getValue());
                    }
                    f5376b.K(true);
                    f5377c = null;
                }
            }
        }
    }

    public static void f(b.a.p0.a.v2.e1.b<String> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            c cVar = f5376b;
            if (cVar == null) {
                if (bVar != null) {
                    bVar.onCallback("");
                }
            } else if (cVar.v() && !TextUtils.isEmpty(f5376b.f5385f)) {
                if (bVar != null) {
                    c cVar2 = f5376b;
                    bVar.onCallback(cVar2.r(cVar2.f5385f));
                }
            } else if (!f5376b.u() || TextUtils.isEmpty(f5376b.f5385f)) {
                f5376b.q(new b(bVar));
            } else if (bVar != null) {
                c cVar3 = f5376b;
                bVar.onCallback(cVar3.r(cVar3.f5385f));
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c cVar = f5376b;
            if (cVar == null) {
                return false;
            }
            return cVar.t();
        }
        return invokeV.booleanValue;
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, null, z) == null) || b.a.p0.a.a2.d.g().l() == 1) {
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
            j(str, b.a.p0.a.v2.k.g(System.currentTimeMillis(), "【HH:mm:ss】"));
        }
    }

    public static void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            c cVar = f5376b;
            if (cVar != null) {
                cVar.w(str, str2);
                return;
            }
            if (f5377c == null) {
                f5377c = new LinkedHashMap<>();
            }
            f5377c.put(str, str2);
        }
    }

    public static void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.x();
    }

    public static void l(long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65548, null, j) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.y(j);
    }

    public static void m(a.C0213a c0213a) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, c0213a) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.z(c0213a);
    }

    public static void n(String str, int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65550, null, str, i2) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.A(str, i2);
    }

    public static void o(String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.B(str);
    }

    public static void p(String str, long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65552, null, str, j) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.C(str, j);
    }

    public static void q(int i2) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65553, null, i2) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.J(i2);
    }

    public static void r(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, gVar) == null) || gVar == null) {
            return;
        }
        int i2 = b.a.p0.a.h.swanapp_tip_request_default;
        int d2 = gVar.d();
        b.a.p0.a.h0.i.a c2 = gVar.c();
        if (c2 != null && c2.c()) {
            i2 = b.a.p0.a.h.swanapp_tip_show_js_error;
        } else if (d2 != 1 && d2 != 2) {
            int f2 = gVar.f();
            if (f2 == 4) {
                i2 = b.a.p0.a.h.swanapp_tip_request_fail;
            } else if (f2 == 8) {
                i2 = b.a.p0.a.h.swanapp_tip_request_slow;
            }
        } else {
            i2 = b.a.p0.a.h.swanapp_tip_request_bad_network;
        }
        e.f(i2);
    }

    public static void s(g.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, aVar) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.q(new a(aVar));
    }

    public static void t() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, null) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.L();
    }

    public static void u() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, null) == null) || (cVar = f5376b) == null) {
            return;
        }
        cVar.M();
    }

    public static synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            synchronized (i.class) {
                if (f5376b != null) {
                    f5376b.N();
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
        public long f5380a;

        /* renamed from: b  reason: collision with root package name */
        public List<d> f5381b;

        /* renamed from: c  reason: collision with root package name */
        public List<d> f5382c;

        /* renamed from: d  reason: collision with root package name */
        public List<d> f5383d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f5384e;

        /* renamed from: f  reason: collision with root package name */
        public String f5385f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f5386g;

        /* renamed from: h  reason: collision with root package name */
        public Timer f5387h;

        /* renamed from: i  reason: collision with root package name */
        public Timer f5388i;
        public Timer j;
        public long k;
        public int l;
        public b.a.p0.a.h0.i.a m;
        public boolean n;
        public long o;

        /* loaded from: classes.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f5389e;

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
                this.f5389e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5389e.f5384e = false;
                    this.f5389e.H();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b extends b.a.p0.a.t0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppActivity f5390a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f5391b;

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
                this.f5391b = cVar;
                this.f5390a = swanAppActivity;
            }

            @Override // b.a.p0.a.t0.a, b.a.p0.a.t0.b
            public void f() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f5391b.I()) {
                    this.f5390a.unregisterCallback(this);
                }
            }
        }

        /* renamed from: b.a.p0.a.h0.i.i$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0215c implements SwanAppNetworkUtils.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f5392a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.a f5393b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f5394c;

            public C0215c(c cVar, g gVar, g.a aVar) {
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
                this.f5394c = cVar;
                this.f5392a = gVar;
                this.f5393b = aVar;
            }

            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.b
            public void onResult(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                    if (i2 == 1) {
                        this.f5392a.j(0);
                    } else if (i2 == 2) {
                        this.f5392a.j(1);
                    } else if (i2 != 3) {
                        this.f5392a.j(3);
                    } else {
                        this.f5392a.j(2);
                    }
                    if (this.f5394c.f5382c.size() + this.f5394c.f5381b.size() + this.f5394c.f5383d.size() > 2 && System.currentTimeMillis() - this.f5394c.k >= 3000) {
                        if (!this.f5394c.E(this.f5392a)) {
                            if (this.f5394c.F(this.f5392a)) {
                                this.f5392a.k(8);
                                this.f5393b.a(this.f5392a);
                                return;
                            }
                            this.f5393b.a(this.f5392a);
                            return;
                        }
                        this.f5392a.k(4);
                        this.f5393b.a(this.f5392a);
                        return;
                    }
                    this.f5392a.k(12);
                    this.f5393b.a(this.f5392a);
                }
            }
        }

        /* loaded from: classes.dex */
        public class d extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f5395e;

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

                @Override // b.a.p0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && q0.H()) {
                        f.c("fcp_timeout", gVar);
                        int d2 = gVar.d();
                        if (d2 == 1) {
                            i.i(b.a.p0.a.h0.i.c.b(b.a.p0.a.h0.i.c.f5360a, gVar));
                            b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_net_unavailable);
                        } else if (d2 != 2) {
                            i.i(b.a.p0.a.h0.i.c.b(b.a.p0.a.h0.i.c.f5360a, gVar));
                        } else {
                            i.i(b.a.p0.a.h0.i.c.b(b.a.p0.a.h0.i.c.f5360a, gVar));
                            b.a.p0.a.h0.i.e.f(b.a.p0.a.h.swanapp_tip_net_unavailable);
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
                this.f5395e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f5395e.f5380a == 0 && b.a.p0.a.m1.g.f().e() == 0) {
                    this.f5395e.q(new a(this));
                }
            }
        }

        /* loaded from: classes.dex */
        public class e extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f5396e;

            /* loaded from: classes.dex */
            public class a implements g.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f5397a;

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
                    this.f5397a = eVar;
                }

                @Override // b.a.p0.a.h0.i.g.a
                public void a(@NonNull g gVar) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) && TextUtils.isEmpty(this.f5397a.f5396e.f5385f)) {
                        this.f5397a.f5396e.f5385f = b.a.p0.a.h0.i.c.b("", gVar);
                        if (i.f5375a) {
                            String.format("%d ms countdown end，collect launchInfo：%s", 6000L, this.f5397a.f5396e.f5385f);
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
                this.f5396e = cVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.f5396e.u() && TextUtils.isEmpty(this.f5396e.f5385f)) {
                    this.f5396e.q(new a(this));
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1858277418, "Lb/a/p0/a/h0/i/i$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1858277418, "Lb/a/p0/a/h0/i/i$c;");
                    return;
                }
            }
            p = b.a.p0.a.c1.a.Z().o();
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
            this.f5380a = 0L;
            this.f5381b = new ArrayList();
            this.f5382c = new ArrayList();
            this.f5383d = new ArrayList();
            this.f5384e = true;
            this.f5385f = "";
            this.f5386g = false;
            this.k = 0L;
            this.l = 0;
            this.m = new b.a.p0.a.h0.i.a();
            this.n = false;
            this.o = s();
        }

        public synchronized void A(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                synchronized (this) {
                    if (this.f5384e) {
                        this.f5383d.add(new d(str, 0L, 0L, i2));
                        D(str);
                    }
                }
            }
        }

        public synchronized void B(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                synchronized (this) {
                    if (this.f5384e) {
                        this.f5381b.add(new d(str, System.currentTimeMillis(), 0L));
                    }
                }
            }
        }

        public synchronized void C(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j) == null) {
                synchronized (this) {
                    if (this.f5384e) {
                        this.f5382c.add(new d(str, 0L, j));
                        D(str);
                    }
                }
            }
        }

        public final void D(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                for (int i2 = 0; i2 < this.f5381b.size(); i2++) {
                    if (TextUtils.equals(this.f5381b.get(i2).f5398a, str)) {
                        List<d> list = this.f5381b;
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
                int size = this.f5383d.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    d dVar = this.f5383d.get(i4);
                    if (dVar != null && (i2 = dVar.f5400c) >= 400 && i2 < 600) {
                        i3++;
                        arrayList.add(dVar.f5398a);
                    }
                }
                int size2 = this.f5382c.size() + i3 + this.f5381b.size();
                gVar.f5371c = arrayList;
                gVar.f5370b = size2;
                return ((double) i3) / ((double) size2) >= 0.5d;
            }
            return invokeL.booleanValue;
        }

        public final boolean F(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) {
                TreeMap treeMap = new TreeMap();
                int size = this.f5382c.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    d dVar = this.f5382c.get(i3);
                    long j = dVar.f5399b;
                    if (j > 3000) {
                        i2++;
                        treeMap.put(dVar.f5398a, Integer.valueOf((int) j));
                    }
                }
                gVar.f5372d = treeMap;
                return i2 >= 2;
            }
            return invokeL.booleanValue;
        }

        public void G() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                Timer timer = this.f5387h;
                if (timer != null) {
                    timer.cancel();
                    this.f5387h = null;
                }
                this.f5380a = 0L;
            }
        }

        public final void H() {
            Timer timer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (timer = this.f5388i) == null) {
                return;
            }
            timer.cancel();
            this.f5388i = null;
        }

        public final boolean I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (!this.f5386g || TextUtils.isEmpty(this.f5385f)) {
                    return false;
                }
                b.a.p0.a.h0.i.b.h(s(), this.f5385f);
                this.f5386g = false;
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
                this.f5386g = z;
            }
        }

        public void L() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                G();
                Timer timer = new Timer();
                this.f5387h = timer;
                timer.schedule(new d(this), 3000L);
            }
        }

        public void M() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                Timer timer = this.j;
                if (timer != null) {
                    timer.cancel();
                    this.j = null;
                }
                Timer timer2 = new Timer();
                this.j = timer2;
                timer2.schedule(new e(this), 6000L);
            }
        }

        public void N() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f5384e) {
                this.k = System.currentTimeMillis();
                Timer timer = new Timer();
                this.f5388i = timer;
                timer.schedule(new a(this), 6000L);
                SwanAppActivity activity = b.a.p0.a.g1.f.T().getActivity();
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
                if (!TextUtils.equals(b.a.p0.a.g1.f.T().S(), b.a.p0.a.h0.i.d.a())) {
                    if (i.f5375a) {
                        String str = "current page: " + b.a.p0.a.g1.f.T().S();
                        String a2 = b.a.p0.a.h0.i.d.a();
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
                String C = b.a.p0.a.g1.f.T().C();
                if (TextUtils.isEmpty(C)) {
                    return;
                }
                b.a.p0.a.g1.f.T().l(C, new b.a.p0.a.o0.d.b("check-skeleton-status"));
            }
        }

        public void p(SwanAppNetworkUtils.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
                this.f5386g = true;
                SwanAppNetworkUtils.b(bVar);
            }
        }

        public void q(g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
                g gVar = new g();
                gVar.h(System.currentTimeMillis() - this.k);
                gVar.i(this.m);
                p(new C0215c(this, gVar, aVar));
            }
        }

        public String r(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                StringBuilder sb = new StringBuilder(b.a.p0.a.c1.a.b().getText(b.a.p0.a.h.swanapp_tip_cur_title));
                sb.append(str);
                String e2 = b.a.p0.a.h0.i.b.e();
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
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P != null) {
                    return P.K().l("launch_time", 0L);
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
                    b.a.p0.a.e0.d.h("SwanAppLaunchTips", "the log has expired, content=" + str2 + str);
                    return;
                }
                String str3 = StringUtils.LF + str2 + str;
                if (!TextUtils.isEmpty(this.f5385f)) {
                    str3 = this.f5385f + str3;
                }
                this.f5385f = str3;
                boolean unused = i.f5375a;
                b.a.p0.a.e0.d.h("SwanAppLaunchTips", str2 + str);
            }
        }

        public void x() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                this.n = true;
            }
        }

        public void y(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048601, this, j) == null) && this.f5380a == 0) {
                this.f5380a = j;
            }
        }

        public void z(@NonNull a.C0213a c0213a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048602, this, c0213a) == null) {
                boolean z = u() || v();
                if (i.f5375a) {
                    String.format("onJsError needFilter ?: %s, content:%s", Boolean.valueOf(z), c0213a.toString());
                }
                if (z) {
                    return;
                }
                this.m.a(c0213a);
            }
        }

        public /* synthetic */ c(h hVar) {
            this();
        }
    }
}
