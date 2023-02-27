package androidx.webkit;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
/* loaded from: classes.dex */
public abstract class ServiceWorkerClientCompat {
    @Nullable
    @WorkerThread
    public abstract WebResourceResponse shouldInterceptRequest(@NonNull WebResourceRequest webResourceRequest);
}
