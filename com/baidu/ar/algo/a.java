package com.baidu.ar.algo;
/* loaded from: classes3.dex */
public class a {
    private static a bO = new a();
    private static a bP;
    private static a bQ;
    private float[] bR;
    private float[] bS;
    private boolean bT;
    public int height;
    private float scale;
    public int width;

    static {
        bO.width = 1280;
        bO.height = 720;
        bO.bT = true;
        bO.bR = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        bO.bS = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        bP = new a();
        bP.width = 640;
        bP.height = 480;
        bO.bT = true;
        bP.bR = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        bP.bS = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        bQ = new a();
        bQ.width = 640;
        bQ.height = 360;
        bQ.bT = true;
        bQ.bR = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        bQ.bS = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    private a() {
        this.scale = 1.0f;
        this.bT = false;
    }

    public a(int i, int i2) {
        this.scale = 1.0f;
        this.bT = false;
        this.width = i;
        this.height = i2;
        this.scale = i > 640 ? 0.5f : 1.0f;
    }

    public static a a(int i, int i2, boolean z) {
        if (z) {
            a aVar = new a(i, i2);
            if (Math.abs((i / i2) - (bQ.width / bQ.height)) < 0.03d) {
                aVar.a(bQ, i / bQ.width);
                return aVar;
            }
            return aVar;
        }
        return b(i, i2);
    }

    private void a(a aVar, float f) {
        this.bR = new float[9];
        this.bS = new float[5];
        this.bT = true;
        for (int i = 0; i < 8; i++) {
            this.bR[i] = aVar.bR[i] * f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.bS[i2] = aVar.bS[i2];
        }
    }

    public static a b(int i, int i2) {
        a aVar = new a(i, i2);
        float f = i / i2;
        if (Math.abs(f - (bO.width / bO.height)) < 0.03d) {
            aVar.a(bO, i / bO.width);
        } else if (Math.abs(f - (bP.width / bP.height)) < 0.03d) {
            aVar.a(bP, i / bP.width);
        }
        return aVar;
    }

    public float[] T() {
        return this.bR;
    }

    public float[] U() {
        return this.bS;
    }

    public float getScale() {
        return 1.0f;
    }
}
