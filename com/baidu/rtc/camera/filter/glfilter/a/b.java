package com.baidu.rtc.camera.filter.glfilter.a;

import android.content.Context;
import android.opengl.GLES30;
/* loaded from: classes6.dex */
public class b extends a {
    private int aXn;
    private float[] aXo;

    public b(Context context) {
        this(context, "uniform mat4 transformMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = aPosition;\n    textureCoordinate = (transformMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES inputTexture;\nvoid main() {\n    gl_FragColor = texture2D(inputTexture, textureCoordinate);\n}                                                          \n");
    }

    public b(Context context, String str, String str2) {
        super(context, str, str2);
    }

    @Override // com.baidu.rtc.camera.filter.glfilter.a.a
    public void FG() {
        super.FG();
        this.aXn = GLES30.glGetUniformLocation(this.mProgramHandle, "transformMatrix");
    }

    @Override // com.baidu.rtc.camera.filter.glfilter.a.a
    public int FK() {
        return 36197;
    }

    @Override // com.baidu.rtc.camera.filter.glfilter.a.a
    public void FH() {
        super.FH();
        GLES30.glUniformMatrix4fv(this.aXn, 1, false, this.aXo, 0);
    }

    public void h(float[] fArr) {
        this.aXo = fArr;
    }
}
