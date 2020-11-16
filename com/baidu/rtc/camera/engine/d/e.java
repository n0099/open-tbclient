package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes16.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b clV;
    private int clx;
    private int cly;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> cmb;
    private FloatBuffer cmc;
    private FloatBuffer cme;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVertexBuffer;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes16.dex */
    private static class a {
        public static e cmf = new e();
    }

    private e() {
        this.cmb = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.clV = com.baidu.rtc.camera.engine.a.b.adu();
    }

    public static e adD() {
        return a.cmf;
    }

    public void init(Context context) {
        adG();
        ba(context);
        this.mContext = context;
    }

    public void release() {
        adF();
        adE();
        this.mContext = null;
    }

    private void adE() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.cmb.get(i2) != null) {
                    this.cmb.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.cmb.clear();
                return;
            }
        }
    }

    private void adF() {
        if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
            this.mVertexBuffer = null;
        }
        if (this.mTextureBuffer != null) {
            this.mTextureBuffer.clear();
            this.mTextureBuffer = null;
        }
        if (this.cmc != null) {
            this.cmc.clear();
            this.cmc = null;
        }
        if (this.cme != null) {
            this.cme.clear();
            this.cme = null;
        }
    }

    private void adG() {
        adF();
        this.cmc = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.cmF);
        this.cme = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.cmG);
        this.mVertexBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.cmF);
        this.mTextureBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.cmG);
    }

    private void ba(Context context) {
        adE();
        this.cmb.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.cmb.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.cmb.get(0) != null && this.cmb.get(1) != null) {
            if (this.cmb.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.cmb.get(0)).w(fArr);
            }
            int b = this.cmb.get(0).b(i, this.mVertexBuffer, this.mTextureBuffer);
            this.cmb.get(1).a(b, this.cmc, this.cme);
            return b;
        }
        return i;
    }

    public void setTextureSize(int i, int i2) {
        this.clx = i;
        this.cly = i2;
    }

    public void W(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        adI();
        adH();
    }

    private void adH() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.cmb.get(i2) != null) {
                    this.cmb.get(i2).onInputSizeChanged(this.clx, this.cly);
                    if (i2 < 1) {
                        this.cmb.get(i2).Y(this.clx, this.cly);
                    }
                    this.cmb.get(i2).X(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void adI() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.cmG;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.cmF;
        float max = Math.max(this.mViewWidth / this.clx, this.mViewHeight / this.cly);
        int round = Math.round(this.clx * max);
        int round2 = Math.round(max * this.cly);
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
        this.cmc.clear();
        this.cmc.put(fArr4).position(0);
        this.cme.clear();
        this.cme.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
