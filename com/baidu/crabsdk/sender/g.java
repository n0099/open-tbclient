package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.b.t;
import com.baidu.crabsdk.b.u;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public final class g {
    private static Map<String, Object> Z(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", com.baidu.crabsdk.a.d);
        hashMap.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("memInfo", com.baidu.crabsdk.b.m.E());
        hashMap.put("sysMemInfo", com.baidu.crabsdk.b.m.D());
        hashMap.put("pageHistory", com.baidu.crabsdk.b.a.q());
        hashMap.put("activitySteps", com.baidu.crabsdk.b.d.w());
        if (u.tn()) {
            hashMap.put("urlRecord", u.tm());
        }
        if (com.baidu.crabsdk.c.c.g(context, "android.permission.ACCESS_NETWORK_STATE")) {
            hashMap.put("networkInfo", com.baidu.crabsdk.b.o.H());
        }
        try {
            hashMap.put("logcat", com.baidu.crabsdk.b.k.C());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w(e.getMessage());
        }
        hashMap.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        hashMap.put(BdStatsConstant.StatsKey.UNAME, t.getUserName());
        hashMap.put("uid", t.R());
        hashMap.put("batVN", "7.5.1");
        hashMap.put("nativeVN", CrabSDK.NDK_VERSION);
        hashMap.put("developerName", com.baidu.crabsdk.a.a);
        hashMap.put("isRoot", Integer.valueOf(com.baidu.crabsdk.b.q.tk()));
        hashMap.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.b.p.ti());
        hashMap.put("appLabel", com.baidu.crabsdk.b.p.tj());
        hashMap.put("appVN", com.baidu.crabsdk.b.p.L());
        hashMap.put("appVC", Integer.valueOf(com.baidu.crabsdk.b.p.M()));
        hashMap.put("model", Build.MODEL);
        hashMap.put(Constants.PHONE_BRAND, Build.BRAND);
        hashMap.put("os", "Android");
        hashMap.put("osVN", Build.VERSION.RELEASE);
        hashMap.put("osVC", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("startupTime", Long.valueOf(com.baidu.crabsdk.b.a.p()));
        hashMap.put("curPage", com.baidu.crabsdk.b.a.r());
        hashMap.put("locale", com.baidu.crabsdk.b.i.B());
        hashMap.put("allThreadStacks", com.baidu.crabsdk.b.s.Q());
        hashMap.put("appCurConfig", com.baidu.crabsdk.b.f.d(context));
        hashMap.put("internalStorageInfo", com.baidu.crabsdk.b.r.O());
        hashMap.put("CUID", com.baidu.crabsdk.b.h.z());
        hashMap.put("channel", com.baidu.crabsdk.a.b);
        hashMap.put("cpuabi", Build.CPU_ABI);
        if (!TextUtils.isEmpty(t.T())) {
            hashMap.put("usersCustom", t.T());
        }
        hashMap.put("batteryRate", com.baidu.crabsdk.b.g.y());
        hashMap.put("procName", CrabSDK.CURRENT_PNAME);
        return hashMap;
    }

    public static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("batvn", "7.5.1");
            jSONObject.put("appkey", com.baidu.crabsdk.a.d);
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put("appvn", com.baidu.crabsdk.b.p.L());
            } else {
                jSONObject.put("appvn", str2);
            }
            jSONObject.put("apiType", str);
            if (!CrabSDK.NDK_VERSION.equals("-1")) {
                jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            }
            com.baidu.crabsdk.c.a.dh("agent is " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> a(Context context, Throwable th, boolean z) {
        Map<String, Object> Z = Z(context);
        if (com.baidu.crabsdk.a.q) {
            com.baidu.crabsdk.c.a.dh("SEND_PRIVACYINFORMATION true");
            Z = a(Z, context, z);
        }
        try {
            return a(Z, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("createCrashRecord fail.", e);
            return Z;
        }
    }

    public static Map<String, Object> a(Throwable th, Context context) {
        if (context == null) {
            com.baidu.crabsdk.c.a.w("null context in createCatchedExceptionRecord");
        }
        Map<String, Object> Z = Z(context);
        Z.put("apiType", "Exception");
        if (com.baidu.crabsdk.a.q) {
            Z = a(Z, context, false);
        }
        try {
            Z = a(Z, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.v("createCrashRecord fail." + e);
        }
        Z.put("type", Z.get("errorType"));
        Z.put("apiType", "Exception");
        return Z;
    }

    private static Map<String, Object> a(Map<String, Object> map, Context context, boolean z) {
        try {
            if (z) {
                map.put(StatisticConstants.SCREENSHOT, new byte[0]);
            } else if (com.baidu.crabsdk.a.m) {
                byte[] tg = com.baidu.crabsdk.b.a.tg();
                com.baidu.crabsdk.c.a.v("截图大小：" + (tg.length / 1024) + "KB");
                map.put(StatisticConstants.SCREENSHOT, tg);
            } else {
                map.put(StatisticConstants.SCREENSHOT, new byte[0]);
            }
            map.put("myAppCPUStat", com.baidu.crabsdk.b.e.x());
            map.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("createRecord fail.", e);
        }
        return map;
    }

    private static Map<String, Object> a(Map<String, Object> map, Throwable th) {
        if (th != null) {
            map.put("errorType", th.getClass().getName());
            String h = com.baidu.crabsdk.c.c.h(th);
            map.put("errorLine", h);
            com.baidu.crabsdk.c.a.dh("errorLine: " + h);
            String i = com.baidu.crabsdk.c.c.i(th);
            map.put("errorOriLine", i);
            com.baidu.crabsdk.c.a.dh("errorOriLine: " + i);
            map.put("errorTrace", Log.getStackTraceString(th));
        }
        return map;
    }

    public static JSONObject aa(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        jSONObject.put(BdStatsConstant.StatsKey.UNAME, t.getUserName());
        jSONObject.put("uid", t.R());
        jSONObject.put("channel", com.baidu.crabsdk.a.b);
        jSONObject.put("usersCustom", t.T());
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("appVC", com.baidu.crabsdk.b.p.M());
        jSONObject.put("batVN", "7.5.1");
        jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
        jSONObject.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.b.p.ti());
        jSONObject.put("appLabel", com.baidu.crabsdk.b.p.tj());
        jSONObject.put("appVN", com.baidu.crabsdk.b.p.L());
        jSONObject.put("soLibs", i.dx(context.getApplicationInfo().nativeLibraryDir));
        jSONObject.put("procName", CrabSDK.CURRENT_PNAME);
        if (com.baidu.crabsdk.a.L) {
            jSONObject.put(FilterImageAction.ACTION_NAME, 2);
        } else {
            jSONObject.put(FilterImageAction.ACTION_NAME, 1);
        }
        jSONObject.put("appKey", com.baidu.crabsdk.a.d);
        jSONObject.put("os", "Android");
        jSONObject.put("osVN", Build.VERSION.RELEASE);
        jSONObject.put("osVC", Build.VERSION.SDK_INT);
        jSONObject.put("isRoot", com.baidu.crabsdk.b.q.tk());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
        jSONObject.put("cpuabi", Build.CPU_ABI);
        jSONObject.put("CUID", com.baidu.crabsdk.b.h.z());
        jSONObject.put("language", com.baidu.crabsdk.b.i.getLanguage());
        jSONObject.put("country", com.baidu.crabsdk.b.i.getCountry());
        jSONObject.put("appCurConfig", com.baidu.crabsdk.b.f.d(context));
        jSONObject.put("sysMemInfo", com.baidu.crabsdk.b.m.D());
        jSONObject.put("allThreadStacks", "");
        jSONObject.put("internalStorageInfo", com.baidu.crabsdk.b.r.O());
        jSONObject.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        jSONObject.put("locale", com.baidu.crabsdk.b.i.B());
        jSONObject.put("networkInfo", com.baidu.crabsdk.b.o.I());
        return jSONObject;
    }

    public static void b(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        map.put("did", map.get("CUID"));
        map.put("language", com.baidu.crabsdk.b.i.getLanguage());
        map.put("country", com.baidu.crabsdk.b.i.getCountry());
        map.put("sdkVN", map.get("batVN"));
        map.put("reportOsVN", Build.VERSION.RELEASE);
        map.put("reportAppVN", com.baidu.crabsdk.b.p.L());
        map.put("reportAppVC", Integer.valueOf(com.baidu.crabsdk.b.p.M()));
        map.put("reportSdkVN", "7.5.1");
        map.put("appName", com.baidu.crabsdk.b.p.tj());
        map.put("occurrenceTime", com.baidu.crabsdk.a.C.format(map.get("phoneTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("cpuInfo", map.get("myAppCPUStat"));
        map.put("diskInfo", map.get("internalStorageInfo"));
        map.put("memoryInfo", map.get("memInfo"));
        map.put("SDInfo", com.baidu.crabsdk.b.r.P());
        map.put("netType", com.baidu.crabsdk.b.o.I());
        map.put("startTime", com.baidu.crabsdk.a.C.format(map.get("startupTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("occurrencePage", map.get("curPage"));
        map.put("pagePath", map.get("pageHistory"));
        map.put("allThreads", map.get("allThreadStacks"));
        map.remove("allThreadStacks");
        map.put(TiebaInitialize.LogFields.REASON, map.get("errorOriLine"));
    }

    public static JSONObject c(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(BdStatsConstant.StatsKey.UNAME, t.getUserName());
        jSONObject.put("uid", t.R());
        jSONObject.put("channel", com.baidu.crabsdk.a.b);
        jSONObject.put("usersCustom", t.T());
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("phoneTime", j);
        if (z) {
            jSONObject.put("batteryRate", com.baidu.crabsdk.b.g.y());
            jSONObject.put("curPage", com.baidu.crabsdk.b.a.r());
            jSONObject.put("startupTime", com.baidu.crabsdk.b.a.p());
            jSONObject.put("pageHistory", com.baidu.crabsdk.b.a.q());
            jSONObject.put("memInfo", com.baidu.crabsdk.b.m.E());
        }
        return jSONObject;
    }

    public static String tu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", "android");
            jSONObject.put("uid", t.R());
            jSONObject.put("appVN", com.baidu.crabsdk.b.p.L());
            jSONObject.put("channel", com.baidu.crabsdk.a.b);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.a.d);
            jSONObject.put("sdkVN", "7.5.1");
            jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            jSONObject.put("appUsedCount", String.valueOf(com.baidu.crabsdk.b.n.G()));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
