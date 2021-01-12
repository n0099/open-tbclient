package com.baidu.swan.apps.impl.a;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import com.baidu.sapi2.utils.e;
import com.baidu.swan.c.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final byte[] daO = {31, -117};

    public static String md5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            return d.toHexString(messageDigest.digest(), "", false);
        } catch (NoSuchAlgorithmException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [137=5, 108=8] */
    public static java.io.File b(byte[] r13, java.io.File r14) {
        /*
            r4 = 2
            r3 = 1
            r2 = 0
            r1 = 0
            if (r13 == 0) goto L9
            int r0 = r13.length
            if (r0 >= r4) goto Lb
        L9:
            r0 = r1
        La:
            return r0
        Lb:
            if (r14 == 0) goto L13
            boolean r0 = r14.exists()
            if (r0 != 0) goto L15
        L13:
            r0 = r1
            goto La
        L15:
            byte[] r0 = com.baidu.swan.apps.impl.a.b.daO
            r0 = r0[r2]
            r13[r2] = r0
            byte[] r0 = com.baidu.swan.apps.impl.a.b.daO
            r0 = r0[r3]
            r13[r3] = r0
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L78
            r4.<init>(r13)     // Catch: java.lang.Exception -> L78
            r2 = 0
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L6c
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L6c
            r3 = 0
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L60
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L60
            r7 = 0
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L54
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L54
            r9 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            r0.<init>()     // Catch: java.lang.Throwable -> L48
        L3e:
            java.lang.String r10 = r8.readLine()     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto L82
            r0.append(r10)     // Catch: java.lang.Throwable -> L48
            goto L3e
        L48:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L4a
        L4a:
            r2 = move-exception
            r3 = r0
        L4c:
            if (r8 == 0) goto L53
            if (r3 == 0) goto L142
            r8.close()     // Catch: java.lang.Throwable -> L13c
        L53:
            throw r2     // Catch: java.lang.Throwable -> L54
        L54:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L56
        L56:
            r2 = move-exception
            r3 = r0
        L58:
            if (r6 == 0) goto L5f
            if (r3 == 0) goto L14d
            r6.close()     // Catch: java.lang.Throwable -> L147
        L5f:
            throw r2     // Catch: java.lang.Throwable -> L60
        L60:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L62
        L62:
            r2 = move-exception
            r3 = r0
        L64:
            if (r5 == 0) goto L6b
            if (r3 == 0) goto L158
            r5.close()     // Catch: java.lang.Throwable -> L152
        L6b:
            throw r2     // Catch: java.lang.Throwable -> L6c
        L6c:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L6e
        L6e:
            r2 = move-exception
            r3 = r0
        L70:
            if (r4 == 0) goto L77
            if (r3 == 0) goto L163
            r4.close()     // Catch: java.lang.Throwable -> L15d
        L77:
            throw r2     // Catch: java.lang.Exception -> L78
        L78:
            r0 = move-exception
            boolean r2 = com.baidu.swan.apps.impl.a.b.DEBUG
            if (r2 == 0) goto L80
            r0.printStackTrace()
        L80:
            r0 = r1
            goto La
        L82:
            boolean r10 = com.baidu.swan.apps.impl.a.b.DEBUG     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto La5
            java.lang.String r10 = "SwanAppCloneModule"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            r11.<init>()     // Catch: java.lang.Throwable -> L48
            java.lang.String r12 = "first char:"
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L48
            r12 = 0
            char r12 = r0.charAt(r12)     // Catch: java.lang.Throwable -> L48
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Throwable -> L48
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L48
            android.util.Log.d(r10, r11)     // Catch: java.lang.Throwable -> L48
        La5:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L48
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = com.baidu.swan.apps.impl.a.a.a.dbb     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L48
            boolean r10 = com.baidu.swan.apps.impl.a.b.DEBUG     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto Lbe
            java.lang.String r10 = "SwanAppCloneModule"
            android.util.Log.d(r10, r0)     // Catch: java.lang.Throwable -> L48
        Lbe:
            r10 = 2
            javax.crypto.Cipher r10 = hp(r10)     // Catch: java.lang.Throwable -> L48
            r11 = 0
            byte[] r0 = android.util.Base64.decode(r0, r11)     // Catch: java.lang.Throwable -> L48
            byte[] r10 = r10.doFinal(r0)     // Catch: java.lang.Throwable -> L48
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L48
            java.lang.String r11 = com.baidu.swan.apps.impl.a.a.a.dbb     // Catch: java.lang.Throwable -> L48
            r0.<init>(r14, r11)     // Catch: java.lang.Throwable -> L48
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L48
            r11.write(r10)     // Catch: java.lang.Throwable -> L48
            boolean r10 = com.baidu.swan.apps.impl.a.b.DEBUG     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto Le9
            java.lang.String r10 = "SwanAppCloneModule"
            java.lang.String r11 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L48
            android.util.Log.d(r10, r11)     // Catch: java.lang.Throwable -> L48
        Le9:
            if (r8 == 0) goto Lf0
            if (r1 == 0) goto L117
            r8.close()     // Catch: java.lang.Throwable -> L10d
        Lf0:
            if (r6 == 0) goto Lf7
            if (r1 == 0) goto L125
            r6.close()     // Catch: java.lang.Throwable -> L11b
        Lf7:
            if (r5 == 0) goto Lfe
            if (r1 == 0) goto L133
            r5.close()     // Catch: java.lang.Throwable -> L129
        Lfe:
            if (r4 == 0) goto La
            if (r1 == 0) goto L137
            r4.close()     // Catch: java.lang.Throwable -> L107
            goto La
        L107:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.lang.Exception -> L78
            goto La
        L10d:
            r8 = move-exception
            r9.addSuppressed(r8)     // Catch: java.lang.Throwable -> L54
            goto Lf0
        L112:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L58
        L117:
            r8.close()     // Catch: java.lang.Throwable -> L54
            goto Lf0
        L11b:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch: java.lang.Throwable -> L60
            goto Lf7
        L120:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L64
        L125:
            r6.close()     // Catch: java.lang.Throwable -> L60
            goto Lf7
        L129:
            r5 = move-exception
            r3.addSuppressed(r5)     // Catch: java.lang.Throwable -> L6c
            goto Lfe
        L12e:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L70
        L133:
            r5.close()     // Catch: java.lang.Throwable -> L6c
            goto Lfe
        L137:
            r4.close()     // Catch: java.lang.Exception -> L78
            goto La
        L13c:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch: java.lang.Throwable -> L54
            goto L53
        L142:
            r8.close()     // Catch: java.lang.Throwable -> L54
            goto L53
        L147:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch: java.lang.Throwable -> L60
            goto L5f
        L14d:
            r6.close()     // Catch: java.lang.Throwable -> L60
            goto L5f
        L152:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch: java.lang.Throwable -> L6c
            goto L6b
        L158:
            r5.close()     // Catch: java.lang.Throwable -> L6c
            goto L6b
        L15d:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch: java.lang.Exception -> L78
            goto L77
        L163:
            r4.close()     // Catch: java.lang.Exception -> L78
            goto L77
        L168:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.a.b.b(byte[], java.io.File):java.io.File");
    }

    private static Cipher hp(int i) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(i, new SecretKeySpec(md5("la32118_p9d8#*!6)".getBytes()).substring(16).getBytes(), e.q), new IvParameterSpec("2081147213143090".getBytes()));
        return cipher;
    }
}
