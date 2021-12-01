package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class BaiduMap {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final String f35761e = "BaiduMap";
    public static int mapStatusReason;
    public transient /* synthetic */ FieldHolder $fh;
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
    public MapView a;

    /* renamed from: b  reason: collision with root package name */
    public TextureMapView f35762b;

    /* renamed from: c  reason: collision with root package name */
    public WearMapView f35763c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.aa f35764d;

    /* renamed from: f  reason: collision with root package name */
    public Projection f35765f;

    /* renamed from: g  reason: collision with root package name */
    public UiSettings f35766g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.j f35767h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comapi.map.e f35768i;

    /* renamed from: j  reason: collision with root package name */
    public ac f35769j;

    /* renamed from: k  reason: collision with root package name */
    public List<Overlay> f35770k;
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

    /* loaded from: classes8.dex */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* loaded from: classes8.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        boolean onMapPoiClick(MapPoi mapPoi);
    }

    /* loaded from: classes8.dex */
    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    /* loaded from: classes8.dex */
    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    /* loaded from: classes8.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* loaded from: classes8.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: classes8.dex */
    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    /* loaded from: classes8.dex */
    public interface OnMapRenderValidDataListener {
        void onMapRenderValidData(boolean z, int i2, String str);
    }

    /* loaded from: classes8.dex */
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i2);
    }

    /* loaded from: classes8.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes8.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: classes8.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: classes8.dex */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    /* loaded from: classes8.dex */
    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    /* loaded from: classes8.dex */
    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i2);
    }

    /* loaded from: classes8.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-292609788, "Lcom/baidu/mapapi/map/BaiduMap;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-292609788, "Lcom/baidu/mapapi/map/BaiduMap;");
        }
    }

    public BaiduMap(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {acVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = new CopyOnWriteArrayList<>();
        this.y = new CopyOnWriteArrayList<>();
        this.I = new ReentrantLock();
        this.J = new ReentrantLock();
        this.f35769j = acVar;
        this.f35768i = acVar.b();
        this.f35764d = com.baidu.mapsdkplatform.comapi.map.aa.f36386b;
        c();
    }

    public BaiduMap(com.baidu.mapsdkplatform.comapi.map.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = new CopyOnWriteArrayList<>();
        this.y = new CopyOnWriteArrayList<>();
        this.I = new ReentrantLock();
        this.J = new ReentrantLock();
        this.f35767h = jVar;
        this.f35768i = jVar.a();
        this.f35764d = com.baidu.mapsdkplatform.comapi.map.aa.a;
        c();
    }

    private Point a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
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
        return (Point) invokeL.objValue;
    }

    private ab a(MapStatusUpdate mapStatusUpdate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, mapStatusUpdate)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return null;
            }
            ab E = eVar.E();
            MapStatus a = mapStatusUpdate.a(this.f35768i, getMapStatus());
            if (a == null) {
                return null;
            }
            return a.b(E);
        }
        return (ab) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
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
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(InfoWindow infoWindow) {
        boolean z;
        Marker marker;
        MapView mapView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, infoWindow) == null) || infoWindow == null) {
            return;
        }
        Set<InfoWindow> keySet = this.L.keySet();
        if (keySet.isEmpty() || !keySet.contains(infoWindow)) {
            showInfoWindow(infoWindow, false);
            return;
        }
        View view = infoWindow.f35837b;
        if (view != null && infoWindow.f35845j) {
            view.destroyDrawingCache();
            MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.f35838c).yOffset(infoWindow.f35841f).build();
            int i2 = f.f36021b[this.f35764d.ordinal()];
            if (i2 == 1) {
                TextureMapView textureMapView = this.f35762b;
                if (textureMapView != null) {
                    textureMapView.removeView(view);
                    this.f35762b.addView(view, build);
                }
            } else if (i2 == 2 && (mapView = this.a) != null) {
                mapView.removeView(view);
                this.a.addView(view, build);
            }
            if (infoWindow.f35844i) {
                z = false;
                BitmapDescriptor b2 = b(infoWindow);
                marker = this.L.get(infoWindow);
                if (marker == null) {
                    Bundle bundle = new Bundle();
                    if (infoWindow.a != null) {
                        marker.type = com.baidu.mapsdkplatform.comapi.map.h.f36446b;
                        marker.f35897b = b2;
                        if (infoWindow.f35837b != null) {
                            bundle.putInt("draw_with_view", 1);
                        } else {
                            bundle.putInt("draw_with_view", 0);
                        }
                    }
                    marker.a = infoWindow.f35838c;
                    marker.a(bundle);
                    com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f6  */
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, this, myLocationData, myLocationConfiguration) == null) || myLocationData == null || myLocationConfiguration == null || !isMyLocationEnabled()) {
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
                    eVar = baiduMap.f35768i;
                    if (eVar != null) {
                    }
                    i2 = f.a[myLocationConfiguration.locationMode.ordinal()];
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
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    parcelItemArr[i3] = (ParcelItem) arrayList2.get(i3);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            baiduMap = this;
            bundle = bundle2;
        }
        eVar = baiduMap.f35768i;
        if (eVar != null) {
            eVar.a(jSONObject.toString(), bundle);
        }
        i2 = f.a[myLocationConfiguration.locationMode.ordinal()];
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
        InterceptResult invokeL;
        BitmapDescriptor fromView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, infoWindow)) == null) {
            View view = infoWindow.f35837b;
            if (view == null || !infoWindow.f35845j) {
                return infoWindow.a;
            }
            if (infoWindow.f35842g) {
                if (infoWindow.f35843h <= 0) {
                    infoWindow.f35843h = SysOSUtil.getDensityDpi();
                }
                fromView = BitmapDescriptorFactory.fromViewWithDpi(infoWindow.f35837b, infoWindow.f35843h);
            } else {
                fromView = BitmapDescriptorFactory.fromView(view);
            }
            infoWindow.a = fromView;
            return fromView;
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.f35770k = new CopyOnWriteArrayList();
            this.l = new CopyOnWriteArrayList();
            this.m = new CopyOnWriteArrayList();
            this.K = new ConcurrentHashMap();
            this.L = new ConcurrentHashMap();
            this.n = new CopyOnWriteArrayList();
            this.T = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
            this.f35766g = new UiSettings(this.f35768i);
            this.o = new a(this);
            this.p = new b(this);
            this.f35768i.a(new c(this));
            this.f35768i.a(new d(this));
            this.f35768i.a(new e(this));
            this.P = this.f35768i.C();
            this.Q = this.f35768i.D();
        }
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.t();
    }

    public void a(HeatMap heatMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, heatMap) == null) {
            this.I.lock();
            try {
                if (this.H != null && this.f35768i != null && heatMap == this.H) {
                    this.H.b();
                    this.H.c();
                    this.H.a = null;
                    this.f35768i.o();
                    this.H = null;
                    this.f35768i.o(false);
                }
            } finally {
                this.I.unlock();
            }
        }
    }

    public void a(TileOverlay tileOverlay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tileOverlay) == null) {
            this.J.lock();
            if (tileOverlay != null) {
                try {
                    if (this.G == tileOverlay) {
                        tileOverlay.b();
                        tileOverlay.a = null;
                        if (this.f35768i != null) {
                            this.f35768i.f(false);
                        }
                    }
                } finally {
                    this.G = null;
                    this.J.unlock();
                }
            }
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, heatMap) == null) || heatMap == null) {
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
                this.H.a = null;
                this.f35768i.o();
            }
            this.H = heatMap;
            heatMap.a = this;
            this.f35768i.o(true);
        } finally {
            this.I.unlock();
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, overlayOptions)) == null) {
            if (overlayOptions == null) {
                return null;
            }
            Overlay a = overlayOptions.a();
            a.listener = this.o;
            if (a instanceof Marker) {
                Marker marker = (Marker) a;
                marker.w = this.p;
                ArrayList<BitmapDescriptor> arrayList = marker.o;
                if (arrayList != null && arrayList.size() != 0) {
                    this.l.add(marker);
                    com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
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
            a.a(bundle);
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f35768i;
            if (eVar2 != null) {
                eVar2.b(bundle);
            }
            this.f35770k.add(a);
            return a;
        }
        return (Overlay) invokeL.objValue;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
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
                    Overlay a = overlayOptions.a();
                    a.listener = this.o;
                    if (a instanceof Marker) {
                        Marker marker = (Marker) a;
                        marker.w = this.p;
                        ArrayList<BitmapDescriptor> arrayList2 = marker.o;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            this.l.add(marker);
                            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
                            if (eVar != null) {
                                eVar.b(true);
                            }
                        }
                        this.m.add(marker);
                    }
                    this.f35770k.add(a);
                    arrayList.add(a);
                    a.a(bundle);
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
                com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f35768i;
                if (eVar2 != null) {
                    eVar2.a(arrayList3);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tileOverlayOptions)) == null) {
            if (tileOverlayOptions == null) {
                return null;
            }
            TileOverlay tileOverlay = this.G;
            if (tileOverlay != null) {
                tileOverlay.b();
                this.G.a = null;
            }
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null || !eVar.a(tileOverlayOptions.a())) {
                return null;
            }
            TileOverlay a = tileOverlayOptions.a(this);
            this.G = a;
            return a;
        }
        return (TileOverlay) invokeL.objValue;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mapStatusUpdate) == null) {
            animateMapStatus(mapStatusUpdate, 300);
        }
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapStatusUpdate, i2) == null) || mapStatusUpdate == null || i2 <= 0) {
            return;
        }
        ab a = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
        if (eVar == null) {
            return;
        }
        mapStatusReason |= 256;
        if (this.S) {
            eVar.a(a, i2);
        } else {
            eVar.a(a);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return false;
            }
            return eVar.e();
        }
        return invokeV.booleanValue;
    }

    public void changeLocationLayerOrder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f35768i.d(z);
        }
    }

    public final void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f35770k.clear();
            this.l.clear();
            this.m.clear();
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar != null) {
                eVar.b(false);
                this.f35768i.n();
            }
            hideInfoWindow();
        }
    }

    public List<InfoWindow> getAllInfoWindows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : (List) invokeV.objValue;
    }

    public final Point getCompassPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar != null) {
                return a(eVar.h());
            }
            return null;
        }
        return (Point) invokeV.objValue;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f35768i.p() : (MapBaseIndoorMapInfo) invokeV.objValue;
    }

    public final MyLocationConfiguration getLocationConfigeration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? getLocationConfiguration() : (MyLocationConfiguration) invokeV.objValue;
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.O : (MyLocationConfiguration) invokeV.objValue;
    }

    public final MyLocationData getLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.N : (MyLocationData) invokeV.objValue;
    }

    public final MapStatus getMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return null;
            }
            return MapStatus.a(eVar.E());
        }
        return (MapStatus) invokeV.objValue;
    }

    public final LatLngBounds getMapStatusLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return null;
            }
            return eVar.F();
        }
        return (LatLngBounds) invokeV.objValue;
    }

    public final int getMapType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return 1;
            }
            if (eVar.l()) {
                return this.f35768i.k() ? 2 : 1;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, latLngBounds)) == null) {
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
        return (List) invokeL.objValue;
    }

    public final float getMaxZoomLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return 0.0f;
            }
            return eVar.a;
        }
        return invokeV.floatValue;
    }

    public final float getMinZoomLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return 0.0f;
            }
            return eVar.f36433b;
        }
        return invokeV.floatValue;
    }

    public final Projection getProjection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f35765f : (Projection) invokeV.objValue;
    }

    public float[] getProjectionMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return null;
            }
            return eVar.N();
        }
        return (float[]) invokeV.objValue;
    }

    public final UiSettings getUiSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f35766g : (UiSettings) invokeV.objValue;
    }

    public float[] getViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return null;
            }
            return eVar.O();
        }
        return (float[]) invokeV.objValue;
    }

    public float getZoomToBound(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return 0.0f;
            }
            return eVar.a(i2, i3, i4, i5, i6, i7);
        }
        return invokeCommon.floatValue;
    }

    public com.baidu.mapsdkplatform.comapi.map.j getmGLMapView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f35767h : (com.baidu.mapsdkplatform.comapi.map.j) invokeV.objValue;
    }

    public void hideInfoWindow() {
        View view;
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            Collection<InfoWindow> values = this.K.values();
            if (!values.isEmpty()) {
                for (InfoWindow infoWindow : values) {
                    if (infoWindow != null && (view = infoWindow.f35837b) != null) {
                        int i2 = f.f36021b[this.f35764d.ordinal()];
                        if (i2 == 1) {
                            TextureMapView textureMapView = this.f35762b;
                            if (textureMapView != null) {
                                textureMapView.removeView(view);
                            }
                        } else if (i2 == 2 && (mapView = this.a) != null) {
                            mapView.removeView(view);
                        }
                    }
                }
            }
            for (Overlay overlay : this.f35770k) {
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
    }

    public void hideInfoWindow(InfoWindow infoWindow) {
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, infoWindow) == null) {
            Set<InfoWindow> keySet = this.L.keySet();
            if (infoWindow == null || keySet.isEmpty() || !keySet.contains(infoWindow)) {
                return;
            }
            View view = infoWindow.f35837b;
            if (view != null) {
                int i2 = f.f36021b[this.f35764d.ordinal()];
                if (i2 == 1) {
                    TextureMapView textureMapView = this.f35762b;
                    if (textureMapView != null) {
                        textureMapView.removeView(view);
                    }
                } else if (i2 == 2 && (mapView = this.a) != null) {
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
    }

    public void hideSDKLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f35768i.c();
        }
    }

    public final boolean isBaiduHeatMapEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return false;
            }
            return eVar.i();
        }
        return invokeV.booleanValue;
    }

    public boolean isBaseIndoorMapMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f35768i.q() : invokeV.booleanValue;
    }

    public final boolean isBuildingsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return false;
            }
            return eVar.m();
        }
        return invokeV.booleanValue;
    }

    public final boolean isMyLocationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return false;
            }
            return eVar.s();
        }
        return invokeV.booleanValue;
    }

    public final boolean isSupportBaiduHeatMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return false;
            }
            return eVar.j();
        }
        return invokeV.booleanValue;
    }

    public final boolean isTrafficEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            if (eVar == null) {
                return false;
            }
            return eVar.g();
        }
        return invokeV.booleanValue;
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, onMarkerClickListener) == null) && this.x.contains(onMarkerClickListener)) {
            this.x.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048616, this, z) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.h(z);
    }

    public final void setBuildingsEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048617, this, z) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.j(z);
    }

    public void setCompassEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.f35768i.e(z);
        }
    }

    public void setCompassIcon(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bitmap) == null) {
            if (bitmap == null) {
                throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
            }
            this.f35768i.a(bitmap);
        }
    }

    public void setCompassPosition(Point point) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, point) == null) && this.f35768i.a(point)) {
            this.T = point;
        }
    }

    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048621, this, str, str2, str3, str4)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                    this.f35768i.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
                    return true;
                }
                return true;
            } else if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
                this.f35768i.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void setIndoorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
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
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, mapStatusUpdate) == null) || mapStatusUpdate == null) {
            return;
        }
        ab a = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
        if (eVar == null) {
            return;
        }
        eVar.a(a);
        OnMapStatusChangeListener onMapStatusChangeListener = this.q;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, latLngBounds) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i2) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        if (i2 == 1) {
            eVar.a(false);
            this.f35768i.u(this.P);
            this.f35768i.v(this.Q);
            this.f35768i.g(true);
            this.f35768i.l(this.R);
        } else if (i2 == 2) {
            eVar.a(true);
            this.f35768i.u(this.P);
            this.f35768i.v(this.Q);
            this.f35768i.g(true);
        } else if (i2 == 3) {
            if (eVar.C()) {
                this.f35768i.u(false);
            }
            if (this.f35768i.D()) {
                this.f35768i.v(false);
            }
            this.f35768i.g(false);
            this.f35768i.l(false);
        }
        com.baidu.mapsdkplatform.comapi.map.j jVar = this.f35767h;
        if (jVar != null) {
            jVar.a(i2);
        }
    }

    public final void setMaxAndMinZoomLevel(float f2, float f3) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 > 21.0f || f3 < 4.0f || f2 < f3 || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.a(f2, f3);
    }

    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, myLocationConfiguration) == null) {
            setMyLocationConfiguration(myLocationConfiguration);
        }
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, myLocationConfiguration) == null) {
            this.O = myLocationConfiguration;
            a(this.N, myLocationConfiguration);
        }
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, myLocationData) == null) {
            this.N = myLocationData;
            if (this.O == null) {
                this.O = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
            }
            a(myLocationData, this.O);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.n(z);
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onBaseIndoorMapListener) == null) {
            this.D = onBaseIndoorMapListener;
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, onMapClickListener) == null) {
            this.s = onMapClickListener;
        }
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onMapDoubleClickListener) == null) {
            this.v = onMapDoubleClickListener;
        }
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, onMapDrawFrameCallback) == null) {
            this.C = onMapDrawFrameCallback;
        }
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onMapLoadedCallback) == null) {
            this.t = onMapLoadedCallback;
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, onMapLongClickListener) == null) {
            this.w = onMapLongClickListener;
        }
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, onMapRenderCallback) == null) {
            this.u = onMapRenderCallback;
        }
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener onMapRenderValidDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onMapRenderValidDataListener) == null) {
            this.E = onMapRenderValidDataListener;
        }
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onMapStatusChangeListener) == null) {
            this.q = onMapStatusChangeListener;
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onMapTouchListener) == null) {
            this.r = onMapTouchListener;
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048641, this, onMarkerClickListener) == null) || onMarkerClickListener == null || this.x.contains(onMarkerClickListener)) {
            return;
        }
        this.x.add(onMarkerClickListener);
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onMarkerDragListener) == null) {
            this.z = onMarkerDragListener;
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, onMyLocationClickListener) == null) {
            this.A = onMyLocationClickListener;
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, onPolylineClickListener) == null) || onPolylineClickListener == null) {
            return;
        }
        this.y.add(onPolylineClickListener);
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, onSynchronizationListener) == null) {
            this.F = onSynchronizationListener;
        }
    }

    public void setOverlayUnderPoi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.f35768i.c(z);
        }
    }

    @Deprecated
    public final void setPadding(int i2, int i3, int i4, int i5) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        ViewGroup viewGroup;
        MapView mapView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048647, this, i2, i3, i4, i5) == null) || i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.E();
        int i6 = f.f36021b[this.f35764d.ordinal()];
        if (i6 == 1) {
            TextureMapView textureMapView = this.f35762b;
            if (textureMapView == null) {
                return;
            }
            float width = ((textureMapView.getWidth() - i2) - i4) / this.f35762b.getWidth();
            float height = ((this.f35762b.getHeight() - i3) - i5) / this.f35762b.getHeight();
            MapStatusUpdate newMapStatus = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.f35762b.getWidth() + i2) - i4) / 2, ((this.f35762b.getHeight() + i3) - i5) / 2)).build());
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f35768i;
            Point point = this.T;
            eVar2.a(new Point((int) (i2 + (point.x * width)), (int) (i3 + (point.y * height))));
            setMapStatus(newMapStatus);
            this.f35762b.setPadding(i2, i3, i4, i5);
            viewGroup = this.f35762b;
        } else if (i6 != 2 || (mapView = this.a) == null) {
            return;
        } else {
            float width2 = ((mapView.getWidth() - i2) - i4) / this.a.getWidth();
            float height2 = ((this.a.getHeight() - i3) - i5) / this.a.getHeight();
            MapStatusUpdate newMapStatus2 = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.a.getWidth() + i2) - i4) / 2, ((this.a.getHeight() + i3) - i5) / 2)).build());
            com.baidu.mapsdkplatform.comapi.map.e eVar3 = this.f35768i;
            Point point2 = this.T;
            eVar3.a(new Point((int) (i2 + (point2.x * width2)), (int) (i3 + (point2.y * height2))));
            setMapStatus(newMapStatus2);
            this.a.setPadding(i2, i3, i4, i5);
            viewGroup = this.a;
        }
        viewGroup.invalidate();
    }

    public void setPixelFormatTransparent(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048648, this, z) == null) || (jVar = this.f35767h) == null) {
            return;
        }
        if (z) {
            jVar.d();
        } else {
            jVar.e();
        }
    }

    public final void setTrafficEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048649, this, z) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.i(z);
    }

    public final void setViewPadding(int i2, int i3, int i4, int i5) {
        ViewGroup viewGroup;
        MapView mapView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048650, this, i2, i3, i4, i5) == null) || i2 < 0 || i3 < 0 || i4 < 0 || i5 < 0 || this.f35768i == null) {
            return;
        }
        int i6 = f.f36021b[this.f35764d.ordinal()];
        if (i6 == 1) {
            TextureMapView textureMapView = this.f35762b;
            if (textureMapView == null) {
                return;
            }
            float width = ((textureMapView.getWidth() - i2) - i4) / this.f35762b.getWidth();
            float height = ((this.f35762b.getHeight() - i3) - i5) / this.f35762b.getHeight();
            com.baidu.mapsdkplatform.comapi.map.e eVar = this.f35768i;
            Point point = this.T;
            eVar.a(new Point((int) (i2 + (point.x * width)), (int) (i3 + (point.y * height))));
            this.f35762b.setPadding(i2, i3, i4, i5);
            viewGroup = this.f35762b;
        } else if (i6 != 2 || (mapView = this.a) == null) {
            return;
        } else {
            float width2 = ((mapView.getWidth() - i2) - i4) / this.a.getWidth();
            float height2 = ((this.a.getHeight() - i3) - i5) / this.a.getHeight();
            com.baidu.mapsdkplatform.comapi.map.e eVar2 = this.f35768i;
            Point point2 = this.T;
            eVar2.a(new Point((int) (i2 + (point2.x * width2)), (int) (i3 + (point2.y * height2))));
            this.a.setPadding(i2, i3, i4, i5);
            viewGroup = this.a;
        }
        viewGroup.invalidate();
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, infoWindow) == null) {
            showInfoWindow(infoWindow, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void showInfoWindow(InfoWindow infoWindow, boolean z) {
        boolean z2;
        Overlay a;
        Bundle bundle;
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048652, this, infoWindow, z) == null) {
            Set<InfoWindow> keySet = this.L.keySet();
            if (infoWindow == null || keySet.contains(infoWindow)) {
                return;
            }
            if (z) {
                hideInfoWindow();
            }
            infoWindow.f35840e = this.p;
            View view = infoWindow.f35837b;
            if (view != null && infoWindow.f35845j) {
                view.destroyDrawingCache();
                MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.f35838c).yOffset(infoWindow.f35841f).build();
                int i2 = f.f36021b[this.f35764d.ordinal()];
                if (i2 == 1) {
                    TextureMapView textureMapView = this.f35762b;
                    if (textureMapView != null) {
                        textureMapView.addView(view, build);
                    }
                } else if (i2 == 2 && this.f35767h != null) {
                    this.a.addView(view, build);
                }
                if (infoWindow.f35844i) {
                    z2 = false;
                    a = new MarkerOptions().perspective(false).icon(b(infoWindow)).position(infoWindow.f35838c).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.f35841f).infoWindow(infoWindow).a();
                    a.listener = this.o;
                    a.type = com.baidu.mapsdkplatform.comapi.map.h.f36446b;
                    bundle = new Bundle();
                    a.a(bundle);
                    if (infoWindow.f35837b == null) {
                        bundle.putInt("draw_with_view", 1);
                    } else {
                        bundle.putInt("draw_with_view", 0);
                    }
                    eVar = this.f35768i;
                    if (eVar != null && z2) {
                        eVar.b(bundle);
                        this.f35770k.add(a);
                    }
                    Marker marker = (Marker) a;
                    marker.w = this.p;
                    this.K.put(marker.y, infoWindow);
                    this.L.put(infoWindow, marker);
                    this.n.add(infoWindow);
                }
            }
            z2 = true;
            a = new MarkerOptions().perspective(false).icon(b(infoWindow)).position(infoWindow.f35838c).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.f35841f).infoWindow(infoWindow).a();
            a.listener = this.o;
            a.type = com.baidu.mapsdkplatform.comapi.map.h.f36446b;
            bundle = new Bundle();
            a.a(bundle);
            if (infoWindow.f35837b == null) {
            }
            eVar = this.f35768i;
            if (eVar != null) {
                eVar.b(bundle);
                this.f35770k.add(a);
            }
            Marker marker2 = (Marker) a;
            marker2.w = this.p;
            this.K.put(marker2.y, infoWindow);
            this.L.put(infoWindow, marker2);
            this.n.add(infoWindow);
        }
    }

    public void showInfoWindows(List<InfoWindow> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048653, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        for (InfoWindow infoWindow : list) {
            showInfoWindow(infoWindow, false);
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048654, this, z) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.v(z);
        this.Q = z;
    }

    public final void showMapPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048655, this, z) == null) || (eVar = this.f35768i) == null) {
            return;
        }
        eVar.u(z);
        this.P = z;
    }

    public void showSDKLayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.f35768i.d();
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, snapshotReadyCallback) == null) {
            this.B = snapshotReadyCallback;
            int i2 = f.f36021b[this.f35764d.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (jVar = this.f35767h) != null) {
                    jVar.a("anything", (Rect) null);
                    return;
                }
                return;
            }
            ac acVar = this.f35769j;
            if (acVar != null) {
                acVar.a("anything", null);
            }
        }
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        com.baidu.mapsdkplatform.comapi.map.j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, rect, snapshotReadyCallback) == null) {
            this.B = snapshotReadyCallback;
            int i2 = f.f36021b[this.f35764d.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && (jVar = this.f35767h) != null) {
                    jVar.a("anything", rect);
                    return;
                }
                return;
            }
            ac acVar = this.f35769j;
            if (acVar != null) {
                acVar.a("anything", rect);
            }
        }
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048659, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
            }
            MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
            if (focusedBaseIndoorMapInfo == null) {
                return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            }
            if (str2.equals(focusedBaseIndoorMapInfo.a)) {
                ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
                return (floors == null || !floors.contains(str)) ? MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW : this.f35768i.a(str, str2) ? MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK : MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            }
            return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
        }
        return (MapBaseIndoorMapInfo.SwitchFloorError) invokeLL.objValue;
    }
}
