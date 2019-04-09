package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes5.dex */
public class a {
    private static a bju;
    private RoutePlanSearch bjt;

    public static a QP() {
        if (bju == null) {
            synchronized (a.class) {
                if (bju == null) {
                    bju = new a();
                }
            }
        }
        return bju;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.bjt = RoutePlanSearch.newInstance();
            this.bjt.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.bjt.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void QQ() {
        if (this.bjt != null) {
            this.bjt.destroy();
        }
    }
}
