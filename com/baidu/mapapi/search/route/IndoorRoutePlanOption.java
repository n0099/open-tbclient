package com.baidu.mapapi.search.route;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class IndoorRoutePlanOption {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IndoorPlanNode mFrom;
    public IndoorPlanNode mTo;

    public IndoorRoutePlanOption() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrom = null;
        this.mTo = null;
    }

    public IndoorRoutePlanOption from(IndoorPlanNode indoorPlanNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, indoorPlanNode)) == null) {
            this.mFrom = indoorPlanNode;
            return this;
        }
        return (IndoorRoutePlanOption) invokeL.objValue;
    }

    public IndoorRoutePlanOption to(IndoorPlanNode indoorPlanNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, indoorPlanNode)) == null) {
            this.mTo = indoorPlanNode;
            return this;
        }
        return (IndoorRoutePlanOption) invokeL.objValue;
    }
}
