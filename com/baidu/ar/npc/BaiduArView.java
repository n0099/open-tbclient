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
/* loaded from: classes26.dex */
public class BaiduArView extends GLSurfaceView {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private c F;
    private GestureDetector.OnGestureListener H;

    /* renamed from: a  reason: collision with root package name */
    ArBridge.d f1200a;
    private GestureDetector e;
    private h f;
    private boolean g;
    private int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private long m;
    public boolean mNeedDestroy;
    public boolean mUpdating;
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

    /* loaded from: classes26.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes26.dex */
    public interface b {
        void a(int i);

        void a(EGLContext eGLContext, int i, int i2);
    }

    /* loaded from: classes26.dex */
    public enum h {
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

    /* loaded from: classes26.dex */
    public enum i {
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
        this.f = h.EStatSingleFingerCandidate;
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
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.f1200a = new z(this);
        this.H = new aa(this);
        a(true, 16, 0);
    }

    public BaiduArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = h.EStatSingleFingerCandidate;
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
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.f1200a = new z(this);
        this.H = new aa(this);
        a(true, 16, 0);
    }

    public BaiduArView(Context context, boolean z, int i2, int i3) {
        super(context);
        this.f = h.EStatSingleFingerCandidate;
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
        this.mNeedDestroy = false;
        this.mUpdating = false;
        this.f1200a = new z(this);
        this.H = new aa(this);
        a(z, i2, i3);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        ArBridge.getInstance().registerMessageHandler(11, this.f1200a);
        super.onResume();
        Log.d(b, MissionEvent.MESSAGE_RESUME);
        Log.d("callseq", "BaiduArView::resume()");
        ArBridge.getInstance().setArView(this);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        ArBridge.getInstance().removeMessageHandeler(this.f1200a);
        Log.d(b, MissionEvent.MESSAGE_PAUSE);
        Log.d("callseq", "BaiduArView::pause()");
        ArBridge.getInstance().a();
        ArBridge.getInstance().setArView(null);
        super.onPause();
    }

    public void setFrameRate(int i2) {
        G = i2;
        if (this.v != null) {
            this.v.a(i2);
        }
    }

    public void startRecord(b bVar) {
        queueEvent(new w(this, bVar));
    }

    public void stopRecord() {
        queueEvent(new x(this));
    }

    public void takeSnapshot(a aVar) {
        if (this.v != null) {
            this.v.a(aVar);
        }
    }

    public void setUserInteractionEnabled(boolean z) {
        this.E = z;
    }

    private void a(boolean z, int i2, int i3) {
        setZOrderMediaOverlay(true);
        if (z) {
            getHolder().setFormat(-3);
        }
        setEGLContextFactory(new e(null));
        setEGLConfigChooser(z ? new d(8, 8, 8, 8, i2, i3) : new d(5, 6, 5, 0, i2, i3));
        this.v = new g(this, null);
        if (G != 0) {
            this.v.a(G);
        }
        setRenderer(this.v);
        setOnClickListener(new y(this));
        this.e = new GestureDetector(getContext(), this.H);
        this.u = new f(this);
    }

