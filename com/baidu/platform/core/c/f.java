package com.baidu.platform.core.c;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public class f extends com.baidu.platform.base.a implements a {

    /* renamed from: b  reason: collision with root package name */
    public OnGetPoiSearchResultListener f9376b = null;

    @Override // com.baidu.platform.core.c.a
    public void a() {
        this.f9338a.lock();
        this.f9376b = null;
        this.f9338a.unlock();
    }

    @Override // com.baidu.platform.core.c.a
    public void a(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        this.f9338a.lock();
        this.f9376b = onGetPoiSearchResultListener;
        this.f9338a.unlock();
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiBoundSearchOption poiBoundSearchOption) {
        g gVar = new g(poiBoundSearchOption.mPageNum, poiBoundSearchOption.mPageCapacity);
        gVar.a(SearchType.POI_IN_BOUND_SEARCH);
        return a(new i(poiBoundSearchOption), this.f9376b, gVar);
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiCitySearchOption poiCitySearchOption) {
        g gVar = new g(poiCitySearchOption.mPageNum, poiCitySearchOption.mPageCapacity);
        gVar.a(SearchType.POI_IN_CITY_SEARCH);
        return a(new i(poiCitySearchOption), this.f9376b, gVar);
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiDetailSearchOption poiDetailSearchOption) {
        d dVar = new d();
        if (poiDetailSearchOption != null) {
            dVar.a(poiDetailSearchOption.isSearchByUids());
        }
        dVar.a(SearchType.POI_DETAIL_SEARCH);
        return a(new e(poiDetailSearchOption), this.f9376b, dVar);
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiIndoorOption poiIndoorOption) {
        b bVar = new b();
        bVar.a(SearchType.INDOOR_POI_SEARCH);
        return a(new c(poiIndoorOption), this.f9376b, bVar);
    }

    @Override // com.baidu.platform.core.c.a
    public boolean a(PoiNearbySearchOption poiNearbySearchOption) {
        g gVar = new g(poiNearbySearchOption.mPageNum, poiNearbySearchOption.mPageCapacity);
        gVar.a(SearchType.POI_NEAR_BY_SEARCH);
        return a(new i(poiNearbySearchOption), this.f9376b, gVar);
    }
}
