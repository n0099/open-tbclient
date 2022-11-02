package com.baidu.platform.core.h;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
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

    public d(SuggestionSearchOption suggestionSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {suggestionSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(suggestionSearchOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.d();
        }
        return (String) invokeL.objValue;
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, suggestionSearchOption) == null) {
            this.a.a("query", suggestionSearchOption.mKeyword);
            this.a.a("region", suggestionSearchOption.mCity);
            if (suggestionSearchOption.mLocation != null) {
                LatLng latLng = suggestionSearchOption.mLocation;
                LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng2 = CoordTrans.gcjToBaidu(latLng2);
                }
                com.baidu.platform.util.a aVar = this.a;
                aVar.a("location", latLng2.latitude + "," + latLng2.longitude);
            }
            String str = "true";
            if (suggestionSearchOption.mCityLimit.booleanValue()) {
                this.a.a("city_limit", "true");
            } else {
                this.a.a("city_limit", "false");
            }
            this.a.a("from", "android_map_sdk");
            this.a.a("output", "json");
            com.baidu.platform.util.a aVar2 = this.a;
            if (!suggestionSearchOption.isExtendAdcode()) {
                str = "false";
            }
            aVar2.a("extensions_adcode", str);
        }
    }
}
