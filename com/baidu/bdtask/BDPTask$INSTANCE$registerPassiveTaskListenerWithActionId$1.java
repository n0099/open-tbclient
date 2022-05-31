package com.baidu.bdtask;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 1, 9}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class BDPTask$INSTANCE$registerPassiveTaskListenerWithActionId$1 extends Lambda implements Function0<Unit> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ String $actionId;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ yo $taskCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDPTask$INSTANCE$registerPassiveTaskListenerWithActionId$1(String str, yo yoVar) {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, yoVar};
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
        this.$actionId = str;
        this.$taskCallback = yoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BDPTask u = BDPTask.m.u();
            if (u != null) {
                u.R(this.$actionId, this.$taskCallback);
                return Unit.INSTANCE;
            }
            return null;
        }
        return (Unit) invokeV.objValue;
    }
}
