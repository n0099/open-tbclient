package com.baidu.mapapi.walknavi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.map.VersionInfo;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.e.c;
/* loaded from: classes4.dex */
public class WalkNavigateHelper {
    private static WalkNavigateHelper d;
    private com.baidu.mapapi.walknavi.controllers.a.a a = new com.baidu.mapapi.walknavi.controllers.a.a();
    private boolean b;
    private Activity c;

    private WalkNavigateHelper() {
    }

    public static WalkNavigateHelper getInstance() {
        if (d == null) {
            d = new WalkNavigateHelper();
        }
        return d;
    }

    public void initNaviEngine(Activity activity, IWEngineInitListener iWEngineInitListener) {
        if (this.a != null) {
            this.a.a(activity, iWEngineInitListener);
        }
    }

    public void routePlanWithParams(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        if (this.a != null) {
            if (!this.a.a()) {
                throw new com.baidu.mapapi.walknavi.controllers.a("naviengine init failed, please init naviengine first");
            }
            if (walkNaviLaunchParam == null || walkNaviLaunchParam.getStartPt() == null || walkNaviLaunchParam.getEndPt() == null) {
                throw new com.baidu.mapapi.walknavi.controllers.a("launch param or startPt or endPt cannot be null");
            }
            if (checkDistanceClose(walkNaviLaunchParam)) {
                throw new com.baidu.mapapi.walknavi.controllers.a("the distance is less than 30 meters");
            }
            if (checkDistanceLong(walkNaviLaunchParam)) {
                throw new com.baidu.mapapi.walknavi.controllers.a("the distance is longer than 50 kilometers");
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(walkNaviLaunchParam.getStartPt());
            GeoPoint ll2mc2 = CoordUtil.ll2mc(walkNaviLaunchParam.getEndPt());
            c create = WalkNaviLaunchParam.create();
            create.a(1);
            WNavigatorWrapper.getWNavigator().c(1);
            b.a().a(walkNaviLaunchParam.getStartPt());
            b.a().b(walkNaviLaunchParam.getEndPt());
            create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 131);
            create.b(0);
            create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{131});
            this.a.a(create, iWRoutePlanListener);
        }
    }

    public View onCreate(Activity activity) {
        if (this.a != null) {
            this.c = activity;
            return this.a.a(activity);
        }
        return null;
    }

    public boolean startWalkNavi(Activity activity) {
        if (b.a().a(activity, (Bundle) null)) {
            if (!this.b) {
                if (!b.a().l()) {
                    return false;
                }
                this.b = true;
            }
            return true;
        }
        return false;
    }

    public void switchWalkNaviMode(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        if (this.a != null) {
            this.a.a(activity, i, walkNaviModeSwitchListener);
        }
    }

    public void startCameraAndSetMapView(Activity activity) {
        this.a.b(activity);
    }

    private boolean checkDistanceClose(WalkNaviLaunchParam walkNaviLaunchParam) {
        Point ll2point = CoordUtil.ll2point(walkNaviLaunchParam.getStartPt());
        Point ll2point2 = CoordUtil.ll2point(walkNaviLaunchParam.getEndPt());
        return ll2point == null || ll2point2 == null || CoordUtil.getDistance(ll2point, ll2point2) < 30.0d;
    }

    private boolean checkDistanceLong(WalkNaviLaunchParam walkNaviLaunchParam) {
        Point ll2point = CoordUtil.ll2point(walkNaviLaunchParam.getStartPt());
        Point ll2point2 = CoordUtil.ll2point(walkNaviLaunchParam.getEndPt());
        return ll2point == null || ll2point2 == null || CoordUtil.getDistance(ll2point, ll2point2) > 50000.0d;
    }

    public void setRouteGuidanceListener(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        if (iWRouteGuidanceListener != null) {
            this.a.a(activity, iWRouteGuidanceListener);
        }
    }

    public void setWalkNaviStatusListener(IWNaviStatusListener iWNaviStatusListener) {
        b.a().a(iWNaviStatusListener);
    }

    public void setTTsPlayer(IWTTSPlayer iWTTSPlayer) {
        if (this.a != null) {
            this.a.a(iWTTSPlayer);
        }
    }

    public void pause() {
        b.a().f();
        if (this.a != null) {
            this.a.b();
        }
    }

    public void resume() {
        if (this.c != null && !this.c.isFinishing()) {
            b.a().e();
            if (this.a != null) {
                this.a.c();
            }
        }
    }

    public void quit() {
        b.a().k();
        b.a().r();
        b.a().g();
        if (this.a != null) {
            this.a.d();
        }
        this.b = false;
        this.c = null;
    }

    static {
        if (!a.a().equals(VersionInfo.getApiVersion())) {
            throw new BaiduMapSDKException("the version of bikenavi is not match with map");
        }
        if (VersionInfo.KIT_NAME.compareToIgnoreCase(VersionInfo.KIT_NAME) != 0) {
        }
        NativeLoader.getInstance().loadLibrary(a.b());
    }
}
