package com.baidu.bdtask.ctrl.actions.exitstrategy;

import c.a.j.h.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.SubTaskState;
import com.baidu.bdtask.framework.utils.DebugTrace;
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
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001aH\u00122\u00120\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00010\u000124\u0010\t\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0011`\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "Lkotlin/ParameterName;", "name", "action", "", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", "dispatch", "<anonymous parameter 0>", "getState", "Lkotlin/Function0;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1 extends Lambda implements Function2<Function1<? super a, ? extends Unit>, Function0<? extends com.baidu.bdtask.ctrl.b>, Function1<? super Function1<? super a, ? extends Unit>, ? extends Function1<? super a, ? extends Unit>>> {
    public static /* synthetic */ Interceptable $ic;
    public static final TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000124\u0010\u0004\u001a0\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00030\u0001j\u0011`\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "", "next", "Lkotlin/ParameterName;", "name", "action", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", "dispatch", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.ctrl.actions.exitstrategy.TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<Function1<? super a, ? extends Unit>, Function1<? super a, ? extends Unit>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 $getState;

        @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "action", "Lcom/baidu/bdtask/framework/redux/Action;", "invoke"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
        /* renamed from: com.baidu.bdtask.ctrl.actions.exitstrategy.TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes10.dex */
        public static final class C17791 extends Lambda implements Function1<a, Unit> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Function1 $next;
            public final /* synthetic */ AnonymousClass1 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C17791(AnonymousClass1 anonymousClass1, Function1 function1) {
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
            public /* bridge */ /* synthetic */ Unit invoke(a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(a aVar) {
                SubTaskState k;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (((c.a.j.f.c.e.a) (!(aVar instanceof c.a.j.f.c.e.a) ? null : aVar)) != null) {
                        com.baidu.bdtask.ctrl.b bVar = (com.baidu.bdtask.ctrl.b) this.this$0.$getState.invoke();
                        if (bVar == null || (k = bVar.k(((c.a.j.f.c.e.a) aVar).f())) == null) {
                            return;
                        }
                        if (k.getTaskStatus().isUnRegistered()) {
                            DebugTrace.d(DebugTrace.a, "task is in unregistered , do't need to clean no click times", "state", null, 4, null);
                            return;
                        } else {
                            this.$next.invoke(aVar);
                            return;
                        }
                    }
                    Unit unit = (Unit) this.$next.invoke(aVar);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function0};
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
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1)) == null) ? new C17791(this, function1) : (Function1) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1150442022, "Lcom/baidu/bdtask/ctrl/actions/exitstrategy/TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1150442022, "Lcom/baidu/bdtask/ctrl/actions/exitstrategy/TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1;");
                return;
            }
        }
        INSTANCE = new TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1() {
        super(2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, function1, function0)) == null) ? new AnonymousClass1(function0) : (Function1) invokeLL.objValue;
    }
}
