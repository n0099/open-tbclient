package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.al;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements al {
    public final /* synthetic */ BaiduMap a;

    @Override // com.baidu.platform.comapi.map.al
    public void a() {
    }

    public d(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(MotionEvent motionEvent) {
        BaiduMap.OnMapTouchListener onMapTouchListener;
        BaiduMap.OnMapTouchListener onMapTouchListener2;
        onMapTouchListener = this.a.r;
        if (onMapTouchListener == null) {
            return;
        }
        onMapTouchListener2 = this.a.r;
        onMapTouchListener2.onTouch(motionEvent);
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        onMapStatusChangeListener = this.a.q;
        if (onMapStatusChangeListener != null) {
            MapStatus a = MapStatus.a(xVar);
            onMapStatusChangeListener2 = this.a.q;
            onMapStatusChangeListener2.onMapStatusChange(a);
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        MapStatus a = MapStatus.a(xVar);
        onMapStatusChangeListener = this.a.q;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener2 = this.a.q;
            onMapStatusChangeListener2.onMapStatusChangeFinish(a);
        }
        onmapgesturelistener = this.a.s;
        if (onmapgesturelistener != null) {
            onmapgesturelistener2 = this.a.s;
            onmapgesturelistener2.onMapStatusChangeFinish(a);
        }
        BaiduMap.mapStatusReason = 0;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        int i;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener3;
        int i2 = BaiduMap.mapStatusReason;
        if ((i2 & 256) == 256) {
            i = 3;
        } else if ((i2 & 16) == 16) {
            i = 2;
        } else {
            i = 1;
        }
        onMapStatusChangeListener = this.a.q;
        if (onMapStatusChangeListener != null) {
            MapStatus a = MapStatus.a(xVar);
            onMapStatusChangeListener2 = this.a.q;
            onMapStatusChangeListener2.onMapStatusChangeStart(a);
            onMapStatusChangeListener3 = this.a.q;
            onMapStatusChangeListener3.onMapStatusChangeStart(a, i);
        }
        onSynchronizationListener = this.a.I;
        if (onSynchronizationListener != null) {
            onSynchronizationListener2 = this.a.I;
            onSynchronizationListener2.onMapStatusChangeReason(i);
        }
        BaiduMap.mapStatusReason = 0;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(GeoPoint geoPoint) {
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        onMapClickListener = this.a.t;
        if (onMapClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapClickListener2 = this.a.t;
            onMapClickListener2.onMapClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b(GeoPoint geoPoint) {
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener;
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener2;
        onMapDoubleClickListener = this.a.w;
        if (onMapDoubleClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            BaiduMap.mapStatusReason |= 1;
            onMapDoubleClickListener2 = this.a.w;
            onMapDoubleClickListener2.onMapDoubleClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c(GeoPoint geoPoint) {
        BaiduMap.OnMapLongClickListener onMapLongClickListener;
        BaiduMap.OnMapLongClickListener onMapLongClickListener2;
        onMapLongClickListener = this.a.x;
        if (onMapLongClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapLongClickListener2 = this.a.x;
            onMapLongClickListener2.onMapLongClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(String str) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        List<Overlay> list;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        List<Overlay> list2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4;
        Map map;
        List<Overlay> list3;
        CopyOnWriteArrayList copyOnWriteArrayList5;
        CopyOnWriteArrayList copyOnWriteArrayList6;
        Map map2;
        com.baidu.mapsdkplatform.comapi.map.d dVar2;
        com.baidu.mapsdkplatform.comapi.map.d dVar3;
        com.baidu.mapsdkplatform.comapi.map.d dVar4;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener2;
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar = this.a.j;
            GeoPoint b = dVar.b(jSONObject.optInt("px"), jSONObject.optInt(Config.PY));
            JSONArray optJSONArray = jSONObject.optJSONArray("dataset");
            JSONObject jSONObject2 = null;
            int i = -1;
            if (optJSONArray != null && (jSONObject2 = optJSONArray.optJSONObject(0)) != null) {
                i = jSONObject2.optInt("ty");
            }
            if (i == 17) {
                onMapClickListener = this.a.t;
                if (onMapClickListener != null) {
                    MapPoi mapPoi = new MapPoi();
                    mapPoi.a(jSONObject2);
                    onMapClickListener2 = this.a.t;
                    onMapClickListener2.onMapPoiClick(mapPoi);
                }
            } else if (i == 18) {
                onMyLocationClickListener = this.a.C;
                if (onMyLocationClickListener != null) {
                    onMyLocationClickListener2 = this.a.C;
                    onMyLocationClickListener2.onMyLocationClick();
                    return;
                }
                a(b);
            } else if (i == 19) {
                dVar2 = this.a.j;
                if (dVar2 != null) {
                    dVar3 = this.a.j;
                    com.baidu.mapsdkplatform.comapi.map.x D = dVar3.D();
                    if (D == null) {
                        return;
                    }
                    D.c = 0;
                    D.b = 0;
                    BaiduMap.mapStatusReason |= 16;
                    dVar4 = this.a.j;
                    dVar4.a(D, 300);
                }
            } else {
                String str2 = "";
                if (i == 90909) {
                    if (jSONObject2 != null) {
                        str2 = jSONObject2.optString("marker_id");
                    }
                    map = this.a.N;
                    Set<String> keySet = map.keySet();
                    if (keySet.isEmpty() || !keySet.contains(str2)) {
                        list3 = this.a.k;
                        for (Overlay overlay : list3) {
                            if ((overlay instanceof Marker) && overlay.F.equals(str2)) {
                                copyOnWriteArrayList5 = this.a.y;
                                if (!copyOnWriteArrayList5.isEmpty()) {
                                    copyOnWriteArrayList6 = this.a.y;
                                    Iterator it = copyOnWriteArrayList6.iterator();
                                    while (it.hasNext()) {
                                        ((BaiduMap.OnMarkerClickListener) it.next()).onMarkerClick((Marker) overlay);
                                    }
                                    return;
                                }
                                a(b);
                            }
                        }
                        return;
                    }
                    for (String str3 : keySet) {
                        if (str3 != null && str3.equals(str2)) {
                            map2 = this.a.N;
                            InfoWindow infoWindow = (InfoWindow) map2.get(str3);
                            if (infoWindow != null && infoWindow.e != null) {
                                infoWindow.e.onInfoWindowClick();
                                return;
                            } else {
                                a(b);
                                return;
                            }
                        }
                    }
                } else if (i == 90910) {
                    if (jSONObject2 != null) {
                        str2 = jSONObject2.optString("polyline_id");
                    }
                    list2 = this.a.k;
                    for (Overlay overlay2 : list2) {
                        if ((overlay2 instanceof Polyline) && overlay2.F.equals(str2)) {
                            copyOnWriteArrayList3 = this.a.z;
                            if (!copyOnWriteArrayList3.isEmpty()) {
                                copyOnWriteArrayList4 = this.a.z;
                                Iterator it2 = copyOnWriteArrayList4.iterator();
                                while (it2.hasNext()) {
                                    ((BaiduMap.OnPolylineClickListener) it2.next()).onPolylineClick((Polyline) overlay2);
                                }
                            } else {
                                a(b);
                            }
                        }
                    }
                } else if (i == 90911) {
                    if (jSONObject2 != null) {
                        str2 = jSONObject2.optString("multipoint_id");
                    }
                    list = this.a.k;
                    for (Overlay overlay3 : list) {
                        if ((overlay3 instanceof MultiPoint) && overlay3.F.equals(str2)) {
                            copyOnWriteArrayList = this.a.A;
                            if (!copyOnWriteArrayList.isEmpty()) {
                                copyOnWriteArrayList2 = this.a.A;
                                Iterator it3 = copyOnWriteArrayList2.iterator();
                                while (it3.hasNext()) {
                                    BaiduMap.OnMultiPointClickListener onMultiPointClickListener = (BaiduMap.OnMultiPointClickListener) it3.next();
                                    MultiPoint multiPoint = (MultiPoint) overlay3;
                                    List<MultiPointItem> multiPointItems = multiPoint.getMultiPointItems();
                                    if (jSONObject2 != null) {
                                        int optInt = jSONObject2.optInt("multipoint_index");
                                        if (multiPointItems != null && optInt >= 0 && multiPointItems.size() > optInt) {
                                            onMultiPointClickListener.onMultiPointClick(multiPoint, multiPointItems.get(optInt));
                                        }
                                    }
                                }
                            } else {
                                a(b);
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        Map map;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback2;
        Map map2;
        Map map3;
        View view2;
        map = this.a.N;
        if (map != null) {
            map2 = this.a.N;
            if (!map2.values().isEmpty()) {
                map3 = this.a.N;
                for (InfoWindow infoWindow : map3.values()) {
                    if (infoWindow != null && (view2 = infoWindow.c) != null) {
                        view2.post(new e(this, infoWindow));
                    }
                }
            }
        }
        onMapDrawFrameCallback = this.a.E;
        if (onMapDrawFrameCallback != null) {
            MapStatus a = MapStatus.a(xVar);
            onMapDrawFrameCallback2 = this.a.E;
            onMapDrawFrameCallback2.onMapDrawFrame(a);
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(boolean z) {
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener;
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener2;
        onBaseIndoorMapListener = this.a.F;
        if (onBaseIndoorMapListener != null) {
            MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = this.a.getFocusedBaseIndoorMapInfo();
            onBaseIndoorMapListener2 = this.a.F;
            onBaseIndoorMapListener2.onBaseIndoorMapMode(z, focusedBaseIndoorMapInfo);
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(boolean z, int i) {
        BaiduMap.OnMapRenderValidDataListener onMapRenderValidDataListener;
        String a;
        BaiduMap.OnMapRenderValidDataListener onMapRenderValidDataListener2;
        onMapRenderValidDataListener = this.a.G;
        if (onMapRenderValidDataListener == null) {
            return;
        }
        a = this.a.a(i);
        onMapRenderValidDataListener2 = this.a.G;
        onMapRenderValidDataListener2.onMapRenderValidData(z, i, a);
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a = MapStatus.a(xVar);
        onmapgesturelistener = this.a.s;
        if (onmapgesturelistener != null) {
            BaiduMap.mapStatusReason = 1;
            onmapgesturelistener2 = this.a.s;
            return onmapgesturelistener2.onMapKneading(point, point2, a);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean b(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a = MapStatus.a(xVar);
        onmapgesturelistener = this.a.s;
        if (onmapgesturelistener != null) {
            BaiduMap.mapStatusReason = 1;
            onmapgesturelistener2 = this.a.s;
            return onmapgesturelistener2.onMapScroll(point, point2, a);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean c(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a = MapStatus.a(xVar);
        onmapgesturelistener = this.a.s;
        if (onmapgesturelistener != null) {
            BaiduMap.mapStatusReason = 1;
            onmapgesturelistener2 = this.a.s;
            return onmapgesturelistener2.onMapOverLooking(point, point2, a);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean d(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a = MapStatus.a(xVar);
        onmapgesturelistener = this.a.s;
        if (onmapgesturelistener != null) {
            BaiduMap.mapStatusReason = 1;
            onmapgesturelistener2 = this.a.s;
            return onmapgesturelistener2.onMapTwoClick(point, point2, a);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(Point point, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a = MapStatus.a(xVar);
        onmapgesturelistener = this.a.s;
        if (onmapgesturelistener != null) {
            BaiduMap.mapStatusReason = 1;
            onmapgesturelistener2 = this.a.s;
            return onmapgesturelistener2.onMapDoubleTouch(point, a);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(MotionEvent motionEvent, float f, float f2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        BaiduMap.onMapGestureListener onmapgesturelistener;
        BaiduMap.onMapGestureListener onmapgesturelistener2;
        MapStatus a = MapStatus.a(xVar);
        onmapgesturelistener = this.a.s;
        if (onmapgesturelistener != null) {
            BaiduMap.mapStatusReason = 1;
            onmapgesturelistener2 = this.a.s;
            return onmapgesturelistener2.onMapFling(motionEvent, f, f2, a);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback2;
        BaiduMap baiduMap = this.a;
        dVar = baiduMap.j;
        baiduMap.f = new Projection(dVar);
        this.a.V = true;
        onMapLoadedCallback = this.a.u;
        if (onMapLoadedCallback != null) {
            onMapLoadedCallback2 = this.a.u;
            onMapLoadedCallback2.onMapLoaded();
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c() {
        BaiduMap.OnMapRenderCallback onMapRenderCallback;
        BaiduMap.OnMapRenderCallback onMapRenderCallback2;
        onMapRenderCallback = this.a.v;
        if (onMapRenderCallback != null) {
            onMapRenderCallback2 = this.a.v;
            onMapRenderCallback2.onMapRenderFinished();
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean b(String str) {
        JSONObject optJSONObject;
        Map map;
        List<Overlay> list;
        Projection projection;
        Marker marker;
        Projection projection2;
        Marker marker2;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker3;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("dataset");
            if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || optJSONObject.optInt("ty") != 90909) {
                return false;
            }
            String optString = optJSONObject.optString("marker_id");
            map = this.a.N;
            Set keySet = map.keySet();
            if (keySet.isEmpty() || !keySet.contains(optString)) {
                list = this.a.k;
                for (Overlay overlay : list) {
                    if ((overlay instanceof Marker) && overlay.F.equals(optString)) {
                        Marker marker4 = (Marker) overlay;
                        if (marker4.f) {
                            this.a.P = marker4;
                            projection = this.a.f;
                            marker = this.a.P;
                            Point screenLocation = projection.toScreenLocation(marker.a);
                            Point point = new Point(screenLocation.x, screenLocation.y - 60);
                            projection2 = this.a.f;
                            LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                            marker2 = this.a.P;
                            marker2.setPosition(fromScreenLocation);
                            onMarkerDragListener = this.a.B;
                            if (onMarkerDragListener != null) {
                                onMarkerDragListener2 = this.a.B;
                                marker3 = this.a.P;
                                onMarkerDragListener2.onMarkerDragStart(marker3);
                            }
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void d() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        com.baidu.mapsdkplatform.comapi.map.d dVar2;
        dVar = this.a.j;
        if (dVar != null) {
            dVar2 = this.a.j;
            dVar2.c(false);
        }
        lock = this.a.L;
        lock.lock();
        try {
            heatMap = this.a.K;
            if (heatMap != null) {
                BaiduMap baiduMap = this.a;
                heatMap2 = this.a.K;
                baiduMap.a(heatMap2);
            }
        } finally {
            lock2 = this.a.L;
            lock2.unlock();
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void d(GeoPoint geoPoint) {
        Marker marker;
        Marker marker2;
        Projection projection;
        Projection projection2;
        Marker marker3;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        Marker marker4;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker5;
        marker = this.a.P;
        if (marker != null) {
            marker2 = this.a.P;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.a.f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.a.P;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.a.B;
                if (onMarkerDragListener != null) {
                    marker4 = this.a.P;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.a.B;
                        marker5 = this.a.P;
                        onMarkerDragListener2.onMarkerDrag(marker5);
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.al
    public void e(GeoPoint geoPoint) {
        Marker marker;
        Marker marker2;
        Projection projection;
        Projection projection2;
        Marker marker3;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        Marker marker4;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker5;
        marker = this.a.P;
        if (marker != null) {
            marker2 = this.a.P;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.a.f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.a.P;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.a.B;
                if (onMarkerDragListener != null) {
                    marker4 = this.a.P;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.a.B;
                        marker5 = this.a.P;
                        onMarkerDragListener2.onMarkerDragEnd(marker5);
                    }
                }
                this.a.P = null;
            }
        }
    }
}
