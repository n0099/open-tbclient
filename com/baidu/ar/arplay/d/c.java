package com.baidu.ar.arplay.d;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes6.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private SurfaceTexture dL;
    private Surface gx;
    private Canvas gy;
    public int mTextureId;
    private int gv = 500;
    private int gw = 500;
    private boolean gz = true;

    public Surface a(int i, int i2, int i3) {
        this.mTextureId = i;
        this.dL = new SurfaceTexture(i);
        f(i2, i3);
        this.gx = new Surface(this.dL);
        return this.gx;
    }

    public void bo() {
        if (this.gy != null) {
            this.gx.unlockCanvasAndPost(this.gy);
        }
        this.gy = null;
    }

    public void f(int i, int i2) {
        this.gv = i;
        this.gw = i2;
        this.dL.setDefaultBufferSize(this.gv, this.gw);
    }

    public Canvas lockCanvas() {
        this.gy = null;
        if (this.gx != null) {
            try {
                this.gy = this.gx.lockCanvas(null);
            } catch (Exception e) {
                Log.e(TAG, "error while rendering view to gl: " + e);
            }
        }
        return this.gy;
    }

    public void release() {
        if (this.gx != null) {
            this.gx.release();
        }
        if (this.dL != null) {
            this.dL.release();
        }
        this.gx = null;
        this.dL = null;
    }

    public void update() {
        try {
            this.dL.updateTexImage();
        } catch (Exception e) {
            Log.e(TAG, "error while update view to gl: " + e);
        }
    }
}
