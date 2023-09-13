package com.baidu.bdtask.strategy.impl.lifecycle;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.framework.redux.d;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.tieba.pq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/bdtask/strategy/impl/lifecycle/InitiativeLifecycleStrategy;", "Lcom/baidu/bdtask/strategy/impl/lifecycle/a;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "subState", "", "onFinished", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "store", "<init>", "(Lcom/baidu/bdtask/framework/redux/Store;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d<com.baidu.bdtask.ctrl.b, pq> dVar) {
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
            final TaskProcessData processData = b(subTaskState).getResponse().getProcessData();
            DebugTrace.a.c(new Function0<String>(processData) { // from class: com.baidu.bdtask.strategy.impl.lifecycle.InitiativeLifecycleStrategy$onFinished$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskProcessData $processedData;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {processData};
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
                    this.$processedData = processData;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "processedData:" + this.$processedData.toJson();
                    }
                    return (String) invokeV.objValue;
                }
            });
            if (processData.isDone()) {
                BDPTask.m.I(b(subTaskState).getActionId());
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
}
