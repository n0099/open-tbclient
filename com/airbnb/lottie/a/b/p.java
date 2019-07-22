package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final Matrix matrix = new Matrix();
    private final a<PointF, PointF> nm;
    private final a<?, PointF> nn;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> np;
    private final a<Float, Float> nq;
    private final a<Integer, Integer> nr;
    @Nullable
    private final a<?, Float> ns;
    @Nullable
    private final a<?, Float> nt;

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.nm = lVar.cQ().cF();
        this.nn = lVar.cR().cF();
        this.np = lVar.cS().cF();
        this.nq = lVar.cT().cF();
        this.nr = lVar.cU().cF();
        if (lVar.cV() != null) {
            this.ns = lVar.cV().cF();
        } else {
            this.ns = null;
        }
        if (lVar.cW() != null) {
            this.nt = lVar.cW().cF();
        } else {
            this.nt = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.nm);
        aVar.a(this.nn);
        aVar.a(this.np);
        aVar.a(this.nq);
        aVar.a(this.nr);
        if (this.ns != null) {
            aVar.a(this.ns);
        }
        if (this.nt != null) {
            aVar.a(this.nt);
        }
    }

    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.nm.b(interfaceC0007a);
        this.nn.b(interfaceC0007a);
        this.np.b(interfaceC0007a);
        this.nq.b(interfaceC0007a);
        this.nr.b(interfaceC0007a);
        if (this.ns != null) {
            this.ns.b(interfaceC0007a);
        }
        if (this.nt != null) {
            this.nt.b(interfaceC0007a);
        }
    }

    public void setProgress(float f) {
        this.nm.setProgress(f);
        this.nn.setProgress(f);
        this.np.setProgress(f);
        this.nq.setProgress(f);
        this.nr.setProgress(f);
        if (this.ns != null) {
            this.ns.setProgress(f);
        }
        if (this.nt != null) {
            this.nt.setProgress(f);
        }
    }

    public a<?, Integer> cw() {
        return this.nr;
    }

    @Nullable
    public a<?, Float> cx() {
        return this.ns;
    }

    @Nullable
    public a<?, Float> cy() {
        return this.nt;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.nn.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.nq.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.np.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.nm.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.nn.getValue();
        PointF value2 = this.nm.getValue();
        com.airbnb.lottie.model.k value3 = this.np.getValue();
        float floatValue = this.nq.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
