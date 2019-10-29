package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class StatService {
    public static final String STAT_ENENT_QR_LOGIN_ENTER = "qrlogin_enter";
    private static final Map<String, String> a = new HashMap();
    private static List<String> b;

    static {
        a.put("pid", "111");
        a.put("type", "1023");
        a.put(Config.DEVICE_PART, Build.MODEL);
        b = new ArrayList();
        b.add("share_read");
        b.add("share_silent_account");
        b.add("share_silent_account_success");
        b.add("load_login");
        b.add("share_account_open");
        b.add("pass_sdk_init");
    }

    public static void onEvent(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                final HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.putAll(a);
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
                if (b.contains(str) && a()) {
                    NetworkRequestScheduler.execute(new Runnable() { // from class: com.baidu.sapi2.utils.StatService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            StatService.b(HttpHashMapWrap.this);
                        }
                    }, "pass_sdk_".concat(str), 60000L, false);
                    return;
                }
                b(httpHashMapWrap);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(HttpHashMapWrap httpHashMapWrap) {
        new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), httpHashMapWrap, null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.utils.StatService.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
            }
        });
    }

    private static boolean a() {
        try {
            Class.forName("com.baidu.searchbox.performance.speed.launcher.NetworkRequestScheduler");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void onEventAutoStatistic(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("name", str);
        onEventAutoStatistic(linkedHashMap);
    }

    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap) {
        onEventAutoStatistic(linkedHashMap, null);
    }

    @TargetApi(8)
    public static void onEventAutoStatistic(LinkedHashMap<String, String> linkedHashMap, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String str : linkedHashMap.keySet()) {
            sb.append(str).append(":").append(linkedHashMap.get(str));
        }
        sb.append("}");
        map.put("auto_statistic", Base64.encodeToString(sb.toString().getBytes(), 0));
        map.put("source", "native");
        map.put("data_source", "client");
        onEvent("auto_statistic", map);
    }
}
