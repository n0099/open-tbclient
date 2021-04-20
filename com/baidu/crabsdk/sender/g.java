package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.b.e;
import com.baidu.crabsdk.b.m;
import com.baidu.crabsdk.b.n;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.b.p;
import com.baidu.crabsdk.b.q;
import com.baidu.crabsdk.b.t;
import com.baidu.crabsdk.b.u;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwai.video.player.KsMediaMeta;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g {
    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdRequestParam.OS, "android");
            jSONObject.put("uid", t.a());
            jSONObject.put("appVN", p.c());
            jSONObject.put("channel", com.baidu.crabsdk.a.f4671b);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.a.f4673d);
            jSONObject.put("sdkVN", "7.5.1");
            jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            jSONObject.put("appUsedCount", String.valueOf(n.b()));
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("batvn", "7.5.1");
            jSONObject.put("appkey", com.baidu.crabsdk.a.f4673d);
            if (TextUtils.isEmpty(str2)) {
                str2 = p.c();
            }
            jSONObject.put("appvn", str2);
            jSONObject.put("apiType", str);
            if (!CrabSDK.NDK_VERSION.equals("-1")) {
                jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            }
            com.baidu.crabsdk.c.a.b("agent is " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> c(Context context, Throwable th, boolean z) {
        Map<String, Object> i = i(context);
        if (com.baidu.crabsdk.a.q) {
            com.baidu.crabsdk.c.a.b("SEND_PRIVACYINFORMATION true");
            e(i, context, z);
        }
        try {
            f(i, th);
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.c.a.a("createCrashRecord fail.", e2);
        }
        return i;
    }

    public static Map<String, Object> d(Throwable th, Context context) {
        if (context == null) {
            com.baidu.crabsdk.c.a.d("null context in createCatchedExceptionRecord");
        }
        Map<String, Object> i = i(context);
        i.put("apiType", "Exception");
        if (com.baidu.crabsdk.a.q) {
            e(i, context, false);
        }
        try {
            f(i, th);
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.c.a.c("createCrashRecord fail." + e2);
        }
        i.put("type", i.get("errorType"));
        i.put("apiType", "Exception");
        return i;
    }

    public static Map<String, Object> e(Map<String, Object> map, Context context, boolean z) {
        try {
            if (z) {
                map.put("screenshot", new byte[0]);
            } else if (com.baidu.crabsdk.a.m) {
                byte[] j = com.baidu.crabsdk.b.a.j();
                com.baidu.crabsdk.c.a.c("截图大小：" + (j.length / 1024) + "KB");
                map.put("screenshot", j);
            } else {
                map.put("screenshot", new byte[0]);
            }
            map.put("myAppCPUStat", e.a());
            map.put("deviceInfo", com.baidu.crabsdk.b.g.b(context));
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.c.a.a("createRecord fail.", e2);
        }
        return map;
    }

    public static Map<String, Object> f(Map<String, Object> map, Throwable th) {
        if (th == null) {
            return map;
        }
        map.put("errorType", th.getClass().getName());
        String g2 = com.baidu.crabsdk.c.c.g(th);
        map.put("errorLine", g2);
        com.baidu.crabsdk.c.a.b("errorLine: " + g2);
        String h2 = com.baidu.crabsdk.c.c.h(th);
        map.put("errorOriLine", h2);
        com.baidu.crabsdk.c.a.b("errorOriLine: " + h2);
        map.put("errorTrace", Log.getStackTraceString(th));
        return map;
    }

    public static JSONObject g(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uname", t.g());
        jSONObject.put("uid", t.a());
        jSONObject.put("channel", com.baidu.crabsdk.a.f4671b);
        jSONObject.put("usersCustom", t.c());
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("phoneTime", j);
        if (z) {
            jSONObject.put("batteryRate", com.baidu.crabsdk.b.g.c());
            jSONObject.put("curPage", com.baidu.crabsdk.b.a.i());
            jSONObject.put("startupTime", com.baidu.crabsdk.b.a.g());
            jSONObject.put("pageHistory", com.baidu.crabsdk.b.a.h());
            jSONObject.put("memInfo", m.b());
        }
        return jSONObject;
    }

    public static void h(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        map.put("did", map.get("CUID"));
        map.put(KsMediaMeta.KSM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.d());
        map.put("country", com.baidu.crabsdk.b.i.c());
        map.put("sdkVN", map.get("batVN"));
        map.put("reportOsVN", Build.VERSION.RELEASE);
        map.put("reportAppVN", p.c());
        map.put("reportAppVC", Integer.valueOf(p.d()));
        map.put("reportSdkVN", "7.5.1");
        map.put("appName", p.b());
        map.put("occurrenceTime", com.baidu.crabsdk.a.C.format(map.get("phoneTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("cpuInfo", map.get("myAppCPUStat"));
        map.put("diskInfo", map.get("internalStorageInfo"));
        map.put("memoryInfo", map.get("memInfo"));
        map.put("SDInfo", com.baidu.crabsdk.b.r.b());
        map.put("netType", o.b());
        map.put("startTime", com.baidu.crabsdk.a.C.format(map.get("startupTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("occurrencePage", map.get("curPage"));
        map.put("pagePath", map.get("pageHistory"));
        map.put("allThreads", map.get("allThreadStacks"));
        map.remove("allThreadStacks");
        map.put("reason", map.get("errorOriLine"));
    }

    public static Map<String, Object> i(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", com.baidu.crabsdk.a.f4673d);
        hashMap.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("memInfo", m.b());
        hashMap.put("sysMemInfo", m.a());
        hashMap.put("pageHistory", com.baidu.crabsdk.b.a.h());
        hashMap.put("activitySteps", com.baidu.crabsdk.b.d.d());
        if (u.b()) {
            hashMap.put("urlRecord", u.a());
        }
        if (com.baidu.crabsdk.c.c.i(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
            hashMap.put("networkInfo", o.a());
        }
        try {
            hashMap.put("logcat", com.baidu.crabsdk.b.k.a());
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.d(e2.getMessage());
        }
        hashMap.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        hashMap.put("uname", t.g());
        hashMap.put("uid", t.a());
        hashMap.put("batVN", "7.5.1");
        hashMap.put("nativeVN", CrabSDK.NDK_VERSION);
        hashMap.put("developerName", com.baidu.crabsdk.a.f4670a);
        hashMap.put("isRoot", Integer.valueOf(q.a()));
        hashMap.put(PushClientConstants.TAG_PKG_NAME, p.a());
        hashMap.put("appLabel", p.b());
        hashMap.put("appVN", p.c());
        hashMap.put("appVC", Integer.valueOf(p.d()));
        hashMap.put("model", Build.MODEL);
        hashMap.put("brand", Build.BRAND);
        hashMap.put(IAdRequestParam.OS, "Android");
        hashMap.put("osVN", Build.VERSION.RELEASE);
        hashMap.put("osVC", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("startupTime", Long.valueOf(com.baidu.crabsdk.b.a.g()));
        hashMap.put("curPage", com.baidu.crabsdk.b.a.i());
        hashMap.put("locale", com.baidu.crabsdk.b.i.b());
        hashMap.put("allThreadStacks", com.baidu.crabsdk.b.s.a());
        hashMap.put("appCurConfig", com.baidu.crabsdk.b.f.a(context));
        hashMap.put("internalStorageInfo", com.baidu.crabsdk.b.r.a());
        hashMap.put("CUID", com.baidu.crabsdk.b.h.c());
        hashMap.put("channel", com.baidu.crabsdk.a.f4671b);
        hashMap.put("cpuabi", Build.CPU_ABI);
        if (!TextUtils.isEmpty(t.c())) {
            hashMap.put("usersCustom", t.c());
        }
        hashMap.put("batteryRate", com.baidu.crabsdk.b.g.c());
        hashMap.put("procName", CrabSDK.CURRENT_PNAME);
        return hashMap;
    }

    public static JSONObject j(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        jSONObject.put("uname", t.g());
        jSONObject.put("uid", t.a());
        jSONObject.put("channel", com.baidu.crabsdk.a.f4671b);
        jSONObject.put("usersCustom", t.c());
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("appVC", p.d());
        jSONObject.put("batVN", "7.5.1");
        jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
        jSONObject.put(PushClientConstants.TAG_PKG_NAME, p.a());
        jSONObject.put("appLabel", p.b());
        jSONObject.put("appVN", p.c());
        jSONObject.put("soLibs", i.m(context.getApplicationInfo().nativeLibraryDir));
        jSONObject.put("procName", CrabSDK.CURRENT_PNAME);
        jSONObject.put(CloudControlRequest.REQUEST_KEY_FILTER, !com.baidu.crabsdk.a.L ? 1 : 2);
        jSONObject.put("appKey", com.baidu.crabsdk.a.f4673d);
        jSONObject.put(IAdRequestParam.OS, "Android");
        jSONObject.put("osVN", Build.VERSION.RELEASE);
        jSONObject.put("osVC", Build.VERSION.SDK_INT);
        jSONObject.put("isRoot", q.a());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("cpuabi", Build.CPU_ABI);
        jSONObject.put("CUID", com.baidu.crabsdk.b.h.c());
        jSONObject.put(KsMediaMeta.KSM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.d());
        jSONObject.put("country", com.baidu.crabsdk.b.i.c());
        jSONObject.put("appCurConfig", com.baidu.crabsdk.b.f.a(context));
        jSONObject.put("sysMemInfo", m.a());
        jSONObject.put("allThreadStacks", "");
        jSONObject.put("internalStorageInfo", com.baidu.crabsdk.b.r.a());
        jSONObject.put("deviceInfo", com.baidu.crabsdk.b.g.b(context));
        jSONObject.put("locale", com.baidu.crabsdk.b.i.b());
        jSONObject.put("networkInfo", o.b());
        return jSONObject;
    }
}
