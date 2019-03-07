package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pO;
    private final a<?, PointF> pP;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> pQ;
    private final a<Float, Float> pR;
    private final a<Integer, Integer> pS;
    @Nullable
    private final a<?, Float> pT;
    @Nullable
    private final a<?, Float> pU;

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.pO = lVar.dQ().dF();
        this.pP = lVar.dR().dF();
        this.pQ = lVar.dS().dF();
        this.pR = lVar.dT().dF();
        this.pS = lVar.dU().dF();
        if (lVar.dV() != null) {
            this.pT = lVar.dV().dF();
        } else {
            this.pT = null;
        }
        if (lVar.dW() != null) {
            this.pU = lVar.dW().dF();
        } else {
            this.pU = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pO);
        aVar.a(this.pP);
        aVar.a(this.pQ);
        aVar.a(this.pR);
        aVar.a(this.pS);
        if (this.pT != null) {
            aVar.a(this.pT);
        }
        if (this.pU != null) {
            aVar.a(this.pU);
        }
    }

    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.pO.b(interfaceC0007a);
        this.pP.b(interfaceC0007a);
        this.pQ.b(interfaceC0007a);
        this.pR.b(interfaceC0007a);
        this.pS.b(interfaceC0007a);
        if (this.pT != null) {
            this.pT.b(interfaceC0007a);
        }
        if (this.pU != null) {
            this.pU.b(interfaceC0007a);
        }
    }

    public void setProgress(float f) {
        this.pO.setProgress(f);
        this.pP.setProgress(f);
        this.pQ.setProgress(f);
        this.pR.setProgress(f);
        this.pS.setProgress(f);
        if (this.pT != null) {
            this.pT.setProgress(f);
        }
        if (this.pU != null) {
            this.pU.setProgress(f);
        }
    }

    public a<?, Integer> dx() {
        return this.pS;
    }

    @Nullable
    public a<?, Float> dy() {
        return this.pT;
    }

    @Nullable
    public a<?, Float> dz() {
        return this.pU;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pP.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pR.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.pQ.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pO.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.pP.getValue();
        PointF value2 = this.pO.getValue();
        com.airbnb.lottie.model.k value3 = this.pQ.getValue();
        float floatValue = this.pR.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
