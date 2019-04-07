package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes5.dex */
public class a {
    private static a bjt;
    private RoutePlanSearch bjs;

    public static a QP() {
        if (bjt == null) {
            synchronized (a.class) {
                if (bjt == null) {
                    bjt = new a();
                }
            }
        }
        return bjt;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.bjs = RoutePlanSearch.newInstance();
            this.bjs.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.bjs.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void QQ() {
        if (this.bjs != null) {
            this.bjs.destroy();
        }
    }
}
