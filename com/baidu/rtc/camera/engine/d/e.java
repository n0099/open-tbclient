package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b aWJ;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> aWP;
    private FloatBuffer aWQ;
    private FloatBuffer aWR;
    private FloatBuffer aWk;
    private FloatBuffer aWl;
    private int aWn;
    private int aWo;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e aWS = new e();
    }

    private e() {
        this.aWP = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.aWJ = com.baidu.rtc.camera.engine.a.b.Fn();
    }

    public static e Fw() {
        return a.aWS;
    }

    public void init(Context context) {
        Fz();
        ba(context);
        this.mContext = context;
    }

    public void release() {
        Fy();
        Fx();
        this.mContext = null;
    }

    private void Fx() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aWP.get(i2) != null) {
                    this.aWP.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.aWP.clear();
                return;
            }
        }
    }

    private void Fy() {
        if (this.aWk != null) {
            this.aWk.clear();
            this.aWk = null;
        }
        if (this.aWl != null) {
            this.aWl.clear();
            this.aWl = null;
        }
        if (this.aWQ != null) {
            this.aWQ.clear();
            this.aWQ = null;
        }
        if (this.aWR != null) {
            this.aWR.clear();
            this.aWR = null;
        }
    }

    private void Fz() {
        Fy();
        this.aWQ = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXq);
        this.aWR = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXr);
        this.aWk = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXq);
        this.aWl = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXr);
    }

    private void ba(Context context) {
        Fx();
        this.aWP.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.aWP.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int h(int i, float[] fArr) {
        if (this.aWP.get(0) != null && this.aWP.get(1) != null) {
            if (this.aWP.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.aWP.get(0)).h(fArr);
            }
            int d = this.aWP.get(0).d(i, this.aWk, this.aWl);
            this.aWP.get(1).c(d, this.aWQ, this.aWR);
            return d;
        }
        return i;
    }

    public void L(int i, int i2) {
        this.aWn = i;
        this.aWo = i2;
    }

    public void M(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        FB();
        FA();
    }

    private void FA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aWP.get(i2) != null) {
                    this.aWP.get(i2).N(this.aWn, this.aWo);
                    if (i2 < 1) {
                        this.aWP.get(i2).P(this.aWn, this.aWo);
                    }
                    this.aWP.get(i2).O(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void FB() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXr;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXq;
        float max = Math.max(this.mViewWidth / this.aWn, this.mViewHeight / this.aWo);
        int round = Math.round(this.aWn * max);
        int round2 = Math.round(max * this.aWo);
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
        this.aWQ.clear();
        this.aWQ.put(fArr4).position(0);
        this.aWR.clear();
        this.aWR.put(fArr3).position(0);
    }

    private float n(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
