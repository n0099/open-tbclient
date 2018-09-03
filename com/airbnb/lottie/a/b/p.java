package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final a<PointF, PointF> mA;
    private final a<?, PointF> mD;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> mE;
    private final a<Float, Float> mF;
    private final a<Integer, Integer> mG;
    @Nullable
    private final a<?, Float> mH;
    @Nullable
    private final a<?, Float> mI;
    private final Matrix matrix = new Matrix();

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.mA = lVar.ct().ci();
        this.mD = lVar.cu().ci();
        this.mE = lVar.cv().ci();
        this.mF = lVar.cw().ci();
        this.mG = lVar.cx().ci();
        if (lVar.cy() != null) {
            this.mH = lVar.cy().ci();
        } else {
            this.mH = null;
        }
        if (lVar.cz() != null) {
            this.mI = lVar.cz().ci();
        } else {
            this.mI = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.mA);
        aVar.a(this.mD);
        aVar.a(this.mE);
        aVar.a(this.mF);
        aVar.a(this.mG);
        if (this.mH != null) {
            aVar.a(this.mH);
        }
        if (this.mI != null) {
            aVar.a(this.mI);
        }
    }

    public void a(a.InterfaceC0006a interfaceC0006a) {
        this.mA.b(interfaceC0006a);
        this.mD.b(interfaceC0006a);
        this.mE.b(interfaceC0006a);
        this.mF.b(interfaceC0006a);
        this.mG.b(interfaceC0006a);
        if (this.mH != null) {
            this.mH.b(interfaceC0006a);
        }
        if (this.mI != null) {
            this.mI.b(interfaceC0006a);
        }
    }

    public void setProgress(float f) {
        this.mA.setProgress(f);
        this.mD.setProgress(f);
        this.mE.setProgress(f);
        this.mF.setProgress(f);
        this.mG.setProgress(f);
        if (this.mH != null) {
            this.mH.setProgress(f);
        }
        if (this.mI != null) {
            this.mI.setProgress(f);
        }
    }

    public a<?, Integer> ca() {
        return this.mG;
    }

    @Nullable
    public a<?, Float> cb() {
        return this.mH;
    }

    @Nullable
    public a<?, Float> cc() {
        return this.mI;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.mD.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.mF.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.mE.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.mA.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.mD.getValue();
        PointF value2 = this.mA.getValue();
        com.airbnb.lottie.model.k value3 = this.mE.getValue();
        float floatValue = this.mF.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
