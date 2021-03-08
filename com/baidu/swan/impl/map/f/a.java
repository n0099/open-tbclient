package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes8.dex */
public class a {
    private static a esO;
    private RoutePlanSearch esN;

    public static a bbw() {
        if (esO == null) {
            synchronized (a.class) {
                if (esO == null) {
                    esO = new a();
                }
            }
        }
        return esO;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.esN = RoutePlanSearch.newInstance();
            this.esN.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.esN.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void bbx() {
        if (this.esN != null) {
            this.esN.destroy();
        }
    }
}
