package b.a.p0.a.a1.g;

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

    /* renamed from: a  reason: collision with root package name */
    public static final int f4038a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f4039b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadPoolExecutor f4040c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-291526392, "Lb/a/p0/a/a1/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-291526392, "Lb/a/p0/a/a1/g/d;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f4038a = availableProcessors;
        f4039b = (availableProcessors * 2) + 1;
        int i2 = f4039b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        f4040c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            f4040c.execute(runnable);
        }
    }
}
