package aegon.chrome.net.impl;

import aegon.chrome.net.ExperimentalUrlRequest;
import aegon.chrome.net.UploadDataProvider;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
public abstract class UrlRequestBase extends ExperimentalUrlRequest {
    public static final /* synthetic */ boolean $assertionsDisabled = !UrlRequestBase.class.desiredAssertionStatus();

    public abstract void addHeader(String str, String str2);

    public abstract void setHttpMethod(String str);

    public abstract void setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor);
}
