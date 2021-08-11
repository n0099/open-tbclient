package com.baidu.platform.core.d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g(IndoorRoutePlanOption indoorRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {indoorRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(indoorRoutePlanOption);
    }

    private void a(IndoorRoutePlanOption indoorRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, indoorRoutePlanOption) == null) {
            this.f44083a.a("qt", "indoornavi");
            this.f44083a.a("rp_format", "json");
            this.f44083a.a("version", "1");
            GeoPoint ll2mc = CoordUtil.ll2mc(indoorRoutePlanOption.mFrom.getLocation());
            if (ll2mc != null) {
                String format = String.format("%f,%f", Double.valueOf(ll2mc.getLongitudeE6()), Double.valueOf(ll2mc.getLatitudeE6()));
                this.f44083a.a(IAdRequestParam.SN, (format + "|" + indoorRoutePlanOption.mFrom.getFloor()).replaceAll(" ", ""));
            }
            GeoPoint ll2mc2 = CoordUtil.ll2mc(indoorRoutePlanOption.mTo.getLocation());
            if (ll2mc2 != null) {
                String format2 = String.format("%f,%f", Double.valueOf(ll2mc2.getLongitudeE6()), Double.valueOf(ll2mc2.getLatitudeE6()));
                this.f44083a.a(com.baidu.fsg.base.statistics.f.f39281a, (format2 + "|" + indoorRoutePlanOption.mTo.getFloor()).replaceAll(" ", ""));
            }
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.l() : (String) invokeL.objValue;
    }
}
