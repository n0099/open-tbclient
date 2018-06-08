package com.baidu.ar.draw;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
/* loaded from: classes3.dex */
public class a {
    private static float[] k = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
    private static float[] l = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private FloatBuffer c;
    private FloatBuffer d;
    private ShortBuffer e;
    private final int f;
    private int g;
    private int h;
    private int m;
    private int n;
    private final String a = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}";
    private final String b = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";
    private short[] i = {0, 1, 2, 0, 2, 3};
    private final int j = 8;

    public a(int i, int i2, boolean z) {
        this.m = i;
        this.n = i2;
        a(z);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(k.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.c = allocateDirect.asFloatBuffer();
        this.c.put(k);
        this.c.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.i.length * 2);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.e = allocateDirect2.asShortBuffer();
        this.e.put(this.i);
        this.e.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(l.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.d = allocateDirect3.asFloatBuffer();
        this.d.put(l);
        this.d.position(0);
        int a = a(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition;textureCoordinate = inputTextureCoordinate;}");
        int a2 = a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}");
        this.f = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f, a);
        GLES20.glAttachShader(this.f, a2);
        GLES20.glLinkProgram(this.f);
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public void a(boolean z) {
        if (z) {
            k = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
        } else {
            k = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        }
    }

    public void a(float[] fArr) {
        GLES20.glUseProgram(this.f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.n, this.m);
        this.g = GLES20.glGetAttribLocation(this.f, "vPosition");
        GLES20.glEnableVertexAttribArray(this.g);
        GLES20.glVertexAttribPointer(this.g, 2, 5126, false, 8, (Buffer) this.c);
        this.h = GLES20.glGetAttribLocation(this.f, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(this.h);
        GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 8, (Buffer) this.d);
        GLES20.glDrawElements(4, this.i.length, 5123, this.e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glDisableVertexAttribArray(this.h);
    }
}
