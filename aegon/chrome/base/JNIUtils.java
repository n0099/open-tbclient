package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
/* loaded from: classes.dex */
public class JNIUtils {
    public static ClassLoader sJniClassLoader;
    public static Boolean sSelectiveJniRegistrationEnabled;

    static {
        JNIUtils.class.desiredAssertionStatus();
    }

    @CalledByNative
    public static Object getClassLoader() {
        ClassLoader classLoader = sJniClassLoader;
        return classLoader == null ? JNIUtils.class.getClassLoader() : classLoader;
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (sSelectiveJniRegistrationEnabled == null) {
            sSelectiveJniRegistrationEnabled = Boolean.FALSE;
        }
        return sSelectiveJniRegistrationEnabled.booleanValue();
    }
}
