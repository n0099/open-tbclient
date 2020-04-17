package com.baidu.ar;

import android.graphics.SurfaceTexture;
/* loaded from: classes3.dex */
public class DuMixInput {
    private int S;
    private int T;
    private int U;
    private SurfaceTexture aR;
    private boolean aS;
    private boolean mFrontCamera;

    public DuMixInput() {
        this.S = 0;
        this.T = 0;
        this.aS = true;
        this.mFrontCamera = true;
        this.U = 90;
    }

    public DuMixInput(SurfaceTexture surfaceTexture, int i, int i2) {
        this.S = 0;
        this.T = 0;
        this.aS = true;
        this.mFrontCamera = true;
        this.U = 90;
        this.aR = surfaceTexture;
        this.S = i;
        this.T = i2;
    }

    public int getInputDegree() {
        return this.U;
    }

    public int getInputHeight() {
        return this.T;
    }

    public SurfaceTexture getInputSurface() {
        return this.aR;
    }

    public int getInputWidth() {
        return this.S;
    }

    public boolean isCameraInput() {
        return this.aS;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public void setCameraInput(boolean z) {
        this.aS = z;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setInputDegree(int i) {
        this.U = i;
    }

    public void setInputHeight(int i) {
        this.T = i;
    }

    public void setInputSurface(SurfaceTexture surfaceTexture) {
        this.aR = surfaceTexture;
    }

    public void setInputWidth(int i) {
        this.S = i;
    }
}
