package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b bHN;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bHT;
    private FloatBuffer bHU;
    private FloatBuffer bHV;
    private FloatBuffer bHo;
    private FloatBuffer bHp;
    private int bHr;
    private int bHs;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e bHW = new e();
    }

    private e() {
        this.bHT = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bHN = com.baidu.rtc.camera.engine.a.b.Qw();
    }

    public static e QF() {
        return a.bHW;
    }

    public void init(Context context) {
        QI();
        aQ(context);
        this.mContext = context;
    }

    public void release() {
        QH();
        QG();
        this.mContext = null;
    }

    private void QG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bHT.get(i2) != null) {
                    this.bHT.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bHT.clear();
                return;
            }
        }
    }

    private void QH() {
        if (this.bHo != null) {
            this.bHo.clear();
            this.bHo = null;
        }
        if (this.bHp != null) {
            this.bHp.clear();
            this.bHp = null;
        }
        if (this.bHU != null) {
            this.bHU.clear();
            this.bHU = null;
        }
        if (this.bHV != null) {
            this.bHV.clear();
            this.bHV = null;
        }
    }

    private void QI() {
        QH();
        this.bHU = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIz);
        this.bHV = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIA);
        this.bHo = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIz);
        this.bHp = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIA);
    }

    private void aQ(Context context) {
        QG();
        this.bHT.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bHT.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bHT.get(0) != null && this.bHT.get(1) != null) {
            if (this.bHT.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bHT.get(0)).w(fArr);
            }
            int b = this.bHT.get(0).b(i, this.bHo, this.bHp);
            this.bHT.get(1).a(b, this.bHU, this.bHV);
            return b;
        }
        return i;
    }

    public void S(int i, int i2) {
        this.bHr = i;
        this.bHs = i2;
    }

    public void T(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        QK();
        QJ();
    }

    private void QJ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bHT.get(i2) != null) {
                    this.bHT.get(i2).U(this.bHr, this.bHs);
                    if (i2 < 1) {
                        this.bHT.get(i2).W(this.bHr, this.bHs);
                    }
                    this.bHT.get(i2).V(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void QK() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bIA;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bIz;
        float max = Math.max(this.mViewWidth / this.bHr, this.mViewHeight / this.bHs);
        int round = Math.round(this.bHr * max);
        int round2 = Math.round(max * this.bHs);
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
        this.bHU.clear();
        this.bHU.put(fArr4).position(0);
        this.bHV.clear();
        this.bHV.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
