package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes10.dex */
public class i extends f<PointF> {
    private final float[] EA;
    private PathMeasure EC;
    private final PointF Ez;
    private h bsX;

    public i(List<? extends com.baidu.live.lottie.e.a<PointF>> list) {
        super(list);
        this.Ez = new PointF();
        this.EA = new float[2];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.live.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.baidu.live.lottie.e.a<PointF> aVar, float f) {
        PointF pointF;
        h hVar = (h) aVar;
        Path iu = hVar.iu();
        if (iu == null) {
            return aVar.HL;
        }
        if (this.bsU == null || (pointF = (PointF) this.bsU.c(hVar.BT, hVar.HO.floatValue(), hVar.HL, hVar.HM, iH(), f, getProgress())) == null) {
            if (this.bsX != hVar) {
                this.EC = new PathMeasure(iu, false);
                this.bsX = hVar;
            }
            this.EC.getPosTan(this.EC.getLength() * f, this.EA, null);
            this.Ez.set(this.EA[0], this.EA[1]);
            return this.Ez;
        }
        return pointF;
    }
}
