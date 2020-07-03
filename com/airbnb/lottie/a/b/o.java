package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final a<PointF, PointF> Dd;
    private final a<?, PointF> De;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> Df;
    private final a<Float, Float> Dg;
    private final a<Integer, Integer> Dh;
    @Nullable
    private final a<?, Float> Di;
    @Nullable
    private final a<?, Float> Dj;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.Dd = lVar.ic().ia();
        this.De = lVar.ie().ia();
        this.Df = lVar.m7if().ia();
        this.Dg = lVar.ig().ia();
        this.Dh = lVar.ih().ia();
        if (lVar.ii() != null) {
            this.Di = lVar.ii().ia();
        } else {
            this.Di = null;
        }
        if (lVar.ij() != null) {
            this.Dj = lVar.ij().ia();
        } else {
            this.Dj = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.Dd);
        aVar.a(this.De);
        aVar.a(this.Df);
        aVar.a(this.Dg);
        aVar.a(this.Dh);
        if (this.Di != null) {
            aVar.a(this.Di);
        }
        if (this.Dj != null) {
            aVar.a(this.Dj);
        }
    }

    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.Dd.b(interfaceC0010a);
        this.De.b(interfaceC0010a);
        this.Df.b(interfaceC0010a);
        this.Dg.b(interfaceC0010a);
        this.Dh.b(interfaceC0010a);
        if (this.Di != null) {
            this.Di.b(interfaceC0010a);
        }
        if (this.Dj != null) {
            this.Dj.b(interfaceC0010a);
        }
    }

    public void setProgress(float f) {
        this.Dd.setProgress(f);
        this.De.setProgress(f);
        this.Df.setProgress(f);
        this.Dg.setProgress(f);
        this.Dh.setProgress(f);
        if (this.Di != null) {
            this.Di.setProgress(f);
        }
        if (this.Dj != null) {
            this.Dj.setProgress(f);
        }
    }

    public a<?, Integer> hO() {
        return this.Dh;
    }

    @Nullable
    public a<?, Float> hP() {
        return this.Di;
    }

    @Nullable
    public a<?, Float> hQ() {
        return this.Dj;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.De.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.Dg.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.Df.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.Dd.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.De.getValue();
        PointF value2 = this.Dd.getValue();
        com.airbnb.lottie.e.d value3 = this.Df.getValue();
        float floatValue = this.Dg.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.Bc) {
            this.Dd.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bd) {
            this.De.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bg) {
            this.Df.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bh) {
            this.Dg.a(cVar);
        } else if (t == com.airbnb.lottie.k.Ba) {
            this.Dh.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bs && this.Di != null) {
            this.Di.a(cVar);
        } else if (t == com.airbnb.lottie.k.Bt && this.Dj != null) {
            this.Dj.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
