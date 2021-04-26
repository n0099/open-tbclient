package com.baidu.mapapi.search.route;
/* loaded from: classes2.dex */
public class MassTransitRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;
    public String mCoordType = "bd09ll";
    public TacticsIncity mTacticsIncity = TacticsIncity.ETRANS_SUGGEST;
    public TacticsIntercity mTacticsIntercity = TacticsIntercity.ETRANS_LEAST_TIME;
    public TransTypeIntercity mTransTypeIntercity = TransTypeIntercity.ETRANS_TRAIN_FIRST;
    public int mPageSize = 10;
    public int mPageIndex = 1;

    /* loaded from: classes2.dex */
    public enum TacticsIncity {
        ETRANS_SUGGEST(0),
        ETRANS_LEAST_TRANSFER(1),
        ETRANS_LEAST_WALK(2),
        ETRANS_NO_SUBWAY(3),
        ETRANS_LEAST_TIME(4),
        ETRANS_SUBWAY_FIRST(5);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7587a;

        TacticsIncity(int i2) {
            this.f7587a = 0;
            this.f7587a = i2;
        }

        public int getInt() {
            return this.f7587a;
        }
    }

    /* loaded from: classes2.dex */
    public enum TacticsIntercity {
        ETRANS_LEAST_TIME(0),
        ETRANS_START_EARLY(1),
        ETRANS_LEAST_PRICE(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7589a;

        TacticsIntercity(int i2) {
            this.f7589a = 0;
            this.f7589a = i2;
        }

        public int getInt() {
            return this.f7589a;
        }
    }

    /* loaded from: classes2.dex */
    public enum TransTypeIntercity {
        ETRANS_TRAIN_FIRST(0),
        ETRANS_PLANE_FIRST(1),
        ETRANS_COACH_FIRST(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7591a;

        TransTypeIntercity(int i2) {
            this.f7591a = 0;
            this.f7591a = i2;
        }

        public int getInt() {
            return this.f7591a;
        }
    }

    @Deprecated
    public MassTransitRoutePlanOption coordType(String str) {
        this.mCoordType = str;
        return this;
    }

    public MassTransitRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public MassTransitRoutePlanOption pageIndex(int i2) {
        if (i2 >= 0 && i2 <= 2147483646) {
            this.mPageIndex = i2 + 1;
        }
        return this;
    }

    public MassTransitRoutePlanOption pageSize(int i2) {
        if (i2 >= 1 && i2 <= 10) {
            this.mPageSize = i2;
        }
        return this;
    }

    public MassTransitRoutePlanOption tacticsIncity(TacticsIncity tacticsIncity) {
        this.mTacticsIncity = tacticsIncity;
        return this;
    }

    public MassTransitRoutePlanOption tacticsIntercity(TacticsIntercity tacticsIntercity) {
        this.mTacticsIntercity = tacticsIntercity;
        return this;
    }

    public MassTransitRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }

    public MassTransitRoutePlanOption transtypeintercity(TransTypeIntercity transTypeIntercity) {
        this.mTransTypeIntercity = transTypeIntercity;
        return this;
    }
}
