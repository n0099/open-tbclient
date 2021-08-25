package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c implements com.baidu.mapsdkplatform.comapi.map.l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaiduMap f41554a;

    public c(BaiduMap baiduMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baiduMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41554a = baiduMap;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(Bitmap bitmap) {
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback;
        BaiduMap.SnapshotReadyCallback snapshotReadyCallback2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            snapshotReadyCallback = this.f41554a.B;
            if (snapshotReadyCallback != null) {
                snapshotReadyCallback2 = this.f41554a.B;
                snapshotReadyCallback2.onSnapshotReady(bitmap);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(MotionEvent motionEvent) {
        BaiduMap.OnMapTouchListener onMapTouchListener;
        BaiduMap.OnMapTouchListener onMapTouchListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            onMapTouchListener = this.f41554a.r;
            if (onMapTouchListener != null) {
                onMapTouchListener2 = this.f41554a.r;
                onMapTouchListener2.onTouch(motionEvent);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GeoPoint geoPoint) {
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, geoPoint) == null) {
            onMapClickListener = this.f41554a.s;
            if (onMapClickListener != null) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                onMapClickListener2 = this.f41554a.s;
                onMapClickListener2.onMapClick(mc2ll);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(ab abVar) {
        Map map;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener;
        BaiduMap.OnSynchronizationListener onSynchronizationListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener3;
        Map map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, abVar) == null) {
            map = this.f41554a.K;
            if (!map.values().isEmpty()) {
                map2 = this.f41554a.K;
                for (InfoWindow infoWindow : map2.values()) {
                    View view = infoWindow.f41340b;
                    if (view != null && !infoWindow.f41347i) {
                        view.setVisibility(4);
                    }
                }
            }
            int i2 = BaiduMap.mapStatusReason;
            int i3 = (i2 & 256) == 256 ? 3 : (i2 & 16) == 16 ? 2 : 1;
            onMapStatusChangeListener = this.f41554a.q;
            if (onMapStatusChangeListener != null) {
                MapStatus a2 = MapStatus.a(abVar);
                onMapStatusChangeListener2 = this.f41554a.q;
                onMapStatusChangeListener2.onMapStatusChangeStart(a2);
                onMapStatusChangeListener3 = this.f41554a.q;
                onMapStatusChangeListener3.onMapStatusChangeStart(a2, i3);
            }
            onSynchronizationListener = this.f41554a.F;
            if (onSynchronizationListener != null) {
                onSynchronizationListener2 = this.f41554a.F;
                onSynchronizationListener2.onMapStatusChangeReason(i3);
            }
            BaiduMap.mapStatusReason = 0;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(String str) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        List<Overlay> list;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        Map map;
        List<Overlay> list2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4;
        Map map2;
        com.baidu.mapsdkplatform.comapi.map.e eVar2;
        com.baidu.mapsdkplatform.comapi.map.e eVar3;
        com.baidu.mapsdkplatform.comapi.map.e eVar4;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener;
        BaiduMap.OnMyLocationClickListener onMyLocationClickListener2;
        BaiduMap.OnMapClickListener onMapClickListener;
        BaiduMap.OnMapClickListener onMapClickListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONArray(ActionJsonData.TAG_DATASET).optJSONObject(0);
                eVar = this.f41554a.f41261i;
                GeoPoint b2 = eVar.b(jSONObject.optInt("px"), jSONObject.optInt("py"));
                int optInt = optJSONObject.optInt("ty");
                if (optInt == 17) {
                    onMapClickListener = this.f41554a.s;
                    if (onMapClickListener != null) {
                        MapPoi mapPoi = new MapPoi();
                        mapPoi.a(optJSONObject);
                        onMapClickListener2 = this.f41554a.s;
                        onMapClickListener2.onMapPoiClick(mapPoi);
                        return;
                    }
                    return;
                }
                if (optInt != 18) {
                    if (optInt == 19) {
                        eVar2 = this.f41554a.f41261i;
                        if (eVar2 != null) {
                            eVar3 = this.f41554a.f41261i;
                            ab E = eVar3.E();
                            if (E == null) {
                                return;
                            }
                            E.f42065c = 0;
                            E.f42064b = 0;
                            BaiduMap.mapStatusReason |= 16;
                            eVar4 = this.f41554a.f41261i;
                            eVar4.a(E, 300);
                            return;
                        }
                        return;
                    } else if (optInt != 90909) {
                        if (optInt == 90910) {
                            String optString = optJSONObject.optString("polyline_id");
                            list = this.f41554a.k;
                            for (Overlay overlay : list) {
                                if ((overlay instanceof Polyline) && overlay.y.equals(optString)) {
                                    copyOnWriteArrayList = this.f41554a.y;
                                    if (copyOnWriteArrayList.isEmpty()) {
                                        a(b2);
                                    } else {
                                        copyOnWriteArrayList2 = this.f41554a.y;
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
                        map = this.f41554a.K;
                        Set<String> keySet = map.keySet();
                        if (!keySet.isEmpty() && keySet.contains(optString2)) {
                            for (String str2 : keySet) {
                                if (str2 != null && str2.equals(optString2)) {
                                    map2 = this.f41554a.K;
                                    InfoWindow infoWindow = (InfoWindow) map2.get(str2);
                                    if (infoWindow != null && infoWindow.f41342d != null) {
                                        infoWindow.f41342d.onInfoWindowClick();
                                        return;
                                    }
                                }
                            }
                            return;
                        }
                        list2 = this.f41554a.k;
                        for (Overlay overlay2 : list2) {
                            if ((overlay2 instanceof Marker) && overlay2.y.equals(optString2)) {
                                copyOnWriteArrayList3 = this.f41554a.x;
                                if (!copyOnWriteArrayList3.isEmpty()) {
                                    copyOnWriteArrayList4 = this.f41554a.x;
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
                onMyLocationClickListener = this.f41554a.A;
                if (onMyLocationClickListener != null) {
                    onMyLocationClickListener2 = this.f41554a.A;
                    onMyLocationClickListener2.onMyLocationClick();
                    return;
                }
                a(b2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(GL10 gl10, ab abVar) {
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback;
        BaiduMap.OnMapDrawFrameCallback onMapDrawFrameCallback2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, gl10, abVar) == null) {
            onMapDrawFrameCallback = this.f41554a.C;
            if (onMapDrawFrameCallback != null) {
                MapStatus a2 = MapStatus.a(abVar);
                onMapDrawFrameCallback2 = this.f41554a.C;
                onMapDrawFrameCallback2.onMapDrawFrame(a2);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(boolean z) {
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener;
        BaiduMap.OnBaseIndoorMapListener onBaseIndoorMapListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            onBaseIndoorMapListener = this.f41554a.D;
            if (onBaseIndoorMapListener != null) {
                MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = this.f41554a.getFocusedBaseIndoorMapInfo();
                onBaseIndoorMapListener2 = this.f41554a.D;
                onBaseIndoorMapListener2.onBaseIndoorMapMode(z, focusedBaseIndoorMapInfo);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void a(boolean z, int i2) {
        BaiduMap.OnMapRenderValidDataListener onMapRenderValidDataListener;
        String a2;
        BaiduMap.OnMapRenderValidDataListener onMapRenderValidDataListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            onMapRenderValidDataListener = this.f41554a.E;
            if (onMapRenderValidDataListener != null) {
                a2 = this.f41554a.a(i2);
                onMapRenderValidDataListener2 = this.f41554a.E;
                onMapRenderValidDataListener2.onMapRenderValidData(z, i2, a2);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b() {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback;
        BaiduMap.OnMapLoadedCallback onMapLoadedCallback2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BaiduMap baiduMap = this.f41554a;
            eVar = baiduMap.f41261i;
            baiduMap.f41258f = new Projection(eVar);
            this.f41554a.S = true;
            onMapLoadedCallback = this.f41554a.t;
            if (onMapLoadedCallback != null) {
                onMapLoadedCallback2 = this.f41554a.t;
                onMapLoadedCallback2.onMapLoaded();
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(GeoPoint geoPoint) {
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener;
        BaiduMap.OnMapDoubleClickListener onMapDoubleClickListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, geoPoint) == null) {
            onMapDoubleClickListener = this.f41554a.v;
            if (onMapDoubleClickListener != null) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                onMapDoubleClickListener2 = this.f41554a.v;
                onMapDoubleClickListener2.onMapDoubleClick(mc2ll);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void b(ab abVar) {
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, abVar) == null) {
            onMapStatusChangeListener = this.f41554a.q;
            if (onMapStatusChangeListener != null) {
                MapStatus a2 = MapStatus.a(abVar);
                onMapStatusChangeListener2 = this.f41554a.q;
                onMapStatusChangeListener2.onMapStatusChange(a2);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public boolean b(String str) {
        InterceptResult invokeL;
        Map map;
        List<Overlay> list;
        Projection projection;
        Marker marker;
        Projection projection2;
        Marker marker2;
        BaiduMap.OnMarkerDragListener onMarkerDragListener;
        BaiduMap.OnMarkerDragListener onMarkerDragListener2;
        Marker marker3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONArray(ActionJsonData.TAG_DATASET).optJSONObject(0);
                if (optJSONObject.optInt("ty") == 90909) {
                    String optString = optJSONObject.optString("marker_id");
                    map = this.f41554a.K;
                    Set keySet = map.keySet();
                    if (keySet.isEmpty() || !keySet.contains(optString)) {
                        list = this.f41554a.k;
                        for (Overlay overlay : list) {
                            if ((overlay instanceof Marker) && overlay.y.equals(optString)) {
                                Marker marker4 = (Marker) overlay;
                                if (marker4.f41414f) {
                                    this.f41554a.M = marker4;
                                    projection = this.f41554a.f41258f;
                                    marker = this.f41554a.M;
                                    Point screenLocation = projection.toScreenLocation(marker.f41409a);
                                    Point point = new Point(screenLocation.x, screenLocation.y - 60);
                                    projection2 = this.f41554a.f41258f;
                                    LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                                    marker2 = this.f41554a.M;
                                    marker2.setPosition(fromScreenLocation);
                                    onMarkerDragListener = this.f41554a.z;
                                    if (onMarkerDragListener != null) {
                                        onMarkerDragListener2 = this.f41554a.z;
                                        marker3 = this.f41554a.M;
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
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c() {
        BaiduMap.OnMapRenderCallback onMapRenderCallback;
        BaiduMap.OnMapRenderCallback onMapRenderCallback2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            onMapRenderCallback = this.f41554a.u;
            if (onMapRenderCallback != null) {
                onMapRenderCallback2 = this.f41554a.u;
                onMapRenderCallback2.onMapRenderFinished();
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(GeoPoint geoPoint) {
        BaiduMap.OnMapLongClickListener onMapLongClickListener;
        BaiduMap.OnMapLongClickListener onMapLongClickListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, geoPoint) == null) {
            onMapLongClickListener = this.f41554a.w;
            if (onMapLongClickListener != null) {
                LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                onMapLongClickListener2 = this.f41554a.w;
                onMapLongClickListener2.onMapLongClick(mc2ll);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void c(ab abVar) {
        Map map;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener;
        BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener2;
        Map map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, abVar) == null) {
            map = this.f41554a.K;
            if (!map.values().isEmpty()) {
                map2 = this.f41554a.K;
                for (InfoWindow infoWindow : map2.values()) {
                    View view = infoWindow.f41340b;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }
            }
            onMapStatusChangeListener = this.f41554a.q;
            if (onMapStatusChangeListener != null) {
                MapStatus a2 = MapStatus.a(abVar);
                onMapStatusChangeListener2 = this.f41554a.q;
                onMapStatusChangeListener2.onMapStatusChangeFinish(a2);
            }
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.l
    public void d() {
        Lock lock;
        Lock lock2;
        HeatMap heatMap;
        HeatMap heatMap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            lock = this.f41554a.I;
            lock.lock();
            try {
                heatMap = this.f41554a.H;
                if (heatMap != null) {
                    heatMap2 = this.f41554a.H;
                    heatMap2.a();
                }
            } finally {
                lock2 = this.f41554a.I;
                lock2.unlock();
            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, geoPoint) == null) {
            marker = this.f41554a.M;
            if (marker != null) {
                marker2 = this.f41554a.M;
                if (marker2.f41414f) {
                    LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                    projection = this.f41554a.f41258f;
                    Point screenLocation = projection.toScreenLocation(mc2ll);
                    Point point = new Point(screenLocation.x, screenLocation.y - 60);
                    projection2 = this.f41554a.f41258f;
                    LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                    marker3 = this.f41554a.M;
                    marker3.setPosition(fromScreenLocation);
                    onMarkerDragListener = this.f41554a.z;
                    if (onMarkerDragListener != null) {
                        marker4 = this.f41554a.M;
                        if (marker4.f41414f) {
                            onMarkerDragListener2 = this.f41554a.z;
                            marker5 = this.f41554a.M;
                            onMarkerDragListener2.onMarkerDrag(marker5);
                        }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            lock = this.f41554a.I;
            lock.lock();
            try {
                heatMap = this.f41554a.H;
                if (heatMap != null) {
                    heatMap2 = this.f41554a.H;
                    heatMap2.a();
                    eVar = this.f41554a.f41261i;
                    eVar.o();
                }
            } finally {
                lock2 = this.f41554a.I;
                lock2.unlock();
            }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, geoPoint) == null) {
            marker = this.f41554a.M;
            if (marker != null) {
                marker2 = this.f41554a.M;
                if (marker2.f41414f) {
                    LatLng mc2ll = CoordUtil.mc2ll(geoPoint);
                    projection = this.f41554a.f41258f;
                    Point screenLocation = projection.toScreenLocation(mc2ll);
                    Point point = new Point(screenLocation.x, screenLocation.y - 60);
                    projection2 = this.f41554a.f41258f;
                    LatLng fromScreenLocation = projection2.fromScreenLocation(point);
                    marker3 = this.f41554a.M;
                    marker3.setPosition(fromScreenLocation);
                    onMarkerDragListener = this.f41554a.z;
                    if (onMarkerDragListener != null) {
                        marker4 = this.f41554a.M;
                        if (marker4.f41414f) {
                            onMarkerDragListener2 = this.f41554a.z;
                            marker5 = this.f41554a.M;
                            onMarkerDragListener2.onMarkerDragEnd(marker5);
                        }
                    }
                    this.f41554a.M = null;
                }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            eVar = this.f41554a.f41261i;
            eVar.b(false);
            lock = this.f41554a.I;
            lock.lock();
            try {
                heatMap = this.f41554a.H;
                if (heatMap != null) {
                    BaiduMap baiduMap = this.f41554a;
                    heatMap2 = this.f41554a.H;
                    baiduMap.a(heatMap2);
                }
            } finally {
                lock2 = this.f41554a.I;
                lock2.unlock();
            }
        }
    }
}
