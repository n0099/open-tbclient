package com.baidu.baiduarsdk.gpuimage.a;
/* loaded from: classes3.dex */
public class f extends g {
    public f() {
        super("uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}\n");
        this.f = 36197;
    }
}
