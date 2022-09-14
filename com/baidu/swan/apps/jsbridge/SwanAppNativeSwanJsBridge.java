package com.baidu.swan.apps.jsbridge;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.cf3;
import com.baidu.tieba.ij1;
import com.baidu.tieba.in2;
import com.baidu.tieba.lf3;
import com.baidu.tieba.w12;
import com.baidu.tieba.xy2;
import com.baidu.tieba.yz1;
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class SwanAppNativeSwanJsBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public w12 mJSContainer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1497901695, "Lcom/baidu/swan/apps/jsbridge/SwanAppNativeSwanJsBridge;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1497901695, "Lcom/baidu/swan/apps/jsbridge/SwanAppNativeSwanJsBridge;");
                return;
            }
        }
        DEBUG = ij1.a;
    }

    public SwanAppNativeSwanJsBridge(w12 w12Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w12Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJSContainer = w12Var;
    }

    @JavascriptInterface
    @SuppressLint({"BDThrowableCheck"})
    public String getAPIs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (DEBUG) {
                return xy2.p() ? lf3.d(i, getClassify()) : "";
            }
            String d = lf3.d(i, getClassify());
            if (TextUtils.isEmpty(d)) {
                if (!DEBUG) {
                    cf3.c(lf3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
                } else {
                    lf3.i();
                    throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
                }
            } else {
                cf3.d();
            }
            return d;
        }
        return (String) invokeI.objValue;
    }

    public String getClassify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? isSwanWeb() ? "swan/web" : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? in2.a(this.mJSContainer) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject b = zt2.b();
            yz1.k(TAG, "getNACanIUseMap - " + b.toString());
            return b.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean isSwanWeb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            w12 w12Var = this.mJSContainer;
            return w12Var != null && (w12Var instanceof NgWebView) && ((NgWebView) w12Var).isSwanWebMode();
        }
        return invokeV.booleanValue;
    }
}
