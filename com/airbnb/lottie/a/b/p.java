package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final a<?, PointF> mA;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> mD;
    private final a<Float, Float> mE;
    private final a<Integer, Integer> mF;
    @Nullable
    private final a<?, Float> mG;
    @Nullable
    private final a<?, Float> mH;
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> mz;

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.mz = lVar.ct().ci();
        this.mA = lVar.cu().ci();
        this.mD = lVar.cv().ci();
        this.mE = lVar.cw().ci();
        this.mF = lVar.cx().ci();
        if (lVar.cy() != null) {
            this.mG = lVar.cy().ci();
        } else {
            this.mG = null;
        }
        if (lVar.cz() != null) {
            this.mH = lVar.cz().ci();
        } else {
            this.mH = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.mz);
        aVar.a(this.mA);
        aVar.a(this.mD);
        aVar.a(this.mE);
        aVar.a(this.mF);
        if (this.mG != null) {
            aVar.a(this.mG);
        }
        if (this.mH != null) {
            aVar.a(this.mH);
        }
    }

    public void a(a.InterfaceC0006a interfaceC0006a) {
        this.mz.b(interfaceC0006a);
        this.mA.b(interfaceC0006a);
        this.mD.b(interfaceC0006a);
        this.mE.b(interfaceC0006a);
        this.mF.b(interfaceC0006a);
        if (this.mG != null) {
            this.mG.b(interfaceC0006a);
        }
        if (this.mH != null) {
            this.mH.b(interfaceC0006a);
        }
    }

    public void setProgress(float f) {
        this.mz.setProgress(f);
        this.mA.setProgress(f);
        this.mD.setProgress(f);
        this.mE.setProgress(f);
        this.mF.setProgress(f);
        if (this.mG != null) {
            this.mG.setProgress(f);
        }
        if (this.mH != null) {
            this.mH.setProgress(f);
        }
    }

    public a<?, Integer> ca() {
        return this.mF;
    }

    @Nullable
    public a<?, Float> cb() {
        return this.mG;
    }

    @Nullable
    public a<?, Float> cc() {
        return this.mH;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.mA.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.mE.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.mD.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.mz.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.mA.getValue();
        PointF value2 = this.mz.getValue();
        com.airbnb.lottie.model.k value3 = this.mD.getValue();
        float floatValue = this.mE.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
