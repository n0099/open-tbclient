package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e Dt;
    private final m<PointF, PointF> Du;
    private final g Dv;
    private final b Dw;
    private final d Dx;
    @Nullable
    private final b Dy;
    @Nullable
    private final b Dz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.Dt = eVar;
        this.Du = mVar;
        this.Dv = gVar;
        this.Dw = bVar;
        this.Dx = dVar;
        this.Dy = bVar2;
        this.Dz = bVar3;
    }

    public e hM() {
        return this.Dt;
    }

    public m<PointF, PointF> hN() {
        return this.Du;
    }

    public g hO() {
        return this.Dv;
    }

    public b hP() {
        return this.Dw;
    }

    public d hQ() {
        return this.Dx;
    }

    @Nullable
    public b hR() {
        return this.Dy;
    }

    @Nullable
    public b hS() {
        return this.Dz;
    }

    public o hT() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
