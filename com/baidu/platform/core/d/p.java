package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
/* loaded from: classes4.dex */
public class p extends com.baidu.platform.base.e {
    public p(WalkingRoutePlanOption walkingRoutePlanOption) {
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.f2867a.a("qt", "walk2");
        this.f2867a.a(IXAdRequestInfo.SN, a(walkingRoutePlanOption.mFrom));
        this.f2867a.a(com.baidu.fsg.base.statistics.h.f1535a, a(walkingRoutePlanOption.mTo));
        if (walkingRoutePlanOption.mFrom != null) {
            this.f2867a.a(Config.STAT_SDK_CHANNEL, walkingRoutePlanOption.mFrom.getCity());
        }
        if (walkingRoutePlanOption.mTo != null) {
            this.f2867a.a("ec", walkingRoutePlanOption.mTo.getCity());
        }
        this.f2867a.a("ie", "utf-8");
        this.f2867a.a("lrn", "20");
        this.f2867a.a("version", "3");
        this.f2867a.a("rp_format", "json");
        this.f2867a.a("rp_filter", "mobile");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.k();
    }
}
