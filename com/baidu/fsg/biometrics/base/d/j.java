package com.baidu.fsg.biometrics.base.d;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiContext;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class j {
    private static final String a = "https://nsclick.baidu.com/v.gif";
    private static final Map<String, String> b = new HashMap();

    private j() {
    }

    static {
        b.put(Info.kBaiduPIDKey, "111");
        b.put("type", "1023");
        b.put("device", HttpConstants.OS_TYPE_VALUE);
    }

    public static void a(String str, Map<String, String> map, Context context) {
        a(str, map, true, context.getApplicationContext());
    }

    public static void a(String str, Map<String, String> map, boolean z, Context context) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (h.b(context)) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(b);
                    hashMap.put("name", str);
                    hashMap.put("clientfrom", "biometrics_sdk");
                    hashMap.put("app_version", h.c(context));
                    hashMap.put(SapiContext.KEY_SDK_VERSION, com.baidu.fsg.biometrics.base.c.a);
                    hashMap.put(NotifyType.VIBRATE, String.valueOf(System.currentTimeMillis()));
                    if (map != null) {
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    new AsyncHttpClient().get(context, a, new RequestParams(hashMap), new a(context, str));
                }
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends HttpResponseHandler {
        WeakReference<Context> a;
        String b;

        public a(Context context, String str) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(context);
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
        }
    }
}
