package com.baidu.live.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.a;
/* loaded from: classes10.dex */
public class o {
    private final a<PointF, PointF> btb;
    private final a<?, PointF> btc;
    private final a<com.baidu.live.lottie.e.d, com.baidu.live.lottie.e.d> btd;
    private final a<Float, Float> bte;
    private final a<Integer, Integer> btf;
    @Nullable
    private final a<?, Float> btg;
    @Nullable
    private final a<?, Float> bth;
    private final Matrix matrix = new Matrix();

    public o(com.baidu.live.lottie.model.a.l lVar) {
        this.btb = lVar.Nu().Ns();
        this.btc = lVar.Nv().Ns();
        this.btd = lVar.Nw().Ns();
        this.bte = lVar.Nx().Ns();
        this.btf = lVar.Ny().Ns();
        if (lVar.Nz() != null) {
            this.btg = lVar.Nz().Ns();
        } else {
            this.btg = null;
        }
        if (lVar.NA() != null) {
            this.bth = lVar.NA().Ns();
        } else {
            this.bth = null;
        }
    }

    public void a(com.baidu.live.lottie.model.layer.a aVar) {
        aVar.a(this.btb);
        aVar.a(this.btc);
        aVar.a(this.btd);
        aVar.a(this.bte);
        aVar.a(this.btf);
        if (this.btg != null) {
            aVar.a(this.btg);
        }
        if (this.bth != null) {
            aVar.a(this.bth);
        }
    }

    public void a(a.InterfaceC0186a interfaceC0186a) {
        this.btb.b(interfaceC0186a);
        this.btc.b(interfaceC0186a);
        this.btd.b(interfaceC0186a);
        this.bte.b(interfaceC0186a);
        this.btf.b(interfaceC0186a);
        if (this.btg != null) {
            this.btg.b(interfaceC0186a);
        }
        if (this.bth != null) {
            this.bth.b(interfaceC0186a);
        }
    }

    public void setProgress(float f) {
        this.btb.setProgress(f);
        this.btc.setProgress(f);
        this.btd.setProgress(f);
        this.bte.setProgress(f);
        this.btf.setProgress(f);
        if (this.btg != null) {
            this.btg.setProgress(f);
        }
        if (this.bth != null) {
            this.bth.setProgress(f);
        }
    }

    public a<?, Integer> Nn() {
        return this.btf;
    }

    @Nullable
    public a<?, Float> No() {
        return this.btg;
    }

    @Nullable
    public a<?, Float> Np() {
        return this.bth;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.btc.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.bte.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.baidu.live.lottie.e.d value2 = this.btd.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.btb.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.btc.getValue();
        PointF value2 = this.btb.getValue();
        com.baidu.live.lottie.e.d value3 = this.btd.getValue();
        float floatValue = this.bte.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public <T> boolean b(T t, @Nullable com.baidu.live.lottie.e.c<T> cVar) {
        if (t == com.baidu.live.lottie.l.CD) {
            this.btb.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CE) {
            this.btc.a(cVar);
        } else if (t == com.baidu.live.lottie.l.bsk) {
            this.btd.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CI) {
            this.bte.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CB) {
            this.btf.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CY && this.btg != null) {
            this.btg.a(cVar);
        } else if (t == com.baidu.live.lottie.l.CZ && this.bth != null) {
            this.bth.a(cVar);
        } else {
            return false;
        }
        return true;
    }
}
