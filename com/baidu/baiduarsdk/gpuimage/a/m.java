package com.baidu.baiduarsdk.gpuimage.a;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes3.dex */
public class m extends g {
    private static final float[] q = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    int a;
    int k;
    public ByteBuffer[] l;
    private FloatBuffer m;
    private int[] n;
    private int o;
    private int p;

    public m() {
        super("uniform mat4 uMVPMatrix;uniform mat4 uTexMatrix;attribute vec4 position;attribute vec4 inputTextureCoordinate;varying vec2 textureCoordinate;void main() {    gl_Position = uMVPMatrix * position;    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;}", "#ifdef GL_ES\nprecision highp float;\n#endif\nvarying vec2 textureCoordinate;\nuniform sampler2D luminanceTexture;\nuniform sampler2D chrominanceTexture;\nvoid main (void){\n   float r, g, b, y, u, v;\n   y = texture2D(luminanceTexture, textureCoordinate).r;\n   u = texture2D(chrominanceTexture, textureCoordinate).a - 0.5;\n   v = texture2D(chrominanceTexture, textureCoordinate).r - 0.5;\n   r = y + 1.13983*v;\n   g = y - 0.39465*u - 0.58060*v;\n   b = y + 2.03211*u;\n   gl_FragColor = vec4(r, g, b, 1.0);\n}\n");
        this.a = -1;
        this.k = -1;
        this.n = new int[]{-1, -1};
        this.l = null;
        this.o = -1;
        this.p = -1;
        this.m = com.baidu.baiduarsdk.gpuimage.graphics.a.a(q);
    }

