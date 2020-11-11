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
import com.baidu.mapapi.bikenavi.controllers.a.a;
import com.baidu.mapapi.bikenavi.params.BikeNaviLaunchParam;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.wnplatform.model.c;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* loaded from: classes7.dex */
public class BikeNavigateHelper {
    private static BikeNavigateHelper d;

    /* renamed from: a  reason: collision with root package name */
    boolean f1973a;
    Activity b;
    private a c = new a();

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

    public void unInitNaviEngine() {
        b.a().z();
        b.a().k();
        if (this.c != null) {
            this.c.d();
            this.c = null;
        }
        this.f1973a = false;
        this.b = null;
        if (d != null) {
            d = null;
        }
    }

    public void routePlanWithParams(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        if (this.c != null) {
            if (!this.c.a()) {
                throw new UnsupportedBikeNaviException("BDMapSDKException: naviengine init failed, please init naviengine first");
            }
            if (bikeNaviLaunchParam == null || bikeNaviLaunchParam.getStartPt() == null || bikeNaviLaunchParam.getEndPt() == null) {
                throw new UnsupportedBikeNaviException("BDMapSDKException: launch param or startPt or endPt cannot be null");
            }
            GeoPoint ll2mc = CoordUtil.ll2mc(bikeNaviLaunchParam.getStartPt());
            GeoPoint ll2mc2 = CoordUtil.ll2mc(bikeNaviLaunchParam.getEndPt());
            com.baidu.platform.comapi.walknavi.e.a create = BikeNaviLaunchParam.create();
            if (bikeNaviLaunchParam.getVehicle() == 1) {
                create.a(bikeNaviLaunchParam.getVehicle());
            }
            create.b(1);
            BNavigatorWrapper.getWNavigator().d(1);
            b.a().a(bikeNaviLaunchParam.getStartPt());
            b.a().b(bikeNaviLaunchParam.getEndPt());
            create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER);
            create.c(0);
            create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER});
            this.c.a(create, iBRoutePlanListener);
        }
    }

    public void routePlanWithRouteNode(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        if (this.c != null) {
            if (!this.c.a()) {
                throw new UnsupportedBikeNaviException("BDMapSDKException: naviengine init failed, please init naviengine first");
            }
            if (bikeNaviLaunchParam == null) {
                throw new UnsupportedBikeNaviException("BDMapSDKException: launch param cannot be null");
            }
            if (bikeNaviLaunchParam.getStartNodeInfo() == null || bikeNaviLaunchParam.getEndNodeInfo() == null) {
                throw new UnsupportedBikeNaviException("BDMapSDKException: startNode or endNodeInfo cannot be null");
            }
            if (bikeNaviLaunchParam.getStartNodeInfo().getLocation() == null || bikeNaviLaunchParam.getEndNodeInfo().getLocation() == null) {
                throw new UnsupportedBikeNaviException("BDMapSDKException: the start and end location cannot be null");
            }
            c cVar = new c();
            cVar.a(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
            b.a().a(cVar);
            GeoPoint ll2mc = CoordUtil.ll2mc(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
            GeoPoint ll2mc2 = CoordUtil.ll2mc(bikeNaviLaunchParam.getEndNodeInfo().getLocation());
            com.baidu.platform.comapi.walknavi.e.a create = BikeNaviLaunchParam.create();
            if (bikeNaviLaunchParam.getVehicle() == 1) {
                create.a(bikeNaviLaunchParam.getVehicle());
            }
            create.b(1);
            BNavigatorWrapper.getWNavigator().d(1);
            b.a().a(bikeNaviLaunchParam.getStartNodeInfo().getLocation());
            b.a().b(bikeNaviLaunchParam.getEndNodeInfo().getLocation());
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
            if (!this.f1973a) {
                if (!b.a().s()) {
                    return false;
                }
                this.f1973a = true;
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

    public MapView getNaviMap() {
        if (this.c != null) {
            return this.c.f();
        }
        return null;
    }

    public void pause() {
        b.a().j();
        if (this.c != null) {
            this.c.b();
        }
    }

    public void resume() {
        if (this.b != null && !this.b.isFinishing()) {
            b.a().i();
            if (this.c != null) {
                this.c.c();
            }
        }
    }

    public void quit() {
        if (b.a().T() != null) {
            b.a().T().q();
        }
        b.a().m();
        b.a().z();
        b.a().k();
        if (this.c != null) {
            this.c.d();
            this.c = null;
        }
        this.f1973a = false;
        this.b = null;
        if (d != null) {
            d = null;
        }
    }

    public void showUIDebuggable(String str) {
        this.c.a(str);
    }
}
