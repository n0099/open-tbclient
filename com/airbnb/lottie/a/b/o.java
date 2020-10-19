package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes10.dex */
public class o {
    private final a<PointF, PointF> Ee;
    private final a<?, PointF> Ef;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> Eg;
    private final a<Float, Float> Eh;
    private final a<Integer, Integer> Ei;
    @Nullable
    private final a<?, Float> Ej;
    @Nullable
    private final a<?, Float> Ek;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.Ee = lVar.jF().jD();
        this.Ef = lVar.jG().jD();
        this.Eg = lVar.jH().jD();
        this.Eh = lVar.jI().jD();
        this.Ei = lVar.jJ().jD();
        if (lVar.jK() != null) {
            this.Ej = lVar.jK().jD();
        } else {
            this.Ej = null;
        }
        if (lVar.jL() != null) {
            this.Ek = lVar.jL().jD();
        } else {
            this.Ek = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.Ee);
        aVar.a(this.Ef);
        aVar.a(this.Eg);
        aVar.a(this.Eh);
        aVar.a(this.Ei);
        if (this.Ej != null) {
            aVar.a(this.Ej);
        }
        if (this.Ek != null) {
            aVar.a(this.Ek);
        }
    }

    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.Ee.b(interfaceC0011a);
        this.Ef.b(interfaceC0011a);
        this.Eg.b(interfaceC0011a);
        this.Eh.b(interfaceC0011a);
        this.Ei.b(interfaceC0011a);
        if (this.Ej != null) {
            this.Ej.b(interfaceC0011a);
        }
        if (this.Ek != null) {
            this.Ek.b(interfaceC0011a);
        }
    }

    public void setProgress(float f) {
        this.Ee.setProgress(f);
        this.Ef.setProgress(f);
        this.Eg.setProgress(f);
        this.Eh.setProgress(f);
        this.Ei.setProgress(f);
        if (this.Ej != null) {
            this.Ej.setProgress(f);
        }
        if (this.Ek != null) {
            this.Ek.setProgress(f);
        }
    }

    public a<?, Integer> jr() {
        return this.Ei;
    }

    @Nullable
    public a<?, Float> js() {
        return this.Ej;
    }

    @Nullable
    public a<?, Float> jt() {
        return this.Ek;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.Ef.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.Eh.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.Eg.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.Ee.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.Ef.getValue();
        PointF value2 = this.Ee.getValue();
        com.airbnb.lottie.e.d value3 = this.Eg.getValue();
        float floatValue = this.Eh.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.BZ) {
            this.Ee.a(cVar);
        } else if (t == com.airbnb.lottie.k.Ca) {
            this.Ef.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cd) {
            this.Eg.a(cVar);
        } else if (t == com.airbnb.lottie.k.Ce) {
            this.Eh.a(cVar);
        } else if (t == com.airbnb.lottie.k.BX) {
            this.Ei.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cp && this.Ej != null) {
            this.Ej.a(cVar);
        } else if (t == com.airbnb.lottie.k.Cq && this.Ek != null) {
            this.Ek.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
