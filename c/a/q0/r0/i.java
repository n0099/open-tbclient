package c.a.q0.r0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class i extends j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f13584b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13585c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13586b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13587c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(a));
                a2.b("tfailNum", String.valueOf(f13586b));
                a2.b("qfailNum", String.valueOf(f13587c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f13586b = 0;
                f13587c = 0;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13588b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13589c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13590d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13591e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13592f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13593g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13588b));
                a2.b("dlsize", String.valueOf(f13589c));
                a2.b("dbt", String.valueOf(f13590d));
                a2.b("pnum", String.valueOf(f13591e));
                a2.b("reqcost", String.valueOf(f13593g));
                a2.b("cpu", String.valueOf(f13592f));
                a2.b("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f13588b = 0L;
                f13589c = 0L;
                f13590d = 0L;
                f13591e = 0;
                f13592f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(52078553, "Lc/a/q0/r0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(52078553, "Lc/a/q0/r0/i;");
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
                a.f13586b++;
            } else if (z3) {
                a.f13587c++;
            }
            if (a.a > f13584b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (b.a > f13585c) {
                b.a();
            }
            if (a.a > f13585c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (b.a < f13584b) {
                b.f13588b += fVar.f13567b;
                b.f13589c += fVar.f13568c;
                b.f13590d += fVar.f13569d;
                b.f13591e += fVar.f13570e;
                b.f13593g += fVar.f13571f;
                b.f13592f += fVar.f13572g;
                b.a++;
                return;
            }
            b.a();
        }
    }
}
