package com.baidu.ar.recorder.c;

import com.baidu.ar.recorder.e.d;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class a extends com.baidu.ar.recorder.e.a {
    private static final float[] g = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] h = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer i = d.a(g);
    private static final FloatBuffer j = d.a(h);

    public a() {
        this.a = i;
        this.b = j;
        this.d = 2;
        this.e = this.d * 4;
        this.c = g.length / this.d;
        this.f = 8;
    }
}
