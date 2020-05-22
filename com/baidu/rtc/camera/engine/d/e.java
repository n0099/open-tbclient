package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private FloatBuffer bCA;
    private FloatBuffer bCB;
    private int bCD;
    private int bCE;
    private com.baidu.rtc.camera.engine.a.b bCZ;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bDf;
    private FloatBuffer bDg;
    private FloatBuffer bDh;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e bDi = new e();
    }

    private e() {
        this.bDf = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bCZ = com.baidu.rtc.camera.engine.a.b.Pq();
    }

    public static e Pz() {
        return a.bDi;
    }

    public void init(Context context) {
        PC();
        aP(context);
        this.mContext = context;
    }

    public void release() {
        PB();
        PA();
        this.mContext = null;
    }

    private void PA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bDf.get(i2) != null) {
                    this.bDf.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bDf.clear();
                return;
            }
        }
    }

    private void PB() {
        if (this.bCA != null) {
            this.bCA.clear();
            this.bCA = null;
        }
        if (this.bCB != null) {
            this.bCB.clear();
            this.bCB = null;
        }
        if (this.bDg != null) {
            this.bDg.clear();
            this.bDg = null;
        }
        if (this.bDh != null) {
            this.bDh.clear();
            this.bDh = null;
        }
    }

    private void PC() {
        PB();
        this.bDg = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bDL);
        this.bDh = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bDM);
        this.bCA = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bDL);
        this.bCB = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bDM);
    }

    private void aP(Context context) {
        PA();
        this.bDf.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bDf.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bDf.get(0) != null && this.bDf.get(1) != null) {
            if (this.bDf.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bDf.get(0)).v(fArr);
            }
            int b = this.bDf.get(0).b(i, this.bCA, this.bCB);
            this.bDf.get(1).a(b, this.bDg, this.bDh);
            return b;
        }
        return i;
    }

    public void Q(int i, int i2) {
        this.bCD = i;
        this.bCE = i2;
    }

    public void R(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        PE();
        PD();
    }

    private void PD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bDf.get(i2) != null) {
                    this.bDf.get(i2).S(this.bCD, this.bCE);
                    if (i2 < 1) {
                        this.bDf.get(i2).U(this.bCD, this.bCE);
                    }
                    this.bDf.get(i2).T(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void PE() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bDM;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bDL;
        float max = Math.max(this.mViewWidth / this.bCD, this.mViewHeight / this.bCE);
        int round = Math.round(this.bCD * max);
        int round2 = Math.round(max * this.bCE);
        float f = round / this.mViewWidth;
        float f2 = round2 / this.mViewHeight;
        if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
            fArr2 = new float[]{fArr4[0] / f2, fArr4[1] / f, fArr4[2] / f2, fArr4[3] / f, fArr4[4] / f2, fArr4[5] / f, fArr4[6] / f2, fArr4[7] / f};
        } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / f)) / 2.0f;
            float f4 = (1.0f - (1.0f / f2)) / 2.0f;
            fArr = new float[]{m(fArr3[0], f3), m(fArr3[1], f4), m(fArr3[2], f3), m(fArr3[3], f4), m(fArr3[4], f3), m(fArr3[5], f4), m(fArr3[6], f3), m(fArr3[7], f4)};
        }
        if (fArr2 != null) {
            fArr4 = fArr2;
        }
        if (fArr != null) {
            fArr3 = fArr;
        }
        this.bDg.clear();
        this.bDg.put(fArr4).position(0);
        this.bDh.clear();
        this.bDh.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
