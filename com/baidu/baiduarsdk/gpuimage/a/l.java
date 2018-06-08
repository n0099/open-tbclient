package com.baidu.baiduarsdk.gpuimage.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
/* loaded from: classes3.dex */
public class l extends r {
    private int l;
    private int m;
    private int n;
    private float o;
    private float p;
    private float q;

    public l() {
        this(64.0f, 512.0f, 512.0f);
    }

    public l(float f, float f2, float f3) {
        super(" precision highp float;\n varying highp vec2 textureCoordinate;\n varying highp vec2 textureCoordinate2; // TODO: This is not used\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n uniform float lut_width;\n uniform float lut_height;\n uniform float dimension;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     float lut_row = lut_height / dimension;\n     float lut_col = lut_width / dimension;\n     float blueColor = textureColor.b * lut_row * lut_col;\n     \n     vec2 quad1;\n     quad1.y = floor(floor(blueColor) / lut_col);\n     quad1.x = floor(blueColor) - (quad1.y * lut_row);\n     \n     vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / lut_col);\n     quad2.x = ceil(blueColor) - (quad2.y * lut_row);\n     \n     vec2 texPos1;\n     float colorIndex = lut_row * lut_col - 1.0;\n     \n     texPos1.x = (quad1.x * dimension + 0.5 + textureColor.r * colorIndex) / lut_width;\n     texPos1.y = (quad1.y * dimension + 0.5 + textureColor.g * colorIndex) / lut_height;\n     \n     vec2 texPos2;\n     texPos2.x = (quad2.x * dimension + 0.5 + textureColor.r * colorIndex) / lut_width;\n     texPos2.y = (quad2.y * dimension + 0.5 + textureColor.g * colorIndex) / lut_height;\n     \n     lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n     lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n     \n     lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     gl_FragColor = vec4(newColor.rgb, textureColor.a);\n }");
        this.o = f;
        this.p = f2;
        this.q = f3;
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.r, com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.l = GLES20.glGetUniformLocation(h(), "dimension");
        this.m = GLES20.glGetUniformLocation(h(), "lut_width");
        this.n = GLES20.glGetUniformLocation(h(), "lut_height");
    }

    public void a(float f) {
        this.o = f;
        a(this.l, this.o);
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.r
    public void a(Bitmap bitmap) {
        super.a(bitmap);
        if (this.a == null || this.a.isRecycled()) {
            return;
        }
        b(this.a.getWidth());
        c(this.a.getHeight());
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.r, com.baidu.baiduarsdk.gpuimage.a.g
    public void b() {
        super.b();
        a(this.o);
        b(this.p);
        c(this.q);
    }

    public void b(float f) {
        this.p = f;
        a(this.m, this.p);
    }

    public void c(float f) {
        this.q = f;
        a(this.n, this.q);
    }
}
