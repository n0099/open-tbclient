package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.is1;
import com.repackage.jo1;
import com.repackage.wp1;
@Keep
/* loaded from: classes2.dex */
public class SwanApiNetworkV8Module {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODULE_NAME = "_naV8Network";
    public transient /* synthetic */ FieldHolder $fh;
    public wp1 requestApi;

    public SwanApiNetworkV8Module(@NonNull jo1 jo1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestApi = new wp1(jo1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsObject)) == null) {
            is1 T = this.requestApi.T(jsObject);
            return T == null ? "" : T.a();
        }
        return (String) invokeL.objValue;
    }
}
