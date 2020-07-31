package com.baidu.ar;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
/* loaded from: classes11.dex */
public class DuMixOutput {
    private Object bh;
    private boolean bi = false;
    private c bj = c.CENTER_CROP;
    private b bk = b.ROTATE_0;
    private a bl = a.NO_MIRRIOR;
    private int bm = 0;
    private int mOutputHeight;
    private int mOutputWidth;

    /* loaded from: classes11.dex */
    public enum a {
        NO_MIRRIOR,
        MIRRIOR_VERTICAL,
        MIRRIOR_HORIZONTAL
    }

    /* loaded from: classes11.dex */
    public enum b {
        ROTATE_0,
        ROTATE_90,
        ROTATE_180,
        ROTATE_270
    }

    /* loaded from: classes11.dex */
    public enum c {
        FIT_XY,
        CENTER_INSIDE,
        CENTER_CROP
    }

    public DuMixOutput() {
    }

    public DuMixOutput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.bh = surfaceTexture;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(Surface surface, int i, int i2) {
        this.bh = surface;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public DuMixOutput(SurfaceHolder surfaceHolder, int i, int i2) {
        this.bh = surfaceHolder;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public a getMirriorType() {
        return this.bl;
    }

    public int getOutputFPS() {
        return this.bm;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public Object getOutputSurface() {
        return this.bh;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public b getRotationType() {
        return this.bk;
    }

    public c getScaleType() {
        return this.bj;
    }

    public boolean isNeedDetach() {
        return this.bi;
    }

    public void setMirriorType(a aVar) {
        this.bl = aVar;
    }

    public void setNeedDetach(boolean z) {
        this.bi = z;
    }

    public void setOutputFPS(int i) {
        this.bm = i;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputSurface(SurfaceTexture surfaceTexture) {
        this.bh = surfaceTexture;
    }

    public void setOutputSurface(Surface surface) {
        this.bh = surface;
    }

    public void setOutputSurface(SurfaceHolder surfaceHolder) {
        this.bh = surfaceHolder;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setRotationType(b bVar) {
        this.bk = bVar;
    }

    public void setScaleType(c cVar) {
        this.bj = cVar;
    }
}
