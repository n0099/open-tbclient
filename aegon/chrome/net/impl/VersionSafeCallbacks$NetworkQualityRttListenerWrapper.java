package aegon.chrome.net.impl;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$NetworkQualityRttListenerWrapper {
    public final VersionSafeCallbacks$NetworkQualityRttListenerWrapper mWrappedListener;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof VersionSafeCallbacks$NetworkQualityRttListenerWrapper)) {
            return false;
        }
        return this.mWrappedListener.equals(((VersionSafeCallbacks$NetworkQualityRttListenerWrapper) obj).mWrappedListener);
    }

    public Executor getExecutor() {
        return this.mWrappedListener.getExecutor();
    }

    public int hashCode() {
        return this.mWrappedListener.hashCode();
    }

    public void onRttObservation(int i2, long j, int i3) {
        this.mWrappedListener.onRttObservation(i2, j, i3);
    }
}
