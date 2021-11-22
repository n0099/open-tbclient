package b.a.q0.q0;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i extends j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f13595b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13596c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13597a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13598b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13599c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                b.a.e.f.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f13597a));
                a2.b("tfailNum", String.valueOf(f13598b));
                a2.b("qfailNum", String.valueOf(f13599c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13597a = 0;
                f13598b = 0;
                f13599c = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13600a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13601b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13602c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13603d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13604e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13605f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13606g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                b.a.e.f.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13601b));
                a2.b("dlsize", String.valueOf(f13602c));
                a2.b("dbt", String.valueOf(f13603d));
                a2.b("pnum", String.valueOf(f13604e));
                a2.b("reqcost", String.valueOf(f13606g));
                a2.b("cpu", String.valueOf(f13605f));
                a2.b("totalNum", String.valueOf(f13600a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13600a = 0;
                f13601b = 0L;
                f13602c = 0L;
                f13603d = 0L;
                f13604e = 0;
                f13605f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-77927687, "Lb/a/q0/q0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-77927687, "Lb/a/q0/q0/i;");
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
            a.f13597a++;
            if (z2) {
                a.f13598b++;
            } else if (z3) {
                a.f13599c++;
            }
            if (a.f13597a > f13595b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f13600a > f13596c) {
                b.a();
            }
            if (a.f13597a > f13596c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f13600a < f13595b) {
                b.f13601b += fVar.f13576b;
                b.f13602c += fVar.f13577c;
                b.f13603d += fVar.f13578d;
                b.f13604e += fVar.f13579e;
                b.f13606g += fVar.f13580f;
                b.f13605f += fVar.f13581g;
                b.f13600a++;
                return;
            }
            b.a();
        }
    }
}
