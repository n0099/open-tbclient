package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
/* loaded from: classes20.dex */
class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + packageName;
    }

    private static String a(Context context, String str) {
        String str2 = "";
        try {
            str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
        } catch (PackageManager.NameNotFoundException e) {
        } catch (CertificateException e2) {
        }
        if (str2 == null) {
            return "";
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

    static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException e) {
            return null;
        }
    }

    static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] b = b(context, packageName);
        if (b == null || b.length <= 0) {
            return null;
        }
        String[] strArr = new String[b.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = b[i] + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + packageName;
            if (com.baidu.lbsapi.auth.a.a) {
                com.baidu.lbsapi.auth.a.a("mcode" + strArr[i]);
            }
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] b(Context context, String str) {
        String[] strArr;
        String[] strArr2;
        int i;
        String[] strArr3;
        String[] strArr4 = null;
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                strArr3 = null;
            } else {
                strArr = new String[signatureArr.length];
                for (int i2 = 0; i2 < signatureArr.length; i2++) {
                    try {
                        strArr[i2] = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i2].toByteArray())));
                    } catch (PackageManager.NameNotFoundException e) {
                        strArr2 = strArr;
                        if (strArr2 != null) {
                            strArr4 = new String[strArr2.length];
                            while (i < strArr2.length) {
                            }
                        }
                        return strArr4;
                    } catch (CertificateException e2) {
                        strArr2 = strArr;
                        if (strArr2 != null) {
                        }
                        return strArr4;
                    }
                }
                strArr3 = strArr;
            }
            strArr2 = strArr3;
        } catch (PackageManager.NameNotFoundException e3) {
            strArr = null;
        } catch (CertificateException e4) {
            strArr = null;
        }
        if (strArr2 != null && strArr2.length > 0) {
            strArr4 = new String[strArr2.length];
            for (i = 0; i < strArr2.length; i++) {
                if (strArr2[i] != null && strArr2[i].length() != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i3 = 0; i3 < strArr2[i].length(); i3++) {
                        stringBuffer.append(strArr2[i].charAt(i3));
                        if (i3 > 0 && i3 % 2 == 1 && i3 < strArr2[i].length() - 1) {
                            stringBuffer.append(":");
                        }
                    }
                    strArr4[i] = stringBuffer.toString();
                }
            }
        }
        return strArr4;
    }
}
