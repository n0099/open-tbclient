package com.baidu.searchbox.network.outback.core;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes3.dex */
public final class HttpMethod {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpMethod() {
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

    public static boolean permitsRequestBody(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!str.equals("GET") && !str.equals("HEAD")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean requiresRequestBody(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!str.equals("POST") && !str.equals(HttpPut.METHOD_NAME) && !str.equals("PATCH") && !str.equals("PROPPATCH") && !str.equals("REPORT")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
