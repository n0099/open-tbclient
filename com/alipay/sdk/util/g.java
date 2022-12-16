package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "pref_trade_token";
    public static final String b = ";";
    public static final String c = "result={";
    public static final String d = "}";
    public static final String e = "trade_token=\"";
    public static final String f = "\"";
    public static final String g = "trade_token=";
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(com.alipay.sdk.sys.a aVar, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, context)) == null) {
            String a2 = h.a(aVar, context, a, "");
            c.b(com.alipay.sdk.cons.a.x, "get trade token: " + a2);
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split(";");
            for (int i = 0; i < split.length; i++) {
                if (split[i].startsWith(c) && split[i].endsWith("}")) {
                    String[] split2 = split[i].substring(8, split[i].length() - 1).split("&");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= split2.length) {
                            break;
                        } else if (split2[i2].startsWith(e) && split2[i2].endsWith("\"")) {
                            str2 = split2[i2].substring(13, split2[i2].length() - 1);
                            break;
                        } else if (split2[i2].startsWith(g)) {
                            str2 = split2[i2].substring(12);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static void a(com.alipay.sdk.sys.a aVar, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, aVar, context, str) == null) {
            try {
                String a2 = a(str);
                c.b(com.alipay.sdk.cons.a.x, "trade token: " + a2);
                if (!TextUtils.isEmpty(a2)) {
                    h.b(aVar, context, a, a2);
                }
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.M, th);
                c.a(th);
            }
        }
    }
}
