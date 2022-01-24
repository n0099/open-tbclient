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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@NotProguard
/* loaded from: classes11.dex */
public class MarioSDK {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MarioSDK";
    public transient /* synthetic */ FieldHolder $fh;
    public AREngineDelegate mAREngineDelegate;
    public b mMarioInitListener;
    public V8Engine mV8Engine;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SurfaceHolder a;

        /* renamed from: b  reason: collision with root package name */
        public GLSurfaceView.Renderer f38340b;

        /* renamed from: c  reason: collision with root package name */
        public ArBridge.FirstFrameListener f38341c;

        /* renamed from: d  reason: collision with root package name */
        public int f38342d;

        /* renamed from: e  reason: collision with root package name */
        public List<DebugConsole> f38343e;

        /* renamed from: f  reason: collision with root package name */
        public Context f38344f;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38343e = new ArrayList();
        }

        public void f(DebugConsole debugConsole) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, debugConsole) == null) || debugConsole == null) {
                return;
            }
            this.f38343e.add(debugConsole);
        }

        public List<DebugConsole> g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38343e : (List) invokeV.objValue;
        }

        public Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38344f : (Context) invokeV.objValue;
        }

        public void h(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
                this.f38344f = context;
            }
        }

        public void i(ArBridge.FirstFrameListener firstFrameListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, firstFrameListener) == null) {
                this.f38341c = firstFrameListener;
            }
        }

        public void j(GLSurfaceView.Renderer renderer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, renderer) == null) {
                this.f38340b = renderer;
            }
        }

        public void k(SurfaceHolder surfaceHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, surfaceHolder) == null) {
                this.a = surfaceHolder;
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a();
    }

    public MarioSDK(V8Engine v8Engine, AREngineDelegate aREngineDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Engine, aREngineDelegate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            c.a.n0.a.a aVar2 = new c.a.n0.a.a();
            if (aVar.a != null) {
                aVar2.p(aVar.a);
            }
            if (aVar.f38341c != null) {
                aVar2.setFirstFrameListener(aVar.f38341c);
            }
            aVar2.setRenderMode(aVar.f38342d);
            if (aVar.f38344f != null) {
                aVar2.o(aVar.f38344f);
            }
            if (aVar.f38340b != null) {
                aVar2.setRenderer(aVar.f38340b);
            }
            if (aVar.g() != null) {
                for (DebugConsole debugConsole : aVar.g()) {
                    aVar2.addDebugConsole(debugConsole);
                }
            }
            return aVar2;
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, v8EngineConfiguration, aVar)) == null) ? initialize(context, v8EngineConfiguration, aVar, null) : (MarioSDK) invokeLLL.objValue;
    }

    public AREngineDelegate getAREngineDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAREngineDelegate : (AREngineDelegate) invokeV.objValue;
    }

    public V8Engine getV8Engine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mV8Engine : (V8Engine) invokeV.objValue;
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

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, a aVar, b bVar) {
        InterceptResult invokeLLLL;
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, v8EngineConfiguration, aVar, bVar)) == null) {
            AREngineDelegate aREngineDelegate = null;
            try {
                v8Engine = createV8Engine(context, v8EngineConfiguration);
            } catch (Exception e2) {
                Log.e(TAG, "v8Engine init error", e2);
                v8Engine = null;
            }
            try {
                aREngineDelegate = createAREngine(aVar);
            } catch (Exception e3) {
                Log.e(TAG, "AREngine init error", e3);
            }
            MarioSDK marioSDK = new MarioSDK(v8Engine, aREngineDelegate);
            if (bVar != null) {
                bVar.a();
            }
            return marioSDK;
        }
        return (MarioSDK) invokeLLLL.objValue;
    }
}
