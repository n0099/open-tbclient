package aegon.chrome.net.impl;

import aegon.chrome.net.RequestFinishedInfo;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public final class VersionSafeCallbacks$RequestFinishedInfoListener extends RequestFinishedInfo.Listener {
    public final RequestFinishedInfo.Listener mWrappedListener;

    public VersionSafeCallbacks$RequestFinishedInfoListener(RequestFinishedInfo.Listener listener) {
        super(listener.getExecutor());
        this.mWrappedListener = listener;
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Listener
    public Executor getExecutor() {
        return this.mWrappedListener.getExecutor();
    }

    @Override // aegon.chrome.net.RequestFinishedInfo.Listener
    public void onRequestFinished(RequestFinishedInfo requestFinishedInfo) {
        this.mWrappedListener.onRequestFinished(requestFinishedInfo);
    }
}
