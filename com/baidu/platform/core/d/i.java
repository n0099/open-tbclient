package com.baidu.platform.core.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class i extends com.baidu.platform.base.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i(PoiBoundSearchOption poiBoundSearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiBoundSearchOption};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(poiBoundSearchOption);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            return cVar.a();
        }
        return (String) invokeL.objValue;
    }

    public i(PoiCitySearchOption poiCitySearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiCitySearchOption};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(poiCitySearchOption);
    }

    public i(PoiNearbySearchOption poiNearbySearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiNearbySearchOption};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(poiNearbySearchOption);
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        String str;
        PoiFilter poiFilter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, poiBoundSearchOption) != null) || poiBoundSearchOption == null) {
            return;
        }
        this.a.a("query", poiBoundSearchOption.mKeyword);
        if (poiBoundSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.a.a("language", "en");
        }
        this.a.a("tag", poiBoundSearchOption.mTag);
        LatLngBounds latLngBounds = poiBoundSearchOption.mBound;
        if (latLngBounds != null && latLngBounds.southwest != null && latLngBounds.northeast != null) {
            LatLng latLng = poiBoundSearchOption.mBound.southwest;
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng3 = poiBoundSearchOption.mBound.northeast;
            LatLng latLng4 = new LatLng(latLng3.latitude, latLng3.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng4 = CoordTrans.gcjToBaidu(latLng4);
            }
            if (latLng2 != null && latLng4 != null) {
                com.baidu.platform.util.a aVar = this.a;
                aVar.a("bounds", latLng2.latitude + "," + latLng2.longitude + "," + latLng4.latitude + "," + latLng4.longitude);
            }
        }
        this.a.a("output", "json");
        com.baidu.platform.util.a aVar2 = this.a;
        if (poiBoundSearchOption.isExtendAdcode()) {
            str = "true";
        } else {
            str = "false";
        }
        aVar2.a("extensions_adcode", str);
        com.baidu.platform.util.a aVar3 = this.a;
        aVar3.a("scope", poiBoundSearchOption.mScope + "");
        com.baidu.platform.util.a aVar4 = this.a;
        aVar4.a(SuggestAddrField.KEY_PAGE_NUM, poiBoundSearchOption.mPageNum + "");
        com.baidu.platform.util.a aVar5 = this.a;
        aVar5.a(SuggestAddrField.KEY_PAGE_SIZE, poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope == 2 && (poiFilter = poiBoundSearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiBoundSearchOption.mPoiFilter.toString());
        }
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        String str;
        PoiFilter poiFilter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, poiCitySearchOption) != null) || poiCitySearchOption == null) {
            return;
        }
        this.a.a("query", poiCitySearchOption.mKeyword);
        if (poiCitySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.a.a("language", "en");
        }
        this.a.a("region", poiCitySearchOption.mCity);
        this.a.a("output", "json");
        com.baidu.platform.util.a aVar = this.a;
        if (poiCitySearchOption.isExtendAdcode()) {
            str = "true";
        } else {
            str = "false";
        }
        aVar.a("extensions_adcode", str);
        com.baidu.platform.util.a aVar2 = this.a;
        aVar2.a(SuggestAddrField.KEY_PAGE_NUM, poiCitySearchOption.mPageNum + "");
        com.baidu.platform.util.a aVar3 = this.a;
        aVar3.a(SuggestAddrField.KEY_PAGE_SIZE, poiCitySearchOption.mPageCapacity + "");
        com.baidu.platform.util.a aVar4 = this.a;
        aVar4.a("scope", poiCitySearchOption.mScope + "");
        this.a.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.mIsCityLimit) {
            this.a.a("city_limit", "true");
        } else {
            this.a.a("city_limit", "false");
        }
        if (poiCitySearchOption.mScope == 2 && (poiFilter = poiCitySearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiCitySearchOption.mPoiFilter.toString());
        }
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        String str;
        PoiFilter poiFilter;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, this, poiNearbySearchOption) != null) || poiNearbySearchOption == null) {
            return;
        }
        this.a.a("query", poiNearbySearchOption.mKeyword);
        if (poiNearbySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.a.a("language", "en");
        }
        if (poiNearbySearchOption.mLocation != null) {
            LatLng latLng = poiNearbySearchOption.mLocation;
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            if (latLng2 != null) {
                com.baidu.platform.util.a aVar = this.a;
                aVar.a("location", latLng2.latitude + "," + latLng2.longitude);
            }
        }
        com.baidu.platform.util.a aVar2 = this.a;
        aVar2.a("radius", poiNearbySearchOption.mRadius + "");
        this.a.a("output", "json");
        com.baidu.platform.util.a aVar3 = this.a;
        if (poiNearbySearchOption.isExtendAdcode()) {
            str = "true";
        } else {
            str = "false";
        }
        aVar3.a("extensions_adcode", str);
        com.baidu.platform.util.a aVar4 = this.a;
        aVar4.a(SuggestAddrField.KEY_PAGE_NUM, poiNearbySearchOption.mPageNum + "");
        com.baidu.platform.util.a aVar5 = this.a;
        aVar5.a(SuggestAddrField.KEY_PAGE_SIZE, poiNearbySearchOption.mPageCapacity + "");
        com.baidu.platform.util.a aVar6 = this.a;
        aVar6.a("scope", poiNearbySearchOption.mScope + "");
        this.a.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.a.a("radius_limit", "true");
        } else {
            this.a.a("radius_limit", "false");
        }
        if (poiNearbySearchOption.mScope == 2 && (poiFilter = poiNearbySearchOption.mPoiFilter) != null && !TextUtils.isEmpty(poiFilter.toString())) {
            this.a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiNearbySearchOption.mPoiFilter.toString());
        }
    }
}
