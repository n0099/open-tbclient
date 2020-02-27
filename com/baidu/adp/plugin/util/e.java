package com.baidu.adp.plugin.util;

import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes.dex */
public final class e {
    private static Object mSync = new Object();
    private static WeakReference<byte[]> zC;

    public static Signature[] a(String str, Util.a aVar) throws CertificateEncodingException, IOException {
        byte[] bArr;
        byte[] bArr2;
        WeakReference<byte[]> weakReference;
        Certificate[] a;
        Certificate[] certificateArr;
        boolean z;
        if (TextUtils.isEmpty(str) || aVar == null) {
            return null;
        }
        synchronized (mSync) {
            WeakReference<byte[]> weakReference2 = zC;
            if (weakReference2 != null) {
                zC = null;
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
            aVar.step = 1;
            Enumeration<JarEntry> entries = jarFile.entries();
            Certificate[] certificateArr2 = null;
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory()) {
                    String name = nextElement.getName();
                    if (name.startsWith("META-INF/")) {
                        continue;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("jarFile_");
                        sb.append(jarFile.getName());
                        sb.append("-JarEntry_");
                        sb.append(name);
                        aVar.error = sb.toString();
                        aVar.step = 2;
                        try {
                            a = a(jarFile, nextElement, bArr2, aVar);
                        } catch (Exception e) {
                            sb.append("-Exception_");
                            sb.append(e.toString());
                            aVar.error = sb.toString();
                            a = a(jarFile, nextElement, bArr2, aVar);
                        }
                        aVar.step = 5;
                        if (a == null) {
                            aVar.step = 6;
                            BdLog.e("Package " + str + " has no certificates at entry " + nextElement.getName() + "; ignoring!");
                            jarFile.close();
                            return null;
                        }
                        if (certificateArr2 == null) {
                            certificateArr = a;
                        } else {
                            for (int i = 0; i < certificateArr2.length; i++) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= a.length) {
                                        z = false;
                                        break;
                                    } else if (certificateArr2[i] != null && certificateArr2[i].equals(a[i2])) {
                                        z = true;
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                if (!z || certificateArr2.length != a.length) {
                                    aVar.step = 7;
                                    jarFile.close();
                                    return null;
                                }
                            }
                            certificateArr = certificateArr2;
                        }
                        certificateArr2 = certificateArr;
                    }
                }
            }
            aVar.step = 8;
            jarFile.close();
            synchronized (mSync) {
                zC = weakReference;
            }
            aVar.step = 9;
            if (certificateArr2 != null && certificateArr2.length > 0) {
                int length = certificateArr2.length;
                Signature[] signatureArr = new Signature[certificateArr2.length];
                for (int i3 = 0; i3 < length; i3++) {
                    signatureArr[i3] = new Signature(certificateArr2[i3].getEncoded());
                }
                return signatureArr;
            }
            BdLog.e("Package " + str + " has no certificates; ignoring!");
            return null;
        } catch (IOException e2) {
            BdLog.e("Exception reading " + str + "----" + e2.getMessage());
            throw e2;
        } catch (RuntimeException e3) {
            BdLog.e("Exception reading " + str + "----" + e3.getMessage());
            throw e3;
        } catch (CertificateEncodingException e4) {
            BdLog.e("Exception reading " + str + "----" + e4.getMessage());
            throw e4;
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr, Util.a aVar) throws IOException {
        Throwable th;
        RuntimeException e;
        IOException e2;
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.close((InputStream) null);
                throw th;
            }
        } catch (IOException e3) {
            e2 = e3;
        } catch (RuntimeException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.f.a.close((InputStream) null);
            throw th;
        }
        try {
            aVar.step = 3;
            do {
            } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
            aVar.step = 4;
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            com.baidu.adp.lib.f.a.close((InputStream) bufferedInputStream);
            return certificates;
        } catch (IOException e5) {
            e2 = e5;
            BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e2.getMessage());
            throw e2;
        } catch (RuntimeException e6) {
            e = e6;
            BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
            throw e;
        }
    }
}
