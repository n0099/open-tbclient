package com.baidu.live.lottie.model.content;

import android.graphics.PointF;
import com.baidu.live.lottie.model.a.m;
/* loaded from: classes9.dex */
public class a implements b {
    private final boolean FD;
    private final m<PointF, PointF> bpU;
    private final com.baidu.live.lottie.model.a.f bqa;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.baidu.live.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.bpU = mVar;
        this.bqa = fVar;
        this.FD = z;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.e(hVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> LX() {
        return this.bpU;
    }

    public com.baidu.live.lottie.model.a.f Me() {
        return this.bqa;
    }

    public boolean isReversed() {
        return this.FD;
    }
}
