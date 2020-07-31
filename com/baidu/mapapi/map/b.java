package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mobstat.Config;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b implements com.baidu.mapsdkplatform.comapi.map.l {
    final /* synthetic */ BaiduMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback2;
        snapshotReadyCallback = this.a.z;
        if (snapshotReadyCallback != null) {
            snapshotReadyCallback2 = this.a.z;
            snapshotReadyCallback2.onSnapshotReady(bitmap);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(MotionEvent motionEvent) {
        BaiduMap.OnMapTouchListener onMapTouchListener;
        BaiduMap.OnMapTouchListener onMapTouchListener2;
        onMapTouchListener = this.a.p;
        if (onMapTouchListener != null) {
            onMapTouchListener2 = this.a.p;
            onMapTouchListener2.onTouch(motionEvent);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GeoPoint geoPoint) {
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        onMapClickListener = this.a.q;
        if (onMapClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapClickListener2 = this.a.q;
            onMapClickListener2.onMapClick(mc2ll);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(ab abVar) {
        View view;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener3;
        View view2;
        view = this.a.J;
        if (view != null) {
            view2 = this.a.J;
            view2.setVisibility(4);
        }
        int i = (BaiduMap.mapStatusReason & 256) == 256 ? 3 : (BaiduMap.mapStatusReason & 16) == 16 ? 2 : 1;
        onMapStatusChangeListener = this.a.o;
        if (onMapStatusChangeListener != null) {
            MapStatus a = MapStatus.a(abVar);
            onMapStatusChangeListener2 = this.a.o;
            onMapStatusChangeListener2.onMapStatusChangeStart(a);
            onMapStatusChangeListener3 = this.a.o;
            onMapStatusChangeListener3.onMapStatusChangeStart(a, i);
        }
        onSynchronizationListener = this.a.C;
        if (onSynchronizationListener != null) {
            onSynchronizationListener2 = this.a.C;
            onSynchronizationListener2.onMapStatusChangeReason(i);
        }
        BaiduMap.mapStatusReason = 0;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(String str) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        List<Overlay> list;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        InfoWindow infoWindow;
        List<Overlay> list2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4;
        Marker marker;
        InfoWindow infoWindow2;
        com.baidu.mapsdkplatform.comapi.map.e eVar2;
        com.baidu.mapsdkplatform.comapi.map.e eVar3;
        com.baidu.mapsdkplatform.comapi.map.e eVar4;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener2;
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONArray(ActionJsonData.TAG_DATASET).optJSONObject(0);
            eVar = this.a.i;
            GeoPoint b = eVar.b(jSONObject.optInt("px"), jSONObject.optInt("py"));
            int optInt = optJSONObject.optInt(Config.EXCEPTION_CRASH_CHANNEL);
            if (optInt == 17) {
                onMapClickListener = this.a.q;
                if (onMapClickListener != null) {
                    MapPoi mapPoi = new MapPoi();
                    mapPoi.a(optJSONObject);
                    onMapClickListener2 = this.a.q;
                    onMapClickListener2.onMapPoiClick(mapPoi);
                }
            } else if (optInt == 18) {
                onMyLocationClickListener = this.a.y;
                if (onMyLocationClickListener == null) {
                    a(b);
                    return;
                }
                onMyLocationClickListener2 = this.a.y;
                onMyLocationClickListener2.onMyLocationClick();
            } else if (optInt == 19) {
                eVar2 = this.a.i;
                if (eVar2 != null) {
                    eVar3 = this.a.i;
                    ab E = eVar3.E();
                    if (E != null) {
                        E.c = 0;
                        E.b = 0;
                        BaiduMap.mapStatusReason |= 16;
                        eVar4 = this.a.i;
                        eVar4.a(E, 300);
                    }
                }
            } else if (optInt != 90909) {
                if (optInt == 90910) {
                    String optString = optJSONObject.optString("polyline_id");
                    list = this.a.k;
                    for (Overlay overlay : list) {
                        if ((overlay instanceof Polyline) && overlay.v.equals(optString)) {
                            copyOnWriteArrayList = this.a.w;
                            if (copyOnWriteArrayList.isEmpty()) {
                                a(b);
                            } else {
                                copyOnWriteArrayList2 = this.a.w;
                                Iterator it = copyOnWriteArrayList2.iterator();
                                while (it.hasNext()) {
                                    ((BaiduMap.OnPolylineClickListener) it.next()).onPolylineClick((Polyline) overlay);
                                }
                            }
                        }
                    }
                }
            } else {
                String optString2 = optJSONObject.optString("marker_id");
                infoWindow = this.a.H;
                if (infoWindow != null) {
                    marker = this.a.I;
                    if (optString2.equals(marker.v)) {
                        infoWindow2 = this.a.H;
                        InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener = infoWindow2.d;
                        if (onInfoWindowClickListener != null) {
                            onInfoWindowClickListener.onInfoWindowClick();
                            return;
                        } else {
                            a(b);
                            return;
                        }
                    }
                }
                list2 = this.a.k;
                for (Overlay overlay2 : list2) {
                    if ((overlay2 instanceof Marker) && overlay2.v.equals(optString2)) {
                        copyOnWriteArrayList3 = this.a.v;
                        if (!copyOnWriteArrayList3.isEmpty()) {
                            copyOnWriteArrayList4 = this.a.v;
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GL10 gl10, ab abVar) {
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback2;
        onMapDrawFrameCallback = this.a.A;
        if (onMapDrawFrameCallback != null) {
            MapStatus a = MapStatus.a(abVar);
            onMapDrawFrameCallback2 = this.a.A;
            onMapDrawFrameCallback2.onMapDrawFrame(a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(boolean z) {
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener;
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener2;
        onBaseIndoorMapListener = this.a.B;
        if (onBaseIndoorMapListener != null) {
            MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = this.a.getFocusedBaseIndoorMapInfo();
            onBaseIndoorMapListener2 = this.a.B;
            onBaseIndoorMapListener2.onBaseIndoorMapMode(z, focusedBaseIndoorMapInfo);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback2;
        BaiduMap baiduMap = this.a;
        eVar = this.a.i;
        baiduMap.f = new Projection(eVar);
        this.a.Q = true;
        onMapLoadedCallback = this.a.r;
        if (onMapLoadedCallback != null) {
            onMapLoadedCallback2 = this.a.r;
            onMapLoadedCallback2.onMapLoaded();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(GeoPoint geoPoint) {
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener;
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener2;
        onMapDoubleClickListener = this.a.t;
        if (onMapDoubleClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapDoubleClickListener2 = this.a.t;
            onMapDoubleClickListener2.onMapDoubleClick(mc2ll);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(ab abVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        onMapStatusChangeListener = this.a.o;
        if (onMapStatusChangeListener != null) {
            MapStatus a = MapStatus.a(abVar);
            onMapStatusChangeListener2 = this.a.o;
            onMapStatusChangeListener2.onMapStatusChange(a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
        r0 = (com.baidu.mapapi.map.Marker) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r0.f == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0063, code lost:
        r5.a.K = r0;
        r0 = r5.a.f;
        r2 = r5.a.K;
        r0 = r0.toScreenLocation(r2.a);
        r2 = new android.graphics.Point(r0.x, r0.y - 60);
        r0 = r5.a.f;
        r0 = r0.fromScreenLocation(r2);
        r2 = r5.a.K;
        r2.setPosition(r0);
        r0 = r5.a.x;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009e, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a0, code lost:
        r0 = r5.a.x;
        r2 = r5.a.K;
        r0.onMarkerDragStart(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00af, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
        if (r2.equals(r0.v) == false) goto L9;
     */
    @Override // com.baidu.mapsdkplatform.comapi.map.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str) {
        Marker marker;
        List list;
        Marker marker2;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONArray(ActionJsonData.TAG_DATASET).optJSONObject(0);
            if (optJSONObject.optInt(Config.EXCEPTION_CRASH_CHANNEL) == 90909) {
                String optString = optJSONObject.optString("marker_id");
                marker = this.a.I;
                if (marker != null) {
                    marker2 = this.a.I;
                }
                list = this.a.k;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Overlay overlay = (Overlay) it.next();
                    if ((overlay instanceof Marker) && overlay.v.equals(optString)) {
                        break;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c() {
        BaiduMap.OnMapRenderCallback onMapRenderCallback;
        BaiduMap.OnMapRenderCallback onMapRenderCallback2;
        onMapRenderCallback = this.a.s;
        if (onMapRenderCallback != null) {
            onMapRenderCallback2 = this.a.s;
            onMapRenderCallback2.onMapRenderFinished();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(GeoPoint geoPoint) {
        BaiduMap.OnMapLongClickListener onMapLongClickListener;
        BaiduMap.OnMapLongClickListener onMapLongClickListener2;
        onMapLongClickListener = this.a.u;
        if (onMapLongClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapLongClickListener2 = this.a.u;
            onMapLongClickListener2.onMapLongClick(mc2ll);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(ab abVar) {
        View view;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        View view2;
        view = this.a.J;
        if (view != null) {
            view2 = this.a.J;
            view2.setVisibility(0);
        }
        onMapStatusChangeListener = this.a.o;
        if (onMapStatusChangeListener != null) {
            MapStatus a = MapStatus.a(abVar);
            onMapStatusChangeListener2 = this.a.o;
            onMapStatusChangeListener2.onMapStatusChangeFinish(a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void d() {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        lock = this.a.F;
        lock.lock();
        try {
            heatMap = this.a.E;
            if (heatMap != null) {
                heatMap2 = this.a.E;
                heatMap2.a();
            }
        } finally {
            lock2 = this.a.F;
            lock2.unlock();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
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
        marker = this.a.K;
        if (marker != null) {
            marker2 = this.a.K;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.a.f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.a.K;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.a.x;
                if (onMarkerDragListener != null) {
                    marker4 = this.a.K;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.a.x;
                        marker5 = this.a.K;
                        onMarkerDragListener2.onMarkerDrag(marker5);
                    }
                }
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void e() {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        lock = this.a.F;
        lock.lock();
        try {
            heatMap = this.a.E;
            if (heatMap != null) {
                heatMap2 = this.a.E;
                heatMap2.a();
                eVar = this.a.i;
                eVar.o();
            }
        } finally {
            lock2 = this.a.F;
            lock2.unlock();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
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
        marker = this.a.K;
        if (marker != null) {
            marker2 = this.a.K;
            if (marker2.f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.a.f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.a.f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.a.K;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.a.x;
                if (onMarkerDragListener != null) {
                    marker4 = this.a.K;
                    if (marker4.f) {
                        onMarkerDragListener2 = this.a.x;
                        marker5 = this.a.K;
                        onMarkerDragListener2.onMarkerDragEnd(marker5);
                    }
                }
                this.a.K = null;
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void f() {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        eVar = this.a.i;
        eVar.b(false);
        lock = this.a.F;
        lock.lock();
        try {
            heatMap = this.a.E;
            if (heatMap != null) {
                BaiduMap baiduMap = this.a;
                heatMap2 = this.a.E;
                baiduMap.a(heatMap2);
            }
        } finally {
            lock2 = this.a.F;
            lock2.unlock();
        }
    }
}
