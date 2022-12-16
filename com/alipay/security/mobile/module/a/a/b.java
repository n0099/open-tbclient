package com.alipay.security.mobile.module.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                if (com.alipay.security.mobile.module.a.a.a(str)) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(str.getBytes("UTF-8"));
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < digest.length; i++) {
                    sb.append(String.format("%02x", Byte.valueOf(digest[i])));
                }
                return sb.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
