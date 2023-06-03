package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.heytap.mcssdk.constant.MessageConstant;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
@Keep
/* loaded from: classes3.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final h a = new h();
    public final WeakReference<GLTextureView> b;
    public g c;
    public GLSurfaceView.Renderer d;
    public boolean e;
    public e f;
    public GLSurfaceView.EGLContextFactory g;
    public GLSurfaceView.EGLWindowSurfaceFactory h;
    public GLSurfaceView.GLWrapper i;
    public int j;
    public int k;
    public boolean l;

    /* loaded from: classes3.dex */
    public interface e {
        EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* loaded from: classes3.dex */
    public abstract class a implements e {
        public int[] a;

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            this.a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (Build.VERSION.SDK_INT < 23) {
                if (GLTextureView.this.k != 2) {
                    return iArr;
                }
            } else if (GLTextureView.this.k != 2 && GLTextureView.this.k != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (GLTextureView.this.k == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // com.baidu.cyberplayer.sdk.GLTextureView.e
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.a, null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.a, eGLConfigArr, i, iArr)) {
                        EGLConfig a = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a != null) {
                            return a;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* loaded from: classes3.dex */
    public class b extends a {
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int[] j;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, i, MonitorType.MONITOR_TYPE_INIT_WEBKIT, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.j = new int[1];
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.j)) {
                return this.j[0];
            }
            return i2;
        }

        @Override // com.baidu.cyberplayer.sdk.GLTextureView.a
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a >= this.g && a2 >= this.h) {
                    int a3 = a(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a3 == this.c && a4 == this.d && a5 == this.e && a6 == this.f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements GLSurfaceView.EGLContextFactory {
        public int b;

        public c() {
            this.b = 12440;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.b, GLTextureView.this.k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                f.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements GLSurfaceView.EGLWindowSurfaceFactory {
        public d() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                Log.e(com.baidu.searchbox.afx.gl.GLTextureView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public EGL10 a;
        public EGLDisplay b;
        public EGLSurface c;
        public EGLConfig d;
        public EGLContext e;
        public WeakReference<GLTextureView> f;

        public f(WeakReference<GLTextureView> weakReference) {
            this.f = weakReference;
        }

        private void a(String str) {
            a(str, this.a.eglGetError());
        }

        public static void a(String str, int i) {
            b(str, i);
        }

        public static String b(String str, int i) {
            return str + " failed: " + i;
        }

        public static void a(String str, String str2, int i) {
            Log.w(str, b(str2, i));
        }

        private void g() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.c;
            if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = this.f.get();
                if (gLTextureView != null) {
                    gLTextureView.h.destroySurface(this.a, this.b, this.c);
                }
                this.c = null;
            }
        }

        public int d() {
            if (!this.a.eglSwapBuffers(this.b, this.c)) {
                return this.a.eglGetError();
            }
            return MessageConstant.CommandId.COMMAND_BASE;
        }

        public void e() {
            g();
        }

        public void f() {
            if (this.e != null) {
                GLTextureView gLTextureView = this.f.get();
                if (gLTextureView != null) {
                    gLTextureView.g.destroyContext(this.a, this.b, this.e);
                }
                this.e = null;
            }
            EGLDisplay eGLDisplay = this.b;
            if (eGLDisplay != null) {
                this.a.eglTerminate(eGLDisplay);
                this.b = null;
            }
        }

        public void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.a.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.f.get();
                    if (gLTextureView == null) {
                        this.d = null;
                        this.e = null;
                    } else {
                        this.d = gLTextureView.f.a(this.a, this.b);
                        this.e = gLTextureView.g.createContext(this.a, this.b, this.d);
                    }
                    EGLContext eGLContext = this.e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.e = null;
                        a("createContext");
                    }
                    this.c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean b() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.d != null) {
                        g();
                        GLTextureView gLTextureView = this.f.get();
                        if (gLTextureView != null) {
                            this.c = gLTextureView.h.createWindowSurface(this.a, this.b, this.d, gLTextureView.getSurfaceTexture());
                        } else {
                            this.c = null;
                        }
                        EGLSurface eGLSurface = this.c;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (!this.a.eglMakeCurrent(this.b, eGLSurface, eGLSurface, this.e)) {
                                a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
                                return false;
                            }
                            return true;
                        }
                        if (this.a.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public GL c() {
            GL gl = this.e.getGL();
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
                if (gLTextureView.i != null) {
                    gl = gLTextureView.i.wrap(gl);
                }
                if ((gLTextureView.j & 3) != 0) {
                    int i = 0;
                    i iVar = null;
                    if ((gLTextureView.j & 1) != 0) {
                        i = 1;
                    }
                    if ((gLTextureView.j & 2) != 0) {
                        iVar = new i();
                    }
                    return GLDebugHelper.wrap(gl, i, iVar);
                }
                return gl;
            }
            return gl;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends Thread {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean o;
        public f r;
        public WeakReference<GLTextureView> s;
        public ArrayList<Runnable> p = new ArrayList<>();
        public boolean q = true;
        public int k = 0;
        public int l = 0;
        public boolean n = true;
        public int m = 1;

        public g(WeakReference<GLTextureView> weakReference) {
            this.s = weakReference;
        }

        public void a(int i) {
            if (i >= 0 && i <= 1) {
                synchronized (GLTextureView.a) {
                    this.m = i;
                    GLTextureView.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
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
                GLTextureView.a.c(this);
            }
        }

        private boolean m() {
            if (!this.d && this.e && !this.f && this.k > 0 && this.l > 0 && (this.n || this.m == 1)) {
                return true;
            }
            return false;
        }

        public boolean a() {
            if (this.h && this.i && m()) {
                return true;
            }
            return false;
        }

        public int b() {
            int i;
            synchronized (GLTextureView.a) {
                i = this.m;
            }
            return i;
        }

        public void c() {
            synchronized (GLTextureView.a) {
                this.n = true;
                GLTextureView.a.notifyAll();
            }
        }

        public void d() {
            synchronized (GLTextureView.a) {
                this.e = true;
                GLTextureView.a.notifyAll();
                while (this.g && !this.b) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            synchronized (GLTextureView.a) {
                this.e = false;
                GLTextureView.a.notifyAll();
                while (!this.g && !this.b) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void f() {
            synchronized (GLTextureView.a) {
                this.c = true;
                GLTextureView.a.notifyAll();
                while (!this.b && !this.d) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            synchronized (GLTextureView.a) {
                this.a = true;
                GLTextureView.a.notifyAll();
                while (!this.b) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void i() {
            this.j = true;
            GLTextureView.a.notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                l();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.a.a(this);
                throw th;
            }
            GLTextureView.a.a(this);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private void l() throws InterruptedException {
            boolean z;
            boolean z2;
            boolean z3;
            this.r = new f(this.s);
            this.h = false;
            this.i = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            GL10 gl10 = null;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            int i = 0;
            int i2 = 0;
            boolean z11 = false;
            while (true) {
                Runnable runnable = null;
                while (true) {
                    try {
                        synchronized (GLTextureView.a) {
                            while (!this.a) {
                                if (!this.p.isEmpty()) {
                                    runnable = this.p.remove(0);
                                } else {
                                    if (this.d != this.c) {
                                        z = this.c;
                                        this.d = this.c;
                                        GLTextureView.a.notifyAll();
                                    } else {
                                        z = false;
                                    }
                                    if (this.j) {
                                        j();
                                        k();
                                        this.j = false;
                                        z6 = true;
                                    }
                                    if (z4) {
                                        j();
                                        k();
                                        z4 = false;
                                    }
                                    if (z && this.i) {
                                        j();
                                    }
                                    if (z && this.h) {
                                        GLTextureView gLTextureView = this.s.get();
                                        if (gLTextureView != null) {
                                            z3 = gLTextureView.l;
                                        } else {
                                            z3 = false;
                                        }
                                        if (!z3 || GLTextureView.a.a()) {
                                            k();
                                        }
                                    }
                                    if (z && GLTextureView.a.b()) {
                                        this.r.f();
                                    }
                                    if (!this.e && !this.g) {
                                        if (this.i) {
                                            j();
                                        }
                                        this.g = true;
                                        this.f = false;
                                        GLTextureView.a.notifyAll();
                                    }
                                    if (this.e && this.g) {
                                        this.g = false;
                                        GLTextureView.a.notifyAll();
                                    }
                                    if (z5) {
                                        this.o = true;
                                        GLTextureView.a.notifyAll();
                                        z5 = false;
                                        z11 = false;
                                    }
                                    if (m()) {
                                        if (!this.h) {
                                            if (z6) {
                                                z6 = false;
                                            } else if (GLTextureView.a.b(this)) {
                                                try {
                                                    this.r.a();
                                                    this.h = true;
                                                    GLTextureView.a.notifyAll();
                                                    z7 = true;
                                                } catch (RuntimeException e) {
                                                    GLTextureView.a.c(this);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.h && !this.i) {
                                            this.i = true;
                                            z8 = true;
                                            z9 = true;
                                            z10 = true;
                                        }
                                        if (this.i) {
                                            if (this.q) {
                                                int i3 = this.k;
                                                int i4 = this.l;
                                                this.q = false;
                                                i = i3;
                                                i2 = i4;
                                                z2 = false;
                                                z8 = true;
                                                z10 = true;
                                                z11 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            this.n = z2;
                                            GLTextureView.a.notifyAll();
                                        }
                                    }
                                    GLTextureView.a.wait();
                                }
                            }
                            synchronized (GLTextureView.a) {
                                j();
                                k();
                            }
                            return;
                        }
                        if (runnable != null) {
                            break;
                        }
                        if (z8) {
                            if (!this.r.b()) {
                                synchronized (GLTextureView.a) {
                                    this.f = true;
                                    GLTextureView.a.notifyAll();
                                }
                            } else {
                                z8 = false;
                            }
                        }
                        if (z9) {
                            gl10 = (GL10) this.r.c();
                            GLTextureView.a.a(gl10);
                            z9 = false;
                        }
                        if (z7) {
                            GLTextureView gLTextureView2 = this.s.get();
                            if (gLTextureView2 != null) {
                                gLTextureView2.d.onSurfaceCreated(gl10, this.r.d);
                            }
                            z7 = false;
                        }
                        if (z10) {
                            GLTextureView gLTextureView3 = this.s.get();
                            if (gLTextureView3 != null) {
                                gLTextureView3.d.onSurfaceChanged(gl10, i, i2);
                            }
                            z10 = false;
                        }
                        GLTextureView gLTextureView4 = this.s.get();
                        if (gLTextureView4 != null) {
                            gLTextureView4.d.onDrawFrame(gl10);
                        }
                        int d = this.r.d();
                        if (d != 12288) {
                            if (d != 12302) {
                                f.a("GLThread", "eglSwapBuffers", d);
                                synchronized (GLTextureView.a) {
                                    this.f = true;
                                    GLTextureView.a.notifyAll();
                                }
                            } else {
                                z4 = true;
                            }
                        }
                        if (z11) {
                            z5 = true;
                        }
                    } catch (Throwable th) {
                        synchronized (GLTextureView.a) {
                            j();
                            k();
                            throw th;
                        }
                    }
                }
                runnable.run();
            }
        }

        public void a(int i, int i2) {
            synchronized (GLTextureView.a) {
                this.k = i;
                this.l = i2;
                this.q = true;
                this.n = true;
                this.o = false;
                GLTextureView.a.notifyAll();
                while (!this.b && !this.d && !this.o && a()) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureView.a) {
                    this.p.add(runnable);
                    GLTextureView.a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void g() {
            synchronized (GLTextureView.a) {
                this.c = false;
                this.n = true;
                this.o = false;
                GLTextureView.a.notifyAll();
                while (!this.b && this.d && !this.o) {
                    try {
                        GLTextureView.a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static String a = "GLThreadManager";
        public boolean b;
        public int c;
        public boolean d;
        public boolean e;
        public boolean f;
        public g g;

        public h() {
        }

        private void c() {
            if (!this.b) {
                this.b = true;
            }
        }

        public synchronized boolean a() {
            return this.f;
        }

        public synchronized boolean b() {
            c();
            return !this.e;
        }

        public synchronized void a(g gVar) {
            gVar.b = true;
            if (this.g == gVar) {
                this.g = null;
            }
            notifyAll();
        }

        public boolean b(g gVar) {
            g gVar2 = this.g;
            if (gVar2 != gVar && gVar2 != null) {
                c();
                if (this.e) {
                    return true;
                }
                g gVar3 = this.g;
                if (gVar3 != null) {
                    gVar3.i();
                    return false;
                }
                return false;
            }
            this.g = gVar;
            notifyAll();
            return true;
        }

        public void c(g gVar) {
            if (this.g == gVar) {
                this.g = null;
            }
            notifyAll();
        }

        public synchronized void a(GL10 gl10) {
            boolean z;
            if (!this.d) {
                c();
                String glGetString = gl10.glGetString(7937);
                boolean z2 = false;
                if (this.c < 131072) {
                    if (!glGetString.startsWith(GLTextureView.GLThreadManager.kMSM7K_RENDERER_PREFIX)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.e = z;
                    notifyAll();
                }
                if (!this.e) {
                    z2 = true;
                }
                this.f = z2;
                this.d = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends Writer {
        public StringBuilder a = new StringBuilder();

        private void a() {
            if (this.a.length() > 0) {
                Log.v(com.baidu.searchbox.afx.gl.GLTextureView.TAG, this.a.toString());
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
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
                    this.a.append(c);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends b {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public j(boolean z) {
            super(8, 8, 8, 0, r6, 0);
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
        }
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    private void b() {
        if (this.c == null) {
            return;
        }
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public void finalize() throws Throwable {
        try {
            if (this.c != null) {
                this.c.h();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.j;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.l;
    }

    public int getRenderMode() {
        return this.c.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        int i2;
        super.onAttachedToWindow();
        if (this.e && this.d != null) {
            g gVar = this.c;
            if (gVar != null) {
                i2 = gVar.b();
            } else {
                i2 = 1;
            }
            g gVar2 = new g(this.b);
            this.c = gVar2;
            if (i2 != 1) {
                gVar2.a(i2);
            }
            this.c.start();
        }
        this.e = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        g gVar = this.c;
        if (gVar != null) {
            gVar.h();
        }
        this.e = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.c.f();
    }

    public void onResume() {
        this.c.g();
    }

    public void requestRender() {
        this.c.c();
    }

    public GLTextureView(Context context) {
        super(context);
        this.b = new WeakReference<>(this);
        a();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    public void queueEvent(Runnable runnable) {
        this.c.a(runnable);
    }

    public void setDebugFlags(int i2) {
        this.j = i2;
    }

    public void setEGLConfigChooser(e eVar) {
        b();
        this.f = eVar;
    }

    public void setEGLContextClientVersion(int i2) {
        b();
        this.k = i2;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        b();
        this.g = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        b();
        this.h = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.i = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.l = z;
    }

    public void setRenderMode(int i2) {
        this.c.a(i2);
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.c.d();
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        this.c.e();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new WeakReference<>(this);
        a();
    }

    public void onLayoutChange(View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        surfaceChanged(getSurfaceTexture(), 0, i4 - i2, i5 - i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        surfaceChanged(surfaceTexture, 0, i2, i3);
    }

    public void setEGLConfigChooser(int i2, int i3, int i4, int i5, int i6, int i7) {
        setEGLConfigChooser(new b(i2, i3, i4, i5, i6, i7));
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new j(z));
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        b();
        if (this.f == null) {
            this.f = new j(true);
        }
        if (this.g == null) {
            this.g = new c();
        }
        if (this.h == null) {
            this.h = new d();
        }
        this.d = renderer;
        g gVar = new g(this.b);
        this.c = gVar;
        gVar.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i2, int i3, int i4) {
        this.c.a(i3, i4);
    }
}
