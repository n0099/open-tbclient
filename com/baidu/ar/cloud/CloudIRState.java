package com.baidu.ar.cloud;

import com.alipay.security.mobile.module.http.model.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class CloudIRState {
    public static final /* synthetic */ CloudIRState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CloudIRState ERROR;
    public static final CloudIRState START;
    public static final CloudIRState SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(870937790, "Lcom/baidu/ar/cloud/CloudIRState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(870937790, "Lcom/baidu/ar/cloud/CloudIRState;");
                return;
            }
        }
        START = new CloudIRState("START", 0);
        SUCCESS = new CloudIRState(c.f36090g, 1);
        CloudIRState cloudIRState = new CloudIRState("ERROR", 2);
        ERROR = cloudIRState;
        $VALUES = new CloudIRState[]{START, SUCCESS, cloudIRState};
    }

    public CloudIRState(String str, int i2) {
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

    public static CloudIRState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CloudIRState) Enum.valueOf(CloudIRState.class, str) : (CloudIRState) invokeL.objValue;
    }

    public static CloudIRState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CloudIRState[]) $VALUES.clone() : (CloudIRState[]) invokeV.objValue;
    }
}
