package com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav;

import android.app.Activity;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.searchbox.bdmapsdk.BdMapRuntime;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
/* loaded from: classes4.dex */
public class WalkARNavPreparer {

    /* loaded from: classes4.dex */
    public interface OnWalkNavPrepareListener {
        void onPrepareFailed(String str);

        void onPrepareStart();

        void onPrepareSuccess();
    }

    public static void prepareWalkNav(Activity activity, LatLng latLng, LatLng latLng2, OnWalkNavPrepareListener onWalkNavPrepareListener) {
        BdMapRuntime.makeSureMapSDKInit();
        prepare(activity, latLng, latLng2, onWalkNavPrepareListener);
    }

    private static void prepare(Activity activity, final LatLng latLng, final LatLng latLng2, final OnWalkNavPrepareListener onWalkNavPrepareListener) {
        final WalkNavigateHelper walkNavigateHelper = WalkNavigateHelper.getInstance();
        try {
            walkNavigateHelper.quit();
            if (onWalkNavPrepareListener != null) {
                onWalkNavPrepareListener.onPrepareStart();
            }
            walkNavigateHelper.initNaviEngine(activity, new IWEngineInitListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavPreparer.1
                @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
                public void engineInitSuccess() {
                    WalkARNavPreparer.routePlanWithWalkParam(walkNavigateHelper, WalkARNavPreparer.createParams(LatLng.this, latLng2), onWalkNavPrepareListener);
                }

                @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
                public void engineInitFail() {
                    walkNavigateHelper.quit();
                    if (onWalkNavPrepareListener != null) {
                        onWalkNavPrepareListener.onPrepareFailed("engineInitFail");
                    }
                }
            });
        } catch (Exception e) {
            AiAppsLog.e("map", "initNaviEngine fail");
            walkNavigateHelper.quit();
            if (onWalkNavPrepareListener != null) {
                onWalkNavPrepareListener.onPrepareFailed(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WalkNaviLaunchParam createParams(LatLng latLng, LatLng latLng2) {
        LatLng convertLocation = convertLocation(latLng);
        return new WalkNaviLaunchParam().stPt(convertLocation).endPt(convertLocation(latLng2));
    }

    private static LatLng convertLocation(LatLng latLng) {
        CoordinateConverter coordinateConverter = new CoordinateConverter();
        coordinateConverter.from(CoordinateConverter.CoordType.COMMON);
        coordinateConverter.coord(latLng);
        return coordinateConverter.convert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void routePlanWithWalkParam(final WalkNavigateHelper walkNavigateHelper, WalkNaviLaunchParam walkNaviLaunchParam, final OnWalkNavPrepareListener onWalkNavPrepareListener) {
        try {
            walkNavigateHelper.routePlanWithParams(walkNaviLaunchParam, new IWRoutePlanListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavPreparer.2
                @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
                public void onRoutePlanStart() {
                }

                @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
                public void onRoutePlanSuccess() {
                    if (OnWalkNavPrepareListener.this != null) {
                        OnWalkNavPrepareListener.this.onPrepareSuccess();
                    }
                }

                @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
                public void onRoutePlanFail(WalkRoutePlanError walkRoutePlanError) {
                    walkNavigateHelper.quit();
                    if (OnWalkNavPrepareListener.this != null) {
                        OnWalkNavPrepareListener.this.onPrepareFailed(walkRoutePlanError.toString());
                    }
                }
            });
        } catch (Exception e) {
            AiAppsLog.e("map", "routePlanWithParams fail");
            walkNavigateHelper.quit();
            if (onWalkNavPrepareListener != null) {
                onWalkNavPrepareListener.onPrepareFailed(e.getMessage());
            }
        }
    }
}
