package com.baidu.ar.arplay.d;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
/* loaded from: classes14.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private SurfaceTexture dy;
    private Surface gk;
    private Canvas gl;
    public int mTextureId;
    private int gi = 500;
    private int gj = 500;
    private boolean gm = true;

    public Surface a(int i, int i2, int i3) {
        this.mTextureId = i;
        this.dy = new SurfaceTexture(i);
        f(i2, i3);
        this.gk = new Surface(this.dy);
        return this.gk;
    }

    public void br() {
        if (this.gl != null) {
            this.gk.unlockCanvasAndPost(this.gl);
        }
        this.gl = null;
    }

    public void f(int i, int i2) {
        this.gi = i;
        this.gj = i2;
        this.dy.setDefaultBufferSize(this.gi, this.gj);
    }

    public Canvas lockCanvas() {
        this.gl = null;
        if (this.gk != null) {
            try {
                this.gl = this.gk.lockCanvas(null);
            } catch (Exception e) {
                Log.e(TAG, "error while rendering view to gl: " + e);
            }
        }
        return this.gl;
    }

    public void release() {
        if (this.gk != null) {
            this.gk.release();
        }
        if (this.dy != null) {
            this.dy.release();
        }
        this.gk = null;
        this.dy = null;
    }

    public void update() {
        try {
            this.dy.updateTexImage();
        } catch (Exception e) {
            Log.e(TAG, "error while update view to gl: " + e);
        }
    }
}
