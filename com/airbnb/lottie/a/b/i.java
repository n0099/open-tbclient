package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class i extends f<PointF> {
    private final PointF mo;
    private final float[] mp;
    private h mq;
    private PathMeasure mr;

    public i(List<? extends com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.mo = new PointF();
        this.mp = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        h hVar = (h) aVar;
        Path path = hVar.getPath();
        if (path == null) {
            return aVar.kX;
        }
        if (this.mq != hVar) {
            this.mr = new PathMeasure(path, false);
            this.mq = hVar;
        }
        this.mr.getPosTan(this.mr.getLength() * f, this.mp, null);
        this.mo.set(this.mp[0], this.mp[1]);
        return this.mo;
    }
}
