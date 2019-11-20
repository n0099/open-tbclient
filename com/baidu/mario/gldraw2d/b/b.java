package com.baidu.mario.gldraw2d.b;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;
/* loaded from: classes2.dex */
public class b {
    protected static final String TAG = b.class.getSimpleName();
    protected a awz;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(a aVar) {
        this.awz = aVar;
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.mEGLSurface = this.awz.createWindowSurface(obj);
    }

    public void releaseEglSurface() {
        this.awz.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void b(a aVar) {
        if (!aVar.isCurrent(this.mEGLSurface)) {
            aVar.makeCurrent(this.mEGLSurface);
        }
    }

    public boolean swapBuffers() {
        boolean swapBuffers = this.awz.swapBuffers(this.mEGLSurface);
        if (!swapBuffers) {
            Log.d(TAG, "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }

    public void setPresentationTime(long j) {
        this.awz.setPresentationTime(this.mEGLSurface, j);
    }
}
