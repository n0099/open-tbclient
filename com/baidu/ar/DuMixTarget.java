package com.baidu.ar;

import android.graphics.SurfaceTexture;
/* loaded from: classes3.dex */
public class DuMixTarget {
    private SurfaceTexture a;
    private SurfaceTexture.OnFrameAvailableListener b;
    private int c;
    private int d;
    private ScaleType e;
    private boolean f;

    /* loaded from: classes3.dex */
    public enum ScaleType {
        MATRIX,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public DuMixTarget(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2, boolean z) {
        this.a = surfaceTexture;
        this.b = onFrameAvailableListener;
        this.c = i;
        this.d = i2;
        this.f = z;
    }

    public SurfaceTexture getDrawTarget() {
        return this.a;
    }

    public ScaleType getScaleType() {
        return this.e;
    }

    public SurfaceTexture.OnFrameAvailableListener getTargetFrameAvailableListener() {
        return this.b;
    }

    public int getTargetHeight() {
        return this.d;
    }

    public int getTargetWidth() {
        return this.c;
    }

    public boolean isDrawPreview() {
        return this.f;
    }

    public void setDrawPreview(boolean z) {
        this.f = z;
    }

    public void setDrawTarget(SurfaceTexture surfaceTexture) {
        this.a = surfaceTexture;
    }

    public void setScaleType(ScaleType scaleType) {
        this.e = scaleType;
    }

    public void setTargetFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        this.b = onFrameAvailableListener;
    }

    public void setTargetHeight(int i) {
        this.d = i;
    }

    public void setTargetWidth(int i) {
        this.c = i;
    }
}
