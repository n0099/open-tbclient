package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF pJ;
    private final float[] pK;
    private h pL;
    private PathMeasure pM;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.pJ = new PointF();
        this.pK = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.on;
        }
        if (this.pL != hVar) {
            this.pM = new PathMeasure(path, false);
            this.pL = hVar;
        }
        this.pM.getPosTan(this.pM.getLength() * f, this.pK, null);
        this.pJ.set(this.pK[0], this.pK[1]);
        return this.pJ;
    }
}
