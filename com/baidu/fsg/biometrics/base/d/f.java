package com.baidu.fsg.biometrics.base.d;

import android.content.Context;
import com.baidu.ar.util.Constants;
import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
public class f {
    public static final String a = "SapiBioFileUtils";
    public static final String b = "liveness_video.mp4";
    private static final String c = "BI0_VIDEO";

    private static String b(Context context) {
        return context.getDir(c, 0).getAbsolutePath();
    }

    public static String a(Context context) {
        return context.getDir(c, 0).getAbsolutePath();
    }

    public static String a(String str, String str2) {
        if (!str2.startsWith(Constants.DOT)) {
            str2 = Constants.DOT + str2;
        }
        return str + str2;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(String str) {
        if (c(str)) {
            return false;
        }
        if (!a(str)) {
            return true;
        }
        return a(new File(str));
    }

    public static boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            c.a(e);
            return false;
        }
    }

    public static boolean a(File file, byte[] bArr) throws IOException {
        return a(file, bArr, true);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [119=5, 120=4] */
    public static boolean a(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L12
            java.io.File r2 = r3.getParentFile()     // Catch: java.lang.Throwable -> L2d
            r2.mkdirs()     // Catch: java.lang.Throwable -> L2d
            r3.createNewFile()     // Catch: java.lang.Throwable -> L2d
        L12:
            boolean r2 = r3.canWrite()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L1e
            if (r1 == 0) goto L1d
            r1.close()
        L1d:
            return r0
        L1e:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2d
            r2.<init>(r3, r5)     // Catch: java.lang.Throwable -> L2d
            r2.write(r4)     // Catch: java.lang.Throwable -> L3e
            if (r2 == 0) goto L2b
            r2.close()
        L2b:
            r0 = 1
            goto L1d
        L2d:
            r2 = move-exception
        L2e:
            if (r1 == 0) goto L1d
            r1.close()
            goto L1d
        L34:
            r0 = move-exception
        L35:
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            throw r0
        L3b:
            r0 = move-exception
            r1 = r2
            goto L35
        L3e:
            r1 = move-exception
            r1 = r2
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.biometrics.base.d.f.a(java.io.File, byte[], boolean):boolean");
    }

    public static boolean b(File file) throws IOException {
        if (file.exists()) {
            return true;
        }
        file.getParentFile().mkdirs();
        return file.createNewFile();
    }

    public static boolean c(String str) {
        return str == null || "".equals(str);
    }
}
