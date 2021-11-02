package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p(WalkingRoutePlanOption walkingRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {walkingRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, walkingRoutePlanOption) == null) {
            this.f42041a.a("qt", "walk2");
            this.f42041a.a("sn", a(walkingRoutePlanOption.mFrom));
            this.f42041a.a(com.baidu.fsg.base.statistics.h.f37503a, a(walkingRoutePlanOption.mTo));
            PlanNode planNode = walkingRoutePlanOption.mFrom;
            if (planNode != null) {
                this.f42041a.a("sc", planNode.getCity());
            }
            PlanNode planNode2 = walkingRoutePlanOption.mTo;
            if (planNode2 != null) {
                this.f42041a.a("ec", planNode2.getCity());
            }
            this.f42041a.a("ie", "utf-8");
            this.f42041a.a("lrn", "20");
            this.f42041a.a("version", "3");
            this.f42041a.a("rp_format", "json");
            this.f42041a.a("rp_filter", "mobile");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.k() : (String) invokeL.objValue;
    }
}
