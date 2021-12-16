package c.a.q0.a.a1.g;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f4552b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadPoolExecutor f4553c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-672977850, "Lc/a/q0/a/a1/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-672977850, "Lc/a/q0/a/a1/g/d;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        f4552b = (availableProcessors * 2) + 1;
        int i2 = f4552b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        f4553c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            f4553c.execute(runnable);
        }
    }
}
