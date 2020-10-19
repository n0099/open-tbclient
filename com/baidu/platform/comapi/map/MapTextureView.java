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
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.heytap.mcssdk.mode.CommandMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
/* loaded from: classes7.dex */
public class MapTextureView extends GLTextureView implements MapRenderModeChangeListener, MapViewInterface, af {

    /* renamed from: a  reason: collision with root package name */
    protected com.baidu.mapsdkplatform.comapi.map.d f2884a;
    protected MapController b;
    protected ac c;
    protected k d;
    protected m e;
    int f;
    int g;
    protected List<Overlay> h;
    protected z i;
    protected ah j;
    protected GestureDetector k;
    private b l;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements GLSurfaceView.EGLContextFactory {
        private int b;

        private a() {
            this.b = 12440;
        }

        private String a(int i) {
            switch (i) {
                case CommandMessage.COMMAND_BASE /* 12288 */:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case CommandMessage.COMMAND_UNREGISTER /* 12290 */:
                    return "EGL_BAD_ACCESS";
                case CommandMessage.COMMAND_STATISTIC /* 12291 */:
                    return "EGL_BAD_ALLOC";
                case CommandMessage.COMMAND_SET_ALIAS /* 12292 */:
                    return "EGL_BAD_ATTRIBUTE";
                case CommandMessage.COMMAND_GET_ALIAS /* 12293 */:
                    return "EGL_BAD_CONFIG";
                case CommandMessage.COMMAND_UNSET_ALIAS /* 12294 */:
                    return "EGL_BAD_CONTEXT";
                case CommandMessage.COMMAND_SET_TAGS /* 12295 */:
                    return "EGL_BAD_CURRENT_SURFACE";
                case CommandMessage.COMMAND_GET_TAGS /* 12296 */:
                    return "EGL_BAD_DISPLAY";
                case CommandMessage.COMMAND_UNSET_TAGS /* 12297 */:
                    return "EGL_BAD_MATCH";
                case CommandMessage.COMMAND_SET_PUSH_TIME /* 12298 */:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case CommandMessage.COMMAND_PAUSE_PUSH /* 12299 */:
                    return "EGL_BAD_NATIVE_WINDOW";
                case CommandMessage.COMMAND_RESUME_PUSH /* 12300 */:
                    return "EGL_BAD_PARAMETER";
                case CommandMessage.COMMAND_SET_ACCOUNTS /* 12301 */:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i);
            }
        }

        private String b(int i) {
            return "0x" + Integer.toHexString(i);
        }

