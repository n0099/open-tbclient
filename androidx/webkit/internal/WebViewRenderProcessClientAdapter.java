package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;
/* loaded from: classes.dex */
public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {
    public static final String[] sSupportedFeatures = {"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};
    public final Executor mExecutor;
    public final WebViewRenderProcessClient mWebViewRenderProcessClient;

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }

    public WebViewRenderProcessClientAdapter(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mExecutor = executor;
        this.mWebViewRenderProcessClient = webViewRenderProcessClient;
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void onRendererResponsive(@NonNull final WebView webView, @NonNull InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl forInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessResponsive(webView, forInvocationHandler);
        } else {
            executor.execute(new Runnable() { // from class: androidx.webkit.internal.WebViewRenderProcessClientAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    webViewRenderProcessClient.onRenderProcessResponsive(webView, forInvocationHandler);
                }
            });
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final void onRendererUnresponsive(@NonNull final WebView webView, @NonNull InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl forInvocationHandler = WebViewRenderProcessImpl.forInvocationHandler(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.mWebViewRenderProcessClient;
        Executor executor = this.mExecutor;
        if (executor == null) {
            webViewRenderProcessClient.onRenderProcessUnresponsive(webView, forInvocationHandler);
        } else {
            executor.execute(new Runnable() { // from class: androidx.webkit.internal.WebViewRenderProcessClientAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    webViewRenderProcessClient.onRenderProcessUnresponsive(webView, forInvocationHandler);
                }
            });
        }
    }
}
