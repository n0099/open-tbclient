package com.baidu.ar.algo;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes12.dex */
public class a {
    private static a bS = new a();
    private static a bT;
    private static a bU;
    private float[] bV;
    private float[] bW;
    private boolean bX;
    public int height;
    private float scale;
    public int width;

    static {
        bS.width = PlatformPlugin.DEFAULT_SYSTEM_UI;
        bS.height = 720;
        bS.bX = true;
        bS.bV = new float[]{1110.8284f, 0.0f, 640.0f, 0.0f, 1111.2183f, 360.0f, 0.0f, 0.0f, 1.0f};
        bS.bW = new float[]{1.0E-5f, 0.0f, 0.0f, 0.0f, 0.0f};
        bT = new a();
        bT.width = 640;
        bT.height = 480;
        bS.bX = true;
        bT.bV = new float[]{594.25995f, 0.0f, 313.4141f, 0.0f, 594.826f, 237.53111f, 0.0f, 0.0f, 1.0f};
        bT.bW = new float[]{0.184825f, -0.433983f, -0.003168f, -0.010542f, 0.0f};
        bU = new a();
        bU.width = 640;
        bU.height = EncoderTextureDrawer.X264_WIDTH;
        bU.bX = true;
        bU.bV = new float[]{585.7661f, 0.0f, 310.29126f, 0.0f, 585.70685f, 174.72643f, 0.0f, 0.0f, 1.0f};
        bU.bW = new float[]{0.170531f, -0.380857f, -0.005316f, 0.011078f, 0.0f};
    }

    private a() {
        this.scale = 1.0f;
        this.bX = false;
    }

    public a(int i, int i2) {
        this.scale = 1.0f;
        this.bX = false;
        this.width = i;
        this.height = i2;
        this.scale = i > 640 ? 0.5f : 1.0f;
    }

    public static a a(int i, int i2, boolean z) {
        if (z) {
            a aVar = new a(i, i2);
            if (Math.abs((i / i2) - (bU.width / bU.height)) < 0.03d) {
                aVar.a(bU, i / bU.width);
                return aVar;
            }
            return aVar;
        }
        return b(i, i2);
    }

    private void a(a aVar, float f) {
        this.bV = new float[9];
        this.bW = new float[5];
        this.bX = true;
        for (int i = 0; i < 8; i++) {
            this.bV[i] = aVar.bV[i] * f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            this.bW[i2] = aVar.bW[i2];
        }
    }

    public static a b(int i, int i2) {
        a aVar = new a(i, i2);
        float f = i / i2;
        if (Math.abs(f - (bS.width / bS.height)) < 0.03d) {
            aVar.a(bS, i / bS.width);
        } else if (Math.abs(f - (bT.width / bT.height)) < 0.03d) {
            aVar.a(bT, i / bT.width);
        }
        return aVar;
    }

    public float[] ah() {
        return this.bV;
    }

    public float[] ai() {
        return this.bW;
    }

    public float getScale() {
        return 1.0f;
    }
}
