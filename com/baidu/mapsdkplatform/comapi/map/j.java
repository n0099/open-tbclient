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
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.MapRenderer;
import com.baidu.mobstat.Config;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class j extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.a {
    private static final String a = j.class.getSimpleName();
    private Handler b;
    private MapRenderer c;
    private int d;
    private int e;
    private GestureDetector f;
    private e g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        float a;
        float b;
        float c;
        float d;
        boolean e;
        float f;
        float g;
        double h;

        public String toString() {
            return "MultiTouch{x1=" + this.a + ", x2=" + this.b + ", y1=" + this.c + ", y2=" + this.d + ", mTwoTouch=" + this.e + ", centerX=" + this.f + ", centerY=" + this.g + ", length=" + this.h + '}';
        }
    }

    public j(Context context, z zVar, String str, int i) {
        super(context);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        setEGLContextClientVersion(2);
        this.f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.g == null) {
            this.g = new e(context, str, i);
        }
        this.g.a(context.hashCode());
        g();
        this.g.a();
        this.g.a(zVar);
        h();
        this.g.a(this.b);
        this.g.f();
        setBackgroundColor(0);
    }

    private static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
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
        } catch (IllegalArgumentException e) {
            setEGLConfigChooser(true);
        }
        this.c = new MapRenderer(this, this);
        this.c.a(this.g.j);
        setRenderer(this.c);
        setRenderMode(1);
    }

    private void h() {
        this.b = new k(this);
    }

    public e a() {
        return this.g;
    }

    public void a(float f, float f2) {
        if (this.g == null || this.g.i == null) {
            return;
        }
        this.g.b(f, f2);
    }

    public void a(int i) {
        if (this.g == null) {
            return;
        }
        Message message = new Message();
        message.what = 50;
        message.obj = Long.valueOf(this.g.j);
        boolean q = this.g.q();
        if (i == 3) {
            message.arg1 = 0;
        } else if (q) {
            message.arg1 = 1;
        }
        this.b.sendMessage(message);
    }

    public void a(String str, Rect rect) {
        if (this.g == null || this.g.i == null) {
            return;
        }
        if (rect == null) {
            this.g.i.a(str, (Bundle) null);
            requestRender();
            return;
        }
        int i = rect.left;
        int i2 = this.e < rect.bottom ? 0 : this.e - rect.bottom;
        int width = rect.width();
        int height = rect.height();
        if (i < 0 || i2 < 0 || width <= 0 || height <= 0) {
            return;
        }
        if (width > this.d) {
            width = Math.abs(rect.width()) - (rect.right - this.d);
        }
        if (height > this.e) {
            height = Math.abs(rect.height()) - (rect.bottom - this.e);
        }
        if (i > SysOSUtil.getScreenSizeX() || i2 > SysOSUtil.getScreenSizeY()) {
            this.g.i.a(str, (Bundle) null);
            requestRender();
            return;
        }
        this.d = width;
        this.e = height;
        Bundle bundle = new Bundle();
        bundle.putInt(Config.EVENT_HEAT_X, i);
        bundle.putInt("y", i2);
        bundle.putInt("width", width);
        bundle.putInt("height", height);
        this.g.i.a(str, bundle);
        requestRender();
    }

    public boolean a(float f, float f2, float f3, float f4) {
        if (this.g == null || this.g.i == null) {
            return false;
        }
        return this.g.a(f, f2, f3, f4);
    }

    public void b() {
        if (this.g == null) {
            return;
        }
        this.g.u();
    }

    public void b(int i) {
        if (this.g != null) {
            if (this.g.h != null) {
                for (l lVar : this.g.h) {
                    if (lVar != null) {
                        lVar.f();
                    }
                }
            }
            this.g.b(this.b);
            this.g.b(i);
            this.g = null;
        }
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
        }
    }

    public boolean b(float f, float f2) {
        if (this.g == null || this.g.i == null) {
            return false;
        }
        return this.g.d(f, f2);
    }

    public void c() {
        if (this.g == null) {
            return;
        }
        this.g.v();
    }

    public boolean c(float f, float f2) {
        if (this.g == null || this.g.i == null) {
            return false;
        }
        return this.g.c(f, f2);
    }

    public void d() {
        getHolder().setFormat(-3);
        this.g.i.s();
    }

    public boolean d(float f, float f2) {
        if (this.g == null || this.g.i == null) {
            return false;
        }
        return this.g.c((int) f, (int) f2);
    }

    public void e() {
        getHolder().setFormat(-1);
        this.g.i.t();
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.MapRenderer.a
    public void f() {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.g == null || this.g.i == null || !this.g.k) {
            return true;
        }
        GeoPoint b = this.g.b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (b != null) {
            if (this.g.h != null) {
                for (l lVar : this.g.h) {
                    if (lVar != null) {
                        lVar.b(b);
                    }
                }
            }
            if (this.g.f) {
                ab E = this.g.E();
                E.a += 1.0f;
                if (!this.g.g) {
                    E.d = b.getLongitudeE6();
                    E.e = b.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.g.a(E, 300);
                e eVar = this.g;
                e.m = System.currentTimeMillis();
                return true;
            }
            return false;
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
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.g == null || this.g.i == null || !this.g.k) {
            return true;
        }
        if (this.g.e) {
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            if (sqrt > 500.0f) {
                BaiduMap.mapStatusReason |= 1;
                this.g.A();
                this.g.a(34, (int) (sqrt * 0.6f), (((int) motionEvent2.getY()) << 16) | ((int) motionEvent2.getX()));
                this.g.L();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.g == null || this.g.i == null || !this.g.k) {
            return;
        }
        String a2 = this.g.i.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.g.l);
        if (a2 == null || a2.equals("")) {
            if (this.g.h != null) {
                for (l lVar : this.g.h) {
                    GeoPoint b = this.g.b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.c(b);
                    }
                }
            }
        } else if (this.g.h != null) {
            for (l lVar2 : this.g.h) {
                if (lVar2 != null) {
                    if (lVar2.b(a2)) {
                        this.g.p = true;
                    } else {
                        lVar2.c(this.g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        super.onPause();
        if (this.g == null || this.g.i == null) {
            return;
        }
        this.g.i.c();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.g == null || this.g.i == null) {
            return;
        }
        if (this.g.h != null) {
            for (l lVar : this.g.h) {
                if (lVar != null) {
                    lVar.d();
                }
            }
        }
        this.g.i.g();
        this.g.i.d();
        this.g.i.n();
        setRenderMode(1);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2;
        if (this.g != null && this.g.i != null && this.g.k) {
            String a2 = this.g.i.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.g.l);
            if (a2 != null && !a2.equals("")) {
                try {
                    jSONObject = new JSONObject(a2);
                } catch (JSONException e2) {
                    jSONObject = null;
                    e = e2;
                }
                try {
                    jSONObject.put("px", (int) motionEvent.getX());
                    jSONObject.put("py", (int) motionEvent.getY());
                    jSONObject2 = jSONObject;
                } catch (JSONException e3) {
                    e = e3;
                    e.printStackTrace();
                    jSONObject2 = jSONObject;
                    if (this.g.h != null) {
                    }
                    return true;
                }
                if (this.g.h != null) {
                    for (l lVar : this.g.h) {
                        if (jSONObject2 != null && lVar != null) {
                            lVar.a(jSONObject2.toString());
                        }
                    }
                }
            } else if (this.g.h != null) {
                for (l lVar2 : this.g.h) {
                    if (lVar2 != null) {
                        lVar2.a(this.g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
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
        if (this.g == null || this.g.i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        if (this.g.h != null) {
            for (l lVar : this.g.h) {
                if (lVar != null) {
                    lVar.a(motionEvent);
                }
            }
        }
        if (this.f.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.g.a(motionEvent);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        if (this.g == null || this.g.i == null) {
            return;
        }
        this.c.a = i2;
        this.c.b = i3;
        this.d = i2;
        this.e = i3;
        this.c.c = 0;
        ab E = this.g.E();
        if (E.f == 0 || E.f == -1 || E.f == (E.j.left - E.j.right) / 2) {
            E.f = -1;
        }
        if (E.g == 0 || E.g == -1 || E.g == (E.j.bottom - E.j.f994top) / 2) {
            E.g = -1;
        }
        E.j.left = 0;
        E.j.f994top = 0;
        E.j.bottom = i3;
        E.j.right = i2;
        this.g.a(E);
        this.g.a(this.d, this.e);
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
