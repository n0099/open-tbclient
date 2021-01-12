package com.baidu.platform.core.e;

import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.PoiDetailShareURLOption;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.base.SearchType;
/* loaded from: classes6.dex */
public class h extends com.baidu.platform.base.a implements a {

    /* renamed from: b  reason: collision with root package name */
    OnGetShareUrlResultListener f4494b = null;

    @Override // com.baidu.platform.core.e.a
    public void a() {
        this.f4133a.lock();
        this.f4494b = null;
        this.f4133a.unlock();
    }

    @Override // com.baidu.platform.core.e.a
    public void a(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        this.f4133a.lock();
        this.f4494b = onGetShareUrlResultListener;
        this.f4133a.unlock();
    }

    @Override // com.baidu.platform.core.e.a
    public boolean a(LocationShareURLOption locationShareURLOption) {
        f fVar = new f();
        fVar.a(SearchType.LOCATION_SEARCH_SHARE);
        return a(new b(locationShareURLOption), this.f4494b, fVar);
    }

    @Override // com.baidu.platform.core.e.a
    public boolean a(PoiDetailShareURLOption poiDetailShareURLOption) {
        f fVar = new f();
        fVar.a(SearchType.POI_DETAIL_SHARE);
        return a(new c(poiDetailShareURLOption), this.f4494b, fVar);
    }

    @Override // com.baidu.platform.core.e.a
    public boolean a(RouteShareURLOption routeShareURLOption) {
        d dVar = new d();
        dVar.a(SearchType.ROUTE_PLAN_SHARE);
        return a(new e(routeShareURLOption), this.f4494b, dVar);
    }
}
