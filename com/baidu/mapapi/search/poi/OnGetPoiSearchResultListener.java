package com.baidu.mapapi.search.poi;
/* loaded from: classes10.dex */
public interface OnGetPoiSearchResultListener {
    void onGetPoiDetailResult(PoiDetailResult poiDetailResult);

    void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult);

    void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult);

    void onGetPoiResult(PoiResult poiResult);
}
