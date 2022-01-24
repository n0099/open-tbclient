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
    public static int f13896b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13897c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13898b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13899c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(a));
                a2.b("tfailNum", String.valueOf(f13898b));
                a2.b("qfailNum", String.valueOf(f13899c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f13898b = 0;
                f13899c = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13900b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13901c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13902d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13903e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13904f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13905g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13900b));
                a2.b("dlsize", String.valueOf(f13901c));
                a2.b("dbt", String.valueOf(f13902d));
                a2.b("pnum", String.valueOf(f13903e));
                a2.b("reqcost", String.valueOf(f13905g));
                a2.b("cpu", String.valueOf(f13904f));
                a2.b("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f13900b = 0L;
                f13901c = 0L;
                f13902d = 0L;
                f13903e = 0;
                f13904f = 0;
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
                a.f13898b++;
            } else if (z3) {
                a.f13899c++;
            }
            if (a.a > f13896b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.a > f13897c) {
                b.a();
            }
            if (a.a > f13897c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.a < f13896b) {
                b.f13900b += fVar.f13879b;
                b.f13901c += fVar.f13880c;
                b.f13902d += fVar.f13881d;
                b.f13903e += fVar.f13882e;
                b.f13905g += fVar.f13883f;
                b.f13904f += fVar.f13884g;
                b.a++;
                return;
            }
            b.a();
        }
    }
}
