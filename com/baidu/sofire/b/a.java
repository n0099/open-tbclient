package com.baidu.sofire.b;

import com.baidu.sapi2.utils.SapiEnv;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class a {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] doFinal = cipher.doFinal(bArr2);
            byte[] c = o.c(bArr2);
            byte[] bArr4 = new byte[doFinal.length + c.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(c, 0, bArr4, doFinal.length, c.length);
            return bArr4;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    public static byte[] a(String str, String str2, byte[] bArr) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance(SapiEnv.SHARE_AES_MODE);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z) {
                byte[] bArr4 = new byte[bArr2.length - 16];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static int a(java.io.File r10, java.io.File r11, byte[] r12) {
        /*
            r3 = 0
            r9 = 8192(0x2000, float:1.148E-41)
            r1 = -1
            r0 = 0
            boolean r2 = r10.exists()
            if (r2 != 0) goto Lc
        Lb:
            return r1
        Lc:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8a
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L8a
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8d
            r2.<init>(r11)     // Catch: java.lang.Throwable -> L8d
            r3 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L49
        L1a:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L49
            if (r6 == r1) goto L5e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r3.<init>()     // Catch: java.lang.Throwable -> L49
            r3.append(r6)     // Catch: java.lang.Throwable -> L49
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L49
            if (r6 >= r9) goto L5c
            byte[] r3 = new byte[r6]     // Catch: java.lang.Throwable -> L49
            r7 = 0
            r8 = 0
            java.lang.System.arraycopy(r5, r7, r3, r8, r6)     // Catch: java.lang.Throwable -> L49
        L34:
            r6 = 0
            byte[] r3 = a(r12, r3, r6)     // Catch: java.lang.Throwable -> L49
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r6.<init>()     // Catch: java.lang.Throwable -> L49
            int r7 = r3.length     // Catch: java.lang.Throwable -> L49
            r6.append(r7)     // Catch: java.lang.Throwable -> L49
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L49
            r2.write(r3)     // Catch: java.lang.Throwable -> L49
            goto L1a
        L49:
            r0 = move-exception
            r0 = r2
            r3 = r4
        L4c:
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto L54
            r3.close()     // Catch: java.lang.Throwable -> L7a
        L54:
            if (r0 == 0) goto L59
            r0.close()     // Catch: java.lang.Throwable -> L67
        L59:
            r0 = r1
        L5a:
            r1 = r0
            goto Lb
        L5c:
            r3 = r5
            goto L34
        L5e:
            r4.close()     // Catch: java.lang.Throwable -> L78
        L61:
            r2.close()     // Catch: java.lang.Throwable -> L65
            goto L5a
        L65:
            r1 = move-exception
            goto L5a
        L67:
            r0 = move-exception
            r0 = r1
            goto L5a
        L6a:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L6d:
            if (r4 == 0) goto L72
            r4.close()     // Catch: java.lang.Throwable -> L7c
        L72:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.lang.Throwable -> L7e
        L77:
            throw r0
        L78:
            r1 = move-exception
            goto L61
        L7a:
            r2 = move-exception
            goto L54
        L7c:
            r1 = move-exception
            goto L72
        L7e:
            r1 = move-exception
            goto L77
        L80:
            r0 = move-exception
            r2 = r3
            goto L6d
        L83:
            r0 = move-exception
            goto L6d
        L85:
            r1 = move-exception
            r2 = r0
            r4 = r3
            r0 = r1
            goto L6d
        L8a:
            r0 = move-exception
            r0 = r3
            goto L4c
        L8d:
            r0 = move-exception
            r0 = r3
            r3 = r4
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.a(java.io.File, java.io.File, byte[]):int");
    }
}
