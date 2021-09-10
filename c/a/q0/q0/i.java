package c.a.q0.q0;

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
    public static int f13697b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13698c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13699a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13700b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13701c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f13699a));
                a2.b("tfailNum", String.valueOf(f13700b));
                a2.b("qfailNum", String.valueOf(f13701c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13699a = 0;
                f13700b = 0;
                f13701c = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13702a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13703b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13704c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13705d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13706e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13707f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13708g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13703b));
                a2.b("dlsize", String.valueOf(f13704c));
                a2.b("dbt", String.valueOf(f13705d));
                a2.b("pnum", String.valueOf(f13706e));
                a2.b("reqcost", String.valueOf(f13708g));
                a2.b("cpu", String.valueOf(f13707f));
                a2.b("totalNum", String.valueOf(f13702a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13702a = 0;
                f13703b = 0L;
                f13704c = 0L;
                f13705d = 0L;
                f13706e = 0;
                f13707f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(51155032, "Lc/a/q0/q0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(51155032, "Lc/a/q0/q0/i;");
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
            a.f13699a++;
            if (z2) {
                a.f13700b++;
            } else if (z3) {
                a.f13701c++;
            }
            if (a.f13699a > f13697b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f13702a > f13698c) {
                b.a();
            }
            if (a.f13699a > f13698c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f13702a < f13697b) {
                b.f13703b += fVar.f13677b;
                b.f13704c += fVar.f13678c;
                b.f13705d += fVar.f13679d;
                b.f13706e += fVar.f13680e;
                b.f13708g += fVar.f13681f;
                b.f13707f += fVar.f13682g;
                b.f13702a++;
                return;
            }
            b.a();
        }
    }
}
