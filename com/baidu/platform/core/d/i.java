package com.baidu.platform.core.d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
/* loaded from: classes5.dex */
public class i extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {massTransitRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(massTransitRoutePlanOption);
    }

    private void a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, massTransitRoutePlanOption) == null) {
            LatLng location = massTransitRoutePlanOption.mFrom.getLocation();
            if (location != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location = CoordTrans.gcjToBaidu(location);
                }
                com.baidu.platform.util.a aVar = this.f44190a;
                aVar.a(FilterValue.DEFAULT_FILTER_VALUE, location.latitude + "," + location.longitude);
            } else {
                this.f44190a.a(FilterValue.DEFAULT_FILTER_VALUE, massTransitRoutePlanOption.mFrom.getName());
            }
            if (massTransitRoutePlanOption.mFrom.getCity() != null) {
                this.f44190a.a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
            }
            LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
            if (location2 != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location2 = CoordTrans.gcjToBaidu(location2);
                }
                com.baidu.platform.util.a aVar2 = this.f44190a;
                aVar2.a("destination", location2.latitude + "," + location2.longitude);
            } else {
                this.f44190a.a("destination", massTransitRoutePlanOption.mTo.getName());
            }
            if (massTransitRoutePlanOption.mTo.getCity() != null) {
                this.f44190a.a("destination_region", massTransitRoutePlanOption.mTo.getCity());
            }
            com.baidu.platform.util.a aVar3 = this.f44190a;
            aVar3.a("tactics_incity", massTransitRoutePlanOption.mTacticsIncity.getInt() + "");
            com.baidu.platform.util.a aVar4 = this.f44190a;
            aVar4.a("tactics_intercity", massTransitRoutePlanOption.mTacticsIntercity.getInt() + "");
            com.baidu.platform.util.a aVar5 = this.f44190a;
            aVar5.a("trans_type_intercity", massTransitRoutePlanOption.mTransTypeIntercity.getInt() + "");
            com.baidu.platform.util.a aVar6 = this.f44190a;
            aVar6.a("page_index", massTransitRoutePlanOption.mPageIndex + "");
            com.baidu.platform.util.a aVar7 = this.f44190a;
            aVar7.a("page_size", massTransitRoutePlanOption.mPageSize + "");
            this.f44190a.a("coord_type", massTransitRoutePlanOption.mCoordType);
            this.f44190a.a("output", "json");
            this.f44190a.a("from", "android_map_sdk");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.g() : (String) invokeL.objValue;
    }
}
