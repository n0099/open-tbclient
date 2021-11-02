package com.baidu.platform.core.c;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(poiBoundSearchOption);
    }

    public i(PoiCitySearchOption poiCitySearchOption) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poiCitySearchOption};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(poiNearbySearchOption);
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        PoiFilter poiFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, poiBoundSearchOption) == null) {
            this.f42041a.a("query", poiBoundSearchOption.mKeyword);
            this.f42041a.a("tag", poiBoundSearchOption.mTag);
            com.baidu.platform.util.a aVar = this.f42041a;
            aVar.a("bounds", poiBoundSearchOption.mBound.southwest.latitude + "," + poiBoundSearchOption.mBound.southwest.longitude + "," + poiBoundSearchOption.mBound.northeast.latitude + "," + poiBoundSearchOption.mBound.northeast.longitude);
            this.f42041a.a("output", "json");
            com.baidu.platform.util.a aVar2 = this.f42041a;
            StringBuilder sb = new StringBuilder();
            sb.append(poiBoundSearchOption.mScope);
            sb.append("");
            aVar2.a("scope", sb.toString());
            com.baidu.platform.util.a aVar3 = this.f42041a;
            aVar3.a(SuggestAddrField.KEY_PAGE_NUM, poiBoundSearchOption.mPageNum + "");
            com.baidu.platform.util.a aVar4 = this.f42041a;
            aVar4.a("page_size", poiBoundSearchOption.mPageCapacity + "");
            if (poiBoundSearchOption.mScope != 2 || (poiFilter = poiBoundSearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
                return;
            }
            this.f42041a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiBoundSearchOption.mPoiFilter.toString());
        }
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        com.baidu.platform.util.a aVar;
        String str;
        PoiFilter poiFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, poiCitySearchOption) == null) {
            this.f42041a.a("query", poiCitySearchOption.mKeyword);
            this.f42041a.a("region", poiCitySearchOption.mCity);
            this.f42041a.a("output", "json");
            com.baidu.platform.util.a aVar2 = this.f42041a;
            aVar2.a(SuggestAddrField.KEY_PAGE_NUM, poiCitySearchOption.mPageNum + "");
            com.baidu.platform.util.a aVar3 = this.f42041a;
            aVar3.a("page_size", poiCitySearchOption.mPageCapacity + "");
            com.baidu.platform.util.a aVar4 = this.f42041a;
            aVar4.a("scope", poiCitySearchOption.mScope + "");
            this.f42041a.a("tag", poiCitySearchOption.mTag);
            if (poiCitySearchOption.mIsCityLimit) {
                aVar = this.f42041a;
                str = "true";
            } else {
                aVar = this.f42041a;
                str = "false";
            }
            aVar.a("city_limit", str);
            if (poiCitySearchOption.mScope != 2 || (poiFilter = poiCitySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
                return;
            }
            this.f42041a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiCitySearchOption.mPoiFilter.toString());
        }
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        com.baidu.platform.util.a aVar;
        String str;
        PoiFilter poiFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, poiNearbySearchOption) == null) {
            this.f42041a.a("query", poiNearbySearchOption.mKeyword);
            com.baidu.platform.util.a aVar2 = this.f42041a;
            aVar2.a("location", poiNearbySearchOption.mLocation.latitude + "," + poiNearbySearchOption.mLocation.longitude);
            com.baidu.platform.util.a aVar3 = this.f42041a;
            aVar3.a("radius", poiNearbySearchOption.mRadius + "");
            this.f42041a.a("output", "json");
            com.baidu.platform.util.a aVar4 = this.f42041a;
            aVar4.a(SuggestAddrField.KEY_PAGE_NUM, poiNearbySearchOption.mPageNum + "");
            com.baidu.platform.util.a aVar5 = this.f42041a;
            aVar5.a("page_size", poiNearbySearchOption.mPageCapacity + "");
            com.baidu.platform.util.a aVar6 = this.f42041a;
            aVar6.a("scope", poiNearbySearchOption.mScope + "");
            this.f42041a.a("tag", poiNearbySearchOption.mTag);
            if (poiNearbySearchOption.mRadiusLimit) {
                aVar = this.f42041a;
                str = "true";
            } else {
                aVar = this.f42041a;
                str = "false";
            }
            aVar.a("radius_limit", str);
            if (poiNearbySearchOption.mScope != 2 || (poiFilter = poiNearbySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
                return;
            }
            this.f42041a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiNearbySearchOption.mPoiFilter.toString());
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.a() : (String) invokeL.objValue;
    }
}
