package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends f<PointF> {
    private final PointF gO;
    private final float[] gP;
    private h gQ;
    private PathMeasure gR;

    public i(List<? extends com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.gO = new PointF();
        this.gP = new float[2];
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
            return aVar.kq;
        }
        if (this.gI == null || (pointF = (PointF) this.gI.b(hVar.ed, hVar.kt.floatValue(), hVar.kq, hVar.kr, bT(), f, getProgress())) == null) {
            if (this.gQ != hVar) {
                this.gR = new PathMeasure(bG, false);
                this.gQ = hVar;
            }
            this.gR.getPosTan(this.gR.getLength() * f, this.gP, null);
            this.gO.set(this.gP[0], this.gP[1]);
            return this.gO;
        }
        return pointF;
    }
}
