package com.alipay.sdk.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1990a = "resultStatus";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1991b = "memo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1992c = "result";
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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

    public static Map<String, String> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Map<String, String> a2 = a();
            try {
                return b(str);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.f1828g, th);
                return a2;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            String[] split = str.split(";");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                String substring = str2.substring(0, str2.indexOf("={"));
                hashMap.put(substring, a(str2, substring));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.f1811c.a());
            HashMap hashMap = new HashMap();
            hashMap.put(f1990a, Integer.toString(b2.a()));
            hashMap.put(f1991b, b2.b());
            hashMap.put("result", "");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            String str3 = str2 + "={";
            return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
        }
        return (String) invokeLL.objValue;
    }
}
