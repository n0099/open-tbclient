package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.cons.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class APSecuritySdk {

    /* renamed from: a  reason: collision with root package name */
    public static APSecuritySdk f1724a;

    /* renamed from: c  reason: collision with root package name */
    public static Object f1725c = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Context f1726b;

    /* loaded from: classes.dex */
    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    /* loaded from: classes.dex */
    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(Context context) {
        this.f1726b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f1724a == null) {
            synchronized (f1725c) {
                if (f1724a == null) {
                    f1724a = new APSecuritySdk(context);
                }
            }
        }
        return f1724a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String a2 = a.a(this.f1726b, "");
        if (com.alipay.security.mobile.module.a.a.a(a2)) {
            initToken(0, new HashMap(), null);
        }
        return a2;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.3.0.1905151001";
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.f1726b, "");
            tokenResult.clientKey = h.f(this.f1726b);
            tokenResult.apdid = a.a(this.f1726b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.f1726b);
            if (com.alipay.security.mobile.module.a.a.a(tokenResult.apdid) || com.alipay.security.mobile.module.a.a.a(tokenResult.apdidToken) || com.alipay.security.mobile.module.a.a.a(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i2, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i2);
        String b2 = h.b(this.f1726b);
        String c2 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.security.mobile.module.a.a.b(b2) && !com.alipay.security.mobile.module.a.a.a(b2, c2)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.f1726b);
            d.a(this.f1726b);
            g.a(this.f1726b);
            i.h();
        }
        if (!com.alipay.security.mobile.module.a.a.a(b2, c2)) {
            h.c(this.f1726b, c2);
        }
        String a2 = com.alipay.security.mobile.module.a.a.a(map, b.f1843g, "");
        String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
        String a4 = com.alipay.security.mobile.module.a.a.a(map, "userId", "");
        if (com.alipay.security.mobile.module.a.a.a(a2)) {
            a2 = UtdidWrapper.getUtdid(this.f1726b);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(b.f1843g, a2);
        hashMap.put("tid", a3);
        hashMap.put("userId", a4);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.f1726b).a(hashMap);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
