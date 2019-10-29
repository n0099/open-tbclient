package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF fA;
    private final float[] fB;
    private h fC;
    private PathMeasure fD;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.fA = new PointF();
        this.fB = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path bw = hVar.bw();
        if (bw == null) {
            return aVar.ej;
        }
        if (this.fC != hVar) {
            this.fD = new PathMeasure(bw, false);
            this.fC = hVar;
        }
        this.fD.getPosTan(this.fD.getLength() * f, this.fB, null);
        this.fA.set(this.fB[0], this.fB[1]);
        return this.fA;
    }
}
