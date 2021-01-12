package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
/* loaded from: classes4.dex */
public class BundleUtils {
    public static final boolean sIsBundle;

    static {
        boolean z;
        try {
            Class.forName("aegon.chrome.base.BundleCanary");
            z = true;
        } catch (ClassNotFoundException e) {
            z = false;
        }
        sIsBundle = z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @aegon.chrome.base.annotations.CalledByNative
    public static java.lang.String getNativeLibraryPath(java.lang.String r4) {
        /*
            aegon.chrome.base.StrictModeContext r3 = aegon.chrome.base.StrictModeContext.allowDiskReads()
            r2 = 0
            android.content.Context r0 = aegon.chrome.base.ContextUtils.sApplicationContext     // Catch: java.lang.Throwable -> L20
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch: java.lang.Throwable -> L20
            dalvik.system.BaseDexClassLoader r0 = (dalvik.system.BaseDexClassLoader) r0     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = r0.findLibrary(r4)     // Catch: java.lang.Throwable -> L20
            r3.close()
            return r0
        L15:
            r0 = move-exception
            r1 = r0
        L17:
            if (r2 == 0) goto L2a
            r3.close()     // Catch: java.lang.Throwable -> L25
        L1c:
            throw r1
        L1d:
            r0 = move-exception
            r1 = r0
            goto L17
        L20:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L22
        L22:
            r1 = move-exception
            r2 = r0
            goto L17
        L25:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L1c
        L2a:
            r3.close()
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: aegon.chrome.base.BundleUtils.getNativeLibraryPath(java.lang.String):java.lang.String");
    }

    @CalledByNative
    public static boolean isBundle() {
        return sIsBundle;
    }
}
