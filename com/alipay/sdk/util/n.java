package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.data.a;
import com.baidu.searchbox.logsystem.logsys.SnapshotConstant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1991a = "com.eg.android.AlipayGphone";

    /* renamed from: b  reason: collision with root package name */
    public static final int f1992b = 125;

    /* renamed from: c  reason: collision with root package name */
    public static final String f1993c = "com.alipay.android.app";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1994d = "com.eg.android.AlipayGphoneRC";

    /* renamed from: e  reason: collision with root package name */
    public static final int f1995e = 99;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f1996f = {"10.1.5.1013151", "10.1.5.1013148"};

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final PackageInfo f1997a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1998b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1999c;

        public a(PackageInfo packageInfo, int i2, String str) {
            this.f1997a = packageInfo;
            this.f1998b = i2;
            this.f1999c = str;
        }

        public boolean a() {
            Signature[] signatureArr = this.f1997a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String b2 = n.b(signature.toByteArray());
                if (b2 != null && !TextUtils.equals(b2, this.f1999c)) {
                    com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.w, String.format("Got %s, expected %s", b2, this.f1999c));
                    return true;
                }
            }
            return false;
        }

        public boolean b() {
            return this.f1997a.versionCode < this.f1998b;
        }
    }

    public static Map<String, String> b(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    public static Map<String, String> c(String str) {
        String[] split;
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            for (String str2 : str.substring(indexOf + 1).split("&")) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), e(str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    public static JSONObject d(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.u, e2);
            return "";
        }
    }

    public static String f(Context context) {
        String a2 = m.a(context);
        return a2.substring(0, a2.indexOf("://"));
    }

    public static String g(Context context) {
        return "-1;-1";
    }

    public static String h(Context context) {
        return c(context, context.getPackageName());
    }

    public static DisplayMetrics i(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String a() {
        if (EnvUtils.isSandBox()) {
            return f1994d;
        }
        try {
            return com.alipay.sdk.app.i.f1800a.get(0).f1864a;
        } catch (Throwable unused) {
            return f1991a;
        }
    }

    public static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(SnapshotConstant.DeviceFilePathConstants.DEVICE_VERSION), 256);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (matcher.matches() && matcher.groupCount() >= 4) {
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            }
            return "Unavailable";
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String e(Context context) {
        DisplayMetrics i2 = i(context);
        return i2.widthPixels + "*" + i2.heightPixels;
    }

    public static boolean f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String a(String str) {
        return (EnvUtils.isSandBox() && TextUtils.equals(str, f1994d)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static String a(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int indexOf2 = TextUtils.isEmpty(str2) ? 0 : str3.indexOf(str2, indexOf);
            if (indexOf2 < 1) {
                return str3.substring(indexOf);
            }
            return str3.substring(indexOf, indexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            com.alipay.sdk.app.statistic.a.a("auth", com.alipay.sdk.app.statistic.c.o, e2);
            return null;
        }
    }

    public static a a(Context context, List<a.C0016a> list) {
        a a2;
        if (list == null) {
            return null;
        }
        for (a.C0016a c0016a : list) {
            if (c0016a != null && (a2 = a(context, c0016a.f1864a, c0016a.f1865b, c0016a.f1866c)) != null && !a2.a() && !a2.b()) {
                return a2;
            }
        }
        return null;
    }

    public static String c(Context context) {
        String b2 = b();
        String c2 = c();
        String d2 = d(context);
        String e2 = e(context);
        return " (" + b2 + ";" + c2 + ";" + d2 + ";;" + e2 + SmallTailInfo.EMOTION_SUFFIX + "(sdk android)";
    }

    public static String d(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static a a(Context context, String str, int i2, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.isSandBox() && f1991a.equals(str)) {
            str = f1994d;
        }
        try {
            packageInfo = b(context, str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("auth", com.alipay.sdk.app.statistic.c.l, th);
            packageInfo = null;
        }
        if (b(packageInfo)) {
            return a(packageInfo, i2, str2);
        }
        return null;
    }

    public static boolean b(PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            com.alipay.sdk.app.statistic.a.a("auth", com.alipay.sdk.app.statistic.c.m, str);
        }
        return z;
    }

    public static a a(PackageInfo packageInfo, int i2, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new a(packageInfo, i2, str);
    }

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f1993c, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String c() {
        String d2 = d();
        int indexOf = d2.indexOf("-");
        if (indexOf != -1) {
            d2 = d2.substring(0, indexOf);
        }
        int indexOf2 = d2.indexOf("\n");
        if (indexOf2 != -1) {
            d2 = d2.substring(0, indexOf2);
        }
        return "Linux " + d2;
    }

    public static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            if (!TextUtils.equals(str, f1996f[0])) {
                if (!TextUtils.equals(str, f1996f[1])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static PackageInfo b(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static String a(int i2) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (nextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (nextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static boolean b(Context context, List<a.C0016a> list) {
        try {
            for (a.C0016a c0016a : list) {
                if (c0016a != null) {
                    String str = c0016a.f1864a;
                    if (EnvUtils.isSandBox() && f1991a.equals(str)) {
                        str = f1994d;
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.K, th);
            return false;
        }
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.l, th);
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a(), 128);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode < 99;
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static String a(Context context, String str) {
        String str2 = "";
        try {
            String str3 = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    str3 = str3 + "#M";
                } else {
                    if (runningAppProcessInfo.processName.startsWith(str + ":")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str3);
                        sb.append("#");
                        sb.append(runningAppProcessInfo.processName.replace(str + ":", ""));
                        str3 = sb.toString();
                    }
                }
            }
            str2 = str3;
        } catch (Throwable unused) {
        }
        if (str2.length() > 0) {
            str2 = str2.substring(1);
        }
        return str2.length() == 0 ? "N" : str2;
    }

    public static String b() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static boolean a(WebView webView, String str, Activity activity) {
        int parseInt;
        String substring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (!str.toLowerCase().startsWith(com.alipay.sdk.cons.a.j.toLowerCase()) && !str.toLowerCase().startsWith(com.alipay.sdk.cons.a.k.toLowerCase())) {
            if (!TextUtils.equals(str, com.alipay.sdk.cons.a.m) && !TextUtils.equals(str, com.alipay.sdk.cons.a.n)) {
                if (str.startsWith(com.alipay.sdk.cons.a.l)) {
                    try {
                        String substring2 = str.substring(str.indexOf(com.alipay.sdk.cons.a.l) + 24);
                        parseInt = Integer.parseInt(substring2.substring(substring2.lastIndexOf(com.alipay.sdk.cons.a.o) + 10));
                    } catch (Exception unused) {
                        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.e());
                    }
                    if (parseInt != com.alipay.sdk.app.k.SUCCEEDED.a() && parseInt != com.alipay.sdk.app.k.PAY_WAITTING.a()) {
                        com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.FAILED.a());
                        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b2.a(), b2.b(), ""));
                        activity.runOnUiThread(new o(activity));
                        return true;
                    }
                    if (com.alipay.sdk.cons.a.s) {
                        StringBuilder sb = new StringBuilder();
                        String decode = URLDecoder.decode(str);
                        String decode2 = URLDecoder.decode(decode);
                        String str2 = decode2.substring(decode2.indexOf(com.alipay.sdk.cons.a.l) + 24, decode2.lastIndexOf(com.alipay.sdk.cons.a.o)).split(com.alipay.sdk.cons.a.q)[0];
                        int indexOf = decode.indexOf(com.alipay.sdk.cons.a.q) + 12;
                        sb.append(str2);
                        sb.append(com.alipay.sdk.cons.a.q);
                        sb.append(decode.substring(indexOf, decode.indexOf("&", indexOf)));
                        sb.append(decode.substring(decode.indexOf("&", indexOf)));
                        substring = sb.toString();
                    } else {
                        String decode3 = URLDecoder.decode(str);
                        substring = decode3.substring(decode3.indexOf(com.alipay.sdk.cons.a.l) + 24, decode3.lastIndexOf(com.alipay.sdk.cons.a.o));
                    }
                    com.alipay.sdk.app.k b3 = com.alipay.sdk.app.k.b(parseInt);
                    com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.a(b3.a(), b3.b(), substring));
                    activity.runOnUiThread(new o(activity));
                    return true;
                }
                return false;
            }
            com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
            activity.finish();
            return true;
        }
        try {
            a a2 = a(activity, com.alipay.sdk.app.i.f1800a);
            if (a2 != null && !a2.b() && !a2.a()) {
                if (str.startsWith("intent://platformapi/startapp")) {
                    str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.cons.a.j);
                }
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        } catch (Throwable unused2) {
        }
        return true;
    }
}
