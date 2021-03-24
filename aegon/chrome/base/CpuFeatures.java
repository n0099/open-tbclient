package aegon.chrome.base;
/* loaded from: classes.dex */
public abstract class CpuFeatures {
    public static native int nativeGetCoreCount();

    public static native long nativeGetCpuFeatures();
}
