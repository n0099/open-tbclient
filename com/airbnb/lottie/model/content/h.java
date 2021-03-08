package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class h {
    private final List<com.airbnb.lottie.model.a> HC = new ArrayList();
    private PointF HD;
    private boolean closed;

    public h(PointF pointF, boolean z, List<com.airbnb.lottie.model.a> list) {
        this.HD = pointF;
        this.closed = z;
        this.HC.addAll(list);
    }

    public h() {
    }

    private void i(float f, float f2) {
        if (this.HD == null) {
            this.HD = new PointF();
        }
        this.HD.set(f, f2);
    }

    public PointF jL() {
        return this.HD;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public List<com.airbnb.lottie.model.a> jM() {
        return this.HC;
    }

    public void a(h hVar, h hVar2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.HD == null) {
            this.HD = new PointF();
        }
        this.closed = hVar.isClosed() || hVar2.isClosed();
        if (hVar.jM().size() != hVar2.jM().size()) {
            com.airbnb.lottie.c.warn("Curves must have the same number of control points. Shape 1: " + hVar.jM().size() + "\tShape 2: " + hVar2.jM().size());
        }
        if (this.HC.isEmpty()) {
            int min = Math.min(hVar.jM().size(), hVar2.jM().size());
            for (int i = 0; i < min; i++) {
                this.HC.add(new com.airbnb.lottie.model.a());
            }
        }
        PointF jL = hVar.jL();
        PointF jL2 = hVar2.jL();
        i(com.airbnb.lottie.d.e.lerp(jL.x, jL2.x, f), com.airbnb.lottie.d.e.lerp(jL.y, jL2.y, f));
        if (this.HC.size() <= hVar.jM().size() && this.HC.size() <= hVar2.jM().size()) {
            for (int size = this.HC.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.a aVar = hVar.jM().get(size);
                com.airbnb.lottie.model.a aVar2 = hVar2.jM().get(size);
                PointF iS = aVar.iS();
                PointF iT = aVar.iT();
                PointF iU = aVar.iU();
                PointF iS2 = aVar2.iS();
                PointF iT2 = aVar2.iT();
                PointF iU2 = aVar2.iU();
                this.HC.get(size).f(com.airbnb.lottie.d.e.lerp(iS.x, iS2.x, f), com.airbnb.lottie.d.e.lerp(iS.y, iS2.y, f));
                this.HC.get(size).g(com.airbnb.lottie.d.e.lerp(iT.x, iT2.x, f), com.airbnb.lottie.d.e.lerp(iT.y, iT2.y, f));
                this.HC.get(size).h(com.airbnb.lottie.d.e.lerp(iU.x, iU2.x, f), com.airbnb.lottie.d.e.lerp(iU.y, iU2.y, f));
            }
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.HC.size() + "closed=" + this.closed + '}';
    }
}
