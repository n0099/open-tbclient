package com.baidu.ar.opengl.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.ar.util.Constants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public final class a {
    private static float[] l = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static float[] o = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    int a;
    int b;
    private int j;
    private int p;
    private int r;
    private boolean g = false;
    int c = -1;
    int d = -1;
    private int h = -1;
    private int i = -1;
    private int[] k = {-1, -1};
    public ByteBuffer[] e = null;
    private final FloatBuffer m = a(l);
    private final float[] q = new float[16];
    private final float[] s = new float[16];
    int f = -1;
    private float[] t = {1.0f, 1.0f, 1.0f, 1.4f, -0.711f, 0.0f, 0.0f, -0.343f, 1.765f};
    private FloatBuffer n = a(o);

    private a() {
        Matrix.setIdentityM(this.q, 0);
        Matrix.setIdentityM(this.s, 0);
    }

    private int a(String str, String str2) {
        int b = b(35633, str);
        int b2 = b(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            throw new RuntimeException("Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, b);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, b2);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            f();
            return glCreateProgram;
        }
        Log.e("GLCameraDrawer", "Could not link program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
        String glGetProgramInfoLog = GLES20.glGetProgramInfoLog(glCreateProgram);
        GLES20.glDeleteProgram(glCreateProgram);
        throw new RuntimeException(glGetProgramInfoLog);
    }

    public static a a() {
        Log.d("GLCameraDrawer", "VideoRendererGui.newInstance");
        return new a();
    }

    private static FloatBuffer a(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.flip();
        return asFloatBuffer;
    }

    private void a(String str) {
    }

    private void a(boolean z) {
        try {
            b();
            GLES20.glUseProgram(this.j);
            a("glUseProgram");
            GLES20.glUniformMatrix4fv(this.p, 1, false, this.q, 0);
            GLES20.glUniformMatrix4fv(this.r, 1, false, this.s, 0);
            GLES20.glEnableVertexAttribArray(this.a);
            GLES20.glVertexAttribPointer(this.a, 2, 5126, false, 8, (Buffer) this.n);
            a("glVertexAttribPointer mPosLocationHandle");
            GLES20.glEnableVertexAttribArray(this.b);
            GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 8, (Buffer) this.m);
            a("glVertexAttribPointer mTexLocationHandle");
            int length = this.k.length;
            int i = 0;
            while (i < length) {
                int i2 = i == 0 ? this.h : this.h / 2;
                int i3 = i == 0 ? this.i : this.i / 2;
                GLES20.glActiveTexture(33984 + i);
                a("glActiveTexture");
                GLES20.glBindTexture(3553, this.k[i]);
                a("glBindTexture");
                if (z) {
                    if (i == 0) {
                        GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, 6409, 5121, this.e[i]);
                    } else {
                        GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, 6410, 5121, this.e[i]);
                    }
                }
                int i4 = -1;
                switch (i) {
                    case 0:
                        i4 = this.c;
                        break;
                    case 1:
                        i4 = this.d;
                        break;
                }
                if (a(i4, "handle num = " + i)) {
                    GLES20.glUniform1i(i4, i);
                    a("glUniform1i handle(" + i + ")");
                }
                i++;
            }
            GLES20.glDrawArrays(5, 0, 4);
            a("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.a);
            a("glDisableVertexAttribArray mPosLocationHandle");
            GLES20.glDisableVertexAttribArray(this.b);
            a("glDisableVertexAttribArray mTexLocationHandle");
            d();
            f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int b(int i, String str) {
        int[] iArr = {0};
        int glCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader");
        GLES20.glShaderSource(glCreateShader, str);
        a("glShaderSource");
        GLES20.glCompileShader(glCreateShader);
        a("glCompileShader");
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("GLCameraDrawer", "Could not compile shader " + i + ":" + GLES20.glGetShaderInfoLog(glCreateShader));
            throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
        }
        f();
        return glCreateShader;
    }

    private void c(int i, int i2, byte[] bArr) {
        long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0L;
        int i3 = i * i2;
        if (this.e == null) {
            this.e = new ByteBuffer[2];
        }
        if (this.e[0] == null || this.e[0].capacity() != i3) {
            this.e[0] = ByteBuffer.allocateDirect(i3);
        }
        if (this.e[1] == null || this.e[1].capacity() != i3 / 2) {
            this.e[1] = ByteBuffer.allocateDirect(i3 / 2);
        }
        com.baidu.ar.util.b.a("data size = " + bArr.length + ", yuvPlane[0] size = " + this.e[0].capacity());
        if (Constants.DEBUG_PREVIEW_FRAME) {
            com.baidu.ar.util.b.d("bdar: before splitYUV y time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.e[0].put(bArr, 0, i3);
        if (Constants.DEBUG_PREVIEW_FRAME) {
            com.baidu.ar.util.b.d("bdar: splitYUV y time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.e[1].put(bArr, i3, i3 / 2);
        if (Constants.DEBUG_PREVIEW_FRAME) {
            com.baidu.ar.util.b.d("bdar: splitYUV u time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        this.e[0].position(0);
        this.e[1].position(0);
    }

    private void e() {
        int length = this.k.length;
        int i = 0;
        while (i < length) {
            int i2 = i == 0 ? this.h : this.h / 2;
            int i3 = i == 0 ? this.i : this.i / 2;
            a("glActiveTexture");
            GLES20.glBindTexture(3553, this.k[i]);
            a("glBindTexture");
            if (i == 0) {
                GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, 6409, 5121, this.e[i]);
            } else {
                GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, 6410, 5121, this.e[i]);
            }
            a("glTexImage2D");
            i++;
        }
        d();
        f();
    }

    private static void f() {
        GLES20.glGetError();
    }

    public void a(float f) {
        if (Float.compare(f, 1.0f) < 0) {
            float f2 = (1.0f - f) / 2.0f;
            float[] fArr = new float[l.length];
            System.arraycopy(l, 0, fArr, 0, l.length);
            fArr[0] = f2;
            fArr[2] = 1.0f - f2;
            fArr[4] = f2;
            fArr[6] = 1.0f - f2;
            this.m.put(fArr, 0, fArr.length);
            this.m.position(0);
        }
    }

    public void a(int i, float f, float f2, float f3) {
        Matrix.setIdentityM(this.q, 0);
        if (i == 1) {
            Matrix.rotateM(this.q, 0, 180.0f, 0.0f, 1.0f, 0.0f);
        } else if (i == 2) {
            Matrix.rotateM(this.q, 0, 180.0f, 1.0f, 0.0f, 0.0f);
        }
        Matrix.rotateM(this.q, 0, f, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(this.q, 0, f2, f3, 1.0f);
    }

    public void a(int i, int i2) {
        long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0L;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        b(i, i2);
        if (Constants.DEBUG_PREVIEW_FRAME) {
            com.baidu.ar.util.b.d("bdar: on buildTextures time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
        a(false);
        if (Constants.DEBUG_PREVIEW_FRAME) {
            com.baidu.ar.util.b.d("bdar: on draw time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void a(int i, int i2, byte[] bArr) {
        long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0L;
        if (bArr != null && i > 0 && i2 > 0) {
            com.baidu.ar.util.b.a("data.size = " + bArr.length);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: before spliteYUV time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            c(i, i2, bArr);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: on spliteYUV time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            b(i, i2);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: on buildTextures time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            a(true);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: on draw time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public boolean a(int i, String str) {
        if (i >= 0) {
            return true;
        }
        if (str != null) {
            com.baidu.ar.util.b.d("[" + getClass().getCanonicalName() + "] Trying to set " + str + " without a valid handle.");
        }
        return false;
    }

    public void b() {
        if (this.g) {
            return;
        }
        this.j = a("uniform mat4 uMVPMatrix;  // MVP 的变换矩阵（整体变形）\nvarying vec2 textureCoordinate;\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 uTexMatrix;\n\nvoid main() {\n  gl_Position = uMVPMatrix * vec4(position.x,position.y,0.0,1.0);\n  textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}\n", "#ifdef GL_ES\nprecision highp float;\n#endif\nvarying vec2 textureCoordinate;\nuniform sampler2D luminanceTexture;\nuniform sampler2D chrominanceTexture;\nvoid main (void){\n   float r, g, b, y, u, v;\n   y = texture2D(luminanceTexture, textureCoordinate).r;\n   u = texture2D(chrominanceTexture, textureCoordinate).a - 0.5;\n   v = texture2D(chrominanceTexture, textureCoordinate).r - 0.5;\n   r = y + 1.13983*v;\n   g = y - 0.39465*u - 0.58060*v;\n   b = y + 2.03211*u;\n   gl_FragColor = vec4(r, g, b, 1.0);\n}\n");
        this.a = GLES20.glGetAttribLocation(this.j, "position");
        a("glGetAttribLocation position");
        if (this.a == -1) {
            throw new RuntimeException("Could not get attrib location for position");
        }
        this.b = GLES20.glGetAttribLocation(this.j, "inputTextureCoordinate");
        a("glGetAttribLocation inputTextureCoordinate");
        if (this.b == -1) {
            throw new RuntimeException("Could not get attrib location for inputTextureCoordinate");
        }
        this.c = GLES20.glGetUniformLocation(this.j, "luminanceTexture");
        a("glGetUniformLocation luminanceTexture");
        if (this.c == -1) {
            throw new RuntimeException("Could not get uniform location for luminanceTexture");
        }
        this.d = GLES20.glGetUniformLocation(this.j, "chrominanceTexture");
        a("glGetUniformLocation chrominanceTexture");
        if (this.d == -1) {
            throw new RuntimeException("Could not get uniform location for chrominanceTexture");
        }
        this.p = GLES20.glGetUniformLocation(this.j, "uMVPMatrix");
        a("glGetUniformLocation mMVPMatrixLoc");
        if (this.p == -1) {
            throw new RuntimeException("Could not get uniform location for mMVPMatrixLoc");
        }
        this.r = GLES20.glGetUniformLocation(this.j, "uTexMatrix");
        a("glGetUniformLocation mTextureMatrixLoc");
        if (this.r == -1) {
            throw new RuntimeException("Could not get uniform location for uTexMatrix");
        }
        this.g = true;
    }

    public void b(float f) {
        if (Float.compare(f, 1.0f) < 0) {
            float f2 = (1.0f - f) / 2.0f;
            float[] fArr = new float[l.length];
            System.arraycopy(l, 0, fArr, 0, l.length);
            fArr[1] = f2;
            fArr[3] = f2;
            fArr[5] = 1.0f - f2;
            fArr[7] = 1.0f - f2;
            this.m.put(fArr, 0, fArr.length);
            this.m.position(0);
        }
    }

    public void b(int i, int i2) {
        boolean z = (i == this.h && i2 == this.i) ? false : true;
        if (z) {
            this.h = i;
            this.i = i2;
            com.baidu.ar.util.b.a("buildTextures videoSizeChanged: w=" + this.h + " h=" + this.i);
        }
        int length = this.k.length;
        int i3 = 0;
        while (i3 < length) {
            if (this.k[i3] < 0 || z) {
                if (this.k[i3] >= 0) {
                    com.baidu.ar.util.b.a("glDeleteTextures id");
                    GLES20.glDeleteTextures(1, new int[]{this.k[i3]}, 0);
                    a("glDeleteTextures");
                }
                int i4 = i3 == 0 ? this.h : this.h / 2;
                int i5 = i3 == 0 ? this.i : this.i / 2;
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                a("glGenTextures");
                this.k[i3] = iArr[0];
                com.baidu.ar.util.b.a("glGenTextures id = " + this.k[i3]);
                Log.d("rendayun", "glGenTextures id = " + this.k[i3] + ", textures[0] = " + iArr[0]);
                a("glActiveTexture");
                GLES20.glBindTexture(3553, this.k[i3]);
                a("glBindTexture");
                if (i3 == 0) {
                    GLES20.glTexImage2D(3553, 0, 6409, i4, i5, 0, 6409, 5121, null);
                } else {
                    GLES20.glTexImage2D(3553, 0, 6410, i4, i5, 0, 6410, 5121, null);
                }
                a("glTexImage2D");
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glBindTexture(3553, 0);
            }
            i3++;
        }
    }

    public void b(int i, int i2, byte[] bArr) {
        long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0L;
        if (bArr != null && i > 0 && i2 > 0) {
            com.baidu.ar.util.b.a("data.size = " + bArr.length);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: before spliteYUV time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            c(i, i2, bArr);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: on spliteYUV time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
            e();
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: on draw time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public void c() {
        com.baidu.ar.util.b.a("reset");
        GLES20.glDeleteProgram(this.j);
        this.h = 0;
        this.i = 0;
        int length = this.k.length;
        for (int i = 0; i < length; i++) {
            if (this.k[i] >= 0) {
                com.baidu.ar.util.b.a("glDeleteTextures id");
                GLES20.glDeleteTextures(1, new int[]{this.k[i]}, 0);
                a("glDeleteTextures");
            }
            this.k[i] = -1;
        }
        this.g = false;
    }

    public void d() {
        int length = this.k.length;
        for (int i = 0; i < length; i++) {
            GLES20.glBindTexture(3553, 0);
        }
    }
}
