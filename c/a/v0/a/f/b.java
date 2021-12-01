package c.a.v0.a.f;

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
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<ScheduledFuture<?>>> a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f26531b;

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f26532c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(681062367, "Lc/a/v0/a/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(681062367, "Lc/a/v0/a/f/b;");
                return;
            }
        }
        a = new ArrayList();
        f26531b = Executors.newFixedThreadPool(2);
        f26532c = Executors.newScheduledThreadPool(2);
    }

    public static synchronized void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            synchronized (b.class) {
                if (f26532c == null || f26532c.isShutdown()) {
                    f26532c = Executors.newScheduledThreadPool(2);
                }
                f26532c.execute(runnable);
            }
        }
    }

    public static synchronized void b(Runnable runnable, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            synchronized (b.class) {
                if (f26532c == null || f26532c.isShutdown()) {
                    f26532c = Executors.newScheduledThreadPool(2);
                }
                a.add(new WeakReference<>(f26532c.scheduleAtFixedRate(runnable, j2, j3, TimeUnit.MILLISECONDS)));
            }
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            ExecutorService executorService = f26531b;
            if (executorService == null || executorService.isShutdown()) {
                f26531b = Executors.newFixedThreadPool(2);
            }
            f26531b.execute(runnable);
        }
    }
}
