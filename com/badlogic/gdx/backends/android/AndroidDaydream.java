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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a1;
import com.repackage.a3;
import com.repackage.b1;
import com.repackage.b3;
import com.repackage.c3;
import com.repackage.c7;
import com.repackage.d1;
import com.repackage.d2;
import com.repackage.e1;
import com.repackage.e2;
import com.repackage.e3;
import com.repackage.e8;
import com.repackage.f2;
import com.repackage.g2;
import com.repackage.g3;
import com.repackage.h2;
import com.repackage.h7;
import com.repackage.k2;
import com.repackage.n2;
import com.repackage.p2;
import com.repackage.t2;
import com.repackage.u2;
import com.repackage.y0;
import com.repackage.y6;
import com.repackage.z0;
@TargetApi(17)
/* loaded from: classes.dex */
public class AndroidDaydream extends DreamService implements d2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z0 applicationLogger;
    public g2 audio;
    public h2 clipboard;
    public final y6<Runnable> executedRunnables;
    public k2 files;
    public boolean firstResume;
    public n2 graphics;
    public Handler handler;
    public p2 input;
    public final e8<d1> lifecycleListeners;
    public y0 listener;
    public int logLevel;
    public t2 net;
    public final y6<Runnable> runnables;

    /* loaded from: classes.dex */
    public class a implements d1 {
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

        @Override // com.repackage.d1
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.audio.dispose();
                this.a.audio = null;
            }
        }

        @Override // com.repackage.d1
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.audio.pause();
            }
        }

        @Override // com.repackage.d1
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
        h7.a();
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
        this.runnables = new y6<>();
        this.executedRunnables = new y6<>();
        this.lifecycleListeners = new e8<>(d1.class);
        this.logLevel = 2;
    }

    private void init(y0 y0Var, e2 e2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, y0Var, e2Var, z) == null) {
            setApplicationLogger(new f2());
            g3 g3Var = e2Var.r;
            if (g3Var == null) {
                g3Var = new e3();
            }
            n2 n2Var = new n2(this, e2Var, g3Var);
            this.graphics = n2Var;
            this.input = createInput(this, this, n2Var.a, e2Var);
            this.audio = createAudio(this, e2Var);
            this.files = createFiles();
            this.net = new t2(this, e2Var);
            this.listener = y0Var;
            this.handler = new Handler();
            this.clipboard = new h2(this);
            addLifecycleListener(new a(this));
            b1.a = this;
            getInput();
            b1.c = getAudio();
            b1.d = getFiles();
            b1.b = getGraphics();
            getNet();
            if (!z) {
                setFullscreen(true);
                setContentView(this.graphics.m(), createLayoutParams());
            }
            createWakeLock(e2Var.n);
            hideStatusBar(e2Var);
            if (getResources().getConfiguration().keyboard != 1) {
                this.input.h(true);
            }
        }
    }

    public void addLifecycleListener(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.a(d1Var);
            }
        }
    }

    public g2 createAudio(Context context, e2 e2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, e2Var)) == null) ? new a3(context, e2Var) : (g2) invokeLL.objValue;
    }

    public k2 createFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            getFilesDir();
            return new b3(getAssets(), this, true);
        }
        return (k2) invokeV.objValue;
    }

    public p2 createInput(Application application, Context context, Object obj, e2 e2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, application, context, obj, e2Var)) == null) ? new c3(this, this, this.graphics.a, e2Var) : (p2) invokeLLLL.objValue;
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

    public void createWakeLock(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            getWindow().addFlags(128);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.logLevel < 3) {
            return;
        }
        getApplicationLogger().debug(str, str2);
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || this.logLevel < 1) {
            return;
        }
        getApplicationLogger().error(str, str2);
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.handler.post(new b(this));
        }
    }

    @Override // com.badlogic.gdx.Application
    public y0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.listener : (y0) invokeV.objValue;
    }

    public z0 getApplicationLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.applicationLogger : (z0) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getWindow() : (Window) invokeV.objValue;
    }

    public a1 getAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.audio : (a1) invokeV.objValue;
    }

    public c7 getClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.clipboard : (c7) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public y6<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.executedRunnables : (y6) invokeV.objValue;
    }

    public Files getFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.files : (Files) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.graphics : (Graphics) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.handler : (Handler) invokeV.objValue;
    }

    public long getJavaHeap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() : invokeV.longValue;
    }

    @Override // com.repackage.d2
    public e8<d1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.lifecycleListeners : (e8) invokeV.objValue;
    }

    public int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.logLevel : invokeV.intValue;
    }

    public long getNativeHeap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Debug.getNativeHeapAllocatedSize() : invokeV.longValue;
    }

    public Net getNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.net : (Net) invokeV.objValue;
    }

    public e1 getPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? new u2(getSharedPreferences(str, 0)) : (e1) invokeL.objValue;
    }

    @Override // com.repackage.d2
    public y6<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.runnables : (y6) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? Application.ApplicationType.Android : (Application.ApplicationType) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public void hideStatusBar(e2 e2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, e2Var) == null) && e2Var.o) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(0);
            decorView.setSystemUiVisibility(1);
        }
    }

    public void initialize(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, y0Var) == null) {
            initialize(y0Var, new e2());
        }
    }

    public View initializeForView(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, y0Var)) == null) ? initializeForView(y0Var, new e2()) : (View) invokeL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) || this.logLevel < 2) {
            return;
        }
        getApplicationLogger().log(str, str2);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.input.h(configuration.hardKeyboardHidden == 1);
        }
    }

    @Override // android.service.dreams.DreamService, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            b1.a = this;
            getInput();
            b1.c = getAudio();
            b1.d = getFiles();
            b1.b = getGraphics();
            getNet();
            this.input.a0();
            n2 n2Var = this.graphics;
            if (n2Var != null) {
                n2Var.q();
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
            this.input.x();
            this.graphics.h();
            this.graphics.j();
            this.graphics.u(d);
            this.graphics.p();
            super.onDreamingStopped();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, runnable) == null) {
            synchronized (this.runnables) {
                this.runnables.a(runnable);
                b1.b.c();
            }
        }
    }

    public void removeLifecycleListener(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, d1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.j(d1Var, true);
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

    public void setApplicationLogger(z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, z0Var) == null) {
            this.applicationLogger = z0Var;
        }
    }

    public void setLogLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.logLevel = i;
        }
    }

    @Override // com.repackage.d2
    public void useImmersiveMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            throw new UnsupportedOperationException();
        }
    }

    public void debug(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) || this.logLevel < 3) {
            return;
        }
        getApplicationLogger().a(str, str2, th);
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, str, str2, th) == null) || this.logLevel < 1) {
            return;
        }
        getApplicationLogger().error(str, str2, th);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d2
    public p2 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.input : (p2) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, th) == null) || this.logLevel < 2) {
            return;
        }
        getApplicationLogger().log(str, str2, th);
    }

    public void initialize(y0 y0Var, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, y0Var, e2Var) == null) {
            init(y0Var, e2Var, false);
        }
    }

    public View initializeForView(y0 y0Var, e2 e2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, y0Var, e2Var)) == null) {
            init(y0Var, e2Var, true);
            return this.graphics.m();
        }
        return (View) invokeLL.objValue;
    }
}
