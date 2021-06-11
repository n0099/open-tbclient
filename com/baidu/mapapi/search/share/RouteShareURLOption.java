package com.baidu.mapapi.search.share;

import com.baidu.mapapi.search.route.PlanNode;
/* loaded from: classes2.dex */
public class RouteShareURLOption {
    public RouteShareMode mMode;
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public int mPn = 0;
    public int mCityCode = -1;

    /* loaded from: classes2.dex */
    public enum RouteShareMode {
        CAR_ROUTE_SHARE_MODE(0),
        FOOT_ROUTE_SHARE_MODE(1),
        CYCLE_ROUTE_SHARE_MODE(2),
        BUS_ROUTE_SHARE_MODE(3);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7391a;

        RouteShareMode(int i2) {
            this.f7391a = -1;
            this.f7391a = i2;
        }

        public int getRouteShareMode() {
            return this.f7391a;
        }
    }

    public RouteShareURLOption cityCode(int i2) {
        this.mCityCode = i2;
        return this;
    }

    public RouteShareURLOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public RouteShareMode getmMode() {
        return this.mMode;
    }

    public RouteShareURLOption pn(int i2) {
        this.mPn = i2;
        return this;
    }

    public RouteShareURLOption routMode(RouteShareMode routeShareMode) {
        this.mMode = routeShareMode;
        return this;
    }

    public RouteShareURLOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
