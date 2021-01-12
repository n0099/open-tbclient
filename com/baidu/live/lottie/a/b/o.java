package com.baidu.live.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
/* loaded from: classes9.dex */
public class o {
    private final a<PointF, PointF> bpA;
    private final a<?, PointF> bpB;
    private final a<com.baidu.live.lottie.e.d, com.baidu.live.lottie.e.d> bpC;
    private final a<Float, Float> bpD;
    private final a<Integer, Integer> bpE;
    @Nullable
    private final a<?, Float> bpF;
    @Nullable
    private final a<?, Float> bpG;
    private final Matrix matrix = new Matrix();

    public o(com.baidu.live.lottie.model.a.l lVar) {
        this.bpA = lVar.LW().LU();
        this.bpB = lVar.LX().LU();
        this.bpC = lVar.LY().LU();
        this.bpD = lVar.LZ().LU();
        this.bpE = lVar.Ma().LU();
        if (lVar.Mb() != null) {
            this.bpF = lVar.Mb().LU();
        } else {
            this.bpF = null;
        }
        if (lVar.Mc() != null) {
            this.bpG = lVar.Mc().LU();
        } else {
            this.bpG = null;
        }
    }

    public void a(com.baidu.live.lottie.model.layer.a aVar) {
        aVar.a(this.bpA);
        aVar.a(this.bpB);
        aVar.a(this.bpC);
        aVar.a(this.bpD);
        aVar.a(this.bpE);
        if (this.bpF != null) {
            aVar.a(this.bpF);
        }
        if (this.bpG != null) {
            aVar.a(this.bpG);
        }
    }

    public void a(a.InterfaceC0185a interfaceC0185a) {
        this.bpA.b(interfaceC0185a);
        this.bpB.b(interfaceC0185a);
        this.bpC.b(interfaceC0185a);
        this.bpD.b(interfaceC0185a);
        this.bpE.b(interfaceC0185a);
        if (this.bpF != null) {
            this.bpF.b(interfaceC0185a);
        }
        if (this.bpG != null) {
            this.bpG.b(interfaceC0185a);
        }
    }

    public void setProgress(float f) {
        this.bpA.setProgress(f);
        this.bpB.setProgress(f);
        this.bpC.setProgress(f);
        this.bpD.setProgress(f);
        this.bpE.setProgress(f);
        if (this.bpF != null) {
            this.bpF.setProgress(f);
        }
        if (this.bpG != null) {
            this.bpG.setProgress(f);
        }
    }

    public a<?, Integer> LP() {
        return this.bpE;
    }

    @Nullable
    public a<?, Float> LQ() {
        return this.bpF;
    }

    @Nullable
    public a<?, Float> LR() {
        return this.bpG;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.bpB.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.bpD.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.baidu.live.lottie.e.d value2 = this.bpC.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.bpA.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.bpB.getValue();
        PointF value2 = this.bpA.getValue();
        com.baidu.live.lottie.e.d value3 = this.bpC.getValue();
        float floatValue = this.bpD.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CD) {
            this.bpA.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CE) {
            this.bpB.a(cVar);
        } else if (t == com.baidu.live.lottie.l.boJ) {
            this.bpC.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CI) {
            this.bpD.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CB) {
            this.bpE.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CY && this.bpF != null) {
            this.bpF.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CZ && this.bpG != null) {
            this.bpG.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
