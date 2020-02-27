package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes6.dex */
public class o {
    private final a<PointF, PointF> gW;
    private final a<?, PointF> gX;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> gY;
    private final a<Float, Float> gZ;
    private final a<Integer, Integer> hb;
    @Nullable
    private final a<?, Float> hc;
    @Nullable
    private final a<?, Float> hd;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.gW = lVar.cp().cn();
        this.gX = lVar.cq().cn();
        this.gY = lVar.cr().cn();
        this.gZ = lVar.cs().cn();
        this.hb = lVar.ct().cn();
        if (lVar.cu() != null) {
            this.hc = lVar.cu().cn();
        } else {
            this.hc = null;
        }
        if (lVar.cv() != null) {
            this.hd = lVar.cv().cn();
        } else {
            this.hd = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.gW);
        aVar.a(this.gX);
        aVar.a(this.gY);
        aVar.a(this.gZ);
        aVar.a(this.hb);
        if (this.hc != null) {
            aVar.a(this.hc);
        }
        if (this.hd != null) {
            aVar.a(this.hd);
        }
    }

    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.gW.b(interfaceC0010a);
        this.gX.b(interfaceC0010a);
        this.gY.b(interfaceC0010a);
        this.gZ.b(interfaceC0010a);
        this.hb.b(interfaceC0010a);
        if (this.hc != null) {
            this.hc.b(interfaceC0010a);
        }
        if (this.hd != null) {
            this.hd.b(interfaceC0010a);
        }
    }

    public void setProgress(float f) {
        this.gW.setProgress(f);
        this.gX.setProgress(f);
        this.gY.setProgress(f);
        this.gZ.setProgress(f);
        this.hb.setProgress(f);
        if (this.hc != null) {
            this.hc.setProgress(f);
        }
        if (this.hd != null) {
            this.hd.setProgress(f);
        }
    }

    public a<?, Integer> cb() {
        return this.hb;
    }

    @Nullable
    public a<?, Float> cc() {
        return this.hc;
    }

    @Nullable
    public a<?, Float> cd() {
        return this.hd;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.gX.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.gZ.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.gY.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.gW.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix j(float f) {
        PointF value = this.gX.getValue();
        PointF value2 = this.gW.getValue();
        com.airbnb.lottie.e.d value3 = this.gY.getValue();
        float floatValue = this.gZ.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.eR) {
            this.gW.a(cVar);
        } else if (t == com.airbnb.lottie.k.eS) {
            this.gX.a(cVar);
        } else if (t == com.airbnb.lottie.k.eV) {
            this.gY.a(cVar);
        } else if (t == com.airbnb.lottie.k.eW) {
            this.gZ.a(cVar);
        } else if (t == com.airbnb.lottie.k.eP) {
            this.hb.a(cVar);
        } else if (t == com.airbnb.lottie.k.fk && this.hc != null) {
            this.hc.a(cVar);
        } else if (t == com.airbnb.lottie.k.fn && this.hd != null) {
            this.hd.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
