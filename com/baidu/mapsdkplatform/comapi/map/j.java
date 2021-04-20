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
    public static final String f7670a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Handler f7671b;

    /* renamed from: c  reason: collision with root package name */
    public MapRenderer f7672c;

    /* renamed from: d  reason: collision with root package name */
    public int f7673d;

    /* renamed from: e  reason: collision with root package name */
    public int f7674e;

    /* renamed from: f  reason: collision with root package name */
    public GestureDetector f7675f;

    /* renamed from: g  reason: collision with root package name */
    public e f7676g;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f7677a;

        /* renamed from: b  reason: collision with root package name */
        public float f7678b;

        /* renamed from: c  reason: collision with root package name */
        public float f7679c;

        /* renamed from: d  reason: collision with root package name */
        public float f7680d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7681e;

        /* renamed from: f  reason: collision with root package name */
        public float f7682f;

        /* renamed from: g  reason: collision with root package name */
        public float f7683g;

        /* renamed from: h  reason: collision with root package name */
        public double f7684h;

        public String toString() {
            return "MultiTouch{x1=" + this.f7677a + ", x2=" + this.f7678b + ", y1=" + this.f7679c + ", y2=" + this.f7680d + ", mTwoTouch=" + this.f7681e + ", centerX=" + this.f7682f + ", centerY=" + this.f7683g + ", length=" + this.f7684h + '}';
        }
    }

    public j(Context context, z zVar, String str, int i) {
        super(context);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        setEGLContextClientVersion(2);
        this.f7675f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.f7676g == null) {
            this.f7676g = new e(context, str, i);
        }
        this.f7676g.a(context.hashCode());
        g();
        this.f7676g.a();
        this.f7676g.a(zVar);
        h();
        this.f7676g.a(this.f7671b);
        this.f7676g.f();
        setBackgroundColor(0);
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
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
        this.f7672c = mapRenderer;
        mapRenderer.a(this.f7676g.j);
        setRenderer(this.f7672c);
        setRenderMode(1);
    }

    private void h() {
        this.f7671b = new k(this);
    }

    public e a() {
        return this.f7676g;
    }

    public void a(float f2, float f3) {
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return;
        }
        eVar.b(f2, f3);
    }

    public void a(int i) {
        int i2;
        if (this.f7676g == null) {
            return;
        }
        Message message = new Message();
        message.what = 50;
        message.obj = Long.valueOf(this.f7676g.j);
        boolean q = this.f7676g.q();
        if (i != 3) {
            i2 = q ? 1 : 1;
            this.f7671b.sendMessage(message);
        }
        i2 = 0;
        message.arg1 = i2;
        this.f7671b.sendMessage(message);
    }

    public void a(String str, Rect rect) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.f7676g;
        if (eVar == null || (aVar = eVar.i) == null) {
            return;
        }
        if (rect != null) {
            int i = rect.left;
            int i2 = this.f7674e;
            int i3 = rect.bottom;
            int i4 = i2 < i3 ? 0 : i2 - i3;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i4 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.f7673d) {
                width = Math.abs(rect.width()) - (rect.right - this.f7673d);
            }
            if (height > this.f7674e) {
                height = Math.abs(rect.height()) - (rect.bottom - this.f7674e);
            }
            if (i > SysOSUtil.getScreenSizeX() || i4 > SysOSUtil.getScreenSizeY()) {
                this.f7676g.i.a(str, (Bundle) null);
                requestRender();
                return;
            }
            this.f7673d = width;
            this.f7674e = height;
            Bundle bundle = new Bundle();
            bundle.putInt("x", i);
            bundle.putInt("y", i4);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            this.f7676g.i.a(str, bundle);
        } else {
            aVar.a(str, (Bundle) null);
        }
        requestRender();
    }

    public boolean a(float f2, float f3, float f4, float f5) {
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return false;
        }
        return eVar.a(f2, f3, f4, f5);
    }

    public void b() {
        e eVar = this.f7676g;
        if (eVar == null) {
            return;
        }
        eVar.u();
    }

    public void b(int i) {
        e eVar = this.f7676g;
        if (eVar != null) {
            List<l> list = eVar.f7654h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.f();
                    }
                }
            }
            this.f7676g.b(this.f7671b);
            this.f7676g.b(i);
            this.f7676g = null;
        }
        Handler handler = this.f7671b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public boolean b(float f2, float f3) {
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return false;
        }
        return eVar.d(f2, f3);
    }

    public void c() {
        e eVar = this.f7676g;
        if (eVar == null) {
            return;
        }
        eVar.v();
    }

    public boolean c(float f2, float f3) {
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return false;
        }
        return eVar.c(f2, f3);
    }

    public void d() {
        getHolder().setFormat(-3);
        this.f7676g.i.s();
    }

    public boolean d(float f2, float f3) {
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return false;
        }
        return eVar.c((int) f2, (int) f3);
    }

    public void e() {
        getHolder().setFormat(-1);
        this.f7676g.i.t();
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.MapRenderer.a
    public void f() {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null || !eVar.k) {
            return true;
        }
        GeoPoint b2 = eVar.b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (b2 != null) {
            List<l> list = this.f7676g.f7654h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.b(b2);
                    }
                }
            }
            e eVar2 = this.f7676g;
            if (eVar2.f7652f) {
                ab E = eVar2.E();
                E.f7605a += 1.0f;
                if (!this.f7676g.f7653g) {
                    E.f7608d = b2.getLongitudeE6();
                    E.f7609e = b2.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.f7676g.a(E, 300);
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
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null || !eVar.k) {
            return true;
        }
        if (eVar.f7651e) {
            float sqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
            if (sqrt <= 500.0f) {
                return false;
            }
            BaiduMap.mapStatusReason |= 1;
            this.f7676g.A();
            this.f7676g.a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
            this.f7676g.L();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        e eVar = this.f7676g;
        if (eVar == null || (aVar = eVar.i) == null || !eVar.k) {
            return;
        }
        String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7676g.l);
        if (a2 == null || a2.equals("")) {
            List<l> list = this.f7676g.f7654h;
            if (list != null) {
                for (l lVar : list) {
                    GeoPoint b2 = this.f7676g.b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.c(b2);
                    }
                }
                return;
            }
            return;
        }
        List<l> list2 = this.f7676g.f7654h;
        if (list2 != null) {
            for (l lVar2 : list2) {
                if (lVar2 != null) {
                    if (lVar2.b(a2)) {
                        this.f7676g.p = true;
                    } else {
                        lVar2.c(this.f7676g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        super.onPause();
        e eVar = this.f7676g;
        if (eVar == null || (aVar = eVar.i) == null) {
            return;
        }
        aVar.c();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return;
        }
        List<l> list = eVar.f7654h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.d();
                }
            }
        }
        this.f7676g.i.g();
        this.f7676g.i.d();
        this.f7676g.i.n();
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
        e eVar = this.f7676g;
        if (eVar != null && (aVar = eVar.i) != null && eVar.k) {
            String a2 = aVar.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f7676g.l);
            JSONObject jSONObject2 = null;
            if (a2 == null || a2.equals("")) {
                List<l> list2 = this.f7676g.f7654h;
                if (list2 != null) {
                    for (l lVar : list2) {
                        if (lVar != null) {
                            lVar.a(this.f7676g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
                        list = this.f7676g.f7654h;
                        if (list != null) {
                        }
                        return true;
                    }
                } catch (JSONException e3) {
                    e = e3;
                }
                list = this.f7676g.f7654h;
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
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        List<l> list = this.f7676g.f7654h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.a(motionEvent);
                }
            }
        }
        if (this.f7675f.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.f7676g.a(motionEvent);
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
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        e eVar = this.f7676g;
        if (eVar == null || eVar.i == null) {
            return;
        }
        MapRenderer mapRenderer = this.f7672c;
        mapRenderer.f7595a = i2;
        mapRenderer.f7596b = i3;
        this.f7673d = i2;
        this.f7674e = i3;
        mapRenderer.f7597c = 0;
        ab E = eVar.E();
        int i4 = E.f7610f;
        if (i4 != 0 && i4 != -1) {
            WinRound winRound = E.j;
        }
        E.f7610f = -1;
        int i5 = E.f7611g;
        if (i5 != 0 && i5 != -1) {
            WinRound winRound2 = E.j;
        }
        E.f7611g = -1;
        WinRound winRound3 = E.j;
        winRound3.left = 0;
        winRound3.top = 0;
        winRound3.bottom = i3;
        winRound3.right = i2;
        this.f7676g.a(E);
        this.f7676g.a(this.f7673d, this.f7674e);
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
