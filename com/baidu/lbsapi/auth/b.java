package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
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
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(cArr[(bArr[i2] & 240) >> 4]);
                sb.append(cArr[bArr[i2] & 15]);
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
        for (int i2 = 0; i2 < str2.length(); i2++) {
            stringBuffer.append(str2.charAt(i2));
            if (i2 > 0 && i2 % 2 == 1 && i2 < str2.length() - 1) {
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
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = b2[i2] + ";" + packageName;
            if (com.baidu.lbsapi.auth.a.f6293a) {
                com.baidu.lbsapi.auth.a.a("mcode" + strArr[i2]);
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
        int i2;
        Signature[] signatureArr;
        String[] strArr2 = null;
        try {
            signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException | CertificateException unused) {
        }
        if (signatureArr != null && signatureArr.length > 0) {
            strArr = new String[signatureArr.length];
            for (int i3 = 0; i3 < signatureArr.length; i3++) {
                try {
                    strArr[i3] = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i3].toByteArray())));
                } catch (PackageManager.NameNotFoundException | CertificateException unused2) {
                }
            }
            if (strArr != null && strArr.length > 0) {
                strArr2 = new String[strArr.length];
                for (i2 = 0; i2 < strArr.length; i2++) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i4 = 0; i4 < strArr[i2].length(); i4++) {
                        stringBuffer.append(strArr[i2].charAt(i4));
                        if (i4 > 0 && i4 % 2 == 1 && i4 < strArr[i2].length() - 1) {
                            stringBuffer.append(":");
                        }
                    }
                    strArr2[i2] = stringBuffer.toString();
                }
            }
            return strArr2;
        }
        strArr = null;
        if (strArr != null) {
            strArr2 = new String[strArr.length];
            while (i2 < strArr.length) {
            }
        }
        return strArr2;
    }
}
