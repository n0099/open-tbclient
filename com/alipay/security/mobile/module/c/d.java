package com.alipay.security.mobile.module.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, str, str2, str3) == null) {
            synchronized (d.class) {
                if (!com.alipay.security.mobile.module.a.a.a(str)) {
                    if (!com.alipay.security.mobile.module.a.a.a(str2) && context != null) {
                        try {
                            String a = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3);
                            HashMap hashMap = new HashMap();
                            hashMap.put(str2, a);
                            e.a(context, str, hashMap);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }
}
