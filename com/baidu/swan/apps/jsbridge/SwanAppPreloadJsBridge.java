package com.baidu.swan.apps.jsbridge;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.tieba.c13;
import com.baidu.tieba.c32;
import com.baidu.tieba.ok1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes3.dex */
public class SwanAppPreloadJsBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "swanPreload";
    public static final String TAG = "SwanAppPreloadJsBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public c32 mJSContainer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1549001120, "Lcom/baidu/swan/apps/jsbridge/SwanAppPreloadJsBridge;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1549001120, "Lcom/baidu/swan/apps/jsbridge/SwanAppPreloadJsBridge;");
                return;
            }
        }
        DEBUG = ok1.a;
    }

    @JavascriptInterface
    public String onJSLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.mJSContainer.onJSLoaded();
            if (DEBUG) {
                Log.d(TAG, "onJsLoaded");
            }
            return c13.f();
        }
        return (String) invokeV.objValue;
    }

    public SwanAppPreloadJsBridge(c32 c32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c32Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJSContainer = c32Var;
    }
}
