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
    public static int f13693b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13694c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13695a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13696b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13697c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f13695a));
                a2.b("tfailNum", String.valueOf(f13696b));
                a2.b("qfailNum", String.valueOf(f13697c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13695a = 0;
                f13696b = 0;
                f13697c = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13698a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13699b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13700c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13701d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13702e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13703f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13704g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13699b));
                a2.b("dlsize", String.valueOf(f13700c));
                a2.b("dbt", String.valueOf(f13701d));
                a2.b("pnum", String.valueOf(f13702e));
                a2.b("reqcost", String.valueOf(f13704g));
                a2.b("cpu", String.valueOf(f13703f));
                a2.b("totalNum", String.valueOf(f13698a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13698a = 0;
                f13699b = 0L;
                f13700c = 0L;
                f13701d = 0L;
                f13702e = 0;
                f13703f = 0;
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
            a.f13695a++;
            if (z2) {
                a.f13696b++;
            } else if (z3) {
                a.f13697c++;
            }
            if (a.f13695a > f13693b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f13698a > f13694c) {
                b.a();
            }
            if (a.f13695a > f13694c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f13698a < f13693b) {
                b.f13699b += fVar.f13673b;
                b.f13700c += fVar.f13674c;
                b.f13701d += fVar.f13675d;
                b.f13702e += fVar.f13676e;
                b.f13704g += fVar.f13677f;
                b.f13703f += fVar.f13678g;
                b.f13698a++;
                return;
            }
            b.a();
        }
    }
}
