package aegon.chrome.net;

import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public abstract class UrlRequest {

    /* loaded from: classes3.dex */
    public static abstract class Builder {
    }

    /* loaded from: classes3.dex */
    public static abstract class Callback {
        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }

        public abstract void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException);

        public abstract void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer);

        public abstract void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str);

        public abstract void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public abstract void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);
    }

    /* loaded from: classes3.dex */
    public static abstract class StatusListener {
        public abstract void onStatus(int i);
    }

    public abstract void followRedirect();

    public abstract void read(ByteBuffer byteBuffer);

    public abstract void start();
}
