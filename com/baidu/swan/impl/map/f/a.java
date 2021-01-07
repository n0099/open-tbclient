package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes9.dex */
public class a {
    private static a etU;
    private RoutePlanSearch etT;

    public static a bfb() {
        if (etU == null) {
            synchronized (a.class) {
                if (etU == null) {
                    etU = new a();
                }
            }
        }
        return etU;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.etT = RoutePlanSearch.newInstance();
            this.etT.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.etT.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void bfc() {
        if (this.etT != null) {
            this.etT.destroy();
        }
    }
}
