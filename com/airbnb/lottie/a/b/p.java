package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pS;
    private final a<?, PointF> pT;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> pU;
    private final a<Float, Float> pV;
    private final a<Integer, Integer> pW;
    @Nullable
    private final a<?, Float> pX;
    @Nullable
    private final a<?, Float> pY;

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.pS = lVar.dS().dH();
        this.pT = lVar.dT().dH();
        this.pU = lVar.dU().dH();
        this.pV = lVar.dV().dH();
        this.pW = lVar.dW().dH();
        if (lVar.dX() != null) {
            this.pX = lVar.dX().dH();
        } else {
            this.pX = null;
        }
        if (lVar.dY() != null) {
            this.pY = lVar.dY().dH();
        } else {
            this.pY = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pS);
        aVar.a(this.pT);
        aVar.a(this.pU);
        aVar.a(this.pV);
        aVar.a(this.pW);
        if (this.pX != null) {
            aVar.a(this.pX);
        }
        if (this.pY != null) {
            aVar.a(this.pY);
        }
    }

    public void a(a.InterfaceC0009a interfaceC0009a) {
        this.pS.b(interfaceC0009a);
        this.pT.b(interfaceC0009a);
        this.pU.b(interfaceC0009a);
        this.pV.b(interfaceC0009a);
        this.pW.b(interfaceC0009a);
        if (this.pX != null) {
            this.pX.b(interfaceC0009a);
        }
        if (this.pY != null) {
            this.pY.b(interfaceC0009a);
        }
    }

    public void setProgress(float f) {
        this.pS.setProgress(f);
        this.pT.setProgress(f);
        this.pU.setProgress(f);
        this.pV.setProgress(f);
        this.pW.setProgress(f);
        if (this.pX != null) {
            this.pX.setProgress(f);
        }
        if (this.pY != null) {
            this.pY.setProgress(f);
        }
    }

    public a<?, Integer> dz() {
        return this.pW;
    }

    @Nullable
    public a<?, Float> dA() {
        return this.pX;
    }

    @Nullable
    public a<?, Float> dB() {
        return this.pY;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pT.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pV.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.pU.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pS.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.pT.getValue();
        PointF value2 = this.pS.getValue();
        com.airbnb.lottie.model.k value3 = this.pU.getValue();
        float floatValue = this.pV.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
