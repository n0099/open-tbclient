package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes5.dex */
public class a {
    private static a bIC;
    private RoutePlanSearch bIB;

    public static a aak() {
        if (bIC == null) {
            synchronized (a.class) {
                if (bIC == null) {
                    bIC = new a();
                }
            }
        }
        return bIC;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.bIB = RoutePlanSearch.newInstance();
            this.bIB.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.bIB.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aal() {
        if (this.bIB != null) {
            this.bIB.destroy();
        }
    }
}
