package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;
/* loaded from: classes4.dex */
public class RoutePlanSearch extends com.baidu.mapapi.search.core.l {

    /* renamed from: b  reason: collision with root package name */
    private boolean f2919b = false;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.platform.core.d.e f2918a = new com.baidu.platform.core.d.j();

    RoutePlanSearch() {
    }

    public static RoutePlanSearch newInstance() {
        BMapManager.init();
        return new RoutePlanSearch();
    }

    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        if (this.f2918a == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (bikingRoutePlanOption == null || bikingRoutePlanOption.mTo == null || bikingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("route plan option , origin or destination can not be null");
        }
        if (bikingRoutePlanOption.mFrom.getLocation() == null && (bikingRoutePlanOption.mFrom.getName() == null || bikingRoutePlanOption.mFrom.getName() == "")) {
            throw new IllegalArgumentException("route plan option , origin is illegal");
        }
        if (bikingRoutePlanOption.mTo.getLocation() == null && (bikingRoutePlanOption.mTo.getName() == null || bikingRoutePlanOption.mTo.getName() == "")) {
            throw new IllegalArgumentException("route plan option , destination is illegal");
        }
        return this.f2918a.a(bikingRoutePlanOption);
    }

    public void destroy() {
        if (this.f2919b) {
            return;
        }
        this.f2919b = true;
        this.f2918a.a();
        BMapManager.destroy();
    }

    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        if (this.f2918a == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (drivingRoutePlanOption == null || drivingRoutePlanOption.mTo == null || drivingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("route plan option , origin or destination can not be null");
        }
        return this.f2918a.a(drivingRoutePlanOption);
    }

    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        if (this.f2918a == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (massTransitRoutePlanOption == null || massTransitRoutePlanOption.mTo == null || massTransitRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("route plan option,origin or destination can not be null");
        }
        if (massTransitRoutePlanOption.mFrom.getLocation() == null && (massTransitRoutePlanOption.mFrom.getName() == null || massTransitRoutePlanOption.mFrom.getCity() == null)) {
            throw new IllegalArgumentException("route plan option,origin is illegal");
        }
        if (massTransitRoutePlanOption.mTo.getLocation() == null && (massTransitRoutePlanOption.mTo.getName() == null || massTransitRoutePlanOption.mTo.getCity() == null)) {
            throw new IllegalArgumentException("route plan option,destination is illegal");
        }
        return this.f2918a.a(massTransitRoutePlanOption);
    }

    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (this.f2918a == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (onGetRoutePlanResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        this.f2918a.a(onGetRoutePlanResultListener);
    }

    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        if (this.f2918a == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (transitRoutePlanOption == null || transitRoutePlanOption.mCityName == null || transitRoutePlanOption.mTo == null || transitRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("route plan option,origin or destination or city can not be null");
        }
        return this.f2918a.a(transitRoutePlanOption);
    }

    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        if (this.f2918a == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (indoorRoutePlanOption == null || indoorRoutePlanOption.mTo == null || indoorRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("option , origin or destination can not be null");
        }
        return this.f2918a.a(indoorRoutePlanOption);
    }

    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        if (this.f2918a == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (walkingRoutePlanOption == null || walkingRoutePlanOption.mTo == null || walkingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("option , origin or destination can not be null");
        }
        return this.f2918a.a(walkingRoutePlanOption);
    }
}
