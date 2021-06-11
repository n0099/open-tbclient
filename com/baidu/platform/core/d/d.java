package com.baidu.platform.core.d;

import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.base.e {
    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        PlanNode planNode;
        this.f9309a.a("qt", "cars");
        this.f9309a.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
        this.f9309a.a("ie", "utf-8");
        this.f9309a.a("lrn", "20");
        this.f9309a.a("version", "6");
        this.f9309a.a("extinfo", EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS);
        this.f9309a.a("mrs", "1");
        this.f9309a.a("rp_format", "json");
        this.f9309a.a("rp_filter", "mobile");
        this.f9309a.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
        this.f9309a.a(IAdRequestParam.SN, a(drivingRoutePlanOption.mFrom));
        this.f9309a.a("en", a(drivingRoutePlanOption.mTo));
        String str = drivingRoutePlanOption.mCityName;
        if (str != null) {
            this.f9309a.a("c", str);
        }
        PlanNode planNode2 = drivingRoutePlanOption.mFrom;
        if (planNode2 != null) {
            this.f9309a.a(Config.STAT_SDK_CHANNEL, planNode2.getCity());
        }
        PlanNode planNode3 = drivingRoutePlanOption.mTo;
        if (planNode3 != null) {
            this.f9309a.a("ec", planNode3.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str2 = new String();
        String str3 = new String();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2) != null) {
                    str2 = str2 + a(planNode);
                    str3 = str3 + planNode.getCity();
                    if (i2 != list.size() - 1) {
                        str3 = str3 + "|";
                        str2 = str2 + "|";
                    }
                }
            }
            this.f9309a.a("wp", str2);
            this.f9309a.a("wpc", str3);
        }
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.i();
    }
}
