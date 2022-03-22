package com.baidu.mapapi.search.route;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BikingRoutePlanOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PlanNode mFrom;
    public int mRidingType;
    public PlanNode mTo;

    public BikingRoutePlanOption() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrom = null;
        this.mTo = null;
        this.mRidingType = 0;
    }

    public BikingRoutePlanOption from(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, planNode)) == null) {
            this.mFrom = planNode;
            return this;
        }
        return (BikingRoutePlanOption) invokeL.objValue;
    }

    public BikingRoutePlanOption ridingType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.mRidingType = i;
            return this;
        }
        return (BikingRoutePlanOption) invokeI.objValue;
    }

    public BikingRoutePlanOption to(PlanNode planNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, planNode)) == null) {
            this.mTo = planNode;
            return this;
        }
        return (BikingRoutePlanOption) invokeL.objValue;
    }
}
