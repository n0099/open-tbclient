package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.GLES20;
/* loaded from: classes3.dex */
public class n extends g {
    private int a;
    private float k;

    public n() {
        this(1.0f);
    }

    public n(float f) {
        super("attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = position;    textureCoordinate = inputTextureCoordinate.xy;}", " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float saturation;\n \n // Values from \"Graphics Shaders: Theory and Practice\" by Bailey and Cunningham\n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n void main()\n {\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    lowp float luminance = dot(textureColor.rgb, luminanceWeighting);\n    lowp vec3 greyScaleColor = vec3(luminance);\n    \n    gl_FragColor = vec4(mix(greyScaleColor, textureColor.rgb, saturation), textureColor.w);\n     \n }");
        this.k = f;
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.a = GLES20.glGetUniformLocation(h(), "saturation");
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
