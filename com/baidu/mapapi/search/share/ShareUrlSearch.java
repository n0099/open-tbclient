package com.baidu.mapapi.search.share;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.l;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.core.e.h;
/* loaded from: classes2.dex */
public class ShareUrlSearch extends l {

    /* renamed from: b  reason: collision with root package name */
    public boolean f7337b = false;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.platform.core.e.a f7336a = new h();

    private boolean a(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static ShareUrlSearch newInstance() {
        BMapManager.init();
        return new ShareUrlSearch();
    }

    public void destroy() {
        if (this.f7337b) {
            return;
        }
        this.f7337b = true;
        this.f7336a.a();
        BMapManager.destroy();
    }

    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        com.baidu.platform.core.e.a aVar = this.f7336a;
        if (aVar != null) {
            if (locationShareURLOption == null || locationShareURLOption.mLocation == null || locationShareURLOption.mName == null || locationShareURLOption.mSnippet == null) {
                throw new IllegalArgumentException("option or name or snippet  can not be null");
            }
            return aVar.a(locationShareURLOption);
        }
        throw new IllegalStateException("searcher has been destroyed");
    }

    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        com.baidu.platform.core.e.a aVar = this.f7336a;
        if (aVar != null) {
            if (poiDetailShareURLOption == null || poiDetailShareURLOption.mUid == null) {
                throw new IllegalArgumentException("option or uid can not be null");
            }
            return aVar.a(poiDetailShareURLOption);
        }
        throw new IllegalStateException("searcher has been destroyed");
    }

    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        if (this.f7336a != null) {
            if (routeShareURLOption != null) {
                if (routeShareURLOption.getmMode().ordinal() < 0) {
                    return false;
                }
                PlanNode planNode = routeShareURLOption.mFrom;
                if (planNode == null || routeShareURLOption.mTo == null) {
                    throw new IllegalArgumentException("start or end point can not be null");
                }
                RouteShareURLOption.RouteShareMode routeShareMode = routeShareURLOption.mMode;
                RouteShareURLOption.RouteShareMode routeShareMode2 = RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE;
                LatLng location = planNode.getLocation();
                if (routeShareMode == routeShareMode2) {
                    if ((location == null || routeShareURLOption.mTo.getLocation() == null) && routeShareURLOption.mCityCode < 0) {
                        throw new IllegalArgumentException("city code can not be null if don't set start or end point");
                    }
                } else if (location == null && !a(routeShareURLOption.mFrom.getCity())) {
                    throw new IllegalArgumentException("start cityCode must be set if not set start location");
                } else {
                    if (routeShareURLOption.mTo.getLocation() == null && !a(routeShareURLOption.mTo.getCity())) {
                        throw new IllegalArgumentException("end cityCode must be set if not set end location");
                    }
                }
                return this.f7336a.a(routeShareURLOption);
            }
            throw new IllegalArgumentException("option is null");
        }
        throw new IllegalStateException("searcher has been destroyed");
    }

    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        com.baidu.platform.core.e.a aVar = this.f7336a;
        if (aVar == null) {
            throw new IllegalStateException("searcher has been destroyed");
        }
        if (onGetShareUrlResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        aVar.a(onGetShareUrlResultListener);
    }
}
