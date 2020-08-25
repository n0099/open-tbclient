package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.util.SparseArray;
import android.widget.ImageView;
import java.nio.FloatBuffer;
/* loaded from: classes11.dex */
public final class e {
    private com.baidu.rtc.camera.engine.a.b bNN;
    private SparseArray<com.baidu.rtc.camera.filter.glfilter.a.a> bNT;
    private FloatBuffer bNU;
    private FloatBuffer bNV;
    private int bNp;
    private int bNq;
    private Context mContext;
    private ImageView.ScaleType mScaleType;
    private FloatBuffer mTextureBuffer;
    private FloatBuffer mVertexBuffer;
    private int mViewHeight;
    private int mViewWidth;

    /* loaded from: classes11.dex */
    private static class a {
        public static e bNW = new e();
    }

    private e() {
        this.bNT = new SparseArray<>();
        this.mScaleType = ImageView.ScaleType.CENTER_CROP;
        this.bNN = com.baidu.rtc.camera.engine.a.b.WH();
    }

    public static e WQ() {
        return a.bNW;
    }

    public void init(Context context) {
        WT();
        aW(context);
        this.mContext = context;
    }

    public void release() {
        WS();
        WR();
        this.mContext = null;
    }

    private void WR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bNT.get(i2) != null) {
                    this.bNT.get(i2).release();
                }
                i = i2 + 1;
            } else {
                this.bNT.clear();
                return;
            }
        }
    }

    private void WS() {
        if (this.mVertexBuffer != null) {
            this.mVertexBuffer.clear();
            this.mVertexBuffer = null;
        }
        if (this.mTextureBuffer != null) {
            this.mTextureBuffer.clear();
            this.mTextureBuffer = null;
        }
        if (this.bNU != null) {
            this.bNU.clear();
            this.bNU = null;
        }
        if (this.bNV != null) {
            this.bNV.clear();
            this.bNV = null;
        }
    }

    private void WT() {
        WS();
        this.bNU = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bOw);
        this.bNV = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bOx);
        this.mVertexBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bOw);
        this.mTextureBuffer = com.baidu.rtc.camera.filter.glfilter.utils.a.createFloatBuffer(com.baidu.rtc.camera.filter.glfilter.utils.b.bOx);
    }

    private void aW(Context context) {
        WR();
        this.bNT.put(0, new com.baidu.rtc.camera.filter.glfilter.a.b(context));
        this.bNT.put(1, new com.baidu.rtc.camera.filter.glfilter.a.a(context));
    }

    public int a(int i, float[] fArr) {
        if (this.bNT.get(0) != null && this.bNT.get(1) != null) {
            if (this.bNT.get(0) instanceof com.baidu.rtc.camera.filter.glfilter.a.b) {
                ((com.baidu.rtc.camera.filter.glfilter.a.b) this.bNT.get(0)).w(fArr);
            }
            int b = this.bNT.get(0).b(i, this.mVertexBuffer, this.mTextureBuffer);
            this.bNT.get(1).a(b, this.bNU, this.bNV);
            return b;
        }
        return i;
    }

    public void V(int i, int i2) {
        this.bNp = i;
        this.bNq = i2;
    }

    public void W(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        WV();
        WU();
    }

    private void WU() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 2) {
                if (this.bNT.get(i2) != null) {
                    this.bNT.get(i2).onInputSizeChanged(this.bNp, this.bNq);
                    if (i2 < 1) {
                        this.bNT.get(i2).Y(this.bNp, this.bNq);
                    }
                    this.bNT.get(i2).X(this.mViewWidth, this.mViewHeight);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void WV() {
        float[] fArr = null;
        float[] fArr2 = null;
        float[] fArr3 = com.baidu.rtc.camera.filter.glfilter.utils.b.bOx;
        float[] fArr4 = com.baidu.rtc.camera.filter.glfilter.utils.b.bOw;
        float max = Math.max(this.mViewWidth / this.bNp, this.mViewHeight / this.bNq);
        int round = Math.round(this.bNp * max);
        int round2 = Math.round(max * this.bNq);
        float f = round / this.mViewWidth;
        float f2 = round2 / this.mViewHeight;
        if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
            fArr2 = new float[]{fArr4[0] / f2, fArr4[1] / f, fArr4[2] / f2, fArr4[3] / f, fArr4[4] / f2, fArr4[5] / f, fArr4[6] / f2, fArr4[7] / f};
        } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
            float f3 = (1.0f - (1.0f / f)) / 2.0f;
            float f4 = (1.0f - (1.0f / f2)) / 2.0f;
            fArr = new float[]{l(fArr3[0], f3), l(fArr3[1], f4), l(fArr3[2], f3), l(fArr3[3], f4), l(fArr3[4], f3), l(fArr3[5], f4), l(fArr3[6], f3), l(fArr3[7], f4)};
        }
        if (fArr2 != null) {
            fArr4 = fArr2;
        }
        if (fArr != null) {
            fArr3 = fArr;
        }
        this.bNU.clear();
        this.bNU.put(fArr4).position(0);
        this.bNV.clear();
        this.bNV.put(fArr3).position(0);
    }

    private float l(float f, float f2) {
        return f == 0.0f ? f2 : 1.0f - f2;
    }
}
