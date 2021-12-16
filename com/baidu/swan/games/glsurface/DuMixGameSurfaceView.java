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
import c.a.q0.a.k;
import c.a.q0.j.e0.g;
import c.a.q0.j.g0.h;
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
/* loaded from: classes11.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AREngineDelegate f40998e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.q0.a.l0.a f40999f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.j.q.c.a f41000g;

    /* renamed from: h  reason: collision with root package name */
    public int f41001h;

    /* renamed from: i  reason: collision with root package name */
    public int f41002i;

    /* renamed from: j  reason: collision with root package name */
    public volatile f f41003j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f41004k;
    public GameRecorderController l;

    /* loaded from: classes11.dex */
    public class a implements c.a.m0.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DuMixGameSurfaceView a;

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
            this.a = duMixGameSurfaceView;
        }

        @Override // c.a.m0.a.d.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.j.q.c.b.k();
            }
        }

        @Override // c.a.m0.a.d.a
        public void b(c.a.m0.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                c.a.q0.j.i0.b.c(bVar);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f41005e;

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
            this.f41005e = duMixGameSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41005e.f40998e == null) {
                return;
            }
            this.f41005e.f40998e.smallGameOnPause();
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f41006e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f41007f;

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
            this.f41007f = duMixGameSurfaceView;
            this.f41006e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41007f.f41003j = this.f41006e;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f41008e;

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
            this.f41008e = duMixGameSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f41008e.f41004k && this.f41008e.f40998e != null) {
                    this.f41008e.f40998e.setScreenShotStatus(false);
                }
                this.f41008e.f41003j = null;
                this.f41008e.f41004k = false;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements GLSurfaceView.Renderer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DuMixGameSurfaceView f41009e;

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
            this.f41009e = duMixGameSurfaceView;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                boolean unused = DuMixGameSurfaceView.m;
                if (this.f41009e.f40998e == null) {
                    return;
                }
                this.f41009e.f40998e.smallGameUpdate();
                if (this.f41009e.f41003j != null) {
                    if (this.f41009e.f41004k) {
                        this.f41009e.f41003j.a(this.f41009e.getScreenShot(), this.f41009e.f41001h, this.f41009e.f41002i);
                        this.f41009e.f40998e.setScreenShotStatus(false);
                        this.f41009e.f41004k = false;
                        this.f41009e.f41003j = null;
                    }
                    if (this.f41009e.f41003j != null) {
                        this.f41009e.f40998e.setScreenShotStatus(true);
                        this.f41009e.f41004k = true;
                    }
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10, i2, i3) == null) {
                this.f41009e.f41001h = i2;
                this.f41009e.f41002i = i3;
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

    /* loaded from: classes11.dex */
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
        m = k.a;
        c.a.q0.a.k2.d.c();
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
            int i3 = this.f41001h;
            if (i3 > 0 && (i2 = this.f41002i) > 0) {
                try {
                    int[] iArr = new int[i3 * i2];
                    IntBuffer wrap = IntBuffer.wrap(iArr);
                    wrap.position(0);
                    GLES20.glReadPixels(0, 0, this.f41001h, this.f41002i, GeneratedTexture.FORMAT, 5121, wrap);
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
        if (!(interceptable == null || interceptable.invokeL(65551, this, renderer) == null) || (aREngineDelegate = this.f40998e) == null) {
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
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                aREngineDelegate.clearOldEvents();
            }
        }
    }

    public void doEnginePerformanceUBC() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.a.l0.a aVar = this.f40999f;
            if (aVar != null) {
                h.b(aVar.q0());
            }
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                h.b(aREngineDelegate.getPerformanceJson());
            }
        }
    }

    public int getFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AREngineDelegate aREngineDelegate = this.f40998e;
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
            AREngineDelegate aREngineDelegate = this.f40998e;
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
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                return aREngineDelegate.getGLThread();
            }
            return null;
        }
        return (Thread) invokeV.objValue;
    }

    public c.a.q0.a.l0.a getV8Engine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f40999f : (c.a.q0.a.l0.a) invokeV.objValue;
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
            aVar.f(new c.a.q0.j.q.a());
            c.a.q0.a.u1.h.p("preload").F(new UbcFlowEvent("na_game_engine_start"));
            AREngineDelegate createAREngine = MarioSDK.createAREngine(aVar);
            this.f40998e = createAREngine;
            createAREngine.setPermissionProxy(new c.a.q0.a.l0.n.e());
            this.f40998e.setOnStuckScreenListener(new a(this));
            this.f40998e.startEngine();
            c.a.q0.a.u1.h.p("preload").F(new UbcFlowEvent("na_game_engine_end"));
            this.f41000g = new c.a.q0.j.q.c.a();
            this.l = new GameRecorderController(this.f40998e);
            g.a().g(this.l);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f41002i = 0;
            this.f41001h = 0;
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
            AREngineDelegate aREngineDelegate = this.f40998e;
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
            if (this.f40998e != null) {
                c.a.q0.a.l0.a aVar = this.f40999f;
                if (aVar != null) {
                    aVar.m0();
                }
                this.f40998e.setFirstFrameListener(null);
                this.f40998e.setOnStuckScreenListener(null);
                this.f40998e.smallGameDestroy();
                this.f40998e.exitGLThread();
                this.f40998e = null;
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f40998e;
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
            SwanAppActivity activity = c.a.q0.a.g1.f.U().getActivity();
            if (activity != null) {
                c.a.q0.a.t0.c frame = activity.getFrame();
                if (frame instanceof c.a.q0.j.o.d) {
                    ((c.a.q0.j.o.d) frame).k1();
                }
            }
        }
    }

    public void onJSError(V8ExceptionInfo v8ExceptionInfo) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, v8ExceptionInfo) == null) || (aREngineDelegate = this.f40998e) == null || aREngineDelegate.getStuckScreenHandler() == null) {
            return;
        }
        this.f40998e.getStuckScreenHandler().a(0, v8ExceptionInfo);
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean z = m;
            queueEvent(new b(this));
            AREngineDelegate aREngineDelegate = this.f40998e;
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
            AREngineDelegate aREngineDelegate = this.f40998e;
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
            if (this.f41000g.a(motionEvent)) {
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
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                aREngineDelegate.queueEvent(runnable);
            }
        }
    }

    public void requestRender() {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (aREngineDelegate = this.f40998e) == null) {
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
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                aREngineDelegate.runOnGLThread(runnable);
            }
        }
    }

    public void setRenderMode(int i2) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (aREngineDelegate = this.f40998e) == null) {
            return;
        }
        aREngineDelegate.setRenderMode(i2);
    }

    public void setV8Engine(c.a.q0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.f40999f = aVar;
            this.f41000g.c(aVar);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048601, this, surfaceHolder, i2, i3, i4) == null) {
            if (m) {
                String str = "surfaceChanged width: " + i3 + ", height: " + i4;
            }
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceChanged(i3, i4);
            }
            c.a.q0.j.q.c.a aVar = this.f41000g;
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
            AREngineDelegate aREngineDelegate = this.f40998e;
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
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceDestroyed();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, surfaceHolder) == null) || (aREngineDelegate = this.f40998e) == null) {
            return;
        }
        aREngineDelegate.requestRenderAndWait();
    }

    public void updateGameCanvasSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            Pair<Integer, Integer> x = c.a.q0.a.g1.f.U().x();
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                aREngineDelegate.updateSurfaceViewSize(((Integer) x.first).intValue(), ((Integer) x.second).intValue());
                this.f40998e.initDisplayMetrics();
            }
            c.a.q0.j.q.c.a aVar = this.f41000g;
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

    public void queueEvent(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, runnable, j2) == null) {
            boolean z = m;
            AREngineDelegate aREngineDelegate = this.f40998e;
            if (aREngineDelegate != null) {
                aREngineDelegate.queueEvent(runnable, j2);
            }
        }
    }
}
