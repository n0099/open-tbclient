package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, map)) == null) {
            synchronized (b.class) {
                hashMap = new HashMap();
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                String a3 = com.alipay.security.mobile.module.a.a.a(map, com.alipay.sdk.cons.b.f35977g, "");
                String a4 = com.alipay.security.mobile.module.a.a.a(map, "userId", "");
                String a5 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
                String a6 = com.alipay.security.mobile.module.a.a.a(map, "appKeyClient", "");
                String a7 = com.alipay.security.mobile.module.a.a.a(map, "tmxSessionId", "");
                String f2 = h.f(context);
                String a8 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", "");
                hashMap.put("AC1", a2);
                hashMap.put("AC2", a3);
                hashMap.put("AC3", "");
                hashMap.put("AC4", f2);
                hashMap.put("AC5", a4);
                hashMap.put("AC6", a7);
                hashMap.put("AC7", "");
                hashMap.put("AC8", a5);
                hashMap.put("AC9", a6);
                if (com.alipay.security.mobile.module.a.a.b(a8)) {
                    hashMap.put("AC10", a8);
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }
}
