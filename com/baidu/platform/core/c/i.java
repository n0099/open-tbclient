package com.baidu.platform.core.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
/* loaded from: classes15.dex */
public class i extends com.baidu.platform.base.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PoiBoundSearchOption poiBoundSearchOption) {
        a(poiBoundSearchOption);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PoiCitySearchOption poiCitySearchOption) {
        a(poiCitySearchOption);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PoiNearbySearchOption poiNearbySearchOption) {
        a(poiNearbySearchOption);
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        this.f4177a.a("query", poiBoundSearchOption.mKeyword);
        this.f4177a.a("tag", poiBoundSearchOption.mTag);
        this.f4177a.a("bounds", poiBoundSearchOption.mBound.southwest.latitude + "," + poiBoundSearchOption.mBound.southwest.longitude + "," + poiBoundSearchOption.mBound.northeast.latitude + "," + poiBoundSearchOption.mBound.northeast.longitude);
        this.f4177a.a("output", "json");
        this.f4177a.a("scope", poiBoundSearchOption.mScope + "");
        this.f4177a.a("page_num", poiBoundSearchOption.mPageNum + "");
        this.f4177a.a("page_size", poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope != 2 || poiBoundSearchOption.mPoiFilter == null || TextUtils.isEmpty(poiBoundSearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f4177a.a(FilterImageAction.ACTION_NAME, poiBoundSearchOption.mPoiFilter.toString());
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        this.f4177a.a("query", poiCitySearchOption.mKeyword);
        this.f4177a.a("region", poiCitySearchOption.mCity);
        this.f4177a.a("output", "json");
        this.f4177a.a("page_num", poiCitySearchOption.mPageNum + "");
        this.f4177a.a("page_size", poiCitySearchOption.mPageCapacity + "");
        this.f4177a.a("scope", poiCitySearchOption.mScope + "");
        this.f4177a.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.mIsCityLimit) {
            this.f4177a.a("city_limit", "true");
        } else {
            this.f4177a.a("city_limit", "false");
        }
        if (poiCitySearchOption.mScope != 2 || poiCitySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiCitySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f4177a.a(FilterImageAction.ACTION_NAME, poiCitySearchOption.mPoiFilter.toString());
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        this.f4177a.a("query", poiNearbySearchOption.mKeyword);
        this.f4177a.a("location", poiNearbySearchOption.mLocation.latitude + "," + poiNearbySearchOption.mLocation.longitude);
        this.f4177a.a("radius", poiNearbySearchOption.mRadius + "");
        this.f4177a.a("output", "json");
        this.f4177a.a("page_num", poiNearbySearchOption.mPageNum + "");
        this.f4177a.a("page_size", poiNearbySearchOption.mPageCapacity + "");
        this.f4177a.a("scope", poiNearbySearchOption.mScope + "");
        this.f4177a.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.f4177a.a("radius_limit", "true");
        } else {
            this.f4177a.a("radius_limit", "false");
        }
        if (poiNearbySearchOption.mScope != 2 || poiNearbySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiNearbySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f4177a.a(FilterImageAction.ACTION_NAME, poiNearbySearchOption.mPoiFilter.toString());
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.a();
    }
}
