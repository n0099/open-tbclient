package com.baidu.ar.opengl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.ar.g;
import com.baidu.ar.util.Constants;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.RendererUtils;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.Calendar;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class BaiduArView extends GLSurfaceView {
    private static com.baidu.ar.f.f J;
    private static byte[] K;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private c F;
    private boolean H;
    private boolean I;
    private GestureDetector.OnGestureListener L;
    ArBridge.MessageHandler a;
    private GestureDetector e;
    private TouchEventStatus f;
    private boolean g;
    private int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private long m;
    private int n;
    private float o;
    private float p;
    private float q;
    private float r;
    private long s;
    private double t;
    private f u;
    private g v;
    private boolean x;
    private boolean y;
    private boolean z;
    private static final String b = BaiduArView.class.getSimpleName();
    private static boolean c = true;
    private static int d = 30;
    private static final double[] w = {1.5707963267948966d, 3.141592653589793d};
    private static int G = 0;

    /* loaded from: classes3.dex */
    public enum TouchEventStatus {
        EStatSingleFingerCandidate,
        EStatTwoFingersCandidate,
        EStatLongPresss,
        EStatScroll,
        EStatTwoFingersScroll,
        EStatPinch,
        EStatUnPinch,
        EScrollAfterLongPress,
        EStatPinchAndUnpinch,
        EStatUnknown
    }

    /* loaded from: classes3.dex */
    public enum TouchEventType {
        EClick,
        ELongPress,
        EScroll,
        ETwoFingerScroll,
        EPinch,
        EUnPinch,
        EScrollAfterLongPress,
        EDoubleClick,
        EClear,
        ESCROLL_DOWN,
        ESHAKE,
        ESCROLL_UP
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(int[] iArr, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);

        void a(EGLContext eGLContext, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        public int a;
        public float b;
        public float c;
        public long d;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d implements GLSurfaceView.EGLConfigChooser {
        private static int g = 4;
        private static int[] h = {12324, 4, 12323, 4, 12322, 4, 12352, g, 12344};
        protected int a;
        protected int b;
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        private int[] i = new int[1];

        public d(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.i) ? this.i[0] : i2;
        }

        private void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                    com.baidu.ar.util.b.a(String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
                } else {
                    do {
                    } while (egl10.eglGetError() != 12288);
                }
            }
        }

        private void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            com.baidu.ar.util.b.a(String.format("%d configurations", Integer.valueOf(length)));
            for (int i = 0; i < length; i++) {
                com.baidu.ar.util.b.a(String.format("Configuration %d:\n", Integer.valueOf(i)));
                a(egl10, eGLDisplay, eGLConfigArr[i]);
            }
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
                    if (a3 == this.a && a4 == this.b && a5 == this.c && a6 == this.d && a >= this.e) {
                        Log.d(BaiduArView.b, "get the config");
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            com.baidu.ar.util.b.a("callseq chooseConfig called");
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, h, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, h, eGLConfigArr, i, iArr);
            if (BaiduArView.c) {
                b(egl10, eGLDisplay, eGLConfigArr);
            }
            return a(egl10, eGLDisplay, eGLConfigArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e implements GLSurfaceView.EGLContextFactory {
        private static int a = 12440;

        private e() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            com.baidu.ar.util.b.a("onSurface creating OpenGL ES 2.0 context");
            com.baidu.ar.util.b.a("callseq onSurface creating OpenGL ES 2.0 context");
            BaiduArView.b("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{a, 2, 12344});
            BaiduArView.b("After eglCreateContext", egl10);
            Log.d(BaiduArView.b, "createContext");
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Log.d(BaiduArView.b, "onSurface destroyContext");
            Log.d("callseq", "onSurface destroyContext");
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class f extends Handler {
        WeakReference<BaiduArView> a;

        public f(BaiduArView baiduArView) {
            this.a = new WeakReference<>(baiduArView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (this.a.get() != null && this.a.get().f == TouchEventStatus.EStatSingleFingerCandidate && this.a.get().g) {
                        this.a.get().f = TouchEventStatus.EStatLongPresss;
                        if (this.a.get().x || this.a.get().D) {
                            return;
                        }
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), this.a.get().h, this.a.get().k, this.a.get().l, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, Calendar.getInstance().getTimeInMillis());
                        return;
                    }
                    return;
                case 2:
                    BaiduArView baiduArView = this.a.get();
                    if (baiduArView == null || message.obj == null) {
                        return;
                    }
                    c cVar = (c) message.obj;
                    if (!baiduArView.z) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), cVar.a, cVar.b, cVar.c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, cVar.d);
                    }
                    ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class g implements GLSurfaceView.Renderer {
        com.baidu.ar.opengl.a.b a;
        private RendererUtils.RenderContext r;
        private b s;
        private volatile a t;
        private com.baidu.ar.opengl.a.a v;
        private com.baidu.ar.f.f w;
        private com.baidu.ar.f.f x;
        private int j = -1;
        private int k = -1;
        private int l = -1;
        private int m = 0;
        private int n = 0;
        private boolean o = false;
        private long p = System.currentTimeMillis();
        private int q = 0;
        boolean b = false;
        int c = 0;
        boolean d = false;
        boolean e = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        private SurfaceTexture u = new SurfaceTexture(-1);

        g() {
            if (Build.VERSION.SDK_INT >= 16) {
                this.u.detachFromGLContext();
            }
            this.v = com.baidu.ar.opengl.a.a.a();
            this.a = new com.baidu.ar.opengl.a.b();
        }

        private void b() {
            if (this.f || !this.b) {
                return;
            }
            ArBridge.getInstance().initAREngine();
            ArBridge.getInstance().setEnginGLJniEnv();
            this.f = true;
        }

        private void c() {
            if (!this.g && this.b && this.f && this.o) {
                if (this.w == null) {
                    this.w = new com.baidu.ar.f.f(this.m, this.n);
                }
                this.w.a = this.m;
                this.w.b = this.n;
                ArBridge.getInstance().setSurface(this.u, this.w.a, this.w.b);
                ArBridge.getInstance().setSize(this.w.a, this.w.b);
                this.g = true;
            }
        }

        private void d() {
            boolean z;
            float f;
            if (this.x == null || !this.o || this.h) {
                return;
            }
            int min = Math.min(this.x.a, this.x.b);
            float min2 = (Math.min(this.m, this.n) * 1.0f) / min;
            float max = (Math.max(this.m, this.n) * 1.0f) / Math.max(this.x.a, this.x.b);
            if (Float.compare(max, min2) < 0) {
                f = max / min2;
                z = true;
            } else {
                z = false;
                f = min2 / max;
            }
            if (z) {
                if (this.v != null) {
                    this.v.a(f);
                    this.v.a(1, -90.0f, 1.0f, 1.0f);
                }
            } else if (this.v != null) {
                this.v.b(f);
                this.v.a(1, -90.0f, 1.0f, 1.0f);
            }
            if (this.a != null) {
                this.a.a(1, 180.0f, 1.0f, 1.0f);
            }
            this.h = true;
        }

        private void e() {
            com.baidu.ar.util.b.a("draw camera in sync mode");
            long currentTimeMillis = Constants.DEBUG_PREVIEW_FRAME ? System.currentTimeMillis() : 0L;
            if (BaiduArView.J == null) {
                return;
            }
            this.v.a(BaiduArView.J.a, BaiduArView.J.b);
            if (Constants.DEBUG_PREVIEW_FRAME) {
                com.baidu.ar.util.b.d("bdar: Camera in BaiduArView draw time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }

        private void f() {
            if (BaiduArView.K == null || BaiduArView.J == null) {
                return;
            }
            this.v.b(BaiduArView.J.a, BaiduArView.J.b, BaiduArView.K);
        }

        private void g() {
            if (BaiduArView.K == null || BaiduArView.J == null) {
                return;
            }
            this.v.a(BaiduArView.J.a, BaiduArView.J.b, BaiduArView.K);
            this.d = true;
            this.e = false;
        }

        private void h() {
            if (this.l <= -1) {
                com.baidu.ar.util.b.a("bdar: mSurfaceTextureId = " + this.l);
                int createTexture = RendererUtils.createTexture();
                if (createTexture <= -1) {
                    com.baidu.ar.util.b.d("bdar: create texture id <= -1, Invalid ID!!!!");
                }
                if (this.u != null && Build.VERSION.SDK_INT >= 16) {
                    this.u.attachToGLContext(createTexture);
                }
                this.l = createTexture;
                this.a.a(this.l);
            }
            if (this.u != null) {
                this.u.updateTexImage();
            }
        }

        private void i() {
            if (this.a != null) {
                if (this.c > 3) {
                    this.a.b();
                } else if (this.b) {
                    this.c++;
                }
            }
        }

        public void a() {
            com.baidu.ar.util.b.a("bdar onContextDestroy");
            if (this.s != null) {
                this.s.a(null, 0, 0);
            }
            if (this.t != null) {
                this.t.a(null, 0, 0);
                this.t = null;
            }
            if (this.u != null && this.l >= 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.u.detachFromGLContext();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.l >= 0) {
                GLES20.glDeleteTextures(1, new int[]{this.l}, 0);
            }
            this.l = -1;
            if (this.v != null) {
                this.v.c();
            }
            if (this.a != null) {
                this.a.a();
            }
            this.c = 0;
            this.d = false;
            this.e = false;
            this.w = null;
            this.x = null;
            this.f = false;
            this.g = false;
            this.m = 0;
            this.n = 0;
            this.o = false;
            this.i = true;
        }

        public void a(int i) {
            if (i <= 0 || i > 60) {
                return;
            }
            this.q = 1000 / i;
        }

        public void a(com.baidu.ar.f.f fVar) {
            if (fVar != null) {
                this.x = new com.baidu.ar.f.f(fVar.a, fVar.b);
            }
        }

        public void a(a aVar) {
            this.t = aVar;
        }

        public void a(b bVar) {
            this.s = bVar;
            if (this.s != null) {
                this.e = true;
            } else {
                this.e = false;
            }
        }

        public void a(GL10 gl10) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            e();
            i();
            GLES20.glDisable(3042);
        }

        public void a(boolean z) {
            this.b = z;
        }

        public void b(GL10 gl10) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            g();
            i();
            GLES20.glDisable(3042);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (this.i) {
                return;
            }
            b();
            c();
            d();
            if (this.q > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.p;
                if (currentTimeMillis < this.q) {
                    try {
                        Thread.sleep(this.q - currentTimeMillis);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.p = System.currentTimeMillis();
            }
            if (this.s != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (this.j == -1) {
                    this.k = RendererUtils.createTexture(this.m, this.n);
                    this.j = RendererUtils.createFBO(this.k, this.m, this.n, 33189);
                    this.r = RendererUtils.createProgram();
                    this.s.a(((EGL10) EGLContext.getEGL()).eglGetCurrentContext(), this.m, this.n);
                    GLES20.glBindFramebuffer(36160, this.j);
                    GLES20.glViewport(0, 0, this.m, this.n);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16640);
                    GLES20.glBindFramebuffer(36160, 0);
                }
                h();
                GLES20.glBindFramebuffer(36160, this.j);
                if (this.e) {
                    b(gl10);
                } else {
                    a(gl10);
                }
                f();
                GLES20.glBindFramebuffer(36160, 0);
                RendererUtils.renderTexture(this.r, this.k, this.m, this.n);
                this.s.a(this.k);
                com.baidu.ar.util.b.a("bdar: spendTime is " + (System.currentTimeMillis() - currentTimeMillis2) + ", texture id is " + this.k + ", SurfaceTextureID is " + this.l);
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                h();
                if (this.d) {
                    a(gl10);
                } else {
                    b(gl10);
                }
                f();
                com.baidu.ar.util.b.a("bdar: spendTime is " + (System.currentTimeMillis() - currentTimeMillis3));
            }
            if (this.t != null) {
                int i = this.m;
                int i2 = this.n;
                int[] iArr = new int[i * i2];
                IntBuffer wrap = IntBuffer.wrap(iArr);
                wrap.position(0);
                wrap.rewind();
                GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
                this.t.a(iArr, i, i2);
                this.t = null;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            com.baidu.ar.util.b.a(String.format("onSurfaceChanged thread name %s id %s width %d height %d", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(i2)));
            GLES20.glViewport(0, 0, i, i2);
            g.a aVar = new g.a();
            aVar.b = i2;
            aVar.a = i;
            com.baidu.ar.g.a().a(aVar);
            this.m = i;
            this.n = i2;
            com.baidu.ar.util.b.a("bdar: glview Width = " + this.m + ", height = " + this.n);
            this.k = -1;
            this.j = -1;
            this.r = null;
            if (this.u != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.u.detachFromGLContext();
                        com.baidu.ar.util.b.a("bdar: mSurfaceTexture.detachFromGLContext()");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.l = -1;
            this.o = true;
            this.h = false;
            this.g = false;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            com.baidu.ar.util.b.a("onSurfaceCreated");
            this.i = false;
        }
    }

    public BaiduArView(Context context) {
        super(context);
        this.f = TouchEventStatus.EStatSingleFingerCandidate;
        this.g = true;
        this.h = -1;
        this.i = -1.0f;
        this.j = -1.0f;
        this.k = -1.0f;
        this.l = -1.0f;
        this.m = -1L;
        this.n = -1;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1.0f;
        this.s = -1L;
        this.t = -1.0d;
        this.v = null;
        this.x = false;
        this.y = true;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = null;
        this.H = true;
        this.I = false;
        this.a = new ArBridge.MessageHandler() { // from class: com.baidu.ar.opengl.BaiduArView.9
            @Override // com.baidu.baiduarsdk.ArBridge.MessageHandler
            public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            BaiduArView.this.x = true;
                        } else {
                            BaiduArView.this.x = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            BaiduArView.this.y = true;
                        } else {
                            BaiduArView.this.y = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            BaiduArView.this.z = true;
                        } else {
                            BaiduArView.this.z = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            BaiduArView.this.B = true;
                        } else {
                            BaiduArView.this.B = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            BaiduArView.this.D = true;
                        } else {
                            BaiduArView.this.D = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            BaiduArView.this.A = true;
                        } else {
                            BaiduArView.this.A = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            BaiduArView.this.C = true;
                        } else {
                            BaiduArView.this.C = false;
                        }
                    }
                }
            }
        };
        this.L = new GestureDetector.OnGestureListener() { // from class: com.baidu.ar.opengl.BaiduArView.10
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(final MotionEvent motionEvent) {
                if (BaiduArView.this.I) {
                    BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.10.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(BaiduArView.b, "touch onLongPress " + motionEvent);
                            long timeInMillis = Calendar.getInstance().getTimeInMillis();
                            if (BaiduArView.this.x || BaiduArView.this.D) {
                                return;
                            }
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    });
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float f2, final float f3) {
                if (BaiduArView.this.I) {
                    BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(BaiduArView.b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", motionEvent.toString(), motionEvent2.toString(), Float.valueOf(f2), Float.valueOf(f3)));
                            long timeInMillis = Calendar.getInstance().getTimeInMillis();
                            if (BaiduArView.this.x || !BaiduArView.this.B) {
                                return;
                            }
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, motionEvent2.getPointerId(0), motionEvent2.getX(), motionEvent2.getY(), f2, f3, timeInMillis);
                        }
                    });
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                if (BaiduArView.this.I) {
                    BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(BaiduArView.b, "touch on single tap with motionEvnet " + motionEvent);
                            long timeInMillis = Calendar.getInstance().getTimeInMillis();
                            Log.d(BaiduArView.b, "touch timeInMils " + timeInMillis);
                            if (BaiduArView.this.x || BaiduArView.this.z) {
                                return;
                            }
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    });
                }
                return false;
            }
        };
        a(true, 16, 0);
    }

    public BaiduArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = TouchEventStatus.EStatSingleFingerCandidate;
        this.g = true;
        this.h = -1;
        this.i = -1.0f;
        this.j = -1.0f;
        this.k = -1.0f;
        this.l = -1.0f;
        this.m = -1L;
        this.n = -1;
        this.o = -1.0f;
        this.p = -1.0f;
        this.q = -1.0f;
        this.r = -1.0f;
        this.s = -1L;
        this.t = -1.0d;
        this.v = null;
        this.x = false;
        this.y = true;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = null;
        this.H = true;
        this.I = false;
        this.a = new ArBridge.MessageHandler() { // from class: com.baidu.ar.opengl.BaiduArView.9
            @Override // com.baidu.baiduarsdk.ArBridge.MessageHandler
            public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            BaiduArView.this.x = true;
                        } else {
                            BaiduArView.this.x = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            BaiduArView.this.y = true;
                        } else {
                            BaiduArView.this.y = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            BaiduArView.this.z = true;
                        } else {
                            BaiduArView.this.z = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            BaiduArView.this.B = true;
                        } else {
                            BaiduArView.this.B = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            BaiduArView.this.D = true;
                        } else {
                            BaiduArView.this.D = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            BaiduArView.this.A = true;
                        } else {
                            BaiduArView.this.A = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            BaiduArView.this.C = true;
                        } else {
                            BaiduArView.this.C = false;
                        }
                    }
                }
            }
        };
        this.L = new GestureDetector.OnGestureListener() { // from class: com.baidu.ar.opengl.BaiduArView.10
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(final MotionEvent motionEvent) {
                if (BaiduArView.this.I) {
                    BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.10.3
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(BaiduArView.b, "touch onLongPress " + motionEvent);
                            long timeInMillis = Calendar.getInstance().getTimeInMillis();
                            if (BaiduArView.this.x || BaiduArView.this.D) {
                                return;
                            }
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    });
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float f2, final float f3) {
                if (BaiduArView.this.I) {
                    BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(BaiduArView.b, String.format("touch onScroll begin motionevent %s and end motion event %s and speed %1.2f, %1.2f ", motionEvent.toString(), motionEvent2.toString(), Float.valueOf(f2), Float.valueOf(f3)));
                            long timeInMillis = Calendar.getInstance().getTimeInMillis();
                            if (BaiduArView.this.x || !BaiduArView.this.B) {
                                return;
                            }
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, motionEvent2.getPointerId(0), motionEvent2.getX(), motionEvent2.getY(), f2, f3, timeInMillis);
                        }
                    });
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(final MotionEvent motionEvent) {
                if (BaiduArView.this.I) {
                    BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Log.d(BaiduArView.b, "touch on single tap with motionEvnet " + motionEvent);
                            long timeInMillis = Calendar.getInstance().getTimeInMillis();
                            Log.d(BaiduArView.b, "touch timeInMils " + timeInMillis);
                            if (BaiduArView.this.x || BaiduArView.this.z) {
                                return;
                            }
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, timeInMillis);
                        }
                    });
                }
                return false;
            }
        };
        a(true, 16, 0);
    }

    private double a(float f2, float f3, float f4, float f5) {
        return Math.sqrt(((f4 - f2) * (f4 - f2)) + ((f5 - f3) * (f5 - f3)));
    }

    private double a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if ((f5 - f3) / (f4 - f2) == (f9 - f7) / (f8 - f6)) {
            return -1.0d;
        }
        float f10 = f4 - f2;
        float f11 = f5 - f3;
        float f12 = f8 - f6;
        float f13 = f9 - f7;
        com.baidu.ar.util.b.a(String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13)));
        double sqrt = ((f10 * f12) + (f11 * f13)) / (Math.sqrt((f10 * f10) + (f11 * f11)) * Math.sqrt((f12 * f12) + (f13 * f13)));
        com.baidu.ar.util.b.a("touchopt" + String.format("cosAngle is %1.3f", Double.valueOf(sqrt)));
        return Math.acos(sqrt);
    }

    private float a(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.h)) - this.k) / ((float) (motionEvent.getEventTime() - this.m));
    }

    private void a(boolean z, int i, int i2) {
        setZOrderMediaOverlay(true);
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new e());
        setEGLConfigChooser(z ? new d(8, 8, 8, 8, i, i2) : new d(5, 6, 5, 0, i, i2));
        this.v = new g();
        if (G != 0) {
            this.v.a(G);
        }
        setRenderer(this.v);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.opengl.BaiduArView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
            }
        });
        this.e = new GestureDetector(getContext(), this.L);
        this.u = new f(this);
    }

    public static void a(byte[] bArr, com.baidu.ar.f.f fVar) {
        if (Constants.DEBUG_PREVIEW_FRAME) {
            System.currentTimeMillis();
        }
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        if (J == null) {
            try {
                J = fVar;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (K == null || K.length != bArr.length) {
            K = new byte[bArr.length];
        }
        System.arraycopy(bArr, 0, K, 0, bArr.length);
    }

    private float b(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.h)) - this.l) / ((float) (motionEvent.getEventTime() - this.m));
    }

    public static void b() {
        K = null;
        J = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return;
            }
            com.baidu.ar.util.b.d(String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
        }
    }

    private float c(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.n)) - this.q) / ((float) (motionEvent.getEventTime() - this.s));
    }

    private float d(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.n)) - this.r) / ((float) (motionEvent.getEventTime() - this.s));
    }

    private float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.h));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float f(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.h));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private float g(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(motionEvent.findPointerIndex(this.n));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private void g() {
        this.f = TouchEventStatus.EStatSingleFingerCandidate;
        this.g = true;
        this.t = -1.0d;
        this.u.removeMessages(1);
        if (this.u.hasMessages(2)) {
            return;
        }
        ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
    }

    private float h(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(motionEvent.findPointerIndex(this.n));
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    private void h() {
        if (this.u.hasMessages(2)) {
            this.u.removeMessages(2);
            if (this.F != null) {
                if (!this.z) {
                    ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), this.F.a, this.F.b, this.F.c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, this.F.d);
                }
                ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                this.F = null;
            }
        }
    }

    public void a(final com.baidu.ar.b bVar) {
        queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.7
            @Override // java.lang.Runnable
            public void run() {
                bVar.a();
            }
        });
    }

    public void a(final com.baidu.ar.b bVar, final com.baidu.ar.recorder.b bVar2) {
        com.baidu.ar.util.b.a("startRecord!!!");
        queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.6
            @Override // java.lang.Runnable
            public void run() {
                BaiduArView.this.v.a(bVar);
                bVar.a(bVar2);
            }
        });
    }

    public void a(final com.baidu.ar.f.f fVar) {
        queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaiduArView.this.v != null) {
                    BaiduArView.this.v.a(fVar);
                }
            }
        });
    }

    public void a(a aVar) {
        if (this.v != null) {
            this.v.a(aVar);
        }
    }

    public boolean a() {
        return this.I;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        ArBridge.getInstance().removeMessageHandeler(this.a);
        com.baidu.ar.util.b.a("onPause");
        com.baidu.ar.util.b.a("callseq, BaiduArView::pause()");
        if (this.I) {
            ArBridge.getInstance().onPauseByUser();
            ArBridge.getInstance().clearScreen();
            ArBridge.getInstance().requestRenderAndWait();
        }
        Runnable runnable = new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.4
            @Override // java.lang.Runnable
            public void run() {
                BaiduArView.this.queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaiduArView.this.v.a();
                    }
                });
                BaiduArView.super.onPause();
            }
        };
        if (this.H) {
            post(runnable);
        } else {
            runnable.run();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        ArBridge.getInstance().registerMessageHandler(11, this.a);
        super.onResume();
        com.baidu.ar.util.b.a("onResume");
        com.baidu.ar.util.b.a("callseq, BaiduArView::resume()");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.I && this.E) {
            switch (this.f) {
                case EStatSingleFingerCandidate:
                    if (motionEvent.getActionMasked() != 0) {
                        if (2 != motionEvent.getActionMasked()) {
                            if (1 != motionEvent.getActionMasked()) {
                                if (5 == motionEvent.getActionMasked()) {
                                    if (this.g) {
                                        this.n = motionEvent.getPointerId(motionEvent.getActionIndex());
                                        this.o = motionEvent.getX(motionEvent.findPointerIndex(this.n));
                                        this.p = motionEvent.getY(motionEvent.findPointerIndex(this.n));
                                        this.s = motionEvent.getEventTime();
                                        this.q = this.o;
                                        this.r = this.p;
                                        this.f = TouchEventStatus.EStatTwoFingersCandidate;
                                    } else {
                                        this.f = TouchEventStatus.EStatUnknown;
                                    }
                                    h();
                                    break;
                                }
                            } else {
                                if (a(this.i, this.j, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300 && !this.x) {
                                    if (this.A) {
                                        if (!this.z) {
                                            ArBridge.getInstance().onTouchEvent(TouchEventType.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                        }
                                    } else if (this.u.hasMessages(2)) {
                                        this.u.removeMessages(2);
                                        ArBridge.getInstance().onTouchEvent(TouchEventType.EDoubleClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                    } else {
                                        Message obtain = Message.obtain();
                                        obtain.what = 2;
                                        c cVar = new c();
                                        cVar.a = motionEvent.getPointerId(0);
                                        cVar.b = motionEvent.getX();
                                        cVar.c = motionEvent.getY();
                                        cVar.d = motionEvent.getDownTime();
                                        obtain.obj = cVar;
                                        this.F = cVar;
                                        this.u.sendMessageDelayed(obtain, 400L);
                                    }
                                }
                                ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                                g();
                                break;
                            }
                        } else {
                            double a2 = a(this.i, this.j, motionEvent.getX(), motionEvent.getY());
                            com.baidu.ar.util.b.a(String.format("touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Double.valueOf(a2)));
                            if (a2 < 20.0d) {
                                if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                                    this.f = TouchEventStatus.EStatLongPresss;
                                    if (!this.x && !this.D) {
                                        ArBridge.getInstance().onTouchEvent(TouchEventType.ELongPress.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                    }
                                    this.u.removeMessages(1);
                                }
                            } else if (a2 < 80.0d) {
                                this.g = false;
                            } else {
                                h();
                                this.f = TouchEventStatus.EStatScroll;
                                if (!this.x && !this.B) {
                                    ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                                }
                                this.u.removeMessages(1);
                            }
                            this.k = motionEvent.getX();
                            this.l = motionEvent.getY();
                            this.m = motionEvent.getEventTime();
                            break;
                        }
                    } else {
                        com.baidu.ar.util.b.a("touchinv Action Down when EStatSingleFingerCandidate");
                        this.h = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.i = motionEvent.getX();
                        this.j = motionEvent.getY();
                        this.k = this.i;
                        this.l = this.j;
                        this.m = motionEvent.getEventTime();
                        if (this.u.hasMessages(2) && this.F != null && a(this.F.b, this.F.c, motionEvent.getX(), motionEvent.getY()) > 100.0d) {
                            h();
                        }
                        this.u.sendEmptyMessageDelayed(1, 600L);
                        com.baidu.ar.util.b.a(String.format("touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d", Float.valueOf(this.i), Float.valueOf(this.j), Long.valueOf(this.m), Integer.valueOf(this.h)));
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_DOWN.ordinal(), this.h, this.i, this.j, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, this.m);
                        ArBridge.getInstance().onTouchEvent(TouchEventType.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        break;
                    }
                    break;
                case EStatTwoFingersCandidate:
                    if (5 != motionEvent.getActionMasked()) {
                        if (6 != motionEvent.getActionMasked()) {
                            if (2 != motionEvent.getActionMasked()) {
                                this.f = TouchEventStatus.EStatUnknown;
                                break;
                            } else {
                                float e2 = e(motionEvent);
                                float f2 = f(motionEvent);
                                float g2 = g(motionEvent);
                                float h = h(motionEvent);
                                double a3 = a(this.i, this.j, e2, f2);
                                double a4 = a(this.o, this.p, g2, h);
                                if ((a3 > 80.0d || a4 > 80.0d) && a3 > 20.0d && a4 > 20.0d) {
                                    double a5 = a(this.i, this.j, e2, f2, this.o, this.p, g2, h);
                                    Log.d("touchopt", String.format("the angle is %1.3f", Double.valueOf(a5)));
                                    if (a5 < 0.39269908169872414d) {
                                        this.f = TouchEventStatus.EStatTwoFingersScroll;
                                        if (!this.x && !this.C) {
                                            ArBridge.getInstance().onTouchEvent(TouchEventType.ETwoFingerScroll.ordinal(), this.h, e2, f2, a(motionEvent), b(motionEvent), this.n, g2, h, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                                            Log.d("touchopt", "EStatTwoFingersScroll");
                                        }
                                    } else {
                                        this.f = TouchEventStatus.EStatPinchAndUnpinch;
                                        this.t = a(e2, f2, g2, h);
                                    }
                                }
                                this.k = e2;
                                this.l = f2;
                                this.m = motionEvent.getEventTime();
                                this.q = g2;
                                this.r = h;
                                this.s = motionEvent.getEventTime();
                                break;
                            }
                        } else {
                            this.f = TouchEventStatus.EStatUnknown;
                            break;
                        }
                    } else {
                        this.f = TouchEventStatus.EStatUnknown;
                        break;
                    }
                    break;
                case EStatScroll:
                    if (5 != motionEvent.getActionMasked()) {
                        if (6 != motionEvent.getActionMasked()) {
                            if (1 != motionEvent.getActionMasked()) {
                                if (2 != motionEvent.getActionMasked()) {
                                    this.f = TouchEventStatus.EStatUnknown;
                                    break;
                                } else if (motionEvent.getEventTime() - this.m >= 1) {
                                    float e3 = e(motionEvent);
                                    float f3 = f(motionEvent);
                                    if (!this.x && !this.B) {
                                        ArBridge.getInstance().onTouchEvent(TouchEventType.EScroll.ordinal(), this.h, e3, f3, a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                                    }
                                    this.k = e3;
                                    this.l = f3;
                                    this.m = motionEvent.getEventTime();
                                    break;
                                }
                            } else {
                                ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                                g();
                                break;
                            }
                        } else {
                            this.f = TouchEventStatus.EStatUnknown;
                            break;
                        }
                    } else {
                        this.f = TouchEventStatus.EStatUnknown;
                        break;
                    }
                    break;
                case EStatTwoFingersScroll:
                    if (5 != motionEvent.getActionMasked()) {
                        if (6 != motionEvent.getActionMasked()) {
                            if (2 != motionEvent.getActionMasked()) {
                                this.f = TouchEventStatus.EStatUnknown;
                                break;
                            } else if (motionEvent.getEventTime() - this.m >= 1 && motionEvent.getEventTime() - this.s >= 1) {
                                float e4 = e(motionEvent);
                                float f4 = f(motionEvent);
                                float g3 = g(motionEvent);
                                float h2 = h(motionEvent);
                                if (!this.x && !this.C) {
                                    ArBridge.getInstance().onTouchEvent(TouchEventType.ETwoFingerScroll.ordinal(), this.h, e4, f4, a(motionEvent), b(motionEvent), this.n, g3, h2, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                                }
                                this.k = e4;
                                this.l = f4;
                                this.m = motionEvent.getEventTime();
                                this.q = g3;
                                this.r = h2;
                                this.s = motionEvent.getEventTime();
                                break;
                            }
                        } else {
                            this.f = TouchEventStatus.EStatUnknown;
                            break;
                        }
                    } else {
                        this.f = TouchEventStatus.EStatUnknown;
                        break;
                    }
                    break;
                case EStatPinchAndUnpinch:
                    if (5 != motionEvent.getActionMasked()) {
                        if (6 != motionEvent.getActionMasked()) {
                            if (2 != motionEvent.getActionMasked()) {
                                this.f = TouchEventStatus.EStatUnknown;
                                break;
                            } else if (motionEvent.getEventTime() - this.m >= 1 && motionEvent.getEventTime() - this.s >= 1) {
                                float e5 = e(motionEvent);
                                float f5 = f(motionEvent);
                                float g4 = g(motionEvent);
                                float h3 = h(motionEvent);
                                double a6 = a(e5, f5, g4, h3);
                                if (a6 > this.t) {
                                    if (!this.x && !this.y) {
                                        ArBridge.getInstance().onTouchEvent(TouchEventType.EUnPinch.ordinal(), this.h, e5, f5, a(motionEvent), b(motionEvent), this.n, g4, h3, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                                    }
                                } else if (!this.x && !this.y) {
                                    ArBridge.getInstance().onTouchEvent(TouchEventType.EPinch.ordinal(), this.h, e5, f5, a(motionEvent), b(motionEvent), this.n, g4, h3, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                                }
                                this.t = a6;
                                this.k = e5;
                                this.l = f5;
                                this.m = motionEvent.getEventTime();
                                this.q = g4;
                                this.r = h3;
                                this.s = motionEvent.getEventTime();
                                break;
                            }
                        } else {
                            this.f = TouchEventStatus.EStatUnknown;
                            if (((motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) == this.h) {
                                this.h = this.n;
                                break;
                            }
                        }
                    } else {
                        this.f = TouchEventStatus.EStatUnknown;
                        break;
                    }
                    break;
                case EStatLongPresss:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 != motionEvent.getActionMasked()) {
                            this.f = TouchEventStatus.EStatUnknown;
                            break;
                        } else {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                            g();
                            break;
                        }
                    } else if (a(this.i, this.j, motionEvent.getX(), motionEvent.getY()) > 80.0d) {
                        this.f = TouchEventStatus.EScrollAfterLongPress;
                        if (!this.x && !this.B) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScrollAfterLongPress.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                        }
                        this.k = e(motionEvent);
                        this.l = f(motionEvent);
                        this.m = motionEvent.getEventTime();
                        break;
                    }
                    break;
                case EScrollAfterLongPress:
                    if (2 != motionEvent.getActionMasked()) {
                        if (1 != motionEvent.getActionMasked()) {
                            this.f = TouchEventStatus.EStatUnknown;
                            break;
                        } else {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                            g();
                            break;
                        }
                    } else {
                        if (!this.x && !this.B) {
                            ArBridge.getInstance().onTouchEvent(TouchEventType.EScrollAfterLongPress.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                        }
                        this.k = e(motionEvent);
                        this.l = f(motionEvent);
                        this.m = motionEvent.getEventTime();
                        break;
                    }
                    break;
                case EStatPinch:
                case EStatUnPinch:
                case EStatUnknown:
                    if (1 == motionEvent.getActionMasked()) {
                        ArBridge.getInstance().onTouchEvent(TouchEventType.ESCROLL_UP.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        g();
                        break;
                    }
                    break;
            }
            return onTouchEvent;
        }
        return onTouchEvent;
    }

    public void setEnginSoLoaded(final boolean z) {
        this.I = z;
        queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BaiduArView.this.v != null) {
                    BaiduArView.this.v.a(z);
                }
            }
        });
    }

    public void setFrameRate(int i) {
        G = i;
        if (this.v != null) {
            this.v.a(i);
        }
    }

    public void setNeedClearScreenOnPause(boolean z) {
        this.H = z;
    }

    public void setRecorder(final b bVar) {
        queueEvent(new Runnable() { // from class: com.baidu.ar.opengl.BaiduArView.5
            @Override // java.lang.Runnable
            public void run() {
                BaiduArView.this.v.a(bVar);
            }
        });
    }

    public void setUserInteractionEnabled(boolean z) {
        this.E = z;
    }
}
