package com.baidu.fsg.base.utils;

import android.os.Build;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class Base64Utils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f39540a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-556211470, "Lcom/baidu/fsg/base/utils/Base64Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-556211470, "Lcom/baidu/fsg/base/utils/Base64Utils;");
                return;
            }
        }
        f39540a = Boolean.valueOf(Build.VERSION.SDK_INT >= 8);
    }

    public Base64Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f39540a.booleanValue()) {
                return Base64.decode(str, 2);
            }
            try {
                return com.baidu.fsg.base.utils.support.Base64.decode(str);
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getLocalizedMessage());
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (f39540a.booleanValue()) {
                return Base64.decode(bArr, 2);
            }
            try {
                return com.baidu.fsg.base.utils.support.Base64.decode(bArr);
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getLocalizedMessage());
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? f39540a.booleanValue() ? Base64.encode(bArr, 2) : com.baidu.fsg.base.utils.support.Base64.encodeBytesToBytes(bArr) : (byte[]) invokeL.objValue;
    }

    public static String encodeToString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) ? f39540a.booleanValue() ? Base64.encodeToString(bArr, 2) : com.baidu.fsg.base.utils.support.Base64.encodeBytes(bArr) : (String) invokeL.objValue;
    }
}
