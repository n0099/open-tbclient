package aegon.chrome.net;

import aegon.chrome.net.UrlRequest;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class CronetEngine {
    public abstract UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor);
}
