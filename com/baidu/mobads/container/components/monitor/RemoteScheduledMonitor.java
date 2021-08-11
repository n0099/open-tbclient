package com.baidu.mobads.container.components.monitor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class RemoteScheduledMonitor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MONITOR_INTERVAL = 500;
    public static RemoteScheduledMonitor mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile AtomicBoolean mMonitorRunning;
    public List<IScheduleTask> mTaskList;
    public ScheduledTask mTaskRunnable;

    /* loaded from: classes5.dex */
    public class ScheduledTask extends BaseTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RemoteScheduledMonitor this$0;

        public ScheduledTask(RemoteScheduledMonitor remoteScheduledMonitor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {remoteScheduledMonitor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = remoteScheduledMonitor;
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.this$0.mMonitorRunning.get()) {
                        for (IScheduleTask iScheduleTask : this.this$0.mTaskList) {
                            if (iScheduleTask.handle()) {
                                this.this$0.mTaskList.remove(iScheduleTask);
                            }
                        }
                        if (this.this$0.mTaskList.isEmpty()) {
                            stop();
                            return null;
                        }
                        return null;
                    }
                    stop();
                    return null;
                } catch (Throwable th) {
                    RemoteXAdLogger.getInstance().i(th);
                    stop();
                    return null;
                }
            }
            return invokeV.objValue;
        }

        public void stop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.mMonitorRunning.set(false);
                this.this$0.mTaskList.clear();
                cancel();
            }
        }
    }

    public RemoteScheduledMonitor() {
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
        this.mTaskRunnable = new ScheduledTask(this);
        this.mMonitorRunning = new AtomicBoolean(false);
        this.mTaskList = Collections.synchronizedList(new ArrayList());
    }

    public static synchronized RemoteScheduledMonitor getInstance() {
        InterceptResult invokeV;
        RemoteScheduledMonitor remoteScheduledMonitor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (RemoteScheduledMonitor.class) {
                if (mInstance == null) {
                    mInstance = new RemoteScheduledMonitor();
                }
                remoteScheduledMonitor = mInstance;
            }
            return remoteScheduledMonitor;
        }
        return (RemoteScheduledMonitor) invokeV.objValue;
    }

    public void addTask(IScheduleTask iScheduleTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iScheduleTask) == null) {
            this.mTaskList.add(iScheduleTask);
        }
    }

    public void removeTask(IScheduleTask iScheduleTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iScheduleTask) == null) {
            this.mTaskList.remove(iScheduleTask);
        }
    }

    public synchronized void startMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (!this.mMonitorRunning.get()) {
                    TaskScheduler.getInstance().submitAtFixedRate(this.mTaskRunnable, 0L, 500L, TimeUnit.MILLISECONDS);
                }
                this.mMonitorRunning.set(true);
            }
        }
    }

    public synchronized void stopMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.mMonitorRunning.set(false);
                this.mTaskList.clear();
            }
        }
    }
}
