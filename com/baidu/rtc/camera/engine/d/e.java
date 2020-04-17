package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private FloatBuffer buS;
    private FloatBuffer buT;
    private int buV;
    private int buW;
    private com.baidu.rtc.camera.engine.a.b bvr;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bvx;
    private FloatBuffer bvy;
    private FloatBuffer bvz;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e bvA = new e();
    }

    private e() {
        this.bvx = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bvr = com.baidu.rtc.camera.engine.a.b.Ne();
    }

    public static e Nn() {
        return a.bvA;
    }

    public void init(Context context) {
        Nq();
        aR(context);
        this.mContext = context;
    }

    public void release() {
        Np();
        No();
        this.mContext = null;
    }

    private void No() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bvx.get(i2) != null) {
                    this.bvx.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bvx.clear();
                return;
            }
        }
    }

    private void Np() {
        if (this.buS != null) {
            this.buS.clear();
            this.buS = null;
        }
        if (this.buT != null) {
            this.buT.clear();
            this.buT = null;
        }
        if (this.bvy != null) {
            this.bvy.clear();
            this.bvy = null;
        }
        if (this.bvz != null) {
            this.bvz.clear();
            this.bvz = null;
        }
    }

    private void Nq() {
        Np();
        this.bvy = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwd);
        this.bvz = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwe);
        this.buS = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwd);
        this.buT = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bwe);
    }

    private void aR(Context context) {
        No();
        this.bvx.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bvx.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bvx.get(0) != null && this.bvx.get(1) != null) {
            if (this.bvx.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bvx.get(0)).v(fArr);
            }
            int b = this.bvx.get(0).b(i, this.buS, this.buT);
            this.bvx.get(1).a(b, this.bvy, this.bvz);
            return b;
        }
        return i;
    }

    public void N(int i, int i2) {
        this.buV = i;
        this.buW = i2;
    }

    public void O(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        Ns();
        Nr();
    }

    private void Nr() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bvx.get(i2) != null) {
                    this.bvx.get(i2).P(this.buV, this.buW);
                    if (i2 < 1) {
                        this.bvx.get(i2).R(this.buV, this.buW);
                    }
                    this.bvx.get(i2).Q(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void Ns() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bwe;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bwd;
        float max = Math.max(this.mViewWidth / this.buV, this.mViewHeight / this.buW);
        int round = Math.round(this.buV * max);
        int round2 = Math.round(max * this.buW);
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
        this.bvy.clear();
        this.bvy.put(fArr4).position(0);
        this.bvz.clear();
        this.bvz.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
