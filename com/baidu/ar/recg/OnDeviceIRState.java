package com.baidu.ar.recg;

import com.alipay.security.mobile.module.http.model.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class OnDeviceIRState {
    public static final /* synthetic */ OnDeviceIRState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final OnDeviceIRState DB_DOWNLOADED;
    public static final OnDeviceIRState DB_INIT;
    public static final OnDeviceIRState ERROR;
    public static final OnDeviceIRState NO_NETWORK;
    public static final OnDeviceIRState START;
    public static final OnDeviceIRState SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1904616304, "Lcom/baidu/ar/recg/OnDeviceIRState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1904616304, "Lcom/baidu/ar/recg/OnDeviceIRState;");
                return;
            }
        }
        START = new OnDeviceIRState("START", 0);
        DB_DOWNLOADED = new OnDeviceIRState("DB_DOWNLOADED", 1);
        DB_INIT = new OnDeviceIRState("DB_INIT", 2);
        SUCCESS = new OnDeviceIRState(c.p, 3);
        NO_NETWORK = new OnDeviceIRState("NO_NETWORK", 4);
        OnDeviceIRState onDeviceIRState = new OnDeviceIRState("ERROR", 5);
        ERROR = onDeviceIRState;
        $VALUES = new OnDeviceIRState[]{START, DB_DOWNLOADED, DB_INIT, SUCCESS, NO_NETWORK, onDeviceIRState};
    }

    public OnDeviceIRState(String str, int i2) {
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

    public static OnDeviceIRState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OnDeviceIRState) Enum.valueOf(OnDeviceIRState.class, str) : (OnDeviceIRState) invokeL.objValue;
    }

    public static OnDeviceIRState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OnDeviceIRState[]) $VALUES.clone() : (OnDeviceIRState[]) invokeV.objValue;
    }
}
