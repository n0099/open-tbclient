package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.a.b.o;
/* loaded from: classes5.dex */
public class l implements com.airbnb.lottie.model.content.b {
    private final e GQ;
    private final m<PointF, PointF> GR;
    private final g GU;
    private final b GV;
    private final d GW;
    @Nullable
    private final b GX;
    @Nullable
    private final b GY;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.GQ = eVar;
        this.GR = mVar;
        this.GU = gVar;
        this.GV = bVar;
        this.GW = dVar;
        this.GX = bVar2;
        this.GY = bVar3;
    }

    public e jd() {
        return this.GQ;
    }

    public m<PointF, PointF> je() {
        return this.GR;
    }

    public g jf() {
        return this.GU;
    }

    public b jg() {
        return this.GV;
    }

    public d jh() {
        return this.GW;
    }

    @Nullable
    public b ji() {
        return this.GX;
    }

    @Nullable
    public b jj() {
        return this.GY;
    }

    public o jk() {
        return new o(this);
    }

    @Override // com.airbnb.lottie.model.content.b
    @Nullable
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }
}
