package c.a.u0.a.f;

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
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<ScheduledFuture<?>>> f30243a;

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f30244b;

    /* renamed from: c  reason: collision with root package name */
    public static ScheduledExecutorService f30245c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1806450466, "Lc/a/u0/a/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1806450466, "Lc/a/u0/a/f/b;");
                return;
            }
        }
        f30243a = new ArrayList();
        f30244b = Executors.newFixedThreadPool(2);
        f30245c = Executors.newScheduledThreadPool(2);
    }

    public static synchronized void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            synchronized (b.class) {
                if (f30245c == null || f30245c.isShutdown()) {
                    f30245c = Executors.newScheduledThreadPool(2);
                }
                f30245c.execute(runnable);
            }
        }
    }

    public static synchronized void b(Runnable runnable, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            synchronized (b.class) {
                if (f30245c == null || f30245c.isShutdown()) {
                    f30245c = Executors.newScheduledThreadPool(2);
                }
                f30243a.add(new WeakReference<>(f30245c.scheduleAtFixedRate(runnable, j2, j3, TimeUnit.MILLISECONDS)));
            }
        }
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            ExecutorService executorService = f30244b;
            if (executorService == null || executorService.isShutdown()) {
                f30244b = Executors.newFixedThreadPool(2);
            }
            f30244b.execute(runnable);
        }
    }
}
