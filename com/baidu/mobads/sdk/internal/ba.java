package com.baidu.mobads.sdk.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class ba {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "TaskScheduler";
    public static volatile ba d;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor b;
    public ScheduledThreadPoolExecutor c;

    public ba() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b();
    }

    public static ba a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (ba.class) {
                    if (d == null) {
                        d = new ba();
                    }
                }
            }
            return d;
        }
        return (ba) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.b = bb.a(1, 1);
            this.c = bb.a(1);
        }
    }

    public void a(h hVar) {
        ThreadPoolExecutor threadPoolExecutor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) && hVar != null && (threadPoolExecutor = this.b) != null && !threadPoolExecutor.isShutdown()) {
            try {
                hVar.a(System.currentTimeMillis());
                FutureTask futureTask = null;
                if (this.b != null && !this.b.isShutdown()) {
                    futureTask = (FutureTask) this.b.submit(hVar);
                }
                hVar.a((Future) futureTask);
            } catch (Throwable unused) {
            }
        }
    }

    public void a(h hVar, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hVar, Long.valueOf(j), Long.valueOf(j2), timeUnit}) == null) && hVar != null && (scheduledThreadPoolExecutor = this.c) != null && !scheduledThreadPoolExecutor.isShutdown()) {
            try {
                hVar.a(System.currentTimeMillis());
                hVar.a((Future) this.c.scheduleAtFixedRate(hVar, j, j2, timeUnit));
            } catch (Throwable unused) {
            }
        }
    }

    public void a(h hVar, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hVar, Long.valueOf(j), timeUnit}) == null) && hVar != null && (scheduledThreadPoolExecutor = this.c) != null && !scheduledThreadPoolExecutor.isShutdown()) {
            try {
                hVar.a(System.currentTimeMillis());
                hVar.a((Future) this.c.schedule(hVar, j, timeUnit));
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) && runnable != null && (threadPoolExecutor = this.b) != null && !threadPoolExecutor.isShutdown()) {
            try {
                this.b.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }
}
