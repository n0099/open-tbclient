package com.baidu.mapapi.search.route;

import com.baidu.mapapi.BMapManager;
/* loaded from: classes20.dex */
public class RoutePlanSearch extends com.baidu.mapapi.search.core.l {
    private boolean b = false;
    private com.baidu.platform.core.d.e a = new com.baidu.platform.core.d.j();

    RoutePlanSearch() {
    }

    public static RoutePlanSearch newInstance() {
        BMapManager.init();
        return new RoutePlanSearch();
    }

    public boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption) {
        if (this.a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (bikingRoutePlanOption == null || bikingRoutePlanOption.mTo == null || bikingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
        }
        if (bikingRoutePlanOption.mFrom.getLocation() == null && (bikingRoutePlanOption.mFrom.getName() == null || bikingRoutePlanOption.mFrom.getName() == "")) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin is illegal");
        }
        if (bikingRoutePlanOption.mTo.getLocation() == null && (bikingRoutePlanOption.mTo.getName() == null || bikingRoutePlanOption.mTo.getName() == "")) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , destination is illegal");
        }
        return this.a.a(bikingRoutePlanOption);
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.a.a();
        BMapManager.destroy();
    }

    public boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption) {
        if (this.a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (drivingRoutePlanOption == null || drivingRoutePlanOption.mTo == null || drivingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option , origin or destination can not be null");
        }
        return this.a.a(drivingRoutePlanOption);
    }

    public boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        if (this.a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (massTransitRoutePlanOption == null || massTransitRoutePlanOption.mTo == null || massTransitRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination can not be null");
        }
        if (massTransitRoutePlanOption.mFrom.getLocation() == null && (massTransitRoutePlanOption.mFrom.getName() == null || massTransitRoutePlanOption.mFrom.getCity() == null)) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin is illegal");
        }
        if (massTransitRoutePlanOption.mTo.getLocation() == null && (massTransitRoutePlanOption.mTo.getName() == null || massTransitRoutePlanOption.mTo.getCity() == null)) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,destination is illegal");
        }
        return this.a.a(massTransitRoutePlanOption);
    }

    public void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (this.a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (onGetRoutePlanResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        this.a.a(onGetRoutePlanResultListener);
    }

    public boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption) {
        if (this.a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (transitRoutePlanOption == null || transitRoutePlanOption.mCityName == null || transitRoutePlanOption.mTo == null || transitRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: route plan option,origin or destination or city can not be null");
        }
        return this.a.a(transitRoutePlanOption);
    }

    public boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption) {
        if (this.a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (indoorRoutePlanOption == null || indoorRoutePlanOption.mTo == null || indoorRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
        }
        return this.a.a(indoorRoutePlanOption);
    }

    public boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption) {
        if (this.a == null) {
            throw new IllegalStateException("BDMapSDKException: RoutePlanSearch is null, please call newInstance() first.");
        }
        if (walkingRoutePlanOption == null || walkingRoutePlanOption.mTo == null || walkingRoutePlanOption.mFrom == null) {
            throw new IllegalArgumentException("BDMapSDKException: option , origin or destination can not be null");
        }
        return this.a.a(walkingRoutePlanOption);
    }
}
