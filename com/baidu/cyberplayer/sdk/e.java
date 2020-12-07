package com.baidu.cyberplayer.sdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.i;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes17.dex */
public class e implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    protected a f1382a;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private SurfaceTexture n;
    private Surface o;
    private boolean s;
    private f t;
    private i.a y;
    private final float[] b = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private final String d = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private final String e = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private float[] f = new float[16];
    private float[] g = new float[16];
    private boolean p = false;
    private final Object q = new Object();
    private final Object r = new Object();
    private boolean u = false;
    private float v = 1.0f;
    private int w = 0;
    private int x = 0;
    private FloatBuffer c = ByteBuffer.allocateDirect(this.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* loaded from: classes17.dex */
    public interface a {
        void a();
    }

    public e() {
        this.c.put(this.b).position(0);
        Matrix.setIdentityM(this.g, 0);
        this.s = false;
        this.t = new f();
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
        }
        return glCreateShader;
    }

    private int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a3);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
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

    private static void a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            try {
                surfaceTexture.setOnFrameAvailableListener(null);
                surfaceTexture.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            CyberLog.e("CyberRender", str + ": glError " + glGetError);
            return true;
        }
        return false;
    }

    private void b(int i, int i2, int i3, int i4) {
        CyberLog.i("CyberRender", "drawSmallScreen called width:" + i3 + " height:" + i4);
        GLES20.glViewport(i, i2, i3, i4);
        e();
        CyberLog.i("CyberRender", "drawSmallScreen called end");
    }

    private void c(int i, int i2, int i3, int i4) {
        if (this.y != null) {
            this.y.a(i3, i4, d(i, i2, i3, i4));
        }
    }

    private Buffer d(int i, int i2, int i3, int i4) {
        CyberLog.i("CyberRender", "=> getFrame width:" + i3 + " height:" + i4);
        IntBuffer wrap = IntBuffer.wrap(new int[i3 * i4]);
        wrap.position(0);
        GLES20.glPixelStorei(3333, 4);
        GLES20.glReadPixels(i, i2, i3, i4, 6408, 5121, wrap);
        return wrap;
    }

    private void e() {
        if (this.h == 0) {
            return;
        }
        GLES20.glUseProgram(this.h);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.i);
        this.c.position(0);
        GLES20.glVertexAttribPointer(this.l, 3, 5126, false, 20, (Buffer) this.c);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.l);
        a("glEnableVertexAttribArray maPositionHandle");
        this.c.position(3);
        GLES20.glVertexAttribPointer(this.m, 3, 5126, false, 20, (Buffer) this.c);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.m);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f, 0);
        float[] c = this.t.c();
        Matrix.scaleM(this.f, 0, c[0], c[1], 0.0f);
        Matrix.rotateM(this.f, 0, this.t.d(), 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.j, 1, false, this.f, 0);
        GLES20.glUniformMatrix4fv(this.k, 1, false, this.g, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    private void f() {
        a(this.n);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.i = iArr[0];
        this.n = new SurfaceTexture(this.i);
        this.n.setOnFrameAvailableListener(this);
        i();
        a("detachGL");
    }

    private void g() {
        synchronized (this.q) {
            try {
                if (this.p) {
                    if (this.n != null) {
                        this.n.updateTexImage();
                        this.n.getTransformMatrix(this.g);
                    }
                    this.p = false;
                    if (!this.s) {
                        this.s = true;
                        if (this.y != null) {
                            this.y.a(System.currentTimeMillis());
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void h() {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.n != null) {
                this.n.attachToGLContext(this.i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void i() {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            if (this.n != null) {
                this.n.detachFromGLContext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void j() {
        if (this.u && this.s) {
            synchronized (this.r) {
                if (this.u) {
                    if (this.v > 1.0f) {
                        this.v = 1.0f;
                    }
                    int i = this.w;
                    int i2 = this.x;
                    this.u = false;
                    CyberLog.i("CyberRender", "drawScreenSnapshot called");
                    int g = this.t.g();
                    int h = this.t.h();
                    int round = Math.round(g * this.v);
                    int round2 = Math.round(h * this.v);
                    if (round <= 0 || round2 <= 0) {
                        return;
                    }
                    CyberLog.i("CyberRender", "drawScreenSnapshot called mSurfaceWidth:" + g + " mSurfaceHeight:" + h + " snapWidth:" + round + " snapHeight:" + round2);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    b(i, i2, round, round2);
                    c(i, i2, round, round2);
                    if (round != g || round2 != h) {
                        GLES20.glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
                        GLES20.glClear(16640);
                    }
                    GLES20.glViewport(0, 0, this.t.g(), this.t.h());
                    if (this.f1382a != null) {
                        this.f1382a.a();
                    }
                    CyberLog.i("CyberRender", "drawScreenSnapshot called end x:" + i + " y:" + i2);
                }
            }
        }
    }

    public synchronized void a() {
        a(this.n);
        this.n = null;
        if (this.o != null) {
            this.o.release();
        }
        this.o = null;
    }

    public void a(float f, int i, int i2) {
        synchronized (this.r) {
            this.u = true;
            this.v = f;
            this.w = i;
            this.x = i2;
        }
        if (this.f1382a != null) {
            this.f1382a.a();
        }
    }

    public void a(int i) {
        if (this.t.c(i)) {
            this.t.b();
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.t.a(i, i2, i3, i4)) {
            this.t.b();
        }
    }

    public void a(a aVar) {
        this.f1382a = aVar;
    }

    public void a(i.a aVar) {
        this.y = aVar;
    }

    public void b() {
        this.t.a();
    }

    public void b(int i) {
        if (this.t.b(i)) {
            this.t.b();
        }
    }

    public synchronized Surface c() {
        a();
        f();
        if (this.n != null) {
            this.o = new Surface(this.n);
        }
        this.p = false;
        this.s = false;
        return this.o;
    }

    public void c(int i) {
        if (this.t.a(i)) {
            this.t.b();
        }
    }

    public synchronized SurfaceTexture d() {
        return this.n;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        h();
        g();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        e();
        i();
        j();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.q) {
            if (surfaceTexture != this.n) {
                return;
            }
            this.p = true;
            if (this.f1382a != null) {
                this.f1382a.a();
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.t.a(i, i2);
        this.t.b();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.h = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        if (this.h == 0) {
            return;
        }
        this.l = GLES20.glGetAttribLocation(this.h, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.l == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for aPosition");
            return;
        }
        this.m = GLES20.glGetAttribLocation(this.h, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.m == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for aTextureCoord");
            return;
        }
        this.j = GLES20.glGetUniformLocation(this.h, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.j == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for uMVPMatrix");
            return;
        }
        this.k = GLES20.glGetUniformLocation(this.h, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.j == -1) {
            CyberLog.e("CyberRender", "Could not get attrib location for uSTMatrix");
            return;
        }
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        if (this.y == null || !this.y.a(0)) {
            return;
        }
        synchronized (this.q) {
            this.p = false;
        }
    }
}
