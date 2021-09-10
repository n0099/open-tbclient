package com.baidu.platform.core.b;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f(ReverseGeoCodeOption reverseGeoCodeOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reverseGeoCodeOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(reverseGeoCodeOption);
    }

    private void a(ReverseGeoCodeOption reverseGeoCodeOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, reverseGeoCodeOption) == null) {
            if (reverseGeoCodeOption.getLocation() != null) {
                LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng = CoordTrans.gcjToBaidu(latLng);
                }
                com.baidu.platform.util.a aVar = this.f44305a;
                aVar.a("location", latLng.latitude + "," + latLng.longitude);
            }
            this.f44305a.a("coordtype", "bd09ll");
            this.f44305a.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
            this.f44305a.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
            this.f44305a.a("pois", "1");
            this.f44305a.a("output", "jsonaes");
            this.f44305a.a("from", "android_map_sdk");
            this.f44305a.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
            this.f44305a.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.e() : (String) invokeL.objValue;
    }
}
