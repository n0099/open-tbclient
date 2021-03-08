package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes5.dex */
public class o {
    private final a<PointF, PointF> Gb;
    private final a<?, PointF> Gc;
    private final a<com.airbnb.lottie.e.d, com.airbnb.lottie.e.d> Gd;
    private final a<Float, Float> Ge;
    private final a<Integer, Integer> Gf;
    @Nullable
    private final a<?, Float> Gg;
    @Nullable
    private final a<?, Float> Gh;
    private final Matrix matrix = new Matrix();

    public o(com.airbnb.lottie.model.a.l lVar) {
        this.Gb = lVar.jd().jb();
        this.Gc = lVar.je().jb();
        this.Gd = lVar.jf().jb();
        this.Ge = lVar.jg().jb();
        this.Gf = lVar.jh().jb();
        if (lVar.ji() != null) {
            this.Gg = lVar.ji().jb();
        } else {
            this.Gg = null;
        }
        if (lVar.jj() != null) {
            this.Gh = lVar.jj().jb();
        } else {
            this.Gh = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.Gb);
        aVar.a(this.Gc);
        aVar.a(this.Gd);
        aVar.a(this.Ge);
        aVar.a(this.Gf);
        if (this.Gg != null) {
            aVar.a(this.Gg);
        }
        if (this.Gh != null) {
            aVar.a(this.Gh);
        }
    }

    public void a(a.InterfaceC0013a interfaceC0013a) {
        this.Gb.b(interfaceC0013a);
        this.Gc.b(interfaceC0013a);
        this.Gd.b(interfaceC0013a);
        this.Ge.b(interfaceC0013a);
        this.Gf.b(interfaceC0013a);
        if (this.Gg != null) {
            this.Gg.b(interfaceC0013a);
        }
        if (this.Gh != null) {
            this.Gh.b(interfaceC0013a);
        }
    }

    public void setProgress(float f) {
        this.Gb.setProgress(f);
        this.Gc.setProgress(f);
        this.Gd.setProgress(f);
        this.Ge.setProgress(f);
        this.Gf.setProgress(f);
        if (this.Gg != null) {
            this.Gg.setProgress(f);
        }
        if (this.Gh != null) {
            this.Gh.setProgress(f);
        }
    }

    public a<?, Integer> iP() {
        return this.Gf;
    }

    @Nullable
    public a<?, Float> iQ() {
        return this.Gg;
    }

    @Nullable
    public a<?, Float> iR() {
        return this.Gh;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.Gc.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.Ge.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.e.d value2 = this.Gd.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.Gb.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix l(float f) {
        PointF value = this.Gc.getValue();
        PointF value2 = this.Gb.getValue();
        com.airbnb.lottie.e.d value3 = this.Gd.getValue();
        float floatValue = this.Ge.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.airbnb.lottie.e.c<T> cVar) {
        if (t == com.airbnb.lottie.j.Ee) {
            this.Gb.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ef) {
            this.Gc.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ei) {
            this.Gd.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ej) {
            this.Ge.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ec) {
            this.Gf.a(cVar);
        } else if (t == com.airbnb.lottie.j.Eu && this.Gg != null) {
            this.Gg.a(cVar);
        } else if (t == com.airbnb.lottie.j.Ev && this.Gh != null) {
            this.Gh.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