    private void a(boolean z) {
        GLES20.glUseProgram(h());
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glUseProgram");
        GLES20.glUniformMatrix4fv(this.d, 1, false, this.g, 0);
        GLES20.glUniformMatrix4fv(this.e, 1, false, this.h, 0);
        GLES20.glEnableVertexAttribArray(i());
        GLES20.glVertexAttribPointer(i(), 2, 5126, false, 8, (Buffer) this.b.a());
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glVertexAttribPointer mPosLocationHandle");
        GLES20.glEnableVertexAttribArray(j());
        GLES20.glVertexAttribPointer(j(), 2, 5126, false, 8, (Buffer) this.m);
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glVertexAttribPointer mTexLocationHandle");
        int length = this.n.length;
        int i = 0;
        while (i < length) {
            int i2 = i == 0 ? this.o : this.o / 2;
            int i3 = i == 0 ? this.p : this.p / 2;
            GLES20.glActiveTexture(33984 + i);
            com.baidu.baiduarsdk.gpuimage.graphics.a.a("glActiveTexture");
            GLES20.glBindTexture(3553, this.n[i]);
            com.baidu.baiduarsdk.gpuimage.graphics.a.a("glBindTexture");
            if (z) {
                if (i == 0) {
                    GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, 6409, 5121, this.l[i]);
                } else {
                    GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, 6410, 5121, this.l[i]);
                }
            }
            int i4 = -1;
            switch (i) {
                case 0:
                    i4 = this.a;
                    break;
                case 1:
                    i4 = this.k;
                    break;
            }
            if (a(i4, "handle num = " + i)) {
                GLES20.glUniform1i(i4, i);
                com.baidu.baiduarsdk.gpuimage.graphics.a.a("glUniform1i handle(" + i + ")");
            }
            i++;
        }
        GLES20.glDrawArrays(5, 0, 4);
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glDrawArrays");
        GLES20.glDisableVertexAttribArray(i());
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glDisableVertexAttribArray mPosLocationHandle");
        GLES20.glDisableVertexAttribArray(j());
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("glDisableVertexAttribArray mTexLocationHandle");
        GLES20.glUseProgram(0);
        l();
    }

    private boolean a(int i, String str) {
        if (i >= 0) {
            return true;
        }
        if (str != null) {
            Log.e("GPUImageNV212RGBAFilter", "[" + getClass().getCanonicalName() + "] Trying to set " + str + " without a valid handle.");
        }
        return false;
    }

    private void c(int i, int i2) {
        boolean z = (i == this.o && i2 == this.p) ? false : true;
        if (z) {
            this.o = i;
            this.p = i2;
            Log.d("GPUImageNV212RGBAFilter", "buildTextures videoSizeChanged: w=" + this.o + " h=" + this.p);
        }
        int length = this.n.length;
        int i3 = 0;
        while (i3 < length) {
            if (this.n[i3] < 0 || z) {
                if (this.n[i3] >= 0) {
                    Log.d("GPUImageNV212RGBAFilter", "glDeleteTextures id");
                    GLES20.glDeleteTextures(1, new int[]{this.n[i3]}, 0);
                    com.baidu.baiduarsdk.gpuimage.graphics.a.a("glDeleteTextures");
                }
                int i4 = i3 == 0 ? this.o : this.o / 2;
                int i5 = i3 == 0 ? this.p : this.p / 2;
                int[] iArr = new int[1];
                GLES20.glGenTextures(1, iArr, 0);
                com.baidu.baiduarsdk.gpuimage.graphics.a.a("glGenTextures");
                this.n[i3] = iArr[0];
                Log.d("GPUImageNV212RGBAFilter", "glGenTextures id = " + this.n[i3]);
                Log.d("rendayun", "glGenTextures id = " + this.n[i3] + ", textures[0] = " + iArr[0]);
                com.baidu.baiduarsdk.gpuimage.graphics.a.a("glActiveTexture");
                GLES20.glBindTexture(3553, this.n[i3]);
                com.baidu.baiduarsdk.gpuimage.graphics.a.a("glBindTexture");
                if (i3 == 0) {
                    GLES20.glTexImage2D(3553, 0, 6409, i4, i5, 0, 6409, 5121, null);
                } else {
                    GLES20.glTexImage2D(3553, 0, 6410, i4, i5, 0, 6410, 5121, null);
                }
                com.baidu.baiduarsdk.gpuimage.graphics.a.a("glTexImage2D");
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GLES20.glBindTexture(3553, 0);
            }
            i3++;
        }
    }

    private void k() {
        c(this.o, this.p);
        a(true);
    }

    private void l() {
        int length = this.n.length;
        for (int i = 0; i < length; i++) {
            GLES20.glBindTexture(3553, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a() {
        super.a();
        this.a = GLES20.glGetUniformLocation(h(), "luminanceTexture");
        com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.a, "luminanceTexture");
        this.k = GLES20.glGetUniformLocation(h(), "chrominanceTexture");
        com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.k, "chrominanceTexture");
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void a(int i, int i2) {
        if (this.i == i && this.j == i2) {
            return;
        }
        super.a(i, i2);
    }

    public void a(int i, int i2, byte[] bArr) {
        if (bArr != null && i > 0 && i2 > 0) {
            Log.d("GPUImageNV212RGBAFilter", "data.size = " + bArr.length);
            int i3 = i * i2;
            if (this.l == null) {
                this.l = new ByteBuffer[2];
            }
            if (this.l[0] == null || this.l[0].capacity() != i3) {
                this.l[0] = ByteBuffer.allocateDirect(i3);
            }
            if (this.l[1] == null || this.l[1].capacity() != i3 / 2) {
                this.l[1] = ByteBuffer.allocateDirect(i3 / 2);
            }
            Log.d("GPUImageNV212RGBAFilter", "data size = " + bArr.length + ", yuvPlane[0] size = " + this.l[0].capacity());
            this.l[0].put(bArr, 0, i3);
            this.l[1].put(bArr, i3, i3 / 2);
            this.l[0].position(0);
            this.l[1].position(0);
            this.o = i;
            this.p = i2;
        }
    }

    public void a(boolean z, float f) {
        float[] fArr = new float[q.length];
        System.arraycopy(q, 0, fArr, 0, q.length);
        if (z) {
            fArr[0] = f;
            fArr[2] = 1.0f - f;
            fArr[4] = f;
            fArr[6] = 1.0f - f;
            this.m.position(0);
            this.m.put(fArr, 0, fArr.length);
            this.m.position(0);
            return;
        }
        fArr[1] = f;
        fArr[3] = f;
        fArr[5] = 1.0f - f;
        fArr[7] = 1.0f - f;
        this.m.position(0);
        this.m.put(fArr, 0, fArr.length);
        this.m.position(0);
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void b(int i, int i2) {
        if (this.g == null) {
            this.g = (float[]) com.baidu.baiduarsdk.gpuimage.graphics.a.a.clone();
        }
        if (this.h == null) {
            this.h = (float[]) com.baidu.baiduarsdk.gpuimage.graphics.a.a.clone();
        }
        com.baidu.baiduarsdk.gpuimage.graphics.a.a("draw start");
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glViewport(0, 0, this.i, this.j);
        k();
    }

    @Override // com.baidu.baiduarsdk.gpuimage.a.g
    public void e() {
        super.e();
        this.o = 0;
        this.p = 0;
        int length = this.n.length;
        for (int i = 0; i < length; i++) {
            if (this.n[i] >= 0) {
                Log.d("GPUImageNV212RGBAFilter", "glDeleteTextures id");
                GLES20.glDeleteTextures(1, new int[]{this.n[i]}, 0);
                com.baidu.baiduarsdk.gpuimage.graphics.a.a("glDeleteTextures");
            }
            this.n[i] = -1;
        }
    }
}
