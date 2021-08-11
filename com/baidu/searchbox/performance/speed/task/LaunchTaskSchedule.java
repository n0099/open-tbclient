package com.baidu.searchbox.performance.speed.task;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.AsyncTaskAssistant;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@MainThread
/* loaded from: classes5.dex */
public class LaunchTaskSchedule {
    public static /* synthetic */ Interceptable $ic;
    public static LaunchTaskSchedule sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public int mProcessType;
    public BaseTaskPool mTaskPool;

    public LaunchTaskSchedule() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static LaunchTaskSchedule getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sInstance == null) {
                sInstance = new LaunchTaskSchedule();
            }
            return sInstance;
        }
        return (LaunchTaskSchedule) invokeV.objValue;
    }

    private void startAsyncTask(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            AsyncTaskAssistant.executeOnThreadPool(new Runnable(this, i2) { // from class: com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LaunchTaskSchedule this$0;
                public final /* synthetic */ int val$lifeCycle;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$lifeCycle = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    List<LaunchTask> taskList;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (taskList = this.this$0.mTaskPool.getTaskList(this.val$lifeCycle, true)) == null) {
                        return;
                    }
                    for (LaunchTask launchTask : taskList) {
                        if ((launchTask.getProcess() & this.this$0.mProcessType) != 0) {
                            AsyncTaskAssistant.executeOnThreadPool(launchTask, launchTask.getName());
                        }
                    }
                }
            }, "startAsync");
        }
    }

    private void startSyncTask(int i2) {
        List<LaunchTask> taskList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) || (taskList = this.mTaskPool.getTaskList(i2, false)) == null) {
            return;
        }
        for (LaunchTask launchTask : taskList) {
            if ((launchTask.getProcess() & this.mProcessType) != 0) {
                launchTask.run();
            }
        }
    }

    public void init(int i2, @NonNull BaseTaskPool baseTaskPool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, baseTaskPool) == null) {
            this.mProcessType = i2;
            this.mTaskPool = baseTaskPool;
        }
    }

    public void start(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.mProcessType <= 0 || this.mTaskPool == null) {
            return;
        }
        startAsyncTask(i2);
        startSyncTask(i2);
    }
}
