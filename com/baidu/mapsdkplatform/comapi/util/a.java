package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0101a {
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

    public static String a(Context context) {
        String packageName = context.getPackageName();
        String a2 = a(context, packageName);
        return a2 + ";" + packageName;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            str2 = "";
            StringBuffer stringBuffer = new StringBuffer();
            while (r0 < str2.length()) {
            }
            return stringBuffer.toString();
        } catch (CertificateException e3) {
            e3.printStackTrace();
            str2 = "";
            StringBuffer stringBuffer2 = new StringBuffer();
            while (r0 < str2.length()) {
            }
            return stringBuffer2.toString();
        }
        StringBuffer stringBuffer22 = new StringBuffer();
        for (int i2 = 0; i2 < str2.length(); i2++) {
            stringBuffer22.append(str2.charAt(i2));
            if (i2 > 0 && i2 % 2 == 1 && i2 < str2.length() - 1) {
                stringBuffer22.append(":");
            }
        }
        return stringBuffer22.toString();
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return C0101a.a(a(x509Certificate.getEncoded()));
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
}
