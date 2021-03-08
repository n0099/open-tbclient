package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes9.dex */
public class a implements b {
    private final boolean Ha;
    private final m<PointF, PointF> buX;
    private final com.baidu.live.lottie.model.a.f bvd;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.buX = mVar;
        this.bvd = fVar;
        this.Ha = z;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.e(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> Ny() {
        return this.buX;
    }

    public com.baidu.live.lottie.model.a.f NF() {
        return this.bvd;
    }

    public boolean isReversed() {
        return this.Ha;
    }
}
