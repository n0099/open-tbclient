package com.baidu.ar.algo.a.b;
/* loaded from: classes3.dex */
public class a {
    private static a c = new a();
    private static a d;
    private static a e;
    int a;
    int b;
    private float f;
    private float[] g;
    private float[] h;
    private boolean i;

    static {
        c.a = 1280;
        c.b = 720;
        c.i = true;
        c.g = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        c.h = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        d = new a();
        d.a = 640;
        d.b = 480;
        c.i = true;
        d.g = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        d.h = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        e = new a();
        e.a = 640;
        e.b = 360;
        e.i = true;
        e.g = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        e.h = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    private a() {
        this.f = 1.0f;
        this.i = false;
    }

    public a(int i, int i2) {
        this.f = 1.0f;
        this.i = false;
        this.a = i;
        this.b = i2;
        this.f = i > 640 ? 0.5f : 1.0f;
    }

    public static a a(int i, int i2) {
        a aVar = new a(i, i2);
        float f = i / i2;
        if (Math.abs(f - (c.a / c.b)) < 0.03d) {
            aVar.a(c, i / c.a);
        } else if (Math.abs(f - (d.a / d.b)) < 0.03d) {
            aVar.a(d, i / d.a);
        }
        return aVar;
    }

    public static a a(int i, int i2, boolean z) {
        if (z) {
            a aVar = new a(i, i2);
            if (Math.abs((i / i2) - (e.a / e.b)) < 0.03d) {
                aVar.a(e, i / e.a);
                return aVar;
            }
            return aVar;
        }
        return a(i, i2);
    }

    private void a(a aVar, float f) {
        this.g = new float[9];
        this.h = new float[5];
        this.i = true;
        for (int i = 0; i < 8; i++) {
            this.g[i] = aVar.g[i] * f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.h[i2] = aVar.h[i2];
        }
    }

    public float a() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] c() {
        return this.h;
    }
}
