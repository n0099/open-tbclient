package com.baidu.ar.vo.b;

import android.opengl.Matrix;
import com.baidu.ar.algovo.ARVOJniClient;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.slam.TrackModel;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c implements a, b {
    public static final String TAG = "c";
    public static final float[] yI = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public d yJ;
    public com.baidu.ar.algo.a yK;
    public float[] yM;
    public float yP;
    public boolean yL = false;
    public float yN = 0.0f;
    public boolean yO = false;

    public c(d dVar) {
        this.yJ = dVar;
    }

    private void c(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, yI, 0, fArr3, 0);
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
        float scale = this.yK.getScale();
        float f = fArr[12];
        float f2 = this.yP;
        fArr[12] = f * f2 * scale;
        fArr[13] = fArr[13] * f2 * scale;
        fArr[14] = fArr[14] * f2 * scale;
        Matrix.rotateM(fArr, 0, this.yN - 90.0f, 0.0f, 0.0f, 1.0f);
    }

    private float[] p(float[] fArr) {
        if (this.yN == 0.0f) {
            this.yN = this.yJ.yS.getAngle();
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, yI, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    @Override // com.baidu.ar.vo.b.b
    public void a(FramePixels framePixels, ICallbackWith<f> iCallbackWith) {
        d dVar;
        float[] hb;
        if (framePixels == null || !this.yL || (dVar = this.yJ) == null || (hb = dVar.yS.hb()) == null || hb.length == 0) {
            return;
        }
        if (!this.yO) {
            iCallbackWith.run(new f(framePixels.getTimestamp()));
            return;
        }
        this.yM = hb;
        ARVOJniClient.track(framePixels.getPixelsAddress(), p(hb));
        ArrayList<TrackModel> fetchModelPose = ARVOJniClient.fetchModelPose();
        Iterator<TrackModel> it = fetchModelPose.iterator();
        while (it.hasNext()) {
            c(it.next().pose, this.yM);
        }
        g gVar = new g(framePixels.getTimestamp());
        gVar.F(true);
        gVar.setTracked(true);
        gVar.b(fetchModelPose);
        iCallbackWith.run(new f(gVar));
    }

    @Override // com.baidu.ar.vo.b.a
    public float[] a(float f, float[] fArr) {
        if (this.yL) {
            float[] fArr2 = new float[2];
            return new float[]{ARVOJniClient.calModelPosition(this.yK.aj(), f, p(fArr), fArr2), fArr2[0], fArr2[1]};
        }
        return null;
    }

    @Override // com.baidu.ar.vo.b.a
    public void hi() {
        if (this.yL && this.yO) {
            ARVOJniClient.removeAllModel();
            this.yO = false;
        }
    }

    @Override // com.baidu.ar.vo.b.b
    public void init() {
        d dVar = this.yJ;
        this.yK = com.baidu.ar.algo.a.a(dVar.yQ, dVar.yR, false);
        try {
            com.baidu.ar.libloader.a.require("ardatabasic");
            com.baidu.ar.libloader.a.require("module_basic");
            com.baidu.ar.libloader.a.require("module_vo");
            this.yL = ARVOJniClient.start(this.yK.width, this.yK.height, this.yK.aj(), this.yK.ak());
        } catch (UnsatisfiedLinkError e) {
            String str = TAG;
            com.baidu.ar.h.b.b(str, "slam algo UnsatisfiedLinkError " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.vo.b.a
    public int insertModel(String str, int i, int i2, float[] fArr, float f) {
        if (this.yL) {
            this.yP = f;
            if (fArr == null) {
                fArr = yI;
            }
            int insertModel = ARVOJniClient.insertModel(str, i, i2, fArr, 1.0f);
            this.yO = true;
            return insertModel;
        }
        return -1;
    }

    public void release() {
        if (this.yL) {
            ARVOJniClient.stop();
            this.yL = false;
        }
        this.yJ = null;
    }
}
