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
    public static volatile boolean w;
    public transient /* synthetic */ FieldHolder $fh;
    public final GLSurfaceView20 a;

    /* renamed from: b  reason: collision with root package name */
    public int f22424b;

    /* renamed from: c  reason: collision with root package name */
    public int f22425c;

    /* renamed from: d  reason: collision with root package name */
    public c.b.b.l.a.a f22426d;

    /* renamed from: e  reason: collision with root package name */
    public c.b.b.n.c f22427e;

    /* renamed from: f  reason: collision with root package name */
    public c.b.b.n.d f22428f;

    /* renamed from: g  reason: collision with root package name */
    public GLVersion f22429g;

    /* renamed from: h  reason: collision with root package name */
    public String f22430h;
    public long i;
    public float j;
    public long k;
    public long l;
    public int m;
    public volatile boolean n;
    public volatile boolean o;
    public volatile boolean p;
    public volatile boolean q;
    public volatile boolean r;
    public final c.b.b.l.a.b s;
    public boolean t;
    public int[] u;
    public Object v;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p) {
                this.a.onDrawFrame(null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Graphics.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k kVar, int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.f22430h == null) {
                this.f22430h = c.b.b.f.f22334e.o(7939);
            }
            return this.f22430h.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22428f != null : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public void c() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gLSurfaceView20 = this.a) == null) {
            return;
        }
        gLSurfaceView20.requestRender();
    }

    @Override // com.badlogic.gdx.Graphics
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.floatValue;
    }

    @Override // com.badlogic.gdx.Graphics
    public Graphics.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f22426d.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
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
            Mesh.g(this.f22426d);
            Texture.t(this.f22426d);
            Cubemap.t(this.f22426d);
            c.b.b.n.g.s(this.f22426d);
            c.b.b.n.m.i.g(this.f22426d);
            c.b.b.n.m.c.i(this.f22426d);
            o();
        }
    }

    public GLSurfaceView20 i(c.b.b.l.a.a aVar, c.b.b.l.a.b0.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, aVar, cVar)) == null) {
            if (g()) {
                GLSurfaceView.EGLConfigChooser l = l();
                GLSurfaceView20 gLSurfaceView20 = new GLSurfaceView20(aVar.getContext(), cVar, this.s.u ? 3 : 2);
                if (l != null) {
                    gLSurfaceView20.setEGLConfigChooser(l);
                } else {
                    c.b.b.l.a.b bVar = this.s;
                    gLSurfaceView20.setEGLConfigChooser(bVar.a, bVar.f22405b, bVar.f22406c, bVar.f22407d, bVar.f22408e, bVar.f22409f);
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
            synchronized (this.v) {
                this.o = false;
                this.r = true;
                while (this.r) {
                    try {
                        this.v.wait();
                    } catch (InterruptedException unused) {
                        c.b.b.f.a.log("AndroidGraphics", "waiting for destroy synchronization failed!");
                    }
                }
            }
        }
    }

    public final int k(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{egl10, eGLDisplay, eGLConfig, Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.u) ? this.u[0] : i2 : invokeCommon.intValue;
    }

    public GLSurfaceView.EGLConfigChooser l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.b.b.l.a.b bVar = this.s;
            return new c.b.b.l.a.b0.b(bVar.a, bVar.f22405b, bVar.f22406c, bVar.f22407d, bVar.f22408e, bVar.f22409f, bVar.f22410g);
        }
        return (GLSurfaceView.EGLConfigChooser) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (View) invokeV.objValue;
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
            if (!this.q) {
                this.j = ((float) (nanoTime - this.i)) / 1.0E9f;
            } else {
                this.j = 0.0f;
            }
            this.i = nanoTime;
            synchronized (this.v) {
                z = this.o;
                z2 = this.p;
                z3 = this.r;
                z4 = this.q;
                if (this.q) {
                    this.q = false;
                }
                if (this.p) {
                    this.p = false;
                    this.v.notifyAll();
                }
                if (this.r) {
                    this.r = false;
                    this.v.notifyAll();
                }
            }
            if (z4) {
                g0<c.b.b.h> lifecycleListeners = this.f22426d.getLifecycleListeners();
                synchronized (lifecycleListeners) {
                    c.b.b.h[] p = lifecycleListeners.p();
                    int i = lifecycleListeners.f22717b;
                    for (int i2 = 0; i2 < i; i2++) {
                        p[i2].resume();
                    }
                    lifecycleListeners.q();
                }
                this.f22426d.getApplicationListener().resume();
                c.b.b.f.a.log("AndroidGraphics", "resumed");
            }
            if (z) {
                synchronized (this.f22426d.getRunnables()) {
                    this.f22426d.getExecutedRunnables().clear();
                    this.f22426d.getExecutedRunnables().b(this.f22426d.getRunnables());
                    this.f22426d.getRunnables().clear();
                }
                for (int i3 = 0; i3 < this.f22426d.getExecutedRunnables().f22717b; i3++) {
                    try {
                        this.f22426d.getExecutedRunnables().get(i3).run();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.f22426d.getInput().g0();
                this.l++;
                this.f22426d.getApplicationListener().render();
            }
            if (z2) {
                g0<c.b.b.h> lifecycleListeners2 = this.f22426d.getLifecycleListeners();
                synchronized (lifecycleListeners2) {
                    c.b.b.h[] p2 = lifecycleListeners2.p();
                    int i4 = lifecycleListeners2.f22717b;
                    for (int i5 = 0; i5 < i4; i5++) {
                        p2[i5].pause();
                    }
                }
                this.f22426d.getApplicationListener().pause();
                c.b.b.f.a.log("AndroidGraphics", "paused");
            }
            if (z3) {
                g0<c.b.b.h> lifecycleListeners3 = this.f22426d.getLifecycleListeners();
                synchronized (lifecycleListeners3) {
                    c.b.b.h[] p3 = lifecycleListeners3.p();
                    int i6 = lifecycleListeners3.f22717b;
                    for (int i7 = 0; i7 < i6; i7++) {
                        p3[i7].dispose();
                    }
                }
                this.f22426d.getApplicationListener().dispose();
                c.b.b.f.a.log("AndroidGraphics", "destroyed");
            }
            if (nanoTime - this.k > C.NANOS_PER_SECOND) {
                this.m = 0;
                this.k = nanoTime;
            }
            this.m++;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048593, this, gl10, i, i2) == null) {
            this.f22424b = i;
            this.f22425c = i2;
            w();
            x();
            gl10.glViewport(0, 0, this.f22424b, this.f22425c);
            if (!this.n) {
                this.f22426d.getApplicationListener().create();
                this.n = true;
                synchronized (this) {
                    this.o = true;
                }
            }
            this.f22426d.getApplicationListener().a(i, i2);
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
            Mesh.n(this.f22426d);
            Texture.y(this.f22426d);
            Cubemap.w(this.f22426d);
            c.b.b.n.g.t(this.f22426d);
            c.b.b.n.m.i.n(this.f22426d);
            c.b.b.n.m.c.n(this.f22426d);
            o();
            Display defaultDisplay = this.f22426d.getWindowManager().getDefaultDisplay();
            this.f22424b = defaultDisplay.getWidth();
            this.f22425c = defaultDisplay.getHeight();
            this.i = System.nanoTime();
            gl10.glViewport(0, 0, this.f22424b, this.f22425c);
        }
    }

    public void p() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (gLSurfaceView20 = this.a) == null) {
            return;
        }
        gLSurfaceView20.onPause();
    }

    public void q() {
        GLSurfaceView20 gLSurfaceView20;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (gLSurfaceView20 = this.a) == null) {
            return;
        }
        gLSurfaceView20.onResume();
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            synchronized (this.v) {
                if (this.o) {
                    this.o = false;
                    this.p = true;
                    this.a.queueEvent(new a(this));
                    while (this.p) {
                        try {
                            this.v.wait(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
                            if (this.p) {
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
            this.a.setPreserveEGLContextOnPause(true);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this.v) {
                this.o = true;
                this.q = true;
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
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.a == null) {
            return;
        }
        ?? r5 = (w || z) ? 1 : 0;
        this.t = r5;
        this.a.setRenderMode(r5);
    }

    public void v(GL10 gl10) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, gl10) == null) {
            GLVersion gLVersion = new GLVersion(Application.ApplicationType.Android, gl10.glGetString(7938), gl10.glGetString(7936), gl10.glGetString(7937));
            this.f22429g = gLVersion;
            if (this.s.u && gLVersion.b() > 2) {
                if (this.f22428f != null) {
                    return;
                }
                j jVar = new j();
                this.f22428f = jVar;
                this.f22427e = jVar;
                c.b.b.f.f22334e = jVar;
                c.b.b.f.f22335f = jVar;
                c.b.b.f.f22336g = jVar;
            } else if (this.f22427e != null) {
                return;
            } else {
                i iVar = new i();
                this.f22427e = iVar;
                c.b.b.f.f22334e = iVar;
                c.b.b.f.f22335f = iVar;
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
            this.f22426d.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            DisplayCutout displayCutout = this.f22426d.getApplicationWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = System.nanoTime();
        this.j = 0.0f;
        this.k = System.nanoTime();
        this.l = -1L;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.t = true;
        this.u = new int[1];
        this.v = new Object();
        this.s = bVar;
        this.f22426d = aVar;
        this.a = i(aVar, cVar);
        s();
        if (z) {
            this.a.setFocusable(true);
            this.a.setFocusableInTouchMode(true);
        }
    }
}
