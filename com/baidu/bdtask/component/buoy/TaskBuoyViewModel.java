package com.baidu.bdtask.component.buoy;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.tieba.cq;
import com.baidu.tieba.eq;
import com.baidu.tieba.et;
import com.baidu.tieba.gq;
import com.baidu.tieba.mt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModel;", "Lcom/baidu/tieba/et;", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "viewData", "", "setViewData", "(Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;)V", "", "preProcess", "F", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModelHolder;", "statusHolder", "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewModelHolder;", "Lcom/baidu/bdtask/model/info/TaskInfo;", NextActive.keyTaskInfo, "Lcom/baidu/bdtask/model/info/TaskInfo;", "getTaskInfo", "()Lcom/baidu/bdtask/model/info/TaskInfo;", "Lcom/baidu/bdtask/framework/ui/mvvm/data/MutableLiveData;", "Lcom/baidu/bdtask/component/buoy/TaskProcessInfo;", "taskProcessInfoLivingData", "Lcom/baidu/bdtask/framework/ui/mvvm/data/MutableLiveData;", "getTaskProcessInfoLivingData", "()Lcom/baidu/bdtask/framework/ui/mvvm/data/MutableLiveData;", "Lcom/baidu/bdtask/component/buoy/TaskStatusInfo;", "taskStatusInfoLivingData", "getTaskStatusInfoLivingData", "<init>", "(Lcom/baidu/bdtask/model/info/TaskInfo;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public class TaskBuoyViewModel extends et<TaskBuoyViewData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gq b;
    public float c;
    public final mt<eq> d;
    public final mt<cq> e;
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
        this.b = new gq(-1, false, false);
        this.c = -1.0f;
        this.d = new mt<>();
        this.e = new mt<>();
    }

    public final TaskInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (TaskInfo) invokeV.objValue;
    }

    public final mt<cq> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (mt) invokeV.objValue;
    }

    public final mt<eq> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (mt) invokeV.objValue;
    }

    public void f(TaskBuoyViewData taskBuoyViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, taskBuoyViewData) == null) {
            super.b(taskBuoyViewData);
            gq gqVar = new gq(taskBuoyViewData.getTaskStatus().getCurStatus(), taskBuoyViewData.getTaskStatus().getProcess().isCompleted(), taskBuoyViewData.getTaskStatus().isDuplicated());
            if (!Intrinsics.areEqual(gqVar, this.b)) {
                this.d.p(new eq(taskBuoyViewData.getTaskStatus(), taskBuoyViewData.getUiConfig(), taskBuoyViewData.getTotalProcess(), taskBuoyViewData.getExtra()));
                this.b = gqVar;
                DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.component.buoy.TaskBuoyViewModel$setViewData$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskBuoyViewModel this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "dispatch new status:" + this.this$0.e().k();
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
            if (Float.compare(this.c, taskBuoyViewData.getCurProcess().a()) != 0) {
                this.e.p(new cq(taskBuoyViewData.getCurProcess()));
                this.c = taskBuoyViewData.getCurProcess().a();
                DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.component.buoy.TaskBuoyViewModel$setViewData$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TaskBuoyViewModel this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "dispatch new process:" + this.this$0.d().k();
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
        }
    }
}
