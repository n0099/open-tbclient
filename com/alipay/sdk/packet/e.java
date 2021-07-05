package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.app.i;
import com.alipay.sdk.net.a;
import com.alipay.sdk.util.m;
import com.alipay.sdk.util.n;
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

    /* renamed from: a  reason: collision with root package name */
    public static final String f1908a = "msp-gzip";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1909b = "Msp-Param";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1910c = "Operation-Type";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1911d = "content-type";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1912e = "Version";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1913f = "AppId";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1914g = "des-mode";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1915h = "namespace";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1916i = "api_name";
    public static final String j = "api_version";
    public static final String k = "data";
    public static final String l = "params";
    public static final String m = "public_key";
    public static final String n = "device";
    public static final String o = "action";
    public static final String p = "type";
    public static final String q = "method";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean r;
    public boolean s;

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
        this.r = true;
        this.s = true;
    }

    public Map<String, String> a(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048582, this, z, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(f1908a, String.valueOf(z));
            hashMap.put(f1910c, "alipay.msp.cashier.dispatch.bytes");
            hashMap.put("content-type", "application/octet-stream");
            hashMap.put(f1912e, "2.0");
            hashMap.put(f1913f, "TAOBAO");
            hashMap.put(f1909b, a.a(str));
            hashMap.put(f1914g, "CBC");
            return hashMap;
        }
        return (Map) invokeZL.objValue;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "4.9.0" : (String) invokeV.objValue;
    }

    public String c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("device", Build.MODEL);
            hashMap.put("namespace", "com.alipay.mobilecashier");
            hashMap.put(f1916i, "com.alipay.mcpay");
            hashMap.put(j, b());
            return a(hashMap, new HashMap<>());
        }
        return (String) invokeV.objValue;
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

    public String a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, jSONObject)) == null) {
            com.alipay.sdk.sys.b a2 = com.alipay.sdk.sys.b.a();
            com.alipay.sdk.tid.b a3 = com.alipay.sdk.tid.b.a(a2.b());
            JSONObject a4 = com.alipay.sdk.util.b.a(new JSONObject(), jSONObject);
            try {
                a4.put("tid", a3.a());
                a4.put(com.alipay.sdk.cons.b.f1841b, a2.c().a(a3));
                a4.put(com.alipay.sdk.cons.b.f1844e, n.b(a2.b(), i.f1803a));
                a4.put(com.alipay.sdk.cons.b.f1845f, n.a(a2.b()));
                a4.put(com.alipay.sdk.cons.b.f1843d, str);
                a4.put("app_key", com.alipay.sdk.cons.a.f1834d);
                a4.put(com.alipay.sdk.cons.b.f1846g, a2.e());
                a4.put(com.alipay.sdk.cons.b.j, a3.b());
                a4.put(com.alipay.sdk.cons.b.k, a2.c().a(a2.b()));
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
            }
            return a4.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) ? Boolean.valueOf(a(bVar, f1908a)).booleanValue() : invokeL.booleanValue;
    }

    public static String a(a.b bVar, String str) {
        InterceptResult invokeLL;
        Map<String, List<String>> map;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, str)) == null) {
            if (bVar == null || str == null || (map = bVar.f1899a) == null || (list = map.get(str)) == null) {
                return null;
            }
            return TextUtils.join(",", list);
        }
        return (String) invokeLL.objValue;
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

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                if (jSONObject.has("params")) {
                    String optString = jSONObject.getJSONObject("params").optString(m, null);
                    if (TextUtils.isEmpty(optString)) {
                        return false;
                    }
                    com.alipay.sdk.sys.b.a().c().a(optString);
                    return true;
                }
                return false;
            } catch (JSONException e2) {
                com.alipay.sdk.util.c.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public b a(Context context) throws Throwable {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? a(context, "") : (b) invokeL.objValue;
    }

    public b a(Context context, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) ? a(context, str, m.a(context)) : (b) invokeLL.objValue;
    }

    public b a(Context context, String str, String str2) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) ? a(context, str, str2, true) : (b) invokeLLL.objValue;
    }

    public b a(Context context, String str, String str2, boolean z) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, Boolean.valueOf(z)})) == null) {
            com.alipay.sdk.util.c.b("", "PacketTask::request url >" + str2);
            c cVar = new c(this.s);
            d a2 = cVar.a(new b(c(), a(str, a())), this.r);
            a.b a3 = com.alipay.sdk.net.a.a(context, new a.C0017a(str2, a(a2.a(), str), a2.b()));
            if (a3 != null) {
                b a4 = cVar.a(new d(a(a3), a3.f1901c));
                return (a4 != null && a(a4.a()) && z) ? a(context, str, str2, false) : a4;
            }
            throw new RuntimeException("Response is null.");
        }
        return (b) invokeCommon.objValue;
    }
}
