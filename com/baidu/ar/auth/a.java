package com.baidu.ar.auth;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IAuthenticator getAsyncAuthenticator(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, str3)) == null) ? com.baidu.ar.auth.a.a.b(str, str2, str3) : (IAuthenticator) invokeLLL.objValue;
    }

    public static IAuthenticator getAuthenticator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? com.baidu.ar.auth.a.b.cE() : (IAuthenticator) invokeV.objValue;
    }

    public static IOfflineAuthenticator getOfflineAuthenticator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? com.baidu.ar.auth.a.c.cF() : (IOfflineAuthenticator) invokeV.objValue;
    }
}
