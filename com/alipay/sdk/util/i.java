package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1980a = "pref_trade_token";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1981b = ";";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1982c = "result={";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1983d = "}";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1984e = "trade_token=\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1985f = "\"";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1986g = "trade_token=";
    public transient /* synthetic */ FieldHolder $fh;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            try {
                String a2 = a(str);
                c.b("", "PayResultUtil::saveTradeToken > tradeToken:" + a2);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                j.a(context, f1980a, a2);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.B, th);
                c.a(th);
            }
        }
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
            for (int i2 = 0; i2 < split.length; i2++) {
                if (split[i2].startsWith(f1982c) && split[i2].endsWith("}")) {
                    String[] split2 = split[i2].substring(8, split[i2].length() - 1).split("&");
                    int i3 = 0;
                    while (true) {
                        if (i3 >= split2.length) {
                            break;
                        } else if (split2[i3].startsWith(f1984e) && split2[i3].endsWith("\"")) {
                            str2 = split2[i3].substring(13, split2[i3].length() - 1);
                            break;
                        } else if (split2[i3].startsWith(f1986g)) {
                            str2 = split2[i3].substring(12);
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String b2 = j.b(context, f1980a, "");
            c.b("", "PayResultUtil::fetchTradeToken > tradeToken:" + b2);
            return b2;
        }
        return (String) invokeL.objValue;
    }
}
