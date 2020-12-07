package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes26.dex */
public class PoiSearch extends l {
    private boolean b = false;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.platform.core.c.a f2131a = new com.baidu.platform.core.c.f();

    PoiSearch() {
    }

    public static PoiSearch newInstance() {
        BMapManager.init();
        return new PoiSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f2131a.a();
        BMapManager.destroy();
    }

    public boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption) {
        if (this.f2131a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (poiBoundSearchOption == null || poiBoundSearchOption.mBound == null || poiBoundSearchOption.mKeyword == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or bound or keyworld can not be null");
        }
        return this.f2131a.a(poiBoundSearchOption);
    }

    public boolean searchInCity(PoiCitySearchOption poiCitySearchOption) {
        if (this.f2131a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (poiCitySearchOption == null || poiCitySearchOption.mCity == null || poiCitySearchOption.mKeyword == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or city or keyworld can not be null");
        }
        return this.f2131a.a(poiCitySearchOption);
    }

    public boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption) {
        if (this.f2131a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (poiNearbySearchOption == null || poiNearbySearchOption.mLocation == null || poiNearbySearchOption.mKeyword == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or location or keyworld can not be null");
        }
        if (poiNearbySearchOption.mRadius <= 0) {
            return false;
        }
        return this.f2131a.a(poiNearbySearchOption);
    }

    public boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption) {
        if (this.f2131a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (poiDetailSearchOption == null || poiDetailSearchOption.getUid() == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
        }
        return this.f2131a.a(poiDetailSearchOption);
    }

    public boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption) {
        if (this.f2131a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (poiIndoorOption == null || poiIndoorOption.bid == null || poiIndoorOption.wd == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or indoor bid or keyword can not be null");
        }
        return this.f2131a.a(poiIndoorOption);
    }

    public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        if (this.f2131a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (onGetPoiSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        this.f2131a.a(onGetPoiSearchResultListener);
    }
}
