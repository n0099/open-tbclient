package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.webkit.internal.ProxyControllerImpl;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class ProxyController {

    /* loaded from: classes.dex */
    public static class LAZY_HOLDER {
        public static final ProxyController INSTANCE = new ProxyControllerImpl();
    }

    public abstract void clearProxyOverride(@NonNull Executor executor, @NonNull Runnable runnable);

    public abstract void setProxyOverride(@NonNull ProxyConfig proxyConfig, @NonNull Executor executor, @NonNull Runnable runnable);

    @NonNull
    public static ProxyController getInstance() {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
            return LAZY_HOLDER.INSTANCE;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }
}
