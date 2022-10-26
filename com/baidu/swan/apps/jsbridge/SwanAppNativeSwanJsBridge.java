package com.baidu.swan.apps.jsbridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.k22;
import com.baidu.tieba.lz2;
import com.baidu.tieba.m02;
import com.baidu.tieba.nu2;
import com.baidu.tieba.qf3;
import com.baidu.tieba.wj1;
import com.baidu.tieba.wn2;
import com.baidu.tieba.zf3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppNativeSwanJsBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public k22 mJSContainer;

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
        DEBUG = wj1.a;
    }

    public String getClassify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (isSwanWeb()) {
                return "swan/web";
            }
            return SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        }
        return (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return wn2.a(this.mJSContainer);
        }
        return (String) invokeV.objValue;
    }

    public boolean isSwanWeb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            k22 k22Var = this.mJSContainer;
            if (k22Var == null || !(k22Var instanceof NgWebView) || !((NgWebView) k22Var).isSwanWebMode()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public SwanAppNativeSwanJsBridge(k22 k22Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k22Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJSContainer = k22Var;
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (DEBUG) {
                if (lz2.p()) {
                    return zf3.d(i, getClassify());
                }
                return "";
            }
            String d = zf3.d(i, getClassify());
            if (TextUtils.isEmpty(d)) {
                if (!DEBUG) {
                    qf3.c(zf3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d, Boolean.TRUE)));
                } else {
                    zf3.i();
                    throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d));
                }
            } else {
                qf3.d();
            }
            return d;
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject b = nu2.b();
            m02.k(TAG, "getNACanIUseMap - " + b.toString());
            return b.toString();
        }
        return (String) invokeV.objValue;
    }
}
