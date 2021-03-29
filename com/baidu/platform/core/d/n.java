package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes2.dex */
public class n extends com.baidu.platform.base.e {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.f9821a.a("qt", "bus");
        com.baidu.platform.util.a aVar = this.f9821a;
        aVar.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.f9821a.a("ie", "utf-8");
        this.f9821a.a("lrn", "20");
        this.f9821a.a("version", "3");
        this.f9821a.a("rp_format", "json");
        this.f9821a.a("rp_filter", "mobile");
        this.f9821a.a("ic_info", "2");
        this.f9821a.a("exptype", "depall");
        this.f9821a.a(IXAdRequestInfo.SN, a(transitRoutePlanOption.mFrom));
        this.f9821a.a("en", a(transitRoutePlanOption.mTo));
        String str = transitRoutePlanOption.mCityName;
        if (str != null) {
            this.f9821a.a("c", str);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.f9821a.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.h();
    }
}
