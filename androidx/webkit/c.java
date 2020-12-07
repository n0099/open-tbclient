package androidx.webkit;

import android.os.Build;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;
import org.chromium.support_lib_boundary.util.Features;
/* loaded from: classes19.dex */
public class c extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {Features.VISUAL_STATE_CALLBACK, Features.RECEIVE_WEB_RESOURCE_ERROR, Features.RECEIVE_HTTP_ERROR, Features.SHOULD_OVERRIDE_WITH_REDIRECTS, Features.SAFE_BROWSING_HIT};

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    @RestrictTo
    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onPageCommitVisible(WebView webView, String str) {
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    @RestrictTo
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, InvocationHandler invocationHandler) {
        onReceivedError(webView, webResourceRequest, new androidx.webkit.internal.c(invocationHandler));
    }

    @Override // android.webkit.WebViewClient
    @RestrictTo
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT >= 23) {
            onReceivedError(webView, webResourceRequest, new androidx.webkit.internal.c(webResourceError));
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, b bVar) {
        if (Build.VERSION.SDK_INT >= 21 && d.bb(Features.WEB_RESOURCE_ERROR_GET_CODE) && d.bb(Features.WEB_RESOURCE_ERROR_GET_DESCRIPTION) && webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, bVar.getErrorCode(), bVar.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    @Override // org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    @RestrictTo
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, InvocationHandler invocationHandler) {
        onSafeBrowsingHit(webView, webResourceRequest, i, new androidx.webkit.internal.b(invocationHandler));
    }

    @Override // android.webkit.WebViewClient
    @RestrictTo
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        onSafeBrowsingHit(webView, webResourceRequest, i, new androidx.webkit.internal.b(safeBrowsingResponse));
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, a aVar) {
        if (d.bb(Features.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL)) {
            aVar.showInterstitial(true);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
