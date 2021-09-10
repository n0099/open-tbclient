package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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
            this.f44305a.a("qt", "walk2");
            this.f44305a.a(IAdRequestParam.SN, a(walkingRoutePlanOption.mFrom));
            this.f44305a.a(com.baidu.fsg.base.statistics.f.f39499a, a(walkingRoutePlanOption.mTo));
            PlanNode planNode = walkingRoutePlanOption.mFrom;
            if (planNode != null) {
                this.f44305a.a("sc", planNode.getCity());
            }
            PlanNode planNode2 = walkingRoutePlanOption.mTo;
            if (planNode2 != null) {
                this.f44305a.a("ec", planNode2.getCity());
            }
            this.f44305a.a("ie", "utf-8");
            this.f44305a.a("lrn", "20");
            this.f44305a.a("version", "3");
            this.f44305a.a("rp_format", "json");
            this.f44305a.a("rp_filter", "mobile");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.k() : (String) invokeL.objValue;
    }
}
