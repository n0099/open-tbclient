package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes3.dex */
public class l implements com.airbnb.lottie.model.content.b {
    @Nullable
    private final b FA;
    @Nullable
    private final b FB;
    private final e Fv;
    private final m<PointF, PointF> Fw;
    private final g Fx;
    private final b Fy;
    private final d Fz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.Fv = eVar;
        this.Fw = mVar;
        this.Fx = gVar;
        this.Fy = bVar;
        this.Fz = dVar;
        this.FA = bVar2;
        this.FB = bVar3;
    }

    public e je() {
        return this.Fv;
    }

    public m<PointF, PointF> jf() {
        return this.Fw;
    }

    public g jg() {
        return this.Fx;
    }

    public b jh() {
        return this.Fy;
    }

    public d ji() {
        return this.Fz;
    }

    @Nullable
    public b jj() {
        return this.FA;
    }

    @Nullable
    public b jk() {
        return this.FB;
    }

    public o jl() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
