package com.baidu.platform.core.f;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.platform.base.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d(SuggestionSearchOption suggestionSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {suggestionSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        com.baidu.platform.util.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, suggestionSearchOption) == null) {
            this.f42041a.a(IAdRequestParam.COST_NAME, suggestionSearchOption.mKeyword);
            this.f42041a.a("region", suggestionSearchOption.mCity);
            if (suggestionSearchOption.mLocation != null) {
                LatLng latLng = suggestionSearchOption.mLocation;
                LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng2 = CoordTrans.gcjToBaidu(latLng2);
                }
                com.baidu.platform.util.a aVar2 = this.f42041a;
                aVar2.a("location", latLng2.latitude + "," + latLng2.longitude);
            }
            if (suggestionSearchOption.mCityLimit.booleanValue()) {
                aVar = this.f42041a;
                str = "true";
            } else {
                aVar = this.f42041a;
                str = "false";
            }
            aVar.a("city_limit", str);
            this.f42041a.a("from", "android_map_sdk");
            this.f42041a.a("output", "json");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.d() : (String) invokeL.objValue;
    }
}
