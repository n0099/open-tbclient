package com.baidu.sapi2.utils;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class StatService {
    private static final String a = "https://nsclick.baidu.com/v.gif";
    private static final Map<String, String> b = new HashMap();

    private StatService() {
    }

    static {
        b.put(Info.kBaiduPIDKey, "111");
        b.put("type", "1023");
        b.put("device", "android");
    }

    public static void onEvent(StatEvent statEvent) {
        if (statEvent != null && !TextUtils.isEmpty(statEvent.a)) {
            HashMap hashMap = new HashMap();
            hashMap.put("di", e.b(statEvent.b));
            a(statEvent.a, hashMap);
        }
    }

    public static void a(String str, Map<String, String> map) {
        a(str, map, true);
    }

    public static void a(final String str, Map<String, String> map, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                final SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
                if (z) {
                    com.baidu.sapi2.c.a(sapiConfiguration.context).a(str, map);
                }
                if (SapiUtils.hasActiveNetwork(sapiConfiguration.context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(b);
                    hashMap.put("name", str);
                    hashMap.put("tpl", sapiConfiguration.tpl);
                    hashMap.put("clientfrom", "mobilesdk_enhanced");
                    hashMap.put(Constants.EXTRA_KEY_APP_VERSION, SapiUtils.getVersionName(sapiConfiguration.context));
                    hashMap.put("sdk_version", SapiAccountManager.VERSION_NAME);
                    if (!TextUtils.isEmpty(sapiConfiguration.clientId)) {
                        hashMap.put("cuid", sapiConfiguration.clientId);
                    }
                    hashMap.put("v", String.valueOf(System.currentTimeMillis()));
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    new AsyncHttpClient().get(sapiConfiguration.context, a, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.utils.StatService.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                        public void onSuccess(int i, String str2) {
                            com.baidu.sapi2.c.a(sapiConfiguration.context).g(str);
                        }
                    });
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    public static void a() {
        try {
            for (Map.Entry<String, Map<String, String>> entry : com.baidu.sapi2.c.a(SapiAccountManager.getInstance().getSapiConfiguration().context).u().entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            L.e(th);
        }
    }
}
