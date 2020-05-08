package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes12.dex */
public class a {
    private static a cXt;
    private RoutePlanSearch cXs;

    public static a aAQ() {
        if (cXt == null) {
            synchronized (a.class) {
                if (cXt == null) {
                    cXt = new a();
                }
            }
        }
        return cXt;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.cXs = RoutePlanSearch.newInstance();
            this.cXs.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.cXs.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aAR() {
        if (this.cXs != null) {
            this.cXs.destroy();
        }
    }
}
