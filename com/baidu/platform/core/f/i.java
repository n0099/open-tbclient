package com.baidu.platform.core.f;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(massTransitRoutePlanOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.g();
        }
        return (String) invokeL.objValue;
    }

    private void a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, massTransitRoutePlanOption) == null) {
            LatLng location = massTransitRoutePlanOption.mFrom.getLocation();
            if (location != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location = CoordTrans.gcjToBaidu(location);
                }
                com.baidu.platform.util.a aVar = this.a;
                aVar.a("origin", location.latitude + "," + location.longitude);
            } else {
                this.a.a("origin", massTransitRoutePlanOption.mFrom.getName());
            }
            if (massTransitRoutePlanOption.mFrom.getCity() != null) {
                this.a.a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
            }
            LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
            if (location2 != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location2 = CoordTrans.gcjToBaidu(location2);
                }
                com.baidu.platform.util.a aVar2 = this.a;
                aVar2.a("destination", location2.latitude + "," + location2.longitude);
            } else {
                this.a.a("destination", massTransitRoutePlanOption.mTo.getName());
            }
            if (massTransitRoutePlanOption.mTo.getCity() != null) {
                this.a.a("destination_region", massTransitRoutePlanOption.mTo.getCity());
            }
            com.baidu.platform.util.a aVar3 = this.a;
            aVar3.a("tactics_incity", massTransitRoutePlanOption.mTacticsIncity.getInt() + "");
            com.baidu.platform.util.a aVar4 = this.a;
            aVar4.a("tactics_intercity", massTransitRoutePlanOption.mTacticsIntercity.getInt() + "");
            com.baidu.platform.util.a aVar5 = this.a;
            aVar5.a("trans_type_intercity", massTransitRoutePlanOption.mTransTypeIntercity.getInt() + "");
            com.baidu.platform.util.a aVar6 = this.a;
            aVar6.a("page_index", massTransitRoutePlanOption.mPageIndex + "");
            com.baidu.platform.util.a aVar7 = this.a;
            aVar7.a(SuggestAddrField.KEY_PAGE_SIZE, massTransitRoutePlanOption.mPageSize + "");
            this.a.a("coord_type", massTransitRoutePlanOption.mCoordType);
            this.a.a("output", "json");
            this.a.a("from", "android_map_sdk");
        }
    }
}
