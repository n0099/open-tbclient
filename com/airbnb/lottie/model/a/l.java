package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e Dq;
    private final m<PointF, PointF> Dr;
    private final g Ds;
    private final b Dt;
    private final d Du;
    @Nullable
    private final b Dv;
    @Nullable
    private final b Dw;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.Dq = eVar;
        this.Dr = mVar;
        this.Ds = gVar;
        this.Dt = bVar;
        this.Du = dVar;
        this.Dv = bVar2;
        this.Dw = bVar3;
    }

    public e hM() {
        return this.Dq;
    }

    public m<PointF, PointF> hN() {
        return this.Dr;
    }

    public g hO() {
        return this.Ds;
    }

    public b hP() {
        return this.Dt;
    }

    public d hQ() {
        return this.Du;
    }

    @Nullable
    public b hR() {
        return this.Dv;
    }

    @Nullable
    public b hS() {
        return this.Dw;
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
