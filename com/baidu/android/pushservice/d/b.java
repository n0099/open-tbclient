package com.baidu.android.pushservice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"InlinedApi"})
    public static void a(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, hashMap) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            hashMap.put("timestamp", currentTimeMillis + "");
            hashMap.put("expires", (86400 + currentTimeMillis) + "");
            hashMap.put("v", "1");
            try {
                hashMap.put("vcode", com.baidu.android.pushservice.j.f.a(URLEncoder.encode(currentTimeMillis + "bccs", "UTF-8").getBytes(), false));
            } catch (UnsupportedEncodingException e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }
}
