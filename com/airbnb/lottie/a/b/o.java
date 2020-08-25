package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes18.dex */
public class o {
    private final a<PointF, PointF> DM;
    private final a<?, PointF> DN;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> DO;
    private final a<Float, Float> DQ;
    private final a<Integer, Integer> DR;
    @Nullable
    private final a<?, Float> DS;
    @Nullable
    private final a<?, Float> DT;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.DM = lVar.jD().jB();
        this.DN = lVar.jE().jB();
        this.DO = lVar.jF().jB();
        this.DQ = lVar.jG().jB();
        this.DR = lVar.jH().jB();
        if (lVar.jI() != null) {
            this.DS = lVar.jI().jB();
        } else {
            this.DS = null;
        }
        if (lVar.jJ() != null) {
            this.DT = lVar.jJ().jB();
        } else {
            this.DT = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.DM);
        aVar.a(this.DN);
        aVar.a(this.DO);
        aVar.a(this.DQ);
        aVar.a(this.DR);
        if (this.DS != null) {
            aVar.a(this.DS);
        }
        if (this.DT != null) {
            aVar.a(this.DT);
        }
    }

    public void a(a.InterfaceC0010a interfaceC0010a) {
        this.DM.b(interfaceC0010a);
        this.DN.b(interfaceC0010a);
        this.DO.b(interfaceC0010a);
        this.DQ.b(interfaceC0010a);
        this.DR.b(interfaceC0010a);
        if (this.DS != null) {
            this.DS.b(interfaceC0010a);
        }
        if (this.DT != null) {
            this.DT.b(interfaceC0010a);
        }
    }

    public void setProgress(float f) {
        this.DM.setProgress(f);
        this.DN.setProgress(f);
        this.DO.setProgress(f);
        this.DQ.setProgress(f);
        this.DR.setProgress(f);
        if (this.DS != null) {
            this.DS.setProgress(f);
        }
        if (this.DT != null) {
            this.DT.setProgress(f);
        }
    }

    public a<?, Integer> jp() {
        return this.DR;
    }

    @Nullable
    public a<?, Float> jq() {
        return this.DS;
    }

    @Nullable
    public a<?, Float> jr() {
        return this.DT;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.DN.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.DQ.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.DO.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.DM.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix i(float f) {
        PointF value = this.DN.getValue();
        PointF value2 = this.DM.getValue();
        com.airbnb.lottie.e.d value3 = this.DO.getValue();
        float floatValue = this.DQ.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.k.BI) {
            this.DM.a(cVar);
        } else if (t == com.airbnb.lottie.k.BJ) {
            this.DN.a(cVar);
        } else if (t == com.airbnb.lottie.k.BM) {
            this.DO.a(cVar);
        } else if (t == com.airbnb.lottie.k.BN) {
            this.DQ.a(cVar);
        } else if (t == com.airbnb.lottie.k.BG) {
            this.DR.a(cVar);
        } else if (t == com.airbnb.lottie.k.BY && this.DS != null) {
            this.DS.a(cVar);
        } else if (t == com.airbnb.lottie.k.BZ && this.DT != null) {
            this.DT.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
