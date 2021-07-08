package com.baidu.pass.biometrics.base.utils;

import android.annotation.TargetApi;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(8)
/* loaded from: classes2.dex */
public class Base64Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_WRAP = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public Base64Utils() {
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

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? Base64.decode(str.getBytes(), 2) : (byte[]) invokeL.objValue;
    }

    public static byte[] encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return Base64.encode(bArr, 2);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encodeToString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            return Base64.encodeToString(bArr, 2);
        }
        return (String) invokeL.objValue;
    }
}
