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
            byte[] c = n.c(bArr2);
            byte[] bArr4 = new byte[doFinal.length + c.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(c, 0, bArr4, doFinal.length, c.length);
            return bArr4;
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance(SapiEnv.SHARE_AES_MODE);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            e.a(th);
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
            e.a(th);
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
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L81
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L81
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L84
            r2.<init>(r11)     // Catch: java.lang.Throwable -> L84
            r3 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L43
        L1a:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L43
            if (r6 == r1) goto L57
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r3.<init>()     // Catch: java.lang.Throwable -> L43
            r3.append(r6)     // Catch: java.lang.Throwable -> L43
            if (r6 >= r9) goto L55
            byte[] r3 = new byte[r6]     // Catch: java.lang.Throwable -> L43
            r7 = 0
            r8 = 0
            java.lang.System.arraycopy(r5, r7, r3, r8, r6)     // Catch: java.lang.Throwable -> L43
        L31:
            r6 = 0
            byte[] r3 = a(r12, r3, r6)     // Catch: java.lang.Throwable -> L43
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r6.<init>()     // Catch: java.lang.Throwable -> L43
            int r7 = r3.length     // Catch: java.lang.Throwable -> L43
            r6.append(r7)     // Catch: java.lang.Throwable -> L43
            r2.write(r3)     // Catch: java.lang.Throwable -> L43
            goto L1a
        L43:
            r0 = move-exception
            r3 = r4
        L45:
            com.baidu.sofire.b.e.a(r0)     // Catch: java.lang.Throwable -> L7e
            if (r3 == 0) goto L4d
            r3.close()     // Catch: java.lang.Throwable -> L73
        L4d:
            if (r2 == 0) goto L52
            r2.close()     // Catch: java.lang.Throwable -> L60
        L52:
            r0 = r1
        L53:
            r1 = r0
            goto Lb
        L55:
            r3 = r5
            goto L31
        L57:
            r4.close()     // Catch: java.lang.Throwable -> L71
        L5a:
            r2.close()     // Catch: java.lang.Throwable -> L5e
            goto L53
        L5e:
            r1 = move-exception
            goto L53
        L60:
            r0 = move-exception
            r0 = r1
            goto L53
        L63:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L66:
            if (r4 == 0) goto L6b
            r4.close()     // Catch: java.lang.Throwable -> L75
        L6b:
            if (r2 == 0) goto L70
            r2.close()     // Catch: java.lang.Throwable -> L77
        L70:
            throw r0
        L71:
            r1 = move-exception
            goto L5a
        L73:
            r0 = move-exception
            goto L4d
        L75:
            r1 = move-exception
            goto L6b
        L77:
            r1 = move-exception
            goto L70
        L79:
            r0 = move-exception
            r2 = r3
            goto L66
        L7c:
            r0 = move-exception
            goto L66
        L7e:
            r0 = move-exception
            r4 = r3
            goto L66
        L81:
            r0 = move-exception
            r2 = r3
            goto L45
        L84:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.a(java.io.File, java.io.File, byte[]):int");
    }
}
