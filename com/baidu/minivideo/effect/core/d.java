package com.baidu.minivideo.effect.core;

import android.opengl.GLES20;
import android.opengl.Matrix;
/* loaded from: classes11.dex */
public class d extends b {
    private int d;
    private int e;

    public d() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", "precision highp float;\n \nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform float alpha;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * alpha;\n}");
    }

    public d(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = uMVPMatrix * position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", str);
    }

    public d(String str, String str2) {
        super(str, str2);
        this.b = new float[16];
        this.c = new float[16];
        Matrix.setIdentityM(this.b, 0);
        Matrix.setIdentityM(this.c, 0);
    }

    public void a(float[] fArr) {
        this.b = fArr;
        g(this.d, fArr);
    }

    @Override // com.baidu.minivideo.effect.core.b
    public void b() {
        super.b();
        this.d = GLES20.glGetUniformLocation(n(), "uMVPMatrix");
        this.e = GLES20.glGetUniformLocation(n(), "uTexMatrix");
    }

    public void b(float[] fArr) {
        this.c = fArr;
        g(this.e, fArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.minivideo.effect.core.b
    public void c() {
        super.c();
        a(this.b);
        b(this.c);
    }

    @Override // com.baidu.minivideo.effect.core.b
    protected int g() {
        return this.d;
    }
}
