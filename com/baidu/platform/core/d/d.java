package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import java.util.List;
/* loaded from: classes15.dex */
public class d extends com.baidu.platform.base.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        PlanNode planNode;
        this.f4177a.a("qt", "cars");
        this.f4177a.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
        this.f4177a.a("ie", "utf-8");
        this.f4177a.a("lrn", "20");
        this.f4177a.a("version", "6");
        this.f4177a.a("extinfo", "32");
        this.f4177a.a("mrs", "1");
        this.f4177a.a("rp_format", "json");
        this.f4177a.a("rp_filter", "mobile");
        this.f4177a.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
        this.f4177a.a(IXAdRequestInfo.SN, a(drivingRoutePlanOption.mFrom));
        this.f4177a.a(com.baidu.fsg.base.statistics.h.f1996a, a(drivingRoutePlanOption.mTo));
        if (drivingRoutePlanOption.mCityName != null) {
            this.f4177a.a("c", drivingRoutePlanOption.mCityName);
        }
        if (drivingRoutePlanOption.mFrom != null) {
            this.f4177a.a(Config.STAT_SDK_CHANNEL, drivingRoutePlanOption.mFrom.getCity());
        }
        if (drivingRoutePlanOption.mTo != null) {
            this.f4177a.a("ec", drivingRoutePlanOption.mTo.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str = new String();
        String str2 = new String();
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.f4177a.a("wp", str);
                this.f4177a.a("wpc", str2);
                return;
            }
            if (list.get(i2) != null) {
                str = str + a(planNode);
                str2 = str2 + planNode.getCity();
                if (i2 != list.size() - 1) {
                    str = str + "|";
                    str2 = str2 + "|";
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.i();
    }
}
