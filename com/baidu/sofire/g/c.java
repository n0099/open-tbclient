package com.baidu.sofire.g;

import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes2.dex */
public final class c {
    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
                try {
                } catch (Throwable unused) {
                    try {
                        d.a();
                        return new Certificate[0];
                    } finally {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable unused2) {
                                d.a();
                            }
                        }
                    }
                }
            } while (bufferedInputStream.read(bArr, 0, 8192) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : new Certificate[0];
            try {
                bufferedInputStream.close();
            } catch (Throwable unused3) {
                d.a();
            }
            return certificates;
        } catch (Throwable unused4) {
            bufferedInputStream = null;
        }
    }

    public static PublicKey a(Signature signature) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
        try {
            byteArrayInputStream.close();
        } catch (Throwable unused) {
            d.a();
        }
        return generateCertificate.getPublicKey();
    }

    public static PublicKey a(String str) {
        int i2;
        boolean z;
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
}
