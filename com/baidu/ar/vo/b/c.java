package com.baidu.ar.vo.b;

import android.opengl.Matrix;
import com.baidu.ar.algovo.ARVOJniClient;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c implements a, b {
    private static final String TAG = c.class.getSimpleName();
    private static final float[] wU = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private d wV;
    private com.baidu.ar.algo.a wW;
    private float[] wY;
    private float xb;
    private boolean wX = false;
    private float wZ = 0.0f;
    private boolean xa = false;

    public c(d dVar) {
        this.wV = dVar;
    }

    private void c(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, wU, 0, fArr3, 0);
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
        float scale = this.wW.getScale();
        float f = fArr[12] * this.xb * scale;
        float f2 = fArr[13] * this.xb * scale;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = scale * fArr[14] * this.xb;
        Matrix.rotateM(fArr, 0, this.wZ - 90.0f, 0.0f, 0.0f, 1.0f);
    }

    private float[] o(float[] fArr) {
        if (this.wZ == 0.0f) {
            this.wZ = this.wV.xe.getAngle();
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, wU, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    @Override // com.baidu.ar.vo.b.b
    public void a(FramePixels framePixels, ICallbackWith<f> iCallbackWith) {
        float[] fw;
        if (framePixels == null || !this.wX || this.wV == null || (fw = this.wV.xe.fw()) == null || fw.length == 0) {
            return;
        }
        if (!this.xa) {
            iCallbackWith.run(new f(framePixels.getTimestamp()));
            return;
        }
        this.wY = fw;
        ARVOJniClient.track(framePixels.getPixelsAddress(), o(fw));
        ArrayList<TrackModel> fetchModelPose = ARVOJniClient.fetchModelPose();
        Iterator<TrackModel> it = fetchModelPose.iterator();
        while (it.hasNext()) {
            c(it.next().pose, this.wY);
        }
        g gVar = new g(framePixels.getTimestamp());
        gVar.G(true);
        gVar.setTracked(true);
        gVar.b(fetchModelPose);
        iCallbackWith.run(new f(gVar));
    }

    @Override // com.baidu.ar.vo.b.a
    public float[] a(float f, float[] fArr) {
        if (this.wX) {
            float[] fArr2 = new float[2];
            return new float[]{ARVOJniClient.calModelPosition(this.wW.T(), f, o(fArr), fArr2), fArr2[0], fArr2[1]};
        }
        return null;
    }

    @Override // com.baidu.ar.vo.b.b
    public void aH() {
        this.wW = com.baidu.ar.algo.a.a(this.wV.xc, this.wV.xd, false);
        try {
            com.baidu.ar.libloader.b.an("module_basic");
            com.baidu.ar.libloader.b.an("module_vo");
            this.wX = ARVOJniClient.start(this.wW.width, this.wW.height, this.wW.T(), this.wW.U());
        } catch (UnsatisfiedLinkError e) {
            com.baidu.ar.f.b.b(TAG, "slam algo UnsatisfiedLinkError " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.vo.b.a
    public void fD() {
        if (this.wX && this.xa) {
            ARVOJniClient.removeAllModel();
            this.xa = false;
        }
    }

    @Override // com.baidu.ar.vo.b.a
    public int insertModel(String str, int i, int i2, float[] fArr, float f) {
        if (this.wX) {
            this.xb = f;
            if (fArr == null) {
                fArr = wU;
            }
            int insertModel = ARVOJniClient.insertModel(str, i, i2, fArr, 1.0f);
            this.xa = true;
            return insertModel;
        }
        return -1;
    }

    public void release() {
        if (this.wX) {
            ARVOJniClient.stop();
            this.wX = false;
        }
        this.wV = null;
    }
}
