package com.baidu.mapapi.map;

import android.content.Context;
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
import com.baidu.live.tbadk.statics.AlaStaticKeys;
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
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes7.dex */
public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final float REAL_MAX_ZOOM_LEVEL = 21.0f;
    public static final float REAL_MIN_ZOOM_LEVEL = 4.0f;
    private OnMyLocationClickListener A;
    private SnapshotReadyCallback B;
    private OnMapDrawFrameCallback C;
    private OnBaseIndoorMapListener D;
    private OnMapRenderValidDataListener E;
    private OnSynchronizationListener F;
    private TileOverlay G;
    private HeatMap H;
    private Map<String, InfoWindow> K;
    private Map<InfoWindow, Marker> L;
    private Marker M;
    private MyLocationData N;
    private MyLocationConfiguration O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private Point T;

    /* renamed from: a  reason: collision with root package name */
    MapView f1997a;
    TextureMapView b;
    WearMapView c;
    com.baidu.mapsdkplatform.comapi.map.v d;
    private Projection f;
    private UiSettings g;
    private MapSurfaceView h;
    private MapTextureView i;
    private com.baidu.mapsdkplatform.comapi.map.d j;
    private List<Overlay> k;
    private List<Marker> l;
    private List<Marker> m;
    private List<InfoWindow> n;
    private Overlay.a o;
    private InfoWindow.a p;
    private OnMapStatusChangeListener q;
    private OnMapTouchListener r;
    private OnMapClickListener s;
    private OnMapLoadedCallback t;
    private OnMapRenderCallback u;
    private OnMapDoubleClickListener v;
    private OnMapLongClickListener w;
    private OnMarkerDragListener z;
    public static int mapStatusReason = 0;
    private static final String e = BaiduMap.class.getSimpleName();
    private CopyOnWriteArrayList<OnMarkerClickListener> x = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<OnPolylineClickListener> y = new CopyOnWriteArrayList<>();
    private Lock I = new ReentrantLock();
    private Lock J = new ReentrantLock();
    private volatile boolean U = false;

    /* loaded from: classes7.dex */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* loaded from: classes7.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        void onMapPoiClick(MapPoi mapPoi);
    }

    /* loaded from: classes7.dex */
    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    /* loaded from: classes7.dex */
    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    /* loaded from: classes7.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* loaded from: classes7.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: classes7.dex */
    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    /* loaded from: classes7.dex */
    public interface OnMapRenderValidDataListener {
        void onMapRenderValidData(boolean z, int i, String str);
    }

    /* loaded from: classes7.dex */
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i);
    }

    /* loaded from: classes7.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes7.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: classes7.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: classes7.dex */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    /* loaded from: classes7.dex */
    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    /* loaded from: classes7.dex */
    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i);
    }

    /* loaded from: classes7.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaiduMap(Context context, MapSurfaceView mapSurfaceView, com.baidu.mapsdkplatform.comapi.map.u uVar) {
        this.h = mapSurfaceView;
        this.j = new com.baidu.mapsdkplatform.comapi.map.d(context, mapSurfaceView, uVar, (String) null, 0);
        mapSurfaceView.setBaseMap(this.j);
        this.d = com.baidu.mapsdkplatform.comapi.map.v.GLSurfaceView;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaiduMap(Context context, MapTextureView mapTextureView, com.baidu.mapsdkplatform.comapi.map.u uVar) {
        this.i = mapTextureView;
        this.j = new com.baidu.mapsdkplatform.comapi.map.d(context, mapTextureView, uVar, (String) null, 0);
        mapTextureView.setBaseMap(this.j);
        this.d = com.baidu.mapsdkplatform.comapi.map.v.TextureView;
        d();
    }

    private Point a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            String[] split = str2.replaceAll("\"", "").split(":");
            if ("x".equals(split[0])) {
                i2 = Integer.valueOf(split[1]).intValue();
            }
            if ("y".equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
            }
        }
        return new Point(i2, i);
    }

    private com.baidu.mapsdkplatform.comapi.map.w a(MapStatusUpdate mapStatusUpdate) {
        if (this.j == null) {
            return null;
        }
        com.baidu.mapsdkplatform.comapi.map.w B = this.j.B();
        MapStatus a2 = mapStatusUpdate.a(this.j, getMapStatus());
        if (a2 != null) {
            return a2.b(B);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(InfoWindow infoWindow) {
        boolean z;
        Marker marker;
        if (infoWindow == null || this.U) {
            return;
        }
        Set<InfoWindow> keySet = this.L.keySet();
        if (keySet.isEmpty() || !keySet.contains(infoWindow)) {
            showInfoWindow(infoWindow, false);
            return;
        }
        View view = infoWindow.b;
        if (view != null && infoWindow.j) {
            view.destroyDrawingCache();
            MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.c).yOffset(infoWindow.f).build();
            switch (b.b[this.d.ordinal()]) {
                case 1:
                    if (this.b != null) {
                        this.b.removeView(view);
                        this.b.addView(view, build);
                        break;
                    }
                    break;
                case 2:
                    if (this.f1997a != null) {
                        this.f1997a.removeView(view);
                        this.f1997a.addView(view, build);
                        break;
                    }
                    break;
            }
            if (infoWindow.i) {
                z = false;
                BitmapDescriptor b = b(infoWindow);
                marker = this.L.get(infoWindow);
                if (marker == null) {
                    Bundle bundle = new Bundle();
                    if (infoWindow.f2013a != null) {
                        marker.type = com.baidu.mapsdkplatform.comapi.map.i.popup;
                        marker.b = b;
                        if (infoWindow.b != null) {
                            bundle.putInt("draw_with_view", 1);
                        } else {
                            bundle.putInt("draw_with_view", 0);
                        }
                    }
                    marker.f2029a = infoWindow.c;
                    marker.i = infoWindow.f;
                    marker.a(bundle);
                    if (this.j == null || !z || this.U) {
                        return;
                    }
                    this.j.c(bundle);
                    return;
                }
                return;
            }
        }
        z = true;
        BitmapDescriptor b2 = b(infoWindow);
        marker = this.L.get(infoWindow);
        if (marker == null) {
        }
    }

    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
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
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, ll2mc.getLongitudeE6());
            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, ll2mc.getLatitudeE6());
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
                f = -1001.0f;
            }
            jSONObject2.put("direction", f);
            jSONObject2.put("iconarrownor", "NormalLocArrow");
            jSONObject2.put("iconarrownorid", 28);
            jSONObject2.put("iconarrowfoc", "FocusLocArrow");
            jSONObject2.put("iconarrowfocid", 29);
            jSONObject2.put("lineid", myLocationConfiguration.accuracyCircleStrokeColor);
            jSONObject2.put("areaid", myLocationConfiguration.accuracyCircleFillColor);
            jSONArray.put(jSONObject2);
            if (myLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS) {
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, ll2mc.getLongitudeE6());
                jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, ll2mc.getLatitudeE6());
                jSONObject3.put("radius", 0);
                jSONObject3.put("direction", 0);
                jSONObject3.put("iconarrownor", "direction_wheel");
                jSONObject3.put("iconarrownorid", 54);
                jSONObject3.put("iconarrowfoc", "direction_wheel");
                jSONObject3.put("iconarrowfocid", 54);
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (myLocationConfiguration.customMarker != null) {
            Bitmap bitmap = myLocationConfiguration.customMarker.getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                ArrayList arrayList = new ArrayList();
                OverlayLocationData overlayLocationData = new OverlayLocationData();
                overlayLocationData.setImage(bitmap);
                overlayLocationData.setImgHeight(bitmap.getHeight());
                overlayLocationData.setImgWidth(bitmap.getWidth());
                overlayLocationData.setImgName(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                overlayLocationData.setRotation(0);
                arrayList.add(overlayLocationData);
                if (this.j != null) {
                    this.j.b(arrayList);
                }
            }
        } else if (this.j != null) {
            this.j.r();
        }
        if (this.j != null) {
            this.j.a(jSONObject.toString(), (Bundle) null);
        }
        switch (b.f2067a[myLocationConfiguration.locationMode.ordinal()]) {
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

    private BitmapDescriptor b(InfoWindow infoWindow) {
        BitmapDescriptor fromView;
        if (infoWindow.b == null || !infoWindow.j) {
            return infoWindow.f2013a;
        }
        if (infoWindow.g) {
            if (infoWindow.h <= 0) {
                infoWindow.h = SysOSUtil.getDensityDpi();
            }
            fromView = BitmapDescriptorFactory.fromViewWithDpi(infoWindow.b, infoWindow.h);
        } else {
            fromView = BitmapDescriptorFactory.fromView(infoWindow.b);
        }
        infoWindow.f2013a = fromView;
        return fromView;
    }

    private void d() {
        this.U = false;
        this.k = new CopyOnWriteArrayList();
        this.l = new CopyOnWriteArrayList();
        this.m = new CopyOnWriteArrayList();
        this.K = new ConcurrentHashMap();
        this.L = new ConcurrentHashMap();
        this.n = new CopyOnWriteArrayList();
        this.T = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        this.g = new UiSettings(this.j);
        this.o = new a(this);
        this.p = new c(this);
        this.j.a(new d(this));
        this.j.a(new e(this));
        this.j.a(new f(this));
        this.P = this.j.z();
        this.Q = this.j.A();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.j == null) {
            return;
        }
        this.j.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HeatMap heatMap) {
        this.I.lock();
        try {
            if (this.H != null && this.j != null && heatMap == this.H) {
                this.H.b();
                this.H.c();
                this.H.f2011a = null;
                this.j.n();
                this.H = null;
                this.j.p(false);
            }
        } finally {
            this.I.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(TileOverlay tileOverlay) {
        this.J.lock();
        if (tileOverlay != null) {
            try {
                if (this.G == tileOverlay) {
                    tileOverlay.b();
                    tileOverlay.f2050a = null;
                    if (this.j != null) {
                        this.j.f(false);
                    }
                }
            } finally {
                this.G = null;
                this.J.unlock();
            }
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap == null || this.j == null) {
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
                this.H.f2011a = null;
                this.j.n();
            }
            this.H = heatMap;
            this.H.f2011a = this;
            this.j.p(true);
        } finally {
            this.I.unlock();
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions == null || this.U) {
            return null;
        }
        Overlay a2 = overlayOptions.a();
        a2.listener = this.o;
        if (a2 instanceof Marker) {
            Marker marker = (Marker) a2;
            marker.x = this.p;
            if (marker.p != null && marker.p.size() != 0) {
                this.l.add(marker);
                if (this.j != null) {
                    this.j.b(true);
                }
            }
            this.m.add(marker);
            if (marker.w != null) {
                showInfoWindow(marker.w, false);
            }
        }
        Bundle bundle = new Bundle();
        a2.a(bundle);
        if (this.j != null && !this.U) {
            this.j.b(bundle);
        }
        this.k.add(a2);
        return a2;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        if (list == null || this.U) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Bundle[] bundleArr = new Bundle[list.size()];
        int i = 0;
        for (OverlayOptions overlayOptions : list) {
            if (overlayOptions != null) {
                Bundle bundle = new Bundle();
                Overlay a2 = overlayOptions.a();
                a2.listener = this.o;
                if (a2 instanceof Marker) {
                    Marker marker = (Marker) a2;
                    marker.x = this.p;
                    if (marker.p != null && marker.p.size() != 0) {
                        this.l.add(marker);
                        if (this.j != null) {
                            this.j.b(true);
                        }
                    }
                    this.m.add(marker);
                }
                this.k.add(a2);
                arrayList.add(a2);
                a2.a(bundle);
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
            if (this.j != null) {
                this.j.a(arrayList2);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        if (this.G != null) {
            this.G.b();
            this.G.f2050a = null;
        }
        if (this.j == null || !this.j.a(tileOverlayOptions.a())) {
            return null;
        }
        TileOverlay a2 = tileOverlayOptions.a(this);
        this.G = a2;
        return a2;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, 300);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i) {
        if (mapStatusUpdate == null || i <= 0) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.w a2 = a(mapStatusUpdate);
        if (this.j != null) {
            mapStatusReason |= 256;
            if (this.S) {
                this.j.a(a2, i);
            } else {
                this.j.a(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        if (this.j == null) {
            return false;
        }
        return this.j.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.U = true;
    }

    public void changeLocationLayerOrder(boolean z) {
        if (this.j == null) {
            return;
        }
        this.j.d(z);
    }

    public void cleanCache(int i) {
        if (this.j == null) {
            return;
        }
        this.j.a(i);
    }

    public final void clear() {
        this.k.clear();
        this.l.clear();
        this.m.clear();
        if (this.j != null) {
            this.j.b(false);
            this.j.m();
        }
        hideInfoWindow();
    }

    public List<InfoWindow> getAllInfoWindows() {
        return this.n;
    }

    public final Point getCompassPosition() {
        if (this.j != null) {
            return a(this.j.g());
        }
        return null;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        if (this.j == null) {
            return null;
        }
        return this.j.o();
    }

    public MapSurfaceView getGLMapView() {
        return this.h;
    }

    @Deprecated
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
        if (this.j == null) {
            return null;
        }
        return MapStatus.a(this.j.B());
    }

    public final LatLngBounds getMapStatusLimit() {
        if (this.j == null) {
            return null;
        }
        return this.j.C();
    }

    public final int getMapType() {
        if (this.j == null) {
            return 1;
        }
        if (this.j.k()) {
            return this.j.j() ? 2 : 1;
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
        if (this.j == null) {
            return 0.0f;
        }
        return this.j.b();
    }

    public final float getMinZoomLevel() {
        if (this.j == null) {
            return 0.0f;
        }
        return this.j.b;
    }

    public final Projection getProjection() {
        return this.f;
    }

    public float[] getProjectionMatrix() {
        if (this.j == null) {
            return null;
        }
        return this.j.J();
    }

    public final UiSettings getUiSettings() {
        return this.g;
    }

    public float[] getViewMatrix() {
        if (this.j == null) {
            return null;
        }
        return this.j.K();
    }

    public float getZoomToBound(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.j == null) {
            return 0.0f;
        }
        return this.j.a(i, i2, i3, i4, i5, i6);
    }

    @Deprecated
    public MapSurfaceView getmGLMapView() {
        return this.h;
    }

    public void hideInfoWindow() {
        View view;
        Collection<InfoWindow> values = this.K.values();
        if (!values.isEmpty()) {
            for (InfoWindow infoWindow : values) {
                if (infoWindow != null && (view = infoWindow.b) != null) {
                    switch (b.b[this.d.ordinal()]) {
                        case 1:
                            if (this.b != null) {
                                this.b.removeView(view);
                                break;
                            } else {
                                continue;
                            }
                        case 2:
                            if (this.f1997a != null) {
                                this.f1997a.removeView(view);
                                break;
                            } else {
                                continue;
                            }
                    }
                }
            }
        }
        for (Overlay overlay : this.k) {
            Set<String> keySet = this.K.keySet();
            String str = overlay.z;
            if ((overlay instanceof Marker) && !keySet.isEmpty() && keySet.contains(str)) {
                overlay.remove();
            }
        }
        this.K.clear();
        this.L.clear();
        this.n.clear();
    }

    public void hideInfoWindow(InfoWindow infoWindow) {
        Set<InfoWindow> keySet = this.L.keySet();
        if (infoWindow == null || keySet.isEmpty() || !keySet.contains(infoWindow)) {
            return;
        }
        View view = infoWindow.b;
        if (view != null) {
            switch (b.b[this.d.ordinal()]) {
                case 1:
                    if (this.b != null) {
                        this.b.removeView(view);
                        break;
                    }
                    break;
                case 2:
                    if (this.f1997a != null) {
                        this.f1997a.removeView(view);
                        break;
                    }
                    break;
            }
        }
        Marker marker = this.L.get(infoWindow);
        if (marker != null) {
            marker.remove();
            this.K.remove(marker.z);
        }
        this.L.remove(infoWindow);
        this.n.remove(infoWindow);
    }

    public void hideSDKLayer() {
        if (this.j == null) {
            return;
        }
        this.j.c();
    }

    public final boolean isBaiduHeatMapEnabled() {
        if (this.j == null) {
            return false;
        }
        return this.j.h();
    }

    public boolean isBaseIndoorMapMode() {
        if (this.j == null) {
            return false;
        }
        return this.j.p();
    }

    public final boolean isBuildingsEnabled() {
        if (this.j == null) {
            return false;
        }
        return this.j.l();
    }

    public final boolean isMyLocationEnabled() {
        if (this.j == null) {
            return false;
        }
        return this.j.s();
    }

    public final boolean isSupportBaiduHeatMap() {
        if (this.j == null) {
            return false;
        }
        return this.j.i();
    }

    public final boolean isTrafficEnabled() {
        if (this.j == null) {
            return false;
        }
        return this.j.f();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.x.contains(onMarkerClickListener)) {
            this.x.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        if (this.j != null) {
            this.j.h(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        if (this.j != null) {
            this.j.j(z);
        }
    }

    public void setCompassEnable(boolean z) {
        if (this.j == null) {
            return;
        }
        this.j.e(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
        }
        if (this.j == null) {
            return;
        }
        this.j.a(bitmap);
    }

    public void setCompassPosition(Point point) {
        if (this.j == null) {
            return;
        }
        if (this.j.a(new Point(point.x, point.y))) {
            this.T = point;
        }
    }

    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        if (this.j == null) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                this.j.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
            }
        } else if (!str.matches("^#[0-9a-fA-F]{8}$") || !str2.matches("^#[0-9a-fA-F]{8}$") || !str3.matches("^#[0-9a-fA-F]{8}$") || !str4.matches("^#[0-9a-fA-F]{8}$")) {
            Log.e(e, "the string of the input customTrafficColor is error");
            return false;
        } else {
            this.j.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
        }
        return true;
    }

    public final void setIndoorEnable(boolean z) {
        if (this.j != null) {
            this.R = z;
            this.j.l(z);
        }
        if (this.D == null || z) {
            return;
        }
        this.D.onBaseIndoorMapMode(false, null);
    }

    public void setLayerClickable(MapLayer mapLayer, boolean z) {
        if (this.j == null) {
            return;
        }
        this.j.a(mapLayer, z);
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate == null) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.w a2 = a(mapStatusUpdate);
        if (this.j != null) {
            this.j.a(a2);
            if (this.q != null) {
                this.q.onMapStatusChange(getMapStatus());
            }
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        if (this.j == null) {
            return;
        }
        this.j.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i) {
        if (this.j == null) {
            return;
        }
        switch (i) {
            case 1:
                this.j.a(false);
                this.j.x(this.P);
                this.j.y(this.Q);
                this.j.g(true);
                this.j.l(this.R);
                return;
            case 2:
                this.j.a(true);
                this.j.x(this.P);
                this.j.y(this.Q);
                this.j.g(true);
                return;
            case 3:
                if (this.j.z()) {
                    this.j.x(false);
                }
                if (this.j.A()) {
                    this.j.y(false);
                }
                this.j.g(false);
                this.j.l(false);
                return;
            default:
                return;
        }
    }

    public final void setMaxAndMinZoomLevel(float f, float f2) {
        if (f <= 21.0f && f2 >= 4.0f && f >= f2 && this.j != null) {
            this.j.a(f, f2);
        }
    }

    @Deprecated
    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        this.O = myLocationConfiguration;
        a(this.N, this.O);
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.N = myLocationData;
        if (this.O == null) {
            this.O = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(myLocationData, this.O);
    }

    public final void setMyLocationEnabled(boolean z) {
        if (this.j != null) {
            this.j.o(z);
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
        if (this.j == null) {
            return;
        }
        this.j.c(z);
    }

    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        setViewPadding(i, i2, i3, i4);
    }

    public void setPixelFormatTransparent(boolean z) {
        if (this.h == null) {
            return;
        }
        if (z) {
            this.h.setPixelFormatTransparent(true);
        } else {
            this.h.setPixelFormatTransparent(false);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        if (this.j != null) {
            this.j.i(z);
        }
    }

    public final void setViewPadding(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || this.j == null) {
            return;
        }
        switch (b.b[this.d.ordinal()]) {
            case 1:
                if (this.b != null) {
                    float width = ((this.b.getWidth() - i) - i3) / this.b.getWidth();
                    float height = ((this.b.getHeight() - i2) - i4) / this.b.getHeight();
                    this.j.a(new Point((int) ((width * this.T.x) + i), (int) ((height * this.T.y) + i2)));
                    this.b.setPadding(i, i2, i3, i4);
                    this.b.invalidate();
                    return;
                }
                return;
            case 2:
                if (this.f1997a != null) {
                    float width2 = ((this.f1997a.getWidth() - i) - i3) / this.f1997a.getWidth();
                    float height2 = ((this.f1997a.getHeight() - i2) - i4) / this.f1997a.getHeight();
                    this.j.a(new Point((int) ((width2 * this.T.x) + i), (int) ((height2 * this.T.y) + i2)));
                    this.f1997a.setPadding(i, i2, i3, i4);
                    this.f1997a.invalidate();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        showInfoWindow(infoWindow, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showInfoWindow(InfoWindow infoWindow, boolean z) {
        boolean z2;
        BitmapDescriptor b;
        Set<InfoWindow> keySet = this.L.keySet();
        if (infoWindow == null || keySet.contains(infoWindow) || this.U) {
            return;
        }
        if (z) {
            hideInfoWindow();
        }
        infoWindow.e = this.p;
        if (infoWindow.b != null && infoWindow.j) {
            View view = infoWindow.b;
            view.destroyDrawingCache();
            MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.c).yOffset(infoWindow.f).build();
            switch (b.b[this.d.ordinal()]) {
                case 1:
                    if (this.b != null) {
                        this.b.addView(view, build);
                        break;
                    }
                    break;
                case 2:
                    if (this.f1997a != null) {
                        this.f1997a.addView(view, build);
                        break;
                    }
                    break;
            }
            if (infoWindow.i) {
                z2 = false;
                b = b(infoWindow);
                if (b == null) {
                    Overlay a2 = new MarkerOptions().perspective(false).icon(b).position(infoWindow.c).zIndex(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).yOffset(infoWindow.f).infoWindow(infoWindow).a();
                    a2.listener = this.o;
                    a2.type = com.baidu.mapsdkplatform.comapi.map.i.popup;
                    Bundle bundle = new Bundle();
                    a2.a(bundle);
                    if (infoWindow.b != null) {
                        bundle.putInt("draw_with_view", 1);
                    } else {
                        bundle.putInt("draw_with_view", 0);
                    }
                    if (this.j != null && z2 && !this.U) {
                        this.j.b(bundle);
                        this.k.add(a2);
                    }
                    Marker marker = (Marker) a2;
                    marker.x = this.p;
                    this.K.put(marker.z, infoWindow);
                    this.L.put(infoWindow, marker);
                    this.n.add(infoWindow);
                    return;
                }
                return;
            }
        }
        z2 = true;
        b = b(infoWindow);
        if (b == null) {
        }
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
        if (this.j != null) {
            this.j.y(z);
            this.Q = z;
        }
    }

    public final void showMapPoi(boolean z) {
        if (this.j != null) {
            this.j.x(z);
            this.P = z;
        }
    }

    public void showSDKLayer() {
        if (this.j == null) {
            return;
        }
        this.j.d();
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        this.B = snapshotReadyCallback;
        switch (b.b[this.d.ordinal()]) {
            case 1:
                if (this.i == null || this.i.getController() == null) {
                    return;
                }
                this.i.doCaptureMapView(new g(this), this.i.getController().getScreenWidth(), this.i.getController().getScreenHeight(), Bitmap.Config.ARGB_8888);
                this.i.requestRender();
                return;
            case 2:
                if (this.h == null || this.h.getController() == null) {
                    return;
                }
                this.h.doCaptureMapView(new h(this), this.h.getController().getScreenWidth(), this.h.getController().getScreenHeight(), Bitmap.Config.ARGB_8888);
                this.h.requestRender();
                return;
            default:
                return;
        }
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        if (this.j == null) {
            return;
        }
        this.B = snapshotReadyCallback;
        switch (b.b[this.d.ordinal()]) {
            case 1:
                if (this.i != null) {
                    this.i.doCaptureMapView(new i(this), rect, Bitmap.Config.ARGB_8888);
                    this.i.requestRender();
                    return;
                }
                return;
            case 2:
                if (this.h != null) {
                    this.h.doCaptureMapView(new j(this), rect, Bitmap.Config.ARGB_8888);
                    this.h.requestRender();
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
        if (str2.equals(focusedBaseIndoorMapInfo.f2016a)) {
            ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
            return (floors == null || !floors.contains(str)) ? MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW : (this.j == null || !this.j.a(str, str2)) ? MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR : MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
        }
        return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
    }

    public void switchLayerOrder(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.j == null) {
            return;
        }
        this.j.a(mapLayer, mapLayer2);
    }
}
