package aegon.chrome.net;

import aegon.chrome.net.UrlRequest;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public abstract class CronetEngine {
    static {
        CronetEngine.class.getSimpleName();
    }

    public abstract UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor);
}
