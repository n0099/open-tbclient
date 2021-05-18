package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final String f6890e = "BaiduMap";
    public static int mapStatusReason;
    public OnMyLocationClickListener A;
    public SnapshotReadyCallback B;
    public OnMapDrawFrameCallback C;
    public OnBaseIndoorMapListener D;
    public OnMapRenderValidDataListener E;
    public OnSynchronizationListener F;
    public TileOverlay G;
    public HeatMap H;
    public Lock I;
    public Lock J;
    public Map<String, InfoWindow> K;
    public Map<InfoWindow, Marker> L;
    public Marker M;
    public MyLocationData N;
    public MyLocationConfiguration O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public Point T;

    /* renamed from: a  reason: collision with root package name */
    public MapView f6891a;

    /* renamed from: b  reason: collision with root package name */
    public TextureMapView f6892b;

    /* renamed from: c  reason: collision with root package name */
    public WearMapView f6893c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.aa f6894d;

    /* renamed from: f  reason: collision with root package name */
    public Projection f6895f;

    /* renamed from: g  reason: collision with root package name */
    public UiSettings f6896g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f6897h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f6898i;
    public ac j;
    public List<Overlay> k;
    public List<Marker> l;
    public List<Marker> m;
    public List<InfoWindow> n;
    public Overlay.a o;
    public InfoWindow.a p;
    public OnMapStatusChangeListener q;
    public OnMapTouchListener r;
    public OnMapClickListener s;
    public OnMapLoadedCallback t;
    public OnMapRenderCallback u;
    public OnMapDoubleClickListener v;
    public OnMapLongClickListener w;
    public CopyOnWriteArrayList<OnMarkerClickListener> x;
    public CopyOnWriteArrayList<OnPolylineClickListener> y;
    public OnMarkerDragListener z;

    /* loaded from: classes2.dex */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* loaded from: classes2.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        boolean onMapPoiClick(MapPoi mapPoi);
    }

    /* loaded from: classes2.dex */
    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    /* loaded from: classes2.dex */
    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    /* loaded from: classes2.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* loaded from: classes2.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: classes2.dex */
    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    /* loaded from: classes2.dex */
    public interface OnMapRenderValidDataListener {
        void onMapRenderValidData(boolean z, int i2, String str);
    }

    /* loaded from: classes2.dex */
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i2);
    }

    /* loaded from: classes2.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes2.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: classes2.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: classes2.dex */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    /* loaded from: classes2.dex */
    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    /* loaded from: classes2.dex */
    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i2);
    }

    /* loaded from: classes2.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public BaiduMap(ac acVar) {
        this.x = new CopyOnWriteArrayList<>();
        this.y = new CopyOnWriteArrayList<>();
        this.I = new ReentrantLock();
        this.J = new ReentrantLock();
        this.j = acVar;
        this.f6898i = acVar.b();
        this.f6894d = com.baidu.mapsdkplatform.comapi.map.aa.TextureView;
        c();
    }

    public BaiduMap(com.baidu.mapsdkplatform.comapi.map.j jVar) {
        this.x = new CopyOnWriteArrayList<>();
        this.y = new CopyOnWriteArrayList<>();
        this.I = new ReentrantLock();
        this.J = new ReentrantLock();
        this.f6897h = jVar;
        this.f6898i = jVar.a();
        this.f6894d = com.baidu.mapsdkplatform.comapi.map.aa.GLSurfaceView;
        c();
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",")) {
            String[] split = str2.replaceAll("\"", "").split(":");
            if ("x".equals(split[0])) {
                i2 = Integer.valueOf(split[1]).intValue();
            }
            if ("y".equals(split[0])) {
                i3 = Integer.valueOf(split[1]).intValue();
            }
        }
        return new Point(i2, i3);
    }

    private ab a(MapStatusUpdate mapStatusUpdate) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return null;
        }
        ab E = eVar.E();
        MapStatus a2 = mapStatusUpdate.a(this.f6898i, getMapStatus());
        if (a2 == null) {
            return null;
        }
        return a2.b(E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2) {
        if (i2 != 0) {
            switch (i2) {
                case 1004:
                    return "网络连接错误";
                case 1005:
                    return "请求发送错误";
                case 1006:
                    return "响应数据读取失败";
                case 1007:
                    return "返回响应数据过大，数据溢出";
                case 1008:
                    return "当前网络类型有问题";
                case 1009:
                    return "数据不一致";
                case 1010:
                    return "请求取消";
                case 1011:
                    return "网络超时错误";
                case 1012:
                    return "网络连接超时";
                case 1013:
                    return "网络发送超时";
                case 1014:
                    return "网络接收超时";
                case 1015:
                    return "DNS解析错误";
                case 1016:
                    return "DNS解析超时";
                case 1017:
                    return "网络写错误";
                case 1018:
                    return "SSL握手错误";
                case 1019:
                    return "SSL握手超时";
                default:
                    return "";
            }
        }
        return "数据请求成功";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(InfoWindow infoWindow) {
        boolean z;
        Marker marker;
        MapView mapView;
        if (infoWindow == null) {
            return;
        }
        Set<InfoWindow> keySet = this.L.keySet();
        if (keySet.isEmpty() || !keySet.contains(infoWindow)) {
            showInfoWindow(infoWindow, false);
            return;
        }
        View view = infoWindow.f6972b;
        if (view != null && infoWindow.j) {
            view.destroyDrawingCache();
            MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.f6973c).yOffset(infoWindow.f6976f).build();
            int i2 = f.f7177b[this.f6894d.ordinal()];
            if (i2 == 1) {
                TextureMapView textureMapView = this.f6892b;
                if (textureMapView != null) {
                    textureMapView.removeView(view);
                    this.f6892b.addView(view, build);
                }
            } else if (i2 == 2 && (mapView = this.f6891a) != null) {
                mapView.removeView(view);
                this.f6891a.addView(view, build);
            }
            if (infoWindow.f6979i) {
                z = false;
                BitmapDescriptor b2 = b(infoWindow);
                marker = this.L.get(infoWindow);
                if (marker == null) {
                    Bundle bundle = new Bundle();
                    if (infoWindow.f6971a != null) {
                        marker.type = com.baidu.mapsdkplatform.comapi.map.h.popup;
                        marker.f7039b = b2;
                        if (infoWindow.f6972b != null) {
                            bundle.putInt("draw_with_view", 1);
                        } else {
                            bundle.putInt("draw_with_view", 0);
                        }
                    }
                    marker.f7038a = infoWindow.f6973c;
                    marker.a(bundle);
                    com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
                    if (eVar == null || !z) {
                        return;
                    }
                    eVar.c(bundle);
                    return;
                }
                return;
            }
        }
        z = true;
        BitmapDescriptor b22 = b(infoWindow);
        marker = this.L.get(infoWindow);
        if (marker == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
        BaiduMap baiduMap;
        Bundle bundle;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        int i2;
        MapStatus.Builder zoom;
        float f2;
        if (myLocationData == null || myLocationConfiguration == null || !isMyLocationEnabled()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        LatLng latLng = new LatLng(myLocationData.latitude, myLocationData.longitude);
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("ptx", ll2mc.getLongitudeE6());
            jSONObject2.put("pty", ll2mc.getLatitudeE6());
            jSONObject2.put("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(latLng, (int) myLocationData.accuracy));
            float f3 = myLocationData.direction;
            if (myLocationConfiguration.enableDirection) {
                f2 = myLocationData.direction % 360.0f;
                if (f2 > 180.0f) {
                    f2 -= 360.0f;
                } else if (f2 < -180.0f) {
                    f2 += 360.0f;
                }
            } else {
                f2 = -1001.0f;
            }
            jSONObject2.put("direction", f2);
            jSONObject2.put("iconarrownor", "NormalLocArrow");
            jSONObject2.put("iconarrownorid", 28);
            jSONObject2.put("iconarrowfoc", "FocusLocArrow");
            jSONObject2.put("iconarrowfocid", 29);
            jSONObject2.put("lineid", myLocationConfiguration.accuracyCircleStrokeColor);
            jSONObject2.put("areaid", myLocationConfiguration.accuracyCircleFillColor);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
            if (myLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS) {
                jSONObject3.put("ptx", ll2mc.getLongitudeE6());
                jSONObject3.put("pty", ll2mc.getLatitudeE6());
                try {
                    jSONObject3.put("radius", 0);
                    jSONObject3.put("direction", 0);
                    jSONObject3.put("iconarrownor", "direction_wheel");
                    jSONObject3.put("iconarrownorid", 54);
                    jSONObject3.put("iconarrowfoc", "direction_wheel");
                    jSONObject3.put("iconarrowfocid", 54);
                    jSONArray.put(jSONObject3);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (myLocationConfiguration.customMarker != null) {
                    }
                    eVar = baiduMap.f6898i;
                    if (eVar != null) {
                    }
                    i2 = f.f7176a[myLocationConfiguration.locationMode.ordinal()];
                    if (i2 != 1) {
                    }
                    baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(zoom.build()));
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
        if (myLocationConfiguration.customMarker != null) {
            bundle = null;
            baiduMap = this;
        } else {
            ArrayList<BitmapDescriptor> arrayList = new ArrayList();
            arrayList.add(myLocationConfiguration.customMarker);
            Bundle bundle2 = new Bundle();
            ArrayList arrayList2 = new ArrayList();
            for (BitmapDescriptor bitmapDescriptor : arrayList) {
                ParcelItem parcelItem = new ParcelItem();
                Bundle bundle3 = new Bundle();
                Bitmap bitmap = bitmapDescriptor.f6908a;
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
                bitmap.copyPixelsToBuffer(allocate);
                bundle3.putByteArray("imgdata", allocate.array());
                bundle3.putInt("imgindex", bitmapDescriptor.hashCode());
                bundle3.putInt("imgH", bitmap.getHeight());
                bundle3.putInt("imgW", bitmap.getWidth());
                parcelItem.setBundle(bundle3);
                arrayList2.add(parcelItem);
            }
            if (arrayList2.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    parcelItemArr[i3] = (ParcelItem) arrayList2.get(i3);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            baiduMap = this;
            bundle = bundle2;
        }
        eVar = baiduMap.f6898i;
        if (eVar != null) {
            eVar.a(jSONObject.toString(), bundle);
        }
        i2 = f.f7176a[myLocationConfiguration.locationMode.ordinal()];
        if (i2 != 1) {
            zoom = new MapStatus.Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom);
        } else if (i2 != 2) {
            return;
        } else {
            zoom = new MapStatus.Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen);
        }
        baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(zoom.build()));
    }

    private BitmapDescriptor b(InfoWindow infoWindow) {
        BitmapDescriptor fromView;
        View view = infoWindow.f6972b;
        if (view == null || !infoWindow.j) {
            return infoWindow.f6971a;
        }
        if (infoWindow.f6977g) {
            if (infoWindow.f6978h <= 0) {
                infoWindow.f6978h = SysOSUtil.getDensityDpi();
            }
            fromView = BitmapDescriptorFactory.fromViewWithDpi(infoWindow.f6972b, infoWindow.f6978h);
        } else {
            fromView = BitmapDescriptorFactory.fromView(view);
        }
        infoWindow.f6971a = fromView;
        return fromView;
    }

    private void c() {
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.K = new ConcurrentHashMap();
        this.L = new ConcurrentHashMap();
        this.n = new CopyOnWriteArrayList();
        this.T = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        this.f6896g = new UiSettings(this.f6898i);
        this.o = new a(this);
        this.p = new b(this);
        this.f6898i.a(new c(this));
        this.f6898i.a(new d(this));
        this.f6898i.a(new e(this));
        this.P = this.f6898i.C();
        this.Q = this.f6898i.D();
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return;
        }
        eVar.t();
    }

    public void a(HeatMap heatMap) {
        this.I.lock();
        try {
            if (this.H != null && this.f6898i != null && heatMap == this.H) {
                this.H.b();
                this.H.c();
                this.H.f6962a = null;
                this.f6898i.o();
                this.H = null;
                this.f6898i.o(false);
            }
        } finally {
            this.I.unlock();
        }
    }

    public void a(TileOverlay tileOverlay) {
        this.J.lock();
        if (tileOverlay != null) {
            try {
                if (this.G == tileOverlay) {
                    tileOverlay.b();
                    tileOverlay.f7140a = null;
                    if (this.f6898i != null) {
                        this.f6898i.f(false);
                    }
                }
            } finally {
                this.G = null;
                this.J.unlock();
            }
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap == null) {
            return;
        }
        this.I.lock();
        try {
            if (heatMap == this.H) {
                return;
            }
            if (this.H != null) {
                this.H.b();
                this.H.c();
                this.H.f6962a = null;
                this.f6898i.o();
            }
            this.H = heatMap;
            heatMap.f6962a = this;
            this.f6898i.o(true);
        } finally {
            this.I.unlock();
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions == null) {
            return null;
        }
        Overlay a2 = overlayOptions.a();
        a2.listener = this.o;
        if (a2 instanceof Marker) {
            Marker marker = (Marker) a2;
            marker.w = this.p;
            ArrayList<BitmapDescriptor> arrayList = marker.o;
            if (arrayList != null && arrayList.size() != 0) {
                this.l.add(marker);
                com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
                if (eVar != null) {
                    eVar.b(true);
                }
            }
            this.m.add(marker);
            InfoWindow infoWindow = marker.v;
            if (infoWindow != null) {
                showInfoWindow(infoWindow, false);
            }
        }
        Bundle bundle = new Bundle();
        a2.a(bundle);
        com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f6898i;
        if (eVar2 != null) {
            eVar2.b(bundle);
        }
        this.k.add(a2);
        return a2;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        int i2;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        Bundle[] bundleArr = new Bundle[size];
        int i3 = 0;
        for (OverlayOptions overlayOptions : list) {
            if (overlayOptions != null) {
                Bundle bundle = new Bundle();
                Overlay a2 = overlayOptions.a();
                a2.listener = this.o;
                if (a2 instanceof Marker) {
                    Marker marker = (Marker) a2;
                    marker.w = this.p;
                    ArrayList<BitmapDescriptor> arrayList2 = marker.o;
                    if (arrayList2 != null && arrayList2.size() != 0) {
                        this.l.add(marker);
                        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
                        if (eVar != null) {
                            eVar.b(true);
                        }
                    }
                    this.m.add(marker);
                }
                this.k.add(a2);
                arrayList.add(a2);
                a2.a(bundle);
                bundleArr[i3] = bundle;
                i3++;
            }
        }
        int i4 = size / 400;
        for (int i5 = 0; i5 < i4 + 1; i5++) {
            ArrayList arrayList3 = new ArrayList();
            for (int i6 = 0; i6 < 400 && (i2 = (i5 * 400) + i6) < size; i6++) {
                if (bundleArr[i2] != null) {
                    arrayList3.add(bundleArr[i2]);
                }
            }
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f6898i;
            if (eVar2 != null) {
                eVar2.a(arrayList3);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        TileOverlay tileOverlay = this.G;
        if (tileOverlay != null) {
            tileOverlay.b();
            this.G.f7140a = null;
        }
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null || !eVar.a(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay a2 = tileOverlayOptions.a(this);
        this.G = a2;
        return a2;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, 300);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i2) {
        if (mapStatusUpdate == null || i2 <= 0) {
            return;
        }
        ab a2 = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return;
        }
        mapStatusReason |= 256;
        if (this.S) {
            eVar.a(a2, i2);
        } else {
            eVar.a(a2);
        }
    }

    public boolean b() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return false;
        }
        return eVar.e();
    }

    public void changeLocationLayerOrder(boolean z) {
        this.f6898i.d(z);
    }

    public final void clear() {
        this.k.clear();
        this.l.clear();
        this.m.clear();
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            eVar.b(false);
            this.f6898i.n();
        }
        hideInfoWindow();
    }

    public List<InfoWindow> getAllInfoWindows() {
        return this.n;
    }

    public final Point getCompassPosition() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            return a(eVar.h());
        }
        return null;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        return this.f6898i.p();
    }

    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.O;
    }

    public final MyLocationData getLocationData() {
        return this.N;
    }

    public final MapStatus getMapStatus() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return null;
        }
        return MapStatus.a(eVar.E());
    }

    public final LatLngBounds getMapStatusLimit() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return null;
        }
        return eVar.F();
    }

    public final int getMapType() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return 1;
        }
        if (eVar.l()) {
            return this.f6898i.k() ? 2 : 1;
        }
        return 3;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.m.size() == 0) {
            return null;
        }
        for (Marker marker : this.m) {
            if (latLngBounds.contains(marker.getPosition())) {
                arrayList.add(marker);
            }
        }
        return arrayList;
    }

    public final float getMaxZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return 0.0f;
        }
        return eVar.f7718a;
    }

    public final float getMinZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return 0.0f;
        }
        return eVar.f7719b;
    }

    public final Projection getProjection() {
        return this.f6895f;
    }

    public float[] getProjectionMatrix() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return null;
        }
        return eVar.N();
    }

    public final UiSettings getUiSettings() {
        return this.f6896g;
    }

    public float[] getViewMatrix() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return null;
        }
        return eVar.O();
    }

    public float getZoomToBound(int i2, int i3, int i4, int i5, int i6, int i7) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return 0.0f;
        }
        return eVar.a(i2, i3, i4, i5, i6, i7);
    }

    public com.baidu.mapsdkplatform.comapi.map.j getmGLMapView() {
        return this.f6897h;
    }

    public void hideInfoWindow() {
        View view;
        MapView mapView;
        Collection<InfoWindow> values = this.K.values();
        if (!values.isEmpty()) {
            for (InfoWindow infoWindow : values) {
                if (infoWindow != null && (view = infoWindow.f6972b) != null) {
                    int i2 = f.f7177b[this.f6894d.ordinal()];
                    if (i2 == 1) {
                        TextureMapView textureMapView = this.f6892b;
                        if (textureMapView != null) {
                            textureMapView.removeView(view);
                        }
                    } else if (i2 == 2 && (mapView = this.f6891a) != null) {
                        mapView.removeView(view);
                    }
                }
            }
        }
        for (Overlay overlay : this.k) {
            Set<String> keySet = this.K.keySet();
            String str = overlay.y;
            if ((overlay instanceof Marker) && !keySet.isEmpty() && keySet.contains(str)) {
                overlay.remove();
            }
        }
        this.K.clear();
        this.L.clear();
        this.n.clear();
    }

    public void hideInfoWindow(InfoWindow infoWindow) {
        MapView mapView;
        Set<InfoWindow> keySet = this.L.keySet();
        if (infoWindow == null || keySet.isEmpty() || !keySet.contains(infoWindow)) {
            return;
        }
        View view = infoWindow.f6972b;
        if (view != null) {
            int i2 = f.f7177b[this.f6894d.ordinal()];
            if (i2 == 1) {
                TextureMapView textureMapView = this.f6892b;
                if (textureMapView != null) {
                    textureMapView.removeView(view);
                }
            } else if (i2 == 2 && (mapView = this.f6891a) != null) {
                mapView.removeView(view);
            }
        }
        Marker marker = this.L.get(infoWindow);
        if (marker != null) {
            marker.remove();
            this.K.remove(marker.y);
        }
        this.L.remove(infoWindow);
        this.n.remove(infoWindow);
    }

    public void hideSDKLayer() {
        this.f6898i.c();
    }

    public final boolean isBaiduHeatMapEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return false;
        }
        return eVar.i();
    }

    public boolean isBaseIndoorMapMode() {
        return this.f6898i.q();
    }

    public final boolean isBuildingsEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return false;
        }
        return eVar.m();
    }

    public final boolean isMyLocationEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return false;
        }
        return eVar.s();
    }

    public final boolean isSupportBaiduHeatMap() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return false;
        }
        return eVar.j();
    }

    public final boolean isTrafficEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return false;
        }
        return eVar.g();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.x.contains(onMarkerClickListener)) {
            this.x.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            eVar.h(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            eVar.j(z);
        }
    }

    public void setCompassEnable(boolean z) {
        this.f6898i.e(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
        }
        this.f6898i.a(bitmap);
    }

    public void setCompassPosition(Point point) {
        if (this.f6898i.a(point)) {
            this.T = point;
        }
    }

    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                this.f6898i.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
                return true;
            }
            return true;
        } else if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
            this.f6898i.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
            return true;
        } else {
            Log.e(f6890e, "the string of the input customTrafficColor is error");
            return false;
        }
    }

    public final void setIndoorEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            this.R = z;
            eVar.l(z);
        }
        OnBaseIndoorMapListener onBaseIndoorMapListener = this.D;
        if (onBaseIndoorMapListener == null || z) {
            return;
        }
        onBaseIndoorMapListener.onBaseIndoorMapMode(false, null);
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate == null) {
            return;
        }
        ab a2 = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return;
        }
        eVar.a(a2);
        OnMapStatusChangeListener onMapStatusChangeListener = this.q;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return;
        }
        eVar.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i2) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar == null) {
            return;
        }
        if (i2 == 1) {
            eVar.a(false);
            this.f6898i.u(this.P);
            this.f6898i.v(this.Q);
            this.f6898i.g(true);
            this.f6898i.l(this.R);
        } else if (i2 == 2) {
            eVar.a(true);
            this.f6898i.u(this.P);
            this.f6898i.v(this.Q);
            this.f6898i.g(true);
        } else if (i2 == 3) {
            if (eVar.C()) {
                this.f6898i.u(false);
            }
            if (this.f6898i.D()) {
                this.f6898i.v(false);
            }
            this.f6898i.g(false);
            this.f6898i.l(false);
        }
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6897h;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public final void setMaxAndMinZoomLevel(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        if (f2 <= 21.0f && f3 >= 4.0f && f2 >= f3 && (eVar = this.f6898i) != null) {
            eVar.a(f2, f3);
        }
    }

    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        this.O = myLocationConfiguration;
        a(this.N, myLocationConfiguration);
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.N = myLocationData;
        if (this.O == null) {
            this.O = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.O);
    }

    public final void setMyLocationEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            eVar.n(z);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        this.D = onBaseIndoorMapListener;
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.s = onMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        this.v = onMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        this.C = onMapDrawFrameCallback;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        this.t = onMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.w = onMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        this.u = onMapRenderCallback;
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener onMapRenderValidDataListener) {
        this.E = onMapRenderValidDataListener;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        this.q = onMapStatusChangeListener;
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        this.r = onMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null || this.x.contains(onMarkerClickListener)) {
            return;
        }
        this.x.add(onMarkerClickListener);
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.z = onMarkerDragListener;
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        this.A = onMyLocationClickListener;
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener != null) {
            this.y.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        this.F = onSynchronizationListener;
    }

    public void setOverlayUnderPoi(boolean z) {
        this.f6898i.c(z);
    }

    @Deprecated
    public final void setPadding(int i2, int i3, int i4, int i5) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        ViewGroup viewGroup;
        MapView mapView;
        if (i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || (eVar = this.f6898i) == null) {
            return;
        }
        eVar.E();
        int i6 = f.f7177b[this.f6894d.ordinal()];
        if (i6 == 1) {
            TextureMapView textureMapView = this.f6892b;
            if (textureMapView == null) {
                return;
            }
            float width = ((textureMapView.getWidth() - i2) - i4) / this.f6892b.getWidth();
            float height = ((this.f6892b.getHeight() - i3) - i5) / this.f6892b.getHeight();
            MapStatusUpdate newMapStatus = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.f6892b.getWidth() + i2) - i4) / 2, ((this.f6892b.getHeight() + i3) - i5) / 2)).build());
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f6898i;
            Point point = this.T;
            eVar2.a(new Point((int) (i2 + (point.x * width)), (int) (i3 + (point.y * height))));
            setMapStatus(newMapStatus);
            this.f6892b.setPadding(i2, i3, i4, i5);
            viewGroup = this.f6892b;
        } else if (i6 != 2 || (mapView = this.f6891a) == null) {
            return;
        } else {
            float width2 = ((mapView.getWidth() - i2) - i4) / this.f6891a.getWidth();
            float height2 = ((this.f6891a.getHeight() - i3) - i5) / this.f6891a.getHeight();
            MapStatusUpdate newMapStatus2 = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.f6891a.getWidth() + i2) - i4) / 2, ((this.f6891a.getHeight() + i3) - i5) / 2)).build());
            com.baidu.mapsdkplatform.comapi.map.e eVar3 = this.f6898i;
            Point point2 = this.T;
            eVar3.a(new Point((int) (i2 + (point2.x * width2)), (int) (i3 + (point2.y * height2))));
            setMapStatus(newMapStatus2);
            this.f6891a.setPadding(i2, i3, i4, i5);
            viewGroup = this.f6891a;
        }
        viewGroup.invalidate();
    }

    public void setPixelFormatTransparent(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6897h;
        if (jVar == null) {
            return;
        }
        if (z) {
            jVar.d();
        } else {
            jVar.e();
        }
    }

    public final void setTrafficEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            eVar.i(z);
        }
    }

    public final void setViewPadding(int i2, int i3, int i4, int i5) {
        ViewGroup viewGroup;
        MapView mapView;
        if (i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || this.f6898i == null) {
            return;
        }
        int i6 = f.f7177b[this.f6894d.ordinal()];
        if (i6 == 1) {
            TextureMapView textureMapView = this.f6892b;
            if (textureMapView == null) {
                return;
            }
            float width = ((textureMapView.getWidth() - i2) - i4) / this.f6892b.getWidth();
            float height = ((this.f6892b.getHeight() - i3) - i5) / this.f6892b.getHeight();
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
            Point point = this.T;
            eVar.a(new Point((int) (i2 + (point.x * width)), (int) (i3 + (point.y * height))));
            this.f6892b.setPadding(i2, i3, i4, i5);
            viewGroup = this.f6892b;
        } else if (i6 != 2 || (mapView = this.f6891a) == null) {
            return;
        } else {
            float width2 = ((mapView.getWidth() - i2) - i4) / this.f6891a.getWidth();
            float height2 = ((this.f6891a.getHeight() - i3) - i5) / this.f6891a.getHeight();
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f6898i;
            Point point2 = this.T;
            eVar2.a(new Point((int) (i2 + (point2.x * width2)), (int) (i3 + (point2.y * height2))));
            this.f6891a.setPadding(i2, i3, i4, i5);
            viewGroup = this.f6891a;
        }
        viewGroup.invalidate();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        showInfoWindow(infoWindow, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showInfoWindow(InfoWindow infoWindow, boolean z) {
        boolean z2;
        Overlay a2;
        Bundle bundle;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Set<InfoWindow> keySet = this.L.keySet();
        if (infoWindow == null || keySet.contains(infoWindow)) {
            return;
        }
        if (z) {
            hideInfoWindow();
        }
        infoWindow.f6975e = this.p;
        View view = infoWindow.f6972b;
        if (view != null && infoWindow.j) {
            view.destroyDrawingCache();
            MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.f6973c).yOffset(infoWindow.f6976f).build();
            int i2 = f.f7177b[this.f6894d.ordinal()];
            if (i2 == 1) {
                TextureMapView textureMapView = this.f6892b;
                if (textureMapView != null) {
                    textureMapView.addView(view, build);
                }
            } else if (i2 == 2 && this.f6897h != null) {
                this.f6891a.addView(view, build);
            }
            if (infoWindow.f6979i) {
                z2 = false;
                a2 = new MarkerOptions().perspective(false).icon(b(infoWindow)).position(infoWindow.f6973c).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.f6976f).infoWindow(infoWindow).a();
                a2.listener = this.o;
                a2.type = com.baidu.mapsdkplatform.comapi.map.h.popup;
                bundle = new Bundle();
                a2.a(bundle);
                if (infoWindow.f6972b == null) {
                    bundle.putInt("draw_with_view", 1);
                } else {
                    bundle.putInt("draw_with_view", 0);
                }
                eVar = this.f6898i;
                if (eVar != null && z2) {
                    eVar.b(bundle);
                    this.k.add(a2);
                }
                Marker marker = (Marker) a2;
                marker.w = this.p;
                this.K.put(marker.y, infoWindow);
                this.L.put(infoWindow, marker);
                this.n.add(infoWindow);
            }
        }
        z2 = true;
        a2 = new MarkerOptions().perspective(false).icon(b(infoWindow)).position(infoWindow.f6973c).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.f6976f).infoWindow(infoWindow).a();
        a2.listener = this.o;
        a2.type = com.baidu.mapsdkplatform.comapi.map.h.popup;
        bundle = new Bundle();
        a2.a(bundle);
        if (infoWindow.f6972b == null) {
        }
        eVar = this.f6898i;
        if (eVar != null) {
            eVar.b(bundle);
            this.k.add(a2);
        }
        Marker marker2 = (Marker) a2;
        marker2.w = this.p;
        this.K.put(marker2.y, infoWindow);
        this.L.put(infoWindow, marker2);
        this.n.add(infoWindow);
    }

    public void showInfoWindows(List<InfoWindow> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (InfoWindow infoWindow : list) {
            showInfoWindow(infoWindow, false);
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            eVar.v(z);
            this.Q = z;
        }
    }

    public final void showMapPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f6898i;
        if (eVar != null) {
            eVar.u(z);
            this.P = z;
        }
    }

    public void showSDKLayer() {
        this.f6898i.d();
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        this.B = snapshotReadyCallback;
        int i2 = f.f7177b[this.f6894d.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 && (jVar = this.f6897h) != null) {
                jVar.a("anything", (Rect) null);
                return;
            }
            return;
        }
        ac acVar = this.j;
        if (acVar != null) {
            acVar.a("anything", null);
        }
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        this.B = snapshotReadyCallback;
        int i2 = f.f7177b[this.f6894d.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 && (jVar = this.f6897h) != null) {
                jVar.a("anything", rect);
                return;
            }
            return;
        }
        ac acVar = this.j;
        if (acVar != null) {
            acVar.a("anything", rect);
        }
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
        }
        MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
        if (focusedBaseIndoorMapInfo == null) {
            return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        }
        if (str2.equals(focusedBaseIndoorMapInfo.f6983a)) {
            ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
            return (floors == null || !floors.contains(str)) ? MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW : this.f6898i.a(str, str2) ? MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK : MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        }
        return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
    }
}
