package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import c.b.b.c;
import c.b.b.e;
import c.b.b.l.a.d;
import c.b.b.l.a.f;
import c.b.b.l.a.h;
import c.b.b.l.a.k;
import c.b.b.l.a.m;
import c.b.b.l.a.q;
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
/* loaded from: classes3.dex */
public class AndroidFragmentApplication extends Fragment implements c.b.b.l.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k a;

    /* renamed from: b  reason: collision with root package name */
    public m f23712b;

    /* renamed from: c  reason: collision with root package name */
    public d f23713c;

    /* renamed from: d  reason: collision with root package name */
    public h f23714d;

    /* renamed from: e  reason: collision with root package name */
    public q f23715e;

    /* renamed from: f  reason: collision with root package name */
    public c f23716f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f23717g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23718h;
    public final c.b.b.q.a<Runnable> i;
    public final c.b.b.q.a<Runnable> j;
    public final g0<c.b.b.h> k;
    public final c.b.b.q.a<f> l;
    public int m;

    /* loaded from: classes3.dex */
    public interface a {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23718h = true;
        this.i = new c.b.b.q.a<>();
        this.j = new c.b.b.q.a<>();
        this.k = new g0<>(c.b.b.h.class);
        this.l = new c.b.b.q.a<>();
        this.m = 2;
    }

    public e C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23713c : (e) invokeV.objValue;
    }

    public Files D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23714d : (Files) invokeV.objValue;
    }

    public Net E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23715e : (Net) invokeV.objValue;
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public final boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (Fragment parentFragment = getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                if (parentFragment.isRemoving()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) || this.m < 3) {
            return;
        }
        Log.d(str, str2);
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.m < 1) {
            return;
        }
        Log.e(str, str2);
    }

    @Override // com.badlogic.gdx.Application
    public c getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23716f : (c) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? getActivity().getWindow() : (Window) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment, c.b.b.l.a.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? getActivity() : (Context) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : (c.b.b.q.a) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a : (Graphics) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f23717g : (Handler) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public m getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f23712b : (m) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public g0<c.b.b.h> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : (g0) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.i : (c.b.b.q.a) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? Application.ApplicationType.Android : (Application.ApplicationType) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (WindowManager) getContext().getSystemService("window") : (WindowManager) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || this.m < 2) {
            return;
        }
        Log.i(str, str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048597, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            synchronized (this.l) {
                for (int i3 = 0; i3 < this.l.f22717b; i3++) {
                    this.l.get(i3).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            if (activity instanceof a) {
                a aVar = (a) activity;
            } else if (getParentFragment() instanceof a) {
                a aVar2 = (a) getParentFragment();
            } else if (getTargetFragment() instanceof a) {
                a aVar3 = (a) getTargetFragment();
            } else {
                throw new RuntimeException("Missing AndroidFragmentApplication.Callbacks. Please implement AndroidFragmentApplication.Callbacks on the parent activity, fragment or target fragment.");
            }
            super.onAttach(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.f23712b.i(configuration.hardKeyboardHidden == 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDetach();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            boolean d2 = this.a.d();
            boolean z = k.w;
            k.w = true;
            this.a.u(true);
            this.a.r();
            this.f23712b.onPause();
            if (isRemoving() || G0() || getActivity().isFinishing()) {
                this.a.h();
                this.a.j();
            }
            k.w = z;
            this.a.u(d2);
            this.a.p();
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.b.b.f.a = this;
            getInput();
            c.b.b.f.f22332c = C0();
            c.b.b.f.f22333d = D0();
            c.b.b.f.f22331b = getGraphics();
            E0();
            this.f23712b.onResume();
            k kVar = this.a;
            if (kVar != null) {
                kVar.q();
            }
            if (!this.f23718h) {
                this.a.t();
            } else {
                this.f23718h = false;
            }
            super.onResume();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, runnable) == null) {
            synchronized (this.i) {
                this.i.a(runnable);
                c.b.b.f.f22331b.c();
            }
        }
    }

    @Override // c.b.b.l.a.a
    @TargetApi(19)
    public void useImmersiveMode(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && z && F0() >= 19) {
            this.a.m().setSystemUiVisibility(5894);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) || this.m < 1) {
            return;
        }
        Log.e(str, str2, th);
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048596, this, str, str2, th) == null) || this.m < 2) {
            return;
        }
        Log.i(str, str2, th);
    }
}
