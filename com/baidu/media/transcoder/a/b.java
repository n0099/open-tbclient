package com.baidu.media.transcoder.a;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
@TargetApi(17)
/* loaded from: classes4.dex */
public class b {
    private EGLDisplay a = EGL14.EGL_NO_DISPLAY;
    private EGLContext b = EGL14.EGL_NO_CONTEXT;
    private EGLSurface c = EGL14.EGL_NO_SURFACE;
    private Surface d;

    public b(Surface surface) {
        if (surface == null) {
            throw new NullPointerException();
        }
        this.d = surface;
        c();
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    private void c() {
        this.a = EGL14.eglGetDisplay(0);
        if (this.a == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.a, iArr, 0, iArr, 1)) {
            this.a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.b = EGL14.eglCreateContext(this.a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        a("eglCreateContext");
        if (this.b == null) {
            throw new RuntimeException("null context");
        }
        this.c = EGL14.eglCreateWindowSurface(this.a, eGLConfigArr[0], this.d, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (this.c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public void a() {
        if (!EGL14.eglMakeCurrent(this.a, this.c, this.c, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @TargetApi(18)
    public void a(long j) {
        EGLExt.eglPresentationTimeANDROID(this.a, this.c, j);
    }

    public boolean b() {
        return EGL14.eglSwapBuffers(this.a, this.c);
    }
}
