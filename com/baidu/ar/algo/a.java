package com.baidu.ar.algo;

import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes11.dex */
public class a {
    private static a cb = new a();
    private static a cc;
    private static a cd;
    private float[] ce;
    private float[] cf;
    private boolean cg;
    public int height;
    private float scale;
    public int width;

    static {
        cb.width = PlatformPlugin.DEFAULT_SYSTEM_UI;
        cb.height = 720;
        cb.cg = true;
        cb.ce = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        cb.cf = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        cc = new a();
        cc.width = 640;
        cc.height = 480;
        cb.cg = true;
        cc.ce = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        cc.cf = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        cd = new a();
        cd.width = 640;
        cd.height = 360;
        cd.cg = true;
        cd.ce = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        cd.cf = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    private a() {
        this.scale = 1.0f;
        this.cg = false;
    }

    public a(int i, int i2) {
        this.scale = 1.0f;
        this.cg = false;
        this.width = i;
        this.height = i2;
        this.scale = i > 640 ? 0.5f : 1.0f;
    }

    public static a a(int i, int i2, boolean z) {
        if (z) {
            a aVar = new a(i, i2);
            if (Math.abs((i / i2) - (cd.width / cd.height)) < 0.03d) {
                aVar.a(cd, i / cd.width);
                return aVar;
            }
            return aVar;
        }
        return b(i, i2);
    }

    private void a(a aVar, float f) {
        this.ce = new float[9];
        this.cf = new float[5];
        this.cg = true;
        for (int i = 0; i < 8; i++) {
            this.ce[i] = aVar.ce[i] * f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.cf[i2] = aVar.cf[i2];
        }
    }

    public static a b(int i, int i2) {
        a aVar = new a(i, i2);
        float f = i / i2;
        if (Math.abs(f - (cb.width / cb.height)) < 0.03d) {
            aVar.a(cb, i / cb.width);
        } else if (Math.abs(f - (cc.width / cc.height)) < 0.03d) {
            aVar.a(cc, i / cc.width);
        }
        return aVar;
    }

    public float[] ah() {
        return this.ce;
    }

    public float[] ai() {
        return this.cf;
    }

    public float getScale() {
        return 1.0f;
    }
}
