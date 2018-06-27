package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final float[] mA;
    private h mD;
    private PathMeasure mE;
    private final PointF mz;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.mz = new PointF();
        this.mA = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.lf;
        }
        if (this.mD != hVar) {
            this.mE = new PathMeasure(path, false);
            this.mD = hVar;
        }
        this.mE.getPosTan(this.mE.getLength() * f, this.mA, null);
        this.mz.set(this.mA[0], this.mA[1]);
        return this.mz;
    }
}
