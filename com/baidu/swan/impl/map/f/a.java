package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes25.dex */
public class a {
    private static a dZE;
    private RoutePlanSearch dZD;

    public static a aXJ() {
        if (dZE == null) {
            synchronized (a.class) {
                if (dZE == null) {
                    dZE = new a();
                }
            }
        }
        return dZE;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.dZD = RoutePlanSearch.newInstance();
            this.dZD.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.dZD.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aXK() {
        if (this.dZD != null) {
            this.dZD.destroy();
        }
    }
}
