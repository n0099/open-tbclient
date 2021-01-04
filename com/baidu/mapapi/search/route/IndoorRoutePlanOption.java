package com.baidu.mapapi.search.route;
/* loaded from: classes15.dex */
public class IndoorRoutePlanOption {
    public IndoorPlanNode mFrom = null;
    public IndoorPlanNode mTo = null;

    public IndoorRoutePlanOption from(IndoorPlanNode indoorPlanNode) {
        this.mFrom = indoorPlanNode;
        return this;
    }

    public IndoorRoutePlanOption to(IndoorPlanNode indoorPlanNode) {
        this.mTo = indoorPlanNode;
        return this;
    }
}
