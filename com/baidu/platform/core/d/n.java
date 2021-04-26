package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes2.dex */
public class n extends com.baidu.platform.base.e {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.f9730a.a("qt", "bus");
        com.baidu.platform.util.a aVar = this.f9730a;
        aVar.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.f9730a.a("ie", "utf-8");
        this.f9730a.a("lrn", "20");
        this.f9730a.a("version", "3");
        this.f9730a.a("rp_format", "json");
        this.f9730a.a("rp_filter", "mobile");
        this.f9730a.a("ic_info", "2");
        this.f9730a.a("exptype", "depall");
        this.f9730a.a(IAdRequestParam.SN, a(transitRoutePlanOption.mFrom));
        this.f9730a.a("en", a(transitRoutePlanOption.mTo));
        String str = transitRoutePlanOption.mCityName;
        if (str != null) {
            this.f9730a.a("c", str);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.f9730a.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.h();
    }
}
