package aegon.chrome.net.impl;

import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
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

    public void onRttObservation(int i, long j, int i2) {
        this.mWrappedListener.onRttObservation(i, j, i2);
    }
}
