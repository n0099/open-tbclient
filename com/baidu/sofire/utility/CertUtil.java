package com.baidu.sofire.utility;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class CertUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CertUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static PublicKey getPublicKey(Signature signature) throws CertificateException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, signature)) == null) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            return generateCertificate.getPublicKey();
        }
        return (PublicKey) invokeL.objValue;
    }

    public static Certificate[] loadCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, jarFile, jarEntry, bArr)) != null) {
            return (Certificate[]) invokeLLL.objValue;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        CommonMethods.handleNuLException(th);
                        return new Certificate[0];
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th2) {
                                CommonMethods.handleNuLException(th2);
                            }
                        }
                    }
                }
            } while (bufferedInputStream2.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : new Certificate[0];
            try {
                bufferedInputStream2.close();
            } catch (Throwable th3) {
                CommonMethods.handleNuLException(th3);
            }
            return certificates;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static PublicKey parserPublicKeyByPath(String str) {
        InterceptResult invokeL;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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
                    Certificate[] loadCertificates = loadCertificates(jarFile, nextElement, bArr);
                    if (loadCertificates != null && loadCertificates.length > 0) {
                        if (certificateArr == null) {
                            certificateArr = loadCertificates;
                        } else {
                            while (i < certificateArr.length) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= loadCertificates.length) {
                                        z = false;
                                        break;
                                    } else if (certificateArr[i] != null && certificateArr[i].equals(loadCertificates[i2])) {
                                        z = true;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                i = (z && certificateArr.length == loadCertificates.length) ? i + 1 : 0;
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
