package com.baidu.ar.statistic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class n extends j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.ar.statistic.j
    public JSONObject a(JSONObject jSONObject, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, aVar)) == null) ? jSONObject : (JSONObject) invokeLL.objValue;
    }

    @Override // com.baidu.ar.statistic.j
    public void g(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.ar.statistic.j
    public void h(JSONObject jSONObject) {
        IHttpRequest newRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || (newRequest = HttpFactory.newRequest()) == null) {
            return;
        }
        String gR = s.gR();
        newRequest.setUrl(gR).setMethod("POST").setBody("info=" + URLEncoder.encode(jSONObject.toString(), "UTF-8")).addHeader("Content-Type: application/x-www-form-urlencoded");
        newRequest.execute();
    }

    @Override // com.baidu.ar.statistic.j
    public Map<String, Object> i(List<a> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            return null;
        }
        return (Map) invokeL.objValue;
    }
}
