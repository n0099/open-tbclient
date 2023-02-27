package com.baidu.ar.arplay.d;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes.dex */
public class c {
    public static final String TAG = "c";
    public SurfaceTexture dL;
    public Surface gx;
    public Canvas gy;
    public int mTextureId;
    public int gv = 500;
    public int gw = 500;
    public boolean gz = true;

    public Surface a(int i, int i2, int i3) {
        this.mTextureId = i;
        this.dL = new SurfaceTexture(i);
        f(i2, i3);
        Surface surface = new Surface(this.dL);
        this.gx = surface;
        return surface;
    }

    public void bo() {
        Canvas canvas = this.gy;
        if (canvas != null) {
            this.gx.unlockCanvasAndPost(canvas);
        }
        this.gy = null;
    }

    public void f(int i, int i2) {
        this.gv = i;
        this.gw = i2;
        this.dL.setDefaultBufferSize(i, i2);
    }

    public Canvas lockCanvas() {
        this.gy = null;
        Surface surface = this.gx;
        if (surface != null) {
            try {
                this.gy = surface.lockCanvas(null);
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "error while rendering view to gl: " + e);
            }
        }
        return this.gy;
    }

    public void release() {
        Surface surface = this.gx;
        if (surface != null) {
            surface.release();
        }
        SurfaceTexture surfaceTexture = this.dL;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        this.gx = null;
        this.dL = null;
    }

    public void update() {
        try {
            this.dL.updateTexImage();
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "error while update view to gl: " + e);
        }
    }
}
