package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final a<PointF, PointF> mL;
    private final a<?, PointF> mM;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> mN;
    private final a<Float, Float> mO;
    private final a<Integer, Integer> mP;
    @Nullable
    private final a<?, Float> mQ;
    @Nullable
    private final a<?, Float> mS;
    private final Matrix matrix = new Matrix();

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.mL = lVar.cv().ck();
        this.mM = lVar.cw().ck();
        this.mN = lVar.cx().ck();
        this.mO = lVar.cy().ck();
        this.mP = lVar.cz().ck();
        if (lVar.cA() != null) {
            this.mQ = lVar.cA().ck();
        } else {
            this.mQ = null;
        }
        if (lVar.cB() != null) {
            this.mS = lVar.cB().ck();
        } else {
            this.mS = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.mL);
        aVar.a(this.mM);
        aVar.a(this.mN);
        aVar.a(this.mO);
        aVar.a(this.mP);
        if (this.mQ != null) {
            aVar.a(this.mQ);
        }
        if (this.mS != null) {
            aVar.a(this.mS);
        }
    }

    public void a(a.InterfaceC0006a interfaceC0006a) {
        this.mL.b(interfaceC0006a);
        this.mM.b(interfaceC0006a);
        this.mN.b(interfaceC0006a);
        this.mO.b(interfaceC0006a);
        this.mP.b(interfaceC0006a);
        if (this.mQ != null) {
            this.mQ.b(interfaceC0006a);
        }
        if (this.mS != null) {
            this.mS.b(interfaceC0006a);
        }
    }

    public void setProgress(float f) {
        this.mL.setProgress(f);
        this.mM.setProgress(f);
        this.mN.setProgress(f);
        this.mO.setProgress(f);
        this.mP.setProgress(f);
        if (this.mQ != null) {
            this.mQ.setProgress(f);
        }
        if (this.mS != null) {
            this.mS.setProgress(f);
        }
    }

    public a<?, Integer> cc() {
        return this.mP;
    }

    @Nullable
    public a<?, Float> cd() {
        return this.mQ;
    }

    @Nullable
    public a<?, Float> ce() {
        return this.mS;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.mM.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.mO.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.mN.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.mL.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.mM.getValue();
        PointF value2 = this.mL.getValue();
        com.airbnb.lottie.model.k value3 = this.mN.getValue();
        float floatValue = this.mO.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
