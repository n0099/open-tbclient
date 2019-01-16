package com.baidu.crabsdk.sender;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.b.o;
import com.baidu.crabsdk.b.p;
import com.baidu.crabsdk.b.q;
import com.baidu.crabsdk.b.r;
import com.baidu.crabsdk.b.s;
import com.baidu.crabsdk.b.t;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioPlayer;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes6.dex */
public final class d {
    public static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("batvn", "7.3.4");
            jSONObject.put("appkey", com.baidu.crabsdk.a.d);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("appvn", str2);
            } else if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                jSONObject.put("appvn", o.I());
            } else {
                jSONObject.put("appvn", com.baidu.crabsdk.a.o);
            }
            jSONObject.put("apiType", str);
            if (!CrabSDK.NDK_VERSION.equals(AiAppsAudioPlayer.ERROR_UNKNOWN)) {
                jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            }
            com.baidu.crabsdk.c.a.cH("agent is " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> a(Context context, Throwable th, boolean z) {
        Map<String, Object> bh = bh(context);
        if (com.baidu.crabsdk.a.q) {
            com.baidu.crabsdk.c.a.cH("SEND_PRIVACYINFORMATION true");
            bh = a(bh, context, z);
        }
        try {
            return a(bh, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.cJ("createCrashRecord fail." + e);
            return bh;
        }
    }

    @SuppressLint({"NewApi"})
    public static Map<String, Object> a(Throwable th, Context context) {
        if (context == null) {
            com.baidu.crabsdk.c.a.cK("null context in createCatchedExceptionRecord");
        }
        Map<String, Object> bh = bh(context);
        bh.put("apiType", "Exception");
        if (com.baidu.crabsdk.a.q) {
            bh = a(bh, context, false);
        }
        try {
            bh = a(bh, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.cJ("createCrashRecord fail." + e);
        }
        bh.put("type", bh.get(AiAppsSearchFlowUBC.FE_DATA_ERRTYPE));
        bh.put("apiType", "Exception");
        return bh;
    }

    private static Map<String, Object> a(Map<String, Object> map, Context context, boolean z) {
        try {
            if (z) {
                map.put("screenshot", new byte[0]);
            } else if (com.baidu.crabsdk.a.m) {
                byte[] rq = com.baidu.crabsdk.b.a.rq();
                com.baidu.crabsdk.c.a.cJ("截图大小：" + (rq.length / 1024) + "KB");
                map.put("screenshot", rq);
            } else {
                map.put("screenshot", new byte[0]);
            }
            map.put("myAppCPUStat", com.baidu.crabsdk.b.e.v());
            map.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.f("createRecord fail.", e);
        }
        return map;
    }

    private static Map<String, Object> a(Map<String, Object> map, Throwable th) {
        if (th != null) {
            map.put(AiAppsSearchFlowUBC.FE_DATA_ERRTYPE, th.getClass().getName());
            String g = com.baidu.crabsdk.c.c.g(th);
            map.put("errorLine", g);
            com.baidu.crabsdk.c.a.cH("errorLine: " + g);
            String h = com.baidu.crabsdk.c.c.h(th);
            map.put("errorOriLine", h);
            com.baidu.crabsdk.c.a.cH("errorOriLine: " + h);
            map.put("errorTrace", Log.getStackTraceString(th));
        }
        return map;
    }

    public static void b(Map<String, Object> map) {
        String str;
        if (map == null) {
            return;
        }
        map.put("did", map.get("CUID"));
        map.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
        map.put("country", com.baidu.crabsdk.b.i.getCountry());
        map.put("sdkVN", map.get("batVN"));
        map.put("reportOsVN", Build.VERSION.RELEASE);
        map.put("reportAppVN", o.I());
        map.put("reportAppVC", Integer.valueOf(o.J()));
        map.put("reportSdkVN", "7.3.4");
        map.put("appName", o.H());
        map.put("occurrenceTime", com.baidu.crabsdk.a.C.format(map.get("phoneTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("cpuInfo", map.get("myAppCPUStat"));
        map.put("diskInfo", map.get("internalStorageInfo"));
        map.put("memoryInfo", map.get("memInfo"));
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            str = "Total: " + com.baidu.crabsdk.c.c.k(blockCount) + " Used: " + com.baidu.crabsdk.c.c.k(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.k(availableBlocks);
        } catch (Exception e) {
            str = "N/A";
            e.printStackTrace();
        }
        map.put("SDInfo", str);
        map.put("netType", com.baidu.crabsdk.b.n.F());
        map.put("startTime", com.baidu.crabsdk.a.C.format(map.get("startupTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("occurrencePage", map.get("curPage"));
        map.put("pagePath", map.get("pageHistory"));
        map.put("allThreads", map.get("allThreadStacks"));
        map.remove("allThreadStacks");
        map.put(WebSocketAction.PARAM_KEY_REASON, map.get("errorOriLine"));
    }

    private static Map<String, Object> bh(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(WBConstants.SSO_APP_KEY, com.baidu.crabsdk.a.d);
        hashMap.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("memInfo", com.baidu.crabsdk.b.l.B());
        hashMap.put("sysMemInfo", com.baidu.crabsdk.b.l.A());
        hashMap.put("pageHistory", com.baidu.crabsdk.b.a.p());
        hashMap.put("activitySteps", com.baidu.crabsdk.b.d.u());
        if (t.R()) {
            hashMap.put("urlRecord", t.ru());
        }
        if (com.baidu.crabsdk.c.c.g(context, "android.permission.ACCESS_NETWORK_STATE")) {
            hashMap.put("networkInfo", com.baidu.crabsdk.b.n.E());
        }
        try {
            hashMap.put("logcat", com.baidu.crabsdk.b.j.z());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.cK(e.getMessage());
        }
        hashMap.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        hashMap.put("uname", s.getUserName());
        hashMap.put("uid", s.N());
        hashMap.put("batVN", "7.3.4");
        hashMap.put("nativeVN", CrabSDK.NDK_VERSION);
        hashMap.put("developerName", com.baidu.crabsdk.a.a);
        hashMap.put("isRoot", Integer.valueOf(p.rs()));
        hashMap.put("pkgName", o.G());
        hashMap.put("appLabel", o.H());
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            hashMap.put("appVN", o.I());
        } else {
            hashMap.put("appVN", com.baidu.crabsdk.a.o);
        }
        hashMap.put("appVC", Integer.valueOf(o.J()));
        hashMap.put("model", Build.MODEL);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("os", "Android");
        hashMap.put("osVN", Build.VERSION.RELEASE);
        hashMap.put("osVC", Integer.valueOf(com.baidu.crabsdk.c.c.rv()));
        hashMap.put("startupTime", Long.valueOf(com.baidu.crabsdk.b.a.rp()));
        hashMap.put("curPage", com.baidu.crabsdk.b.a.q());
        hashMap.put("locale", com.baidu.crabsdk.b.i.y());
        hashMap.put("allThreadStacks", r.M());
        hashMap.put("appCurConfig", com.baidu.crabsdk.b.f.e(context));
        try {
            str = q.L();
        } catch (Exception e2) {
            str = "N/A";
            e2.printStackTrace();
        }
        hashMap.put("internalStorageInfo", str);
        hashMap.put("CUID", com.baidu.crabsdk.b.h.g(context));
        hashMap.put("channel", com.baidu.crabsdk.a.b);
        hashMap.put("cpuabi", Build.CPU_ABI);
        if (!TextUtils.isEmpty(s.P())) {
            hashMap.put("usersCustom", s.P());
        }
        hashMap.put("batteryRate", com.baidu.crabsdk.b.g.w());
        return hashMap;
    }

    public static JSONObject f(Context context, String str, long j) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WBConstants.SSO_APP_KEY, com.baidu.crabsdk.a.d);
        jSONObject.put("batVN", "7.3.4");
        jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
        jSONObject.put("developerName", com.baidu.crabsdk.a.a);
        jSONObject.put("isRoot", p.rs());
        jSONObject.put("pkgName", o.G());
        jSONObject.put("appLabel", o.H());
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            jSONObject.put("appVN", o.I());
        } else {
            jSONObject.put("appVN", com.baidu.crabsdk.a.o);
        }
        jSONObject.put("appVC", o.J());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("os", "Android");
        jSONObject.put("osVN", Build.VERSION.RELEASE);
        jSONObject.put("osVC", com.baidu.crabsdk.c.c.rv());
        jSONObject.put("CUID", com.baidu.crabsdk.b.h.g(context));
        jSONObject.put("channel", com.baidu.crabsdk.a.b);
        jSONObject.put("cpuabi", Build.CPU_ABI);
        jSONObject.put("phoneTime", j);
        jSONObject.put("memInfo", "N/A");
        if (com.baidu.crabsdk.c.c.g(context, "android.permission.ACCESS_NETWORK_STATE")) {
            jSONObject.put("networkInfo", com.baidu.crabsdk.b.n.E().trim());
        }
        jSONObject.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        jSONObject.put("uname", s.getUserName());
        jSONObject.put("uid", s.N());
        try {
            str2 = q.L();
        } catch (Exception e) {
            str2 = "N/A";
            e.printStackTrace();
        }
        jSONObject.put("internalStorageInfo", str2);
        if (!TextUtils.isEmpty(s.P())) {
            jSONObject.put("usersCustom", s.P());
        }
        jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
        jSONObject.put("country", com.baidu.crabsdk.b.i.getCountry());
        jSONObject.put("batteryRate", com.baidu.crabsdk.b.g.w());
        jSONObject.put("appCurConfig", com.baidu.crabsdk.b.f.e(context));
        jSONObject.put("locale", com.baidu.crabsdk.b.i.y());
        jSONObject.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("dump", str);
        jSONObject.put("soLibs", f.cS(context.getApplicationInfo().nativeLibraryDir));
        if (com.baidu.crabsdk.a.L) {
            jSONObject.put("filter", 2);
        } else {
            jSONObject.put("filter", 1);
        }
        return jSONObject;
    }

    public static String rA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", HttpConstants.OS_TYPE_VALUE);
            jSONObject.put("uid", s.N());
            if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                jSONObject.put("appVN", o.I());
            } else {
                jSONObject.put("appVN", com.baidu.crabsdk.a.o);
            }
            jSONObject.put("channel", com.baidu.crabsdk.a.b);
            jSONObject.put("pkgName", com.baidu.crabsdk.a.d);
            jSONObject.put("sdkVN", "7.3.4");
            jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            jSONObject.put("appUsedCount", String.valueOf(com.baidu.crabsdk.b.m.D()));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
