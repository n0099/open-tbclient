package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.appsearchlib.Info;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class StatService {
    public static final String STAT_ENENT_QR_LOGIN_ENTER = "qrlogin_enter";
    private static final Map<String, String> a = new HashMap();

    private StatService() {
    }

    static {
        a.put(Info.kBaiduPIDKey, "111");
        a.put("type", "1023");
        a.put("device", "android");
    }

    public static void onEvent(StatEvent statEvent) {
        if (statEvent != null && !TextUtils.isEmpty(statEvent.a)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo(statEvent.b));
            hashMap.put("pis_di", SapiDeviceInfo.getPisDeviceInfo());
            onEvent(statEvent.a, hashMap);
        }
    }

    public static void onEvent(String str, Map<String, String> map) {
        onEvent(str, map, false);
    }

    public static void onEvent(String str, Map<String, String> map, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                SapiConfiguration confignation = isAccountManager.getConfignation();
                if (SapiUtils.hasActiveNetwork(confignation.context)) {
                    HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                    httpHashMapWrap.putAll(a);
                    httpHashMapWrap.put("name", str);
                    httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
                    httpHashMapWrap.put("device", Build.MODEL);
                    httpHashMapWrap.put("tpl", confignation.tpl);
                    httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
                    httpHashMapWrap.put(Constants.EXTRA_KEY_APP_VERSION, SapiUtils.getVersionName(confignation.context));
                    httpHashMapWrap.put(SapiContext.KEY_SDK_VERSION, isAccountManager.getVersionName());
                    if (!TextUtils.isEmpty(confignation.clientId)) {
                        httpHashMapWrap.put("cuid", confignation.clientId);
                    }
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                                httpHashMapWrap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), httpHashMapWrap, null, null, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.utils.StatService.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                        public void onSuccess(int i, String str2) {
                        }
                    });
                }
            } catch (Throwable th) {
                Log.e(th);
            }
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
            sb.append(str).append(":").append(linkedHashMap.get(str));
        }
        sb.append("}");
        map.put("auto_statistic", Base64.encodeToString(sb.toString().getBytes(), 0));
        map.put("source", "native");
        map.put("data_source", "client");
        onEvent("auto_statistic", map);
    }
}
