package com.baidu.baiduarsdk.blend;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import com.baidu.baiduarsdk.blend.TextureParams;
import com.baidu.baiduarsdk.blend.b;
import com.baidu.baiduarsdk.gpuimage.a.f;
import com.baidu.baiduarsdk.gpuimage.a.g;
import com.baidu.baiduarsdk.gpuimage.a.h;
import com.baidu.baiduarsdk.gpuimage.a.m;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class a implements d {
    private static final String g = a.class.getSimpleName();
    private volatile h A;
    private volatile b.d I;
    b.a e;
    com.baidu.baiduarsdk.c.a f;
    private b.c m;
    private SurfaceTexture o;
    private volatile h y;
    private volatile h z;
    private int[] h = {-1};
    private int i = 0;
    private int j = 0;
    private long k = System.currentTimeMillis();
    private int l = 0;
    private boolean n = false;
    boolean a = false;
    int b = 0;
    boolean c = false;
    boolean d = true;
    private TextureParams.SourceType p = TextureParams.SourceType.SURFACE_TEXTURE;
    private boolean q = true;
    private float r = 0.0f;
    private final float[] s = new float[16];
    private int t = -1;
    private m u = null;
    private f v = null;
    private g w = null;
    private com.baidu.baiduarsdk.gpuimage.a.d x = null;
    private int B = -1;
    private int[] C = {-1, -1};
    private int D = -1;
    private int E = -1;
    private int F = -1;
    private int G = -1;
    private int H = -1;
    private int[] J = null;

    private void a(int i, int i2) {
        c();
        this.H = com.baidu.baiduarsdk.gpuimage.graphics.a.a(3553, i, i2);
    }

    private void a(h hVar) {
        Log.d(g, "clearGPUImageFilters: ");
        if (hVar == null || !hVar.g()) {
            return;
        }
        hVar.d();
    }

    private void a(h hVar, int i, int i2) {
        Log.d(g, "initGPUImageFilters: " + i + "x" + i2);
        hVar.c();
        if (i <= 0 || i2 <= 0) {
            return;
        }
        hVar.a(i, i2);
    }

    private boolean a(int[] iArr, SurfaceTexture surfaceTexture) {
        if (iArr[0] <= -1) {
            Log.e(g, "bdar: oldTextureId = " + iArr[0]);
            int a = com.baidu.baiduarsdk.gpuimage.graphics.a.a();
            if (a <= -1) {
                Log.e(g, "bdar: create texture id <= -1, Invalid ID!!!!");
                return false;
            }
            if (surfaceTexture != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        surfaceTexture.attachToGLContext(a);
                    }
                } catch (Exception e) {
                    Log.e(g, "bdar: runException oldTextureId = " + iArr[0]);
                    e.printStackTrace();
                    b(iArr, surfaceTexture);
                    if (a >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{a}, 0);
                        return false;
                    }
                    return false;
                }
            }
            iArr[0] = a;
            Log.d(g, "bdar: newTextureId = " + iArr[0]);
        }
        return true;
    }

    private void b(int i, int i2) {
        d();
        this.t = com.baidu.baiduarsdk.gpuimage.graphics.a.a(3553, i, i2);
    }

    private void b(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    private void b(int[] iArr, SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null && iArr[0] >= 0) {
            try {
                if (Build.VERSION.SDK_INT >= 16 && surfaceTexture != null) {
                    surfaceTexture.detachFromGLContext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (iArr[0] >= 0) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
        iArr[0] = -1;
    }

    private void c() {
        if (this.H != -1) {
            com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.H);
            this.H = -1;
        }
    }

    private void c(int i, int i2) {
        e();
        this.E = com.baidu.baiduarsdk.gpuimage.graphics.a.a(3553, i, i2);
        this.F = com.baidu.baiduarsdk.gpuimage.graphics.a.a(3553, i, i2);
        this.G = com.baidu.baiduarsdk.gpuimage.graphics.a.a(3553, i, i2);
    }

    private void d() {
        if (this.t != -1) {
            com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.t);
            this.t = -1;
        }
    }

    private void e() {
        if (this.E != -1) {
            com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.E);
            this.E = -1;
        }
        if (this.F != -1) {
            com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.F);
            this.F = -1;
        }
        if (this.G != -1) {
            com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.G);
            this.G = -1;
        }
    }

    private void f() {
        boolean z = true;
        try {
            if (this.i == 0 || this.j == 0) {
                Log.e(g, "Skipping Frame Processing!");
                return;
            }
            System.currentTimeMillis();
            System.nanoTime();
            if (this.d) {
                if (this.p == TextureParams.SourceType.SURFACE_TEXTURE) {
                    a(this.h, this.o);
                    this.v.c(this.s);
                    com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.t, 3553, this.D);
                    this.v.b(this.h[0], this.D);
                    b(this.o);
                    this.o.getTransformMatrix(this.s);
                } else if (this.p == TextureParams.SourceType.YUV_DATA) {
                    com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.t, 3553, this.D);
                    g();
                }
                com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.E, 3553, this.D);
                this.C[0] = this.F;
                this.C[1] = this.G;
                this.y.a(this.C, this.B);
                this.y.b(this.t, this.D);
            }
            int[] k = this.f != null ? this.f.k() : null;
            if (k != null) {
                a();
                this.J = k;
            }
            boolean z2 = (this.J == null || this.J[3] == -1) ? false : true;
            if (z2) {
                com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.F, 3553, this.D);
                this.C[0] = this.G;
                this.C[1] = this.t;
                this.z.a(this.C, this.B);
                this.z.b(this.J[3], this.D);
            }
            if (this.d || z2) {
                com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.t, 3553, this.D);
                if (this.d && z2) {
                    this.x.b(this.F);
                    this.x.b(this.E, this.D);
                } else if (this.d) {
                    this.w.b(this.E, this.D);
                } else if (z2) {
                    this.w.b(this.F, this.D);
                }
                com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.G, 3553, this.D);
                this.C[0] = this.E;
                this.C[1] = this.F;
                this.A.a(this.C, this.B);
                this.A.b(this.t, this.D);
                int i = this.G;
                if (this.J == null || this.J[5] == -1) {
                    z = false;
                }
                if (z) {
                    com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.t, 3553, this.D);
                    this.x.b(this.J[5]);
                    this.x.b(this.G, this.D);
                    i = this.t;
                }
                this.w.a(i);
                if (this.m == null && this.I == null) {
                    c();
                } else {
                    if (this.H == -1) {
                        a(this.i, this.j);
                    }
                    com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.H, 3553, this.D);
                    this.w.b(this.G, this.D);
                }
                if (this.I != null) {
                    int i2 = this.i;
                    int i3 = this.j;
                    int[] iArr = new int[i2 * i3];
                    IntBuffer wrap = IntBuffer.wrap(iArr);
                    wrap.position(0);
                    wrap.rewind();
                    GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, wrap);
                    this.I.a(iArr, i2, i3);
                    this.I = null;
                }
                if (this.m != null) {
                    if (!this.n) {
                        this.m.a(((EGL10) EGLContext.getEGL()).eglGetCurrentContext(), this.i, this.j);
                        this.n = true;
                    }
                    this.m.a(this.H);
                }
            }
            if (this.f != null) {
                if (this.f.l() != 0) {
                    a();
                }
                this.f.i();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void g() {
        if (b.c == null || b.a == 0 || b.b == 0) {
            return;
        }
        int i = b.a;
        int i2 = b.b;
        byte[] bArr = b.c;
        if (this.u != null) {
            this.u.b(this.s);
            synchronized (b.class) {
                System.currentTimeMillis();
                this.u.a(i, i2, bArr);
            }
            this.u.b(-1, this.D);
            if (this.e != null) {
                this.e.a();
                this.e = null;
            }
        }
    }

    public void a() {
        if (this.f == null || this.J == null) {
            return;
        }
        this.f.b(this.J);
        this.J = null;
    }

    public void a(int i) {
        if (i <= 0 || i > 60) {
            return;
        }
        this.l = 1000 / i;
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.o = surfaceTexture;
    }

    public void a(TextureParams textureParams) {
        this.d = textureParams.b();
        this.p = textureParams.e();
        this.q = textureParams.c();
        this.r = textureParams.d();
        a(textureParams.a());
        if (this.u != null) {
            this.u.a(this.q, this.r);
        }
    }

    public void a(b.c cVar) {
        this.m = cVar;
        this.n = false;
    }

    public void a(b.d dVar) {
        this.I = dVar;
    }

    public void a(com.baidu.baiduarsdk.c.a aVar) {
        this.f = aVar;
    }

    public void a(List<g> list) {
        Log.d(g, "setGPUImageFiltersInternal: ");
        a(this.y);
        this.y.a(list);
        a(this.y, this.i, this.j);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void a(float[] fArr) {
        Matrix.setIdentityM(this.s, 0);
        if (fArr == null || fArr.length != this.s.length) {
            return;
        }
        System.arraycopy(fArr, 0, this.s, 0, fArr.length);
    }

    @Override // com.baidu.baiduarsdk.blend.d
    public void b() {
        Log.d(g, "bdar onContextDestroy");
        if (this.m != null) {
            this.m.a(null, 0, 0);
        }
        b(this.h, this.o);
        this.b = 0;
        this.e = null;
        this.i = 0;
        this.j = 0;
        this.u.d();
        this.u = null;
        this.v.d();
        this.v = null;
        this.w.d();
        this.w = null;
        this.x.d();
        this.x = null;
        a(this.y);
        a(this.z);
        a(this.A);
        this.y = null;
        this.z = null;
        this.A = null;
        d();
        e();
        c();
        com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.D);
        this.D = -1;
        com.baidu.baiduarsdk.gpuimage.graphics.a.b(this.B);
        this.B = -1;
        if (this.I != null) {
            this.I.a(null, 0, 0);
            this.I = null;
        }
        if (this.J != null) {
            com.baidu.baiduarsdk.c.a.a(this.J);
            this.J = null;
        }
        this.c = true;
    }

    public void b(List<g> list) {
        Log.d(g, "setGPUImageFiltersInternal: ");
        a(this.z);
        this.z.a(list);
        a(this.z, this.i, this.j);
    }

    public void c(List<g> list) {
        Log.d(g, "setGPUImageFiltersInternal: ");
        a(this.A);
        this.A.a(list);
        a(this.A, this.i, this.j);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        Log.i(g, "bdar: blender renderer onDrawFrame  mEnginSoLoaded = " + this.a + ", mContextDestroy = " + this.c);
        if (this.c) {
            return;
        }
        if (this.l > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            if (currentTimeMillis < this.l) {
                try {
                    Thread.sleep(this.l - currentTimeMillis);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.k = System.currentTimeMillis();
        }
        System.currentTimeMillis();
        f();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Log.d(g, String.format("bdar:onSurfaceChanged thread name %s id %s width %d height %d", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(i2)));
        GLES20.glViewport(0, 0, i, i2);
        if (this.i == i && this.j == i2) {
            return;
        }
        this.i = i;
        this.j = i2;
        Log.e(g, "bdar: glview Width = " + this.i + ", height = " + this.j);
        b(this.h, this.o);
        this.y.a(i, i2);
        this.z.a(i, i2);
        this.A.a(i, i2);
        this.u.a(i, i2);
        this.v.a(i, i2);
        this.w.a(i, i2);
        this.x.a(i, i2);
        b(i, i2);
        c(i, i2);
        GLES20.glFlush();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.e(g, "bdar:onSurfaceCreated");
        this.c = false;
        this.u = new m();
        if (Float.compare(this.r, 0.0f) != 0) {
            this.u.a(this.q, this.r);
        }
        this.u.c();
        this.v = new f();
        this.v.c();
        this.w = new g();
        this.w.c();
        this.x = new com.baidu.baiduarsdk.gpuimage.a.d();
        this.x.c();
        this.D = com.baidu.baiduarsdk.gpuimage.graphics.a.b();
        this.B = com.baidu.baiduarsdk.gpuimage.graphics.a.b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g());
        this.y = new h(arrayList);
        this.y.a(true);
        a(this.y, 0, 0);
        this.z = new h(arrayList);
        this.z.a(true);
        a(this.z, 0, 0);
        this.A = new h(arrayList);
        this.A.a(true);
        a(this.A, 0, 0);
    }
}
