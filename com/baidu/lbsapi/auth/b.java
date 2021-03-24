package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public static class a {
        public static String a(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
            }
            return sb.toString();
        }
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        String a2 = a(context, packageName);
        return a2 + ";" + packageName;
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException | CertificateException unused) {
            str2 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str2.length(); i++) {
            stringBuffer.append(str2.charAt(i));
            if (i > 0 && i % 2 == 1 && i < str2.length() - 1) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] b2 = b(context, packageName);
        if (b2 == null || b2.length <= 0) {
            return null;
        }
        int length = b2.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = b2[i] + ";" + packageName;
            if (com.baidu.lbsapi.auth.a.f6321a) {
                com.baidu.lbsapi.auth.a.a("mcode" + strArr[i]);
            }
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] b(Context context, String str) {
        String[] strArr;
        int i;
        Signature[] signatureArr;
        String[] strArr2 = null;
        try {
            signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException | CertificateException unused) {
        }
        if (signatureArr != null && signatureArr.length > 0) {
            strArr = new String[signatureArr.length];
            for (int i2 = 0; i2 < signatureArr.length; i2++) {
                try {
                    strArr[i2] = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i2].toByteArray())));
                } catch (PackageManager.NameNotFoundException | CertificateException unused2) {
                }
            }
            if (strArr != null && strArr.length > 0) {
                strArr2 = new String[strArr.length];
                for (i = 0; i < strArr.length; i++) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i3 = 0; i3 < strArr[i].length(); i3++) {
                        stringBuffer.append(strArr[i].charAt(i3));
                        if (i3 > 0 && i3 % 2 == 1 && i3 < strArr[i].length() - 1) {
                            stringBuffer.append(":");
                        }
                    }
                    strArr2[i] = stringBuffer.toString();
                }
            }
            return strArr2;
        }
        strArr = null;
        if (strArr != null) {
            strArr2 = new String[strArr.length];
            while (i < strArr.length) {
            }
        }
        return strArr2;
    }

    public static String c(Context context) {
        String string = context.getSharedPreferences("mac", 0).getString("macaddr", null);
        if (string == null) {
            String d2 = d(context);
            if (d2 != null) {
                string = Base64.encodeToString(d2.getBytes(), 0);
                if (!TextUtils.isEmpty(string)) {
                    context.getSharedPreferences("mac", 0).edit().putString("macaddr", string).commit();
                }
            } else {
                string = "";
            }
        }
        if (com.baidu.lbsapi.auth.a.f6321a) {
            com.baidu.lbsapi.auth.a.a("getMacID mac_adress: " + string);
        }
        return string;
    }

    public static boolean c(Context context, String str) {
        boolean z = context.checkCallingOrSelfPermission(str) != -1;
        if (com.baidu.lbsapi.auth.a.f6321a) {
            com.baidu.lbsapi.auth.a.a("hasPermission " + z + " | " + str);
        }
        return z;
    }

    public static String d(Context context) {
        String format;
        String str = null;
        try {
        } catch (Exception e2) {
            if (com.baidu.lbsapi.auth.a.f6321a) {
                com.baidu.lbsapi.auth.a.a(e2.toString());
            }
        }
        if (!c(context, "android.permission.ACCESS_WIFI_STATE")) {
            if (com.baidu.lbsapi.auth.a.f6321a) {
            }
            return str;
        }
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        str = connectionInfo.getMacAddress();
        if (!TextUtils.isEmpty(str)) {
            Base64.encode(str.getBytes(), 0);
        }
        format = com.baidu.lbsapi.auth.a.f6321a ? String.format("ssid=%s mac=%s", connectionInfo.getSSID(), connectionInfo.getMacAddress()) : "You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add:android.permission.ACCESS_WIFI_STATE";
        return str;
        com.baidu.lbsapi.auth.a.a(format);
        return str;
    }
}
