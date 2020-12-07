package com.baidu.platform.core.d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes26.dex */
public class g extends com.baidu.platform.base.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IndoorRoutePlanOption indoorRoutePlanOption) {
        a(indoorRoutePlanOption);
    }

    private void a(IndoorRoutePlanOption indoorRoutePlanOption) {
        this.f2818a.a("qt", "indoornavi");
        this.f2818a.a("rp_format", "json");
        this.f2818a.a("version", "1");
        GeoPoint ll2mc = CoordUtil.ll2mc(indoorRoutePlanOption.mFrom.getLocation());
        if (ll2mc != null) {
            this.f2818a.a(IXAdRequestInfo.SN, (String.format("%d,%d", Double.valueOf(ll2mc.getLongitudeE6()), Double.valueOf(ll2mc.getLatitudeE6())) + "|" + indoorRoutePlanOption.mFrom.getFloor()).replaceAll(" ", ""));
        }
        GeoPoint ll2mc2 = CoordUtil.ll2mc(indoorRoutePlanOption.mTo.getLocation());
        if (ll2mc2 != null) {
            this.f2818a.a(com.baidu.fsg.base.statistics.h.f1497a, (String.format("%d,%d", Double.valueOf(ll2mc2.getLongitudeE6()), Double.valueOf(ll2mc2.getLatitudeE6())) + "|" + indoorRoutePlanOption.mTo.getFloor()).replaceAll(" ", ""));
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.l();
    }
}
