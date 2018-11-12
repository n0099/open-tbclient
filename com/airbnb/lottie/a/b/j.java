package com.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends f<PointF> {
    private final PointF pK;

    public j(List<com.airbnb.lottie.a.a<PointF>> list) {
        super(list);
        this.pK = new PointF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.airbnb.lottie.a.a<PointF> aVar, float f) {
        if (aVar.on == null || aVar.oo == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = aVar.on;
        PointF pointF2 = aVar.oo;
        this.pK.set(pointF.x + ((pointF2.x - pointF.x) * f), ((pointF2.y - pointF.y) * f) + pointF.y);
        return this.pK;
    }
}
