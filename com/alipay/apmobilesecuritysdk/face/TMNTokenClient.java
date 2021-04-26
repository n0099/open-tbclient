package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
/* loaded from: classes.dex */
public class TMNTokenClient {

    /* renamed from: a  reason: collision with root package name */
    public static TMNTokenClient f1718a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1719b;

    /* loaded from: classes.dex */
    public interface InitResultListener {
        void onResult(String str, int i2);
    }

    public TMNTokenClient(Context context) {
        this.f1719b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.f1719b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f1718a == null) {
            synchronized (TMNTokenClient.class) {
                if (f1718a == null) {
                    f1718a = new TMNTokenClient(context);
                }
            }
        }
        return f1718a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (a.a(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (a.a(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.f1830g, UtdidWrapper.getUtdid(this.f1719b));
        hashMap.put("tid", "");
        hashMap.put("userId", "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
            @Override // java.lang.Runnable
            public void run() {
                int a2 = new com.alipay.apmobilesecuritysdk.a.a(TMNTokenClient.this.f1719b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (a2 != 0) {
                    initResultListener2.onResult("", a2);
                    return;
                }
                initResultListener.onResult(com.alipay.apmobilesecuritysdk.a.a.a(TMNTokenClient.this.f1719b, str), 0);
            }
        });
    }
}
