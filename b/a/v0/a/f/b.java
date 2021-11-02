package b.a.v0.a.f;

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
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<ScheduledFuture<?>>> f29142a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f29143b;

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f29144c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(974465374, "Lb/a/v0/a/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(974465374, "Lb/a/v0/a/f/b;");
                return;
            }
        }
        f29142a = new ArrayList();
        f29143b = Executors.newFixedThreadPool(2);
        f29144c = Executors.newScheduledThreadPool(2);
    }

    public static synchronized void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            synchronized (b.class) {
                if (f29144c == null || f29144c.isShutdown()) {
                    f29144c = Executors.newScheduledThreadPool(2);
                }
                f29144c.execute(runnable);
            }
        }
    }

    public static synchronized void b(Runnable runnable, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            synchronized (b.class) {
                if (f29144c == null || f29144c.isShutdown()) {
                    f29144c = Executors.newScheduledThreadPool(2);
                }
                f29142a.add(new WeakReference<>(f29144c.scheduleAtFixedRate(runnable, j, j2, TimeUnit.MILLISECONDS)));
            }
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            ExecutorService executorService = f29143b;
            if (executorService == null || executorService.isShutdown()) {
                f29143b = Executors.newFixedThreadPool(2);
            }
            f29143b.execute(runnable);
        }
    }
}
