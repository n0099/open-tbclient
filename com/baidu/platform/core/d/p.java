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
        this.a.a("qt", "walk2");
        this.a.a(IXAdRequestInfo.SN, a(walkingRoutePlanOption.mFrom));
        this.a.a(com.baidu.fsg.base.statistics.h.a, a(walkingRoutePlanOption.mTo));
        if (walkingRoutePlanOption.mFrom != null) {
            this.a.a(Config.STAT_SDK_CHANNEL, walkingRoutePlanOption.mFrom.getCity());
        }
        if (walkingRoutePlanOption.mTo != null) {
            this.a.a("ec", walkingRoutePlanOption.mTo.getCity());
        }
        this.a.a("ie", "utf-8");
        this.a.a("lrn", "20");
        this.a.a("version", "3");
        this.a.a("rp_format", "json");
        this.a.a("rp_filter", "mobile");
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.k();
    }
}
