package c.b.b.l.a;

import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.b.b.q.g0;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.MonitorType;
import com.google.android.exoplayer2.C;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class k extends c.b.b.a implements GLSurfaceView.Renderer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean A;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final GLSurfaceView20 f27172e;

    /* renamed from: f  reason: collision with root package name */
    public int f27173f;

    /* renamed from: g  reason: collision with root package name */
    public int f27174g;

    /* renamed from: h  reason: collision with root package name */
    public c.b.b.l.a.a f27175h;

    /* renamed from: i  reason: collision with root package name */
    public c.b.b.n.c f27176i;

    /* renamed from: j  reason: collision with root package name */
    public c.b.b.n.d f27177j;
    public GLVersion k;
    public String l;
    public long m;
    public float n;
    public long o;
    public long p;
    public int q;
    public volatile boolean r;
    public volatile boolean s;
    public volatile boolean t;
    public volatile boolean u;
    public volatile boolean v;
    public final c.b.b.l.a.b w;
    public boolean x;
    public int[] y;
    public Object z;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f27178e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27178e = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f27178e.t) {
                this.f27178e.onDrawFrame(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Graphics.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k kVar, int i2, int i3, int i4, int i5) {
            super(i2, i3, i4, i5);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(281672243, "Lc/b/b/l/a/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(281672243, "Lc/b/b/l/a/k;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(c.b.b.l.a.a aVar, c.b.b.l.a.b bVar, c.b.b.l.a.b0.c cVar) {
        this(aVar, bVar, cVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c.b.b.l.a.a) objArr2[0], (c.b.b.l.a.b) objArr2[1], (c.b.b.l.a.b0.c) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.l == null) {
                this.l = c.b.b.f.f27077e.o(7939);
            }
            return this.l.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27177j != null : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public void c() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gLSurfaceView20 = this.f27172e) == null) {
            return;
        }
        gLSurfaceView20.requestRender();
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.x : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.floatValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public Graphics.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f27175h.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            return new b(this, displayMetrics.widthPixels, displayMetrics.heightPixels, 0, 0);
        }
        return (Graphics.a) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eglGetDisplay, new int[]{MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 4, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 4, 12322, 4, 12352, 4, 12344}, new EGLConfig[10], 10, iArr);
            egl10.eglTerminate(eglGetDisplay);
            return iArr[0] > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // c.b.b.a
    public Graphics.GraphicsType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Graphics.GraphicsType.AndroidGL : (Graphics.GraphicsType) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Mesh.g(this.f27175h);
            Texture.t(this.f27175h);
            Cubemap.t(this.f27175h);
            c.b.b.n.g.s(this.f27175h);
            c.b.b.n.m.i.g(this.f27175h);
            c.b.b.n.m.c.i(this.f27175h);
            o();
        }
    }

    public GLSurfaceView20 i(c.b.b.l.a.a aVar, c.b.b.l.a.b0.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, aVar, cVar)) == null) {
            if (g()) {
                GLSurfaceView.EGLConfigChooser l = l();
                GLSurfaceView20 gLSurfaceView20 = new GLSurfaceView20(aVar.getContext(), cVar, this.w.u ? 3 : 2);
                if (l != null) {
                    gLSurfaceView20.setEGLConfigChooser(l);
                } else {
                    c.b.b.l.a.b bVar = this.w;
                    gLSurfaceView20.setEGLConfigChooser(bVar.a, bVar.f27150b, bVar.f27151c, bVar.f27152d, bVar.f27153e, bVar.f27154f);
                }
                gLSurfaceView20.setRenderer(this);
                return gLSurfaceView20;
            }
            throw new GdxRuntimeException("Libgdx requires OpenGL ES 2.0");
        }
        return (GLSurfaceView20) invokeLL.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.z) {
                this.s = false;
                this.v = true;
                while (this.v) {
                    try {
                        this.z.wait();
                    } catch (InterruptedException unused) {
                        c.b.b.f.a.log("AndroidGraphics", "waiting for destroy synchronization failed!");
                    }
                }
            }
        }
    }

    public final int k(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.y) ? this.y[0] : i3 : invokeCommon.intValue;
    }

    public GLSurfaceView.EGLConfigChooser l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.b.b.l.a.b bVar = this.w;
            return new c.b.b.l.a.b0.b(bVar.a, bVar.f27150b, bVar.f27151c, bVar.f27152d, bVar.f27153e, bVar.f27154f, bVar.f27155g);
        }
        return (GLSurfaceView.EGLConfigChooser) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f27172e : (View) invokeV.objValue;
    }

    public void n(EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eGLConfig) == null) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            int k = k(egl10, eglGetDisplay, eGLConfig, MonitorType.MONITOR_TYPE_DOWNLOAD_WEBKIT, 0);
            int k2 = k(egl10, eglGetDisplay, eGLConfig, MonitorType.MONITOR_TYPE_INIT_WEBKIT, 0);
            int k3 = k(egl10, eglGetDisplay, eGLConfig, 12322, 0);
            int k4 = k(egl10, eglGetDisplay, eGLConfig, 12321, 0);
            int k5 = k(egl10, eglGetDisplay, eGLConfig, 12325, 0);
            int k6 = k(egl10, eglGetDisplay, eGLConfig, 12326, 0);
            int max = Math.max(k(egl10, eglGetDisplay, eGLConfig, 12337, 0), k(egl10, eglGetDisplay, eGLConfig, 12513, 0));
            boolean z = k(egl10, eglGetDisplay, eGLConfig, 12513, 0) != 0;
            Application application = c.b.b.f.a;
            application.log("AndroidGraphics", "framebuffer: (" + k + StringUtil.ARRAY_ELEMENT_SEPARATOR + k2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + k3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + k4 + SmallTailInfo.EMOTION_SUFFIX);
            Application application2 = c.b.b.f.a;
            StringBuilder sb = new StringBuilder();
            sb.append("depthbuffer: (");
            sb.append(k5);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            application2.log("AndroidGraphics", sb.toString());
            Application application3 = c.b.b.f.a;
            application3.log("AndroidGraphics", "stencilbuffer: (" + k6 + SmallTailInfo.EMOTION_SUFFIX);
            Application application4 = c.b.b.f.a;
            application4.log("AndroidGraphics", "samples: (" + max + SmallTailInfo.EMOTION_SUFFIX);
            Application application5 = c.b.b.f.a;
            application5.log("AndroidGraphics", "coverage sampling: (" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.b.b.f.a.log("AndroidGraphics", Mesh.k());
            c.b.b.f.a.log("AndroidGraphics", Texture.v());
            c.b.b.f.a.log("AndroidGraphics", Cubemap.v());
            c.b.b.f.a.log("AndroidGraphics", c.b.b.n.m.i.m());
            c.b.b.f.a.log("AndroidGraphics", c.b.b.n.m.c.l());
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gl10) == null) {
            long nanoTime = System.nanoTime();
            if (!this.u) {
                this.n = ((float) (nanoTime - this.m)) / 1.0E9f;
            } else {
                this.n = 0.0f;
            }
            this.m = nanoTime;
            synchronized (this.z) {
                z = this.s;
                z2 = this.t;
                z3 = this.v;
                z4 = this.u;
                if (this.u) {
                    this.u = false;
                }
                if (this.t) {
                    this.t = false;
                    this.z.notifyAll();
                }
                if (this.v) {
                    this.v = false;
                    this.z.notifyAll();
                }
            }
            if (z4) {
                g0<c.b.b.h> lifecycleListeners = this.f27175h.getLifecycleListeners();
                synchronized (lifecycleListeners) {
                    c.b.b.h[] o = lifecycleListeners.o();
                    int i2 = lifecycleListeners.f27499f;
                    for (int i3 = 0; i3 < i2; i3++) {
                        o[i3].resume();
                    }
                    lifecycleListeners.p();
                }
                this.f27175h.getApplicationListener().resume();
                c.b.b.f.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.f27175h.getRunnables()) {
                    this.f27175h.getExecutedRunnables().clear();
                    this.f27175h.getExecutedRunnables().b(this.f27175h.getRunnables());
                    this.f27175h.getRunnables().clear();
                }
                for (int i4 = 0; i4 < this.f27175h.getExecutedRunnables().f27499f; i4++) {
                    try {
                        this.f27175h.getExecutedRunnables().get(i4).run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.f27175h.getInput().m();
                this.p++;
                this.f27175h.getApplicationListener().render();
            }
            if (z2) {
                g0<c.b.b.h> lifecycleListeners2 = this.f27175h.getLifecycleListeners();
                synchronized (lifecycleListeners2) {
                    c.b.b.h[] o2 = lifecycleListeners2.o();
                    int i5 = lifecycleListeners2.f27499f;
                    for (int i6 = 0; i6 < i5; i6++) {
                        o2[i6].pause();
                    }
                }
                this.f27175h.getApplicationListener().pause();
                c.b.b.f.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                g0<c.b.b.h> lifecycleListeners3 = this.f27175h.getLifecycleListeners();
                synchronized (lifecycleListeners3) {
                    c.b.b.h[] o3 = lifecycleListeners3.o();
                    int i7 = lifecycleListeners3.f27499f;
                    for (int i8 = 0; i8 < i7; i8++) {
                        o3[i8].dispose();
                    }
                }
                this.f27175h.getApplicationListener().dispose();
                c.b.b.f.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.o > C.NANOS_PER_SECOND) {
                this.q = 0;
                this.o = nanoTime;
            }
            this.q++;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, gl10, i2, i3) == null) {
            this.f27173f = i2;
            this.f27174g = i3;
            w();
            x();
            gl10.glViewport(0, 0, this.f27173f, this.f27174g);
            if (!this.r) {
                this.f27175h.getApplicationListener().create();
                this.r = true;
                synchronized (this) {
                    this.s = true;
                }
            }
            this.f27175h.getApplicationListener().a(i2, i3);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, gl10, eGLConfig) == null) {
            ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
            v(gl10);
            n(eGLConfig);
            w();
            x();
            Mesh.n(this.f27175h);
            Texture.y(this.f27175h);
            Cubemap.w(this.f27175h);
            c.b.b.n.g.t(this.f27175h);
            c.b.b.n.m.i.n(this.f27175h);
            c.b.b.n.m.c.n(this.f27175h);
            o();
            Display defaultDisplay = this.f27175h.getWindowManager().getDefaultDisplay();
            this.f27173f = defaultDisplay.getWidth();
            this.f27174g = defaultDisplay.getHeight();
            this.m = System.nanoTime();
            gl10.glViewport(0, 0, this.f27173f, this.f27174g);
        }
    }

    public void p() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gLSurfaceView20 = this.f27172e) == null) {
            return;
        }
        gLSurfaceView20.onPause();
    }

    public void q() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (gLSurfaceView20 = this.f27172e) == null) {
            return;
        }
        gLSurfaceView20.onResume();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.z) {
                if (this.s) {
                    this.s = false;
                    this.t = true;
                    this.f27172e.queueEvent(new a(this));
                    while (this.t) {
                        try {
                            this.z.wait(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                            if (this.t) {
                                c.b.b.f.a.error("AndroidGraphics", "waiting for pause synchronization took too long; assuming deadlock and killing");
                                Process.killProcess(Process.myPid());
                            }
                        } catch (InterruptedException unused) {
                            c.b.b.f.a.log("AndroidGraphics", "waiting for pause synchronization failed!");
                        }
                    }
                }
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f27172e.setPreserveEGLContextOnPause(true);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this.z) {
                this.s = true;
                this.u = true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.f27172e == null) {
            return;
        }
        ?? r5 = (A || z) ? 1 : 0;
        this.x = r5;
        this.f27172e.setRenderMode(r5);
    }

    public void v(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, gl10) == null) {
            GLVersion gLVersion = new GLVersion(Application.ApplicationType.Android, gl10.glGetString(7938), gl10.glGetString(7936), gl10.glGetString(7937));
            this.k = gLVersion;
            if (this.w.u && gLVersion.b() > 2) {
                if (this.f27177j != null) {
                    return;
                }
                j jVar = new j();
                this.f27177j = jVar;
                this.f27176i = jVar;
                c.b.b.f.f27077e = jVar;
                c.b.b.f.f27078f = jVar;
                c.b.b.f.f27079g = jVar;
            } else if (this.f27176i != null) {
                return;
            } else {
                i iVar = new i();
                this.f27176i = iVar;
                c.b.b.f.f27077e = iVar;
                c.b.b.f.f27078f = iVar;
            }
            Application application = c.b.b.f.a;
            application.log("AndroidGraphics", "OGL renderer: " + gl10.glGetString(7937));
            Application application2 = c.b.b.f.a;
            application2.log("AndroidGraphics", "OGL vendor: " + gl10.glGetString(7936));
            Application application3 = c.b.b.f.a;
            application3.log("AndroidGraphics", "OGL version: " + gl10.glGetString(7938));
            Application application4 = c.b.b.f.a;
            application4.log("AndroidGraphics", "OGL extensions: " + gl10.glGetString(7939));
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f27175h.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            DisplayCutout displayCutout = this.f27175h.getApplicationWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
            if (displayCutout != null) {
                displayCutout.getSafeInsetRight();
                displayCutout.getSafeInsetBottom();
                displayCutout.getSafeInsetTop();
                displayCutout.getSafeInsetLeft();
            }
        } catch (UnsupportedOperationException unused) {
            c.b.b.f.a.log("AndroidGraphics", "Unable to get safe area insets");
        }
    }

    public k(c.b.b.l.a.a aVar, c.b.b.l.a.b bVar, c.b.b.l.a.b0.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar, cVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = System.nanoTime();
        this.n = 0.0f;
        this.o = System.nanoTime();
        this.p = -1L;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.x = true;
        this.y = new int[1];
        this.z = new Object();
        this.w = bVar;
        this.f27175h = aVar;
        this.f27172e = i(aVar, cVar);
        s();
        if (z) {
            this.f27172e.setFocusable(true);
            this.f27172e.setFocusableInTouchMode(true);
        }
    }
}
