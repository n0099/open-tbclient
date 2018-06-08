package com.baidu.baiduarsdk.c;

import android.os.HandlerThread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* loaded from: classes3.dex */
public class b extends HandlerThread {
    private static final int[] f = {12339, 1, 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};
    private static final int[] g = {12375, 1, 12374, 1, 12344};
    private static final int[] h = {12440, 2, 12344};
    private EGLContext a;
    private EGL10 b;
    private EGLContext c;
    private EGLDisplay d;
    private EGLSurface e;

    public b(String str) {
        super(str);
        this.c = null;
        this.d = null;
        this.e = null;
    }

    private void d() {
        this.b = (EGL10) EGLContext.getEGL();
        this.d = this.b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.d == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        this.b.eglInitialize(this.d, new int[2]);
        this.b.eglChooseConfig(this.d, f, eGLConfigArr, 1, new int[1]);
        this.c = this.b.eglCreateContext(this.d, eGLConfigArr[0], this.a, h);
        this.e = this.b.eglCreatePbufferSurface(this.d, eGLConfigArr[0], g);
        this.b.eglMakeCurrent(this.d, this.e, this.e, this.c);
    }

    public EGLContext a() {
        return this.a;
    }

    public void a(EGLContext eGLContext, EGLConfig eGLConfig) {
        this.a = eGLContext;
    }

    public void b() {
        this.b.eglMakeCurrent(this.d, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        if (this.c != null) {
            this.b.eglDestroyContext(this.d, this.c);
            this.c = null;
        }
        if (this.e != null) {
            this.b.eglDestroySurface(this.d, this.e);
            this.e = null;
        }
        if (this.d != null) {
            this.b.eglTerminate(this.d);
            this.d = null;
        }
    }

    public boolean c() {
        return this.b.eglSwapBuffers(this.d, this.e);
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        setName("GLResThread" + getThreadId());
        try {
            d();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        b();
    }
}
