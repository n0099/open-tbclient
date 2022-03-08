package c.a.p0.a.x.u.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8936b;

    /* renamed from: c  reason: collision with root package name */
    public static Runnable f8937c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.x.u.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0585a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0585a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.e.a.a.e(AppRuntime.getAppContext());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.e.a.a.d(AppRuntime.getAppContext()).g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1780144695, "Lc/a/p0/a/x/u/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1780144695, "Lc/a/p0/a/x/u/h/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        c.a.p0.a.s0.a.g0().getSwitch("swan_cpu_booster", 0);
        f8936b = b(0);
        if (a) {
            String str = "swan_cpu_booster - 0";
            String str2 = "SWAN_CPU_BOOSTER - " + f8936b;
        }
        a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f8936b) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            c.a.p0.e.a.a.b(a);
            if (f8937c == null) {
                f8937c = new b();
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "init cpu booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }

    public static boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 <= 0) {
                return false;
            }
            if (i2 == 1) {
                return true;
            }
            if (i2 == 2) {
                return c.a.p0.a.s0.a.u0().a();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65539, null, z) == null) && f8936b) {
            if (a) {
                String str = "cpu-booster preInit async ? - " + z;
            }
            RunnableC0585a runnableC0585a = new RunnableC0585a();
            if (z) {
                ExecutorUtilsExt.postOnElastic(runnableC0585a, "booster-preInit", 3);
            } else {
                runnableC0585a.run();
            }
        }
    }

    public static void d(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) || runnable == null) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(runnable, "SwanCpuBoosterWrapper", 0);
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && f8936b) {
            boolean z = a;
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            d(f8937c);
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "startBooster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }
}
