package com.baidu.platform.core.e;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.base.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d(RecommendStopSearchOption recommendStopSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recommendStopSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(recommendStopSearchOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.u();
        }
        return (String) invokeL.objValue;
    }

    private void a(RecommendStopSearchOption recommendStopSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, recommendStopSearchOption) == null) {
            if (recommendStopSearchOption != null && recommendStopSearchOption.mLocation != null) {
                LatLng latLng = new LatLng(recommendStopSearchOption.getLocation().latitude, recommendStopSearchOption.getLocation().longitude);
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng = CoordTrans.gcjToBaidu(latLng);
                }
                com.baidu.platform.util.a aVar = this.a;
                aVar.a("location", latLng.longitude + "," + latLng.latitude);
            }
            this.a.a("coordtype", "bd09ll");
            this.a.a("from", "android_map_sdk");
            this.a.a("output", "json");
        }
    }
}
