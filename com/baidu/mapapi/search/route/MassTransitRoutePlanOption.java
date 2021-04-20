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
        public int f7327a;

        TacticsIncity(int i) {
            this.f7327a = 0;
            this.f7327a = i;
        }

        public int getInt() {
            return this.f7327a;
        }
    }

    /* loaded from: classes2.dex */
    public enum TacticsIntercity {
        ETRANS_LEAST_TIME(0),
        ETRANS_START_EARLY(1),
        ETRANS_LEAST_PRICE(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7329a;

        TacticsIntercity(int i) {
            this.f7329a = 0;
            this.f7329a = i;
        }

        public int getInt() {
            return this.f7329a;
        }
    }

    /* loaded from: classes2.dex */
    public enum TransTypeIntercity {
        ETRANS_TRAIN_FIRST(0),
        ETRANS_PLANE_FIRST(1),
        ETRANS_COACH_FIRST(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f7331a;

        TransTypeIntercity(int i) {
            this.f7331a = 0;
            this.f7331a = i;
        }

        public int getInt() {
            return this.f7331a;
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

    public MassTransitRoutePlanOption pageIndex(int i) {
        if (i >= 0 && i <= 2147483646) {
            this.mPageIndex = i + 1;
        }
        return this;
    }

    public MassTransitRoutePlanOption pageSize(int i) {
        if (i >= 1 && i <= 10) {
            this.mPageSize = i;
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
