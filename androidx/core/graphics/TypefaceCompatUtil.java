package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
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
/* loaded from: classes14.dex */
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [87=4] */
    @Nullable
    @RequiresApi(19)
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [107=5, 108=7] */
    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(19)
    public static java.nio.ByteBuffer mmap(android.content.Context r11, android.os.CancellationSignal r12, android.net.Uri r13) {
        /*
            r6 = 0
            android.content.ContentResolver r0 = r11.getContentResolver()
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r7 = r0.openFileDescriptor(r13, r1, r12)     // Catch: java.io.IOException -> L1d
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
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch: java.lang.Throwable -> L6f
            long r4 = r0.size()     // Catch: java.lang.Throwable -> L6f
            java.nio.channels.FileChannel$MapMode r1 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L6f
            r2 = 0
            java.nio.MappedByteBuffer r0 = r0.map(r1, r2, r4)     // Catch: java.lang.Throwable -> L6f
            if (r9 == 0) goto L45
            if (r6 == 0) goto L63
            r9.close()     // Catch: java.lang.Throwable -> L52
        L45:
            if (r7 == 0) goto L17
            if (r6 == 0) goto L6b
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
            r2 = r0
        L5b:
            if (r7 == 0) goto L62
            if (r2 == 0) goto L89
            r7.close()     // Catch: java.lang.Throwable -> L84
        L62:
            throw r1     // Catch: java.io.IOException -> L1d
        L63:
            r9.close()     // Catch: java.lang.Throwable -> L57
            goto L45
        L67:
            r0 = move-exception
            r1 = r0
            r2 = r6
            goto L5b
        L6b:
            r7.close()     // Catch: java.io.IOException -> L1d
            goto L17
        L6f:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L71
        L71:
            r1 = move-exception
            r2 = r0
        L73:
            if (r9 == 0) goto L7a
            if (r2 == 0) goto L80
            r9.close()     // Catch: java.lang.Throwable -> L7b
        L7a:
            throw r1     // Catch: java.lang.Throwable -> L57
        L7b:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch: java.lang.Throwable -> L57
            goto L7a
        L80:
            r9.close()     // Catch: java.lang.Throwable -> L57
            goto L7a
        L84:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch: java.io.IOException -> L1d
            goto L62
        L89:
            r7.close()     // Catch: java.io.IOException -> L1d
            goto L62
        L8d:
            r0 = move-exception
            r1 = r0
            r2 = r6
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatUtil.mmap(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    @Nullable
    @RequiresApi(19)
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [151=4] */
    public static boolean copyToFile(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            closeQuietly(fileOutputStream);
                            StrictMode.setThreadPolicy(allowThreadDiskWrites);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    Log.e(TAG, "Error copying resource contents to temp file: " + e.getMessage());
                    closeQuietly(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                closeQuietly(null);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(null);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
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
