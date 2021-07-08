package com.baidu.mobads.sdk.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class TaskScheduler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "TaskScheduler";
    public static volatile TaskScheduler sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadPoolExecutor mHighPoolExecutor;
    public ScheduledThreadPoolExecutor mScheduledPoolExecutor;

    public TaskScheduler() {
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
        initThreadPool();
    }

    public static TaskScheduler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (TaskScheduler.class) {
                    if (sInstance == null) {
                        sInstance = new TaskScheduler();
                    }
                }
            }
            return sInstance;
        }
        return (TaskScheduler) invokeV.objValue;
    }

    private void initThreadPool() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mHighPoolExecutor = ThreadPoolFactory.getThreadPoolExecutor(1, 5);
            this.mScheduledPoolExecutor = ThreadPoolFactory.getScheduledThreadPoolExecutor(2);
        }
    }

    public void submit(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) || runnable == null || (threadPoolExecutor = this.mHighPoolExecutor) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.mHighPoolExecutor.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void submitAtFixedRate(BaseTask baseTask, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{baseTask, Long.valueOf(j), Long.valueOf(j2), timeUnit}) == null) || baseTask == null || (scheduledThreadPoolExecutor = this.mScheduledPoolExecutor) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            baseTask.setTaskAddTime(System.currentTimeMillis());
            baseTask.setTask(this.mScheduledPoolExecutor.scheduleAtFixedRate(baseTask, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void submitWithDelay(BaseTask baseTask, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{baseTask, Long.valueOf(j), timeUnit}) == null) || baseTask == null || (scheduledThreadPoolExecutor = this.mScheduledPoolExecutor) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            baseTask.setTaskAddTime(System.currentTimeMillis());
            baseTask.setTask(this.mScheduledPoolExecutor.schedule(baseTask, j, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void submit(BaseTask baseTask) {
        ThreadPoolExecutor threadPoolExecutor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, baseTask) == null) || baseTask == null || (threadPoolExecutor = this.mHighPoolExecutor) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            baseTask.setTaskAddTime(System.currentTimeMillis());
            FutureTask futureTask = null;
            if (this.mHighPoolExecutor != null && !this.mHighPoolExecutor.isShutdown()) {
                futureTask = (FutureTask) this.mHighPoolExecutor.submit(baseTask);
            }
            baseTask.setTask(futureTask);
        } catch (Throwable unused) {
        }
    }
}
