package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes7.dex */
public class o {
    private final a<PointF, PointF> EV;
    private final a<?, PointF> EW;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> EX;
    private final a<Float, Float> EY;
    private final a<Integer, Integer> EZ;
    @Nullable
    private final a<?, Float> Fa;
    @Nullable
    private final a<?, Float> Fb;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.EV = lVar.jF().jD();
        this.EW = lVar.jG().jD();
        this.EX = lVar.jH().jD();
        this.EY = lVar.jI().jD();
        this.EZ = lVar.jJ().jD();
        if (lVar.jK() != null) {
            this.Fa = lVar.jK().jD();
        } else {
            this.Fa = null;
        }
        if (lVar.jL() != null) {
            this.Fb = lVar.jL().jD();
        } else {
            this.Fb = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.EV);
        aVar.a(this.EW);
        aVar.a(this.EX);
        aVar.a(this.EY);
        aVar.a(this.EZ);
        if (this.Fa != null) {
            aVar.a(this.Fa);
        }
        if (this.Fb != null) {
            aVar.a(this.Fb);
        }
    }

    public void a(a.InterfaceC0011a interfaceC0011a) {
        this.EV.b(interfaceC0011a);
        this.EW.b(interfaceC0011a);
        this.EX.b(interfaceC0011a);
        this.EY.b(interfaceC0011a);
        this.EZ.b(interfaceC0011a);
        if (this.Fa != null) {
            this.Fa.b(interfaceC0011a);
        }
        if (this.Fb != null) {
            this.Fb.b(interfaceC0011a);
        }
    }

    public void setProgress(float f) {
        this.EV.setProgress(f);
        this.EW.setProgress(f);
        this.EX.setProgress(f);
        this.EY.setProgress(f);
        this.EZ.setProgress(f);
        if (this.Fa != null) {
            this.Fa.setProgress(f);
        }
        if (this.Fb != null) {
            this.Fb.setProgress(f);
        }
    }

    public a<?, Integer> jr() {
        return this.EZ;
    }

    @Nullable
    public a<?, Float> js() {
        return this.Fa;
    }

    @Nullable
    public a<?, Float> jt() {
        return this.Fb;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.EW.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.EY.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.EX.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.EV.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.EW.getValue();
        PointF value2 = this.EV.getValue();
        com.airbnb.lottie.e.d value3 = this.EX.getValue();
        float floatValue = this.EY.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.CV) {
            this.EV.a(cVar);
        } else if (t == com.airbnb.lottie.k.CW) {
            this.EW.a(cVar);
        } else if (t == com.airbnb.lottie.k.CZ) {
            this.EX.a(cVar);
        } else if (t == com.airbnb.lottie.k.Da) {
            this.EY.a(cVar);
        } else if (t == com.airbnb.lottie.k.CP) {
            this.EZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.Dl && this.Fa != null) {
            this.Fa.a(cVar);
        } else if (t == com.airbnb.lottie.k.Dm && this.Fb != null) {
            this.Fb.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
