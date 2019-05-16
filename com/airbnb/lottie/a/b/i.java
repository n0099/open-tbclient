package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF ne;
    private final float[] nf;
    private h ng;
    private PathMeasure nh;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.ne = new PointF();
        this.nf = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.lJ;
        }
        if (this.ng != hVar) {
            this.nh = new PathMeasure(path, false);
            this.ng = hVar;
        }
        this.nh.getPosTan(this.nh.getLength() * f, this.nf, null);
        this.ne.set(this.nf[0], this.nf[1]);
        return this.ne;
    }
}
