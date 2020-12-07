package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes26.dex */
public class f implements ad {
    private static final j b = new j();

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<SurfaceView> f2916a;
    private final WeakReference<f> c = new WeakReference<>(this);
    private i d;
    private ak e;
    private boolean f;
    private e g;
    private InterfaceC0292f h;
    private g i;
    private k j;
    private int k;
    private int l;
    private boolean m;

    /* loaded from: classes26.dex */
    private abstract class a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f2917a;

        public a(int[] iArr) {
            this.f2917a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (f.this.l == 2 || f.this.l == 3) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                System.arraycopy(iArr, 0, iArr2, 0, length - 1);
                iArr2[length - 1] = 12352;
                if (f.this.l == 2) {
                    iArr2[length] = 4;
                } else {
                    iArr2[length] = 64;
                }
                iArr2[length + 1] = 12344;
                return iArr2;
            }
            return iArr;
        }

        @Override // com.baidu.platform.comapi.map.f.e
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f2917a, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.f2917a, eGLConfigArr, i, iArr)) {
                    EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                    if (a2 == null) {
                        throw new IllegalArgumentException("No config chosen");
                    }
                    return a2;
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    /* loaded from: classes26.dex */
    private class b extends a {
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected int h;
        private int[] j;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.j = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j) ? this.j[0] : i2;
        }

        @Override // com.baidu.platform.comapi.map.f.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.g && a3 >= this.h) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.c && a5 == this.d && a6 == this.e && a7 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes26.dex */
    private class c implements InterfaceC0292f {
        private int b;

        private c() {
            this.b = 12440;
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0292f
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.b, f.this.l, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (f.this.l == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.baidu.platform.comapi.map.f.InterfaceC0292f
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            h.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* loaded from: classes26.dex */
    private static class d implements g {
        private d() {
        }

        @Override // com.baidu.platform.comapi.map.f.g
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLRenderControl", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // com.baidu.platform.comapi.map.f.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes26.dex */
    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.baidu.platform.comapi.map.f$f  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0292f {
        EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* loaded from: classes26.dex */
    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f2919a;
        EGLDisplay b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<f> f;

        public h(WeakReference<f> weakReference) {
            this.f = weakReference;
        }

        private static String a(int i) {
            switch (i) {
                case CommandMessage.COMMAND_BASE /* 12288 */:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case CommandMessage.COMMAND_UNREGISTER /* 12290 */:
                    return "EGL_BAD_ACCESS";
                case CommandMessage.COMMAND_STATISTIC /* 12291 */:
                    return "EGL_BAD_ALLOC";
                case CommandMessage.COMMAND_SET_ALIAS /* 12292 */:
                    return "EGL_BAD_ATTRIBUTE";
                case CommandMessage.COMMAND_GET_ALIAS /* 12293 */:
                    return "EGL_BAD_CONFIG";
                case CommandMessage.COMMAND_UNSET_ALIAS /* 12294 */:
                    return "EGL_BAD_CONTEXT";
                case CommandMessage.COMMAND_SET_TAGS /* 12295 */:
                    return "EGL_BAD_CURRENT_SURFACE";
                case CommandMessage.COMMAND_GET_TAGS /* 12296 */:
                    return "EGL_BAD_DISPLAY";
                case CommandMessage.COMMAND_UNSET_TAGS /* 12297 */:
                    return "EGL_BAD_MATCH";
                case CommandMessage.COMMAND_SET_PUSH_TIME /* 12298 */:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case CommandMessage.COMMAND_PAUSE_PUSH /* 12299 */:
                    return "EGL_BAD_NATIVE_WINDOW";
                case CommandMessage.COMMAND_RESUME_PUSH /* 12300 */:
                    return "EGL_BAD_PARAMETER";
                case CommandMessage.COMMAND_SET_ACCOUNTS /* 12301 */:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return b(i);
            }
        }

        private void a(String str) {
            a(str, this.f2919a.eglGetError());
        }

        public static void a(String str, int i) {
            throw new RuntimeException(b(str, i));
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        private static String b(int i) {
            return "0x" + Integer.toHexString(i);
        }

        public static String b(String str, int i) {
            return str + " failed: " + a(i);
        }

        private void g() {
            if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f2919a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            f fVar = this.f.get();
            if (fVar != null) {
                fVar.i.a(this.f2919a, this.b, this.c);
            }
            this.c = null;
        }

        public void a() {
            this.f2919a = (EGL10) EGLContext.getEGL();
            this.b = this.f2919a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.b == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f2919a.eglInitialize(this.b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            f fVar = this.f.get();
            if (fVar == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = fVar.g.a(this.f2919a, this.b);
                this.e = fVar.h.a(this.f2919a, this.b, this.d);
            }
            if (this.e == null || this.e == EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext");
            }
            this.c = null;
        }

        public boolean b() {
            if (this.f2919a == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.d == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            g();
            f fVar = this.f.get();
            if (fVar != null) {
                this.c = fVar.i.a(this.f2919a, this.b, this.d, fVar.a());
            } else {
                this.c = null;
            }
            if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                if (this.f2919a.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (this.f2919a.eglMakeCurrent(this.b, this.c, this.c, this.e)) {
                return true;
            } else {
                a("EGLHelper", "eglMakeCurrent", this.f2919a.eglGetError());
                return false;
            }
        }

        GL c() {
            GL gl = this.e.getGL();
            f fVar = this.f.get();
            if (fVar != null) {
                if (fVar.j != null) {
                    gl = fVar.j.a(gl);
                }
                if ((fVar.k & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (fVar.k & 1) != 0 ? 1 : 0, (fVar.k & 2) != 0 ? new l() : null);
                }
                return gl;
            }
            return gl;
        }

        public int d() {
            return !this.f2919a.eglSwapBuffers(this.b, this.c) ? this.f2919a.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void e() {
            g();
        }

        public void f() {
            if (this.e != null) {
                f fVar = this.f.get();
                if (fVar != null) {
                    fVar.h.a(this.f2919a, this.b, this.e);
                }
                this.e = null;
            }
            if (this.b != null) {
                this.f2919a.eglTerminate(this.b);
                this.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2920a;
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
        private h u;
        private WeakReference<f> v;
        private ArrayList<Runnable> r = new ArrayList<>();
        private boolean s = true;
        private Runnable t = null;
        private int l = 0;
        private int m = 0;
        private boolean o = true;
        private int n = 1;
        private boolean p = false;

        i(WeakReference<f> weakReference) {
            this.v = weakReference;
        }

        private void i() {
            if (this.i) {
                this.i = false;
                this.u.e();
            }
        }

        private void j() {
            if (this.h) {
                this.u.f();
                this.h = false;
                f.b.b(this);
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void k() throws InterruptedException {
            boolean z;
            int i;
            Runnable runnable;
            boolean z2;
            int i2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            Runnable remove;
            boolean z8;
            boolean z9;
            boolean z10;
            Runnable runnable2;
            int i3;
            int i4;
            this.u = new h(this.v);
            this.h = false;
            this.i = false;
            this.p = false;
            boolean z11 = false;
            GL10 gl10 = null;
            int i5 = 0;
            boolean z12 = false;
            Runnable runnable3 = null;
            int i6 = 0;
            boolean z13 = false;
            Runnable runnable4 = null;
            boolean z14 = false;
            boolean z15 = false;
            boolean z16 = false;
            boolean z17 = false;
            boolean z18 = false;
            while (true) {
                try {
                    synchronized (f.b) {
                        while (!this.f2920a) {
                            if (this.r.isEmpty()) {
                                boolean z19 = false;
                                if (this.d != this.c) {
                                    z19 = this.c;
                                    this.d = this.c;
                                    f.b.notifyAll();
                                }
                                if (this.k) {
                                    i();
                                    j();
                                    this.k = false;
                                    z14 = true;
                                }
                                if (z16) {
                                    i();
                                    j();
                                    z16 = false;
                                }
                                if (z19 && this.i) {
                                    i();
                                }
                                if (z19 && this.h) {
                                    f fVar = this.v.get();
                                    if (!(fVar == null ? false : fVar.m)) {
                                        j();
                                    }
                                }
                                if (!this.e && !this.g) {
                                    if (this.i) {
                                        i();
                                    }
                                    this.g = true;
                                    this.f = false;
                                    f.b.notifyAll();
                                }
                                if (this.e && this.g) {
                                    this.g = false;
                                    f.b.notifyAll();
                                }
                                if (z12) {
                                    this.p = false;
                                    z12 = false;
                                    this.q = true;
                                    f.b.notifyAll();
                                }
                                if (this.t != null) {
                                    runnable2 = this.t;
                                    this.t = null;
                                } else {
                                    runnable2 = runnable3;
                                }
                                if (l()) {
                                    if (!this.h) {
                                        if (z14) {
                                            z14 = false;
                                        } else {
                                            try {
                                                this.u.a();
                                                this.h = true;
                                                z11 = true;
                                                f.b.notifyAll();
                                            } catch (RuntimeException e) {
                                                f.b.b(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.h && !this.i) {
                                        this.i = true;
                                        z18 = true;
                                        z17 = true;
                                        z15 = true;
                                    }
                                    if (this.i) {
                                        if (this.s) {
                                            z15 = true;
                                            i4 = this.l;
                                            i3 = this.m;
                                            this.p = true;
                                            z18 = true;
                                            this.s = false;
                                        } else {
                                            i3 = i5;
                                            i4 = i6;
                                        }
                                        this.o = false;
                                        f.b.notifyAll();
                                        if (this.p) {
                                            i = i4;
                                            Runnable runnable5 = runnable4;
                                            z = true;
                                            runnable = runnable2;
                                            z3 = z18;
                                            z4 = z17;
                                            z5 = z16;
                                            z6 = z15;
                                            z7 = z14;
                                            remove = runnable5;
                                            boolean z20 = z12;
                                            i2 = i3;
                                            z2 = z20;
                                        } else {
                                            runnable = runnable2;
                                            z3 = z18;
                                            z4 = z17;
                                            z5 = z16;
                                            z6 = z15;
                                            z7 = z14;
                                            remove = runnable4;
                                            z = z13;
                                            i = i4;
                                            int i7 = i3;
                                            z2 = z12;
                                            i2 = i7;
                                        }
                                    }
                                } else if (runnable2 != null) {
                                    Log.w("GLRenderControl", "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                    runnable2.run();
                                    runnable2 = null;
                                }
                                f.b.wait();
                                runnable3 = runnable2;
                            } else {
                                z = z13;
                                i = i6;
                                runnable = runnable3;
                                z2 = z12;
                                i2 = i5;
                                z3 = z18;
                                z4 = z17;
                                z5 = z16;
                                z6 = z15;
                                z7 = z14;
                                remove = this.r.remove(0);
                            }
                        }
                        synchronized (f.b) {
                            i();
                            j();
                        }
                        return;
                    }
                    if (remove != null) {
                        remove.run();
                        i5 = i2;
                        z12 = z2;
                        runnable3 = runnable;
                        i6 = i;
                        z13 = z;
                        runnable4 = null;
                        z14 = z7;
                        z15 = z6;
                        z16 = z5;
                        z17 = z4;
                        z18 = z3;
                    } else {
                        if (!z3) {
                            z8 = z3;
                        } else if (this.u.b()) {
                            synchronized (f.b) {
                                this.j = true;
                                f.b.notifyAll();
                            }
                            z8 = false;
                        } else {
                            synchronized (f.b) {
                                this.j = true;
                                this.f = true;
                                f.b.notifyAll();
                            }
                            i5 = i2;
                            z12 = z2;
                            runnable3 = runnable;
                            i6 = i;
                            z13 = z;
                            runnable4 = remove;
                            z14 = z7;
                            z15 = z6;
                            z16 = z5;
                            z17 = z4;
                            z18 = z3;
                        }
                        if (z4) {
                            z4 = false;
                            gl10 = (GL10) this.u.c();
                        }
                        if (z11) {
                            f fVar2 = this.v.get();
                            if (fVar2 != null) {
                                fVar2.e.a(null, fVar2.b(), fVar2.c(), 0);
                                Log.d("GLRenderControl", "mRenderer.onSurfaceCreated");
                            }
                            z11 = false;
                        }
                        if (z6) {
                            f fVar3 = this.v.get();
                            if (fVar3 != null) {
                                fVar3.e.a(i, i2);
                                Log.d("GLRenderControl", "mRenderer.onSurfaceChanged");
                            }
                            z6 = false;
                        }
                        f fVar4 = this.v.get();
                        if (fVar4 != null) {
                            fVar4.e.a(gl10);
                            if (runnable != null) {
                                runnable.run();
                                runnable = null;
                            }
                            Log.d("GLRenderControl", "mRenderer.onDrawFrame");
                        }
                        int d = this.u.d();
                        switch (d) {
                            case CommandMessage.COMMAND_BASE /* 12288 */:
                                break;
                            case 12302:
                                z5 = true;
                                break;
                            default:
                                h.a("GLThread", "eglSwapBuffers", d);
                                synchronized (f.b) {
                                    this.f = true;
                                    f.b.notifyAll();
                                    break;
                                }
                        }
                        if (z) {
                            z9 = true;
                            z10 = false;
                        } else {
                            z9 = z2;
                            z10 = z;
                        }
                        runnable4 = remove;
                        z14 = z7;
                        z15 = z6;
                        z16 = z5;
                        z17 = z4;
                        z18 = z8;
                        i5 = i2;
                        z12 = z9;
                        int i8 = i;
                        z13 = z10;
                        runnable3 = runnable;
                        i6 = i8;
                    }
                } catch (Throwable th) {
                    synchronized (f.b) {
                        i();
                        j();
                        throw th;
                    }
                }
            }
        }

        private boolean l() {
            return !this.d && this.e && !this.f && this.l > 0 && this.m > 0 && (this.o || this.n == 1);
        }

        public void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (f.b) {
                this.n = i;
                f.b.notifyAll();
            }
        }

        public void a(int i, int i2) {
            synchronized (f.b) {
                this.l = i;
                this.m = i2;
                this.s = true;
                this.o = true;
                this.q = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                f.b.notifyAll();
                while (!this.b && !this.d && !this.q && a()) {
                    try {
                        f.b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            synchronized (f.b) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.p = true;
                this.o = true;
                this.q = false;
                this.t = runnable;
                f.b.notifyAll();
            }
        }

        public boolean a() {
            return this.h && this.i && l();
        }

        public int b() {
            int i;
            synchronized (f.b) {
                i = this.n;
            }
            return i;
        }

        public void b(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (f.b) {
                this.r.add(runnable);
                f.b.notifyAll();
            }
        }

        public void c() {
            synchronized (f.b) {
                this.o = true;
                f.b.notifyAll();
            }
        }

        public void d() {
            synchronized (f.b) {
                this.e = true;
                this.j = false;
                f.b.notifyAll();
                while (this.g && !this.j && !this.b) {
                    try {
                        f.b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (f.b) {
                this.e = false;
                f.b.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        f.b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (f.b) {
                this.c = true;
                f.b.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        f.b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (f.b) {
                this.c = false;
                this.o = true;
                this.q = false;
                f.b.notifyAll();
                while (!this.b && this.d && !this.q) {
                    try {
                        f.b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (f.b) {
                this.f2920a = true;
                f.b.notifyAll();
                while (!this.b) {
                    try {
                        f.b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                k();
            } catch (InterruptedException e) {
            } finally {
                f.b.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        private static String f2921a = "GLThreadManager";

        private j() {
        }

        public synchronized void a(i iVar) {
            iVar.b = true;
            notifyAll();
        }

        public void b(i iVar) {
            notifyAll();
        }
    }

    /* loaded from: classes26.dex */
    public interface k {
        GL a(GL gl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f2922a = new StringBuilder();

        l() {
        }

        private void a() {
            if (this.f2922a.length() > 0) {
                Log.v("GLSurfaceView26", this.f2922a.toString());
                this.f2922a.delete(0, this.f2922a.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == '\n') {
                    a();
                } else {
                    this.f2922a.append(c);
                }
            }
        }
    }

    /* loaded from: classes26.dex */
    private class m extends b {
        public m(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public f(SurfaceView surfaceView) {
        this.f2916a = new WeakReference<>(surfaceView);
    }

    private Bitmap a(int i2, int i3, int i4, int i5, GL10 gl10, Bitmap.Config config) {
        int[] iArr = new int[i4 * i5];
        int[] iArr2 = new int[i4 * i5];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        try {
            gl10.glReadPixels(i2, i3, i4, i5, 6408, 5121, wrap);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * i4;
                int i8 = ((i5 - i6) - 1) * i4;
                for (int i9 = 0; i9 < i4; i9++) {
                    int i10 = iArr[i7 + i9];
                    iArr2[i8 + i9] = (i10 & (-16711936)) | ((i10 << 16) & 16711680) | ((i10 >> 16) & 255);
                }
            }
            return config == null ? Bitmap.createBitmap(iArr2, i4, i5, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(iArr2, i4, i5, config);
        } catch (GLException e2) {
            return null;
        }
    }

    private void l() {
        if (this.d != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    @Override // com.baidu.platform.comapi.map.ad
    public Bitmap a(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        return a(i2, i3, i4, i5, (GL10) obj, config);
    }

    public SurfaceHolder a() {
        SurfaceView surfaceView = this.f2916a.get();
        if (surfaceView != null) {
            return surfaceView.getHolder();
        }
        return null;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void a(int i2) {
        this.k = i2;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        a(new b(i2, i3, i4, i5, i6, i7));
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void a(ak akVar) {
        l();
        if (this.g == null) {
            this.g = new m(true);
        }
        if (this.h == null) {
            this.h = new c();
        }
        if (this.i == null) {
            this.i = new d();
        }
        this.e = akVar;
        this.d = new i(this.c);
        this.d.start();
    }

    public void a(e eVar) {
        l();
        this.g = eVar;
    }

    public void a(InterfaceC0292f interfaceC0292f) {
        l();
        this.h = interfaceC0292f;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void a(Runnable runnable) {
        this.d.b(runnable);
    }

    public void a(boolean z) {
        this.m = z;
    }

    public int b() {
        SurfaceView surfaceView = this.f2916a.get();
        if (surfaceView != null) {
            return surfaceView.getWidth();
        }
        return 0;
    }

    public void b(int i2) {
        l();
        this.l = i2;
    }

    public void b(boolean z) {
        a(new m(z));
    }

    public int c() {
        SurfaceView surfaceView = this.f2916a.get();
        if (surfaceView != null) {
            return surfaceView.getHeight();
        }
        return 0;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void c(int i2) {
        this.d.a(i2);
    }

    @Override // com.baidu.platform.comapi.map.ad
    public int d() {
        return this.k;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public int e() {
        return this.d.b();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void f() {
        this.d.c();
    }

    protected void finalize() throws Throwable {
        try {
            if (this.d != null) {
                this.d.h();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void g() {
        this.d.f();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void h() {
        this.d.g();
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void i() {
        if (this.f && this.e != null) {
            int b2 = this.d != null ? this.d.b() : 1;
            this.d = new i(this.c);
            if (b2 != 1) {
                this.d.a(b2);
            }
            this.d.start();
        }
        this.f = false;
    }

    @Override // com.baidu.platform.comapi.map.ad
    public void j() {
        if (this.d != null) {
            this.d.h();
        }
        this.f = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.d.a(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.d.d();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.d.e();
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        if (this.d != null) {
            this.d.a(runnable);
        }
    }
}
