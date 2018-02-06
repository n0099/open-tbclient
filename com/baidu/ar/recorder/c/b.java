package com.baidu.ar.recorder.c;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes3.dex */
public final class b {
    private static final String a = b.class.getSimpleName();
    private EGLDisplay b;
    private EGLContext c;
    private EGLConfig d;
    private int e;

    public b() {
        this(null, 0);
    }

    public b(EGLContext eGLContext, int i) {
        this.b = EGL14.EGL_NO_DISPLAY;
        this.c = EGL14.EGL_NO_CONTEXT;
        this.d = null;
        this.e = -1;
        if (this.b != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        this.b = EGL14.eglGetDisplay(0);
        if (this.b == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.b, iArr, 0, iArr, 1)) {
            this.b = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((i & 2) != 0) {
            Log.d(a, "Trying GLES 3");
            EGLConfig a2 = a(i, 3);
            if (a2 != null) {
                EGLContext eglCreateContext = EGL14.eglCreateContext(this.b, a2, eGLContext, new int[]{12440, 3, 12344}, 0);
                if (EGL14.eglGetError() == 12288) {
                    this.d = a2;
                    this.c = eglCreateContext;
                    this.e = 3;
                }
            }
        }
        if (this.c == EGL14.EGL_NO_CONTEXT) {
            Log.d(a, "Trying GLES 2");
            EGLConfig a3 = a(i, 2);
            if (a3 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.b, a3, eGLContext, new int[]{12440, 2, 12344}, 0);
            a("eglCreateContext");
            this.d = a3;
            this.c = eglCreateContext2;
            this.e = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.b, this.c, 12440, iArr2, 0);
        Log.d(a, "EGLContext created, client version " + iArr2[0]);
    }

    private EGLConfig a(int i, int i2) {
        int i3 = i2 >= 3 ? 68 : 4;
        int[] iArr = new int[13];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12352;
        iArr[9] = i3;
        iArr[10] = 12344;
        iArr[11] = 0;
        iArr[12] = 12344;
        if ((i & 1) != 0) {
            iArr[iArr.length - 3] = 12610;
            iArr[iArr.length - 2] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.b, iArr, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w(a, "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    public EGLSurface a(Object obj) {
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.b, this.d, obj, new int[]{12344}, 0);
            a("eglCreateWindowSurface");
            if (eglCreateWindowSurface == null) {
                throw new RuntimeException("surface was null");
            }
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("invalid surface: " + obj);
    }

    public void a() {
        if (this.b != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.b, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.b, this.c);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.b);
        }
        this.b = EGL14.EGL_NO_DISPLAY;
        this.c = EGL14.EGL_NO_CONTEXT;
        this.d = null;
    }

    public void a(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.b, eGLSurface);
    }

    public void a(EGLSurface eGLSurface, long j) {
        EGLExt.eglPresentationTimeANDROID(this.b, eGLSurface, j);
    }

    public void b(EGLSurface eGLSurface) {
        if (this.b == EGL14.EGL_NO_DISPLAY) {
            Log.d(a, "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean c(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.b, eGLSurface);
    }

    public boolean d(EGLSurface eGLSurface) {
        return this.c.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    protected void finalize() {
        try {
            if (this.b != EGL14.EGL_NO_DISPLAY) {
                Log.w(a, "WARNING: EglCore was not explicitly released -- state may be leaked");
                a();
            }
        } finally {
            super.finalize();
        }
    }
}
