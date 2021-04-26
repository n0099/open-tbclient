package com.baidu.crabsdk.lite.sender;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.crabsdk.lite.CrabLite;
import com.baidu.crabsdk.lite.a.f;
import com.baidu.crabsdk.lite.a.g;
import com.baidu.crabsdk.lite.a.h;
import com.baidu.crabsdk.lite.a.k;
import com.baidu.crabsdk.lite.a.l;
import com.baidu.crabsdk.lite.a.m;
import com.baidu.crabsdk.lite.a.n;
import com.baidu.crabsdk.lite.a.o;
import com.baidu.crabsdk.lite.a.p;
import com.baidu.crabsdk.lite.a.q;
import com.baidu.crabsdk.lite.a.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    public static String a(String str, String str2, String str3) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("batvn", "2.2.1");
            HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4862a.get(str);
            String str4 = (hashMap == null || (obj = hashMap.get("sdk_appkey")) == null) ? null : (String) obj;
            if (str4 != null) {
                jSONObject.put("appkey", str4);
                if (str3 == null || str3.length() <= 0) {
                    Object obj2 = hashMap.get("sdk_appvn");
                    str3 = obj2 != null ? (String) obj2 : n.d();
                }
                jSONObject.put("appvn", str3);
                jSONObject.put("apiType", str2);
                if (!CrabLite.f4860b.equals("-1")) {
                    jSONObject.put("ndkVN", CrabLite.f4860b);
                }
                com.baidu.crabsdk.lite.b.a.f(str, "agent is " + jSONObject.toString());
                return jSONObject.toString();
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> b(String str, Context context, Throwable th) {
        Object obj;
        Map<String, Object> e2 = e(str, context);
        if (e2 == null) {
            return null;
        }
        boolean z = true;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4862a.get(str);
        if (hashMap != null && (obj = hashMap.get("sdk_privacy")) != null) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            com.baidu.crabsdk.lite.b.a.f(str, "SEND_PRIVACYINFORMATION true");
            c(str, e2, context);
        }
        try {
            d(str, e2, th);
        } catch (RuntimeException e3) {
            com.baidu.crabsdk.lite.b.a.c(str, "createCrashRecord fail." + e3);
        }
        return e2;
    }

    public static Map<String, Object> c(String str, Map<String, Object> map, Context context) {
        Object obj;
        try {
            HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4862a.get(str);
            if ((hashMap == null || (obj = hashMap.get("sdk_screenshot")) == null) ? false : ((Boolean) obj).booleanValue()) {
                byte[] g2 = com.baidu.crabsdk.lite.a.a.g(str);
                com.baidu.crabsdk.lite.b.a.c(str, "截图大小：" + (g2.length / 1024) + "KB");
                map.put("screenshot", g2);
            } else {
                map.put("screenshot", new byte[0]);
            }
            map.put("myAppCPUStat", com.baidu.crabsdk.lite.a.c.a(str));
            map.put("deviceInfo", f.a(context));
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.lite.b.a.e(str, "createRecord fail.", e2);
        }
        return map;
    }

    public static Map<String, Object> d(String str, Map<String, Object> map, Throwable th) {
        if (th == null) {
            return map;
        }
        map.put("errorType", th.getClass().getName());
        String d2 = com.baidu.crabsdk.lite.b.c.d(th);
        map.put("errorLine", d2);
        com.baidu.crabsdk.lite.b.a.f(str, "errorLine: " + d2);
        String f2 = com.baidu.crabsdk.lite.b.c.f(th);
        map.put("errorOriLine", f2);
        com.baidu.crabsdk.lite.b.a.f(str, "errorOriLine: " + f2);
        map.put("errorTrace", Log.getStackTraceString(th));
        return map;
    }

    public static Map<String, Object> e(String str, Context context) {
        String str2;
        String str3;
        HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4862a.get(str);
        if (hashMap == null) {
            str3 = "sdk config map is null!";
        } else {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get("sdk_appkey");
            if (obj != null) {
                hashMap2.put("appKey", (String) obj);
                hashMap2.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
                hashMap2.put("memInfo", k.b());
                hashMap2.put("sysMemInfo", k.c(str));
                hashMap2.put("pageHistory", com.baidu.crabsdk.lite.a.a.d());
                if (com.baidu.crabsdk.lite.b.c.e(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                    hashMap2.put("networkInfo", m.c(str));
                }
                try {
                    hashMap2.put("logcat", com.baidu.crabsdk.lite.a.i.a(str));
                } catch (Exception e2) {
                    com.baidu.crabsdk.lite.b.a.d(str, e2.getMessage());
                }
                hashMap2.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
                hashMap2.put("uname", r.d(str));
                hashMap2.put("uid", r.c(str));
                hashMap2.put("batVN", "2.2.1");
                hashMap2.put("nativeVN", CrabLite.f4860b);
                Object obj2 = hashMap.get("sdk_developname");
                hashMap2.put("developerName", obj2 != null ? (String) obj2 : "");
                hashMap2.put("isRoot", Integer.valueOf(o.b(str)));
                hashMap2.put(PushClientConstants.TAG_PKG_NAME, str);
                hashMap2.put("appLabel", n.c());
                Object obj3 = hashMap.get("sdk_appvn");
                hashMap2.put("appVN", obj3 != null ? (String) obj3 : n.d());
                Object obj4 = hashMap.get("sdk_appvc");
                hashMap2.put("appVC", obj4 != null ? (String) obj4 : Integer.valueOf(n.e()));
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("brand", Build.BRAND);
                hashMap2.put(IAdRequestParam.OS, "Android");
                hashMap2.put("osVN", Build.VERSION.RELEASE);
                hashMap2.put("osVC", Integer.valueOf(com.baidu.crabsdk.lite.b.c.g()));
                hashMap2.put("startupTime", Long.valueOf(com.baidu.crabsdk.lite.a.a.a()));
                hashMap2.put("curPage", com.baidu.crabsdk.lite.a.a.f());
                hashMap2.put("locale", h.b());
                hashMap2.put("allThreadStacks", q.b());
                hashMap2.put("appCurConfig", com.baidu.crabsdk.lite.a.e.a(str, context));
                try {
                    str2 = p.a();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    str2 = "N/A";
                }
                hashMap2.put("internalStorageInfo", str2);
                hashMap2.put("CUID", g.a(str, context));
                hashMap2.put("channel", com.baidu.crabsdk.lite.a.d.a(str));
                hashMap2.put("cpuabi", Build.CPU_ABI);
                String f2 = r.f(str);
                if (!TextUtils.isEmpty(f2)) {
                    hashMap2.put("usersCustom", f2);
                }
                hashMap2.put("batteryRate", f.c(str));
                return hashMap2;
            }
            str3 = "get sdk appkey is null!";
        }
        com.baidu.crabsdk.lite.b.a.d(str, str3);
        return null;
    }

    public static String f(String str) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdRequestParam.OS, "android");
            jSONObject.put("uid", r.c(str));
            String str2 = null;
            HashMap<String, Object> hashMap = com.baidu.crabsdk.lite.a.f4862a.get(str);
            if (hashMap != null && (obj = hashMap.get("sdk_appvn")) != null) {
                str2 = (String) obj;
            }
            if (str2 == null) {
                str2 = n.d();
            }
            jSONObject.put("appVN", str2);
            jSONObject.put("channel", com.baidu.crabsdk.lite.a.d.a(str));
            Object obj2 = hashMap.get("sdk_appkey");
            if (obj2 != null) {
                jSONObject.put(PushClientConstants.TAG_PKG_NAME, (String) obj2);
            }
            jSONObject.put("sdkVN", "2.2.1");
            jSONObject.put("ndkVN", CrabLite.f4860b);
            jSONObject.put("appUsedCount", String.valueOf(l.d(str)));
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
