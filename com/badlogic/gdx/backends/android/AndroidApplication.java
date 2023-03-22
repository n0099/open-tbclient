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
import com.baidu.tieba.a2;
import com.baidu.tieba.c2;
import com.baidu.tieba.g2;
import com.baidu.tieba.k6;
import com.baidu.tieba.l0;
import com.baidu.tieba.m0;
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
public class AndroidApplication extends Activity implements q1 {
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
    public m0 m;
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;

    @Override // com.baidu.tieba.q1
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this : (Context) invokeV.objValue;
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
        t6.a();
    }

    public m0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return (m0) invokeV.objValue;
    }

    public n0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (n0) invokeV.objValue;
    }

    public Files c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (Files) invokeV.objValue;
    }

    public Net d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (Net) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Build.VERSION.SDK_INT;
        }
        return invokeV.intValue;
    }

    @Override // com.badlogic.gdx.Application
    public l0 getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (l0) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return getWindow();
        }
        return (Window) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public k6<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return (k6) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.a;
        }
        return (Graphics) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    /* renamed from: getInput */
    public c2 mo6getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b;
        }
        return (c2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public q7<q0> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return (q7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q1
    public k6<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.h;
        }
        return (k6) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return Application.ApplicationType.Android;
        }
        return (Application.ApplicationType) invokeV.objValue;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
        }
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
        this.h = new k6<>();
        this.i = new k6<>();
        this.j = new q7<>(q0.class);
        this.k = new k6<>();
        this.l = 2;
        this.n = false;
        this.o = false;
        this.p = -1;
        this.q = false;
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean d = this.a.d();
            boolean z = a2.w;
            a2.w = true;
            this.a.u(true);
            this.a.r();
            this.b.onPause();
            if (isFinishing()) {
                this.a.h();
                this.a.j();
            }
            a2.w = z;
            this.a.u(d);
            this.a.p();
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            o0.a = this;
            mo6getInput();
            o0.c = b();
            o0.d = c();
            o0.b = getGraphics();
            d();
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
            this.q = true;
            int i = this.p;
            if (i == 1 || i == -1) {
                this.c.resume();
                this.q = false;
            }
            super.onResume();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.l >= 3) {
            a().debug(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && this.l >= 1) {
            a().error(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) && this.l >= 2) {
            a().log(str, str2);
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) && this.l >= 1) {
            a().error(str, str2, th);
        }
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

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || !z) {
            return;
        }
        getWindow().getDecorView().setSystemUiVisibility(1);
    }

    @TargetApi(19)
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && z && e() >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            boolean z = true;
            if (configuration.hardKeyboardHidden != 1) {
                z = false;
            }
            this.b.r(z);
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
                o0.b.c();
            }
        }
    }
}
