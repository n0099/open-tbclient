package androidx.webkit;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public abstract class ServiceWorkerClientCompat {
    public abstract WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest);
}
