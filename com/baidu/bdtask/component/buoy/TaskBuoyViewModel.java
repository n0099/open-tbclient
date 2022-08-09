package com.baidu.bdtask.component.buoy;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ip;
import com.repackage.kp;
import com.repackage.ks;
import com.repackage.mp;
import com.repackage.ss;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", "Lcom/repackage/ks;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "viewData", "", "setViewData", "(Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;)V", "", "preProcess", "F", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModelHolder;", "statusHolder", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModelHolder;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/model/info/TaskInfo;", "getTaskInfo", "()Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/framework/ui/mvvm/data/MutableLiveData;", "Lcom/baidu/bdtask/component/buoy/TaskProcessInfo;", "taskProcessInfoLivingData", "Lcom/baidu/bdtask/framework/ui/mvvm/data/MutableLiveData;", "getTaskProcessInfoLivingData", "()Lcom/baidu/bdtask/framework/ui/mvvm/data/MutableLiveData;", "Lcom/baidu/bdtask/component/buoy/TaskStatusInfo;", "taskStatusInfoLivingData", "getTaskStatusInfoLivingData", "<init>", "(Lcom/baidu/bdtask/model/info/TaskInfo;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public class TaskBuoyViewModel extends ks<TaskBuoyViewData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mp b;
    public float c;
    public final ss<kp> d;
    public final ss<ip> e;
    public final TaskInfo f;

    public TaskBuoyViewModel(TaskInfo taskInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = taskInfo;
        this.b = new mp(-1, false, false);
        this.c = -1.0f;
        this.d = new ss<>();
        this.e = new ss<>();
    }

    public final TaskInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (TaskInfo) invokeV.objValue;
    }

    public final ss<ip> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (ss) invokeV.objValue;
    }

    public final ss<kp> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (ss) invokeV.objValue;
    }

    public void f(TaskBuoyViewData taskBuoyViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, taskBuoyViewData) == null) {
            super.b(taskBuoyViewData);
            mp mpVar = new mp(taskBuoyViewData.getTaskStatus().getCurStatus(), taskBuoyViewData.getTaskStatus().getProcess().isCompleted(), taskBuoyViewData.getTaskStatus().isDuplicated());
            if (!Intrinsics.areEqual(mpVar, this.b)) {
                this.d.p(new kp(taskBuoyViewData.getTaskStatus(), taskBuoyViewData.getUiConfig(), taskBuoyViewData.getTotalProcess(), taskBuoyViewData.getExtra()));
                this.b = mpVar;
                DebugTrace.a.c(new TaskBuoyViewModel$setViewData$1(this));
            }
            if (Float.compare(this.c, taskBuoyViewData.getCurProcess().a()) != 0) {
                this.e.p(new ip(taskBuoyViewData.getCurProcess()));
                this.c = taskBuoyViewData.getCurProcess().a();
                DebugTrace.a.c(new TaskBuoyViewModel$setViewData$2(this));
            }
        }
    }
}
