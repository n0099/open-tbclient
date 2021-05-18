package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
/* loaded from: classes2.dex */
public class p extends com.baidu.platform.base.e {
    public p(WalkingRoutePlanOption walkingRoutePlanOption) {
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.f9352a.a("qt", "walk2");
        this.f9352a.a(IAdRequestParam.SN, a(walkingRoutePlanOption.mFrom));
        this.f9352a.a("en", a(walkingRoutePlanOption.mTo));
        PlanNode planNode = walkingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.f9352a.a(Config.STAT_SDK_CHANNEL, planNode.getCity());
        }
        PlanNode planNode2 = walkingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.f9352a.a("ec", planNode2.getCity());
        }
        this.f9352a.a("ie", "utf-8");
        this.f9352a.a("lrn", "20");
        this.f9352a.a("version", "3");
        this.f9352a.a("rp_format", "json");
        this.f9352a.a("rp_filter", "mobile");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.k();
    }
}
