package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.sapi2.result.AddressManageResult;
/* loaded from: classes5.dex */
public class n extends com.baidu.platform.base.e {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.a.a("qt", "bus");
        this.a.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.a.a("ie", "utf-8");
        this.a.a("lrn", "20");
        this.a.a("version", "3");
        this.a.a("rp_format", "json");
        this.a.a("rp_filter", AddressManageResult.KEY_MOBILE);
        this.a.a("ic_info", "2");
        this.a.a("exptype", "depall");
        this.a.a(IXAdRequestInfo.SN, a(transitRoutePlanOption.mFrom));
        this.a.a("en", a(transitRoutePlanOption.mTo));
        if (transitRoutePlanOption.mCityName != null) {
            this.a.a("c", transitRoutePlanOption.mCityName);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.a.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.h();
    }
}
