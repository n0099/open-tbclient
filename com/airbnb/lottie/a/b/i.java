package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF pF;
    private final float[] pG;
    private h pH;
    private PathMeasure pI;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.pF = new PointF();
        this.pG = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.oh;
        }
        if (this.pH != hVar) {
            this.pI = new PathMeasure(path, false);
            this.pH = hVar;
        }
        this.pI.getPosTan(this.pI.getLength() * f, this.pG, null);
        this.pF.set(this.pG[0], this.pG[1]);
        return this.pF;
    }
}
