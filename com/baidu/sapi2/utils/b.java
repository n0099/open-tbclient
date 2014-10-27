package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private static final String a = "http://nsclick.baidu.com/v.gif";
    private static final Map<String, String> b = new HashMap();

    static {
        b.put("pid", "111");
        b.put("type", "1023");
        b.put("device", "android");
    }

    public static void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            try {
                SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
                com.baidu.sapi2.c.a(sapiConfiguration.context).a(str, map);
                if (SapiUtils.hasActiveNetwork(sapiConfiguration.context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(b);
                    hashMap.put("name", str);
                    hashMap.put("tpl", sapiConfiguration.tpl);
                    hashMap.put("app_version", SapiUtils.getVersionName(sapiConfiguration.context));
                    hashMap.put("sdk_version", SapiAccountManager.VERSION_NAME);
                    if (!TextUtils.isEmpty(sapiConfiguration.clientId)) {
                        hashMap.put("cuid", sapiConfiguration.clientId);
                    }
                    hashMap.put("login_share_strategy", sapiConfiguration.loginShareStrategy().getStrValue());
                    hashMap.put("v", String.valueOf(new Date().getTime()));
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    new AsyncHttpClient().get(sapiConfiguration.context, a, new RequestParams(hashMap), new a(sapiConfiguration, str));
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends HttpResponseHandler {
        final /* synthetic */ SapiConfiguration a;
        final /* synthetic */ String b;

        a(SapiConfiguration sapiConfiguration, String str) {
            this.a = sapiConfiguration;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            com.baidu.sapi2.c.a(this.a.context).e(this.b);
        }
    }

    public static void a() {
        try {
            for (Map.Entry<String, Map<String, String>> entry : com.baidu.sapi2.c.a(SapiAccountManager.getInstance().getSapiConfiguration().context).m().entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            L.e(th);
        }
    }
}
