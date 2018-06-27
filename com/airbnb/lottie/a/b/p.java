package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final a<PointF, PointF> mK;
    private final a<?, PointF> mL;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> mM;
    private final a<Float, Float> mN;
    private final a<Integer, Integer> mO;
    @Nullable
    private final a<?, Float> mP;
    @Nullable
    private final a<?, Float> mQ;
    private final Matrix matrix = new Matrix();

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.mK = lVar.cv().ck();
        this.mL = lVar.cw().ck();
        this.mM = lVar.cx().ck();
        this.mN = lVar.cy().ck();
        this.mO = lVar.cz().ck();
        if (lVar.cA() != null) {
            this.mP = lVar.cA().ck();
        } else {
            this.mP = null;
        }
        if (lVar.cB() != null) {
            this.mQ = lVar.cB().ck();
        } else {
            this.mQ = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.mK);
        aVar.a(this.mL);
        aVar.a(this.mM);
        aVar.a(this.mN);
        aVar.a(this.mO);
        if (this.mP != null) {
            aVar.a(this.mP);
        }
        if (this.mQ != null) {
            aVar.a(this.mQ);
        }
    }

    public void a(a.InterfaceC0006a interfaceC0006a) {
        this.mK.b(interfaceC0006a);
        this.mL.b(interfaceC0006a);
        this.mM.b(interfaceC0006a);
        this.mN.b(interfaceC0006a);
        this.mO.b(interfaceC0006a);
        if (this.mP != null) {
            this.mP.b(interfaceC0006a);
        }
        if (this.mQ != null) {
            this.mQ.b(interfaceC0006a);
        }
    }

    public void setProgress(float f) {
        this.mK.setProgress(f);
        this.mL.setProgress(f);
        this.mM.setProgress(f);
        this.mN.setProgress(f);
        this.mO.setProgress(f);
        if (this.mP != null) {
            this.mP.setProgress(f);
        }
        if (this.mQ != null) {
            this.mQ.setProgress(f);
        }
    }

    public a<?, Integer> cc() {
        return this.mO;
    }

    @Nullable
    public a<?, Float> cd() {
        return this.mP;
    }

    @Nullable
    public a<?, Float> ce() {
        return this.mQ;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.mL.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.mN.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.mM.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.mK.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.mL.getValue();
        PointF value2 = this.mK.getValue();
        com.airbnb.lottie.model.k value3 = this.mM.getValue();
        float floatValue = this.mN.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
