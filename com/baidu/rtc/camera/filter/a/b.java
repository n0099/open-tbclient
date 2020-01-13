package com.baidu.rtc.camera.filter.a;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes5.dex */
public class b {
    protected a aRC;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(a aVar) {
        this.aRC = aVar;
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.aRC.createWindowSurface(obj);
    }

    public void releaseEglSurface() {
        this.aRC.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void makeCurrent() {
        this.aRC.makeCurrent(this.mEGLSurface);
    }

    public boolean swapBuffers() {
        boolean swapBuffers = this.aRC.swapBuffers(this.mEGLSurface);
        if (!swapBuffers) {
            Log.d("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }

    public void setPresentationTime(long j) {
        this.aRC.setPresentationTime(this.mEGLSurface, j);
    }
}
