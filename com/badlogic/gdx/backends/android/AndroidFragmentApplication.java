package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Net;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a2;
import com.baidu.tieba.c2;
import com.baidu.tieba.g2;
import com.baidu.tieba.k6;
import com.baidu.tieba.l0;
import com.baidu.tieba.n0;
import com.baidu.tieba.o0;
import com.baidu.tieba.q0;
import com.baidu.tieba.q1;
import com.baidu.tieba.q7;
import com.baidu.tieba.t1;
import com.baidu.tieba.t6;
import com.baidu.tieba.v1;
import com.baidu.tieba.x1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AndroidFragmentApplication extends Fragment implements q1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a2 a;
    public c2 b;
    public t1 c;
    public x1 d;
    public g2 e;
    public l0 f;
    public boolean g;
    public final k6<Runnable> h;
    public final k6<Runnable> i;
    public final q7<q0> j;
    public final k6<v1> k;
    public int l;

    /* loaded from: classes.dex */
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
        t6.a();
    }

    public n0 E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (n0) invokeV.objValue;
    }

    public Files F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (Files) invokeV.objValue;
    }

    public Net G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Net) invokeV.objValue;
    }

    public final boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
    public l0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (l0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return getActivity().getWindow();
        }
        return (Window) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.tieba.q1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return getActivity();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public k6<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return (k6) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    /* renamed from: getInput */
    public c2 mo6getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (c2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public q7<q0> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return (q7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public k6<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (k6) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return Application.ApplicationType.Android;
        }
        return (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (WindowManager) getContext().getSystemService("window");
        }
        return (WindowManager) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDetach();
        }
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
        this.g = true;
        this.h = new k6<>();
        this.i = new k6<>();
        this.j = new q7<>(q0.class);
        this.k = new k6<>();
        this.l = 2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean d = this.a.d();
            boolean z = a2.w;
            a2.w = true;
            this.a.u(true);
            this.a.r();
            this.b.onPause();
            if (isRemoving() || H1() || getActivity().isFinishing()) {
                this.a.h();
                this.a.j();
            }
            a2.w = z;
            this.a.u(d);
            this.a.p();
            super.onPause();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.l >= 3) {
            Log.d(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) && this.l >= 1) {
            Log.e(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) && this.l >= 2) {
            Log.i(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) && this.l >= 1) {
            Log.e(str, str2, th);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            synchronized (this.k) {
                for (int i3 = 0; i3 < this.k.b; i3++) {
                    this.k.get(i3).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048596, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            boolean z = true;
            if (configuration.hardKeyboardHidden != 1) {
                z = false;
            }
            this.b.r(z);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, runnable) == null) {
            synchronized (this.h) {
                this.h.a(runnable);
                o0.b.c();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            o0.a = this;
            mo6getInput();
            o0.c = E1();
            o0.d = F1();
            o0.b = getGraphics();
            G1();
            this.b.onResume();
            a2 a2Var = this.a;
            if (a2Var != null) {
                a2Var.q();
            }
            if (!this.g) {
                this.a.t();
            } else {
                this.g = false;
            }
            super.onResume();
        }
    }
}
