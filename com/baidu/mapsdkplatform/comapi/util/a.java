package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0114a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
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

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String packageName = context.getPackageName();
            String a = a(context, packageName);
            return a + ParamableElem.DIVIDE_PARAM + packageName;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray())));
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                str2 = "";
                StringBuffer stringBuffer = new StringBuffer();
                while (r0 < str2.length()) {
                }
                return stringBuffer.toString();
            } catch (CertificateException e2) {
                e2.printStackTrace();
                str2 = "";
                StringBuffer stringBuffer2 = new StringBuffer();
                while (r0 < str2.length()) {
                }
                return stringBuffer2.toString();
            }
            StringBuffer stringBuffer22 = new StringBuffer();
            for (int i = 0; i < str2.length(); i++) {
                stringBuffer22.append(str2.charAt(i));
                if (i > 0 && i % 2 == 1 && i < str2.length() - 1) {
                    stringBuffer22.append(":");
                }
            }
            return stringBuffer22.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String a(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, x509Certificate)) == null) {
            try {
                return C0114a.a(a(x509Certificate.getEncoded()));
            } catch (CertificateEncodingException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                return MessageDigest.getInstance("SHA1").digest(bArr);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
