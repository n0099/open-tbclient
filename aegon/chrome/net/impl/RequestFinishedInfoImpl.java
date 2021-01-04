package aegon.chrome.net.impl;

import aegon.chrome.net.CronetException;
import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlResponseInfo;
import androidx.annotation.Nullable;
import java.util.Collection;
/* loaded from: classes5.dex */
public class RequestFinishedInfoImpl extends RequestFinishedInfo {
    @Nullable
    public final CronetException mException;
    public final RequestFinishedInfo.Metrics mMetrics;

    public RequestFinishedInfoImpl(String str, Collection<Object> collection, RequestFinishedInfo.Metrics metrics, int i, @Nullable UrlResponseInfo urlResponseInfo, @Nullable CronetException cronetException) {
        this.mMetrics = metrics;
        this.mException = cronetException;
    }
}
