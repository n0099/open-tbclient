package com.baidu.sofire.utility;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InterceptResult invokeLLL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, jarFile, jarEntry, bArr)) != null) {
            return (Certificate[]) invokeLLL.objValue;
        }
        try {
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (Throwable unused) {
                    try {
                        c.a();
                        return new Certificate[0];
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable unused2) {
                                c.a();
                            }
                        }
                    }
                }
            } while (bufferedInputStream.read(bArr, 0, 8192) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : new Certificate[0];
            try {
                bufferedInputStream.close();
            } catch (Throwable unused3) {
                c.a();
            }
            return certificates;
        } catch (Throwable unused4) {
            bufferedInputStream = null;
        }
    }

    public static PublicKey a(Signature signature) throws CertificateException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, signature)) == null) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (Throwable unused) {
                c.a();
            }
            return generateCertificate.getPublicKey();
        }
        return (PublicKey) invokeL.objValue;
    }

    public static PublicKey a(String str) {
        InterceptResult invokeL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArr = new byte[8192];
            JarFile jarFile = new JarFile(str);
            Enumeration<JarEntry> entries = jarFile.entries();
            Certificate[] certificateArr = null;
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                    Certificate[] a2 = a(jarFile, nextElement, bArr);
                    if (a2 != null && a2.length > 0) {
                        if (certificateArr == null) {
                            certificateArr = a2;
                        } else {
                            while (i2 < certificateArr.length) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= a2.length) {
                                        z = false;
                                        break;
                                    } else if (certificateArr[i2] != null && certificateArr[i2].equals(a2[i3])) {
                                        z = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                i2 = (z && certificateArr.length == a2.length) ? i2 + 1 : 0;
                                jarFile.close();
                                return null;
                            }
                            continue;
                        }
                    }
                    jarFile.close();
                    return null;
                }
            }
            jarFile.close();
            if (certificateArr != null && certificateArr.length > 0) {
                return certificateArr[0].getPublicKey();
            }
            return null;
        }
        return (PublicKey) invokeL.objValue;
    }
}
