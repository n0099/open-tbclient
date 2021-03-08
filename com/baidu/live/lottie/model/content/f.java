package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.a.a.n;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes9.dex */
public class f implements b {
    private final m<PointF, PointF> buX;
    private final com.baidu.live.lottie.model.a.f bvd;
    private final com.baidu.live.lottie.model.a.b bvw;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.b bVar) {
        this.name = str;
        this.buX = mVar;
        this.bvd = fVar;
        this.bvw = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b NX() {
        return this.bvw;
    }

    public com.baidu.live.lottie.model.a.f NF() {
        return this.bvd;
    }

    public m<PointF, PointF> Ny() {
        return this.buX;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new n(hVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.buX + ", size=" + this.bvd + '}';
    }
}
