package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes4.dex */
public class o {
    private final a<PointF, PointF> gS;
    private final a<?, PointF> gT;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> gU;
    private final a<Float, Float> gV;
    private final a<Integer, Integer> gW;
    @Nullable
    private final a<?, Float> gX;
    @Nullable
    private final a<?, Float> gY;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.gS = lVar.co().cm();
        this.gT = lVar.cp().cm();
        this.gU = lVar.cq().cm();
        this.gV = lVar.cr().cm();
        this.gW = lVar.cs().cm();
        if (lVar.ct() != null) {
            this.gX = lVar.ct().cm();
        } else {
            this.gX = null;
        }
        if (lVar.cu() != null) {
            this.gY = lVar.cu().cm();
        } else {
            this.gY = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.gS);
        aVar.a(this.gT);
        aVar.a(this.gU);
        aVar.a(this.gV);
        aVar.a(this.gW);
        if (this.gX != null) {
            aVar.a(this.gX);
        }
        if (this.gY != null) {
            aVar.a(this.gY);
        }
    }

    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.gS.b(interfaceC0010a);
        this.gT.b(interfaceC0010a);
        this.gU.b(interfaceC0010a);
        this.gV.b(interfaceC0010a);
        this.gW.b(interfaceC0010a);
        if (this.gX != null) {
            this.gX.b(interfaceC0010a);
        }
        if (this.gY != null) {
            this.gY.b(interfaceC0010a);
        }
    }

    public void setProgress(float f) {
        this.gS.setProgress(f);
        this.gT.setProgress(f);
        this.gU.setProgress(f);
        this.gV.setProgress(f);
        this.gW.setProgress(f);
        if (this.gX != null) {
            this.gX.setProgress(f);
        }
        if (this.gY != null) {
            this.gY.setProgress(f);
        }
    }

    public a<?, Integer> ca() {
        return this.gW;
    }

    @Nullable
    public a<?, Float> cb() {
        return this.gX;
    }

    @Nullable
    public a<?, Float> cc() {
        return this.gY;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.gT.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.gV.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.gU.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.gS.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.gT.getValue();
        PointF value2 = this.gS.getValue();
        com.airbnb.lottie.e.d value3 = this.gU.getValue();
        float floatValue = this.gV.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.eP) {
            this.gS.a(cVar);
        } else if (t == com.airbnb.lottie.k.eQ) {
            this.gT.a(cVar);
        } else if (t == com.airbnb.lottie.k.eT) {
            this.gU.a(cVar);
        } else if (t == com.airbnb.lottie.k.eU) {
            this.gV.a(cVar);
        } else if (t == com.airbnb.lottie.k.eN) {
            this.gW.a(cVar);
        } else if (t == com.airbnb.lottie.k.fh && this.gX != null) {
            this.gX.a(cVar);
        } else if (t == com.airbnb.lottie.k.fi && this.gY != null) {
            this.gY.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
