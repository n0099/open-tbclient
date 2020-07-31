package com.baidu.sofire.i;

import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes3.dex */
public final class c {
    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
            } while (bufferedInputStream.read(bArr, 0, 8192) != -1);
            bufferedInputStream.close();
            if (jarEntry != null) {
                return jarEntry.getCertificates();
            }
            return null;
        } catch (IOException e) {
            d.a();
            return null;
        } catch (RuntimeException e2) {
            d.a();
            return null;
        } catch (Throwable th) {
            d.a();
            return null;
        }
    }

    public static PublicKey a(Signature signature) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
        try {
            byteArrayInputStream.close();
        } catch (Throwable th) {
        }
        return generateCertificate.getPublicKey();
    }

    public static PublicKey a(String str) {
        boolean z;
        try {
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
                    Certificate[] a = a(jarFile, nextElement, bArr);
                    if (a == null) {
                        jarFile.close();
                        return null;
                    } else if (certificateArr == null) {
                        certificateArr = a;
                    } else {
                        for (int i = 0; i < certificateArr.length; i++) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < a.length) {
                                    if (certificateArr[i] == null || !certificateArr[i].equals(a[i2])) {
                                        i2++;
                                    } else {
                                        z = true;
                                        break;
                                    }
                                } else {
                                    z = false;
                                    break;
                                }
                            }
                            if (!z || certificateArr.length != a.length) {
                                jarFile.close();
                                return null;
                            }
                        }
                        continue;
                    }
                }
            }
            jarFile.close();
            if (certificateArr == null || certificateArr.length <= 0) {
                return null;
            }
            return certificateArr[0].getPublicKey();
        } catch (Throwable th) {
            return null;
        }
    }
}
