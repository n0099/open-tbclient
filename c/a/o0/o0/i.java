package c.a.o0.o0;

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
    public static int f13410b = 100;

    /* renamed from: c  reason: collision with root package name */
    public static int f13411c = 10;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13412a;

        /* renamed from: b  reason: collision with root package name */
        public static int f13413b;

        /* renamed from: c  reason: collision with root package name */
        public static int f13414c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imbusy");
                a2.b("totalNum", String.valueOf(f13412a));
                a2.b("tfailNum", String.valueOf(f13413b));
                a2.b("qfailNum", String.valueOf(f13414c));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13412a = 0;
                f13413b = 0;
                f13414c = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static int f13415a;

        /* renamed from: b  reason: collision with root package name */
        public static long f13416b;

        /* renamed from: c  reason: collision with root package name */
        public static long f13417c;

        /* renamed from: d  reason: collision with root package name */
        public static long f13418d;

        /* renamed from: e  reason: collision with root package name */
        public static int f13419e;

        /* renamed from: f  reason: collision with root package name */
        public static int f13420f;

        /* renamed from: g  reason: collision with root package name */
        public static long f13421g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                c.a.e.e.n.a a2 = j.a();
                a2.b("action", "imcost");
                a2.b("dect", String.valueOf(f13416b));
                a2.b("dlsize", String.valueOf(f13417c));
                a2.b("dbt", String.valueOf(f13418d));
                a2.b("pnum", String.valueOf(f13419e));
                a2.b("reqcost", String.valueOf(f13421g));
                a2.b("cpu", String.valueOf(f13420f));
                a2.b("totalNum", String.valueOf(f13415a));
                BdStatisticsManager.getInstance().performance("im", a2);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                f13415a = 0;
                f13416b = 0L;
                f13417c = 0L;
                f13418d = 0L;
                f13419e = 0;
                f13420f = 0;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(858654616, "Lc/a/o0/o0/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(858654616, "Lc/a/o0/o0/i;");
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
            a.f13412a++;
            if (z2) {
                a.f13413b++;
            } else if (z3) {
                a.f13414c++;
            }
            if (a.f13412a > f13410b) {
                a.a();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && k.d().g()) {
            if (b.f13415a > f13411c) {
                b.a();
            }
            if (a.f13412a > f13411c) {
                a.a();
            }
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) && k.d().g()) {
            if (b.f13415a < f13410b) {
                b.f13416b += fVar.f13390b;
                b.f13417c += fVar.f13391c;
                b.f13418d += fVar.f13392d;
                b.f13419e += fVar.f13393e;
                b.f13421g += fVar.f13394f;
                b.f13420f += fVar.f13395g;
                b.f13415a++;
                return;
            }
            b.a();
        }
    }
}
