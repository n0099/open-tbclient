package com.baidu.swan.impl.map.f;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes19.dex */
public class a {
    private static a dDg;
    private RoutePlanSearch dDf;

    public static a aSv() {
        if (dDg == null) {
            synchronized (a.class) {
                if (dDg == null) {
                    dDg = new a();
                }
            }
        }
        return dDg;
    }

    public void a(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.dDf = RoutePlanSearch.newInstance();
            this.dDf.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.dDf.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void aSw() {
        if (this.dDf != null) {
            this.dDf.destroy();
        }
    }
}
