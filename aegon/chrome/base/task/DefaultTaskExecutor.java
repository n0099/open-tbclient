package aegon.chrome.base.task;

import aegon.chrome.base.ThreadUtils;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class DefaultTaskExecutor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap;

    public DefaultTaskExecutor() {
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
        this.mTraitsToRunnerMap = new HashMap();
    }

    public static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }

    public final synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        InterceptResult invokeV;
        ChoreographerTaskRunner choreographerTaskRunner;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                choreographerTaskRunner = (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(DefaultTaskExecutor$$Lambda$1.$ic);
            }
            return choreographerTaskRunner;
        }
        return (ChoreographerTaskRunner) invokeV.objValue;
    }

    public TaskRunner createTaskRunner(TaskTraits taskTraits) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskTraits)) == null) ? taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new TaskRunnerImpl(taskTraits, "TaskRunnerImpl", 0) : (TaskRunner) invokeL.objValue;
    }

    public synchronized void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{taskTraits, runnable, Long.valueOf(j)}) == null) {
            synchronized (this) {
                if (taskTraits.mExtensionId != 0) {
                    TaskRunner createTaskRunner = createTaskRunner(taskTraits);
                    createTaskRunner.postDelayedTask(runnable, j);
                    createTaskRunner.destroy();
                } else {
                    TaskRunner taskRunner = this.mTraitsToRunnerMap.get(taskTraits);
                    if (taskRunner == null) {
                        taskRunner = createTaskRunner(taskTraits);
                        taskRunner.disableLifetimeCheck();
                        this.mTraitsToRunnerMap.put(taskTraits, taskRunner);
                    }
                    taskRunner.postDelayedTask(runnable, j);
                }
            }
        }
    }
}
