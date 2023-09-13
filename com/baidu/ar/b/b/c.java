package com.baidu.ar.b.b;

import com.baidu.ar.arplay.core.pixel.FramePixels;
/* loaded from: classes.dex */
public abstract class c<T> extends com.baidu.ar.c.a {
    public int cI;

    /* renamed from: cn  reason: collision with root package name */
    public FramePixels f1033cn;

    public c(int i, FramePixels framePixels) {
        this.cI = i;
        this.f1033cn = framePixels;
    }

    @Override // com.baidu.ar.c.a
    public T ay() {
        if (com.baidu.ar.b.a.as().c(this.cI)) {
            try {
                com.baidu.ar.b.a.as().a(this.cI, true);
                return e(this.f1033cn);
            } finally {
                com.baidu.ar.b.a.as().a(this.cI, false);
            }
        }
        return null;
    }

    public abstract T e(FramePixels framePixels);
}
