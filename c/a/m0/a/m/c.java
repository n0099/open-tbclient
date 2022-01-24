package c.a.m0.a.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f4590c;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f4591b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f4590c == null) {
                synchronized (c.class) {
                    if (f4590c == null) {
                        f4590c = new c();
                    }
                }
            }
            return f4590c;
        }
        return (c) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = d.g(5, 15);
            this.f4591b = d.f(3);
        }
    }

    public void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) || runnable == null) {
            return;
        }
        try {
            this.a.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void d(b bVar, long j2, long j3, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3), timeUnit}) == null) || bVar == null || (scheduledThreadPoolExecutor = this.f4591b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            bVar.i(System.currentTimeMillis());
            bVar.h(this.f4591b.scheduleAtFixedRate(bVar, j2, j3, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
