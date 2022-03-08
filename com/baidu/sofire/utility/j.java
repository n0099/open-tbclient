package com.baidu.sofire.utility;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            try {
                return Base64.encodeToString((UUID.randomUUID() + "_" + System.currentTimeMillis() + "_" + str).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, "");
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
