package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class h {
    private final List<com.baidu.live.lottie.model.a> Gg = new ArrayList();
    private PointF Gh;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.baidu.live.lottie.model.a> list) {
        this.Gh = pointF;
        this.closed = z;
        this.Gg.addAll(list);
    }

    public h() {
    }

    private void i(float f, float f2) {
        if (this.Gh == null) {
            this.Gh = new PointF();
        }
        this.Gh.set(f, f2);
    }

    public PointF jM() {
        return this.Gh;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.baidu.live.lottie.model.a> jN() {
        return this.Gg;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.Gh == null) {
            this.Gh = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.jN().size() != hVar2.jN().size()) {
            com.baidu.live.lottie.d.warn("Curves must have the same number of control points. Shape 1: " + hVar.jN().size() + "\tShape 2: " + hVar2.jN().size());
        }
        if (this.Gg.isEmpty()) {
            int min = Math.min(hVar.jN().size(), hVar2.jN().size());
            for (int i = 0; i < min; i++) {
                this.Gg.add(new com.baidu.live.lottie.model.a());
            }
        }
        PointF jM = hVar.jM();
        PointF jM2 = hVar2.jM();
        i(com.baidu.live.lottie.d.e.lerp(jM.x, jM2.x, f), com.baidu.live.lottie.d.e.lerp(jM.y, jM2.y, f));
        for (int size = this.Gg.size() - 1; size >= 0; size--) {
            com.baidu.live.lottie.model.a aVar = hVar.jN().get(size);
            com.baidu.live.lottie.model.a aVar2 = hVar2.jN().get(size);
            PointF iT = aVar.iT();
            PointF iU = aVar.iU();
            PointF iV = aVar.iV();
            PointF iT2 = aVar2.iT();
            PointF iU2 = aVar2.iU();
            PointF iV2 = aVar2.iV();
            this.Gg.get(size).f(com.baidu.live.lottie.d.e.lerp(iT.x, iT2.x, f), com.baidu.live.lottie.d.e.lerp(iT.y, iT2.y, f));
            this.Gg.get(size).g(com.baidu.live.lottie.d.e.lerp(iU.x, iU2.x, f), com.baidu.live.lottie.d.e.lerp(iU.y, iU2.y, f));
            this.Gg.get(size).h(com.baidu.live.lottie.d.e.lerp(iV.x, iV2.x, f), com.baidu.live.lottie.d.e.lerp(iV.y, iV2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.Gg.size() + "closed=" + this.closed + '}';
    }
}
