package com.baidu.cyberplayer.sdk;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.searchbox.afx.recode.TextureRender;
import java.nio.Buffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class c extends g {
    public final Object B = new Object();
    public int C = -1;
    public int D = -1;
    public int E = -1;
    public int F = -1;
    public int G = -1;
    public int H = -1;
    public float I = 0.0f;
    public float J = 0.0f;
    public float K = 0.0f;
    public float L = 0.0f;
    public boolean M = true;
    public final String N = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float width;\nuniform float height;\nuniform float left;uniform float right;\nuniform float top;uniform float bottom;\nvec2 clampCoord(vec2 coord) {\nreturn vec2(clamp(coord.x, left, right), clamp(coord.y, top, bottom));}\nvec4 gauss(vec4 src, vec2 offset, int ksize) {\nint index = 0;float sum = 0.0;\nfloat mind = (float(ksize) - 1.0)/2.0;float sigma = 0.3*(float(ksize-1)*0.5-1.0)+0.8;\nvec4 color = vec4(0.0);\nfor(int y=0;y<ksize;y++) {\n  for(int x = 0;x<ksize;x++) {\n    float xpoint = abs(float(x) - mind); float ypoint = abs(float(y) - mind);\n    float weight = (1.0/(2.0*3.1415*sigma*sigma))*pow(2.718,((-(xpoint*xpoint+ypoint*ypoint))/((2.0*sigma)*(2.0*sigma))));\n    vec4 currentColor = texture2D(sTexture, clampCoord(vTextureCoord + vec2(float(-1+x)*offset.x,float(-1+y)*offset.y)));\n    color += currentColor*weight;index++;sum += weight;}\n}\nreturn vec4(color.rgb / sum, src.a);\n}\nvoid main() {\nvec4 sourceColor = texture2D(sTexture, vTextureCoord);\nif (vTextureCoord.x > left && vTextureCoord.x < right && vTextureCoord.y > top && vTextureCoord.y < bottom) {\n     int radius = 8;\n     vec2 blurOffset = vec2(5.0 / width, 5.0 / height);\n     sourceColor= gauss(sourceColor, blurOffset, (2 * radius + 1));\n}\ngl_FragColor = sourceColor;\n}\n";

    public c() {
        this.g = 0;
        this.h = 0;
        this.i = 0;
        CyberLog.d("CyberGaussBurRender", "CyberGaussBurRender");
    }

    private boolean b(String str) {
        boolean z;
        try {
            int a = a(TextureRender.VERTEX_SHADER, str);
            this.g = a;
            if (a == 0) {
                CyberLog.e("CyberGaussBurRender", "resetProgram mProgram = 0");
                return false;
            }
            this.m = GLES20.glGetAttribLocation(a, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.m == -1) {
                CyberLog.e("CyberGaussBurRender", "Could not get attrib location for aPosition");
                return false;
            }
            this.n = GLES20.glGetAttribLocation(this.g, "aTextureCoord");
            a("glGetAttribLocation aTextureCoord");
            if (this.n == -1) {
                CyberLog.e("CyberGaussBurRender", "Could not get attrib location for aTextureCoord");
                return false;
            }
            this.k = GLES20.glGetUniformLocation(this.g, "uMVPMatrix");
            a("glGetUniformLocation uMVPMatrix");
            if (this.k == -1) {
                CyberLog.e("CyberGaussBurRender", "Could not get attrib location for uMVPMatrix");
                return false;
            }
            this.l = GLES20.glGetUniformLocation(this.g, "uSTMatrix");
            a("glGetUniformLocation uSTMatrix");
            if (this.k == -1) {
                CyberLog.e("CyberGaussBurRender", "Could not get attrib location for uSTMatrix");
                return false;
            }
            this.C = GLES20.glGetUniformLocation(this.g, "width");
            this.D = GLES20.glGetUniformLocation(this.g, "height");
            this.E = GLES20.glGetUniformLocation(this.g, "left");
            this.F = GLES20.glGetUniformLocation(this.g, "right");
            this.G = GLES20.glGetUniformLocation(this.g, "top");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.g, "bottom");
            this.H = glGetUniformLocation;
            if (this.C != -1 && this.D != -1 && this.E != -1 && this.F != -1 && this.G != -1 && glGetUniformLocation != -1) {
                z = true;
                GLES20.glTexParameterf(36197, 10241, 9728.0f);
                GLES20.glTexParameterf(36197, 10240, 9729.0f);
                return z;
            }
            CyberLog.e("CyberGaussBurRender", "Could not get attrib location for filter");
            z = false;
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.g
    public void a() {
        CyberLog.d("CyberGaussBurRender", "CyberGaussBurRender reset");
        this.u.b();
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = 0.0f;
    }

    @Override // com.baidu.cyberplayer.sdk.g
    public boolean a(int i, float f, float f2, float f3, float f4) {
        float max;
        float max2;
        float max3;
        float max4;
        if (i == 256 && this.M) {
            try {
                max = Math.max(Math.min(f, 1.0f), 0.0f);
                max2 = Math.max(Math.min(f2, 1.0f), 0.0f);
                max3 = Math.max(Math.min(f3, 1.0f), 0.0f);
                max4 = Math.max(Math.min(f4, 1.0f), 0.0f);
            } catch (Exception unused) {
            }
            if (Math.abs(this.I - max) <= 1.0E-6d && Math.abs(this.J - max2) <= 1.0E-6d && Math.abs(this.K - max3) <= 1.0E-6d && Math.abs(this.L - max4) <= 1.0E-6d) {
                return true;
            }
            synchronized (this.B) {
                this.I = max;
                this.J = max2;
                this.K = max3;
                this.L = max4;
            }
            if (this.t && this.A != null) {
                this.A.a();
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.g
    public void b() {
        int i = this.g;
        if (i == 0) {
            return;
        }
        GLES20.glUseProgram(i);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.j);
        this.b.position(0);
        GLES20.glVertexAttribPointer(this.m, 3, 5126, false, 20, (Buffer) this.b);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.m);
        a("glEnableVertexAttribArray maPositionHandle");
        this.b.position(3);
        GLES20.glVertexAttribPointer(this.n, 3, 5126, false, 20, (Buffer) this.b);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.n);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.e, 0);
        float[] d = this.u.d();
        if (this.u.g()) {
            float[] f = this.u.f();
            Matrix.translateM(this.e, 0, f[0], f[1], 0.0f);
        }
        Matrix.scaleM(this.e, 0, d[0], d[1], 0.0f);
        Matrix.rotateM(this.e, 0, this.u.h(), 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.k, 1, false, this.e, 0);
        GLES20.glUniformMatrix4fv(this.l, 1, false, this.f, 0);
        if (this.M) {
            synchronized (this.B) {
                float k = d[0] * this.u.k();
                float l = d[1] * this.u.l();
                if (Math.abs(k - 0.0f) <= 1.0E-6d || Math.abs(l - 0.0f) <= 1.0E-6d) {
                    k = 1280.0f;
                    l = 720.0f;
                }
                GLES20.glUniform1f(this.C, k);
                GLES20.glUniform1f(this.D, l);
                GLES20.glUniform1f(this.E, this.I);
                GLES20.glUniform1f(this.F, this.J);
                GLES20.glUniform1f(this.G, this.K);
                GLES20.glUniform1f(this.H, this.L);
            }
        }
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    @Override // com.baidu.cyberplayer.sdk.g, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        CyberLog.d("CyberGaussBurRender", "onSurfaceCreated");
        if (this.M) {
            boolean b = b("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float width;\nuniform float height;\nuniform float left;uniform float right;\nuniform float top;uniform float bottom;\nvec2 clampCoord(vec2 coord) {\nreturn vec2(clamp(coord.x, left, right), clamp(coord.y, top, bottom));}\nvec4 gauss(vec4 src, vec2 offset, int ksize) {\nint index = 0;float sum = 0.0;\nfloat mind = (float(ksize) - 1.0)/2.0;float sigma = 0.3*(float(ksize-1)*0.5-1.0)+0.8;\nvec4 color = vec4(0.0);\nfor(int y=0;y<ksize;y++) {\n  for(int x = 0;x<ksize;x++) {\n    float xpoint = abs(float(x) - mind); float ypoint = abs(float(y) - mind);\n    float weight = (1.0/(2.0*3.1415*sigma*sigma))*pow(2.718,((-(xpoint*xpoint+ypoint*ypoint))/((2.0*sigma)*(2.0*sigma))));\n    vec4 currentColor = texture2D(sTexture, clampCoord(vTextureCoord + vec2(float(-1+x)*offset.x,float(-1+y)*offset.y)));\n    color += currentColor*weight;index++;sum += weight;}\n}\nreturn vec4(color.rgb / sum, src.a);\n}\nvoid main() {\nvec4 sourceColor = texture2D(sTexture, vTextureCoord);\nif (vTextureCoord.x > left && vTextureCoord.x < right && vTextureCoord.y > top && vTextureCoord.y < bottom) {\n     int radius = 8;\n     vec2 blurOffset = vec2(5.0 / width, 5.0 / height);\n     sourceColor= gauss(sourceColor, blurOffset, (2 * radius + 1));\n}\ngl_FragColor = sourceColor;\n}\n");
            this.M = b;
            if (!b) {
                int i = this.h;
                if (i != 0) {
                    GLES20.glDeleteShader(i);
                }
                int i2 = this.i;
                if (i2 != 0) {
                    GLES20.glDeleteShader(i2);
                }
                int i3 = this.g;
                if (i3 != 0) {
                    GLES20.glDeleteProgram(i3);
                }
            }
        }
        if (!this.M) {
            b(TextureRender.FRAGMENT_SHADER);
        }
        i.a aVar = this.z;
        if (aVar != null && aVar.a(0)) {
            synchronized (this.r) {
                this.q = false;
            }
        }
    }
}
