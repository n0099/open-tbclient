package aegon.chrome.net.impl;

import aegon.chrome.net.ExperimentalCronetEngine;
import aegon.chrome.net.ExperimentalUrlRequest;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlRequest;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class CronetEngineBase extends ExperimentalCronetEngine {
    public abstract UrlRequestBase createRequest(String str, UrlRequest.Callback callback, Executor executor, int i2, Collection<Object> collection, boolean z, boolean z2, boolean z3, boolean z4, int i3, boolean z5, int i4, @Nullable RequestFinishedInfo.Listener listener);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // aegon.chrome.net.CronetEngine
    public ExperimentalUrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor) {
        return new UrlRequestBuilderImpl(str, callback, executor, this);
    }
}
