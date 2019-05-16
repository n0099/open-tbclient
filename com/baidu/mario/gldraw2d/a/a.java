package com.baidu.mario.gldraw2d.a;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mario.gldraw2d.b.b;
/* loaded from: classes2.dex */
public class a extends b {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public a(com.baidu.mario.gldraw2d.b.a aVar, Surface surface, boolean z) {
        super(aVar);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z;
    }

    public a(com.baidu.mario.gldraw2d.b.a aVar, SurfaceTexture surfaceTexture) {
        super(aVar);
        createWindowSurface(surfaceTexture);
    }

    public a(com.baidu.mario.gldraw2d.b.a aVar, SurfaceHolder surfaceHolder) {
        super(aVar);
        createWindowSurface(surfaceHolder);
    }

    public void release() {
        releaseEglSurface();
        if (this.mSurface != null) {
            if (this.mReleaseSurface) {
                this.mSurface.release();
            }
            this.mSurface = null;
        }
    }

    public void a(com.baidu.mario.gldraw2d.b.a aVar) {
        if (this.mSurface == null) {
            throw new RuntimeException("not yet implemented for SurfaceTexture");
        }
        this.acV = aVar;
        createWindowSurface(this.mSurface);
    }
}
