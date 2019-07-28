package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.crabsdk.CrabSDK;
import com.baidu.crabsdk.b.r;
import com.baidu.crabsdk.b.s;
import com.baidu.crabsdk.b.t;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public final class g {
    public static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("batvn", "7.3.7");
            jSONObject.put("appkey", com.baidu.crabsdk.a.d);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("appvn", str2);
            } else if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                jSONObject.put("appvn", com.baidu.crabsdk.b.o.H());
            } else {
                jSONObject.put("appvn", com.baidu.crabsdk.a.o);
            }
            jSONObject.put("apiType", str);
            if (!CrabSDK.NDK_VERSION.equals(LivenessStat.TYPE_STRING_DEFAULT)) {
                jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            }
            com.baidu.crabsdk.c.a.ch("agent is " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> a(Context context, Throwable th, boolean z) {
        Map<String, Object> at = at(context);
        if (com.baidu.crabsdk.a.q) {
            com.baidu.crabsdk.c.a.ch("SEND_PRIVACYINFORMATION true");
            at = a(at, context, z);
        }
        try {
            return a(at, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.v("createCrashRecord fail." + e);
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
                byte[] ri = com.baidu.crabsdk.b.a.ri();
                com.baidu.crabsdk.c.a.v("截图大小：" + (ri.length / 1024) + "KB");
                map.put("screenshot", ri);
            } else {
                map.put("screenshot", new byte[0]);
            }
            map.put("myAppCPUStat", com.baidu.crabsdk.b.e.u());
            map.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.a("createRecord fail.", e);
        }
        return map;
    }

    private static Map<String, Object> a(Map<String, Object> map, Throwable th) {
        if (th != null) {
            map.put("errorType", th.getClass().getName());
            String f = com.baidu.crabsdk.c.c.f(th);
            map.put("errorLine", f);
            com.baidu.crabsdk.c.a.ch("errorLine: " + f);
            String g = com.baidu.crabsdk.c.c.g(th);
            map.put("errorOriLine", g);
            com.baidu.crabsdk.c.a.ch("errorOriLine: " + g);
            map.put("errorTrace", Log.getStackTraceString(th));
        }
        return map;
    }

    private static Map<String, Object> at(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", com.baidu.crabsdk.a.d);
        hashMap.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("memInfo", com.baidu.crabsdk.b.l.A());
        hashMap.put("sysMemInfo", com.baidu.crabsdk.b.l.z());
        hashMap.put("pageHistory", com.baidu.crabsdk.b.a.p());
        hashMap.put("activitySteps", com.baidu.crabsdk.b.d.t());
        if (t.rn()) {
            hashMap.put("urlRecord", t.P());
        }
        if (com.baidu.crabsdk.c.c.g(context, "android.permission.ACCESS_NETWORK_STATE")) {
            hashMap.put("networkInfo", com.baidu.crabsdk.b.n.D());
        }
        try {
            hashMap.put("logcat", com.baidu.crabsdk.b.j.y());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.w(e.getMessage());
        }
        hashMap.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        hashMap.put("uname", s.getUserName());
        hashMap.put("uid", s.M());
        hashMap.put("batVN", "7.3.7");
        hashMap.put("nativeVN", CrabSDK.NDK_VERSION);
        hashMap.put("developerName", com.baidu.crabsdk.a.a);
        hashMap.put("isRoot", Integer.valueOf(com.baidu.crabsdk.b.p.J()));
        hashMap.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.b.o.F());
        hashMap.put("appLabel", com.baidu.crabsdk.b.o.G());
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            hashMap.put("appVN", com.baidu.crabsdk.b.o.H());
        } else {
            hashMap.put("appVN", com.baidu.crabsdk.a.o);
        }
        hashMap.put("appVC", Integer.valueOf(com.baidu.crabsdk.b.o.I()));
        hashMap.put("model", Build.MODEL);
        hashMap.put(Constants.PHONE_BRAND, Build.BRAND);
        hashMap.put(IXAdRequestInfo.OS, "Android");
        hashMap.put("osVN", Build.VERSION.RELEASE);
        hashMap.put("osVC", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("startupTime", Long.valueOf(com.baidu.crabsdk.b.a.rh()));
        hashMap.put("curPage", com.baidu.crabsdk.b.a.q());
        hashMap.put("locale", com.baidu.crabsdk.b.i.x());
        hashMap.put("allThreadStacks", r.L());
        hashMap.put("appCurConfig", com.baidu.crabsdk.b.f.d(context));
        try {
            str = com.baidu.crabsdk.b.q.rl();
        } catch (Exception e2) {
            str = "N/A";
            e2.printStackTrace();
        }
        hashMap.put("internalStorageInfo", str);
        hashMap.put("CUID", com.baidu.crabsdk.b.h.g(context));
        hashMap.put(LogBuilder.KEY_CHANNEL, com.baidu.crabsdk.a.b);
        hashMap.put("cpuabi", Build.CPU_ABI);
        if (!TextUtils.isEmpty(s.O())) {
            hashMap.put("usersCustom", s.O());
        }
        hashMap.put("batteryRate", com.baidu.crabsdk.b.g.v());
        hashMap.put("procName", CrabSDK.CURRENT_PNAME);
        return hashMap;
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
        map.put("reportAppVN", com.baidu.crabsdk.b.o.H());
        map.put("reportAppVC", Integer.valueOf(com.baidu.crabsdk.b.o.I()));
        map.put("reportSdkVN", "7.3.7");
        map.put("appName", com.baidu.crabsdk.b.o.G());
        map.put("occurrenceTime", com.baidu.crabsdk.a.C.format(map.get("phoneTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("cpuInfo", map.get("myAppCPUStat"));
        map.put("diskInfo", map.get("internalStorageInfo"));
        map.put("memoryInfo", map.get("memInfo"));
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            str = "Total: " + com.baidu.crabsdk.c.c.r(blockCount) + " Used: " + com.baidu.crabsdk.c.c.r(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.r(availableBlocks);
        } catch (Exception e) {
            str = "N/A";
            e.printStackTrace();
        }
        map.put("SDInfo", str);
        map.put("netType", com.baidu.crabsdk.b.n.E());
        map.put("startTime", com.baidu.crabsdk.a.C.format(map.get("startupTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("occurrencePage", map.get("curPage"));
        map.put("pagePath", map.get("pageHistory"));
        map.put("allThreads", map.get("allThreadStacks"));
        map.remove("allThreadStacks");
        map.put("reason", map.get("errorOriLine"));
    }

    public static JSONObject c(Context context, String str, long j) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appKey", com.baidu.crabsdk.a.d);
        jSONObject.put("batVN", "7.3.7");
        jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
        jSONObject.put("developerName", com.baidu.crabsdk.a.a);
        jSONObject.put("isRoot", com.baidu.crabsdk.b.p.J());
        jSONObject.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.b.o.F());
        jSONObject.put("appLabel", com.baidu.crabsdk.b.o.G());
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            jSONObject.put("appVN", com.baidu.crabsdk.b.o.H());
        } else {
            jSONObject.put("appVN", com.baidu.crabsdk.a.o);
        }
        jSONObject.put("appVC", com.baidu.crabsdk.b.o.I());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
        jSONObject.put(IXAdRequestInfo.OS, "Android");
        jSONObject.put("osVN", Build.VERSION.RELEASE);
        jSONObject.put("osVC", Build.VERSION.SDK_INT);
        jSONObject.put("CUID", com.baidu.crabsdk.b.h.g(context));
        jSONObject.put(LogBuilder.KEY_CHANNEL, com.baidu.crabsdk.a.b);
        jSONObject.put("cpuabi", Build.CPU_ABI);
        jSONObject.put("phoneTime", j);
        jSONObject.put("memInfo", "N/A");
        if (com.baidu.crabsdk.c.c.g(context, "android.permission.ACCESS_NETWORK_STATE")) {
            jSONObject.put("networkInfo", com.baidu.crabsdk.b.n.D().trim());
        }
        jSONObject.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        jSONObject.put("uname", s.getUserName());
        jSONObject.put("uid", s.M());
        try {
            str2 = com.baidu.crabsdk.b.q.rl();
        } catch (Exception e) {
            str2 = "N/A";
            e.printStackTrace();
        }
        jSONObject.put("internalStorageInfo", str2);
        if (!TextUtils.isEmpty(s.O())) {
            jSONObject.put("usersCustom", s.O());
        }
        jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.baidu.crabsdk.b.i.getLanguage());
        jSONObject.put("country", com.baidu.crabsdk.b.i.getCountry());
        jSONObject.put("batteryRate", com.baidu.crabsdk.b.g.v());
        jSONObject.put("appCurConfig", com.baidu.crabsdk.b.f.d(context));
        jSONObject.put("locale", com.baidu.crabsdk.b.i.x());
        jSONObject.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("dump", str);
        jSONObject.put("soLibs", i.cv(context.getApplicationInfo().nativeLibraryDir));
        if (com.baidu.crabsdk.a.L) {
            jSONObject.put("filter", 2);
        } else {
            jSONObject.put("filter", 1);
        }
        return jSONObject;
    }

    public static String rt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdRequestInfo.OS, "android");
            jSONObject.put("uid", s.M());
            if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                jSONObject.put("appVN", com.baidu.crabsdk.b.o.H());
            } else {
                jSONObject.put("appVN", com.baidu.crabsdk.a.o);
            }
            jSONObject.put(LogBuilder.KEY_CHANNEL, com.baidu.crabsdk.a.b);
            jSONObject.put(PushClientConstants.TAG_PKG_NAME, com.baidu.crabsdk.a.d);
            jSONObject.put("sdkVN", "7.3.7");
            jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            jSONObject.put("appUsedCount", String.valueOf(com.baidu.crabsdk.b.m.rk()));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
