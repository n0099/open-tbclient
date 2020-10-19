package com.baidu.mapapi.map;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements com.baidu.platform.comapi.map.ag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BaiduMap f2067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BaiduMap baiduMap) {
        this.f2067a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a() {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(MotionEvent motionEvent) {
        BaiduMap.OnMapTouchListener onMapTouchListener;
        BaiduMap.OnMapTouchListener onMapTouchListener2;
        onMapTouchListener = this.f2067a.r;
        if (onMapTouchListener != null) {
            onMapTouchListener2 = this.f2067a.r;
            onMapTouchListener2.onTouch(motionEvent);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(com.baidu.mapsdkplatform.comapi.map.w wVar) {
        Map map;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener3;
        Map map2;
        map = this.f2067a.K;
        if (!map.values().isEmpty()) {
            map2 = this.f2067a.K;
            for (InfoWindow infoWindow : map2.values()) {
                if (infoWindow.b != null && !infoWindow.i) {
                    infoWindow.b.setVisibility(4);
                }
            }
        }
        int i = (BaiduMap.mapStatusReason & 256) == 256 ? 3 : (BaiduMap.mapStatusReason & 16) == 16 ? 2 : 1;
        onMapStatusChangeListener = this.f2067a.q;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(wVar);
            onMapStatusChangeListener2 = this.f2067a.q;
            onMapStatusChangeListener2.onMapStatusChangeStart(a2);
            onMapStatusChangeListener3 = this.f2067a.q;
            onMapStatusChangeListener3.onMapStatusChangeStart(a2, i);
        }
        onSynchronizationListener = this.f2067a.F;
        if (onSynchronizationListener != null) {
            onSynchronizationListener2 = this.f2067a.F;
            onSynchronizationListener2.onMapStatusChangeReason(i);
        }
        BaiduMap.mapStatusReason = 0;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(GeoPoint geoPoint) {
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        onMapClickListener = this.f2067a.s;
        if (onMapClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapClickListener2 = this.f2067a.s;
            onMapClickListener2.onMapClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(String str) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        List<Overlay> list;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        Map map;
        List<Overlay> list2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4;
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
            dVar = this.f2067a.j;
            GeoPoint b = dVar.b(jSONObject.optInt("px"), jSONObject.optInt("py"));
            JSONArray optJSONArray = jSONObject.optJSONArray("dataset");
            JSONObject jSONObject2 = null;
            int i = -1;
            if (optJSONArray != null && (jSONObject2 = optJSONArray.optJSONObject(0)) != null) {
                i = jSONObject2.optInt("ty");
            }
            if (i == 17) {
                onMapClickListener = this.f2067a.s;
                if (onMapClickListener != null) {
                    MapPoi mapPoi = new MapPoi();
                    mapPoi.a(jSONObject2);
                    onMapClickListener2 = this.f2067a.s;
                    onMapClickListener2.onMapPoiClick(mapPoi);
                }
            } else if (i == 18) {
                onMyLocationClickListener = this.f2067a.A;
                if (onMyLocationClickListener == null) {
                    a(b);
                    return;
                }
                onMyLocationClickListener2 = this.f2067a.A;
                onMyLocationClickListener2.onMyLocationClick();
            } else if (i == 19) {
                dVar2 = this.f2067a.j;
                if (dVar2 != null) {
                    dVar3 = this.f2067a.j;
                    com.baidu.mapsdkplatform.comapi.map.w B = dVar3.B();
                    if (B != null) {
                        B.c = 0;
                        B.b = 0;
                        BaiduMap.mapStatusReason |= 16;
                        dVar4 = this.f2067a.j;
                        dVar4.a(B, 300);
                    }
                }
            } else if (i != 90909) {
                if (i == 90910) {
                    String optString = jSONObject2 != null ? jSONObject2.optString("polyline_id") : "";
                    list = this.f2067a.k;
                    for (Overlay overlay : list) {
                        if ((overlay instanceof Polyline) && overlay.z.equals(optString)) {
                            copyOnWriteArrayList = this.f2067a.y;
                            if (copyOnWriteArrayList.isEmpty()) {
                                a(b);
                            } else {
                                copyOnWriteArrayList2 = this.f2067a.y;
                                Iterator it = copyOnWriteArrayList2.iterator();
                                while (it.hasNext()) {
                                    ((BaiduMap.OnPolylineClickListener) it.next()).onPolylineClick((Polyline) overlay);
                                }
                            }
                        }
                    }
                }
            } else {
                String optString2 = jSONObject2 != null ? jSONObject2.optString("marker_id") : "";
                map = this.f2067a.K;
                Set<String> keySet = map.keySet();
                if (!keySet.isEmpty() && keySet.contains(optString2)) {
                    for (String str2 : keySet) {
                        if (str2 != null && str2.equals(optString2)) {
                            map2 = this.f2067a.K;
                            InfoWindow infoWindow = (InfoWindow) map2.get(str2);
                            if (infoWindow == null || infoWindow.d == null) {
                                a(b);
                                return;
                            } else {
                                infoWindow.d.onInfoWindowClick();
                                return;
                            }
                        }
                    }
                    return;
                }
                list2 = this.f2067a.k;
                for (Overlay overlay2 : list2) {
                    if ((overlay2 instanceof Marker) && overlay2.z.equals(optString2)) {
                        copyOnWriteArrayList3 = this.f2067a.x;
                        if (!copyOnWriteArrayList3.isEmpty()) {
                            copyOnWriteArrayList4 = this.f2067a.x;
                            Iterator it2 = copyOnWriteArrayList4.iterator();
                            while (it2.hasNext()) {
                                ((BaiduMap.OnMarkerClickListener) it2.next()).onMarkerClick((Marker) overlay2);
                            }
                            return;
                        }
                        a(b);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback2;
        onMapDrawFrameCallback = this.f2067a.C;
        if (onMapDrawFrameCallback != null) {
            MapStatus a2 = MapStatus.a(wVar);
            onMapDrawFrameCallback2 = this.f2067a.C;
            onMapDrawFrameCallback2.onMapDrawFrame(a2);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(boolean z) {
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener;
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener2;
        onBaseIndoorMapListener = this.f2067a.D;
        if (onBaseIndoorMapListener != null) {
            MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = this.f2067a.getFocusedBaseIndoorMapInfo();
            onBaseIndoorMapListener2 = this.f2067a.D;
            onBaseIndoorMapListener2.onBaseIndoorMapMode(z, focusedBaseIndoorMapInfo);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback2;
        BaiduMap baiduMap = this.f2067a;
        dVar = this.f2067a.j;
        baiduMap.f = new Projection(dVar);
        this.f2067a.S = true;
        onMapLoadedCallback = this.f2067a.t;
        if (onMapLoadedCallback != null) {
            onMapLoadedCallback2 = this.f2067a.t;
            onMapLoadedCallback2.onMapLoaded();
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b(com.baidu.mapsdkplatform.comapi.map.w wVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        onMapStatusChangeListener = this.f2067a.q;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(wVar);
            onMapStatusChangeListener2 = this.f2067a.q;
            onMapStatusChangeListener2.onMapStatusChange(a2);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b(GeoPoint geoPoint) {
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener;
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener2;
        onMapDoubleClickListener = this.f2067a.v;
        if (onMapDoubleClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapDoubleClickListener2 = this.f2067a.v;
            onMapDoubleClickListener2.onMapDoubleClick(mc2ll);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
        r0 = (com.baidu.mapapi.map.Marker) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r0.f == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
        r5.f2067a.M = r0;
        r0 = r5.f2067a.f;
        r2 = r5.f2067a.M;
        r0 = r0.toScreenLocation(r2.f2027a);
        r2 = new android.graphics.Point(r0.x, r0.y - 60);
        r0 = r5.f2067a.f;
        r0 = r0.fromScreenLocation(r2);
        r2 = r5.f2067a.M;
        r2.setPosition(r0);
        r0 = r5.f2067a.z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009e, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a0, code lost:
        r0 = r5.f2067a.z;
        r2 = r5.f2067a.M;
        r0.onMarkerDragStart(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00af, code lost:
        return true;
     */
    @Override // com.baidu.platform.comapi.map.ag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str) {
        Map map;
        List list;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONArray("dataset").optJSONObject(0);
            if (optJSONObject.optInt("ty") == 90909) {
                String optString = optJSONObject.optString("marker_id");
                map = this.f2067a.K;
                Set keySet = map.keySet();
                if (keySet.isEmpty() || !keySet.contains(optString)) {
                    list = this.f2067a.k;
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Overlay overlay = (Overlay) it.next();
                        if ((overlay instanceof Marker) && overlay.z.equals(optString)) {
                            break;
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void c() {
        BaiduMap.OnMapRenderCallback onMapRenderCallback;
        BaiduMap.OnMapRenderCallback onMapRenderCallback2;
        onMapRenderCallback = this.f2067a.u;
        if (onMapRenderCallback != null) {
            onMapRenderCallback2 = this.f2067a.u;
            onMapRenderCallback2.onMapRenderFinished();
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void c(com.baidu.mapsdkplatform.comapi.map.w wVar) {
        Map map;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        Map map2;
        map = this.f2067a.K;
        if (!map.values().isEmpty()) {
            map2 = this.f2067a.K;
            for (InfoWindow infoWindow : map2.values()) {
                View view = infoWindow.b;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        }
        onMapStatusChangeListener = this.f2067a.q;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(wVar);
            onMapStatusChangeListener2 = this.f2067a.q;
            onMapStatusChangeListener2.onMapStatusChangeFinish(a2);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void c(GeoPoint geoPoint) {
        BaiduMap.OnMapLongClickListener onMapLongClickListener;
        BaiduMap.OnMapLongClickListener onMapLongClickListener2;
        onMapLongClickListener = this.f2067a.w;
        if (onMapLongClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapLongClickListener2 = this.f2067a.w;
            onMapLongClickListener2.onMapLongClick(mc2ll);
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void d() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        com.baidu.mapsdkplatform.comapi.map.d dVar2;
        dVar = this.f2067a.j;
        if (dVar != null) {
            dVar2 = this.f2067a.j;
            dVar2.b(false);
        }
        lock = this.f2067a.I;
        lock.lock();
        try {
            heatMap = this.f2067a.H;
            if (heatMap != null) {
                BaiduMap baiduMap = this.f2067a;
                heatMap2 = this.f2067a.H;
                baiduMap.a(heatMap2);
            }
        } finally {
            lock2 = this.f2067a.I;
            lock2.unlock();
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
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
        marker = this.f2067a.M;
        if (marker != null) {
            marker2 = this.f2067a.M;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.f2067a.f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.f2067a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.f2067a.M;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.f2067a.z;
                if (onMarkerDragListener != null) {
                    marker4 = this.f2067a.M;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.f2067a.z;
                        marker5 = this.f2067a.M;
                        onMarkerDragListener2.onMarkerDrag(marker5);
                    }
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
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
        marker = this.f2067a.M;
        if (marker != null) {
            marker2 = this.f2067a.M;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.f2067a.f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.f2067a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.f2067a.M;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.f2067a.z;
                if (onMarkerDragListener != null) {
                    marker4 = this.f2067a.M;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.f2067a.z;
                        marker5 = this.f2067a.M;
                        onMarkerDragListener2.onMarkerDragEnd(marker5);
                    }
                }
                this.f2067a.M = null;
            }
        }
    }
}
