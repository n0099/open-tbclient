package com.airbnb.lottie.a.b;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.a;
/* loaded from: classes2.dex */
public class p {
    private final a<PointF, PointF> fh;
    private final a<?, PointF> fi;
    private final a<com.airbnb.lottie.model.k, com.airbnb.lottie.model.k> fj;
    private final a<Float, Float> fk;
    private final a<Integer, Integer> fl;
    @Nullable
    private final a<?, Float> fn;
    @Nullable
    private final a<?, Float> fo;
    private final Matrix matrix = new Matrix();

    public p(com.airbnb.lottie.model.a.l lVar) {
        this.fh = lVar.cj().bY();
        this.fi = lVar.ck().bY();
        this.fj = lVar.cl().bY();
        this.fk = lVar.cm().bY();
        this.fl = lVar.cn().bY();
        if (lVar.co() != null) {
            this.fn = lVar.co().bY();
        } else {
            this.fn = null;
        }
        if (lVar.cp() != null) {
            this.fo = lVar.cp().bY();
        } else {
            this.fo = null;
        }
    }

    public void a(com.airbnb.lottie.model.layer.a aVar) {
        aVar.a(this.fh);
        aVar.a(this.fi);
        aVar.a(this.fj);
        aVar.a(this.fk);
        aVar.a(this.fl);
        if (this.fn != null) {
            aVar.a(this.fn);
        }
        if (this.fo != null) {
            aVar.a(this.fo);
        }
    }

    public void a(a.InterfaceC0007a interfaceC0007a) {
        this.fh.b(interfaceC0007a);
        this.fi.b(interfaceC0007a);
        this.fj.b(interfaceC0007a);
        this.fk.b(interfaceC0007a);
        this.fl.b(interfaceC0007a);
        if (this.fn != null) {
            this.fn.b(interfaceC0007a);
        }
        if (this.fo != null) {
            this.fo.b(interfaceC0007a);
        }
    }

    public void setProgress(float f) {
        this.fh.setProgress(f);
        this.fi.setProgress(f);
        this.fj.setProgress(f);
        this.fk.setProgress(f);
        this.fl.setProgress(f);
        if (this.fn != null) {
            this.fn.setProgress(f);
        }
        if (this.fo != null) {
            this.fo.setProgress(f);
        }
    }

    public a<?, Integer> bP() {
        return this.fl;
    }

    @Nullable
    public a<?, Float> bQ() {
        return this.fn;
    }

    @Nullable
    public a<?, Float> bR() {
        return this.fo;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.fi.getValue();
        if (value.x != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(value.x, value.y);
        }
        float floatValue = this.fk.getValue().floatValue();
        if (floatValue != 0.0f) {
            this.matrix.preRotate(floatValue);
        }
        com.airbnb.lottie.model.k value2 = this.fj.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.fh.getValue();
        if (value3.x != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-value3.x, -value3.y);
        }
        return this.matrix;
    }

    public Matrix h(float f) {
        PointF value = this.fi.getValue();
        PointF value2 = this.fh.getValue();
        com.airbnb.lottie.model.k value3 = this.fj.getValue();
        float floatValue = this.fk.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), f), (float) Math.pow(value3.getScaleY(), f));
        this.matrix.preRotate(floatValue * f, value2.x, value2.y);
        return this.matrix;
    }
}
