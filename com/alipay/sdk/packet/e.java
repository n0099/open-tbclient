package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.net.a;
import com.alipay.sdk.util.k;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String c = "msp-gzip";
    public static final String d = "Msp-Param";
    public static final String e = "Operation-Type";
    public static final String f = "content-type";
    public static final String g = "Version";
    public static final String h = "AppId";
    public static final String i = "des-mode";
    public static final String j = "namespace";
    public static final String k = "api_name";
    public static final String l = "api_version";
    public static final String m = "data";
    public static final String n = "params";
    public static final String o = "public_key";
    public static final String p = "device";
    public static final String q = "action";
    public static final String r = "type";
    public static final String s = "method";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;

    public abstract JSONObject a() throws JSONException;

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "4.9.0" : (String) invokeV.objValue;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        this.b = true;
    }

    public static String a(a.b bVar, String str) {
        InterceptResult invokeLL;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, str)) == null) {
            if (bVar == null || str == null || (map = bVar.a) == null || (list = map.get(str)) == null) {
                return null;
            }
            return TextUtils.join(",", list);
        }
        return (String) invokeLL.objValue;
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", str);
            jSONObject2.put("method", str2);
            jSONObject.put("action", jSONObject2);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static boolean a(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            return Boolean.valueOf(a(bVar, c)).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                if (!jSONObject.has("params")) {
                    return false;
                }
                String optString = jSONObject.getJSONObject("params").optString(o, null);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                com.alipay.sdk.data.b.a(optString);
                return true;
            } catch (JSONException e2) {
                com.alipay.sdk.util.c.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, context)) == null) {
            return a(aVar, context, "");
        }
        return (b) invokeLL.objValue;
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, context, str)) == null) {
            return a(aVar, context, str, k.b(context));
        }
        return (b) invokeLLL.objValue;
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) throws Throwable {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, context, str, str2)) == null) {
            return a(aVar, context, str, str2, true);
        }
        return (b) invokeLLLL.objValue;
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2, boolean z) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{aVar, context, str, str2, Boolean.valueOf(z)})) == null) {
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "Packet: " + str2);
            c cVar = new c(this.b);
            b bVar = new b(b(), a(aVar, str, a()));
            Map<String, String> a = a(false, str);
            d a2 = cVar.a(bVar, this.a, a.get("iSr"));
            a.b a3 = com.alipay.sdk.net.a.a(context, new a.C0012a(str2, a(a2.b(), str), a2.a()));
            if (a3 != null) {
                b a4 = cVar.a(new d(a(a3), a3.c), a.get("iSr"));
                if (a4 != null && a(a4.b()) && z) {
                    return a(aVar, context, str, str2, false);
                }
                return a4;
            }
            throw new RuntimeException("Response is null.");
        }
        return (b) invokeCommon.objValue;
    }

    public String a(com.alipay.sdk.sys.a aVar, String str, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, aVar, str, jSONObject)) == null) {
            com.alipay.sdk.sys.b d2 = com.alipay.sdk.sys.b.d();
            com.alipay.sdk.tid.a a = com.alipay.sdk.tid.a.a(d2.b());
            JSONObject a2 = com.alipay.sdk.util.b.a(new JSONObject(), jSONObject);
            try {
                a2.put(com.alipay.sdk.cons.b.d, str);
                a2.put("tid", a.d());
                a2.put("user_agent", d2.a().a(aVar, a));
                a2.put(com.alipay.sdk.cons.b.e, l.b(aVar, d2.b(), com.alipay.sdk.app.a.d));
                a2.put(com.alipay.sdk.cons.b.f, l.i(d2.b()));
                a2.put("app_key", com.alipay.sdk.cons.a.f);
                a2.put(com.alipay.sdk.cons.b.g, d2.c());
                a2.put(com.alipay.sdk.cons.b.j, a.c());
                a2.put(com.alipay.sdk.cons.b.k, com.alipay.sdk.data.b.b(d2.b()));
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BodyErr", th);
                com.alipay.sdk.util.c.a(th);
            }
            return a2.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public String a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, hashMap, hashMap2)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            if (hashMap2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                    jSONObject3.put(entry2.getKey(), entry2.getValue());
                }
                jSONObject2.put("params", jSONObject3);
            }
            jSONObject.put("data", jSONObject2);
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public Map<String, String> a(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(c, String.valueOf(z));
            hashMap.put(e, "alipay.msp.cashier.dispatch.bytes");
            hashMap.put("content-type", "application/octet-stream");
            hashMap.put(g, "2.0");
            hashMap.put(h, "TAOBAO");
            hashMap.put(d, a.a(str));
            hashMap.put(i, "CBC");
            return hashMap;
        }
        return (Map) invokeZL.objValue;
    }

    public String b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("device", Build.MODEL);
            hashMap.put("namespace", "com.alipay.mobilecashier");
            hashMap.put("api_name", "com.alipay.mcpay");
            hashMap.put(l, c());
            return a(hashMap, new HashMap<>());
        }
        return (String) invokeV.objValue;
    }
}
