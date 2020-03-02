package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes12.dex */
public class a {
    private static a cyf;
    private RoutePlanSearch cye;

    public static a asD() {
        if (cyf == null) {
            synchronized (a.class) {
                if (cyf == null) {
                    cyf = new a();
                }
            }
        }
        return cyf;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.cye = RoutePlanSearch.newInstance();
            this.cye.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.cye.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void asE() {
        if (this.cye != null) {
            this.cye.destroy();
        }
    }
}
