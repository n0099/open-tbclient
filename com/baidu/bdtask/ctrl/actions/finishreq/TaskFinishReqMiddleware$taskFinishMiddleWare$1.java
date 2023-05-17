package com.baidu.bdtask.ctrl.actions.finishreq;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware$taskFinishMiddleWare$1;
import com.baidu.bdtask.ctrl.model.TaskStatus;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.bdtask.model.response.NextActive;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.fr;
import com.baidu.tieba.oq;
import com.baidu.tieba.qt;
import com.baidu.tieba.vq;
import com.baidu.tieba.wq;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aH\u00122\u00120\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00010\u000124\u0010\t\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "Lkotlin/ParameterName;", "name", "action", "", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", StatConstants.VALUE_TYPE_DISPATCH, "<anonymous parameter 0>", "getState", "Lkotlin/Function0;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskFinishReqMiddleware$taskFinishMiddleWare$1 extends Lambda implements Function2<Function1<? super fr, ? extends Unit>, Function0<? extends com.baidu.bdtask.ctrl.b>, Function1<? super Function1<? super fr, ? extends Unit>, ? extends Function1<? super fr, ? extends Unit>>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskFinishReqMiddleware$taskFinishMiddleWare$1(b bVar) {
        super(2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.this$0 = bVar;
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000124\u0010\u0004\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0001j\u0011`\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "Lkotlin/ParameterName;", "name", "action", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", StatConstants.VALUE_TYPE_DISPATCH, "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware$taskFinishMiddleWare$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Function1<? super fr, ? extends Unit>, Function1<? super fr, ? extends Unit>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 $getState;
        public final /* synthetic */ TaskFinishReqMiddleware$taskFinishMiddleWare$1 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TaskFinishReqMiddleware$taskFinishMiddleWare$1 taskFinishReqMiddleware$taskFinishMiddleWare$1, Function0 function0) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskFinishReqMiddleware$taskFinishMiddleWare$1, function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public /* bridge */ /* synthetic */ Function1<? super fr, ? extends Unit> invoke(Function1<? super fr, ? extends Unit> function1) {
            return invoke2((Function1<? super fr, Unit>) function1);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Function1<fr, Unit> invoke2(Function1<? super fr, Unit> function1) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1)) == null) {
                return new Function1<fr, Unit>(this, function1) { // from class: com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware.taskFinishMiddleWare.1.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Function1 $next;
                    public final /* synthetic */ AnonymousClass1 this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, function1};
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
                        this.$next = function1;
                    }

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"com/baidu/bdtask/ctrl/actions/finishreq/TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$1$2", "Lcom/baidu/tieba/vq;", "", "errmsg", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "onFail", "(Ljava/lang/String;I)V", "Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;", "parser", "onResponseParsed", "(Lcom/baidu/bdtask/ctrl/repo/TaskResponseParser;)V", "Lcom/baidu/bdtask/model/response/TaskResponseData;", "data", "onSucceed", "(Lcom/baidu/bdtask/model/response/TaskResponseData;)V", "<init>", "(Lcom/baidu/bdtask/ctrl/actions/finishreq/TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$1;Lcom/baidu/bdtask/model/info/TaskInfo;Lkotlin/jvm/internal/Ref$ObjectRef;)V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
                    /* renamed from: com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$a */
                    /* loaded from: classes.dex */
                    public static final class a implements vq {
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ TaskInfo a;
                        public final /* synthetic */ Ref.ObjectRef b;
                        public final /* synthetic */ C00701 c;
                        public final /* synthetic */ fr d;

                        public a(TaskInfo taskInfo, Ref.ObjectRef objectRef, C00701 c00701, fr frVar) {
                            Interceptable interceptable = $ic;
                            if (interceptable != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {taskInfo, objectRef, c00701, frVar};
                                interceptable.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = taskInfo;
                            this.b = objectRef;
                            this.c = c00701;
                            this.d = frVar;
                        }

                        @Override // com.baidu.tieba.vq
                        public void a(TaskResponseData taskResponseData) {
                            Set set;
                            TaskInfo taskInfo;
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeL(1048576, this, taskResponseData) == null) {
                                set = this.c.this$0.this$0.this$0.b;
                                set.remove(this.a.getSingleKey());
                                Function1 function1 = this.c.$next;
                                fr frVar = this.d;
                                oq oqVar = (oq) frVar;
                                oqVar.h(taskResponseData.deepCopy());
                                TaskInfo taskInfo2 = (TaskInfo) this.b.element;
                                if (taskInfo2 != null) {
                                    taskInfo = taskInfo2.deepCopy();
                                } else {
                                    taskInfo = null;
                                }
                                oqVar.g(taskInfo);
                                function1.invoke(frVar);
                            }
                        }

                        /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.bdtask.model.info.TaskInfo, T] */
                        @Override // com.baidu.tieba.vq
                        public void b(wq wqVar) {
                            TaskResponseData d;
                            Interceptable interceptable = $ic;
                            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wqVar) == null) && wqVar.a() && (d = wqVar.d()) != null) {
                                NextActive nextActive = d.getNextActive();
                                if (!d.isEmpty() && !TextUtils.isEmpty(nextActive.getTaskInfo())) {
                                    this.b.element = new qt(nextActive.getTaskInfo()).a();
                                    DebugTrace.a.c(new Function0<String>(this) { // from class: com.baidu.bdtask.ctrl.actions.finishreq.TaskFinishReqMiddleware$taskFinishMiddleWare$1$1$1$$special$$inlined$let$lambda$1$1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ TaskFinishReqMiddleware$taskFinishMiddleWare$1.AnonymousClass1.C00701.a this$0;

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
                                            JSONObject jSONObject;
                                            Interceptable interceptable2 = $ic;
                                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("get need merged taskInfo:");
                                                TaskInfo taskInfo = (TaskInfo) this.this$0.b.element;
                                                if (taskInfo != null) {
                                                    jSONObject = taskInfo.toJson();
                                                } else {
                                                    jSONObject = null;
                                                }
                                                sb.append(jSONObject);
                                                return sb.toString();
                                            }
                                            return (String) invokeV.objValue;
                                        }
                                    });
                                }
                            }
                        }

                        @Override // com.baidu.tieba.vq
                        public void c(String str, int i) {
                            Set set;
                            Interceptable interceptable = $ic;
                            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                                set = this.c.this$0.this$0.this$0.b;
                                set.remove(this.a.getSingleKey());
                                Function1 function1 = this.c.$next;
                                fr frVar = this.d;
                                oq oqVar = (oq) frVar;
                                oqVar.b(i);
                                oqVar.c(str);
                                function1.invoke(frVar);
                            }
                        }
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(fr frVar) {
                        invoke2(frVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(fr frVar) {
                        fr frVar2;
                        Set set;
                        Set set2;
                        com.baidu.bdtask.ctrl.repo.a aVar;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frVar) == null) {
                            if (!(frVar instanceof oq)) {
                                frVar2 = null;
                            } else {
                                frVar2 = frVar;
                            }
                            if (((oq) frVar2) != null) {
                                com.baidu.bdtask.ctrl.b bVar = (com.baidu.bdtask.ctrl.b) this.this$0.$getState.invoke();
                                if (bVar != null) {
                                    oq oqVar = (oq) frVar;
                                    SubTaskState k = bVar.k(oqVar.f());
                                    if (k != null) {
                                        TaskInfo taskInfo = k.getTaskInfo();
                                        TaskStatus taskStatus = k.getTaskStatus();
                                        if (taskStatus.isCompleted()) {
                                            set = this.this$0.this$0.this$0.b;
                                            if (!set.contains(taskInfo.getSingleKey())) {
                                                set2 = this.this$0.this$0.this$0.b;
                                                set2.add(taskInfo.getSingleKey());
                                                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                                objectRef.element = null;
                                                aVar = this.this$0.this$0.this$0.a;
                                                aVar.b(taskInfo, taskStatus, new a(taskInfo, objectRef, this, frVar));
                                                return;
                                            }
                                            return;
                                        }
                                        Function1 function12 = this.$next;
                                        oqVar.b(302);
                                        oqVar.c("task has been not completed");
                                        function12.invoke(frVar);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            Unit unit = (Unit) this.$next.invoke(frVar);
                        }
                    }
                };
            }
            return (Function1) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Function1<? super Function1<? super fr, ? extends Unit>, ? extends Function1<? super fr, ? extends Unit>> invoke(Function1<? super fr, ? extends Unit> function1, Function0<? extends com.baidu.bdtask.ctrl.b> function0) {
        return invoke2((Function1<? super fr, Unit>) function1, (Function0<com.baidu.bdtask.ctrl.b>) function0);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Function1<Function1<? super fr, Unit>, Function1<fr, Unit>> invoke2(Function1<? super fr, Unit> function1, Function0<com.baidu.bdtask.ctrl.b> function0) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1, function0)) == null) {
            return new AnonymousClass1(this, function0);
        }
        return (Function1) invokeLL.objValue;
    }
}
