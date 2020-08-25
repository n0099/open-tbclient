package com.baidu.swan.apps.impl.a;

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
    private static final byte[] csQ = {31, -117};

    public static String md5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
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
    public static java.io.File b(byte[] r14, java.io.File r15) {
        /*
            r4 = 2
            r3 = 1
            r2 = 0
            r1 = 0
            if (r14 == 0) goto L9
            int r0 = r14.length
            if (r0 >= r4) goto Lb
        L9:
            r0 = r1
        La:
            return r0
        Lb:
            if (r15 == 0) goto L13
            boolean r0 = r15.exists()
            if (r0 != 0) goto L15
        L13:
            r0 = r1
            goto La
        L15:
            byte[] r0 = com.baidu.swan.apps.impl.a.b.csQ
            r0 = r0[r2]
            r14[r2] = r0
            byte[] r0 = com.baidu.swan.apps.impl.a.b.csQ
            r0 = r0[r3]
            r14[r3] = r0
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L80
            r3.<init>(r14)     // Catch: java.lang.Exception -> L80
            r2 = 0
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L72
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L72
            r5 = 0
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L64
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L64
            r7 = 0
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L56
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L56
            r9 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            r0.<init>()     // Catch: java.lang.Throwable -> L48
        L3e:
            java.lang.String r10 = r8.readLine()     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto L8a
            r0.append(r10)     // Catch: java.lang.Throwable -> L48
            goto L3e
        L48:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L4a
        L4a:
            r2 = move-exception
            r13 = r2
            r2 = r0
            r0 = r13
        L4e:
            if (r8 == 0) goto L55
            if (r2 == 0) goto L147
            r8.close()     // Catch: java.lang.Throwable -> L141
        L55:
            throw r0     // Catch: java.lang.Throwable -> L56
        L56:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L58
        L58:
            r2 = move-exception
            r13 = r2
            r2 = r0
            r0 = r13
        L5c:
            if (r6 == 0) goto L63
            if (r2 == 0) goto L152
            r6.close()     // Catch: java.lang.Throwable -> L14c
        L63:
            throw r0     // Catch: java.lang.Throwable -> L64
        L64:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L66
        L66:
            r2 = move-exception
            r13 = r2
            r2 = r0
            r0 = r13
        L6a:
            if (r4 == 0) goto L71
            if (r2 == 0) goto L15d
            r4.close()     // Catch: java.lang.Throwable -> L157
        L71:
            throw r0     // Catch: java.lang.Throwable -> L72
        L72:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L74
        L74:
            r2 = move-exception
            r13 = r2
            r2 = r0
            r0 = r13
        L78:
            if (r3 == 0) goto L7f
            if (r2 == 0) goto L168
            r3.close()     // Catch: java.lang.Throwable -> L162
        L7f:
            throw r0     // Catch: java.lang.Exception -> L80
        L80:
            r0 = move-exception
            boolean r2 = com.baidu.swan.apps.impl.a.b.DEBUG
            if (r2 == 0) goto L88
            r0.printStackTrace()
        L88:
            r0 = r1
            goto La
        L8a:
            boolean r10 = com.baidu.swan.apps.impl.a.b.DEBUG     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto Lad
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
        Lad:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L48
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = com.baidu.swan.apps.impl.a.a.a.ctd     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L48
            boolean r10 = com.baidu.swan.apps.impl.a.b.DEBUG     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto Lc6
            java.lang.String r10 = "SwanAppCloneModule"
            android.util.Log.d(r10, r0)     // Catch: java.lang.Throwable -> L48
        Lc6:
            r10 = 2
            javax.crypto.Cipher r10 = hF(r10)     // Catch: java.lang.Throwable -> L48
            r11 = 0
            byte[] r0 = android.util.Base64.decode(r0, r11)     // Catch: java.lang.Throwable -> L48
            byte[] r10 = r10.doFinal(r0)     // Catch: java.lang.Throwable -> L48
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L48
            java.lang.String r11 = com.baidu.swan.apps.impl.a.a.a.ctd     // Catch: java.lang.Throwable -> L48
            r0.<init>(r15, r11)     // Catch: java.lang.Throwable -> L48
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48
            r11.<init>(r0)     // Catch: java.lang.Throwable -> L48
            r11.write(r10)     // Catch: java.lang.Throwable -> L48
            boolean r10 = com.baidu.swan.apps.impl.a.b.DEBUG     // Catch: java.lang.Throwable -> L48
            if (r10 == 0) goto Lf1
            java.lang.String r10 = "SwanAppCloneModule"
            java.lang.String r11 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L48
            android.util.Log.d(r10, r11)     // Catch: java.lang.Throwable -> L48
        Lf1:
            if (r8 == 0) goto Lf8
            if (r1 == 0) goto L11e
            r8.close()     // Catch: java.lang.Throwable -> L115
        Lf8:
            if (r6 == 0) goto Lff
            if (r1 == 0) goto L12b
            r6.close()     // Catch: java.lang.Throwable -> L122
        Lff:
            if (r4 == 0) goto L106
            if (r1 == 0) goto L138
            r4.close()     // Catch: java.lang.Throwable -> L12f
        L106:
            if (r3 == 0) goto La
            if (r1 == 0) goto L13c
            r3.close()     // Catch: java.lang.Throwable -> L10f
            goto La
        L10f:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.lang.Exception -> L80
            goto La
        L115:
            r8 = move-exception
            r9.addSuppressed(r8)     // Catch: java.lang.Throwable -> L56
            goto Lf8
        L11a:
            r0 = move-exception
            r2 = r1
            goto L5c
        L11e:
            r8.close()     // Catch: java.lang.Throwable -> L56
            goto Lf8
        L122:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch: java.lang.Throwable -> L64
            goto Lff
        L127:
            r0 = move-exception
            r2 = r1
            goto L6a
        L12b:
            r6.close()     // Catch: java.lang.Throwable -> L64
            goto Lff
        L12f:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch: java.lang.Throwable -> L72
            goto L106
        L134:
            r0 = move-exception
            r2 = r1
            goto L78
        L138:
            r4.close()     // Catch: java.lang.Throwable -> L72
            goto L106
        L13c:
            r3.close()     // Catch: java.lang.Exception -> L80
            goto La
        L141:
            r5 = move-exception
            r2.addSuppressed(r5)     // Catch: java.lang.Throwable -> L56
            goto L55
        L147:
            r8.close()     // Catch: java.lang.Throwable -> L56
            goto L55
        L14c:
            r5 = move-exception
            r2.addSuppressed(r5)     // Catch: java.lang.Throwable -> L64
            goto L63
        L152:
            r6.close()     // Catch: java.lang.Throwable -> L64
            goto L63
        L157:
            r4 = move-exception
            r2.addSuppressed(r4)     // Catch: java.lang.Throwable -> L72
            goto L71
        L15d:
            r4.close()     // Catch: java.lang.Throwable -> L72
            goto L71
        L162:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.lang.Exception -> L80
            goto L7f
        L168:
            r3.close()     // Catch: java.lang.Exception -> L80
            goto L7f
        L16d:
            r0 = move-exception
            r2 = r1
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.a.b.b(byte[], java.io.File):java.io.File");
    }

    private static Cipher hF(int i) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(i, new SecretKeySpec(md5("la32118_p9d8#*!6)".getBytes()).substring(16).getBytes(), e.q), new IvParameterSpec("2081147213143090".getBytes()));
        return cipher;
    }
}
