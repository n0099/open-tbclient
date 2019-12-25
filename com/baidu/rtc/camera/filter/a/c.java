package com.baidu.rtc.camera.filter.a;

import android.graphics.SurfaceTexture;
import android.view.Surface;
/* loaded from: classes4.dex */
public class c extends b {
    private boolean mReleaseSurface;
    private Surface mSurface;

    public c(a aVar, Surface surface, boolean z) {
        super(aVar);
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z;
    }

    public c(a aVar, SurfaceTexture surfaceTexture) {
        super(aVar);
        createWindowSurface(surfaceTexture);
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
}
