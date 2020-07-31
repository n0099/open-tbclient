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
    private static final float[] xu = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float xB;
    private d xv;
    private com.baidu.ar.algo.a xw;
    private float[] xy;
    private boolean xx = false;
    private float xz = 0.0f;
    private boolean xA = false;

    public c(d dVar) {
        this.xv = dVar;
    }

    private void c(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, xu, 0, fArr3, 0);
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
        float scale = this.xw.getScale();
        float f = fArr[12] * this.xB * scale;
        float f2 = fArr[13] * this.xB * scale;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = scale * fArr[14] * this.xB;
        Matrix.rotateM(fArr, 0, this.xz - 90.0f, 0.0f, 0.0f, 1.0f);
    }

    private float[] p(float[] fArr) {
        if (this.xz == 0.0f) {
            this.xz = this.xv.xE.getAngle();
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, xu, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    @Override // com.baidu.ar.vo.b.b
    public void a(FramePixels framePixels, ICallbackWith<f> iCallbackWith) {
        float[] fM;
        if (framePixels == null || !this.xx || this.xv == null || (fM = this.xv.xE.fM()) == null || fM.length == 0) {
            return;
        }
        if (!this.xA) {
            iCallbackWith.run(new f(framePixels.getTimestamp()));
            return;
        }
        this.xy = fM;
        ARVOJniClient.track(framePixels.getPixelsAddress(), p(fM));
        ArrayList<TrackModel> fetchModelPose = ARVOJniClient.fetchModelPose();
        Iterator<TrackModel> it = fetchModelPose.iterator();
        while (it.hasNext()) {
            c(it.next().pose, this.xy);
        }
        g gVar = new g(framePixels.getTimestamp());
        gVar.G(true);
        gVar.setTracked(true);
        gVar.b(fetchModelPose);
        iCallbackWith.run(new f(gVar));
    }

    @Override // com.baidu.ar.vo.b.a
    public float[] a(float f, float[] fArr) {
        if (this.xx) {
            float[] fArr2 = new float[2];
            return new float[]{ARVOJniClient.calModelPosition(this.xw.ah(), f, p(fArr), fArr2), fArr2[0], fArr2[1]};
        }
        return null;
    }

    @Override // com.baidu.ar.vo.b.b
    public void aV() {
        this.xw = com.baidu.ar.algo.a.a(this.xv.xC, this.xv.xD, false);
        try {
            com.baidu.ar.libloader.b.ao("module_basic");
            com.baidu.ar.libloader.b.ao("module_vo");
            this.xx = ARVOJniClient.start(this.xw.width, this.xw.height, this.xw.ah(), this.xw.ai());
        } catch (UnsatisfiedLinkError e) {
            com.baidu.ar.f.b.b(TAG, "slam algo UnsatisfiedLinkError " + e.getMessage());
        }
    }

    @Override // com.baidu.ar.vo.b.a
    public void fT() {
        if (this.xx && this.xA) {
            ARVOJniClient.removeAllModel();
            this.xA = false;
        }
    }

    @Override // com.baidu.ar.vo.b.a
    public int insertModel(String str, int i, int i2, float[] fArr, float f) {
        if (this.xx) {
            this.xB = f;
            if (fArr == null) {
                fArr = xu;
            }
            int insertModel = ARVOJniClient.insertModel(str, i, i2, fArr, 1.0f);
            this.xA = true;
            return insertModel;
        }
        return -1;
    }

    public void release() {
        if (this.xx) {
            ARVOJniClient.stop();
            this.xx = false;
        }
        this.xv = null;
    }
}
