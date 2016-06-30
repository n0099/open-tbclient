package com.baidu.adp.plugin.util;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes.dex */
public final class h {
    private static Object mSync = new Object();
    private static WeakReference<byte[]> vW;

    public static Signature[] bG(String str) {
        byte[] bArr;
        byte[] bArr2;
        WeakReference<byte[]> weakReference;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (mSync) {
            WeakReference<byte[]> weakReference2 = vW;
            if (weakReference2 != null) {
                vW = null;
                bArr = weakReference2.get();
            } else {
                bArr = null;
            }
            if (bArr == null) {
                byte[] bArr3 = new byte[8192];
                bArr2 = bArr3;
                weakReference = new WeakReference<>(bArr3);
            } else {
                bArr2 = bArr;
                weakReference = weakReference2;
            }
        }
        try {
            JarFile jarFile = new JarFile(str);
            Enumeration<JarEntry> entries = jarFile.entries();
            Certificate[] certificateArr = null;
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                    Certificate[] a = a(jarFile, nextElement, bArr2);
                    if (a == null) {
                        BdLog.e("Package " + str + " has no certificates at entry " + nextElement.getName() + "; ignoring!");
                        jarFile.close();
                        return null;
                    } else if (certificateArr == null) {
                        certificateArr = a;
                    } else {
                        for (int i = 0; i < certificateArr.length; i++) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= a.length) {
                                    z = false;
                                    break;
                                } else if (certificateArr[i] == null || !certificateArr[i].equals(a[i2])) {
                                    i2++;
                                } else {
                                    z = true;
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
            synchronized (mSync) {
                vW = weakReference;
            }
            if (certificateArr != null && certificateArr.length > 0) {
                int length = certificateArr.length;
                Signature[] signatureArr = new Signature[certificateArr.length];
                for (int i3 = 0; i3 < length; i3++) {
                    signatureArr[i3] = new Signature(certificateArr[i3].getEncoded());
                }
                return signatureArr;
            }
            BdLog.e("Package " + str + " has no certificates; ignoring!");
            return null;
        } catch (IOException e) {
            BdLog.e("Exception reading " + str + "----" + e.getMessage());
            throw e;
        } catch (RuntimeException e2) {
            BdLog.e("Exception reading " + str + "----" + e2.getMessage());
            throw e2;
        } catch (CertificateEncodingException e3) {
            BdLog.e("Exception reading " + str + "----" + e3.getMessage());
            throw e3;
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        Throwable th;
        RuntimeException e;
        IOException e2;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                do {
                    try {
                    } catch (IOException e3) {
                        e2 = e3;
                        BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e2.getMessage());
                        throw e2;
                    } catch (RuntimeException e4) {
                        e = e4;
                        BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
                        throw e;
                    }
                } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
                Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
                com.baidu.adp.lib.h.a.c(bufferedInputStream);
                return certificates;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.h.a.c(null);
                throw th;
            }
        } catch (IOException e5) {
            e2 = e5;
        } catch (RuntimeException e6) {
            e = e6;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.h.a.c(null);
            throw th;
        }
    }
}
