package androidx.core.graphics;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes14.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi21Impl";

    private File getFile(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException e) {
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [82=4, 79=5] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public android.graphics.Typeface createFromFontInfo(android.content.Context r7, android.os.CancellationSignal r8, @androidx.annotation.NonNull androidx.core.provider.FontsContractCompat.FontInfo[] r9, int r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r9.length
            r2 = 1
            if (r1 >= r2) goto L6
        L5:
            return r0
        L6:
            androidx.core.provider.FontsContractCompat$FontInfo r1 = r6.findBestInfo(r9, r10)
            android.content.ContentResolver r2 = r7.getContentResolver()
            android.net.Uri r1 = r1.getUri()     // Catch: java.io.IOException -> L55
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r4 = r2.openFileDescriptor(r1, r3, r8)     // Catch: java.io.IOException -> L55
            r2 = 0
            java.io.File r1 = r6.getFile(r4)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L26
            boolean r3 = r1.canRead()     // Catch: java.lang.Throwable -> L49
            if (r3 != 0) goto L7c
        L26:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49
            java.io.FileDescriptor r1 = r4.getFileDescriptor()     // Catch: java.lang.Throwable -> L49
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L49
            r5 = 0
            android.graphics.Typeface r1 = super.createFromInputStream(r7, r3)     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L3b
            if (r0 == 0) goto L57
            r3.close()     // Catch: java.lang.Throwable -> L44
        L3b:
            if (r4 == 0) goto L42
            if (r0 == 0) goto L64
            r4.close()     // Catch: java.lang.Throwable -> L5f
        L42:
            r0 = r1
            goto L5
        L44:
            r3 = move-exception
            r5.addSuppressed(r3)     // Catch: java.lang.Throwable -> L49
            goto L3b
        L49:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L4b
        L4b:
            r2 = move-exception
            r3 = r1
        L4d:
            if (r4 == 0) goto L54
            if (r3 == 0) goto L98
            r4.close()     // Catch: java.lang.Throwable -> L93
        L54:
            throw r2     // Catch: java.io.IOException -> L55
        L55:
            r1 = move-exception
            goto L5
        L57:
            r3.close()     // Catch: java.lang.Throwable -> L49
            goto L3b
        L5b:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L4d
        L5f:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L55
            goto L42
        L64:
            r4.close()     // Catch: java.io.IOException -> L55
            goto L42
        L68:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L6a
        L6a:
            r1 = move-exception
        L6b:
            if (r3 == 0) goto L72
            if (r2 == 0) goto L78
            r3.close()     // Catch: java.lang.Throwable -> L73
        L72:
            throw r1     // Catch: java.lang.Throwable -> L49
        L73:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.lang.Throwable -> L49
            goto L72
        L78:
            r3.close()     // Catch: java.lang.Throwable -> L49
            goto L72
        L7c:
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r1)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L87
            if (r0 == 0) goto L8f
            r4.close()     // Catch: java.lang.Throwable -> L8a
        L87:
            r0 = r1
            goto L5
        L8a:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L55
            goto L87
        L8f:
            r4.close()     // Catch: java.io.IOException -> L55
            goto L87
        L93:
            r1 = move-exception
            r3.addSuppressed(r1)     // Catch: java.io.IOException -> L55
            goto L54
        L98:
            r4.close()     // Catch: java.io.IOException -> L55
            goto L54
        L9c:
            r1 = move-exception
            r2 = r0
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
