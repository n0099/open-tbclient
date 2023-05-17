package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.baidu.searchbox.logsystem.basic.eventhandler.OOMDeviceEventSceneSceneHandler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Statistics;
import com.heytap.mcssdk.constant.MessageConstant;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes3.dex */
public class MapTextureView extends h implements MapRenderModeChangeListener, MapViewInterface, ak {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.mapsdkplatform.comapi.map.d a;
    public MapController b;
    public af c;
    public l d;
    public p e;
    public int f;
    public int g;
    public List<Overlay> h;
    public ac i;
    public am j;
    public GestureDetector k;
    public List<BmLayer> l;
    public c m;

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public Overlay getPopupOverlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (Overlay) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, geoBound) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements GLSurfaceView.EGLContextFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapTextureView a;
        public int b;

        public a(MapTextureView mapTextureView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapTextureView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mapTextureView;
            this.b = 12440;
        }

        public /* synthetic */ a(MapTextureView mapTextureView, y yVar) {
            this(mapTextureView);
        }

        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                throw new RuntimeException(b(str, i));
            }
        }

        public String b(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
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

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, egl10, eGLDisplay, eGLConfig)) == null) {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.b, 2, 12344});
            }
            return (EGLContext) invokeLLL.objValue;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, egl10, eGLDisplay, eGLContext) == null) {
                if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                    a("eglDestroyContex", egl10.eglGetError());
                }
                this.a.onRecycle();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapTextureView a;

        public b(MapTextureView mapTextureView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapTextureView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mapTextureView;
        }

        public /* synthetic */ b(MapTextureView mapTextureView, y yVar) {
            this(mapTextureView);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                super.onLongPress(motionEvent);
                MapController mapController = this.a.b;
                if (mapController != null && mapController.getBaseMap() != null) {
                    MapController mapController2 = this.a.b;
                    if (mapController2.mIsMapLoadFinish) {
                        String GetNearlyObjID = mapController2.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), this.a.b.nearlyRadius);
                        GeoPoint geoPoint = null;
                        if (GetNearlyObjID != null && !GetNearlyObjID.equals("")) {
                            MapTextureView mapTextureView = this.a;
                            if (mapTextureView.b.mListeners != null) {
                                if (mapTextureView.getProjection() != null) {
                                    geoPoint = this.a.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                                }
                                for (al alVar : this.a.b.mListeners) {
                                    if (alVar != null) {
                                        if (alVar.b(GetNearlyObjID)) {
                                            this.a.b.mHasMapObjDraging = true;
                                        } else if (geoPoint != null) {
                                            alVar.c(geoPoint);
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        MapTextureView mapTextureView2 = this.a;
                        if (mapTextureView2.b.mListeners != null) {
                            if (mapTextureView2.getProjection() != null) {
                                geoPoint = this.a.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                            }
                            if (geoPoint == null) {
                                return;
                            }
                            for (al alVar2 : this.a.b.mListeners) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapTextureView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.l = new ArrayList();
        this.h = new ArrayList();
        a(context);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean removeOverlay(Overlay overlay) {
        InterceptResult invokeL;
        MapController mapController;
        AppBaseMap baseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, overlay)) == null) {
            if (overlay == null || (mapController = this.b) == null || (baseMap = mapController.getBaseMap()) == null) {
                return false;
            }
            baseMap.ClearLayer(overlay.mLayerID);
            baseMap.ShowLayers(overlay.mLayerID, false);
            baseMap.UpdateLayers(overlay.mLayerID);
            baseMap.RemoveLayer(overlay.mLayerID);
            if (overlay instanceof ItemizedOverlay) {
                this.h.remove(overlay);
            } else if (overlay instanceof InnerOverlay) {
                this.h.remove(overlay);
                this.c.a(overlay);
            }
            overlay.mLayerID = 0L;
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.l = new ArrayList();
        this.h = new ArrayList();
        a(context);
    }

    private synchronized boolean a(long j, BmLayer bmLayer) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TRACKBALL, this, j, bmLayer)) == null) {
            synchronized (this) {
                if (bmLayer != null) {
                    if (this.b != null) {
                        AppBaseMap baseMap = this.b.getBaseMap();
                        if (baseMap == null) {
                            return false;
                        }
                        synchronized (this) {
                            if (this.l.contains(bmLayer)) {
                                return false;
                            }
                            this.l.add(bmLayer);
                            return baseMap.addBmLayerBelow(j, bmLayer.a(), 1, 0);
                        }
                    }
                }
                return false;
            }
        }
        return invokeJL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.l = new ArrayList();
        this.h = new ArrayList();
        a(context);
    }

    public void doCaptureMapView(com.baidu.platform.comapi.map.c cVar, Rect rect, Bitmap.Config config) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, cVar, rect, config) == null) && rect != null) {
            int i3 = rect.left;
            int i4 = this.g;
            int i5 = rect.bottom;
            if (i4 < i5) {
                i = 0;
            } else {
                i = i4 - i5;
            }
            int width = rect.width();
            int height = rect.height();
            if (i3 >= 0 && i >= 0 && width > 0 && height > 0) {
                if (width > this.f) {
                    width = Math.abs(rect.width()) - (rect.right - this.f);
                }
                int i6 = width;
                if (height > this.g) {
                    i2 = Math.abs(rect.height()) - (rect.bottom - this.g);
                } else {
                    i2 = height;
                }
                if (i3 <= SysOSUtil.getScreenSizeX() && i <= SysOSUtil.getScreenSizeY()) {
                    this.e.a(cVar, i3, i, i6, i2, config);
                }
            }
        }
    }

    @Override // com.baidu.platform.comapi.map.h, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048623, this, surfaceTexture, i, i2) == null) {
            super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
            this.f = i;
            this.g = i2;
            p pVar = this.e;
            pVar.a = i;
            pVar.b = i2;
            pVar.c = 0;
            if (this.b != null) {
                MapStatus mapStatus = getMapStatus();
                MapStatus.WinRound winRound = mapStatus.winRound;
                winRound.left = 0;
                winRound.top = 0;
                winRound.bottom = i2;
                winRound.right = i;
                this.b.setMapStatusWithAnimation(mapStatus, 4, 0);
                if (this.b.getMapViewSurfaceListener() != null) {
                    this.b.getMapViewSurfaceListener().onSurfaceChanged(i, i2);
                }
                MapStatus mapStatus2 = getMapStatus();
                MapStatus.WinRound winRound2 = mapStatus2.winRound;
                this.f = Math.abs(winRound2.right - winRound2.left);
                MapStatus.WinRound winRound3 = mapStatus2.winRound;
                int abs = Math.abs(winRound3.bottom - winRound3.top);
                this.g = abs;
                this.b.setScreenSize(this.f, abs);
            }
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.f, this.g);
            }
        }
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            setEGLContextClientVersion(2);
            this.j = new am();
            this.k = new GestureDetector(context, this.j);
            this.j.a(new b(this, null));
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayer(BmLayer bmLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bmLayer)) == null) {
            return a(0L, bmLayer);
        }
        return invokeL.booleanValue;
    }

    public synchronized Overlay getOverlay(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            synchronized (this) {
                for (Overlay overlay : this.h) {
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
    public float getZoomToBound(MapBound mapBound) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, mapBound)) == null) {
            return getZoomToBound(mapBound, this.f, this.g);
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, mapBound)) == null) {
            return getZoomToBoundF(mapBound, this.f, this.g);
        }
        return invokeL.floatValue;
    }

    public void listenMapRenderMessage(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, cVar) == null) {
            this.m = cVar;
        }
    }

    @Override // com.baidu.platform.comapi.map.h, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, surfaceTexture)) == null) {
            super.onSurfaceTextureDestroyed(surfaceTexture);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.h, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, surfaceTexture) == null) {
            super.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, dVar) == null) {
            this.a = dVar;
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, geoPoint) == null) && (mapController = this.b) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.b.setMapStatus(mapStatus);
        }
    }

    public void setMapRenderStableListener(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, acVar) == null) {
            this.i = acVar;
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, mapStatus) == null) && (mapController = this.b) != null) {
            mapController.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048637, this, i) == null) && (mapController = this.b) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.overlooking = i;
            this.b.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048638, this, i) == null) && (mapController = this.b) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.rotation = i;
            this.b.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        MapController mapController;
        AppBaseMap baseMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048641, this, z) == null) && (mapController = this.b) != null && (baseMap = mapController.getBaseMap()) != null) {
            baseMap.ShowTrafficMap(z);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048642, this, winRound) == null) && (mapController = this.b) != null) {
            MapStatus mapStatus = mapController.getMapStatus();
            mapStatus.winRound = winRound;
            this.b.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            setZoomLevel(i);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addBmLayerBelow(Overlay overlay, BmLayer bmLayer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, overlay, bmLayer)) == null) {
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
        if ((interceptable == null || interceptable.invokeLI(1048579, this, mapStatus, i) == null) && (mapController = this.b) != null) {
            mapController.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        InterceptResult invokeLL;
        MapController mapController;
        AppBaseMap baseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048645, this, overlay, overlay2)) == null) {
            if (overlay == null || overlay2 == null || (mapController = this.b) == null || (baseMap = mapController.getBaseMap()) == null) {
                return false;
            }
            return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addOverlay(Overlay overlay) {
        InterceptResult invokeL;
        MapController mapController;
        AppBaseMap baseMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, overlay)) == null) {
            if (overlay == null || (mapController = this.b) == null || (baseMap = mapController.getBaseMap()) == null) {
                return false;
            }
            if (overlay instanceof InnerOverlay) {
                InnerOverlay innerOverlay = (InnerOverlay) overlay;
                if (innerOverlay.mBaseMap == null) {
                    innerOverlay.mBaseMap = getController().getBaseMap();
                }
                if (!innerOverlay.addedToMapView()) {
                    return false;
                }
                this.h.add(overlay);
                this.c.a(innerOverlay);
                return true;
            }
            if (overlay instanceof ItemizedOverlay) {
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                long AddLayer = baseMap.AddLayer(itemizedOverlay.getUpdateType(), 0, "item");
                overlay.mLayerID = AddLayer;
                if (AddLayer == 0) {
                    return false;
                }
                this.h.add(overlay);
                itemizedOverlay.a();
                baseMap.SetLayersClickable(overlay.mLayerID, true);
                baseMap.ShowLayers(overlay.mLayerID, true);
                baseMap.UpdateLayers(overlay.mLayerID);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void attachBaseMapController(MapController mapController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mapController) == null) {
            p pVar = new p(this, this);
            this.e = pVar;
            this.b = mapController;
            pVar.a(mapController.getBaseMap());
            setEGLContextFactory(new a(this, null));
            setRenderer(this.e);
            setRenderMode(0);
            this.e.a(true);
            af afVar = new af(this.b.getBaseMap());
            this.c = afVar;
            this.b.setOverlayMapCallBack(afVar);
            this.b.setMapViewInterface(this);
            b();
            this.b.setMapRenderModeChangeListener(this);
            this.d = new l(this.b);
            this.j.a(this.b);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, overlay) == null) && overlay != null && this.b != null) {
            if (overlay instanceof ItemizedOverlay) {
                ItemizedOverlay itemizedOverlay = (ItemizedOverlay) overlay;
                if (itemizedOverlay.b()) {
                    if (itemizedOverlay.getAllItem().size() <= 0) {
                        this.b.getBaseMap().ClearLayer(overlay.mLayerID);
                        this.b.getBaseMap().ShowLayers(overlay.mLayerID, false);
                        this.b.getBaseMap().UpdateLayers(overlay.mLayerID);
                    } else {
                        this.b.getBaseMap().ShowLayers(overlay.mLayerID, true);
                        this.b.getBaseMap().UpdateLayers(overlay.mLayerID);
                    }
                    itemizedOverlay.a(false);
                }
            }
            MapController mapController = this.b;
            if (mapController != null && mapController.getBaseMap() != null) {
                this.b.getBaseMap().UpdateLayers(overlay.mLayerID);
            }
        }
    }

    public void b() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (mapController = this.b) == null || mapController.getBaseMap() == null) {
            return;
        }
        c();
    }

    public void c() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (mapController = this.b) == null || mapController.getBaseMap() == null || this.c == null) {
            return;
        }
        this.h.clear();
        this.c.a();
    }

    public void destroyForMultiViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MapController mapController = this.b;
            if (mapController != null) {
                mapController.unInitForMultiTextureView();
                this.b = null;
            }
            af afVar = this.c;
            if (afVar != null) {
                afVar.a();
                this.c = null;
            }
            this.d = null;
        }
    }

    public com.baidu.mapsdkplatform.comapi.map.d getBaseMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (com.baidu.mapsdkplatform.comapi.map.d) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<BmLayer> getBmlayers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return (MapController) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            MapController mapController = this.b;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            MapController mapController = this.b;
            if (mapController != null) {
                return mapController.getCurrentZoomLevel();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            MapController mapController = this.b;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            MapController mapController = this.b;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            MapController mapController = this.b;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            MapController mapController = this.b;
            if (mapController != null) {
                return mapController.getMapStatus();
            }
            return null;
        }
        return (MapStatus) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getOverlooking() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            MapController mapController = this.b;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.d;
        }
        return (Projection) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            MapController mapController = this.b;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            MapController mapController = this.b;
            if (mapController != null) {
                return mapController.getZoomLevel();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.h
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            MapController mapController = this.b;
            if (mapController != null) {
                mapController.getBaseMap().OnPause();
            }
            super.onPause();
        }
    }

    public void onRecycle() {
        MapController mapController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (mapController = this.b) != null && mapController.getBaseMap() != null) {
            this.b.getBaseMap().ResetImageRes();
        }
    }

    @Override // com.baidu.platform.comapi.map.h
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            MapController mapController = this.b;
            if (mapController != null) {
                mapController.getBaseMap().OnResume();
            }
            super.onResume();
        }
    }

    public void unListenMapRenderMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            this.m = null;
        }
    }

    public void doCaptureMapView(com.baidu.platform.comapi.map.c cVar, int i, int i2, Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{cVar, Integer.valueOf(i), Integer.valueOf(i2), config}) == null) {
            this.e.a(cVar, i, i2, config);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            MapStatus mapStatus = getMapStatus();
            l lVar = (l) getProjection();
            MapStatus.WinRound winRound = mapStatus.winRound;
            GeoPoint fromPixels = lVar.fromPixels(winRound.left, winRound.top);
            MapStatus.WinRound winRound2 = mapStatus.winRound;
            return (int) Math.abs(lVar.fromPixels(winRound2.right - 1, winRound2.bottom - 1).getLongitude() - fromPixels.getLongitude());
        }
        return invokeV.intValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.a;
            if (dVar != null) {
                List<al> list = dVar.h;
                if (list != null) {
                    for (al alVar : list) {
                        if (alVar != null) {
                            alVar.d();
                        }
                    }
                }
                this.a.L();
                this.a = null;
            }
            this.b.unInit();
            this.b = null;
            this.c.a();
            this.c = null;
            this.d = null;
        }
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, cls)) == null) {
            synchronized (this) {
                for (Overlay overlay : this.h) {
                    if (overlay.getClass() == cls) {
                        return overlay;
                    }
                }
                return null;
            }
        }
        return (Overlay) invokeL.objValue;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
        ac acVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            c cVar = this.m;
            if (cVar != null) {
                cVar.a(i);
            }
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

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, motionEvent)) == null) {
            try {
                if (this.k != null && this.k.onTouchEvent(motionEvent)) {
                    return true;
                }
                if (this.b != null) {
                    if (this.b.handleTouchEvent(motionEvent)) {
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
    public synchronized boolean removeBmLayer(BmLayer bmLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, bmLayer)) == null) {
            synchronized (this) {
                if (bmLayer != null) {
                    if (this.b != null) {
                        AppBaseMap baseMap = this.b.getBaseMap();
                        if (baseMap == null) {
                            return false;
                        }
                        baseMap.removeBmLayer(bmLayer.a());
                        synchronized (this) {
                            this.l.remove(bmLayer);
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
        if ((interceptable != null && interceptable.invokeF(1048643, this, f) != null) || this.b == null) {
            return;
        }
        int i = 21;
        if (getController().getFocusedBaseIndoorMapInfo() != null) {
            i = 22;
        }
        if (f < 4.0f) {
            f = 4.0f;
        } else if (f > i) {
            f = 21.0f;
        }
        MapStatus mapStatus = getMapStatus();
        if (mapStatus != null) {
            mapStatus.level = f;
            animateTo(mapStatus, 300);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048607, this, mapBound, i, i2)) == null) {
            if (this.b == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", mapBound.leftBottomPt.getIntX());
            bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
            bundle.putInt("right", mapBound.rightTopPt.getIntX());
            bundle.putInt("top", mapBound.rightTopPt.getIntY());
            return this.b.getZoomToBound(bundle, i, i2);
        }
        return invokeLII.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048609, this, mapBound, i, i2)) == null) {
            if (this.b == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", mapBound.leftBottomPt.getIntX());
            bundle.putInt("bottom", mapBound.leftBottomPt.getIntY());
            bundle.putInt("right", mapBound.rightTopPt.getIntX());
            bundle.putInt("top", mapBound.rightTopPt.getIntY());
            return this.b.getZoomToBoundF(bundle);
        }
        return invokeLII.floatValue;
    }

    @Override // com.baidu.platform.comapi.map.h, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048621, this, surfaceTexture, i, i2) == null) {
            super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
            this.f = i;
            this.g = i2;
            MapController mapController = this.b;
            if (mapController != null) {
                if (mapController.getMapViewSurfaceListener() != null) {
                    this.b.getMapViewSurfaceListener().onSurfaceChanged(i, i2);
                }
                MapStatus mapStatus = getMapStatus();
                MapStatus.WinRound winRound = mapStatus.winRound;
                this.f = Math.abs(winRound.right - winRound.left);
                MapStatus.WinRound winRound2 = mapStatus.winRound;
                this.g = Math.abs(winRound2.bottom - winRound2.top);
            }
            com.baidu.mapsdkplatform.comapi.map.d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.f, this.g);
            }
        }
    }
}
