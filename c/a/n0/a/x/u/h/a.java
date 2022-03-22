package c.a.n0.a.x.u.h;

import android.util.Log;
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
    public static final boolean f7506b;

    /* renamed from: c  reason: collision with root package name */
    public static Runnable f7507c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.x.u.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0577a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0577a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.e.a.a.e(AppRuntime.getAppContext());
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.e.a.a.d(AppRuntime.getAppContext()).g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1193338681, "Lc/a/n0/a/x/u/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1193338681, "Lc/a/n0/a/x/u/h/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        c.a.n0.a.s0.a.g0().getSwitch("swan_cpu_booster", 0);
        f7506b = b(0);
        if (a) {
            Log.d("SwanCpuBoosterWrapper", "swan_cpu_booster - 0");
            Log.d("SwanCpuBoosterWrapper", "SWAN_CPU_BOOSTER - " + f7506b);
        }
        a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f7506b) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            c.a.n0.e.a.a.b(a);
            if (f7507c == null) {
                f7507c = new b();
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanCpuBoosterWrapper", "init cpu booster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i <= 0) {
                return false;
            }
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return c.a.n0.a.s0.a.u0().a();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65539, null, z) == null) && f7506b) {
            if (a) {
                Log.d("SwanCpuBoosterWrapper", "cpu-booster preInit async ? - " + z);
            }
            RunnableC0577a runnableC0577a = new RunnableC0577a();
            if (z) {
                ExecutorUtilsExt.postOnElastic(runnableC0577a, "booster-preInit", 3);
            } else {
                runnableC0577a.run();
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
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && f7506b) {
            if (a) {
                Log.d("SwanCpuBoosterWrapper", "startBooster");
            }
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            d(f7507c);
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanCpuBoosterWrapper", "startBooster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }
}
