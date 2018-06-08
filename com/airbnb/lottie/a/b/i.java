package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF mA;
    private final float[] mD;
    private h mE;
    private PathMeasure mF;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.mA = new PointF();
        this.mD = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.lg;
        }
        if (this.mE != hVar) {
            this.mF = new PathMeasure(path, false);
            this.mE = hVar;
        }
        this.mF.getPosTan(this.mF.getLength() * f, this.mD, null);
        this.mA.set(this.mD[0], this.mD[1]);
        return this.mA;
    }
}