    private void c() {
        this.f = h.EStatSingleFingerCandidate;
        this.g = true;
        this.t = -1.0d;
        this.u.removeMessages(1);
        if (!this.u.hasMessages(2)) {
            ArBridge.getInstance().a(i.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
        }
    }

    private float a(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.h)) - this.k) / ((float) (motionEvent.getEventTime() - this.m));
    }

    private float b(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.h)) - this.l) / ((float) (motionEvent.getEventTime() - this.m));
    }

    private float c(MotionEvent motionEvent) {
        return (motionEvent.getX(motionEvent.findPointerIndex(this.n)) - this.q) / ((float) (motionEvent.getEventTime() - this.s));
    }

    private float d(MotionEvent motionEvent) {
        return (motionEvent.getY(motionEvent.findPointerIndex(this.n)) - this.r) / ((float) (motionEvent.getEventTime() - this.s));
    }

    private float e(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.h));
    }

    private float f(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.h));
    }

    private float g(MotionEvent motionEvent) {
        return motionEvent.getX(motionEvent.findPointerIndex(this.n));
    }

    private float h(MotionEvent motionEvent) {
        return motionEvent.getY(motionEvent.findPointerIndex(this.n));
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
        Log.d("touchopt", String.format("vx1 %1.3f vy1 %1.3f vx2 %1.3f vy2 %1.3f", Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13)));
        double sqrt = ((f10 * f12) + (f11 * f13)) / (Math.sqrt((f10 * f10) + (f11 * f11)) * Math.sqrt((f12 * f12) + (f13 * f13)));
        Log.d("touchopt", String.format("cosAngle is %1.3f", Double.valueOf(sqrt)));
        return Math.acos(sqrt);
    }

    private void d() {
        if (this.u.hasMessages(2)) {
            this.u.removeMessages(2);
            if (this.F != null) {
                if (!this.z) {
                    ArBridge.getInstance().a(i.EClick.ordinal(), this.F.f1201a, this.F.b, this.F.c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, this.F.d);
                }
                ArBridge.getInstance().a(i.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                this.F = null;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.E) {
            switch (ae.f1215a[this.f.ordinal()]) {
                case 1:
                    if (motionEvent.getActionMasked() == 0) {
                        Log.d(b, "touchinv Action Down when EStatSingleFingerCandidate");
                        this.h = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.i = motionEvent.getX();
                        this.j = motionEvent.getY();
                        this.k = this.i;
                        this.l = this.j;
                        this.m = motionEvent.getEventTime();
                        if (this.u.hasMessages(2) && this.F != null && a(this.F.b, this.F.c, motionEvent.getX(), motionEvent.getY()) > 20.0d) {
                            d();
                        }
                        this.u.sendEmptyMessageDelayed(1, 600L);
                        Log.d(b, String.format("touchinv Action Down when EStatSingleFingerCandidate x %1.1f, y %1.1f, time %d id %d", Float.valueOf(this.i), Float.valueOf(this.j), Long.valueOf(this.m), Integer.valueOf(this.h)));
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        double a2 = a(this.i, this.j, motionEvent.getX(), motionEvent.getY());
                        Log.d(b, String.format("touchinv Action Move when EStatSingleFingerCandidate x %1.1f, y %1.1f, distance %1.2f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Double.valueOf(a2)));
                        if (a2 < 20.0d) {
                            if (motionEvent.getEventTime() - motionEvent.getDownTime() > 600) {
                                this.f = h.EStatLongPresss;
                                if (!this.x && !this.D) {
                                    ArBridge.getInstance().a(i.ELongPress.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                }
                                this.u.removeMessages(1);
                            }
                        } else if (a2 < 80.0d) {
                            this.g = false;
                        } else {
                            d();
                            this.f = h.EStatScroll;
                            if (!this.x && !this.B) {
                                ArBridge.getInstance().a(i.EScroll.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.u.removeMessages(1);
                        }
                        this.k = motionEvent.getX();
                        this.l = motionEvent.getY();
                        this.m = motionEvent.getEventTime();
                        break;
                    } else if (1 == motionEvent.getActionMasked()) {
                        if (a(this.i, this.j, motionEvent.getX(), motionEvent.getY()) < 20.0d && motionEvent.getEventTime() - motionEvent.getDownTime() < 300 && !this.x) {
                            if (this.A) {
                                if (!this.z) {
                                    ArBridge.getInstance().a(i.EClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                                }
                            } else if (this.u.hasMessages(2)) {
                                this.u.removeMessages(2);
                                ArBridge.getInstance().a(i.EDoubleClick.ordinal(), motionEvent.getPointerId(0), motionEvent.getX(), motionEvent.getY(), -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getDownTime());
                            } else {
                                Message obtain = Message.obtain();
                                obtain.what = 2;
                                c cVar = new c(null);
                                cVar.f1201a = motionEvent.getPointerId(0);
                                cVar.b = motionEvent.getX();
                                cVar.c = motionEvent.getY();
                                cVar.d = motionEvent.getDownTime();
                                obtain.obj = cVar;
                                this.F = cVar;
                                this.u.sendMessageDelayed(obtain, 400L);
                            }
                        }
                        c();
                        break;
                    } else if (5 == motionEvent.getActionMasked()) {
                        if (this.g) {
                            this.n = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.o = motionEvent.getX(motionEvent.findPointerIndex(this.n));
                            this.p = motionEvent.getY(motionEvent.findPointerIndex(this.n));
                            this.s = motionEvent.getEventTime();
                            this.q = this.o;
                            this.r = this.p;
                            this.f = h.EStatTwoFingersCandidate;
                        } else {
                            this.f = h.EStatUnknown;
                        }
                        d();
                        break;
                    }
                    break;
                case 2:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        float e2 = e(motionEvent);
                        float f2 = f(motionEvent);
                        float g2 = g(motionEvent);
                        float h2 = h(motionEvent);
                        double a3 = a(this.i, this.j, e2, f2);
                        double a4 = a(this.o, this.p, g2, h2);
                        if ((a3 > 80.0d || a4 > 80.0d) && a3 > 20.0d && a4 > 20.0d) {
                            double a5 = a(this.i, this.j, e2, f2, this.o, this.p, g2, h2);
                            Log.d("touchopt", String.format("the angle is %1.3f", Double.valueOf(a5)));
                            if (a5 < 0.39269908169872414d) {
                                this.f = h.EStatTwoFingersScroll;
                                if (!this.x && !this.C) {
                                    ArBridge.getInstance().a(i.ETwoFingerScroll.ordinal(), this.h, e2, f2, a(motionEvent), b(motionEvent), this.n, g2, h2, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                                    Log.d("touchopt", "EStatTwoFingersScroll");
                                }
                            } else {
                                this.f = h.EStatPinchAndUnpinch;
                                this.t = a(e2, f2, g2, h2);
                            }
                        }
                        this.k = e2;
                        this.l = f2;
                        this.m = motionEvent.getEventTime();
                        this.q = g2;
                        this.r = h2;
                        this.s = motionEvent.getEventTime();
                        break;
                    } else {
                        this.f = h.EStatUnknown;
                        break;
                    }
                    break;
                case 3:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (1 == motionEvent.getActionMasked()) {
                        c();
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        if (motionEvent.getEventTime() - this.m >= 1) {
                            float e3 = e(motionEvent);
                            float f3 = f(motionEvent);
                            if (!this.x && !this.B) {
                                ArBridge.getInstance().a(i.EScroll.ordinal(), this.h, e3, f3, a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.k = e3;
                            this.l = f3;
                            this.m = motionEvent.getEventTime();
                            break;
                        }
                    } else {
                        this.f = h.EStatUnknown;
                        break;
                    }
                    break;
                case 4:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        if (motionEvent.getEventTime() - this.m >= 1 && motionEvent.getEventTime() - this.s >= 1) {
                            float e4 = e(motionEvent);
                            float f4 = f(motionEvent);
                            float g3 = g(motionEvent);
                            float h3 = h(motionEvent);
                            if (!this.x && !this.C) {
                                ArBridge.getInstance().a(i.ETwoFingerScroll.ordinal(), this.h, e4, f4, a(motionEvent), b(motionEvent), this.n, g3, h3, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                            }
                            this.k = e4;
                            this.l = f4;
                            this.m = motionEvent.getEventTime();
                            this.q = g3;
                            this.r = h3;
                            this.s = motionEvent.getEventTime();
                            break;
                        }
                    } else {
                        this.f = h.EStatUnknown;
                        break;
                    }
                    break;
                case 5:
                    if (5 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (6 == motionEvent.getActionMasked()) {
                        this.f = h.EStatUnknown;
                        break;
                    } else if (2 == motionEvent.getActionMasked()) {
                        if (motionEvent.getEventTime() - this.m >= 1 && motionEvent.getEventTime() - this.s >= 1) {
                            float e5 = e(motionEvent);
                            float f5 = f(motionEvent);
                            float g4 = g(motionEvent);
                            float h4 = h(motionEvent);
                            double a6 = a(e5, f5, g4, h4);
                            if (a6 > this.t) {
                                if (!this.x && !this.y) {
                                    ArBridge.getInstance().a(i.EUnPinch.ordinal(), this.h, e5, f5, a(motionEvent), b(motionEvent), this.n, g4, h4, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                                }
                            } else if (!this.x && !this.y) {
                                ArBridge.getInstance().a(i.EPinch.ordinal(), this.h, e5, f5, a(motionEvent), b(motionEvent), this.n, g4, h4, c(motionEvent), d(motionEvent), motionEvent.getEventTime());
                            }
                            this.t = a6;
                            this.k = e5;
                            this.l = f5;
                            this.m = motionEvent.getEventTime();
                            this.q = g4;
                            this.r = h4;
                            this.s = motionEvent.getEventTime();
                            break;
                        }
                    } else {
                        this.f = h.EStatUnknown;
                        break;
                    }
                    break;
                case 6:
                    if (2 == motionEvent.getActionMasked()) {
                        if (a(this.i, this.j, motionEvent.getX(), motionEvent.getY()) > 80.0d) {
                            this.f = h.EScrollAfterLongPress;
                            if (!this.x && !this.B) {
                                ArBridge.getInstance().a(i.EScrollAfterLongPress.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                            }
                            this.k = e(motionEvent);
                            this.l = f(motionEvent);
                            this.m = motionEvent.getEventTime();
                            break;
                        }
                    } else if (1 == motionEvent.getActionMasked()) {
                        c();
                        break;
                    } else {
                        this.f = h.EStatUnknown;
                        break;
                    }
                    break;
                case 7:
                    if (2 == motionEvent.getActionMasked()) {
                        if (!this.x && !this.B) {
                            ArBridge.getInstance().a(i.EScrollAfterLongPress.ordinal(), this.h, motionEvent.getX(), motionEvent.getY(), a(motionEvent), b(motionEvent), -1, -1.0f, -1.0f, -1.0f, -1.0f, motionEvent.getEventTime());
                        }
                        this.k = e(motionEvent);
                        this.l = f(motionEvent);
                        this.m = motionEvent.getEventTime();
                        break;
                    } else if (1 == motionEvent.getActionMasked()) {
                        c();
                        break;
                    } else {
                        this.f = h.EStatUnknown;
                        break;
                    }
                    break;
                case 8:
                case 9:
                case 10:
                    if (1 == motionEvent.getActionMasked()) {
                        c();
                        break;
                    }
                    break;
            }
            return onTouchEvent;
        }
        return onTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class e implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a  reason: collision with root package name */
        private static int f1203a = 12440;

        private e() {
        }

        /* synthetic */ e(w wVar) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            Log.w(BaiduArView.b, "onSurface creating OpenGL ES 2.0 context");
            Log.w("callseq", "onSurface creating OpenGL ES 2.0 context");
            BaiduArView.b("Before eglCreateContext", egl10);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{f1203a, 2, 12344});
            BaiduArView.b("After eglCreateContext", egl10);
            Log.d(BaiduArView.b, "createContext");
            ArBridge.getInstance().setGLThreadID(Thread.currentThread().getId());
            return eglCreateContext;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            Log.d(BaiduArView.b, "onSurface destroyContext");
            Log.d("callseq", "onSurface destroyContext");
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            ArBridge.getInstance().setGLThreadID(-1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                Log.e(b, String.format("%s: EGL error: 0x%x", str, Integer.valueOf(eglGetError)));
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class d implements GLSurfaceView.EGLConfigChooser {
        private static int g = 4;
        private static int[] h = {12324, 4, 12323, 4, 12322, 4, 12352, g, 12338, 1, 12337, 4, 12344};

        /* renamed from: a  reason: collision with root package name */
        protected int f1202a;
        protected int b;
        protected int c;
        protected int d;
        protected int e;
        protected int f;
        private int[] i = new int[1];

        public d(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f1202a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x003e  */
        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int i;
            Log.w("callseq", "chooseConfig called");
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, h, null, 0, iArr);
            int i2 = iArr[0];
            if (i2 <= 0) {
                h[11] = 2;
                egl10.eglChooseConfig(eGLDisplay, h, null, 0, iArr);
                i2 = iArr[0];
                if (i2 <= 0) {
                    h[8] = 12344;
                    egl10.eglChooseConfig(eGLDisplay, h, null, 0, iArr);
                    i = iArr[0];
                    if (i > 0) {
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
            i = i2;
            if (i > 0) {
            }
        }

        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (a2 >= this.e && a3 >= this.f) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (a4 == this.f1202a && a5 == this.b && a6 == this.c && a7 == this.d && a2 >= this.e) {
                        Log.d(BaiduArView.b, "get the config");
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.i)) {
                return this.i[0];
            }
            return i2;
        }

        private void b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            Log.e(BaiduArView.b, String.format("%d configurations", Integer.valueOf(length)));
            for (int i = 0; i < length; i++) {
                Log.e(BaiduArView.b, String.format("Configuration %d:\n", Integer.valueOf(i)));
                a(egl10, eGLDisplay, eGLConfigArr[i]);
            }
        }

        private void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < iArr.length; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                    Log.w(BaiduArView.b, String.format("  %s: %d\n", str, Integer.valueOf(iArr2[0])));
                } else {
                    do {
                    } while (egl10.eglGetError() != 12288);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class g implements GLSurfaceView.Renderer {
        private int b;
        private int c;
        private int d;
        private int e;
        private long f;
        private int g;
        private RendererUtils.a h;
        private b i;
        private volatile a j;

        private g() {
            this.b = -1;
            this.c = -1;
            this.d = 0;
            this.e = 0;
            this.f = System.currentTimeMillis();
            this.g = 0;
        }

        /* synthetic */ g(BaiduArView baiduArView, w wVar) {
            this();
        }

        public void a(b bVar) {
            this.i = bVar;
        }

        public void a(int i) {
            if (i > 0 && i <= 60) {
                this.g = 1000 / i;
            }
        }

        public void a(a aVar) {
            this.j = aVar;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            BaiduArView.this.mUpdating = true;
            if (this.g > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.f;
                if (currentTimeMillis < this.g) {
                    try {
                        Thread.sleep(this.g - currentTimeMillis);
                    } catch (Throwable th) {
                    }
                }
                this.f = System.currentTimeMillis();
            }
            if (this.i != null) {
                if (this.b == -1) {
                    this.c = RendererUtils.createTexture(this.d, this.e);
                    this.b = RendererUtils.createFBO(this.c, this.d, this.e, 33189);
                    this.h = RendererUtils.createProgram();
                    this.i.a(((EGL10) EGLContext.getEGL()).eglGetCurrentContext(), this.d, this.e);
                }
                GLES20.glBindFramebuffer(36160, this.b);
                ArBridge.getInstance().c();
                GLES20.glBindFramebuffer(36160, 0);
                RendererUtils.renderTexture(this.h, this.c, this.d, this.e);
                this.i.a(this.c);
            } else {
                ArBridge.getInstance().c();
            }
            if (this.j != null) {
                this.j.a(a());
                this.j = null;
            }
            BaiduArView.this.mUpdating = false;
            if (BaiduArView.this.mNeedDestroy) {
                ArBridge.getInstance().nativeDestroyCase();
                BaiduArView.this.mNeedDestroy = false;
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Log.d(BaiduArView.b, String.format("onSurfaceChanged thread name %s id %s width %d height %d", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(i), Integer.valueOf(i2)));
            this.d = i;
            this.e = i2;
            this.c = -1;
            this.b = -1;
            this.h = null;
            ArBridge.getInstance().setSize(i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Log.d(BaiduArView.b, "onSurfaceCreated");
            ArBridge.getInstance().setGLJniEnv();
            ArBridge.getInstance().b();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class f extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<BaiduArView> f1204a;

        public f(BaiduArView baiduArView) {
            this.f1204a = new WeakReference<>(baiduArView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    if (this.f1204a.get() != null && this.f1204a.get().f == h.EStatSingleFingerCandidate && this.f1204a.get().g) {
                        this.f1204a.get().f = h.EStatLongPresss;
                        if (!this.f1204a.get().x && !this.f1204a.get().D) {
                            ArBridge.getInstance().a(i.ELongPress.ordinal(), this.f1204a.get().h, this.f1204a.get().k, this.f1204a.get().l, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, Calendar.getInstance().getTimeInMillis());
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    BaiduArView baiduArView = this.f1204a.get();
                    if (baiduArView != null && message.obj != null) {
                        c cVar = (c) message.obj;
                        if (!baiduArView.z) {
                            ArBridge.getInstance().a(i.EClick.ordinal(), cVar.f1201a, cVar.b, cVar.c, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, cVar.d);
                        }
                        ArBridge.getInstance().a(i.EClear.ordinal(), -1, -1.0f, -1.0f, -1.0f, -1.0f, -1, -1.0f, -1.0f, -1.0f, -1.0f, -1L);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f1201a;
        public float b;
        public float c;
        public long d;

        private c() {
        }

        /* synthetic */ c(w wVar) {
            this();
        }
    }
}
