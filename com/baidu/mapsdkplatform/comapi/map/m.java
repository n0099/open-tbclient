package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
import org.webrtc.EglBase10;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f7961a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f7962b;

    /* renamed from: c  reason: collision with root package name */
    public a f7963c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f7964d;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f7968h;
    public final ac k;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f7965e = EGL10.EGL_NO_DISPLAY;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f7966f = EGL10.EGL_NO_CONTEXT;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f7967g = EGL10.EGL_NO_SURFACE;

    /* renamed from: i  reason: collision with root package name */
    public int f7969i = 1;
    public boolean j = false;

    /* loaded from: classes2.dex */
    public interface a {
        int a();
    }

    public m(SurfaceTexture surfaceTexture, a aVar, AtomicBoolean atomicBoolean, ac acVar) {
        this.f7962b = surfaceTexture;
        this.f7963c = aVar;
        this.f7961a = atomicBoolean;
        this.k = acVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f7964d = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f7965e = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f7964d.eglGetError()));
        } else if (!this.f7964d.eglInitialize(eglGetDisplay, new int[2])) {
            throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f7964d.eglGetError()));
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[100];
            int[] iArr = new int[1];
            if (!this.f7964d.eglChooseConfig(this.f7965e, new int[]{12352, 4, 12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                return false;
            }
            this.f7966f = this.f7964d.eglCreateContext(this.f7965e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            EGLSurface eglCreateWindowSurface = this.f7964d.eglCreateWindowSurface(this.f7965e, eGLConfigArr[0], this.f7962b, null);
            this.f7967g = eglCreateWindowSurface;
            if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f7966f == EGL10.EGL_NO_CONTEXT) {
                if (this.f7964d.eglGetError() == 12299) {
                    throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                }
                GLUtils.getEGLErrorString(this.f7964d.eglGetError());
            }
            EGL10 egl102 = this.f7964d;
            EGLDisplay eGLDisplay = this.f7965e;
            EGLSurface eGLSurface = this.f7967g;
            if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f7966f)) {
                this.f7968h = (GL10) this.f7966f.getGL();
                return true;
            }
            String eGLErrorString = GLUtils.getEGLErrorString(this.f7964d.eglGetError());
            throw new RuntimeException("eglMakeCurrent failed : " + eGLErrorString);
        }
    }

    public static boolean b(int i2, int i3, int i4, int i5, int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }

    private void d() {
        try {
            if (b(5, 6, 5, 0, 24, 0)) {
                a(8, 8, 8, 0, 24, 0);
            } else {
                a(8, 8, 8, 0, 24, 0);
            }
        } catch (IllegalArgumentException unused) {
            a(8, 8, 8, 0, 24, 0);
        }
        MapRenderer.nativeInit(this.k.b().j);
        MapRenderer.nativeResize(this.k.b().j, ac.f7892a, ac.f7893b);
    }

    private void e() {
        EGLSurface eGLSurface = this.f7967g;
        EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
        if (eGLSurface != eGLSurface2) {
            this.f7964d.eglMakeCurrent(this.f7965e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
            this.f7964d.eglDestroySurface(this.f7965e, this.f7967g);
            this.f7967g = EGL10.EGL_NO_SURFACE;
        }
        EGLContext eGLContext = this.f7966f;
        if (eGLContext != EGL10.EGL_NO_CONTEXT) {
            this.f7964d.eglDestroyContext(this.f7965e, eGLContext);
            this.f7966f = EGL10.EGL_NO_CONTEXT;
        }
        EGLDisplay eGLDisplay = this.f7965e;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.f7964d.eglTerminate(eGLDisplay);
            this.f7965e = EGL10.EGL_NO_DISPLAY;
        }
    }

    public void a() {
        this.f7969i = 1;
        this.j = false;
        synchronized (this) {
            if (getState() == Thread.State.WAITING) {
                notify();
            }
        }
    }

    public void b() {
        this.f7969i = 0;
        synchronized (this) {
            this.j = true;
        }
    }

    public void c() {
        this.j = true;
        synchronized (this) {
            if (getState() == Thread.State.WAITING) {
                notify();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        d();
        while (this.f7963c != null) {
            if (this.f7969i != 1 || this.j) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else if (this.k.b() == null) {
                break;
            } else {
                synchronized (this.k.b()) {
                    synchronized (this) {
                        if (!this.j) {
                            this.f7969i = this.f7963c.a();
                        }
                    }
                    if (this.k.b().f7927h != null) {
                        for (l lVar : this.k.b().f7927h) {
                            if (lVar != null) {
                                ab I = this.k.b().I();
                                if (this.f7968h == null) {
                                    return;
                                }
                                if (lVar != null) {
                                    lVar.a(this.f7968h, I);
                                }
                            }
                        }
                    }
                    this.f7964d.eglSwapBuffers(this.f7965e, this.f7967g);
                }
            }
            if (this.j) {
                break;
            }
        }
        e();
    }
}
