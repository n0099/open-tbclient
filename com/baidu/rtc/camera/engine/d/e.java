package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private int aWA;
    private int aWB;
    private com.baidu.rtc.camera.engine.a.b aWW;
    private FloatBuffer aWx;
    private FloatBuffer aWy;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> aXc;
    private FloatBuffer aXd;
    private FloatBuffer aXe;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e aXf = new e();
    }

    private e() {
        this.aXc = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.aWW = com.baidu.rtc.camera.engine.a.b.Fs();
    }

    public static e FB() {
        return a.aXf;
    }

    public void init(Context context) {
        FE();
        aZ(context);
        this.mContext = context;
    }

    public void release() {
        FD();
        FC();
        this.mContext = null;
    }

    private void FC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aXc.get(i2) != null) {
                    this.aXc.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.aXc.clear();
                return;
            }
        }
    }

    private void FD() {
        if (this.aWx != null) {
            this.aWx.clear();
            this.aWx = null;
        }
        if (this.aWy != null) {
            this.aWy.clear();
            this.aWy = null;
        }
        if (this.aXd != null) {
            this.aXd.clear();
            this.aXd = null;
        }
        if (this.aXe != null) {
            this.aXe.clear();
            this.aXe = null;
        }
    }

    private void FE() {
        FD();
        this.aXd = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXD);
        this.aXe = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXE);
        this.aWx = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXD);
        this.aWy = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXE);
    }

    private void aZ(Context context) {
        FC();
        this.aXc.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.aXc.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int h(int i, float[] fArr) {
        if (this.aXc.get(0) != null && this.aXc.get(1) != null) {
            if (this.aXc.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.aXc.get(0)).h(fArr);
            }
            int d = this.aXc.get(0).d(i, this.aWx, this.aWy);
            this.aXc.get(1).c(d, this.aXd, this.aXe);
            return d;
        }
        return i;
    }

    public void L(int i, int i2) {
        this.aWA = i;
        this.aWB = i2;
    }

    public void M(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        FG();
        FF();
    }

    private void FF() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aXc.get(i2) != null) {
                    this.aXc.get(i2).N(this.aWA, this.aWB);
                    if (i2 < 1) {
                        this.aXc.get(i2).P(this.aWA, this.aWB);
                    }
                    this.aXc.get(i2).O(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void FG() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXE;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXD;
        float max = Math.max(this.mViewWidth / this.aWA, this.mViewHeight / this.aWB);
        int round = Math.round(this.aWA * max);
        int round2 = Math.round(max * this.aWB);
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
        this.aXd.clear();
        this.aXd.put(fArr4).position(0);
        this.aXe.clear();
        this.aXe.put(fArr3).position(0);
    }

    private float n(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
