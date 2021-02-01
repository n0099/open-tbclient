package androidx.webkit.internal;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.RequiresApi;
import androidx.webkit.ServiceWorkerClientCompat;
@RequiresApi(24)
/* loaded from: classes15.dex */
public class FrameworkServiceWorkerClient extends ServiceWorkerClient {
    private final ServiceWorkerClientCompat mImpl;

    public FrameworkServiceWorkerClient(ServiceWorkerClientCompat serviceWorkerClientCompat) {
        this.mImpl = serviceWorkerClientCompat;
    }

    @Override // android.webkit.ServiceWorkerClient
    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        return this.mImpl.shouldInterceptRequest(webResourceRequest);
    }
}
