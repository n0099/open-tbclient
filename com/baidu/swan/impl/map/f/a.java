package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes25.dex */
public class a {
    private static a dRi;
    private RoutePlanSearch dRh;

    public static a aVQ() {
        if (dRi == null) {
            synchronized (a.class) {
                if (dRi == null) {
                    dRi = new a();
                }
            }
        }
        return dRi;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.dRh = RoutePlanSearch.newInstance();
            this.dRh.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.dRh.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aVR() {
        if (this.dRh != null) {
            this.dRh.destroy();
        }
    }
}
