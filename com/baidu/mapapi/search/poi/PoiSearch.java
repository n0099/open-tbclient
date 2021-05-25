package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
/* loaded from: classes2.dex */
public class PoiSearch extends l {

    /* renamed from: b  reason: collision with root package name */
    public boolean f7248b = false;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.c.a f7247a = new com.baidu.platform.core.c.f();

    public static PoiSearch newInstance() {
        BMapManager.init();
        return new PoiSearch();
    }

    public void destroy() {
        if (this.f7248b) {
            return;
        }
        this.f7248b = true;
        this.f7247a.a();
        BMapManager.destroy();
    }

    public boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption) {
        com.baidu.platform.core.c.a aVar = this.f7247a;
        if (aVar != null) {
            if (poiBoundSearchOption == null || poiBoundSearchOption.mBound == null || poiBoundSearchOption.mKeyword == null) {
                throw new IllegalArgumentException("BDMapSDKException: option or bound or keyworld can not be null");
            }
            return aVar.a(poiBoundSearchOption);
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchInCity(PoiCitySearchOption poiCitySearchOption) {
        com.baidu.platform.core.c.a aVar = this.f7247a;
        if (aVar != null) {
            if (poiCitySearchOption == null || poiCitySearchOption.mCity == null || poiCitySearchOption.mKeyword == null) {
                throw new IllegalArgumentException("BDMapSDKException: option or city or keyworld can not be null");
            }
            return aVar.a(poiCitySearchOption);
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption) {
        com.baidu.platform.core.c.a aVar = this.f7247a;
        if (aVar != null) {
            if (poiNearbySearchOption == null || poiNearbySearchOption.mLocation == null || poiNearbySearchOption.mKeyword == null) {
                throw new IllegalArgumentException("BDMapSDKException: option or location or keyworld can not be null");
            }
            if (poiNearbySearchOption.mRadius <= 0) {
                return false;
            }
            return aVar.a(poiNearbySearchOption);
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption) {
        if (this.f7247a != null) {
            if (poiDetailSearchOption == null || poiDetailSearchOption.getUid() == null) {
                throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
            }
            return this.f7247a.a(poiDetailSearchOption);
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption) {
        com.baidu.platform.core.c.a aVar = this.f7247a;
        if (aVar != null) {
            if (poiIndoorOption == null || poiIndoorOption.bid == null || poiIndoorOption.wd == null) {
                throw new IllegalArgumentException("BDMapSDKException: option or indoor bid or keyword can not be null");
            }
            return aVar.a(poiIndoorOption);
        }
        throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
    }

    public void setOnGetPoiSearchResultListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        com.baidu.platform.core.c.a aVar = this.f7247a;
        if (aVar == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (onGetPoiSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        aVar.a(onGetPoiSearchResultListener);
    }
}
