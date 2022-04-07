package com.baidu.bdtask.ui.components.buoy;

import com.baidu.bdtask.component.buoy.TaskBuoyViewData;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.repackage.su;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/bdtask/component/buoy/TaskBuoyViewData;", "onChanged"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskBuoyView$onViewModelBind$1<T> implements su<TaskBuoyViewData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ TaskBuoyView a;

    public TaskBuoyView$onViewModelBind$1(TaskBuoyView taskBuoyView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {taskBuoyView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = taskBuoyView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.su
    /* renamed from: a */
    public final void onChanged(TaskBuoyViewData it) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, it) == null) || it == null) {
            return;
        }
        DebugTrace.a.c(new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$1(this));
        if (!this.a.S()) {
            DebugTrace.a.c(new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$2(this));
            DebugTrace.a.c(new TaskBuoyView$onViewModelBind$1$1$3(it));
        }
        TaskStatus taskStatus = it.getTaskStatus();
        if (taskStatus.isRegistered()) {
            TaskBuoyView taskBuoyView = this.a;
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            taskBuoyView.F(it, new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$3(it, this));
        } else if (taskStatus.isRunning()) {
            z2 = this.a.n;
            if (!z2) {
                TaskBuoyView taskBuoyView2 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                taskBuoyView2.F(it, new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$4(this));
            }
            this.a.c0(new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$5(it, this));
        } else if (taskStatus.isFinished()) {
            z = this.a.n;
            if (!z) {
                this.a.c0(new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$6(this));
                TaskBuoyView taskBuoyView3 = this.a;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                taskBuoyView3.F(it, new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$7(this));
            }
            this.a.c0(new TaskBuoyView$onViewModelBind$1$$special$$inlined$let$lambda$8(it, this));
        }
        this.a.E(taskStatus.getCurStatus());
    }
}
