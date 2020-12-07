package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes25.dex */
public class a {
    private static a ekP;
    private RoutePlanSearch ekO;

    public static a bcH() {
        if (ekP == null) {
            synchronized (a.class) {
                if (ekP == null) {
                    ekP = new a();
                }
            }
        }
        return ekP;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.ekO = RoutePlanSearch.newInstance();
            this.ekO.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.ekO.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void bcI() {
        if (this.ekO != null) {
            this.ekO.destroy();
        }
    }
}
