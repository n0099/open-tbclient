package com.baidu.platform.comapi.map;

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
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.basestruct.MapBound;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.ae;
import com.baidu.platform.comapi.map.f;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.heytap.mcssdk.mode.CommandMessage;
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
/* loaded from: classes3.dex */
public class MapSurfaceView extends RenderSurfaceView implements View.OnKeyListener, MapRenderModeChangeListener, MapViewInterface, af {
    private static int s = 0;
    private static final ExecutorService y = Executors.newSingleThreadExecutor();
    private int A;
    private int B;
    protected MapController a;
    protected ac b;
    protected k c;
    protected m d;
    protected volatile boolean e;
    protected boolean f;
    protected ah g;
    protected GestureDetector h;
    protected z i;
    protected com.baidu.mapsdkplatform.comapi.map.d j;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private boolean p;
    private boolean q;
    private LocationOverlay r;
    private List<Overlay> t;
    private int u;
    private int v;
    private HashSet<y> w;
    private boolean x;
    private int z;

    /* loaded from: classes3.dex */
    private class a implements f.InterfaceC0242f {
        private int b;

        private a() {
            this.b = 12440;
        }

        /* synthetic */ a(MapSurfaceView mapSurfaceView, q qVar) {
            this();
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

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0242f
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.b, 2, 12344});
        }

        public void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0242f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("MapContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                a("eglDestroyContex", egl10.eglGetError());
            }
            MapSurfaceView.this.onRecycle();
        }

        public String b(String str, int i) {
            return str + " failed: " + a(i);
        }
    }

    /* loaded from: classes3.dex */
    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        /* synthetic */ b(MapSurfaceView mapSurfaceView, q qVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            if (MapSurfaceView.this.a == null || MapSurfaceView.this.a.getBaseMap() == null || !MapSurfaceView.this.a.mIsMapLoadFinish) {
                return;
            }
            String GetNearlyObjID = MapSurfaceView.this.a.getBaseMap().GetNearlyObjID(-1L, (int) motionEvent.getX(), (int) motionEvent.getY(), MapSurfaceView.this.a.nearlyRadius);
            if (GetNearlyObjID == null || GetNearlyObjID.equals("")) {
                if (MapSurfaceView.this.a.mListeners != null) {
                    for (ag agVar : MapSurfaceView.this.a.mListeners) {
                        GeoPoint fromPixels = MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (agVar != null) {
                            agVar.c(fromPixels);
                        }
                    }
                }
            } else if (MapSurfaceView.this.a.mListeners != null) {
                for (ag agVar2 : MapSurfaceView.this.a.mListeners) {
                    if (agVar2 != null) {
                        if (agVar2.b(GetNearlyObjID)) {
                            MapSurfaceView.this.a.mHasMapObjDraging = true;
                        } else {
                            agVar2.c(MapSurfaceView.this.getProjection().fromPixels((int) motionEvent.getX(), (int) motionEvent.getY()));
                        }
                    }
                }
            }
        }
    }

    public MapSurfaceView(Context context) {
        super(context);
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
        this.t = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.w = new HashSet<>();
        this.f = true;
        this.x = true;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        s++;
    }

    public MapSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
        this.t = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.w = new HashSet<>();
        this.f = true;
        this.x = true;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        s++;
    }

    public MapSurfaceView(Context context, ae.a aVar) {
        super(context, aVar);
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
        this.t = new ArrayList();
        this.u = 0;
        this.v = 0;
        this.w = new HashSet<>();
        this.f = true;
        this.x = true;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        s++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.map.RenderSurfaceView
    public ad a(ae.a aVar) {
        if (aVar == ae.a.OPENGL_ES) {
            f fVar = (f) super.a(aVar);
            if (this.x) {
                fVar.a(new a(this, null));
                return fVar;
            }
            return fVar;
        }
        return super.a(aVar);
    }

    protected void a() {
        if (this.a == null || this.a.getBaseMap() == null || this.b == null) {
            return;
        }
        this.t.clear();
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.platform.comapi.map.RenderSurfaceView
    public void a(Context context, ae.a aVar) {
        super.a(context, aVar);
        setBackgroundColor(Color.rgb(244, (int) BaseActivity.DIALOG_LOADING, 240));
        setPixelFormatTransparent(false);
        this.g = new ah();
        this.h = new GestureDetector(context, this.g);
        this.d = new m(new WeakReference(this), this);
        setRenderer(this.d);
        setRenderMode(1);
        this.g.a(new b(this, null));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean addOverlay(Overlay overlay) {
        boolean z;
        if (overlay != null) {
            if (this.a != null) {
                AppBaseMap baseMap = this.a.getBaseMap();
                if (baseMap == null) {
                    z = false;
                } else if (overlay instanceof aj) {
                    z = ((InnerOverlay) overlay).addedToMapView();
                } else if (overlay instanceof InnerOverlay) {
                    if (((InnerOverlay) overlay).mBaseMap == null) {
                        ((InnerOverlay) overlay).mBaseMap = getController().getBaseMap();
                    }
                    if (((InnerOverlay) overlay).addedToMapView()) {
                        synchronized (this) {
                            this.t.add(overlay);
                            this.b.a((InnerOverlay) overlay);
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                } else if (overlay instanceof ItemizedOverlay) {
                    overlay.mLayerID = baseMap.AddLayer(((ItemizedOverlay) overlay).getUpdateType(), 0, MapController.ITEM_LAYER_TAG);
                    if (overlay.mLayerID == 0) {
                        z = false;
                    } else {
                        synchronized (this) {
                            this.t.add(overlay);
                            ((ItemizedOverlay) overlay).a();
                            baseMap.SetLayersClickable(overlay.mLayerID, true);
                            baseMap.ShowLayers(overlay.mLayerID, true);
                            baseMap.UpdateLayers(overlay.mLayerID);
                            z = true;
                        }
                    }
                } else {
                    z = false;
                }
            }
        }
        z = false;
        return z;
    }

    public void addSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.g.a(simpleOnGestureListener);
    }

    public void addStateListener(y yVar) {
        if (yVar != null) {
            this.w.add(yVar);
        }
    }

    public void animateTo(MapStatus mapStatus, int i) {
        if (this.a != null) {
            this.a.setMapStatusWithAnimation(mapStatus, i);
        }
    }

    public void animateTo(MapStatus mapStatus, int i, int i2) {
        if (this.a != null) {
            this.a.setMapStatusWithAnimation(mapStatus, i, i2);
        }
    }

    protected void b() {
        if (this.a == null || this.a.getBaseMap() == null) {
            return;
        }
        a();
    }

    public void beginLocationLayerAnimation() {
        if (this.r != null) {
            this.r.beginLocationLayerAnimation();
        }
    }

    public void clearDefaultLocationLayerData(Bundle bundle) {
        this.r.clearLocationLayerData(bundle);
    }

    public void doCaptureMapView(c cVar, int i, int i2) {
        this.d.a(cVar, i, i2);
    }

    public void doCaptureMapView(c cVar, int i, int i2, Bitmap.Config config) {
        this.d.a(cVar, i, i2, config);
    }

    public void doCaptureMapView(c cVar, Rect rect, Bitmap.Config config) {
        if (rect != null) {
            int i = rect.left;
            int i2 = this.v < rect.bottom ? 0 : this.v - rect.bottom;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i2 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.u) {
                width = Math.abs(rect.width()) - (rect.right - this.u);
            }
            if (height > this.v) {
                height = Math.abs(rect.height()) - (rect.bottom - this.v);
            }
            if (i > SysOSUtil.getScreenSizeX() || i2 > SysOSUtil.getScreenSizeY()) {
                return;
            }
            this.d.a(cVar, i, i2, width, height, config);
            requestRender();
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean enable3D() {
        return true;
    }

    public void forceSetTraffic(boolean z) {
        if (this.a != null) {
            this.l = z;
        }
        y.submit(new r(this));
    }

    public com.baidu.mapsdkplatform.comapi.map.d getBaseMap() {
        return this.j;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapController getController() {
        return this.a;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getCurrentMapStatus() {
        if (this.a != null) {
            return this.a.getCurrentMapStatus();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getCurrentZoomLevel() {
        if (this.a != null) {
            return this.a.getCurrentZoomLevel();
        }
        return 0.0f;
    }

    public LocationOverlay getDefaultLocationLay() {
        return this.r;
    }

    public float getFZoomToBoundF(MapBound mapBound, MapBound mapBound2) {
        if (this.a == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapBound.leftBottomPt.getIntY());
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapBound.rightTopPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.TOP, mapBound.rightTopPt.getIntY());
        Bundle bundle2 = new Bundle();
        bundle2.putInt("left", mapBound2.leftBottomPt.getIntX());
        bundle2.putInt(VerticalTranslateLayout.BOTTOM, mapBound2.leftBottomPt.getIntY());
        bundle2.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapBound2.rightTopPt.getIntX());
        bundle2.putInt(VerticalTranslateLayout.TOP, mapBound2.rightTopPt.getIntY());
        return this.a.GetFZoomToBoundF(bundle, bundle2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.GeoBound getGeoRound() {
        if (this.a == null) {
            return null;
        }
        return this.a.getMapStatus().geoRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLatitudeSpan() {
        k kVar = (k) getProjection();
        return (int) Math.abs(kVar.fromPixels(0, 0).getLatitude() - kVar.fromPixels(this.u - 1, this.v - 1).getLatitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getLongitudeSpan() {
        k kVar = (k) getProjection();
        return (int) Math.abs(kVar.fromPixels(this.u - 1, this.v - 1).getLongitude() - kVar.fromPixels(0, 0).getLongitude());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public GeoPoint getMapCenter() {
        if (this.a == null) {
            return null;
        }
        MapStatus mapStatus = this.a.getMapStatus();
        return new GeoPoint(mapStatus.centerPtY, mapStatus.centerPtX);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getMapRotation() {
        if (this.a == null) {
            return 0;
        }
        return this.a.getMapStatus().rotation;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus getMapStatus() {
        if (this.a != null) {
            return this.a.getMapStatus();
        }
        return null;
    }

    public MapViewListener getMapViewListener() {
        if (this.a != null) {
            return this.a.getMapViewListener();
        }
        return null;
    }

    public OnLongPressListener getOnLongPressListener() {
        return this.g.a();
    }

    public synchronized Overlay getOverlay(int i) {
        Overlay overlay;
        if (i != 21) {
            Iterator<Overlay> it = this.t.iterator();
            while (true) {
                if (!it.hasNext()) {
                    overlay = null;
                    break;
                }
                overlay = it.next();
                if (overlay.mType == i) {
                    break;
                }
            }
        } else {
            overlay = null;
        }
        return overlay;
    }

    public synchronized Overlay getOverlay(Class<?> cls) {
        Overlay overlay;
        Iterator<Overlay> it = this.t.iterator();
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
        return this.t;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public int getOverlooking() {
        if (this.a == null) {
            return 0;
        }
        return this.a.getMapStatus().overlooking;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public Projection getProjection() {
        return this.c;
    }

    public ExecutorService getSingleThreadPool() {
        return y;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public MapStatus.WinRound getWinRound() {
        if (this.a == null) {
            return null;
        }
        return this.a.getMapStatus().winRound;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomLevel() {
        if (this.a != null) {
            return this.a.getZoomLevel();
        }
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound) {
        com.baidu.platform.comapi.util.SysOSUtil sysOSUtil = com.baidu.platform.comapi.util.SysOSUtil.getInstance();
        return getZoomToBound(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBound(MapBound mapBound, int i, int i2) {
        if (this.a == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapBound.leftBottomPt.getIntY());
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapBound.rightTopPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.TOP, mapBound.rightTopPt.getIntY());
        return this.a.getZoomToBound(bundle, i, i2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound) {
        com.baidu.platform.comapi.util.SysOSUtil sysOSUtil = com.baidu.platform.comapi.util.SysOSUtil.getInstance();
        return getZoomToBoundF(mapBound, sysOSUtil.getScreenWidth(), sysOSUtil.getScreenHeight());
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public float getZoomToBoundF(MapBound mapBound, int i, int i2) {
        if (this.a == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", mapBound.leftBottomPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.BOTTOM, mapBound.leftBottomPt.getIntY());
        bundle.putInt(HorizontalTranslateLayout.DIRECTION_RIGHT, mapBound.rightTopPt.getIntX());
        bundle.putInt(VerticalTranslateLayout.TOP, mapBound.rightTopPt.getIntY());
        return this.a.getZoomToBoundF(bundle);
    }

    public boolean inRangeOfView(float f, float f2) {
        return f >= ((float) 0) && f <= ((float) (this.u + 0)) && f2 >= ((float) 0) && f2 <= ((float) (this.v + 0));
    }

    public synchronized boolean insertOverlay(Overlay overlay, int i) {
        if ((overlay instanceof InnerOverlay) && this.a != null) {
            if (((InnerOverlay) overlay).mBaseMap == null) {
                ((InnerOverlay) overlay).mBaseMap = this.a.getBaseMap();
            }
            this.t.add(overlay);
            this.b.a((InnerOverlay) overlay);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isBaseIndoorMap() {
        return this.o;
    }

    public boolean isPredictTraffic() {
        return this.z > 0 || this.A > 0 || this.B > 0;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isSatellite() {
        return this.m;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isStreetRoad() {
        return this.n;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean isTraffic() {
        return this.l;
    }

    @Override // com.baidu.platform.comapi.map.RenderSurfaceView, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.a.updateDrawFPS();
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.f = false;
        }
    }

    public void onBackground() {
        if (this.q) {
            return;
        }
        if (this.a != null && this.a.getBaseMap() != null) {
            this.a.getBaseMap().OnBackground();
        }
        this.q = true;
    }

    @Override // com.baidu.platform.comapi.map.RenderSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        if (this.a != null) {
            this.a.updateDrawFPS();
        }
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 14) {
            this.f = true;
        }
    }

    public void onForeground() {
        if (this.q) {
            if (this.a != null && this.a.getBaseMap() != null) {
                this.a.getBaseMap().OnForeground();
            }
            this.q = false;
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this == view && keyEvent.getAction() == 0) {
            switch (i) {
                case 19:
                    this.a.scrollBy(0, -50);
                    break;
                case 20:
                    this.a.scrollBy(0, 50);
                    break;
                case 21:
                    this.a.scrollBy(-50, 0);
                    break;
                case 22:
                    this.a.scrollBy(50, 0);
                    break;
                default:
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onMapRenderModeChange(int i) {
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

    @Override // com.baidu.platform.comapi.map.RenderSurfaceView
    public void onPause() {
        if (this.p) {
            return;
        }
        if (this.d != null) {
            this.d.b();
        }
        if (this.a != null) {
            this.a.onPause();
        }
        Iterator<y> it = this.w.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        super.onPause();
        this.p = true;
    }

    public void onRecycle() {
        if (this.a == null || this.a.getBaseMap() == null) {
            return;
        }
        this.a.getBaseMap().ResetImageRes();
    }

    @Override // com.baidu.platform.comapi.map.MapRenderModeChangeListener
    public void onRequestRender() {
        requestRender();
    }

    @Override // com.baidu.platform.comapi.map.RenderSurfaceView
    public void onResume() {
        if (this.p && this.e) {
            if (this.d != null) {
                this.d.a();
            }
            if (this.a != null) {
                this.a.onResume();
            }
            Iterator<y> it = this.w.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
            setRenderMode(1);
            super.onResume();
            this.p = false;
        }
    }

    @Override // android.view.View, com.baidu.platform.comapi.map.MapViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.h == null || !this.h.onTouchEvent(motionEvent)) {
                if (this.a != null) {
                    if (this.a.handleTouchEvent(motionEvent)) {
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
        if (overlay == null || this.a == null) {
            return;
        }
        if ((overlay instanceof ItemizedOverlay) && ((ItemizedOverlay) overlay).b()) {
            if (((ItemizedOverlay) overlay).getAllItem().size() <= 0) {
                this.a.getBaseMap().ClearLayer(overlay.mLayerID);
                this.a.getBaseMap().ShowLayers(overlay.mLayerID, false);
                this.a.getBaseMap().UpdateLayers(overlay.mLayerID);
            } else {
                this.a.getBaseMap().ShowLayers(overlay.mLayerID, true);
                this.a.getBaseMap().UpdateLayers(overlay.mLayerID);
            }
            ((ItemizedOverlay) overlay).a(false);
        }
        if (this.a == null || this.a.getBaseMap() == null) {
            return;
        }
        this.a.getBaseMap().UpdateLayers(overlay.mLayerID);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public synchronized boolean removeOverlay(Overlay overlay) {
        AppBaseMap baseMap;
        boolean z = false;
        synchronized (this) {
            if (overlay != null) {
                if (this.a != null && (baseMap = this.a.getBaseMap()) != null) {
                    baseMap.ClearLayer(overlay.mLayerID);
                    baseMap.ShowLayers(overlay.mLayerID, false);
                    baseMap.UpdateLayers(overlay.mLayerID);
                    baseMap.RemoveLayer(overlay.mLayerID);
                    synchronized (this) {
                        if (overlay instanceof ItemizedOverlay) {
                            this.t.remove(overlay);
                        } else if (overlay instanceof InnerOverlay) {
                            this.t.remove(overlay);
                            this.b.a(overlay);
                        }
                        overlay.mLayerID = 0L;
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public void removeSimpleOnGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.g.b(simpleOnGestureListener);
    }

    public void removeStateListener(y yVar) {
        if (yVar != null) {
            this.w.remove(yVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void saveScreenToLocal(String str) {
        if (this.a != null) {
            this.a.saveScreenToLocal(str);
        }
    }

    public void saveScreenToLocal(String str, Rect rect) {
        String str2;
        if (this.j == null || this.j.a() == null) {
            return;
        }
        if (rect == null) {
            this.j.a().SaveScreenToLocal(str, null);
            return;
        }
        int i = rect.left;
        int i2 = this.v < rect.bottom ? 0 : this.v - rect.bottom;
        int width = rect.width();
        int height = rect.height();
        if (i < 0 || i2 < 0 || width <= 0 || height <= 0) {
            return;
        }
        if (width > this.u) {
            width = Math.abs(rect.width()) - (rect.right - this.u);
        }
        if (height > this.v) {
            height = Math.abs(rect.height()) - (rect.bottom - this.v);
        }
        if (i > SysOSUtil.getScreenSizeX() || i2 > SysOSUtil.getScreenSizeY()) {
            this.j.a().SaveScreenToLocal(str, null);
            return;
        }
        if (width == 0 || height == 0) {
            str2 = null;
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", i);
                jSONObject.put("y", i2);
                jSONObject.put("width", width);
                jSONObject.put("height", height);
                str2 = jSONObject.toString();
            } catch (Exception e) {
                str2 = null;
            }
        }
        this.j.a().SaveScreenToLocal(str, str2);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setBaseIndoorMap(boolean z) {
        if (this.a != null) {
            this.o = z;
        }
        y.submit(new u(this, z));
    }

    public void setBaseMap(com.baidu.mapsdkplatform.comapi.map.d dVar) {
        this.j = dVar;
    }

    public void setDefaultLocationLayerData(List<OverlayLocationData> list) {
        this.r.setLocationLayerData(list);
    }

    public void setFirstFrameListener(e eVar) {
        if (this.d != null) {
            this.d.a(eVar);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setGeoRound(MapStatus.GeoBound geoBound) {
    }

    public boolean setItsPreTime(int i, int i2, int i3) {
        AppBaseMap baseMap;
        if (this.z == i && this.A == i2 && this.B == i3) {
            return true;
        }
        if (this.a == null || (baseMap = this.a.getBaseMap()) == null) {
            return false;
        }
        this.z = i;
        this.A = i2;
        this.B = i3;
        return baseMap.SetItsPreTime(i, i2, i3);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapCenter(GeoPoint geoPoint) {
        if (this.a != null) {
            MapStatus mapStatus = this.a.getMapStatus();
            mapStatus.centerPtX = geoPoint.getLongitude();
            mapStatus.centerPtY = geoPoint.getLatitude();
            this.a.setMapStatus(mapStatus);
        }
    }

    public void setMapController(MapController mapController) {
        if (this.a != null) {
            return;
        }
        this.a = mapController;
        this.d.a(this.a.getBaseMap());
        this.d.a(true);
        this.b = new ac(this.a.getBaseMap());
        this.a.setOverlayMapCallBack(this.b);
        this.a.setMapViewInterface(this);
        b();
        this.a.setMapRenderModeChangeListener(this);
        this.e = true;
        this.c = new k(this.a);
        this.g.a(this.a);
    }

    public void setMapRenderStableListener(z zVar) {
        this.i = zVar;
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapStatus(MapStatus mapStatus) {
        if (this.a != null) {
            this.a.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setMapTo2D(boolean z) {
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        this.g.a(onLongPressListener);
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setOverlooking(int i) {
        if (this.a != null) {
            MapStatus mapStatus = this.a.getMapStatus();
            mapStatus.overlooking = i;
            this.a.setMapStatus(mapStatus);
        }
    }

    public void setPixelFormatTransparent(boolean z) {
        if (z) {
            getHolder().setFormat(-3);
        } else {
            getHolder().setFormat(-1);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setRotation(int i) {
        if (this.a != null) {
            MapStatus mapStatus = this.a.getMapStatus();
            mapStatus.rotation = i;
            this.a.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setSatellite(boolean z) {
        if (this.a != null) {
            this.m = z;
        }
        y.submit(new q(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setStreetRoad(boolean z) {
        if (this.a != null) {
            this.n = z;
        }
        y.submit(new t(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setTraffic(boolean z) {
        if (this.l == z) {
            return;
        }
        if (this.a != null) {
            this.l = z;
        }
        y.submit(new s(this));
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setWinRound(MapStatus.WinRound winRound) {
        if (this.a != null) {
            MapStatus mapStatus = this.a.getMapStatus();
            mapStatus.winRound = winRound;
            this.a.setMapStatus(mapStatus);
        }
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public void setZoomLevel(float f) {
        if (this.a == null) {
            return;
        }
        int i = getController().getFocusedBaseIndoorMapInfo() != null ? 22 : 21;
        if (f < 4.0f) {
            f = 4.0f;
        } else if (f > i) {
            f = i;
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

    @Override // com.baidu.platform.comapi.map.RenderSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.a != null) {
            this.a.updateDrawFPS();
        }
        if (this.d != null) {
            this.d.a = i2;
            this.d.b = i3;
            this.d.c = 0;
        }
        this.u = i2;
        this.v = i3;
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        if (this.a != null) {
            MapStatus mapStatus = getMapStatus();
            if (mapStatus != null) {
                mapStatus.winRound.left = 0;
                mapStatus.winRound.top = 0;
                mapStatus.winRound.bottom = i3;
                mapStatus.winRound.right = i2;
                setMapStatus(mapStatus);
            }
            this.a.setScreenSize(this.u, this.v);
            if (this.a.isNaviMode() && this.a.getNaviMapViewListener() != null) {
                this.a.getNaviMapViewListener().resizeScreen(i2, i3);
            }
        }
        if (this.j != null) {
            this.j.a(this.u, this.v);
        }
    }

    @Override // com.baidu.platform.comapi.map.RenderSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.a != null) {
            this.a.updateDrawFPS();
        }
        super.surfaceCreated(surfaceHolder);
        if (surfaceHolder == null || surfaceHolder.getSurface().isValid()) {
            return;
        }
        surfaceDestroyed(surfaceHolder);
    }

    @Override // com.baidu.platform.comapi.map.RenderSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.a != null) {
            this.a.updateDrawFPS();
        }
        super.surfaceDestroyed(surfaceHolder);
        if (this.x) {
            return;
        }
        onRecycle();
    }

    @Override // com.baidu.platform.comapi.map.MapViewInterface
    public boolean switchOverlay(Overlay overlay, Overlay overlay2) {
        AppBaseMap baseMap;
        if (overlay == null || overlay2 == null || this.a == null || (baseMap = this.a.getBaseMap()) == null) {
            return false;
        }
        return baseMap.SwitchLayer(overlay.mLayerID, overlay2.mLayerID);
    }

    public void unInit() {
        if (this.j != null) {
            if (this.j.h != null) {
                for (ag agVar : this.j.h) {
                    if (agVar != null) {
                        agVar.d();
                    }
                }
            }
            this.j.I();
            this.j = null;
        }
        this.a.unInit();
        this.a = null;
        this.b.a();
        this.b = null;
        this.c = null;
        this.d = null;
    }
}
