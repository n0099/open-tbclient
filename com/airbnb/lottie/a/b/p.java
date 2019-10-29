package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final a<PointF, PointF> fJ;
    private final a<?, PointF> fK;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> fL;
    private final a<Float, Float> fM;
    private final a<Integer, Integer> fN;
    @Nullable
    private final a<?, Float> fO;
    @Nullable
    private final a<?, Float> fP;
    private final Matrix matrix = new Matrix();

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.fJ = lVar.cj().bY();
        this.fK = lVar.ck().bY();
        this.fL = lVar.cl().bY();
        this.fM = lVar.cm().bY();
        this.fN = lVar.cn().bY();
        if (lVar.co() != null) {
            this.fO = lVar.co().bY();
        } else {
            this.fO = null;
        }
        if (lVar.cp() != null) {
            this.fP = lVar.cp().bY();
        } else {
            this.fP = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.fJ);
        aVar.a(this.fK);
        aVar.a(this.fL);
        aVar.a(this.fM);
        aVar.a(this.fN);
        if (this.fO != null) {
            aVar.a(this.fO);
        }
        if (this.fP != null) {
            aVar.a(this.fP);
        }
    }

    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.fJ.b(interfaceC0007a);
        this.fK.b(interfaceC0007a);
        this.fL.b(interfaceC0007a);
        this.fM.b(interfaceC0007a);
        this.fN.b(interfaceC0007a);
        if (this.fO != null) {
            this.fO.b(interfaceC0007a);
        }
        if (this.fP != null) {
            this.fP.b(interfaceC0007a);
        }
    }

    public void setProgress(float f) {
        this.fJ.setProgress(f);
        this.fK.setProgress(f);
        this.fL.setProgress(f);
        this.fM.setProgress(f);
        this.fN.setProgress(f);
        if (this.fO != null) {
            this.fO.setProgress(f);
        }
        if (this.fP != null) {
            this.fP.setProgress(f);
        }
    }

    public a<?, Integer> bP() {
        return this.fN;
    }

    @Nullable
    public a<?, Float> bQ() {
        return this.fO;
    }

    @Nullable
    public a<?, Float> bR() {
        return this.fP;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.fK.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.fM.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.fL.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.fJ.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.fK.getValue();
        PointF value2 = this.fJ.getValue();
        com.airbnb.lottie.model.k value3 = this.fL.getValue();
        float floatValue = this.fM.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
