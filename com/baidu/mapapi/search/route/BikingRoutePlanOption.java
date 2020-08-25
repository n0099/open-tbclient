package com.baidu.mapapi.search.route;
/* loaded from: classes20.dex */
public class BikingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public int mRidingType = 0;

    public BikingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public BikingRoutePlanOption ridingType(int i) {
        this.mRidingType = i;
        return this;
    }

    public BikingRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
