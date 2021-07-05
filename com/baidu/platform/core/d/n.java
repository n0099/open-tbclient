package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class n extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n(TransitRoutePlanOption transitRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transitRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, transitRoutePlanOption) == null) {
            this.f9391a.a("qt", "bus");
            com.baidu.platform.util.a aVar = this.f9391a;
            aVar.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
            this.f9391a.a("ie", "utf-8");
            this.f9391a.a("lrn", "20");
            this.f9391a.a("version", "3");
            this.f9391a.a("rp_format", "json");
            this.f9391a.a("rp_filter", "mobile");
            this.f9391a.a("ic_info", "2");
            this.f9391a.a("exptype", "depall");
            this.f9391a.a(IAdRequestParam.SN, a(transitRoutePlanOption.mFrom));
            this.f9391a.a("en", a(transitRoutePlanOption.mTo));
            String str = transitRoutePlanOption.mCityName;
            if (str != null) {
                this.f9391a.a("c", str);
            }
            if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
                this.f9391a.a("f", "[0,2,4,7,5,8,9,10,11]");
            }
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.h() : (String) invokeL.objValue;
    }
}
