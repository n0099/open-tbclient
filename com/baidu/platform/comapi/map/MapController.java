package com.baidu.platform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.net.BdNetTask;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class MapController {
    public static final String ANDROID_SDK_LAYER_TAG = "android_sdk";
    public static final String CITY_AREA_TAG = "cityarea";
    public static final String COMPASS_LAYER_TAG = "compass";
    public static final String DEFAULT_LAYER_TAG = "default";
    public static final String DYNAMIC_MAP_LAYER_TAG = "dynamicmap";
    public static final String HEATMAP_LAYER_TAG = "heatmap";
    public static final String ITEM_LAYER_TAG = "item";
    public static final String ITSROUTE_LAYER_TAG = "itsroute";
    public static final String LOCAL_LIMIT_MAP_LAYER_TAG = "dynamiclimit";
    public static final String LOCATION_LAYER_TAG = "location";
    public static final int MSG_LONGLINK_CONNECT = 1;
    public static final int MSG_LONGLINK_DISCONNECT = 2;
    public static final String POISON_LAYER_TAG = "poison";
    public static final String POPUP_LAYER_TAG = "popup";
    public static final String RTPOPUP_LAYER_TAG = "rtpopup";
    public static final String RT_POPUP_LAYER_TAG = "rtpopup";
    public static final String SHARELOCATION_BUBBLE = "smshare";
    public static final String STREETPOPUP_LAYER_TAG = "streetpopup";
    public static final String STREETROUTE_LAYER_TAG = "streetroute";
    public static boolean m_registered_SENSOR_ORIENTATION;
    private static float x;
    private static float y;
    private static boolean z;
    private long L;
    private long T;
    private long X;
    SoftReference<MapViewInterface> h;
    NaviMapViewListener i;
    private com.baidu.platform.comapi.map.b.d k;
    public boolean mHasMapObjDraging;
    public boolean mIsMapLoadFinish;
    private MapFirstFrameCallback p;
    private static final String j = MapController.class.getSimpleName();
    public static boolean isCompass = false;
    private static Handler t = null;
    private static boolean w = true;
    private static long N = 0;
    public static boolean mLocIconOnScreen = true;
    private static List<AppBaseMap> S = new ArrayList();
    private boolean l = true;

    /* renamed from: a  reason: collision with root package name */
    int f2876a = 0;
    private int m = 1;
    private int n = 1;
    private boolean o = false;
    private boolean q = false;
    private AppBaseMap r = null;
    private long s = 0;
    public int nearlyRadius = 20;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = true;
    private boolean F = false;
    private boolean G = true;
    private boolean H = false;
    private float I = -1.0f;
    private float J = -1.0f;
    private float K = 0.0f;
    private boolean M = false;
    private boolean O = true;
    private boolean P = true;
    private boolean Q = true;
    private boolean R = true;
    MapViewListener b = null;
    CaptureMapListener c = null;
    i d = null;
    ai e = null;
    MapRenderModeChangeListener f = null;
    EngineMsgListener g = null;
    public float mMaxZoomLevel = 21.0f;
    public float mMinZoomLevel = 4.0f;
    public boolean mIsMoving = false;
    public boolean mIsAnimating = false;
    private boolean U = false;
    private com.baidu.platform.comapi.map.b.b V = new com.baidu.platform.comapi.map.b.b(this);
    private MapControlMode W = MapControlMode.DEFAULT;
    public List<ag> mListeners = new ArrayList();
    private int u = SysOSUtil.getInstance().getScreenWidth();
    private int v = SysOSUtil.getInstance().getScreenHeight();

    /* loaded from: classes26.dex */
    public enum HeatMapType {
        CITY(0),
        SCENERY(1),
        CEMETERY(2);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2877a;

        HeatMapType(int i) {
            this.f2877a = i;
        }

        public int getId() {
            return this.f2877a;
        }
    }

    /* loaded from: classes26.dex */
    public enum MapControlMode {
        DEFAULT(1),
        INDOOR(2),
        STREET(3),
        STREET_WAITING(4);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2878a;

        MapControlMode(int i) {
            this.f2878a = i;
        }
    }

    /* loaded from: classes26.dex */
    public interface MapFirstFrameCallback {
        void onFirstFrameDrawing(MapController mapController);
    }

    /* loaded from: classes26.dex */
    public enum MapLayerType {
        DEFAULT(1),
        SATELLITE(2),
        INDOOR(3),
        STREET(5);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2879a;

        MapLayerType(int i) {
            this.f2879a = i;
        }
    }

    /* loaded from: classes26.dex */
    public enum MapSceneMode {
        DEFAULT(0),
        POI(1),
        ROUTE(2),
        INTERNAL(3),
        INDOOR(7);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2880a;

        MapSceneMode(int i) {
            this.f2880a = i;
        }

        public int getMode() {
            return this.f2880a;
        }
    }

    /* loaded from: classes26.dex */
    public enum MapStyleMode {
        DEFAULT(1),
        SEARCH_POI(2),
        SEARCH_ROUTE(3),
        NAV_DAY(4),
        NAV_NIGHT(5),
        WALK_DAY(6),
        INTERNAL(7),
        INTERNAL_SPECIAL(8),
        FOOT_PRINT(9);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2881a;

        MapStyleMode(int i) {
            this.f2881a = i;
        }

        public int getMode() {
            return this.f2881a;
        }
    }

    /* loaded from: classes26.dex */
    public enum RecommendPoiScene {
        BASE(0),
        INTERNATIONAL(1);
        
        public int value;

        RecommendPoiScene(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes26.dex */
    public enum RecycleMemoryLevel {
        NORMAL(0),
        FULL(1);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f2883a;

        RecycleMemoryLevel(int i) {
            this.f2883a = i;
        }

        public int getLevel() {
            return this.f2883a;
        }
    }

    /* loaded from: classes26.dex */
    class a extends com.baidu.platform.comapi.util.i {
        a() {
            super(Looper.getMainLooper());
        }

        @Override // com.baidu.platform.comapi.util.i
        public void a(Message message) {
            if (message.what == 4000 && MapController.this.c != null) {
                MapController.this.c.onGetCaptureMap(message.arg2 == 1);
            }
            if (message.what == 519 && MapController.this.d != null) {
                MapController.this.d.a();
            }
            if (message.what == 39) {
                if (((Long) message.obj).longValue() != MapController.this.s) {
                    return;
                }
                switch (message.arg1) {
                    case 2:
                        if (MapController.this.mListeners != null) {
                            for (ag agVar : MapController.this.mListeners) {
                                if (agVar != null) {
                                    agVar.c();
                                }
                            }
                            MapController.this.mIsMoving = false;
                            break;
                        } else {
                            return;
                        }
                    case 100:
                        if (MapController.this.M) {
                            if (MapController.this.h == null || MapController.this.h.get() == null) {
                                return;
                            }
                            com.baidu.platform.comapi.util.j.a().execute(new l(this));
                        }
                        MapController.this.B = false;
                        if (MapController.this.getMapViewListener() != null) {
                            MapController.this.getMapViewListener().onMapAnimationFinish();
                        }
                        if (MapController.this.isNaviMode() && MapController.this.i != null) {
                            MapController.this.i.onMapAnimationFinish();
                        }
                        MapController.this.mIsMoving = false;
                        MapController.this.mIsAnimating = false;
                        if (MapController.this.mListeners != null) {
                            for (ag agVar2 : MapController.this.mListeners) {
                                if (agVar2 != null) {
                                    agVar2.c(MapController.this.getMapStatusInner());
                                }
                            }
                            break;
                        }
                        break;
                    case 200:
                        MapController.this.mIsMoving = false;
                        break;
                    case 300:
                        if (MapController.this.p != null) {
                            MapController.this.p.onFirstFrameDrawing(MapController.this);
                            break;
                        }
                        break;
                    default:
                        if (MapController.this.f != null) {
                            MapController.this.f.onMapRenderModeChange(message.arg1);
                        }
                        if (MapController.this.isNaviMode() && MapController.this.i != null) {
                            MapController.this.i.onMapRenderModeChange(message.arg1);
                            break;
                        }
                        break;
                }
                if (!MapController.this.mIsMapLoadFinish && MapController.this.v > 0 && MapController.this.u > 0 && MapController.this.getMapView().getProjection().fromPixels(0, 0) != null) {
                    MapController.this.mIsMapLoadFinish = true;
                    for (ag agVar3 : MapController.this.mListeners) {
                        if (agVar3 != null) {
                            agVar3.b();
                        }
                    }
                }
                for (ag agVar4 : MapController.this.mListeners) {
                    if (agVar4 != null) {
                        agVar4.a();
                    }
                }
            } else if (message.what == 41) {
                if (MapController.this.mListeners == null) {
                    return;
                }
                if (MapController.this.mIsMoving || MapController.this.mIsAnimating) {
                    for (ag agVar5 : MapController.this.mListeners) {
                        if (agVar5 != null) {
                            agVar5.b(MapController.this.getMapStatusInner());
                        }
                    }
                }
            }
            if (message.what == 512) {
                int i = message.arg1;
                if (MapController.this.getMapViewListener() != null) {
                    MapController.this.getMapViewListener().onClickedPopup(i);
                }
            }
            if (message.what == 50) {
                if (MapController.this.g != null) {
                    if (message.arg1 == 1) {
                        MapController.this.g.onEnterIndoorMapMode(MapController.this.getFocusedBaseIndoorMapInfo());
                    } else if (message.arg1 == 0) {
                        MapController.this.g.onExitIndoorMapMode();
                    }
                }
                if (MapController.this.mListeners == null) {
                    return;
                }
                for (ag agVar6 : MapController.this.mListeners) {
                    if (agVar6 != null) {
                        if (message.arg1 == 0) {
                            agVar6.a(false);
                            MapController.this.mMaxZoomLevel = 21.0f;
                        } else if (message.arg1 == 1) {
                            j focusedBaseIndoorMapInfo = MapController.this.getFocusedBaseIndoorMapInfo();
                            if (MapController.this.getMapStatus().level < 18.0f || focusedBaseIndoorMapInfo == null) {
                                agVar6.a(false);
                                MapController.this.mMaxZoomLevel = 21.0f;
                            } else {
                                agVar6.a(true);
                                MapController.this.mMaxZoomLevel = 22.0f;
                            }
                        }
                    }
                }
            }
            if (message.what == 51) {
                MapController.this.setNetStatus(message.arg1);
            }
            if (message.what != 65301 || MapController.this.g == null) {
                return;
            }
            if (message.arg1 == 1) {
                MapController.this.getMapBarData();
            } else if (message.arg1 == 0) {
                com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a());
            }
        }
    }

    public MapController() {
        t = new a();
        c();
    }

    public static native int CleanAfterDBClick(long j2, float f, float f2);

    public static int GetAdaptKeyCode(int i) {
        switch (i) {
            case 19:
                return 17;
            case 20:
                return 19;
            case 21:
                return 16;
            case 22:
                return 18;
            default:
                return 0;
        }
    }

    public static native int MapProc(long j2, int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4);

    private MapStatus a(boolean z2) {
        Bundle GetMapStatus;
        if (a() && (GetMapStatus = this.r.GetMapStatus(z2)) != null) {
            MapStatus mapStatus = new MapStatus();
            mapStatus.level = (float) GetMapStatus.getDouble("level");
            mapStatus.rotation = (int) GetMapStatus.getDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION);
            mapStatus.overlooking = (int) GetMapStatus.getDouble("overlooking");
            mapStatus.centerPtX = GetMapStatus.getDouble("centerptx");
            mapStatus.centerPtY = GetMapStatus.getDouble("centerpty");
            mapStatus.centerPtZ = GetMapStatus.getDouble("centerptz");
            mapStatus.winRound.left = GetMapStatus.getInt("left");
            mapStatus.winRound.right = GetMapStatus.getInt(HorizontalTranslateLayout.DIRECTION_RIGHT);
            mapStatus.winRound.top = GetMapStatus.getInt(VerticalTranslateLayout.TOP);
            mapStatus.winRound.bottom = GetMapStatus.getInt(VerticalTranslateLayout.BOTTOM);
            mapStatus.geoRound.left = GetMapStatus.getLong("gleft");
            mapStatus.geoRound.right = GetMapStatus.getLong("gright");
            mapStatus.geoRound.top = GetMapStatus.getLong("gtop");
            mapStatus.geoRound.bottom = GetMapStatus.getLong("gbottom");
            mapStatus.xOffset = GetMapStatus.getFloat("xoffset");
            mapStatus.yOffset = GetMapStatus.getFloat("yoffset");
            mapStatus.bfpp = GetMapStatus.getInt("bfpp") == 1;
            mapStatus.panoId = GetMapStatus.getString("panoid");
            mapStatus.streetIndicateAngle = GetMapStatus.getFloat("siangle");
            mapStatus.isBirdEye = GetMapStatus.getInt("isbirdeye") == 1;
            mapStatus.streetExt = GetMapStatus.getInt("ssext");
            mapStatus.roadOffsetX = GetMapStatus.getFloat("roadOffsetX");
            mapStatus.roadOffsetY = GetMapStatus.getFloat("roadOffsetY");
            mapStatus.bOverlookSpringback = GetMapStatus.getInt("boverlookback") == 1;
            mapStatus.minOverlooking = (int) GetMapStatus.getFloat("minoverlook");
            if (mapStatus.geoRound.left <= -20037508) {
                mapStatus.geoRound.left = -20037508L;
            }
            if (mapStatus.geoRound.right >= 20037508) {
                mapStatus.geoRound.right = 20037508L;
            }
            if (mapStatus.geoRound.top >= 20037508) {
                mapStatus.geoRound.top = 20037508L;
            }
            if (mapStatus.geoRound.bottom <= -20037508) {
                mapStatus.geoRound.bottom = -20037508L;
            }
            return mapStatus;
        }
        return new MapStatus();
    }

    private void a(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        x = x2;
        y = y2;
        MapMsgProc(4, 0, x2 | (y2 << 16));
        z = true;
        this.T = motionEvent.getDownTime();
    }

    private boolean a() {
        return this.C && this.r != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
        r3 = (org.json.JSONObject) new org.json.JSONObject(r3).getJSONArray("dataset").get(0);
        r6 = r3.getInt("itemindex");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0091, code lost:
        r3 = r3.optInt("clickindex", -1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0099, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
        r6 = r4;
        r3 = r10;
        r8 = false;
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d4, code lost:
        r10 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i, int i2, int i3) {
        long j2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean z3;
        String GetNearlyObjID;
        if (!a() || this.h == null || this.h.get() == null) {
            return false;
        }
        MapViewInterface mapViewInterface = this.h.get();
        int i8 = -1;
        long j3 = 0;
        try {
            int size = mapViewInterface.getOverlays().size() - 1;
            while (true) {
                if (size < 0) {
                    i6 = -1;
                    i7 = -1;
                    z3 = false;
                    break;
                }
                Overlay overlay = mapViewInterface.getOverlays().get(size);
                if (overlay.mType == 27) {
                    j3 = overlay.mLayerID;
                    int zoomUnitsInMeter = (int) (this.nearlyRadius * getZoomUnitsInMeter());
                    if (this.r != null && (GetNearlyObjID = this.r.GetNearlyObjID(j3, i2, i3, zoomUnitsInMeter)) != null && !GetNearlyObjID.equals("")) {
                        break;
                    }
                }
                size--;
            }
            z2 = z3;
            int i9 = i6;
            i4 = i7;
            j2 = j3;
            i5 = i9;
        } catch (JSONException e) {
        }
        if (i == 1 && getMapViewListener() != null) {
            GeoPoint fromPixels = mapViewInterface.getProjection().fromPixels(i2, i3);
            if (i5 == -1) {
                getMapViewListener().onClickedItem(i4, i5, fromPixels, j2);
            } else {
                getMapViewListener().onClickedItem(i4, fromPixels, j2);
            }
        }
        return z2;
    }

    private void b() {
        this.F = false;
        this.K = 0.0f;
        this.I = -1.0f;
        this.J = -1.0f;
    }

    private boolean b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        JSONObject jSONObject;
        if (a()) {
            if (getMapViewListener() == null && this.i == null) {
                return false;
            }
            int zoomUnitsInMeter = (int) (this.nearlyRadius * getZoomUnitsInMeter());
            Point point = new Point(i, i2);
            Point point2 = null;
            if (isNaviMode() && this.i != null) {
                point2 = this.i.onTapInterception(point);
            }
            if (point2 != null) {
                i4 = point2.getIntX();
                i3 = point2.getIntY();
            } else {
                i3 = i2;
                i4 = i;
            }
            String GetNearlyObjID = this.r.GetNearlyObjID(-1L, i4, i3, zoomUnitsInMeter);
            if (GetNearlyObjID == null) {
                return false;
            }
            if (isNaviMode() && this.i != null && this.i.onItemClick(GetNearlyObjID, i4, i3)) {
                return true;
            }
            int i6 = -1;
            try {
                JSONObject jSONObject2 = new JSONObject(GetNearlyObjID);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = null;
                ArrayList arrayList3 = null;
                ArrayList arrayList4 = null;
                ArrayList arrayList5 = null;
                ArrayList arrayList6 = null;
                ArrayList arrayList7 = null;
                if (jSONObject2.has(MapBundleKey.MapObjKey.OBJ_MCAR) && (jSONObject = jSONObject2.getJSONObject(MapBundleKey.MapObjKey.OBJ_MCAR)) != null) {
                    ArrayList arrayList8 = new ArrayList();
                    MapObj mapObj = new MapObj();
                    mapObj.routeType = MapBundleKey.MapObjKey.OBJ_MCAR;
                    if (jSONObject.has("id")) {
                        mapObj.routeId = jSONObject.getInt("id");
                    }
                    if (jSONObject.has("status")) {
                        mapObj.status = jSONObject.getInt("status");
                    }
                    if (jSONObject.has("in")) {
                        mapObj.index = jSONObject.getInt("in");
                    }
                    arrayList8.add(mapObj);
                    if (getMapViewListener() != null) {
                        getMapViewListener().onClickedRouteObj(arrayList8);
                    }
                    return true;
                }
                JSONArray jSONArray = jSONObject2.getJSONArray("dataset");
                int i7 = ((JSONObject) jSONArray.get(0)).getInt("ty");
                if (i7 == 22) {
                    arrayList2 = new ArrayList();
                } else if (i7 == 3 || i7 == 13 || i7 == 14 || i7 == 16 || i7 == 15 || i7 == 4 || i7 == 103 || i7 == 25 || i7 == 31 || i7 == 104 || i7 == 5000 || i7 == 6018 || i7 == 6019) {
                    arrayList4 = new ArrayList();
                } else if (i7 == 8 || i7 == 1 || i7 == 2) {
                    arrayList5 = new ArrayList();
                } else if (i7 == 6) {
                    arrayList6 = new ArrayList();
                } else if (i7 == 24) {
                    arrayList3 = new ArrayList();
                } else if (i7 == 1239) {
                    arrayList5 = new ArrayList();
                } else if (i7 == 7000) {
                    arrayList7 = new ArrayList();
                }
                int i8 = 0;
                while (true) {
                    if (i8 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i8);
                    int i9 = jSONObject3.getInt("ty");
                    if (i9 == 26) {
                        i5 = i6;
                    } else {
                        MapObj mapObj2 = new MapObj();
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_LAYER_ID)) {
                            mapObj2.layer_id = (int) jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_LAYER_ID);
                        } else {
                            mapObj2.layer_id = 0;
                        }
                        if (jSONObject3.has("ud")) {
                            mapObj2.strUid = jSONObject3.getString("ud");
                        } else {
                            mapObj2.strUid = "";
                        }
                        mapObj2.strText = jSONObject3.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
                        if (jSONObject3.has("in")) {
                            mapObj2.nIndex = jSONObject3.getInt("in");
                        } else if (jSONObject3.has("index")) {
                            mapObj2.nIndex = jSONObject3.getInt("index");
                        } else {
                            mapObj2.nIndex = 0;
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO)) {
                            Point complexPtToPoint = CoordinateUtil.complexPtToPoint(jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_GEO));
                            mapObj2.geoPt.setTo(complexPtToPoint == null ? 0.0d : complexPtToPoint.getIntX(), complexPtToPoint == null ? 0.0d : complexPtToPoint.getIntY());
                        } else if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) && jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_PTY)) {
                            mapObj2.geoPt.setTo((int) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_GEO_Z)) {
                            mapObj2.geoZ = (float) jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_GEO_Z);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_INDOOR_POI)) {
                            mapObj2.indoorpoi = jSONObject3.getBoolean(MapBundleKey.MapObjKey.OBJ_INDOOR_POI);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE)) {
                            mapObj2.poiOnlineType = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_POI_ONLINETYPE);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_BID)) {
                            mapObj2.bid = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_BID);
                        }
                        if (jSONObject3.has("ts")) {
                            mapObj2.sltime = jSONObject3.getInt("ts");
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ)) {
                            mapObj2.slobj = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                            mapObj2.slvisi = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_SL_VISI);
                        }
                        mapObj2.nType = i9;
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                            mapObj2.offset = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_OFFSET);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_POINAME)) {
                            mapObj2.ssName = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_POINAME);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID)) {
                            mapObj2.ssIndoorId = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID);
                        }
                        if (jSONObject3.has("ud")) {
                            mapObj2.ssPoiUid = jSONObject3.getString("ud");
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.STREET_TYPE)) {
                            mapObj2.ssType = jSONObject3.getString(MapBundleKey.MapObjKey.STREET_TYPE);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DIS)) {
                            mapObj2.offset = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DIS);
                        }
                        if (jSONObject3.has("x")) {
                            mapObj2.geoPt.setIntX(jSONObject3.getInt("x"));
                            mapObj2.streetArrowCenterX = jSONObject3.getDouble("x");
                        }
                        if (jSONObject3.has("y")) {
                            mapObj2.geoPt.setIntY(jSONObject3.getInt("y"));
                            mapObj2.streetArrowCenterY = jSONObject3.getDouble("y");
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)) {
                            mapObj2.ssZ = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z);
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                            mapObj2.ssRotation = jSONObject3.getDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION);
                        }
                        if (jSONObject3.has("pid")) {
                            mapObj2.ssPanoId = jSONObject3.getString("pid");
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                            mapObj2.ssData = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_SS_DATA);
                        }
                        if (jSONObject3.has("src")) {
                            mapObj2.dynamicSrc = jSONObject3.getInt("src");
                            i6 = mapObj2.dynamicSrc;
                        } else {
                            mapObj2.dynamicSrc = -1;
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_AD)) {
                            mapObj2.ad = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_AD);
                        } else {
                            mapObj2.ad = -1;
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                            mapObj2.adstyle = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
                        } else {
                            mapObj2.adstyle = -1;
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                            mapObj2.qid = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_QID);
                        } else {
                            mapObj2.qid = "";
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_PUID)) {
                            mapObj2.puid = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_PUID);
                        } else {
                            mapObj2.puid = "";
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_SRC)) {
                            mapObj2.dysrc = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DY_SRC);
                        } else {
                            mapObj2.dysrc = -1;
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_DY_STGE)) {
                            mapObj2.dystge = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_DY_STGE);
                        } else {
                            mapObj2.dystge = -1;
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.AD_LOG)) {
                            mapObj2.adLog = jSONObject3.getString(MapBundleKey.MapObjKey.AD_LOG);
                        } else {
                            mapObj2.adLog = "";
                        }
                        if (jSONObject3.has("url")) {
                            mapObj2.url = jSONObject3.getString("url");
                        } else {
                            mapObj2.url = "";
                        }
                        if (jSONObject3.has(MapBundleKey.MapObjKey.OBJ_STYLE_ID)) {
                            mapObj2.style_id = jSONObject3.getInt(MapBundleKey.MapObjKey.OBJ_STYLE_ID);
                        } else {
                            mapObj2.style_id = 0;
                        }
                        if (jSONObject3.has("level")) {
                            mapObj2.level = jSONObject3.getInt("level");
                        } else {
                            mapObj2.level = -1;
                        }
                        if (i7 == 22) {
                            ItsMapObj itsMapObj = new ItsMapObj();
                            itsMapObj.baseMapObj = mapObj2;
                            itsMapObj.tTrafficStart = jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_START);
                            itsMapObj.tTrafficEnd = jSONObject3.getLong(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_END);
                            itsMapObj.strTrafficDetail = jSONObject3.getString(MapBundleKey.MapObjKey.OBJ_TRAFFIC_EVENT_DETAIL);
                            if (arrayList2 != null) {
                                arrayList2.add(itsMapObj);
                            }
                            i5 = i6;
                        } else if (i7 == 3 || i7 == 13 || i7 == 14 || i7 == 16 || i7 == 15 || i7 == 4 || i7 == 103 || i7 == 25 || i7 == 31 || i7 == 104 || i7 == 5000 || i7 == 6018 || i7 == 6019) {
                            if (arrayList4 != null) {
                                arrayList4.add(mapObj2);
                                i5 = i6;
                            }
                            i5 = i6;
                        } else if (i7 == 8 || i7 == 1 || i7 == 2) {
                            if (arrayList5 != null) {
                                arrayList5.add(mapObj2);
                                i5 = i6;
                            }
                            i5 = i6;
                        } else if (i7 == 6) {
                            if (arrayList6 != null) {
                                arrayList6.add(mapObj2);
                                i5 = i6;
                            }
                            i5 = i6;
                        } else if (i7 == 24) {
                            if (arrayList3 != null) {
                                arrayList3.add(mapObj2);
                                i5 = i6;
                            }
                            i5 = i6;
                        } else if (i7 == 1234 || i7 == 1236 || i7 == 2000 || i7 == 2001) {
                            break;
                        } else if (i7 == 1235) {
                            if (getMapViewListener() != null) {
                                getMapViewListener().onClickStreetArrow(mapObj2);
                            }
                        } else if (i7 == 2002) {
                            if (getMapViewListener() != null) {
                                getMapViewListener().onClickStreetSurface(mapObj2);
                            }
                        } else if (i7 == 1239) {
                            if (arrayList5 != null) {
                                arrayList5.add(mapObj2);
                            }
                            if (getMapViewListener() != null) {
                                getMapViewListener().onClickedRouteLabelObj(arrayList5);
                            }
                        } else if (i7 == 6000) {
                            if (getMapViewListener() != null) {
                                getMapViewListener().onClickedTrafficUgcEventMapObj(mapObj2, true);
                            }
                        } else if (i7 == 7000) {
                            if (arrayList7 != null) {
                                arrayList7.add(mapObj2);
                                i5 = i6;
                            }
                            i5 = i6;
                        } else if (i7 == 6002) {
                            if (getMapViewListener() != null) {
                                getMapViewListener().onClickedTrafficUgcEventMapObj(mapObj2, jSONObject3.optBoolean("bchecked"));
                                i5 = i6;
                            }
                            i5 = i6;
                        } else {
                            if (i7 != 90909 && i7 != 90910) {
                                arrayList.add(mapObj2);
                            } else if (getMapViewListener() != null) {
                                getMapViewListener().onClickSdkMapObj(i7, jSONObject3);
                                i5 = i6;
                            }
                            i5 = i6;
                        }
                    }
                    i8++;
                    i6 = i5;
                }
                switch (i7) {
                    case 1:
                    case 2:
                    case 8:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedRouteObj(arrayList5);
                            break;
                        }
                        break;
                    case 3:
                    case 4:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 25:
                    case 31:
                    case 103:
                    case 104:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedPoiObj(arrayList4);
                            break;
                        }
                        break;
                    case 6:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedMapObj(arrayList6);
                            break;
                        }
                        break;
                    case 17:
                    case 18:
                    case 19:
                    case NodeType.E_TOPIC_POI /* 6060 */:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedMapObj(arrayList);
                            break;
                        }
                        break;
                    case 20:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedStreetPopup(GetNearlyObjID);
                            break;
                        }
                        break;
                    case 22:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedItsMapObj(arrayList2);
                            break;
                        }
                        break;
                    case 23:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedMapObj(arrayList);
                            break;
                        }
                        break;
                    case 5000:
                        if (getMapViewListener() != null) {
                            if (i6 != 27) {
                                getMapViewListener().onClickedPoiObj(arrayList4);
                                break;
                            } else {
                                getMapViewListener().onClickPolymericMapObj(arrayList4);
                                break;
                            }
                        }
                        break;
                    case NodeType.E_UNIVERSAL_LAYER /* 6018 */:
                    case NodeType.E_UNIVERSAL_LAYER_AGGREGATE_POI /* 6019 */:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedUniversalLayerPoiEventMapObj(arrayList4);
                            break;
                        }
                        break;
                    case NodeType.E_PARTICLE /* 7000 */:
                        if (getMapViewListener() != null) {
                            getMapViewListener().onClickedParticleEventMapObj(arrayList7);
                            break;
                        }
                        break;
                }
                return true;
            } catch (JSONException e) {
                return false;
            }
        }
        return false;
    }

    private void c() {
        MessageProxy.registerMessageHandler(4000, t);
        MessageProxy.registerMessageHandler(519, t);
        MessageProxy.registerMessageHandler(39, t);
        MessageProxy.registerMessageHandler(512, t);
        MessageProxy.registerMessageHandler(65297, t);
        MessageProxy.registerMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, t);
        MessageProxy.registerMessageHandler(50, t);
        MessageProxy.registerMessageHandler(51, t);
        MessageProxy.registerMessageHandler(65301, t);
        MessageProxy.registerMessageHandler(41, t);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(int i, int i2) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2;
        if (a()) {
            String GetNearlyObjID = this.r.GetNearlyObjID(-1L, i, i2, this.nearlyRadius);
            if (GetNearlyObjID != null && !GetNearlyObjID.equals("")) {
                try {
                    jSONObject = new JSONObject(GetNearlyObjID);
                } catch (JSONException e2) {
                    jSONObject = null;
                    e = e2;
                }
                try {
                    jSONObject.put("px", i);
                    jSONObject.put("py", i2);
                    jSONObject2 = jSONObject;
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    if (this.mListeners != null) {
                    }
                    return true;
                }
                if (this.mListeners != null) {
                    for (ag agVar : this.mListeners) {
                        if (jSONObject2 != null && agVar != null) {
                            agVar.a(jSONObject2.toString());
                        }
                    }
                }
            } else if (this.mListeners != null) {
                for (ag agVar2 : this.mListeners) {
                    if (agVar2 != null) {
                        agVar2.a(getMapView().getProjection().fromPixels(i, i2));
                    }
                }
            }
            return true;
        }
        return false;
    }

    private void d() {
        MessageProxy.unRegisterMessageHandler(4000, t);
        MessageProxy.unRegisterMessageHandler(519, t);
        MessageProxy.unRegisterMessageHandler(39, t);
        MessageProxy.unRegisterMessageHandler(512, t);
        MessageProxy.unRegisterMessageHandler(65297, t);
        MessageProxy.unRegisterMessageHandler(UIMsg.MsgDefine.V_WM_VSTREETCLICKBACKGROUND, t);
        MessageProxy.unRegisterMessageHandler(50, t);
        MessageProxy.unRegisterMessageHandler(51, t);
        MessageProxy.unRegisterMessageHandler(65301, t);
    }

    private boolean d(int i, int i2) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        int i3;
        if (a() && getMapViewListener() != null) {
            String GetNearlyObjID = this.r.GetNearlyObjID(-1L, i, i2, (int) (this.nearlyRadius * getZoomUnitsInMeter()));
            if (GetNearlyObjID == null) {
                return false;
            }
            new ArrayList();
            try {
                jSONArray = new JSONObject(GetNearlyObjID).getJSONArray("dataset");
            } catch (JSONException e) {
            }
            if (((JSONObject) jSONArray.get(0)).getInt("ty") == 7000) {
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= jSONArray.length()) {
                        getMapViewListener().onClickedParticleEventMapObj(arrayList);
                        return true;
                    }
                    try {
                        jSONObject = (JSONObject) jSONArray.get(i5);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        jSONObject = null;
                    }
                    if (jSONObject != null && (i3 = jSONObject.getInt("ty")) != 26) {
                        MapObj mapObj = new MapObj();
                        if (jSONObject.has("ud")) {
                            mapObj.strUid = jSONObject.getString("ud");
                        } else {
                            mapObj.strUid = "";
                        }
                        mapObj.strText = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
                        if (jSONObject.has("in")) {
                            mapObj.nIndex = jSONObject.getInt("in");
                        } else if (jSONObject.has("index")) {
                            mapObj.nIndex = jSONObject.getInt("index");
                        } else {
                            mapObj.nIndex = 0;
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_GEO)) {
                            Point complexPtToPoint = CoordinateUtil.complexPtToPoint(jSONObject.getString(MapBundleKey.MapObjKey.OBJ_GEO));
                            mapObj.geoPt.setTo(complexPtToPoint == null ? 0.0d : complexPtToPoint.getIntX(), complexPtToPoint == null ? 0.0d : complexPtToPoint.getIntY());
                        } else if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_PTX) && jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_PTY)) {
                            mapObj.geoPt.setTo((int) jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTX), (int) jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SL_PTY));
                        }
                        if (jSONObject.has("ts")) {
                            mapObj.sltime = jSONObject.getInt("ts");
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_OBJ)) {
                            mapObj.slobj = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SL_VISI)) {
                            mapObj.slvisi = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_SL_VISI);
                        }
                        mapObj.nType = i3;
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_OFFSET)) {
                            mapObj.offset = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_OFFSET);
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_POINAME)) {
                            mapObj.ssName = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_SS_POINAME);
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID)) {
                            mapObj.ssIndoorId = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_SS_INDOOR_ID);
                        }
                        if (jSONObject.has("ud")) {
                            mapObj.ssPoiUid = jSONObject.getString("ud");
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_DIS)) {
                            mapObj.offset = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_DIS);
                        }
                        if (jSONObject.has("x")) {
                            mapObj.geoPt.setIntX(jSONObject.getInt("x"));
                            mapObj.streetArrowCenterX = jSONObject.getDouble("x");
                        }
                        if (jSONObject.has("y")) {
                            mapObj.geoPt.setIntY(jSONObject.getInt("y"));
                            mapObj.streetArrowCenterY = jSONObject.getDouble("y");
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)) {
                            mapObj.ssZ = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z);
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION)) {
                            mapObj.ssRotation = jSONObject.getDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION);
                        }
                        if (jSONObject.has("pid")) {
                            mapObj.ssPanoId = jSONObject.getString("pid");
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_SS_DATA)) {
                            mapObj.ssData = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_SS_DATA);
                        }
                        if (jSONObject.has("src")) {
                            mapObj.dynamicSrc = jSONObject.getInt("src");
                        } else {
                            mapObj.dynamicSrc = -1;
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_AD)) {
                            mapObj.ad = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_AD);
                        } else {
                            mapObj.ad = -1;
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_AD_STYLE)) {
                            mapObj.adstyle = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_AD_STYLE);
                        } else {
                            mapObj.adstyle = -1;
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_QID)) {
                            mapObj.qid = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_QID);
                        } else {
                            mapObj.qid = "";
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.OBJ_PUID)) {
                            mapObj.puid = jSONObject.getString(MapBundleKey.MapObjKey.OBJ_PUID);
                        } else {
                            mapObj.puid = "";
                        }
                        if (jSONObject.has(MapBundleKey.MapObjKey.AD_LOG)) {
                            mapObj.adLog = jSONObject.getString(MapBundleKey.MapObjKey.AD_LOG);
                        } else {
                            mapObj.adLog = "";
                        }
                        if (jSONObject.has("url")) {
                            mapObj.url = jSONObject.getString("url");
                        } else {
                            mapObj.url = "";
                        }
                        if (jSONObject.has("level")) {
                            mapObj.level = jSONObject.getInt("level");
                        } else {
                            mapObj.level = -1;
                        }
                        arrayList.add(mapObj);
                    }
                    i4 = i5 + 1;
                }
            }
            return false;
        }
        return false;
    }

    public static int getScaleDis(int i) {
        switch (i) {
            case 1:
                return ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT;
            case 2:
                return 5000000;
            case 3:
                return 2000000;
            case 4:
                return MessageConfig.BASE_SEGMENT_LENGTH;
            case 5:
                return 500000;
            case 6:
                return AlaRecorderLog.ErrCodeSeg.ERROR_BASE_RTMP;
            case 7:
                return 100000;
            case 8:
                return IMConstants.ERROR_BASE;
            case 9:
                return BdNetTask.TIMEOUT_READ;
            case 10:
                return 20000;
            case 11:
                return 10000;
            case 12:
                return 5000;
            case 13:
                return 2000;
            case 14:
                return 1000;
            case 15:
                return 500;
            case 16:
                return 200;
            case 17:
                return 100;
            case 18:
                return 50;
            case 19:
                return 20;
            case 20:
                return 10;
            case 21:
                return 5;
            case 22:
                return 2;
            default:
                return 0;
        }
    }

    public float GetFZoomToBoundF(Bundle bundle, Bundle bundle2) {
        if (a()) {
            return this.r.GetFZoomToBoundF(bundle, bundle2);
        }
        return 0.0f;
    }

    public int MapMsgProc(int i, int i2, int i3) {
        return MapMsgProc(i, i2, i3, 0, 0, 0.0d, 0.0d, 0.0d, 0.0d);
    }

    public int MapMsgProc(int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, double d4) {
        if (a()) {
            return MapProc(this.s, i, i2, i3, i4, i5, d, d2, d3, d4);
        }
        return -1;
    }

    public void SetStyleMode(int i) {
        setMapScene(i);
    }

    void a(int i, int i2) {
        if (a()) {
            this.r.MoveToScrPoint(i, i2);
        }
    }

    public void addOneOverlayItem(Bundle bundle) {
        if (a()) {
            this.X = this.r.AddLayer(2, 0, ANDROID_SDK_LAYER_TAG);
            bundle.putLong("layer_addr", this.X);
            this.r.addOneOverlayItem(bundle);
            this.r.UpdateLayers(this.X);
        }
    }

    public void addStreetCustomMarker(Bundle bundle, Bitmap bitmap) {
        if (a()) {
            this.r.AddStreetCustomMarker(bundle, bitmap);
        }
    }

    public void animateTo(GeoPoint geoPoint, int i) {
        if (a()) {
            MapStatus mapStatus = getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public boolean cleanCache(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.r;
        return appBaseMap != null && appBaseMap.CleanCache(mapLayerType.f2879a);
    }

    public void clearUniversalLayer() {
        if (a()) {
            this.r.clearUniversalLayer();
        }
    }

    public boolean createByDuplicateAppBaseMap(long j2) {
        this.r = new AppBaseMap();
        if (this.r.CreateByDuplicate(j2)) {
            this.s = this.r.GetId();
            return true;
        }
        this.r = null;
        this.s = 0L;
        return false;
    }

    public void enablePOIAnimation(boolean z2) {
        if (a()) {
            this.r.enablePOIAnimation(z2);
        }
    }

    public void forceSetMapScene(int i) {
        this.m = i;
        if (a()) {
            this.r.setMapScene(this.m);
        }
    }

    public boolean forceSetMapThemeScene(int i, int i2, Bundle bundle) {
        this.n = i;
        this.m = i2;
        if (a()) {
            return this.r.setMapThemeScene(i, i2, bundle);
        }
        return false;
    }

    public float getAdapterZoomUnitsEx() {
        if (a()) {
            return this.r.GetAdapterZoomUnitsEx();
        }
        return 0.0f;
    }

    public AppBaseMap getBaseMap() {
        return this.r;
    }

    public int getCacheSize(MapLayerType mapLayerType) {
        AppBaseMap appBaseMap = this.r;
        if (appBaseMap == null) {
            return 0;
        }
        return appBaseMap.GetCacheSize(mapLayerType.f2879a);
    }

    public CaptureMapListener getCaptureMapListener() {
        return this.c;
    }

    public String getCityInfoByID(int i) {
        if (this.r != null) {
            return this.r.GetCityInfoByID(i);
        }
        return null;
    }

    public MapStatus getCurrentMapStatus() {
        return a(false);
    }

    public float getCurrentZoomLevel() {
        Bundle GetMapStatus;
        if (this.r == null || (GetMapStatus = this.r.GetMapStatus(false)) == null) {
            return 4.0f;
        }
        return (float) GetMapStatus.getDouble("level");
    }

    public j getFocusedBaseIndoorMapInfo() {
        String[] strArr;
        int[] iArr;
        if (a()) {
            String GetFocusedBaseIndoorMapInfo = this.r.GetFocusedBaseIndoorMapInfo();
            if (TextUtils.isEmpty(GetFocusedBaseIndoorMapInfo)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(GetFocusedBaseIndoorMapInfo);
                String optString = jSONObject.optString("focusindoorid");
                String optString2 = jSONObject.optString("curfloor");
                int optInt = jSONObject.optInt("idrtype");
                JSONArray optJSONArray = jSONObject.optJSONArray("floorlist");
                if (optJSONArray != null) {
                    strArr = new String[optJSONArray.length()];
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.getString(i));
                    }
                    arrayList.toArray(strArr);
                } else {
                    strArr = null;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("floorattribute");
                if (optJSONArray2 != null) {
                    iArr = new int[optJSONArray2.length()];
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        iArr[i2] = optJSONArray2.optInt(i2);
                    }
                } else {
                    iArr = null;
                }
                return new j(optString, optString2, strArr, iArr, optInt, jSONObject.optInt("idrguide"), jSONObject.optString("idrsearch"));
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    public com.baidu.platform.comapi.map.b.d getGestureMonitor() {
        if (this.k == null) {
            this.k = new com.baidu.platform.comapi.map.b.d(this);
        }
        return this.k;
    }

    public i getHideIndoorPopupListener() {
        return this.d;
    }

    public EngineMsgListener getIndoorMapListener() {
        return this.g;
    }

    public boolean getMapBarData() {
        if (a()) {
            Bundle bundle = new Bundle();
            this.r.getMapBarData(bundle);
            byte[] bArr = new byte[0];
            String string = bundle.containsKey("uid") ? bundle.getString("uid") : null;
            String string2 = bundle.containsKey("searchbound") ? bundle.getString("searchbound") : null;
            String string3 = bundle.containsKey("curfloor") ? bundle.getString("curfloor") : null;
            if (bundle.containsKey("barinfo")) {
                bArr = bundle.getByteArray("barinfo");
            }
            com.baidu.platform.comapi.util.a.a().a(new b(string, string2, string3, bArr));
            return true;
        }
        return false;
    }

    public boolean getMapBarShowData() {
        if (a()) {
            return this.r.getMapBarData(new Bundle());
        }
        return false;
    }

    public boolean getMapClickEnable() {
        return this.A;
    }

    public MapControlMode getMapControlMode() {
        return this.W;
    }

    public long getMapId() {
        return this.s;
    }

    public MapRenderModeChangeListener getMapRenderModeChangeListener() {
        return this.f;
    }

    public int getMapScene() {
        if (a()) {
            return this.r.getMapScene();
        }
        return 0;
    }

    public MapStatus getMapStatus() {
        return a(true);
    }

    public com.baidu.mapsdkplatform.comapi.map.w getMapStatusInner() {
        if (a()) {
            Bundle GetMapStatus = this.r.GetMapStatus();
            com.baidu.mapsdkplatform.comapi.map.w wVar = new com.baidu.mapsdkplatform.comapi.map.w();
            wVar.a(GetMapStatus);
            return wVar;
        }
        return null;
    }

    public int getMapTheme() {
        if (a()) {
            return this.r.getMapTheme();
        }
        return 0;
    }

    public MapViewInterface getMapView() {
        if (this.h != null) {
            return this.h.get();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        return this.b;
    }

    public NaviMapViewListener getNaviMapViewListener() {
        return this.i;
    }

    public String getProjectionPt(String str) {
        if (a()) {
            return this.r.getProjectionPt(str);
        }
        return null;
    }

    public int getScaleLevel(int i, int i2) {
        if (a()) {
            return this.r.getScaleLevel(i, i2);
        }
        return 0;
    }

    public int getSceneLayerScene() {
        return this.m;
    }

    public int getSceneLayerTheme() {
        return this.n;
    }

    public int getScreenHeight() {
        return this.v;
    }

    public int getScreenWidth() {
        return this.u;
    }

    public ai getStreetArrowClickListener() {
        return this.e;
    }

    public int getVMPMapCityCode() {
        if (this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", "map");
            this.r.GetVMPMapCityInfo(bundle);
            return bundle.getInt("code");
        }
        return 0;
    }

    public int getVMPMapCityItsInfo() {
        if (this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", "its");
            this.r.GetVMPMapCityInfo(bundle);
            return bundle.getInt("rst");
        }
        return 0;
    }

    public int getVMPMapCityLevel() {
        if (this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", "map");
            this.r.GetVMPMapCityInfo(bundle);
            return bundle.getInt("level");
        }
        return 0;
    }

    public int getVMPMapCitySatInfo() {
        if (this.r != null) {
            Bundle bundle = new Bundle();
            bundle.putString("querytype", "sat");
            this.r.GetVMPMapCityInfo(bundle);
            return bundle.getInt("rst");
        }
        return 0;
    }

    public float getZoomLevel() {
        Bundle GetMapStatus;
        if (this.r == null || (GetMapStatus = this.r.GetMapStatus()) == null) {
            return 4.0f;
        }
        return (float) GetMapStatus.getDouble("level");
    }

    public float getZoomToBound(Bundle bundle, int i, int i2) {
        if (a()) {
            return this.r.GetZoomToBound(bundle, i, i2);
        }
        return 0.0f;
    }

    public float getZoomToBoundF(Bundle bundle) {
        if (a()) {
            return this.r.GetZoomToBoundF(bundle);
        }
        return 0.0f;
    }

    public double getZoomUnitsInMeter() {
        Bundle GetMapStatus;
        AppBaseMap baseMap = getBaseMap();
        if (baseMap != null && (GetMapStatus = baseMap.GetMapStatus()) != null) {
            float f = GetMapStatus.getFloat("adapterZoomUnits");
            if (f > 1.0E-4d) {
                return f;
            }
        }
        return Math.pow(2.0d, 18.0f - getZoomLevel());
    }

    public void handleClick(MotionEvent motionEvent) {
        MapMsgProc(UIMsg.KEvent.V_WM_LBUTTONCLICK, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
    }

    public void handleDoubleClickZoom(MotionEvent motionEvent) {
        if (System.currentTimeMillis() - this.L < 100) {
            return;
        }
        mapStatusChangeStart();
        float y2 = motionEvent.getY();
        float f = this.J - y2;
        MapMsgProc(8193, 3, (int) ((f / (getScreenHeight() / 9.0f)) * 10000.0f));
        this.K = f;
        this.J = y2;
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
        if (!isNaviMode() || getNaviMapViewListener() == null) {
            return;
        }
        getNaviMapViewListener().onAction(521, null);
    }

    public void handleDoubleDownClick(MotionEvent motionEvent) {
        this.F = true;
        this.I = motionEvent.getX();
        this.J = motionEvent.getY();
        this.L = System.currentTimeMillis();
        com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.d());
    }

    public void handleDoubleTouch(MotionEvent motionEvent) {
        GeoPoint geoPoint;
        GeoPoint fromPixels;
        float f;
        float f2;
        float f3;
        float f4;
        if (System.currentTimeMillis() - this.L > 150) {
            return;
        }
        if (isNaviMode() && this.i != null) {
            this.i.onAction(513, motionEvent);
            return;
        }
        if (!this.E) {
            geoPoint = null;
        } else if (this.h == null || this.h.get() == null) {
            return;
        } else {
            float x2 = motionEvent.getX() - (getScreenWidth() / 2);
            float y2 = (motionEvent.getY() - (getScreenHeight() / 2)) * (-1.0f);
            if (isCompass || this.H) {
                fromPixels = this.h.get().getProjection().fromPixels(getScreenWidth() / 2, getScreenHeight() / 2);
                f = 0.0f;
                f2 = 0.0f;
            } else {
                fromPixels = this.h.get().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                f = y2;
                f2 = x2;
            }
            if (fromPixels != null) {
                float longitudeE6 = (float) fromPixels.getLongitudeE6();
                f3 = (float) fromPixels.getLatitudeE6();
                f4 = longitudeE6;
            } else {
                f3 = 0.0f;
                f4 = 0.0f;
            }
            this.M = true;
            getGestureMonitor().b(this.h.get().getZoomLevel() + 1.0f);
            mapStatusChangeStart();
            MapMsgProc(8195, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16), (this.u / 2) | ((this.v / 2) << 16), 0, 0, f4, f3, f2, f);
            N = System.currentTimeMillis();
            geoPoint = fromPixels;
        }
        if (geoPoint == null || this.mListeners == null) {
            return;
        }
        for (ag agVar : this.mListeners) {
            if (agVar != null) {
                agVar.b(geoPoint);
            }
        }
    }

    @SuppressLint({"FloatMath"})
    public boolean handleFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (w && this.R) {
            float sqrt = (float) ((((float) Math.sqrt((f * f) + (f2 * f2))) / (SysOSUtil.getInstance().getDensityDPI() / 310.0f)) * 1.3d);
            if (getMapControlMode() != MapControlMode.STREET && sqrt < 300.0f) {
                this.B = false;
                return false;
            }
            this.B = true;
            getGestureMonitor().a();
            mapStatusChangeStart();
            MapMsgProc(34, (int) sqrt, (((int) motionEvent2.getY()) << 16) | ((int) motionEvent2.getX()));
            if (getMapViewListener() != null) {
                com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.c());
            }
            this.U = false;
            return true;
        }
        return false;
    }

    public boolean handleKeyEvent(int i, KeyEvent keyEvent) {
        int GetAdaptKeyCode = GetAdaptKeyCode(i);
        if (GetAdaptKeyCode == 0) {
            return false;
        }
        MapMsgProc(1, GetAdaptKeyCode, 0);
        return true;
    }

    public void handleLongClick(MotionEvent motionEvent) {
        MapMsgProc(20737, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
    }

    public int handleMapModeGet() {
        return MapMsgProc(4113, 0, 0);
    }

    public boolean handlePopupClick(int i, int i2) {
        return false;
    }

    public void handleRightClick() {
        MapMsgProc(UIMsg.KEvent.V_WM_RBUTTONCLICK, 0, 0);
    }

    public void handleStreetscapeDoubleTouch(MotionEvent motionEvent) {
        float f;
        float f2;
        if (this.h == null || this.h.get() == null) {
            return;
        }
        GeoPoint fromPixels = this.h.get().getProjection().fromPixels(this.u / 2, this.v / 2);
        if (fromPixels != null) {
            float longitudeE6 = (float) fromPixels.getLongitudeE6();
            f = (float) fromPixels.getLatitudeE6();
            f2 = longitudeE6;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        MapMsgProc(8195, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()), ((this.v / 2) << 16) | (this.u / 2), 0, 0, f2, f, 0.0d, 0.0d);
    }

    public boolean handleTouchEvent(MotionEvent motionEvent) {
        if (a()) {
            if (!this.B) {
                this.V.a(motionEvent);
            }
            if (motionEvent.getPointerCount() == 2) {
                this.l = true;
                w = false;
                b();
            }
            if (motionEvent.getAction() != 2 && this.F) {
                this.l = true;
                b();
            }
            switch (motionEvent.getAction()) {
                case 0:
                    this.l = true;
                    a(motionEvent);
                    break;
                case 1:
                    w = true;
                    this.l = true;
                    handleTouchUp(motionEvent);
                    break;
                case 2:
                    if (this.F) {
                        handleDoubleClickZoom(motionEvent);
                        break;
                    } else if (this.R) {
                        handleTouchMove(motionEvent);
                        break;
                    }
                    break;
                default:
                    return false;
            }
            if (this.mListeners != null) {
                for (ag agVar : this.mListeners) {
                    if (agVar != null) {
                        agVar.a(motionEvent);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean handleTouchMove(MotionEvent motionEvent) {
        if (w && System.currentTimeMillis() - N >= 300) {
            if (this.mHasMapObjDraging) {
                if (this.mListeners != null) {
                    for (ag agVar : this.mListeners) {
                        GeoPoint fromPixels = getMapView().getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (agVar != null) {
                            agVar.d(fromPixels);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(motionEvent.getX() - x);
            float abs2 = Math.abs(motionEvent.getY() - y);
            float density = SysOSUtil.getInstance().getDensity();
            float f = (float) (((double) density) > 1.5d ? density * 1.5d : density);
            if (!z || abs / f > 3.0f || abs2 / f > 3.0f) {
                z = false;
                if (isCompass) {
                    com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.a());
                }
                int x2 = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                if (x2 < 0) {
                    x2 = 0;
                }
                if (y2 < 0) {
                    y2 = 0;
                }
                if (this.l) {
                    getGestureMonitor().b();
                    this.l = false;
                }
                mapStatusChangeStart();
                MapMsgProc(3, 0, (y2 << 16) | x2);
                com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.b(false, true));
                this.B = false;
                this.q = true;
                this.U = true;
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean handleTouchSingleClick(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        c(x2, y2);
        if (d(x2, y2) || handlePopupClick(x2, y2) || a(1, x2, y2)) {
            return true;
        }
        if (this.A && b(x2, y2)) {
            return true;
        }
        if (isNaviMode() && this.i != null) {
            this.i.onAction(514, motionEvent);
        }
        if (getMapViewListener() != null) {
            getMapViewListener().onClickedBackground((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return false;
    }

    public boolean handleTouchUp(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int i = x2 < 0 ? 0 : x2;
        int i2 = y2 < 0 ? 0 : y2;
        if (this.mHasMapObjDraging) {
            if (this.mListeners != null) {
                for (ag agVar : this.mListeners) {
                    GeoPoint fromPixels = getMapView().getProjection().fromPixels(i, i2);
                    if (agVar != null) {
                        agVar.e(fromPixels);
                    }
                }
            }
            this.mHasMapObjDraging = false;
        } else {
            if (w) {
                MapMsgProc(5, 0, (i2 << 16) | i);
            }
            if (!this.B && getMapViewListener() != null) {
                getMapViewListener().onMapAnimationFinish();
            }
            if (!this.B && isNaviMode() && getNaviMapViewListener() != null) {
                getNaviMapViewListener().onMapAnimationFinish();
            }
            boolean z2 = motionEvent.getEventTime() - this.T < 300 && Math.abs(motionEvent.getX() - x) < 10.0f && Math.abs(motionEvent.getY() - y) < 10.0f;
            if (!this.B && ((!z2 || this.U) && this.mListeners != null)) {
                for (ag agVar2 : this.mListeners) {
                    agVar2.c(getMapStatusInner());
                }
            }
            this.U = false;
            this.B = false;
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.b(true, false));
            com.baidu.platform.comapi.util.a.a().a(new com.baidu.platform.comapi.map.a.c());
        }
        return true;
    }

    public boolean handleTrackballEvent(MotionEvent motionEvent) {
        if (a()) {
            switch (motionEvent.getAction()) {
                case 2:
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    int i = rawX > 0.0f ? 18 : rawX < 0.0f ? 16 : 0;
                    if (rawY > 0.0f) {
                        i = 19;
                    } else if (rawY < 0.0f) {
                        i = 17;
                    }
                    if (i != 0) {
                        MapMsgProc(1, i, 0);
                        break;
                    } else {
                        return false;
                    }
            }
            return true;
        }
        return false;
    }

    public boolean handleZoomTo(int i) {
        switch (i) {
            case 0:
                MapMsgProc(4097, -1, 0);
                break;
            case 1:
                MapMsgProc(4096, -1, 0);
                break;
        }
        return false;
    }

    public boolean importMapTheme(int i) {
        if (a()) {
            return this.r.importMapTheme(i);
        }
        return false;
    }

    public void initAppBaseMap() {
        if (S.size() != 0) {
            createByDuplicateAppBaseMap(S.get(0).GetId());
            return;
        }
        initBaseMap();
        S.add(this.r);
    }

    public void initBaseMap() {
        this.r = new AppBaseMap();
        this.r.Create();
        this.s = this.r.GetId();
    }

    public void initMapResources(Bundle bundle) {
        if (this.C || bundle == null || this.r == null) {
            return;
        }
        boolean z2 = SysOSUtil.getInstance().getDensityDPI() >= 180;
        this.nearlyRadius = (SysOSUtil.getInstance().getDensityDPI() * 25) / 240;
        String string = bundle.getString("modulePath");
        String string2 = bundle.getString("appSdcardPath");
        String string3 = bundle.getString("appCachePath");
        String string4 = bundle.getString("appSecondCachePath");
        int i = bundle.getInt("mapTmpMax");
        int i2 = bundle.getInt("domTmpMax");
        int i3 = bundle.getInt("itsTmpMax");
        int i4 = bundle.getInt("ssgTmpMax");
        String str = z2 ? "/h/" : "/l/";
        String str2 = string + "/cfg";
        String str3 = string2 + "/vmp";
        this.r.Init(str2 + "/a/", str2 + "/idrres/", str3 + str, string3 + "/tmp/", string4 + "/tmp/", str3 + str, str2 + "/a/", this.u, this.v, SysOSUtil.getInstance().getDensityDPI(), i, i2, i3, i4, false, com.baidu.platform.comapi.b.g() || com.baidu.platform.comapi.b.f() || com.baidu.platform.comapi.b.h());
        this.r.SetMapStatus(bundle);
        this.C = true;
    }

    public boolean is3DGestureEnable() {
        return this.O;
    }

    public boolean isBaseIndoorMapMode() {
        if (a()) {
            return this.r.IsBaseIndoorMapMode();
        }
        return false;
    }

    public boolean isCanTouchMove() {
        return this.R;
    }

    public boolean isDoubleClickZoom() {
        return this.E;
    }

    public boolean isEnableDMoveZoom() {
        return this.F;
    }

    public boolean isEnableZoom() {
        return this.Q;
    }

    public boolean isEnlargeCenterWithDoubleClickEnabled() {
        return this.H;
    }

    public boolean isInFocusBarBorder(GeoPoint geoPoint, double d) {
        return a() && geoPoint != null && this.r.IsPointInFocusBarBorder(geoPoint.getLongitude(), geoPoint.getLatitude(), d);
    }

    public boolean isInFocusIndoorBuilding(GeoPoint geoPoint) {
        return a() && geoPoint != null && this.r.IsPointInFocusIDRBorder(geoPoint.getLongitude(), geoPoint.getLatitude());
    }

    public boolean isMapAnimationRunning() {
        if (a()) {
            return this.r.isAnimationRunning();
        }
        return false;
    }

    public boolean isMovedMap() {
        return this.q;
    }

    public boolean isNaviMode() {
        if (a()) {
            return this.r.isNaviMode();
        }
        return false;
    }

    public boolean isOverlookGestureEnable() {
        return this.P;
    }

    public boolean isPressedOnPopup(int i, int i2) {
        return false;
    }

    public boolean isStreetArrowShown() {
        if (a()) {
            return this.r.IsStreetArrowShown();
        }
        return false;
    }

    public boolean isStreetCustomMarkerShown() {
        if (a()) {
            return this.r.IsStreetCustomMarkerShown();
        }
        return false;
    }

    public boolean isStreetPOIMarkerShown() {
        if (a()) {
            return this.r.IsStreetPOIMarkerShown();
        }
        return false;
    }

    public boolean isStreetRoadClickable() {
        if (a()) {
            return this.r.IsStreetRoadClickable();
        }
        return false;
    }

    public boolean isTwoTouchClickZoomEnabled() {
        return this.G;
    }

    public void mapStatusChangeStart() {
        if (this.mIsMoving) {
            return;
        }
        this.mIsMoving = true;
        this.mIsAnimating = true;
        if (this.mListeners != null) {
            for (ag agVar : this.mListeners) {
                if (agVar != null) {
                    agVar.a(getMapStatusInner());
                }
            }
        }
    }

    public void onPause() {
        if (a()) {
            this.r.OnPause();
        }
    }

    public void onResume() {
        if (a()) {
            this.r.OnResume();
        }
    }

    public void recycleMemory(RecycleMemoryLevel recycleMemoryLevel) {
        if (a()) {
            this.r.recycleMemory(recycleMemoryLevel.getLevel());
        }
    }

    public void registMapViewListener(ag agVar) {
        if (agVar == null || this.mListeners == null) {
            return;
        }
        this.mListeners.add(agVar);
    }

    public void removeOneOverlayItem(Bundle bundle) {
        if (a()) {
            bundle.putLong("layer_addr", this.X);
            this.r.removeOneOverlayItem(bundle);
            this.r.UpdateLayers(this.X);
        }
    }

    public void removeStreetAllCustomMarker() {
        if (a()) {
            this.r.RemoveStreetAllCustomMarker();
        }
    }

    public void removeStreetCustomMarker(String str) {
        if (a()) {
            this.r.RemoveStreetCustomMaker(str);
        }
    }

    public void saveScreenToLocal(String str) {
        saveScreenToLocal(str, 0, 0, 0, 0);
    }

    public void saveScreenToLocal(String str, int i, int i2, int i3, int i4) {
        String str2 = null;
        if (!a() || TextUtils.isEmpty(str)) {
            return;
        }
        if (i3 != 0 && i4 != 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", i);
                jSONObject.put("y", i2);
                jSONObject.put("width", i3);
                jSONObject.put("height", i4);
                str2 = jSONObject.toString();
            } catch (Exception e) {
            }
        }
        this.r.SaveScreenToLocal(str, str2);
    }

    public void scrollBy(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        a((this.u / 2) + i, (this.v / 2) + i2);
    }

    public void set3DGestureEnable(boolean z2) {
        this.O = z2;
    }

    public void setAllStreetCustomMarkerVisibility(boolean z2) {
        if (a()) {
            this.r.SetAllStreetCustomMarkerVisibility(z2);
        }
    }

    public void setCanTouchMove(boolean z2) {
        this.R = z2;
    }

    public void setCaptureMapListener(CaptureMapListener captureMapListener) {
        this.c = captureMapListener;
    }

    public void setDoubleClickZoom(boolean z2) {
        this.E = z2;
    }

    public void setEnableZoom(boolean z2) {
        this.Q = z2;
    }

    public void setEngineMsgListener(EngineMsgListener engineMsgListener) {
        this.g = engineMsgListener;
    }

    public void setEnlargeCenterWithDoubleClickEnable(boolean z2) {
        this.H = z2;
    }

    public void setHideIndoorPopupListener(i iVar) {
        this.d = iVar;
    }

    public boolean setLayerSceneMode(long j2, MapSceneMode mapSceneMode) {
        if (a()) {
            return this.r.SetLayerSceneMode(j2, mapSceneMode.getMode());
        }
        return false;
    }

    public void setMapClickEnable(boolean z2) {
        this.A = z2;
    }

    public int setMapControlMode(MapControlMode mapControlMode) {
        if (a()) {
            this.W = mapControlMode;
            return this.r.SetMapControlMode(mapControlMode.f2878a);
        }
        return -1;
    }

    public void setMapFirstFrameCallback(MapFirstFrameCallback mapFirstFrameCallback) {
        this.p = mapFirstFrameCallback;
    }

    public void setMapRenderModeChangeListener(MapRenderModeChangeListener mapRenderModeChangeListener) {
        this.f = mapRenderModeChangeListener;
    }

    public void setMapScene(int i) {
        if (i == getMapScene()) {
            return;
        }
        this.m = i;
        if (a()) {
            this.r.setMapScene(this.m);
        }
    }

    public void setMapStatus(Bundle bundle) {
        if (a()) {
            this.r.SetMapStatus(bundle);
        }
    }

    public void setMapStatus(MapStatus mapStatus) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapStatus.winRound.right);
        bundle.putInt(VerticalTranslateLayout.TOP, mapStatus.winRound.top);
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animatime", mapStatus.animationTime);
        bundle.putInt("animation", mapStatus.hasAnimation);
        bundle.putInt("animatime", mapStatus.animationTime);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        mapStatusChangeStart();
        this.r.SetMapStatus(bundle);
    }

    public void setMapStatus(MapStatus mapStatus, boolean z2) {
        if (!a() || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapStatus.winRound.right);
        bundle.putInt(VerticalTranslateLayout.TOP, mapStatus.winRound.top);
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putInt("animation", 0);
        bundle.putInt("animatime", 0);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z2 ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        this.r.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i) {
        if (!a() || this.r == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapStatus.winRound.right);
        bundle.putInt(VerticalTranslateLayout.TOP, mapStatus.winRound.top);
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        mapStatusChangeStart();
        this.r.SetMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, int i2) {
        if (!a() || this.r == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapStatus.winRound.right);
        bundle.putInt(VerticalTranslateLayout.TOP, mapStatus.winRound.top);
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animationType", i);
        bundle.putInt("animatime", i2);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        this.r.SetNewMapStatus(bundle);
    }

    public void setMapStatusWithAnimation(MapStatus mapStatus, int i, boolean z2) {
        if (!a() || this.r == null || mapStatus == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", mapStatus.level);
        bundle.putDouble(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, mapStatus.rotation);
        bundle.putDouble("overlooking", mapStatus.overlooking);
        bundle.putDouble("centerptx", mapStatus.centerPtX);
        bundle.putDouble("centerpty", mapStatus.centerPtY);
        bundle.putDouble("centerptz", mapStatus.centerPtZ);
        bundle.putInt("left", mapStatus.winRound.left);
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapStatus.winRound.right);
        bundle.putInt(VerticalTranslateLayout.TOP, mapStatus.winRound.top);
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapStatus.winRound.bottom);
        bundle.putLong("gleft", mapStatus.geoRound.left);
        bundle.putLong("gright", mapStatus.geoRound.right);
        bundle.putLong("gbottom", mapStatus.geoRound.bottom);
        bundle.putLong("gtop", mapStatus.geoRound.top);
        bundle.putFloat("xoffset", mapStatus.xOffset);
        bundle.putFloat("yoffset", mapStatus.yOffset);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", i);
        bundle.putInt("bfpp", mapStatus.bfpp ? 1 : 0);
        bundle.putString("panoid", mapStatus.panoId);
        bundle.putInt("autolink", z2 ? 1 : 0);
        bundle.putFloat("siangle", mapStatus.streetIndicateAngle);
        bundle.putInt("isbirdeye", mapStatus.isBirdEye ? 1 : 0);
        bundle.putInt("ssext", mapStatus.streetExt);
        bundle.putFloat("roadOffsetX", mapStatus.roadOffsetX);
        bundle.putFloat("roadOffsetY", mapStatus.roadOffsetY);
        this.r.SetMapStatus(bundle);
    }

    public boolean setMapTheme(int i, Bundle bundle) {
        if (a()) {
            if (this.r.getMapTheme() == i) {
                return true;
            }
            this.n = i;
            return this.r.setMapTheme(i, bundle);
        }
        return false;
    }

    public boolean setMapThemeScene(int i, int i2, Bundle bundle) {
        if (a()) {
            if (this.r.getMapTheme() == i && this.r.getMapScene() == i2) {
                return true;
            }
            this.n = i;
            this.m = i2;
            return this.r.setMapThemeScene(i, i2, bundle);
        }
        return false;
    }

    public void setMapViewInterface(MapViewInterface mapViewInterface) {
        this.h = new SoftReference<>(mapViewInterface);
    }

    public void setMapViewListener(MapViewListener mapViewListener) {
        this.b = mapViewListener;
    }

    public void setMaxAndMinZoomLevel(float f, float f2) {
        this.mMaxZoomLevel = f;
        this.mMinZoomLevel = f2;
    }

    public void setNaviMapViewListener(NaviMapViewListener naviMapViewListener) {
        this.i = naviMapViewListener;
    }

    public void setNetStatus(int i) {
        if (this.g == null) {
            return;
        }
        if (i == 1) {
            this.g.onLongLinkConnect();
        } else if (i == 2 && this.f2876a != i) {
            this.g.onLongLinkDisConnect();
        }
        this.f2876a = i;
    }

    public void setOverlayMapCallBack(ac acVar) {
        if (acVar == null || this.r == null) {
            return;
        }
        this.r.SetCallback(acVar);
    }

    public void setOverlookGestureEnable(boolean z2) {
        this.P = z2;
    }

    public void setRecommendPOIScene(RecommendPoiScene recommendPoiScene) {
        if (a()) {
            this.r.setRecommendPOIScene(recommendPoiScene.value);
        }
    }

    public void setScreenSize(int i, int i2) {
        this.u = i;
        this.v = i2;
    }

    public void setStreetArrowClickListener(ai aiVar) {
        this.e = aiVar;
    }

    public void setStreetArrowShow(boolean z2) {
        if (a()) {
            this.r.SetStreetArrowShow(z2);
        }
    }

    public void setStreetMarkerClickable(String str, boolean z2) {
        if (a()) {
            this.r.SetStreetMarkerClickable(str, z2);
        }
    }

    public void setStreetRoadClickable(boolean z2) {
        if (a()) {
            this.r.SetStreetRoadClickable(z2);
        }
    }

    public void setStyleMode(MapStyleMode mapStyleMode) {
        if (a()) {
            this.r.SetStyleMode(mapStyleMode.getMode());
        }
    }

    public void setTargetStreetCustomMarkerVisibility(boolean z2, String str) {
        if (a()) {
            this.r.SetTargetStreetCustomMarkerVisibility(z2, str);
        }
    }

    public void setTravelMode(boolean z2) {
        this.o = z2;
    }

    public void setTwoTouchClickZoomEnabled(boolean z2) {
        this.G = z2;
    }

    public void setUniversalFilter(String str) {
        if (a()) {
            this.r.setUniversalFilter(str);
        }
    }

    public void showBaseIndoorMap(boolean z2) {
        if (a()) {
            this.r.ShowBaseIndoorMap(z2);
        }
    }

    public void showStreetPOIMarker(boolean z2) {
        if (a()) {
            this.r.ShowStreetPOIMarker(z2);
        }
    }

    public void showUniversalLayer(Bundle bundle) {
        if (a()) {
            this.r.showUniversalLayer(bundle);
        }
    }

    public void startIndoorAnimation() {
        if (a()) {
            this.r.StartIndoorAnimation();
        }
    }

    public boolean switchBaseIndoorMapFloor(String str, String str2) {
        if (a()) {
            return this.r.SwitchBaseIndoorMapFloor(str, str2);
        }
        return false;
    }

    public void unInit() {
        d();
        if (t != null) {
            t.removeCallbacksAndMessages(null);
            t = null;
        }
        if (S != null) {
            S.remove(this.r);
        }
        if (!this.C || this.r == null) {
            return;
        }
        this.r.Release();
        this.r = null;
        this.C = false;
    }

    public void unInitForMultiTextureView() {
        if (!this.C || this.r == null) {
            return;
        }
        this.r.Release();
        this.r = null;
        this.C = false;
    }

    public void updateDrawFPS() {
        if (a()) {
            this.r.updateDrawFPS();
        }
    }

    public void updateOneOverlayItem(Bundle bundle) {
        if (a()) {
            bundle.putLong("layer_addr", this.X);
            this.r.updateOneOverlayItem(bundle);
            this.r.UpdateLayers(this.X);
        }
    }
}
