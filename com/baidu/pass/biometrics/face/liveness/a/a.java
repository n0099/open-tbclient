package com.baidu.pass.biometrics.face.liveness.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.dto.PassBiometricDto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static a f43848b = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f43849c = "request_data";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, PassBiometricDto> f43850a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43850a = new HashMap<>();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f43848b == null) {
                f43848b = new a();
            }
            return f43848b;
        }
        return (a) invokeV.objValue;
    }

    public PassBiometricDto a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HashMap<String, PassBiometricDto> hashMap = this.f43850a;
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
            if (this.f43850a == null) {
                this.f43850a = new HashMap<>();
            }
            this.f43850a.put(str, passBiometricDto);
        }
    }

    public void a() {
        HashMap<String, PassBiometricDto> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hashMap = this.f43850a) == null) {
            return;
        }
        hashMap.clear();
        this.f43850a = null;
    }
}
