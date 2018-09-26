package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> pa;
    private final a<?, PointF> pd;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> pe;
    private final a<Float, Float> pf;
    private final a<Integer, Integer> pg;
    @Nullable
    private final a<?, Float> ph;
    @Nullable
    private final a<?, Float> pi;

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.pa = lVar.dA().dp();
        this.pd = lVar.dB().dp();
        this.pe = lVar.dC().dp();
        this.pf = lVar.dD().dp();
        this.pg = lVar.dE().dp();
        if (lVar.dF() != null) {
            this.ph = lVar.dF().dp();
        } else {
            this.ph = null;
        }
        if (lVar.dG() != null) {
            this.pi = lVar.dG().dp();
        } else {
            this.pi = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.pa);
        aVar.a(this.pd);
        aVar.a(this.pe);
        aVar.a(this.pf);
        aVar.a(this.pg);
        if (this.ph != null) {
            aVar.a(this.ph);
        }
        if (this.pi != null) {
            aVar.a(this.pi);
        }
    }

    public void a(a.InterfaceC0006a interfaceC0006a) {
        this.pa.b(interfaceC0006a);
        this.pd.b(interfaceC0006a);
        this.pe.b(interfaceC0006a);
        this.pf.b(interfaceC0006a);
        this.pg.b(interfaceC0006a);
        if (this.ph != null) {
            this.ph.b(interfaceC0006a);
        }
        if (this.pi != null) {
            this.pi.b(interfaceC0006a);
        }
    }

    public void setProgress(float f) {
        this.pa.setProgress(f);
        this.pd.setProgress(f);
        this.pe.setProgress(f);
        this.pf.setProgress(f);
        this.pg.setProgress(f);
        if (this.ph != null) {
            this.ph.setProgress(f);
        }
        if (this.pi != null) {
            this.pi.setProgress(f);
        }
    }

    public a<?, Integer> dh() {
        return this.pg;
    }

    @Nullable
    public a<?, Float> di() {
        return this.ph;
    }

    @Nullable
    public a<?, Float> dj() {
        return this.pi;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.pd.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.pf.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.pe.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.pa.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.pd.getValue();
        PointF value2 = this.pa.getValue();
        com.airbnb.lottie.model.k value3 = this.pe.getValue();
        float floatValue = this.pf.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
