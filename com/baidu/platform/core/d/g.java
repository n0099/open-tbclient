package com.baidu.platform.core.d;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes2.dex */
public class g extends com.baidu.platform.base.e {
    public g(IndoorRoutePlanOption indoorRoutePlanOption) {
        a(indoorRoutePlanOption);
    }

    private void a(IndoorRoutePlanOption indoorRoutePlanOption) {
        this.f9309a.a("qt", "indoornavi");
        this.f9309a.a("rp_format", "json");
        this.f9309a.a("version", "1");
        GeoPoint ll2mc = CoordUtil.ll2mc(indoorRoutePlanOption.mFrom.getLocation());
        if (ll2mc != null) {
            String format = String.format("%f,%f", Double.valueOf(ll2mc.getLongitudeE6()), Double.valueOf(ll2mc.getLatitudeE6()));
            this.f9309a.a(IAdRequestParam.SN, (format + "|" + indoorRoutePlanOption.mFrom.getFloor()).replaceAll(" ", ""));
        }
        GeoPoint ll2mc2 = CoordUtil.ll2mc(indoorRoutePlanOption.mTo.getLocation());
        if (ll2mc2 != null) {
            String format2 = String.format("%f,%f", Double.valueOf(ll2mc2.getLongitudeE6()), Double.valueOf(ll2mc2.getLatitudeE6()));
            this.f9309a.a("en", (format2 + "|" + indoorRoutePlanOption.mTo.getFloor()).replaceAll(" ", ""));
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.l();
    }
}
