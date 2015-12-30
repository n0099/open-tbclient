package com.baidu.sapi2.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class StatService {
    private static final String a = "http://nsclick.baidu.com/v.gif";
    private static final Map<String, String> b = new HashMap();

    private StatService() {
    }

    static {
        b.put(Info.kBaiduPIDKey, "111");
        b.put("type", "1023");
        b.put("device", SocialConstants.ANDROID_CLIENT_TYPE);
    }

    public static void onEvent(StatEvent statEvent) {
        if (statEvent != null && !TextUtils.isEmpty(statEvent.a)) {
            HashMap hashMap = new HashMap();
            hashMap.put("di", e.b(statEvent.b));
            a(statEvent.a, hashMap);
        }
    }

    public static void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
                com.baidu.sapi2.d.a(sapiConfiguration.context).a(str, map);
                if (SapiUtils.hasActiveNetwork(sapiConfiguration.context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(b);
                    hashMap.put("name", str);
                    hashMap.put("tpl", sapiConfiguration.tpl);
                    hashMap.put("clientfrom", "mobilesdk_enhanced");
                    hashMap.put("app_version", SapiUtils.getVersionName(sapiConfiguration.context));
                    hashMap.put("sdk_version", SapiAccountManager.VERSION_NAME);
                    if (!TextUtils.isEmpty(sapiConfiguration.clientId)) {
                        hashMap.put(SocialConstants.PARAM_CUID, sapiConfiguration.clientId);
                    }
                    hashMap.put("v", String.valueOf(System.currentTimeMillis()));
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    new Handler(Looper.getMainLooper()).post(new a(sapiConfiguration, hashMap, str));
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a implements Runnable {
        final /* synthetic */ SapiConfiguration a;
        final /* synthetic */ Map b;
        final /* synthetic */ String c;

        a(SapiConfiguration sapiConfiguration, Map map, String str) {
            this.a = sapiConfiguration;
            this.b = map;
            this.c = str;
        }

        /* renamed from: com.baidu.sapi2.utils.StatService$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class HandlerC0038a extends HttpResponseHandler {
            HandlerC0038a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                com.baidu.sapi2.d.a(a.this.a.context).e(a.this.c);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            new AsyncHttpClient().get(this.a.context, StatService.a, new RequestParams(this.b), new HandlerC0038a());
        }
    }

    public static void a() {
        try {
            for (Map.Entry<String, Map<String, String>> entry : com.baidu.sapi2.d.a(SapiAccountManager.getInstance().getSapiConfiguration().context).p().entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            L.e(th);
        }
    }
}
