package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                StringBuilder sb = new StringBuilder(bArr.length * 2);
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    sb.append(cArr[(bArr[i2] & 240) >> 4]);
                    sb.append(cArr[bArr[i2] & 15]);
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? Locale.getDefault().getLanguage() : (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String packageName = context.getPackageName();
            String a2 = a(context, packageName);
            return a2 + ";" + packageName;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public static String a(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x509Certificate)) == null) {
            try {
                return a.a(a(x509Certificate.getEncoded()));
            } catch (CertificateEncodingException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            try {
                return MessageDigest.getInstance("SHA1").digest(bArr);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            String packageName = context.getPackageName();
            String[] b2 = b(context, packageName);
            if (b2 == null || b2.length <= 0) {
                return null;
            }
            int length = b2.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = b2[i2] + ";" + packageName;
                if (com.baidu.lbsapi.auth.a.f39406a) {
                    com.baidu.lbsapi.auth.a.a("mcode" + strArr[i2]);
                }
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] b(Context context, String str) {
        InterceptResult invokeLL;
        String[] strArr;
        int i2;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
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
        return (String[]) invokeLL.objValue;
    }
}
