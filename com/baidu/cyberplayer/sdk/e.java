package com.baidu.cyberplayer.sdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.i;
import com.baidu.searchbox.afx.recode.TextureRender;
import com.baidu.wallet.core.StatusCode;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class e implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    public a f4921a;

    /* renamed from: c  reason: collision with root package name */
    public FloatBuffer f4923c;

    /* renamed from: h  reason: collision with root package name */
    public int f4928h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public SurfaceTexture n;
    public Surface o;
    public boolean s;
    public f t;
    public i.a y;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f4922b = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    public final String f4924d = TextureRender.VERTEX_SHADER;

    /* renamed from: e  reason: collision with root package name */
    public final String f4925e = TextureRender.FRAGMENT_SHADER;

    /* renamed from: f  reason: collision with root package name */
    public float[] f4926f = new float[16];

    /* renamed from: g  reason: collision with root package name */
    public float[] f4927g = new float[16];
    public boolean p = false;
    public final Object q = new Object();
    public final Object r = new Object();
    public boolean u = false;
    public float v = 1.0f;
    public int w = 0;
    public int x = 0;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public e() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.f4922b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f4923c = asFloatBuffer;
        asFloatBuffer.put(this.f4922b).position(0);
        Matrix.setIdentityM(this.f4927g, 0);
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
            return glCreateShader;
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

    public static void a(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            try {
                surfaceTexture.setOnFrameAvailableListener(null);
                surfaceTexture.release();
            } catch (Exception e2) {
                e2.printStackTrace();
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
        int i = this.f4928h;
        if (i == 0) {
            return;
        }
        GLES20.glUseProgram(i);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.i);
        this.f4923c.position(0);
        GLES20.glVertexAttribPointer(this.l, 3, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 20, (Buffer) this.f4923c);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.l);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f4923c.position(3);
        GLES20.glVertexAttribPointer(this.m, 3, (int) StatusCode.PUBLIC_SECURITY_AUTH_NOT_EXIST, false, 20, (Buffer) this.f4923c);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.m);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f4926f, 0);
        float[] c2 = this.t.c();
        if (this.t.f()) {
            float[] e2 = this.t.e();
            Matrix.translateM(this.f4926f, 0, e2[0], e2[1], 0.0f);
        }
        Matrix.scaleM(this.f4926f, 0, c2[0], c2[1], 0.0f);
        Matrix.rotateM(this.f4926f, 0, this.t.g(), 0.0f, 0.0f, 1.0f);
        GLES20.glUniformMatrix4fv(this.j, 1, false, this.f4926f, 0);
        GLES20.glUniformMatrix4fv(this.k, 1, false, this.f4927g, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    private void f() {
        a(this.n);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.i = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.i);
        this.n = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        i();
        a("detachGL");
    }

    private void g() {
        synchronized (this.q) {
            try {
                if (this.p) {
                    if (this.n != null) {
                        this.n.updateTexImage();
                        this.n.getTransformMatrix(this.f4927g);
                    }
                    this.p = false;
                    if (!this.s) {
                        this.s = true;
                        if (this.y != null) {
                            this.y.a(System.currentTimeMillis());
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
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
        } catch (Exception e2) {
            e2.printStackTrace();
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
        } catch (Exception e2) {
            e2.printStackTrace();
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
                    int j = this.t.j();
                    int k = this.t.k();
                    int round = Math.round(j * this.v);
                    int round2 = Math.round(k * this.v);
                    if (round <= 0 || round2 <= 0) {
                        return;
                    }
                    CyberLog.i("CyberRender", "drawScreenSnapshot called mSurfaceWidth:" + j + " mSurfaceHeight:" + k + " snapWidth:" + round + " snapHeight:" + round2);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16640);
                    b(i, i2, round, round2);
                    c(i, i2, round, round2);
                    if (round != j || round2 != k) {
                        GLES20.glClearColor(255.0f, 255.0f, 255.0f, 1.0f);
                        GLES20.glClear(16640);
                    }
                    GLES20.glViewport(0, 0, this.t.j(), this.t.k());
                    a aVar = this.f4921a;
                    if (aVar != null) {
                        aVar.a();
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

    public void a(float f2, int i, int i2) {
        synchronized (this.r) {
            this.u = true;
            this.v = f2;
            this.w = i;
            this.x = i2;
        }
        a aVar = this.f4921a;
        if (aVar != null) {
            aVar.a();
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
        this.f4921a = aVar;
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
            a aVar = this.f4921a;
            if (aVar != null) {
                aVar.a();
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
        String str;
        String str2;
        int a2 = a(TextureRender.VERTEX_SHADER, TextureRender.FRAGMENT_SHADER);
        this.f4928h = a2;
        if (a2 == 0) {
            return;
        }
        this.l = GLES20.glGetAttribLocation(a2, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.l == -1) {
            str = "CyberRender";
            str2 = "Could not get attrib location for aPosition";
        } else {
            this.m = GLES20.glGetAttribLocation(this.f4928h, "aTextureCoord");
            a("glGetAttribLocation aTextureCoord");
            if (this.m == -1) {
                str = "CyberRender";
                str2 = "Could not get attrib location for aTextureCoord";
            } else {
                this.j = GLES20.glGetUniformLocation(this.f4928h, "uMVPMatrix");
                a("glGetUniformLocation uMVPMatrix");
                if (this.j == -1) {
                    str = "CyberRender";
                    str2 = "Could not get attrib location for uMVPMatrix";
                } else {
                    this.k = GLES20.glGetUniformLocation(this.f4928h, "uSTMatrix");
                    a("glGetUniformLocation uSTMatrix");
                    if (this.j != -1) {
                        GLES20.glTexParameterf(36197, 10241, 9728.0f);
                        GLES20.glTexParameterf(36197, 10240, 9729.0f);
                        i.a aVar = this.y;
                        if (aVar == null || !aVar.a(0)) {
                            return;
                        }
                        synchronized (this.q) {
                            this.p = false;
                        }
                        return;
                    }
                    str = "CyberRender";
                    str2 = "Could not get attrib location for uSTMatrix";
                }
            }
        }
        CyberLog.e(str, str2);
    }
}
