package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes7.dex */
public final class e {
    private FloatBuffer bHN;
    private FloatBuffer bHO;
    private int bHQ;
    private int bHR;
    private com.baidu.rtc.camera.engine.a.b bIm;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bIs;
    private FloatBuffer bIt;
    private FloatBuffer bIu;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes7.dex */
    private static class a {
        public static e bIv = new e();
    }

    private e() {
        this.bIs = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bIm = com.baidu.rtc.camera.engine.a.b.QL();
    }

    public static e QU() {
        return a.bIv;
    }

    public void init(Context context) {
        QX();
        aR(context);
        this.mContext = context;
    }

    public void release() {
        QW();
        QV();
        this.mContext = null;
    }

    private void QV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bIs.get(i2) != null) {
                    this.bIs.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bIs.clear();
                return;
            }
        }
    }

    private void QW() {
        if (this.bHN != null) {
            this.bHN.clear();
            this.bHN = null;
        }
        if (this.bHO != null) {
            this.bHO.clear();
            this.bHO = null;
        }
        if (this.bIt != null) {
            this.bIt.clear();
            this.bIt = null;
        }
        if (this.bIu != null) {
            this.bIu.clear();
            this.bIu = null;
        }
    }

    private void QX() {
        QW();
        this.bIt = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIY);
        this.bIu = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIZ);
        this.bHN = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIY);
        this.bHO = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bIZ);
    }

    private void aR(Context context) {
        QV();
        this.bIs.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bIs.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bIs.get(0) != null && this.bIs.get(1) != null) {
            if (this.bIs.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bIs.get(0)).w(fArr);
            }
            int b = this.bIs.get(0).b(i, this.bHN, this.bHO);
            this.bIs.get(1).a(b, this.bIt, this.bIu);
            return b;
        }
        return i;
    }

    public void S(int i, int i2) {
        this.bHQ = i;
        this.bHR = i2;
    }

    public void T(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        QZ();
        QY();
    }

    private void QY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bIs.get(i2) != null) {
                    this.bIs.get(i2).U(this.bHQ, this.bHR);
                    if (i2 < 1) {
                        this.bIs.get(i2).W(this.bHQ, this.bHR);
                    }
                    this.bIs.get(i2).V(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void QZ() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bIZ;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bIY;
        float max = Math.max(this.mViewWidth / this.bHQ, this.mViewHeight / this.bHR);
        int round = Math.round(this.bHQ * max);
        int round2 = Math.round(max * this.bHR);
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
        this.bIt.clear();
        this.bIt.put(fArr4).position(0);
        this.bIu.clear();
        this.bIu.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
