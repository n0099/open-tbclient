package com.baidu.swan.impl.map.e;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes5.dex */
public class a {
    private static a bJt;
    private RoutePlanSearch bJs;

    public static a aam() {
        if (bJt == null) {
            synchronized (a.class) {
                if (bJt == null) {
                    bJt = new a();
                }
            }
        }
        return bJt;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.bJs = RoutePlanSearch.newInstance();
            this.bJs.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.bJs.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aan() {
        if (this.bJs != null) {
            this.bJs.destroy();
        }
    }
}
