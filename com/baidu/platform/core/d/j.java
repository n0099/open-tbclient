package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.platform.base.SearchType;
/* loaded from: classes2.dex */
public class j extends com.baidu.platform.base.a implements e {

    /* renamed from: b  reason: collision with root package name */
    public OnGetRoutePlanResultListener f9281b = null;

    @Override // com.baidu.platform.core.d.e
    public void a() {
        this.f9238a.lock();
        this.f9281b = null;
        this.f9238a.unlock();
    }

    @Override // com.baidu.platform.core.d.e
    public void a(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        this.f9238a.lock();
        this.f9281b = onGetRoutePlanResultListener;
        this.f9238a.unlock();
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(BikingRoutePlanOption bikingRoutePlanOption) {
        a aVar = new a();
        aVar.a(SearchType.BIKE_ROUTE);
        return a(new b(bikingRoutePlanOption), this.f9281b, aVar);
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(DrivingRoutePlanOption drivingRoutePlanOption) {
        c cVar = new c();
        cVar.a(SearchType.DRIVE_ROUTE);
        return a(new d(drivingRoutePlanOption), this.f9281b, cVar);
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(IndoorRoutePlanOption indoorRoutePlanOption) {
        f fVar = new f();
        fVar.a(SearchType.INDOOR_ROUTE);
        return a(new g(indoorRoutePlanOption), this.f9281b, fVar);
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        h hVar = new h();
        hVar.a(SearchType.MASS_TRANSIT_ROUTE);
        return a(new i(massTransitRoutePlanOption), this.f9281b, hVar);
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(TransitRoutePlanOption transitRoutePlanOption) {
        m mVar = new m();
        mVar.a(SearchType.TRANSIT_ROUTE);
        return a(new n(transitRoutePlanOption), this.f9281b, mVar);
    }

    @Override // com.baidu.platform.core.d.e
    public boolean a(WalkingRoutePlanOption walkingRoutePlanOption) {
        o oVar = new o();
        oVar.a(SearchType.WALK_ROUTE);
        return a(new p(walkingRoutePlanOption), this.f9281b, oVar);
    }
}
