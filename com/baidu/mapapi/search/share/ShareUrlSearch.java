package com.baidu.mapapi.search.share;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.l;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.platform.core.e.h;
/* loaded from: classes15.dex */
public class ShareUrlSearch extends l {

    /* renamed from: b  reason: collision with root package name */
    private boolean f3057b = false;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.platform.core.e.a f3056a = new h();

    ShareUrlSearch() {
    }

    private boolean a(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static ShareUrlSearch newInstance() {
        BMapManager.init();
        return new ShareUrlSearch();
    }

    public void destroy() {
        if (this.f3057b) {
            return;
        }
        this.f3057b = true;
        this.f3056a.a();
        BMapManager.destroy();
    }

    public boolean requestLocationShareUrl(LocationShareURLOption locationShareURLOption) {
        if (this.f3056a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (locationShareURLOption == null || locationShareURLOption.mLocation == null || locationShareURLOption.mName == null || locationShareURLOption.mSnippet == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or name or snippet  can not be null");
        }
        return this.f3056a.a(locationShareURLOption);
    }

    public boolean requestPoiDetailShareUrl(PoiDetailShareURLOption poiDetailShareURLOption) {
        if (this.f3056a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (poiDetailShareURLOption == null || poiDetailShareURLOption.mUid == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or uid can not be null");
        }
        return this.f3056a.a(poiDetailShareURLOption);
    }

    public boolean requestRouteShareUrl(RouteShareURLOption routeShareURLOption) {
        if (this.f3056a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (routeShareURLOption == null) {
            throw new IllegalArgumentException("BDMapSDKException: option is null");
        }
        if (routeShareURLOption.getmMode().ordinal() < 0) {
            return false;
        }
        if (routeShareURLOption.mFrom == null || routeShareURLOption.mTo == null) {
            throw new IllegalArgumentException("BDMapSDKException: start or end point can not be null");
        }
        if (routeShareURLOption.mMode == RouteShareURLOption.RouteShareMode.BUS_ROUTE_SHARE_MODE) {
            if ((routeShareURLOption.mFrom.getLocation() == null || routeShareURLOption.mTo.getLocation() == null) && routeShareURLOption.mCityCode < 0) {
                throw new IllegalArgumentException("BDMapSDKException: city code can not be null if don't set start or end point");
            }
        } else if (routeShareURLOption.mFrom.getLocation() == null && !a(routeShareURLOption.mFrom.getCity())) {
            throw new IllegalArgumentException("BDMapSDKException: start cityCode must be set if not set start location");
        } else {
            if (routeShareURLOption.mTo.getLocation() == null && !a(routeShareURLOption.mTo.getCity())) {
                throw new IllegalArgumentException("BDMapSDKException: end cityCode must be set if not set end location");
            }
        }
        return this.f3056a.a(routeShareURLOption);
    }

    public void setOnGetShareUrlResultListener(OnGetShareUrlResultListener onGetShareUrlResultListener) {
        if (this.f3056a == null) {
            throw new IllegalStateException("BDMapSDKException: searcher has been destroyed");
        }
        if (onGetShareUrlResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        this.f3056a.a(onGetShareUrlResultListener);
    }
}
