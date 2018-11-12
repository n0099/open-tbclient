package com.baidu.platform.core.d;

import com.baidu.ar.util.IoUtils;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
/* loaded from: classes4.dex */
public class o extends com.baidu.platform.base.e {
    public o(WalkingRoutePlanOption walkingRoutePlanOption) {
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.a.a("qt", "walk2");
        this.a.a("sn", a(walkingRoutePlanOption.mFrom));
        this.a.a(com.baidu.fsg.base.statistics.h.a, a(walkingRoutePlanOption.mTo));
        if (walkingRoutePlanOption.mFrom != null) {
            this.a.a(Config.STAT_SDK_CHANNEL, walkingRoutePlanOption.mFrom.getCity());
        }
        if (walkingRoutePlanOption.mTo != null) {
            this.a.a("ec", walkingRoutePlanOption.mTo.getCity());
        }
        this.a.a("ie", IoUtils.UTF_8);
        this.a.a("lrn", "20");
        this.a.a("version", "3");
        this.a.a("rp_format", NetworkDef.DataType.JSON);
        this.a.a("rp_filter", ScopeInfo.SCOPE_ID_MOBILE);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.k();
    }
}
