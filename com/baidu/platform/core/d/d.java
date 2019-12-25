package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.platform.base.e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        PlanNode planNode;
        this.a.a("qt", "cars");
        this.a.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
        this.a.a("ie", "utf-8");
        this.a.a("lrn", "20");
        this.a.a("version", "6");
        this.a.a("extinfo", "32");
        this.a.a("mrs", "1");
        this.a.a("rp_format", "json");
        this.a.a("rp_filter", "mobile");
        this.a.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
        this.a.a(IXAdRequestInfo.SN, a(drivingRoutePlanOption.mFrom));
        this.a.a(com.baidu.fsg.base.statistics.h.a, a(drivingRoutePlanOption.mTo));
        if (drivingRoutePlanOption.mCityName != null) {
            this.a.a("c", drivingRoutePlanOption.mCityName);
        }
        if (drivingRoutePlanOption.mFrom != null) {
            this.a.a(Config.STAT_SDK_CHANNEL, drivingRoutePlanOption.mFrom.getCity());
        }
        if (drivingRoutePlanOption.mTo != null) {
            this.a.a("ec", drivingRoutePlanOption.mTo.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str = new String();
        String str2 = new String();
        if (list == null) {
            return;
        }
        int i = 0;
        String str3 = str;
        String str4 = str2;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.a.a("wp", str3);
                this.a.a("wpc", str4);
                return;
            }
            if (list.get(i2) != null) {
                str3 = str3 + a(planNode);
                str4 = str4 + planNode.getCity();
                if (i2 != list.size() - 1) {
                    str3 = str3 + "|";
                    str4 = str4 + "|";
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
