package com.baidu.media.transcoder.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
/* loaded from: classes5.dex */
public class d implements SurfaceTexture.OnFrameAvailableListener {
    private SurfaceTexture aIA;
    private e aIB;
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
        this.aIB = new e();
        this.aIB.b();
        this.aIA = new SurfaceTexture(this.aIB.a());
        this.aIA.setOnFrameAvailableListener(this);
        this.e = new Surface(this.aIA);
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
        this.aIB.a("before updateTexImage");
        this.aIA.updateTexImage();
    }

    public void c() {
        this.aIB.a(this.aIA);
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
