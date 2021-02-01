package com.baidu.ar.b.b;

import com.baidu.ar.arplay.core.pixel.FramePixels;
/* loaded from: classes6.dex */
public abstract class c<T> extends com.baidu.ar.c.a {
    private int cI;

    /* renamed from: cn  reason: collision with root package name */
    FramePixels f1489cn;

    public c(int i, FramePixels framePixels) {
        this.cI = i;
        this.f1489cn = framePixels;
    }

    @Override // com.baidu.ar.c.a
    public T ay() {
        if (com.baidu.ar.b.a.as().c(this.cI)) {
            try {
                com.baidu.ar.b.a.as().a(this.cI, true);
                return e(this.f1489cn);
            } finally {
                com.baidu.ar.b.a.as().a(this.cI, false);
            }
        }
        return null;
    }

    public abstract T e(FramePixels framePixels);
}
