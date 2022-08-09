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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a7;
import com.repackage.b1;
import com.repackage.d1;
import com.repackage.e1;
import com.repackage.g1;
import com.repackage.g2;
import com.repackage.g8;
import com.repackage.j2;
import com.repackage.j7;
import com.repackage.l2;
import com.repackage.n2;
import com.repackage.q2;
import com.repackage.s2;
import com.repackage.w2;
/* loaded from: classes.dex */
public class AndroidFragmentApplication extends Fragment implements g2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q2 a;
    public s2 b;
    public j2 c;
    public n2 d;
    public w2 e;
    public b1 f;
    public boolean g;
    public final a7<Runnable> h;
    public final a7<Runnable> i;
    public final g8<g1> j;
    public final a7<l2> k;
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
        j7.a();
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
        this.h = new a7<>();
        this.i = new a7<>();
        this.j = new g8<>(g1.class);
        this.k = new a7<>();
        this.l = 2;
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || this.l < 3) {
            return;
        }
        Log.d(str, str2);
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.l < 1) {
            return;
        }
        Log.e(str, str2);
    }

    @Override // com.badlogic.gdx.Application
    public b1 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (b1) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getActivity().getWindow() : (Window) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.repackage.g2
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getActivity() : (Context) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public a7<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (a7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (Graphics) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public s2 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (s2) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public g8<g1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (g8) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public a7<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.h : (a7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? Application.ApplicationType.Android : (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.repackage.g2
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (WindowManager) getContext().getSystemService("window") : (WindowManager) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || this.l < 2) {
            return;
        }
        Log.i(str, str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048591, this, activity) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.b.r(configuration.hardKeyboardHidden == 1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetach();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean d = this.a.d();
            boolean z = q2.w;
            q2.w = true;
            this.a.u(true);
            this.a.r();
            this.b.onPause();
            if (isRemoving() || u1() || getActivity().isFinishing()) {
                this.a.h();
                this.a.j();
            }
            q2.w = z;
            this.a.u(d);
            this.a.p();
            super.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            e1.a = this;
            getInput();
            e1.c = r1();
            e1.d = s1();
            e1.b = getGraphics();
            t1();
            this.b.onResume();
            q2 q2Var = this.a;
            if (q2Var != null) {
                q2Var.q();
            }
            if (!this.g) {
                this.a.t();
            } else {
                this.g = false;
            }
            super.onResume();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, runnable) == null) {
            synchronized (this.h) {
                this.h.a(runnable);
                e1.b.c();
            }
        }
    }

    public d1 r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.c : (d1) invokeV.objValue;
    }

    public Files s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.d : (Files) invokeV.objValue;
    }

    public Net t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.e : (Net) invokeV.objValue;
    }

    public final boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, th) == null) || this.l < 1) {
            return;
        }
        Log.e(str, str2, th);
    }
}
