package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    private static final String a = "http://nsclick.baidu.com/v.gif";
    private static final AsyncHttpClient b = new AsyncHttpClient();
    private static final Map<String, String> c = new HashMap();

    static {
        c.put("pid", "111");
        c.put("type", "1023");
        c.put("device", "android");
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
                if (SapiUtils.hasActiveNetwork(sapiConfiguration.context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(c);
                    hashMap.put("name", str);
                    hashMap.put("tpl", sapiConfiguration.tpl);
                    hashMap.put("app_version", SapiUtils.getVersionName(sapiConfiguration.context));
                    hashMap.put("sdk_version", SapiAccountManager.VERSION_NAME);
                    if (!TextUtils.isEmpty(sapiConfiguration.clientId)) {
                        hashMap.put("cuid", sapiConfiguration.clientId);
                    }
                    hashMap.put("login_share_strategy", sapiConfiguration.loginShareStrategy.getStrValue());
                    hashMap.put("v", String.valueOf(new Date().getTime()));
                    b.get(sapiConfiguration.context, a, new RequestParams(hashMap), null);
                }
            } catch (Throwable th) {
                L.e(th);
            }
        }
    }
}
