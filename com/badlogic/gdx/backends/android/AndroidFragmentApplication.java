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
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.a1;
import com.baidu.tieba.e1;
import com.baidu.tieba.g3;
import com.baidu.tieba.h1;
import com.baidu.tieba.j1;
import com.baidu.tieba.k1;
import com.baidu.tieba.n1;
import com.baidu.tieba.p1;
import com.baidu.tieba.r2;
import com.baidu.tieba.t1;
import com.baidu.tieba.v0;
import com.baidu.tieba.w2;
import com.baidu.tieba.x0;
import com.baidu.tieba.y0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AndroidFragmentApplication extends Fragment implements e1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n1 a;
    public p1 b;
    public h1 c;
    public k1 d;
    public t1 e;
    public v0 f;
    public boolean g;
    public final r2<Runnable> h;
    public final r2<Runnable> i;
    public final g3<a1> j;
    public final r2<j1> k;
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
        w2.a();
    }

    public x0 c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (x0) invokeV.objValue;
    }

    public Files d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (Files) invokeV.objValue;
    }

    public Net e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Net) invokeV.objValue;
    }

    public final boolean f2() {
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
    public v0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (v0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return getActivity().getWindow();
        }
        return (Window) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.tieba.e1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return getActivity();
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public r2<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (r2) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a;
        }
        return (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    /* renamed from: getInput */
    public p1 mo6getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (p1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public g3<a1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j;
        }
        return (g3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public r2<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return (r2) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return Application.ApplicationType.Android;
        }
        return (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e1
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (WindowManager) getContext().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        }
        return (WindowManager) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
        this.h = new r2<>();
        this.i = new r2<>();
        this.j = new g3<>(a1.class);
        this.k = new r2<>();
        this.l = 2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            boolean d = this.a.d();
            boolean z = n1.v;
            n1.v = true;
            this.a.t(true);
            this.a.q();
            this.b.onPause();
            if (isRemoving() || f2() || getActivity().isFinishing()) {
                this.a.g();
                this.a.i();
            }
            n1.v = z;
            this.a.t(d);
            this.a.o();
            super.onPause();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) && this.l >= 1) {
            Log.e(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) && this.l >= 2) {
            Log.i(str, str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048593, this, activity) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048594, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            boolean z = true;
            if (configuration.hardKeyboardHidden != 1) {
                z = false;
            }
            this.b.C(z);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, runnable) == null) {
            synchronized (this.h) {
                this.h.a(runnable);
                y0.b.c();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            y0.a = this;
            mo6getInput();
            c2();
            d2();
            y0.b = getGraphics();
            e2();
            this.b.onResume();
            n1 n1Var = this.a;
            if (n1Var != null) {
                n1Var.p();
            }
            if (!this.g) {
                this.a.s();
            } else {
                this.g = false;
            }
            super.onResume();
        }
    }
}
