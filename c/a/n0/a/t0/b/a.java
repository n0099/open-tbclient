package c.a.n0.a.t0.b;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import c.a.n0.a.b0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.t0.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.t0.a f6327b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppUtilsJavaScriptInterface f6328c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.a.k.a f6329d;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            c.a.n0.a.t0.a aVar = this.a;
            if (aVar != null) {
                aVar.setActivityRef(activity);
            }
            c.a.n0.a.t0.a aVar2 = this.f6327b;
            if (aVar2 != null) {
                aVar2.setActivityRef(activity);
            }
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.f6328c;
            if (swanAppUtilsJavaScriptInterface != null) {
                swanAppUtilsJavaScriptInterface.setActivity(activity);
            }
            c.a.n0.a.k.a aVar3 = this.f6329d;
            if (aVar3 != null) {
                aVar3.g(activity);
            }
        }
    }

    public final void b(c.a.n0.a.x.f.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull c.a.n0.a.k.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, context, callbackHandler, unitedSchemeMainDispatcher, aVar2) == null) {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
            this.a = swanAppGlobalJsBridge;
            aVar.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
            SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, aVar);
            this.f6327b = swanAppJsBridge;
            aVar.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
            aVar.addJavascriptInterface(new SwanAppPreloadJsBridge(aVar), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
            aVar2.b(aVar);
        }
    }

    public final void c(@NonNull c.a.n0.a.x.f.a aVar, Context context, @NonNull c.a.n0.a.k.a aVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, context, aVar2) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
            this.f6328c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            aVar.addJavascriptInterface(this.f6328c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            aVar2.a(aVar);
        }
    }

    public final void d(c.a.n0.a.x.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.addJavascriptInterface(new SwanAppNativeSwanJsBridge(aVar), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        }
    }

    public void e(c.a.n0.a.x.f.a aVar, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, aVar, context, callbackHandler, unitedSchemeMainDispatcher) == null) || aVar == null || context == null || callbackHandler == null || unitedSchemeMainDispatcher == null) {
            return;
        }
        c.a.n0.a.k.a aVar2 = new c.a.n0.a.k.a(context, callbackHandler, aVar);
        this.f6329d = aVar2;
        b(aVar, context, callbackHandler, unitedSchemeMainDispatcher, aVar2);
        if (aVar instanceof c) {
            c(aVar, context, this.f6329d);
        } else {
            d(aVar);
        }
    }

    public void f(Context context, c.a.n0.a.x.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, aVar) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, aVar);
            this.f6328c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            aVar.addJavascriptInterface(this.f6328c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.f6328c.setForceShareLight(true);
        }
    }
}
