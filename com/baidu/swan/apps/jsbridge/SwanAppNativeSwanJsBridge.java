package com.baidu.swan.apps.jsbridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import b.a.p0.a.d1.b.b;
import b.a.p0.a.h0.f.a;
import b.a.p0.a.k;
import b.a.p0.a.l0.d;
import b.a.p0.a.v2.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Keep
/* loaded from: classes8.dex */
public class SwanAppNativeSwanJsBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "_naSwan";
    public static final String TAG = "SwanAppNativeSwanJsBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public a mJSContainer;

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
        DEBUG = k.f6397a;
    }

    public SwanAppNativeSwanJsBridge(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJSContainer = aVar;
    }

    @JavascriptInterface
    public String getAPIs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (DEBUG) {
                return b.a.p0.a.u1.a.a.p() ? j.d(i2, false) : "";
            }
            String d2 = j.d(i2, false);
            if (TextUtils.isEmpty(d2)) {
                if (!DEBUG) {
                    b.a.p0.a.v2.a.c(j.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i2), d2, Boolean.TRUE)));
                } else {
                    j.g();
                    throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i2), d2));
                }
            } else {
                b.a.p0.a.v2.a.d();
            }
            return d2;
        }
        return (String) invokeI.objValue;
    }

    @JavascriptInterface
    public String getEnvVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.a(this.mJSContainer) : (String) invokeV.objValue;
    }

    @JavascriptInterface
    public String getNACanIUseMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            d.K0(jSONObject);
            b.a.p0.a.e0.d.h(TAG, "getNACanIUseMap - " + jSONObject.toString());
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
