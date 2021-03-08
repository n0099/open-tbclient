package com.baidu.live.lottie.model.a;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.a.b.o;
/* loaded from: classes9.dex */
public class l implements com.baidu.live.lottie.model.content.b {
    private final e buW;
    private final m<PointF, PointF> buX;
    private final g buY;
    private final b buZ;
    private final d bva;
    @Nullable
    private final b bvb;
    @Nullable
    private final b bvc;

    public l() {
        this(new e(), new e(), new g(), new b(), new d(), new b(), new b());
    }

    public l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.buW = eVar;
        this.buX = mVar;
        this.buY = gVar;
        this.buZ = bVar;
        this.bva = dVar;
        this.bvb = bVar2;
        this.bvc = bVar3;
    }

    public e Nx() {
        return this.buW;
    }

    public m<PointF, PointF> Ny() {
        return this.buX;
    }

    public g Nz() {
        return this.buY;
    }

    public b NA() {
        return this.buZ;
    }

    public d NB() {
        return this.bva;
    }

    @Nullable
    public b NC() {
        return this.bvb;
    }

    @Nullable
    public b ND() {
        return this.bvc;
    }

    public o NE() {
        return new o(this);
    }

    @Override // com.baidu.live.lottie.model.content.b
    @Nullable
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return null;
    }
}
