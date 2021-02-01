package aegon.chrome.net.impl;

import aegon.chrome.net.UrlRequest;
/* loaded from: classes3.dex */
public final class VersionSafeCallbacks$UrlRequestStatusListener extends UrlRequest.StatusListener {
    public final UrlRequest.StatusListener mWrappedListener;

    @Override // aegon.chrome.net.UrlRequest.StatusListener
    public void onStatus(int i) {
        this.mWrappedListener.onStatus(i);
    }
}
