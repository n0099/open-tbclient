package c.a.o0.r0;

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
    public static int f11145b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f11146c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f11147b;

        /* renamed from: c  reason: collision with root package name */
        public static int f11148c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(a));
                a2.b("tfailNum", String.valueOf(f11147b));
                a2.b("qfailNum", String.valueOf(f11148c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f11147b = 0;
                f11148c = 0;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static long f11149b;

        /* renamed from: c  reason: collision with root package name */
        public static long f11150c;

        /* renamed from: d  reason: collision with root package name */
        public static long f11151d;

        /* renamed from: e  reason: collision with root package name */
        public static int f11152e;

        /* renamed from: f  reason: collision with root package name */
        public static int f11153f;

        /* renamed from: g  reason: collision with root package name */
        public static long f11154g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f11149b));
                a2.b("dlsize", String.valueOf(f11150c));
                a2.b("dbt", String.valueOf(f11151d));
                a2.b("pnum", String.valueOf(f11152e));
                a2.b("reqcost", String.valueOf(f11154g));
                a2.b("cpu", String.valueOf(f11153f));
                a2.b("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f11149b = 0L;
                f11150c = 0L;
                f11151d = 0L;
                f11152e = 0;
                f11153f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(861425179, "Lc/a/o0/r0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(861425179, "Lc/a/o0/r0/i;");
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                a.f11147b++;
            } else if (z3) {
                a.f11148c++;
            }
            if (a.a > f11145b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (b.a > f11146c) {
                b.a();
            }
            if (a.a > f11146c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (b.a < f11145b) {
                b.f11149b += fVar.f11131b;
                b.f11150c += fVar.f11132c;
                b.f11151d += fVar.f11133d;
                b.f11152e += fVar.f11134e;
                b.f11154g += fVar.f11135f;
                b.f11153f += fVar.f11136g;
                b.a++;
                return;
            }
            b.a();
        }
    }
}
