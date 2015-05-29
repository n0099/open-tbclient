package com.baidu.sapi2.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static final String a = "http://nsclick.baidu.com/v.gif";
    private static final Map<String, String> b = new HashMap();

    static {
        b.put(Info.kBaiduPIDKey, "111");
        b.put("type", "1023");
        b.put("device", "android");
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
                    new Handler(Looper.getMainLooper()).post(new RunnableC0019a(sapiConfiguration, hashMap, str));
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class RunnableC0019a implements Runnable {
        final /* synthetic */ SapiConfiguration a;
        final /* synthetic */ Map b;
        final /* synthetic */ String c;

        RunnableC0019a(SapiConfiguration sapiConfiguration, Map map, String str) {
            this.a = sapiConfiguration;
            this.b = map;
            this.c = str;
        }

        /* renamed from: com.baidu.sapi2.utils.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class HandlerC0020a extends HttpResponseHandler {
            HandlerC0020a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                com.baidu.sapi2.d.a(RunnableC0019a.this.a.context).e(RunnableC0019a.this.c);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            new AsyncHttpClient().get(this.a.context, a.a, new RequestParams(this.b), new HandlerC0020a());
        }
    }

    public static void a() {
        try {
            for (Map.Entry<String, Map<String, String>> entry : com.baidu.sapi2.d.a(SapiAccountManager.getInstance().getSapiConfiguration().context).r().entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            L.e(th);
        }
    }
}
