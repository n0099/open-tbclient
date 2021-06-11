package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
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
    public AtomicBoolean f7701a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceTexture f7702b;

    /* renamed from: c  reason: collision with root package name */
    public a f7703c;

    /* renamed from: d  reason: collision with root package name */
    public EGL10 f7704d;

    /* renamed from: h  reason: collision with root package name */
    public GL10 f7708h;
    public final ac k;

    /* renamed from: e  reason: collision with root package name */
    public EGLDisplay f7705e = EGL10.EGL_NO_DISPLAY;

    /* renamed from: f  reason: collision with root package name */
    public EGLContext f7706f = EGL10.EGL_NO_CONTEXT;

    /* renamed from: g  reason: collision with root package name */
    public EGLSurface f7707g = EGL10.EGL_NO_SURFACE;

    /* renamed from: i  reason: collision with root package name */
    public int f7709i = 1;
    public boolean j = false;

    /* loaded from: classes2.dex */
    public interface a {
        int a();
    }

    public m(SurfaceTexture surfaceTexture, a aVar, AtomicBoolean atomicBoolean, ac acVar) {
        this.f7702b = surfaceTexture;
        this.f7703c = aVar;
        this.f7701a = atomicBoolean;
        this.k = acVar;
    }

    private boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f7704d = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f7705e = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f7704d.eglGetError()));
        } else if (!this.f7704d.eglInitialize(eglGetDisplay, new int[2])) {
            throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f7704d.eglGetError()));
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[100];
            int[] iArr = new int[1];
            if (!this.f7704d.eglChooseConfig(this.f7705e, new int[]{12352, 4, ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                return false;
            }
            this.f7706f = this.f7704d.eglCreateContext(this.f7705e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER});
            EGLSurface eglCreateWindowSurface = this.f7704d.eglCreateWindowSurface(this.f7705e, eGLConfigArr[0], this.f7702b, null);
            this.f7707g = eglCreateWindowSurface;
            if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE || this.f7706f == EGL10.EGL_NO_CONTEXT) {
                if (this.f7704d.eglGetError() == 12299) {
                    throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                }
                GLUtils.getEGLErrorString(this.f7704d.eglGetError());
            }
            EGL10 egl102 = this.f7704d;
            EGLDisplay eGLDisplay = this.f7705e;
            EGLSurface eGLSurface = this.f7707g;
            if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f7706f)) {
                this.f7708h = (GL10) this.f7706f.getGL();
                return true;
            }
            String eGLErrorString = GLUtils.getEGLErrorString(this.f7704d.eglGetError());
            throw new RuntimeException("eglMakeCurrent failed : " + eGLErrorString);
        }
    }

    public static boolean b(int i2, int i3, int i4, int i5, int i6, int i7) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i2, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, i3, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, i4, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, i5, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, i6, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, i7, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
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
        if (this.k.b() == null) {
            return;
        }
        MapRenderer.nativeInit(this.k.b().j);
        MapRenderer.nativeResize(this.k.b().j, ac.f7632a, ac.f7633b);
    }

    private void e() {
        EGLSurface eGLSurface = this.f7707g;
        EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
        if (eGLSurface != eGLSurface2) {
            this.f7704d.eglMakeCurrent(this.f7705e, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
            this.f7704d.eglDestroySurface(this.f7705e, this.f7707g);
            this.f7707g = EGL10.EGL_NO_SURFACE;
        }
        EGLContext eGLContext = this.f7706f;
        if (eGLContext != EGL10.EGL_NO_CONTEXT) {
            this.f7704d.eglDestroyContext(this.f7705e, eGLContext);
            this.f7706f = EGL10.EGL_NO_CONTEXT;
        }
        EGLDisplay eGLDisplay = this.f7705e;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.f7704d.eglTerminate(eGLDisplay);
            this.f7705e = EGL10.EGL_NO_DISPLAY;
        }
    }

    public void a() {
        this.f7709i = 1;
        this.j = false;
        synchronized (this) {
            if (getState() == Thread.State.WAITING) {
                notify();
            }
        }
    }

    public void b() {
        this.f7709i = 0;
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
        while (this.f7703c != null) {
            if (this.f7709i != 1 || this.j) {
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
                            this.f7709i = this.f7703c.a();
                        }
                    }
                    e b2 = this.k.b();
                    if (b2 != null && b2.f7667h != null) {
                        for (l lVar : b2.f7667h) {
                            if (lVar != null) {
                                ab J = b2.J();
                                if (this.f7708h == null) {
                                    return;
                                }
                                if (lVar != null) {
                                    lVar.a(this.f7708h, J);
                                }
                            }
                        }
                    }
                    this.f7704d.eglSwapBuffers(this.f7705e, this.f7707g);
                }
            }
            if (this.j) {
                break;
            }
        }
        e();
    }
}
