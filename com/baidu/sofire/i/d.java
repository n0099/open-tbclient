package com.baidu.sofire.i;

import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes12.dex */
public final class d {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.security.cert.Certificate[] a(java.util.jar.JarFile r5, java.util.jar.JarEntry r6, byte[] r7) {
        /*
            r3 = 0
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L28
            java.io.InputStream r2 = r5.getInputStream(r6)     // Catch: java.lang.Throwable -> L28
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L28
        Lb:
            r0 = 0
            r2 = 8192(0x2000, float:1.148E-41)
            int r0 = r1.read(r7, r0, r2)     // Catch: java.lang.Throwable -> L4f
            r2 = -1
            if (r0 != r2) goto Lb
            if (r6 == 0) goto L1f
            java.security.cert.Certificate[] r0 = r6.getCertificates()     // Catch: java.lang.Throwable -> L4f
        L1b:
            r1.close()     // Catch: java.lang.Throwable -> L23
        L1e:
            return r0
        L1f:
            r0 = 0
            java.security.cert.Certificate[] r0 = new java.security.cert.Certificate[r0]     // Catch: java.lang.Throwable -> L4f
            goto L1b
        L23:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L1e
        L28:
            r1 = move-exception
        L29:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L31
            r0.close()     // Catch: java.lang.Throwable -> L34
        L31:
            java.security.cert.Certificate[] r0 = new java.security.cert.Certificate[r3]
            goto L1e
        L34:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L31
        L39:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L3d:
            if (r1 == 0) goto L42
            r1.close()     // Catch: java.lang.Throwable -> L43
        L42:
            throw r0
        L43:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L42
        L48:
            r0 = move-exception
            goto L3d
        L4a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L3d
        L4f:
            r0 = move-exception
            r0 = r1
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.d.a(java.util.jar.JarFile, java.util.jar.JarEntry, byte[]):java.security.cert.Certificate[]");
    }

    public static PublicKey a(Signature signature) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
        try {
            byteArrayInputStream.close();
        } catch (Throwable th) {
            e.a();
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
                    if (a == null || a.length <= 0) {
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
