package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes5.dex */
public class PoiSearch extends l {
    private boolean b = false;
    private com.baidu.platform.core.c.a a = new com.baidu.platform.core.c.f();

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
        this.a.a();
        BMapManager.destroy();
    }

    public boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (poiBoundSearchOption == null || poiBoundSearchOption.mBound == null || poiBoundSearchOption.mKeyword == null) {
            throw new IllegalArgumentException("option or bound or keyworld can not be null");
        }
        return this.a.a(poiBoundSearchOption);
    }

    public boolean searchInCity(PoiCitySearchOption poiCitySearchOption) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (poiCitySearchOption == null || poiCitySearchOption.mCity == null || poiCitySearchOption.mKeyword == null) {
            throw new IllegalArgumentException("option or city or keyworld can not be null");
        }
        return this.a.a(poiCitySearchOption);
    }

    public boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (poiNearbySearchOption == null || poiNearbySearchOption.mLocation == null || poiNearbySearchOption.mKeyword == null) {
            throw new IllegalArgumentException("option or location or keyworld can not be null");
        }
        if (poiNearbySearchOption.mRadius <= 0) {
            return false;
        }
        return this.a.a(poiNearbySearchOption);
    }

    public boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (poiDetailSearchOption == null || poiDetailSearchOption.getUid() == null) {
            throw new IllegalArgumentException("option or uid can not be null");
        }
        return this.a.a(poiDetailSearchOption);
    }

    public boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (poiIndoorOption == null || poiIndoorOption.bid == null || poiIndoorOption.wd == null) {
            throw new IllegalArgumentException("option or indoor bid or keyword can not be null");
        }
        return this.a.a(poiIndoorOption);
    }

    public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        if (this.a == null) {
            throw new IllegalStateException("searcher is null, please call newInstance first.");
        }
        if (onGetPoiSearchResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        this.a.a(onGetPoiSearchResultListener);
    }
}
