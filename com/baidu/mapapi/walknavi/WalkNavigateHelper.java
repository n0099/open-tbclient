package com.baidu.mapapi.walknavi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.g.a.d;
import com.baidu.mapapi.PermissionUtils;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviCalcRouteListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.adapter.IWTTSPlayer;
import com.baidu.mapapi.walknavi.controllers.WNavigatorWrapper;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.MultiRouteDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.RouteNodeType;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.walknavi.WalkNaviModeSwitchListener;
import com.baidu.platform.comapi.walknavi.b;
import com.baidu.platform.comapi.walknavi.e.c;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class WalkNavigateHelper {
    private static WalkNavigateHelper f;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3081b;
    private Activity c;
    private c e;
    private boolean d = false;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.mapapi.walknavi.controllers.a.a f3080a = new com.baidu.mapapi.walknavi.controllers.a.a();

    private WalkNavigateHelper() {
    }

    public static WalkNavigateHelper getInstance() {
        if (f == null) {
            f = new WalkNavigateHelper();
        }
        return f;
    }

    public void initNaviEngine(Activity activity, IWEngineInitListener iWEngineInitListener) {
        if (this.f3080a != null) {
            this.f3080a.a(activity, iWEngineInitListener);
        }
    }

    public void unInitNaviEngine() {
        b.a().z();
        b.a().k();
        if (this.f3080a != null) {
            this.f3080a.e();
            this.f3080a = null;
        }
        this.f3081b = false;
        this.c = null;
        this.e = null;
        if (f != null) {
            f = null;
        }
    }

    public void routePlanWithRouteNode(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        if (this.f3080a != null) {
            if (!this.f3080a.a()) {
                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: naviengine init failed, please init naviengine first");
            }
            if (walkNaviLaunchParam == null) {
                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: launch param cannot be null");
            }
            if (walkNaviLaunchParam.getStartNodeInfo() == null || walkNaviLaunchParam.getEndNodeInfo() == null) {
                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: startNode or endNodeInfo cannot be null");
            }
            if (walkNaviLaunchParam.getStartNodeInfo().getType() == RouteNodeType.LOCATION || walkNaviLaunchParam.getEndNodeInfo().getType() == RouteNodeType.LOCATION) {
                if (walkNaviLaunchParam.getStartNodeInfo().getLocation() == null || walkNaviLaunchParam.getEndNodeInfo().getLocation() == null) {
                    throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: the start and end location cannot be null");
                }
                if (a(walkNaviLaunchParam)) {
                    if (iWRoutePlanListener != null) {
                        iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_LESS_THAN_30M);
                        return;
                    }
                    return;
                } else if (b(walkNaviLaunchParam)) {
                    if (iWRoutePlanListener != null) {
                        iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_MORE_THAN_50KM);
                        return;
                    }
                    return;
                } else {
                    a(walkNaviLaunchParam, iWRoutePlanListener, true);
                    return;
                }
            }
            if (walkNaviLaunchParam.getStartNodeInfo().getType() == RouteNodeType.KEYWORD || walkNaviLaunchParam.getEndNodeInfo().getType() == RouteNodeType.KEYWORD) {
                if (walkNaviLaunchParam.getStartNodeInfo().getKeyword() == null || walkNaviLaunchParam.getEndNodeInfo().getKeyword() == null || walkNaviLaunchParam.getStartNodeInfo().getKeyword().isEmpty() || walkNaviLaunchParam.getEndNodeInfo().getKeyword().isEmpty()) {
                    throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: if WalkRouteNodeInfo's type is RouteNodeType.KEYWORD ,the startNodeInfo and endNodeInfo keyword cannot be null or empty");
                }
                if ((!walkNaviLaunchParam.getStartNodeInfo().getBuildingID().isEmpty() || !walkNaviLaunchParam.getEndNodeInfo().getBuildingID().isEmpty()) && !PermissionUtils.getInstance().isIndoorNaviAuthorized()) {
                    if (iWRoutePlanListener != null) {
                        iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.INVAILD_PERMISSION);
                        return;
                    }
                    return;
                }
            }
            WNavigatorWrapper.getWNavigator().a(0, 0);
            b.a().a(new a(this, iWRoutePlanListener, walkNaviLaunchParam));
            b.a().F().a(walkNaviLaunchParam);
        }
    }

    public void routePlanWithParams(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener) {
        if (this.f3080a != null) {
            if (!this.f3080a.a()) {
                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: naviengine init failed, please init naviengine first");
            }
            if (walkNaviLaunchParam == null || walkNaviLaunchParam.getStartPt() == null || walkNaviLaunchParam.getEndPt() == null) {
                throw new com.baidu.mapapi.walknavi.controllers.a("BDMapSDKException: launch param or startPt or endPt cannot be null");
            }
            if (a(walkNaviLaunchParam)) {
                if (iWRoutePlanListener != null) {
                    iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_LESS_THAN_30M);
                }
            } else if (b(walkNaviLaunchParam)) {
                if (iWRoutePlanListener != null) {
                    iWRoutePlanListener.onRoutePlanFail(WalkRoutePlanError.DISTANCE_MORE_THAN_50KM);
                }
            } else {
                a(walkNaviLaunchParam, iWRoutePlanListener, false);
            }
        }
    }

    private void a(WalkNaviLaunchParam walkNaviLaunchParam, IWRoutePlanListener iWRoutePlanListener, boolean z) {
        LatLng startPt;
        LatLng endPt;
        if (z) {
            startPt = walkNaviLaunchParam.getStartNodeInfo().getLocation();
            endPt = walkNaviLaunchParam.getEndNodeInfo().getLocation();
        } else {
            startPt = walkNaviLaunchParam.getStartPt();
            endPt = walkNaviLaunchParam.getEndPt();
        }
        GeoPoint ll2mc = CoordUtil.ll2mc(startPt);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(endPt);
        c create = WalkNaviLaunchParam.create();
        create.b(1);
        create.c(1);
        create.a(0);
        WNavigatorWrapper.getWNavigator().d(1);
        WNavigatorWrapper.getWNavigator().e(walkNaviLaunchParam.getExtraNaviMode());
        b.a().a(startPt);
        b.a().b(endPt);
        create.a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER);
        create.d(0);
        create.a(new int[]{(int) ll2mc2.getLongitudeE6()}, new int[]{(int) ll2mc2.getLatitudeE6()}, new int[]{IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER});
        this.f3080a.a(create, iWRoutePlanListener);
    }

    public View onCreate(Activity activity) {
        if (this.f3080a != null) {
            this.c = activity;
            return this.f3080a.a(activity);
        }
        return null;
    }

    public boolean startWalkNavi(Activity activity) {
        if (b.a().a(activity, (Bundle) null)) {
            if (!this.f3081b) {
                if (!b.a().s()) {
                    return false;
                }
                this.f3081b = true;
            }
            return true;
        }
        return false;
    }

    public void switchWalkNaviMode(Activity activity, int i, WalkNaviModeSwitchListener walkNaviModeSwitchListener) {
        if (this.f3080a != null) {
            this.f3080a.a(activity, i, walkNaviModeSwitchListener);
        }
    }

    public void naviCalcRoute(int i, IWNaviCalcRouteListener iWNaviCalcRouteListener) {
        b.a().a(i);
        if (this.f3080a != null) {
            this.f3080a.a(this.e, i, iWNaviCalcRouteListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(d dVar, WalkNaviLaunchParam walkNaviLaunchParam) {
        c create = WalkNaviLaunchParam.create();
        create.b(1);
        create.c(walkNaviLaunchParam.getExtraNaviMode());
        create.a(0);
        create.a(dVar.vC().vN().cm(0), dVar.vC().vN().cm(1), dVar.vC().vT().getCode(), dVar.vC().vN().getFloor(), dVar.vC().vN().wm());
        int size = dVar.vC().vP().size();
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        for (int i = 0; i < dVar.vC().vP().size(); i++) {
            iArr[i] = dVar.vC().ch(i).cm(0);
            iArr2[i] = dVar.vC().ch(i).cm(1);
            iArr3[i] = dVar.vC().cj(0).getCode();
            strArr[i] = dVar.vC().ch(i).getFloor();
            strArr2[i] = dVar.vC().ch(i).wm();
        }
        create.a(iArr, iArr2, iArr3, strArr, strArr2);
        create.d(2);
        create.a(dVar.toByteArray());
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(dVar.vC().vN().cm(1), dVar.vC().vN().cm(0)));
        b.a().a(mc2ll);
        int size = dVar.vC().vP().size();
        b.a().b(CoordUtil.mc2ll(new GeoPoint(dVar.vC().ch(size - 1).cm(1), dVar.vC().ch(size - 1).cm(0))));
        String floor = dVar.vC().vN().getFloor();
        String wm = dVar.vC().vN().wm();
        com.baidu.platform.comapi.wnplatform.model.c cVar = new com.baidu.platform.comapi.wnplatform.model.c();
        cVar.a(mc2ll);
        cVar.a(wm);
        cVar.b(floor);
        b.a().a(cVar);
        GeoPoint ll2mc = CoordUtil.ll2mc(mc2ll);
        b.a().G().a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 0, wm, floor);
    }

    public List<Polyline> displayRoutePlanResult(MapView mapView, MultiRouteDisplayOption multiRouteDisplayOption) {
        if (this.f3080a != null) {
            return this.f3080a.a(mapView, multiRouteDisplayOption);
        }
        return null;
    }

    public void startCameraAndSetMapView(Activity activity) {
        this.f3080a.b(activity);
    }

    private boolean a(WalkNaviLaunchParam walkNaviLaunchParam) {
        LatLng location;
        LatLng location2;
        if (walkNaviLaunchParam.getStartNodeInfo() == null) {
            location = walkNaviLaunchParam.getStartPt();
        } else {
            location = walkNaviLaunchParam.getStartNodeInfo().getLocation();
        }
        if (walkNaviLaunchParam.getEndNodeInfo() == null) {
            location2 = walkNaviLaunchParam.getEndPt();
        } else {
            location2 = walkNaviLaunchParam.getEndNodeInfo().getLocation();
        }
        Point ll2point = CoordUtil.ll2point(location);
        Point ll2point2 = CoordUtil.ll2point(location2);
        if (ll2point == null || ll2point2 == null) {
            return true;
        }
        return CoordUtil.getDistance(ll2point, ll2point2) < 30.0d;
    }

    private boolean b(WalkNaviLaunchParam walkNaviLaunchParam) {
        LatLng location;
        LatLng location2;
        if (walkNaviLaunchParam.getStartNodeInfo() == null) {
            location = walkNaviLaunchParam.getStartPt();
        } else {
            location = walkNaviLaunchParam.getStartNodeInfo().getLocation();
        }
        if (walkNaviLaunchParam.getEndNodeInfo() == null) {
            location2 = walkNaviLaunchParam.getEndPt();
        } else {
            location2 = walkNaviLaunchParam.getEndNodeInfo().getLocation();
        }
        Point ll2point = CoordUtil.ll2point(location);
        Point ll2point2 = CoordUtil.ll2point(location2);
        if (ll2point == null || ll2point2 == null) {
            return true;
        }
        return CoordUtil.getDistance(ll2point, ll2point2) > 50000.0d;
    }

    public boolean hasIndoorRoute() {
        return this.d;
    }

    public void setRouteGuidanceListener(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        if (iWRouteGuidanceListener != null) {
            this.f3080a.a(activity, iWRouteGuidanceListener);
        }
    }

    public void setWalkNaviStatusListener(IWNaviStatusListener iWNaviStatusListener) {
        b.a().a(iWNaviStatusListener);
    }

    public void setTTsPlayer(IWTTSPlayer iWTTSPlayer) {
        if (this.f3080a != null) {
            this.f3080a.a(iWTTSPlayer);
        }
    }

    public void triggerLocation(WLocData wLocData) {
        if (this.f3080a != null) {
            this.f3080a.a(wLocData);
        }
    }

    public void setWalkNaviDisplayOption(WalkNaviDisplayOption walkNaviDisplayOption) {
        if (this.f3080a != null) {
            this.f3080a.a(walkNaviDisplayOption);
        }
    }

    public void setWalkNpcModelInfoList(ArrayList<BaseNpcModel> arrayList) {
        if (this.f3080a != null) {
            this.f3080a.a(arrayList);
        }
    }

    public ArrayList<BaseNpcModel> getWalkNpcModelInfoList() {
        if (this.f3080a != null) {
            return this.f3080a.b();
        }
        return null;
    }

    public void switchNPCModel(BaseNpcModel baseNpcModel) {
        if (this.f3080a != null) {
            this.f3080a.a(baseNpcModel);
        }
    }

    public void addMoreNPCModelOnClickListener(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        if (this.f3080a != null) {
            this.f3080a.a(iWMoreNPCModelOnClickListener);
        }
    }

    public void addNPCLoadAndInitListener(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        if (this.f3080a != null) {
            this.f3080a.a(iWNPCLoadAndInitListener);
        }
    }

    public MapView getNaviMap() {
        if (this.f3080a != null) {
            return this.f3080a.i();
        }
        return null;
    }

    public void pause() {
        b.a().j();
        if (this.f3080a != null) {
            this.f3080a.c();
        }
    }

    public void resume() {
        if (this.c != null && !this.c.isFinishing()) {
            b.a().i();
            if (this.f3080a != null) {
                this.f3080a.d();
            }
        }
    }

    public void quit() {
        if (b.a().T() != null) {
            b.a().T().q();
        }
        if (this.f3080a != null && this.f3081b) {
            this.f3080a.f();
            this.f3080a.g();
        }
        b.a().m();
        b.a().z();
        b.a().k();
        if (this.f3080a != null) {
            this.f3080a.e();
            this.f3080a = null;
        }
        this.f3081b = false;
        this.c = null;
        this.e = null;
        if (f != null) {
            f = null;
        }
    }
}
