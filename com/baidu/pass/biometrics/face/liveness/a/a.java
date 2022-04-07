package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static a b = null;
    public static final String c = "request_data";
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, PassBiometricDto> a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                b = new a();
            }
            return b;
        }
        return (a) invokeV.objValue;
    }

    public PassBiometricDto a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HashMap<String, PassBiometricDto> hashMap = this.a;
            if (hashMap != null) {
                return hashMap.get(str);
            }
            return null;
        }
        return (PassBiometricDto) invokeL.objValue;
    }

    public void a(String str, PassBiometricDto passBiometricDto) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, passBiometricDto) == null) {
            if (this.a == null) {
                this.a = new HashMap<>();
            }
            this.a.put(str, passBiometricDto);
        }
    }

    public void a() {
        HashMap<String, PassBiometricDto> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hashMap = this.a) == null) {
            return;
        }
        hashMap.clear();
        this.a = null;
    }
}
