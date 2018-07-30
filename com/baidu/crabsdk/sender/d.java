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
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class d {
    public static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("batvn", "7.3.0");
            jSONObject.put("appkey", com.baidu.crabsdk.a.d);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("appvn", str2);
            } else if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                jSONObject.put("appvn", o.H());
            } else {
                jSONObject.put("appvn", com.baidu.crabsdk.a.o);
            }
            jSONObject.put("apiType", str);
            if (!CrabSDK.NDK_VERSION.equals("-1")) {
                jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            }
            com.baidu.crabsdk.c.a.ce("agent is " + jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Map<String, Object> a(Context context, Throwable th, boolean z) {
        Map<String, Object> au = au(context);
        if (com.baidu.crabsdk.a.q) {
            com.baidu.crabsdk.c.a.ce("SEND_PRIVACYINFORMATION true");
            au = a(au, context, z);
        }
        try {
            return a(au, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.cg("createCrashRecord fail." + e);
            return au;
        }
    }

    @SuppressLint({"NewApi"})
    public static Map<String, Object> a(Throwable th, Context context) {
        if (context == null) {
            com.baidu.crabsdk.c.a.ch("null context in createCatchedExceptionRecord");
        }
        Map<String, Object> au = au(context);
        au.put("apiType", "Exception");
        if (com.baidu.crabsdk.a.q) {
            au = a(au, context, false);
        }
        try {
            au = a(au, th);
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.cg("createCrashRecord fail." + e);
        }
        au.put("type", au.get("errorType"));
        au.put("apiType", "Exception");
        return au;
    }

    private static Map<String, Object> a(Map<String, Object> map, Context context, boolean z) {
        try {
            if (z) {
                map.put("screenshot", new byte[0]);
            } else if (com.baidu.crabsdk.a.m) {
                byte[] pc = com.baidu.crabsdk.b.a.pc();
                com.baidu.crabsdk.c.a.cg("截图大小：" + (pc.length / 1024) + "KB");
                map.put("screenshot", pc);
            } else {
                map.put("screenshot", new byte[0]);
            }
            map.put("myAppCPUStat", com.baidu.crabsdk.b.e.v());
            map.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        } catch (RuntimeException e) {
            com.baidu.crabsdk.c.a.b("createRecord fail.", e);
        }
        return map;
    }

    private static Map<String, Object> a(Map<String, Object> map, Throwable th) {
        if (th != null) {
            map.put("errorType", th.getClass().getName());
            String c = com.baidu.crabsdk.c.c.c(th);
            map.put("errorLine", c);
            com.baidu.crabsdk.c.a.ce("errorLine: " + c);
            String f = com.baidu.crabsdk.c.c.f(th);
            map.put("errorOriLine", f);
            com.baidu.crabsdk.c.a.ce("errorOriLine: " + f);
            map.put("errorTrace", Log.getStackTraceString(th));
        }
        return map;
    }

    private static Map<String, Object> au(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(WBConstants.SSO_APP_KEY, com.baidu.crabsdk.a.d);
        hashMap.put("phoneTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("memInfo", com.baidu.crabsdk.b.l.B());
        hashMap.put("sysMemInfo", com.baidu.crabsdk.b.l.A());
        hashMap.put("pageHistory", com.baidu.crabsdk.b.a.p());
        hashMap.put("activitySteps", com.baidu.crabsdk.b.d.u());
        if (t.pi()) {
            hashMap.put("urlRecord", t.P());
        }
        if (com.baidu.crabsdk.c.c.g(context, "android.permission.ACCESS_NETWORK_STATE")) {
            hashMap.put("networkInfo", com.baidu.crabsdk.b.n.D());
        }
        try {
            hashMap.put("logcat", com.baidu.crabsdk.b.j.z());
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.ch(e.getMessage());
        }
        hashMap.put("recordId", System.currentTimeMillis() + UUID.randomUUID().toString());
        hashMap.put("uname", s.getUserName());
        hashMap.put("uid", s.M());
        hashMap.put("batVN", "7.3.0");
        hashMap.put("nativeVN", CrabSDK.NDK_VERSION);
        hashMap.put("developerName", com.baidu.crabsdk.a.a);
        hashMap.put("isRoot", Integer.valueOf(p.J()));
        hashMap.put("pkgName", o.F());
        hashMap.put("appLabel", o.G());
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            hashMap.put("appVN", o.H());
        } else {
            hashMap.put("appVN", com.baidu.crabsdk.a.o);
        }
        hashMap.put("appVC", Integer.valueOf(o.pf()));
        hashMap.put("model", Build.MODEL);
        hashMap.put("brand", Build.BRAND);
        hashMap.put("os", "Android");
        hashMap.put("osVN", Build.VERSION.RELEASE);
        hashMap.put("osVC", Integer.valueOf(com.baidu.crabsdk.c.c.pj()));
        hashMap.put("startupTime", Long.valueOf(com.baidu.crabsdk.b.a.pb()));
        hashMap.put("curPage", com.baidu.crabsdk.b.a.q());
        hashMap.put("locale", com.baidu.crabsdk.b.i.y());
        hashMap.put("allThreadStacks", r.L());
        hashMap.put("appCurConfig", com.baidu.crabsdk.b.f.e(context));
        try {
            str = q.pg();
        } catch (Exception e2) {
            str = "N/A";
            e2.printStackTrace();
        }
        hashMap.put("internalStorageInfo", str);
        hashMap.put("CUID", com.baidu.crabsdk.b.h.g(context));
        hashMap.put("channel", com.baidu.crabsdk.a.b);
        hashMap.put("cpuabi", Build.CPU_ABI);
        if (!TextUtils.isEmpty(s.O())) {
            hashMap.put("usersCustom", s.O());
        }
        hashMap.put("batteryRate", com.baidu.crabsdk.b.g.w());
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
        map.put("reportAppVN", o.H());
        map.put("reportAppVC", Integer.valueOf(o.pf()));
        map.put("reportSdkVN", "7.3.0");
        map.put("appName", o.G());
        map.put("occurrenceTime", com.baidu.crabsdk.a.C.format(map.get("phoneTime") != null ? map.get("phoneTime") : Long.valueOf(System.currentTimeMillis())));
        map.put("cpuInfo", map.get("myAppCPUStat"));
        map.put("diskInfo", map.get("internalStorageInfo"));
        map.put("memoryInfo", map.get("memInfo"));
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long availableBlocks = statFs2.getAvailableBlocks() * statFs2.getBlockSize();
            str = "Total: " + com.baidu.crabsdk.c.c.p(blockCount) + " Used: " + com.baidu.crabsdk.c.c.p(blockCount - availableBlocks) + " Free: " + com.baidu.crabsdk.c.c.p(availableBlocks);
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
        jSONObject.put(WBConstants.SSO_APP_KEY, com.baidu.crabsdk.a.d);
        jSONObject.put("batVN", "7.3.0");
        jSONObject.put("nativeVN", CrabSDK.NDK_VERSION);
        jSONObject.put("developerName", com.baidu.crabsdk.a.a);
        jSONObject.put("isRoot", p.J());
        jSONObject.put("pkgName", o.F());
        jSONObject.put("appLabel", o.G());
        if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
            jSONObject.put("appVN", o.H());
        } else {
            jSONObject.put("appVN", com.baidu.crabsdk.a.o);
        }
        jSONObject.put("appVC", o.pf());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("os", "Android");
        jSONObject.put("osVN", Build.VERSION.RELEASE);
        jSONObject.put("osVC", com.baidu.crabsdk.c.c.pj());
        jSONObject.put("CUID", com.baidu.crabsdk.b.h.g(context));
        jSONObject.put("channel", com.baidu.crabsdk.a.b);
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
            str2 = q.pg();
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
        jSONObject.put("batteryRate", com.baidu.crabsdk.b.g.w());
        jSONObject.put("appCurConfig", com.baidu.crabsdk.b.f.e(context));
        jSONObject.put("locale", com.baidu.crabsdk.b.i.y());
        jSONObject.put("deviceInfo", com.baidu.crabsdk.b.g.f(context));
        jSONObject.put("javaLine", "N/A");
        jSONObject.put("errorTrace", "N/A");
        jSONObject.put("dump", str);
        if (!com.baidu.crabsdk.a.L) {
            jSONObject.put("soLibs", f.cq(context.getApplicationInfo().nativeLibraryDir));
        }
        return jSONObject;
    }

    public static String pp() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", HttpConstants.OS_TYPE_VALUE);
            jSONObject.put("uid", s.M());
            if (TextUtils.isEmpty(com.baidu.crabsdk.a.o)) {
                jSONObject.put("appVN", o.H());
            } else {
                jSONObject.put("appVN", com.baidu.crabsdk.a.o);
            }
            jSONObject.put("channel", com.baidu.crabsdk.a.b);
            jSONObject.put("pkgName", com.baidu.crabsdk.a.d);
            jSONObject.put("sdkVN", "7.3.0");
            jSONObject.put("ndkVN", CrabSDK.NDK_VERSION);
            jSONObject.put("appUsedCount", String.valueOf(com.baidu.crabsdk.b.m.pe()));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
