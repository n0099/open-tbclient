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
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.mapsdkplatform.comapi.map.l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f7099a;

    public b(BaiduMap baiduMap) {
        this.f7099a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback2;
        snapshotReadyCallback = this.f7099a.z;
        if (snapshotReadyCallback != null) {
            snapshotReadyCallback2 = this.f7099a.z;
            snapshotReadyCallback2.onSnapshotReady(bitmap);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(MotionEvent motionEvent) {
        BaiduMap.OnMapTouchListener onMapTouchListener;
        BaiduMap.OnMapTouchListener onMapTouchListener2;
        onMapTouchListener = this.f7099a.p;
        if (onMapTouchListener != null) {
            onMapTouchListener2 = this.f7099a.p;
            onMapTouchListener2.onTouch(motionEvent);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GeoPoint geoPoint) {
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        onMapClickListener = this.f7099a.q;
        if (onMapClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapClickListener2 = this.f7099a.q;
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
        view = this.f7099a.J;
        if (view != null) {
            view2 = this.f7099a.J;
            view2.setVisibility(4);
        }
        int i = BaiduMap.mapStatusReason;
        int i2 = (i & 256) == 256 ? 3 : (i & 16) == 16 ? 2 : 1;
        onMapStatusChangeListener = this.f7099a.o;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(abVar);
            onMapStatusChangeListener2 = this.f7099a.o;
            onMapStatusChangeListener2.onMapStatusChangeStart(a2);
            onMapStatusChangeListener3 = this.f7099a.o;
            onMapStatusChangeListener3.onMapStatusChangeStart(a2, i2);
        }
        onSynchronizationListener = this.f7099a.C;
        if (onSynchronizationListener != null) {
            onSynchronizationListener2 = this.f7099a.C;
            onSynchronizationListener2.onMapStatusChangeReason(i2);
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
            eVar = this.f7099a.i;
            GeoPoint b2 = eVar.b(jSONObject.optInt("px"), jSONObject.optInt("py"));
            int optInt = optJSONObject.optInt("ty");
            if (optInt == 17) {
                onMapClickListener = this.f7099a.q;
                if (onMapClickListener != null) {
                    MapPoi mapPoi = new MapPoi();
                    mapPoi.a(optJSONObject);
                    onMapClickListener2 = this.f7099a.q;
                    onMapClickListener2.onMapPoiClick(mapPoi);
                    return;
                }
                return;
            }
            if (optInt != 18) {
                if (optInt == 19) {
                    eVar2 = this.f7099a.i;
                    if (eVar2 != null) {
                        eVar3 = this.f7099a.i;
                        ab E = eVar3.E();
                        if (E == null) {
                            return;
                        }
                        E.f7607c = 0;
                        E.f7606b = 0;
                        BaiduMap.mapStatusReason |= 16;
                        eVar4 = this.f7099a.i;
                        eVar4.a(E, 300);
                        return;
                    }
                    return;
                } else if (optInt != 90909) {
                    if (optInt == 90910) {
                        String optString = optJSONObject.optString("polyline_id");
                        list = this.f7099a.k;
                        for (Overlay overlay : list) {
                            if ((overlay instanceof Polyline) && overlay.v.equals(optString)) {
                                copyOnWriteArrayList = this.f7099a.w;
                                if (copyOnWriteArrayList.isEmpty()) {
                                    a(b2);
                                } else {
                                    copyOnWriteArrayList2 = this.f7099a.w;
                                    Iterator it = copyOnWriteArrayList2.iterator();
                                    while (it.hasNext()) {
                                        ((BaiduMap.OnPolylineClickListener) it.next()).onPolylineClick((Polyline) overlay);
                                    }
                                }
                            }
                        }
                        return;
                    }
                    return;
                } else {
                    String optString2 = optJSONObject.optString("marker_id");
                    infoWindow = this.f7099a.H;
                    if (infoWindow != null) {
                        marker = this.f7099a.I;
                        if (optString2.equals(marker.v)) {
                            infoWindow2 = this.f7099a.H;
                            InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener = infoWindow2.f6920d;
                            if (onInfoWindowClickListener != null) {
                                onInfoWindowClickListener.onInfoWindowClick();
                                return;
                            }
                        }
                    }
                    list2 = this.f7099a.k;
                    for (Overlay overlay2 : list2) {
                        if ((overlay2 instanceof Marker) && overlay2.v.equals(optString2)) {
                            copyOnWriteArrayList3 = this.f7099a.v;
                            if (!copyOnWriteArrayList3.isEmpty()) {
                                copyOnWriteArrayList4 = this.f7099a.v;
                                Iterator it2 = copyOnWriteArrayList4.iterator();
                                while (it2.hasNext()) {
                                    ((BaiduMap.OnMarkerClickListener) it2.next()).onMarkerClick((Marker) overlay2);
                                }
                                return;
                            }
                            a(b2);
                        }
                    }
                    return;
                }
            }
            onMyLocationClickListener = this.f7099a.y;
            if (onMyLocationClickListener != null) {
                onMyLocationClickListener2 = this.f7099a.y;
                onMyLocationClickListener2.onMyLocationClick();
                return;
            }
            a(b2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GL10 gl10, ab abVar) {
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback2;
        onMapDrawFrameCallback = this.f7099a.A;
        if (onMapDrawFrameCallback != null) {
            MapStatus a2 = MapStatus.a(abVar);
            onMapDrawFrameCallback2 = this.f7099a.A;
            onMapDrawFrameCallback2.onMapDrawFrame(a2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(boolean z) {
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener;
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener2;
        onBaseIndoorMapListener = this.f7099a.B;
        if (onBaseIndoorMapListener != null) {
            MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = this.f7099a.getFocusedBaseIndoorMapInfo();
            onBaseIndoorMapListener2 = this.f7099a.B;
            onBaseIndoorMapListener2.onBaseIndoorMapMode(z, focusedBaseIndoorMapInfo);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback2;
        BaiduMap baiduMap = this.f7099a;
        eVar = baiduMap.i;
        baiduMap.f6847f = new Projection(eVar);
        this.f7099a.Q = true;
        onMapLoadedCallback = this.f7099a.r;
        if (onMapLoadedCallback != null) {
            onMapLoadedCallback2 = this.f7099a.r;
            onMapLoadedCallback2.onMapLoaded();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(GeoPoint geoPoint) {
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener;
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener2;
        onMapDoubleClickListener = this.f7099a.t;
        if (onMapDoubleClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapDoubleClickListener2 = this.f7099a.t;
            onMapDoubleClickListener2.onMapDoubleClick(mc2ll);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(ab abVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        onMapStatusChangeListener = this.f7099a.o;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(abVar);
            onMapStatusChangeListener2 = this.f7099a.o;
            onMapStatusChangeListener2.onMapStatusChange(a2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public boolean b(String str) {
        Marker marker;
        List<Overlay> list;
        Projection projection;
        Marker marker2;
        Projection projection2;
        Marker marker3;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker4;
        Marker marker5;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONArray(ActionJsonData.TAG_DATASET).optJSONObject(0);
            if (optJSONObject.optInt("ty") == 90909) {
                String optString = optJSONObject.optString("marker_id");
                marker = this.f7099a.I;
                if (marker != null) {
                    marker5 = this.f7099a.I;
                    if (optString.equals(marker5.v)) {
                        return false;
                    }
                }
                list = this.f7099a.k;
                for (Overlay overlay : list) {
                    if ((overlay instanceof Marker) && overlay.v.equals(optString)) {
                        Marker marker6 = (Marker) overlay;
                        if (marker6.f6982f) {
                            this.f7099a.K = marker6;
                            projection = this.f7099a.f6847f;
                            marker2 = this.f7099a.K;
                            Point screenLocation = projection.toScreenLocation(marker2.f6977a);
                            Point point = new Point(screenLocation.x, screenLocation.y - 60);
                            projection2 = this.f7099a.f6847f;
                            LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                            marker3 = this.f7099a.K;
                            marker3.setPosition(fromScreenLocation);
                            onMarkerDragListener = this.f7099a.x;
                            if (onMarkerDragListener != null) {
                                onMarkerDragListener2 = this.f7099a.x;
                                marker4 = this.f7099a.K;
                                onMarkerDragListener2.onMarkerDragStart(marker4);
                            }
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c() {
        BaiduMap.OnMapRenderCallback onMapRenderCallback;
        BaiduMap.OnMapRenderCallback onMapRenderCallback2;
        onMapRenderCallback = this.f7099a.s;
        if (onMapRenderCallback != null) {
            onMapRenderCallback2 = this.f7099a.s;
            onMapRenderCallback2.onMapRenderFinished();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(GeoPoint geoPoint) {
        BaiduMap.OnMapLongClickListener onMapLongClickListener;
        BaiduMap.OnMapLongClickListener onMapLongClickListener2;
        onMapLongClickListener = this.f7099a.u;
        if (onMapLongClickListener != null) {
            LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
            onMapLongClickListener2 = this.f7099a.u;
            onMapLongClickListener2.onMapLongClick(mc2ll);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(ab abVar) {
        View view;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        View view2;
        view = this.f7099a.J;
        if (view != null) {
            view2 = this.f7099a.J;
            view2.setVisibility(0);
        }
        onMapStatusChangeListener = this.f7099a.o;
        if (onMapStatusChangeListener != null) {
            MapStatus a2 = MapStatus.a(abVar);
            onMapStatusChangeListener2 = this.f7099a.o;
            onMapStatusChangeListener2.onMapStatusChangeFinish(a2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void d() {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        lock = this.f7099a.F;
        lock.lock();
        try {
            heatMap = this.f7099a.E;
            if (heatMap != null) {
                heatMap2 = this.f7099a.E;
                heatMap2.a();
            }
        } finally {
            lock2 = this.f7099a.F;
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
        marker = this.f7099a.K;
        if (marker != null) {
            marker2 = this.f7099a.K;
            if (marker2.f6982f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.f7099a.f6847f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.f7099a.f6847f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.f7099a.K;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.f7099a.x;
                if (onMarkerDragListener != null) {
                    marker4 = this.f7099a.K;
                    if (marker4.f6982f) {
                        onMarkerDragListener2 = this.f7099a.x;
                        marker5 = this.f7099a.K;
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
        lock = this.f7099a.F;
        lock.lock();
        try {
            heatMap = this.f7099a.E;
            if (heatMap != null) {
                heatMap2 = this.f7099a.E;
                heatMap2.a();
                eVar = this.f7099a.i;
                eVar.o();
            }
        } finally {
            lock2 = this.f7099a.F;
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
        marker = this.f7099a.K;
        if (marker != null) {
            marker2 = this.f7099a.K;
            if (marker2.f6982f) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                projection = this.f7099a.f6847f;
                Point screenLocation = projection.toScreenLocation(mc2ll);
                Point point = new Point(screenLocation.x, screenLocation.y - 60);
                projection2 = this.f7099a.f6847f;
                LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                marker3 = this.f7099a.K;
                marker3.setPosition(fromScreenLocation);
                onMarkerDragListener = this.f7099a.x;
                if (onMarkerDragListener != null) {
                    marker4 = this.f7099a.K;
                    if (marker4.f6982f) {
                        onMarkerDragListener2 = this.f7099a.x;
                        marker5 = this.f7099a.K;
                        onMarkerDragListener2.onMarkerDragEnd(marker5);
                    }
                }
                this.f7099a.K = null;
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
        eVar = this.f7099a.i;
        eVar.b(false);
        lock = this.f7099a.F;
        lock.lock();
        try {
            heatMap = this.f7099a.E;
            if (heatMap != null) {
                BaiduMap baiduMap = this.f7099a;
                heatMap2 = this.f7099a.E;
                baiduMap.a(heatMap2);
            }
        } finally {
            lock2 = this.f7099a.F;
            lock2.unlock();
        }
    }
}
