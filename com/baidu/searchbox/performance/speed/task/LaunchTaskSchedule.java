package com.baidu.searchbox.performance.speed.task;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.AsyncTaskAssistant;
import com.baidu.searchbox.performance.speed.SpeedRuntime;
import com.baidu.tieba.hc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class LaunchTaskSchedule {
    public static /* synthetic */ Interceptable $ic;
    public static LaunchTaskSchedule sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set historyLifecycle;
    public HashSet mChangeToSyncTaskSet;
    public int mProcessType;
    public BaseTaskPool mTaskPool;

    public LaunchTaskSchedule() {
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
        this.historyLifecycle = new HashSet();
        this.mChangeToSyncTaskSet = new HashSet();
    }

    public static LaunchTaskSchedule getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = new LaunchTaskSchedule();
            }
            return sInstance;
        }
        return (LaunchTaskSchedule) invokeV.objValue;
    }

    private boolean checkStartBefore(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (this.historyLifecycle.contains(Integer.valueOf(i))) {
                return true;
            }
            this.historyLifecycle.add(Integer.valueOf(i));
            return false;
        }
        return invokeI.booleanValue;
    }

    public void start(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || this.mProcessType <= 0 || this.mTaskPool == null || checkStartBefore(i)) {
            return;
        }
        startAsyncTask(i);
        startSyncTask(i);
        startIdleTask(i);
    }

    private void startAsyncTask(int i) {
        List<LaunchTask> taskList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65539, this, i) != null) || (taskList = this.mTaskPool.getTaskList(i, 2)) == null) {
            return;
        }
        try {
            if (SpeedRuntime.getSpeedContext().isMainProcess() && !this.mChangeToSyncTaskSet.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (LaunchTask launchTask : taskList) {
                    if (launchTask.getName() != null && this.mChangeToSyncTaskSet.contains(launchTask.getName()) && (launchTask.getProcess() & this.mProcessType) != 0) {
                        launchTask.run();
                    } else {
                        arrayList.add(launchTask);
                    }
                }
                taskList = arrayList;
            }
        } catch (Exception unused) {
        }
        for (LaunchTask launchTask2 : taskList) {
            if ((launchTask2.getProcess() & this.mProcessType) != 0) {
                AsyncTaskAssistant.executeOnThreadPool(launchTask2, launchTask2.getName());
            }
        }
    }

    public void startTask(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            List<LaunchTask> taskList = this.mTaskPool.getTaskList(i, 2);
            if (taskList != null) {
                for (LaunchTask launchTask : taskList) {
                    launchTask.run();
                }
            }
            List<LaunchTask> taskList2 = this.mTaskPool.getTaskList(i, 1);
            if (taskList2 != null) {
                for (LaunchTask launchTask2 : taskList2) {
                    launchTask2.run();
                }
            }
            List<LaunchTask> taskList3 = this.mTaskPool.getTaskList(i, 3);
            if (taskList3 != null) {
                for (LaunchTask launchTask3 : taskList3) {
                    launchTask3.run();
                }
            }
        }
    }

    private void startIdleTask(int i) {
        List<LaunchTask> taskList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) != null) || (taskList = this.mTaskPool.getTaskList(i, 3)) == null) {
            return;
        }
        for (LaunchTask launchTask : taskList) {
            if ((launchTask.getProcess() & this.mProcessType) != 0) {
                hc.b().a(launchTask.getName(), new Runnable(this, launchTask) { // from class: com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LaunchTaskSchedule this$0;
                    public final /* synthetic */ LaunchTask val$task;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, launchTask};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$task = launchTask;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$task.run();
                        }
                    }
                });
            }
        }
    }

    private void startSyncTask(int i) {
        List<LaunchTask> taskList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65541, this, i) != null) || (taskList = this.mTaskPool.getTaskList(i, 1)) == null) {
            return;
        }
        for (LaunchTask launchTask : taskList) {
            if ((launchTask.getProcess() & this.mProcessType) != 0) {
                launchTask.run();
            }
        }
    }

    public void startTaskInSingleThread(int i) {
        List<LaunchTask> taskList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (taskList = this.mTaskPool.getTaskList(i, 2)) == null) {
            return;
        }
        for (LaunchTask launchTask : taskList) {
            if ((launchTask.getProcess() & this.mProcessType) != 0) {
                new Thread(launchTask).start();
            }
        }
    }

    public void init(int i, BaseTaskPool baseTaskPool, HashSet hashSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, baseTaskPool, hashSet) == null) {
            this.mProcessType = i;
            this.mTaskPool = baseTaskPool;
            this.mChangeToSyncTaskSet = hashSet;
        }
    }
}
