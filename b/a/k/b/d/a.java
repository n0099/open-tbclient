package b.a.k.b.d;

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
    public static final String f3169d;

    /* renamed from: e  reason: collision with root package name */
    public static a f3170e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3171a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f3172b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3173c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1431675587, "Lb/a/k/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1431675587, "Lb/a/k/b/d/a;");
                return;
            }
        }
        f3169d = BdSailor.class.getName();
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
            a aVar = f3170e;
            if (aVar == null) {
                f3170e = new a();
            } else if (aVar.f3172b != null && (aVar.f3173c ^ BdZeusUtil.isWebkitLoaded())) {
                Log.d(f3169d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
                f3170e.f();
                f3170e.e();
            }
            return f3170e;
        }
        return (a) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            a a2 = a();
            a2.f();
            a2.f3171a = null;
            f3170e = null;
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Log.d(f3169d, "BdWebViewSingleton pauseTimer");
            try {
                e();
                this.f3172b.pauseTimers();
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
            Log.d(f3169d, "BdWebViewSingleton resumeTimer");
            try {
                e();
                this.f3172b.resumeTimers();
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f3172b == null && this.f3171a != null) {
            if (BdZeusUtil.isWebkitLoaded()) {
                this.f3173c = true;
            } else {
                this.f3173c = false;
                Log.d(f3169d, "BdWebViewSingleton init system webview,zeus was not load complete");
            }
            this.f3172b = new WebView(this.f3171a);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.w(f3169d, "BdWebViewSingleton, old instance has been destroyed");
            WebView webView = this.f3172b;
            if (webView != null) {
                webView.destroy();
                this.f3172b = null;
            }
        }
    }
}
