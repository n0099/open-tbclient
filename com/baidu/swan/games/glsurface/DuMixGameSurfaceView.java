package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.j.e0.g;
import b.a.p0.j.g0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AREngineDelegate f45470e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.p0.a.l0.a f45471f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.p0.j.q.c.a f45472g;

    /* renamed from: h  reason: collision with root package name */
    public int f45473h;

    /* renamed from: i  reason: collision with root package name */
    public int f45474i;
    public volatile f j;
    public boolean k;
    public GameRecorderController l;

    /* loaded from: classes8.dex */
    public class a implements b.a.k0.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f45475a;

        public a(DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45475a = duMixGameSurfaceView;
        }

        @Override // b.a.k0.a.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.j.q.c.b.k();
            }
        }

        @Override // b.a.k0.a.d.a
        public void b(b.a.k0.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                b.a.p0.j.i0.b.c(bVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f45476e;

        public b(DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45476e = duMixGameSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45476e.f45470e == null) {
                return;
            }
            this.f45476e.f45470e.smallGameOnPause();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f45477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f45478f;

        public c(DuMixGameSurfaceView duMixGameSurfaceView, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixGameSurfaceView, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45478f = duMixGameSurfaceView;
            this.f45477e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45478f.j = this.f45477e;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f45479e;

        public d(DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45479e = duMixGameSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f45479e.k && this.f45479e.f45470e != null) {
                    this.f45479e.f45470e.setScreenShotStatus(false);
                }
                this.f45479e.j = null;
                this.f45479e.k = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements GLSurfaceView.Renderer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f45480e;

        public e(DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45480e = duMixGameSurfaceView;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                boolean unused = DuMixGameSurfaceView.m;
                if (this.f45480e.f45470e == null) {
                    return;
                }
                this.f45480e.f45470e.smallGameUpdate();
                if (this.f45480e.j != null) {
                    if (this.f45480e.k) {
                        this.f45480e.j.a(this.f45480e.getScreenShot(), this.f45480e.f45473h, this.f45480e.f45474i);
                        this.f45480e.f45470e.setScreenShotStatus(false);
                        this.f45480e.k = false;
                        this.f45480e.j = null;
                    }
                    if (this.f45480e.j != null) {
                        this.f45480e.f45470e.setScreenShotStatus(true);
                        this.f45480e.k = true;
                    }
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10, i2, i3) == null) {
                this.f45480e.f45473h = i2;
                this.f45480e.f45474i = i3;
                if (DuMixGameSurfaceView.m) {
                    String str = "AiWebRender onSurfaceChanged width * height = " + i2 + " * " + i3;
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gl10, eGLConfig) == null) {
                boolean unused = DuMixGameSurfaceView.m;
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(int[] iArr, int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1056185791, "Lcom/baidu/swan/games/glsurface/DuMixGameSurfaceView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1056185791, "Lcom/baidu/swan/games/glsurface/DuMixGameSurfaceView;");
                return;
            }
        }
        m = k.f6863a;
        b.a.p0.a.k2.d.c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DuMixGameSurfaceView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int i3 = this.f45473h;
            if (i3 > 0 && (i2 = this.f45474i) > 0) {
                try {
                    int[] iArr = new int[i3 * i2];
                    IntBuffer wrap = IntBuffer.wrap(iArr);
                    wrap.position(0);
                    GLES20.glReadPixels(0, 0, this.f45473h, this.f45474i, GeneratedTexture.FORMAT, 5121, wrap);
                    return iArr;
                } catch (OutOfMemoryError unused) {
                }
            }
            return null;
        }
        return (int[]) invokeV.objValue;
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, renderer) == null) || (aREngineDelegate = this.f45470e) == null) {
            return;
        }
        aREngineDelegate.setRenderer(renderer);
    }

    public synchronized void cancelScreenShot() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                queueEvent(new d(this));
            }
        }
    }

    public void clearOldEvents() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.clearOldEvents();
            }
        }
    }

    public void doEnginePerformanceUBC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.p0.a.l0.a aVar = this.f45471f;
            if (aVar != null) {
                h.b(aVar.q0());
            }
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                h.b(aREngineDelegate.getPerformanceJson());
            }
        }
    }

    public int getFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate == null) {
                return 0;
            }
            return aREngineDelegate.getFPS();
        }
        return invokeV.intValue;
    }

    public int getRenderMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                return aREngineDelegate.getRenderMode();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public Thread getThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                return aREngineDelegate.getGLThread();
            }
            return null;
        }
        return (Thread) invokeV.objValue;
    }

    public b.a.p0.a.l0.a getV8Engine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45471f : (b.a.p0.a.l0.a) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = m;
            SurfaceHolder holder = getHolder();
            holder.addCallback(this);
            MarioSDK.a aVar = new MarioSDK.a();
            aVar.k(holder);
            aVar.i(this);
            aVar.j(new e(this));
            aVar.h(AppRuntime.getAppContext());
            aVar.f(new b.a.p0.j.q.a());
            b.a.p0.a.u1.h.p("preload").F(new UbcFlowEvent("na_game_engine_start"));
            AREngineDelegate createAREngine = MarioSDK.createAREngine(aVar);
            this.f45470e = createAREngine;
            createAREngine.setPermissionProxy(new b.a.p0.a.l0.n.e());
            this.f45470e.setOnStuckScreenListener(new a(this));
            this.f45470e.startEngine();
            b.a.p0.a.u1.h.p("preload").F(new UbcFlowEvent("na_game_engine_end"));
            this.f45472g = new b.a.p0.j.q.c.a();
            this.l = new GameRecorderController(this.f45470e);
            g.a().g(this.l);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f45474i = 0;
            this.f45473h = 0;
        }
    }

    public void notifySurfaceChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            surfaceChanged(getHolder(), 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onAttachedToWindow();
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.onAttachedToWindow();
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            boolean z = m;
            m();
            g.a().f(this.l);
            if (this.f45470e != null) {
                b.a.p0.a.l0.a aVar = this.f45471f;
                if (aVar != null) {
                    aVar.m0();
                }
                this.f45470e.setFirstFrameListener(null);
                this.f45470e.setOnStuckScreenListener(null);
                this.f45470e.smallGameDestroy();
                this.f45470e.exitGLThread();
                this.f45470e = null;
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            doEnginePerformanceUBC();
            SwanAppActivity activity = b.a.p0.a.g1.f.U().getActivity();
            if (activity != null) {
                b.a.p0.a.t0.c frame = activity.getFrame();
                if (frame instanceof b.a.p0.j.o.d) {
                    ((b.a.p0.j.o.d) frame).k1();
                }
            }
        }
    }

    public void onJSError(V8ExceptionInfo v8ExceptionInfo) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, v8ExceptionInfo) == null) || (aREngineDelegate = this.f45470e) == null || aREngineDelegate.getStuckScreenHandler() == null) {
            return;
        }
        this.f45470e.getStuckScreenHandler().a(0, v8ExceptionInfo);
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean z = m;
            queueEvent(new b(this));
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.onPause();
            }
            g.a().d();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.onResume();
            }
            g.a().e();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (this.f45472g.a(motionEvent)) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void queueEvent(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, runnable) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.queueEvent(runnable);
            }
        }
    }

    public void requestRender() {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aREngineDelegate = this.f45470e) == null) {
            return;
        }
        aREngineDelegate.requestRender();
    }

    public synchronized void requestScreenShot(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            synchronized (this) {
                queueEvent(new c(this, fVar));
            }
        }
    }

    public void runOnGLThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, runnable) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.runOnGLThread(runnable);
            }
        }
    }

    public void setRenderMode(int i2) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (aREngineDelegate = this.f45470e) == null) {
            return;
        }
        aREngineDelegate.setRenderMode(i2);
    }

    public void setV8Engine(b.a.p0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.f45471f = aVar;
            this.f45472g.c(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048601, this, surfaceHolder, i2, i3, i4) == null) {
            if (m) {
                String str = "surfaceChanged width: " + i3 + ", height: " + i4;
            }
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceChanged(i3, i4);
            }
            b.a.p0.j.q.c.a aVar = this.f45472g;
            if (aVar != null) {
                aVar.b(i3, i4);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, surfaceHolder) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceCreated();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, surfaceHolder) == null) {
            boolean z = m;
            m();
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceDestroyed();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, surfaceHolder) == null) || (aREngineDelegate = this.f45470e) == null) {
            return;
        }
        aREngineDelegate.requestRenderAndWait();
    }

    public void updateGameCanvasSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            Pair<Integer, Integer> x = b.a.p0.a.g1.f.U().x();
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.updateSurfaceViewSize(((Integer) x.first).intValue(), ((Integer) x.second).intValue());
                this.f45470e.initDisplayMetrics();
            }
            b.a.p0.j.q.c.a aVar = this.f45472g;
            if (aVar != null) {
                aVar.d(((Integer) x.first).intValue(), ((Integer) x.second).intValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DuMixGameSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        l();
    }

    public void queueEvent(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, runnable, j) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f45470e;
            if (aREngineDelegate != null) {
                aREngineDelegate.queueEvent(runnable, j);
            }
        }
    }
}
