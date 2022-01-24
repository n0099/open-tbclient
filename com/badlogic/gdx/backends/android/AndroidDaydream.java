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
import c.b.b.c;
import c.b.b.d;
import c.b.b.f;
import c.b.b.i;
import c.b.b.l.a.e;
import c.b.b.l.a.h;
import c.b.b.l.a.k;
import c.b.b.l.a.m;
import c.b.b.l.a.q;
import c.b.b.l.a.r;
import c.b.b.l.a.x;
import c.b.b.l.a.y;
import c.b.b.l.a.z;
import c.b.b.q.g0;
import c.b.b.q.j;
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
@TargetApi(17)
/* loaded from: classes9.dex */
public class AndroidDaydream extends DreamService implements c.b.b.l.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d applicationLogger;
    public c.b.b.l.a.d audio;
    public e clipboard;
    public final c.b.b.q.a<Runnable> executedRunnables;
    public h files;
    public boolean firstResume;
    public k graphics;
    public Handler handler;
    public m input;
    public final g0<c.b.b.h> lifecycleListeners;
    public c listener;
    public int logLevel;
    public q net;
    public final c.b.b.q.a<Runnable> runnables;

    /* loaded from: classes9.dex */
    public class a implements c.b.b.h {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = androidDaydream;
        }

        @Override // c.b.b.h
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.audio.dispose();
                this.a.audio = null;
            }
        }

        @Override // c.b.b.h
        public void pause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.audio.pause();
            }
        }

        @Override // c.b.b.h
        public void resume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.audio.resume();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AndroidDaydream f31072e;

        public b(AndroidDaydream androidDaydream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidDaydream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31072e = androidDaydream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31072e.finish();
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
        j.a();
    }

    public AndroidDaydream() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.firstResume = true;
        this.runnables = new c.b.b.q.a<>();
        this.executedRunnables = new c.b.b.q.a<>();
        this.lifecycleListeners = new g0<>(c.b.b.h.class);
        this.logLevel = 2;
    }

    private void init(c cVar, c.b.b.l.a.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, cVar, bVar, z) == null) {
            setApplicationLogger(new c.b.b.l.a.c());
            c.b.b.l.a.b0.c cVar2 = bVar.r;
            if (cVar2 == null) {
                cVar2 = new c.b.b.l.a.b0.a();
            }
            k kVar = new k(this, bVar, cVar2);
            this.graphics = kVar;
            this.input = createInput(this, this, kVar.f27062e, bVar);
            this.audio = createAudio(this, bVar);
            this.files = createFiles();
            this.net = new q(this, bVar);
            this.listener = cVar;
            this.handler = new Handler();
            this.clipboard = new e(this);
            addLifecycleListener(new a(this));
            f.a = this;
            getInput();
            f.f26965c = getAudio();
            f.f26966d = getFiles();
            f.f26964b = getGraphics();
            getNet();
            if (!z) {
                setFullscreen(true);
                setContentView(this.graphics.m(), createLayoutParams());
            }
            createWakeLock(bVar.n);
            hideStatusBar(bVar);
            if (getResources().getConfiguration().keyboard != 1) {
                this.input.c(true);
            }
        }
    }

    public void addLifecycleListener(c.b.b.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.a(hVar);
            }
        }
    }

    public c.b.b.l.a.d createAudio(Context context, c.b.b.l.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar)) == null) ? new x(context, bVar) : (c.b.b.l.a.d) invokeLL.objValue;
    }

    public h createFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            getFilesDir();
            return new y(getAssets(), this, true);
        }
        return (h) invokeV.objValue;
    }

    public m createInput(Application application, Context context, Object obj, c.b.b.l.a.b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, application, context, obj, bVar)) == null) ? new z(this, this, this.graphics.f27062e, bVar) : (m) invokeLLLL.objValue;
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
    public c getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.listener : (c) invokeV.objValue;
    }

    public d getApplicationLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.applicationLogger : (d) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? getWindow() : (Window) invokeV.objValue;
    }

    public c.b.b.e getAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.audio : (c.b.b.e) invokeV.objValue;
    }

    public c.b.b.q.e getClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.clipboard : (c.b.b.q.e) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.executedRunnables : (c.b.b.q.a) invokeV.objValue;
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

    @Override // c.b.b.l.a.a
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

    @Override // c.b.b.l.a.a
    public g0<c.b.b.h> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.lifecycleListeners : (g0) invokeV.objValue;
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

    public i getPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? new r(getSharedPreferences(str, 0)) : (i) invokeL.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.runnables : (c.b.b.q.a) invokeV.objValue;
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

    public void hideStatusBar(c.b.b.l.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) && bVar.o) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(0);
            decorView.setSystemUiVisibility(1);
        }
    }

    public void initialize(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            initialize(cVar, new c.b.b.l.a.b());
        }
    }

    public View initializeForView(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, cVar)) == null) ? initializeForView(cVar, new c.b.b.l.a.b()) : (View) invokeL.objValue;
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
            this.input.c(configuration.hardKeyboardHidden == 1);
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
            f.a = this;
            getInput();
            f.f26965c = getAudio();
            f.f26966d = getFiles();
            f.f26964b = getGraphics();
            getNet();
            this.input.h();
            k kVar = this.graphics;
            if (kVar != null) {
                kVar.q();
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
            boolean d2 = this.graphics.d();
            this.graphics.u(true);
            this.graphics.r();
            this.input.g();
            this.graphics.h();
            this.graphics.j();
            this.graphics.u(d2);
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
                f.f26964b.c();
            }
        }
    }

    public void removeLifecycleListener(c.b.b.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, hVar) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.i(hVar, true);
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

    public void setApplicationLogger(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, dVar) == null) {
            this.applicationLogger = dVar;
        }
    }

    public void setLogLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.logLevel = i2;
        }
    }

    @Override // c.b.b.l.a.a
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
    @Override // c.b.b.l.a.a
    public m getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.input : (m) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, th) == null) || this.logLevel < 2) {
            return;
        }
        getApplicationLogger().log(str, str2, th);
    }

    public void initialize(c cVar, c.b.b.l.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, cVar, bVar) == null) {
            init(cVar, bVar, false);
        }
    }

    public View initializeForView(c cVar, c.b.b.l.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, cVar, bVar)) == null) {
            init(cVar, bVar, true);
            return this.graphics.m();
        }
        return (View) invokeLL.objValue;
    }
}
