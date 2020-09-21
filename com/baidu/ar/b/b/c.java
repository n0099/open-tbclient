package com.baidu.ar.b.b;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
/* loaded from: classes10.dex */
public abstract class c<T> extends com.baidu.ar.c.a {
    private int cD;
    FramePixels cj;

    public c(int i, FramePixels framePixels) {
        this.cD = i;
        this.cj = framePixels;
    }

    @Override // com.baidu.ar.c.a
    public T ax() {
        if (com.baidu.ar.b.a.ar().b(this.cD)) {
            try {
                com.baidu.ar.b.a.ar().a(this.cD, true);
                return f(this.cj);
            } finally {
                com.baidu.ar.b.a.ar().a(this.cD, false);
            }
        }
        return null;
    }

    public abstract T f(FramePixels framePixels);
}
