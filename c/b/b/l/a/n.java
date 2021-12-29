package c.b.b.l.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import c.b.b.q.g0;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
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
public class n implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AndroidLiveWallpaperService f27879e;

    /* renamed from: f  reason: collision with root package name */
    public l f27880f;

    /* renamed from: g  reason: collision with root package name */
    public m f27881g;

    /* renamed from: h  reason: collision with root package name */
    public d f27882h;

    /* renamed from: i  reason: collision with root package name */
    public h f27883i;

    /* renamed from: j  reason: collision with root package name */
    public q f27884j;

    /* renamed from: k  reason: collision with root package name */
    public c.b.b.c f27885k;
    public boolean l;
    public final c.b.b.q.a<Runnable> m;
    public final c.b.b.q.a<Runnable> n;
    public final g0<c.b.b.h> o;
    public int p;
    public c.b.b.d q;
    public volatile c.b.b.n.a[] r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(281672336, "Lc/b/b/l/a/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(281672336, "Lc/b/b/l/a/n;");
                return;
            }
        }
        c.b.b.q.j.a();
    }

    public n(AndroidLiveWallpaperService androidLiveWallpaperService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {androidLiveWallpaperService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = true;
        this.m = new c.b.b.q.a<>();
        this.n = new c.b.b.q.a<>();
        this.o = new g0<>(c.b.b.h.class);
        this.p = 2;
        this.r = null;
        this.f27879e = androidLiveWallpaperService;
    }

    public d a(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, bVar)) == null) ? new x(context, bVar) : (d) invokeLL.objValue;
    }

    public h b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e().getFilesDir();
            return new y(e().getAssets(), e(), true);
        }
        return (h) invokeV.objValue;
    }

    public m c(Application application, Context context, Object obj, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, application, context, obj, bVar)) == null) ? new z(this, e(), this.f27880f.f27870e, bVar) : (m) invokeLLLL.objValue;
    }

    public c.b.b.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : (c.b.b.d) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void debug(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || this.p < 3) {
            return;
        }
        d().debug(str, str2);
    }

    public AndroidLiveWallpaperService e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27879e : (AndroidLiveWallpaperService) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || this.p < 1) {
            return;
        }
        d().error(str, str2);
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Build.VERSION.SDK_INT : invokeV.intValue;
    }

    public void g(c.b.b.c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, cVar, bVar) == null) {
            if (f() >= 14) {
                k(new c());
                c.b.b.l.a.b0.c cVar2 = bVar.r;
                if (cVar2 == null) {
                    cVar2 = new c.b.b.l.a.b0.a();
                }
                this.f27880f = new l(this, bVar, cVar2);
                this.f27881g = c(this, e(), this.f27880f.f27870e, bVar);
                this.f27882h = a(e(), bVar);
                this.f27883i = b();
                this.f27884j = new q(this, bVar);
                this.f27885k = cVar;
                new e(e());
                c.b.b.f.a = this;
                c.b.b.f.f27770c = this.f27882h;
                c.b.b.f.f27771d = this.f27883i;
                c.b.b.f.f27769b = this.f27880f;
                return;
            }
            throw new GdxRuntimeException("LibGDX requires Android API Level 14 or later.");
        }
    }

    @Override // com.badlogic.gdx.Application
    public c.b.b.c getApplicationListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f27885k : (c.b.b.c) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Window getApplicationWindow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Window) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f27879e : (Context) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getExecutedRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : (c.b.b.q.a) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Graphics getGraphics() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f27880f : (Graphics) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (Handler) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public m getInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f27881g : (m) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public g0<c.b.b.h> getLifecycleListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o : (g0) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public c.b.b.q.a<Runnable> getRunnables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.m : (c.b.b.q.a) invokeV.objValue;
    }

    @Override // com.badlogic.gdx.Application
    public Application.ApplicationType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? Application.ApplicationType.Android : (Application.ApplicationType) invokeV.objValue;
    }

    @Override // c.b.b.l.a.a
    public WindowManager getWindowManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f27879e.getWindowManager() : (WindowManager) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            l lVar = this.f27880f;
            if (lVar != null) {
                lVar.z();
            }
            d dVar = this.f27882h;
            if (dVar != null) {
                dVar.dispose();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = AndroidLiveWallpaperService.DEBUG;
            this.f27882h.pause();
            this.f27881g.onPause();
            l lVar = this.f27880f;
            if (lVar != null) {
                lVar.p();
            }
            boolean z2 = AndroidLiveWallpaperService.DEBUG;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.b.b.f.a = this;
            m mVar = this.f27881g;
            c.b.b.f.f27770c = this.f27882h;
            c.b.b.f.f27771d = this.f27883i;
            c.b.b.f.f27769b = this.f27880f;
            mVar.onResume();
            l lVar = this.f27880f;
            if (lVar != null) {
                lVar.q();
            }
            if (!this.l) {
                this.f27882h.resume();
                this.f27880f.t();
                return;
            }
            this.l = false;
        }
    }

    public void k(c.b.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, dVar) == null) {
            this.q = dVar;
        }
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) || this.p < 2) {
            return;
        }
        d().log(str, str2);
    }

    @Override // com.badlogic.gdx.Application
    public void postRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, runnable) == null) {
            synchronized (this.m) {
                this.m.a(runnable);
            }
        }
    }

    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, intent) == null) {
            this.f27879e.startActivity(intent);
        }
    }

    @Override // c.b.b.l.a.a
    public void useImmersiveMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.badlogic.gdx.Application
    public void error(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, th) == null) || this.p < 1) {
            return;
        }
        d().error(str, str2, th);
    }

    @Override // com.badlogic.gdx.Application
    public void log(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048602, this, str, str2, th) == null) || this.p < 2) {
            return;
        }
        d().log(str, str2, th);
    }
}
