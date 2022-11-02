package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.OverlayLocationData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final float REAL_MAX_ZOOM_LEVEL = 21.0f;
    public static final float REAL_MIN_ZOOM_LEVEL = 4.0f;
    public static final String e = "BaiduMap";
    public static int mapStatusReason = 256;
    public transient /* synthetic */ FieldHolder $fh;
    public CopyOnWriteArrayList<OnMultiPointClickListener> A;
    public OnMarkerDragListener B;
    public OnMyLocationClickListener C;
    public SnapshotReadyCallback D;
    public OnMapDrawFrameCallback E;
    public OnBaseIndoorMapListener F;
    public OnMapRenderValidDataListener G;
    public OnHeatMapDrawFrameCallBack H;
    public OnSynchronizationListener I;
    public TileOverlay J;
    public HeatMap K;
    public Lock L;
    public Lock M;
    public Map<String, InfoWindow> N;
    public Map<InfoWindow, Marker> O;
    public Marker P;
    public MyLocationData Q;
    public MyLocationConfiguration R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public Point W;
    public volatile boolean X;
    public com.baidu.mapsdkplatform.comapi.map.a.c Y;
    public MapView a;
    public TextureMapView b;
    public WearMapView c;
    public com.baidu.mapsdkplatform.comapi.map.w d;
    public Projection f;
    public UiSettings g;
    public MapSurfaceView h;
    public MapTextureView i;
    public com.baidu.mapsdkplatform.comapi.map.d j;
    public List<Overlay> k;
    public List<Marker> l;
    public List<Marker> m;
    public List<InfoWindow> n;
    public Overlay.a o;
    public InfoWindow.a p;
    public OnMapStatusChangeListener q;
    public OnMapTouchListener r;
    public onMapGestureListener s;
    public OnMapClickListener t;
    public OnMapLoadedCallback u;
    public OnMapRenderCallback v;
    public OnMapDoubleClickListener w;
    public OnMapLongClickListener x;
    public CopyOnWriteArrayList<OnMarkerClickListener> y;
    public CopyOnWriteArrayList<OnPolylineClickListener> z;

    /* loaded from: classes2.dex */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* loaded from: classes2.dex */
    public interface OnHeatMapDrawFrameCallBack {
        void frameIndex(int i);
    }

    /* loaded from: classes2.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        void onMapPoiClick(MapPoi mapPoi);
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
        void onMapRenderValidData(boolean z, int i, String str);
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
    public interface OnMultiPointClickListener {
        boolean onMultiPointClick(MultiPoint multiPoint, MultiPointItem multiPointItem);
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

    /* loaded from: classes2.dex */
    public interface onMapGestureListener {
        boolean onMapDoubleTouch(Point point, MapStatus mapStatus);

        boolean onMapFling(MotionEvent motionEvent, float f, float f2, MapStatus mapStatus);

        boolean onMapKneading(Point point, Point point2, MapStatus mapStatus);

        boolean onMapOverLooking(Point point, Point point2, MapStatus mapStatus);

        boolean onMapScroll(Point point, Point point2, MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        boolean onMapTwoClick(Point point, Point point2, MapStatus mapStatus);
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

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, this, i)) == null) {
            if (i != 0) {
                switch (i) {
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

    public final void setMapLanguage(MapLanguage mapLanguage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, mapLanguage) == null) {
        }
    }

    public BaiduMap(Context context, MapSurfaceView mapSurfaceView, com.baidu.mapsdkplatform.comapi.map.v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mapSurfaceView, vVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.y = new CopyOnWriteArrayList<>();
        this.z = new CopyOnWriteArrayList<>();
        this.A = new CopyOnWriteArrayList<>();
        this.L = new ReentrantLock();
        this.M = new ReentrantLock();
        this.X = false;
        this.h = mapSurfaceView;
        com.baidu.mapsdkplatform.comapi.map.d dVar = new com.baidu.mapsdkplatform.comapi.map.d(context, mapSurfaceView, vVar, (String) null, 0);
        this.j = dVar;
        mapSurfaceView.setBaseMap(dVar);
        this.d = com.baidu.mapsdkplatform.comapi.map.w.a;
        d();
    }

    public BaiduMap(Context context, MapTextureView mapTextureView, com.baidu.mapsdkplatform.comapi.map.v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mapTextureView, vVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.y = new CopyOnWriteArrayList<>();
        this.z = new CopyOnWriteArrayList<>();
        this.A = new CopyOnWriteArrayList<>();
        this.L = new ReentrantLock();
        this.M = new ReentrantLock();
        this.X = false;
        this.i = mapTextureView;
        com.baidu.mapsdkplatform.comapi.map.d dVar = new com.baidu.mapsdkplatform.comapi.map.d(context, mapTextureView, vVar, (String) null, 0);
        this.j = dVar;
        mapTextureView.setBaseMap(dVar);
        this.d = com.baidu.mapsdkplatform.comapi.map.w.b;
        d();
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapStatusUpdate) == null) {
            animateMapStatus(mapStatusUpdate, 300);
        }
    }

    public void changeLocationLayerOrder(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048588, this, z) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.f(z);
    }

    public void cleanCache(int i) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.a(i);
    }

    public LatLngBounds getOverlayLatLngBounds(OverlayOptions overlayOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, overlayOptions)) == null) {
            if (overlayOptions != null && this.j != null) {
                Overlay a = overlayOptions.a();
                Bundle bundle = new Bundle();
                a.a(bundle);
                return this.j.b(bundle);
            }
            return null;
        }
        return (LatLngBounds) invokeL.objValue;
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, onMarkerClickListener) == null) && this.y.contains(onMarkerClickListener)) {
            this.y.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z) == null) && (dVar = this.j) != null) {
            dVar.k(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048631, this, z) == null) && (dVar = this.j) != null) {
            dVar.m(z);
        }
    }

    public void setCompassEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048632, this, z) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.h(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bitmap) == null) {
            if (bitmap != null) {
                com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
                if (dVar == null) {
                    return;
                }
                dVar.a(bitmap);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
        }
    }

    public void setCompassPosition(Point point) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048634, this, point) != null) || this.j == null) {
            return;
        }
        if (this.j.a(new Point(point.x, point.y))) {
            this.W = point;
        }
    }

    public void setDEMEnable(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048636, this, z) == null) && (dVar = this.j) != null) {
            dVar.b(z);
        }
    }

    public final void setFontSizeLevel(int i) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048637, this, i) == null) && (dVar = this.j) != null) {
            dVar.c(i);
        }
    }

    public void setHeatMapFrameAnimationIndex(int i) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048638, this, i) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.b(i);
    }

    public final void setIndoorEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar != null) {
                this.U = z;
                dVar.o(z);
            }
            OnBaseIndoorMapListener onBaseIndoorMapListener = this.F;
            if (onBaseIndoorMapListener != null && !z) {
                onBaseIndoorMapListener.onBaseIndoorMapMode(false, null);
            }
        }
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048642, this, mapStatusUpdate) != null) || mapStatusUpdate == null) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.x a = a(mapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
        if (dVar == null) {
            return;
        }
        mapStatusReason |= 256;
        dVar.B(true);
        this.j.a(a);
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048643, this, latLngBounds) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    @Deprecated
    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, myLocationConfiguration) == null) {
            setMyLocationConfiguration(myLocationConfiguration);
        }
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, myLocationConfiguration) == null) {
            this.R = myLocationConfiguration;
            a(this.Q, myLocationConfiguration);
        }
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, myLocationData) == null) {
            this.Q = myLocationData;
            if (this.R == null) {
                this.R = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
            }
            a(myLocationData, this.R);
        }
    }

    public final void setMyLocationEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048649, this, z) == null) && (dVar = this.j) != null) {
            dVar.q(z);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, onBaseIndoorMapListener) == null) {
            this.F = onBaseIndoorMapListener;
        }
    }

    public void setOnHeatMapDrawFrameCallBack(OnHeatMapDrawFrameCallBack onHeatMapDrawFrameCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, onHeatMapDrawFrameCallBack) == null) {
            this.H = onHeatMapDrawFrameCallBack;
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, onMapClickListener) == null) {
            this.t = onMapClickListener;
        }
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, onMapDoubleClickListener) == null) {
            this.w = onMapDoubleClickListener;
        }
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, onMapDrawFrameCallback) == null) {
            this.E = onMapDrawFrameCallback;
        }
    }

    public final void setOnMapGestureListener(onMapGestureListener onmapgesturelistener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, onmapgesturelistener) == null) {
            this.s = onmapgesturelistener;
        }
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, onMapLoadedCallback) == null) {
            this.u = onMapLoadedCallback;
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, onMapLongClickListener) == null) {
            this.x = onMapLongClickListener;
        }
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, onMapRenderCallback) == null) {
            this.v = onMapRenderCallback;
        }
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener onMapRenderValidDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, onMapRenderValidDataListener) == null) {
            this.G = onMapRenderValidDataListener;
        }
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, onMapStatusChangeListener) == null) {
            this.q = onMapStatusChangeListener;
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, onMapTouchListener) == null) {
            this.r = onMapTouchListener;
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, onMarkerClickListener) == null) && onMarkerClickListener != null && !this.y.contains(onMarkerClickListener)) {
            this.y.add(onMarkerClickListener);
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, onMarkerDragListener) == null) {
            this.B = onMarkerDragListener;
        }
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048664, this, onMultiPointClickListener) == null) && onMultiPointClickListener != null) {
            this.A.add(onMultiPointClickListener);
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, onMyLocationClickListener) == null) {
            this.C = onMyLocationClickListener;
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, onPolylineClickListener) == null) && onPolylineClickListener != null) {
            this.z.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, onSynchronizationListener) == null) {
            this.I = onSynchronizationListener;
        }
    }

    public void setOverlayUnderPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048668, this, z) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.e(z);
    }

    public void setPixelFormatTransparent(boolean z) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048670, this, z) != null) || (mapSurfaceView = this.h) == null) {
            return;
        }
        if (z) {
            mapSurfaceView.setPixelFormatTransparent(true);
        } else {
            mapSurfaceView.setPixelFormatTransparent(false);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048671, this, z) == null) && (dVar = this.j) != null) {
            dVar.l(z);
        }
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, infoWindow) == null) {
            showInfoWindow(infoWindow, true);
        }
    }

    public void showInfoWindows(List<InfoWindow> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, list) == null) && list != null && !list.isEmpty()) {
            for (InfoWindow infoWindow : list) {
                showInfoWindow(infoWindow, false);
            }
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048676, this, z) == null) && (dVar = this.j) != null) {
            dVar.D(z);
            this.T = z;
        }
    }

    public final void showMapPoi(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048677, this, z) == null) && (dVar = this.j) != null) {
            dVar.C(z);
            this.S = z;
        }
    }

    public void showOperateLayer(boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048678, this, z) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.d(z);
    }

    public boolean switchOverlayLayerAndNavigationLayer(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048686, this, z)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.g(z);
        }
        return invokeZ.booleanValue;
    }

    private Point a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
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
        return (Point) invokeL.objValue;
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, overlayOptions)) == null) {
            if (overlayOptions != null && !this.X) {
                Overlay a = overlayOptions.a();
                a.listener = this.o;
                if (a instanceof Marker) {
                    Marker marker = (Marker) a;
                    marker.A = this.p;
                    ArrayList<BitmapDescriptor> arrayList = marker.s;
                    if (arrayList != null && arrayList.size() != 0) {
                        this.l.add(marker);
                        com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
                        if (dVar != null) {
                            dVar.c(true);
                        }
                    }
                    this.m.add(marker);
                    InfoWindow infoWindow = marker.z;
                    if (infoWindow != null) {
                        showInfoWindow(infoWindow, false);
                    }
                }
                Bundle bundle = new Bundle();
                a.a(bundle);
                if (this.j != null && !this.X) {
                    this.j.c(bundle);
                }
                this.k.add(a);
                return a;
            }
            return null;
        }
        return (Overlay) invokeL.objValue;
    }

    public void hideInfoWindow(InfoWindow infoWindow) {
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, infoWindow) == null) {
            Set<InfoWindow> keySet = this.O.keySet();
            if (infoWindow != null && !keySet.isEmpty() && keySet.contains(infoWindow)) {
                View view2 = infoWindow.c;
                if (view2 != null) {
                    int i = b.b[this.d.ordinal()];
                    if (i != 1) {
                        if (i == 2 && (mapView = this.a) != null) {
                            mapView.removeView(view2);
                        }
                    } else {
                        TextureMapView textureMapView = this.b;
                        if (textureMapView != null) {
                            textureMapView.removeView(view2);
                        }
                    }
                }
                Marker marker = this.O.get(infoWindow);
                if (marker != null) {
                    marker.remove();
                    this.N.remove(marker.F);
                }
                this.O.remove(infoWindow);
                this.n.remove(infoWindow);
            }
        }
    }

    public final void setMapType(int i) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048644, this, i) != null) || (dVar = this.j) == null) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (dVar.B()) {
                        this.j.C(false);
                    }
                    if (this.j.C()) {
                        this.j.D(false);
                    }
                    this.j.j(false);
                    this.j.o(false);
                }
            } else {
                dVar.a(true);
                this.j.C(this.S);
                this.j.D(this.T);
                this.j.j(true);
            }
        } else {
            dVar.a(false);
            this.j.C(this.S);
            this.j.D(this.T);
            this.j.j(true);
            this.j.o(this.U);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b a = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
            a.a("BasicMap setMapType type = " + i);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, snapshotReadyCallback) == null) {
            this.D = snapshotReadyCallback;
            int i = b.b[this.d.ordinal()];
            if (i != 1) {
                if (i == 2 && (mapSurfaceView = this.h) != null && mapSurfaceView.getController() != null) {
                    this.h.doCaptureMapView(new i(this), this.h.getController().getScreenWidth(), this.h.getController().getScreenHeight(), Bitmap.Config.ARGB_8888);
                    this.h.requestRender();
                    return;
                }
                return;
            }
            MapTextureView mapTextureView = this.i;
            if (mapTextureView != null && mapTextureView.getController() != null) {
                this.i.doCaptureMapView(new h(this), this.i.getController().getScreenWidth(), this.i.getController().getScreenHeight(), Bitmap.Config.ARGB_8888);
                this.i.requestRender();
            }
        }
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, mapStatusUpdate, i) == null) && mapStatusUpdate != null && i > 0) {
            com.baidu.mapsdkplatform.comapi.map.x a = a(mapStatusUpdate);
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return;
            }
            mapStatusReason |= 256;
            if (!this.V) {
                dVar.a(a);
            } else {
                dVar.a(a, i);
            }
        }
    }

    public void setLayerClickable(MapLayer mapLayer, boolean z) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048640, this, mapLayer, z) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.a(mapLayer, z);
    }

    public void switchLayerOrder(MapLayer mapLayer, MapLayer mapLayer2) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048685, this, mapLayer, mapLayer2) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.a(mapLayer, mapLayer2);
    }

    private com.baidu.mapsdkplatform.comapi.map.x a(MapStatusUpdate mapStatusUpdate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, mapStatusUpdate)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return null;
            }
            com.baidu.mapsdkplatform.comapi.map.x D = dVar.D();
            MapStatus a = mapStatusUpdate.a(this.j, getMapStatus());
            if (a == null) {
                return null;
            }
            return a.b(D);
        }
        return (com.baidu.mapsdkplatform.comapi.map.x) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(InfoWindow infoWindow) {
        boolean z;
        Marker marker;
        MapView mapView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, this, infoWindow) == null) && infoWindow != null && !this.X) {
            Set<InfoWindow> keySet = this.O.keySet();
            if (!keySet.isEmpty() && keySet.contains(infoWindow)) {
                View view2 = infoWindow.c;
                if (view2 != null && infoWindow.k) {
                    view2.destroyDrawingCache();
                    MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.d).yOffset(infoWindow.g).build();
                    int i = b.b[this.d.ordinal()];
                    if (i != 1) {
                        if (i == 2 && (mapView = this.a) != null) {
                            mapView.addView(view2, build);
                        }
                    } else {
                        TextureMapView textureMapView = this.b;
                        if (textureMapView != null) {
                            textureMapView.addView(view2, build);
                            view2.setLayoutParams(build);
                        }
                    }
                    if (infoWindow.j) {
                        z = false;
                        BitmapDescriptor b = b(infoWindow);
                        marker = this.O.get(infoWindow);
                        if (marker == null) {
                            Bundle bundle = new Bundle();
                            if (infoWindow.b != null) {
                                marker.type = com.baidu.mapsdkplatform.comapi.map.i.b;
                                marker.b = b;
                                if (infoWindow.c != null) {
                                    bundle.putInt("draw_with_view", 1);
                                } else {
                                    bundle.putInt("draw_with_view", 0);
                                }
                            }
                            marker.a = infoWindow.d;
                            marker.i = infoWindow.g;
                            marker.a(bundle);
                            if (this.j != null && z && !this.X) {
                                this.j.e(bundle);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z = true;
                BitmapDescriptor b2 = b(infoWindow);
                marker = this.O.get(infoWindow);
                if (marker == null) {
                }
            } else {
                showInfoWindow(infoWindow, false);
            }
        }
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list == null || this.X) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i2 = size / 400;
            for (int i3 = 0; i3 < i2 + 1; i3++) {
                if (i2 == 0) {
                    i = size;
                } else if (i3 == i2) {
                    i = size - (i2 * 400);
                } else {
                    i = 400;
                }
                Bundle[] bundleArr = new Bundle[i];
                for (int i4 = 0; i4 < 400; i4++) {
                    int i5 = (i3 * 400) + i4;
                    if (i5 >= size) {
                        break;
                    } else if (this.X) {
                        return null;
                    } else {
                        OverlayOptions overlayOptions = list.get(i5);
                        if (overlayOptions != null) {
                            Bundle bundle = new Bundle();
                            Overlay a = overlayOptions.a();
                            a.listener = this.o;
                            if (a instanceof Marker) {
                                Marker marker = (Marker) a;
                                marker.A = this.p;
                                ArrayList<BitmapDescriptor> arrayList2 = marker.s;
                                if (arrayList2 != null && arrayList2.size() != 0) {
                                    this.l.add(marker);
                                    com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
                                    if (dVar != null) {
                                        dVar.c(true);
                                    }
                                }
                                this.m.add(marker);
                            }
                            this.k.add(a);
                            arrayList.add(a);
                            a.a(bundle);
                            com.baidu.mapsdkplatform.comapi.map.d dVar2 = this.j;
                            if (dVar2 != null) {
                                dVar2.g(bundle);
                                this.j.d(bundle);
                            }
                            bundleArr[i4] = bundle;
                        }
                    }
                }
                com.baidu.mapsdkplatform.comapi.map.d dVar3 = this.j;
                if (dVar3 != null) {
                    dVar3.a(bundleArr);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void removeOverLays(List<Overlay> list) {
        int i;
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, list) == null) && list != null && !this.X) {
            int size = list.size();
            int i2 = size / 400;
            for (int i3 = 0; i3 < i2 + 1; i3++) {
                if (i2 == 0) {
                    i = size;
                } else if (i3 == i2) {
                    i = size - (i2 * 400);
                } else {
                    i = 400;
                }
                Bundle[] bundleArr = new Bundle[i];
                for (int i4 = 0; i4 < 400; i4++) {
                    int i5 = (i3 * 400) + i4;
                    if (i5 >= size) {
                        break;
                    } else if (this.X) {
                        return;
                    } else {
                        Overlay overlay = list.get(i5);
                        if (overlay != null) {
                            Bundle a = overlay.a();
                            com.baidu.mapsdkplatform.comapi.map.d dVar2 = this.j;
                            if (dVar2 != null) {
                                dVar2.g(a);
                            }
                            bundleArr[i4] = a;
                            List<Marker> list2 = this.m;
                            if (list2 != null && list2.contains(overlay)) {
                                this.m.remove(overlay);
                            }
                            if (this.l.contains(overlay)) {
                                Marker marker = (Marker) overlay;
                                if (marker.s != null) {
                                    this.l.remove(marker);
                                    if (this.l.size() == 0 && (dVar = this.j) != null) {
                                        dVar.c(false);
                                    }
                                }
                            }
                        }
                    }
                }
                com.baidu.mapsdkplatform.comapi.map.d dVar3 = this.j;
                if (dVar3 != null) {
                    dVar3.b(bundleArr);
                }
            }
            this.k.removeAll(list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
        JSONObject jSONObject;
        BitmapDescriptor bitmapDescriptor;
        BaiduMap baiduMap;
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        int i;
        Bitmap bitmap;
        float f;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, this, myLocationData, myLocationConfiguration) == null) {
            if (myLocationData != null && myLocationConfiguration != null && isMyLocationEnabled()) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                LatLng latLng = new LatLng(myLocationData.latitude, myLocationData.longitude);
                GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
                try {
                    jSONObject2.put("type", 0);
                    jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, ll2mc.getLongitudeE6());
                    jSONObject3.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, ll2mc.getLatitudeE6());
                    jSONObject3.put("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(latLng, (int) myLocationData.accuracy));
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
                    jSONObject3.put("direction", f);
                    jSONObject3.put("iconarrownor", "NormalLocArrow");
                    jSONObject3.put("iconarrownorid", 28);
                    jSONObject3.put("iconarrowfocid", 29);
                    jSONObject3.put("iconarrowfoc", "FocusLocArrow");
                    try {
                        jSONObject3.put("lineid", myLocationConfiguration.accuracyCircleStrokeColor);
                        jSONObject3.put("areaid", myLocationConfiguration.accuracyCircleFillColor);
                        jSONArray2.put(jSONObject3);
                        if (myLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS) {
                            jSONArray = jSONArray2;
                            jSONObject4.put(MapBundleKey.MapObjKey.OBJ_SL_PTX, ll2mc.getLongitudeE6());
                            jSONObject4.put(MapBundleKey.MapObjKey.OBJ_SL_PTY, ll2mc.getLatitudeE6());
                            jSONObject4.put("radius", 0);
                            jSONObject4.put("direction", 0);
                            jSONObject4.put("iconarrownor", "direction_wheel");
                            jSONObject4.put("iconarrowfoc", "direction_wheel");
                            jSONObject4.put("iconarrownorid", 54);
                            jSONObject4.put("iconarrowfocid", 54);
                            jSONArray.put(jSONObject4);
                        } else {
                            jSONArray = jSONArray2;
                        }
                        jSONObject = jSONObject2;
                        try {
                            jSONObject.put("data", jSONArray);
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                            bitmapDescriptor = myLocationConfiguration.customMarker;
                            if (bitmapDescriptor == null) {
                            }
                            baiduMap = this;
                            dVar = baiduMap.j;
                            if (dVar != null) {
                            }
                            i = b.a[myLocationConfiguration.locationMode.ordinal()];
                            if (i == 1) {
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        jSONObject = jSONObject2;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    jSONObject = jSONObject2;
                }
                bitmapDescriptor = myLocationConfiguration.customMarker;
                if (bitmapDescriptor == null && (bitmap = bitmapDescriptor.getBitmap()) != null && !bitmap.isRecycled()) {
                    ArrayList arrayList = new ArrayList();
                    OverlayLocationData overlayLocationData = new OverlayLocationData();
                    overlayLocationData.setImage(bitmap);
                    overlayLocationData.setImgHeight(bitmap.getHeight());
                    overlayLocationData.setImgWidth(bitmap.getWidth());
                    overlayLocationData.setImgName("icon");
                    overlayLocationData.setRotation(myLocationConfiguration.enableDirection ? 1 : 0);
                    arrayList.add(overlayLocationData);
                    baiduMap = this;
                    com.baidu.mapsdkplatform.comapi.map.d dVar2 = baiduMap.j;
                    if (dVar2 != null) {
                        dVar2.a(arrayList);
                    }
                } else {
                    baiduMap = this;
                }
                dVar = baiduMap.j;
                if (dVar != null) {
                    dVar.a(jSONObject.toString(), (Bundle) null);
                }
                i = b.a[myLocationConfiguration.locationMode.ordinal()];
                if (i == 1) {
                    if (i == 2) {
                        baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
                        return;
                    }
                    return;
                }
                baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
            }
        }
    }

    private BitmapDescriptor b(InfoWindow infoWindow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, infoWindow)) == null) {
            View view2 = infoWindow.c;
            if (view2 != null && infoWindow.k) {
                if (infoWindow.h) {
                    if (infoWindow.i <= 0) {
                        infoWindow.i = SysOSUtil.getDensityDpi();
                    }
                    return BitmapDescriptorFactory.fromViewWithDpi(infoWindow.c, infoWindow.i);
                }
                return BitmapDescriptorFactory.fromView(view2);
            }
            return infoWindow.b;
        }
        return (BitmapDescriptor) invokeL.objValue;
    }

    public void a(TileOverlay tileOverlay) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tileOverlay) == null) {
            this.M.lock();
            if (tileOverlay != null) {
                try {
                    if (this.J == tileOverlay) {
                        tileOverlay.b();
                        tileOverlay.a = null;
                        if (this.j != null) {
                            this.j.e();
                        }
                    }
                } finally {
                    this.J = null;
                    this.M.unlock();
                }
            }
        }
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tileOverlayOptions)) == null) {
            if (tileOverlayOptions == null) {
                return null;
            }
            TileOverlay tileOverlay = this.J;
            if (tileOverlay != null) {
                tileOverlay.b();
                this.J.a = null;
            }
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null || !dVar.a(tileOverlayOptions.a())) {
                return null;
            }
            TileOverlay a = tileOverlayOptions.a(this);
            this.J = a;
            return a;
        }
        return (TileOverlay) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            this.X = false;
            this.k = new CopyOnWriteArrayList();
            this.l = new CopyOnWriteArrayList();
            this.m = new CopyOnWriteArrayList();
            this.N = new ConcurrentHashMap();
            this.O = new ConcurrentHashMap();
            this.n = new CopyOnWriteArrayList();
            this.W = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
            this.g = new UiSettings(this.j);
            this.o = new a(this);
            this.p = new c(this);
            this.j.a(new d(this));
            this.j.a(new f(this));
            this.j.a(new g(this));
            this.S = this.j.B();
            this.T = this.j.C();
        }
    }

    public void a() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.v();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.f();
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.X = true;
            com.baidu.mapsdkplatform.comapi.map.a.c cVar = this.Y;
            if (cVar != null) {
                cVar.c();
                this.Y = null;
            }
            hideInfoWindow();
        }
    }

    public List<InfoWindow> getAllInfoWindows() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public final Point getCompassPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar != null) {
                return a(dVar.h());
            }
            return null;
        }
        return (Point) invokeV.objValue;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return null;
            }
            return dVar.r();
        }
        return (MapBaseIndoorMapInfo) invokeV.objValue;
    }

    public final int getFontSizeLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar != null) {
                dVar.G();
                return 1;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public MapSurfaceView getGLMapView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.h;
        }
        return (MapSurfaceView) invokeV.objValue;
    }

    public OnHeatMapDrawFrameCallBack getHeatMapDrawFrameCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.H;
        }
        return (OnHeatMapDrawFrameCallBack) invokeV.objValue;
    }

    @Deprecated
    public final MyLocationConfiguration getLocationConfigeration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return getLocationConfiguration();
        }
        return (MyLocationConfiguration) invokeV.objValue;
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.R;
        }
        return (MyLocationConfiguration) invokeV.objValue;
    }

    public final MyLocationData getLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.Q;
        }
        return (MyLocationData) invokeV.objValue;
    }

    public final String getMapApprovalNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return "";
            }
            return dVar.O();
        }
        return (String) invokeV.objValue;
    }

    public final String getMapCopyrightInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return "";
            }
            return dVar.Q();
        }
        return (String) invokeV.objValue;
    }

    public MapLanguage getMapLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar != null) {
                return MapLanguage.values()[dVar.R()];
            }
            return MapLanguage.CHINESE;
        }
        return (MapLanguage) invokeV.objValue;
    }

    public final String getMapMappingQualificationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return "";
            }
            return dVar.P();
        }
        return (String) invokeV.objValue;
    }

    public final MapStatus getMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return null;
            }
            return MapStatus.a(dVar.D());
        }
        return (MapStatus) invokeV.objValue;
    }

    public final LatLngBounds getMapStatusLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return null;
            }
            return dVar.E();
        }
        return (LatLngBounds) invokeV.objValue;
    }

    public MapTextureView getMapTextureView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.i;
        }
        return (MapTextureView) invokeV.objValue;
    }

    public final int getMapType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return 1;
            }
            if (!dVar.l()) {
                return 3;
            }
            if (!this.j.k()) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public final float getMaxZoomLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return 0.0f;
            }
            return dVar.b();
        }
        return invokeV.floatValue;
    }

    public final float getMinZoomLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return 0.0f;
            }
            return dVar.b;
        }
        return invokeV.floatValue;
    }

    public final Projection getProjection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.f;
        }
        return (Projection) invokeV.objValue;
    }

    public float[] getProjectionMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return null;
            }
            return dVar.M();
        }
        return (float[]) invokeV.objValue;
    }

    public final UiSettings getUiSettings() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.g;
        }
        return (UiSettings) invokeV.objValue;
    }

    public float[] getViewMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return null;
            }
            return dVar.N();
        }
        return (float[]) invokeV.objValue;
    }

    @Deprecated
    public MapSurfaceView getmGLMapView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.h;
        }
        return (MapSurfaceView) invokeV.objValue;
    }

    public void hideSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.c();
    }

    public final boolean isBaiduHeatMapEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.i();
        }
        return invokeV.booleanValue;
    }

    public boolean isBaseIndoorMapMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.s();
        }
        return invokeV.booleanValue;
    }

    public final boolean isBuildingsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.m();
        }
        return invokeV.booleanValue;
    }

    public final boolean isMyLocationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.u();
        }
        return invokeV.booleanValue;
    }

    public final boolean isShowMapPoi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.S;
        }
        return invokeV.booleanValue;
    }

    public final boolean isSupportBaiduHeatMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.j();
        }
        return invokeV.booleanValue;
    }

    public final boolean isTrafficEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return false;
            }
            return dVar.g();
        }
        return invokeV.booleanValue;
    }

    public void showSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048679, this) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.d();
    }

    public void startHeatMapFrameAnimation() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048682, this) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.o();
    }

    public void stopHeatMapFrameAnimation() {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048683, this) != null) || (dVar = this.j) == null) {
            return;
        }
        dVar.p();
    }

    public void a(HeatMap heatMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, heatMap) == null) {
            this.L.lock();
            try {
                if (this.K != null && this.j != null && heatMap == this.K) {
                    this.K.b();
                    this.K.c();
                    this.K.a = null;
                    this.j.q();
                    this.K = null;
                    this.j.r(false);
                }
            } finally {
                this.L.unlock();
            }
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, heatMap) == null) && heatMap != null && this.j != null) {
            this.L.lock();
            try {
                if (heatMap == this.K) {
                    return;
                }
                if (this.K != null) {
                    this.K.b();
                    this.K.c();
                    this.K.a = null;
                    this.j.q();
                }
                this.K = heatMap;
                heatMap.a = this;
                Bundle bundle = heatMap.toBundle();
                this.j.r(true);
                this.j.h(bundle);
            } finally {
                this.L.unlock();
            }
        }
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, latLngBounds)) == null) {
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

    public final TraceOverlay addTraceOverlay(TraceOptions traceOptions, TraceAnimationListener traceAnimationListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, traceOptions, traceAnimationListener)) == null) {
            if (traceOptions == null) {
                return null;
            }
            com.baidu.mapsdkplatform.comapi.map.a.c cVar = this.Y;
            if (cVar == null || cVar.d()) {
                com.baidu.mapsdkplatform.comapi.map.w wVar = this.d;
                if (wVar == com.baidu.mapsdkplatform.comapi.map.w.a) {
                    this.Y = new com.baidu.mapsdkplatform.comapi.map.a.c(this.h);
                } else if (wVar != com.baidu.mapsdkplatform.comapi.map.w.b) {
                    return null;
                } else {
                    this.Y = new com.baidu.mapsdkplatform.comapi.map.a.c(this.i);
                }
                this.Y.a();
            }
            this.Y.a(traceAnimationListener);
            return this.Y.a(traceOptions);
        }
        return (TraceOverlay) invokeLL.objValue;
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        MapSurfaceView mapSurfaceView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048681, this, rect, snapshotReadyCallback) != null) || this.j == null) {
            return;
        }
        this.D = snapshotReadyCallback;
        int i = b.b[this.d.ordinal()];
        if (i != 1) {
            if (i == 2 && (mapSurfaceView = this.h) != null) {
                mapSurfaceView.doCaptureMapView(new k(this), rect, Bitmap.Config.ARGB_8888);
                this.h.requestRender();
                return;
            }
            return;
        }
        MapTextureView mapTextureView = this.i;
        if (mapTextureView != null) {
            mapTextureView.doCaptureMapView(new j(this), rect, Bitmap.Config.ARGB_8888);
            this.i.requestRender();
        }
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048684, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
                if (focusedBaseIndoorMapInfo == null) {
                    return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
                }
                if (!str2.equals(focusedBaseIndoorMapInfo.a)) {
                    return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
                }
                ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
                if (floors != null && floors.contains(str)) {
                    com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
                    if (dVar != null && dVar.a(str, str2)) {
                        return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
                    }
                    return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
                }
                return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW;
            }
            return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
        }
        return (MapBaseIndoorMapInfo.SwitchFloorError) invokeLL.objValue;
    }

    public final void clear() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.X) {
            return;
        }
        this.k.clear();
        this.l.clear();
        this.m.clear();
        com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
        if (dVar != null) {
            dVar.c(false);
            this.j.n();
        }
        hideInfoWindow();
    }

    public float getZoomToBound(int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar == null) {
                return 0.0f;
            }
            return dVar.a(i, i2, i3, i4, i5, i6);
        }
        return invokeCommon.floatValue;
    }

    public void hideInfoWindow() {
        View view2;
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            Collection<InfoWindow> values = this.N.values();
            if (!values.isEmpty()) {
                for (InfoWindow infoWindow : values) {
                    if (infoWindow != null && (view2 = infoWindow.c) != null) {
                        int i = b.b[this.d.ordinal()];
                        if (i != 1) {
                            if (i == 2 && (mapView = this.a) != null) {
                                mapView.removeView(view2);
                            }
                        } else {
                            TextureMapView textureMapView = this.b;
                            if (textureMapView != null) {
                                textureMapView.removeView(view2);
                            }
                        }
                    }
                }
            }
            for (Overlay overlay : this.k) {
                Set<String> keySet = this.N.keySet();
                String str = overlay.F;
                if ((overlay instanceof Marker) && !keySet.isEmpty() && keySet.contains(str)) {
                    overlay.remove();
                }
            }
            this.N.clear();
            this.O.clear();
            this.n.clear();
        }
    }

    @Deprecated
    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048635, this, str, str2, str3, str4)) == null) {
            if (this.j == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
                    this.j.a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
                    return true;
                }
                Log.e(e, "the string of the input customTrafficColor is error");
                return false;
            } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                this.j.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
                return true;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void setViewPadding(int i, int i2, int i3, int i4) {
        MapView mapView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIII(1048672, this, i, i2, i3, i4) != null) || i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || this.j == null) {
            return;
        }
        int i5 = b.b[this.d.ordinal()];
        if (i5 != 1) {
            if (i5 != 2 || (mapView = this.a) == null) {
                return;
            }
            float width = ((mapView.getWidth() - i) - i3) / this.a.getWidth();
            float height = ((this.a.getHeight() - i2) - i4) / this.a.getHeight();
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            Point point = this.W;
            dVar.a(new Point((int) (i + (point.x * width)), (int) (i2 + (point.y * height))));
            this.a.setPadding(i, i2, i3, i4);
            this.a.invalidate();
            return;
        }
        TextureMapView textureMapView = this.b;
        if (textureMapView == null) {
            return;
        }
        float width2 = ((textureMapView.getWidth() - i) - i3) / this.b.getWidth();
        float height2 = ((this.b.getHeight() - i2) - i4) / this.b.getHeight();
        com.baidu.mapsdkplatform.comapi.map.d dVar2 = this.j;
        Point point2 = this.W;
        dVar2.a(new Point((int) (i + (point2.x * width2)), (int) (i2 + (point2.y * height2))));
        this.b.setPadding(i, i2, i3, i4);
        this.b.invalidate();
    }

    public final void setMaxAndMinZoomLevel(float f, float f2) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) && f <= 21.0f && f2 >= 4.0f && f >= f2 && (dVar = this.j) != null) {
            dVar.a(f, f2);
        }
    }

    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048669, this, i, i2, i3, i4) == null) {
            setViewPadding(i, i2, i3, i4);
        }
    }

    public void showInfoWindow(InfoWindow infoWindow, boolean z) {
        boolean z2;
        MapView mapView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048674, this, infoWindow, z) == null) {
            Set<InfoWindow> keySet = this.O.keySet();
            if (infoWindow != null && !keySet.contains(infoWindow) && !this.X) {
                if (z) {
                    hideInfoWindow();
                }
                infoWindow.f = this.p;
                View view2 = infoWindow.c;
                if (view2 != null && infoWindow.k) {
                    view2.destroyDrawingCache();
                    MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.d).yOffset(infoWindow.g).build();
                    int i = b.b[this.d.ordinal()];
                    if (i != 1) {
                        if (i == 2 && (mapView = this.a) != null) {
                            mapView.addView(view2, build);
                        }
                    } else {
                        TextureMapView textureMapView = this.b;
                        if (textureMapView != null) {
                            textureMapView.addView(view2, build);
                        }
                    }
                    z2 = false;
                } else {
                    z2 = true;
                }
                BitmapDescriptor b = b(infoWindow);
                if (b == null) {
                    return;
                }
                Overlay a = new MarkerOptions().perspective(false).icon(b).position(infoWindow.d).zIndex(Integer.MAX_VALUE).yOffset(infoWindow.g).infoWindow(infoWindow).a();
                a.listener = this.o;
                a.type = com.baidu.mapsdkplatform.comapi.map.i.b;
                Bundle bundle = new Bundle();
                a.a(bundle);
                if (infoWindow.c != null) {
                    bundle.putInt("draw_with_view", 1);
                } else {
                    bundle.putInt("draw_with_view", 0);
                }
                if (this.j != null && z2 && !this.X) {
                    this.j.c(bundle);
                    this.k.add(a);
                }
                Marker marker = (Marker) a;
                marker.A = this.p;
                this.N.put(marker.F, infoWindow);
                this.O.put(infoWindow, marker);
                this.n.add(infoWindow);
            }
        }
    }
}
