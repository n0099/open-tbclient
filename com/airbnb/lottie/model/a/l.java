package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e hN;
    private final m<PointF, PointF> hO;
    private final g hP;
    private final b hQ;
    private final d hR;
    @Nullable
    private final b hS;
    @Nullable
    private final b hT;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.hN = eVar;
        this.hO = mVar;
        this.hP = gVar;
        this.hQ = bVar;
        this.hR = dVar;
        this.hS = bVar2;
        this.hT = bVar3;
    }

    public e cp() {
        return this.hN;
    }

    public m<PointF, PointF> cq() {
        return this.hO;
    }

    public g cr() {
        return this.hP;
    }

    public b cs() {
        return this.hQ;
    }

    public d ct() {
        return this.hR;
    }

    @Nullable
    public b cu() {
        return this.hS;
    }

    @Nullable
    public b cv() {
        return this.hT;
    }

    public o cw() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
