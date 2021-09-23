package c.a.k0.a;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLSurfaceView;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.bean.PerformanceJsonBean;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.Log;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.ZeusMonitorType;
import com.heytap.mcssdk.mode.CommandMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import org.json.JSONArray;
import org.webrtc.EglBase10;
/* loaded from: classes.dex */
public final class a implements AREngineDelegate {
    public static /* synthetic */ Interceptable $ic;
    public static PermissionProxy o;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3742a;

    /* renamed from: b  reason: collision with root package name */
    public ArBridge f3743b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<DebugConsole> f3744c;

    /* renamed from: d  reason: collision with root package name */
    public int f3745d;

    /* renamed from: e  reason: collision with root package name */
    public long f3746e;

    /* renamed from: f  reason: collision with root package name */
    public float f3747f;

    /* renamed from: g  reason: collision with root package name */
    public float f3748g;

    /* renamed from: h  reason: collision with root package name */
    public GLSurfaceView.Renderer f3749h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3750i;

    /* renamed from: j  reason: collision with root package name */
    public final d f3751j;
    public Object k;
    public SurfaceHolder l;
    public b m;
    public boolean n;

    /* renamed from: c.a.k0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0092a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3752e;

        public RunnableC0092a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3752e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3752e.m.m = true;
                this.f3752e.f3743b.smallGameDestroy();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean A;
        public boolean B;
        public boolean C;
        public LinkedList<Runnable> D;
        public LinkedList<Runnable> E;
        public TreeSet<e> F;
        public boolean G;
        public c H;
        public d I;
        public a J;
        public V8Engine K;

        /* renamed from: e  reason: collision with root package name */
        public int f3753e;

        /* renamed from: f  reason: collision with root package name */
        public long f3754f;

        /* renamed from: g  reason: collision with root package name */
        public long f3755g;

        /* renamed from: h  reason: collision with root package name */
        public long f3756h;

