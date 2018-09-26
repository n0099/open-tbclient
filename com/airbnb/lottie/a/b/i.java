package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF oR;
    private final float[] oS;
    private h oT;
    private PathMeasure oU;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.oR = new PointF();
        this.oS = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.nA;
        }
        if (this.oT != hVar) {
            this.oU = new PathMeasure(path, false);
            this.oT = hVar;
        }
        this.oU.getPosTan(this.oU.getLength() * f, this.oS, null);
        this.oR.set(this.oS[0], this.oS[1]);
        return this.oR;
    }
}
