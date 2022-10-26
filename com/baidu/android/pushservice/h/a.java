package com.baidu.android.pushservice.h;

import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    int i = b & 255;
                    if (i < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Long.valueOf(j)})) == null) ? a(context, String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j))) : (String) invokeCommon.objValue;
    }
}
