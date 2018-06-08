package com.baidu.baiduarsdk;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public final class a {
    private static final i d = new i();
    private GLSurfaceView.Renderer b;
    private Object e;
    private g f;
    private d g;
    private e h;
    private f i;
    private long a = -1;
    private boolean c = false;
    private final WeakReference<a> j = new WeakReference<>(this);

    /* renamed from: com.baidu.baiduarsdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0055a implements d {
        protected int a;
        protected int b;
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int[] g;
        private int[] h = new int[1];

        public C0055a(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12352, 4, 12344};
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.h) ? this.h[0] : i2;
        }

        @Override // com.baidu.baiduarsdk.a.d
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.g, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.g, eGLConfigArr, i, iArr)) {
                    EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                    if (a == null) {
                        throw new IllegalArgumentException("No config chosen");
                    }
                    return a;
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.e && a2 >= this.f) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a3 == this.a && a4 == this.b && a5 == this.c && a6 == this.d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    private static class b implements e {
        private b() {
        }

        @Override // com.baidu.baiduarsdk.a.e
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        }

        @Override // com.baidu.baiduarsdk.a.e
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* loaded from: classes3.dex */
    private static class c implements f {
        private c() {
        }

        @Override // com.baidu.baiduarsdk.a.f
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("EngineLogger", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.baiduarsdk.a.f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* loaded from: classes3.dex */
    public interface e {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes3.dex */
    public interface f {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class g extends Thread {
        private boolean a;
        private boolean b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean q;
        private h t;
        private WeakReference<a> u;
        private ArrayList<Runnable> r = new ArrayList<>();
        private boolean s = true;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;
        private boolean p = false;

        g(WeakReference<a> weakReference) {
            this.u = weakReference;
        }

        private void h() {
            if (this.i) {
                this.i = false;
                this.t.e();
            }
        }

        private void i() {
            if (this.h) {
                this.t.f();
                this.h = false;
                a.d.b(this);
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0271  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x02d2  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void j() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            Runnable runnable;
            boolean z5;
            boolean z6;
            int i;
            boolean z7;
            int i2;
            boolean z8;
            boolean z9;
            GL10 gl10;
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            this.t = new h(this.u);
            this.h = false;
            this.i = false;
            this.p = false;
            GL10 gl102 = null;
            boolean z15 = false;
            int i3 = 0;
            boolean z16 = false;
            int i4 = 0;
            boolean z17 = false;
            boolean z18 = false;
            Runnable runnable2 = null;
            boolean z19 = false;
            boolean z20 = false;
            boolean z21 = false;
            boolean z22 = false;
            while (true) {
                try {
                    synchronized (a.d) {
                        while (!this.a) {
                            if (this.h && this.i && !this.r.isEmpty()) {
                                z = z22;
                                z2 = z21;
                                z3 = z20;
                                z4 = z19;
                                runnable = this.r.remove(0);
                                z5 = z18;
                                z6 = z17;
                                i = i4;
                                z7 = z16;
                                i2 = i3;
                                z8 = z15;
                            } else {
                                boolean z23 = false;
                                if (this.d != this.c) {
                                    z23 = this.c;
                                    this.d = this.c;
                                    a.d.notifyAll();
                                }
                                if (this.k) {
                                    h();
                                    i();
                                    this.k = false;
                                    z20 = true;
                                }
                                if (z16) {
                                    h();
                                    i();
                                    z16 = false;
                                }
                                if (z23 && this.i) {
                                    h();
                                }
                                if (!z23 || this.h) {
                                }
                                if (!this.e && !this.g) {
                                    if (this.i) {
                                        h();
                                    }
                                    this.g = true;
                                    this.f = false;
                                    a.d.notifyAll();
                                }
                                if (this.e && this.g) {
                                    this.g = false;
                                    a.d.notifyAll();
                                }
                                if (z15) {
                                    this.p = false;
                                    z15 = false;
                                    this.q = true;
                                    a.d.notifyAll();
                                }
                                if (k()) {
                                    if (!this.h) {
                                        if (z20) {
                                            z20 = false;
                                        } else {
                                            try {
                                                this.t.a();
                                                this.h = true;
                                                z22 = true;
                                                a.d.notifyAll();
                                            } catch (RuntimeException e) {
                                                a.d.b(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.h && !this.i) {
                                        this.i = true;
                                        z18 = true;
                                        z21 = true;
                                        z17 = true;
                                    }
                                    if (this.i) {
                                        if (this.s) {
                                            z17 = true;
                                            i3 = this.l;
                                            i4 = this.m;
                                            this.p = true;
                                            z18 = true;
                                            this.s = false;
                                        }
                                        this.o = false;
                                        a.d.notifyAll();
                                        if (this.p) {
                                            z = z22;
                                            z2 = z21;
                                            z3 = z20;
                                            z4 = true;
                                            runnable = runnable2;
                                            z5 = z18;
                                            z6 = z17;
                                            i = i4;
                                            z7 = z16;
                                            i2 = i3;
                                            z8 = z15;
                                        } else {
                                            z = z22;
                                            z2 = z21;
                                            z3 = z20;
                                            z4 = z19;
                                            runnable = runnable2;
                                            z5 = z18;
                                            z6 = z17;
                                            i = i4;
                                            z7 = z16;
                                            i2 = i3;
                                            z8 = z15;
                                        }
                                    }
                                }
                                a.d.wait();
                            }
                        }
                        synchronized (a.d) {
                            h();
                            i();
                        }
                        return;
                    }
                    if (runnable != null) {
                        runnable.run();
                        z15 = z8;
                        i3 = i2;
                        z16 = z7;
                        i4 = i;
                        z17 = z6;
                        z18 = z5;
                        runnable2 = null;
                        z19 = z4;
                        z20 = z3;
                        z21 = z2;
                        z22 = z;
                    } else {
                        if (!z5) {
                            z9 = z5;
                        } else if (this.t.b()) {
                            synchronized (a.d) {
                                this.j = true;
                                a.d.notifyAll();
                            }
                            z9 = false;
                        } else {
                            synchronized (a.d) {
                                this.j = true;
                                this.f = true;
                                a.d.notifyAll();
                            }
                            z15 = z8;
                            i3 = i2;
                            z16 = z7;
                            i4 = i;
                            z17 = z6;
                            z18 = z5;
                            runnable2 = runnable;
                            z19 = z4;
                            z20 = z3;
                            z21 = z2;
                            z22 = z;
                        }
                        if (z2) {
                            z10 = false;
                            gl10 = (GL10) this.t.c();
                        } else {
                            gl10 = gl102;
                            z10 = z2;
                        }
                        if (z) {
                            a aVar = this.u.get();
                            if (aVar != null) {
                                aVar.b.onSurfaceCreated(gl10, this.t.d);
                            }
                            z = false;
                        }
                        if (z6) {
                            a aVar2 = this.u.get();
                            if (aVar2 != null) {
                                aVar2.b.onSurfaceChanged(gl10, i2, i);
                            }
                            z6 = false;
                        }
                        a aVar3 = this.u.get();
                        if (aVar3 != null) {
                            if (aVar3.c) {
                                aVar3.b.onDrawFrame(gl10);
                                int d = this.t.d();
                                switch (d) {
                                    case 12288:
                                        z14 = z7;
                                        break;
                                    case 12302:
                                        z14 = true;
                                        break;
                                    default:
                                        h.a("GLThread", "eglSwapBuffers", d);
                                        synchronized (a.d) {
                                            this.f = true;
                                            a.d.notifyAll();
                                        }
                                        z14 = z7;
                                        break;
                                }
                                z11 = z14;
                                if (z4) {
                                    z12 = z8;
                                    z13 = z4;
                                } else {
                                    z12 = true;
                                    z13 = false;
                                }
                                i3 = i2;
                                z20 = z3;
                                z16 = z11;
                                z21 = z10;
                                z22 = z;
                                gl102 = gl10;
                                boolean z24 = z6;
                                z18 = z9;
                                z15 = z12;
                                runnable2 = runnable;
                                z19 = z13;
                                i4 = i;
                                z17 = z24;
                            } else {
                                aVar3.c = true;
                            }
                        }
                        z11 = z7;
                        if (z4) {
                        }
                        i3 = i2;
                        z20 = z3;
                        z16 = z11;
                        z21 = z10;
                        z22 = z;
                        gl102 = gl10;
                        boolean z242 = z6;
                        z18 = z9;
                        z15 = z12;
                        runnable2 = runnable;
                        z19 = z13;
                        i4 = i;
                        z17 = z242;
                    }
                } catch (Throwable th) {
                    synchronized (a.d) {
                        h();
                        i();
                        throw th;
                    }
                }
            }
        }

        private boolean k() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (a.d) {
                this.n = i;
                a.d.notifyAll();
            }
        }

        public void a(int i, int i2) {
            synchronized (a.d) {
                this.l = i;
                this.m = i2;
                this.s = true;
                this.o = true;
                this.q = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                a.d.notifyAll();
                while (!this.b && !this.d && !this.q && a()) {
                    try {
                        a.d.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (a.d) {
                this.r.add(runnable);
                a.d.notifyAll();
            }
        }

        public boolean a() {
            return this.h && this.i && k();
        }

        public void b() {
            synchronized (a.d) {
                this.o = true;
                a.d.notifyAll();
            }
        }

        public void c() {
            synchronized (a.d) {
                this.e = true;
                this.j = false;
                a.d.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        a.d.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void d() {
            synchronized (a.d) {
                this.e = false;
                a.d.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        a.d.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (a.d) {
                this.c = true;
                a.d.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        a.d.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (a.d) {
                this.c = false;
                this.o = true;
                this.q = false;
                a.d.notifyAll();
                while (!this.b && this.d && !this.q) {
                    try {
                        a.d.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (a.d) {
                this.a = true;
                a.d.notifyAll();
                while (!this.b) {
                    try {
                        a.d.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("ARGLThread " + getId());
            try {
                j();
            } catch (InterruptedException e) {
            } finally {
                a.d.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class h {
        EGL10 a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<a> f;

        public h(WeakReference<a> weakReference) {
            this.f = weakReference;
        }

        private void a(String str) {
            a(str, this.a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }

        private void g() {
            if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            a aVar = this.f.get();
            if (aVar != null) {
                aVar.i.a(this.a, this.b, this.c);
            }
            this.c = null;
        }

        public void a() {
            this.a = (EGL10) EGLContext.getEGL();
            this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.b == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.a.eglInitialize(this.b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            a aVar = this.f.get();
            if (aVar == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = aVar.g.a(this.a, this.b);
                this.e = aVar.h.a(this.a, this.b, this.d);
                aVar.a = Thread.currentThread().getId();
            }
            if (this.e == null || this.e == EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext");
            }
            this.c = null;
        }

        public boolean b() {
            if (this.a == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.d == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            g();
            a aVar = this.f.get();
            if (aVar == null || aVar.e == null) {
                this.c = null;
            } else {
                this.c = aVar.i.a(this.a, this.b, this.d, aVar.e);
            }
            if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                if (this.a.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (this.a.eglMakeCurrent(this.b, this.c, this.c, this.e)) {
                return true;
            } else {
                a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                return false;
            }
        }

        GL c() {
            return this.e.getGL();
        }

        public int d() {
            if (this.a.eglSwapBuffers(this.b, this.c)) {
                return 12288;
            }
            return this.a.eglGetError();
        }

        public void e() {
            g();
        }

        public void f() {
            if (this.e != null) {
                a aVar = this.f.get();
                if (aVar != null) {
                    aVar.h.a(this.a, this.b, this.e);
                    aVar.a = -1L;
                }
                this.e = null;
            }
            if (this.b != null) {
                this.a.eglTerminate(this.b);
                this.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class i {
        private static String a = "GLThreadManager";
        private g b;

        private i() {
        }

        public synchronized void a(g gVar) {
            gVar.b = true;
            if (this.b == gVar) {
                this.b = null;
            }
            notifyAll();
        }

        public void b(g gVar) {
            if (this.b == gVar) {
                this.b = null;
            }
            notifyAll();
        }
    }

    public void a() {
        if (this.f != null) {
            this.f.b();
        }
    }

    public void a(int i2) {
        if (this.f != null) {
            this.f.a(i2);
        }
    }

    public void a(GLSurfaceView.Renderer renderer) {
        if (this.g == null) {
            this.g = new C0055a(8, 8, 8, 8, 16, 0);
        }
        if (this.h == null) {
            this.h = new b();
        }
        if (this.i == null) {
            this.i = new c();
        }
        this.b = renderer;
        this.f = new g(this.j);
        this.f.start();
    }

    public void a(Object obj, int i2, int i3) {
        this.e = obj;
        if (Build.VERSION.SDK_INT >= 15 && this.e != null && (this.e instanceof SurfaceTexture)) {
            ((SurfaceTexture) this.e).setDefaultBufferSize(i2, i3);
        }
        if (this.f != null) {
            if (this.e == null) {
                this.f.d();
                return;
            }
            this.f.c();
            this.f.a(i2, i3);
        }
    }

    public void a(Runnable runnable) {
        if (this.f != null) {
            this.f.a(runnable);
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.e();
        }
    }

    public void c() {
        if (this.f != null) {
            this.f.f();
        }
    }

    public void d() {
        if (this.f != null) {
            this.f.g();
        }
        Log.e("EngineLogger", "exitGLThread()");
    }

    public boolean e() {
        return this.f != null && this.f.h;
    }

    public EGLContext f() {
        if (this.f == null || this.f.t == null) {
            return null;
        }
        return this.f.t.e;
    }

    protected void finalize() {
        try {
            if (this.f != null) {
                this.f.g();
            }
        } finally {
            super.finalize();
        }
    }

    public EGLConfig g() {
        if (this.f == null || this.f.t == null) {
            return null;
        }
        return this.f.t.d;
    }
}
