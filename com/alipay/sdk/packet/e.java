package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.app.i;
import com.alipay.sdk.net.a;
import com.alipay.sdk.util.m;
import com.alipay.sdk.util.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1940a = "msp-gzip";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1941b = "Msp-Param";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1942c = "Operation-Type";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1943d = "content-type";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1944e = "Version";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1945f = "AppId";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1946g = "des-mode";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1947h = "namespace";
    public static final String i = "api_name";
    public static final String j = "api_version";
    public static final String k = "data";
    public static final String l = "params";
    public static final String m = "public_key";
    public static final String n = "device";
    public static final String o = "action";
    public static final String p = "type";
    public static final String q = "method";
    public boolean r = true;
    public boolean s = true;

    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(f1940a, String.valueOf(z));
        hashMap.put(f1942c, "alipay.msp.cashier.dispatch.bytes");
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put(f1944e, "2.0");
        hashMap.put(f1945f, "TAOBAO");
        hashMap.put(f1941b, a.a(str));
        hashMap.put(f1946g, "CBC");
        return hashMap;
    }

    public abstract JSONObject a() throws JSONException;

    public String b() {
        return "4.9.0";
    }

    public String c() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("device", Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put(i, "com.alipay.mcpay");
        hashMap.put(j, b());
        return a(hashMap, new HashMap<>());
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public String a(String str, JSONObject jSONObject) {
        com.alipay.sdk.sys.b a2 = com.alipay.sdk.sys.b.a();
        com.alipay.sdk.tid.b a3 = com.alipay.sdk.tid.b.a(a2.b());
        JSONObject a4 = com.alipay.sdk.util.b.a(new JSONObject(), jSONObject);
        try {
            a4.put("tid", a3.a());
            a4.put(com.alipay.sdk.cons.b.f1877b, a2.c().a(a3));
            a4.put(com.alipay.sdk.cons.b.f1880e, n.b(a2.b(), i.f1842a));
            a4.put(com.alipay.sdk.cons.b.f1881f, n.a(a2.b()));
            a4.put(com.alipay.sdk.cons.b.f1879d, str);
            a4.put(com.alipay.sdk.cons.b.f1883h, com.alipay.sdk.cons.a.f1871d);
            a4.put(com.alipay.sdk.cons.b.f1882g, a2.e());
            a4.put(com.alipay.sdk.cons.b.j, a3.b());
            a4.put(com.alipay.sdk.cons.b.k, a2.c().a(a2.b()));
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
        return a4.toString();
    }

    public static boolean a(a.b bVar) {
        return Boolean.valueOf(a(bVar, f1940a)).booleanValue();
    }

    public static String a(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.f1931a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public String a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
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

    private boolean a(String str) {
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

    public b a(Context context) throws Throwable {
        return a(context, "");
    }

    public b a(Context context, String str) throws Throwable {
        return a(context, str, m.a(context));
    }

    public b a(Context context, String str, String str2) throws Throwable {
        return a(context, str, str2, true);
    }

    public b a(Context context, String str, String str2, boolean z) throws Throwable {
        com.alipay.sdk.util.c.b("", "PacketTask::request url >" + str2);
        c cVar = new c(this.s);
        d a2 = cVar.a(new b(c(), a(str, a())), this.r);
        a.b a3 = com.alipay.sdk.net.a.a(context, new a.C0016a(str2, a(a2.a(), str), a2.b()));
        if (a3 != null) {
            b a4 = cVar.a(new d(a(a3), a3.f1933c));
            return (a4 != null && a(a4.a()) && z) ? a(context, str, str2, false) : a4;
        }
        throw new RuntimeException("Response is null.");
    }
}
