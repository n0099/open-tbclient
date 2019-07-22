package com.baidu.swan.impl.map.a.b;

import android.content.Context;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.swan.impl.map.a.b.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class e {
    public static void a(Context context, com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.impl.map.b bVar2, boolean z) {
        if (bVar == null || cVar == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "initMapView model is invalid");
            return;
        }
        BaiduMap map = bVar.bof.getMap();
        com.baidu.swan.impl.map.b.b bVar3 = new com.baidu.swan.impl.map.b.b(bVar);
        bVar.bof.getMap().setOnMapClickListener(bVar3);
        bVar.bof.getMap().setOnMarkerClickListener(bVar3);
        bVar.bof.getMap().setOnMapLoadedCallback(bVar3);
        bVar.bof.getMap().setOnMapRenderCallbadk(bVar3);
        bVar.bof.getMap().setOnMapStatusChangeListener(bVar3);
        bVar.bof.getMap().setOnMyLocationClickListener(bVar3);
        map.getUiSettings().setScrollGesturesEnabled(cVar.aAA);
        map.getUiSettings().setRotateGesturesEnabled(cVar.aAB);
        map.getUiSettings().setZoomGesturesEnabled(cVar.aAz);
        bVar.bof.showZoomControls(cVar.aAz);
        map.setBuildingsEnabled(cVar.aAE);
        map.getUiSettings().setOverlookingGesturesEnabled(cVar.aAD);
        if (cVar.aAr != null && cVar.aAr.isValid()) {
            com.baidu.swan.apps.console.c.i("map", "initMapView coordinate is " + cVar.aAr);
            map.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(cVar.aAr.latitude, cVar.aAr.longitude)));
        }
        float f = map.getMapStatus() != null ? map.getMapStatus().zoom : (float) cVar.aAs;
        if (!z) {
            f = (float) cVar.aAs;
        }
        map.setMapStatus(MapStatusUpdateFactory.zoomTo(f));
        com.baidu.swan.apps.console.c.i("map", "initMapView scale is " + cVar.aAs);
        bVar.isShowLocation = cVar.isShowLocation;
        if (cVar.isShowLocation) {
            a(context, bVar2);
        } else {
            bVar2.cW(false);
        }
        map.getUiSettings().setCompassEnabled(cVar.aAC);
        if (cVar.aAt != null && cVar.aAt.size() > 0) {
            for (com.baidu.swan.apps.x.a.a.d dVar : cVar.aAt) {
                f.b(bVar, dVar);
                com.baidu.swan.apps.console.c.i("map", "initMapView createMarker id " + dVar.id);
            }
        }
        if (cVar.aAw != null && cVar.aAw.size() > 0) {
            for (com.baidu.swan.apps.x.a.a.b bVar4 : cVar.aAw) {
                b.a(bVar, bVar4, bVar3);
                com.baidu.swan.apps.console.c.i("map", "initMapView createControl id " + bVar4.id);
            }
        }
        if (cVar.aAu != null && cVar.aAu.size() > 0) {
            for (com.baidu.swan.apps.x.a.a.f fVar : cVar.aAu) {
                if (!fVar.isValid()) {
                    com.baidu.swan.apps.console.c.e("map", "polyline is invalid");
                } else {
                    ArrayList arrayList = new ArrayList(fVar.aAW.size());
                    Iterator<com.baidu.swan.apps.x.a.a.c> it = fVar.aAW.iterator();
                    while (it.hasNext()) {
                        com.baidu.swan.apps.x.a.a.c next = it.next();
                        arrayList.add(new LatLng(next.latitude, next.longitude));
                    }
                    if (arrayList.size() < 2 || arrayList.contains(null)) {
                        com.baidu.swan.apps.console.c.e("map", "polyline count can't less than 2 or your polyline points contains null");
                    } else {
                        map.addOverlay(new PolylineOptions().points(arrayList).color(fVar.color).width((int) fVar.width).dottedLine(fVar.aAY));
                        com.baidu.swan.apps.console.c.i("map", "initMapView createPoly");
                    }
                }
            }
        }
        if (cVar.aAv != null && cVar.aAv.size() > 0) {
            for (com.baidu.swan.apps.x.a.a.a aVar : cVar.aAv) {
                if (aVar.isValid()) {
                    map.addOverlay(new CircleOptions().center(new LatLng(aVar.aAr.latitude, aVar.aAr.longitude)).stroke(new Stroke((int) aVar.aAM, aVar.color)).fillColor(aVar.aAL).radius(aVar.radius));
                    com.baidu.swan.apps.console.c.i("map", "initMapView createCircle");
                }
            }
        }
        if (cVar.aAx != null && cVar.aAx.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (com.baidu.swan.apps.x.a.a.c cVar2 : cVar.aAx) {
                builder.include(new LatLng(cVar2.latitude, cVar2.longitude));
            }
            map.setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
            com.baidu.swan.apps.console.c.i("map", "initMapView includePoints");
        }
        if (cVar.aAy != null && !cVar.aAy.isEmpty()) {
            for (com.baidu.swan.apps.x.a.a.e eVar : cVar.aAy) {
                if (!eVar.isValid()) {
                    com.baidu.swan.apps.console.c.e("map", "polygon is invalid");
                } else {
                    ArrayList arrayList2 = new ArrayList(eVar.aAW.size());
                    Iterator<com.baidu.swan.apps.x.a.a.c> it2 = eVar.aAW.iterator();
                    while (it2.hasNext()) {
                        com.baidu.swan.apps.x.a.a.c next2 = it2.next();
                        arrayList2.add(new LatLng(next2.latitude, next2.longitude));
                    }
                    if (arrayList2.size() < 3 || arrayList2.contains(null)) {
                        com.baidu.swan.apps.console.c.e("map", "polygons count can't less than 3 or your polygons points contains null");
                    } else {
                        map.addOverlay(new PolygonOptions().points(arrayList2).stroke(new Stroke(eVar.strokeWidth, eVar.nM)).fillColor(eVar.aAL).zIndex(eVar.aAX));
                        com.baidu.swan.apps.console.c.i("map", "initMapView createPolygons");
                    }
                }
            }
        }
    }

    public static void a(Context context, com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.apps.x.a.c cVar, com.baidu.swan.impl.map.b bVar2) {
        a(context, bVar, cVar, bVar2, false);
    }

    private static void a(Context context, final com.baidu.swan.impl.map.b bVar) {
        d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.a.b.e.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                com.baidu.swan.impl.map.b.this.cW(true);
                com.baidu.swan.apps.console.c.i("map", "location permission success");
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                com.baidu.swan.apps.console.c.i("map", "location permission fail");
            }
        });
    }
}
