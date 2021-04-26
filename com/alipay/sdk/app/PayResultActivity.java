package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class PayResultActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1744a = "{\"isLogin\":\"false\"}";

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap<String, Object> f1745b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final String f1746c = "hk.alipay.wallet";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1747d = "phonecashier.pay.hash";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1748e = "orderSuffix";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1749f = "externalPkgName";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1750g = "phonecashier.pay.result";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1751h = "phonecashier.pay.resultOrderHash";

    /* renamed from: i  reason: collision with root package name */
    public static String f1752i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static volatile String f1753a;

        /* renamed from: b  reason: collision with root package name */
        public static volatile String f1754b;
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage(f1746c);
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            com.alipay.sdk.util.c.b(com.alipay.sdk.net.a.f1877a, "PayTask:payReuslt: UnsupportedEncodingException:" + e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra(f1748e))) {
                a.f1753a = intent.getStringExtra(f1747d);
                a(this, a.f1753a, intent.getStringExtra(f1748e), intent.getStringExtra(f1749f));
                a(this, 300);
                return;
            }
            String stringExtra = intent.getStringExtra(f1750g);
            int intExtra = intent.getIntExtra(f1751h, 0);
            if (intExtra != 0 && TextUtils.equals(a.f1753a, String.valueOf(intExtra))) {
                if (!TextUtils.isEmpty(stringExtra)) {
                    a(stringExtra, a.f1753a);
                } else {
                    a(a.f1753a);
                }
                a.f1753a = "";
                a(this, 300);
                return;
            }
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.R, "Expected " + a.f1753a + ", got " + intExtra);
            a(a.f1753a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }

    public static void a(String str) {
        a.f1754b = j.c();
        a(f1745b, str);
    }

    public static void a(String str, String str2) {
        a.f1754b = str;
        a(f1745b, str2);
    }

    public static void a(Activity activity, int i2) {
        new Handler().postDelayed(new f(activity), i2);
    }

    public static boolean a(HashMap<String, Object> hashMap, String str) {
        Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }
}
