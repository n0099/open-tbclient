package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes5.dex */
public final class e {
    private FloatBuffer aRJ;
    private FloatBuffer aRK;
    private int aRM;
    private int aRN;
    private com.baidu.rtc.camera.engine.a.b aSi;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> aSo;
    private FloatBuffer aSp;
    private FloatBuffer aSq;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes5.dex */
    private static class a {
        public static e aSr = new e();
    }

    private e() {
        this.aSo = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.aSi = com.baidu.rtc.camera.engine.a.b.CP();
    }

    public static e CY() {
        return a.aSr;
    }

    public void init(Context context) {
        Db();
        aW(context);
        this.mContext = context;
    }

    public void release() {
        Da();
        CZ();
        this.mContext = null;
    }

    private void CZ() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aSo.get(i2) != null) {
                    this.aSo.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.aSo.clear();
                return;
            }
        }
    }

    private void Da() {
        if (this.aRJ != null) {
            this.aRJ.clear();
            this.aRJ = null;
        }
        if (this.aRK != null) {
            this.aRK.clear();
            this.aRK = null;
        }
        if (this.aSp != null) {
            this.aSp.clear();
            this.aSp = null;
        }
        if (this.aSq != null) {
            this.aSq.clear();
            this.aSq = null;
        }
    }

    private void Db() {
        Da();
        this.aSp = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aSP);
        this.aSq = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aSQ);
        this.aRJ = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aSP);
        this.aRK = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aSQ);
    }

    private void aW(Context context) {
        CZ();
        this.aSo.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.aSo.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int h(int i, float[] fArr) {
        if (this.aSo.get(0) != null && this.aSo.get(1) != null) {
            if (this.aSo.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.aSo.get(0)).h(fArr);
            }
            int d = this.aSo.get(0).d(i, this.aRJ, this.aRK);
            this.aSo.get(1).c(d, this.aSp, this.aSq);
            return d;
        }
        return i;
    }

    public void K(int i, int i2) {
        this.aRM = i;
        this.aRN = i2;
    }

    public void L(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        Dd();
        Dc();
    }

    private void Dc() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aSo.get(i2) != null) {
                    this.aSo.get(i2).M(this.aRM, this.aRN);
                    if (i2 < 1) {
                        this.aSo.get(i2).O(this.aRM, this.aRN);
                    }
                    this.aSo.get(i2).N(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void Dd() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.aSQ;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.aSP;
        float max = Math.max(this.mViewWidth / this.aRM, this.mViewHeight / this.aRN);
        int round = Math.round(this.aRM * max);
        int round2 = Math.round(max * this.aRN);
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
        this.aSp.clear();
        this.aSp.put(fArr4).position(0);
        this.aSq.clear();
        this.aSq.put(fArr3).position(0);
    }

    private float n(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
