package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {
    private final PointF CV;
    private final float[] CW;
    private h CX;
    private PathMeasure CY;

    public i(List<? extends com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.CV = new PointF();
        this.CW = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path ht = hVar.ht();
        if (ht == null) {
            return aVar.Gp;
        }
        if (this.CK == null || (pointF = (PointF) this.CK.b(hVar.Ao, hVar.Gs.floatValue(), hVar.Gp, hVar.Gq, hG(), f, getProgress())) == null) {
            if (this.CX != hVar) {
                this.CY = new PathMeasure(ht, false);
                this.CX = hVar;
            }
            this.CY.getPosTan(this.CY.getLength() * f, this.CW, null);
            this.CV.set(this.CW[0], this.CW[1]);
            return this.CV;
        }
        return pointF;
    }
}
