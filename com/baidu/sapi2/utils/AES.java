package com.baidu.sapi2.utils;

import com.baidu.sapi2.base.debug.Log;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class AES {
    private static final String DEFAULT_ALGORITHM = "AES";
    private static final String DEFAULT_ALGORITHM_MODE = "AES/CBC/NoPadding";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private String algorithm;
    private String algorithmMode;
    private String encoding;

    public AES() {
        this("AES", DEFAULT_ALGORITHM_MODE, "UTF-8");
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.encoding = "UTF-8";
        this.algorithmMode = DEFAULT_ALGORITHM_MODE;
        this.algorithm = "AES";
        this.algorithm = str;
        this.algorithmMode = str2;
        this.encoding = str3;
    }

    public byte[] encrypt(String str, String str2, String str3) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.encoding));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.algorithm);
            Cipher cipher = Cipher.getInstance(this.algorithmMode);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(padString(str).getBytes());
        } catch (NoSuchAlgorithmException e) {
            Log.e(Log.TAG, e.toString());
            return null;
        } catch (NoSuchPaddingException e2) {
            Log.e(Log.TAG, e2.toString());
            return null;
        }
    }

    public byte[] decrypt(byte[] bArr, String str, String str2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("Empty string");
        }
        byte[] bArr2 = new byte[0];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.encoding));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.algorithm);
            Cipher cipher = Cipher.getInstance(this.algorithmMode);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            Log.e(Log.TAG, th.toString());
            return bArr2;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [104=4] */
    public void decryptFile(java.lang.String r8, java.lang.String r9, java.lang.String r10) throws java.lang.Exception {
        /*
            r7 = this;
            r2 = 0
            javax.crypto.spec.SecretKeySpec r0 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L89
            byte[] r1 = r10.getBytes()     // Catch: java.lang.Throwable -> L89
            java.lang.String r3 = r7.algorithm     // Catch: java.lang.Throwable -> L89
            r0.<init>(r1, r3)     // Catch: java.lang.Throwable -> L89
            java.lang.String r1 = r7.algorithm     // Catch: java.lang.Throwable -> L89
            javax.crypto.Cipher r5 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Throwable -> L89
            r1 = 2
            r5.init(r1, r0)     // Catch: java.lang.Throwable -> L89
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L89
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L89
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L8d
            r1.<init>(r9)     // Catch: java.lang.Throwable -> L8d
            javax.crypto.CipherOutputStream r3 = new javax.crypto.CipherOutputStream     // Catch: java.lang.Throwable -> L91
            r3.<init>(r1, r5)     // Catch: java.lang.Throwable -> L91
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L34
        L29:
            int r2 = r4.read(r0)     // Catch: java.lang.Throwable -> L34
            if (r2 < 0) goto L57
            r5 = 0
            r3.write(r0, r5, r2)     // Catch: java.lang.Throwable -> L34
            goto L29
        L34:
            r0 = move-exception
            r2 = r3
            r3 = r4
        L37:
            java.lang.String r4 = "SAPI"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L84
            r6 = 0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L84
            r5[r6] = r0     // Catch: java.lang.Throwable -> L84
            com.baidu.sapi2.base.debug.Log.e(r4, r5)     // Catch: java.lang.Throwable -> L84
            if (r2 == 0) goto L4c
            r2.close()
        L4c:
            if (r1 == 0) goto L51
            r1.close()
        L51:
            if (r3 == 0) goto L56
            r3.close()
        L56:
            return
        L57:
            if (r3 == 0) goto L5c
            r3.close()
        L5c:
            if (r1 == 0) goto L61
            r1.close()
        L61:
            if (r4 == 0) goto L56
            r4.close()
            goto L56
        L67:
            r0 = move-exception
            r3 = r2
            r4 = r2
        L6a:
            if (r3 == 0) goto L6f
            r3.close()
        L6f:
            if (r2 == 0) goto L74
            r2.close()
        L74:
            if (r4 == 0) goto L79
            r4.close()
        L79:
            throw r0
        L7a:
            r0 = move-exception
            r3 = r2
            goto L6a
        L7d:
            r0 = move-exception
            r3 = r2
            r2 = r1
            goto L6a
        L81:
            r0 = move-exception
            r2 = r1
            goto L6a
        L84:
            r0 = move-exception
            r4 = r3
            r3 = r2
            r2 = r1
            goto L6a
        L89:
            r0 = move-exception
            r1 = r2
            r3 = r2
            goto L37
        L8d:
            r0 = move-exception
            r1 = r2
            r3 = r4
            goto L37
        L91:
            r0 = move-exception
            r3 = r4
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.AES.decryptFile(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static String padString(String str) {
        int length = 16 - (str.getBytes().length % 16);
        for (int i = 0; i < length; i++) {
            str = str + ' ';
        }
        return str;
    }
}
