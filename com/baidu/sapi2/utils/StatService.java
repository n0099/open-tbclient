package com.baidu.sapi2.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.util.Constants;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class StatService {
    private static final Map<String, String> a = new HashMap();

    private StatService() {
    }

    static {
        a.put(Info.kBaiduPIDKey, "111");
        a.put("type", "1023");
        a.put("device", Constants.OS_TYPE_VALUE);
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

    public static void onEvent(final String str, Map<String, String> map, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
                final SapiConfiguration confignation = isAccountManager.getConfignation();
                if (z) {
                    SapiContext.getInstance(confignation.context).addStatItem(str, map);
                }
                if (SapiUtils.hasActiveNetwork(confignation.context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(a);
                    hashMap.put("name", str);
                    hashMap.put("tpl", confignation.tpl);
                    hashMap.put("clientfrom", "mobilesdk_enhanced");
                    hashMap.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION, SapiUtils.getVersionName(confignation.context));
                    hashMap.put("sdk_version", isAccountManager.getVersionName());
                    if (!TextUtils.isEmpty(confignation.clientId)) {
                        hashMap.put("cuid", confignation.clientId);
                    }
                    hashMap.put(NotifyType.VIBRATE, String.valueOf(System.currentTimeMillis()));
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
                        public void onSuccess(int i, String str2) {
                            SapiContext.getInstance(confignation.context).removeStatItem(str);
                        }
                    });
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public static void replay() {
        try {
            for (Map.Entry<String, Map<String, String>> entry : SapiContext.getInstance(ServiceManager.getInstance().getIsAccountManager().getConfignation().context).getStatItems().entrySet()) {
                onEvent(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            Log.e(th);
        }
    }
}
