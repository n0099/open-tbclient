package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes15.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final g f4244b = new g(null);

    /* renamed from: a  reason: collision with root package name */
    private final View.OnLayoutChangeListener f4245a;
    private final WeakReference<GLTextureView> c;
    private f d;
    private ak e;
    private boolean f;
    private GLSurfaceView.EGLConfigChooser g;
    private GLSurfaceView.EGLContextFactory h;
    private GLSurfaceView.EGLWindowSurfaceFactory i;
    private GLSurfaceView.GLWrapper j;
    private int k;
    private int l;
    private boolean m;

    /* loaded from: classes15.dex */
    private abstract class a implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f4246a;

        public a(int[] iArr) {
            this.f4246a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (GLTextureView.this.l != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            System.arraycopy(iArr, 0, iArr2, 0, length - 1);
            iArr2[length - 1] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f4246a, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.f4246a, eGLConfigArr, i, iArr)) {
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
    }

    /* loaded from: classes15.dex */
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

        @Override // com.baidu.platform.comapi.map.GLTextureView.a
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

    /* loaded from: classes15.dex */
    private class c implements GLSurfaceView.EGLContextFactory {

        /* renamed from: b  reason: collision with root package name */
        private int f4249b;

        private c() {
            this.f4249b = 12440;
        }

        /* synthetic */ c(GLTextureView gLTextureView, com.baidu.platform.comapi.map.h hVar) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f4249b, GLTextureView.this.l, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.l == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
            e.a("eglDestroyContex", egl10.eglGetError());
        }
    }

    /* loaded from: classes15.dex */
    private static class d implements GLSurfaceView.EGLWindowSurfaceFactory {
        private d() {
        }

        /* synthetic */ d(com.baidu.platform.comapi.map.h hVar) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f4250a;

        /* renamed from: b  reason: collision with root package name */
        EGLDisplay f4251b;
        EGLSurface c;
        EGLConfig d;
        EGLContext e;
        private WeakReference<GLTextureView> f;

        public e(WeakReference<GLTextureView> weakReference) {
            this.f = weakReference;
        }

        private void a(String str) {
            a(str, this.f4250a.eglGetError());
        }

        public static void a(String str, int i) {
            String b2 = b(str, i);
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + b2);
            throw new RuntimeException(b2);
        }

        public static void a(String str, String str2, int i) {
        }

        public static String b(String str, int i) {
            return str + " EGL failed code: " + i;
        }

        private void g() {
            if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                return;
            }
            this.f4250a.eglMakeCurrent(this.f4251b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
                gLTextureView.i.destroySurface(this.f4250a, this.f4251b, this.c);
            }
            this.c = null;
        }

        public void a() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            this.f4250a = (EGL10) EGLContext.getEGL();
            this.f4251b = this.f4250a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (this.f4251b == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f4250a.eglInitialize(this.f4251b, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView == null) {
                this.d = null;
                this.e = null;
            } else {
                this.d = gLTextureView.g.chooseConfig(this.f4250a, this.f4251b);
                this.e = gLTextureView.h.createContext(this.f4250a, this.f4251b, this.d);
            }
            if (this.e == null || this.e == EGL10.EGL_NO_CONTEXT) {
                this.e = null;
                a("createContext");
            }
            Log.w("EglHelper", "createContext " + this.e + " tid=" + Thread.currentThread().getId());
            this.c = null;
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f4250a == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f4251b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.d == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            g();
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
                this.c = gLTextureView.i.createWindowSurface(this.f4250a, this.f4251b, this.d, gLTextureView.getSurfaceTexture());
            } else {
                this.c = null;
            }
            if (this.c == null || this.c == EGL10.EGL_NO_SURFACE) {
                if (this.f4250a.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            } else if (this.f4250a.eglMakeCurrent(this.f4251b, this.c, this.c, this.e)) {
                return true;
            } else {
                a("EGLHelper", "eglMakeCurrent", this.f4250a.eglGetError());
                return false;
            }
        }

        GL c() {
            GL gl = this.e.getGL();
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
                if (gLTextureView.j != null) {
                    gl = gLTextureView.j.wrap(gl);
                }
                if ((gLTextureView.k & 3) != 0) {
                    return GLDebugHelper.wrap(gl, (gLTextureView.k & 1) != 0 ? 1 : 0, (gLTextureView.k & 2) != 0 ? new h() : null);
                }
                return gl;
            }
            return gl;
        }

        public int d() {
            return !this.f4250a.eglSwapBuffers(this.f4251b, this.c) ? this.f4250a.eglGetError() : CommandMessage.COMMAND_BASE;
        }

        public void e() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            g();
        }

        public void f() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.e != null) {
                GLTextureView gLTextureView = this.f.get();
                if (gLTextureView != null) {
                    gLTextureView.h.destroyContext(this.f4250a, this.f4251b, this.e);
                }
                this.e = null;
            }
            if (this.f4251b != null) {
                this.f4250a.eglTerminate(this.f4251b);
                this.f4251b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4252a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4253b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean o;
        private e r;
        private WeakReference<GLTextureView> s;
        private ArrayList<Runnable> p = new ArrayList<>();
        private boolean q = true;
        private int k = 0;
        private int l = 0;
        private boolean n = true;
        private int m = 1;

        f(WeakReference<GLTextureView> weakReference) {
            this.s = weakReference;
        }

        private void j() {
            if (this.i) {
                this.i = false;
                this.r.e();
            }
        }

        private void k() {
            if (this.h) {
                this.r.f();
                this.h = false;
                GLTextureView.f4244b.c(this);
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void l() throws InterruptedException {
            GL10 gl10;
            boolean z;
            int i;
            this.r = new e(this.s);
            this.h = false;
            this.i = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int i2 = 0;
            int i3 = 0;
            Runnable runnable = null;
            GL10 gl102 = null;
            while (true) {
                try {
                    synchronized (GLTextureView.f4244b) {
                        while (!this.f4252a) {
                            if (this.p.isEmpty()) {
                                if (this.d != this.c) {
                                    boolean z10 = this.c;
                                    this.d = this.c;
                                    GLTextureView.f4244b.notifyAll();
                                    Log.i("GLThread", "mPaused is now " + this.d + " tid=" + getId());
                                    z = z10;
                                } else {
                                    z = false;
                                }
                                if (this.j) {
                                    Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());
                                    j();
                                    k();
                                    this.j = false;
                                    z9 = true;
                                }
                                if (z5) {
                                    j();
                                    k();
                                    z5 = false;
                                }
                                if (z && this.i) {
                                    Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());
                                    j();
                                }
                                if (z && this.h) {
                                    GLTextureView gLTextureView = this.s.get();
                                    if (!(gLTextureView != null && gLTextureView.m) || GLTextureView.f4244b.a()) {
                                        k();
                                        Log.i("GLThread", "releasing EGL context because paused tid=" + getId());
                                    }
                                }
                                if (z && GLTextureView.f4244b.b()) {
                                    this.r.f();
                                    Log.i("GLThread", "terminating EGL because paused tid=" + getId());
                                }
                                if (!this.e && !this.g) {
                                    Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());
                                    if (this.i) {
                                        j();
                                    }
                                    this.g = true;
                                    this.f = false;
                                    GLTextureView.f4244b.notifyAll();
                                }
                                if (this.e && this.g) {
                                    Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());
                                    this.g = false;
                                    GLTextureView.f4244b.notifyAll();
                                }
                                if (z8) {
                                    Log.i("GLThread", "sending render notification tid=" + getId());
                                    z7 = false;
                                    z8 = false;
                                    this.o = true;
                                    GLTextureView.f4244b.notifyAll();
                                }
                                if (m()) {
                                    if (!this.h) {
                                        if (z9) {
                                            z9 = false;
                                        } else if (GLTextureView.f4244b.b(this)) {
                                            try {
                                                this.r.a();
                                                this.h = true;
                                                z2 = true;
                                                GLTextureView.f4244b.notifyAll();
                                            } catch (RuntimeException e) {
                                                GLTextureView.f4244b.c(this);
                                                throw e;
                                            }
                                        }
                                    }
                                    if (this.h && !this.i) {
                                        this.i = true;
                                        z3 = true;
                                        z4 = true;
                                        z6 = true;
                                    }
                                    if (this.i) {
                                        if (this.q) {
                                            z6 = true;
                                            i2 = this.k;
                                            i = this.l;
                                            z7 = true;
                                            Log.i("GLThread", "noticing that we want render notification tid=" + getId());
                                            z3 = true;
                                            this.q = false;
                                        } else {
                                            i = i3;
                                        }
                                        this.n = false;
                                        GLTextureView.f4244b.notifyAll();
                                        i3 = i;
                                    }
                                }
                                Log.i("GLThread", "waiting tid=" + getId() + " mHaveEglContext: " + this.h + " mHaveEglSurface: " + this.i + " mPaused: " + this.d + " mHasSurface: " + this.e + " mSurfaceIsBad: " + this.f + " mWaitingForSurface: " + this.g + " mWidth: " + this.k + " mHeight: " + this.l + " mRequestRender: " + this.n + " mRenderMode: " + this.m);
                                GLTextureView.f4244b.wait();
                            } else {
                                runnable = this.p.remove(0);
                            }
                        }
                        synchronized (GLTextureView.f4244b) {
                            j();
                            k();
                        }
                        return;
                    }
                    if (runnable != null) {
                        runnable.run();
                        runnable = null;
                    } else {
                        if (z3) {
                            Log.w("GLThread", "egl createSurface");
                            if (this.r.b()) {
                                z3 = false;
                            } else {
                                synchronized (GLTextureView.f4244b) {
                                    this.f = true;
                                    GLTextureView.f4244b.notifyAll();
                                }
                            }
                        }
                        if (z4) {
                            GL10 gl103 = (GL10) this.r.c();
                            GLTextureView.f4244b.a(gl103);
                            z4 = false;
                            gl10 = gl103;
                        } else {
                            gl10 = gl102;
                        }
                        if (z2) {
                            Log.w("GLThread", "onSurfaceCreated");
                            GLTextureView gLTextureView2 = this.s.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.e.a(null, gLTextureView2.getWidth(), gLTextureView2.getHeight(), 0);
                            }
                            z2 = false;
                        }
                        if (z6) {
                            Log.w("GLThread", "onSurfaceChanged(" + i2 + ", " + i3 + ")");
                            GLTextureView gLTextureView3 = this.s.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.e.a(i2, i3);
                            }
                            z6 = false;
                        }
                        GLTextureView gLTextureView4 = this.s.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.e.a(gl10);
                        }
                        int d = this.r.d();
                        switch (d) {
                            case CommandMessage.COMMAND_BASE /* 12288 */:
                                break;
                            case 12302:
                                Log.i("GLThread", "egl context lost tid=" + getId());
                                z5 = true;
                                break;
                            default:
                                e.a("GLThread", "eglSwapBuffers", d);
                                synchronized (GLTextureView.f4244b) {
                                    this.f = true;
                                    GLTextureView.f4244b.notifyAll();
                                    break;
                                }
                        }
                        z8 = z7 ? true : z8;
                        gl102 = gl10;
                    }
                } catch (Throwable th) {
                    synchronized (GLTextureView.f4244b) {
                        j();
                        k();
                        throw th;
                    }
                }
            }
        }

        private boolean m() {
            return !this.d && this.e && !this.f && this.k > 0 && this.l > 0 && (this.n || this.m == 1);
        }

        public void a(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLTextureView.f4244b) {
                this.m = i;
                GLTextureView.f4244b.notifyAll();
            }
        }

        public void a(int i, int i2) {
            synchronized (GLTextureView.f4244b) {
                this.k = i;
                this.l = i2;
                this.q = true;
                this.n = true;
                this.o = false;
                GLTextureView.f4244b.notifyAll();
                while (!this.f4253b && !this.d && !this.o && a()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLTextureView.f4244b.wait();
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
            synchronized (GLTextureView.f4244b) {
                this.p.add(runnable);
                GLTextureView.f4244b.notifyAll();
            }
        }

        public boolean a() {
            return this.h && this.i && m();
        }

        public int b() {
            int i;
            synchronized (GLTextureView.f4244b) {
                i = this.m;
            }
            return i;
        }

        public void c() {
            synchronized (GLTextureView.f4244b) {
                this.n = true;
                GLTextureView.f4244b.notifyAll();
            }
        }

        public void d() {
            synchronized (GLTextureView.f4244b) {
                Log.i("GLThread", "surfaceCreated tid=" + getId());
                this.e = true;
                GLTextureView.f4244b.notifyAll();
                while (this.g && !this.f4253b) {
                    try {
                        GLTextureView.f4244b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (GLTextureView.f4244b) {
                Log.i("GLThread", "surfaceDestroyed tid=" + getId());
                this.e = false;
                GLTextureView.f4244b.notifyAll();
                while (!this.g && !this.f4253b) {
                    try {
                        GLTextureView.f4244b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (GLTextureView.f4244b) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.c = true;
                GLTextureView.f4244b.notifyAll();
                while (!this.f4253b && !this.d) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLTextureView.f4244b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            synchronized (GLTextureView.f4244b) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.c = false;
                this.n = true;
                this.o = false;
                GLTextureView.f4244b.notifyAll();
                while (!this.f4253b && this.d && !this.o) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLTextureView.f4244b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (GLTextureView.f4244b) {
                this.f4252a = true;
                GLTextureView.f4244b.notifyAll();
                while (!this.f4253b) {
                    try {
                        GLTextureView.f4244b.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.j = true;
            GLTextureView.f4244b.notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            try {
                l();
            } catch (InterruptedException e) {
            } finally {
                GLTextureView.f4244b.a(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private static String f4254a = "GLThreadManager";

        /* renamed from: b  reason: collision with root package name */
        private static final Class f4255b;
        private static final Method c;
        private boolean d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private f i;

        static {
            try {
                f4255b = Class.forName("android.os.SystemProperties");
                c = f4255b.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                c.setAccessible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private g() {
        }

        /* synthetic */ g(com.baidu.platform.comapi.map.h hVar) {
            this();
        }

        private void c() {
            if (this.d) {
                return;
            }
            try {
                this.e = ((Integer) c.invoke(null, "ro.opengles.version", 0)).intValue();
            } catch (Exception e) {
                this.e = 65536;
            }
            if (this.e >= 131072) {
                this.g = true;
            }
            Log.w(f4254a, "checkGLESVersion mGLESVersion = " + this.e + " mMultipleGLESContextsAllowed = " + this.g);
            this.d = true;
        }

        public synchronized void a(f fVar) {
            Log.i("GLThread", "exiting tid=" + fVar.getId());
            fVar.f4253b = true;
            if (this.i == fVar) {
                this.i = null;
            }
            notifyAll();
        }

        public synchronized void a(GL10 gl10) {
            synchronized (this) {
                if (!this.f) {
                    c();
                    String glGetString = gl10.glGetString(7937);
                    if (this.e < 131072) {
                        this.g = !glGetString.startsWith("Q3Dimension MSM7500 ");
                        notifyAll();
                    }
                    this.h = this.g ? false : true;
                    Log.w(f4254a, "checkGLDriver renderer = \"" + glGetString + "\" multipleContextsAllowed = " + this.g + " mLimitedGLESContexts = " + this.h);
                    this.f = true;
                }
            }
        }

        public synchronized boolean a() {
            return this.h;
        }

        public synchronized boolean b() {
            c();
            return !this.g;
        }

        public boolean b(f fVar) {
            if (this.i == fVar || this.i == null) {
                this.i = fVar;
                notifyAll();
                return true;
            }
            c();
            if (this.g) {
                return true;
            }
            if (this.i != null) {
                this.i.i();
            }
            return false;
        }

        public void c(f fVar) {
            if (this.i == fVar) {
                this.i = null;
            }
            notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class h extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f4256a = new StringBuilder();

        h() {
        }

        private void a() {
            if (this.f4256a.length() > 0) {
                this.f4256a.delete(0, this.f4256a.length());
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
                    this.f4256a.append(c);
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    private class i extends b {
        public i(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.f4245a = new com.baidu.platform.comapi.map.h(this);
        this.c = new WeakReference<>(this);
        b();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4245a = new com.baidu.platform.comapi.map.h(this);
        this.c = new WeakReference<>(this);
        b();
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4245a = new com.baidu.platform.comapi.map.h(this);
        this.c = new WeakReference<>(this);
        b();
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

    private void b() {
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this.f4245a);
    }

    private void c() {
        if (this.d != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public Bitmap captureImageFromSurface(int i2, int i3, int i4, int i5, Object obj, Bitmap.Config config) {
        return a(i2, i3, i4, i5, (GL10) obj, config);
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

    public int getDebugFlags() {
        return this.k;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.m;
    }

    public int getRenderMode() {
        return this.d.b();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.f);
        if (this.f && this.e != null) {
            int b2 = this.d != null ? this.d.b() : 1;
            this.d = new f(this.c);
            if (b2 != 1) {
                this.d.a(b2);
            }
            this.d.start();
        }
        this.f = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        if (this.d != null) {
            this.d.h();
        }
        this.f = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        if (this.d != null) {
            this.d.f();
        }
    }

    public void onResume() {
        if (this.d != null) {
            this.d.g();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        if (this.d != null) {
            this.d.a(runnable);
        }
    }

    public void requestRender() {
        if (this.d != null) {
            this.d.c();
        }
    }

    public void setDebugFlags(int i2) {
        this.k = i2;
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        c();
        this.g = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new i(z));
    }

    public void setEGLContextClientVersion(int i2) {
        c();
        this.l = i2;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        c();
        this.h = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        c();
        this.i = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.j = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.m = z;
    }

    public void setRenderMode(int i2) {
        this.d.a(i2);
    }

    public void setRenderer(ak akVar) {
        c();
        if (this.g == null) {
            this.g = new i(true);
        }
        if (this.h == null) {
            this.h = new c(this, null);
        }
        if (this.i == null) {
            this.i = new d(null);
        }
        this.e = akVar;
        this.d = new f(this.c);
        this.d.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        if (this.d != null) {
            this.d.a(i3, i4);
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        if (this.d != null) {
            this.d.d();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        if (this.d != null) {
            this.d.e();
        }
    }
}
