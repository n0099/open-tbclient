package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes12.dex */
public class a {
    private static a dng;
    private RoutePlanSearch dnf;

    public static a aFO() {
        if (dng == null) {
            synchronized (a.class) {
                if (dng == null) {
                    dng = new a();
                }
            }
        }
        return dng;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.dnf = RoutePlanSearch.newInstance();
            this.dnf.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.dnf.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aFP() {
        if (this.dnf != null) {
            this.dnf.destroy();
        }
    }
}
