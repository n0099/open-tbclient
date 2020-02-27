package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes12.dex */
public class a {
    private static a cye;
    private RoutePlanSearch cyd;

    public static a asB() {
        if (cye == null) {
            synchronized (a.class) {
                if (cye == null) {
                    cye = new a();
                }
            }
        }
        return cye;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.cyd = RoutePlanSearch.newInstance();
            this.cyd.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.cyd.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void asC() {
        if (this.cyd != null) {
            this.cyd.destroy();
        }
    }
}
