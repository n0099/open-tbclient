package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes19.dex */
public class a {
    private static a dDc;
    private RoutePlanSearch dDb;

    public static a aSv() {
        if (dDc == null) {
            synchronized (a.class) {
                if (dDc == null) {
                    dDc = new a();
                }
            }
        }
        return dDc;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.dDb = RoutePlanSearch.newInstance();
            this.dDb.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.dDb.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aSw() {
        if (this.dDb != null) {
            this.dDb.destroy();
        }
    }
}
