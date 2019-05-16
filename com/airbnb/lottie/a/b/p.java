package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nn;
    private final a<?, PointF> np;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> nq;
    private final a<Float, Float> nr;
    private final a<Integer, Integer> ns;
    @Nullable
    private final a<?, Float> nt;
    @Nullable
    private final a<?, Float> nu;

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.nn = lVar.cK().cz();
        this.np = lVar.cL().cz();
        this.nq = lVar.cM().cz();
        this.nr = lVar.cN().cz();
        this.ns = lVar.cO().cz();
        if (lVar.cP() != null) {
            this.nt = lVar.cP().cz();
        } else {
            this.nt = null;
        }
        if (lVar.cQ() != null) {
            this.nu = lVar.cQ().cz();
        } else {
            this.nu = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nn);
        aVar.a(this.np);
        aVar.a(this.nq);
        aVar.a(this.nr);
        aVar.a(this.ns);
        if (this.nt != null) {
            aVar.a(this.nt);
        }
        if (this.nu != null) {
            aVar.a(this.nu);
        }
    }

    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.nn.b(interfaceC0007a);
        this.np.b(interfaceC0007a);
        this.nq.b(interfaceC0007a);
        this.nr.b(interfaceC0007a);
        this.ns.b(interfaceC0007a);
        if (this.nt != null) {
            this.nt.b(interfaceC0007a);
        }
        if (this.nu != null) {
            this.nu.b(interfaceC0007a);
        }
    }

    public void setProgress(float f) {
        this.nn.setProgress(f);
        this.np.setProgress(f);
        this.nq.setProgress(f);
        this.nr.setProgress(f);
        this.ns.setProgress(f);
        if (this.nt != null) {
            this.nt.setProgress(f);
        }
        if (this.nu != null) {
            this.nu.setProgress(f);
        }
    }

    public a<?, Integer> cr() {
        return this.ns;
    }

    @Nullable
    public a<?, Float> cs() {
        return this.nt;
    }

    @Nullable
    public a<?, Float> ct() {
        return this.nu;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.np.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nr.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.nq.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nn.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.np.getValue();
        PointF value2 = this.nn.getValue();
        com.airbnb.lottie.model.k value3 = this.nq.getValue();
        float floatValue = this.nr.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
