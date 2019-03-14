package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes5.dex */
public class a {
    private static a bjq;
    private RoutePlanSearch bjp;

    public static a QR() {
        if (bjq == null) {
            synchronized (a.class) {
                if (bjq == null) {
                    bjq = new a();
                }
            }
        }
        return bjq;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.bjp = RoutePlanSearch.newInstance();
            this.bjp.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.bjp.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void QS() {
        if (this.bjp != null) {
            this.bjp.destroy();
        }
    }
}
