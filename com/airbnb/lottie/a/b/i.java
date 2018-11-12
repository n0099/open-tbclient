package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF pK;
    private final float[] pL;
    private h pM;
    private PathMeasure pN;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.pK = new PointF();
        this.pL = new float[2];
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
        if (this.pM != hVar) {
            this.pN = new PathMeasure(path, false);
            this.pM = hVar;
        }
        this.pN.getPosTan(this.pN.getLength() * f, this.pL, null);
        this.pK.set(this.pL[0], this.pL[1]);
        return this.pK;
    }
}
