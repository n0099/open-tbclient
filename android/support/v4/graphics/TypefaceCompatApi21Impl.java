package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes23.dex */
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=4, 78=5] */
    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public android.graphics.Typeface createFromFontInfo(android.content.Context r8, android.os.CancellationSignal r9, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r10, int r11) {
        /*
            r7 = this;
            r0 = 0
            int r1 = r10.length
            r2 = 1
            if (r1 >= r2) goto L6
        L5:
            return r0
        L6:
            android.support.v4.provider.FontsContractCompat$FontInfo r1 = r7.findBestInfo(r10, r11)
            android.content.ContentResolver r2 = r8.getContentResolver()
            android.net.Uri r1 = r1.getUri()     // Catch: java.io.IOException -> L57
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r3 = r2.openFileDescriptor(r1, r3, r9)     // Catch: java.io.IOException -> L57
            r2 = 0
            java.io.File r1 = r7.getFile(r3)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L26
            boolean r4 = r1.canRead()     // Catch: java.lang.Throwable -> L49
            if (r4 != 0) goto L7d
        L26:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49
            java.io.FileDescriptor r1 = r3.getFileDescriptor()     // Catch: java.lang.Throwable -> L49
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L49
            r5 = 0
            android.graphics.Typeface r1 = super.createFromInputStream(r8, r4)     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L3b
            if (r0 == 0) goto L59
            r4.close()     // Catch: java.lang.Throwable -> L44
        L3b:
            if (r3 == 0) goto L42
            if (r0 == 0) goto L65
            r3.close()     // Catch: java.lang.Throwable -> L60
        L42:
            r0 = r1
            goto L5
        L44:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch: java.lang.Throwable -> L49
            goto L3b
        L49:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L4b
        L4b:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L4f:
            if (r3 == 0) goto L56
            if (r2 == 0) goto L99
            r3.close()     // Catch: java.lang.Throwable -> L94
        L56:
            throw r1     // Catch: java.io.IOException -> L57
        L57:
            r1 = move-exception
            goto L5
        L59:
            r4.close()     // Catch: java.lang.Throwable -> L49
            goto L3b
        L5d:
            r1 = move-exception
            r2 = r0
            goto L4f
        L60:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L57
            goto L42
        L65:
            r3.close()     // Catch: java.io.IOException -> L57
            goto L42
        L69:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L6b
        L6b:
            r1 = move-exception
        L6c:
            if (r4 == 0) goto L73
            if (r2 == 0) goto L79
            r4.close()     // Catch: java.lang.Throwable -> L74
        L73:
            throw r1     // Catch: java.lang.Throwable -> L49
        L74:
            r4 = move-exception
            r2.addSuppressed(r4)     // Catch: java.lang.Throwable -> L49
            goto L73
        L79:
            r4.close()     // Catch: java.lang.Throwable -> L49
            goto L73
        L7d:
            android.graphics.Typeface r1 = android.graphics.Typeface.createFromFile(r1)     // Catch: java.lang.Throwable -> L49
            if (r3 == 0) goto L88
            if (r0 == 0) goto L90
            r3.close()     // Catch: java.lang.Throwable -> L8b
        L88:
            r0 = r1
            goto L5
        L8b:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L57
            goto L88
        L90:
            r3.close()     // Catch: java.io.IOException -> L57
            goto L88
        L94:
            r3 = move-exception
            r2.addSuppressed(r3)     // Catch: java.io.IOException -> L57
            goto L56
        L99:
            r3.close()     // Catch: java.io.IOException -> L57
            goto L56
        L9d:
            r1 = move-exception
            r2 = r0
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi21Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }
}
