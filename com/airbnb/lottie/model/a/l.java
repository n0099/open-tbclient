package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes10.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e EU;
    private final m<PointF, PointF> EV;
    private final g EW;
    private final b EX;
    private final d EY;
    @Nullable
    private final b EZ;
    @Nullable
    private final b Fa;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.EU = eVar;
        this.EV = mVar;
        this.EW = gVar;
        this.EX = bVar;
        this.EY = dVar;
        this.EZ = bVar2;
        this.Fa = bVar3;
    }

    public e jF() {
        return this.EU;
    }

    public m<PointF, PointF> jG() {
        return this.EV;
    }

    public g jH() {
        return this.EW;
    }

    public b jI() {
        return this.EX;
    }

    public d jJ() {
        return this.EY;
    }

    @Nullable
    public b jK() {
        return this.EZ;
    }

    @Nullable
    public b jL() {
        return this.Fa;
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
