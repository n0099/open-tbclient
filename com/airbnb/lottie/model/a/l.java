package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes18.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e EB;
    private final m<PointF, PointF> ED;
    private final g EE;
    private final b EF;
    private final d EG;
    @Nullable
    private final b EH;
    @Nullable
    private final b EI;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.EB = eVar;
        this.ED = mVar;
        this.EE = gVar;
        this.EF = bVar;
        this.EG = dVar;
        this.EH = bVar2;
        this.EI = bVar3;
    }

    public e jD() {
        return this.EB;
    }

    public m<PointF, PointF> jE() {
        return this.ED;
    }

    public g jF() {
        return this.EE;
    }

    public b jG() {
        return this.EF;
    }

    public d jH() {
        return this.EG;
    }

    @Nullable
    public b jI() {
        return this.EH;
    }

    @Nullable
    public b jJ() {
        return this.EI;
    }

    public o jK() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
