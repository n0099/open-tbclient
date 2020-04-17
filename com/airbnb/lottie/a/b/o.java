package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final a<Float, Float> CB;
    private final a<Integer, Integer> CC;
    @Nullable
    private final a<?, Float> CD;
    @Nullable
    private final a<?, Float> CE;
    private final a<PointF, PointF> Cx;
    private final a<?, PointF> Cy;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> Cz;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.Cx = lVar.hM().hK();
        this.Cy = lVar.hN().hK();
        this.Cz = lVar.hO().hK();
        this.CB = lVar.hP().hK();
        this.CC = lVar.hQ().hK();
        if (lVar.hR() != null) {
            this.CD = lVar.hR().hK();
        } else {
            this.CD = null;
        }
        if (lVar.hS() != null) {
            this.CE = lVar.hS().hK();
        } else {
            this.CE = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.Cx);
        aVar.a(this.Cy);
        aVar.a(this.Cz);
        aVar.a(this.CB);
        aVar.a(this.CC);
        if (this.CD != null) {
            aVar.a(this.CD);
        }
        if (this.CE != null) {
            aVar.a(this.CE);
        }
    }

    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.Cx.b(interfaceC0010a);
        this.Cy.b(interfaceC0010a);
        this.Cz.b(interfaceC0010a);
        this.CB.b(interfaceC0010a);
        this.CC.b(interfaceC0010a);
        if (this.CD != null) {
            this.CD.b(interfaceC0010a);
        }
        if (this.CE != null) {
            this.CE.b(interfaceC0010a);
        }
    }

    public void setProgress(float f) {
        this.Cx.setProgress(f);
        this.Cy.setProgress(f);
        this.Cz.setProgress(f);
        this.CB.setProgress(f);
        this.CC.setProgress(f);
        if (this.CD != null) {
            this.CD.setProgress(f);
        }
        if (this.CE != null) {
            this.CE.setProgress(f);
        }
    }

    public a<?, Integer> hy() {
        return this.CC;
    }

    @Nullable
    public a<?, Float> hz() {
        return this.CD;
    }

    @Nullable
    public a<?, Float> hA() {
        return this.CE;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.Cy.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.CB.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.Cz.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.Cx.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix g(float f) {
        PointF value = this.Cy.getValue();
        PointF value2 = this.Cx.getValue();
        com.airbnb.lottie.e.d value3 = this.Cz.getValue();
        float floatValue = this.CB.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.Az) {
            this.Cx.a(cVar);
        } else if (t == com.airbnb.lottie.k.AA) {
            this.Cy.a(cVar);
        } else if (t == com.airbnb.lottie.k.AD) {
            this.Cz.a(cVar);
        } else if (t == com.airbnb.lottie.k.AE) {
            this.CB.a(cVar);
        } else if (t == com.airbnb.lottie.k.Ax) {
            this.CC.a(cVar);
        } else if (t == com.airbnb.lottie.k.AQ && this.CD != null) {
            this.CD.a(cVar);
        } else if (t == com.airbnb.lottie.k.AR && this.CE != null) {
            this.CE.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
