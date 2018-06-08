package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.GLES20;
/* loaded from: classes3.dex */
public class b extends g {
    protected float[] a;
    private float k;
    private int l;
    private int m;

    public b() {
        this(1.0f, (float[]) com.baidu.baiduarsdk.gpuimage.graphics.a.a.clone());
    }

    public b(float f, float[] fArr) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nuniform lowp mat4 colorMatrix;\nuniform lowp float intensity;\n\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp vec4 outputColor = textureColor * colorMatrix;\n    \n    gl_FragColor = (intensity * outputColor) + ((1.0 - intensity) * textureColor);\n}");
        this.k = f;
        this.a = fArr;
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.l = GLES20.glGetUniformLocation(h(), "colorMatrix");
        this.m = GLES20.glGetUniformLocation(h(), "intensity");
    }

    public void a(float f) {
        this.k = f;
        a(this.m, f);
    }

    public void a(final float[] fArr) {
        this.a = fArr;
        a(new Runnable() { // from class: com.baidu.baiduarsdk.gpuimage.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.c(b.this.l, fArr);
            }
        });
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void b() {
        super.b();
        a(this.k);
        a(this.a);
    }
}
