package com.baidu.ar.arplay.d;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes3.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private SurfaceTexture dK;
    private Surface gJ;
    private Canvas gK;
    public int mTextureId;
    private int gH = 500;
    private int gI = 500;
    private boolean gL = true;

    public Surface a(int i, int i2, int i3) {
        this.mTextureId = i;
        this.dK = new SurfaceTexture(i);
        f(i2, i3);
        this.gJ = new Surface(this.dK);
        return this.gJ;
    }

    public void aV() {
        if (this.gK != null) {
            this.gJ.unlockCanvasAndPost(this.gK);
        }
        this.gK = null;
    }

    public void f(int i, int i2) {
        this.gH = i;
        this.gI = i2;
        this.dK.setDefaultBufferSize(this.gH, this.gI);
    }

    public Canvas lockCanvas() {
        this.gK = null;
        if (this.gJ != null) {
            try {
                this.gK = this.gJ.lockCanvas(null);
            } catch (Exception e) {
                Log.e(TAG, "error while rendering view to gl: " + e);
            }
        }
        return this.gK;
    }

    public void release() {
        if (this.gJ != null) {
            this.gJ.release();
        }
        if (this.dK != null) {
            this.dK.release();
        }
        this.gJ = null;
        this.dK = null;
    }

    public void update() {
        try {
            this.dK.updateTexImage();
        } catch (Exception e) {
            Log.e(TAG, "error while update view to gl: " + e);
        }
    }
}
