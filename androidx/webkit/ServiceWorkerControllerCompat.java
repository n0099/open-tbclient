package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.internal.ServiceWorkerControllerImpl;
/* loaded from: classes.dex */
public abstract class ServiceWorkerControllerCompat {

    /* loaded from: classes.dex */
    public static class LAZY_HOLDER {
        public static final ServiceWorkerControllerCompat INSTANCE = new ServiceWorkerControllerImpl();
    }

    @NonNull
    public static ServiceWorkerControllerCompat getInstance() {
        return LAZY_HOLDER.INSTANCE;
    }

    @NonNull
    public abstract ServiceWorkerWebSettingsCompat getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(@Nullable ServiceWorkerClientCompat serviceWorkerClientCompat);
}
