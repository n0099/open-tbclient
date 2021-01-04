package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class PassBioFileUtils {
    public static final String TAG = "PassBioFileUtils";

    public static boolean checkAndCreadFile(File file) throws IOException {
        if (file.exists()) {
            return true;
        }
        file.getParentFile().mkdirs();
        return file.createNewFile();
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (isFileExist(str)) {
            return deleteFile(new File(str));
        }
        return true;
    }

    public static boolean write(File file, byte[] bArr) throws IOException {
        return write(file, bArr, true);
    }

    public static boolean isFileExist(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static boolean write(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
        /*
            r0 = 0
            r2 = 0
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L12
            java.io.File r1 = r3.getParentFile()     // Catch: java.lang.Throwable -> L2e
            r1.mkdirs()     // Catch: java.lang.Throwable -> L2e
            r3.createNewFile()     // Catch: java.lang.Throwable -> L2e
        L12:
            boolean r1 = r3.canWrite()     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L19
        L18:
            return r0
        L19:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2e
            r1.<init>(r3, r5)     // Catch: java.lang.Throwable -> L2e
            r1.write(r4)     // Catch: java.lang.Throwable -> L36
            r1.close()
            r0 = 1
            goto L18
        L26:
            r0 = move-exception
            r1 = r2
        L28:
            if (r1 == 0) goto L2d
            r1.close()
        L2d:
            throw r0
        L2e:
            r1 = move-exception
            r1 = r2
        L30:
            if (r1 == 0) goto L18
            r1.close()
            goto L18
        L36:
            r2 = move-exception
            goto L30
        L38:
            r0 = move-exception
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.base.utils.PassBioFileUtils.write(java.io.File, byte[], boolean):boolean");
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            Log.e(e);
            return false;
        }
    }
}
