package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    private final List<com.airbnb.lottie.model.a> Gi = new ArrayList();
    private PointF Gj;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.airbnb.lottie.model.a> list) {
        this.Gj = pointF;
        this.closed = z;
        this.Gi.addAll(list);
    }

    public h() {
    }

    private void h(float f, float f2) {
        if (this.Gj == null) {
            this.Gj = new PointF();
        }
        this.Gj.set(f, f2);
    }

    public PointF jM() {
        return this.Gj;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.a> jN() {
        return this.Gi;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.Gj == null) {
            this.Gj = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.jN().size() != hVar2.jN().size()) {
            com.airbnb.lottie.c.warn("Curves must have the same number of control points. Shape 1: " + hVar.jN().size() + "\tShape 2: " + hVar2.jN().size());
        }
        if (this.Gi.isEmpty()) {
            int min = Math.min(hVar.jN().size(), hVar2.jN().size());
            for (int i = 0; i < min; i++) {
                this.Gi.add(new com.airbnb.lottie.model.a());
            }
        }
        PointF jM = hVar.jM();
        PointF jM2 = hVar2.jM();
        h(com.airbnb.lottie.d.e.lerp(jM.x, jM2.x, f), com.airbnb.lottie.d.e.lerp(jM.y, jM2.y, f));
        if (this.Gi.size() <= hVar.jN().size() && this.Gi.size() <= hVar2.jN().size()) {
            for (int size = this.Gi.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.a aVar = hVar.jN().get(size);
                com.airbnb.lottie.model.a aVar2 = hVar2.jN().get(size);
                PointF iT = aVar.iT();
                PointF iU = aVar.iU();
                PointF iV = aVar.iV();
                PointF iT2 = aVar2.iT();
                PointF iU2 = aVar2.iU();
                PointF iV2 = aVar2.iV();
                this.Gi.get(size).e(com.airbnb.lottie.d.e.lerp(iT.x, iT2.x, f), com.airbnb.lottie.d.e.lerp(iT.y, iT2.y, f));
                this.Gi.get(size).f(com.airbnb.lottie.d.e.lerp(iU.x, iU2.x, f), com.airbnb.lottie.d.e.lerp(iU.y, iU2.y, f));
                this.Gi.get(size).g(com.airbnb.lottie.d.e.lerp(iV.x, iV2.x, f), com.airbnb.lottie.d.e.lerp(iV.y, iV2.y, f));
            }
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.Gi.size() + "closed=" + this.closed + '}';
    }
}
