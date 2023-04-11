package com.baidu.searchbox.live.video;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b%\u0010\u0007J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0005R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010#\u001a\n \u0017*\u0004\u0018\u00010\"0\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/live/video/InsertLiveUbc;", "", "isSuccess", "", "insertLoadPluginEnd", "(Z)V", "insertLoadPluginStart", "()V", "isRealLive", "", "scheme", "liveItemSelectedLog", "(ZLjava/lang/String;)V", "isSupport", "livePluginSupportLog", "message", "log", "(Ljava/lang/String;)V", "INSERT_LIVE_VALUE_LOAD", "Ljava/lang/String;", "INSERT_LIVE_VALUE_SELECT", "INSERT_LIVE_VALUE_SUPPORT", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "kotlin.jvm.PlatformType", "appInfoService", "Lcom/baidu/searchbox/live/interfaces/service/AppInfoService;", "hasFirstCheck", "Z", "getHasFirstCheck", "()Z", "setHasFirstCheck", "", "loadStartTime", "J", "Lcom/baidu/ubc/UBCManager;", "ubcManager", "Lcom/baidu/ubc/UBCManager;", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class InsertLiveUbc {
    public static String INSERT_LIVE_VALUE_LOAD;
    public static String INSERT_LIVE_VALUE_SELECT;
    public static String INSERT_LIVE_VALUE_SUPPORT;
    public static final AppInfoService appInfoService;
    public static boolean hasFirstCheck;
    public static long loadStartTime;
    public static final InsertLiveUbc INSTANCE = new InsertLiveUbc();
    public static final UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);

    static {
        String str;
        String str2;
        AppInfoService appInfoService2 = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        appInfoService = appInfoService2;
        String str3 = null;
        if (appInfoService2 != null) {
            str = appInfoService2.getLiveAppId();
        } else {
            str = null;
        }
        INSERT_LIVE_VALUE_SUPPORT = Intrinsics.stringPlus(str, "_insert_live_support");
        AppInfoService appInfoService3 = appInfoService;
        if (appInfoService3 != null) {
            str2 = appInfoService3.getLiveAppId();
        } else {
            str2 = null;
        }
        INSERT_LIVE_VALUE_SELECT = Intrinsics.stringPlus(str2, "_insert_live_select");
        AppInfoService appInfoService4 = appInfoService;
        if (appInfoService4 != null) {
            str3 = appInfoService4.getLiveAppId();
        }
        INSERT_LIVE_VALUE_LOAD = Intrinsics.stringPlus(str3, "_insert_live_load");
    }

    public final boolean getHasFirstCheck() {
        return hasFirstCheck;
    }

    public final void insertLoadPluginStart() {
        loadStartTime = SystemClock.elapsedRealtime();
    }

    public final void insertLoadPluginEnd(boolean z) {
        String str;
        if (ubcManager == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - loadStartTime;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("type", "enter_live");
            jSONObject.put("value", INSERT_LIVE_VALUE_LOAD);
            jSONObject.put("source", "bd_video_insert_live");
            JSONObject jSONObject2 = new JSONObject();
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject2.put("result", str);
            jSONObject2.put("elapsed_time", elapsedRealtime);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcManager.onEvent("5153", jSONObject);
        loadStartTime = 0L;
        log("5153 video load plugin " + INSERT_LIVE_VALUE_LOAD + " json= " + jSONObject);
    }

    public final void liveItemSelectedLog(boolean z, String str) {
        String str2;
        if (ubcManager == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("type", "enter_live");
            jSONObject.put("value", INSERT_LIVE_VALUE_SELECT);
            jSONObject.put("source", "bd_video_insert_live");
            JSONObject jSONObject2 = new JSONObject();
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            jSONObject2.put("result", str2);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcManager.onEvent("5153", jSONObject);
        log("5153 video load plugin " + INSERT_LIVE_VALUE_SELECT + " json= " + jSONObject);
    }

    public final void livePluginSupportLog(boolean z, String str) {
        String str2;
        if (hasFirstCheck || ubcManager == null) {
            return;
        }
        hasFirstCheck = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "live");
            jSONObject.put("type", "enter_live");
            jSONObject.put("value", INSERT_LIVE_VALUE_SUPPORT);
            jSONObject.put("source", "bd_video_insert_live");
            JSONObject jSONObject2 = new JSONObject();
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            jSONObject2.put("result", str2);
            jSONObject.put("ext", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubcManager.onEvent("5153", jSONObject);
        log("5153 video load plugin " + INSERT_LIVE_VALUE_SUPPORT + " json= " + jSONObject);
    }

    public final void log(String str) {
        AppInfoService appInfoService2 = appInfoService;
        if (appInfoService2 != null && appInfoService2.isDebug()) {
            Log.d("InsertLiveUbc", str);
        }
    }

    public final void setHasFirstCheck(boolean z) {
        hasFirstCheck = z;
    }
}
