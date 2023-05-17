package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                char[] cArr = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                StringBuilder sb = new StringBuilder(bArr.length * 2);
                for (int i = 0; i < bArr.length; i++) {
                    sb.append(cArr[(bArr[i] & 240) >> 4]);
                    sb.append(cArr[bArr[i] & 15]);
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
            return a2 + ParamableElem.DIVIDE_PARAM + packageName;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[LOOP:0: B:25:0x009f->B:34:0x00bf, LOOP_START, PHI: r1 
      PHI: (r1v3 int) = (r1v2 int), (r1v4 int) binds: [B:24:0x009d, B:34:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        StringBuilder sb;
        String certificateException;
        String str2;
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
            } catch (PackageManager.NameNotFoundException e) {
                sb = new StringBuilder();
                sb.append("getFingerPrint：");
                certificateException = e.toString();
                sb.append(certificateException);
                com.baidu.lbsapi.auth.a.a(sb.toString());
                str2 = "";
                StringBuffer stringBuffer = new StringBuffer();
                if (str2 != null) {
                }
                return stringBuffer.toString();
            } catch (CertificateException e2) {
                sb = new StringBuilder();
                sb.append("getFingerPrint：");
                certificateException = e2.toString();
                sb.append(certificateException);
                com.baidu.lbsapi.auth.a.a(sb.toString());
                str2 = "";
                StringBuffer stringBuffer2 = new StringBuffer();
                if (str2 != null) {
                }
                return stringBuffer2.toString();
            }
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo;
                if (signingInfo != null) {
                    signatureArr = signingInfo.hasMultipleSigners() ? context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners() : context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getSigningCertificateHistory();
                    str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray())));
                    StringBuffer stringBuffer22 = new StringBuffer();
                    if (str2 != null) {
                        for (int i = 0; i < str2.length(); i++) {
                            stringBuffer22.append(str2.charAt(i));
                            if (i > 0 && i % 2 == 1 && i < str2.length() - 1) {
                                stringBuffer22.append(":");
                            }
                        }
                    }
                    return stringBuffer22.toString();
                }
                packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            }
            signatureArr = packageInfo.signatures;
            str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray())));
            StringBuffer stringBuffer222 = new StringBuffer();
            if (str2 != null) {
            }
            return stringBuffer222.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, x509Certificate)) == null) {
            try {
                return a.a(a(x509Certificate.getEncoded()));
            } catch (CertificateEncodingException e) {
                com.baidu.lbsapi.auth.a.a("getFingerprintAs：" + e.toString());
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
            } catch (NoSuchAlgorithmException e) {
                com.baidu.lbsapi.auth.a.a("generateSHA1：" + e.toString());
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            String packageName = context.getPackageName();
            String[] b = b(context, packageName);
            if (b == null || b.length <= 0) {
                return null;
            }
            int length = b.length;
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = b[i] + ParamableElem.DIVIDE_PARAM + packageName;
                if (com.baidu.lbsapi.auth.a.a) {
                    com.baidu.lbsapi.auth.a.a("mcode" + strArr[i]);
                }
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] b(Context context, String str) {
        InterceptResult invokeLL;
        String[] strArr;
        StringBuilder sb;
        String certificateException;
        int i;
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            String[] strArr2 = null;
            try {
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                strArr = null;
            } catch (CertificateException e2) {
                e = e2;
                strArr = null;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo;
                if (signingInfo != null) {
                    signatureArr = signingInfo.hasMultipleSigners() ? context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners() : context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getSigningCertificateHistory();
                    if (signatureArr != null || signatureArr.length <= 0) {
                        strArr = null;
                    } else {
                        strArr = new String[signatureArr.length];
                        for (int i2 = 0; i2 < signatureArr.length; i2++) {
                            try {
                                strArr[i2] = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[i2].toByteArray())));
                            } catch (PackageManager.NameNotFoundException e3) {
                                e = e3;
                                sb = new StringBuilder();
                                sb.append("getFingerPrint：");
                                certificateException = e.toString();
                                sb.append(certificateException);
                                com.baidu.lbsapi.auth.a.a(sb.toString());
                                if (strArr != null) {
                                }
                                return strArr2;
                            } catch (CertificateException e4) {
                                e = e4;
                                sb = new StringBuilder();
                                sb.append("getFingerPrint：");
                                certificateException = e.toString();
                                sb.append(certificateException);
                                com.baidu.lbsapi.auth.a.a(sb.toString());
                                if (strArr != null) {
                                }
                                return strArr2;
                            }
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
                packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            } else {
                packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            }
            signatureArr = packageInfo.signatures;
            if (signatureArr != null) {
            }
            strArr = null;
            if (strArr != null) {
                strArr2 = new String[strArr.length];
                while (i < strArr.length) {
                }
            }
            return strArr2;
        }
        return (String[]) invokeLL.objValue;
    }
}
