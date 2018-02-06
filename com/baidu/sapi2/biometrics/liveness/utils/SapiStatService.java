package com.baidu.sapi2.biometrics.liveness.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.util.Constants;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.fsg.biometrics.base.d.c;
import com.baidu.fsg.biometrics.base.d.h;
import com.baidu.sapi2.biometrics.liveness.d;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class SapiStatService {
    private static final String a = "https://nsclick.baidu.com/v.gif";
    private static final Map<String, String> b = new HashMap();

    private SapiStatService() {
    }

    static {
        b.put(Info.kBaiduPIDKey, "111");
        b.put("type", "1023");
        b.put("device", Constants.OS_TYPE_VALUE);
    }

    public static void onEvent(String str, Map<String, String> map, Context context) {
        onEvent(str, map, true, context.getApplicationContext());
    }

    public static void onEvent(String str, Map<String, String> map, boolean z, Context context) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    d.a(context).a(str, map);
                } catch (Throwable th) {
                    c.a(th);
                    return;
                }
            }
            if (h.b(context)) {
                HashMap hashMap = new HashMap();
                hashMap.putAll(b);
                hashMap.put("name", str);
                hashMap.put("clientfrom", "biometrics_sdk");
                hashMap.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION, h.c(context));
                hashMap.put("sdk_version", com.baidu.fsg.biometrics.base.c.a);
                hashMap.put(NotifyType.VIBRATE, String.valueOf(System.currentTimeMillis()));
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                            hashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                new AsyncHttpClient().get(context, a, new RequestParams(hashMap), new ResponsHandler(context, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ResponsHandler extends HttpResponseHandler {
        WeakReference<Context> a;
        String b;

        public ResponsHandler(Context context, String str) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(context);
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            if (this.a != null && this.a.get() != null) {
                d.a(this.a.get()).a(this.b);
            }
        }
    }
}
