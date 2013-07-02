package com.baidu.mapapi;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class MKWalkingRouteResult {
    private MKPlanNode a;
    private MKPlanNode b;
    private ArrayList c;
    private MKRouteAddrResult d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MKPlanNode mKPlanNode) {
        this.a = mKPlanNode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MKRouteAddrResult mKRouteAddrResult) {
        this.d = mKRouteAddrResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList arrayList) {
        this.c = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(MKPlanNode mKPlanNode) {
        this.b = mKPlanNode;
    }

    public MKRouteAddrResult getAddrResult() {
        return this.d;
    }

    public MKPlanNode getEnd() {
        return this.b;
    }

    public int getNumPlan() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    public MKRoutePlan getPlan(int i) {
        if (this.c != null) {
            return (MKRoutePlan) this.c.get(i);
        }
        return null;
    }

    public MKPlanNode getStart() {
        return this.a;
    }
}
