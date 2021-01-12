package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes8.dex */
public class a {
    private static a epg;
    private RoutePlanSearch epf;

    public static a bbh() {
        if (epg == null) {
            synchronized (a.class) {
                if (epg == null) {
                    epg = new a();
                }
            }
        }
        return epg;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.epf = RoutePlanSearch.newInstance();
            this.epf.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.epf.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void bbi() {
        if (this.epf != null) {
            this.epf.destroy();
        }
    }
}
