package com.baidu.mapapi.search.route;
/* loaded from: classes4.dex */
public class TransitRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public String mCityName = null;
    public TransitPolicy mPolicy = TransitPolicy.EBUS_TIME_FIRST;

    /* loaded from: classes4.dex */
    public enum TransitPolicy {
        EBUS_TIME_FIRST(0),
        EBUS_TRANSFER_FIRST(2),
        EBUS_WALK_FIRST(3),
        EBUS_NO_SUBWAY(4);
        
        private int a;

        TransitPolicy(int i) {
            this.a = 0;
            this.a = i;
        }

        public int getInt() {
            return this.a;
        }
    }

    public TransitRoutePlanOption city(String str) {
        this.mCityName = str;
        return this;
    }

    public TransitRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public TransitRoutePlanOption policy(TransitPolicy transitPolicy) {
        this.mPolicy = transitPolicy;
        return this;
    }

    public TransitRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
