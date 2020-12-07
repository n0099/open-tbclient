package com.baidu.mapapi.search.route;
/* loaded from: classes26.dex */
public class WalkingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;

    public WalkingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public WalkingRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
