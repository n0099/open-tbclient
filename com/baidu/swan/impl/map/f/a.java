package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes25.dex */
public class a {
    private static a efv;
    private RoutePlanSearch efu;

    public static a baj() {
        if (efv == null) {
            synchronized (a.class) {
                if (efv == null) {
                    efv = new a();
                }
            }
        }
        return efv;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.efu = RoutePlanSearch.newInstance();
            this.efu.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.efu.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void bak() {
        if (this.efu != null) {
            this.efu.destroy();
        }
    }
}
