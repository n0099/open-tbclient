package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class p extends com.baidu.platform.base.e {
    public p(WalkingRoutePlanOption walkingRoutePlanOption) {
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.f4140a.a("qt", "walk2");
        this.f4140a.a(IXAdRequestInfo.SN, a(walkingRoutePlanOption.mFrom));
        this.f4140a.a(com.baidu.fsg.base.statistics.h.f1947a, a(walkingRoutePlanOption.mTo));
        if (walkingRoutePlanOption.mFrom != null) {
            this.f4140a.a(Config.STAT_SDK_CHANNEL, walkingRoutePlanOption.mFrom.getCity());
        }
        if (walkingRoutePlanOption.mTo != null) {
            this.f4140a.a("ec", walkingRoutePlanOption.mTo.getCity());
        }
        this.f4140a.a("ie", "utf-8");
        this.f4140a.a("lrn", "20");
        this.f4140a.a("version", "3");
        this.f4140a.a("rp_format", "json");
        this.f4140a.a("rp_filter", "mobile");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.k();
    }
}
