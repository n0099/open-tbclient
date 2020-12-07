package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b csR;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> csX;
    private FloatBuffer csY;
    private FloatBuffer csZ;
    private int csv;
    private int csw;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVertexBuffer;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes11.dex */
    private static class a {
        public static e cta = new e();
    }

    private e() {
        this.csX = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.csR = com.baidu.rtc.camera.engine.a.b.agC();
    }

    public static e agL() {
        return a.cta;
    }

    public void init(Context context) {
        agO();
        bG(context);
        this.mContext = context;
    }

    public void release() {
        agN();
        agM();
        this.mContext = null;
    }

    private void agM() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.csX.get(i2) != null) {
                    this.csX.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.csX.clear();
                return;
            }
        }
    }

    private void agN() {
        if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
            this.mVertexBuffer = null;
        }
        if (this.mTextureBuffer != null) {
            this.mTextureBuffer.clear();
            this.mTextureBuffer = null;
        }
        if (this.csY != null) {
            this.csY.clear();
            this.csY = null;
        }
        if (this.csZ != null) {
            this.csZ.clear();
            this.csZ = null;
        }
    }

    private void agO() {
        agN();
        this.csY = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.ctB);
        this.csZ = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.ctC);
        this.mVertexBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.ctB);
        this.mTextureBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.ctC);
    }

    private void bG(Context context) {
        agM();
        this.csX.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.csX.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.csX.get(0) != null && this.csX.get(1) != null) {
            if (this.csX.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.csX.get(0)).v(fArr);
            }
            int b = this.csX.get(0).b(i, this.mVertexBuffer, this.mTextureBuffer);
            this.csX.get(1).a(b, this.csY, this.csZ);
            return b;
        }
        return i;
    }

    public void setTextureSize(int i, int i2) {
        this.csv = i;
        this.csw = i2;
    }

    public void Y(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        agQ();
        agP();
    }

    private void agP() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.csX.get(i2) != null) {
                    this.csX.get(i2).onInputSizeChanged(this.csv, this.csw);
                    if (i2 < 1) {
                        this.csX.get(i2).aa(this.csv, this.csw);
                    }
                    this.csX.get(i2).Z(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void agQ() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.ctC;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.ctB;
        float max = Math.max(this.mViewWidth / this.csv, this.mViewHeight / this.csw);
        int round = Math.round(this.csv * max);
        int round2 = Math.round(max * this.csw);
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
        this.csY.clear();
        this.csY.put(fArr4).position(0);
        this.csZ.clear();
        this.csZ.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
