package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b aWH;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> aWN;
    private FloatBuffer aWO;
    private FloatBuffer aWP;
    private FloatBuffer aWi;
    private FloatBuffer aWj;
    private int aWl;
    private int aWm;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes6.dex */
    private static class a {
        public static e aWQ = new e();
    }

    private e() {
        this.aWN = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.aWH = com.baidu.rtc.camera.engine.a.b.Fl();
    }

    public static e Fu() {
        return a.aWQ;
    }

    public void init(Context context) {
        Fx();
        ba(context);
        this.mContext = context;
    }

    public void release() {
        Fw();
        Fv();
        this.mContext = null;
    }

    private void Fv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aWN.get(i2) != null) {
                    this.aWN.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.aWN.clear();
                return;
            }
        }
    }

    private void Fw() {
        if (this.aWi != null) {
            this.aWi.clear();
            this.aWi = null;
        }
        if (this.aWj != null) {
            this.aWj.clear();
            this.aWj = null;
        }
        if (this.aWO != null) {
            this.aWO.clear();
            this.aWO = null;
        }
        if (this.aWP != null) {
            this.aWP.clear();
            this.aWP = null;
        }
    }

    private void Fx() {
        Fw();
        this.aWO = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXo);
        this.aWP = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXp);
        this.aWi = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXo);
        this.aWj = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.aXp);
    }

    private void ba(Context context) {
        Fv();
        this.aWN.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.aWN.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int h(int i, float[] fArr) {
        if (this.aWN.get(0) != null && this.aWN.get(1) != null) {
            if (this.aWN.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.aWN.get(0)).h(fArr);
            }
            int d = this.aWN.get(0).d(i, this.aWi, this.aWj);
            this.aWN.get(1).c(d, this.aWO, this.aWP);
            return d;
        }
        return i;
    }

    public void L(int i, int i2) {
        this.aWl = i;
        this.aWm = i2;
    }

    public void M(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        Fz();
        Fy();
    }

    private void Fy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.aWN.get(i2) != null) {
                    this.aWN.get(i2).N(this.aWl, this.aWm);
                    if (i2 < 1) {
                        this.aWN.get(i2).P(this.aWl, this.aWm);
                    }
                    this.aWN.get(i2).O(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void Fz() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXp;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.aXo;
        float max = Math.max(this.mViewWidth / this.aWl, this.mViewHeight / this.aWm);
        int round = Math.round(this.aWl * max);
        int round2 = Math.round(max * this.aWm);
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
        this.aWO.clear();
        this.aWO.put(fArr4).position(0);
        this.aWP.clear();
        this.aWP.put(fArr3).position(0);
    }

    private float n(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
