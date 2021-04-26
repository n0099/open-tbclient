package com.baidu.mapapi.search.route;
/* loaded from: classes2.dex */
public class BikingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public int mRidingType = 0;

    public BikingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public BikingRoutePlanOption ridingType(int i2) {
        this.mRidingType = i2;
        return this;
    }

    public BikingRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
