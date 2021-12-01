package c.a.j.b.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f3467d;

    /* renamed from: e  reason: collision with root package name */
    public static a f3468e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f3469b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3470c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1249564093, "Lc/a/j/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1249564093, "Lc/a/j/b/d/a;");
                return;
            }
        }
        f3467d = BdSailor.class.getName();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a aVar = f3468e;
            if (aVar == null) {
                f3468e = new a();
            } else if (aVar.f3469b != null && (aVar.f3470c ^ BdZeusUtil.isWebkitLoaded())) {
                Log.d(f3467d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
                f3468e.f();
                f3468e.e();
            }
            return f3468e;
        }
        return (a) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            a a = a();
            a.f();
            a.a = null;
            f3468e = null;
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Log.d(f3467d, "BdWebViewSingleton pauseTimer");
            try {
                e();
                this.f3469b.pauseTimers();
                return true;
            } catch (Exception e2) {
                Log.printStackTrace(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Log.d(f3467d, "BdWebViewSingleton resumeTimer");
            try {
                e();
                this.f3469b.resumeTimers();
                return true;
            } catch (Exception e2) {
                Log.printStackTrace(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f3469b == null && this.a != null) {
            if (BdZeusUtil.isWebkitLoaded()) {
                this.f3470c = true;
            } else {
                this.f3470c = false;
                Log.d(f3467d, "BdWebViewSingleton init system webview,zeus was not load complete");
            }
            this.f3469b = new WebView(this.a);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.w(f3467d, "BdWebViewSingleton, old instance has been destroyed");
            WebView webView = this.f3469b;
            if (webView != null) {
                webView.destroy();
                this.f3469b = null;
            }
        }
    }
}
