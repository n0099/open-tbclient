package com.baidu.crabsdk.lite;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, HashMap<String, Object>> f4731a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4732b;

    /* renamed from: c  reason: collision with root package name */
    public static int f4733c;

    /* renamed from: d  reason: collision with root package name */
    public static int f4734d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4735e;

    /* renamed from: f  reason: collision with root package name */
    public static long f4736f;

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, Integer> f4737g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4738h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f4739i;
    public static boolean j;
    public static boolean k;
    public static Proxy l;
    public static String m;
    public static String n;
    public static String o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1194698888, "Lcom/baidu/crabsdk/lite/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1194698888, "Lcom/baidu/crabsdk/lite/a;");
                return;
            }
        }
        f4731a = new HashMap<>();
        f4732b = null;
        f4733c = 10;
        f4734d = 200;
        f4735e = true;
        f4736f = 30000L;
        f4737g = new HashMap<>();
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        f4738h = true;
        f4739i = true;
        j = true;
        k = false;
        l = null;
        m = null;
        n = "http://cq01-tdw-bfe02.cq01.baidu.com:8123/api/add_crab";
        o = "http://cq01-tdw-bfe02.cq01.baidu.com:8123/api/add_crab";
    }

    public static String a(String str) {
        InterceptResult invokeL;
        HashMap<String, Object> hashMap;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (f4738h) {
                if (m == null || (hashMap = f4731a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                    return "https://crab.baidu.com/api_int/add_crab";
                }
                return ((String) obj) + "api_int/add_crab";
            }
            return n;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        HashMap<String, Object> hashMap;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f4738h) {
                if (m == null || (hashMap = f4731a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                    return "https://crab.baidu.com/api_anr/add_crab";
                }
                return ((String) obj) + "api_int/add_crab";
            }
            return o;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        HashMap<String, Object> hashMap;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (f4738h) {
                if (m == null || (hashMap = f4731a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                    return "https://crab.baidu.com/api/newsync2";
                }
                return ((String) obj) + "api_int/add_crab";
            }
            return "http://cq01-tdw-bfe02.cq01.baidu.com:8090/batsdk/api/newsync2";
        }
        return (String) invokeL.objValue;
    }
}
