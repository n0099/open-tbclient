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
import com.baidu.tieba.a1;
import com.baidu.tieba.a2;
import com.baidu.tieba.b1;
import com.baidu.tieba.c2;
import com.baidu.tieba.e1;
import com.baidu.tieba.f1;
import com.baidu.tieba.g1;
import com.baidu.tieba.g3;
import com.baidu.tieba.h1;
import com.baidu.tieba.i1;
import com.baidu.tieba.k1;
import com.baidu.tieba.n1;
import com.baidu.tieba.p1;
import com.baidu.tieba.r2;
import com.baidu.tieba.t1;
import com.baidu.tieba.t2;
import com.baidu.tieba.u1;
import com.baidu.tieba.v0;
import com.baidu.tieba.w0;
import com.baidu.tieba.w2;
import com.baidu.tieba.x0;
import com.baidu.tieba.x1;
import com.baidu.tieba.y0;
import com.baidu.tieba.y1;
import com.baidu.tieba.z1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(17)
/* loaded from: classes.dex */
public class AndroidDaydream extends DreamService implements e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w0 applicationLogger;
    public h1 audio;
    public i1 clipboard;
    public final r2<Runnable> executedRunnables;
    public k1 files;
    public boolean firstResume;
    public n1 graphics;
    public Handler handler;
    public p1 input;
    public final g3<a1> lifecycleListeners;
    public v0 listener;
    public int logLevel;
    public t1 net;
    public final r2<Runnable> runnables;

    @Override // com.baidu.tieba.e1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (Context) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public class a implements a1 {
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

        @Override // com.baidu.tieba.a1
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.audio.dispose();
                this.a.audio = null;
            }
        }

        @Override // com.baidu.tieba.a1
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.audio.pause();
            }
        }

        @Override // com.baidu.tieba.a1
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
        w2.a();
    }

    public k1 createFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            getFilesDir();
            return new y1(getAssets(), this, true);
        }
        return (k1) invokeV.objValue;
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
    public v0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.listener;
        }
        return (v0) invokeV.objValue;
    }

    public w0 getApplicationLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.applicationLogger;
        }
        return (w0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return getWindow();
        }
        return (Window) invokeV.objValue;
    }

    public x0 getAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.audio;
        }
        return (x0) invokeV.objValue;
    }

    public t2 getClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.clipboard;
        }
        return (t2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public r2<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.executedRunnables;
        }
        return (r2) invokeV.objValue;
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

    @Override // com.baidu.tieba.e1
    public g3<a1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.lifecycleListeners;
        }
        return (g3) invokeV.objValue;
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

    @Override // com.baidu.tieba.e1
    public r2<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.runnables;
        }
        return (r2) invokeV.objValue;
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
        this.runnables = new r2<>();
        this.executedRunnables = new r2<>();
        this.lifecycleListeners = new g3<>(a1.class);
        this.logLevel = 2;
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            y0.a = this;
            getInput();
            getAudio();
            getFiles();
            y0.b = getGraphics();
            getNet();
            this.input.j1();
            n1 n1Var = this.graphics;
            if (n1Var != null) {
                n1Var.p();
            }
            if (!this.firstResume) {
                this.graphics.s();
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
            this.graphics.t(true);
            this.graphics.q();
            this.input.q0();
            this.graphics.g();
            this.graphics.i();
            this.graphics.t(d);
            this.graphics.o();
            super.onDreamingStopped();
        }
    }

    private void init(v0 v0Var, f1 f1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, v0Var, f1Var, z) == null) {
            setApplicationLogger(new g1());
            c2 c2Var = f1Var.r;
            if (c2Var == null) {
                c2Var = new a2();
            }
            n1 n1Var = new n1(this, f1Var, c2Var);
            this.graphics = n1Var;
            this.input = createInput(this, this, n1Var.a, f1Var);
            this.audio = createAudio(this, f1Var);
            this.files = createFiles();
            this.net = new t1(this, f1Var);
            this.listener = v0Var;
            this.handler = new Handler();
            this.clipboard = new i1(this);
            addLifecycleListener(new a(this));
            y0.a = this;
            getInput();
            getAudio();
            getFiles();
            y0.b = getGraphics();
            getNet();
            if (!z) {
                setFullscreen(true);
                setContentView(this.graphics.l(), createLayoutParams());
            }
            createWakeLock(f1Var.n);
            hideStatusBar(f1Var);
            if (getResources().getConfiguration().keyboard != 1) {
                this.input.C(true);
            }
        }
    }

    public void addLifecycleListener(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.a(a1Var);
            }
        }
    }

    public void createWakeLock(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            getWindow().addFlags(128);
        }
    }

    public b1 getPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return new u1(getSharedPreferences(str, 0));
        }
        return (b1) invokeL.objValue;
    }

    public void hideStatusBar(f1 f1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, f1Var) != null) || !f1Var.o) {
            return;
        }
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(0);
        decorView.setSystemUiVisibility(1);
    }

    public void initialize(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, v0Var) == null) {
            initialize(v0Var, new f1());
        }
    }

    public View initializeForView(v0 v0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, v0Var)) == null) {
            return initializeForView(v0Var, new f1());
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
            this.input.C(z);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, runnable) == null) {
            synchronized (this.runnables) {
                this.runnables.a(runnable);
                y0.b.c();
            }
        }
    }

    public void removeLifecycleListener(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, a1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.g(a1Var, true);
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

    public void setApplicationLogger(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, w0Var) == null) {
            this.applicationLogger = w0Var;
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

    public h1 createAudio(Context context, f1 f1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, f1Var)) == null) {
            return new x1(context, f1Var);
        }
        return (h1) invokeLL.objValue;
    }

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

    public void initialize(v0 v0Var, f1 f1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, v0Var, f1Var) == null) {
            init(v0Var, f1Var, false);
        }
    }

    public View initializeForView(v0 v0Var, f1 f1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, v0Var, f1Var)) == null) {
            init(v0Var, f1Var, true);
            return this.graphics.l();
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

    public p1 createInput(Application application, Context context, Object obj, f1 f1Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, application, context, obj, f1Var)) == null) {
            return new z1(this, this, this.graphics.a, f1Var);
        }
        return (p1) invokeLLLL.objValue;
    }

    public void debug(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) && this.logLevel >= 3) {
            getApplicationLogger().b(str, str2, th);
        }
    }

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
    @Override // com.baidu.tieba.e1
    public p1 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.input;
        }
        return (p1) invokeV.objValue;
    }
}
