package b.a.p0.a.h0.u.h;

import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6206a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6207b;

    /* renamed from: c  reason: collision with root package name */
    public static Runnable f6208c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.h0.u.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0262a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0262a() {
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
                b.a.p0.e.a.a.e(AppRuntime.getAppContext());
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
                b.a.p0.e.a.a.d(AppRuntime.getAppContext()).g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2093159348, "Lb/a/p0/a/h0/u/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2093159348, "Lb/a/p0/a/h0/u/h/a;");
                return;
            }
        }
        f6206a = k.f6863a;
        b.a.p0.a.c1.a.g0().getSwitch("swan_cpu_booster", 0);
        f6207b = b(0);
        if (f6206a) {
            String str = "swan_cpu_booster - 0";
            String str2 = "SWAN_CPU_BOOSTER - " + f6207b;
        }
        a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && f6207b) {
            long currentTimeMillis = f6206a ? System.currentTimeMillis() : 0L;
            b.a.p0.e.a.a.b(f6206a);
            if (f6208c == null) {
                f6208c = new b();
            }
            if (f6206a) {
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
                return b.a.p0.a.c1.a.u0().a();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65539, null, z) == null) && f6207b) {
            if (f6206a) {
                String str = "cpu-booster preInit async ? - " + z;
            }
            RunnableC0262a runnableC0262a = new RunnableC0262a();
            if (z) {
                ExecutorUtilsExt.postOnElastic(runnableC0262a, "booster-preInit", 3);
            } else {
                runnableC0262a.run();
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
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) && f6207b) {
            boolean z = f6206a;
            long currentTimeMillis = f6206a ? System.currentTimeMillis() : 0L;
            d(f6208c);
            if (f6206a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                String str = "startBooster cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms";
            }
        }
    }
}
