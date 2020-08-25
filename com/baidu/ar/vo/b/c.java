package com.baidu.ar.vo.b;

import android.opengl.Matrix;
import com.baidu.ar.algovo.ARVOJniClient;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class c implements a, b {
    private static final String TAG = c.class.getSimpleName();
    private static final float[] xT = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private d xU;
    private com.baidu.ar.algo.a xV;
    private float[] xX;
    private float ya;
    private boolean xW = false;
    private float xY = 0.0f;
    private boolean xZ = false;

    public c(d dVar) {
        this.xU = dVar;
    }

    private void c(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, xT, 0, fArr3, 0);
        Matrix.invertM(fArr3, 0, fArr4, 0);
        fArr[0] = fArr3[0];
        fArr[1] = fArr3[1];
        fArr[2] = fArr3[2];
        fArr[4] = fArr3[4];
        fArr[5] = fArr3[5];
        fArr[6] = fArr3[6];
        fArr[8] = fArr3[8];
        fArr[9] = fArr3[9];
        fArr[10] = fArr3[10];
        float scale = this.xV.getScale();
        float f = fArr[12] * this.ya * scale;
        float f2 = fArr[13] * this.ya * scale;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = scale * fArr[14] * this.ya;
        Matrix.rotateM(fArr, 0, this.xY - 90.0f, 0.0f, 0.0f, 1.0f);
    }

    private float[] q(float[] fArr) {
        if (this.xY == 0.0f) {
            this.xY = this.xU.yd.getAngle();
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, xT, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    @Override // com.baidu.ar.vo.b.b
    public void a(FramePixels framePixels, ICallbackWith<f> iCallbackWith) {
        float[] hb;
        if (framePixels == null || !this.xW || this.xU == null || (hb = this.xU.yd.hb()) == null || hb.length == 0) {
            return;
        }
        if (!this.xZ) {
            iCallbackWith.run(new f(framePixels.getTimestamp()));
            return;
        }
        this.xX = hb;
        ARVOJniClient.track(framePixels.getPixelsAddress(), q(hb));
        ArrayList<TrackModel> fetchModelPose = ARVOJniClient.fetchModelPose();
        Iterator<TrackModel> it = fetchModelPose.iterator();
        while (it.hasNext()) {
            c(it.next().pose, this.xX);
        }
        g gVar = new g(framePixels.getTimestamp());
        gVar.H(true);
        gVar.setTracked(true);
        gVar.b(fetchModelPose);
        iCallbackWith.run(new f(gVar));
    }

    @Override // com.baidu.ar.vo.b.a
    public float[] a(float f, float[] fArr) {
        if (this.xW) {
            float[] fArr2 = new float[2];
            return new float[]{ARVOJniClient.calModelPosition(this.xV.ah(), f, q(fArr), fArr2), fArr2[0], fArr2[1]};
        }
        return null;
    }

    @Override // com.baidu.ar.vo.b.a
    public void hi() {
        if (this.xW && this.xZ) {
            ARVOJniClient.removeAllModel();
            this.xZ = false;
        }
    }

    @Override // com.baidu.ar.vo.b.b
    public void init() {
        this.xV = com.baidu.ar.algo.a.a(this.xU.yb, this.xU.yc, false);
        try {
            com.baidu.ar.libloader.b.as("module_basic");
            com.baidu.ar.libloader.b.as("module_vo");
            this.xW = ARVOJniClient.start(this.xV.width, this.xV.height, this.xV.ah(), this.xV.ai());
        } catch (UnsatisfiedLinkError e) {
            com.baidu.ar.g.b.b(TAG, "slam algo UnsatisfiedLinkError " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.vo.b.a
    public int insertModel(String str, int i, int i2, float[] fArr, float f) {
        if (this.xW) {
            this.ya = f;
            if (fArr == null) {
                fArr = xT;
            }
            int insertModel = ARVOJniClient.insertModel(str, i, i2, fArr, 1.0f);
            this.xZ = true;
            return insertModel;
        }
        return -1;
    }

    public void release() {
        if (this.xW) {
            ARVOJniClient.stop();
            this.xW = false;
        }
        this.xU = null;
    }
}
