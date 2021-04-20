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
import com.baidu.mapsdkplatform.comapi.map.aa;
import com.baidu.mapsdkplatform.comapi.map.ab;
import com.baidu.mapsdkplatform.comapi.map.ac;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
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
    public static final String f6842e = "BaiduMap";
    public static int mapStatusReason;
    public OnMapDrawFrameCallback A;
    public OnBaseIndoorMapListener B;
    public OnSynchronizationListener C;
    public TileOverlay D;
    public HeatMap E;
    public Lock F;
    public Lock G;
    public InfoWindow H;
    public Marker I;
    public View J;
    public Marker K;
    public MyLocationData L;
    public MyLocationConfiguration M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public Point R;

    /* renamed from: a  reason: collision with root package name */
    public MapView f6843a;

    /* renamed from: b  reason: collision with root package name */
    public TextureMapView f6844b;

    /* renamed from: c  reason: collision with root package name */
    public WearMapView f6845c;

    /* renamed from: d  reason: collision with root package name */
    public aa f6846d;

    /* renamed from: f  reason: collision with root package name */
    public Projection f6847f;

    /* renamed from: g  reason: collision with root package name */
    public UiSettings f6848g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f6849h;
    public com.baidu.mapsdkplatform.comapi.map.e i;
    public ac j;
    public List<Overlay> k;
    public List<Marker> l;
    public List<Marker> m;
    public Overlay.a n;
    public OnMapStatusChangeListener o;
    public OnMapTouchListener p;
    public OnMapClickListener q;
    public OnMapLoadedCallback r;
    public OnMapRenderCallback s;
    public OnMapDoubleClickListener t;
    public OnMapLongClickListener u;
    public CopyOnWriteArrayList<OnMarkerClickListener> v;
    public CopyOnWriteArrayList<OnPolylineClickListener> w;
    public OnMarkerDragListener x;
    public OnMyLocationClickListener y;
    public SnapshotReadyCallback z;

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
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i);
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
        void onMapStatusChangeReason(int i);
    }

    /* loaded from: classes2.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public BaiduMap(ac acVar) {
        this.v = new CopyOnWriteArrayList<>();
        this.w = new CopyOnWriteArrayList<>();
        this.F = new ReentrantLock();
        this.G = new ReentrantLock();
        this.j = acVar;
        this.i = acVar.b();
        this.f6846d = aa.TextureView;
        c();
    }

    public BaiduMap(com.baidu.mapsdkplatform.comapi.map.j jVar) {
        this.v = new CopyOnWriteArrayList<>();
        this.w = new CopyOnWriteArrayList<>();
        this.F = new ReentrantLock();
        this.G = new ReentrantLock();
        this.f6849h = jVar;
        this.i = jVar.a();
        this.f6846d = aa.GLSurfaceView;
        c();
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",")) {
            String[] split = str2.replaceAll("\"", "").split(":");
            if ("x".equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
            }
            if ("y".equals(split[0])) {
                i2 = Integer.valueOf(split[1]).intValue();
            }
        }
        return new Point(i, i2);
    }

    private ab a(MapStatusUpdate mapStatusUpdate) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return null;
        }
        ab E = eVar.E();
        MapStatus a2 = mapStatusUpdate.a(this.i, getMapStatus());
        if (a2 == null) {
            return null;
        }
        return a2.b(E);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
        BaiduMap baiduMap;
        Bundle bundle;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        int i;
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
                f2 = -1.0f;
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
                    eVar = baiduMap.i;
                    if (eVar != null) {
                    }
                    i = e.f7102a[myLocationConfiguration.locationMode.ordinal()];
                    if (i != 1) {
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
                Bitmap bitmap = bitmapDescriptor.f6858a;
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
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    parcelItemArr[i2] = (ParcelItem) arrayList2.get(i2);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            baiduMap = this;
            bundle = bundle2;
        }
        eVar = baiduMap.i;
        if (eVar != null) {
            eVar.a(jSONObject.toString(), bundle);
        }
        i = e.f7102a[myLocationConfiguration.locationMode.ordinal()];
        if (i != 1) {
            zoom = new MapStatus.Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom);
        } else if (i != 2) {
            return;
        } else {
            zoom = new MapStatus.Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen);
        }
        baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(zoom.build()));
    }

    private void c() {
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.R = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        this.f6848g = new UiSettings(this.i);
        this.n = new a(this);
        this.i.a(new b(this));
        this.i.a(new c(this));
        this.i.a(new d(this));
        this.N = this.i.C();
        this.O = this.i.D();
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return;
        }
        eVar.t();
    }

    public void a(HeatMap heatMap) {
        this.F.lock();
        try {
            if (this.E != null && this.i != null && heatMap == this.E) {
                this.E.b();
                this.E.c();
                this.E.f6909a = null;
                this.i.o();
                this.E = null;
                this.i.n(false);
            }
        } finally {
            this.F.unlock();
        }
    }

    public void a(TileOverlay tileOverlay) {
        this.G.lock();
        if (tileOverlay != null) {
            try {
                if (this.D == tileOverlay) {
                    tileOverlay.b();
                    tileOverlay.f7071a = null;
                    if (this.i != null) {
                        this.i.e(false);
                    }
                }
            } finally {
                this.D = null;
                this.G.unlock();
            }
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap == null) {
            return;
        }
        this.F.lock();
        try {
            if (heatMap == this.E) {
                return;
            }
            if (this.E != null) {
                this.E.b();
                this.E.c();
                this.E.f6909a = null;
                this.i.o();
            }
            this.E = heatMap;
            heatMap.f6909a = this;
            this.i.n(true);
        } finally {
            this.F.unlock();
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions == null) {
            return null;
        }
        Overlay a2 = overlayOptions.a();
        a2.listener = this.n;
        if (a2 instanceof Marker) {
            Marker marker = (Marker) a2;
            ArrayList<BitmapDescriptor> arrayList = marker.o;
            if (arrayList != null && arrayList.size() != 0) {
                this.l.add(marker);
                com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
                if (eVar != null) {
                    eVar.b(true);
                }
            }
            this.m.add(marker);
        }
        Bundle bundle = new Bundle();
        a2.a(bundle);
        com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.i;
        if (eVar2 != null) {
            eVar2.b(bundle);
        }
        this.k.add(a2);
        return a2;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        int i;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        Bundle[] bundleArr = new Bundle[size];
        int i2 = 0;
        for (OverlayOptions overlayOptions : list) {
            if (overlayOptions != null) {
                Bundle bundle = new Bundle();
                Overlay a2 = overlayOptions.a();
                a2.listener = this.n;
                if (a2 instanceof Marker) {
                    Marker marker = (Marker) a2;
                    ArrayList<BitmapDescriptor> arrayList2 = marker.o;
                    if (arrayList2 != null && arrayList2.size() != 0) {
                        this.l.add(marker);
                        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
                        if (eVar != null) {
                            eVar.b(true);
                        }
                    }
                    this.m.add(marker);
                }
                this.k.add(a2);
                arrayList.add(a2);
                a2.a(bundle);
                bundleArr[i2] = bundle;
                i2++;
            }
        }
        int i3 = size / 400;
        for (int i4 = 0; i4 < i3 + 1; i4++) {
            ArrayList arrayList3 = new ArrayList();
            for (int i5 = 0; i5 < 400 && (i = (i4 * 400) + i5) < size; i5++) {
                if (bundleArr[i] != null) {
                    arrayList3.add(bundleArr[i]);
                }
            }
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.i;
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
        TileOverlay tileOverlay = this.D;
        if (tileOverlay != null) {
            tileOverlay.b();
            this.D.f7071a = null;
        }
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null || !eVar.a(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay a2 = tileOverlayOptions.a(this);
        this.D = a2;
        return a2;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, 300);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i) {
        if (mapStatusUpdate == null || i <= 0) {
            return;
        }
        ab a2 = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return;
        }
        mapStatusReason |= 256;
        if (this.Q) {
            eVar.a(a2, i);
        } else {
            eVar.a(a2);
        }
    }

    public boolean b() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return false;
        }
        return eVar.e();
    }

    public void changeLocationLayerOrder(boolean z) {
        this.i.c(z);
    }

    public final void clear() {
        this.k.clear();
        this.l.clear();
        this.m.clear();
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            eVar.b(false);
            this.i.n();
        }
        hideInfoWindow();
    }

    public final Point getCompassPosition() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            return a(eVar.h());
        }
        return null;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        return this.i.p();
    }

    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.M;
    }

    public final MyLocationData getLocationData() {
        return this.L;
    }

    public final MapStatus getMapStatus() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return null;
        }
        return MapStatus.a(eVar.E());
    }

    public final LatLngBounds getMapStatusLimit() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return null;
        }
        return eVar.F();
    }

    public final int getMapType() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return 1;
        }
        if (eVar.l()) {
            return this.i.k() ? 2 : 1;
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
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return 0.0f;
        }
        return eVar.f7648a;
    }

    public final float getMinZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return 0.0f;
        }
        return eVar.f7649b;
    }

    public final Projection getProjection() {
        return this.f6847f;
    }

    public float[] getProjectionMatrix() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return null;
        }
        return eVar.M();
    }

    public final UiSettings getUiSettings() {
        return this.f6848g;
    }

    public float[] getViewMatrix() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return null;
        }
        return eVar.N();
    }

    public com.baidu.mapsdkplatform.comapi.map.j getmGLMapView() {
        return this.f6849h;
    }

    public void hideInfoWindow() {
        InfoWindow infoWindow = this.H;
        if (infoWindow != null) {
            if (infoWindow.f6918b != null) {
                int i = e.f7103b[this.f6846d.ordinal()];
                if (i == 1) {
                    TextureMapView textureMapView = this.f6844b;
                    if (textureMapView != null) {
                        textureMapView.removeView(this.J);
                    }
                } else if (i == 2 && this.f6849h != null) {
                    this.f6843a.removeView(this.J);
                }
                this.J = null;
            }
            this.H = null;
            this.I.remove();
            this.I = null;
        }
    }

    public void hideSDKLayer() {
        this.i.c();
    }

    public final boolean isBaiduHeatMapEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return false;
        }
        return eVar.i();
    }

    public boolean isBaseIndoorMapMode() {
        return this.i.q();
    }

    public final boolean isBuildingsEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return false;
        }
        return eVar.m();
    }

    public final boolean isMyLocationEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return false;
        }
        return eVar.s();
    }

    public final boolean isSupportBaiduHeatMap() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return false;
        }
        return eVar.j();
    }

    public final boolean isTrafficEnabled() {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return false;
        }
        return eVar.g();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.v.contains(onMarkerClickListener)) {
            this.v.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            eVar.g(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            eVar.i(z);
        }
    }

    public void setCompassEnable(boolean z) {
        this.i.d(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("compass's icon can not be null");
        }
        this.i.a(bitmap);
    }

    public void setCompassPosition(Point point) {
        if (this.i.a(point)) {
            this.R = point;
        }
    }

    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                this.i.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
                return true;
            }
            return true;
        } else if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
            this.i.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
            return true;
        } else {
            Log.e(f6842e, "the string of the input customTrafficColor is error");
            return false;
        }
    }

    public final void setIndoorEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            this.P = z;
            eVar.k(z);
        }
        OnBaseIndoorMapListener onBaseIndoorMapListener = this.B;
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
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return;
        }
        eVar.a(a2);
        OnMapStatusChangeListener onMapStatusChangeListener = this.o;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return;
        }
        eVar.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar == null) {
            return;
        }
        if (i == 1) {
            eVar.a(false);
            this.i.t(this.N);
            this.i.u(this.O);
            this.i.f(true);
            this.i.k(this.P);
        } else if (i == 2) {
            eVar.a(true);
            this.i.t(this.N);
            this.i.u(this.O);
            this.i.f(true);
        } else if (i == 3) {
            if (eVar.C()) {
                this.i.t(false);
            }
            if (this.i.D()) {
                this.i.u(false);
            }
            this.i.f(false);
            this.i.k(false);
        }
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6849h;
        if (jVar != null) {
            jVar.a(i);
        }
    }

    public final void setMaxAndMinZoomLevel(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        if (f2 <= 21.0f && f3 >= 4.0f && f2 >= f3 && (eVar = this.i) != null) {
            eVar.a(f2, f3);
        }
    }

    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        this.M = myLocationConfiguration;
        a(this.L, myLocationConfiguration);
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.L = myLocationData;
        if (this.M == null) {
            this.M = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.M);
    }

    public final void setMyLocationEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            eVar.m(z);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        this.B = onBaseIndoorMapListener;
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.q = onMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        this.t = onMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        this.A = onMapDrawFrameCallback;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        this.r = onMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.u = onMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        this.s = onMapRenderCallback;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        this.o = onMapStatusChangeListener;
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        this.p = onMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null || this.v.contains(onMarkerClickListener)) {
            return;
        }
        this.v.add(onMarkerClickListener);
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.x = onMarkerDragListener;
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        this.y = onMyLocationClickListener;
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener != null) {
            this.w.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        this.C = onSynchronizationListener;
    }

    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        ViewGroup viewGroup;
        MapView mapView;
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || (eVar = this.i) == null) {
            return;
        }
        eVar.E();
        int i5 = e.f7103b[this.f6846d.ordinal()];
        if (i5 == 1) {
            TextureMapView textureMapView = this.f6844b;
            if (textureMapView == null) {
                return;
            }
            float width = ((textureMapView.getWidth() - i) - i3) / this.f6844b.getWidth();
            float height = ((this.f6844b.getHeight() - i2) - i4) / this.f6844b.getHeight();
            MapStatusUpdate newMapStatus = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.f6844b.getWidth() + i) - i3) / 2, ((this.f6844b.getHeight() + i2) - i4) / 2)).build());
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.i;
            Point point = this.R;
            eVar2.a(new Point((int) (i + (point.x * width)), (int) (i2 + (point.y * height))));
            setMapStatus(newMapStatus);
            this.f6844b.setPadding(i, i2, i3, i4);
            viewGroup = this.f6844b;
        } else if (i5 != 2 || (mapView = this.f6843a) == null) {
            return;
        } else {
            float width2 = ((mapView.getWidth() - i) - i3) / this.f6843a.getWidth();
            float height2 = ((this.f6843a.getHeight() - i2) - i4) / this.f6843a.getHeight();
            MapStatusUpdate newMapStatus2 = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.f6843a.getWidth() + i) - i3) / 2, ((this.f6843a.getHeight() + i2) - i4) / 2)).build());
            com.baidu.mapsdkplatform.comapi.map.e eVar3 = this.i;
            Point point2 = this.R;
            eVar3.a(new Point((int) (i + (point2.x * width2)), (int) (i2 + (point2.y * height2))));
            setMapStatus(newMapStatus2);
            this.f6843a.setPadding(i, i2, i3, i4);
            viewGroup = this.f6843a;
        }
        viewGroup.invalidate();
    }

    public void setPixelFormatTransparent(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f6849h;
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
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            eVar.h(z);
        }
    }

    public final void setViewPadding(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup;
        MapView mapView;
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || this.i == null) {
            return;
        }
        int i5 = e.f7103b[this.f6846d.ordinal()];
        if (i5 == 1) {
            TextureMapView textureMapView = this.f6844b;
            if (textureMapView == null) {
                return;
            }
            float width = ((textureMapView.getWidth() - i) - i3) / this.f6844b.getWidth();
            float height = ((this.f6844b.getHeight() - i2) - i4) / this.f6844b.getHeight();
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
            Point point = this.R;
            eVar.a(new Point((int) (i + (point.x * width)), (int) (i2 + (point.y * height))));
            this.f6844b.setPadding(i, i2, i3, i4);
            viewGroup = this.f6844b;
        } else if (i5 != 2 || (mapView = this.f6843a) == null) {
            return;
        } else {
            float width2 = ((mapView.getWidth() - i) - i3) / this.f6843a.getWidth();
            float height2 = ((this.f6843a.getHeight() - i2) - i4) / this.f6843a.getHeight();
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.i;
            Point point2 = this.R;
            eVar2.a(new Point((int) (i + (point2.x * width2)), (int) (i2 + (point2.y * height2))));
            this.f6843a.setPadding(i, i2, i3, i4);
            viewGroup = this.f6843a;
        }
        viewGroup.invalidate();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow != null) {
            hideInfoWindow();
            View view = infoWindow.f6918b;
            if (view != null) {
                this.J = view;
                view.destroyDrawingCache();
                MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.f6919c).yOffset(infoWindow.f6921e).build();
                int i = e.f7103b[this.f6846d.ordinal()];
                if (i == 1) {
                    TextureMapView textureMapView = this.f6844b;
                    if (textureMapView != null) {
                        textureMapView.addView(this.J, build);
                    }
                } else if (i == 2 && this.f6849h != null) {
                    this.f6843a.addView(this.J, build);
                }
            }
            this.H = infoWindow;
            View view2 = infoWindow.f6918b;
            Overlay a2 = new MarkerOptions().perspective(false).icon(view2 != null ? BitmapDescriptorFactory.fromView(view2) : infoWindow.f6917a).position(infoWindow.f6919c).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.f6921e).a();
            a2.listener = this.n;
            a2.type = com.baidu.mapsdkplatform.comapi.map.h.popup;
            Bundle bundle = new Bundle();
            a2.a(bundle);
            if (infoWindow.f6918b != null) {
                bundle.putInt("by_view", 1);
            } else {
                bundle.putInt("by_view", 0);
            }
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
            if (eVar != null) {
                eVar.b(bundle);
            }
            this.k.add(a2);
            this.I = (Marker) a2;
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            eVar.u(z);
            this.O = z;
        }
    }

    public final void showMapPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.i;
        if (eVar != null) {
            eVar.t(z);
            this.N = z;
        }
    }

    public void showSDKLayer() {
        this.i.d();
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        this.z = snapshotReadyCallback;
        int i = e.f7103b[this.f6846d.ordinal()];
        if (i != 1) {
            if (i == 2 && (jVar = this.f6849h) != null) {
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
        this.z = snapshotReadyCallback;
        int i = e.f7103b[this.f6846d.ordinal()];
        if (i != 1) {
            if (i == 2 && (jVar = this.f6849h) != null) {
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
        if (str2.equals(focusedBaseIndoorMapInfo.f6925a)) {
            ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
            return (floors == null || !floors.contains(str)) ? MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW : this.i.a(str, str2) ? MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK : MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        }
        return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
    }
}
