package com.baidu.swan.impl.map.a.b;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.impl.map.a.b.d;
/* loaded from: classes12.dex */
public class e {
    public static void a(Context context, com.baidu.swan.impl.map.item.c cVar, com.baidu.swan.apps.z.a.c cVar2, com.baidu.swan.impl.map.b bVar, boolean z) {
        if (cVar == null || cVar2 == null || !cVar2.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "initMapView model is invalid");
            return;
        }
        BaiduMap map = cVar.cVF.getMap();
        com.baidu.swan.impl.map.b.b bVar2 = new com.baidu.swan.impl.map.b.b(cVar);
        map.setOnMapClickListener(bVar2);
        map.setOnMarkerClickListener(bVar2);
        map.setOnMapLoadedCallback(bVar2);
        map.setOnMapRenderCallbadk(bVar2);
        map.setOnMapStatusChangeListener(bVar2);
        map.setOnMyLocationClickListener(bVar2);
        UiSettings uiSettings = map.getUiSettings();
        uiSettings.setScrollGesturesEnabled(cVar2.bYs);
        uiSettings.setRotateGesturesEnabled(cVar2.bYt);
        uiSettings.setZoomGesturesEnabled(cVar2.bYr);
        cVar.cVF.showZoomControls(cVar2.bYr);
        map.setBuildingsEnabled(cVar2.bYw);
        uiSettings.setOverlookingGesturesEnabled(cVar2.bYv);
        if (cVar2.bYj != null && cVar2.bYj.isValid()) {
            com.baidu.swan.apps.console.c.i("map", "initMapView coordinate is " + cVar2.bYj);
            map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(cVar2.bYj.latitude, cVar2.bYj.longitude)));
        }
        MapStatus mapStatus = map.getMapStatus();
        float f = mapStatus != null ? mapStatus.zoom : (float) cVar2.bYk;
        if (!z) {
            f = (float) cVar2.bYk;
        }
        map.setMapStatus(MapStatusUpdateFactory.zoomTo(f));
        com.baidu.swan.apps.console.c.i("map", "initMapView scale is " + cVar2.bYk);
        cVar.isShowLocation = cVar2.isShowLocation;
        if (cVar2.isShowLocation) {
            a(context, bVar);
        } else {
            bVar.fI(false);
        }
        uiSettings.setCompassEnabled(cVar2.bYu);
        f.a(AppRuntime.getAppContext(), cVar2, cVar);
        f.a(cVar2, cVar, bVar2);
    }

    public static void a(Context context, com.baidu.swan.impl.map.item.c cVar, com.baidu.swan.apps.z.a.c cVar2, com.baidu.swan.impl.map.b bVar) {
        a(context, cVar, cVar2, bVar, false);
    }

    private static void a(Context context, final com.baidu.swan.impl.map.b bVar) {
        d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.a.b.e.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                com.baidu.swan.impl.map.b.this.fI(true);
                com.baidu.swan.apps.console.c.i("map", "location permission success");
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                com.baidu.swan.apps.console.c.i("map", "location permission fail");
            }
        });
    }
}
