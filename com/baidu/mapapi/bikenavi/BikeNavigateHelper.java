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
/* loaded from: classes2.dex */
public class BikeNavigateHelper {

    /* renamed from: d  reason: collision with root package name */
    public static BikeNavigateHelper f6774d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f6775a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f6776b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.mapapi.bikenavi.controllers.a.a f6777c = new com.baidu.mapapi.bikenavi.controllers.a.a();

    static {
        if (a.a().equals(VersionInfo.getApiVersion())) {
            NativeLoader.getInstance().loadLibrary(a.b());
            return;
        }
        throw new BaiduMapSDKException("the version of bikenavi is not match with map");
    }

    public static BikeNavigateHelper getInstance() {
        if (f6774d == null) {
            f6774d = new BikeNavigateHelper();
        }
        return f6774d;
    }

    public void initNaviEngine(Activity activity, IBEngineInitListener iBEngineInitListener) {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            aVar.a(activity, iBEngineInitListener);
        }
    }

    public View onCreate(Activity activity) {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            this.f6776b = activity;
            return aVar.a(activity);
        }
        return null;
    }

    public void pause() {
        b.a().h();
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void quit() {
        if (b.a().Q() != null) {
            b.a().Q().q();
        }
        b.a().k();
        b.a().w();
        b.a().i();
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            aVar.d();
            this.f6777c = null;
        }
        this.f6775a = false;
        this.f6776b = null;
        if (f6774d != null) {
            f6774d = null;
        }
    }

    public void resume() {
        Activity activity = this.f6776b;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        b.a().g();
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void routePlanWithParams(BikeNaviLaunchParam bikeNaviLaunchParam, IBRoutePlanListener iBRoutePlanListener) {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            if (aVar.a()) {
                if (bikeNaviLaunchParam != null && bikeNaviLaunchParam.getStartPt() != null && bikeNaviLaunchParam.getEndPt() != null) {
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
                    this.f6777c.a(create, iBRoutePlanListener);
                    return;
                }
                throw new UnsupportedBikeNaviException("launch param or startPt or endPt cannot be null");
            }
            throw new UnsupportedBikeNaviException("naviengine init failed, please init naviengine first");
        }
    }

    public void setBikeNaviStatusListener(IBNaviStatusListener iBNaviStatusListener) {
        b.a().a(iBNaviStatusListener);
    }

    public boolean setNaviMapUp() {
        MapView f2 = this.f6777c.f();
        if (f2 != null) {
            f2.setZOrderMediaOverlay(true);
            return true;
        }
        return false;
    }

    public void setRouteGuidanceListener(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        if (iBRouteGuidanceListener != null) {
            this.f6777c.a(activity, iBRouteGuidanceListener);
        }
    }

    public void setTTsPlayer(IBTTSPlayer iBTTSPlayer) {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            aVar.a(iBTTSPlayer);
        }
    }

    public void showUIDebuggable(String str) {
        this.f6777c.a(str);
    }

    public boolean startBikeNavi(Activity activity) {
        if (b.a().a(activity, (Bundle) null)) {
            if (!this.f6775a) {
                if (!b.a().p()) {
                    return false;
                }
                this.f6775a = true;
            }
            return true;
        }
        return false;
    }

    public void triggerLocation(WLocData wLocData) {
        com.baidu.mapapi.bikenavi.controllers.a.a aVar = this.f6777c;
        if (aVar != null) {
            aVar.a(wLocData);
        }
    }
}
