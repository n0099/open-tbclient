package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes5.dex */
public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    private OnMapDrawFrameCallback A;
    private OnBaseIndoorMapListener B;
    private OnSynchronizationListener C;
    private TileOverlay D;
    private HeatMap E;
    private Lock F;
    private Lock G;
    private InfoWindow H;
    private Marker I;
    private View J;
    private Marker K;
    private MyLocationData L;
    private MyLocationConfiguration M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private Point R;
    MapView a;
    TextureMapView b;
    WearMapView c;
    aa d;
    private Projection f;
    private UiSettings g;
    private com.baidu.mapsdkplatform.comapi.map.j h;
    private com.baidu.mapsdkplatform.comapi.map.e i;
    private ac j;
    private List<Overlay> k;
    private List<Marker> l;
    private List<Marker> m;
    private Overlay.a n;
    private OnMapStatusChangeListener o;
    private OnMapTouchListener p;
    private OnMapClickListener q;
    private OnMapLoadedCallback r;
    private OnMapRenderCallback s;
    private OnMapDoubleClickListener t;
    private OnMapLongClickListener u;
    private CopyOnWriteArrayList<OnMarkerClickListener> v;
    private CopyOnWriteArrayList<OnPolylineClickListener> w;
    private OnMarkerDragListener x;
    private OnMyLocationClickListener y;
    private SnapshotReadyCallback z;
    public static int mapStatusReason = 0;
    private static final String e = BaiduMap.class.getSimpleName();

    /* loaded from: classes5.dex */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* loaded from: classes5.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        boolean onMapPoiClick(MapPoi mapPoi);
    }

    /* loaded from: classes5.dex */
    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    /* loaded from: classes5.dex */
    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    /* loaded from: classes5.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* loaded from: classes5.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: classes5.dex */
    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    /* loaded from: classes5.dex */
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i);
    }

    /* loaded from: classes5.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes5.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: classes5.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: classes5.dex */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    /* loaded from: classes5.dex */
    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    /* loaded from: classes5.dex */
    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i);
    }

    /* loaded from: classes5.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaiduMap(ac acVar) {
        this.v = new CopyOnWriteArrayList<>();
        this.w = new CopyOnWriteArrayList<>();
        this.F = new ReentrantLock();
        this.G = new ReentrantLock();
        this.j = acVar;
        this.i = this.j.b();
        this.d = aa.TextureView;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaiduMap(com.baidu.mapsdkplatform.comapi.map.j jVar) {
        this.v = new CopyOnWriteArrayList<>();
        this.w = new CopyOnWriteArrayList<>();
        this.F = new ReentrantLock();
        this.G = new ReentrantLock();
        this.h = jVar;
        this.i = this.h.a();
        this.d = aa.GLSurfaceView;
        c();
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            String[] split = str2.replaceAll("\"", "").split(":");
            if (Config.EVENT_HEAT_X.equals(split[0])) {
                i2 = Integer.valueOf(split[1]).intValue();
            }
            if ("y".equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
            }
        }
        return new Point(i2, i);
    }

    private ab a(MapStatusUpdate mapStatusUpdate) {
        if (this.i == null) {
            return null;
        }
        ab E = this.i.E();
        MapStatus a = mapStatusUpdate.a(this.i, getMapStatus());
        if (a != null) {
            return a.b(E);
        }
        return null;
    }

    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
        Bundle bundle;
        float f;
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
            float f2 = myLocationData.direction;
            if (myLocationConfiguration.enableDirection) {
                f = myLocationData.direction % 360.0f;
                if (f > 180.0f) {
                    f -= 360.0f;
                } else if (f < -180.0f) {
                    f += 360.0f;
                }
            } else {
                f = -1.0f;
            }
            jSONObject2.put("direction", f);
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
                jSONObject3.put("radius", 0);
                jSONObject3.put("direction", 0);
                jSONObject3.put("iconarrownor", "direction_wheel");
                jSONObject3.put("iconarrownorid", 54);
                jSONObject3.put("iconarrowfoc", "direction_wheel");
                jSONObject3.put("iconarrowfocid", 54);
                jSONArray.put(jSONObject3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (myLocationConfiguration.customMarker == null) {
            bundle = null;
        } else {
            ArrayList<BitmapDescriptor> arrayList = new ArrayList();
            arrayList.add(myLocationConfiguration.customMarker);
            Bundle bundle2 = new Bundle();
            ArrayList arrayList2 = new ArrayList();
            for (BitmapDescriptor bitmapDescriptor : arrayList) {
                ParcelItem parcelItem = new ParcelItem();
                Bundle bundle3 = new Bundle();
                Bitmap bitmap = bitmapDescriptor.a;
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
                for (int i = 0; i < arrayList2.size(); i++) {
                    parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        if (this.i != null) {
            this.i.a(jSONObject.toString(), bundle);
        }
        switch (e.a[myLocationConfiguration.locationMode.ordinal()]) {
            case 1:
                animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
                return;
            case 2:
                animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
                return;
            case 3:
            default:
                return;
        }
    }

    private void c() {
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.R = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        this.g = new UiSettings(this.i);
        this.n = new a(this);
        this.i.a(new b(this));
        this.i.a(new c(this));
        this.i.a(new d(this));
        this.N = this.i.C();
        this.O = this.i.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.i == null) {
            return;
        }
        this.i.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HeatMap heatMap) {
        this.F.lock();
        try {
            if (this.E != null && this.i != null && heatMap == this.E) {
                this.E.b();
                this.E.c();
                this.E.a = null;
                this.i.o();
                this.E = null;
                this.i.n(false);
            }
        } finally {
            this.F.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TileOverlay tileOverlay) {
        this.G.lock();
        if (tileOverlay != null) {
            try {
                if (this.D == tileOverlay) {
                    tileOverlay.b();
                    tileOverlay.a = null;
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
                this.E.a = null;
                this.i.o();
            }
            this.E = heatMap;
            this.E.a = this;
            this.i.n(true);
        } finally {
            this.F.unlock();
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions == null) {
            return null;
        }
        Overlay a = overlayOptions.a();
        a.listener = this.n;
        if (a instanceof Marker) {
            Marker marker = (Marker) a;
            if (marker.o != null && marker.o.size() != 0) {
                this.l.add(marker);
                if (this.i != null) {
                    this.i.b(true);
                }
            }
            this.m.add(marker);
        }
        Bundle bundle = new Bundle();
        a.a(bundle);
        if (this.i != null) {
            this.i.b(bundle);
        }
        this.k.add(a);
        return a;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Bundle[] bundleArr = new Bundle[list.size()];
        int i = 0;
        for (OverlayOptions overlayOptions : list) {
            if (overlayOptions != null) {
                Bundle bundle = new Bundle();
                Overlay a = overlayOptions.a();
                a.listener = this.n;
                if (a instanceof Marker) {
                    Marker marker = (Marker) a;
                    if (marker.o != null && marker.o.size() != 0) {
                        this.l.add(marker);
                        if (this.i != null) {
                            this.i.b(true);
                        }
                    }
                    this.m.add(marker);
                }
                this.k.add(a);
                arrayList.add(a);
                a.a(bundle);
                bundleArr[i] = bundle;
                i++;
            }
        }
        int length = bundleArr.length / 400;
        for (int i2 = 0; i2 < length + 1; i2++) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < 400 && (i2 * 400) + i3 < bundleArr.length; i3++) {
                if (bundleArr[(i2 * 400) + i3] != null) {
                    arrayList2.add(bundleArr[(i2 * 400) + i3]);
                }
            }
            if (this.i != null) {
                this.i.a(arrayList2);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        if (this.D != null) {
            this.D.b();
            this.D.a = null;
        }
        if (this.i == null || !this.i.a(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay a = tileOverlayOptions.a(this);
        this.D = a;
        return a;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, 300);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i) {
        if (mapStatusUpdate == null || i <= 0) {
            return;
        }
        ab a = a(mapStatusUpdate);
        if (this.i != null) {
            mapStatusReason |= 256;
            if (this.Q) {
                this.i.a(a, i);
            } else {
                this.i.a(a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        if (this.i == null) {
            return false;
        }
        return this.i.e();
    }

    public void changeLocationLayerOrder(boolean z) {
        this.i.c(z);
    }

    public final void clear() {
        this.k.clear();
        this.l.clear();
        this.m.clear();
        if (this.i != null) {
            this.i.b(false);
            this.i.n();
        }
        hideInfoWindow();
    }

    public final Point getCompassPosition() {
        if (this.i != null) {
            return a(this.i.h());
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
        if (this.i == null) {
            return null;
        }
        return MapStatus.a(this.i.E());
    }

    public final LatLngBounds getMapStatusLimit() {
        if (this.i == null) {
            return null;
        }
        return this.i.F();
    }

    public final int getMapType() {
        if (this.i == null) {
            return 1;
        }
        if (this.i.l()) {
            return this.i.k() ? 2 : 1;
        }
        return 3;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.m.size() != 0) {
            for (Marker marker : this.m) {
                if (latLngBounds.contains(marker.getPosition())) {
                    arrayList.add(marker);
                }
            }
            return arrayList;
        }
        return null;
    }

    public final float getMaxZoomLevel() {
        if (this.i == null) {
            return 0.0f;
        }
        return this.i.a;
    }

    public final float getMinZoomLevel() {
        if (this.i == null) {
            return 0.0f;
        }
        return this.i.b;
    }

    public final Projection getProjection() {
        return this.f;
    }

    public float[] getProjectionMatrix() {
        if (this.i == null) {
            return null;
        }
        return this.i.M();
    }

    public final UiSettings getUiSettings() {
        return this.g;
    }

    public float[] getViewMatrix() {
        if (this.i == null) {
            return null;
        }
        return this.i.N();
    }

    public com.baidu.mapsdkplatform.comapi.map.j getmGLMapView() {
        return this.h;
    }

    public void hideInfoWindow() {
        if (this.H != null) {
            if (this.H.b != null) {
                switch (e.b[this.d.ordinal()]) {
                    case 1:
                        if (this.b != null) {
                            this.b.removeView(this.J);
                            break;
                        }
                        break;
                    case 2:
                        if (this.h != null) {
                            this.a.removeView(this.J);
                            break;
                        }
                        break;
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
        if (this.i == null) {
            return false;
        }
        return this.i.i();
    }

    public boolean isBaseIndoorMapMode() {
        return this.i.q();
    }

    public final boolean isBuildingsEnabled() {
        if (this.i == null) {
            return false;
        }
        return this.i.m();
    }

    public final boolean isMyLocationEnabled() {
        if (this.i == null) {
            return false;
        }
        return this.i.s();
    }

    public final boolean isSupportBaiduHeatMap() {
        if (this.i == null) {
            return false;
        }
        return this.i.j();
    }

    public final boolean isTrafficEnabled() {
        if (this.i == null) {
            return false;
        }
        return this.i.g();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.v.contains(onMarkerClickListener)) {
            this.v.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        if (this.i != null) {
            this.i.g(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        if (this.i != null) {
            this.i.i(z);
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
            }
        } else if (!str.matches("^#[0-9a-fA-F]{8}$") || !str2.matches("^#[0-9a-fA-F]{8}$") || !str3.matches("^#[0-9a-fA-F]{8}$") || !str4.matches("^#[0-9a-fA-F]{8}$")) {
            Log.e(e, "the string of the input customTrafficColor is error");
            return false;
        } else {
            this.i.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
        }
        return true;
    }

    public final void setIndoorEnable(boolean z) {
        if (this.i != null) {
            this.P = z;
            this.i.k(z);
        }
        if (this.B == null || z) {
            return;
        }
        this.B.onBaseIndoorMapMode(false, null);
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate == null) {
            return;
        }
        ab a = a(mapStatusUpdate);
        if (this.i != null) {
            this.i.a(a);
            if (this.o != null) {
                this.o.onMapStatusChange(getMapStatus());
            }
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        if (this.i == null) {
            return;
        }
        this.i.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i) {
        if (this.i == null) {
            return;
        }
        switch (i) {
            case 1:
                this.i.a(false);
                this.i.t(this.N);
                this.i.u(this.O);
                this.i.f(true);
                this.i.k(this.P);
                break;
            case 2:
                this.i.a(true);
                this.i.t(this.N);
                this.i.u(this.O);
                this.i.f(true);
                break;
            case 3:
                if (this.i.C()) {
                    this.i.t(false);
                }
                if (this.i.D()) {
                    this.i.u(false);
                }
                this.i.f(false);
                this.i.k(false);
                break;
        }
        if (this.h != null) {
            this.h.a(i);
        }
    }

    public final void setMaxAndMinZoomLevel(float f, float f2) {
        if (f <= 21.0f && f2 >= 4.0f && f >= f2 && this.i != null) {
            this.i.a(f, f2);
        }
    }

    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        this.M = myLocationConfiguration;
        a(this.L, this.M);
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.L = myLocationData;
        if (this.M == null) {
            this.M = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.M);
    }

    public final void setMyLocationEnabled(boolean z) {
        if (this.i != null) {
            this.i.m(z);
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
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || this.i == null) {
            return;
        }
        this.i.E();
        switch (e.b[this.d.ordinal()]) {
            case 1:
                if (this.b != null) {
                    float width = ((this.b.getWidth() - i) - i3) / this.b.getWidth();
                    float height = ((this.b.getHeight() - i2) - i4) / this.b.getHeight();
                    MapStatusUpdate newMapStatus = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.b.getWidth() + i) - i3) / 2, ((this.b.getHeight() + i2) - i4) / 2)).build());
                    this.i.a(new Point((int) ((width * this.R.x) + i), (int) ((height * this.R.y) + i2)));
                    setMapStatus(newMapStatus);
                    this.b.setPadding(i, i2, i3, i4);
                    this.b.invalidate();
                    return;
                }
                return;
            case 2:
                if (this.a != null) {
                    float width2 = ((this.a.getWidth() - i) - i3) / this.a.getWidth();
                    float height2 = ((this.a.getHeight() - i2) - i4) / this.a.getHeight();
                    MapStatusUpdate newMapStatus2 = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.a.getWidth() + i) - i3) / 2, ((this.a.getHeight() + i2) - i4) / 2)).build());
                    this.i.a(new Point((int) ((width2 * this.R.x) + i), (int) ((height2 * this.R.y) + i2)));
                    setMapStatus(newMapStatus2);
                    this.a.setPadding(i, i2, i3, i4);
                    this.a.invalidate();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setPixelFormatTransparent(boolean z) {
        if (this.h == null) {
            return;
        }
        if (z) {
            this.h.d();
        } else {
            this.h.e();
        }
    }

    public final void setTrafficEnabled(boolean z) {
        if (this.i != null) {
            this.i.h(z);
        }
    }

    public final void setViewPadding(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || this.i == null) {
            return;
        }
        switch (e.b[this.d.ordinal()]) {
            case 1:
                if (this.b != null) {
                    float width = ((this.b.getWidth() - i) - i3) / this.b.getWidth();
                    float height = ((this.b.getHeight() - i2) - i4) / this.b.getHeight();
                    this.i.a(new Point((int) ((width * this.R.x) + i), (int) ((height * this.R.y) + i2)));
                    this.b.setPadding(i, i2, i3, i4);
                    this.b.invalidate();
                    return;
                }
                return;
            case 2:
                if (this.a != null) {
                    float width2 = ((this.a.getWidth() - i) - i3) / this.a.getWidth();
                    float height2 = ((this.a.getHeight() - i2) - i4) / this.a.getHeight();
                    this.i.a(new Point((int) ((width2 * this.R.x) + i), (int) ((height2 * this.R.y) + i2)));
                    this.a.setPadding(i, i2, i3, i4);
                    this.a.invalidate();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow != null) {
            hideInfoWindow();
            if (infoWindow.b != null) {
                this.J = infoWindow.b;
                this.J.destroyDrawingCache();
                MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.c).yOffset(infoWindow.e).build();
                switch (e.b[this.d.ordinal()]) {
                    case 1:
                        if (this.b != null) {
                            this.b.addView(this.J, build);
                            break;
                        }
                        break;
                    case 2:
                        if (this.h != null) {
                            this.a.addView(this.J, build);
                            break;
                        }
                        break;
                }
            }
            this.H = infoWindow;
            Overlay a = new MarkerOptions().perspective(false).icon(infoWindow.b != null ? BitmapDescriptorFactory.fromView(infoWindow.b) : infoWindow.a).position(infoWindow.c).zIndex(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).yOffset(infoWindow.e).a();
            a.listener = this.n;
            a.type = com.baidu.mapsdkplatform.comapi.map.h.popup;
            Bundle bundle = new Bundle();
            a.a(bundle);
            if (infoWindow.b != null) {
                bundle.putInt("by_view", 1);
            } else {
                bundle.putInt("by_view", 0);
            }
            if (this.i != null) {
                this.i.b(bundle);
            }
            this.k.add(a);
            this.I = (Marker) a;
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        if (this.i != null) {
            this.i.u(z);
            this.O = z;
        }
    }

    public final void showMapPoi(boolean z) {
        if (this.i != null) {
            this.i.t(z);
            this.N = z;
        }
    }

    public void showSDKLayer() {
        this.i.d();
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        this.z = snapshotReadyCallback;
        switch (e.b[this.d.ordinal()]) {
            case 1:
                if (this.j != null) {
                    this.j.a("anything", null);
                    return;
                }
                return;
            case 2:
                if (this.h != null) {
                    this.h.a("anything", (Rect) null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        this.z = snapshotReadyCallback;
        switch (e.b[this.d.ordinal()]) {
            case 1:
                if (this.j != null) {
                    this.j.a("anything", rect);
                    return;
                }
                return;
            case 2:
                if (this.h != null) {
                    this.h.a("anything", rect);
                    return;
                }
                return;
            default:
                return;
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
        if (str2.equals(focusedBaseIndoorMapInfo.a)) {
            ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
            return (floors == null || !floors.contains(str)) ? MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW : this.i.a(str, str2) ? MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK : MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        }
        return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
    }
}
