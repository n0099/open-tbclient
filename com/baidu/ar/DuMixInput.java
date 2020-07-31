package com.baidu.ar;

import android.graphics.SurfaceTexture;
/* loaded from: classes11.dex */
public class DuMixInput {
    private int R;
    private int S;
    private int T;
    private SurfaceTexture bd;
    private boolean be;
    private boolean mFrontCamera;

    public DuMixInput() {
        this.R = 0;
        this.S = 0;
        this.be = true;
        this.mFrontCamera = true;
        this.T = 90;
    }

    public DuMixInput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.R = 0;
        this.S = 0;
        this.be = true;
        this.mFrontCamera = true;
        this.T = 90;
        this.bd = surfaceTexture;
        this.R = i;
        this.S = i2;
    }

    public int getInputDegree() {
        return this.T;
    }

    public int getInputHeight() {
        return this.S;
    }

    public SurfaceTexture getInputSurface() {
        return this.bd;
    }

    public int getInputWidth() {
        return this.R;
    }

    public boolean isCameraInput() {
        return this.be;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public void setCameraInput(boolean z) {
        this.be = z;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setInputDegree(int i) {
        this.T = i;
    }

    public void setInputHeight(int i) {
        this.S = i;
    }

    public void setInputSurface(SurfaceTexture surfaceTexture) {
        this.bd = surfaceTexture;
    }

    public void setInputWidth(int i) {
        this.R = i;
    }
}
