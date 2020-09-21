package com.baidu.rtc.camera.filter.a;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes15.dex */
public class b {
    protected a bPk;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(a aVar) {
        this.bPk = aVar;
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.bPk.createWindowSurface(obj);
    }

    public void releaseEglSurface() {
        this.bPk.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void makeCurrent() {
        this.bPk.makeCurrent(this.mEGLSurface);
    }

    public boolean swapBuffers() {
        boolean swapBuffers = this.bPk.swapBuffers(this.mEGLSurface);
        if (!swapBuffers) {
            Log.d("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }

    public void setPresentationTime(long j) {
        this.bPk.setPresentationTime(this.mEGLSurface, j);
    }
}
