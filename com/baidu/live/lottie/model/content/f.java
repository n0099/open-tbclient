package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.a.a.n;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes10.dex */
public class f implements b {
    private final com.baidu.live.lottie.model.a.f btC;
    private final com.baidu.live.lottie.model.a.b btV;
    private final m<PointF, PointF> btw;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.f fVar, com.baidu.live.lottie.model.a.b bVar) {
        this.name = str;
        this.btw = mVar;
        this.btC = fVar;
        this.btV = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.baidu.live.lottie.model.a.b NU() {
        return this.btV;
    }

    public com.baidu.live.lottie.model.a.f NC() {
        return this.btC;
    }

    public m<PointF, PointF> Nv() {
        return this.btw;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new n(hVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.btw + ", size=" + this.btC + '}';
    }
}
