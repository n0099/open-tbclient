package aegon.chrome.base;

import android.os.StrictMode;
import java.io.Closeable;
/* loaded from: classes5.dex */
public final class StrictModeContext implements Closeable {
    public final StrictMode.ThreadPolicy mThreadPolicy;
    public final StrictMode.VmPolicy mVmPolicy;

    public StrictModeContext(StrictMode.ThreadPolicy threadPolicy) {
        this.mThreadPolicy = threadPolicy;
        this.mVmPolicy = null;
    }

    public StrictModeContext(StrictMode.ThreadPolicy threadPolicy, StrictMode.VmPolicy vmPolicy) {
        this.mThreadPolicy = threadPolicy;
        this.mVmPolicy = vmPolicy;
    }

    public static StrictModeContext allowAllVmPolicies() {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new StrictModeContext(null, vmPolicy);
    }

    public static StrictModeContext allowDiskReads() {
        return new StrictModeContext(StrictMode.allowThreadDiskReads());
    }

    public static StrictModeContext allowDiskWrites() {
        return new StrictModeContext(StrictMode.allowThreadDiskWrites());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy threadPolicy = this.mThreadPolicy;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        StrictMode.VmPolicy vmPolicy = this.mVmPolicy;
        if (vmPolicy != null) {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }
}
