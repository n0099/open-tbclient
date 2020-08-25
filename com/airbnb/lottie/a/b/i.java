package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes18.dex */
public class i extends f<PointF> {
    private final PointF DC;
    private final float[] DD;
    private h DE;
    private PathMeasure DG;

    public i(List<? extends com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.DC = new PointF();
        this.DD = new float[2];
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
        Path iU = hVar.iU();
        if (iU == null) {
            return aVar.GX;
        }
        if (this.Dv == null || (pointF = (PointF) this.Dv.b(hVar.AX, hVar.Ha.floatValue(), hVar.GX, hVar.GY, jh(), f, getProgress())) == null) {
            if (this.DE != hVar) {
                this.DG = new PathMeasure(iU, false);
                this.DE = hVar;
            }
            this.DG.getPosTan(this.DG.getLength() * f, this.DD, null);
            this.DC.set(this.DD[0], this.DD[1]);
            return this.DC;
        }
        return pointF;
    }
}
