package com.baidu.ar.npc;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.ar.npc.ArBridge;
import com.baidu.ar.npc.RendererUtils;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Calendar;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class BaiduArView extends GLSurfaceView {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public c F;
    public GestureDetector.OnGestureListener H;

    /* renamed from: a  reason: collision with root package name */
    public ArBridge.d f4102a;

    /* renamed from: e  reason: collision with root package name */
    public GestureDetector f4103e;

    /* renamed from: f  reason: collision with root package name */
    public i f4104f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4105g;

    /* renamed from: h  reason: collision with root package name */
    public int f4106h;
    public float i;
    public float j;
    public float k;
    public float l;
    public long m;
    public boolean mNeedDestroy;
    public boolean mUpdating;
    public int n;
    public float o;
    public float p;
    public float q;
    public float r;
    public long s;
    public double t;
    public f u;
    public g v;
    public boolean x;
    public boolean y;
    public boolean z;

    /* renamed from: b  reason: collision with root package name */
    public static final String f4099b = BaiduArView.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4100c = true;

    /* renamed from: d  reason: collision with root package name */
    public static int f4101d = 30;
    public static final double[] w = {1.5707963267948966d, 3.141592653589793d};
    public static int G = 0;

    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i);

        void a(EGLContext eGLContext, int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f4107a;

        /* renamed from: b  reason: collision with root package name */
        public float f4108b;

        /* renamed from: c  reason: collision with root package name */
        public float f4109c;

        /* renamed from: d  reason: collision with root package name */
        public long f4110d;

        public c() {
        }

        public /* synthetic */ c(w wVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class e implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a  reason: collision with root package name */
        public static int f4119a = 12440;

        public e() {
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            Log.w(BaiduArView.f4099b, "onSurface creating OpenGL ES 2.0 context");
            Log.w("callseq", "onSurface creating OpenGL ES 2.0 context");
            BaiduArView.checkEglError("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{f4119a, 2, 12344});
            BaiduArView.checkEglError("After eglCreateContext", egl10);
            Log.d(BaiduArView.f4099b, "createContext");
            ArBridge.getInstance().setGLThreadID(Thread.currentThread().getId());
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Log.d(BaiduArView.f4099b, "onSurface destroyContext");
            Log.d("callseq", "onSurface destroyContext");
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            ArBridge.getInstance().setGLThreadID(-1L);
        }

        public /* synthetic */ e(w wVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<BaiduArView> f4120a;

        public f(BaiduArView baiduArView) {
            this.f4120a = new WeakReference<>(baiduArView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BaiduArView baiduArView;
            Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2 || (baiduArView = this.f4120a.get()) == null || (obj = message.obj) == null) {
                    return;
                }
                c cVar = (c) obj;
                if (!baiduArView.z) {
                    ArBridge.getInstance().a(j.EClick.ordinal(), cVar.f4107a, cVar.f4108b, cVar.f4109c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, cVar.f4110d);
                }
                ArBridge.getInstance().a(j.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
            } else if (this.f4120a.get() != null && this.f4120a.get().f4104f == i.EStatSingleFingerCandidate && this.f4120a.get().f4105g) {
                this.f4120a.get().f4104f = i.EStatLongPresss;
                if (this.f4120a.get().x || this.f4120a.get().D) {
                    return;
                }
                ArBridge.getInstance().a(j.ELongPress.ordinal(), this.f4120a.get().f4106h, this.f4120a.get().k, this.f4120a.get().l, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, Calendar.getInstance().getTimeInMillis());
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements GLSurfaceView.Renderer {

        /* renamed from: b  reason: collision with root package name */
        public int f4122b;

        /* renamed from: c  reason: collision with root package name */
        public int f4123c;

        /* renamed from: d  reason: collision with root package name */
        public int f4124d;

        /* renamed from: e  reason: collision with root package name */
        public int f4125e;

        /* renamed from: f  reason: collision with root package name */
        public long f4126f;

        /* renamed from: g  reason: collision with root package name */
        public int f4127g;

        /* renamed from: h  reason: collision with root package name */
        public RendererUtils.a f4128h;
        public b i;
        public volatile a j;

        public g() {
            this.f4122b = -1;
            this.f4123c = -1;
            this.f4124d = 0;
            this.f4125e = 0;
            this.f4126f = System.currentTimeMillis();
            this.f4127g = 0;
        }

        public void a(b bVar) {
            this.i = bVar;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            BaiduArView.this.mUpdating = true;
            if (this.f4127g > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.f4126f;
                int i = this.f4127g;
                if (currentTimeMillis < i) {
                    try {
                        Thread.sleep(i - currentTimeMillis);
                    } catch (Throwable unused) {
                    }
                }
                this.f4126f = System.currentTimeMillis();
            }
            if (this.i != null) {
                if (this.f4122b == -1) {
                    int createTexture = RendererUtils.createTexture(this.f4124d, this.f4125e);
                    this.f4123c = createTexture;
                    this.f4122b = RendererUtils.createFBO(createTexture, this.f4124d, this.f4125e, 33189);
                    this.f4128h = RendererUtils.createProgram();
                    this.i.a(((EGL10) EGLContext.getEGL()).eglGetCurrentContext(), this.f4124d, this.f4125e);
                }
                GLES20.glBindFramebuffer(36160, this.f4122b);
                ArBridge.getInstance().c();
                GLES20.glBindFramebuffer(36160, 0);
                RendererUtils.renderTexture(this.f4128h, this.f4123c, this.f4124d, this.f4125e);
                this.i.a(this.f4123c);
            } else {
                ArBridge.getInstance().c();
            }
            if (this.j != null) {
                this.j.a(a());
                this.j = null;
            }
            BaiduArView baiduArView = BaiduArView.this;
            baiduArView.mUpdating = false;
            if (baiduArView.mNeedDestroy) {
                ArBridge.getInstance().nativeDestroyCase();
                BaiduArView.this.mNeedDestroy = false;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Log.d(BaiduArView.f4099b, String.format("onSurfaceChanged thread name %s id %s width %d height %d", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(i2)));
            this.f4124d = i;
            this.f4125e = i2;
            this.f4123c = -1;
            this.f4122b = -1;
            this.f4128h = null;
            ArBridge.getInstance().setSize(i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Log.d(BaiduArView.f4099b, "onSurfaceCreated");
            ArBridge.getInstance().setGLJniEnv();
            ArBridge.getInstance().b();
        }

        public void a(int i) {
            if (i <= 0 || i > 60) {
                return;
            }
            this.f4127g = 1000 / i;
        }

        public void a(a aVar) {
            this.j = aVar;
        }

        private Bitmap a() {
            int width = BaiduArView.this.getWidth();
            int height = BaiduArView.this.getHeight();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, width, height, 6408, 5121, allocateDirect);
            allocateDirect.rewind();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            return createBitmap;
        }

        public /* synthetic */ g(BaiduArView baiduArView, w wVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public float f4129a;

        /* renamed from: b  reason: collision with root package name */
        public float f4130b;

        public h() {
        }

        public /* synthetic */ h(w wVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public enum i {
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

    /* loaded from: classes.dex */
    public enum j {
        EClick,
        ELongPress,
        EScroll,
        ETwoFingerScroll,
        EPinch,
        EUnPinch,
        EScrollAfterLongPress,
        EDoubleClick,
        EClear
    }

    public BaiduArView(Context context) {
        super(context);
        this.f4104f = i.EStatSingleFingerCandidate;
        this.f4105g = true;
        this.f4106h = -1;
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
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.f4102a = new z(this);
        this.H = new aa(this);
        init(true, 16, 0);
    }

    public static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError == 12288) {
                return;
            }
            Log.e(f4099b, String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
        }
    }

    private void clearStatus() {
        this.f4104f = i.EStatSingleFingerCandidate;
        this.f4105g = true;
        this.t = -1.0d;
        this.u.removeMessages(1);
        if (this.u.hasMessages(2)) {
            return;
        }
        ArBridge.getInstance().a(j.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
    }

    private double getAngleOfTwoLine(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f5 - f3;
        float f11 = f4 - f2;
        float f12 = f9 - f7;
        float f13 = f8 - f6;
        if (f10 / f11 == f12 / f13) {
            return -1.0d;
        }
        Log.d("touchopt", String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f11), Float.valueOf(f10), Float.valueOf(f13), Float.valueOf(f12)));
        double sqrt = ((f11 * f13) + (f10 * f12)) / (Math.sqrt((f11 * f11) + (f10 * f10)) * Math.sqrt((f13 * f13) + (f12 * f12)));
        Log.d("touchopt", String.format("cosAngle is %1.3f", Double.valueOf(sqrt)));
        return Math.acos(sqrt);
    }

    private double getDistance(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return Math.sqrt((f6 * f6) + (f7 * f7));
    }

    private float getFirstVelX(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.f4106h)) - this.k) / ((float) (motionEvent.getEventTime() - this.m));
    }

    private float getFirstVelY(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.f4106h)) - this.l) / ((float) (motionEvent.getEventTime() - this.m));
    }

    private float getFirstX(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.f4106h));
    }

    private float getFirstY(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.f4106h));
    }

    private h getIntersectOfTwoLines(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (getAngleOfTwoLine(f2, f3, f4, f5, f6, f7, f8, f9) > 0.0d) {
            float f10 = (f2 * f5) - (f3 * f4);
            float f11 = f6 - f8;
            float f12 = f2 - f4;
            float f13 = (f6 * f9) - (f8 * f7);
            float f14 = (f10 * f11) - (f12 * f13);
            float f15 = f7 - f9;
            float f16 = (f12 * f15) - ((f3 - f5) * f11);
            float f17 = f14 / f16;
            float f18 = ((f10 * f15) - ((f3 - (-f5)) * f13)) / f16;
            h hVar = new h(null);
            hVar.f4129a = f17;
            hVar.f4130b = f18;
            return hVar;
        }
        return null;
    }

    private float getSecondVelX(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.n)) - this.q) / ((float) (motionEvent.getEventTime() - this.s));
    }

    private float getSecondVelY(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.n)) - this.r) / ((float) (motionEvent.getEventTime() - this.s));
    }

    private float getSecondX(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.n));
    }

    private float getSecondY(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.n));
    }

    private void init(boolean z, int i2, int i3) {
        setZOrderMediaOverlay(true);
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new e(null));
        setEGLConfigChooser(z ? new d(8, 8, 8, 8, i2, i3) : new d(5, 6, 5, 0, i2, i3));
        g gVar = new g(this, null);
        this.v = gVar;
        int i4 = G;
        if (i4 != 0) {
            gVar.a(i4);
        }
        setRenderer(this.v);
        setOnClickListener(new y(this));
        this.f4103e = new GestureDetector(getContext(), this.H);
        this.u = new f(this);
    }

    private void sendDelayedClickEvent() {
        if (this.u.hasMessages(2)) {
            this.u.removeMessages(2);
            if (this.F != null) {
                if (!this.z) {
                    ArBridge arBridge = ArBridge.getInstance();
                    int ordinal = j.EClick.ordinal();
                    c cVar = this.F;
                    arBridge.a(ordinal, cVar.f4107a, cVar.f4108b, cVar.f4109c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, cVar.f4110d);
                }
                ArBridge.getInstance().a(j.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                this.F = null;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        ArBridge.getInstance().removeMessageHandeler(this.f4102a);
        Log.d(f4099b, MissionEvent.MESSAGE_PAUSE);
        Log.d("callseq", "BaiduArView::pause()");
        ArBridge.getInstance().a();
        ArBridge.getInstance().setArView(null);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        ArBridge.getInstance().registerMessageHandler(11, this.f4102a);
        super.onResume();
        Log.d(f4099b, MissionEvent.MESSAGE_RESUME);
        Log.d("callseq", "BaiduArView::resume()");
        ArBridge.getInstance().setArView(this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        float f2;
        float f3;
        float f4;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.E) {
            switch (ae.f4166a[this.f4104f.ordinal()]) {
                case 1:
                    if (motionEvent.getActionMasked() == 0) {
                        Log.d(f4099b, "touchinv Action Down when EStatSingleFingerCandidate");
                        this.f4106h = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.i = motionEvent.getX();
                        float y = motionEvent.getY();
                        this.j = y;
                        this.k = this.i;
                        this.l = y;
                        this.m = motionEvent.getEventTime();
                        if (this.u.hasMessages(2) && (cVar = this.F) != null && getDistance(cVar.f4108b, cVar.f4109c, motionEvent.getX(), motionEvent.getY()) > 20.0d) {
                            sendDelayedClickEvent();
                        }
                        this.u.sendEmptyMessageDelayed(1, 600L);
                        Log.d(f4099b, String.format("touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d", Float.valueOf(this.i), Float.valueOf(this.j), Long.valueOf(this.m), Integer.valueOf(this.f4106h)));
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        double distance = getDistance(this.i, this.j, motionEvent.getX(), motionEvent.getY());
                        Log.d(f4099b, String.format("touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Double.valueOf(distance)));
                        if (distance < 20.0d) {
                            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                                this.f4104f = i.EStatLongPresss;
                                if (!this.x && !this.D) {
                                    ArBridge.getInstance().a(j.ELongPress.ordinal(), this.f4106h, motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                }
                                this.u.removeMessages(1);
                            }
                        } else if (distance < 80.0d) {
                            this.f4105g = false;
                        } else {
                            sendDelayedClickEvent();
                            this.f4104f = i.EStatScroll;
                            if (!this.x && !this.B) {
                                ArBridge.getInstance().a(j.EScroll.ordinal(), this.f4106h, motionEvent.getX(), motionEvent.getY(), getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.u.removeMessages(1);
                        }
                        this.k = motionEvent.getX();
                        this.l = motionEvent.getY();
                        this.m = motionEvent.getEventTime();
                        break;
                    } else if (1 == motionEvent.getActionMasked()) {
                        if (getDistance(this.i, this.j, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300 && !this.x) {
                            if (this.A) {
                                if (!this.z) {
                                    ArBridge.getInstance().a(j.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                }
                            } else if (this.u.hasMessages(2)) {
                                this.u.removeMessages(2);
                                ArBridge.getInstance().a(j.EDoubleClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                            } else {
                                Message obtain = Message.obtain();
                                obtain.what = 2;
                                c cVar2 = new c(null);
                                cVar2.f4107a = motionEvent.getPointerId(0);
                                cVar2.f4108b = motionEvent.getX();
                                cVar2.f4109c = motionEvent.getY();
                                cVar2.f4110d = motionEvent.getDownTime();
                                obtain.obj = cVar2;
                                this.F = cVar2;
                                this.u.sendMessageDelayed(obtain, 400L);
                            }
                        }
                        clearStatus();
                        break;
                    } else if (5 == motionEvent.getActionMasked()) {
                        if (this.f4105g) {
                            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.n = pointerId;
                            this.o = motionEvent.getX(motionEvent.findPointerIndex(pointerId));
                            this.p = motionEvent.getY(motionEvent.findPointerIndex(this.n));
                            this.s = motionEvent.getEventTime();
                            this.q = this.o;
                            this.r = this.p;
                            this.f4104f = i.EStatTwoFingersCandidate;
                        } else {
                            this.f4104f = i.EStatUnknown;
                        }
                        sendDelayedClickEvent();
                        break;
                    }
                    break;
                case 2:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        float firstX = getFirstX(motionEvent);
                        float firstY = getFirstY(motionEvent);
                        float secondX = getSecondX(motionEvent);
                        float secondY = getSecondY(motionEvent);
                        double distance2 = getDistance(this.i, this.j, firstX, firstY);
                        double distance3 = getDistance(this.o, this.p, secondX, secondY);
                        if ((distance2 > 80.0d || distance3 > 80.0d) && distance2 > 20.0d && distance3 > 20.0d) {
                            f2 = secondY;
                            double angleOfTwoLine = getAngleOfTwoLine(this.i, this.j, firstX, firstY, this.o, this.p, secondX, f2);
                            Log.d("touchopt", String.format("the angle is %1.3f", Double.valueOf(angleOfTwoLine)));
                            if (angleOfTwoLine < 0.39269908169872414d) {
                                this.f4104f = i.EStatTwoFingersScroll;
                                if (this.x || this.C) {
                                    f3 = firstY;
                                } else {
                                    f3 = firstY;
                                    ArBridge.getInstance().a(j.ETwoFingerScroll.ordinal(), this.f4106h, firstX, f3, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.n, secondX, f2, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                                    Log.d("touchopt", "EStatTwoFingersScroll");
                                }
                                f4 = secondX;
                            } else {
                                f3 = firstY;
                                this.f4104f = i.EStatPinchAndUnpinch;
                                f4 = secondX;
                                this.t = getDistance(firstX, f3, f4, f2);
                            }
                        } else {
                            f2 = secondY;
                            f4 = secondX;
                            f3 = firstY;
                        }
                        this.k = firstX;
                        this.l = f3;
                        this.m = motionEvent.getEventTime();
                        this.q = f4;
                        this.r = f2;
                        this.s = motionEvent.getEventTime();
                        break;
                    } else {
                        this.f4104f = i.EStatUnknown;
                        break;
                    }
                    break;
                case 3:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (1 == motionEvent.getActionMasked()) {
                        clearStatus();
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        if (motionEvent.getEventTime() - this.m >= 1) {
                            float firstX2 = getFirstX(motionEvent);
                            float firstY2 = getFirstY(motionEvent);
                            if (!this.x && !this.B) {
                                ArBridge.getInstance().a(j.EScroll.ordinal(), this.f4106h, firstX2, firstY2, getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.k = firstX2;
                            this.l = firstY2;
                            this.m = motionEvent.getEventTime();
                            break;
                        }
                    } else {
                        this.f4104f = i.EStatUnknown;
                        break;
                    }
                    break;
                case 4:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        if (motionEvent.getEventTime() - this.m >= 1 && motionEvent.getEventTime() - this.s >= 1) {
                            float firstX3 = getFirstX(motionEvent);
                            float firstY3 = getFirstY(motionEvent);
                            float secondX2 = getSecondX(motionEvent);
                            float secondY2 = getSecondY(motionEvent);
                            if (!this.x && !this.C) {
                                ArBridge.getInstance().a(j.ETwoFingerScroll.ordinal(), this.f4106h, firstX3, firstY3, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.n, secondX2, secondY2, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                            }
                            this.k = firstX3;
                            this.l = firstY3;
                            this.m = motionEvent.getEventTime();
                            this.q = secondX2;
                            this.r = secondY2;
                            this.s = motionEvent.getEventTime();
                            break;
                        }
                    } else {
                        this.f4104f = i.EStatUnknown;
                        break;
                    }
                    break;
                case 5:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f4104f = i.EStatUnknown;
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        if (motionEvent.getEventTime() - this.m >= 1 && motionEvent.getEventTime() - this.s >= 1) {
                            float firstX4 = getFirstX(motionEvent);
                            float firstY4 = getFirstY(motionEvent);
                            float secondX3 = getSecondX(motionEvent);
                            float secondY3 = getSecondY(motionEvent);
                            double distance4 = getDistance(firstX4, firstY4, secondX3, secondY3);
                            if (distance4 > this.t) {
                                if (!this.x && !this.y) {
                                    ArBridge.getInstance().a(j.EUnPinch.ordinal(), this.f4106h, firstX4, firstY4, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.n, secondX3, secondY3, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                                }
                            } else if (!this.x && !this.y) {
                                ArBridge.getInstance().a(j.EPinch.ordinal(), this.f4106h, firstX4, firstY4, getFirstVelX(motionEvent), getFirstVelY(motionEvent), this.n, secondX3, secondY3, getSecondVelX(motionEvent), getSecondVelY(motionEvent), motionEvent.getEventTime());
                            }
                            this.t = distance4;
                            this.k = firstX4;
                            this.l = firstY4;
                            this.m = motionEvent.getEventTime();
                            this.q = secondX3;
                            this.r = secondY3;
                            this.s = motionEvent.getEventTime();
                            break;
                        }
                    } else {
                        this.f4104f = i.EStatUnknown;
                        break;
                    }
                    break;
                case 6:
                    if (2 == motionEvent.getActionMasked()) {
                        if (getDistance(this.i, this.j, motionEvent.getX(), motionEvent.getY()) > 80.0d) {
                            this.f4104f = i.EScrollAfterLongPress;
                            if (!this.x && !this.B) {
                                ArBridge.getInstance().a(j.EScrollAfterLongPress.ordinal(), this.f4106h, motionEvent.getX(), motionEvent.getY(), getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.k = getFirstX(motionEvent);
                            this.l = getFirstY(motionEvent);
                            this.m = motionEvent.getEventTime();
                            break;
                        }
                    } else if (1 == motionEvent.getActionMasked()) {
                        clearStatus();
                        break;
                    } else {
                        this.f4104f = i.EStatUnknown;
                        break;
                    }
                    break;
                case 7:
                    if (2 == motionEvent.getActionMasked()) {
                        if (!this.x && !this.B) {
                            ArBridge.getInstance().a(j.EScrollAfterLongPress.ordinal(), this.f4106h, motionEvent.getX(), motionEvent.getY(), getFirstVelX(motionEvent), getFirstVelY(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                        }
                        this.k = getFirstX(motionEvent);
                        this.l = getFirstY(motionEvent);
                        this.m = motionEvent.getEventTime();
                        break;
                    } else if (1 == motionEvent.getActionMasked()) {
                        clearStatus();
                        break;
                    } else {
                        this.f4104f = i.EStatUnknown;
                        break;
                    }
                    break;
                case 8:
                case 9:
                case 10:
                    if (1 == motionEvent.getActionMasked()) {
                        clearStatus();
                        break;
                    }
                    break;
            }
            return onTouchEvent;
        }
        return onTouchEvent;
    }

    public void setFrameRate(int i2) {
        G = i2;
        g gVar = this.v;
        if (gVar != null) {
            gVar.a(i2);
        }
    }

    public void setUserInteractionEnabled(boolean z) {
        this.E = z;
    }

    public void startRecord(b bVar) {
        queueEvent(new w(this, bVar));
    }

    public void stopRecord() {
        queueEvent(new x(this));
    }

    public void takeSnapshot(a aVar) {
        g gVar = this.v;
        if (gVar != null) {
            gVar.a(aVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: g  reason: collision with root package name */
        public static int f4111g = 4;

        /* renamed from: h  reason: collision with root package name */
        public static int[] f4112h = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12338, 1, 12337, 4, 12344};

        /* renamed from: a  reason: collision with root package name */
        public int f4113a;

        /* renamed from: b  reason: collision with root package name */
        public int f4114b;

        /* renamed from: c  reason: collision with root package name */
        public int f4115c;

        /* renamed from: d  reason: collision with root package name */
        public int f4116d;

        /* renamed from: e  reason: collision with root package name */
        public int f4117e;

        /* renamed from: f  reason: collision with root package name */
        public int f4118f;
        public int[] i = new int[1];

        public d(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f4113a = i;
            this.f4114b = i2;
            this.f4115c = i3;
            this.f4116d = i4;
            this.f4117e = i5;
            this.f4118f = i6;
        }

        private void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            Log.e(BaiduArView.f4099b, String.format("%d configurations", Integer.valueOf(length)));
            for (int i = 0; i < length; i++) {
                Log.e(BaiduArView.f4099b, String.format("Configuration %d:\n", Integer.valueOf(i)));
                a(egl10, eGLDisplay, eGLConfigArr[i]);
            }
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.f4117e && a3 >= this.f4118f) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.f4113a && a5 == this.f4114b && a6 == this.f4115c && a7 == this.f4116d && a2 >= this.f4117e) {
                        Log.d(BaiduArView.f4099b, "get the config");
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            Log.w("callseq", "chooseConfig called");
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, f4112h, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                int[] iArr2 = f4112h;
                iArr2[11] = 2;
                egl10.eglChooseConfig(eGLDisplay, iArr2, null, 0, iArr);
                i = iArr[0];
                if (i <= 0) {
                    int[] iArr3 = f4112h;
                    iArr3[8] = 12344;
                    egl10.eglChooseConfig(eGLDisplay, iArr3, null, 0, iArr);
                    i = iArr[0];
                }
            }
            int i2 = i;
            if (i2 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                egl10.eglChooseConfig(eGLDisplay, f4112h, eGLConfigArr, i2, iArr);
                if (BaiduArView.f4100c) {
                    b(egl10, eGLDisplay, eGLConfigArr);
                }
                return a(egl10, eGLDisplay, eGLConfigArr);
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.i) ? this.i[0] : i2;
        }

        private void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < 17; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                    Log.w(BaiduArView.f4099b, String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
                } else {
                    do {
                    } while (egl10.eglGetError() != 12288);
                }
            }
        }
    }

    public BaiduArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4104f = i.EStatSingleFingerCandidate;
        this.f4105g = true;
        this.f4106h = -1;
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
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.f4102a = new z(this);
        this.H = new aa(this);
        init(true, 16, 0);
    }

    public BaiduArView(Context context, boolean z, int i2, int i3) {
        super(context);
        this.f4104f = i.EStatSingleFingerCandidate;
        this.f4105g = true;
        this.f4106h = -1;
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
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.f4102a = new z(this);
        this.H = new aa(this);
        init(z, i2, i3);
    }
}
