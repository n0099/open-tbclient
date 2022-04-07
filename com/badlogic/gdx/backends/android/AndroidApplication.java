package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
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
import com.repackage.i2;
import com.repackage.k2;
import com.repackage.n2;
import com.repackage.p2;
import com.repackage.t2;
import com.repackage.u2;
import com.repackage.x2;
import com.repackage.y0;
import com.repackage.y6;
import com.repackage.z0;
/* loaded from: classes.dex */
public class AndroidApplication extends Activity implements d2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y6<i2> androidEventListeners;
    public z0 applicationLogger;
    public g2 audio;
    public h2 clipboard;
    public final y6<Runnable> executedRunnables;
    public k2 files;
    public boolean firstResume;
    public n2 graphics;
    public Handler handler;
    public boolean hideStatusBar;
    public p2 input;
    public boolean isWaitingForAudio;
    public final e8<d1> lifecycleListeners;
    public y0 listener;
    public int logLevel;
    public t2 net;
    public final y6<Runnable> runnables;
    public boolean useImmersiveMode;
    public int wasFocusChanged;

    /* loaded from: classes.dex */
    public class a implements d1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AndroidApplication a;

        public a(AndroidApplication androidApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = androidApplication;
        }

        @Override // com.repackage.d1
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.audio.dispose();
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
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AndroidApplication a;

        public b(AndroidApplication androidApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = androidApplication;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2099865306, "Lcom/badlogic/gdx/backends/android/AndroidApplication;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2099865306, "Lcom/badlogic/gdx/backends/android/AndroidApplication;");
                return;
            }
        }
        h7.a();
    }

    public AndroidApplication() {
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
        this.androidEventListeners = new y6<>();
        this.logLevel = 2;
        this.useImmersiveMode = false;
        this.hideStatusBar = false;
        this.wasFocusChanged = -1;
        this.isWaitingForAudio = false;
    }

    private void init(y0 y0Var, e2 e2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, y0Var, e2Var, z) == null) {
            if (getVersion() >= 14) {
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
                this.useImmersiveMode = e2Var.t;
                this.hideStatusBar = e2Var.o;
                this.clipboard = new h2(this);
                addLifecycleListener(new a(this));
                b1.a = this;
                getInput();
                b1.c = getAudio();
                b1.d = getFiles();
                b1.b = getGraphics();
                getNet();
                if (!z) {
                    try {
                        requestWindowFeature(1);
                    } catch (Exception e) {
                        log("AndroidApplication", "Content already displayed, cannot request FEATURE_NO_TITLE", e);
                    }
                    getWindow().setFlags(1024, 1024);
                    getWindow().clearFlags(2048);
                    setContentView(this.graphics.m(), createLayoutParams());
                }
                createWakeLock(e2Var.n);
                hideStatusBar(this.hideStatusBar);
                useImmersiveMode(this.useImmersiveMode);
                if (this.useImmersiveMode && getVersion() >= 19) {
                    new x2().a(this);
                }
                if (getResources().getConfiguration().keyboard != 1) {
                    this.input.h(true);
                    return;
                }
                return;
            }
            throw new GdxRuntimeException("LibGDX requires Android API Level 14 or later.");
        }
    }

    public void addAndroidEventListener(i2 i2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i2Var) == null) {
            synchronized (this.androidEventListeners) {
                this.androidEventListeners.a(i2Var);
            }
        }
    }

    public void addLifecycleListener(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.a(d1Var);
            }
        }
    }

    public g2 createAudio(Context context, e2 e2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, e2Var)) == null) ? new a3(context, e2Var) : (g2) invokeLL.objValue;
    }

    public k2 createFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            getFilesDir();
            return new b3(getAssets(), this, true);
        }
        return (k2) invokeV.objValue;
    }

    public p2 createInput(Application application, Context context, Object obj, e2 e2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, application, context, obj, e2Var)) == null) ? new c3(this, this, this.graphics.a, e2Var) : (p2) invokeLLLL.objValue;
    }

    public FrameLayout.LayoutParams createLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (FrameLayout.LayoutParams) invokeV.objValue;
    }

    public void createWakeLock(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && z) {
            getWindow().addFlags(128);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) || this.logLevel < 3) {
            return;
        }
        getApplicationLogger().debug(str, str2);
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) || this.logLevel < 1) {
            return;
        }
        getApplicationLogger().error(str, str2);
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.handler.post(new b(this));
        }
    }

    @Override // com.badlogic.gdx.Application
    public y0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.listener : (y0) invokeV.objValue;
    }

    public z0 getApplicationLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.applicationLogger : (z0) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getWindow() : (Window) invokeV.objValue;
    }

    public a1 getAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.audio : (a1) invokeV.objValue;
    }

    public c7 getClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.clipboard : (c7) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public y6<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.executedRunnables : (y6) invokeV.objValue;
    }

    public Files getFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.files : (Files) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.graphics : (Graphics) invokeV.objValue;
    }

    @Override // com.repackage.d2
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.handler : (Handler) invokeV.objValue;
    }

    public long getJavaHeap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() : invokeV.longValue;
    }

    @Override // com.repackage.d2
    public e8<d1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.lifecycleListeners : (e8) invokeV.objValue;
    }

    public int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.logLevel : invokeV.intValue;
    }

    public long getNativeHeap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? Debug.getNativeHeapAllocatedSize() : invokeV.longValue;
    }

    public Net getNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.net : (Net) invokeV.objValue;
    }

    public e1 getPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? new u2(getSharedPreferences(str, 0)) : (e1) invokeL.objValue;
    }

    @Override // com.repackage.d2
    public y6<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.runnables : (y6) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? Application.ApplicationType.Android : (Application.ApplicationType) invokeV.objValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public void hideStatusBar(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && z) {
            getWindow().getDecorView().setSystemUiVisibility(1);
        }
    }

    public void initialize(y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, y0Var) == null) {
            initialize(y0Var, new e2());
        }
    }

    public View initializeForView(y0 y0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, y0Var)) == null) ? initializeForView(y0Var, new e2()) : (View) invokeL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, str, str2) == null) || this.logLevel < 2) {
            return;
        }
        getApplicationLogger().log(str, str2);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048616, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            synchronized (this.androidEventListeners) {
                for (int i3 = 0; i3 < this.androidEventListeners.b; i3++) {
                    this.androidEventListeners.get(i3).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.input.h(configuration.hardKeyboardHidden == 1);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            super.onCreate(bundle);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            boolean d = this.graphics.d();
            boolean z = n2.w;
            n2.w = true;
            this.graphics.u(true);
            this.graphics.r();
            this.input.onPause();
            if (isFinishing()) {
                this.graphics.h();
                this.graphics.j();
            }
            n2.w = z;
            this.graphics.u(d);
            this.graphics.p();
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            b1.a = this;
            getInput();
            b1.c = getAudio();
            b1.d = getFiles();
            b1.b = getGraphics();
            getNet();
            this.input.onResume();
            n2 n2Var = this.graphics;
            if (n2Var != null) {
                n2Var.q();
            }
            if (!this.firstResume) {
                this.graphics.t();
            } else {
                this.firstResume = false;
            }
            this.isWaitingForAudio = true;
            int i = this.wasFocusChanged;
            if (i == 1 || i == -1) {
                this.audio.resume();
                this.isWaitingForAudio = false;
            }
            super.onResume();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            super.onWindowFocusChanged(z);
            useImmersiveMode(this.useImmersiveMode);
            hideStatusBar(this.hideStatusBar);
            if (z) {
                this.wasFocusChanged = 1;
                if (this.isWaitingForAudio) {
                    this.audio.resume();
                    this.isWaitingForAudio = false;
                    return;
                }
                return;
            }
            this.wasFocusChanged = 0;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, runnable) == null) {
            synchronized (this.runnables) {
                this.runnables.a(runnable);
                b1.b.c();
            }
        }
    }

    public void removeAndroidEventListener(i2 i2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, i2Var) == null) {
            synchronized (this.androidEventListeners) {
                this.androidEventListeners.j(i2Var, true);
            }
        }
    }

    public void removeLifecycleListener(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, d1Var) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.j(d1Var, true);
            }
        }
    }

    public void setApplicationLogger(z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, z0Var) == null) {
            this.applicationLogger = z0Var;
        }
    }

    public void setLogLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            this.logLevel = i;
        }
    }

    @Override // com.repackage.d2
    @TargetApi(19)
    public void useImmersiveMode(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && z && getVersion() >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void debug(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, th) == null) || this.logLevel < 3) {
            return;
        }
        getApplicationLogger().a(str, str2, th);
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, th) == null) || this.logLevel < 1) {
            return;
        }
        getApplicationLogger().error(str, str2, th);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d2
    public p2 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.input : (p2) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048615, this, str, str2, th) == null) || this.logLevel < 2) {
            return;
        }
        getApplicationLogger().log(str, str2, th);
    }

    public void initialize(y0 y0Var, e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, y0Var, e2Var) == null) {
            init(y0Var, e2Var, false);
        }
    }

    public View initializeForView(y0 y0Var, e2 e2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, y0Var, e2Var)) == null) {
            init(y0Var, e2Var, true);
            return this.graphics.m();
        }
        return (View) invokeLL.objValue;
    }
}
