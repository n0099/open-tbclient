package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes4.dex */
public class o {
    private final a<PointF, PointF> EH;
    private final a<?, PointF> EI;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> EJ;
    private final a<Float, Float> EK;
    private final a<Integer, Integer> EL;
    @Nullable
    private final a<?, Float> EM;
    @Nullable
    private final a<?, Float> EN;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.EH = lVar.jd().jb();
        this.EI = lVar.je().jb();
        this.EJ = lVar.jf().jb();
        this.EK = lVar.jg().jb();
        this.EL = lVar.jh().jb();
        if (lVar.ji() != null) {
            this.EM = lVar.ji().jb();
        } else {
            this.EM = null;
        }
        if (lVar.jj() != null) {
            this.EN = lVar.jj().jb();
        } else {
            this.EN = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.EH);
        aVar.a(this.EI);
        aVar.a(this.EJ);
        aVar.a(this.EK);
        aVar.a(this.EL);
        if (this.EM != null) {
            aVar.a(this.EM);
        }
        if (this.EN != null) {
            aVar.a(this.EN);
        }
    }

    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.EH.b(interfaceC0007a);
        this.EI.b(interfaceC0007a);
        this.EJ.b(interfaceC0007a);
        this.EK.b(interfaceC0007a);
        this.EL.b(interfaceC0007a);
        if (this.EM != null) {
            this.EM.b(interfaceC0007a);
        }
        if (this.EN != null) {
            this.EN.b(interfaceC0007a);
        }
    }

    public void setProgress(float f) {
        this.EH.setProgress(f);
        this.EI.setProgress(f);
        this.EJ.setProgress(f);
        this.EK.setProgress(f);
        this.EL.setProgress(f);
        if (this.EM != null) {
            this.EM.setProgress(f);
        }
        if (this.EN != null) {
            this.EN.setProgress(f);
        }
    }

    public a<?, Integer> iP() {
        return this.EL;
    }

    @Nullable
    public a<?, Float> iQ() {
        return this.EM;
    }

    @Nullable
    public a<?, Float> iR() {
        return this.EN;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.EI.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.EK.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.EJ.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.EH.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.EI.getValue();
        PointF value2 = this.EH.getValue();
        com.airbnb.lottie.e.d value3 = this.EJ.getValue();
        float floatValue = this.EK.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.j.CD) {
            this.EH.a(cVar);
        } else if (t == com.airbnb.lottie.j.CE) {
            this.EI.a(cVar);
        } else if (t == com.airbnb.lottie.j.CH) {
            this.EJ.a(cVar);
        } else if (t == com.airbnb.lottie.j.CI) {
            this.EK.a(cVar);
        } else if (t == com.airbnb.lottie.j.CB) {
            this.EL.a(cVar);
        } else if (t == com.airbnb.lottie.j.CY && this.EM != null) {
            this.EM.a(cVar);
        } else if (t == com.airbnb.lottie.j.CZ && this.EN != null) {
            this.EN.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
