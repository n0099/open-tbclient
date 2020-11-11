package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes7.dex */
public class n extends com.baidu.platform.base.e {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.f2816a.a("qt", "bus");
        this.f2816a.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.f2816a.a("ie", "utf-8");
        this.f2816a.a("lrn", "20");
        this.f2816a.a("version", "3");
        this.f2816a.a("rp_format", "json");
        this.f2816a.a("rp_filter", "mobile");
        this.f2816a.a("ic_info", "2");
        this.f2816a.a("exptype", "depall");
        this.f2816a.a(IXAdRequestInfo.SN, a(transitRoutePlanOption.mFrom));
        this.f2816a.a(com.baidu.fsg.base.statistics.h.f1495a, a(transitRoutePlanOption.mTo));
        if (transitRoutePlanOption.mCityName != null) {
            this.f2816a.a("c", transitRoutePlanOption.mCityName);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.f2816a.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.h();
    }
}
