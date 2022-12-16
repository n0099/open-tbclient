package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.MarioSDK;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.b54;
import com.baidu.tieba.dh2;
import com.baidu.tieba.f04;
import com.baidu.tieba.f44;
import com.baidu.tieba.gc2;
import com.baidu.tieba.jx2;
import com.baidu.tieba.l04;
import com.baidu.tieba.mb2;
import com.baidu.tieba.n04;
import com.baidu.tieba.o04;
import com.baidu.tieba.ok1;
import com.baidu.tieba.q54;
import com.baidu.tieba.rp2;
import com.baidu.tieba.wh1;
import com.baidu.tieba.x93;
import com.baidu.tieba.xh1;
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
/* loaded from: classes3.dex */
public class DuMixGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, ArBridge.FirstFrameListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public AREngineDelegate a;
    public mb2 b;
    public n04 c;
    public int d;
    public int e;
    public volatile d f;
    public boolean g;
    public GameRecorderController h;

    /* loaded from: classes3.dex */
    public interface d {
        void a(int[] iArr, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public class a implements wh1 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = duMixGameSurfaceView;
        }

        @Override // com.baidu.tieba.wh1
        public void b(xh1 xh1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xh1Var) == null) {
                q54.c(xh1Var);
            }
        }

        @Override // com.baidu.tieba.wh1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o04.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DuMixGameSurfaceView a;

        public b(DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = duMixGameSurfaceView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null) {
                this.a.a.smallGameOnPause();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements GLSurfaceView.Renderer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DuMixGameSurfaceView a;

        public c(DuMixGameSurfaceView duMixGameSurfaceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {duMixGameSurfaceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = duMixGameSurfaceView;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gl10) == null) {
                if (DuMixGameSurfaceView.i) {
                    Log.d("DuMixGameSurfaceView", "AiWebRender onDrawFrame !!!");
                }
                if (this.a.a == null) {
                    return;
                }
                this.a.a.smallGameUpdate();
                if (this.a.f != null) {
                    if (this.a.g) {
                        this.a.f.a(this.a.getScreenShot(), this.a.d, this.a.e);
                        this.a.a.setScreenShotStatus(false);
                        this.a.g = false;
                        this.a.f = null;
                    }
                    if (this.a.f != null) {
                        this.a.a.setScreenShotStatus(true);
                        this.a.g = true;
                    }
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gl10, i, i2) != null) {
                return;
            }
            this.a.d = i;
            this.a.e = i2;
            if (DuMixGameSurfaceView.i) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceChanged width * height = " + i + " * " + i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gl10, eGLConfig) == null) && DuMixGameSurfaceView.i) {
                Log.d("DuMixGameSurfaceView", "AiWebRender onSurfaceCreated !!!");
            }
        }
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
        i = ok1.a;
        x93.c();
    }

    public int getFPS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AREngineDelegate aREngineDelegate = this.a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AREngineDelegate aREngineDelegate = this.a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                return aREngineDelegate.getGLThread();
            }
            return null;
        }
        return (Thread) invokeV.objValue;
    }

    public mb2 getV8Engine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (mb2) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "executeQueueEvent");
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.clearOldEvents();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            mb2 mb2Var = this.b;
            if (mb2Var != null) {
                b54.b(mb2Var.o0());
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                b54.b(aREngineDelegate.getPerformanceJson());
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.onAttachedToWindow();
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "onDetachedFromWindow");
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // com.baidu.smallgame.sdk.ArBridge.FirstFrameListener
    public void onFirstFrameFinished() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            n();
            SwanAppActivity activity = rp2.U().getActivity();
            if (activity != null) {
                dh2 Q = activity.Q();
                if (Q instanceof f04) {
                    ((f04) Q).k1();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            surfaceChanged(getHolder(), 0, getWidth(), getHeight());
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_PAUSE);
            }
            u(new b(this));
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.onPause();
            }
            f44.a().d();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "onResume");
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.onResume();
            }
            f44.a().e();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.e = 0;
            this.d = 0;
        }
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
        o();
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
        o();
    }

    private void setRenderer(GLSurfaceView.Renderer renderer) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65551, this, renderer) == null) && (aREngineDelegate = this.a) != null) {
            aREngineDelegate.setRenderer(renderer);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (this.c.a(motionEvent)) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void r(V8ExceptionInfo v8ExceptionInfo) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, v8ExceptionInfo) == null) && (aREngineDelegate = this.a) != null && aREngineDelegate.getStuckScreenHandler() != null) {
            this.a.getStuckScreenHandler().a(0, v8ExceptionInfo);
        }
    }

    public void setRenderMode(int i2) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && (aREngineDelegate = this.a) != null) {
            aREngineDelegate.setRenderMode(i2);
        }
    }

    public void setV8Engine(mb2 mb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mb2Var) == null) {
            this.b = mb2Var;
            this.c.c(mb2Var);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, surfaceHolder) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "surfaceCreated");
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceCreated();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "surfaceDestroyed width");
            }
            w();
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceDestroyed();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        AREngineDelegate aREngineDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, surfaceHolder) == null) && (aREngineDelegate = this.a) != null) {
            aREngineDelegate.requestRenderAndWait();
        }
    }

    public void u(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, runnable) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "queueEvent");
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.queueEvent(runnable);
            }
        }
    }

    public void x(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, runnable) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "runOnGLThread");
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.runOnGLThread(runnable);
            }
        }
    }

    public void v(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, runnable, j) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "queueEvent delayed");
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.queueEvent(runnable, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getScreenShot() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i3 = this.d;
            if (i3 > 0 && (i2 = this.e) > 0) {
                try {
                    int[] iArr = new int[i3 * i2];
                    IntBuffer wrap = IntBuffer.wrap(iArr);
                    wrap.position(0);
                    GLES20.glReadPixels(0, 0, this.d, this.e, GeneratedTexture.FORMAT, 5121, wrap);
                    return iArr;
                } catch (OutOfMemoryError unused) {
                }
            }
            return null;
        }
        return (int[]) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "init");
            }
            SurfaceHolder holder = getHolder();
            holder.addCallback(this);
            MarioSDK.a aVar = new MarioSDK.a();
            aVar.k(holder);
            aVar.i(this);
            aVar.j(new c(this));
            aVar.h(AppRuntime.getAppContext());
            aVar.f(new l04());
            jx2.p("preload").F(new UbcFlowEvent("na_game_engine_start"));
            AREngineDelegate createAREngine = MarioSDK.createAREngine(aVar);
            this.a = createAREngine;
            createAREngine.setPermissionProxy(new gc2());
            this.a.setOnStuckScreenListener(new a(this));
            this.a.startEngine();
            jx2.p("preload").F(new UbcFlowEvent("na_game_engine_end"));
            this.c = new n04();
            this.h = new GameRecorderController(this.a);
            f44.a().g(this.h);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", MissionEvent.MESSAGE_DESTROY);
            }
            w();
            f44.a().f(this.h);
            if (this.a != null) {
                mb2 mb2Var = this.b;
                if (mb2Var != null) {
                    mb2Var.k0();
                }
                this.a.setFirstFrameListener(null);
                this.a.setOnStuckScreenListener(null);
                this.a.smallGameDestroy();
                this.a.exitGLThread();
                this.a = null;
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            Pair<Integer, Integer> x = rp2.U().x();
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.updateSurfaceViewSize(((Integer) x.first).intValue(), ((Integer) x.second).intValue());
                this.a.initDisplayMetrics();
            }
            n04 n04Var = this.c;
            if (n04Var != null) {
                n04Var.d(((Integer) x.first).intValue(), ((Integer) x.second).intValue());
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048593, this, surfaceHolder, i2, i3, i4) == null) {
            if (i) {
                Log.d("DuMixGameSurfaceView", "surfaceChanged width: " + i3 + ", height: " + i4);
            }
            AREngineDelegate aREngineDelegate = this.a;
            if (aREngineDelegate != null) {
                aREngineDelegate.surfaceChanged(i3, i4);
            }
            n04 n04Var = this.c;
            if (n04Var != null) {
                n04Var.b(i3, i4);
            }
        }
    }
}
