package com.baidu.platform.comapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.ai;
import com.baidu.platform.comapi.map.f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.searchbox.logsystem.basic.eventhandler.OOMDeviceEventSceneSceneHandler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Statistics;
import com.heytap.mcssdk.constant.MessageConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MapSurfaceView extends aj implements View.OnKeyListener, MapRenderModeChangeListener, MapViewInterface, ak {
    public static /* synthetic */ Interceptable $ic;
    public static final ExecutorService A;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public int B;
    public int C;
    public int D;
    public MapController a;
    public af b;
    public l c;
    public p d;
    public volatile boolean e;
    public boolean f;
    public am g;
    public GestureDetector h;
    public ac i;
    public com.baidu.mapsdkplatform.comapi.map.d j;
    public volatile boolean l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile boolean o;
    public boolean p;
    public boolean q;
    public LocationOverlay r;
    public boolean t;
    public List<BmLayer> u;
    public List<Overlay> v;
    public int w;
    public int x;
    public HashSet<ab> y;
    public boolean z;

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, geoBound) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements f.InterfaceC0126f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapSurfaceView a;
        public int b;

        public a(MapSurfaceView mapSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mapSurfaceView;
            this.b = 12440;
        }

        public /* synthetic */ a(MapSurfaceView mapSurfaceView, t tVar) {
            this(mapSurfaceView);
        }

        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                throw new RuntimeException(b(str, i));
            }
        }

        public String b(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
                return str + " failed: " + a(i);
            }
            return (String) invokeLI.objValue;
        }

        private String a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
                switch (i) {
                    case MessageConstant.CommandId.COMMAND_BASE /* 12288 */:
                        return "EGL_SUCCESS";
                    case 12289:
                        return "EGL_NOT_INITIALIZED";
                    case MessageConstant.CommandId.COMMAND_UNREGISTER /* 12290 */:
                        return "EGL_BAD_ACCESS";
                    case MessageConstant.CommandId.COMMAND_STATISTIC /* 12291 */:
                        return OOMDeviceEventSceneSceneHandler.EGL_BAD_ALLOC;
                    case MessageConstant.CommandId.COMMAND_SET_ALIAS /* 12292 */:
                        return "EGL_BAD_ATTRIBUTE";
                    case 12293:
                        return "EGL_BAD_CONFIG";
                    case 12294:
                        return "EGL_BAD_CONTEXT";
                    case 12295:
                        return "EGL_BAD_CURRENT_SURFACE";
                    case 12296:
                        return "EGL_BAD_DISPLAY";
                    case 12297:
                        return "EGL_BAD_MATCH";
                    case MessageConstant.CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return "EGL_BAD_NATIVE_PIXMAP";
                    case MessageConstant.CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                        return "EGL_BAD_NATIVE_WINDOW";
                    case 12300:
                        return "EGL_BAD_PARAMETER";
                    case 12301:
                        return "EGL_BAD_SURFACE";
                    case Statistics.kTypeWhiteScreen /* 12302 */:
                        return "EGL_CONTEXT_LOST";
                    default:
                        return b(i);
                }
            }
            return (String) invokeI.objValue;
        }

        private String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
                return "0x" + Integer.toHexString(i);
            }
            return (String) invokeI.objValue;
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0126f
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, egl10, eGLDisplay, eGLConfig)) == null) {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.b, 2, 12344});
            }
            return (EGLContext) invokeLLL.objValue;
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0126f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, egl10, eGLDisplay, eGLContext) == null) {
                if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                    Log.e("MapContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                    a("eglDestroyContex", egl10.eglGetError());
                }
                this.a.onRecycle();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapSurfaceView a;

        public b(MapSurfaceView mapSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mapSurfaceView;
        }

        public /* synthetic */ b(MapSurfaceView mapSurfaceView, t tVar) {
            this(mapSurfaceView);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                super.onLongPress(motionEvent);
                MapController mapController = this.a.a;
                if (mapController != null && mapController.getBaseMap() != null) {
                    MapController mapController2 = this.a.a;
                    if (mapController2.mIsMapLoadFinish) {
                        String GetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), this.a.a.nearlyRadius);
                        GeoPoint geoPoint = null;
                        if (GetNearlyObjID != null && !GetNearlyObjID.equals("")) {
                            MapSurfaceView mapSurfaceView = this.a;
                            if (mapSurfaceView.a.mListeners != null) {
                                if (mapSurfaceView.getProjection() != null) {
                                    geoPoint = this.a.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                                }
                                for (al alVar : this.a.a.mListeners) {
                                    if (alVar != null) {
                                        if (alVar.b(GetNearlyObjID)) {
                                            this.a.a.mHasMapObjDraging = true;
                                        } else if (geoPoint != null) {
                                            alVar.c(geoPoint);
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        MapSurfaceView mapSurfaceView2 = this.a;
                        if (mapSurfaceView2.a.mListeners != null) {
                            if (mapSurfaceView2.getProjection() != null) {
                                geoPoint = this.a.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                            }
                            if (geoPoint == null) {
                                return;
                            }
                            for (al alVar2 : this.a.a.mListeners) {
                                if (alVar2 != null && geoPoint != null) {
                                    alVar2.c(geoPoint);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-678616726, "Lcom/baidu/platform/comapi/map/MapSurfaceView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-678616726, "Lcom/baidu/platform/comapi/map/MapSurfaceView;");
                return;
            }
        }
        A = Executors.newSingleThreadExecutor();
    }

    public void a() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (mapController = this.a) == null || mapController.getBaseMap() == null || this.b == null) {
            return;
        }
        this.v.clear();
        this.b.a();
    }

    public void b() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (mapController = this.a) == null || mapController.getBaseMap() == null) {
            return;
        }
        a();
    }

    public void beginLocationLayerAnimation() {
        LocationOverlay locationOverlay;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (locationOverlay = this.r) != null) {
            locationOverlay.beginLocationLayerAnimation();
        }
    }

    public com.baidu.mapsdkplatform.comapi.map.d getBaseMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.j;
        }
        return (com.baidu.mapsdkplatform.comapi.map.d) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.u;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.a;
        }
        return (MapController) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                return mapController.getCurrentMapStatus();
            }
            return null;
        }
        return (MapStatus) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                return mapController.getCurrentZoomLevel();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ int getDebugFlags() {
        return super.getDebugFlags();
    }

    public LocationOverlay getDefaultLocationLay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.r;
        }
        return (LocationOverlay) invokeV.objValue;
    }

    public int getFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.k.e();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            MapController mapController = this.a;
            if (mapController == null) {
                return null;
            }
            return mapController.getMapStatus().geoRound;
        }
        return (MapStatus.GeoBound) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public GeoPoint getMapCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            MapController mapController = this.a;
            if (mapController == null) {
                return null;
            }
            MapStatus mapStatus = mapController.getMapStatus();
            return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
        }
        return (GeoPoint) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            MapController mapController = this.a;
            if (mapController == null) {
                return 0;
            }
            return mapController.getMapStatus().rotation;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                return mapController.getMapStatus();
            }
            return null;
        }
        return (MapStatus) invokeV.objValue;
    }

    public MapViewListener getMapViewListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                return mapController.getMapViewListener();
            }
            return null;
        }
        return (MapViewListener) invokeV.objValue;
    }

    public OnLongPressListener getOnLongPressListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.g.a();
        }
        return (OnLongPressListener) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.v;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getOverlooking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            MapController mapController = this.a;
            if (mapController == null) {
                return 0;
            }
            return mapController.getMapStatus().overlooking;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.c;
        }
        return (Projection) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ ah getRenderControl() {
        return super.getRenderControl();
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ int getRenderMode() {
        return super.getRenderMode();
    }

    public ExecutorService getSingleThreadPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return A;
        }
        return (ExecutorService) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ ai.a getViewType() {
        return super.getViewType();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            MapController mapController = this.a;
            if (mapController == null) {
                return null;
            }
            return mapController.getMapStatus().winRound;
        }
        return (MapStatus.WinRound) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                return mapController.getZoomLevel();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean isPredictTraffic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (this.B <= 0 && this.C <= 0 && this.D <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.aj, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.onAttachedToWindow();
            MapController mapController = this.a;
            if (mapController != null) {
                mapController.updateDrawFPS();
            }
            if (Build.VERSION.SDK_INT < 14) {
                this.f = false;
            }
        }
    }

    public void onBackground() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048635, this) != null) || this.q) {
            return;
        }
        MapController mapController = this.a;
        if (mapController != null && mapController.getBaseMap() != null) {
            this.a.getBaseMap().OnBackground();
        }
        this.q = true;
    }

    @Override // com.baidu.platform.comapi.map.aj, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                mapController.updateDrawFPS();
            }
            super.onDetachedFromWindow();
            if (Build.VERSION.SDK_INT < 14) {
                this.f = true;
            }
        }
    }

    public void onRecycle() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && (mapController = this.a) != null && mapController.getBaseMap() != null) {
            this.a.getBaseMap().ResetImageRes();
        }
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            requestRender();
        }
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ void requestRender() {
        super.requestRender();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapSurfaceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, motionEvent)) == null) {
            MapStatus mapStatus = getMapStatus();
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                int x = (int) motionEvent.getX(i);
                int y = (int) motionEvent.getY(i);
                if (mapStatus != null) {
                    MapStatus.WinRound winRound = mapStatus.winRound;
                    if (x >= winRound.left && x <= winRound.right && y >= winRound.top && y <= winRound.bottom) {
                    }
                }
                return false;
            }
            try {
                if (this.h != null && this.h.onTouchEvent(motionEvent)) {
                    return true;
                }
                if (this.a != null) {
                    if (this.a.handleTouchEvent(motionEvent)) {
                        return true;
                    }
                }
                return super.onTouchEvent(motionEvent);
            } catch (Exception unused) {
                return super.onTouchEvent(motionEvent);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048646, this, overlay) == null) && overlay != null && this.a != null) {
            if (overlay instanceof ItemizedOverlay) {
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                if (itemizedOverlay.b()) {
                    if (itemizedOverlay.getAllItem().size() <= 0) {
                        this.a.getBaseMap().ClearLayer(overlay.mLayerID);
                        this.a.getBaseMap().ShowLayers(overlay.mLayerID, false);
                        this.a.getBaseMap().UpdateLayers(overlay.mLayerID);
                    } else {
                        this.a.getBaseMap().ShowLayers(overlay.mLayerID, true);
                        this.a.getBaseMap().UpdateLayers(overlay.mLayerID);
                    }
                    itemizedOverlay.a(false);
                }
            }
            MapController mapController = this.a;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.a.getBaseMap().UpdateLayers(overlay.mLayerID);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    public float getFZoomToBoundF(MapBound mapBound, MapBound mapBound2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, mapBound, mapBound2)) == null) {
            if (this.a == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", mapBound.leftBottomPt.getIntX());
            bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
            bundle.putInt("right", mapBound.rightTopPt.getIntX());
            bundle.putInt("top", mapBound.rightTopPt.getIntY());
            Bundle bundle2 = new Bundle();
            bundle2.putInt("left", mapBound2.leftBottomPt.getIntX());
            bundle2.putInt("bottom", mapBound2.leftBottomPt.getIntY());
            bundle2.putInt("right", mapBound2.rightTopPt.getIntX());
            bundle2.putInt("top", mapBound2.rightTopPt.getIntY());
            return this.a.GetFZoomToBoundF(bundle, bundle2);
        }
        return invokeLL.floatValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapSurfaceView(Context context, ai.a aVar) {
        super(context, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ai.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapSurfaceView(Context context, ai.a aVar, boolean z) {
        super(context, aVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (ai.a) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    public void doCaptureMapView(c cVar, Rect rect, Bitmap.Config config) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048592, this, cVar, rect, config) == null) && rect != null) {
            int i3 = rect.left;
            int i4 = this.x;
            int i5 = rect.bottom;
            if (i4 < i5) {
                i = 0;
            } else {
                i = i4 - i5;
            }
            int width = rect.width();
            int height = rect.height();
            if (i3 >= 0 && i >= 0 && width > 0 && height > 0) {
                if (width > this.w) {
                    width = Math.abs(rect.width()) - (rect.right - this.w);
                }
                int i6 = width;
                if (height > this.x) {
                    i2 = Math.abs(rect.height()) - (rect.bottom - this.x);
                } else {
                    i2 = height;
                }
                if (i3 <= SysOSUtil.getScreenSizeX() && i <= SysOSUtil.getScreenSizeY()) {
                    this.d.a(cVar, i3, i, i6, i2, config);
                    requestRender();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapSurfaceView(Context context, boolean z) {
        super(context, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.t = true;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 0;
        this.x = 0;
        this.y = new HashSet<>();
        this.f = true;
        this.z = true;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        s++;
    }

    private synchronized boolean a(long j, BmLayer bmLayer) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65542, this, j, bmLayer)) == null) {
            synchronized (this) {
                if (bmLayer != null) {
                    if (this.a != null) {
                        AppBaseMap baseMap = this.a.getBaseMap();
                        if (baseMap == null) {
                            return false;
                        }
                        synchronized (this) {
                            if (this.u.contains(bmLayer)) {
                                return false;
                            }
                            this.u.add(bmLayer);
                            return baseMap.addBmLayerBelow(j, bmLayer.a(), 1, 0);
                        }
                    }
                }
                return false;
            }
        }
        return invokeJL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bmLayer)) == null) {
            return a(0L, bmLayer);
        }
        return invokeL.booleanValue;
    }

    public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, simpleOnGestureListener) == null) {
            this.g.a(simpleOnGestureListener);
        }
    }

    public void addStateListener(ab abVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, abVar) == null) && abVar != null) {
            this.y.add(abVar);
        }
    }

    public void clearDefaultLocationLayerData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            this.r.clearLocationLayerData(bundle);
        }
    }

    public void forceSetTraffic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (this.a != null) {
                this.l = z;
            }
            A.submit(new u(this));
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, mapBound)) == null) {
            com.baidu.platform.comapi.util.SysOSUtil sysOSUtil = com.baidu.platform.comapi.util.SysOSUtil.getInstance();
            return getZoomToBound(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, mapBound)) == null) {
            com.baidu.platform.comapi.util.SysOSUtil sysOSUtil = com.baidu.platform.comapi.util.SysOSUtil.getInstance();
            return getZoomToBoundF(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
        ac acVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            if (i == 1) {
                requestRender();
            } else if (i == 0) {
                if (getRenderMode() != 0) {
                    setRenderMode(0);
                }
            } else if (i == 2 && (acVar = this.i) != null) {
                acVar.a();
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ void queueEvent(Runnable runnable) {
        super.queueEvent(runnable);
    }

    public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, simpleOnGestureListener) == null) {
            this.g.b(simpleOnGestureListener);
        }
    }

    public void removeStateListener(ab abVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048650, this, abVar) == null) && abVar != null) {
            this.y.remove(abVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048652, this, str) == null) && (mapController = this.a) != null) {
            mapController.saveScreenToLocal(str);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            if (this.a != null) {
                this.o = z;
            }
            A.submit(new x(this, z));
        }
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, dVar) == null) {
            this.j = dVar;
        }
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ void setDebugFlags(int i) {
        super.setDebugFlags(i);
    }

    public void setDefaultLocationLayerData(List<OverlayLocationData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, list) == null) {
            this.r.setLocationLayerData(list);
        }
    }

    public void setFPS(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i) == null) {
            this.k.a(i);
        }
    }

    public void setFirstFrameListener(e eVar) {
        p pVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048659, this, eVar) == null) && (pVar = this.d) != null) {
            pVar.a(eVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, geoPoint) == null) && (mapController = this.a) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.a.setMapStatus(mapStatus);
        }
    }

    public void setMapRenderStableListener(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, acVar) == null) {
            this.i = acVar;
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048665, this, mapStatus) == null) && (mapController = this.a) != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, onLongPressListener) == null) {
            this.g.a(onLongPressListener);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048668, this, i) == null) && (mapController = this.a) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i;
            this.a.setMapStatus(mapStatus);
        }
    }

    public void setPixelFormatTransparent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            if (z) {
                getHolder().setFormat(-3);
            } else {
                getHolder().setFormat(-1);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ void setRenderMode(int i) {
        super.setRenderMode(i);
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ void setRenderer(aq aqVar) {
        super.setRenderer(aqVar);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048672, this, i) == null) && (mapController = this.a) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i;
            this.a.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            if (this.a != null) {
                this.m = z;
            }
            A.submit(new t(this));
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            if (this.a != null) {
                this.n = z;
            }
            A.submit(new w(this));
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048675, this, z) != null) || this.l == z) {
            return;
        }
        if (this.a != null) {
            this.l = z;
        }
        A.submit(new v(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048676, this, winRound) == null) && (mapController = this.a) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.a.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i) == null) {
            setZoomLevel(i);
        }
    }

    @Override // com.baidu.platform.comapi.map.aj, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, surfaceHolder) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                mapController.updateDrawFPS();
            }
            super.surfaceCreated(surfaceHolder);
            if (surfaceHolder != null && !surfaceHolder.getSurface().isValid()) {
                surfaceDestroyed(surfaceHolder);
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.aj, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, surfaceHolder) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                mapController.updateDrawFPS();
            }
            super.surfaceDestroyed(surfaceHolder);
        }
    }

    @Override // com.baidu.platform.comapi.map.aj, android.view.SurfaceHolder.Callback2
    @Deprecated
    public /* bridge */ /* synthetic */ void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        super.surfaceRedrawNeeded(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.aj
    public ah a(ai.a aVar, boolean z, Context context) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{aVar, Boolean.valueOf(z), context})) == null) {
            ah a2 = super.a(aVar, z, context);
            if (a2 instanceof f) {
                f fVar = (f) a2;
                if (this.z) {
                    fVar.a(new a(this, null));
                }
            }
            return a2;
        }
        return (ah) invokeCommon.objValue;
    }

    public boolean setItsPreTime(int i, int i2, int i3) {
        InterceptResult invokeIII;
        AppBaseMap baseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048661, this, i, i2, i3)) == null) {
            if (this.B == i && this.C == i2 && this.D == i3) {
                return true;
            }
            MapController mapController = this.a;
            if (mapController != null && (baseMap = mapController.getBaseMap()) != null) {
                this.B = i;
                this.C = i2;
                this.D = i3;
                return baseMap.SetItsPreTime(i, i2, i3);
            }
            return false;
        }
        return invokeIII.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.aj
    public void a(Context context, ai.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, context, aVar, z) == null) {
            super.a(context, aVar, z);
            setBackgroundColor(Color.rgb((int) GDiffPatcher.COPY_UBYTE_UBYTE, 242, 240));
            setPixelFormatTransparent(false);
            this.g = new am();
            this.h = new GestureDetector(context, this.g);
            p pVar = new p(new WeakReference(this), this);
            this.d = pVar;
            setRenderer(pVar);
            setRenderMode(1);
            this.g.a(new b(this, null));
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap surfaceView initView");
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048624, this, mapBound, i, i2)) == null) {
            if (this.a == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", mapBound.leftBottomPt.getIntX());
            bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
            bundle.putInt("right", mapBound.rightTopPt.getIntX());
            bundle.putInt("top", mapBound.rightTopPt.getIntY());
            return this.a.getZoomToBound(bundle, i, i2);
        }
        return invokeLII.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048626, this, mapBound, i, i2)) == null) {
            if (this.a == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", mapBound.leftBottomPt.getIntX());
            bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
            bundle.putInt("right", mapBound.rightTopPt.getIntX());
            bundle.putInt("top", mapBound.rightTopPt.getIntY());
            return this.a.getZoomToBoundF(bundle);
        }
        return invokeLII.floatValue;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048638, this, view2, i, keyEvent)) == null) {
            if (this != view2 || keyEvent.getAction() != 0) {
                return false;
            }
            switch (i) {
                case 19:
                    this.a.scrollBy(0, -50);
                    return true;
                case 20:
                    this.a.scrollBy(0, 50);
                    return true;
                case 21:
                    this.a.scrollBy(-50, 0);
                    return true;
                case 22:
                    this.a.scrollBy(50, 0);
                    return true;
                default:
                    return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, overlay, bmLayer)) == null) {
            if (overlay != null) {
                return a(overlay.mLayerID, bmLayer);
            }
            return a(0L, bmLayer);
        }
        return invokeLL.booleanValue;
    }

    public void animateTo(MapStatus mapStatus, int i) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, mapStatus, i) == null) && (mapController = this.a) != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    @Override // com.baidu.platform.comapi.map.aj, android.view.SurfaceHolder.Callback2
    @TargetApi(26)
    public /* bridge */ /* synthetic */ void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        super.surfaceRedrawNeededAsync(surfaceHolder, runnable);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        InterceptResult invokeLL;
        MapController mapController;
        AppBaseMap baseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048684, this, overlay, overlay2)) == null) {
            if (overlay == null || overlay2 == null || (mapController = this.a) == null || (baseMap = mapController.getBaseMap()) == null) {
                return false;
            }
            return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean addOverlay(Overlay overlay) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, overlay)) == null) {
            synchronized (this) {
                if (overlay != null) {
                    if (this.a != null) {
                        AppBaseMap baseMap = this.a.getBaseMap();
                        if (baseMap == null) {
                            return false;
                        }
                        if (overlay instanceof ao) {
                            return ((InnerOverlay) overlay).addedToMapView();
                        }
                        if (overlay instanceof InnerOverlay) {
                            if (((InnerOverlay) overlay).mBaseMap == null) {
                                ((InnerOverlay) overlay).mBaseMap = getController().getBaseMap();
                            }
                            if (!((InnerOverlay) overlay).addedToMapView()) {
                                return false;
                            }
                            synchronized (this) {
                                this.v.add(overlay);
                                this.b.a((InnerOverlay) overlay);
                            }
                            return true;
                        } else if (!(overlay instanceof ItemizedOverlay)) {
                            return false;
                        } else {
                            long AddLayer = baseMap.AddLayer(((ItemizedOverlay) overlay).getUpdateType(), 0, "item");
                            overlay.mLayerID = AddLayer;
                            if (AddLayer == 0) {
                                return false;
                            }
                            synchronized (this) {
                                this.v.add(overlay);
                                ((ItemizedOverlay) overlay).a();
                                baseMap.SetLayersClickable(overlay.mLayerID, true);
                                baseMap.ShowLayers(overlay.mLayerID, true);
                                baseMap.UpdateLayers(overlay.mLayerID);
                            }
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void animateTo(MapStatus mapStatus, int i, int i2) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048585, this, mapStatus, i, i2) == null) && (mapController = this.a) != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i, i2);
        }
    }

    public void doCaptureMapView(c cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, cVar, i, i2) == null) {
            this.d.a(cVar, i, i2);
        }
    }

    @Override // com.baidu.platform.comapi.map.aj
    public /* bridge */ /* synthetic */ Bitmap captureImageFromSurface(int i, int i2, int i3, int i4, Object obj, Bitmap.Config config) {
        return super.captureImageFromSurface(i, i2, i3, i4, obj, config);
    }

    public void doCaptureMapView(c cVar, int i, int i2, Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{cVar, Integer.valueOf(i), Integer.valueOf(i2), config}) == null) {
            this.d.a(cVar, i, i2, config);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            MapStatus mapStatus = getMapStatus();
            l lVar = (l) getProjection();
            MapStatus.WinRound winRound = mapStatus.winRound;
            GeoPoint fromPixels = lVar.fromPixels(winRound.left, winRound.top);
            MapStatus.WinRound winRound2 = mapStatus.winRound;
            return (int) Math.abs(fromPixels.getLatitude() - lVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLatitude());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLongitudeSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            MapStatus mapStatus = getMapStatus();
            l lVar = (l) getProjection();
            MapStatus.WinRound winRound = mapStatus.winRound;
            GeoPoint fromPixels = lVar.fromPixels(winRound.left, winRound.top);
            MapStatus.WinRound winRound2 = mapStatus.winRound;
            return (int) Math.abs(lVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLongitude() - fromPixels.getLongitude());
        }
        return invokeV.intValue;
    }

    public void onForeground() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && this.q) {
            MapController mapController = this.a;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.a.getBaseMap().OnForeground();
            }
            this.q = false;
            if (this.k.b() == ai.a.b) {
                p pVar = this.d;
                if (pVar != null) {
                    pVar.a();
                }
                super.onResume();
            }
        }
    }

    public synchronized Overlay getOverlay(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            synchronized (this) {
                if (i == 21) {
                    return null;
                }
                for (Overlay overlay : this.v) {
                    if (overlay.mType == i) {
                        return overlay;
                    }
                }
                return null;
            }
        }
        return (Overlay) invokeI.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, bmLayer)) == null) {
            synchronized (this) {
                if (bmLayer != null) {
                    if (this.a != null) {
                        AppBaseMap baseMap = this.a.getBaseMap();
                        if (baseMap == null) {
                            return false;
                        }
                        baseMap.removeBmLayer(bmLayer.a());
                        synchronized (this) {
                            this.u.remove(bmLayer);
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048677, this, f) != null) || this.a == null) {
            return;
        }
        int i = 21;
        if (getController().getFocusedBaseIndoorMapInfo() != null) {
            i = 22;
        }
        if (f < 4.0f) {
            f = 4.0f;
        } else {
            float f2 = i;
            if (f > f2) {
                f = f2;
            }
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.level = f;
            animateTo(mapStatus, 300);
        }
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, cls)) == null) {
            synchronized (this) {
                for (Overlay overlay : this.v) {
                    if (overlay.getClass() == cls) {
                        return overlay;
                    }
                }
                return null;
            }
        }
        return (Overlay) invokeL.objValue;
    }

    public boolean inRangeOfView(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float f3 = 0;
            if (f < f3 || f > this.w + 0 || f2 < f3 || f2 > this.x + 0) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public synchronized boolean insertOverlay(Overlay overlay, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048628, this, overlay, i)) == null) {
            synchronized (this) {
                if ((overlay instanceof InnerOverlay) && this.a != null) {
                    if (((InnerOverlay) overlay).mBaseMap == null) {
                        ((InnerOverlay) overlay).mBaseMap = this.a.getBaseMap();
                    }
                    this.v.add(overlay);
                    this.b.a((InnerOverlay) overlay);
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.aj
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048640, this) != null) || this.p) {
            return;
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap onPause");
        }
        p pVar = this.d;
        if (pVar != null) {
            pVar.b();
        }
        MapController mapController = this.a;
        if (mapController != null) {
            mapController.onPause();
        }
        Iterator<ab> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.onPause();
        this.p = true;
    }

    public void unInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar != null) {
                List<al> list = dVar.h;
                if (list != null) {
                    for (al alVar : list) {
                        if (alVar != null) {
                            alVar.d();
                        }
                    }
                }
                this.j.L();
                this.j = null;
            }
            this.a.unInit();
            this.a = null;
            this.b.a();
            this.b = null;
            this.c = null;
            this.d = null;
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b.a().a("BasicMap surfaceView unInit");
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.aj
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && this.p) {
            if (OpenLogUtil.isMapLogEnable()) {
                com.baidu.mapsdkplatform.comapi.commonutils.b a2 = com.baidu.mapsdkplatform.comapi.commonutils.b.a();
                a2.a("BasicMap onResume isInited = " + this.e);
            }
            if (!this.e) {
                return;
            }
            p pVar = this.d;
            if (pVar != null) {
                pVar.a();
            }
            MapController mapController = this.a;
            if (mapController != null) {
                mapController.onResume();
            }
            Iterator<ab> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            setRenderMode(1);
            super.onResume();
            this.p = false;
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeOverlay(Overlay overlay) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, overlay)) == null) {
            synchronized (this) {
                if (overlay != null) {
                    if (this.a != null) {
                        AppBaseMap baseMap = this.a.getBaseMap();
                        if (baseMap == null) {
                            return false;
                        }
                        baseMap.ClearLayer(overlay.mLayerID);
                        baseMap.ShowLayers(overlay.mLayerID, false);
                        baseMap.UpdateLayers(overlay.mLayerID);
                        baseMap.RemoveLayer(overlay.mLayerID);
                        synchronized (this) {
                            if (overlay instanceof ItemizedOverlay) {
                                this.v.remove(overlay);
                            } else if (overlay instanceof InnerOverlay) {
                                this.v.remove(overlay);
                                this.b.a(overlay);
                            }
                            overlay.mLayerID = 0L;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void setMapController(MapController mapController) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048663, this, mapController) != null) || this.a != null) {
            return;
        }
        this.a = mapController;
        this.d.a(mapController.getBaseMap());
        this.d.a(true);
        af afVar = new af(this.a.getBaseMap());
        this.b = afVar;
        this.a.setOverlayMapCallBack(afVar);
        this.a.setMapViewInterface(this);
        b();
        this.a.setMapRenderModeChangeListener(this);
        this.e = true;
        this.c = new l(this.a);
        this.g.a(this.a);
    }

    public void saveScreenToLocal(String str, Rect rect) {
        com.baidu.mapsdkplatform.comapi.map.d dVar;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048653, this, str, rect) == null) && (dVar = this.j) != null && dVar.a() != null) {
            String str2 = null;
            if (rect != null) {
                int i2 = rect.left;
                int i3 = this.x;
                int i4 = rect.bottom;
                if (i3 < i4) {
                    i = 0;
                } else {
                    i = i3 - i4;
                }
                int width = rect.width();
                int height = rect.height();
                if (i2 >= 0 && i >= 0 && width > 0 && height > 0) {
                    if (width > this.w) {
                        width = Math.abs(rect.width()) - (rect.right - this.w);
                    }
                    if (height > this.x) {
                        height = Math.abs(rect.height()) - (rect.bottom - this.x);
                    }
                    if (i2 <= SysOSUtil.getScreenSizeX() && i <= SysOSUtil.getScreenSizeY()) {
                        if (width != 0 && height != 0) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("x", i2);
                                jSONObject.put("y", i);
                                jSONObject.put("width", width);
                                jSONObject.put("height", height);
                                str2 = jSONObject.toString();
                            } catch (Exception unused) {
                            }
                        }
                        this.j.a().SaveScreenToLocal(str, str2);
                        return;
                    }
                    this.j.a().SaveScreenToLocal(str, null);
                    return;
                }
                return;
            }
            this.j.a().SaveScreenToLocal(str, null);
        }
    }

    @Override // com.baidu.platform.comapi.map.aj, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048679, this, surfaceHolder, i, i2, i3) == null) {
            MapController mapController = this.a;
            if (mapController != null) {
                mapController.updateDrawFPS();
            }
            p pVar = this.d;
            if (pVar != null) {
                pVar.a = i2;
                pVar.b = i3;
                pVar.c = 0;
            }
            this.w = i2;
            this.x = i3;
            super.surfaceChanged(surfaceHolder, i, i2, i3);
            if (this.a != null) {
                MapStatus mapStatus = getMapStatus();
                if (mapStatus != null) {
                    MapStatus.WinRound winRound = mapStatus.winRound;
                    winRound.left = 0;
                    winRound.top = 0;
                    winRound.bottom = i3;
                    winRound.right = i2;
                    if (!this.t) {
                        this.a.setMapStatus(mapStatus, false);
                    } else {
                        this.t = false;
                        this.a.setMapStatusWithAnimation(mapStatus, 4, 0);
                    }
                    if (this.a.getMapViewSurfaceListener() != null) {
                        this.a.getMapViewSurfaceListener().onSurfaceChanged(i2, i3);
                    }
                }
                MapStatus mapStatus2 = getMapStatus();
                MapStatus.WinRound winRound2 = mapStatus2.winRound;
                this.w = Math.abs(winRound2.right - winRound2.left);
                MapStatus.WinRound winRound3 = mapStatus2.winRound;
                int abs = Math.abs(winRound3.bottom - winRound3.top);
                this.x = abs;
                this.a.setScreenSize(this.w, abs);
                if (this.a.isNaviMode() && this.a.getNaviMapViewListener() != null) {
                    this.a.getNaviMapViewListener().resizeScreen(i2, i3);
                }
            }
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.j;
            if (dVar != null) {
                dVar.a(this.w, this.x);
            }
        }
    }
}
