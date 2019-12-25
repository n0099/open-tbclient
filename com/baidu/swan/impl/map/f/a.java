package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes9.dex */
public class a {
    private static a ctT;
    private RoutePlanSearch ctS;

    public static a apU() {
        if (ctT == null) {
            synchronized (a.class) {
                if (ctT == null) {
                    ctT = new a();
                }
            }
        }
        return ctT;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.ctS = RoutePlanSearch.newInstance();
            this.ctS.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.ctS.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void apV() {
        if (this.ctS != null) {
            this.ctS.destroy();
        }
    }
}
