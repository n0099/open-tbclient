package com.baidu.poly.util;

import android.text.TextUtils;
import c.a.e0.k.a.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes5.dex */
public class HttpSigner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2122372207, "Lcom/baidu/poly/util/HttpSigner;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2122372207, "Lcom/baidu/poly/util/HttpSigner;");
                return;
            }
        }
        System.loadLibrary("hs");
    }

    public static String a(b bVar, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, bVar, str, i2)) == null) {
            if (bVar == null) {
                return "";
            }
            Map<String, String> c2 = bVar.c();
            ArrayList<String> arrayList = new ArrayList(c2.keySet());
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String str2 : arrayList) {
                String str3 = c2.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                    sb.append("&");
                }
            }
            sb.append(str);
            sb.append("=");
            sb.append(nativeGetStatisticsKey(i2));
            return c.a.e0.k.g.b.c(sb.toString());
        }
        return (String) invokeLLI.objValue;
    }

    public static void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bVar) == null) || bVar == null) {
            return;
        }
        Map<String, String> c2 = bVar.c();
        if (c2.containsKey("timestamp")) {
            c2.remove("timestamp");
        }
        if (c2.containsKey("sign")) {
            c2.remove("sign");
        }
        ArrayList<String> arrayList = new ArrayList(c2.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            String str2 = c2.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                sb.append("&");
            }
        }
        bVar.e("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        sb.append(nativeGetCommissionSk());
        sb.append("&");
        sb.append(bVar.b("timestamp"));
        bVar.e("sign", c.a.e0.k.g.b.c(sb.toString()));
    }

    public static native String nativeGetCommissionSk();

    public static native String nativeGetStatisticsKey(int i2);
}
