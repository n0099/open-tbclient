package com.baidu.smallgame.sdk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.tieba.yh1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@NotProguard
/* loaded from: classes3.dex */
public class MarioSDK {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MarioSDK";
    public transient /* synthetic */ FieldHolder $fh;
    public AREngineDelegate mAREngineDelegate;
    public b mMarioInitListener;
    public V8Engine mV8Engine;

    /* loaded from: classes3.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SurfaceHolder a;
        public GLSurfaceView.Renderer b;
        public ArBridge.FirstFrameListener c;
        public int d;
        public List<DebugConsole> e;
        public Context f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = new ArrayList();
        }

        public List<DebugConsole> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.e;
            }
            return (List) invokeV.objValue;
        }

        public Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.f;
            }
            return (Context) invokeV.objValue;
        }

        public void f(DebugConsole debugConsole) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, debugConsole) != null) || debugConsole == null) {
                return;
            }
            this.e.add(debugConsole);
        }

        public void h(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                this.f = context;
            }
        }

        public void i(ArBridge.FirstFrameListener firstFrameListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, firstFrameListener) == null) {
                this.c = firstFrameListener;
            }
        }

        public void j(GLSurfaceView.Renderer renderer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, renderer) == null) {
                this.b = renderer;
            }
        }

        public void k(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, surfaceHolder) == null) {
                this.a = surfaceHolder;
            }
        }
    }

    public MarioSDK(V8Engine v8Engine, AREngineDelegate aREngineDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Engine, aREngineDelegate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mV8Engine = v8Engine;
        this.mAREngineDelegate = aREngineDelegate;
    }

    public static AREngineDelegate createAREngine(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            yh1 yh1Var = new yh1();
            if (aVar.a != null) {
                yh1Var.p(aVar.a);
            }
            if (aVar.c != null) {
                yh1Var.setFirstFrameListener(aVar.c);
            }
            yh1Var.setRenderMode(aVar.d);
            if (aVar.f != null) {
                yh1Var.o(aVar.f);
            }
            if (aVar.b != null) {
                yh1Var.setRenderer(aVar.b);
            }
            if (aVar.g() != null) {
                for (DebugConsole debugConsole : aVar.g()) {
                    yh1Var.addDebugConsole(debugConsole);
                }
            }
            return yh1Var;
        }
        return (AREngineDelegate) invokeL.objValue;
    }

    public static V8Engine createV8Engine(Context context, V8EngineConfiguration v8EngineConfiguration) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, v8EngineConfiguration)) == null) {
            if (v8EngineConfiguration == null) {
                return null;
            }
            V8Engine v8Engine = new V8Engine(context, v8EngineConfiguration.getBasePath(), v8EngineConfiguration.getJsPath(), v8EngineConfiguration.getV8ThreadDelegatePolicy(), v8EngineConfiguration.getMainGlobalObject(), v8EngineConfiguration.getOpenGlobalObject());
            if (v8EngineConfiguration.getUserAgent() != null) {
                v8Engine.setUserAgent(v8EngineConfiguration.getUserAgent());
            }
            if (v8EngineConfiguration.getDecodeBdFile() != null) {
                v8Engine.setBdFileRealPath(v8EngineConfiguration.getDecodeBdFile());
            }
            if (v8EngineConfiguration.getJavaScriptExceptionDelegate() != null) {
                v8Engine.setJavaScriptExceptionDelegate(v8EngineConfiguration.getJavaScriptExceptionDelegate());
            }
            if (v8EngineConfiguration.getFileSystemDelegatePolicy() != null) {
                v8Engine.setFileSystemDelegatePolicy(v8EngineConfiguration.getFileSystemDelegatePolicy());
            }
            if (v8EngineConfiguration.getV8EngineConsoles() != null) {
                for (V8Engine.V8EngineConsole v8EngineConsole : v8EngineConfiguration.getV8EngineConsoles()) {
                    v8Engine.addV8EngineConsole(v8EngineConsole);
                }
            }
            if (v8EngineConfiguration.getV8StatusListeners() != null) {
                for (V8Engine.V8StatusListener v8StatusListener : v8EngineConfiguration.getV8StatusListeners()) {
                    v8Engine.addStatusHandler(v8StatusListener);
                }
            }
            return v8Engine;
        }
        return (V8Engine) invokeLL.objValue;
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, v8EngineConfiguration, aVar)) == null) {
            return initialize(context, v8EngineConfiguration, aVar, null);
        }
        return (MarioSDK) invokeLLL.objValue;
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, a aVar, b bVar) {
        InterceptResult invokeLLLL;
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, v8EngineConfiguration, aVar, bVar)) == null) {
            AREngineDelegate aREngineDelegate = null;
            try {
                v8Engine = createV8Engine(context, v8EngineConfiguration);
            } catch (Exception e) {
                Log.e(TAG, "v8Engine init error", e);
                v8Engine = null;
            }
            try {
                aREngineDelegate = createAREngine(aVar);
            } catch (Exception e2) {
                Log.e(TAG, "AREngine init error", e2);
            }
            MarioSDK marioSDK = new MarioSDK(v8Engine, aREngineDelegate);
            if (bVar != null) {
                bVar.a();
            }
            return marioSDK;
        }
        return (MarioSDK) invokeLLLL.objValue;
    }

    public AREngineDelegate getAREngineDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mAREngineDelegate;
        }
        return (AREngineDelegate) invokeV.objValue;
    }

    public V8Engine getV8Engine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mV8Engine;
        }
        return (V8Engine) invokeV.objValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            resetAREngine();
            resetV8Engine();
        }
    }

    public void resetAREngine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mAREngineDelegate = null;
        }
    }

    public void resetV8Engine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mV8Engine = null;
        }
    }

    public void setMarioInitListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.mMarioInitListener = bVar;
        }
    }
}
