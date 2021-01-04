package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes3.dex */
public class o {
    private final a<PointF, PointF> EJ;
    private final a<?, PointF> EK;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> EL;
    private final a<Float, Float> EM;
    private final a<Integer, Integer> EN;
    @Nullable
    private final a<?, Float> EO;
    @Nullable
    private final a<?, Float> EP;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.EJ = lVar.je().jc();
        this.EK = lVar.jf().jc();
        this.EL = lVar.jg().jc();
        this.EM = lVar.jh().jc();
        this.EN = lVar.ji().jc();
        if (lVar.jj() != null) {
            this.EO = lVar.jj().jc();
        } else {
            this.EO = null;
        }
        if (lVar.jk() != null) {
            this.EP = lVar.jk().jc();
        } else {
            this.EP = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.EJ);
        aVar.a(this.EK);
        aVar.a(this.EL);
        aVar.a(this.EM);
        aVar.a(this.EN);
        if (this.EO != null) {
            aVar.a(this.EO);
        }
        if (this.EP != null) {
            aVar.a(this.EP);
        }
    }

    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.EJ.b(interfaceC0007a);
        this.EK.b(interfaceC0007a);
        this.EL.b(interfaceC0007a);
        this.EM.b(interfaceC0007a);
        this.EN.b(interfaceC0007a);
        if (this.EO != null) {
            this.EO.b(interfaceC0007a);
        }
        if (this.EP != null) {
            this.EP.b(interfaceC0007a);
        }
    }

    public void setProgress(float f) {
        this.EJ.setProgress(f);
        this.EK.setProgress(f);
        this.EL.setProgress(f);
        this.EM.setProgress(f);
        this.EN.setProgress(f);
        if (this.EO != null) {
            this.EO.setProgress(f);
        }
        if (this.EP != null) {
            this.EP.setProgress(f);
        }
    }

    public a<?, Integer> iQ() {
        return this.EN;
    }

    @Nullable
    public a<?, Float> iR() {
        return this.EO;
    }

    @Nullable
    public a<?, Float> iS() {
        return this.EP;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.EK.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.EM.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.EL.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.EJ.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.EK.getValue();
        PointF value2 = this.EJ.getValue();
        com.airbnb.lottie.e.d value3 = this.EL.getValue();
        float floatValue = this.EM.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.j.CF) {
            this.EJ.a(cVar);
        } else if (t == com.airbnb.lottie.j.CG) {
            this.EK.a(cVar);
        } else if (t == com.airbnb.lottie.j.CJ) {
            this.EL.a(cVar);
        } else if (t == com.airbnb.lottie.j.CK) {
            this.EM.a(cVar);
        } else if (t == com.airbnb.lottie.j.CD) {
            this.EN.a(cVar);
        } else if (t == com.airbnb.lottie.j.Da && this.EO != null) {
            this.EO.a(cVar);
        } else if (t == com.airbnb.lottie.j.Db && this.EP != null) {
            this.EP.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
