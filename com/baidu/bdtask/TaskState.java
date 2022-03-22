package com.baidu.bdtask;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006#"}, d2 = {"Lcom/baidu/bdtask/TaskState;", "Lcom/baidu/bdtask/model/ITaskModelData;", "Lcom/baidu/bdtask/model/info/TaskInfo;", "component1", "()Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "component2", "()Lcom/baidu/bdtask/ctrl/model/TaskStatus;", NextActive.keyTaskInfo, TaskStatus.key, "copy", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)Lcom/baidu/bdtask/TaskState;", "deepCopy", "()Lcom/baidu/bdtask/TaskState;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "", "toString", "()Ljava/lang/String;", "Lcom/baidu/bdtask/model/info/TaskInfo;", "getTaskInfo", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "getTaskStatus", "<init>", "(Lcom/baidu/bdtask/model/info/TaskInfo;Lcom/baidu/bdtask/ctrl/model/TaskStatus;)V", "INS", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class TaskState implements ITaskModelData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a INS;
    public static final String key = "taskState";
    public transient /* synthetic */ FieldHolder $fh;
    public final TaskInfo taskInfo;
    public final TaskStatus taskStatus;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-890463031, "Lcom/baidu/bdtask/TaskState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-890463031, "Lcom/baidu/bdtask/TaskState;");
                return;
            }
        }
        INS = new a(null);
    }

    public TaskState(TaskInfo taskInfo, TaskStatus taskStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo, taskStatus};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.taskInfo = taskInfo;
        this.taskStatus = taskStatus;
    }

    public static /* synthetic */ TaskState copy$default(TaskState taskState, TaskInfo taskInfo, TaskStatus taskStatus, int i, Object obj) {
        if ((i & 1) != 0) {
            taskInfo = taskState.taskInfo;
        }
        if ((i & 2) != 0) {
            taskStatus = taskState.taskStatus;
        }
        return taskState.copy(taskInfo, taskStatus);
    }

    public final TaskInfo component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.taskInfo : (TaskInfo) invokeV.objValue;
    }

    public final TaskStatus component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.taskStatus : (TaskStatus) invokeV.objValue;
    }

    public final TaskState copy(TaskInfo taskInfo, TaskStatus taskStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, taskInfo, taskStatus)) == null) ? new TaskState(taskInfo, taskStatus) : (TaskState) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof TaskState) {
                    TaskState taskState = (TaskState) obj;
                    return Intrinsics.areEqual(this.taskInfo, taskState.taskInfo) && Intrinsics.areEqual(this.taskStatus, taskState.taskStatus);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final TaskInfo getTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.taskInfo : (TaskInfo) invokeV.objValue;
    }

    public final TaskStatus getTaskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.taskStatus : (TaskStatus) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TaskInfo taskInfo = this.taskInfo;
            int hashCode = (taskInfo != null ? taskInfo.hashCode() : 0) * 31;
            TaskStatus taskStatus = this.taskStatus;
            return hashCode + (taskStatus != null ? taskStatus.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ITaskModelData.a.a(this) : invokeV.booleanValue;
    }

    @Override // com.baidu.bdtask.model.ITaskModelData
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("info", this.taskInfo.toJson());
            jSONObject.put(TaskStatus.key, this.taskStatus.toJson());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "TaskState(taskInfo=" + this.taskInfo + ", taskStatus=" + this.taskStatus + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.bdtask.model.ITaskModelData
    public TaskState deepCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new TaskState(this.taskInfo.deepCopy(), this.taskStatus.deepCopy()) : (TaskState) invokeV.objValue;
    }
}
