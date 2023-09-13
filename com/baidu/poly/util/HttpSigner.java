package com.baidu.poly.util;

import android.text.TextUtils;
import com.baidu.tieba.nh1;
import com.baidu.tieba.pg1;
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
/* loaded from: classes3.dex */
public class HttpSigner {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static native String nativeGetAppId(int i);

    public static native String nativeGetCommissionSk();

    public static native String nativeGetStatisticsKey(int i);

    public static native String nativeSignNop(String str, int i);

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(pg1 pg1Var, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, pg1Var, str, i)) == null) {
            if (pg1Var == null) {
                return "";
            }
            Map<String, String> b = pg1Var.b();
            ArrayList<String> arrayList = new ArrayList(b.keySet());
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String str2 : arrayList) {
                String str3 = b.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                    sb.append("&");
                }
            }
            sb.append(str);
            sb.append("=");
            sb.append(nativeGetStatisticsKey(i));
            return nh1.c(sb.toString());
        }
        return (String) invokeLLI.objValue;
    }

    public static void b(pg1 pg1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, pg1Var) != null) || pg1Var == null) {
            return;
        }
        Map<String, String> b = pg1Var.b();
        if (b.containsKey("timestamp")) {
            b.remove("timestamp");
        }
        if (b.containsKey("sign")) {
            b.remove("sign");
        }
        ArrayList<String> arrayList = new ArrayList(b.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            String str2 = b.get(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                sb.append("&");
            }
        }
        pg1Var.d("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        sb.append(nativeGetCommissionSk());
        sb.append("&");
        sb.append(pg1Var.a("timestamp"));
        pg1Var.d("sign", nh1.c(sb.toString()));
    }
}
