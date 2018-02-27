package com.baidu.sapi2.base.utils;

import com.baidu.sapi2.base.debug.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class FileUtil {
    public static boolean deleteFile(String str) {
        if (TextUtil.isNullOrEmptyWithoutTrim(str)) {
            return false;
        }
        if (!isFileExist(str)) {
            return true;
        }
        return deleteFile(new File(str));
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            Log.i(Log.TAG, e);
            return false;
        }
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [67=4] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String read(String str) throws IOException {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    String str2 = new String(bArr);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return str2;
                    }
                    return str2;
                } catch (Exception e) {
                    e = e;
                    Log.e(e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static boolean write(File file, byte[] bArr) throws IOException {
        return write(file, bArr, true);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [114=5, 115=4] */
    public static boolean write(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.base.utils.FileUtil.write(java.io.File, byte[], boolean):boolean");
    }

    public static boolean isFileExist(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean checkAndCreadFile(File file) throws IOException {
        if (file.exists()) {
            return true;
        }
        file.getParentFile().mkdirs();
        return file.createNewFile();
    }
}
