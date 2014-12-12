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
public final class f {
    private static Object tP = new Object();
    private static WeakReference<byte[]> tQ;

    public static Signature[] bw(String str) {
        byte[] bArr;
        byte[] bArr2;
        WeakReference<byte[]> weakReference;
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (tP) {
            WeakReference<byte[]> weakReference2 = tQ;
            if (weakReference2 != null) {
                tQ = null;
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
            synchronized (tP) {
                tQ = weakReference;
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
            return null;
        } catch (RuntimeException e2) {
            BdLog.e("Exception reading " + str + "----" + e2.getMessage());
            return null;
        } catch (CertificateEncodingException e3) {
            BdLog.e("Exception reading " + str + "----" + e3.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [140=5] */
    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                do {
                    try {
                    } catch (IOException e) {
                        e = e;
                        BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
                        com.baidu.adp.lib.g.a.d(bufferedInputStream);
                        return r0;
                    } catch (RuntimeException e2) {
                        e = e2;
                        BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
                        com.baidu.adp.lib.g.a.d(bufferedInputStream);
                        return r0;
                    } catch (Exception e3) {
                        e = e3;
                        BdLog.e("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + "----" + e.getMessage());
                        com.baidu.adp.lib.g.a.d(bufferedInputStream);
                        return r0;
                    }
                } while (bufferedInputStream.read(bArr, 0, bArr.length) != -1);
                r0 = jarEntry != null ? jarEntry.getCertificates() : null;
                com.baidu.adp.lib.g.a.d(bufferedInputStream);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.g.a.d(null);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedInputStream = null;
        } catch (RuntimeException e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (Exception e6) {
            e = e6;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.adp.lib.g.a.d(null);
            throw th;
        }
        return r0;
    }
}
