package com.baidu.bdtask.strategy;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.TaskState;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.tieba.ku;
import com.baidu.tieba.lu;
import com.baidu.tieba.zu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/bdtask/strategy/PassiveLifecycleStrategy;", "Lcom/baidu/tieba/zu;", "Lcom/baidu/bdtask/ctrl/SubTaskState;", TaskState.key, "", "onInterruptException", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class e implements zu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // com.baidu.tieba.zu
    public void a(SubTaskState subTaskState) {
        lu d;
        lu d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, subTaskState) == null) {
            zu.a.c(this, subTaskState);
            final int curStatusCode = subTaskState.getTaskStatus().getCurStatusCode();
            DebugTrace.a.c(new Function0<String>(curStatusCode) { // from class: com.baidu.bdtask.strategy.PassiveLifecycleStrategy$onInterruptException$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ int $errorNo;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(curStatusCode)};
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
                    this.$errorNo = curStatusCode;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "processException errorNo:" + this.$errorNo;
                    }
                    return (String) invokeV.objValue;
                }
            });
            if (curStatusCode != 103) {
                if (curStatusCode != 11002 && curStatusCode != 12002 && curStatusCode != 13002 && curStatusCode != 19004) {
                    BDPTask t = BDPTask.m.t();
                    if (t != null) {
                        t.Q(subTaskState.getTaskInfo(), curStatusCode);
                        return;
                    }
                    return;
                }
                ku v = BDPTask.m.v();
                if (v != null && (d2 = v.d()) != null) {
                    d2.c(subTaskState.getTaskInfo().getActionId(), "unregister by offline");
                    return;
                }
                return;
            }
            ku v2 = BDPTask.m.v();
            if (v2 != null && (d = v2.d()) != null) {
                d.c(subTaskState.getTaskInfo().getActionId(), "task is expired");
            }
        }
    }

    @Override // com.baidu.tieba.zu
    public boolean b(TaskInfo taskInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, taskInfo, i)) == null) {
            return zu.a.b(this, taskInfo, i);
        }
        return invokeLI.booleanValue;
    }

    public void c(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subTaskState) == null) {
            zu.a.a(this, subTaskState);
        }
    }
}
