package com.baidu.mobads.sdk.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class be implements RejectedExecutionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public be() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        LinkedBlockingQueue linkedBlockingQueue;
        ThreadFactory threadFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
            av.h(bb.a).e("Exceeded ThreadPoolExecutor pool size");
            synchronized (this) {
                threadPoolExecutor2 = bb.d;
                if (threadPoolExecutor2 == null) {
                    LinkedBlockingQueue unused = bb.e = new LinkedBlockingQueue();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    linkedBlockingQueue = bb.e;
                    threadFactory = bb.f;
                    ThreadPoolExecutor unused2 = bb.d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, linkedBlockingQueue, threadFactory);
                }
            }
            threadPoolExecutor3 = bb.d;
            threadPoolExecutor3.execute(runnable);
        }
    }
}
