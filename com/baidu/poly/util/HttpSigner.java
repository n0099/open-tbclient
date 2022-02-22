package com.baidu.poly.util;

import android.text.TextUtils;
import c.a.i0.l.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes11.dex */
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

    public HttpSigner() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(b bVar, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bVar, str, i2)) == null) {
            if (bVar == null) {
                return "";
            }
            Map<String, String> b2 = bVar.b();
            ArrayList<String> arrayList = new ArrayList(b2.keySet());
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String str2 : arrayList) {
                String str3 = b2.get(str2);
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
            return c.a.i0.m.i.b.c(sb.toString());
        }
        return (String) invokeLLI.objValue;
    }

    public static void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bVar) == null) || bVar == null) {
            return;
        }
        Map<String, String> b2 = bVar.b();
        if (b2.containsKey("timestamp")) {
            b2.remove("timestamp");
        }
        if (b2.containsKey("sign")) {
            b2.remove("sign");
        }
        ArrayList<String> arrayList = new ArrayList(b2.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            String str2 = b2.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                sb.append("&");
            }
        }
        bVar.d("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        sb.append(nativeGetCommissionSk());
        sb.append("&");
        sb.append(bVar.a("timestamp"));
        bVar.d("sign", c.a.i0.m.i.b.c(sb.toString()));
    }

    public static native String nativeGetAppId(int i2);

    public static native String nativeGetCommissionSk();

    public static native String nativeGetStatisticsKey(int i2);

    public static native String nativeSignNop(String str, int i2);
}
