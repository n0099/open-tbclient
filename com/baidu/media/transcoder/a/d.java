package com.baidu.media.transcoder.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
/* loaded from: classes6.dex */
public class d implements SurfaceTexture.OnFrameAvailableListener {
    private SurfaceTexture aMV;
    private e aMW;
    private Surface e;
    private boolean g;
    private EGLDisplay a = EGL14.EGL_NO_DISPLAY;
    private EGLContext b = EGL14.EGL_NO_CONTEXT;
    private EGLSurface c = EGL14.EGL_NO_SURFACE;
    private Object f = new Object();

    public d() {
        d();
    }

    private void d() {
        this.aMW = new e();
        this.aMW.b();
        this.aMV = new SurfaceTexture(this.aMW.a());
        this.aMV.setOnFrameAvailableListener(this);
        this.e = new Surface(this.aMV);
    }

    public Surface a() {
        return this.e;
    }

    public void b() {
        synchronized (this.f) {
            do {
                if (this.g) {
                    this.g = false;
                } else {
                    try {
                        this.f.wait(10000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } while (this.g);
            throw new RuntimeException("Surface frame wait timed out");
        }
        this.aMW.a("before updateTexImage");
        this.aMV.updateTexImage();
    }

    public void c() {
        this.aMW.a(this.aMV);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f) {
            if (this.g) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.g = true;
            this.f.notifyAll();
        }
    }
}
