package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class StatService implements NoProguard {
    public static final String AUTO_STATISTIC = "auto_statistic";
    public static final String STAT_ENENT_QR_LOGIN_ENTER = "qrlogin_enter";
    public static final String TAG = "StatService";
    public static final Map<String, String> commonParams;
    public static List<String> delayRequestName;

    static {
        HashMap hashMap = new HashMap();
        commonParams = hashMap;
        hashMap.put("pid", "111");
        commonParams.put("type", SmartLaunchStats.UBC_START_LAUNCH_ID);
        commonParams.put(Config.DEVICE_PART, "android");
        ArrayList arrayList = new ArrayList();
        delayRequestName = arrayList;
        arrayList.add("share_read");
        delayRequestName.add("share_silent_account");
        delayRequestName.add("share_silent_account_success");
        delayRequestName.add("load_login");
        delayRequestName.add("share_account_open");
        delayRequestName.add("pass_sdk_init");
    }

    public static boolean isSearchBox() {
        try {
            Class.forName("com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getEventTypeBase64Value(String str) {
        return "{eventType:" + str + "}";
    }

    public static void onEventAutoStat(String str) {
        onEventAutoStat(str, null);
    }

    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap) {
        onEventAutoStatistic(linkedHashMap, null);
    }

    public static void sendRequest(HttpHashMapWrap httpHashMapWrap) {
        new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.utils.StatService.2
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
            }
        });
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            final HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.putAll(commonParams);
            httpHashMapWrap.put("name", str);
            httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        httpHashMapWrap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (delayRequestName.contains(str) && isSearchBox()) {
                NetworkRequestScheduler.execute(new Runnable() { // from class: com.baidu.sapi2.utils.StatService.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StatService.sendRequest(HttpHashMapWrap.this);
                    }
                }, "pass_sdk_".concat(str), 60000L, false);
                return;
            }
            sendRequest(httpHashMapWrap);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static void onEventAutoStat(String str, Map<String, String> map) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String encodeToString = Base64.encodeToString(getEventTypeBase64Value(str).getBytes(), 0);
        if (!TextUtils.isEmpty(encodeToString) && encodeToString.endsWith("\n")) {
            encodeToString = encodeToString.replace("\n", "");
        }
        httpHashMapWrap.put("auto_statistic", encodeToString);
        httpHashMapWrap.putAll(commonParams);
        httpHashMapWrap.put("source", "native");
        httpHashMapWrap.put("data_source", "client");
        httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        if (map != null) {
            for (String str2 : map.keySet()) {
                httpHashMapWrap.put(str2, map.get(str2));
            }
        }
        try {
            sendRequest(httpHashMapWrap);
        } catch (Exception unused) {
        }
    }

    @TargetApi(8)
    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String str : linkedHashMap.keySet()) {
            sb.append(str);
            sb.append(":");
            sb.append(linkedHashMap.get(str));
            sb.append(",");
        }
        int lastIndexOf = sb.lastIndexOf(",");
        if (lastIndexOf > 0) {
            sb = new StringBuilder(sb.substring(0, lastIndexOf));
        }
        sb.append("}");
        Log.d(TAG, "onEventAutoStatistic content=" + sb.toString());
        map.put("auto_statistic", Base64.encodeToString(sb.toString().getBytes(), 0));
        map.put("source", "native");
        map.put("data_source", "client");
        onEvent("auto_statistic", map);
    }
}
