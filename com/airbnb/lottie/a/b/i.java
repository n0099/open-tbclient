package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF nd;
    private final float[] ne;
    private h nf;
    private PathMeasure ng;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.nd = new PointF();
        this.ne = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path cd = hVar.cd();
        if (cd == null) {
            return aVar.lI;
        }
        if (this.nf != hVar) {
            this.ng = new PathMeasure(cd, false);
            this.nf = hVar;
        }
        this.ng.getPosTan(this.ng.getLength() * f, this.ne, null);
        this.nd.set(this.ne[0], this.ne[1]);
        return this.nd;
    }
}
