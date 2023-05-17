package com.baidu.platform.core.c;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(reverseGeoCodeOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.e();
        }
        return (String) invokeL.objValue;
    }

    private void a(ReverseGeoCodeOption reverseGeoCodeOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, reverseGeoCodeOption) == null) {
            if (reverseGeoCodeOption.getLocation() != null) {
                LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    latLng = CoordTrans.gcjToBaidu(latLng);
                }
                com.baidu.platform.util.a aVar = this.a;
                aVar.a("location", latLng.latitude + "," + latLng.longitude);
            }
            if (reverseGeoCodeOption.getLanguage() == LanguageType.LanguageTypeEnglish) {
                this.a.a("language", "en");
            }
            this.a.a("coordtype", "bd09ll");
            this.a.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
            this.a.a(SuggestAddrField.KEY_PAGE_SIZE, String.valueOf(reverseGeoCodeOption.getPageSize()));
            this.a.a("pois", "1");
            this.a.a("extensions_poi", "1");
            this.a.a("extensions_town", "true");
            if (reverseGeoCodeOption.getExtensionsRoad()) {
                this.a.a("extensions_road", "true");
            } else {
                this.a.a("extensions_road", CommandUBCHelper.COMMAND_UBC_VALUE_FALSE);
            }
            String poiType = reverseGeoCodeOption.getPoiType();
            if (!TextUtils.isEmpty(poiType)) {
                this.a.a("poi_types", poiType);
            }
            this.a.a("output", "jsonaes");
            this.a.a("from", "android_map_sdk");
            this.a.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
            this.a.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
        }
    }
}
