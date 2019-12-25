package com.baidu.media.transcoder.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
/* loaded from: classes4.dex */
public class d implements SurfaceTexture.OnFrameAvailableListener {
    private SurfaceTexture aHI;
    private e aHJ;
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
        this.aHJ = new e();
        this.aHJ.b();
        this.aHI = new SurfaceTexture(this.aHJ.a());
        this.aHI.setOnFrameAvailableListener(this);
        this.e = new Surface(this.aHI);
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
        this.aHJ.a("before updateTexImage");
        this.aHI.updateTexImage();
    }

    public void c() {
        this.aHJ.a(this.aHI);
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
