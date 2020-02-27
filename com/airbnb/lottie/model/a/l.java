package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e hO;
    private final m<PointF, PointF> hP;
    private final g hQ;
    private final b hR;
    private final d hS;
    @Nullable
    private final b hT;
    @Nullable
    private final b hU;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.hO = eVar;
        this.hP = mVar;
        this.hQ = gVar;
        this.hR = bVar;
        this.hS = dVar;
        this.hT = bVar2;
        this.hU = bVar3;
    }

    public e cp() {
        return this.hO;
    }

    public m<PointF, PointF> cq() {
        return this.hP;
    }

    public g cr() {
        return this.hQ;
    }

    public b cs() {
        return this.hR;
    }

    public d ct() {
        return this.hS;
    }

    @Nullable
    public b cu() {
        return this.hT;
    }

    @Nullable
    public b cv() {
        return this.hU;
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
