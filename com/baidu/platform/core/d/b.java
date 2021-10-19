package com.baidu.platform.core.d;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
/* loaded from: classes5.dex */
public class b extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bikingRoutePlanOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bikingRoutePlanOption) == null) {
            this.f44279a.a("mode", "riding");
            LatLng location = bikingRoutePlanOption.mFrom.getLocation();
            if (location != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location = CoordTrans.gcjToBaidu(location);
                }
                com.baidu.platform.util.a aVar = this.f44279a;
                aVar.a(FilterValue.DEFAULT_FILTER_VALUE, location.latitude + "," + location.longitude);
            } else {
                this.f44279a.a(FilterValue.DEFAULT_FILTER_VALUE, bikingRoutePlanOption.mFrom.getName());
            }
            LatLng location2 = bikingRoutePlanOption.mTo.getLocation();
            if (location2 != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location2 = CoordTrans.gcjToBaidu(location2);
                }
                com.baidu.platform.util.a aVar2 = this.f44279a;
                aVar2.a("destination", location2.latitude + "," + location2.longitude);
            } else {
                this.f44279a.a("destination", bikingRoutePlanOption.mTo.getName());
            }
            this.f44279a.a("origin_region", bikingRoutePlanOption.mFrom.getCity());
            this.f44279a.a("destination_region", bikingRoutePlanOption.mTo.getCity());
            int i2 = bikingRoutePlanOption.mRidingType;
            if (i2 == 1) {
                this.f44279a.a("riding_type", String.valueOf(i2));
            }
            this.f44279a.a("output", "json");
            this.f44279a.a("from", "android_map_sdk");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.j() : (String) invokeL.objValue;
    }
}
