package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.b.t;
import com.baidu.crabsdk.b.u;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.img.effect.FilterImageAction;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes8.dex */
public final class g {
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
            com.baidu.crabsdk.c.a.cj("agent is " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> a(Context context, Throwable th, boolean z) {
        Map<String, Object> at = at(context);
        if (com.baidu.crabsdk.a.q) {
            com.baidu.crabsdk.c.a.cj("SEND_PRIVACYINFORMATION true");
            at = a(at, context, z);
        }
        try {
            return a(at, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("createCrashRecord fail.", e);
            return at;
        }
    }

    public static Map<String, Object> a(Throwable th, Context context) {
        if (context == null) {
            com.baidu.crabsdk.c.a.w("null context in createCatchedExceptionRecord");
        }
        Map<String, Object> at = at(context);
        at.put("apiType", "Exception");
        if (com.baidu.crabsdk.a.q) {
            at = a(at, context, false);
        }
        try {
            at = a(at, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.v("createCrashRecord fail." + e);
        }
        at.put("type", at.get("errorType"));
        at.put("apiType", "Exception");
        return at;
    }

    private static Map<String, Object> a(Map<String, Object> map, Context context, boolean z) {
        try {
            if (z) {
                map.put("screenshot", new byte[0]);
            } else if (com.baidu.crabsdk.a.m) {
                byte[] og = com.baidu.crabsdk.b.a.og();
                com.baidu.crabsdk.c.a.v("截图大小：" + (og.length / 1024) + "KB");
                map.put("screenshot", og);
            } else {
                map.put("screenshot", new byte[0]);
            }
            map.put("myAppCPUStat", com.baidu.crabsdk.b.e.x());
            map.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("createRecord fail.", e);
        }
        return map;
    }

    private static Map<String, Object> a(Map<String, Object> map, Throwable th) {
        if (th != null) {
            map.put("errorType", th.getClass().getName());
            String h = com.baidu.crabsdk.c.c.h(th);
            map.put("errorLine", h);
            com.baidu.crabsdk.c.a.cj("errorLine: " + h);
            String i = com.baidu.crabsdk.c.c.i(th);
            map.put("errorOriLine", i);
            com.baidu.crabsdk.c.a.cj("errorOriLine: " + i);
            map.put("errorTrace", Log.getStackTraceString(th));
        }
        return map;
    }

    private static Map<String, Object> at(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", com.baidu.crabsdk.a.d);
        hashMap.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("memInfo", com.baidu.crabsdk.b.m.E());
        hashMap.put("sysMemInfo", com.baidu.crabsdk.b.m.D());
        hashMap.put("pageHistory", com.baidu.crabsdk.b.a.q());
        hashMap.put("activitySteps", com.baidu.crabsdk.b.d.w());
        if (u.or()) {
            hashMap.put("urlRecord", u.oq());
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
        hashMap.put("uid", t.on());
        hashMap.put("batVN", "7.5.1");
        hashMap.put("nativeVN", CrabSDK.NDK_VERSION);
        hashMap.put("developerName", com.baidu.crabsdk.a.a);
        hashMap.put("isRoot", Integer.valueOf(com.baidu.crabsdk.b.q.ol()));
        hashMap.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.b.p.oi());
        hashMap.put("appLabel", com.baidu.crabsdk.b.p.oj());
        hashMap.put("appVN", com.baidu.crabsdk.b.p.L());
        hashMap.put("appVC", Integer.valueOf(com.baidu.crabsdk.b.p.ok()));
        hashMap.put("model", Build.MODEL);
        hashMap.put(Constants.PHONE_BRAND, Build.BRAND);
        hashMap.put("os", "Android");
        hashMap.put("osVN", Build.VERSION.RELEASE);
        hashMap.put("osVC", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("startupTime", Long.valueOf(com.baidu.crabsdk.b.a.p()));
        hashMap.put("curPage", com.baidu.crabsdk.b.a.r());
        hashMap.put("locale", com.baidu.crabsdk.b.i.B());
        hashMap.put("allThreadStacks", com.baidu.crabsdk.b.s.om());
        hashMap.put("appCurConfig", com.baidu.crabsdk.b.f.d(context));
        hashMap.put("internalStorageInfo", com.baidu.crabsdk.b.r.O());
        hashMap.put("CUID", com.baidu.crabsdk.b.h.z());
        hashMap.put("channel", com.baidu.crabsdk.a.b);
        hashMap.put("cpuabi", Build.CPU_ABI);
        if (!TextUtils.isEmpty(t.op())) {
            hashMap.put("usersCustom", t.op());
        }
        hashMap.put("batteryRate", com.baidu.crabsdk.b.g.y());
        hashMap.put("procName", CrabSDK.CURRENT_PNAME);
        return hashMap;
    }

    public static JSONObject au(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        jSONObject.put(BdStatsConstant.StatsKey.UNAME, t.getUserName());
        jSONObject.put("uid", t.on());
        jSONObject.put("channel", com.baidu.crabsdk.a.b);
        jSONObject.put("usersCustom", t.op());
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("appVC", com.baidu.crabsdk.b.p.ok());
        jSONObject.put("batVN", "7.5.1");
        jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
        jSONObject.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.b.p.oi());
        jSONObject.put("appLabel", com.baidu.crabsdk.b.p.oj());
        jSONObject.put("appVN", com.baidu.crabsdk.b.p.L());
        jSONObject.put("soLibs", i.cw(context.getApplicationInfo().nativeLibraryDir));
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
        jSONObject.put("isRoot", com.baidu.crabsdk.b.q.ol());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
        jSONObject.put("cpuabi", Build.CPU_ABI);
        jSONObject.put("CUID", com.baidu.crabsdk.b.h.z());
        jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
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
        map.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
        map.put("country", com.baidu.crabsdk.b.i.getCountry());
        map.put("sdkVN", map.get("batVN"));
        map.put("reportOsVN", Build.VERSION.RELEASE);
        map.put("reportAppVN", com.baidu.crabsdk.b.p.L());
        map.put("reportAppVC", Integer.valueOf(com.baidu.crabsdk.b.p.ok()));
        map.put("reportSdkVN", "7.5.1");
        map.put("appName", com.baidu.crabsdk.b.p.oj());
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
        jSONObject.put("uid", t.on());
        jSONObject.put("channel", com.baidu.crabsdk.a.b);
        jSONObject.put("usersCustom", t.op());
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

    public static String ox() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            jSONObject.put("uid", t.on());
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
