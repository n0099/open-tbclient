package com.baidu.android.pushservice.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
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
                for (byte b2 : digest) {
                    int i2 = b2 & 255;
                    if (i2 < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i2));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, Long.valueOf(j2)})) == null) ? a(context, String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j2))) : (String) invokeCommon.objValue;
    }
}
