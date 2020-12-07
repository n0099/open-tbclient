package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes7.dex */
public class j extends f<PointF> {
    private final PointF EM;

    public j(List<com.airbnb.lottie.e.a<PointF>> list) {
        super(list);
        this.EM = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        if (aVar.If == null || aVar.Ig == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = aVar.If;
        PointF pointF3 = aVar.Ig;
        if (this.EG == null || (pointF = (PointF) this.EG.b(aVar.Ce, aVar.Ii.floatValue(), pointF2, pointF3, f, jj(), getProgress())) == null) {
            this.EM.set(pointF2.x + ((pointF3.x - pointF2.x) * f), pointF2.y + ((pointF3.y - pointF2.y) * f));
            return this.EM;
        }
        return pointF;
    }
}
