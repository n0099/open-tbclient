package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapLayer;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.LocationOverlay;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.MapViewInterface;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.platform.comapi.map.ag;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class d implements com.baidu.mapsdkplatform.comjni.a.a.a {
    private static int D;
    private static int E;
    private y A;
    private k B;
    private l C;
    private int F;
    private int G;
    private String L;
    private int M;
    private b N;
    private LocationOverlay T;
    private com.baidu.platform.comapi.map.d U;
    AppBaseMap i;
    private boolean m;
    private boolean n;
    private aa v;
    private z w;
    private Context x;
    private List<c> y;
    private HashMap<MapLayer, c> z;
    private static final String l = d.class.getSimpleName();
    public static float d = 1096.0f;
    static long j = 0;

    /* renamed from: a  reason: collision with root package name */
    public float f2224a = 21.0f;
    public float b = 4.0f;
    public float c = 21.0f;
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = true;
    boolean e = true;
    boolean f = true;
    boolean g = false;
    private boolean t = true;
    private boolean u = false;
    private boolean H = false;
    private boolean I = false;
    private long J = 0;
    private long K = 0;
    private boolean O = false;
    private Queue<a> P = new LinkedList();
    public MapStatusUpdate k = null;
    private boolean Q = false;
    private boolean R = false;
    public List<ag> h = new ArrayList();
    private MapController S = new MapController();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Bundle f2225a;

        public a(Bundle bundle) {
            this.f2225a = bundle;
        }
    }

    public d(Context context, MapSurfaceView mapSurfaceView, u uVar, String str, int i) {
        this.x = context;
        this.L = str;
        this.M = i;
        this.S.initAppBaseMap();
        a(this.S);
        mapSurfaceView.setMapController(this.S);
        this.i = this.S.getBaseMap();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.S.getMapId());
        N();
        a(uVar);
        this.S.getBaseMap().SetSDKLayerCallback(this);
        this.S.onResume();
    }

    public d(Context context, MapTextureView mapTextureView, u uVar, String str, int i) {
        this.x = context;
        this.L = str;
        this.M = i;
        this.S.initAppBaseMap();
        a(this.S);
        mapTextureView.attachBaseMapController(this.S);
        this.i = this.S.getBaseMap();
        N();
        this.i = this.S.getBaseMap();
        a(uVar);
        this.S.getBaseMap().SetSDKLayerCallback(this);
        this.S.onResume();
    }

    private void L() {
        try {
            D = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            E = (int) (SysOSUtil.getInstance().getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("x", D);
            jSONObject2.put("y", D);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
            if (this.U != null) {
                this.U.setData(jSONObject.toString());
                this.U.UpdateOverlay();
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void M() {
        if (!this.q && !this.n && !this.m && !this.r) {
            this.f2224a = this.c;
            if (this.S != null) {
                this.S.mMaxZoomLevel = this.f2224a;
                return;
            }
            return;
        }
        if (this.f2224a > 20.0f) {
            this.f2224a = 20.0f;
            if (this.S != null) {
                this.S.mMaxZoomLevel = 20.0f;
            }
        }
        if (B().f2242a > 20.0f) {
            w B = B();
            B.f2242a = 20.0f;
            a(B);
        }
    }

    private void N() {
        this.y = new ArrayList();
        this.z = new HashMap<>();
        this.A = new y();
        a(this.A);
        this.z.put(MapLayer.MAP_LAYER_OVERLAY, this.A);
        l(false);
        if (this.i != null) {
            this.i.setDEMEnable(false);
        }
    }

    private void O() {
        if (this.S == null || this.S.mIsMoving) {
            return;
        }
        this.S.mIsMoving = true;
        this.S.mIsAnimating = false;
        if (this.h != null) {
            for (ag agVar : this.h) {
                if (agVar != null) {
                    agVar.a(B());
                }
            }
        }
    }

    private long a(MapLayer mapLayer) {
        if (this.i == null) {
            return -1L;
        }
        switch (e.f2226a[mapLayer.ordinal()]) {
            case 1:
                if (this.T != null) {
                    return this.T.mLayerID;
                }
                return -1L;
            case 2:
                if (this.A != null) {
                    return this.A.f2223a;
                }
                return -1L;
            case 3:
                return this.i.getLayerIDByTag("poiindoormarklayer");
            case 4:
                return this.i.getLayerIDByTag("basepoi");
            default:
                return -1L;
        }
    }

    private void a(c cVar) {
        if (this.i == null) {
            return;
        }
        cVar.f2223a = this.i.AddLayer(cVar.c, cVar.d, cVar.b);
        this.y.add(cVar);
    }

    private void a(u uVar) {
        if (uVar == null) {
            uVar = new u();
        }
        new w();
        w wVar = uVar.f2240a;
        this.s = uVar.f;
        this.t = uVar.d;
        this.e = uVar.e;
        this.f = uVar.g;
        w(this.s);
        v(this.t);
        q(this.e);
        r(this.f);
        this.i.SetMapStatus(wVar.a(this));
        this.i.SetMapControlMode(t.DEFAULT.ordinal());
        this.o = uVar.b;
        if (uVar.b) {
            if (this.U == null) {
                this.U = new com.baidu.platform.comapi.map.d(this.i);
                MapViewInterface mapView = this.S.getMapView();
                if (mapView != null) {
                    mapView.addOverlay(this.U);
                    L();
                }
            }
            this.i.ShowLayers(this.U.mLayerID, true);
            this.i.ResetImageRes();
        }
        int i = uVar.c;
        if (i == 2) {
            a(true);
        }
        if (i == 3) {
            if (z()) {
                x(false);
            }
            if (A()) {
                y(false);
            }
            g(false);
            l(false);
        }
    }

    private void a(MapController mapController) {
        if (!com.baidu.platform.comapi.b.a()) {
            synchronized (com.baidu.platform.comapi.b.class) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", 12.0d);
        bundle.putDouble("centerptx", 1.295815798E7d);
        bundle.putDouble("centerpty", 4825999.74d);
        bundle.putDouble("centerptz", 0.0d);
        bundle.putInt("left", 0);
        bundle.putInt(VerticalTranslateLayout.TOP, 0);
        int screenHeight = SysOSUtil.getInstance().getScreenHeight();
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, SysOSUtil.getInstance().getScreenWidth());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, screenHeight);
        bundle.putString("modulePath", SysOSUtil.getInstance().getOutputDirPath());
        bundle.putString("appSdcardPath", SysOSUtil.getInstance().getSdcardPath());
        bundle.putString("appCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putString("appSecondCachePath", SysOSUtil.getInstance().getOutputCache());
        bundle.putInt("mapTmpMax", EnvironmentUtilities.getMapTmpStgMax());
        bundle.putInt("domTmpMax", EnvironmentUtilities.getDomTmpStgMax());
        bundle.putInt("itsTmpMax", EnvironmentUtilities.getItsTmpStgMax());
        bundle.putInt("ssgTmpMax", EnvironmentUtilities.getSsgTmpStgMax());
        mapController.initMapResources(bundle);
    }

    private void a(String str, String str2, long j2) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j2));
        } catch (Exception e) {
        }
    }

    private boolean e(Bundle bundle) {
        if (this.i == null) {
            return false;
        }
        return this.i.addSDKTileData(bundle);
    }

    private boolean f(Bundle bundle) {
        boolean z = false;
        if (bundle != null && this.i != null && (z = this.i.updateSDKTile(bundle))) {
            f(z);
            this.i.UpdateLayers(this.v.f2223a);
        }
        return z;
    }

    private void g(Bundle bundle) {
        if (bundle.get("param") == null) {
            int i = bundle.getInt("type");
            if (i == i.ground.ordinal()) {
                bundle.putLong("layer_addr", this.A.f2223a);
                return;
            } else if (i >= i.arc.ordinal()) {
                bundle.putLong("layer_addr", this.A.f2223a);
                return;
            } else if (i == i.popup.ordinal()) {
                bundle.putLong("layer_addr", this.A.f2223a);
                return;
            } else {
                bundle.putLong("layer_addr", this.A.f2223a);
                return;
            }
        }
        Bundle bundle2 = (Bundle) bundle.get("param");
        int i2 = bundle2.getInt("type");
        if (i2 == i.ground.ordinal()) {
            bundle2.putLong("layer_addr", this.A.f2223a);
        } else if (i2 >= i.arc.ordinal()) {
            bundle2.putLong("layer_addr", this.A.f2223a);
        } else if (i2 == i.popup.ordinal()) {
            bundle2.putLong("layer_addr", this.A.f2223a);
        } else {
            bundle2.putLong("layer_addr", this.A.f2223a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(boolean z) {
    }

    public boolean A() {
        if (this.i != null) {
            return this.i.LayersIsShow(this.i.getLayerIDByTag("poiindoormarklayer"));
        }
        return false;
    }

    public w B() {
        if (this.i == null) {
            return null;
        }
        Bundle GetMapStatus = this.i.GetMapStatus();
        w wVar = new w();
        wVar.a(GetMapStatus);
        return wVar;
    }

    public LatLngBounds C() {
        if (this.i == null) {
            return null;
        }
        Bundle mapStatusLimits = this.i.getMapStatusLimits();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i = mapStatusLimits.getInt("maxCoorx");
        int i2 = mapStatusLimits.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("minCoory"), i))).include(CoordUtil.mc2ll(new GeoPoint(mapStatusLimits.getInt("maxCoory"), i2)));
        return builder.build();
    }

    public MapStatusUpdate D() {
        return this.k;
    }

    public int E() {
        return this.F;
    }

    public int F() {
        return this.G;
    }

    public w G() {
        if (this.i == null) {
            return null;
        }
        Bundle GetMapStatus = this.i.GetMapStatus();
        w wVar = new w();
        wVar.a(GetMapStatus);
        return wVar;
    }

    public double H() {
        return B().m;
    }

    public void I() {
    }

    public float[] J() {
        if (this.i == null) {
            return null;
        }
        return this.i.getProjectionMatrix();
    }

    public float[] K() {
        if (this.i == null) {
            return null;
        }
        return this.i.getViewMatrix();
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.S.mIsMapLoadFinish) {
            if (this.i == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", i);
            bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, i3);
            bundle.putInt(VerticalTranslateLayout.BOTTOM, i4);
            bundle.putInt(VerticalTranslateLayout.TOP, i2);
            bundle.putInt("hasHW", 1);
            bundle.putInt("width", i5);
            bundle.putInt("height", i6);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("left", 0);
            bundle2.putInt(VerticalTranslateLayout.BOTTOM, i6);
            bundle2.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, i5);
            bundle2.putInt(VerticalTranslateLayout.TOP, 0);
            return this.i.GetFZoomToBoundF(bundle, bundle2);
        }
        return 12.0f;
    }

    @Override // com.baidu.mapsdkplatform.comjni.a.a.a, com.baidu.platform.comjni.map.basemap.a
    public int a(Bundle bundle, long j2, int i) {
        if (this.B != null && j2 == this.B.f2223a) {
            bundle.putBundle("param", this.C.a(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("zoom")));
            return this.B.e;
        } else if (this.v == null || j2 != this.v.f2223a) {
            return 0;
        } else {
            bundle.putBundle("param", this.w.a(bundle.getInt("x"), bundle.getInt("y"), bundle.getInt("zoom"), this.x));
            return this.v.e;
        }
    }

    public Point a(GeoPoint geoPoint) {
        com.baidu.platform.comapi.basestruct.Point pixels = this.S.getMapView().getProjection().toPixels(geoPoint, null);
        return pixels != null ? new Point(pixels.getIntX(), pixels.getIntY()) : new Point();
    }

    public AppBaseMap a() {
        return this.i;
    }

    public void a(float f, float f2) {
        this.f2224a = f;
        this.c = f;
        this.b = f2;
        if (this.S != null) {
            this.S.setMaxAndMinZoomLevel(f, f2);
        }
        if (this.i != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("maxLevel", (int) f);
            bundle.putInt("minLevel", (int) f2);
            this.i.setMaxAndMinZoomLevel(bundle);
        }
    }

    public void a(int i) {
        if (this.i == null) {
            return;
        }
        this.i.CleanCache(i);
    }

    public void a(int i, int i2) {
        this.F = i;
        this.G = i2;
    }

    public void a(long j2, long j3, long j4, long j5, boolean z) {
        if (this.i == null) {
        }
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        int i = 0;
        if (this.i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", D);
            jSONObject2.put("y", E);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("dataset", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            ArrayList arrayList = new ArrayList();
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle3 = new Bundle();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            bundle3.putByteArray("imgdata", allocate.array());
            bundle3.putInt("imgindex", bitmap.hashCode());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            parcelItem.setBundle(bundle3);
            arrayList.add(parcelItem);
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                    i = i2 + 1;
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        if (this.U != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                this.U.setData(jSONObject.toString());
            }
            if (bundle != null) {
                this.U.setParam(bundle);
            }
            this.U.UpdateOverlay();
        }
    }

    public void a(MapLayer mapLayer, MapLayer mapLayer2) {
        if (this.i == null) {
            return;
        }
        long a2 = a(mapLayer);
        long a3 = a(mapLayer2);
        if (a2 == -1 || a3 == -1) {
            return;
        }
        this.i.SwitchLayer(a2, a3);
    }

    public void a(MapLayer mapLayer, boolean z) {
        if (this.i == null) {
            return;
        }
        long a2 = a(mapLayer);
        if (a2 != -1) {
            this.i.SetLayersClickable(a2, z);
        }
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.k = mapStatusUpdate;
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.i == null) {
            return;
        }
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        int latitudeE6 = (int) ll2mc2.getLatitudeE6();
        int longitudeE6 = (int) ll2mc2.getLongitudeE6();
        int latitudeE62 = (int) ll2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", (int) ll2mc.getLongitudeE6());
        bundle.putInt("minCoory", latitudeE6);
        bundle.putInt("minCoorx", longitudeE6);
        bundle.putInt("maxCoory", latitudeE62);
        this.i.setMapStatusLimits(bundle);
    }

    public void a(l lVar) {
        this.C = lVar;
    }

    public void a(w wVar) {
        if (this.i == null || wVar == null) {
            return;
        }
        Bundle a2 = wVar.a(this);
        a2.putInt("animation", 0);
        a2.putInt("animatime", 0);
        O();
        this.i.SetMapStatus(a2);
    }

    public void a(w wVar, int i) {
        if (this.i == null || wVar == null) {
            return;
        }
        Bundle a2 = wVar.a(this);
        a2.putInt("animation", 1);
        a2.putInt("animatime", i);
        if (this.O) {
            this.P.add(new a(a2));
            return;
        }
        y();
        this.i.SetMapStatus(a2);
    }

    public void a(z zVar) {
        this.w = zVar;
    }

    public void a(ag agVar) {
        if (agVar == null || this.h == null) {
            return;
        }
        this.S.registMapViewListener(agVar);
        this.h.add(agVar);
    }

    public void a(String str, int i) {
        if (this.i == null) {
            return;
        }
        this.i.initCustomStyle(str, "");
    }

    public void a(String str, Bundle bundle) {
        if (this.T == null) {
            return;
        }
        this.T.setData(str);
        this.T.setParam(bundle);
        this.T.UpdateOverlay();
    }

    public void a(List<Bundle> list) {
        if (this.i == null || list == null) {
            return;
        }
        int size = list.size();
        Bundle[] bundleArr = new Bundle[list.size()];
        for (int i = 0; i < size; i++) {
            g(list.get(i));
            bundleArr[i] = list.get(i);
        }
        this.i.addOverlayItems(bundleArr, size);
    }

    public void a(boolean z) {
        if (this.i == null) {
            return;
        }
        this.n = z;
        M();
        this.i.ShowSatelliteMap(this.n);
    }

    @Override // com.baidu.mapsdkplatform.comjni.a.a.a, com.baidu.platform.comjni.map.basemap.a
    public boolean a(long j2) {
        Iterator<c> it = this.y.iterator();
        while (it.hasNext()) {
            if (it.next().f2223a == j2) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Point point) {
        if (point != null && this.i != null && point.x >= 0 && point.y >= 0) {
            D = point.x;
            E = point.y;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", D);
                jSONObject2.put("y", E);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("dataset", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (this.U != null) {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    this.U.setData(jSONObject.toString());
                }
                this.U.UpdateOverlay();
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        if (this.i == null) {
            return false;
        }
        this.v = new aa();
        long AddLayer = this.i.AddLayer(this.v.c, this.v.d, this.v.b);
        if (AddLayer != 0) {
            this.v.f2223a = AddLayer;
            this.y.add(this.v);
            bundle.putLong("sdktileaddr", AddLayer);
            return e(bundle) && f(bundle);
        }
        return false;
    }

    public boolean a(String str, String str2) {
        if (this.i == null) {
            return false;
        }
        return this.i.SwitchBaseIndoorMapFloor(str, str2);
    }

    public float b() {
        return this.S != null ? this.S.mMaxZoomLevel : this.f2224a;
    }

    public GeoPoint b(int i, int i2) {
        return this.S.getMapView().getProjection().fromPixels(i, i2);
    }

    public void b(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        g(bundle);
        this.i.addOneOverlayItem(bundle);
    }

    public void b(List<OverlayLocationData> list) {
        if (this.T == null) {
            return;
        }
        this.T.setLocationLayerData(list);
    }

    public void b(boolean z) {
        this.u = z;
    }

    public void c() {
        if (this.i == null) {
            return;
        }
        for (c cVar : this.y) {
            this.i.ShowLayers(cVar.f2223a, false);
        }
    }

    public void c(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        g(bundle);
        this.i.updateOneOverlayItem(bundle);
    }

    public void c(boolean z) {
        if (this.i == null) {
            return;
        }
        if (z) {
            if (this.Q) {
                return;
            }
            this.i.SwitchLayer(this.N.f2223a, this.A.f2223a);
            this.Q = true;
        } else if (this.Q) {
            this.i.SwitchLayer(this.A.f2223a, this.N.f2223a);
            this.Q = false;
        }
    }

    public void d() {
        if (this.i == null) {
            return;
        }
        for (c cVar : this.y) {
            if ((cVar instanceof com.baidu.mapsdkplatform.comapi.map.a) || (cVar instanceof k)) {
                this.i.ShowLayers(cVar.f2223a, false);
            } else {
                this.i.ShowLayers(cVar.f2223a, true);
            }
        }
        this.i.ShowTrafficMap(false);
    }

    public void d(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        g(bundle);
        this.i.removeOneOverlayItem(bundle);
        this.i.UpdateLayers(this.A.f2223a);
    }

    public void d(boolean z) {
        if (this.i == null) {
            return;
        }
        if (z) {
            if (this.R || this.T == null) {
                return;
            }
            this.i.SwitchLayer(this.A.f2223a, this.T.mLayerID);
            this.R = true;
        } else if (!this.R || this.T == null) {
        } else {
            this.i.SwitchLayer(this.T.mLayerID, this.A.f2223a);
            this.R = false;
        }
    }

    public void e(boolean z) {
        if (this.i == null) {
            return;
        }
        if (this.U == null) {
            this.U = new com.baidu.platform.comapi.map.d(this.i);
            MapViewInterface mapView = this.S.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.U);
                L();
            }
        }
        this.i.ShowLayers(this.U.mLayerID, z);
    }

    public boolean e() {
        if (this.v == null || this.i == null) {
            return false;
        }
        return this.i.cleanSDKTileDataCache(this.v.f2223a);
    }

    public void f(boolean z) {
        if (this.i == null || this.v == null) {
            return;
        }
        this.i.ShowLayers(this.v.f2223a, z);
    }

    public boolean f() {
        return this.m;
    }

    public String g() {
        if (this.i == null) {
        }
        return null;
    }

    public void g(boolean z) {
        if (this.i == null) {
            return;
        }
        this.i.ShowLayers(this.i.getLayerIDByTag("basemap"), z);
    }

    public void h(boolean z) {
        if (this.i == null) {
            return;
        }
        this.r = z;
        this.i.ShowHotMap(this.r, 0);
    }

    public boolean h() {
        return this.r;
    }

    public void i(boolean z) {
        if (this.i == null) {
            return;
        }
        this.m = z;
        this.i.ShowTrafficMap(this.m);
    }

    public boolean i() {
        if (this.i == null) {
        }
        return false;
    }

    public void j(boolean z) {
        if (this.i == null) {
            return;
        }
        this.i.setDrawHouseHeightEnable(z);
    }

    public boolean j() {
        return this.n;
    }

    public void k(boolean z) {
        if (this.i == null) {
            return;
        }
        this.o = z;
        if (this.U == null) {
            this.U = new com.baidu.platform.comapi.map.d(this.i);
            MapViewInterface mapView = this.S.getMapView();
            if (mapView != null) {
                mapView.addOverlay(this.U);
                L();
            }
        }
        this.i.ShowLayers(this.U.mLayerID, z);
    }

    public boolean k() {
        if (this.i == null) {
            return false;
        }
        return this.i.LayersIsShow(this.i.getLayerIDByTag("basemap"));
    }

    public void l(boolean z) {
        if (this.i == null) {
            return;
        }
        if (z) {
            this.f2224a = 22.0f;
            this.c = 22.0f;
            if (this.S != null) {
                this.S.mMaxZoomLevel = 22.0f;
            }
        } else {
            this.f2224a = 21.0f;
            this.c = 21.0f;
            if (this.S != null) {
                this.S.mMaxZoomLevel = 21.0f;
            }
        }
        this.i.ShowBaseIndoorMap(z);
    }

    public boolean l() {
        if (this.i == null) {
            return false;
        }
        return this.i.getDrawHouseHeightEnable();
    }

    public void m() {
        if (this.i == null) {
            return;
        }
        this.i.ClearSDKLayer(this.A.f2223a);
    }

    public void n() {
        if (this.i == null || this.B == null) {
            return;
        }
        this.i.UpdateLayers(this.B.f2223a);
    }

    public void n(boolean z) {
        if (this.i == null) {
            return;
        }
        this.i.setCustomStyleEnable(z);
    }

    public MapBaseIndoorMapInfo o() {
        String GetFocusedBaseIndoorMapInfo;
        String str;
        JSONException e;
        if (this.i == null || (GetFocusedBaseIndoorMapInfo = this.i.GetFocusedBaseIndoorMapInfo()) == null) {
            return null;
        }
        String str2 = "";
        ArrayList arrayList = new ArrayList(1);
        try {
            JSONObject jSONObject = new JSONObject(GetFocusedBaseIndoorMapInfo);
            str2 = jSONObject.optString("focusindoorid");
            str = jSONObject.optString("curfloor");
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("floorlist");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.get(i).toString());
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                return new MapBaseIndoorMapInfo(str2, str, arrayList);
            }
        } catch (JSONException e3) {
            str = "";
            e = e3;
        }
        return new MapBaseIndoorMapInfo(str2, str, arrayList);
    }

    public void o(boolean z) {
        if (this.i == null) {
            return;
        }
        this.p = z;
        if (this.T != null) {
            this.i.ShowLayers(this.T.mLayerID, z);
            return;
        }
        MapViewInterface mapView = this.S.getMapView();
        if (mapView != null) {
            this.T = new LocationOverlay(this.i);
            mapView.addOverlay(this.T);
        }
    }

    public void p(boolean z) {
        if (this.i == null) {
            return;
        }
        if (this.B == null) {
            this.B = new k();
            a(this.B);
        }
        this.q = z;
        this.i.ShowLayers(this.B.f2223a, z);
    }

    public boolean p() {
        if (this.i == null) {
            return false;
        }
        return this.i.IsBaseIndoorMapMode();
    }

    public void q(boolean z) {
        if (this.S == null) {
            return;
        }
        this.S.setCanTouchMove(z);
        this.e = z;
    }

    public boolean q() {
        return this.o;
    }

    public void r() {
        this.T.clearLocationLayerData(null);
    }

    public void r(boolean z) {
        if (this.S == null) {
            return;
        }
        this.S.setEnableZoom(z);
        this.f = z;
    }

    public void s(boolean z) {
        if (this.S == null) {
            return;
        }
        this.S.setDoubleClickZoom(z);
    }

    public boolean s() {
        return this.p;
    }

    public void t() {
        if (this.i == null || this.B == null) {
            return;
        }
        this.i.UpdateLayers(this.B.f2223a);
    }

    public void t(boolean z) {
        if (this.S == null) {
            return;
        }
        this.S.setTwoTouchClickZoomEnabled(z);
    }

    public void u(boolean z) {
        if (this.S == null) {
            return;
        }
        this.S.setEnlargeCenterWithDoubleClickEnable(z);
    }

    public boolean u() {
        return this.e;
    }

    public void v(boolean z) {
        if (this.S == null) {
            return;
        }
        this.S.set3DGestureEnable(z);
        this.t = z;
    }

    public boolean v() {
        return this.f;
    }

    public void w(boolean z) {
        if (this.S == null) {
            return;
        }
        this.S.setOverlookGestureEnable(z);
        this.s = z;
    }

    public boolean w() {
        return this.t;
    }

    public void x(boolean z) {
        if (this.i != null) {
            this.i.ShowLayers(this.i.getLayerIDByTag("basepoi"), z);
        }
    }

    public boolean x() {
        return this.s;
    }

    void y() {
        if (this.S == null || this.S.mIsMoving || this.S.mIsAnimating) {
            return;
        }
        this.S.mIsAnimating = true;
        if (this.h != null) {
            for (ag agVar : this.h) {
                if (agVar != null) {
                    agVar.a(B());
                }
            }
        }
    }

    public void y(boolean z) {
        if (this.i != null) {
            this.i.ShowLayers(this.i.getLayerIDByTag("poiindoormarklayer"), z);
        }
    }

    public boolean z() {
        if (this.i != null) {
            return this.i.LayersIsShow(this.i.getLayerIDByTag("basepoi"));
        }
        return false;
    }
}
