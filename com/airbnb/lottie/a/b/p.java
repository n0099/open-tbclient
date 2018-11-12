package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pT;
    private final a<?, PointF> pU;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> pV;
    private final a<Float, Float> pW;
    private final a<Integer, Integer> pX;
    @Nullable
    private final a<?, Float> pY;
    @Nullable
    private final a<?, Float> pZ;

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.pT = lVar.dR().dG();
        this.pU = lVar.dS().dG();
        this.pV = lVar.dT().dG();
        this.pW = lVar.dU().dG();
        this.pX = lVar.dV().dG();
        if (lVar.dW() != null) {
            this.pY = lVar.dW().dG();
        } else {
            this.pY = null;
        }
        if (lVar.dX() != null) {
            this.pZ = lVar.dX().dG();
        } else {
            this.pZ = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pT);
        aVar.a(this.pU);
        aVar.a(this.pV);
        aVar.a(this.pW);
        aVar.a(this.pX);
        if (this.pY != null) {
            aVar.a(this.pY);
        }
        if (this.pZ != null) {
            aVar.a(this.pZ);
        }
    }

    public void a(a.InterfaceC0009a interfaceC0009a) {
        this.pT.b(interfaceC0009a);
        this.pU.b(interfaceC0009a);
        this.pV.b(interfaceC0009a);
        this.pW.b(interfaceC0009a);
        this.pX.b(interfaceC0009a);
        if (this.pY != null) {
            this.pY.b(interfaceC0009a);
        }
        if (this.pZ != null) {
            this.pZ.b(interfaceC0009a);
        }
    }

    public void setProgress(float f) {
        this.pT.setProgress(f);
        this.pU.setProgress(f);
        this.pV.setProgress(f);
        this.pW.setProgress(f);
        this.pX.setProgress(f);
        if (this.pY != null) {
            this.pY.setProgress(f);
        }
        if (this.pZ != null) {
            this.pZ.setProgress(f);
        }
    }

    public a<?, Integer> dy() {
        return this.pX;
    }

    @Nullable
    public a<?, Float> dz() {
        return this.pY;
    }

    @Nullable
    public a<?, Float> dA() {
        return this.pZ;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pU.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pW.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.pV.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pT.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.pU.getValue();
        PointF value2 = this.pT.getValue();
        com.airbnb.lottie.model.k value3 = this.pV.getValue();
        float floatValue = this.pW.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
