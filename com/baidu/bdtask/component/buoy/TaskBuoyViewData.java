package com.baidu.bdtask.component.buoy;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.ui.buoy.BuoyViewData;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.tieba.sp;
import com.baidu.tieba.up;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "Lcom/baidu/bdtask/framework/ui/buoy/BuoyViewData;", "", "toString", "()Ljava/lang/String;", "Lcom/baidu/bdtask/component/buoy/TaskSingleProcess;", "curProcess", "Lcom/baidu/bdtask/component/buoy/TaskSingleProcess;", "getCurProcess", "()Lcom/baidu/bdtask/component/buoy/TaskSingleProcess;", "extra", "Ljava/lang/String;", "getExtra", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", TaskStatus.key, "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "getTaskStatus", "()Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "Lcom/baidu/bdtask/model/response/TaskProcessData;", "totalProcess", "Lcom/baidu/bdtask/model/response/TaskProcessData;", "getTotalProcess", "()Lcom/baidu/bdtask/model/response/TaskProcessData;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyUIConfig;", "uiConfig", "Lcom/baidu/bdtask/component/buoy/TaskBuoyUIConfig;", "getUiConfig", "()Lcom/baidu/bdtask/component/buoy/TaskBuoyUIConfig;", "<init>", "(Lcom/baidu/bdtask/ctrl/model/TaskStatus;Lcom/baidu/bdtask/component/buoy/TaskBuoyUIConfig;Lcom/baidu/bdtask/component/buoy/TaskSingleProcess;Lcom/baidu/bdtask/model/response/TaskProcessData;Ljava/lang/String;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskBuoyViewData extends BuoyViewData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final up curProcess;
    public final String extra;
    public final TaskStatus taskStatus;
    public final TaskProcessData totalProcess;
    public final sp uiConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskBuoyViewData(TaskStatus taskStatus, sp spVar, up upVar, TaskProcessData taskProcessData, String str) {
        super(spVar.c(), spVar.g(), spVar.a(), spVar.e(), spVar.d(), spVar.f(), upVar.a(), upVar.b(), spVar.b());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {taskStatus, spVar, upVar, taskProcessData, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5], ((Float) objArr2[6]).floatValue(), ((Long) objArr2[7]).longValue(), (String) objArr2[8]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.taskStatus = taskStatus;
        this.uiConfig = spVar;
        this.curProcess = upVar;
        this.totalProcess = taskProcessData;
        this.extra = str;
    }

    public /* synthetic */ TaskBuoyViewData(TaskStatus taskStatus, sp spVar, up upVar, TaskProcessData taskProcessData, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(taskStatus, spVar, upVar, taskProcessData, (i & 16) != 0 ? "" : str);
    }

    public final up getCurProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.curProcess;
        }
        return (up) invokeV.objValue;
    }

    public final String getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.extra;
        }
        return (String) invokeV.objValue;
    }

    public final TaskStatus getTaskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.taskStatus;
        }
        return (TaskStatus) invokeV.objValue;
    }

    public final TaskProcessData getTotalProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.totalProcess;
        }
        return (TaskProcessData) invokeV.objValue;
    }

    public final sp getUiConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.uiConfig;
        }
        return (sp) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "taskStatus:" + this.taskStatus + "\n uiConfig:" + this.uiConfig + "\n curProcess:" + this.curProcess + "\n totalProcess:" + this.totalProcess + "\n " + this.extra;
        }
        return (String) invokeV.objValue;
    }
}
