package com.baidu.searchbox.v8engine.net;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class NetRequestStatusCode {
    public static final /* synthetic */ NetRequestStatusCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NetRequestStatusCode CALLBACK_ERROR;
    public static final NetRequestStatusCode DATA_ERROR;
    public static final NetRequestStatusCode DATA_TYPE_ERROR;
    public static final NetRequestStatusCode ENVIRONMENT_INVALID;
    public static final NetRequestStatusCode HEADER_CLASS_TYPE_ERROR;
    public static final NetRequestStatusCode HEADER_OBJECT_EMPTY_ERROR;
    public static final NetRequestStatusCode METHOD_ERROR;
    public static final NetRequestStatusCode NO_ERROR;
    public static final NetRequestStatusCode PARAM_ERROR;
    public static final NetRequestStatusCode RESPONSE_TYPE_ERROR;
    public static final NetRequestStatusCode URL_ERROR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-430715929, "Lcom/baidu/searchbox/v8engine/net/NetRequestStatusCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-430715929, "Lcom/baidu/searchbox/v8engine/net/NetRequestStatusCode;");
                return;
            }
        }
        NO_ERROR = new NetRequestStatusCode("NO_ERROR", 0);
        URL_ERROR = new NetRequestStatusCode("URL_ERROR", 1);
        METHOD_ERROR = new NetRequestStatusCode("METHOD_ERROR", 2);
        DATA_TYPE_ERROR = new NetRequestStatusCode("DATA_TYPE_ERROR", 3);
        RESPONSE_TYPE_ERROR = new NetRequestStatusCode("RESPONSE_TYPE_ERROR", 4);
        HEADER_CLASS_TYPE_ERROR = new NetRequestStatusCode("HEADER_CLASS_TYPE_ERROR", 5);
        HEADER_OBJECT_EMPTY_ERROR = new NetRequestStatusCode("HEADER_OBJECT_EMPTY_ERROR", 6);
        DATA_ERROR = new NetRequestStatusCode("DATA_ERROR", 7);
        CALLBACK_ERROR = new NetRequestStatusCode("CALLBACK_ERROR", 8);
        ENVIRONMENT_INVALID = new NetRequestStatusCode("ENVIRONMENT_INVALID", 9);
        NetRequestStatusCode netRequestStatusCode = new NetRequestStatusCode("PARAM_ERROR", 10);
        PARAM_ERROR = netRequestStatusCode;
        $VALUES = new NetRequestStatusCode[]{NO_ERROR, URL_ERROR, METHOD_ERROR, DATA_TYPE_ERROR, RESPONSE_TYPE_ERROR, HEADER_CLASS_TYPE_ERROR, HEADER_OBJECT_EMPTY_ERROR, DATA_ERROR, CALLBACK_ERROR, ENVIRONMENT_INVALID, netRequestStatusCode};
    }

    public NetRequestStatusCode(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static NetRequestStatusCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetRequestStatusCode) Enum.valueOf(NetRequestStatusCode.class, str) : (NetRequestStatusCode) invokeL.objValue;
    }

    public static NetRequestStatusCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetRequestStatusCode[]) $VALUES.clone() : (NetRequestStatusCode[]) invokeV.objValue;
    }
}
