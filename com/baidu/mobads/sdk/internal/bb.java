package com.baidu.mobads.sdk.internal;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class bb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "ThreadPoolFactory";
    public static final int b = 2;
    public static final int c = 60;
    public static ThreadPoolExecutor d;
    public static LinkedBlockingQueue<Runnable> e;
    public static final ThreadFactory f;
    public static final RejectedExecutionHandler g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833693455, "Lcom/baidu/mobads/sdk/internal/bb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833693455, "Lcom/baidu/mobads/sdk/internal/bb;");
                return;
            }
        }
        f = new bc();
        g = new be();
    }

    public bb() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ScheduledThreadPoolExecutor a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return new ScheduledThreadPoolExecutor(i, f);
        }
        return (ScheduledThreadPoolExecutor) invokeI.objValue;
    }

    public static ThreadPoolExecutor a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f);
            threadPoolExecutor.setRejectedExecutionHandler(g);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }
        return (ThreadPoolExecutor) invokeII.objValue;
    }
}
