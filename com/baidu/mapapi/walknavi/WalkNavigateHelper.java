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
/* loaded from: classes2.dex */
public class WalkNavigateHelper {

    /* renamed from: d  reason: collision with root package name */
    public static WalkNavigateHelper f7455d;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.mapapi.walknavi.controllers.a.a f7456a = new com.baidu.mapapi.walknavi.controllers.a.a();

    /* renamed from: b  reason: collision with root package name */
    public boolean f7457b;

    /* renamed from: c  reason: collision with root package name */
    public Activity f7458c;

    static {
        if (a.a().equals(VersionInfo.getApiVersion())) {
            NativeLoader.getInstance().loadLibrary(a.b());
            return;
        }
        throw new BaiduMapSDKException("the version of bikenavi is not match with map");
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

    public static WalkNavigateHelper getInstance() {
        if (f7455d == null) {
            f7455d = new WalkNavigateHelper();
        }
        return f7455d;
    }

    public void addMoreNPCModelOnClickListener(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(iWMoreNPCModelOnClickListener);
        }
    }

    public void addNPCLoadAndInitListener(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(iWNPCLoadAndInitListener);
        }
    }

    public ArrayList<BaseNpcModel> getWalkNpcModelInfoList() {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public void initNaviEngine(Activity activity, IWEngineInitListener iWEngineInitListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(activity, iWEngineInitListener);
        }
    }

    public View onCreate(Activity activity) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            this.f7458c = activity;
            return aVar.a(activity);
        }
        return null;
    }

    public void pause() {
        b.a().h();
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void quit() {
        if (b.a().Q() != null) {
            b.a().Q().q();
        }
        b.a().k();
        b.a().w();
        b.a().i();
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.e();
            this.f7456a = null;
        }
        this.f7457b = false;
        this.f7458c = null;
        if (f7455d != null) {
            f7455d = null;
        }
    }

    public void resume() {
        Activity activity = this.f7458c;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        b.a().g();
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void routePlanWithParams(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            if (aVar.a()) {
                if (walkNaviLaunchParam != null && walkNaviLaunchParam.getStartPt() != null && walkNaviLaunchParam.getEndPt() != null) {
                    if (checkDistanceClose(walkNaviLaunchParam)) {
                        if (iWRoutePlanListener != null) {
                            iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_LESS_THAN_30M);
                            return;
                        }
                        return;
                    } else if (checkDistanceLong(walkNaviLaunchParam)) {
                        if (iWRoutePlanListener != null) {
                            iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_MORE_THAN_50KM);
                            return;
                        }
                        return;
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
                        this.f7456a.a(create, iWRoutePlanListener);
                        return;
                    }
                }
                throw new com.baidu.mapapi.walknavi.controllers.a("launch param or startPt or endPt cannot be null");
            }
            throw new com.baidu.mapapi.walknavi.controllers.a("naviengine init failed, please init naviengine first");
        }
    }

    public void setRouteGuidanceListener(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        if (iWRouteGuidanceListener != null) {
            this.f7456a.a(activity, iWRouteGuidanceListener);
        }
    }

    public void setTTsPlayer(IWTTSPlayer iWTTSPlayer) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(iWTTSPlayer);
        }
    }

    public void setWalkNaviDisplayOption(WalkNaviDisplayOption walkNaviDisplayOption) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(walkNaviDisplayOption);
        }
    }

    public void setWalkNaviStatusListener(IWNaviStatusListener iWNaviStatusListener) {
        b.a().a(iWNaviStatusListener);
    }

    public void setWalkNpcModelInfoList(ArrayList<BaseNpcModel> arrayList) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(arrayList);
        }
    }

    public void startCameraAndSetMapView(Activity activity) {
        this.f7456a.b(activity);
    }

    public boolean startWalkNavi(Activity activity) {
        if (b.a().a(activity, (Bundle) null)) {
            if (!this.f7457b) {
                if (!b.a().p()) {
                    return false;
                }
                this.f7457b = true;
            }
            return true;
        }
        return false;
    }

    public void switchNPCModel(BaseNpcModel baseNpcModel) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(baseNpcModel);
        }
    }

    public void switchWalkNaviMode(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(activity, i, walkNaviModeSwitchListener);
        }
    }

    public void triggerLocation(WLocData wLocData) {
        com.baidu.mapapi.walknavi.controllers.a.a aVar = this.f7456a;
        if (aVar != null) {
            aVar.a(wLocData);
        }
    }
}
