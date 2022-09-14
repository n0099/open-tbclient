package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Net;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b7;
import com.baidu.tieba.c1;
import com.baidu.tieba.d1;
import com.baidu.tieba.e1;
import com.baidu.tieba.f1;
import com.baidu.tieba.h1;
import com.baidu.tieba.h2;
import com.baidu.tieba.h8;
import com.baidu.tieba.k2;
import com.baidu.tieba.k7;
import com.baidu.tieba.m2;
import com.baidu.tieba.o2;
import com.baidu.tieba.r2;
import com.baidu.tieba.t2;
import com.baidu.tieba.x2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AndroidApplication extends Activity implements h2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r2 a;
    public t2 b;
    public k2 c;
    public o2 d;
    public x2 e;
    public c1 f;
    public boolean g;
    public final b7<Runnable> h;
    public final b7<Runnable> i;
    public final h8<h1> j;
    public final b7<m2> k;
    public int l;
    public d1 m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;

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
        k7.a();
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
        this.g = true;
        this.h = new b7<>();
        this.i = new b7<>();
        this.j = new h8<>(h1.class);
        this.k = new b7<>();
        this.l = 2;
        this.n = false;
        this.o = false;
        this.p = -1;
        this.q = false;
    }

    public d1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (d1) invokeV.objValue;
    }

    public e1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (e1) invokeV.objValue;
    }

    public Files c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (Files) invokeV.objValue;
    }

    public Net d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (Net) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || this.l < 3) {
            return;
        }
        a().debug(str, str2);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.l < 1) {
            return;
        }
        a().error(str, str2);
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z) {
            getWindow().getDecorView().setSystemUiVisibility(1);
        }
    }

    @TargetApi(19)
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && z && e() >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    @Override // com.badlogic.gdx.Application
    public c1 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : (c1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getWindow() : (Window) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this : (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public b7<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : (b7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a : (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public t2 getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b : (t2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public h8<h1> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : (h8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h2
    public b7<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.h : (b7) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? Application.ApplicationType.Android : (Application.ApplicationType) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || this.l < 2) {
            return;
        }
        a().log(str, str2);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048596, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            synchronized (this.k) {
                for (int i3 = 0; i3 < this.k.b; i3++) {
                    this.k.get(i3).onActivityResult(i, i2, intent);
                }
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            this.b.r(configuration.hardKeyboardHidden == 1);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean d = this.a.d();
            boolean z = r2.w;
            r2.w = true;
            this.a.u(true);
            this.a.r();
            this.b.onPause();
            if (isFinishing()) {
                this.a.h();
                this.a.j();
            }
            r2.w = z;
            this.a.u(d);
            this.a.p();
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            f1.a = this;
            getInput();
            f1.c = b();
            f1.d = c();
            f1.b = getGraphics();
            d();
            this.b.onResume();
            r2 r2Var = this.a;
            if (r2Var != null) {
                r2Var.q();
            }
            if (!this.g) {
                this.a.t();
            } else {
                this.g = false;
            }
            this.q = true;
            int i = this.p;
            if (i == 1 || i == -1) {
                this.c.resume();
                this.q = false;
            }
            super.onResume();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.onWindowFocusChanged(z);
            g(this.n);
            f(this.o);
            if (z) {
                this.p = 1;
                if (this.q) {
                    this.c.resume();
                    this.q = false;
                    return;
                }
                return;
            }
            this.p = 0;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, runnable) == null) {
            synchronized (this.h) {
                this.h.a(runnable);
                f1.b.c();
            }
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) || this.l < 1) {
            return;
        }
        a().error(str, str2, th);
    }
}
