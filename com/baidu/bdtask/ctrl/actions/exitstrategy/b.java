package com.baidu.bdtask.ctrl.actions.exitstrategy;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.sq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000B\u0007¢\u0006\u0004\b\u0010\u0010\u0011Jæ\u0001\u0010\u000e\u001aÚ\u0001\u0012A\u0012?\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0011`\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012l\u0012j\u0012A\u0012?\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0011`\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012#\u0012!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\b0\u00020\u0001j\b\u0012\u0004\u0012\u00020\u000b`\r¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/bdtask/ctrl/actions/exitstrategy/TaskNoClickTimesCleanMiddleWare;", "Lkotlin/Function2;", "Lkotlin/Function1;", "Lcom/baidu/bdtask/framework/redux/Action;", "Lkotlin/ParameterName;", "name", "action", "", "Lcom/baidu/bdtask/framework/redux/DispatchFunction;", "dispatch", "Lkotlin/Function0;", "Lcom/baidu/bdtask/ctrl/BDPTaskState;", "getState", "Lcom/baidu/bdtask/framework/redux/Middleware;", "taskNoClickTimesCleanMiddleWare", "()Lkotlin/Function2;", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public final Function2<Function1<? super sq, Unit>, Function0<com.baidu.bdtask.ctrl.b>, Function1<Function1<? super sq, Unit>, Function1<sq, Unit>>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TaskNoClickTimesCleanMiddleWare$taskNoClickTimesCleanMiddleWare$1.INSTANCE : (Function2) invokeV.objValue;
    }
}
