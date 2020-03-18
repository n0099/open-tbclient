package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final a<PointF, PointF> gV;
    private final a<?, PointF> gW;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> gX;
    private final a<Float, Float> gY;
    private final a<Integer, Integer> gZ;
    @Nullable
    private final a<?, Float> hb;
    @Nullable
    private final a<?, Float> hc;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.gV = lVar.cp().cn();
        this.gW = lVar.cq().cn();
        this.gX = lVar.cr().cn();
        this.gY = lVar.cs().cn();
        this.gZ = lVar.ct().cn();
        if (lVar.cu() != null) {
            this.hb = lVar.cu().cn();
        } else {
            this.hb = null;
        }
        if (lVar.cv() != null) {
            this.hc = lVar.cv().cn();
        } else {
            this.hc = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.gV);
        aVar.a(this.gW);
        aVar.a(this.gX);
        aVar.a(this.gY);
        aVar.a(this.gZ);
        if (this.hb != null) {
            aVar.a(this.hb);
        }
        if (this.hc != null) {
            aVar.a(this.hc);
        }
    }

    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.gV.b(interfaceC0010a);
        this.gW.b(interfaceC0010a);
        this.gX.b(interfaceC0010a);
        this.gY.b(interfaceC0010a);
        this.gZ.b(interfaceC0010a);
        if (this.hb != null) {
            this.hb.b(interfaceC0010a);
        }
        if (this.hc != null) {
            this.hc.b(interfaceC0010a);
        }
    }

    public void setProgress(float f) {
        this.gV.setProgress(f);
        this.gW.setProgress(f);
        this.gX.setProgress(f);
        this.gY.setProgress(f);
        this.gZ.setProgress(f);
        if (this.hb != null) {
            this.hb.setProgress(f);
        }
        if (this.hc != null) {
            this.hc.setProgress(f);
        }
    }

    public a<?, Integer> cb() {
        return this.gZ;
    }

    @Nullable
    public a<?, Float> cc() {
        return this.hb;
    }

    @Nullable
    public a<?, Float> cd() {
        return this.hc;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.gW.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.gY.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.gX.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.gV.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.gW.getValue();
        PointF value2 = this.gV.getValue();
        com.airbnb.lottie.e.d value3 = this.gX.getValue();
        float floatValue = this.gY.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.eQ) {
            this.gV.a(cVar);
        } else if (t == com.airbnb.lottie.k.eR) {
            this.gW.a(cVar);
        } else if (t == com.airbnb.lottie.k.eU) {
            this.gX.a(cVar);
        } else if (t == com.airbnb.lottie.k.eV) {
            this.gY.a(cVar);
        } else if (t == com.airbnb.lottie.k.eO) {
            this.gZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.fj && this.hb != null) {
            this.hb.a(cVar);
        } else if (t == com.airbnb.lottie.k.fk && this.hc != null) {
            this.hc.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
