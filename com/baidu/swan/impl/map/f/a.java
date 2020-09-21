package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes24.dex */
public class a {
    private static a dFh;
    private RoutePlanSearch dFg;

    public static a aTh() {
        if (dFh == null) {
            synchronized (a.class) {
                if (dFh == null) {
                    dFh = new a();
                }
            }
        }
        return dFh;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.dFg = RoutePlanSearch.newInstance();
            this.dFg.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.dFg.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aTi() {
        if (this.dFg != null) {
            this.dFg.destroy();
        }
    }
}
