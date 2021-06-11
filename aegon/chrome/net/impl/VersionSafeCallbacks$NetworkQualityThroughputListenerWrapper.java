package aegon.chrome.net.impl;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper {
    public final VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper mWrappedListener;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper)) {
            return false;
        }
        return this.mWrappedListener.equals(((VersionSafeCallbacks$NetworkQualityThroughputListenerWrapper) obj).mWrappedListener);
    }

    public Executor getExecutor() {
        return this.mWrappedListener.getExecutor();
    }

    public int hashCode() {
        return this.mWrappedListener.hashCode();
    }

    public void onThroughputObservation(int i2, long j, int i3) {
        this.mWrappedListener.onThroughputObservation(i2, j, i3);
    }
}
