package com.baidu.sofire.i;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public final class a {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.e.q);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] doFinal = cipher.doFinal(bArr2);
            byte[] b = p.b(bArr2);
            byte[] bArr4 = new byte[doFinal.length + b.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(b, 0, bArr4, doFinal.length, b.length);
            return bArr4;
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.e.q);
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

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.e.q);
            Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.e.q);
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
            if (r10 == 0) goto Ld
            boolean r2 = r10.exists()
            if (r2 != 0) goto Lf
        Ld:
            r0 = r1
        Le:
            return r0
        Lf:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8c
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L8c
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8f
            r2.<init>(r11)     // Catch: java.lang.Throwable -> L8f
            r3 = 8192(0x2000, float:1.148E-41)
            byte[] r5 = new byte[r3]     // Catch: java.lang.Throwable -> L4c
        L1d:
            int r6 = r4.read(r5)     // Catch: java.lang.Throwable -> L4c
            if (r6 == r1) goto L60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r3.<init>()     // Catch: java.lang.Throwable -> L4c
            r3.append(r6)     // Catch: java.lang.Throwable -> L4c
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L4c
            if (r6 >= r9) goto L5e
            byte[] r3 = new byte[r6]     // Catch: java.lang.Throwable -> L4c
            r7 = 0
            r8 = 0
            java.lang.System.arraycopy(r5, r7, r3, r8, r6)     // Catch: java.lang.Throwable -> L4c
        L37:
            r6 = 0
            byte[] r3 = a(r12, r3, r6)     // Catch: java.lang.Throwable -> L4c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r6.<init>()     // Catch: java.lang.Throwable -> L4c
            int r7 = r3.length     // Catch: java.lang.Throwable -> L4c
            r6.append(r7)     // Catch: java.lang.Throwable -> L4c
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L4c
            r2.write(r3)     // Catch: java.lang.Throwable -> L4c
            goto L1d
        L4c:
            r0 = move-exception
            r0 = r2
            r3 = r4
        L4f:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L87
            if (r3 == 0) goto L57
            r3.close()     // Catch: java.lang.Throwable -> L7c
        L57:
            if (r0 == 0) goto L5c
            r0.close()     // Catch: java.lang.Throwable -> L69
        L5c:
            r0 = r1
            goto Le
        L5e:
            r3 = r5
            goto L37
        L60:
            r4.close()     // Catch: java.lang.Throwable -> L7a
        L63:
            r2.close()     // Catch: java.lang.Throwable -> L67
            goto Le
        L67:
            r1 = move-exception
            goto Le
        L69:
            r0 = move-exception
            r0 = r1
            goto Le
        L6c:
            r0 = move-exception
            r2 = r3
            r4 = r3
        L6f:
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.lang.Throwable -> L7e
        L74:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.lang.Throwable -> L80
        L79:
            throw r0
        L7a:
            r1 = move-exception
            goto L63
        L7c:
            r2 = move-exception
            goto L57
        L7e:
            r1 = move-exception
            goto L74
        L80:
            r1 = move-exception
            goto L79
        L82:
            r0 = move-exception
            r2 = r3
            goto L6f
        L85:
            r0 = move-exception
            goto L6f
        L87:
            r1 = move-exception
            r2 = r0
            r4 = r3
            r0 = r1
            goto L6f
        L8c:
            r0 = move-exception
            r0 = r3
            goto L4f
        L8f:
            r0 = move-exception
            r0 = r3
            r3 = r4
            goto L4f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.a.a(java.io.File, java.io.File, byte[]):int");
    }
}
