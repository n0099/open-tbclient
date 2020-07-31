package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes20.dex */
public class o {
    private final a<PointF, PointF> Df;
    private final a<?, PointF> Dg;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> Dh;
    private final a<Float, Float> Di;
    private final a<Integer, Integer> Dj;
    @Nullable
    private final a<?, Float> Dk;
    @Nullable
    private final a<?, Float> Dl;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.Df = lVar.ic().ia();
        this.Dg = lVar.ie().ia();
        this.Dh = lVar.m7if().ia();
        this.Di = lVar.ig().ia();
        this.Dj = lVar.ih().ia();
        if (lVar.ii() != null) {
            this.Dk = lVar.ii().ia();
        } else {
            this.Dk = null;
        }
        if (lVar.ij() != null) {
            this.Dl = lVar.ij().ia();
        } else {
            this.Dl = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.Df);
        aVar.a(this.Dg);
        aVar.a(this.Dh);
        aVar.a(this.Di);
        aVar.a(this.Dj);
        if (this.Dk != null) {
            aVar.a(this.Dk);
        }
        if (this.Dl != null) {
            aVar.a(this.Dl);
        }
    }

    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.Df.b(interfaceC0010a);
        this.Dg.b(interfaceC0010a);
        this.Dh.b(interfaceC0010a);
        this.Di.b(interfaceC0010a);
        this.Dj.b(interfaceC0010a);
        if (this.Dk != null) {
            this.Dk.b(interfaceC0010a);
        }
        if (this.Dl != null) {
            this.Dl.b(interfaceC0010a);
        }
    }

    public void setProgress(float f) {
        this.Df.setProgress(f);
        this.Dg.setProgress(f);
        this.Dh.setProgress(f);
        this.Di.setProgress(f);
        this.Dj.setProgress(f);
        if (this.Dk != null) {
            this.Dk.setProgress(f);
        }
        if (this.Dl != null) {
            this.Dl.setProgress(f);
        }
    }

    public a<?, Integer> hO() {
        return this.Dj;
    }

    @Nullable
    public a<?, Float> hP() {
        return this.Dk;
    }

    @Nullable
    public a<?, Float> hQ() {
        return this.Dl;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.Dg.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.Di.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.Dh.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.Df.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.Dg.getValue();
        PointF value2 = this.Df.getValue();
        com.airbnb.lottie.e.d value3 = this.Dh.getValue();
        float floatValue = this.Di.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.Be) {
            this.Df.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bf) {
            this.Dg.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bi) {
            this.Dh.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bj) {
            this.Di.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bc) {
            this.Dj.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bu && this.Dk != null) {
            this.Dk.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bv && this.Dl != null) {
            this.Dl.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
