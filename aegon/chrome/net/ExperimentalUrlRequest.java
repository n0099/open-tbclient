package aegon.chrome.net;

import aegon.chrome.net.UrlRequest;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public abstract class ExperimentalUrlRequest extends UrlRequest {

    /* loaded from: classes4.dex */
    public static abstract class Builder extends UrlRequest.Builder {
        public abstract Builder addHeader(String str, String str2);

        public abstract Builder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor);
    }
}
