package com.baidu.bdtask.strategy.impl.lifecycle;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.redux.d;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iq;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/baidu/bdtask/strategy/impl/lifecycle/PassiveLifecycleStrategy;", "Lcom/baidu/bdtask/strategy/impl/lifecycle/a;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "subState", "", "onFinished", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "onPassiveInterrupted", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "store", "<init>", "(Lcom/baidu/bdtask/framework/redux/Store;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d<com.baidu.bdtask.ctrl.b, iq> dVar) {
        super(dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.bdtask.strategy.impl.lifecycle.a
    public void j(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
            super.j(subTaskState);
            if (m(subTaskState)) {
                return;
            }
            n(subTaskState);
            if (subTaskState.isForceCleaned()) {
                BDPTask.m.H(b(subTaskState).getActionId());
                DebugTrace.a.c(new PassiveLifecycleStrategy$onFinished$1(this, subTaskState));
                return;
            }
            TaskProcessData processData = b(subTaskState).getResponse().getProcessData();
            DebugTrace.a.c(new PassiveLifecycleStrategy$onFinished$2(processData));
            if (processData.isDone()) {
                BDPTask t = BDPTask.m.t();
                if (t != null) {
                    t.Q(subTaskState.getTaskInfo(), 400);
                }
            } else if (b(subTaskState).isVisitAction()) {
                SubTaskState k = a().k(b(subTaskState).getSingleKey());
                if (k != null) {
                    k.reset2Running(false);
                }
            } else {
                SubTaskState k2 = a().k(b(subTaskState).getSingleKey());
                if (k2 != null) {
                    k2.reset2Running(true);
                }
            }
        }
    }

    @Override // com.baidu.bdtask.strategy.impl.lifecycle.a
    public void k(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subTaskState) == null) {
            super.k(subTaskState);
            TaskStatus taskStatus = subTaskState.getTaskStatus();
            DebugTrace.a.c(new PassiveLifecycleStrategy$onPassiveInterrupted$1(taskStatus));
            if (taskStatus.getInterruptErrorNo() == 102) {
                return;
            }
            e();
        }
    }
}
