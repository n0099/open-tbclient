package c.a.q0.r0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class i extends j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f12528b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f12529c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static int f12530b;

        /* renamed from: c  reason: collision with root package name */
        public static int f12531c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(a));
                a2.b("tfailNum", String.valueOf(f12530b));
                a2.b("qfailNum", String.valueOf(f12531c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f12530b = 0;
                f12531c = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;

        /* renamed from: b  reason: collision with root package name */
        public static long f12532b;

        /* renamed from: c  reason: collision with root package name */
        public static long f12533c;

        /* renamed from: d  reason: collision with root package name */
        public static long f12534d;

        /* renamed from: e  reason: collision with root package name */
        public static int f12535e;

        /* renamed from: f  reason: collision with root package name */
        public static int f12536f;

        /* renamed from: g  reason: collision with root package name */
        public static long f12537g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.d.f.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f12532b));
                a2.b("dlsize", String.valueOf(f12533c));
                a2.b("dbt", String.valueOf(f12534d));
                a2.b("pnum", String.valueOf(f12535e));
                a2.b("reqcost", String.valueOf(f12537g));
                a2.b("cpu", String.valueOf(f12536f));
                a2.b("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                f12532b = 0L;
                f12533c = 0L;
                f12534d = 0L;
                f12535e = 0;
                f12536f = 0;
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
                a.f12530b++;
            } else if (z3) {
                a.f12531c++;
            }
            if (a.a > f12528b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.a > f12529c) {
                b.a();
            }
            if (a.a > f12529c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.a < f12528b) {
                b.f12532b += fVar.f12510b;
                b.f12533c += fVar.f12511c;
                b.f12534d += fVar.f12512d;
                b.f12535e += fVar.f12513e;
                b.f12537g += fVar.f12514f;
                b.f12536f += fVar.f12515g;
                b.a++;
                return;
            }
            b.a();
        }
    }
}
