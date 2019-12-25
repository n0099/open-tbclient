package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public final class e {
    private FloatBuffer aQR;
    private FloatBuffer aQS;
    private int aQU;
    private int aQV;
    private com.baidu.rtc.camera.engine.a.b aRq;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> aRw;
    private FloatBuffer aRx;
    private FloatBuffer aRy;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes4.dex */
    private static class a {
        public static e aRz = new e();
    }

    private e() {
        this.aRw = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.aRq = com.baidu.rtc.camera.engine.a.b.Ct();
    }

    public static e CC() {
        return a.aRz;
    }

    public void init(Context context) {
        CF();
        aW(context);
        this.mContext = context;
    }

    public void release() {
        CE();
        CD();
        this.mContext = null;
    }

    private void CD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aRw.get(i2) != null) {
                    this.aRw.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.aRw.clear();
                return;
            }
        }
    }

    private void CE() {
        if (this.aQR != null) {
            this.aQR.clear();
            this.aQR = null;
        }
        if (this.aQS != null) {
            this.aQS.clear();
            this.aQS = null;
        }
        if (this.aRx != null) {
            this.aRx.clear();
            this.aRx = null;
        }
        if (this.aRy != null) {
            this.aRy.clear();
            this.aRy = null;
        }
    }

    private void CF() {
        CE();
        this.aRx = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aRX);
        this.aRy = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aRY);
        this.aQR = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aRX);
        this.aQS = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aRY);
    }

    private void aW(Context context) {
        CD();
        this.aRw.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.aRw.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int h(int i, float[] fArr) {
        if (this.aRw.get(0) != null && this.aRw.get(1) != null) {
            if (this.aRw.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.aRw.get(0)).h(fArr);
            }
            int d = this.aRw.get(0).d(i, this.aQR, this.aQS);
            this.aRw.get(1).c(d, this.aRx, this.aRy);
            return d;
        }
        return i;
    }

    public void G(int i, int i2) {
        this.aQU = i;
        this.aQV = i2;
    }

    public void H(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        CH();
        CG();
    }

    private void CG() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aRw.get(i2) != null) {
                    this.aRw.get(i2).I(this.aQU, this.aQV);
                    if (i2 < 1) {
                        this.aRw.get(i2).K(this.aQU, this.aQV);
                    }
                    this.aRw.get(i2).J(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void CH() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.aRY;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.aRX;
        float max = Math.max(this.mViewWidth / this.aQU, this.mViewHeight / this.aQV);
        int round = Math.round(this.aQU * max);
        int round2 = Math.round(max * this.aQV);
        float f = round / this.mViewWidth;
        float f2 = round2 / this.mViewHeight;
        if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
            fArr2 = new float[]{fArr4[0] / f2, fArr4[1] / f, fArr4[2] / f2, fArr4[3] / f, fArr4[4] / f2, fArr4[5] / f, fArr4[6] / f2, fArr4[7] / f};
        } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / f)) / 2.0f;
            float f4 = (1.0f - (1.0f / f2)) / 2.0f;
            fArr = new float[]{n(fArr3[0], f3), n(fArr3[1], f4), n(fArr3[2], f3), n(fArr3[3], f4), n(fArr3[4], f3), n(fArr3[5], f4), n(fArr3[6], f3), n(fArr3[7], f4)};
        }
        if (fArr2 != null) {
            fArr4 = fArr2;
        }
        if (fArr != null) {
            fArr3 = fArr;
        }
        this.aRx.clear();
        this.aRx.put(fArr4).position(0);
        this.aRy.clear();
        this.aRy.put(fArr3).position(0);
    }

    private float n(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
