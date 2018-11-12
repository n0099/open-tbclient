package com.baidu.searchbox.ng.ai.apps.impl.map.utils;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
/* loaded from: classes4.dex */
public class DrivingRoutePlanManager {
    private static DrivingRoutePlanManager mInstance;
    private RoutePlanSearch mSearch;

    public static DrivingRoutePlanManager getInstance() {
        if (mInstance == null) {
            synchronized (DrivingRoutePlanManager.class) {
                if (mInstance == null) {
                    mInstance = new DrivingRoutePlanManager();
                }
            }
        }
        return mInstance;
    }

    public void startRoutePlan(LatLng latLng, LatLng latLng2, OnGetRoutePlanResultListener onGetRoutePlanResultListener) {
        if (latLng != null && latLng2 != null && onGetRoutePlanResultListener != null) {
            this.mSearch = RoutePlanSearch.newInstance();
            this.mSearch.setOnGetRoutePlanResultListener(onGetRoutePlanResultListener);
            PlanNode withLocation = PlanNode.withLocation(latLng);
            this.mSearch.drivingSearch(new DrivingRoutePlanOption().from(withLocation).to(PlanNode.withLocation(latLng2)));
        }
    }

    public void destorySearch() {
        if (this.mSearch != null) {
            this.mSearch.destroy();
        }
    }
}
