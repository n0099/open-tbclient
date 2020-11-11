package com.baidu.platform.core.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
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
        this.f2816a.a("query", poiBoundSearchOption.mKeyword);
        this.f2816a.a("tag", poiBoundSearchOption.mTag);
        this.f2816a.a("bounds", poiBoundSearchOption.mBound.southwest.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + poiBoundSearchOption.mBound.southwest.longitude + Constants.ACCEPT_TIME_SEPARATOR_SP + poiBoundSearchOption.mBound.northeast.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + poiBoundSearchOption.mBound.northeast.longitude);
        this.f2816a.a("output", "json");
        this.f2816a.a("scope", poiBoundSearchOption.mScope + "");
        this.f2816a.a("page_num", poiBoundSearchOption.mPageNum + "");
        this.f2816a.a("page_size", poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope != 2 || poiBoundSearchOption.mPoiFilter == null || TextUtils.isEmpty(poiBoundSearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f2816a.a(FilterImageAction.ACTION_NAME, poiBoundSearchOption.mPoiFilter.toString());
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        this.f2816a.a("query", poiCitySearchOption.mKeyword);
        this.f2816a.a("region", poiCitySearchOption.mCity);
        this.f2816a.a("output", "json");
        this.f2816a.a("page_num", poiCitySearchOption.mPageNum + "");
        this.f2816a.a("page_size", poiCitySearchOption.mPageCapacity + "");
        this.f2816a.a("scope", poiCitySearchOption.mScope + "");
        this.f2816a.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.mIsCityLimit) {
            this.f2816a.a("city_limit", "true");
        } else {
            this.f2816a.a("city_limit", "false");
        }
        if (poiCitySearchOption.mScope != 2 || poiCitySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiCitySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f2816a.a(FilterImageAction.ACTION_NAME, poiCitySearchOption.mPoiFilter.toString());
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        this.f2816a.a("query", poiNearbySearchOption.mKeyword);
        this.f2816a.a("location", poiNearbySearchOption.mLocation.latitude + Constants.ACCEPT_TIME_SEPARATOR_SP + poiNearbySearchOption.mLocation.longitude);
        this.f2816a.a("radius", poiNearbySearchOption.mRadius + "");
        this.f2816a.a("output", "json");
        this.f2816a.a("page_num", poiNearbySearchOption.mPageNum + "");
        this.f2816a.a("page_size", poiNearbySearchOption.mPageCapacity + "");
        this.f2816a.a("scope", poiNearbySearchOption.mScope + "");
        this.f2816a.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.f2816a.a("radius_limit", "true");
        } else {
            this.f2816a.a("radius_limit", "false");
        }
        if (poiNearbySearchOption.mScope != 2 || poiNearbySearchOption.mPoiFilter == null || TextUtils.isEmpty(poiNearbySearchOption.mPoiFilter.toString())) {
            return;
        }
        this.f2816a.a(FilterImageAction.ACTION_NAME, poiNearbySearchOption.mPoiFilter.toString());
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.a();
    }
}
