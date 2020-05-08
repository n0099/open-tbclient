package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private FloatBuffer buX;
    private FloatBuffer buY;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bvC;
    private FloatBuffer bvD;
    private FloatBuffer bvE;
    private int bva;
    private int bvb;
    private com.baidu.rtc.camera.engine.a.b bvw;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e bvF = new e();
    }

    private e() {
        this.bvC = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bvw = com.baidu.rtc.camera.engine.a.b.Nd();
    }

    public static e Nm() {
        return a.bvF;
    }

    public void init(Context context) {
        Np();
        aF(context);
        this.mContext = context;
    }

    public void release() {
        No();
        Nn();
        this.mContext = null;
    }

    private void Nn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bvC.get(i2) != null) {
                    this.bvC.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bvC.clear();
                return;
            }
        }
    }

    private void No() {
        if (this.buX != null) {
            this.buX.clear();
            this.buX = null;
        }
        if (this.buY != null) {
            this.buY.clear();
            this.buY = null;
        }
        if (this.bvD != null) {
            this.bvD.clear();
            this.bvD = null;
        }
        if (this.bvE != null) {
            this.bvE.clear();
            this.bvE = null;
        }
    }

    private void Np() {
        No();
        this.bvD = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwi);
        this.bvE = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwj);
        this.buX = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwi);
        this.buY = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwj);
    }

    private void aF(Context context) {
        Nn();
        this.bvC.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bvC.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bvC.get(0) != null && this.bvC.get(1) != null) {
            if (this.bvC.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bvC.get(0)).v(fArr);
            }
            int b = this.bvC.get(0).b(i, this.buX, this.buY);
            this.bvC.get(1).a(b, this.bvD, this.bvE);
            return b;
        }
        return i;
    }

    public void N(int i, int i2) {
        this.bva = i;
        this.bvb = i2;
    }

    public void O(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        Nr();
        Nq();
    }

    private void Nq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bvC.get(i2) != null) {
                    this.bvC.get(i2).P(this.bva, this.bvb);
                    if (i2 < 1) {
                        this.bvC.get(i2).R(this.bva, this.bvb);
                    }
                    this.bvC.get(i2).Q(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void Nr() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bwj;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bwi;
        float max = Math.max(this.mViewWidth / this.bva, this.mViewHeight / this.bvb);
        int round = Math.round(this.bva * max);
        int round2 = Math.round(max * this.bvb);
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
        this.bvD.clear();
        this.bvD.put(fArr4).position(0);
        this.bvE.clear();
        this.bvE.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
