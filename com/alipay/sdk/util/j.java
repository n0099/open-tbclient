package com.alipay.sdk.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "resultStatus";

    /* renamed from: b  reason: collision with root package name */
    public static final String f31438b = "memo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f31439c = "result";
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    public static Map<String, String> a(com.alipay.sdk.sys.a aVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aVar, str)) == null) {
            Map<String, String> a2 = a();
            try {
                return a(str);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", com.alipay.sdk.app.statistic.b.r, th);
                return a2;
            }
        }
        return (Map) invokeLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            String str3 = str2 + "={";
            return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
        }
        return (String) invokeLL.objValue;
    }

    public static Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            com.alipay.sdk.app.c b2 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.f31272e.b());
            HashMap hashMap = new HashMap();
            hashMap.put("resultStatus", Integer.toString(b2.b()));
            hashMap.put("memo", b2.a());
            hashMap.put("result", "");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public static Map<String, String> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String[] split = str.split(";");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                String substring = str2.substring(0, str2.indexOf("={"));
                hashMap.put(substring, b(str2, substring));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            try {
                Matcher matcher = Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
                if (matcher.find()) {
                    return matcher.group(2);
                }
            } catch (Throwable th) {
                c.a(th);
            }
            return "?";
        }
        return (String) invokeLL.objValue;
    }
}
