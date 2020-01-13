package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes5.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e hK;
    private final m<PointF, PointF> hL;
    private final g hM;
    private final b hN;
    private final d hO;
    @Nullable
    private final b hP;
    @Nullable
    private final b hQ;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.hK = eVar;
        this.hL = mVar;
        this.hM = gVar;
        this.hN = bVar;
        this.hO = dVar;
        this.hP = bVar2;
        this.hQ = bVar3;
    }

    public e co() {
        return this.hK;
    }

    public m<PointF, PointF> cp() {
        return this.hL;
    }

    public g cq() {
        return this.hM;
    }

    public b cr() {
        return this.hN;
    }

    public d cs() {
        return this.hO;
    }

    @Nullable
    public b ct() {
        return this.hP;
    }

    @Nullable
    public b cu() {
        return this.hQ;
    }

    public o cv() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
