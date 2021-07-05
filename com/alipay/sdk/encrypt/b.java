package com.alipay.sdk.encrypt;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? a(1, str, str2) : (String) invokeLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? a(2, str, str2) : (String) invokeLL.objValue;
    }

    public static String a(int i2, String str, String str2) {
        InterceptResult invokeILL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, str, str2)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), Coder.KEY_DES);
                Cipher cipher = Cipher.getInstance(Coder.KEY_DES);
                cipher.init(i2, secretKeySpec);
                if (i2 == 2) {
                    bytes = a.a(str);
                } else {
                    bytes = str.getBytes("UTF-8");
                }
                byte[] doFinal = cipher.doFinal(bytes);
                if (i2 == 2) {
                    return new String(doFinal);
                }
                return a.a(doFinal);
            } catch (Exception e2) {
                com.alipay.sdk.util.c.a(e2);
                return null;
            }
        }
        return (String) invokeILL.objValue;
    }
}
