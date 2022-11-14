package com.baidu.bdtask.ctrl.actions.dotask.click;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.gr;
import com.baidu.tieba.kq;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aH\u00122\u00120\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00010\u000124\u0010\t\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "Lkotlin/ParameterName;", "name", "action", "", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", StatConstants.VALUE_TYPE_DISPATCH, "<anonymous parameter 0>", "getState", "Lkotlin/Function0;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TaskExecClickMiddleware$taskExecClickMiddleWare$1 extends Lambda implements Function2<Function1<? super gr, ? extends Unit>, Function0<? extends com.baidu.bdtask.ctrl.b>, Function1<? super Function1<? super gr, ? extends Unit>, ? extends Function1<? super gr, ? extends Unit>>> {
    public static /* synthetic */ Interceptable $ic;
    public static final TaskExecClickMiddleware$taskExecClickMiddleWare$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(652549236, "Lcom/baidu/bdtask/ctrl/actions/dotask/click/TaskExecClickMiddleware$taskExecClickMiddleWare$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(652549236, "Lcom/baidu/bdtask/ctrl/actions/dotask/click/TaskExecClickMiddleware$taskExecClickMiddleWare$1;");
                return;
            }
        }
        INSTANCE = new TaskExecClickMiddleware$taskExecClickMiddleWare$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskExecClickMiddleware$taskExecClickMiddleWare$1() {
        super(2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000124\u0010\u0004\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0001j\u0011`\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "Lkotlin/ParameterName;", "name", "action", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", StatConstants.VALUE_TYPE_DISPATCH, "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.ctrl.actions.dotask.click.TaskExecClickMiddleware$taskExecClickMiddleWare$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Function1<? super gr, ? extends Unit>, Function1<? super gr, ? extends Unit>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 $getState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function0};
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
            this.$getState = function0;
        }

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "action", "Lcom/baidu/bdtask/framework/redux/Action;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
        /* renamed from: com.baidu.bdtask.ctrl.actions.dotask.click.TaskExecClickMiddleware$taskExecClickMiddleWare$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00651 extends Lambda implements Function1<gr, Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Function1 $next;
            public final /* synthetic */ AnonymousClass1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00651(AnonymousClass1 anonymousClass1, Function1 function1) {
                super(1);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {anonymousClass1, function1};
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
                this.this$0 = anonymousClass1;
                this.$next = function1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(gr grVar) {
                invoke2(grVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(gr grVar) {
                gr grVar2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, grVar) == null) {
                    if (!(grVar instanceof kq)) {
                        grVar2 = null;
                    } else {
                        grVar2 = grVar;
                    }
                    if (((kq) grVar2) != null) {
                        com.baidu.bdtask.ctrl.b bVar = (com.baidu.bdtask.ctrl.b) this.this$0.$getState.invoke();
                        if (bVar != null) {
                            kq kqVar = (kq) grVar;
                            SubTaskState k = bVar.k(kqVar.f());
                            if (k != null) {
                                if (!k.getTaskStatus().isEnable()) {
                                    DebugTrace.d(DebugTrace.a, "task is not enable", "state", null, 4, null);
                                    Function1 function1 = this.$next;
                                    kqVar.b(305);
                                    kqVar.c("task is not enable , because of unregistered or keep in silence");
                                    function1.invoke(grVar);
                                    return;
                                }
                                this.$next.invoke(grVar);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Unit unit = (Unit) this.$next.invoke(grVar);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Function1<? super gr, ? extends Unit> invoke(Function1<? super gr, ? extends Unit> function1) {
            return invoke2((Function1<? super gr, Unit>) function1);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Function1<gr, Unit> invoke2(Function1<? super gr, Unit> function1) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1)) == null) {
                return new C00651(this, function1);
            }
            return (Function1) invokeL.objValue;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Function1<? super Function1<? super gr, ? extends Unit>, ? extends Function1<? super gr, ? extends Unit>> invoke(Function1<? super gr, ? extends Unit> function1, Function0<? extends com.baidu.bdtask.ctrl.b> function0) {
        return invoke2((Function1<? super gr, Unit>) function1, (Function0<com.baidu.bdtask.ctrl.b>) function0);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Function1<Function1<? super gr, Unit>, Function1<gr, Unit>> invoke2(Function1<? super gr, Unit> function1, Function0<com.baidu.bdtask.ctrl.b> function0) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1, function0)) == null) {
            return new AnonymousClass1(function0);
        }
        return (Function1) invokeLL.objValue;
    }
}
