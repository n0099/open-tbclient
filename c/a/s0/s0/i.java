package c.a.s0.s0;

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
    public static int f14080b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f14081c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f14082b;

        /* renamed from: c  reason: collision with root package name */
        public static int f14083c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(a));
                a2.b("tfailNum", String.valueOf(f14082b));
                a2.b("qfailNum", String.valueOf(f14083c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f14082b = 0;
                f14083c = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static long f14084b;

        /* renamed from: c  reason: collision with root package name */
        public static long f14085c;

        /* renamed from: d  reason: collision with root package name */
        public static long f14086d;

        /* renamed from: e  reason: collision with root package name */
        public static int f14087e;

        /* renamed from: f  reason: collision with root package name */
        public static int f14088f;

        /* renamed from: g  reason: collision with root package name */
        public static long f14089g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f14084b));
                a2.b("dlsize", String.valueOf(f14085c));
                a2.b("dbt", String.valueOf(f14086d));
                a2.b("pnum", String.valueOf(f14087e));
                a2.b("reqcost", String.valueOf(f14089g));
                a2.b("cpu", String.valueOf(f14088f));
                a2.b("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f14084b = 0L;
                f14085c = 0L;
                f14086d = 0L;
                f14087e = 0;
                f14088f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-756344552, "Lc/a/s0/s0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-756344552, "Lc/a/s0/s0/i;");
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
                a.f14082b++;
            } else if (z3) {
                a.f14083c++;
            }
            if (a.a > f14080b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.a > f14081c) {
                b.a();
            }
            if (a.a > f14081c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.a < f14080b) {
                b.f14084b += fVar.f14062b;
                b.f14085c += fVar.f14063c;
                b.f14086d += fVar.f14064d;
                b.f14087e += fVar.f14065e;
                b.f14089g += fVar.f14066f;
                b.f14088f += fVar.f14067g;
                b.a++;
                return;
            }
            b.a();
        }
    }
}
