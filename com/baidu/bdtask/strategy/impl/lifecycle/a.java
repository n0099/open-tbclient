package com.baidu.bdtask.strategy.impl.lifecycle;

import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.redux.d;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.guide.TaskGuideData;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.tieba.dr;
import com.baidu.tieba.dt;
import com.baidu.tieba.kq;
import com.baidu.tieba.lq;
import com.baidu.tieba.mq;
import com.baidu.tieba.pq;
import com.baidu.tieba.qq;
import com.baidu.tieba.xu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000B\u001b\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020&0%¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0002\u001a\u00020\u0001H\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001e\u0010\u001aJ!\u0010\"\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b$\u0010\u001aR\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020&0%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/baidu/bdtask/strategy/impl/lifecycle/BaseLifecycleStrategy;", "", "activeNextTask", "()V", "Lcom/baidu/bdtask/ctrl/SubTaskState;", "subState", "", "finishAborted", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)Z", "finishGuideShowAborted", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "getAppState", "()Lcom/baidu/bdtask/ctrl/BDPTaskState;", "Lcom/baidu/bdtask/framework/redux/Action;", "getCurAction", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)Lcom/baidu/bdtask/framework/redux/Action;", "Lcom/baidu/bdtask/model/guide/TaskGuideData;", "getGuide", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)Lcom/baidu/bdtask/model/guide/TaskGuideData;", "Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "getStatus", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)Lcom/baidu/bdtask/ctrl/model/TaskStatus;", "Lcom/baidu/bdtask/model/info/TaskInfo;", "getTaskInfo", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)Lcom/baidu/bdtask/model/info/TaskInfo;", "onFinished", "(Lcom/baidu/bdtask/ctrl/SubTaskState;)V", "onPassiveInterrupted", "onRegistered", "onRunning", "onUnRegistered", "", "actionId", "duplicateId", "requestTaskComplete", "(Ljava/lang/String;Ljava/lang/String;)V", "showFinishGuide", "Lcom/baidu/bdtask/framework/redux/Store;", "Lcom/baidu/bdtask/ctrl/DefaultTaskAction;", "store", "Lcom/baidu/bdtask/framework/redux/Store;", "<init>", "(Lcom/baidu/bdtask/framework/redux/Store;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d<com.baidu.bdtask.ctrl.b, pq> a;

    public a(d<com.baidu.bdtask.ctrl.b, pq> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dVar;
    }

    public final TaskInfo b(SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, subTaskState)) == null) {
            return subTaskState.getTaskInfo();
        }
        return (TaskInfo) invokeL.objValue;
    }

    public final TaskGuideData d(SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, subTaskState)) == null) {
            return b(subTaskState).getTaskGuide();
        }
        return (TaskGuideData) invokeL.objValue;
    }

    public final TaskStatus f(SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, subTaskState)) == null) {
            return subTaskState.getTaskStatus();
        }
        return (TaskStatus) invokeL.objValue;
    }

    public final dr g(SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, subTaskState)) == null) {
            return subTaskState.getCurStatusRuntime().getCurAction();
        }
        return (dr) invokeL.objValue;
    }

    @CallSuper
    public void j(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, subTaskState) == null) {
            xu.c.m(subTaskState);
        }
    }

    @CallSuper
    public void k(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, subTaskState) == null) {
            xu.c.n(subTaskState);
        }
    }

    @CallSuper
    public void l(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, subTaskState) == null) {
            xu.c.o(subTaskState);
            a().h(b(subTaskState));
            a().l(b(subTaskState));
            e();
        }
    }

    public final com.baidu.bdtask.ctrl.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.a();
        }
        return (com.baidu.bdtask.ctrl.b) invokeV.objValue;
    }

    public final void c(String str, String str2) {
        TaskInfo s;
        TaskInfo deepCopy;
        BDPTask t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && (s = a().s(str)) != null && (deepCopy = s.deepCopy()) != null && (t = BDPTask.m.t()) != null) {
            t.j0(deepCopy, new mq(deepCopy.getSingleKey(), null, null, str2, null, null, 54, null));
        }
    }

    public final void e() {
        final SubTaskState j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (j = a().j()) != null) {
            DebugTrace.a.c(new Function0<String>(j) { // from class: com.baidu.bdtask.strategy.impl.lifecycle.BaseLifecycleStrategy$activeNextTask$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SubTaskState $taskState;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {j};
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
                    this.$taskState = j;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return "recover task: " + this.$taskState.getTaskInfo().toJson();
                    }
                    return (String) invokeV.objValue;
                }
            });
            BDPTask t = BDPTask.m.t();
            if (t != null) {
                t.g0(j.getTaskInfo());
            }
            DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.strategy.impl.lifecycle.BaseLifecycleStrategy$activeNextTask$2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a this$0;

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
                        StringBuilder sb = new StringBuilder();
                        sb.append("cur active:");
                        JSONObject jSONObject = null;
                        SubTaskState c = com.baidu.bdtask.ctrl.b.c(this.this$0.a(), null, 1, null);
                        if (c != null) {
                            jSONObject = c.toJson();
                        }
                        sb.append(jSONObject);
                        return sb.toString();
                    }
                    return (String) invokeV.objValue;
                }
            });
        }
    }

    @CallSuper
    public void h(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, subTaskState) == null) {
            if (!d(subTaskState).isEmpty()) {
                com.baidu.bdtask.component.a.c(com.baidu.bdtask.component.a.b.a(), d(subTaskState).getUiType(), d(subTaskState).getUi(), subTaskState.getTaskInfo(), subTaskState.getTaskStatus(), null, 16, null);
            }
            xu.c.i(subTaskState);
        }
    }

    @CallSuper
    public void i(SubTaskState subTaskState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, subTaskState) == null) {
            if (f(subTaskState).isCompleted()) {
                c(b(subTaskState).getActionId(), f(subTaskState).getTaskStatusRuntime().getCurDuplicateId());
            }
            xu.c.k(subTaskState);
        }
    }

    public final boolean m(final SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, subTaskState)) == null) {
            if (f(subTaskState).isDuplicated()) {
                DebugTrace.a.c(BaseLifecycleStrategy$finishAborted$1.INSTANCE);
                f(subTaskState).reset2RunningStatus();
                return true;
            }
            dr g = g(subTaskState);
            if ((g instanceof lq) || (g instanceof kq)) {
                DebugTrace.a.c(new Function0<String>(this, subTaskState) { // from class: com.baidu.bdtask.strategy.impl.lifecycle.BaseLifecycleStrategy$finishAborted$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SubTaskState $subState;
                    public final /* synthetic */ a this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, subTaskState};
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
                        this.$subState = subTaskState;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        String str;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("abort by ");
                            dr g2 = this.this$0.g(this.$subState);
                            if (g2 != null) {
                                str = g2.e();
                            } else {
                                str = null;
                            }
                            sb.append(str);
                            return sb.toString();
                        }
                        return (String) invokeV.objValue;
                    }
                });
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean o(final SubTaskState subTaskState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, subTaskState)) == null) {
            TaskResponseData response = b(subTaskState).getResponse();
            if (response.isEmpty()) {
                return true;
            }
            dr g = g(subTaskState);
            if (g instanceof lq) {
                return true;
            }
            if ((g instanceof kq) && !response.isLayer()) {
                DebugTrace.a.c(new Function0<String>(this, subTaskState) { // from class: com.baidu.bdtask.strategy.impl.lifecycle.BaseLifecycleStrategy$finishGuideShowAborted$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SubTaskState $subState;
                    public final /* synthetic */ a this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, subTaskState};
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
                        this.$subState = subTaskState;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        String str;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("showFinishGuide abort by ");
                            dr g2 = this.this$0.g(this.$subState);
                            if (g2 != null) {
                                str = g2.e();
                            } else {
                                str = null;
                            }
                            sb.append(str);
                            return sb.toString();
                        }
                        return (String) invokeV.objValue;
                    }
                });
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void n(SubTaskState subTaskState) {
        dt dtVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, subTaskState) == null) {
            TaskResponseData response = b(subTaskState).getResponse();
            if (response.isEmpty() || o(subTaskState)) {
                return;
            }
            com.baidu.bdtask.component.a a = com.baidu.bdtask.component.a.b.a();
            int uiType = response.getUiType();
            TaskUIData ui = response.getUi();
            TaskInfo taskInfo = subTaskState.getTaskInfo();
            TaskStatus taskStatus = subTaskState.getTaskStatus();
            qq interceptor = subTaskState.getInterceptor();
            if (interceptor != null) {
                dtVar = interceptor.a();
            } else {
                dtVar = null;
            }
            a.b(uiType, ui, taskInfo, taskStatus, dtVar);
        }
    }
}
