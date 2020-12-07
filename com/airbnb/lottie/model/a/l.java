package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes7.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e FK;
    private final m<PointF, PointF> FL;
    private final g FM;
    private final b FN;
    private final d FO;
    @Nullable
    private final b FP;
    @Nullable
    private final b FQ;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.FK = eVar;
        this.FL = mVar;
        this.FM = gVar;
        this.FN = bVar;
        this.FO = dVar;
        this.FP = bVar2;
        this.FQ = bVar3;
    }

    public e jF() {
        return this.FK;
    }

    public m<PointF, PointF> jG() {
        return this.FL;
    }

    public g jH() {
        return this.FM;
    }

    public b jI() {
        return this.FN;
    }

    public d jJ() {
        return this.FO;
    }

    @Nullable
    public b jK() {
        return this.FP;
    }

    @Nullable
    public b jL() {
        return this.FQ;
    }

    public o jM() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
