package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, map)) == null) {
            synchronized (a.class) {
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "appchannel", "");
                hashMap = new HashMap();
                hashMap.put("AA1", context.getPackageName());
                hashMap.put("AA2", com.alipay.security.mobile.module.deviceinfo.a.a().a(context));
                hashMap.put("AA3", "APPSecuritySDK-ALIPAYSDK");
                hashMap.put("AA4", "3.3.0.1905151001");
                hashMap.put("AA6", a2);
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }
}
