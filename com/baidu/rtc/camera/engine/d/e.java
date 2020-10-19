package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public final class e {
    private int bYP;
    private int bYQ;
    private com.baidu.rtc.camera.engine.a.b bZn;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bZt;
    private FloatBuffer bZu;
    private FloatBuffer bZv;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVertexBuffer;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes11.dex */
    private static class a {
        public static e bZw = new e();
    }

    private e() {
        this.bZt = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bZn = com.baidu.rtc.camera.engine.a.b.ZI();
    }

    public static e ZR() {
        return a.bZw;
    }

    public void init(Context context) {
        ZU();
        ba(context);
        this.mContext = context;
    }

    public void release() {
        ZT();
        ZS();
        this.mContext = null;
    }

    private void ZS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bZt.get(i2) != null) {
                    this.bZt.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bZt.clear();
                return;
            }
        }
    }

    private void ZT() {
        if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
            this.mVertexBuffer = null;
        }
        if (this.mTextureBuffer != null) {
            this.mTextureBuffer.clear();
            this.mTextureBuffer = null;
        }
        if (this.bZu != null) {
            this.bZu.clear();
            this.bZu = null;
        }
        if (this.bZv != null) {
            this.bZv.clear();
            this.bZv = null;
        }
    }

    private void ZU() {
        ZT();
        this.bZu = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bZW);
        this.bZv = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bZX);
        this.mVertexBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bZW);
        this.mTextureBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bZX);
    }

    private void ba(Context context) {
        ZS();
        this.bZt.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bZt.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bZt.get(0) != null && this.bZt.get(1) != null) {
            if (this.bZt.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bZt.get(0)).w(fArr);
            }
            int b = this.bZt.get(0).b(i, this.mVertexBuffer, this.mTextureBuffer);
            this.bZt.get(1).a(b, this.bZu, this.bZv);
            return b;
        }
        return i;
    }

    public void setTextureSize(int i, int i2) {
        this.bYP = i;
        this.bYQ = i2;
    }

    public void V(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        ZW();
        ZV();
    }

    private void ZV() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bZt.get(i2) != null) {
                    this.bZt.get(i2).onInputSizeChanged(this.bYP, this.bYQ);
                    if (i2 < 1) {
                        this.bZt.get(i2).X(this.bYP, this.bYQ);
                    }
                    this.bZt.get(i2).W(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void ZW() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bZX;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bZW;
        float max = Math.max(this.mViewWidth / this.bYP, this.mViewHeight / this.bYQ);
        int round = Math.round(this.bYP * max);
        int round2 = Math.round(max * this.bYQ);
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
        this.bZu.clear();
        this.bZu.put(fArr4).position(0);
        this.bZv.clear();
        this.bZv.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
