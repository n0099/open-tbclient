package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.GLES20;
/* loaded from: classes3.dex */
public class c extends g {
    private int a;
    private float k;

    public c() {
        this(1.2f);
    }

    public c(float f) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float contrast;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(((textureColor.rgb - vec3(0.5)) * contrast + vec3(0.5)), textureColor.w);\n }");
        this.k = f;
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.a = GLES20.glGetUniformLocation(h(), "contrast");
    }

    public void a(float f) {
        this.k = f;
        a(this.a, this.k);
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void b() {
        super.b();
        a(this.k);
    }
}
