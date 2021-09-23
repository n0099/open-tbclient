package com.baidu.swan.apps.api.module.network;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import c.a.p0.a.u.c.b;
import c.a.p0.a.u.c.d;
import c.a.p0.a.u.e.j.g;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes6.dex */
public class SwanApiNetworkV8Module {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MODULE_NAME = "_naV8Network";
    public transient /* synthetic */ FieldHolder $fh;
    public g requestApi;

    public SwanApiNetworkV8Module(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.requestApi = new g(bVar);
    }

    @JavascriptInterface
    public String request(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jsObject)) == null) {
            boolean z = d.f8735c;
            c.a.p0.a.u.h.b L = this.requestApi.L(jsObject);
            return L == null ? "" : L.a();
        }
        return (String) invokeL.objValue;
    }
}
