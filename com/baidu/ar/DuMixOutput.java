package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes3.dex */
public class DuMixOutput {
    private Object aV;
    private boolean aW = false;
    private c aX = c.CENTER_CROP;
    private b aY = b.ROTATE_0;
    private a aZ = a.NO_MIRRIOR;
    private int ba = 0;
    private int mOutputHeight;
    private int mOutputWidth;

    /* loaded from: classes3.dex */
    public enum a {
        NO_MIRRIOR,
        MIRRIOR_VERTICAL,
        MIRRIOR_HORIZONTAL
    }

    /* loaded from: classes3.dex */
    public enum b {
        ROTATE_0,
        ROTATE_90,
        ROTATE_180,
        ROTATE_270
    }

    /* loaded from: classes3.dex */
    public enum c {
        FIT_XY,
        CENTER_INSIDE,
        CENTER_CROP
    }

    public DuMixOutput() {
    }

    public DuMixOutput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.aV = surfaceTexture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(Surface surface, int i, int i2) {
        this.aV = surface;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(SurfaceHolder surfaceHolder, int i, int i2) {
        this.aV = surfaceHolder;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public a getMirriorType() {
        return this.aZ;
    }

    public int getOutputFPS() {
        return this.ba;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public Object getOutputSurface() {
        return this.aV;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public b getRotationType() {
        return this.aY;
    }

    public c getScaleType() {
        return this.aX;
    }

    public boolean isNeedDetach() {
        return this.aW;
    }

    public void setMirriorType(a aVar) {
        this.aZ = aVar;
    }

    public void setNeedDetach(boolean z) {
        this.aW = z;
    }

    public void setOutputFPS(int i) {
        this.ba = i;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputSurface(SurfaceTexture surfaceTexture) {
        this.aV = surfaceTexture;
    }

    public void setOutputSurface(Surface surface) {
        this.aV = surface;
    }

    public void setOutputSurface(SurfaceHolder surfaceHolder) {
        this.aV = surfaceHolder;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setRotationType(b bVar) {
        this.aY = bVar;
    }

    public void setScaleType(c cVar) {
        this.aX = cVar;
    }
}
