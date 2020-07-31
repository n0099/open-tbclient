package com.baidu.ar.arplay.d;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes11.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private SurfaceTexture dW;
    private Surface gV;
    private Canvas gW;
    public int mTextureId;
    private int gT = 500;
    private int gU = 500;
    private boolean gX = true;

    public Surface a(int i, int i2, int i3) {
        this.mTextureId = i;
        this.dW = new SurfaceTexture(i);
        f(i2, i3);
        this.gV = new Surface(this.dW);
        return this.gV;
    }

    public void bj() {
        if (this.gW != null) {
            this.gV.unlockCanvasAndPost(this.gW);
        }
        this.gW = null;
    }

    public void f(int i, int i2) {
        this.gT = i;
        this.gU = i2;
        this.dW.setDefaultBufferSize(this.gT, this.gU);
    }

    public Canvas lockCanvas() {
        this.gW = null;
        if (this.gV != null) {
            try {
                this.gW = this.gV.lockCanvas(null);
            } catch (Exception e) {
                Log.e(TAG, "error while rendering view to gl: " + e);
            }
        }
        return this.gW;
    }

    public void release() {
        if (this.gV != null) {
            this.gV.release();
        }
        if (this.dW != null) {
            this.dW.release();
        }
        this.gV = null;
        this.dW = null;
    }

    public void update() {
        try {
            this.dW.updateTexImage();
        } catch (Exception e) {
            Log.e(TAG, "error while update view to gl: " + e);
        }
    }
}
