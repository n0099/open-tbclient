package com.baidu.live.lottie.a.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* loaded from: classes9.dex */
public class i extends f<PointF> {
    private final PointF FT;
    private final float[] FU;
    private PathMeasure FW;
    private h buz;

    public i(List<? extends com.baidu.live.lottie.e.a<PointF>> list) {
        super(list);
        this.FT = new PointF();
        this.FU = new float[2];
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
            return aVar.Jk;
        }
        if (this.buw == null || (pointF = (PointF) this.buw.c(hVar.Dr, hVar.Jn.floatValue(), hVar.Jk, hVar.Jl, iH(), f, getProgress())) == null) {
            if (this.buz != hVar) {
                this.FW = new PathMeasure(iu, false);
                this.buz = hVar;
            }
            this.FW.getPosTan(this.FW.getLength() * f, this.FU, null);
            this.FT.set(this.FU[0], this.FU[1]);
            return this.FT;
        }
        return pointF;
    }
}
