package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import dalvik.system.BaseDexClassLoader;
/* loaded from: classes.dex */
public class BundleUtils {
    public static final boolean sIsBundle;

    static {
        boolean z;
        try {
            Class.forName("aegon.chrome.base.BundleCanary");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        sIsBundle = z;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @CalledByNative
    public static String getNativeLibraryPath(String str) {
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            String findLibrary = ((BaseDexClassLoader) ContextUtils.sApplicationContext.getClassLoader()).findLibrary(str);
            allowDiskReads.close();
            return findLibrary;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    allowDiskReads.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @CalledByNative
    public static boolean isBundle() {
        return sIsBundle;
    }
}
