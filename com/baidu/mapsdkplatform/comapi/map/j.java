package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.MapRenderer;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class j extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7685a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Handler f7686b;

    /* renamed from: c  reason: collision with root package name */
    public MapRenderer f7687c;

    /* renamed from: d  reason: collision with root package name */
    public int f7688d;

    /* renamed from: e  reason: collision with root package name */
    public int f7689e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f7690f;

    /* renamed from: g  reason: collision with root package name */
    public e f7691g;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f7692a;

        /* renamed from: b  reason: collision with root package name */
        public float f7693b;

        /* renamed from: c  reason: collision with root package name */
        public float f7694c;

        /* renamed from: d  reason: collision with root package name */
        public float f7695d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7696e;

        /* renamed from: f  reason: collision with root package name */
        public float f7697f;

        /* renamed from: g  reason: collision with root package name */
        public float f7698g;

        /* renamed from: h  reason: collision with root package name */
        public double f7699h;

        public String toString() {
            return "MultiTouch{x1=" + this.f7692a + ", x2=" + this.f7693b + ", y1=" + this.f7694c + ", y2=" + this.f7695d + ", mTwoTouch=" + this.f7696e + ", centerX=" + this.f7697f + ", centerY=" + this.f7698g + ", length=" + this.f7699h + '}';
        }
    }

    public j(Context context, z zVar, String str, int i2) {
        super(context);
        if (context == null) {
            throw new RuntimeException("BDMapSDKException: when you create an mapview, the context can not be null");
        }
        setEGLContextClientVersion(2);
        this.f7690f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.f7691g == null) {
            this.f7691g = new e(context, str, i2);
        }
        this.f7691g.a(context.hashCode());
        g();
        this.f7691g.a();
        this.f7691g.a(zVar);
        h();
        this.f7691g.a(this.f7686b);
        this.f7691g.f();
        setBackgroundColor(0);
    }

    public static boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }

    private void g() {
        try {
            if (a(8, 8, 8, 8, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0);
            } else if (a(5, 6, 5, 0, 24, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        MapRenderer mapRenderer = new MapRenderer(this, this);
        this.f7687c = mapRenderer;
        mapRenderer.a(this.f7691g.j);
        setRenderer(this.f7687c);
        setRenderMode(1);
    }

    private void h() {
        this.f7686b = new k(this);
    }

    public e a() {
        return this.f7691g;
    }

    public void a(float f2, float f3) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return;
        }
        eVar.b(f2, f3);
    }

    public void a(int i2) {
        int i3;
        if (this.f7691g == null) {
            return;
        }
        Message message = new Message();
        message.what = 50;
        message.obj = Long.valueOf(this.f7691g.j);
        boolean q = this.f7691g.q();
        if (i2 != 3) {
            i3 = q ? 1 : 1;
            this.f7686b.sendMessage(message);
        }
        i3 = 0;
        message.arg1 = i3;
        this.f7686b.sendMessage(message);
    }

    public void a(String str, Rect rect) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.f7691g;
        if (eVar == null || (aVar = eVar.f7668i) == null) {
            return;
        }
        if (rect != null) {
            int i2 = rect.left;
            int i3 = this.f7689e;
            int i4 = rect.bottom;
            int i5 = i3 < i4 ? 0 : i3 - i4;
            int width = rect.width();
            int height = rect.height();
            if (i2 < 0 || i5 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.f7688d) {
                width = Math.abs(rect.width()) - (rect.right - this.f7688d);
            }
            if (height > this.f7689e) {
                height = Math.abs(rect.height()) - (rect.bottom - this.f7689e);
            }
            if (i2 > SysOSUtil.getScreenSizeX() || i5 > SysOSUtil.getScreenSizeY()) {
                this.f7691g.f7668i.a(str, (Bundle) null);
                requestRender();
                return;
            }
            this.f7688d = width;
            this.f7689e = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i2);
            bundle.putInt("y", i5);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.f7691g.f7668i.a(str, bundle);
        } else {
            aVar.a(str, (Bundle) null);
        }
        requestRender();
    }

    public boolean a(float f2, float f3, float f4, float f5) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return false;
        }
        return eVar.a(f2, f3, f4, f5);
    }

    public void b() {
        e eVar = this.f7691g;
        if (eVar == null) {
            return;
        }
        eVar.u();
    }

    public void b(int i2) {
        e eVar = this.f7691g;
        if (eVar != null) {
            List<l> list = eVar.f7667h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.f();
                    }
                }
            }
            this.f7691g.b(this.f7686b);
            this.f7691g.b(i2);
            this.f7691g = null;
        }
        Handler handler = this.f7686b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public boolean b(float f2, float f3) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return false;
        }
        return eVar.d(f2, f3);
    }

    public void c() {
        e eVar = this.f7691g;
        if (eVar == null) {
            return;
        }
        eVar.v();
    }

    public boolean c(float f2, float f3) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return false;
        }
        return eVar.c(f2, f3);
    }

    public void d() {
        getHolder().setFormat(-3);
        this.f7691g.f7668i.s();
    }

    public boolean d(float f2, float f3) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return false;
        }
        return eVar.c((int) f2, (int) f3);
    }

    public void e() {
        getHolder().setFormat(-1);
        this.f7691g.f7668i.t();
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.MapRenderer.a
    public void f() {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null || !eVar.k) {
            return true;
        }
        GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (b2 != null) {
            List<l> list = this.f7691g.f7667h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.b(b2);
                    }
                }
            }
            e eVar2 = this.f7691g;
            if (eVar2.f7665f) {
                ab E = eVar2.E();
                E.f7614a += 1.0f;
                if (!this.f7691g.f7666g) {
                    E.f7617d = b2.getLongitudeE6();
                    E.f7618e = b2.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.f7691g.a(E, 300);
                e.m = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null || !eVar.k) {
            return true;
        }
        if (eVar.f7664e) {
            float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
            if (sqrt <= 500.0f) {
                return false;
            }
            BaiduMap.mapStatusReason |= 1;
            this.f7691g.A();
            this.f7691g.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
            this.f7691g.M();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.f7691g;
        if (eVar == null || (aVar = eVar.f7668i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7691g.l);
        if (a2 == null || a2.equals("")) {
            List<l> list = this.f7691g.f7667h;
            if (list != null) {
                for (l lVar : list) {
                    GeoPoint b2 = this.f7691g.b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.c(b2);
                    }
                }
                return;
            }
            return;
        }
        List<l> list2 = this.f7691g.f7667h;
        if (list2 != null) {
            for (l lVar2 : list2) {
                if (lVar2 != null) {
                    if (lVar2.b(a2)) {
                        this.f7691g.p = true;
                    } else {
                        lVar2.c(this.f7691g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        super.onPause();
        e eVar = this.f7691g;
        if (eVar == null || (aVar = eVar.f7668i) == null) {
            return;
        }
        aVar.c();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return;
        }
        List<l> list = eVar.f7667h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.d();
                }
            }
        }
        this.f7691g.f7668i.g();
        this.f7691g.f7668i.d();
        this.f7691g.f7668i.n();
        setRenderMode(1);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        JSONObject jSONObject;
        List<l> list;
        e eVar = this.f7691g;
        if (eVar != null && (aVar = eVar.f7668i) != null && eVar.k) {
            String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7691g.l);
            JSONObject jSONObject2 = null;
            if (a2 == null || a2.equals("")) {
                List<l> list2 = this.f7691g.f7667h;
                if (list2 != null) {
                    for (l lVar : list2) {
                        if (lVar != null) {
                            lVar.a(this.f7691g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                        }
                    }
                }
            } else {
                try {
                    jSONObject = new JSONObject(a2);
                    try {
                        jSONObject.put("px", (int) motionEvent.getX());
                        jSONObject.put("py", (int) motionEvent.getY());
                    } catch (JSONException e2) {
                        e = e2;
                        jSONObject2 = jSONObject;
                        e.printStackTrace();
                        jSONObject = jSONObject2;
                        list = this.f7691g.f7667h;
                        if (list != null) {
                        }
                        return true;
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
                list = this.f7691g.f7667h;
                if (list != null) {
                    for (l lVar2 : list) {
                        if (jSONObject != null && lVar2 != null) {
                            lVar2.a(jSONObject.toString());
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        List<l> list = this.f7691g.f7667h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.a(motionEvent);
                }
            }
        }
        if (this.f7690f.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.f7691g.a(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r6 == ((r2.left - r2.right) / 2)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r6 == ((r2.bottom - r2.top) / 2)) goto L18;
     */
    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
        e eVar = this.f7691g;
        if (eVar == null || eVar.f7668i == null) {
            return;
        }
        MapRenderer mapRenderer = this.f7687c;
        mapRenderer.f7604a = i3;
        mapRenderer.f7605b = i4;
        this.f7688d = i3;
        this.f7689e = i4;
        mapRenderer.f7606c = 0;
        ab E = eVar.E();
        int i5 = E.f7619f;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound = E.j;
        }
        E.f7619f = -1;
        int i6 = E.f7620g;
        if (i6 != 0 && i6 != -1) {
            WinRound winRound2 = E.j;
        }
        E.f7620g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i4;
        winRound3.right = i3;
        this.f7691g.a(E);
        this.f7691g.a(this.f7688d, this.f7689e);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        if (surfaceHolder == null || surfaceHolder.getSurface().isValid()) {
            return;
        }
        surfaceDestroyed(surfaceHolder);
    }
}
