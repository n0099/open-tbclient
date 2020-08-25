package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class TypefaceCompatUtil {
    private static final String CACHE_FILE_PREFIX = ".font";
    private static final String TAG = "TypefaceCompatUtil";

    private TypefaceCompatUtil() {
    }

    @Nullable
    public static File getTempFile(Context context) {
        String str = CACHE_FILE_PREFIX + Process.myPid() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myTid() + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < 100) {
                File file = new File(context.getCacheDir(), str + i2);
                if (!file.createNewFile()) {
                    i = i2 + 1;
                } else {
                    return file;
                }
            } else {
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [85=4] */
    @RequiresApi(19)
    @Nullable
    private static ByteBuffer mmap(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
            if (fileInputStream != null) {
                if (0 != 0) {
                    fileInputStream.close();
                } else {
                    fileInputStream.close();
                }
            }
            return map;
        } catch (IOException e) {
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=5, 106=7] */
    @android.support.annotation.RequiresApi(19)
    @android.support.annotation.Nullable
    public static java.nio.ByteBuffer mmap(android.content.Context r12, android.os.CancellationSignal r13, android.net.Uri r14) {
        /*
            r6 = 0
            android.content.ContentResolver r0 = r12.getContentResolver()
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r7 = r0.openFileDescriptor(r14, r1, r13)     // Catch: java.io.IOException -> L1d
            r8 = 0
            if (r7 != 0) goto L24
            if (r7 == 0) goto L16
            if (r6 == 0) goto L20
            r7.close()     // Catch: java.lang.Throwable -> L18
        L16:
            r0 = r6
        L17:
            return r0
        L18:
            r0 = move-exception
            r8.addSuppressed(r0)     // Catch: java.io.IOException -> L1d
            goto L16
        L1d:
            r0 = move-exception
            r0 = r6
            goto L17
        L20:
            r7.close()     // Catch: java.io.IOException -> L1d
            goto L16
        L24:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L57
            java.io.FileDescriptor r0 = r7.getFileDescriptor()     // Catch: java.lang.Throwable -> L57
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L57
            r10 = 0
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch: java.lang.Throwable -> L70
            long r4 = r0.size()     // Catch: java.lang.Throwable -> L70
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L70
            r2 = 0
            java.nio.MappedByteBuffer r0 = r0.map(r1, r2, r4)     // Catch: java.lang.Throwable -> L70
            if (r9 == 0) goto L45
            if (r6 == 0) goto L65
            r9.close()     // Catch: java.lang.Throwable -> L52
        L45:
            if (r7 == 0) goto L17
            if (r6 == 0) goto L6c
            r7.close()     // Catch: java.lang.Throwable -> L4d
            goto L17
        L4d:
            r1 = move-exception
            r8.addSuppressed(r1)     // Catch: java.io.IOException -> L1d
            goto L17
        L52:
            r1 = move-exception
            r10.addSuppressed(r1)     // Catch: java.lang.Throwable -> L57
            goto L45
        L57:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L59
        L59:
            r1 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L5d:
            if (r7 == 0) goto L64
            if (r1 == 0) goto L8c
            r7.close()     // Catch: java.lang.Throwable -> L87
        L64:
            throw r0     // Catch: java.io.IOException -> L1d
        L65:
            r9.close()     // Catch: java.lang.Throwable -> L57
            goto L45
        L69:
            r0 = move-exception
            r1 = r6
            goto L5d
        L6c:
            r7.close()     // Catch: java.io.IOException -> L1d
            goto L17
        L70:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L72
        L72:
            r1 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
        L76:
            if (r9 == 0) goto L7d
            if (r1 == 0) goto L83
            r9.close()     // Catch: java.lang.Throwable -> L7e
        L7d:
            throw r0     // Catch: java.lang.Throwable -> L57
        L7e:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch: java.lang.Throwable -> L57
            goto L7d
        L83:
            r9.close()     // Catch: java.lang.Throwable -> L57
            goto L7d
        L87:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch: java.io.IOException -> L1d
            goto L64
        L8c:
            r7.close()     // Catch: java.io.IOException -> L1d
            goto L64
        L90:
            r0 = move-exception
            r1 = r6
            goto L76
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatUtil.mmap(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    @RequiresApi(19)
    @Nullable
    public static ByteBuffer copyToDirectBuffer(Context context, Resources resources, int i) {
        ByteBuffer byteBuffer = null;
        File tempFile = getTempFile(context);
        if (tempFile != null) {
            try {
                if (copyToFile(tempFile, resources, i)) {
                    byteBuffer = mmap(tempFile);
                }
            } finally {
                tempFile.delete();
            }
        }
        return byteBuffer;
    }

    public static boolean copyToFile(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, false);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            closeQuietly(fileOutputStream);
                            return true;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
                    closeQuietly(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public static boolean copyToFile(File file, Resources resources, int i) {
        InputStream inputStream = null;
        try {
            inputStream = resources.openRawResource(i);
            return copyToFile(file, inputStream);
        } finally {
            closeQuietly(inputStream);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
