package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b aWI;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> aWO;
    private FloatBuffer aWP;
    private FloatBuffer aWQ;
    private FloatBuffer aWj;
    private FloatBuffer aWk;
    private int aWm;
    private int aWn;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e aWR = new e();
    }

    private e() {
        this.aWO = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.aWI = com.baidu.rtc.camera.engine.a.b.Fn();
    }

    public static e Fw() {
        return a.aWR;
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
                if (this.aWO.get(i2) != null) {
                    this.aWO.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.aWO.clear();
                return;
            }
        }
    }

    private void Fy() {
        if (this.aWj != null) {
            this.aWj.clear();
            this.aWj = null;
        }
        if (this.aWk != null) {
            this.aWk.clear();
            this.aWk = null;
        }
        if (this.aWP != null) {
            this.aWP.clear();
            this.aWP = null;
        }
        if (this.aWQ != null) {
            this.aWQ.clear();
            this.aWQ = null;
        }
    }

    private void Fz() {
        Fy();
        this.aWP = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXp);
        this.aWQ = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXq);
        this.aWj = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXp);
        this.aWk = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXq);
    }

    private void ba(Context context) {
        Fx();
        this.aWO.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.aWO.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int h(int i, float[] fArr) {
        if (this.aWO.get(0) != null && this.aWO.get(1) != null) {
            if (this.aWO.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.aWO.get(0)).h(fArr);
            }
            int d = this.aWO.get(0).d(i, this.aWj, this.aWk);
            this.aWO.get(1).c(d, this.aWP, this.aWQ);
            return d;
        }
        return i;
    }

    public void L(int i, int i2) {
        this.aWm = i;
        this.aWn = i2;
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
                if (this.aWO.get(i2) != null) {
                    this.aWO.get(i2).N(this.aWm, this.aWn);
                    if (i2 < 1) {
                        this.aWO.get(i2).P(this.aWm, this.aWn);
                    }
                    this.aWO.get(i2).O(this.mViewWidth, this.mViewHeight);
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
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXq;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXp;
        float max = Math.max(this.mViewWidth / this.aWm, this.mViewHeight / this.aWn);
        int round = Math.round(this.aWm * max);
        int round2 = Math.round(max * this.aWn);
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
        this.aWP.clear();
        this.aWP.put(fArr4).position(0);
        this.aWQ.clear();
        this.aWQ.put(fArr3).position(0);
    }

    private float n(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
