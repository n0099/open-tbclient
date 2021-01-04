package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes3.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final b FA;
    private final d FB;
    @Nullable
    private final b FC;
    @Nullable
    private final b FD;
    private final e Fx;
    private final m<PointF, PointF> Fy;
    private final g Fz;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.Fx = eVar;
        this.Fy = mVar;
        this.Fz = gVar;
        this.FA = bVar;
        this.FB = dVar;
        this.FC = bVar2;
        this.FD = bVar3;
    }

    public e je() {
        return this.Fx;
    }

    public m<PointF, PointF> jf() {
        return this.Fy;
    }

    public g jg() {
        return this.Fz;
    }

    public b jh() {
        return this.FA;
    }

    public d ji() {
        return this.FB;
    }

    @Nullable
    public b jj() {
        return this.FC;
    }

    @Nullable
    public b jk() {
        return this.FD;
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
