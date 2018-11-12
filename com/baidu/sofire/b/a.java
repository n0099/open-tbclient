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
            byte[] d = o.d(bArr2);
            byte[] bArr4 = new byte[doFinal.length + d.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(d, 0, bArr4, doFinal.length, d.length);
            return bArr4;
        } catch (Throwable th) {
            e.a(th);
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
    public static int a(java.io.File r9, java.io.File r10, byte[] r11) {
        /*
            r3 = 0
            r1 = -1
            r0 = 0
            if (r9 == 0) goto Lb
            boolean r2 = r9.exists()
            if (r2 != 0) goto Ld
        Lb:
            r0 = r1
        Lc:
            return r0
        Ld:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> La4
            r4.<init>(r9)     // Catch: java.lang.Throwable -> La4
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La7
            r2.<init>(r10)     // Catch: java.lang.Throwable -> La7
            r3 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L63
        L1b:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L63
            if (r6 == r1) goto L76
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r7 = ""
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r3 = r3.append(r6)     // Catch: java.lang.Throwable -> L63
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L63
            com.baidu.sofire.b.a(r3)     // Catch: java.lang.Throwable -> L63
            int r3 = r5.length     // Catch: java.lang.Throwable -> L63
            if (r6 >= r3) goto L74
            byte[] r3 = new byte[r6]     // Catch: java.lang.Throwable -> L63
            r7 = 0
            r8 = 0
            java.lang.System.arraycopy(r5, r7, r3, r8, r6)     // Catch: java.lang.Throwable -> L63
        L42:
            r6 = 0
            byte[] r3 = a(r11, r3, r6)     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r6.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r7 = ""
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L63
            int r7 = r3.length     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L63
            com.baidu.sofire.b.a(r6)     // Catch: java.lang.Throwable -> L63
            r2.write(r3)     // Catch: java.lang.Throwable -> L63
            goto L1b
        L63:
            r0 = move-exception
            r3 = r4
        L65:
            com.baidu.sofire.b.e.a(r0)     // Catch: java.lang.Throwable -> La1
            if (r3 == 0) goto L6d
            r3.close()     // Catch: java.lang.Throwable -> L96
        L6d:
            if (r2 == 0) goto L72
            r2.close()     // Catch: java.lang.Throwable -> L83
        L72:
            r0 = r1
            goto Lc
        L74:
            r3 = r5
            goto L42
        L76:
            if (r4 == 0) goto L7b
            r4.close()     // Catch: java.lang.Throwable -> L94
        L7b:
            if (r2 == 0) goto Lc
            r2.close()     // Catch: java.lang.Throwable -> L81
            goto Lc
        L81:
            r1 = move-exception
            goto Lc
        L83:
            r0 = move-exception
            r0 = r1
            goto Lc
        L86:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L89:
            if (r4 == 0) goto L8e
            r4.close()     // Catch: java.lang.Throwable -> L98
        L8e:
            if (r2 == 0) goto L93
            r2.close()     // Catch: java.lang.Throwable -> L9a
        L93:
            throw r0
        L94:
            r1 = move-exception
            goto L7b
        L96:
            r0 = move-exception
            goto L6d
        L98:
            r1 = move-exception
            goto L8e
        L9a:
            r1 = move-exception
            goto L93
        L9c:
            r0 = move-exception
            r2 = r3
            goto L89
        L9f:
            r0 = move-exception
            goto L89
        La1:
            r0 = move-exception
            r4 = r3
            goto L89
        La4:
            r0 = move-exception
            r2 = r3
            goto L65
        La7:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L65
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.a.a(java.io.File, java.io.File, byte[]):int");
    }
}
