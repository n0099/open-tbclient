package com.baidu.platform.core.c;

import android.text.TextUtils;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
/* loaded from: classes2.dex */
public class i extends com.baidu.platform.base.e {
    public i(PoiBoundSearchOption poiBoundSearchOption) {
        a(poiBoundSearchOption);
    }

    public i(PoiCitySearchOption poiCitySearchOption) {
        a(poiCitySearchOption);
    }

    public i(PoiNearbySearchOption poiNearbySearchOption) {
        a(poiNearbySearchOption);
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        PoiFilter poiFilter;
        this.f9352a.a("query", poiBoundSearchOption.mKeyword);
        this.f9352a.a("tag", poiBoundSearchOption.mTag);
        com.baidu.platform.util.a aVar = this.f9352a;
        aVar.a("bounds", poiBoundSearchOption.mBound.southwest.latitude + "," + poiBoundSearchOption.mBound.southwest.longitude + "," + poiBoundSearchOption.mBound.northeast.latitude + "," + poiBoundSearchOption.mBound.northeast.longitude);
        this.f9352a.a("output", "json");
        com.baidu.platform.util.a aVar2 = this.f9352a;
        StringBuilder sb = new StringBuilder();
        sb.append(poiBoundSearchOption.mScope);
        sb.append("");
        aVar2.a("scope", sb.toString());
        com.baidu.platform.util.a aVar3 = this.f9352a;
        aVar3.a(SuggestAddrField.KEY_PAGE_NUM, poiBoundSearchOption.mPageNum + "");
        com.baidu.platform.util.a aVar4 = this.f9352a;
        aVar4.a("page_size", poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope != 2 || (poiFilter = poiBoundSearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.f9352a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiBoundSearchOption.mPoiFilter.toString());
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        com.baidu.platform.util.a aVar;
        String str;
        PoiFilter poiFilter;
        this.f9352a.a("query", poiCitySearchOption.mKeyword);
        this.f9352a.a("region", poiCitySearchOption.mCity);
        this.f9352a.a("output", "json");
        com.baidu.platform.util.a aVar2 = this.f9352a;
        aVar2.a(SuggestAddrField.KEY_PAGE_NUM, poiCitySearchOption.mPageNum + "");
        com.baidu.platform.util.a aVar3 = this.f9352a;
        aVar3.a("page_size", poiCitySearchOption.mPageCapacity + "");
        com.baidu.platform.util.a aVar4 = this.f9352a;
        aVar4.a("scope", poiCitySearchOption.mScope + "");
        this.f9352a.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.mIsCityLimit) {
            aVar = this.f9352a;
            str = "true";
        } else {
            aVar = this.f9352a;
            str = "false";
        }
        aVar.a("city_limit", str);
        if (poiCitySearchOption.mScope != 2 || (poiFilter = poiCitySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.f9352a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiCitySearchOption.mPoiFilter.toString());
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        com.baidu.platform.util.a aVar;
        String str;
        PoiFilter poiFilter;
        this.f9352a.a("query", poiNearbySearchOption.mKeyword);
        com.baidu.platform.util.a aVar2 = this.f9352a;
        aVar2.a("location", poiNearbySearchOption.mLocation.latitude + "," + poiNearbySearchOption.mLocation.longitude);
        com.baidu.platform.util.a aVar3 = this.f9352a;
        aVar3.a("radius", poiNearbySearchOption.mRadius + "");
        this.f9352a.a("output", "json");
        com.baidu.platform.util.a aVar4 = this.f9352a;
        aVar4.a(SuggestAddrField.KEY_PAGE_NUM, poiNearbySearchOption.mPageNum + "");
        com.baidu.platform.util.a aVar5 = this.f9352a;
        aVar5.a("page_size", poiNearbySearchOption.mPageCapacity + "");
        com.baidu.platform.util.a aVar6 = this.f9352a;
        aVar6.a("scope", poiNearbySearchOption.mScope + "");
        this.f9352a.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            aVar = this.f9352a;
            str = "true";
        } else {
            aVar = this.f9352a;
            str = "false";
        }
        aVar.a("radius_limit", str);
        if (poiNearbySearchOption.mScope != 2 || (poiFilter = poiNearbySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.f9352a.a(CloudControlRequest.REQUEST_KEY_FILTER, poiNearbySearchOption.mPoiFilter.toString());
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.a();
    }
}
