package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes19.dex */
public class a {
    private static a dtc;
    private RoutePlanSearch dtb;

    public static a aJF() {
        if (dtc == null) {
            synchronized (a.class) {
                if (dtc == null) {
                    dtc = new a();
                }
            }
        }
        return dtc;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.dtb = RoutePlanSearch.newInstance();
            this.dtb.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.dtb.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aJG() {
        if (this.dtb != null) {
            this.dtb.destroy();
        }
    }
}
