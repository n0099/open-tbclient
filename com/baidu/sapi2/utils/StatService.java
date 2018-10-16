package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class StatService {
    public static final String STAT_ENENT_QR_LOGIN_ENTER = "qrlogin_enter";
    private static final Map<String, String> a = new HashMap();

    private StatService() {
    }

    static {
        a.put(Info.kBaiduPIDKey, "111");
        a.put("type", "1023");
        a.put(Config.DEVICE_PART, HttpConstants.OS_TYPE_VALUE);
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
        onEvent(str, map, true);
    }

    public static void onEvent(String str, Map<String, String> map, boolean z) {
        onEvent(str, String.valueOf(System.currentTimeMillis()), map, z, false);
    }

    public static void onEvent(final String str, final String str2, Map<String, String> map, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                final SapiConfiguration confignation = isAccountManager.getConfignation();
                if (z && !z2) {
                    map.put("v", str2);
                    SapiContext.getInstance(confignation.context).addStatItemV2(str, str2, map);
                }
                if (SapiUtils.hasActiveNetwork(confignation.context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(a);
                    hashMap.put("name", str);
                    hashMap.put(Config.DEVICE_PART, Build.MODEL);
                    hashMap.put(BaiduRimConstants.TPL_INIT_KEY, confignation.tpl);
                    hashMap.put("clientfrom", "mobilesdk_enhanced");
                    hashMap.put("app_version", SapiUtils.getVersionName(confignation.context));
                    hashMap.put(SapiContext.KEY_SDK_VERSION, isAccountManager.getVersionName());
                    if (!TextUtils.isEmpty(confignation.clientId)) {
                        hashMap.put("cuid", confignation.clientId);
                    }
                    if (!z2) {
                        hashMap.put("v", str2);
                    }
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    new AsyncHttpClient().get(confignation.context, SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.utils.StatService.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                        public void onSuccess(int i, String str3) {
                            SapiContext.getInstance(confignation.context).removeStatItemV2(str, str2);
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

    public static void replay() {
        try {
            SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
            Map<String, Map<String, String>> statItemsV1 = SapiContext.getInstance(confignation.context).getStatItemsV1();
            if (!statItemsV1.isEmpty()) {
                for (Map.Entry<String, Map<String, String>> entry : statItemsV1.entrySet()) {
                    onEvent(entry.getKey(), String.valueOf(System.currentTimeMillis()), entry.getValue(), true, true);
                }
                SapiContext.getInstance(confignation.context).clearStatItemV1();
            }
            for (StatModel statModel : SapiContext.getInstance(confignation.context).getStatItemsV2()) {
                onEvent(statModel.name, statModel.time, statModel.extraMap, true, true);
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    /* loaded from: classes.dex */
    public static class StatModel {
        public static final String KEY_MAP = "map";
        public static final String KEY_NAME = "name";
        public static final String KEY_TIME = "time";
        public Map<String, String> extraMap;
        public String name;
        public String time;

        public StatModel(String str, String str2, Map<String, String> map) {
            this.extraMap = new HashMap();
            this.name = str;
            this.time = str2;
            this.extraMap = map;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.name);
                jSONObject.put("time", this.time);
                jSONObject.put("map", new JSONObject(this.extraMap));
            } catch (JSONException e) {
            }
            return jSONObject;
        }

        public static StatModel fromJsonObject(JSONObject jSONObject) {
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString("time");
            HashMap hashMap = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject("map");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString3 = optJSONObject.optString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString3)) {
                        hashMap.put(next, optString3);
                    }
                }
            }
            if (TextUtils.isEmpty(optString) || hashMap.isEmpty()) {
                return null;
            }
            return new StatModel(optString, optString2, hashMap);
        }
    }
}
