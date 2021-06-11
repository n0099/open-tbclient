package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.app.i;
import com.alipay.sdk.util.n;
import com.baidu.pass.ecommerce.view.SpeechRecognitionDialog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1869a = "virtualImeiAndImsi";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1870b = "virtual_imei";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1871c = "virtual_imsi";

    /* renamed from: d  reason: collision with root package name */
    public static c f1872d;

    /* renamed from: e  reason: collision with root package name */
    public String f1873e;

    /* renamed from: f  reason: collision with root package name */
    public String f1874f = "sdk-and-lite";

    /* renamed from: g  reason: collision with root package name */
    public String f1875g;

    public c() {
        String a2 = i.a();
        if (i.b()) {
            return;
        }
        this.f1874f += '_' + a2;
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (f1872d == null) {
                f1872d = new c();
            }
            cVar = f1872d;
        }
        return cVar;
    }

    private String e() {
        return "1";
    }

    private String f() {
        return "-1;-1";
    }

    private String g() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(SpeechRecognitionDialog.REQUEST_SETTING_CODE) + 1000);
    }

    public String c() {
        String b2;
        Context b3 = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b3.getSharedPreferences(f1869a, 0);
        String string = sharedPreferences.getString(f1870b, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b3).a())) {
                b2 = g();
            } else {
                b2 = com.alipay.sdk.util.a.a(b3).b();
            }
            String str = b2;
            sharedPreferences.edit().putString(f1870b, str).commit();
            return str;
        }
        return string;
    }

    public String d() {
        String a2;
        Context b2 = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b2.getSharedPreferences(f1869a, 0);
        String string = sharedPreferences.getString(f1871c, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a(b2).a())) {
                String e2 = com.alipay.sdk.sys.b.a().e();
                if (TextUtils.isEmpty(e2)) {
                    a2 = g();
                } else {
                    a2 = e2.substring(3, 18);
                }
            } else {
                a2 = com.alipay.sdk.util.a.a(b2).a();
            }
            String str = a2;
            sharedPreferences.edit().putString(f1871c, str).commit();
            return str;
        }
        return string;
    }

    public String a() {
        return this.f1875g;
    }

    public synchronized void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.a().b()).edit().putString(com.alipay.sdk.cons.b.f1845i, str).commit();
        com.alipay.sdk.cons.a.f1830c = str;
    }

    private String b(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    private String b(Context context, HashMap<String, String> hashMap) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new d(this, context, hashMap)).get(3000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1823e, com.alipay.sdk.app.statistic.c.j, th);
            return "";
        }
    }

    private String c(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    public String a(com.alipay.sdk.tid.b bVar) {
        Context b2 = com.alipay.sdk.sys.b.a().b();
        com.alipay.sdk.util.a a2 = com.alipay.sdk.util.a.a(b2);
        if (TextUtils.isEmpty(this.f1873e)) {
            String b3 = n.b();
            String c2 = n.c();
            String d2 = n.d(b2);
            String f2 = n.f(b2);
            String e2 = n.e(b2);
            String b4 = b(b2);
            this.f1873e = "Msp/15.6.5 (" + b3 + ";" + c2 + ";" + d2 + ";" + f2 + ";" + e2 + ";" + b4;
        }
        String b5 = com.alipay.sdk.util.a.b(b2).b();
        String g2 = n.g(b2);
        String e3 = e();
        String a3 = a2.a();
        String b6 = a2.b();
        String d3 = d();
        String c3 = c();
        if (bVar != null) {
            this.f1875g = bVar.b();
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean d4 = com.alipay.sdk.sys.b.d();
        String d5 = a2.d();
        String c4 = c(b2);
        String d6 = d(b2);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1873e);
        sb.append(";");
        sb.append(b5);
        sb.append(";");
        sb.append(g2);
        sb.append(";");
        sb.append(e3);
        sb.append(";");
        sb.append(a3);
        sb.append(";");
        sb.append(b6);
        sb.append(";");
        sb.append(this.f1875g);
        sb.append(";");
        sb.append(replace);
        sb.append(";");
        sb.append(replace2);
        sb.append(";");
        sb.append(d4);
        sb.append(";");
        sb.append(d5);
        sb.append(";");
        sb.append(f());
        sb.append(";");
        sb.append(this.f1874f);
        sb.append(";");
        sb.append(d3);
        sb.append(";");
        sb.append(c3);
        sb.append(";");
        sb.append(c4);
        sb.append(";");
        sb.append(d6);
        if (bVar != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tid", com.alipay.sdk.tid.b.a(b2).a());
            hashMap.put(com.alipay.sdk.cons.b.f1843g, com.alipay.sdk.sys.b.a().e());
            String b7 = b(b2, hashMap);
            if (!TextUtils.isEmpty(b7)) {
                sb.append(";");
                sb.append(b7);
            }
        }
        sb.append(SmallTailInfo.EMOTION_SUFFIX);
        return sb.toString();
    }

    private String d(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, HashMap<String, String> hashMap) {
        String str;
        try {
            str = SecurityClientMobile.GetApdid(context, hashMap);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1823e, com.alipay.sdk.app.statistic.c.f1826h, th);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1823e, com.alipay.sdk.app.statistic.c.f1827i, "apdid == null");
        }
        com.alipay.sdk.util.c.d(com.alipay.sdk.net.a.f1890a, "apdid:" + str);
        return str;
    }

    public String a(Context context) {
        if (context != null) {
            try {
                StringBuilder sb = new StringBuilder();
                String packageName = context.getPackageName();
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                sb.append("(");
                sb.append(packageName);
                sb.append(";");
                sb.append(packageInfo.versionCode);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }
}
