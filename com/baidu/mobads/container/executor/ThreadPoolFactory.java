package com.baidu.mobads.container.executor;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class ThreadPoolFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BACKUP_POOL_SIZE = 5;
    public static final int KEEP_ALIVE_SECONDS = 60;
    public static final String LOG_TAG = "ThreadPoolFactory";
    public static ThreadPoolExecutor sBackupExecutor;
    public static LinkedBlockingQueue<Runnable> sBackupExecutorQueue;
    public static final RejectedExecutionHandler sRunOnSerialPolicy;
    public static final ThreadFactory sThreadFactory;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1794669332, "Lcom/baidu/mobads/container/executor/ThreadPoolFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1794669332, "Lcom/baidu/mobads/container/executor/ThreadPoolFactory;");
                return;
            }
        }
        sThreadFactory = new ThreadFactory() { // from class: com.baidu.mobads.container.executor.ThreadPoolFactory.1
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
                    Thread thread = new Thread(runnable, "TaskScheduler #" + this.mCount.getAndIncrement());
                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(this) { // from class: com.baidu.mobads.container.executor.ThreadPoolFactory.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$0;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public void uncaughtException(Thread thread2, Throwable th) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeLL(1048576, this, thread2, th) == null) {
                                Log.i("ThreadPoolFactory", "线程名字=" + thread2.getName() + "线程crash信息", th);
                            }
                        }
                    });
                    return thread;
                }
                return (Thread) invokeL.objValue;
            }
        };
        sRunOnSerialPolicy = new RejectedExecutionHandler() { // from class: com.baidu.mobads.container.executor.ThreadPoolFactory.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

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
                    }
                }
            }

            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
                    Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
                    synchronized (this) {
                        if (ThreadPoolFactory.sBackupExecutor == null) {
                            LinkedBlockingQueue unused = ThreadPoolFactory.sBackupExecutorQueue = new LinkedBlockingQueue();
                            ThreadPoolExecutor unused2 = ThreadPoolFactory.sBackupExecutor = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, ThreadPoolFactory.sBackupExecutorQueue, ThreadPoolFactory.sThreadFactory);
                        }
                    }
                    ThreadPoolFactory.sBackupExecutor.execute(runnable);
                }
            }
        };
    }

    public ThreadPoolFactory() {
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

    public static ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? new ScheduledThreadPoolExecutor(i2, sThreadFactory) : (ScheduledThreadPoolExecutor) invokeI.objValue;
    }

    public static ThreadPoolExecutor getThreadPoolExecutor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i2, i3)) == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), sThreadFactory);
            threadPoolExecutor.setRejectedExecutionHandler(sRunOnSerialPolicy);
            return threadPoolExecutor;
        }
        return (ThreadPoolExecutor) invokeII.objValue;
    }
}
