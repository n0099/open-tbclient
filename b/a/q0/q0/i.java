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
    public static int f12845b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f12846c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f12847a;

        /* renamed from: b  reason: collision with root package name */
        public static int f12848b;

        /* renamed from: c  reason: collision with root package name */
        public static int f12849c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                b.a.e.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f12847a));
                a2.b("tfailNum", String.valueOf(f12848b));
                a2.b("qfailNum", String.valueOf(f12849c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f12847a = 0;
                f12848b = 0;
                f12849c = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f12850a;

        /* renamed from: b  reason: collision with root package name */
        public static long f12851b;

        /* renamed from: c  reason: collision with root package name */
        public static long f12852c;

        /* renamed from: d  reason: collision with root package name */
        public static long f12853d;

        /* renamed from: e  reason: collision with root package name */
        public static int f12854e;

        /* renamed from: f  reason: collision with root package name */
        public static int f12855f;

        /* renamed from: g  reason: collision with root package name */
        public static long f12856g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                b.a.e.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f12851b));
                a2.b("dlsize", String.valueOf(f12852c));
                a2.b("dbt", String.valueOf(f12853d));
                a2.b("pnum", String.valueOf(f12854e));
                a2.b("reqcost", String.valueOf(f12856g));
                a2.b("cpu", String.valueOf(f12855f));
                a2.b("totalNum", String.valueOf(f12850a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f12850a = 0;
                f12851b = 0L;
                f12852c = 0L;
                f12853d = 0L;
                f12854e = 0;
                f12855f = 0;
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
            a.f12847a++;
            if (z2) {
                a.f12848b++;
            } else if (z3) {
                a.f12849c++;
            }
            if (a.f12847a > f12845b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f12850a > f12846c) {
                b.a();
            }
            if (a.f12847a > f12846c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f12850a < f12845b) {
                b.f12851b += fVar.f12826b;
                b.f12852c += fVar.f12827c;
                b.f12853d += fVar.f12828d;
                b.f12854e += fVar.f12829e;
                b.f12856g += fVar.f12830f;
                b.f12855f += fVar.f12831g;
                b.f12850a++;
                return;
            }
            b.a();
        }
    }
}
