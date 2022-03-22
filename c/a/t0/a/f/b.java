package c.a.t0.a.f;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<ScheduledFuture<?>>> a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f21376b;

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f21377c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1003997, "Lc/a/t0/a/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1003997, "Lc/a/t0/a/f/b;");
                return;
            }
        }
        a = new ArrayList();
        f21376b = Executors.newFixedThreadPool(2);
        f21377c = Executors.newScheduledThreadPool(2);
    }

    public static synchronized void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            synchronized (b.class) {
                if (f21377c == null || f21377c.isShutdown()) {
                    f21377c = Executors.newScheduledThreadPool(2);
                }
                f21377c.execute(runnable);
            }
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (b.class) {
                if (f21377c == null || f21377c.isShutdown()) {
                    f21377c = Executors.newScheduledThreadPool(2);
                }
                a.add(new WeakReference<>(f21377c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
            }
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            ExecutorService executorService = f21376b;
            if (executorService == null || executorService.isShutdown()) {
                f21376b = Executors.newFixedThreadPool(2);
            }
            f21376b.execute(runnable);
        }
    }
}
