package com.baidu.adp.framework.cmdRouter;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class DefaultPoolExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CPU_COUNT;
    public static final int MAX_CORE_POOL_SIZE;
    public static final long SURPLUS_THREAD_LIFE = 30;
    public static ThreadPoolExecutor executor;
    public static final ThreadFactory sThreadFactory;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1223334200, "Lcom/baidu/adp/framework/cmdRouter/DefaultPoolExecutor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1223334200, "Lcom/baidu/adp/framework/cmdRouter/DefaultPoolExecutor;");
                return;
            }
        }
        sThreadFactory = new ThreadFactory() { // from class: com.baidu.adp.framework.cmdRouter.DefaultPoolExecutor.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final AtomicInteger mCount;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mCount = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "EasyRouter #" + this.mCount.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        MAX_CORE_POOL_SIZE = availableProcessors + 1;
    }

    public DefaultPoolExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ThreadPoolExecutor newDefaultPoolExecutor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            int min = Math.min(i2, MAX_CORE_POOL_SIZE);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(min, min, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), sThreadFactory);
            executor = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return executor;
        }
        return (ThreadPoolExecutor) invokeI.objValue;
    }
}
