package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes15.dex */
public class n extends com.baidu.platform.base.e {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.f4177a.a("qt", "bus");
        this.f4177a.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.f4177a.a("ie", "utf-8");
        this.f4177a.a("lrn", "20");
        this.f4177a.a("version", "3");
        this.f4177a.a("rp_format", "json");
        this.f4177a.a("rp_filter", "mobile");
        this.f4177a.a("ic_info", "2");
        this.f4177a.a("exptype", "depall");
        this.f4177a.a(IXAdRequestInfo.SN, a(transitRoutePlanOption.mFrom));
        this.f4177a.a(com.baidu.fsg.base.statistics.h.f1996a, a(transitRoutePlanOption.mTo));
        if (transitRoutePlanOption.mCityName != null) {
            this.f4177a.a("c", transitRoutePlanOption.mCityName);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.f4177a.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.h();
    }
}
