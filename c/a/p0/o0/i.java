package c.a.p0.o0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i extends j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f13701b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13702c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13703a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13704b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13705c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f13703a));
                a2.b("tfailNum", String.valueOf(f13704b));
                a2.b("qfailNum", String.valueOf(f13705c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13703a = 0;
                f13704b = 0;
                f13705c = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13706a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13707b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13708c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13709d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13710e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13711f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13712g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13707b));
                a2.b("dlsize", String.valueOf(f13708c));
                a2.b("dbt", String.valueOf(f13709d));
                a2.b("pnum", String.valueOf(f13710e));
                a2.b("reqcost", String.valueOf(f13712g));
                a2.b("cpu", String.valueOf(f13711f));
                a2.b("totalNum", String.valueOf(f13706a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13706a = 0;
                f13707b = 0L;
                f13708c = 0L;
                f13709d = 0L;
                f13710e = 0;
                f13711f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1693502345, "Lc/a/p0/o0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1693502345, "Lc/a/p0/o0/i;");
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
            a.f13703a++;
            if (z2) {
                a.f13704b++;
            } else if (z3) {
                a.f13705c++;
            }
            if (a.f13703a > f13701b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f13706a > f13702c) {
                b.a();
            }
            if (a.f13703a > f13702c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f13706a < f13701b) {
                b.f13707b += fVar.f13681b;
                b.f13708c += fVar.f13682c;
                b.f13709d += fVar.f13683d;
                b.f13710e += fVar.f13684e;
                b.f13712g += fVar.f13685f;
                b.f13711f += fVar.f13686g;
                b.f13706a++;
                return;
            }
            b.a();
        }
    }
}
