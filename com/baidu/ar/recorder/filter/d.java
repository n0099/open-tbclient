package com.baidu.ar.recorder.filter;

import android.content.Context;
/* loaded from: classes3.dex */
public class d extends b {
    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.ar.recorder.filter.b, com.baidu.ar.recorder.filter.a
    protected int a(Context context) {
        return com.baidu.ar.recorder.c.d.a("uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nuniform mat4 uTexMatrix;  // Texture 的变换矩阵 （只对texture变形）\n\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\n\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;//fragment中没有默认的浮点数精度修饰符。因此，对于浮点数，浮点数向量和矩阵变量声明，必须声明包含一个精度修饰符。\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
    }

    @Override // com.baidu.ar.recorder.filter.b, com.baidu.ar.recorder.filter.c
    public int f() {
        return 3553;
    }
}
