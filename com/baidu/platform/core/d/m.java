package com.baidu.platform.core.d;

import com.baidu.ar.util.IoUtils;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
/* loaded from: classes4.dex */
public class m extends com.baidu.platform.base.e {
    public m(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.a.a("qt", "bus");
        this.a.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.a.a("ie", IoUtils.UTF_8);
        this.a.a("lrn", "20");
        this.a.a("version", "3");
        this.a.a("rp_format", NetworkDef.DataType.JSON);
        this.a.a("rp_filter", ScopeInfo.SCOPE_ID_MOBILE);
        this.a.a("ic_info", "2");
        this.a.a("exptype", "depall");
        this.a.a("sn", a(transitRoutePlanOption.mFrom));
        this.a.a(com.baidu.fsg.base.statistics.h.a, a(transitRoutePlanOption.mTo));
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
