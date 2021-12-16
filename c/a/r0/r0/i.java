package c.a.r0.r0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i extends j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f12855b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f12856c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f12857b;

        /* renamed from: c  reason: collision with root package name */
        public static int f12858c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(a));
                a2.b("tfailNum", String.valueOf(f12857b));
                a2.b("qfailNum", String.valueOf(f12858c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f12857b = 0;
                f12858c = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static long f12859b;

        /* renamed from: c  reason: collision with root package name */
        public static long f12860c;

        /* renamed from: d  reason: collision with root package name */
        public static long f12861d;

        /* renamed from: e  reason: collision with root package name */
        public static int f12862e;

        /* renamed from: f  reason: collision with root package name */
        public static int f12863f;

        /* renamed from: g  reason: collision with root package name */
        public static long f12864g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f12859b));
                a2.b("dlsize", String.valueOf(f12860c));
                a2.b("dbt", String.valueOf(f12861d));
                a2.b("pnum", String.valueOf(f12862e));
                a2.b("reqcost", String.valueOf(f12864g));
                a2.b("cpu", String.valueOf(f12863f));
                a2.b("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f12859b = 0L;
                f12860c = 0L;
                f12861d = 0L;
                f12862e = 0;
                f12863f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1794888888, "Lc/a/r0/r0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1794888888, "Lc/a/r0/r0/i;");
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            a.a++;
            if (z2) {
                a.f12857b++;
            } else if (z3) {
                a.f12858c++;
            }
            if (a.a > f12855b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.a > f12856c) {
                b.a();
            }
            if (a.a > f12856c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.a < f12855b) {
                b.f12859b += fVar.f12837b;
                b.f12860c += fVar.f12838c;
                b.f12861d += fVar.f12839d;
                b.f12862e += fVar.f12840e;
                b.f12864g += fVar.f12841f;
                b.f12863f += fVar.f12842g;
                b.a++;
                return;
            }
            b.a();
        }
    }
}
