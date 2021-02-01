package com.baidu.ar.algo;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes6.dex */
public class a {
    private static a bV = new a();
    private static a bW;
    private static a bX;
    private float[] bY;
    private float[] bZ;
    private boolean ca;
    public int height;
    private float scale;
    public int width;

    static {
        bV.width = 1280;
        bV.height = 720;
        bV.ca = true;
        bV.bY = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        bV.bZ = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        bW = new a();
        bW.width = 640;
        bW.height = 480;
        bV.ca = true;
        bW.bY = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        bW.bZ = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        bX = new a();
        bX.width = 640;
        bX.height = EncoderTextureDrawer.X264_WIDTH;
        bX.ca = true;
        bX.bY = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        bX.bZ = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    private a() {
        this.scale = 1.0f;
        this.ca = false;
    }

    public a(int i, int i2) {
        this.scale = 1.0f;
        this.ca = false;
        this.width = i;
        this.height = i2;
        this.scale = i > 640 ? 0.5f : 1.0f;
    }

    public static a a(int i, int i2, boolean z) {
        if (z) {
            a aVar = new a(i, i2);
            if (Math.abs((i / i2) - (bX.width / bX.height)) < 0.03d) {
                aVar.a(bX, i / bX.width);
                return aVar;
            }
            return aVar;
        }
        return b(i, i2);
    }

    private void a(a aVar, float f) {
        this.bY = new float[9];
        this.bZ = new float[5];
        this.ca = true;
        for (int i = 0; i < 8; i++) {
            this.bY[i] = aVar.bY[i] * f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.bZ[i2] = aVar.bZ[i2];
        }
    }

    public static a b(int i, int i2) {
        a aVar = new a(i, i2);
        float f = i / i2;
        if (Math.abs(f - (bV.width / bV.height)) < 0.03d) {
            aVar.a(bV, i / bV.width);
        } else if (Math.abs(f - (bW.width / bW.height)) < 0.03d) {
            aVar.a(bW, i / bW.width);
        }
        return aVar;
    }

    public float[] aj() {
        return this.bY;
    }

    public float[] ak() {
        return this.bZ;
    }

    public float getScale() {
        return 1.0f;
    }
}
