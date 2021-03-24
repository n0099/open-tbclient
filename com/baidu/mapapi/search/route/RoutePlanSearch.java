package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;
/* loaded from: classes2.dex */
public class RoutePlanSearch extends com.baidu.mapapi.search.core.l {

    /* renamed from: b  reason: collision with root package name */
    public boolean f7306b = false;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.d.e f7305a = new com.baidu.platform.core.d.j();

    public static RoutePlanSearch newInstance() {
        BMapManager.init();
        return new RoutePlanSearch();
    }

    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        PlanNode planNode;
        if (this.f7305a != null) {
            if (bikingRoutePlanOption == null || bikingRoutePlanOption.mTo == null || (planNode = bikingRoutePlanOption.mFrom) == null) {
                throw new IllegalArgumentException("route plan option , origin or destination can not be null");
            }
            if (planNode.getLocation() == null && (bikingRoutePlanOption.mFrom.getName() == null || bikingRoutePlanOption.mFrom.getName() == "")) {
                throw new IllegalArgumentException("route plan option , origin is illegal");
            }
            if (bikingRoutePlanOption.mTo.getLocation() == null && (bikingRoutePlanOption.mTo.getName() == null || bikingRoutePlanOption.mTo.getName() == "")) {
                throw new IllegalArgumentException("route plan option , destination is illegal");
            }
            return this.f7305a.a(bikingRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public void destroy() {
        if (this.f7306b) {
            return;
        }
        this.f7306b = true;
        this.f7305a.a();
        BMapManager.destroy();
    }

    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        com.baidu.platform.core.d.e eVar = this.f7305a;
        if (eVar != null) {
            if (drivingRoutePlanOption == null || drivingRoutePlanOption.mTo == null || drivingRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("route plan option , origin or destination can not be null");
            }
            return eVar.a(drivingRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        PlanNode planNode;
        if (this.f7305a != null) {
            if (massTransitRoutePlanOption == null || massTransitRoutePlanOption.mTo == null || (planNode = massTransitRoutePlanOption.mFrom) == null) {
                throw new IllegalArgumentException("route plan option,origin or destination can not be null");
            }
            if (planNode.getLocation() == null && (massTransitRoutePlanOption.mFrom.getName() == null || massTransitRoutePlanOption.mFrom.getCity() == null)) {
                throw new IllegalArgumentException("route plan option,origin is illegal");
            }
            if (massTransitRoutePlanOption.mTo.getLocation() == null && (massTransitRoutePlanOption.mTo.getName() == null || massTransitRoutePlanOption.mTo.getCity() == null)) {
                throw new IllegalArgumentException("route plan option,destination is illegal");
            }
            return this.f7305a.a(massTransitRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        com.baidu.platform.core.d.e eVar = this.f7305a;
        if (eVar == null) {
            throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
        }
        if (onGetRoutePlanResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        eVar.a(onGetRoutePlanResultListener);
    }

    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        com.baidu.platform.core.d.e eVar = this.f7305a;
        if (eVar != null) {
            if (transitRoutePlanOption == null || transitRoutePlanOption.mCityName == null || transitRoutePlanOption.mTo == null || transitRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("route plan option,origin or destination or city can not be null");
            }
            return eVar.a(transitRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        com.baidu.platform.core.d.e eVar = this.f7305a;
        if (eVar != null) {
            if (indoorRoutePlanOption == null || indoorRoutePlanOption.mTo == null || indoorRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("option , origin or destination can not be null");
            }
            return eVar.a(indoorRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }

    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        com.baidu.platform.core.d.e eVar = this.f7305a;
        if (eVar != null) {
            if (walkingRoutePlanOption == null || walkingRoutePlanOption.mTo == null || walkingRoutePlanOption.mFrom == null) {
                throw new IllegalArgumentException("option , origin or destination can not be null");
            }
            return eVar.a(walkingRoutePlanOption);
        }
        throw new IllegalStateException("RoutePlanSearch is null, please call newInstance() first.");
    }
}
