package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import c.b.b.d;
import c.b.b.i;
import c.b.b.l.a.e;
import c.b.b.l.a.f;
import c.b.b.l.a.h;
import c.b.b.l.a.k;
import c.b.b.l.a.m;
import c.b.b.l.a.q;
import c.b.b.l.a.r;
import c.b.b.l.a.u;
import c.b.b.l.a.x;
import c.b.b.l.a.y;
import c.b.b.l.a.z;
import c.b.b.q.g0;
import c.b.b.q.j;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AndroidFragmentApplication extends Fragment implements c.b.b.l.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d applicationLogger;
    public c.b.b.l.a.d audio;
    public c callbacks;
    public e clipboard;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<f> f31910e;
    public final c.b.b.q.a<Runnable> executedRunnables;
    public h files;
    public boolean firstResume;
    public k graphics;
    public Handler handler;
    public m input;
    public final g0<c.b.b.h> lifecycleListeners;
    public c.b.b.c listener;
    public int logLevel;
    public q net;
    public final c.b.b.q.a<Runnable> runnables;

    /* loaded from: classes9.dex */
    public class a implements c.b.b.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AndroidFragmentApplication a;

        public a(AndroidFragmentApplication androidFragmentApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidFragmentApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = androidFragmentApplication;
        }

        @Override // c.b.b.h
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.audio.dispose();
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
        public final /* synthetic */ AndroidFragmentApplication f31911e;

        public b(AndroidFragmentApplication androidFragmentApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {androidFragmentApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31911e = androidFragmentApplication;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31911e.callbacks.exit();
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void exit();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-304527798, "Lcom/badlogic/gdx/backends/android/AndroidFragmentApplication;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-304527798, "Lcom/badlogic/gdx/backends/android/AndroidFragmentApplication;");
                return;
            }
        }
        j.a();
    }

    public AndroidFragmentApplication() {
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
        this.f31910e = new c.b.b.q.a<>();
        this.logLevel = 2;
    }

    public void addAndroidEventListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            synchronized (this.f31910e) {
                this.f31910e.a(fVar);
            }
        }
    }

    public void addLifecycleListener(c.b.b.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.a(hVar);
            }
        }
    }

    public c.b.b.l.a.d createAudio(Context context, c.b.b.l.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar)) == null) ? new x(context, bVar) : (c.b.b.l.a.d) invokeLL.objValue;
    }

    public h createFiles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new y(getResources().getAssets(), getActivity(), true) : (h) invokeV.objValue;
    }

    public m createInput(Application application, Context context, Object obj, c.b.b.l.a.b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, application, context, obj, bVar)) == null) ? new z(this, getActivity(), this.graphics.f27796e, bVar) : (m) invokeLLLL.objValue;
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
            getActivity().getWindow().addFlags(128);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            int i2 = this.logLevel;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            int i2 = this.logLevel;
        }
    }

    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.handler.post(new b(this));
        }
    }

    @Override // com.badlogic.gdx.Application
    public c.b.b.c getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.listener : (c.b.b.c) invokeV.objValue;
    }

    public d getApplicationLogger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.applicationLogger : (d) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getActivity().getWindow() : (Window) invokeV.objValue;
    }

    public c.b.b.e getAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.audio : (c.b.b.e) invokeV.objValue;
    }

    public c.b.b.q.e getClipboard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.clipboard : (c.b.b.q.e) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment, c.b.b.l.a.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? getActivity() : (Context) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.executedRunnables : (c.b.b.q.a) invokeV.objValue;
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

    @Override // c.b.b.l.a.a
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

    @Override // c.b.b.l.a.a
    public g0<c.b.b.h> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.lifecycleListeners : (g0) invokeV.objValue;
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

    public i getPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? new r(getActivity().getSharedPreferences(str, 0)) : (i) invokeL.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.runnables : (c.b.b.q.a) invokeV.objValue;
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

    @Override // c.b.b.l.a.a
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? (WindowManager) getContext().getSystemService("window") : (WindowManager) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            for (Fragment parentFragment = getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                if (parentFragment.isRemoving()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View initializeForView(c.b.b.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, cVar)) == null) ? initializeForView(cVar, new c.b.b.l.a.b()) : (View) invokeL.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            int i2 = this.logLevel;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048615, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            synchronized (this.f31910e) {
                for (int i4 = 0; i4 < this.f31910e.f28143f; i4++) {
                    this.f31910e.get(i4).onActivityResult(i2, i3, intent);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, activity) == null) {
            if (activity instanceof c) {
                this.callbacks = (c) activity;
            } else if (getParentFragment() instanceof c) {
                this.callbacks = (c) getParentFragment();
            } else if (getTargetFragment() instanceof c) {
                this.callbacks = (c) getTargetFragment();
            } else {
                throw new RuntimeException("Missing AndroidFragmentApplication.Callbacks. Please implement AndroidFragmentApplication.Callbacks on the parent activity, fragment or target fragment.");
            }
            super.onAttach(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.input.c(configuration.hardKeyboardHidden == 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onDetach();
            this.callbacks = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            boolean d2 = this.graphics.d();
            boolean z = k.A;
            k.A = true;
            this.graphics.u(true);
            this.graphics.r();
            this.input.onPause();
            if (isRemoving() || i() || getActivity().isFinishing()) {
                this.graphics.h();
                this.graphics.j();
            }
            k.A = z;
            this.graphics.u(d2);
            this.graphics.p();
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            c.b.b.f.a = this;
            getInput();
            c.b.b.f.f27696c = getAudio();
            c.b.b.f.f27697d = getFiles();
            c.b.b.f.f27695b = getGraphics();
            getNet();
            this.input.onResume();
            k kVar = this.graphics;
            if (kVar != null) {
                kVar.q();
            }
            if (!this.firstResume) {
                this.graphics.t();
            } else {
                this.firstResume = false;
            }
            super.onResume();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, runnable) == null) {
            synchronized (this.runnables) {
                this.runnables.a(runnable);
                c.b.b.f.f27695b.c();
            }
        }
    }

    public void removeAndroidEventListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, fVar) == null) {
            synchronized (this.f31910e) {
                this.f31910e.i(fVar, true);
            }
        }
    }

    public void removeLifecycleListener(c.b.b.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, hVar) == null) {
            synchronized (this.lifecycleListeners) {
                this.lifecycleListeners.i(hVar, true);
            }
        }
    }

    public void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, runnable) == null) {
            getActivity().runOnUiThread(runnable);
        }
    }

    public void setApplicationLogger(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, dVar) == null) {
            this.applicationLogger = dVar;
        }
    }

    public void setLogLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.logLevel = i2;
        }
    }

    @Override // c.b.b.l.a.a
    @TargetApi(19)
    public void useImmersiveMode(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z) == null) && z && getVersion() >= 19) {
            this.graphics.m().setSystemUiVisibility(5894);
        }
    }

    public void debug(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, th) == null) {
            int i2 = this.logLevel;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, th) == null) {
            int i2 = this.logLevel;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.l.a.a
    public m getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.input : (m) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, th) == null) {
            int i2 = this.logLevel;
        }
    }

    public View initializeForView(c.b.b.c cVar, c.b.b.l.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, cVar, bVar)) == null) {
            if (getVersion() >= 14) {
                setApplicationLogger(new c.b.b.l.a.c());
                c.b.b.l.a.b0.c cVar2 = bVar.r;
                if (cVar2 == null) {
                    cVar2 = new c.b.b.l.a.b0.a();
                }
                this.graphics = new k(this, bVar, cVar2);
                this.input = createInput(this, getActivity(), this.graphics.f27796e, bVar);
                this.audio = createAudio(getActivity(), bVar);
                this.files = createFiles();
                this.net = new q(this, bVar);
                this.listener = cVar;
                this.handler = new Handler();
                this.clipboard = new e(getActivity());
                addLifecycleListener(new a(this));
                c.b.b.f.a = this;
                getInput();
                c.b.b.f.f27696c = getAudio();
                c.b.b.f.f27697d = getFiles();
                c.b.b.f.f27695b = getGraphics();
                getNet();
                createWakeLock(bVar.n);
                useImmersiveMode(bVar.t);
                if (bVar.t && getVersion() >= 19) {
                    new u().a(this);
                }
                if (getResources().getConfiguration().keyboard != 1) {
                    this.input.c(true);
                }
                return this.graphics.m();
            }
            throw new GdxRuntimeException("LibGDX requires Android API Level 14 or later.");
        }
        return (View) invokeLL.objValue;
    }
}
