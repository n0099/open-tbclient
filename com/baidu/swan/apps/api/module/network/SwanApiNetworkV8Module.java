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
import com.repackage.gp1;
import com.repackage.sr1;
import com.repackage.tn1;
@Keep
/* loaded from: classes2.dex */
public class SwanApiNetworkV8Module {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODULE_NAME = "_naV8Network";
    public transient /* synthetic */ FieldHolder $fh;
    public gp1 requestApi;

    public SwanApiNetworkV8Module(@NonNull tn1 tn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestApi = new gp1(tn1Var);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsObject)) == null) {
            sr1 T = this.requestApi.T(jsObject);
            return T == null ? "" : T.a();
        }
        return (String) invokeL.objValue;
    }
}
