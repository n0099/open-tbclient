package com.baidu.bdtask.ctrl.actions.finishreq;

import android.text.TextUtils;
import c.a.j.f.g.c;
import c.a.j.h.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.tachikoma.core.event.base.TKBaseEvent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aH\u00122\u00120\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00010\u000124\u0010\t\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "Lkotlin/ParameterName;", "name", "action", "", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", TKBaseEvent.TK_DISPATCH_EVENT_NAME, "<anonymous parameter 0>", "getState", "Lkotlin/Function0;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class TaskFinishReqMiddleware$taskFinishMiddleWare$1 extends Lambda implements Function2<Function1<? super a, ? extends Unit>, Function0<? extends com.baidu.bdtask.ctrl.b>, Function1<? super Function1<? super a, ? extends Unit>, ? extends Function1<? super a, ? extends Unit>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000124\u0010\u0004\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0001j\u0011`\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "", "next", "Lkotlin/ParameterName;", "name", "action", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", TKBaseEvent.TK_DISPATCH_EVENT_NAME, "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware$taskFinishMiddleWare$1$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Function1<? super a, ? extends Unit>, Function1<? super a, ? extends Unit>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 $getState;
        public final /* synthetic */ TaskFinishReqMiddleware$taskFinishMiddleWare$1 this$0;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "action", "Lcom/baidu/bdtask/framework/redux/Action;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
        /* renamed from: com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C17631 extends Lambda implements Function1<c.a.j.h.a.a, Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Function1 $next;
            public final /* synthetic */ AnonymousClass1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C17631(AnonymousClass1 anonymousClass1, Function1 function1) {
                super(1);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {anonymousClass1, function1};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = anonymousClass1;
                this.$next = function1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c.a.j.h.a.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(c.a.j.h.a.a aVar) {
                Set set;
                Set set2;
                com.baidu.bdtask.ctrl.repo.a aVar2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (((c.a.j.f.c.f.a) (!(aVar instanceof c.a.j.f.c.f.a) ? null : aVar)) != null) {
                        com.baidu.bdtask.ctrl.b bVar = (com.baidu.bdtask.ctrl.b) this.this$0.$getState.invoke();
                        if (bVar != null) {
                            c.a.j.f.c.f.a aVar3 = (c.a.j.f.c.f.a) aVar;
                            SubTaskState k2 = bVar.k(aVar3.f());
                            if (k2 != null) {
                                TaskInfo taskInfo = k2.getTaskInfo();
                                TaskStatus taskStatus = k2.getTaskStatus();
                                if (taskStatus.isCompleted()) {
                                    set = this.this$0.this$0.this$0.f34038b;
                                    if (set.contains(taskInfo.getSingleKey())) {
                                        return;
                                    }
                                    set2 = this.this$0.this$0.this$0.f34038b;
                                    set2.add(taskInfo.getSingleKey());
                                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                    objectRef.element = null;
                                    aVar2 = this.this$0.this$0.this$0.a;
                                    aVar2.b(taskInfo, taskStatus, new a(taskInfo, objectRef, this, aVar));
                                    return;
                                }
                                Function1 function1 = this.$next;
                                aVar3.b(302);
                                aVar3.c("task has been not completed");
                                function1.invoke(aVar);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Unit unit = (Unit) this.$next.invoke(aVar);
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"com/baidu/bdtask/ctrl/actions/finishreq/TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$1$2", "Lc/a/j/f/g/b;", "", "errmsg", "", EnterDxmPayServiceAction.SERVICE_STATUS_CODE, "", "onFail", "(Ljava/lang/String;I)V", "Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;", "parser", "onResponseParsed", "(Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;)V", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "data", "onSucceed", "(Lcom/baidu/bdtask/model/response/TaskResponseData;)V", "<init>", "(Lcom/baidu/bdtask/ctrl/actions/finishreq/TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$1;Lcom/baidu/bdtask/model/info/TaskInfo;Lkotlin/jvm/internal/Ref$ObjectRef;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
            /* renamed from: com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$a */
            /* loaded from: classes10.dex */
            public static final class a implements c.a.j.f.g.b {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Ref.ObjectRef f34035b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ C17631 f34036c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ c.a.j.h.a.a f34037d;

                public a(TaskInfo taskInfo, Ref.ObjectRef objectRef, C17631 c17631, c.a.j.h.a.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {taskInfo, objectRef, c17631, aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = taskInfo;
                    this.f34035b = objectRef;
                    this.f34036c = c17631;
                    this.f34037d = aVar;
                }

                @Override // c.a.j.f.g.b
                public void a(TaskResponseData taskResponseData) {
                    Set set;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                        set = this.f34036c.this$0.this$0.this$0.f34038b;
                        set.remove(this.a.getSingleKey());
                        Function1 function1 = this.f34036c.$next;
                        c.a.j.h.a.a aVar = this.f34037d;
                        c.a.j.f.c.f.a aVar2 = (c.a.j.f.c.f.a) aVar;
                        aVar2.h(taskResponseData.deepCopy());
                        TaskInfo taskInfo = (TaskInfo) this.f34035b.element;
                        aVar2.g(taskInfo != null ? taskInfo.deepCopy() : null);
                        function1.invoke(aVar);
                    }
                }

                /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.bdtask.model.info.TaskInfo, T] */
                @Override // c.a.j.f.g.b
                public void b(c cVar) {
                    TaskResponseData d2;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) && cVar.a() && (d2 = cVar.d()) != null) {
                        NextActive nextActive = d2.getNextActive();
                        if (d2.isEmpty() || TextUtils.isEmpty(nextActive.getTaskInfo())) {
                            return;
                        }
                        this.f34035b.element = new c.a.j.i.b(nextActive.getTaskInfo()).a();
                        DebugTrace.a.c(new TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$$special$$inlined$let$lambda$1$1(this));
                    }
                }

                @Override // c.a.j.f.g.b
                public void a(String str, int i2) {
                    Set set;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                        set = this.f34036c.this$0.this$0.this$0.f34038b;
                        set.remove(this.a.getSingleKey());
                        Function1 function1 = this.f34036c.$next;
                        c.a.j.h.a.a aVar = this.f34037d;
                        c.a.j.f.c.f.a aVar2 = (c.a.j.f.c.f.a) aVar;
                        aVar2.b(i2);
                        aVar2.c(str);
                        function1.invoke(aVar);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TaskFinishReqMiddleware$taskFinishMiddleWare$1 taskFinishReqMiddleware$taskFinishMiddleWare$1, Function0 function0) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskFinishReqMiddleware$taskFinishMiddleWare$1, function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = taskFinishReqMiddleware$taskFinishMiddleWare$1;
            this.$getState = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Function1<? super a, ? extends Unit> invoke(Function1<? super a, ? extends Unit> function1) {
            return invoke2((Function1<? super a, Unit>) function1);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Function1<a, Unit> invoke2(Function1<? super a, Unit> function1) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1)) == null) ? new C17631(this, function1) : (Function1) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskFinishReqMiddleware$taskFinishMiddleWare$1(b bVar) {
        super(2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Function1<? super Function1<? super a, ? extends Unit>, ? extends Function1<? super a, ? extends Unit>> invoke(Function1<? super a, ? extends Unit> function1, Function0<? extends com.baidu.bdtask.ctrl.b> function0) {
        return invoke2((Function1<? super a, Unit>) function1, (Function0<com.baidu.bdtask.ctrl.b>) function0);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Function1<Function1<? super a, Unit>, Function1<a, Unit>> invoke2(Function1<? super a, Unit> function1, Function0<com.baidu.bdtask.ctrl.b> function0) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1, function0)) == null) ? new AnonymousClass1(this, function0) : (Function1) invokeLL.objValue;
    }
}
