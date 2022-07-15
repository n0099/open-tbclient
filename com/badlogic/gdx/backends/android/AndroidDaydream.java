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
import com.repackage.a7;
import com.repackage.b1;
import com.repackage.c1;
import com.repackage.c3;
import com.repackage.d1;
import com.repackage.d3;
import com.repackage.e1;
import com.repackage.e3;
import com.repackage.e7;
import com.repackage.g1;
import com.repackage.g2;
import com.repackage.g3;
import com.repackage.g8;
import com.repackage.h1;
import com.repackage.h2;
import com.repackage.i2;
import com.repackage.i3;
import com.repackage.j2;
import com.repackage.j7;
import com.repackage.k2;
import com.repackage.n2;
import com.repackage.q2;
import com.repackage.s2;
import com.repackage.w2;
import com.repackage.x2;
@TargetApi(17)
/* loaded from: classes.dex */
public class AndroidDaydream extends DreamService implements g2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c1 applicationLogger;
    public j2 audio;
    public k2 clipboard;
    public final a7<Runnable> executedRunnables;
    public n2 files;
    public boolean firstResume;
    public q2 graphics;
    public Handler handler;
    public s2 input;
    public final g8<g1> lifecycleListeners;
    public b1 listener;
    public int logLevel;
    public w2 net;
    public final a7<Runnable> runnables;

    /* loaded from: classes.dex */
    public class a implements g1 {
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

        @Override // com.repackage.g1
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.audio.dispose();
                this.a.audio = null;
            }
        }

        @Override // com.repackage.g1
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.audio.pause();
            }
        }

        @Override // com.repackage.g1
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
        j7.a();
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
        this.runnables = new a7<>();
        this.executedRunnables = new a7<>();
        this.lifecycleListeners = new g8<>(g1.class);
        this.logLevel = 2;
    }

    private void init(b1 b1Var, h2 h2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, b1Var, h2Var, z) == null) {
            setApplicationLogger(new i2());
            i3 i3Var = h2Var.r;
            if (i3Var == null) {
                i3Var = new g3();
            }
            q2 q2Var = new q2(this, h2Var, i3Var);
            this.graphics = q2Var;
            this.input = createInput(this, this, q2Var.a, h2Var);
            this.audio = createAudio(this, h2Var);
            this.files = createFiles();
            this.net = new w2(this, h2Var);
            this.listener = b1Var;
            this.handler = new Handler();
            this.clipboard = new k2(this);
            addLifecycleListener(new a(this));
            e1.a = this;
            getInput();
            e1.c = getAudio();
            e1.d = getFiles();
            e1.b = getGraphics();
            getNet();
            if (!z) {
                setFullscreen(true);
                setContentView(this.graphics.m(), createLayoutParams());
            }
            createWakeLock(h2Var.n);
            hideStatusBar(h2Var);
            if (getResources().getConfiguration().keyboard != 1) {
                this.input.r(true);
            }
        }
    }

    public void addLifecycleListener(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, g1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.a(g1Var);
            }
        }
    }

    public j2 createAudio(Context context, h2 h2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, h2Var)) == null) ? new c3(context, h2Var) : (j2) invokeLL.objValue;
    }

    public n2 createFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            getFilesDir();
            return new d3(getAssets(), this, true);
        }
        return (n2) invokeV.objValue;
    }

    public s2 createInput(Application application, Context context, Object obj, h2 h2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, application, context, obj, h2Var)) == null) ? new e3(this, this, this.graphics.a, h2Var) : (s2) invokeLLLL.objValue;
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
    public b1 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.listener : (b1) invokeV.objValue;
    }

    public c1 getApplicationLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.applicationLogger : (c1) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getWindow() : (Window) invokeV.objValue;
    }

    public d1 getAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.audio : (d1) invokeV.objValue;
    }

    public e7 getClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.clipboard : (e7) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public a7<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.executedRunnables : (a7) invokeV.objValue;
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

    @Override // com.repackage.g2
    public g8<g1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.lifecycleListeners : (g8) invokeV.objValue;
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

    public h1 getPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? new x2(getSharedPreferences(str, 0)) : (h1) invokeL.objValue;
    }

    @Override // com.repackage.g2
    public a7<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.runnables : (a7) invokeV.objValue;
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

    public void hideStatusBar(h2 h2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, h2Var) == null) && h2Var.o) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(0);
            decorView.setSystemUiVisibility(1);
        }
    }

    public void initialize(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, b1Var) == null) {
            initialize(b1Var, new h2());
        }
    }

    public View initializeForView(b1 b1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, b1Var)) == null) ? initializeForView(b1Var, new h2()) : (View) invokeL.objValue;
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
            this.input.r(configuration.hardKeyboardHidden == 1);
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
            e1.a = this;
            getInput();
            e1.c = getAudio();
            e1.d = getFiles();
            e1.b = getGraphics();
            getNet();
            this.input.K0();
            q2 q2Var = this.graphics;
            if (q2Var != null) {
                q2Var.q();
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
            this.input.Z();
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
                e1.b.c();
            }
        }
    }

    public void removeLifecycleListener(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, g1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.j(g1Var, true);
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

    public void setApplicationLogger(c1 c1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, c1Var) == null) {
            this.applicationLogger = c1Var;
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

    public void debug(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) || this.logLevel < 3) {
            return;
        }
        getApplicationLogger().b(str, str2, th);
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
    @Override // com.repackage.g2
    public s2 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.input : (s2) invokeV.objValue;
    }

    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, th) == null) || this.logLevel < 2) {
            return;
        }
        getApplicationLogger().a(str, str2, th);
    }

    public void initialize(b1 b1Var, h2 h2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, b1Var, h2Var) == null) {
            init(b1Var, h2Var, false);
        }
    }

    public View initializeForView(b1 b1Var, h2 h2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, b1Var, h2Var)) == null) {
            init(b1Var, h2Var, true);
            return this.graphics.m();
        }
        return (View) invokeLL.objValue;
    }
}
