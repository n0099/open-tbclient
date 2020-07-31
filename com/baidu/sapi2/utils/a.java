package com.baidu.sapi2.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes19.dex */
public final class a {
    private static final int a = 2048;

    public static boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            Log.i(Log.TAG, e);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5=4] */
    public static String b(String str) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e) {
            fileInputStream2 = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str2 = new String(bArr);
            fileInputStream.close();
            return str2;
        } catch (Exception e2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
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
    public static boolean a(java.io.File r3, byte[] r4, boolean r5) throws java.io.IOException {
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.a.a(java.io.File, byte[], boolean):boolean");
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws Exception, IOException {
        int i = 0;
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 2048);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 2048);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    Log.e(Log.TAG, e);
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e2) {
                    Log.e(Log.TAG, e2);
                }
            }
        }
        bufferedOutputStream.flush();
        return i;
    }
}
