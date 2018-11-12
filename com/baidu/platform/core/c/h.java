package com.baidu.platform.core.c;

import android.net.http.Headers;
import android.text.TextUtils;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.webkit.internal.ABTestConstants;
/* loaded from: classes4.dex */
public class h extends com.baidu.platform.base.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PoiBoundSearchOption poiBoundSearchOption) {
        a(poiBoundSearchOption);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PoiCitySearchOption poiCitySearchOption) {
        a(poiCitySearchOption);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PoiNearbySearchOption poiNearbySearchOption) {
        a(poiNearbySearchOption);
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        this.a.a("query", poiBoundSearchOption.mKeyword);
        this.a.a("tag", poiBoundSearchOption.mTag);
        this.a.a("bounds", poiBoundSearchOption.mBound.southwest.latitude + "," + poiBoundSearchOption.mBound.southwest.longitude + "," + poiBoundSearchOption.mBound.northeast.latitude + "," + poiBoundSearchOption.mBound.northeast.longitude);
        this.a.a("output", NetworkDef.DataType.JSON);
        this.a.a("scope", poiBoundSearchOption.mScope + "");
        this.a.a("page_num", poiBoundSearchOption.mPageNum + "");
        this.a.a("page_size", poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope != 2 || poiBoundSearchOption.mPoiFilter == null || TextUtils.isEmpty(poiBoundSearchOption.mPoiFilter.toString())) {
            return;
        }
        this.a.a("filter", poiBoundSearchOption.mPoiFilter.toString());
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        this.a.a("query", poiCitySearchOption.mKeyword);
        this.a.a("region", poiCitySearchOption.mCity);
        this.a.a("output", NetworkDef.DataType.JSON);
        this.a.a("page_num", poiCitySearchOption.mPageNum + "");
        this.a.a("page_size", poiCitySearchOption.mPageCapacity + "");
        this.a.a("scope", poiCitySearchOption.mScope + "");
        this.a.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.mIsCityLimit) {
            this.a.a("city_limit", "true");
        } else {
            this.a.a("city_limit", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
        if (poiCitySearchOption.mScope != 2 || poiCitySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiCitySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.a.a("filter", poiCitySearchOption.mPoiFilter.toString());
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        this.a.a("query", poiNearbySearchOption.mKeyword);
        this.a.a(Headers.LOCATION, poiNearbySearchOption.mLocation.latitude + "," + poiNearbySearchOption.mLocation.longitude);
        this.a.a("radius", poiNearbySearchOption.mRadius + "");
        this.a.a("output", NetworkDef.DataType.JSON);
        this.a.a("page_num", poiNearbySearchOption.mPageNum + "");
        this.a.a("page_size", poiNearbySearchOption.mPageCapacity + "");
        this.a.a("scope", poiNearbySearchOption.mScope + "");
        this.a.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.a.a("radius_limit", "true");
        } else {
            this.a.a("radius_limit", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
        if (poiNearbySearchOption.mScope != 2 || poiNearbySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiNearbySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.a.a("filter", poiNearbySearchOption.mPoiFilter.toString());
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.a();
    }
}
