package com.baidu.live.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
/* loaded from: classes9.dex */
public class o {
    private final a<PointF, PointF> buD;
    private final a<?, PointF> buE;
    private final a<com.baidu.live.lottie.e.d, com.baidu.live.lottie.e.d> buF;
    private final a<Float, Float> buG;
    private final a<Integer, Integer> buH;
    @Nullable
    private final a<?, Float> buI;
    @Nullable
    private final a<?, Float> buJ;
    private final Matrix matrix = new Matrix();

    public o(com.baidu.live.lottie.model.a.l lVar) {
        this.buD = lVar.Nx().Nv();
        this.buE = lVar.Ny().Nv();
        this.buF = lVar.Nz().Nv();
        this.buG = lVar.NA().Nv();
        this.buH = lVar.NB().Nv();
        if (lVar.NC() != null) {
            this.buI = lVar.NC().Nv();
        } else {
            this.buI = null;
        }
        if (lVar.ND() != null) {
            this.buJ = lVar.ND().Nv();
        } else {
            this.buJ = null;
        }
    }

    public void a(com.baidu.live.lottie.model.layer.a aVar) {
        aVar.a(this.buD);
        aVar.a(this.buE);
        aVar.a(this.buF);
        aVar.a(this.buG);
        aVar.a(this.buH);
        if (this.buI != null) {
            aVar.a(this.buI);
        }
        if (this.buJ != null) {
            aVar.a(this.buJ);
        }
    }

    public void a(a.InterfaceC0192a interfaceC0192a) {
        this.buD.b(interfaceC0192a);
        this.buE.b(interfaceC0192a);
        this.buF.b(interfaceC0192a);
        this.buG.b(interfaceC0192a);
        this.buH.b(interfaceC0192a);
        if (this.buI != null) {
            this.buI.b(interfaceC0192a);
        }
        if (this.buJ != null) {
            this.buJ.b(interfaceC0192a);
        }
    }

    public void setProgress(float f) {
        this.buD.setProgress(f);
        this.buE.setProgress(f);
        this.buF.setProgress(f);
        this.buG.setProgress(f);
        this.buH.setProgress(f);
        if (this.buI != null) {
            this.buI.setProgress(f);
        }
        if (this.buJ != null) {
            this.buJ.setProgress(f);
        }
    }

    public a<?, Integer> Nq() {
        return this.buH;
    }

    @Nullable
    public a<?, Float> Nr() {
        return this.buI;
    }

    @Nullable
    public a<?, Float> Ns() {
        return this.buJ;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.buE.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.buG.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.baidu.live.lottie.e.d value2 = this.buF.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.buD.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix l(float f) {
        PointF value = this.buE.getValue();
        PointF value2 = this.buD.getValue();
        com.baidu.live.lottie.e.d value3 = this.buF.getValue();
        float floatValue = this.buG.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.Ee) {
            this.buD.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Ef) {
            this.buE.a(cVar);
        } else if (t == com.baidu.live.lottie.l.btL) {
            this.buF.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Ej) {
            this.buG.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Ec) {
            this.buH.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Eu && this.buI != null) {
            this.buI.a(cVar);
        } else if (t == com.baidu.live.lottie.l.Ev && this.buJ != null) {
            this.buJ.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
