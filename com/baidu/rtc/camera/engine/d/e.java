package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes15.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b bPR;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bPX;
    private FloatBuffer bPY;
    private FloatBuffer bPZ;
    private int bPt;
    private int bPu;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVertexBuffer;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes15.dex */
    private static class a {
        public static e bQa = new e();
    }

    private e() {
        this.bPX = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bPR = com.baidu.rtc.camera.engine.a.b.Xq();
    }

    public static e Xz() {
        return a.bQa;
    }

    public void init(Context context) {
        XC();
        aV(context);
        this.mContext = context;
    }

    public void release() {
        XB();
        XA();
        this.mContext = null;
    }

    private void XA() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bPX.get(i2) != null) {
                    this.bPX.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bPX.clear();
                return;
            }
        }
    }

    private void XB() {
        if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
            this.mVertexBuffer = null;
        }
        if (this.mTextureBuffer != null) {
            this.mTextureBuffer.clear();
            this.mTextureBuffer = null;
        }
        if (this.bPY != null) {
            this.bPY.clear();
            this.bPY = null;
        }
        if (this.bPZ != null) {
            this.bPZ.clear();
            this.bPZ = null;
        }
    }

    private void XC() {
        XB();
        this.bPY = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bQA);
        this.bPZ = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bQB);
        this.mVertexBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bQA);
        this.mTextureBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bQB);
    }

    private void aV(Context context) {
        XA();
        this.bPX.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bPX.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bPX.get(0) != null && this.bPX.get(1) != null) {
            if (this.bPX.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bPX.get(0)).w(fArr);
            }
            int b = this.bPX.get(0).b(i, this.mVertexBuffer, this.mTextureBuffer);
            this.bPX.get(1).a(b, this.bPY, this.bPZ);
            return b;
        }
        return i;
    }

    public void V(int i, int i2) {
        this.bPt = i;
        this.bPu = i2;
    }

    public void W(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        XE();
        XD();
    }

    private void XD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bPX.get(i2) != null) {
                    this.bPX.get(i2).onInputSizeChanged(this.bPt, this.bPu);
                    if (i2 < 1) {
                        this.bPX.get(i2).Y(this.bPt, this.bPu);
                    }
                    this.bPX.get(i2).X(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void XE() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bQB;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bQA;
        float max = Math.max(this.mViewWidth / this.bPt, this.mViewHeight / this.bPu);
        int round = Math.round(this.bPt * max);
        int round2 = Math.round(max * this.bPu);
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
        this.bPY.clear();
        this.bPY.put(fArr4).position(0);
        this.bPZ.clear();
        this.bPZ.put(fArr3).position(0);
    }

    private float m(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
