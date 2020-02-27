package com.baidu.mapapi.bikenavi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.mapapi.bikenavi.adapter.IBEngineInitListener;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.bikenavi.adapter.IBRoutePlanListener;
import com.baidu.mapapi.bikenavi.adapter.IBTTSPlayer;
import com.baidu.mapapi.bikenavi.controllers.BNavigatorWrapper;
import com.baidu.mapapi.bikenavi.controllers.UnsupportedBikeNaviException;
import com.baidu.mapapi.bikenavi.params.BikeNaviLaunchParam;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.map.VersionInfo;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* loaded from: classes8.dex */
public class BikeNavigateHelper {
    private static BikeNavigateHelper d;
    boolean a;
    Activity b;
    private com.baidu.mapapi.bikenavi.controllers.a.a c = new com.baidu.mapapi.bikenavi.controllers.a.a();

    private BikeNavigateHelper() {
    }

    public static BikeNavigateHelper getInstance() {
        if (d == null) {
            d = new BikeNavigateHelper();
        }
        return d;
    }

    public void initNaviEngine(Activity activity, IBEngineInitListener iBEngineInitListener) {
        if (this.c != null) {
            this.c.a(activity, iBEngineInitListener);
        }
    }

    public void routePlanWithParams(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        if (this.c != null) {
            if (!this.c.a()) {
                throw new UnsupportedBikeNaviException("naviengine init failed, please init naviengine first");
            }
            if (bikeNaviLaunchParam == null || bikeNaviLaunchParam.getStartPt() == null || bikeNaviLaunchParam.getEndPt() == null) {
                throw new UnsupportedBikeNaviException("launch param or startPt or endPt cannot be null");
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(bikeNaviLaunchParam.getStartPt());
            GeoPoint ll2mc2 = CoordUtil.ll2mc(bikeNaviLaunchParam.getEndPt());
            com.baidu.platform.comapi.walknavi.e.a create = BikeNaviLaunchParam.create();
            if (bikeNaviLaunchParam.getVehicle() == 1) {
                create.a(bikeNaviLaunchParam.getVehicle());
            }
            create.b(1);
            BNavigatorWrapper.getWNavigator().c(1);
            b.a().a(bikeNaviLaunchParam.getStartPt());
            b.a().b(bikeNaviLaunchParam.getEndPt());
            create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER);
            create.c(0);
            create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER});
            this.c.a(create, iBRoutePlanListener);
        }
    }

    public void setRouteGuidanceListener(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        if (iBRouteGuidanceListener != null) {
            this.c.a(activity, iBRouteGuidanceListener);
        }
    }

    public void setTTsPlayer(IBTTSPlayer iBTTSPlayer) {
        if (this.c != null) {
            this.c.a(iBTTSPlayer);
        }
    }

    public void setBikeNaviStatusListener(IBNaviStatusListener iBNaviStatusListener) {
        b.a().a(iBNaviStatusListener);
    }

    public boolean startBikeNavi(Activity activity) {
        if (b.a().a(activity, (Bundle) null)) {
            if (!this.a) {
                if (!b.a().p()) {
                    return false;
                }
                this.a = true;
            }
            return true;
        }
        return false;
    }

    public void triggerLocation(WLocData wLocData) {
        if (this.c != null) {
            this.c.a(wLocData);
        }
    }

    public View onCreate(Activity activity) {
        if (this.c != null) {
            this.b = activity;
            return this.c.a(activity);
        }
        return null;
    }

    public boolean setNaviMapUp() {
        MapView f = this.c.f();
        if (f != null) {
            f.setZOrderMediaOverlay(true);
            return true;
        }
        return false;
    }

    public void pause() {
        b.a().h();
        if (this.c != null) {
            this.c.b();
        }
    }

    public void resume() {
        if (this.b != null && !this.b.isFinishing()) {
            b.a().g();
            if (this.c != null) {
                this.c.c();
            }
        }
    }

    public void quit() {
        if (b.a().Q() != null) {
            b.a().Q().q();
        }
        b.a().k();
        b.a().w();
        b.a().i();
        if (this.c != null) {
            this.c.d();
            this.c = null;
        }
        this.a = false;
        this.b = null;
        if (d != null) {
            d = null;
        }
    }

    public void showUIDebuggable(String str) {
        this.c.a(str);
    }

    static {
        if (!a.a().equals(VersionInfo.getApiVersion())) {
            throw new BaiduMapSDKException("the version of bikenavi is not match with map");
        }
        if (VersionInfo.KIT_NAME.compareToIgnoreCase(VersionInfo.KIT_NAME) != 0) {
            throw new BaiduMapSDKException("sdk of bikenavi is not match the correct map sdk, please integrate baidumapapi_map_for_bikenavi jar and so, instead of baidumapapi_map jar and so");
        }
        NativeLoader.getInstance().loadLibrary(a.b());
    }
}
