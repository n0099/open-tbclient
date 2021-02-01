package aegon.chrome.net.impl;

import aegon.chrome.net.CronetException;
import aegon.chrome.net.UrlRequest;
import aegon.chrome.net.UrlResponseInfo;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public final class VersionSafeCallbacks$UrlRequestCallback extends UrlRequest.Callback {
    public final UrlRequest.Callback mWrappedCallback;

    public VersionSafeCallbacks$UrlRequestCallback(UrlRequest.Callback callback) {
        this.mWrappedCallback = callback;
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.mWrappedCallback.onCanceled(urlRequest, urlResponseInfo);
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        this.mWrappedCallback.onFailed(urlRequest, urlResponseInfo, cronetException);
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        this.mWrappedCallback.onReadCompleted(urlRequest, urlResponseInfo, byteBuffer);
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        this.mWrappedCallback.onRedirectReceived(urlRequest, urlResponseInfo, str);
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.mWrappedCallback.onResponseStarted(urlRequest, urlResponseInfo);
    }

    @Override // aegon.chrome.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.mWrappedCallback.onSucceeded(urlRequest, urlResponseInfo);
    }
}