        public void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public String b(String str, int i) {
            return str + " failed: " + a(i);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.b, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                a("eglDestroyContex", egl10.eglGetError());
            }
            MapTextureView.this.onRecycle();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i);
    }

    public MapTextureView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = new ArrayList();
        setEGLContextClientVersion(2);
        this.j = new ah();
        this.k = new GestureDetector(context, this.j);
    }

    public MapTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = new ArrayList();
        setEGLContextClientVersion(2);
        this.j = new ah();
        this.k = new GestureDetector(context, this.j);
    }

    public MapTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.h = new ArrayList();
        setEGLContextClientVersion(2);
        this.j = new ah();
        this.k = new GestureDetector(context, this.j);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean addOverlay(Overlay overlay) {
        if (overlay == null || this.b == null) {
            return false;
        }
        AppBaseMap baseMap = this.b.getBaseMap();
        if (baseMap == null) {
            return false;
        }
        if (overlay instanceof InnerOverlay) {
            if (((InnerOverlay) overlay).mBaseMap == null) {
                ((InnerOverlay) overlay).mBaseMap = getController().getBaseMap();
            }
            if (((InnerOverlay) overlay).addedToMapView()) {
                this.h.add(overlay);
                this.c.a((InnerOverlay) overlay);
                return true;
            }
            return false;
        } else if (overlay instanceof ItemizedOverlay) {
            overlay.mLayerID = baseMap.AddLayer(((ItemizedOverlay) overlay).getUpdateType(), 0, MapController.ITEM_LAYER_TAG);
            if (overlay.mLayerID == 0) {
                return false;
            }
            this.h.add(overlay);
            ((ItemizedOverlay) overlay).a();
            baseMap.SetLayersClickable(overlay.mLayerID, true);
            baseMap.ShowLayers(overlay.mLayerID, true);
            baseMap.UpdateLayers(overlay.mLayerID);
            return true;
        } else {
            return false;
        }
    }

    public void animateTo(MapStatus mapStatus, int i) {
        if (this.b != null) {
            this.b.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public void attachBaseMapController(MapController mapController) {
        this.e = new m(this, this);
        this.b = mapController;
        this.e.a(mapController.getBaseMap());
        setEGLContextFactory(new a());
        setRenderer(this.e);
        setRenderMode(0);
        this.e.a(true);
        this.c = new ac(this.b.getBaseMap());
        this.b.setOverlayMapCallBack(this.c);
        this.b.setMapViewInterface(this);
        b();
        this.b.setMapRenderModeChangeListener(this);
        this.d = new k(this.b);
        this.j.a(this.b);
    }

    protected void b() {
        if (this.b == null || this.b.getBaseMap() == null) {
            return;
        }
        c();
    }

    protected void c() {
        if (this.b == null || this.b.getBaseMap() == null || this.c == null) {
            return;
        }
        this.h.clear();
        this.c.a();
    }

    public void destroyForMultiViews() {
        if (this.b != null) {
            this.b.unInitForMultiTextureView();
            this.b = null;
        }
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        this.d = null;
    }

    public void doCaptureMapView(c cVar, int i, int i2, Bitmap.Config config) {
        this.e.a(cVar, i, i2, config);
    }

    public void doCaptureMapView(c cVar, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i = rect.left;
            int i2 = this.g < rect.bottom ? 0 : this.g - rect.bottom;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i2 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.f) {
                width = Math.abs(rect.width()) - (rect.right - this.f);
            }
            if (height > this.g) {
                height = Math.abs(rect.height()) - (rect.bottom - this.g);
            }
            if (i > SysOSUtil.getScreenSizeX() || i2 > SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.e.a(cVar, i, i2, width, height, config);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return false;
    }

    public com.baidu.mapsdkplatform.comapi.map.d getBaseMap() {
        return this.f2884a;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.b;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        if (this.b != null) {
            return this.b.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        if (this.b != null) {
            return this.b.getCurrentZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        if (this.b == null) {
            return null;
        }
        return this.b.getMapStatus().geoRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        k kVar = (k) getProjection();
        return (int) Math.abs(kVar.fromPixels(0, 0).getLatitude() - kVar.fromPixels(this.f - 1, this.g - 1).getLatitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLongitudeSpan() {
        k kVar = (k) getProjection();
        return (int) Math.abs(kVar.fromPixels(this.f - 1, this.g - 1).getLongitude() - kVar.fromPixels(0, 0).getLongitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public GeoPoint getMapCenter() {
        if (this.b == null) {
            return null;
        }
        MapStatus mapStatus = this.b.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        if (this.b == null) {
            return 0;
        }
        return this.b.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        if (this.b != null) {
            return this.b.getMapStatus();
        }
        return null;
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        Overlay overlay;
        Iterator<Overlay> it = this.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                overlay = null;
                break;
            }
            overlay = it.next();
            if (overlay.getClass() == cls) {
                break;
            }
        }
        return overlay;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public List<Overlay> getOverlays() {
        return this.h;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getOverlooking() {
        if (this.b == null) {
            return 0;
        }
        return this.b.getMapStatus().overlooking;
    }

    public Overlay getPopupOverlay() {
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.d;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        if (this.b == null) {
            return null;
        }
        return this.b.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        if (this.b != null) {
            return this.b.getZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        return getZoomToBound(mapBound, this.f, this.g);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        if (this.b == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapBound.leftBottomPt.getIntY());
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapBound.rightTopPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.TOP, mapBound.rightTopPt.getIntY());
        return this.b.getZoomToBound(bundle, i, i2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        return getZoomToBoundF(mapBound, this.f, this.g);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        if (this.b == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapBound.leftBottomPt.getIntY());
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapBound.rightTopPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.TOP, mapBound.rightTopPt.getIntY());
        return this.b.getZoomToBoundF(bundle);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return false;
    }

    public void listenMapRenderMessage(b bVar) {
        this.l = bVar;
    }

    public void onDestroy() {
        if (this.f2884a != null) {
            if (this.f2884a.h != null) {
                for (ag agVar : this.f2884a.h) {
                    if (agVar != null) {
                        agVar.d();
                    }
                }
            }
            this.f2884a.I();
            this.f2884a = null;
        }
        this.b.unInit();
        this.b = null;
        this.c.a();
        this.c = null;
        this.d = null;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
        if (this.l != null) {
            this.l.a(i);
        }
        if (i == 1) {
            requestRender();
        } else if (i == 0) {
            if (getRenderMode() != 0) {
                setRenderMode(0);
            }
        } else if (i != 2 || this.i == null) {
        } else {
            this.i.a();
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onPause() {
        if (this.b != null) {
            this.b.getBaseMap().OnPause();
        }
        super.onPause();
    }

    public void onRecycle() {
        if (this.b == null || this.b.getBaseMap() == null) {
            return;
        }
        this.b.getBaseMap().ResetImageRes();
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView
    public void onResume() {
        if (this.b != null) {
            this.b.getBaseMap().OnResume();
        }
        super.onResume();
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        this.f = i;
        this.g = i2;
        if (this.f2884a != null) {
            this.f2884a.a(this.f, this.g);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        this.f = i;
        this.g = i2;
        this.e.f2923a = i;
        this.e.b = i2;
        this.e.c = 0;
        if (this.b != null) {
            MapStatus mapStatus = getMapStatus();
            mapStatus.winRound.left = 0;
            mapStatus.winRound.top = 0;
            mapStatus.winRound.bottom = i2;
            mapStatus.winRound.right = i;
            setMapStatus(mapStatus);
            this.b.setScreenSize(this.f, this.g);
        }
        if (this.f2884a != null) {
            this.f2884a.a(this.f, this.g);
        }
    }

    @Override // com.baidu.platform.comapi.map.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureUpdated(surfaceTexture);
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.k == null || !this.k.onTouchEvent(motionEvent)) {
                if (this.b != null) {
                    if (this.b.handleTouchEvent(motionEvent)) {
                        return true;
                    }
                }
                return super.onTouchEvent(motionEvent);
            }
            return true;
        } catch (Exception e) {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void refresh(Overlay overlay) {
        if (overlay == null || this.b == null) {
            return;
        }
        if ((overlay instanceof ItemizedOverlay) && ((ItemizedOverlay) overlay).b()) {
            if (((ItemizedOverlay) overlay).getAllItem().size() <= 0) {
                this.b.getBaseMap().ClearLayer(overlay.mLayerID);
                this.b.getBaseMap().ShowLayers(overlay.mLayerID, false);
                this.b.getBaseMap().UpdateLayers(overlay.mLayerID);
            } else {
                this.b.getBaseMap().ShowLayers(overlay.mLayerID, true);
                this.b.getBaseMap().UpdateLayers(overlay.mLayerID);
            }
            ((ItemizedOverlay) overlay).a(false);
        }
        if (this.b == null || this.b.getBaseMap() == null) {
            return;
        }
        this.b.getBaseMap().UpdateLayers(overlay.mLayerID);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean removeOverlay(Overlay overlay) {
        AppBaseMap baseMap;
        if (overlay == null || this.b == null || (baseMap = this.b.getBaseMap()) == null) {
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

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.f2884a = dVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        if (this.b != null) {
            MapStatus mapStatus = this.b.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.b.setMapStatus(mapStatus);
        }
    }

    public void setMapRenderStableListener(z zVar) {
        this.i = zVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        if (this.b != null) {
            this.b.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        if (this.b != null) {
            MapStatus mapStatus = this.b.getMapStatus();
            mapStatus.overlooking = i;
            this.b.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        if (this.b != null) {
            MapStatus mapStatus = this.b.getMapStatus();
            mapStatus.rotation = i;
            this.b.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        AppBaseMap baseMap;
        if (this.b == null || (baseMap = this.b.getBaseMap()) == null) {
            return;
        }
        baseMap.ShowTrafficMap(z);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        if (this.b != null) {
            MapStatus mapStatus = this.b.getMapStatus();
            mapStatus.winRound = winRound;
            this.b.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f) {
        if (this.b == null) {
            return;
        }
        int i = getController().getFocusedBaseIndoorMapInfo() != null ? 22 : 21;
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
    public void setZoomLevel(int i) {
        setZoomLevel(i);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || this.b == null || (baseMap = this.b.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unListenMapRenderMessage() {
        this.l = null;
    }
}
