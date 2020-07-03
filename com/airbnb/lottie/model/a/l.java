package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes6.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e DX;
    private final m<PointF, PointF> DY;
    private final g DZ;
    private final b Ea;
    private final d Eb;
    @Nullable
    private final b Ec;
    @Nullable
    private final b Ed;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.DX = eVar;
        this.DY = mVar;
        this.DZ = gVar;
        this.Ea = bVar;
        this.Eb = dVar;
        this.Ec = bVar2;
        this.Ed = bVar3;
    }

    public e ic() {
        return this.DX;
    }

    public m<PointF, PointF> ie() {
        return this.DY;
    }

    /* renamed from: if  reason: not valid java name */
    public g m7if() {
        return this.DZ;
    }

    public b ig() {
        return this.Ea;
    }

    public d ih() {
        return this.Eb;
    }

    @Nullable
    public b ii() {
        return this.Ec;
    }

    @Nullable
    public b ij() {
        return this.Ed;
    }

    public o ik() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
