package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.service.dreams.DreamService;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Net;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a2;
import com.baidu.tieba.c2;
import com.baidu.tieba.g2;
import com.baidu.tieba.h2;
import com.baidu.tieba.k6;
import com.baidu.tieba.l0;
import com.baidu.tieba.m0;
import com.baidu.tieba.m2;
import com.baidu.tieba.n0;
import com.baidu.tieba.n2;
import com.baidu.tieba.o0;
import com.baidu.tieba.o2;
import com.baidu.tieba.o6;
import com.baidu.tieba.q0;
import com.baidu.tieba.q1;
import com.baidu.tieba.q2;
import com.baidu.tieba.q7;
import com.baidu.tieba.r0;
import com.baidu.tieba.r1;
import com.baidu.tieba.s1;
import com.baidu.tieba.s2;
import com.baidu.tieba.t1;
import com.baidu.tieba.t6;
import com.baidu.tieba.u1;
import com.baidu.tieba.x1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(17)
/* loaded from: classes.dex */
public class AndroidDaydream extends DreamService implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m0 applicationLogger;
    public t1 audio;
    public u1 clipboard;
    public final k6<Runnable> executedRunnables;
    public x1 files;
    public boolean firstResume;
    public a2 graphics;
    public Handler handler;
    public c2 input;
    public final q7<q0> lifecycleListeners;
    public l0 listener;
    public int logLevel;
    public g2 net;
    public final k6<Runnable> runnables;

    @Override // com.baidu.tieba.q1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (Context) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public class a implements q0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AndroidDaydream a;

        public a(AndroidDaydream androidDaydream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidDaydream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = androidDaydream;
        }

        @Override // com.baidu.tieba.q0
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.audio.dispose();
                this.a.audio = null;
            }
        }

        @Override // com.baidu.tieba.q0
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.audio.pause();
            }
        }

        @Override // com.baidu.tieba.q0
        public void resume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.audio.resume();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AndroidDaydream a;

        public b(AndroidDaydream androidDaydream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidDaydream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = androidDaydream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1258622043, "Lcom/badlogic/gdx/backends/android/AndroidDaydream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1258622043, "Lcom/badlogic/gdx/backends/android/AndroidDaydream;");
                return;
            }
        }
        t6.a();
    }

    public x1 createFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            getFilesDir();
            return new n2(getAssets(), this, true);
        }
        return (x1) invokeV.objValue;
    }

    public FrameLayout.LayoutParams createLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.handler.post(new b(this));
        }
    }

    @Override // com.badlogic.gdx.Application
    public l0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.listener;
        }
        return (l0) invokeV.objValue;
    }

    public m0 getApplicationLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.applicationLogger;
        }
        return (m0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return getWindow();
        }
        return (Window) invokeV.objValue;
    }

    public n0 getAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.audio;
        }
        return (n0) invokeV.objValue;
    }

    public o6 getClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.clipboard;
        }
        return (o6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public k6<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.executedRunnables;
        }
        return (k6) invokeV.objValue;
    }

    public Files getFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.files;
        }
        return (Files) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.graphics;
        }
        return (Graphics) invokeV.objValue;
    }

    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.handler;
        }
        return (Handler) invokeV.objValue;
    }

    public long getJavaHeap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.q1
    public q7<q0> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.lifecycleListeners;
        }
        return (q7) invokeV.objValue;
    }

    public int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.logLevel;
        }
        return invokeV.intValue;
    }

    public long getNativeHeap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return Debug.getNativeHeapAllocatedSize();
        }
        return invokeV.longValue;
    }

    public Net getNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.net;
        }
        return (Net) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public k6<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.runnables;
        }
        return (k6) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return Application.ApplicationType.Android;
        }
        return (Application.ApplicationType) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return Build.VERSION.SDK_INT;
        }
        return invokeV.intValue;
    }

    @Override // android.service.dreams.DreamService, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    public AndroidDaydream() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.firstResume = true;
        this.runnables = new k6<>();
        this.executedRunnables = new k6<>();
        this.lifecycleListeners = new q7<>(q0.class);
        this.logLevel = 2;
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            o0.a = this;
            getInput();
            o0.c = getAudio();
            o0.d = getFiles();
            o0.b = getGraphics();
            getNet();
            this.input.R0();
            a2 a2Var = this.graphics;
            if (a2Var != null) {
                a2Var.q();
            }
            if (!this.firstResume) {
                this.graphics.t();
            } else {
                this.firstResume = false;
            }
            super.onDreamingStarted();
        }
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            boolean d = this.graphics.d();
            this.graphics.u(true);
            this.graphics.r();
            this.input.e0();
            this.graphics.h();
            this.graphics.j();
            this.graphics.u(d);
            this.graphics.p();
            super.onDreamingStopped();
        }
    }

    private void init(l0 l0Var, r1 r1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, l0Var, r1Var, z) == null) {
            setApplicationLogger(new s1());
            s2 s2Var = r1Var.r;
            if (s2Var == null) {
                s2Var = new q2();
            }
            a2 a2Var = new a2(this, r1Var, s2Var);
            this.graphics = a2Var;
            this.input = createInput(this, this, a2Var.a, r1Var);
            this.audio = createAudio(this, r1Var);
            this.files = createFiles();
            this.net = new g2(this, r1Var);
            this.listener = l0Var;
            this.handler = new Handler();
            this.clipboard = new u1(this);
            addLifecycleListener(new a(this));
            o0.a = this;
            getInput();
            o0.c = getAudio();
            o0.d = getFiles();
            o0.b = getGraphics();
            getNet();
            if (!z) {
                setFullscreen(true);
                setContentView(this.graphics.m(), createLayoutParams());
            }
            createWakeLock(r1Var.n);
            hideStatusBar(r1Var);
            if (getResources().getConfiguration().keyboard != 1) {
                this.input.s(true);
            }
        }
    }

    public void addLifecycleListener(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q0Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.a(q0Var);
            }
        }
    }

    public void createWakeLock(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            getWindow().addFlags(128);
        }
    }

    public r0 getPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return new h2(getSharedPreferences(str, 0));
        }
        return (r0) invokeL.objValue;
    }

    public void hideStatusBar(r1 r1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, r1Var) != null) || !r1Var.o) {
            return;
        }
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(0);
        decorView.setSystemUiVisibility(1);
    }

    public void initialize(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, l0Var) == null) {
            initialize(l0Var, new r1());
        }
    }

    public View initializeForView(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, l0Var)) == null) {
            return initializeForView(l0Var, new r1());
        }
        return (View) invokeL.objValue;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            boolean z = true;
            if (configuration.hardKeyboardHidden != 1) {
                z = false;
            }
            this.input.s(z);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, runnable) == null) {
            synchronized (this.runnables) {
                this.runnables.a(runnable);
                o0.b.c();
            }
        }
    }

    public void removeLifecycleListener(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, q0Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.i(q0Var, true);
            }
        }
    }

    public void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, runnable) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public void setApplicationLogger(m0 m0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, m0Var) == null) {
            this.applicationLogger = m0Var;
        }
    }

    public void setLogLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.logLevel = i;
        }
    }

    public void useImmersiveMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public t1 createAudio(Context context, r1 r1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, r1Var)) == null) {
            return new m2(context, r1Var);
        }
        return (t1) invokeLL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && this.logLevel >= 3) {
            getApplicationLogger().debug(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) && this.logLevel >= 1) {
            getApplicationLogger().error(str, str2);
        }
    }

    public void initialize(l0 l0Var, r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, l0Var, r1Var) == null) {
            init(l0Var, r1Var, false);
        }
    }

    public View initializeForView(l0 l0Var, r1 r1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, l0Var, r1Var)) == null) {
            init(l0Var, r1Var, true);
            return this.graphics.m();
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) && this.logLevel >= 2) {
            getApplicationLogger().log(str, str2);
        }
    }

    public c2 createInput(Application application, Context context, Object obj, r1 r1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, application, context, obj, r1Var)) == null) {
            return new o2(this, this, this.graphics.a, r1Var);
        }
        return (c2) invokeLLLL.objValue;
    }

    public void debug(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) && this.logLevel >= 3) {
            getApplicationLogger().b(str, str2, th);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, th) == null) && this.logLevel >= 1) {
            getApplicationLogger().error(str, str2, th);
        }
    }

    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, th) == null) && this.logLevel >= 2) {
            getApplicationLogger().a(str, str2, th);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    public c2 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.input;
        }
        return (c2) invokeV.objValue;
    }
}
