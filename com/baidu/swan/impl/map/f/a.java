package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes10.dex */
public class a {
    private static a cue;
    private RoutePlanSearch cud;

    public static a aqn() {
        if (cue == null) {
            synchronized (a.class) {
                if (cue == null) {
                    cue = new a();
                }
            }
        }
        return cue;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.cud = RoutePlanSearch.newInstance();
            this.cud.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.cud.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aqo() {
        if (this.cud != null) {
            this.cud.destroy();
        }
    }
}
