package com.alipay.security.mobile.module.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                str2 = f.a(str);
            } catch (Throwable unused) {
                str2 = "";
            }
            if (com.alipay.security.mobile.module.a.a.a(str2)) {
                return c.a(".SystemConfig" + File.separator + str);
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
