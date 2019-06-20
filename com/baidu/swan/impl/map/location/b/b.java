package com.baidu.swan.impl.map.location.b;

import android.app.Activity;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.walknavi.WalkNavigateHelper;
import com.baidu.mapapi.walknavi.adapter.IWEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener;
import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;
import com.baidu.mapapi.walknavi.params.WalkNaviLaunchParam;
import com.baidu.swan.apps.console.c;
/* loaded from: classes5.dex */
public class b {

    /* loaded from: classes5.dex */
    public interface a {
        void Uo();

        void Up();

        void kd(String str);
    }

    public static void a(Activity activity, LatLng latLng, LatLng latLng2, a aVar) {
        com.baidu.swan.impl.map.a.Tx();
        b(activity, latLng, latLng2, aVar);
    }

    private static void b(Activity activity, final LatLng latLng, final LatLng latLng2, final a aVar) {
        final WalkNavigateHelper walkNavigateHelper = WalkNavigateHelper.getInstance();
        if (aVar != null) {
            try {
                aVar.Uo();
            } catch (Exception e) {
                c.e("map", "initNaviEngine fail");
                walkNavigateHelper.quit();
                if (aVar != null) {
                    aVar.kd(e.getMessage());
                    return;
                }
                return;
            }
        }
        walkNavigateHelper.initNaviEngine(activity, new IWEngineInitListener() { // from class: com.baidu.swan.impl.map.location.b.b.1
            @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
            public void engineInitSuccess() {
                b.a(walkNavigateHelper, b.g(LatLng.this, latLng2), aVar);
            }

            @Override // com.baidu.mapapi.walknavi.adapter.IWEngineInitListener
            public void engineInitFail() {
                walkNavigateHelper.quit();
                if (aVar != null) {
                    aVar.kd("engineInitFail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WalkNaviLaunchParam g(LatLng latLng, LatLng latLng2) {
        LatLng g = g(latLng);
        return new WalkNaviLaunchParam().stPt(g).endPt(g(latLng2));
    }

    private static LatLng g(LatLng latLng) {
        CoordinateConverter coordinateConverter = new CoordinateConverter();
        coordinateConverter.from(CoordinateConverter.CoordType.COMMON);
        coordinateConverter.coord(latLng);
        return coordinateConverter.convert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final WalkNavigateHelper walkNavigateHelper, WalkNaviLaunchParam walkNaviLaunchParam, final a aVar) {
        try {
            walkNavigateHelper.routePlanWithParams(walkNaviLaunchParam, new IWRoutePlanListener() { // from class: com.baidu.swan.impl.map.location.b.b.2
                @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
                public void onRoutePlanStart() {
                }

                @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
                public void onRoutePlanSuccess() {
                    if (a.this != null) {
                        a.this.Up();
                    }
                }

                @Override // com.baidu.mapapi.walknavi.adapter.IWRoutePlanListener
                public void onRoutePlanFail(WalkRoutePlanError walkRoutePlanError) {
                    walkNavigateHelper.quit();
                    if (a.this != null) {
                        a.this.kd(walkRoutePlanError.toString());
                    }
                }
            });
        } catch (Exception e) {
            c.e("map", "routePlanWithParams fail");
            walkNavigateHelper.quit();
            if (aVar != null) {
                aVar.kd(e.getMessage());
            }
        }
    }
}
