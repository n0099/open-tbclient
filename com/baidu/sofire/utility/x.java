package com.baidu.sofire.utility;

import android.content.Context;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes11.dex */
public final class x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, context, str, i2, th) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", str);
                hashMap.put("1", Integer.valueOf(i2));
                hashMap.put("2", Base64.encodeToString(com.baidu.sofire.b.a(th).getBytes(), 0).replace(StringUtils.LF, "").replace("\t", "").replace(StringUtils.CR, ""));
                c.a(context, "1090102", (Map<String, Object>) hashMap, true);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public static void a(Context context, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65536, null, context, str, i2, i3) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("0", str);
                hashMap.put("1", Integer.valueOf(i2));
                hashMap.put("2", Integer.valueOf(i3));
                c.a(context, "1090101", hashMap);
            } catch (Throwable unused) {
                c.a();
            }
        }
    }
}
