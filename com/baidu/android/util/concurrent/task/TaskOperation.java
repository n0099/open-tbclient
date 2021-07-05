package com.baidu.android.util.concurrent.task;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.task.TaskManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TaskOperation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] mNextTaskParams;
    public TaskManager.TaskManagerState mTaskManagerStatus;

    public TaskOperation() {
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
        this.mNextTaskParams = null;
        this.mTaskManagerStatus = TaskManager.TaskManagerState.CONTINUE;
    }

    public void appendTaskParam(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            appendTaskParams(new Object[]{obj});
        }
    }

    public void appendTaskParams(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) || objArr == null) {
            return;
        }
        setTaskParams(new TaskOperation(objArr));
    }

    public TaskManager.TaskManagerState getTaskManagerStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTaskManagerStatus : (TaskManager.TaskManagerState) invokeV.objValue;
    }

    public Object[] getTaskParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mNextTaskParams : (Object[]) invokeV.objValue;
    }

    public void setTaskManagerStatus(TaskManager.TaskManagerState taskManagerState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, taskManagerState) == null) {
            this.mTaskManagerStatus = taskManagerState;
        }
    }

    public void setTaskParams(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, objArr) == null) {
            this.mNextTaskParams = objArr;
        }
    }

    public void setTaskParamsEmpty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mNextTaskParams = null;
        }
    }

    public void setTaskParams(TaskOperation taskOperation) {
        Object[] taskParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, taskOperation) == null) {
            if (taskOperation == this) {
                throw new IllegalArgumentException("The argument can NOT be self.");
            }
            if (taskOperation == null || (taskParams = taskOperation.getTaskParams()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Object[] objArr = this.mNextTaskParams;
            if (objArr != null) {
                for (Object obj : objArr) {
                    arrayList.add(obj);
                }
            }
            for (Object obj2 : taskParams) {
                arrayList.add(obj2);
            }
            this.mNextTaskParams = arrayList.toArray();
        }
    }

    public TaskOperation(Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {objArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mNextTaskParams = null;
        this.mTaskManagerStatus = TaskManager.TaskManagerState.CONTINUE;
        this.mNextTaskParams = objArr;
    }

    public TaskOperation(TaskOperation taskOperation) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskOperation};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNextTaskParams = null;
        this.mTaskManagerStatus = TaskManager.TaskManagerState.CONTINUE;
        setTaskParams(taskOperation);
    }
}
