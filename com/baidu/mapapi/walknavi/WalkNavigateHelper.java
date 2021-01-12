package com.baidu.mapapi.walknavi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.map.VersionInfo;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class WalkNavigateHelper {
    private static WalkNavigateHelper d;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapapi.walknavi.controllers.a.a f2977a = new com.baidu.mapapi.walknavi.controllers.a.a();

    /* renamed from: b  reason: collision with root package name */
    private boolean f2978b;
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
        if (this.f2977a != null) {
            this.f2977a.a(activity, iWEngineInitListener);
        }
    }

    public void routePlanWithParams(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        if (this.f2977a != null) {
            if (!this.f2977a.a()) {
                throw new com.baidu.mapapi.walknavi.controllers.a("naviengine init failed, please init naviengine first");
            }
            if (walkNaviLaunchParam == null || walkNaviLaunchParam.getStartPt() == null || walkNaviLaunchParam.getEndPt() == null) {
                throw new com.baidu.mapapi.walknavi.controllers.a("launch param or startPt or endPt cannot be null");
            }
            if (checkDistanceClose(walkNaviLaunchParam)) {
                if (iWRoutePlanListener != null) {
                    iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_LESS_THAN_30M);
                }
            } else if (checkDistanceLong(walkNaviLaunchParam)) {
                if (iWRoutePlanListener != null) {
                    iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_MORE_THAN_50KM);
                }
            } else {
                GeoPoint ll2mc = CoordUtil.ll2mc(walkNaviLaunchParam.getStartPt());
                GeoPoint ll2mc2 = CoordUtil.ll2mc(walkNaviLaunchParam.getEndPt());
                c create = WalkNaviLaunchParam.create();
                create.b(1);
                create.c(1);
                create.a(0);
                WNavigatorWrapper.getWNavigator().c(1);
                WNavigatorWrapper.getWNavigator().d(walkNaviLaunchParam.getExtraNaviMode());
                b.a().a(walkNaviLaunchParam.getStartPt());
                b.a().b(walkNaviLaunchParam.getEndPt());
                create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER);
                create.d(0);
                create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER});
                this.f2977a.a(create, iWRoutePlanListener);
            }
        }
    }

    public View onCreate(Activity activity) {
        if (this.f2977a != null) {
            this.c = activity;
            return this.f2977a.a(activity);
        }
        return null;
    }

    public boolean startWalkNavi(Activity activity) {
        if (b.a().a(activity, (Bundle) null)) {
            if (!this.f2978b) {
                if (!b.a().p()) {
                    return false;
                }
                this.f2978b = true;
            }
            return true;
        }
        return false;
    }

    public void switchWalkNaviMode(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        if (this.f2977a != null) {
            this.f2977a.a(activity, i, walkNaviModeSwitchListener);
        }
    }

    public void startCameraAndSetMapView(Activity activity) {
        this.f2977a.b(activity);
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
            this.f2977a.a(activity, iWRouteGuidanceListener);
        }
    }

    public void setWalkNaviStatusListener(IWNaviStatusListener iWNaviStatusListener) {
        b.a().a(iWNaviStatusListener);
    }

    public void setTTsPlayer(IWTTSPlayer iWTTSPlayer) {
        if (this.f2977a != null) {
            this.f2977a.a(iWTTSPlayer);
        }
    }

    public void triggerLocation(WLocData wLocData) {
        if (this.f2977a != null) {
            this.f2977a.a(wLocData);
        }
    }

    public void setWalkNaviDisplayOption(WalkNaviDisplayOption walkNaviDisplayOption) {
        if (this.f2977a != null) {
            this.f2977a.a(walkNaviDisplayOption);
        }
    }

    public void setWalkNpcModelInfoList(ArrayList<BaseNpcModel> arrayList) {
        if (this.f2977a != null) {
            this.f2977a.a(arrayList);
        }
    }

    public ArrayList<BaseNpcModel> getWalkNpcModelInfoList() {
        if (this.f2977a != null) {
            return this.f2977a.b();
        }
        return null;
    }

    public void switchNPCModel(BaseNpcModel baseNpcModel) {
        if (this.f2977a != null) {
            this.f2977a.a(baseNpcModel);
        }
    }

    public void addMoreNPCModelOnClickListener(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        if (this.f2977a != null) {
            this.f2977a.a(iWMoreNPCModelOnClickListener);
        }
    }

    public void addNPCLoadAndInitListener(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        if (this.f2977a != null) {
            this.f2977a.a(iWNPCLoadAndInitListener);
        }
    }

    public void pause() {
        b.a().h();
        if (this.f2977a != null) {
            this.f2977a.c();
        }
    }

    public void resume() {
        if (this.c != null && !this.c.isFinishing()) {
            b.a().g();
            if (this.f2977a != null) {
                this.f2977a.d();
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
        if (this.f2977a != null) {
            this.f2977a.e();
            this.f2977a = null;
        }
        this.f2978b = false;
        this.c = null;
        if (d != null) {
            d = null;
        }
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
