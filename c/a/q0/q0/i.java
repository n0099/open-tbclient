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
    public static int f13713b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13714c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13715a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13716b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13717c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f13715a));
                a2.b("tfailNum", String.valueOf(f13716b));
                a2.b("qfailNum", String.valueOf(f13717c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13715a = 0;
                f13716b = 0;
                f13717c = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13718a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13719b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13720c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13721d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13722e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13723f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13724g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13719b));
                a2.b("dlsize", String.valueOf(f13720c));
                a2.b("dbt", String.valueOf(f13721d));
                a2.b("pnum", String.valueOf(f13722e));
                a2.b("reqcost", String.valueOf(f13724g));
                a2.b("cpu", String.valueOf(f13723f));
                a2.b("totalNum", String.valueOf(f13718a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13718a = 0;
                f13719b = 0L;
                f13720c = 0L;
                f13721d = 0L;
                f13722e = 0;
                f13723f = 0;
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
            a.f13715a++;
            if (z2) {
                a.f13716b++;
            } else if (z3) {
                a.f13717c++;
            }
            if (a.f13715a > f13713b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f13718a > f13714c) {
                b.a();
            }
            if (a.f13715a > f13714c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f13718a < f13713b) {
                b.f13719b += fVar.f13693b;
                b.f13720c += fVar.f13694c;
                b.f13721d += fVar.f13695d;
                b.f13722e += fVar.f13696e;
                b.f13724g += fVar.f13697f;
                b.f13723f += fVar.f13698g;
                b.f13718a++;
                return;
            }
            b.a();
        }
    }
}
