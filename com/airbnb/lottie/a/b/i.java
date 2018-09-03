package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF mp;
    private final float[] mq;
    private h mr;
    private PathMeasure mt;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.mp = new PointF();
        this.mq = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.kY;
        }
        if (this.mr != hVar) {
            this.mt = new PathMeasure(path, false);
            this.mr = hVar;
        }
        this.mt.getPosTan(this.mt.getLength() * f, this.mq, null);
        this.mp.set(this.mq[0], this.mq[1]);
        return this.mp;
    }
}
