package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {
    private final PointF gN;
    private final float[] gO;
    private h gP;
    private PathMeasure gQ;

    public i(List<? extends com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gN = new PointF();
        this.gO = new float[2];
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
        Path bG = hVar.bG();
        if (bG == null) {
            return aVar.kp;
        }
        if (this.gH == null || (pointF = (PointF) this.gH.b(hVar.ec, hVar.ks.floatValue(), hVar.kp, hVar.kq, bT(), f, getProgress())) == null) {
            if (this.gP != hVar) {
                this.gQ = new PathMeasure(bG, false);
                this.gP = hVar;
            }
            this.gQ.getPosTan(this.gQ.getLength() * f, this.gO, null);
            this.gN.set(this.gO[0], this.gO[1]);
            return this.gN;
        }
        return pointF;
    }
}
