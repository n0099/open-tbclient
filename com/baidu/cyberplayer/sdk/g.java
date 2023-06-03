package com.baidu.cyberplayer.sdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.searchbox.afx.recode.TextureRender;
import com.faceunity.gles.GeneratedTexture;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class g implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
    public a A;
    public FloatBuffer b;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public SurfaceTexture o;
    public Surface p;
    public boolean t;
    public h u;
    public i.a z;
    public final float[] a = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public final String c = TextureRender.VERTEX_SHADER;
    public final String d = TextureRender.FRAGMENT_SHADER;
    public float[] e = new float[16];
    public float[] f = new float[16];
    public boolean q = false;
    public final Object r = new Object();
    public final Object s = new Object();
    public boolean v = false;
    public float w = 1.0f;
    public int x = 0;
    public int y = 0;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public boolean a(int i, float f, float f2, float f3, float f4) {
        return false;
    }

    public g() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.b = asFloatBuffer;
        asFloatBuffer.put(this.a).position(0);
        Matrix.setIdentityM(this.f, 0);
        this.t = false;
        this.u = new h();
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                CyberLog.e("CyberRender", "Could not compile shader " + i + ":");
                CyberLog.e("CyberRender", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    public static void a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            try {
                surfaceTexture.setOnFrameAvailableListener(null);
                surfaceTexture.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(int i) {
        if (this.u.b(i)) {
            this.u.c();
        }
    }

    public void c(int i) {
        if (this.u.a(i)) {
            this.u.c();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        f();
        i();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        b();
        g();
        j();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.r) {
            if (surfaceTexture != this.o) {
                return;
            }
            this.q = true;
            a aVar = this.A;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private void b(int i, int i2, int i3, int i4) {
        CyberLog.i("CyberRender", "drawSmallScreen called width:" + i3 + " height:" + i4);
        GLES20.glViewport(i, i2, i3, i4);
        b();
        CyberLog.i("CyberRender", "drawSmallScreen called end");
    }

    private void c(int i, int i2, int i3, int i4) {
        if (this.z != null) {
            this.z.a(i3, i4, d(i, i2, i3, i4));
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.u.a(i, i2, i3, i4)) {
            this.u.c();
        }
    }

    private Buffer d(int i, int i2, int i3, int i4) {
        CyberLog.i("CyberRender", "=> getFrame width:" + i3 + " height:" + i4);
        IntBuffer wrap = IntBuffer.wrap(new int[i3 * i4]);
        wrap.position(0);
        GLES20.glPixelStorei(3333, 4);
        GLES20.glReadPixels(i, i2, i3, i4, GeneratedTexture.FORMAT, 5121, wrap);
        return wrap;
    }

    private void h() {
        a(this.o);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.j = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.j);
        this.o = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        g();
        a("detachGL");
    }

    public void a() {
        this.u.a();
    }

    public synchronized void c() {
        a(this.o);
        this.o = null;
        if (this.p != null) {
            this.p.release();
        }
        this.p = null;
    }

    public synchronized Surface d() {
        c();
        h();
        if (this.o != null) {
            this.p = new Surface(this.o);
        }
        this.q = false;
        this.t = false;
        return this.p;
    }

    public synchronized SurfaceTexture e() {
        return this.o;
    }

    public void f() {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.o != null) {
                this.o.attachToGLContext(this.j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g() {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.o != null) {
                this.o.detachFromGLContext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void i() {
        synchronized (this.r) {
            try {
                if (this.q) {
                    if (this.o != null) {
                        this.o.updateTexImage();
                        this.o.getTransformMatrix(this.f);
                    }
                    this.q = false;
                    if (!this.t) {
                        this.t = true;
                        if (this.z != null) {
                            this.z.a(System.currentTimeMillis());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void j() {
        if (this.v && this.t) {
            synchronized (this.s) {
                if (!this.v) {
                    return;
                }
                if (this.w > 1.0f) {
                    this.w = 1.0f;
                }
                int i = this.x;
                int i2 = this.y;
                this.v = false;
                CyberLog.i("CyberRender", "drawScreenSnapshot called");
                int k = this.u.k();
                int l = this.u.l();
                int round = Math.round(k * this.w);
                int round2 = Math.round(l * this.w);
                if (round > 0 && round2 > 0) {
                    CyberLog.i("CyberRender", "drawScreenSnapshot called mSurfaceWidth:" + k + " mSurfaceHeight:" + l + " snapWidth:" + round + " snapHeight:" + round2);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    b(i, i2, round, round2);
                    c(i, i2, round, round2);
                    if (round != k || round2 != l) {
                        GLES20.glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
                        GLES20.glClear(16640);
                    }
                    GLES20.glViewport(0, 0, this.u.k(), this.u.l());
                    a aVar = this.A;
                    if (aVar != null) {
                        aVar.a();
                    }
                    CyberLog.i("CyberRender", "drawScreenSnapshot called end x:" + i + " y:" + i2);
                }
            }
        }
    }

    public int a(String str, String str2) {
        int a2 = a(35633, str);
        this.h = a2;
        if (a2 == 0) {
            return 0;
        }
        int a3 = a(35632, str2);
        this.i = a3;
        if (a3 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a2);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, a3);
            a("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                CyberLog.e("CyberRender", "Could not link program: ");
                CyberLog.e("CyberRender", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    public void a(float f, int i, int i2) {
        synchronized (this.s) {
            this.v = true;
            this.w = f;
            this.x = i;
            this.y = i2;
        }
        a aVar = this.A;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.u.a(i, i2);
        this.u.c();
        i.a aVar = this.z;
        if (aVar != null) {
            aVar.a(i, i2);
        }
    }

    public void a(int i) {
        if (this.u.c(i)) {
            this.u.c();
        }
    }

    public void a(a aVar) {
        this.A = aVar;
    }

    public void a(i.a aVar) {
        this.z = aVar;
    }

    public boolean a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            CyberLog.e("CyberRender", str + ": glError " + glGetError);
            return true;
        }
        return false;
    }

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
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int a2 = a(TextureRender.VERTEX_SHADER, TextureRender.FRAGMENT_SHADER);
        this.g = a2;
        if (a2 == 0) {
            return;
        }
        this.m = GLES20.glGetAttribLocation(a2, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.m == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for aPosition");
            return;
        }
        this.n = GLES20.glGetAttribLocation(this.g, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.n == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for aTextureCoord");
            return;
        }
        this.k = GLES20.glGetUniformLocation(this.g, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.k == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for uMVPMatrix");
            return;
        }
        this.l = GLES20.glGetUniformLocation(this.g, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.k == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for uSTMatrix");
            return;
        }
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        i.a aVar = this.z;
        if (aVar != null && aVar.a(0)) {
            synchronized (this.r) {
                this.q = false;
            }
        }
    }
}