        /* renamed from: i  reason: collision with root package name */
        public long f3757i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f3758j;
        public boolean k;
        public boolean l;
        public volatile boolean m;
        public volatile boolean n;
        public boolean o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3753e = 0;
            this.f3754f = 0L;
            this.f3755g = 0L;
            this.f3756h = 0L;
            this.f3757i = 0L;
            this.f3758j = false;
            this.k = false;
            this.l = false;
            this.m = false;
            this.n = false;
            this.D = new LinkedList<>();
            this.E = new LinkedList<>();
            this.F = new TreeSet<>();
            this.G = true;
            this.K = null;
            this.x = 0;
            this.y = 0;
            this.A = true;
            this.z = 1;
            this.B = false;
            this.J = aVar;
            this.I = aVar.f3751j;
        }

        public void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.I) {
                    this.q = true;
                    this.v = false;
                    this.I.notifyAll();
                    while (this.s && !this.v && !this.n) {
                        try {
                            this.I.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void B() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.I) {
                    this.q = false;
                    this.I.notifyAll();
                    while (!this.s && !this.n) {
                        try {
                            this.I.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t && this.u && r() : invokeV.booleanValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f3753e++;
                if (this.f3754f != 0) {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - this.f3754f)) / 1000.0f;
                    if (currentTimeMillis > 1.0f) {
                        this.J.r((int) (this.f3753e / currentTimeMillis));
                        this.f3753e = 0;
                        this.f3754f = System.currentTimeMillis();
                        return;
                    }
                    return;
                }
                this.f3754f = System.currentTimeMillis();
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                synchronized (this.I) {
                    this.D.clear();
                    this.E.clear();
                    this.F.clear();
                }
            }
        }

        public final Runnable g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                synchronized (this.I) {
                    if (!this.F.isEmpty() && this.F.first().b()) {
                        return this.F.pollFirst();
                    }
                    return this.D.pollFirst();
                }
            }
            return (Runnable) invokeV.objValue;
        }

        public int h() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                synchronized (this.I) {
                    i2 = this.z;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public final V8Engine i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.K == null) {
                    this.K = V8Engine.getInstance();
                }
                return this.K;
            }
            return (V8Engine) invokeV.objValue;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x01a4, code lost:
            if (r20.k != false) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x01a8, code lost:
            if (r20.J == null) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x01aa, code lost:
            r20.k = true;
            r20.J.o("first_event");
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x01b8, code lost:
            if (com.baidu.searchbox.v8engine.V8Engine.isDebug() == false) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:108:0x01bc, code lost:
            if (r20.J == null) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x01be, code lost:
            r20.J.n(1, r12.toString());
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x01c8, code lost:
            r12.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x01cc, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x01ce, code lost:
            r0.printStackTrace();
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x01ea, code lost:
            if (r7 == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:123:0x01f2, code lost:
            if (r20.H.a() == false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:124:0x01f4, code lost:
            r3 = r20.I;
         */
        /* JADX WARN: Code restructure failed: missing block: B:125:0x01f6, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x01f8, code lost:
            r20.v = true;
            r20.I.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x01ff, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x0200, code lost:
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:133:0x0205, code lost:
            r3 = r20.I;
         */
        /* JADX WARN: Code restructure failed: missing block: B:134:0x0207, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:136:0x0209, code lost:
            r20.v = true;
            r20.r = true;
            r20.I.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:137:0x0212, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:138:0x0213, code lost:
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x0219, code lost:
            if (r8 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x021b, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:144:0x021c, code lost:
            if (r6 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:145:0x021e, code lost:
            r0 = r20.J;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x0220, code lost:
            if (r0 == null) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x0222, code lost:
            r0.f3749h.onSurfaceCreated(null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:148:0x022a, code lost:
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x022b, code lost:
            if (r9 == false) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:150:0x022d, code lost:
            r0 = r20.J;
         */
        /* JADX WARN: Code restructure failed: missing block: B:151:0x022f, code lost:
            if (r0 == null) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:152:0x0231, code lost:
            r0.f3749h.onSurfaceChanged(null, r10, r11);
            r0.updateSurfaceViewSize(r10, r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:153:0x023e, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x023f, code lost:
            r0 = r20.J;
            r14 = java.lang.System.currentTimeMillis();
            r2 = r14 - r20.f3755g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:155:0x024f, code lost:
            if (r0.f3750i == false) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x0258, code lost:
            if (((float) r2) < k()) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x025a, code lost:
            r20.f3755g = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0262, code lost:
            if (r20.f3758j != false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x0266, code lost:
            if (r20.J == null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x0268, code lost:
            r20.f3758j = true;
            r20.J.o("first_frame");
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x0272, code lost:
            r0.f3749h.onDrawFrame(null);
            e();
            r2 = r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x0286, code lost:
            if ((r14 - r20.f3757i) <= 33) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x0288, code lost:
            r0.f3743b.notifyFrameUpdated();
            r20.f3757i = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:167:0x0293, code lost:
            if (r20.l == false) goto L93;
         */
        /* JADX WARN: Code restructure failed: missing block: B:168:0x0295, code lost:
            r20.J.f3743b.smallGameOnResume();
            r20.l = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:170:0x02a3, code lost:
            r4 = r0.f3743b.shouldSwapBuffer();
         */
        /* JADX WARN: Code restructure failed: missing block: B:171:0x02ab, code lost:
            if (r4 == false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:172:0x02ad, code lost:
            r14 = r20.H.i();
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x02b5, code lost:
            if (r14 == 12288) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:175:0x02b9, code lost:
            if (r14 == 12302) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x02bb, code lost:
            c.a.k0.a.a.c.f(com.baidu.smallgame.sdk.ArBridge.TAG, "eglSwapBuffers", r14);
            r3 = r20.I;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x02c4, code lost:
            monitor-enter(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:179:0x02c6, code lost:
            r20.r = true;
            r20.I.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:180:0x02cd, code lost:
            monitor-exit(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:185:0x02d2, code lost:
            r14 = r2;
            r15 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:186:0x02d5, code lost:
            r14 = r2;
            r15 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x02d8, code lost:
            r20.f3756h = java.lang.System.currentTimeMillis();
         */
        /* JADX WARN: Code restructure failed: missing block: B:188:0x02e8, code lost:
            if (r20.J.f3743b.isRenderCallbackQueueEmpty() != false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x02ea, code lost:
            if (r4 == false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:190:0x02ec, code lost:
            r2 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:191:0x02ee, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x02f9, code lost:
            if ((r0.f3743b.getStuckScreenHandler() instanceof c.a.k0.a.b) == false) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:194:0x02fb, code lost:
            ((c.a.k0.a.b) r0.f3743b.getStuckScreenHandler()).f(r2, r20.f3756h);
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x030a, code lost:
            r0 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:196:0x030d, code lost:
            r14 = r4;
            r0.f3750i = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:197:0x0312, code lost:
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:198:0x0314, code lost:
            if (r13 == false) goto L90;
         */
        /* JADX WARN: Code restructure failed: missing block: B:199:0x0316, code lost:
            r4 = true;
            r13 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:200:0x0319, code lost:
            r4 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:201:0x031a, code lost:
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x01a0, code lost:
            if (r12 == null) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void j() {
            boolean z;
            boolean z2;
            Runnable runnable;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.H = new c(this.J);
                z = false;
                this.t = false;
                this.u = false;
                this.B = false;
                z2 = false;
                boolean z9 = false;
                boolean z10 = false;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                boolean z14 = false;
                int i2 = 0;
                int i3 = 0;
                runnable = null;
                boolean z15 = false;
                loop0: while (true) {
                    try {
                        synchronized (this.I) {
                            while (!this.m) {
                                if (!this.E.isEmpty()) {
                                    runnable = this.E.pollFirst();
                                } else if (!a() || (!x() && (runnable = g()) == null)) {
                                    if (this.p != this.o) {
                                        boolean z16 = this.o;
                                        this.p = this.o;
                                        if (this.o) {
                                            this.l = z;
                                            this.J.f3743b.smallGameOnPauseOnGLThrad();
                                        } else {
                                            this.l = true;
                                        }
                                        this.I.notifyAll();
                                        StringBuilder sb = new StringBuilder();
                                        z6 = z16;
                                        sb.append("mPaused is now ");
                                        sb.append(this.p);
                                        sb.append(" tid=");
                                        z4 = z10;
                                        z5 = z11;
                                        sb.append(getId());
                                        Log.i(ArBridge.TAG, sb.toString());
                                    } else {
                                        z4 = z10;
                                        z5 = z11;
                                        z6 = false;
                                    }
                                    if (this.w) {
                                        z();
                                        y();
                                        this.w = false;
                                        z10 = true;
                                    } else {
                                        z10 = z4;
                                    }
                                    if (z2) {
                                        z();
                                        y();
                                        z2 = false;
                                    }
                                    if (z6 && this.u) {
                                        z();
                                    }
                                    if (z6) {
                                        boolean z17 = this.t;
                                    }
                                    if (!this.q && !this.s) {
                                        if (this.u) {
                                            z();
                                        }
                                        this.s = true;
                                        this.r = false;
                                        this.I.notifyAll();
                                    }
                                    if (this.q && this.s) {
                                        this.s = false;
                                        this.I.notifyAll();
                                    }
                                    if (z9) {
                                        this.B = false;
                                        this.C = true;
                                        this.I.notifyAll();
                                        z9 = false;
                                    }
                                    if (r()) {
                                        if (this.t) {
                                            z7 = z10;
                                            z11 = z5;
                                        } else if (z10) {
                                            z11 = z5;
                                            z7 = false;
                                        } else {
                                            try {
                                                this.H.h();
                                                this.J.f3743b.setEglContextToRecorder(this.J.m(), 0, 0);
                                                this.t = true;
                                                this.I.notifyAll();
                                                z7 = z10;
                                                z11 = true;
                                            } catch (RuntimeException e2) {
                                                this.I.a(this);
                                                throw e2;
                                            }
                                        }
                                        if (this.t && !this.u) {
                                            this.u = true;
                                            z12 = true;
                                            z13 = true;
                                            z14 = true;
                                        }
                                        if (this.u) {
                                            if (this.G) {
                                                int i4 = this.x;
                                                int i5 = this.y;
                                                this.B = true;
                                                this.G = false;
                                                i2 = i4;
                                                i3 = i5;
                                                z8 = false;
                                                z12 = true;
                                                z14 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            this.A = z8;
                                            this.I.notifyAll();
                                            z10 = z7;
                                            if (this.B) {
                                                z15 = true;
                                            }
                                        } else {
                                            z10 = z7;
                                        }
                                    } else {
                                        z11 = z5;
                                    }
                                    this.I.wait();
                                    z = false;
                                }
                                z3 = z2;
                            }
                            break loop0;
                        }
                    } catch (Throwable th) {
                        synchronized (this.I) {
                            if (this.J != null) {
                                this.J.f3743b.smallGameDestroy();
                            }
                            V8Engine v8Engine = V8Engine.getInstance();
                            if (v8Engine != null && !v8Engine.isDestroyed()) {
                                Log.e(ArBridge.TAG, "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                            }
                            z();
                            y();
                            throw th;
                        }
                    }
                }
                synchronized (this.I) {
                    if (this.J != null) {
                        this.J.f3743b.smallGameDestroy();
                    }
                    V8Engine v8Engine2 = V8Engine.getInstance();
                    if (v8Engine2 != null && !v8Engine2.isDestroyed()) {
                        Log.e(ArBridge.TAG, "v8engine is not destroyed. Please check that you have called the destroyEngine method");
                    }
                    z();
                    y();
                }
                return;
            }
            return;
            if (V8Engine.isDebug() && this.J != null) {
                this.J.n(2, runnable.toString());
            }
            z2 = z3;
            z = false;
            runnable = null;
        }

        public final float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                V8Engine i2 = i();
                if (i2 != null) {
                    return i2.minFramesInterval();
                }
                return 16.666666f;
            }
            return invokeV.floatValue;
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                synchronized (this.I) {
                    Log.i(ArBridge.TAG, "onPause tid=" + getId());
                    this.o = true;
                    if (this.J != null && (this.J.f3743b.getStuckScreenHandler() instanceof c.a.k0.a.b)) {
                        ((c.a.k0.a.b) this.J.f3743b.getStuckScreenHandler()).e();
                    }
                    this.I.notifyAll();
                    while (!this.n && !this.p) {
                        Log.i("Main thread", "onPause waiting for mPaused.");
                        try {
                            this.I.wait(500L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                synchronized (this.I) {
                    Log.i(ArBridge.TAG, "onResume tid=" + getId());
                    this.o = false;
                    this.A = true;
                    this.C = false;
                    this.I.notifyAll();
                    while (!this.n && this.p && !this.C) {
                        Log.i("Main thread", "onResume waiting for !mPaused.");
                        try {
                            this.I.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void n(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
                synchronized (this.I) {
                    this.x = i2;
                    this.y = i3;
                    this.G = true;
                    this.A = true;
                    this.C = false;
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.I.notifyAll();
                    while (!this.n && !this.p && !this.C && a()) {
                        try {
                            this.I.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void o(Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048589, this, runnable, j2) == null) {
                if (runnable != null) {
                    if (this.m || this.n) {
                        return;
                    }
                    synchronized (this.I) {
                        TreeSet<e> treeSet = this.F;
                        if (j2 <= 0) {
                            j2 = 0;
                        }
                        treeSet.add(new e(runnable, j2));
                        this.I.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }

        public void p(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, runnable) == null) {
                q(runnable, true);
            }
        }

        public final void q(Runnable runnable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048591, this, runnable, z) == null) {
                if (runnable != null) {
                    if (this.m || this.n) {
                        return;
                    }
                    synchronized (this.I) {
                        if (V8Engine.isDebug() && this.J != null) {
                            this.J.n(0, runnable.toString());
                        }
                        if (!z && !a()) {
                            this.E.add(runnable);
                            this.I.notifyAll();
                        }
                        this.D.add(runnable);
                        this.I.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("r must not be null");
            }
        }

        public final boolean r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? !this.p && this.q && !this.r && this.x > 0 && this.y > 0 && (this.A || this.z == 1) : invokeV.booleanValue;
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [c.a.k0.a.a, com.baidu.searchbox.v8engine.V8Engine, c.a.k0.a.a$c] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                setName("ARGLThread " + getId());
                a aVar = this.J;
                if (aVar != null) {
                    ArBridge k = aVar.k();
                    if (k != null) {
                        k.setGLThreadID(getId());
                        k.smallGameOnInit();
                        this.J.initDisplayMetrics();
                    } else {
                        Log.e(ArBridge.TAG, "Render Engine Init Failed. ArBridge is null");
                    }
                } else {
                    Log.e(ArBridge.TAG, "Render Engine Init Failed. AREngine is null");
                }
                try {
                    try {
                        j();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    this.I.b(this);
                    this.H.g();
                    this.H = null;
                    this.J = null;
                    this.K = null;
                }
            }
        }

        public void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
                synchronized (this.I) {
                    this.m = true;
                    this.I.notifyAll();
                    while (!this.n) {
                        try {
                            this.I.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
                synchronized (this.I) {
                    this.A = true;
                    this.I.notifyAll();
                }
            }
        }

        public void u() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
                synchronized (this.I) {
                    if (Thread.currentThread() == this) {
                        return;
                    }
                    this.B = true;
                    this.A = true;
                    this.C = false;
                    this.I.notifyAll();
                    while (!this.n && !this.p && !this.C && a()) {
                        try {
                            this.I.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void v(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, runnable) == null) {
                q(runnable, false);
            }
        }

        public void w(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
                if (i2 >= 0 && i2 <= 1) {
                    synchronized (this.I) {
                        this.z = i2;
                        this.I.notifyAll();
                    }
                    return;
                }
                throw new IllegalArgumentException("renderMode");
            }
        }

        public boolean x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.J.f3743b.mFirstFrameFinished && ((float) (System.currentTimeMillis() - this.f3756h)) > k();
            }
            return invokeV.booleanValue;
        }

        public final void y() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.t) {
                this.H.c();
                this.t = false;
                this.I.a(this);
            }
        }

        public final void z() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.u) {
                this.u = false;
                this.H.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f3759a;

        /* renamed from: b  reason: collision with root package name */
        public EGLDisplay f3760b;

        /* renamed from: c  reason: collision with root package name */
        public EGLSurface f3761c;

        /* renamed from: d  reason: collision with root package name */
        public EGLConfig f3762d;

        /* renamed from: e  reason: collision with root package name */
        public EGLContext f3763e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3759a = aVar;
        }

        public static String d(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
                return str + " failed: " + i2;
            }
            return (String) invokeLI.objValue;
        }

        public static void f(String str, String str2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65538, null, str, str2, i2) == null) {
                Log.w(str, d(str2, i2));
            }
        }

        public static void k(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65539, null, str, i2) == null) {
                throw new RuntimeException(d(str, i2));
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f3760b != null) {
                    if (this.f3762d != null) {
                        b();
                        Object obj = this.f3759a.l;
                        if (obj == null) {
                            obj = this.f3759a.k;
                        }
                        if (obj != null) {
                            this.f3761c = EGL14.eglCreateWindowSurface(this.f3760b, this.f3762d, obj, new int[]{ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                        } else {
                            this.f3761c = null;
                        }
                        EGLSurface eGLSurface = this.f3761c;
                        if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
                            return EGL14.eglMakeCurrent(this.f3760b, eGLSurface, eGLSurface, this.f3763e);
                        }
                        if (EGL14.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            return invokeV.booleanValue;
        }

        public void b() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eGLSurface = this.f3761c) == null || eGLSurface == (eGLSurface2 = EGL14.EGL_NO_SURFACE)) {
                return;
            }
            EGL14.eglMakeCurrent(this.f3760b, eGLSurface2, eGLSurface2, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f3760b, this.f3761c);
            this.f3761c = null;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                EGLContext eGLContext = this.f3763e;
                if (eGLContext != null) {
                    EGL14.eglDestroyContext(this.f3760b, eGLContext);
                    this.f3763e = null;
                }
                EGLDisplay eGLDisplay = this.f3760b;
                if (eGLDisplay != null) {
                    EGL14.eglTerminate(eGLDisplay);
                    this.f3760b = null;
                }
                this.f3759a.f3746e = -1L;
            }
        }

        public final EGLConfig e(int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!EGL14.eglChooseConfig(this.f3760b, new int[]{ZeusMonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_INIT_WEBKIT, 8, ZeusMonitorType.MONITOR_TYPE_BACK_FORWARD_HIJACK, 8, ZeusMonitorType.MONITOR_TYPE_MAGICFILTER_ABORT_RESOURCE_COUNT, 8, ZeusMonitorType.MONITOR_TYPE_SUB_RESOURCE_SAFE, z ? 16 : 0, ZeusMonitorType.MONITOR_TYPE_NET_INJECT, 0, 12352, 4, ZeusMonitorType.MONITOR_TYPE_AD_FILTER, 0, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    Log.w(ArBridge.TAG, "unable to find RGB8888 / " + i3 + " EGLConfig");
                    return null;
                }
                return eGLConfigArr[0];
            }
            return (EGLConfig) invokeCommon.objValue;
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f3759a = null;
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                this.f3760b = eglGetDisplay;
                if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                    int[] iArr = new int[2];
                    if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                        EGLConfig e2 = e(0, 0, false);
                        this.f3762d = e2;
                        this.f3763e = EGL14.eglCreateContext(this.f3760b, e2, EGL14.EGL_NO_CONTEXT, new int[]{EglBase10.EGL_CONTEXT_CLIENT_VERSION, 2, ZeusMonitorType.MONITOR_TYPE_AD_FILTER}, 0);
                        this.f3759a.f3746e = Thread.currentThread().getId();
                        EGLContext eGLContext = this.f3763e;
                        if (eGLContext != null && eGLContext != EGL14.EGL_NO_CONTEXT) {
                            this.f3761c = null;
                            return;
                        }
                        this.f3763e = null;
                        j("createContext");
                        throw null;
                    }
                    this.f3760b = null;
                    throw new RuntimeException("unable to initialize EGL14");
                }
                throw new RuntimeException("unable to get EGL14 display");
            }
        }

        public int i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !EGL14.eglSwapBuffers(this.f3760b, this.f3761c) ? EGL14.eglGetError() : CommandMessage.COMMAND_BASE : invokeV.intValue;
        }

        public final void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                k(str, EGL14.eglGetError());
                throw null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f3764a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-911934484, "Lc/a/k0/a/a$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-911934484, "Lc/a/k0/a/a$d;");
            }
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public void a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (this.f3764a == bVar) {
                    this.f3764a = null;
                }
                synchronized (this) {
                    notifyAll();
                }
            }
        }

        public synchronized void b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                synchronized (this) {
                    bVar.n = true;
                    if (this.f3764a == bVar) {
                        this.f3764a = null;
                    }
                    notifyAll();
                }
            }
        }

        public /* synthetic */ d(RunnableC0092a runnableC0092a) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class e implements Comparable<e>, Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final long f3765e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f3766f;

        public e(Runnable runnable, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3766f = runnable;
            this.f3765e = System.currentTimeMillis() + j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? (int) (this.f3765e - eVar.f3765e) : invokeL.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? System.currentTimeMillis() >= this.f3765e : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f3766f.run();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1742065900, "Lc/a/k0/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1742065900, "Lc/a/k0/a/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f3744c = null;
        this.f3745d = 0;
        this.f3747f = 0.0f;
        this.f3748g = 0.0f;
        this.f3750i = false;
        this.f3751j = new d(null);
        Log.setMinLogLevel(6, false);
        this.f3743b = new ArBridge();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean ableToDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b bVar = this.m;
            return bVar != null && bVar.a();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void addDebugConsole(DebugConsole debugConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, debugConsole) == null) {
            synchronized (this) {
                if (this.f3744c == null) {
                    this.f3744c = new ArrayList<>(1);
                }
                this.f3744c.add(debugConsole);
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void clearOldEvents() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.f();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void exitGLThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.s();
            }
            Log.e(ArBridge.TAG, "[V8Dispose][AREngine] exitGLThread.");
        }
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (this.m != null) {
                    this.m.s();
                }
            } finally {
                super.finalize();
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public long getCurrentRecordProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f3743b.getGameRecorder() != null) {
                return this.f3743b.getGameRecorder().s();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3745d : invokeV.intValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public Thread getGLThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (Thread) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public JSONArray getPerformanceJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArBridge arBridge = this.f3743b;
            return arBridge == null ? new JSONArray() : arBridge.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public PerformanceJsonBean getPerformanceJsonBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArBridge arBridge = this.f3743b;
            return arBridge == null ? new PerformanceJsonBean() : arBridge.getPerformanceJsonBean();
        }
        return (PerformanceJsonBean) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public int getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            b bVar = this.m;
            if (bVar != null) {
                return bVar.h();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public c.a.k0.a.d.c getStuckScreenHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArBridge arBridge = this.f3743b;
            if (arBridge == null) {
                return null;
            }
            return arBridge.getStuckScreenHandler();
        }
        return (c.a.k0.a.d.c) invokeV.objValue;
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void initDisplayMetrics() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Context l = l();
            if (l != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) l.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                float f2 = displayMetrics.widthPixels;
                float f3 = displayMetrics.heightPixels;
                float f4 = this.f3747f;
                float f5 = f4 != 0.0f ? f4 : f2;
                float f6 = this.f3748g;
                float f7 = f6 != 0.0f ? f6 : f3;
                ArBridge arBridge = this.f3743b;
                if (arBridge != null) {
                    arBridge.setDisplayMetrics(f5, f7, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.density);
                    return;
                } else {
                    Log.e(ArBridge.TAG, "[RenderError] error init render display, because arbridge is null");
                    return;
                }
            }
            throw new NullPointerException("[RenderError] initDisplayMetrics Error. because AppContext is null");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f3743b.isDestroyed() : invokeV.booleanValue;
    }

    public ArBridge k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f3743b : (ArBridge) invokeV.objValue;
    }

    public Context l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f3742a : (Context) invokeV.objValue;
    }

    public EGLContext m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b bVar = this.m;
            if (bVar == null || bVar.H == null) {
                return null;
            }
            return this.m.H.f3763e;
        }
        return (EGLContext) invokeV.objValue;
    }

    public final void n(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048593, this, i2, str) == null) || this.f3744c == null) {
            return;
        }
        for (DebugConsole debugConsole : new ArrayList(this.f3744c)) {
            debugConsole.onReceiveInfo(i2, str);
        }
    }

    public void o(String str) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (arBridge = this.f3743b) == null) {
            return;
        }
        arBridge.getPerformanceJsonBean().put(str);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.n && this.f3749h != null) {
                b bVar = this.m;
                int h2 = bVar != null ? bVar.h() : 1;
                b bVar2 = new b(this);
                this.m = bVar2;
                if (h2 != 1) {
                    bVar2.w(h2);
                }
                this.m.start();
            }
            this.n = false;
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] onAttachedToWindow");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onDetachedFromWindow() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!this.n && (bVar = this.m) != null) {
                bVar.s();
            }
            this.n = true;
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] onDetachedFromWindow");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.l();
            }
            if (this.f3743b.getGameRecorder() != null) {
                this.f3743b.getGameRecorder().w();
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                bVar.m();
            }
            if (this.f3743b.getGameRecorder() != null) {
                this.f3743b.getGameRecorder().z();
            }
        }
    }

    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            this.f3742a = context;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void pauseRecord() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f3743b.getGameRecorder() == null) {
            return;
        }
        this.f3743b.getGameRecorder().v();
    }

    public void q(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, surfaceHolder) == null) {
            this.l = (SurfaceHolder) new WeakReference(surfaceHolder).get();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, runnable) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.p(runnable);
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 > 60) {
                i2 = 60;
            }
            this.f3745d = i2;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public synchronized void removeDebugConsole(DebugConsole debugConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, debugConsole) == null) {
            synchronized (this) {
                if (this.f3744c == null) {
                    return;
                }
                this.f3744c.remove(debugConsole);
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRender() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.t();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void requestRenderAndWait() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.u();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void resumeRecord() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.f3743b.getGameRecorder() == null) {
            return;
        }
        this.f3743b.getGameRecorder().y();
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void runOnGLThread(Runnable runnable) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, runnable) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.v(runnable);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setAudioEngineProxy(c.a.x.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, aVar) == null) || this.f3743b.getGameRecorder() == null) {
            return;
        }
        this.f3743b.getGameRecorder().A(aVar);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, firstFrameListener) == null) {
            this.f3743b.setFirstFrameListener(firstFrameListener);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setGameRecordCallback(c.a.x.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, cVar) == null) || this.f3743b.getGameRecorder() == null) {
            return;
        }
        this.f3743b.getGameRecorder().C(cVar);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setOnStuckScreenListener(c.a.k0.a.d.a aVar) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, aVar) == null) || (arBridge = this.f3743b) == null) {
            return;
        }
        arBridge.setOnStuckScreenListener(aVar);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setPermissionProxy(PermissionProxy permissionProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, permissionProxy) == null) {
            o = permissionProxy;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderMode(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.w(i2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setRenderer(GLSurfaceView.Renderer renderer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, renderer) == null) {
            this.f3749h = renderer;
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setScreenShotStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.f3743b.setScreenShotStatus(z);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void setStuckScreenLimitTime(long j2) {
        ArBridge arBridge;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048618, this, j2) == null) || (arBridge = this.f3743b) == null) {
            return;
        }
        arBridge.setStuckScreenLimitTime(j2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            b bVar = this.m;
            if (bVar == null) {
                Log.e(ArBridge.TAG, "Destroy AREngine fail. Because GLThread is null");
            } else {
                bVar.v(new RunnableC0092a(this));
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f3743b.smallGameOnPause();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void smallGameUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f3743b.smallGameUpdate();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startEngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.f3749h != null) {
                b bVar = new b(this);
                this.m = bVar;
                bVar.start();
                return;
            }
            throw new NullPointerException("start render engine failed. because renderer is not set");
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void startRecord(boolean z, int i2, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2)}) == null) || this.f3743b.getGameRecorder() == null) {
            return;
        }
        this.f3743b.nativeUpdateRecordingStatus(true);
        this.f3743b.getGameRecorder().F(z, i2, str, z2);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || this.f3743b.getGameRecorder() == null) {
            return;
        }
        this.f3743b.getGameRecorder().I();
        this.f3743b.nativeUpdateRecordingStatus(false);
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceChanged(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048625, this, i2, i3) == null) {
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceChanged. width=" + i2 + ", height=" + i3);
            this.m.n(i2, i3);
            this.f3743b.setEglContextToRecorder(m(), i2, i3);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceCreated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceCreated.");
            this.m.A();
            Context appContext = V8Engine.getAppContext();
            if (appContext != null) {
                p = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRotation();
            }
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void surfaceDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            Log.w(ArBridge.TAG, "[V8Dispose][AREngine] surfaceDestroyed.");
            this.m.B();
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void updateSurfaceViewSize(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            Log.w(ArBridge.TAG, "[ARDispose] updateSurfaceViewSize, width=" + f2 + ", height=" + f3);
            this.f3747f = f2;
            this.f3748g = f3;
            this.f3743b.setSize(f2, f3);
        }
    }

    @Override // com.baidu.smallgame.sdk.delegate.AREngineDelegate
    public void queueEvent(Runnable runnable, long j2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048603, this, runnable, j2) == null) || (bVar = this.m) == null) {
            return;
        }
        bVar.o(runnable, j2);
    }
}
